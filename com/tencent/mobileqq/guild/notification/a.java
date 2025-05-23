package com.tencent.mobileqq.guild.notification;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.b;
import com.tencent.mobileqq.app.notification.struct.e;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.guild.message.notify.api.IGuildNotify;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import su1.c;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class a extends b {
    protected a(QQAppInterface qQAppInterface, e eVar) {
        super(qQAppInterface, eVar);
    }

    private void o(Message message) {
        String notificationPrefix = ((IGuildNotify) this.f196404a.getRuntimeService(IGuildNotify.class)).getNotificationPrefix(message);
        this.f196405b.l(notificationPrefix + "(" + d() + "):");
        this.f196405b.j(s(message, notificationPrefix));
    }

    private void p(Message message) {
        Object obj = message.extObj;
        if (obj instanceof MsgRecord) {
            MsgRecord msgRecord = (MsgRecord) obj;
            if (msgRecord.getDirectMsgFlag() == 1) {
                this.f196405b.k(j.g(this.f196404a.getApp().getResources(), R.drawable.icon));
                return;
            }
            IGProGuildInfo guildInfo = ((IGPSService) this.f196404a.getRuntimeService(IGPSService.class)).getGuildInfo(msgRecord.getGuildId());
            if (guildInfo != null) {
                Bitmap avatarBitmap = ((IGuildNotify) this.f196404a.getRuntimeService(IGuildNotify.class)).getAvatarBitmap(guildInfo.getAvatarUrl(100));
                if (avatarBitmap == null) {
                    avatarBitmap = BaseImageUtil.getDefaultFaceBitmap();
                }
                this.f196405b.k(avatarBitmap);
            }
        }
    }

    private e q(Message message) {
        String stringExtra = c().getStringExtra("uinname");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = c().getStringExtra("uin");
        }
        IGProChannelInfo channelInfo = ((IGPSService) this.f196404a.getRuntimeService(IGPSService.class)).getChannelInfo(message.frienduin);
        if (channelInfo != null) {
            if (!channelInfo.isHiddenPostChannel()) {
                stringExtra = stringExtra + APLogFileUtil.SEPARATOR_LOG + channelInfo.getChannelName();
            }
            this.f196405b.b().putExtra("channel_name", channelInfo.getChannelName());
        }
        this.f196405b.i(stringExtra);
        this.f196405b.l("(" + stringExtra + "):");
        this.f196405b.j(new QQText(message.f203106msg, 3).toPlainText(false));
        IGProGuildInfo guildInfo = ((IGPSService) this.f196404a.getRuntimeService(IGPSService.class)).getGuildInfo(c.b(message));
        if (guildInfo != null) {
            Bitmap avatarBitmap = ((IGuildNotify) this.f196404a.getRuntimeService(IGuildNotify.class)).getAvatarBitmap(guildInfo.getAvatarUrl(100));
            if (avatarBitmap == null) {
                avatarBitmap = BaseImageUtil.getDefaultFaceBitmap();
            }
            this.f196405b.k(avatarBitmap);
        }
        return this.f196405b;
    }

    private void r(Message message) {
        Object obj = message.extObj;
        if (obj instanceof MsgRecord) {
            MsgRecord msgRecord = (MsgRecord) obj;
            if (msgRecord.getDirectMsgFlag() == 1) {
                this.f196405b.i("\u9891\u9053\u79c1\u4fe1");
                return;
            }
            String stringExtra = c().getStringExtra("uinname");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = c().getStringExtra("uin");
            }
            IGProChannelInfo channelInfo = ((IGPSService) this.f196404a.getRuntimeService(IGPSService.class)).getChannelInfo(msgRecord.getChannelId());
            String str = "" + stringExtra;
            if (channelInfo != null) {
                str = str + APLogFileUtil.SEPARATOR_LOG + channelInfo.getChannelName();
            }
            this.f196405b.i(str);
        }
    }

    private String s(Message message, String str) {
        if (((IGuildNotify) this.f196404a.getRuntimeService(IGuildNotify.class)).isRevokeNotify(message)) {
            return this.f196404a.getApplicationContext().getString(R.string.f132623x);
        }
        Object obj = message.extObj;
        if ((obj instanceof MsgRecord) && MsgExtKt.W((MsgRecord) obj)) {
            return this.f196404a.getApplicationContext().getString(R.string.f132633y, message.nickName);
        }
        return MessageNotificationSettingManager.l(this.f196404a).p(f.o(str + t(message, new QQText(message.f203106msg, 3).toPlainText(false))), message);
    }

    private String t(Message message, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Object obj = message.extObj;
        if ((obj instanceof MsgRecord) && qr0.e.e((MsgRecord) obj, ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isUserOnLine())) {
            return str;
        }
        String[] strArr = {HardCodeUtil.qqStr(R.string.f15156181), HardCodeUtil.qqStr(R.string.f15155180)};
        for (int i3 = 0; i3 < 2; i3++) {
            String str2 = strArr[i3];
            if (str.startsWith(str2)) {
                return str.substring(str2.length());
            }
        }
        return str;
    }

    @Override // com.tencent.mobileqq.app.notification.struct.d
    public e a(Message message) {
        String str;
        if (message.extObj instanceof MsgRecord) {
            o(message);
            l(message);
            IGProChannelInfo channelInfo = ((IGPSService) this.f196404a.getRuntimeService(IGPSService.class)).getChannelInfo(message.frienduin);
            Intent b16 = this.f196405b.b();
            Object obj = "";
            if (channelInfo == null) {
                str = "";
            } else {
                str = channelInfo.getChannelName();
            }
            b16.putExtra("channel_name", str);
            r(message);
            p(message);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("convertToNotificationElement.  notifyType:");
                if (channelInfo != null) {
                    obj = Integer.valueOf(channelInfo.getFinalMsgNotify());
                }
                sb5.append(obj);
                sb5.append(" shmsgseq:");
                sb5.append(message.shmsgseq);
                sb5.append(" channelId:");
                sb5.append(message.frienduin);
                QLog.d("GuildNotificationProcessor", 2, sb5.toString());
            }
            return this.f196405b;
        }
        return q(message);
    }

    @Override // com.tencent.mobileqq.app.notification.struct.c
    public int e(Message message) {
        return h(message);
    }
}
