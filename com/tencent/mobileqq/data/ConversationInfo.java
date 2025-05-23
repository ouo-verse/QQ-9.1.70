package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.imcore.message.s;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.FAIL, columnNames = "uin,type")
/* loaded from: classes10.dex */
public class ConversationInfo extends Entity {
    public static final String SUB_ACCOUNT_TROOP_UNREAD_ERROR = " SUB_ACCOUNT_TROOP_UNREAD ERROR ";
    public static final String UNREAD_ERROR = " UNREAD ERROR ";
    public static final String UNREAD_GIFT_COUNT_ERROR = " UNREAD_GIFT_COUNT ERROR ";
    public static final String UNREAD_MARK_ERROR = " UNREAD_MARK ERROR ";
    public static final String UNREAD_RED_PACK_ERROR = " UNREAD_RED_PACK ERROR ";
    public static Callback sCallback = null;
    private static final String tableName = "conversation_info";
    public byte[] extData;
    public int extInt1;
    public int extInt2;
    public int extInt3;
    public String extString;
    public boolean isImax = false;
    public long lastread;

    @notColumn
    public TinyInfo tinyInfo;
    public int type;
    public String uin;
    public int unreadCount;
    public int unreadGiftCount;
    public int unreadMark;
    public int unreadTroopGuildCount;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface Callback {
        void onTypeChanged(int i3, ConversationInfo conversationInfo);

        void onUnreadChanged(int i3, ConversationInfo conversationInfo, String str);

        boolean reportPublicAccountTypeError(String str, int i3);
    }

    static {
        s.a();
        sCallback = new a();
    }

    public ConversationInfo() {
    }

    public static String getConversationInfoTableName() {
        return "conversation_info";
    }

    public static void setCallback(Callback callback) {
        sCallback = callback;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return getConversationInfoTableName();
    }

    public int getUnreadTroopGuildCount() {
        return this.unreadTroopGuildCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        super.postRead();
        if (!TextUtils.isEmpty(this.extString)) {
            this.tinyInfo = new TinyInfo(this.extString);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        super.prewrite();
        TinyInfo tinyInfo = this.tinyInfo;
        if (tinyInfo != null) {
            this.extString = tinyInfo.toJsonStr();
        }
    }

    public void setExtInt1(int i3) {
        this.extInt1 = i3;
        sCallback.onUnreadChanged(i3, this, UNREAD_RED_PACK_ERROR);
    }

    public void setExtInt2(int i3) {
        this.extInt2 = i3;
        sCallback.onUnreadChanged(i3, this, SUB_ACCOUNT_TROOP_UNREAD_ERROR);
    }

    public void setType(int i3) {
        this.type = i3;
        sCallback.onTypeChanged(i3, this);
    }

    public void setUnread(int i3) {
        this.unreadCount = i3;
        sCallback.onUnreadChanged(i3, this, UNREAD_ERROR);
    }

    public void setUnreadGiftCount(int i3) {
        this.unreadGiftCount = i3;
        sCallback.onUnreadChanged(i3, this, UNREAD_GIFT_COUNT_ERROR);
    }

    public void setUnreadMark(int i3) {
        this.unreadMark = i3;
        sCallback.onUnreadChanged(i3, this, UNREAD_MARK_ERROR);
    }

    public void setUnreadTroopGuildCount(int i3) {
        this.unreadTroopGuildCount = i3;
    }

    public String toString() {
        String str;
        if (QLog.isColorLevel()) {
            str = this.uin;
        } else if (!TextUtils.isEmpty(this.uin) && this.uin.length() >= 4) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("*");
            String str2 = this.uin;
            sb5.append(str2.substring(str2.length() - 4, this.uin.length()));
            str = sb5.toString();
        } else {
            str = this.uin;
        }
        return "--ConversationInfo--,shortUin:" + str + ",type:" + this.type + ",lastread:" + this.lastread + ",unreadCount:" + this.unreadCount + ",unreadGiftCount:" + this.unreadGiftCount + ",unreadRedPacketCount:" + this.extInt1 + ",subAccountTroopunReadMsg:" + this.extInt2 + ",PublicAccountConversationRedMask:" + this.extInt3 + ",unreadMark:" + this.unreadMark + ", extStr:" + this.extString;
    }

    public ConversationInfo(String str, int i3) {
        this.uin = str;
        setType(i3);
        sCallback.reportPublicAccountTypeError(str, i3);
    }

    public ConversationInfo(String str, int i3, long j3, int i16) {
        this.uin = str;
        setType(i3);
        this.lastread = j3;
        setUnread(i16);
        sCallback.reportPublicAccountTypeError(str, i3);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Callback {
        a() {
        }

        @Override // com.tencent.mobileqq.data.ConversationInfo.Callback
        public boolean reportPublicAccountTypeError(String str, int i3) {
            return false;
        }

        @Override // com.tencent.mobileqq.data.ConversationInfo.Callback
        public void onTypeChanged(int i3, ConversationInfo conversationInfo) {
        }

        @Override // com.tencent.mobileqq.data.ConversationInfo.Callback
        public void onUnreadChanged(int i3, ConversationInfo conversationInfo, String str) {
        }
    }
}
