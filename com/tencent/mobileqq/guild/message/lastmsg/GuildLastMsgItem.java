package com.tencent.mobileqq.guild.message.lastmsg;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.guild.message.lastmsg.a;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "channelId")
/* loaded from: classes14.dex */
public class GuildLastMsgItem extends Entity implements Cloneable {
    private static final String TAG = "GuildLastMsgItem";
    public String channelId;

    @notColumn
    public String draftText;

    @notColumn
    public long draftTime;

    @notColumn
    public Message message;
    public int highlightBiztype = a.InterfaceC7854a.f230606a;
    public long highlightSeq = -1;

    @notColumn
    public long aboutMeMsgCnt = 0;

    @notColumn
    public long calendarMsgCnt = 0;

    @notColumn
    public long msgCnt = 0;

    @notColumn
    public int msgShowType = 0;

    private String getGuildIdDefault() {
        IGProChannelInfo channelInfo;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null || (channelInfo = ((IGPSService) waitAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(this.channelId)) == null) {
            return "";
        }
        return channelInfo.getGuildId();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuildLastMsgItem)) {
            return false;
        }
        GuildLastMsgItem guildLastMsgItem = (GuildLastMsgItem) obj;
        if (this.highlightBiztype != guildLastMsgItem.highlightBiztype || this.highlightSeq != guildLastMsgItem.highlightSeq || this.draftTime != guildLastMsgItem.draftTime || this.aboutMeMsgCnt != guildLastMsgItem.aboutMeMsgCnt || this.calendarMsgCnt != guildLastMsgItem.calendarMsgCnt || this.msgCnt != guildLastMsgItem.msgCnt || this.msgShowType != guildLastMsgItem.msgShowType) {
            return false;
        }
        String str = this.channelId;
        if (str == null ? guildLastMsgItem.channelId != null : !str.equals(guildLastMsgItem.channelId)) {
            return false;
        }
        Message message = this.message;
        if (message == null ? guildLastMsgItem.message != null : !message.equals(guildLastMsgItem.message)) {
            return false;
        }
        String str2 = this.draftText;
        String str3 = guildLastMsgItem.draftText;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public String getGuildId() {
        Message message = this.message;
        if (message == null) {
            return getGuildIdDefault();
        }
        String b16 = su1.c.b(message);
        if (TextUtils.isEmpty(b16)) {
            return getGuildIdDefault();
        }
        return b16;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.channelId;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = ((i3 * 31) + this.highlightBiztype) * 31;
        long j3 = this.highlightSeq;
        int i19 = (i18 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        Message message = this.message;
        if (message != null) {
            i16 = message.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str2 = this.draftText;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        int i27 = (i26 + i17) * 31;
        long j16 = this.draftTime;
        int i28 = (i27 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.aboutMeMsgCnt;
        int i29 = (i28 + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        long j18 = this.calendarMsgCnt;
        int i36 = (i29 + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        long j19 = this.msgCnt;
        return ((i36 + ((int) (j19 ^ (j19 >>> 32)))) * 31) + this.msgShowType;
    }

    public boolean isDirectMessage() {
        Message message = this.message;
        if (message == null) {
            if (!QLog.isDebugVersion()) {
                return false;
            }
            throw new NullPointerException("\u5b58\u53d6item\u65f6\u5019, message\u4e00\u5b9a\u4e0d\u4e3a\u7a7a, \u5982\u679c\u4e3a\u7a7a\u4e86, \u8054\u7cfbvashzhong!");
        }
        return su1.c.c(message);
    }

    public boolean isInMsgTab() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && this.channelId != null) {
            return ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).isQQMsgListChannel(getGuildId(), this.channelId);
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("channelId:");
        sb5.append(this.channelId);
        sb5.append(" ");
        sb5.append("highlightBiztype:");
        sb5.append(this.highlightBiztype);
        sb5.append(" ");
        sb5.append("highlightSeq:");
        sb5.append(this.highlightSeq);
        sb5.append(" ");
        sb5.append("message:");
        Message message = this.message;
        String str2 = "";
        if (message == null) {
            str = "";
        } else {
            str = message.toString();
        }
        sb5.append(str);
        sb5.append(" ");
        sb5.append("draftText:");
        String str3 = this.draftText;
        if (str3 != null) {
            str2 = str3;
        }
        sb5.append(str2);
        sb5.append(" ");
        sb5.append("draftTime:");
        sb5.append(this.draftTime);
        sb5.append(" ");
        sb5.append("aboutMeMsgCnt:");
        sb5.append(this.aboutMeMsgCnt);
        sb5.append(" ");
        sb5.append("calendarMsgCnt:");
        sb5.append(this.calendarMsgCnt);
        sb5.append(" ");
        sb5.append("msgCnt:");
        sb5.append(this.msgCnt);
        sb5.append(" ");
        sb5.append("msgShowType:");
        sb5.append(this.msgShowType);
        sb5.append(" ");
        sb5.append("isDirectMessage:");
        sb5.append(isDirectMessage());
        sb5.append(" ");
        return sb5.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GuildLastMsgItem m192clone() {
        try {
            return (GuildLastMsgItem) super.clone();
        } catch (CloneNotSupportedException unused) {
            return this;
        }
    }
}
