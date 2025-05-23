package com.tencent.mobileqq.guild.message.api.impl.onlinepush;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.impl.onlinepush.e;
import com.tencent.mobileqq.guild.message.base.s;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.group_pro_proto.common.common$Msg;

/* loaded from: classes14.dex */
public class GuildMsgPushConsumer {

    /* renamed from: a, reason: collision with root package name */
    private GuildMessagePushHandler f230212a;

    /* renamed from: b, reason: collision with root package name */
    private s f230213b;

    /* renamed from: c, reason: collision with root package name */
    private bc f230214c;

    /* renamed from: d, reason: collision with root package name */
    private IGuildFocusChannelService f230215d;

    /* renamed from: e, reason: collision with root package name */
    private e f230216e;

    /* renamed from: f, reason: collision with root package name */
    private f f230217f = new f(1000);

    public GuildMsgPushConsumer(GuildMessagePushHandler guildMessagePushHandler) {
        this.f230212a = guildMessagePushHandler;
        this.f230216e = guildMessagePushHandler.K2();
    }

    private IGuildFocusChannelService c() {
        if (this.f230215d == null) {
            this.f230215d = (IGuildFocusChannelService) this.f230212a.f230205d.getRuntimeService(IGuildFocusChannelService.class, "");
        }
        return this.f230215d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public s d() {
        if (this.f230213b == null) {
            this.f230213b = ((IGuildMsgFactory) this.f230212a.f230205d.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(2);
        }
        return this.f230213b;
    }

    private void i(Runnable runnable, long j3) {
        synchronized (this) {
            if (this.f230214c == null) {
                this.f230214c = ThreadManagerV2.newHandlerRecycleThread("Guild_Msg_OnlinePush_Thread", 0).b();
            }
        }
        if (j3 > 0) {
            this.f230214c.postDelayed(runnable, j3);
        } else {
            this.f230214c.post(runnable);
        }
    }

    private boolean j(e.b bVar) {
        long j3;
        long j16;
        if (bVar == null) {
            return false;
        }
        long j17 = bVar.f230289a;
        e eVar = this.f230216e;
        if (j17 == e.B) {
            return false;
        }
        e.c K = eVar.K(j17);
        List<byte[]> list = K.f230292b;
        long j18 = 0;
        long j19 = 200;
        if (list != null && list.size() > 0) {
            this.f230216e.f(bVar);
            long uptimeMillis = SystemClock.uptimeMillis();
            Bundle bundle = new Bundle();
            bundle.putLong("channelId", bVar.f230289a);
            d().a(K.f230292b, Integer.valueOf(com.tencent.mobileqq.guild.message.s.f230789d), bundle);
            j16 = SystemClock.uptimeMillis() - uptimeMillis;
            this.f230216e.s().i(c().isHugeChannel(String.valueOf(K.f230291a)), K.f230292b.size());
            j3 = j16;
        } else {
            j3 = 0;
            j16 = 200;
        }
        if (j16 <= 200) {
            j19 = j16;
        }
        if (!this.f230216e.j()) {
            j18 = j19;
        }
        h(j18);
        QLog.i("GuildMsgPushConsumer", 1, "realProcessMsgsAndPostNext exeChannelInfo:" + bVar + " exeMsgInfo:" + K.toString() + " cost time:" + j3 + " delay:" + j18);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        e.b g16 = this.f230216e.g();
        if (!com.tencent.mobileqq.guild.message.s.K(this.f230212a.f230205d)) {
            if (this.f230217f.a("runCoreTask1")) {
                QLog.i("GuildMsgPushConsumer", 1, "isSyncGuildMsgFinish false");
            }
            g16 = null;
        }
        if (!j(g16)) {
            this.f230216e.U();
        }
        this.f230216e.y();
    }

    public void e(final List<byte[]> list) {
        i(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.onlinepush.GuildMsgPushConsumer.1
            @Override // java.lang.Runnable
            public void run() {
                GuildMsgPushConsumer.this.d().a(list, Integer.valueOf(com.tencent.mobileqq.guild.message.s.f230790e), null);
            }
        }, 0L);
    }

    public void f(final List<common$Msg> list) {
        i(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.onlinepush.GuildMsgPushConsumer.2
            @Override // java.lang.Runnable
            public void run() {
                GuildMsgPushConsumer.this.d().a(list, Integer.valueOf(com.tencent.mobileqq.guild.message.s.f230790e), null);
            }
        }, 0L);
    }

    public void g() {
        bc bcVar = this.f230214c;
        if (bcVar != null) {
            bcVar.removeAll();
            this.f230214c = null;
        }
    }

    public void h(long j3) {
        i(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.onlinepush.GuildMsgPushConsumer.3
            @Override // java.lang.Runnable
            public void run() {
                GuildMsgPushConsumer.this.k();
            }
        }, j3);
    }
}
