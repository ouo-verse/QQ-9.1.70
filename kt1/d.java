package kt1;

import com.tencent.mobileqq.guild.media.core.e;
import com.tencent.mobileqq.guild.media.core.f;
import com.tencent.mobileqq.guild.media.core.i;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.logic.ac;
import com.tencent.mobileqq.guild.media.model.AudioQueueState;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.fc;
import com.tencent.mobileqq.qqguildsdk.data.genc.k;
import com.tencent.mobileqq.qqguildsdk.data.genc.l;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.er;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u001e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J(\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\n\u00a8\u0006\u0015"}, d2 = {"Lkt1/d;", "", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "k", "Lcom/tencent/mobileqq/guild/media/core/f;", "j", "", "guildId", "channelId", "tinyId", "", "isClose", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/fc;", "i", "", "d", "l", "needPush", "f", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a */
    @NotNull
    public static final d f412973a = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"kt1/d$a", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements i {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("QGMC.GuildAudioQueueService", 1, "setMicrophone enable: false, result: " + result + ", " + errMsg);
        }
    }

    d() {
    }

    public static final void e(int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
        QLog.i("QGMC.GuildAudioQueueService", 1, "addSpeakerOrderByUser result: " + i3 + ", " + str);
        if (i3 == 0) {
            com.tencent.mobileqq.guild.media.core.notify.c cVar = new com.tencent.mobileqq.guild.media.core.notify.c(AudioQueueState.AUDIO_QUEUE_ENTER);
            d dVar = f412973a;
            dVar.j().getEventBus().i(cVar);
            dVar.j().N().N1(true);
            return;
        }
        QQToast.makeText(BaseApplication.context, str, 0).show();
    }

    public static /* synthetic */ void g(d dVar, long j3, long j16, long j17, boolean z16, int i3, Object obj) {
        boolean z17;
        if ((i3 & 8) != 0) {
            z17 = true;
        } else {
            z17 = z16;
        }
        dVar.f(j3, j16, j17, z17);
    }

    public static final void h(long j3, boolean z16, int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
        QLog.i("QGMC.GuildAudioQueueService", 1, "closeSpeakingByUser result: " + i3 + ", " + str);
        if (i3 == 0) {
            ac.T0(j.a().M(), String.valueOf(j3), false, 2, null);
            j.a().J().i(false, new a());
            if (z16) {
                f412973a.j().getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.c(AudioQueueState.AUDIO_QUEUE_CLOSE));
                return;
            }
            return;
        }
        QQToast.makeText(BaseApplication.context, str, 0).show();
    }

    private final fc i(long guildId, long channelId, long tinyId, boolean isClose) {
        k kVar = new k();
        kVar.e(guildId);
        kVar.d(channelId);
        fc fcVar = new fc();
        fcVar.g(tinyId);
        fcVar.e(kVar);
        if (isClose) {
            l lVar = new l();
            lVar.e(11);
            fcVar.f(lVar);
        }
        return fcVar;
    }

    private final f j() {
        e a16 = j.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.IMediaChannelInnerCore");
        return (f) a16;
    }

    private final IGPSService k() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        return (IGPSService) runtimeService;
    }

    public static final void m(int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
        QLog.i("QGMC.GuildAudioQueueService", 1, "removeSpeakOrderByUser result: " + i3 + ", " + str);
        if (i3 == 0) {
            f412973a.j().getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.c(AudioQueueState.AUDIO_QUEUE_EXIT));
        } else {
            QQToast.makeText(BaseApplication.context, str, 0).show();
        }
    }

    public final void d(long guildId, long channelId, long tinyId) {
        QLog.i("QGMC.GuildAudioQueueService", 1, "addSpeakerOrderByUser request: " + guildId + ", " + channelId + ", " + tinyId);
        k().addSpeakOrderByUser(i(guildId, channelId, tinyId, false), new er() { // from class: kt1.b
            @Override // wh2.er
            public final void a(int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
                d.e(i3, str, iGProUserAVRspInfo);
            }
        });
    }

    public final void f(long guildId, long channelId, final long tinyId, final boolean needPush) {
        QLog.i("QGMC.GuildAudioQueueService", 1, "closeSpeakingByUser request: " + guildId + ", " + channelId + ", " + tinyId);
        k().removeSpeakOrderByUser(i(guildId, channelId, tinyId, true), new er() { // from class: kt1.a
            @Override // wh2.er
            public final void a(int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
                d.h(tinyId, needPush, i3, str, iGProUserAVRspInfo);
            }
        });
    }

    public final void l(long guildId, long channelId, long tinyId) {
        QLog.i("QGMC.GuildAudioQueueService", 1, "removeSpeakOrderByUser request: " + guildId + ", " + channelId + ", " + tinyId);
        k().removeSpeakOrderByUser(i(guildId, channelId, tinyId, false), new er() { // from class: kt1.c
            @Override // wh2.er
            public final void a(int i3, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
                d.m(i3, str, iGProUserAVRspInfo);
            }
        });
    }
}
