package com.tencent.mobileqq.data;

import android.annotation.SuppressLint;
import android.database.Cursor;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.FAIL, columnNames = "uin,type")
/* loaded from: classes10.dex */
public final class RecentUser extends Entity {
    public static final long FLAG_HOTCHAT = 1;
    public static final long FLAG_PA_AD = 16;
    public static final String TABLE_NAME = "recent";
    private static final String TAG = "RecentUser";
    public String displayName;

    @notColumn
    public Object extraInfo;

    @defaultValue(defaultInteger = 0)
    public int isHiddenChat;

    @notColumn
    public int jumpTabMode;

    @defaultzero
    public long lFlag;

    @defaultzero
    public long lastmsgdrafttime;
    public long lastmsgtime;
    public boolean mIsParsed;

    /* renamed from: msg, reason: collision with root package name */
    @notColumn
    public Object f203116msg;
    public byte[] msgData;
    public int msgType;

    @defaultzero
    public long opTime;
    public byte[] parceledRecentBaseData;

    @notColumn
    public String senderUin;

    @defaultzero
    public long showUpTime;
    public String troopUin;
    public int type;
    public String uin;

    @notColumn
    public boolean updatedByRegisterProxy;

    @Deprecated
    public RecentUser() {
    }

    public void cleanMsgAndMsgData(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cleanMsgAndMsgData " + this.uin + " " + this.uin + " this.msgType " + this.msgType + " msgType " + i3);
        }
        if (this.msgType == i3) {
            this.f203116msg = null;
            this.msgData = null;
            this.msgType = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    @SuppressLint({"Range"})
    public boolean entityByCursor(Cursor cursor) {
        boolean z16;
        if (1 == cursor.getShort(cursor.getColumnIndex("mIsParsed"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsParsed = z16;
        this.uin = cursor.getString(cursor.getColumnIndex("uin"));
        this.troopUin = cursor.getString(cursor.getColumnIndex("troopUin"));
        this.displayName = cursor.getString(cursor.getColumnIndex(CommonConstant.KEY_DISPLAY_NAME));
        this.type = cursor.getInt(cursor.getColumnIndex("type"));
        this.lastmsgtime = cursor.getLong(cursor.getColumnIndex("lastmsgtime"));
        this.lastmsgdrafttime = cursor.getLong(cursor.getColumnIndex("lastmsgdrafttime"));
        this.msgType = cursor.getInt(cursor.getColumnIndex(QQBrowserActivity.KEY_MSG_TYPE));
        this.msgData = cursor.getBlob(cursor.getColumnIndex(AppConstants.Key.COLUMN_MSG_DATA));
        this.showUpTime = cursor.getLong(cursor.getColumnIndex("showUpTime"));
        this.lFlag = cursor.getLong(cursor.getColumnIndex("lFlag"));
        this.opTime = cursor.getLong(cursor.getColumnIndex("opTime"));
        this.isHiddenChat = cursor.getInt(cursor.getColumnIndex("isHiddenChat"));
        this.parceledRecentBaseData = cursor.getBlob(cursor.getColumnIndex("parceledRecentBaseData"));
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RecentUser)) {
            return false;
        }
        RecentUser recentUser = (RecentUser) obj;
        String str = this.uin;
        if (str == null) {
            if (recentUser.uin != null || getType() != recentUser.getType()) {
                return false;
            }
            return true;
        }
        if (!str.equals(recentUser.uin) || getType() != recentUser.getType()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return TABLE_NAME;
    }

    public int getType() {
        return this.type;
    }

    public void parse() {
        if (!this.mIsParsed) {
            synchronized (this) {
                if (!this.mIsParsed) {
                    doParse();
                    this.mIsParsed = true;
                }
            }
        }
    }

    public void reParse() {
        if (!this.mIsParsed) {
            return;
        }
        this.mIsParsed = false;
        parse();
    }

    public void setMsgAndType(Object obj, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setMsgAndType " + this.uin + " " + this.uin + " this.msgType " + this.msgType + " msgType " + i3);
        }
        if (i3 >= this.msgType) {
            this.f203116msg = obj;
            this.msgType = i3;
            reParse();
        }
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public String toString() {
        return "RecentUser{uin='" + this.uin + "', type=" + this.type + '}';
    }

    public RecentUser(String str, int i3) {
        this.uin = str;
        this.type = i3;
    }

    public void doParse() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
    }
}
