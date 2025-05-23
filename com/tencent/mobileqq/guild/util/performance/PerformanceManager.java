package com.tencent.mobileqq.guild.util.performance;

import androidx.lifecycle.Observer;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes14.dex */
public class PerformanceManager {

    /* renamed from: g, reason: collision with root package name */
    private static PerformanceManager f235574g;

    /* renamed from: h, reason: collision with root package name */
    private static final long[] f235575h = {60000, MiniBoxNoticeInfo.MIN_5, 600000, 1800000, 3600000};

    /* renamed from: a, reason: collision with root package name */
    private Timer f235576a = null;

    /* renamed from: b, reason: collision with root package name */
    private TimerTask f235577b = null;

    /* renamed from: c, reason: collision with root package name */
    private Timer f235578c = null;

    /* renamed from: d, reason: collision with root package name */
    private TimerTask f235579d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f235580e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f235581f = 0;

    /* renamed from: com.tencent.mobileqq.guild.util.performance.PerformanceManager$3, reason: invalid class name */
    /* loaded from: classes14.dex */
    class AnonymousClass3 extends TimerTask {
        final /* synthetic */ PerformanceManager this$0;

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            QLog.i("Guild-PerformanceManager", 4, "runAudioReportTask");
            PerformanceManager performanceManager = this.this$0;
            performanceManager.j(performanceManager.k("audio_room", performanceManager.f235581f));
            this.this$0.f235581f += 60000;
        }
    }

    /* loaded from: classes14.dex */
    class a implements Observer<LiveChannelRoomInfo> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(LiveChannelRoomInfo liveChannelRoomInfo) {
            boolean z16;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("observeLiveRoom: liveChannelRoomInfo is null? -> ");
            boolean z17 = true;
            if (liveChannelRoomInfo == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("  |   mVideoReportTimer is null? -> ");
            if (PerformanceManager.this.f235578c != null) {
                z17 = false;
            }
            sb5.append(z17);
            QLog.i("Guild-PerformanceManager", 4, sb5.toString());
            if (liveChannelRoomInfo != null && PerformanceManager.this.f235578c == null) {
                PerformanceManager.this.o();
            }
            if (liveChannelRoomInfo == null && PerformanceManager.this.f235578c != null) {
                GLiveChannelCore.f226698a.t().p().removeObserver(this);
                PerformanceManager.this.p();
            }
        }
    }

    PerformanceManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(b bVar) {
        bVar.b("audio_float_window_showing", String.valueOf(GuildFloatWindowUtils.m())).b("person_number", String.valueOf(j.c().getUserInfoList().f228125a.size())).g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b k(String str, long j3) {
        return b.c().a(ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE).f(str).e("guild_impl").b("process_memory_used", String.valueOf(d.d())).b("phone_total_memory", String.valueOf(d.c())).b("phone_free_memory", String.valueOf(d.b())).b("process_cpu_jiffies", String.valueOf(d.a())).b("time", String.valueOf(TimeUnit.MILLISECONDS.toMinutes(j3)));
    }

    public static PerformanceManager l() {
        if (f235574g == null) {
            synchronized (PerformanceManager.class) {
                if (f235574g == null) {
                    f235574g = new PerformanceManager();
                }
            }
        }
        return f235574g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        QLog.i("Guild-PerformanceManager", 4, "runVideoReportTask");
        long[] jArr = f235575h;
        q(k("video_room", jArr[this.f235580e]));
        int i3 = this.f235580e + 1;
        this.f235580e = i3;
        if (i3 < jArr.length) {
            this.f235579d = new TimerTask() { // from class: com.tencent.mobileqq.guild.util.performance.PerformanceManager.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    PerformanceManager.this.n();
                }
            };
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.util.performance.PerformanceManager.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PerformanceManager.this.f235578c != null) {
                        PerformanceManager.this.f235578c.schedule(PerformanceManager.this.f235579d, PerformanceManager.f235575h[PerformanceManager.this.f235580e] - PerformanceManager.f235575h[PerformanceManager.this.f235580e - 1]);
                    }
                }
            });
        }
    }

    private void q(b bVar) {
        long viewer;
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        b b16 = bVar.b("video_width", String.valueOf(gLiveChannelCore.t().L().getValue())).b("video_height", String.valueOf(gLiveChannelCore.t().I().getValue()));
        if (gLiveChannelCore.t().p().getValue() == null) {
            viewer = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        } else {
            viewer = gLiveChannelCore.t().p().getValue().getViewer();
        }
        b16.b("person_number", String.valueOf(viewer)).g();
    }

    public void m() {
        if (this.f235578c == null) {
            GLiveChannelCore.f226698a.t().p().observeForever(new a());
        }
    }

    public void o() {
        p();
        this.f235578c = new BaseTimer();
        TimerTask timerTask = new TimerTask() { // from class: com.tencent.mobileqq.guild.util.performance.PerformanceManager.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                PerformanceManager.this.n();
            }
        };
        this.f235579d = timerTask;
        this.f235580e = 0;
        this.f235578c.schedule(timerTask, f235575h[0]);
    }

    public void p() {
        TimerTask timerTask = this.f235579d;
        if (timerTask != null) {
            timerTask.cancel();
            this.f235579d = null;
        }
        Timer timer = this.f235578c;
        if (timer != null) {
            timer.cancel();
            this.f235578c = null;
        }
    }
}
