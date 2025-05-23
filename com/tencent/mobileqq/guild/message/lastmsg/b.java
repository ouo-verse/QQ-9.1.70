package com.tencent.mobileqq.guild.message.lastmsg;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.lastmsg.api.IGuildGuestLastMsgService;
import com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService;
import com.tencent.mobileqq.guild.message.m;
import com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private AppRuntime f230642a;

    /* renamed from: b, reason: collision with root package name */
    private m f230643b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements IGuildLastMsgService.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MessageRecord f230644a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGuildLastMsgService f230645b;

        a(MessageRecord messageRecord, IGuildLastMsgService iGuildLastMsgService) {
            this.f230644a = messageRecord;
            this.f230645b = iGuildLastMsgService;
        }

        @Override // com.tencent.mobileqq.guild.message.lastmsg.api.IGuildLastMsgService.a
        public void a(String str, GuildLastMsgItem guildLastMsgItem) {
            if (guildLastMsgItem == null) {
                return;
            }
            synchronized (guildLastMsgItem) {
                boolean e16 = b.this.e(str, guildLastMsgItem, this.f230644a);
                boolean d16 = b.this.d(str, guildLastMsgItem, this.f230644a);
                if (e16 || d16) {
                    this.f230645b.updateLastMsgItem(this.f230644a.frienduin, guildLastMsgItem);
                    QLog.i("GuildLastMsgHandler", 1, "updateLastMsg: " + guildLastMsgItem.toString());
                }
            }
        }
    }

    public b(AppRuntime appRuntime, m mVar) {
        this.f230642a = appRuntime;
        this.f230643b = mVar;
    }

    private boolean c(MessageRecord messageRecord) {
        if (messageRecord.isValid && !ad.D(messageRecord.msgtype)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(String str, GuildLastMsgItem guildLastMsgItem, MessageRecord messageRecord) {
        if (c(messageRecord)) {
            QLog.i("GuildLastMsgHandler", 1, "handleMessage filterMsg " + messageRecord.toString());
            return false;
        }
        if (f(messageRecord, guildLastMsgItem.message)) {
            QLog.i("GuildLastMsgHandler", 1, "handleMessage mrIsOld " + messageRecord.toString());
            return false;
        }
        MessageRecord.copyMessageRecordBaseField(guildLastMsgItem.message, messageRecord);
        try {
            this.f230643b.f116282e.decodeMsg(guildLastMsgItem.message);
            if (((IGuildMessageTempUtilsApi) QRoute.api(IGuildMessageTempUtilsApi.class)).isMessageForPic(messageRecord)) {
                String c16 = m.F.c(messageRecord);
                if (!TextUtils.isEmpty(c16)) {
                    guildLastMsgItem.message.f203106msg = c16;
                }
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildLastMsgHandler", 2, "updateMsgTab ERROR", th5);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str, GuildLastMsgItem guildLastMsgItem, MessageRecord messageRecord) {
        if (messageRecord.shmsgseq > ((IGuildMsgSeqTimeService) this.f230642a.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getReadedMsgSeq(str).f230119d) {
            ((IGuildLastMsgService) this.f230642a.getRuntimeService(IGuildLastMsgService.class, "")).updateUnreadCnt(str, guildLastMsgItem);
            return true;
        }
        return false;
    }

    private boolean f(MessageRecord messageRecord, Message message) {
        int i3 = (int) (message.shmsgseq - messageRecord.shmsgseq);
        if ((messageRecord.isSendFromLocal() && (!messageRecord.isSendFromLocal() || TextUtils.equals(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getLocalOnlyFromMR(messageRecord), "1"))) || i3 <= 0) {
            return false;
        }
        return true;
    }

    public void g(MessageRecord messageRecord, com.tencent.mobileqq.troop.data.c cVar) {
        if (messageRecord != null && this.f230643b != null) {
            IGuildLastMsgService iGuildLastMsgService = (IGuildLastMsgService) this.f230642a.getRuntimeService(IGuildLastMsgService.class, "");
            iGuildLastMsgService.getLastMsgItemAsync(messageRecord.frienduin, new a(messageRecord, iGuildLastMsgService));
        }
    }

    public void h(MessageRecord messageRecord, com.tencent.mobileqq.troop.data.c cVar) {
        if (messageRecord != null && this.f230643b != null) {
            String str = messageRecord.frienduin;
            IGuildGuestLastMsgService iGuildGuestLastMsgService = (IGuildGuestLastMsgService) this.f230642a.getRuntimeService(IGuildGuestLastMsgService.class, "");
            GuildLastMsgItem lastMsgItemForGuest = iGuildGuestLastMsgService.getLastMsgItemForGuest(str);
            if (d(str, lastMsgItemForGuest, messageRecord)) {
                iGuildGuestLastMsgService.updateLastMsgItemForGuest(str, lastMsgItemForGuest);
            }
        }
    }
}
