package com.tencent.mobileqq.guild.media.widget;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GProAudioLiveRobotStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.GProAudioLiveRobotStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProAudioLiveRobotStatusRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGProAudioLiveRobotStatusCallback;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMediaFacesController {

    /* renamed from: a, reason: collision with root package name */
    private View f229682a;

    /* renamed from: b, reason: collision with root package name */
    private volatile ArrayList<GProAudioLiveRobotStatusRspInfo> f229683b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private long f229684c = 5000;

    /* renamed from: d, reason: collision with root package name */
    private volatile Timer f229685d;

    /* renamed from: e, reason: collision with root package name */
    private TimerTask f229686e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.guild.media.widget.user.adapter.d f229687f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements IGProAudioLiveRobotStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f229691a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f229692b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f229693c;

        a(AppRuntime appRuntime, long j3, long j16) {
            this.f229691a = appRuntime;
            this.f229692b = j3;
            this.f229693c = j16;
        }

        private void a(int i3, String str) {
            QLog.i("QGMC.GuildMediaFacesController", 1, "getAudioLiveRobotStatus errCode:" + i3 + ";msg:" + str);
        }

        private void b(GProAudioLiveRobotStatusRsp gProAudioLiveRobotStatusRsp) {
            GuildMediaFacesController.this.f229684c = gProAudioLiveRobotStatusRsp.getPollInterval();
            GuildMediaFacesController.this.f229683b = gProAudioLiveRobotStatusRsp.getRspInfos();
            if (GuildMediaFacesController.this.f229682a != null) {
                GuildMediaFacesController.this.f229687f.Z(GuildMediaFacesController.this.f229683b);
            }
            GuildMediaFacesController.this.l(this.f229691a, this.f229692b, this.f229693c);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGProAudioLiveRobotStatusCallback
        public void onResult(int i3, String str, GProAudioLiveRobotStatusRsp gProAudioLiveRobotStatusRsp) {
            if (i3 == 0 && gProAudioLiveRobotStatusRsp != null) {
                b(gProAudioLiveRobotStatusRsp);
            } else {
                a(i3, str);
            }
        }
    }

    public GuildMediaFacesController(@Nullable View view, com.tencent.mobileqq.guild.media.widget.user.adapter.d dVar) {
        this.f229682a = view;
        this.f229687f = dVar;
    }

    public static ArrayList<Long> j(List<com.tencent.mobileqq.guild.media.core.data.p> list) {
        ArrayList<Long> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        for (com.tencent.mobileqq.guild.media.core.data.p pVar : list) {
            if (pVar.f228098f == 1 && !pVar.K.getNoLoopInfo()) {
                arrayList.add(Long.valueOf(Long.parseLong(pVar.f228093a)));
            }
        }
        return arrayList;
    }

    public static long k(long j3, String str) {
        com.tencent.mobileqq.guild.media.core.data.p g16 = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().g(str);
        if (g16 != null) {
            return g16.K.getBotTrtcId();
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final AppRuntime appRuntime, final long j3, final long j16) {
        g(false);
        if (this.f229682a == null) {
            return;
        }
        if (this.f229685d == null) {
            this.f229685d = new BaseTimer();
        }
        if (this.f229686e == null) {
            this.f229686e = new TimerTask() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaFacesController.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    GuildMediaFacesController.this.i(appRuntime, j3, j16);
                }
            };
        }
        if (this.f229685d != null) {
            try {
                Timer timer = this.f229685d;
                TimerTask timerTask = this.f229686e;
                long j17 = this.f229684c;
                timer.schedule(timerTask, j17, j17);
            } catch (Exception unused) {
                g(false);
            }
        }
    }

    public void g(boolean z16) {
        if (z16) {
            this.f229682a = null;
        }
        TimerTask timerTask = this.f229686e;
        if (timerTask != null) {
            timerTask.cancel();
            this.f229686e = null;
        }
        if (this.f229685d != null) {
            this.f229685d.cancel();
            this.f229685d = null;
        }
    }

    public boolean h(GProAudioLiveRobotStatusRspInfo gProAudioLiveRobotStatusRspInfo) {
        boolean z16;
        if (this.f229682a == null) {
            return true;
        }
        for (GProAudioLiveRobotStatusRspInfo gProAudioLiveRobotStatusRspInfo2 : this.f229687f.v()) {
            if (gProAudioLiveRobotStatusRspInfo2.getBotId() == gProAudioLiveRobotStatusRspInfo.getBotId()) {
                if (gProAudioLiveRobotStatusRspInfo.getStatusType() == gProAudioLiveRobotStatusRspInfo2.getStatusType() && TextUtils.equals(gProAudioLiveRobotStatusRspInfo.getStatusText(), gProAudioLiveRobotStatusRspInfo2.getStatusText())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return !z16;
            }
        }
        return true;
    }

    public void i(AppRuntime appRuntime, long j3, long j16) {
        if (this.f229682a == null) {
            return;
        }
        ArrayList<Long> j17 = j(com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a);
        if (j17.size() <= 0) {
            this.f229683b.clear();
            this.f229687f.Z(this.f229683b);
        } else {
            com.tencent.qqnt.kernel.api.ac g16 = sx1.f.g();
            if (g16 == null) {
                return;
            }
            g16.getAudioLiveRobotStatus(new GProAudioLiveRobotStatusReq(j3, j16, j17), new a(appRuntime, j3, j16));
        }
    }
}
