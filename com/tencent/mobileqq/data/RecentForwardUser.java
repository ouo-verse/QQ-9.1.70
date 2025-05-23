package com.tencent.mobileqq.data;

import android.database.Cursor;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.FAIL, columnNames = "uin,type")
/* loaded from: classes10.dex */
public final class RecentForwardUser extends Entity {
    public static final String TABLE_NAME = "recent_forward";
    private static final String TAG = "RecentForwardUser";
    public String displayName;

    @defaultValue(defaultInteger = 0)
    public int isHiddenChat;

    @defaultzero
    public long lastMsgDraftTime;
    public long lastMsgTime;

    @defaultzero
    public long opTime;

    @defaultzero
    public long showUpTime;
    public String troopUin;
    public int type;
    public String uin;

    @Deprecated
    public RecentForwardUser() {
    }

    public static RecentForwardUser createFrom(RecentUser recentUser) {
        RecentForwardUser recentForwardUser = new RecentForwardUser(recentUser.uin, recentUser.type);
        recentForwardUser.troopUin = recentUser.troopUin;
        recentForwardUser.displayName = recentUser.displayName;
        recentForwardUser.lastMsgTime = recentUser.lastmsgtime;
        recentForwardUser.lastMsgDraftTime = recentUser.lastmsgdrafttime;
        recentForwardUser.showUpTime = recentUser.showUpTime;
        recentForwardUser.opTime = recentUser.opTime;
        recentForwardUser.isHiddenChat = recentUser.isHiddenChat;
        return recentForwardUser;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public boolean entityByCursor(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("uin");
        int columnIndex2 = cursor.getColumnIndex("troopUin");
        int columnIndex3 = cursor.getColumnIndex(CommonConstant.KEY_DISPLAY_NAME);
        int columnIndex4 = cursor.getColumnIndex("type");
        int columnIndex5 = cursor.getColumnIndex("lastMsgTime");
        int columnIndex6 = cursor.getColumnIndex("lastMsgDraftTime");
        int columnIndex7 = cursor.getColumnIndex("showUpTime");
        int columnIndex8 = cursor.getColumnIndex("opTime");
        int columnIndex9 = cursor.getColumnIndex("isHiddenChat");
        if (columnIndex >= 0) {
            this.uin = cursor.getString(columnIndex);
        }
        if (columnIndex2 >= 0) {
            this.troopUin = cursor.getString(columnIndex2);
        }
        if (columnIndex3 >= 0) {
            this.displayName = cursor.getString(columnIndex3);
        }
        if (columnIndex4 >= 0) {
            this.type = cursor.getInt(columnIndex4);
        }
        if (columnIndex5 >= 0) {
            this.lastMsgTime = cursor.getLong(columnIndex5);
        }
        if (columnIndex6 >= 0) {
            this.lastMsgDraftTime = cursor.getLong(columnIndex6);
        }
        if (columnIndex7 >= 0) {
            this.showUpTime = cursor.getLong(columnIndex7);
        }
        if (columnIndex8 >= 0) {
            this.opTime = cursor.getLong(columnIndex8);
        }
        if (columnIndex9 >= 0) {
            this.isHiddenChat = cursor.getInt(columnIndex9);
            return true;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RecentForwardUser)) {
            return false;
        }
        RecentForwardUser recentForwardUser = (RecentForwardUser) obj;
        String str = this.uin;
        if (str == null) {
            if (recentForwardUser.uin != null || getType() != recentForwardUser.getType()) {
                return false;
            }
            return true;
        }
        if (!str.equals(recentForwardUser.uin) || getType() != recentForwardUser.getType()) {
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

    public void setType(int i3) {
        this.type = i3;
    }

    public RecentUser toRecentUser() {
        RecentUser recentUser = new RecentUser(this.uin, this.type);
        recentUser.troopUin = this.troopUin;
        recentUser.displayName = this.displayName;
        recentUser.lastmsgtime = this.lastMsgTime;
        recentUser.lastmsgdrafttime = this.lastMsgDraftTime;
        recentUser.showUpTime = this.showUpTime;
        recentUser.opTime = this.opTime;
        recentUser.isHiddenChat = this.isHiddenChat;
        return recentUser;
    }

    public String toString() {
        return "RecentUser{uin='" + this.uin + "', type=" + this.type + '}';
    }

    public RecentForwardUser(String str, int i3) {
        this.uin = str;
        this.type = i3;
    }
}
