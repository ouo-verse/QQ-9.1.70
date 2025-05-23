package com.tencent.mobileqq.guild.message.msgtype;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes14.dex */
public class MessageForGuildRevokeGrayTip extends ChatMessage {
    private static String TAG = "MessageForGuildRevokeGrayTip";
    private GuildRevokeGrayTipInfo info = new GuildRevokeGrayTipInfo();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class GuildRevokeGrayTipInfo implements Serializable {
        String wording = "";
        boolean canReEdit = false;
        String reEditText = "";
        String atInfoData = "";
        String operatorTid = "";
        boolean needUpdateNick = false;
        String revokedSenderUin = "";

        GuildRevokeGrayTipInfo() {
        }
    }

    public MessageForGuildRevokeGrayTip() {
        this.msgtype = MessageRecord.MSG_TYPE_GUILD_REVOKE_GRAY_TIP;
    }

    private byte[] getBytesFromObject(Serializable serializable) throws Exception {
        if (serializable == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream).writeObject(serializable);
        return byteArrayOutputStream.toByteArray();
    }

    private Object getObjectFromBytes(byte[] bArr) throws Exception {
        if (bArr != null && bArr.length != 0) {
            return new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
        }
        return null;
    }

    public boolean canReEdit() {
        return this.info.canReEdit;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        GuildRevokeGrayTipInfo guildRevokeGrayTipInfo;
        try {
            guildRevokeGrayTipInfo = (GuildRevokeGrayTipInfo) getObjectFromBytes(this.msgData);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "doParse. exception: " + e16.toString() + ", shmsgseq: " + this.shmsgseq + ", channelId: " + this.frienduin + ", setting msg to invalid!");
            this.isValid = false;
            guildRevokeGrayTipInfo = null;
        }
        if (guildRevokeGrayTipInfo != null) {
            this.info = guildRevokeGrayTipInfo;
        }
    }

    public String getAtInfoData() {
        return this.info.atInfoData;
    }

    public String getGuildId() {
        return String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(this));
    }

    public boolean getNeedUpdateNick() {
        return this.info.needUpdateNick;
    }

    public String getOperatorTid() {
        return this.info.operatorTid;
    }

    public String getReEditText() {
        return this.info.reEditText;
    }

    public String getRevokeSenderUin() {
        return this.info.revokedSenderUin;
    }

    public String getWording() {
        if (TextUtils.isEmpty(this.info.wording)) {
            QLog.e(TAG, 1, "getWording is empty, showing default wording.");
            return HardCodeUtil.qqStr(R.string.f153181be);
        }
        return this.info.wording;
    }

    public void init(MessageRecord messageRecord, String str, boolean z16, String str2, String str3, String str4, boolean z17) {
        this.frienduin = messageRecord.frienduin;
        this.shmsgseq = messageRecord.shmsgseq;
        this.msgUid = messageRecord.msgUid;
        saveExtInfoToExtStr(IGuildMessageUtilsApi.GUILD_ID_EXT_STR, String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(messageRecord)));
        saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_LOCAL_ONLY, "1");
        saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_GUILD_MEMBER_NAME, ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getMsgGuildMemberNameFromMR(messageRecord));
        saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_FROM_NICK, ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getNickNameFromMR(messageRecord));
        this.istroop = 10014;
        this.mIsParsed = true;
        this.isread = true;
        this.mNeedTimeStamp = false;
        this.senderuin = str4;
        GuildRevokeGrayTipInfo guildRevokeGrayTipInfo = this.info;
        guildRevokeGrayTipInfo.wording = str;
        guildRevokeGrayTipInfo.canReEdit = z16;
        guildRevokeGrayTipInfo.reEditText = str2;
        guildRevokeGrayTipInfo.atInfoData = str3;
        guildRevokeGrayTipInfo.operatorTid = str4;
        guildRevokeGrayTipInfo.needUpdateNick = z17;
        guildRevokeGrayTipInfo.revokedSenderUin = messageRecord.senderuin;
        try {
            this.msgData = getBytesFromObject(guildRevokeGrayTipInfo);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "serial. exception: " + e16.toString() + ", shmsgseq: " + this.shmsgseq + ", channelId: " + this.frienduin);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        serial();
    }

    public void serial() {
        try {
            this.msgData = getBytesFromObject(this.info);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "serial. exception: " + e16.toString());
        }
        if (this.msgData == null) {
            QLog.e(TAG, 1, "Failed to serial. shmsgseq: " + this.shmsgseq + ", channelId: " + this.frienduin);
        }
    }

    public void setCanReEdit(boolean z16) {
        GuildRevokeGrayTipInfo guildRevokeGrayTipInfo = this.info;
        guildRevokeGrayTipInfo.canReEdit = z16;
        try {
            this.msgData = getBytesFromObject(guildRevokeGrayTipInfo);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "serial. exception: " + e16.toString() + ", shmsgseq: " + this.shmsgseq + ", channelId: " + this.frienduin);
        }
    }
}
