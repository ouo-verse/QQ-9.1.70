package com.tencent.av;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.ak;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.rtc.node.report.data.NodeModel$EndStatusCode;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.utils.RtcVideoRecoveryNodeReport;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoRecoveryMonitor {

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f72888a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f72889b;

    /* renamed from: c, reason: collision with root package name */
    private final long f72890c;

    /* renamed from: d, reason: collision with root package name */
    private final long f72891d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f72892e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f72893f;

    /* renamed from: g, reason: collision with root package name */
    private long f72894g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f72895h;

    /* renamed from: i, reason: collision with root package name */
    private long f72896i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f72897j;

    public VideoRecoveryMonitor(VideoAppInterface videoAppInterface) {
        boolean z16;
        this.f72888a = videoAppInterface;
        if (com.tencent.av.ui.funchat.record.e.a().f75882n == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f72889b = z16;
        long j3 = com.tencent.av.ui.funchat.record.e.a().f75883o;
        this.f72890c = j3;
        long b16 = ak.b("qav_video_recovery_control", "background_recovery_time_interval_ms", 8000L);
        this.f72891d = b16;
        QLog.d("VideoRecoveryMonitor", 1, String.format("VideoProcessExitMonitor mRecoveryEnable=%s mRecoveryInterval=%s qqPaused=%s", Boolean.valueOf(this.f72889b), Long.valueOf(j3), Long.valueOf(b16)));
    }

    private boolean c(boolean z16, long j3) {
        if (z16) {
            if (j3 <= this.f72891d) {
                return true;
            }
            return false;
        }
        if (j3 <= this.f72890c) {
            return true;
        }
        return false;
    }

    private void g() {
        try {
            QLog.d("VideoRecoveryMonitor", 1, "removeLastCallInfo");
            this.f72888a.getApp().getSharedPreferences("last_call_info_sp", 0).edit().remove("last_call_uin").remove("last_call_display_name").remove("last_call_business_type").remove("last_call_relation_type").remove("last_call_is_friend").remove("last_call_speaker_on").remove("last_call_local_mute").remove("last_call_room_id").apply();
        } catch (Throwable th5) {
            QLog.e("VideoRecoveryMonitor", 1, "removeLastCallInfo fail.", th5);
        }
    }

    private void h(boolean z16) {
        if (this.f72888a == null) {
            return;
        }
        QLog.d("VideoRecoveryMonitor", 1, String.format("sendKeepProcessAlive keepAlive=%s", Boolean.valueOf(z16)));
        NewIntent newIntent = new NewIntent(this.f72888a.getApplication(), t.class);
        newIntent.putExtra("reqType", 19);
        newIntent.putExtra("keepAlive", z16);
        this.f72888a.startServlet(newIntent);
        this.f72888a.h0(z16);
        this.f72892e = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i() {
        if (this.f72889b && this.f72892e && this.f72888a != null) {
            try {
                SessionInfo f16 = n.e().f();
                String str = f16.f73091w;
                String str2 = f16.f73099y;
                int i3 = f16.S0;
                int i16 = f16.f73035i;
                boolean z16 = f16.f73084u0;
                boolean z17 = f16.I0;
                boolean z18 = f16.K;
                long J = r.h0().J(str);
                if (QLog.isColorLevel()) {
                    QLog.d("VideoRecoveryMonitor", 2, String.format("updateLastCallInfo peerUin=%s displayName=%s businessType=%s relationType=%s sessionType=%s isFriend=%s speakerOn=%s localMute=%s roomId=%s", str, str2, 0, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Long.valueOf(J)));
                }
                if ((i16 == 1 || i16 == 2) && i3 == 3) {
                    this.f72888a.getApp().getSharedPreferences("last_call_info_sp", 0).edit().putString("last_call_uin", str).putString("last_call_display_name", str2).putInt("last_call_business_type", 0).putInt("last_call_relation_type", i3).putBoolean("last_call_is_friend", z16).putBoolean("last_call_speaker_on", z17).putBoolean("last_call_local_mute", z18).putLong("last_call_room_id", J).apply();
                }
            } catch (Throwable th5) {
                QLog.e("VideoRecoveryMonitor", 1, "updateLastCallInfo fail.", th5);
            }
        }
    }

    private void j() {
        try {
            this.f72888a.getApp().getSharedPreferences("last_call_info_sp", 0).edit().putLong("last_recovery_time", System.currentTimeMillis()).apply();
        } catch (Throwable th5) {
            QLog.e("VideoRecoveryMonitor", 1, "updateLastRecoveryTime fail.", th5);
        }
    }

    public void b() {
        TraeHelper F0;
        if (!this.f72889b) {
            return;
        }
        QLog.d("VideoRecoveryMonitor", 1, String.format("channelReady mIsRecovering=%s", Boolean.valueOf(this.f72893f)));
        if (this.f72893f) {
            VideoRecoveryReporter.g(true, System.currentTimeMillis() - this.f72894g);
            this.f72893f = false;
            this.f72895h = true;
            this.f72896i = System.currentTimeMillis();
            if (this.f72897j && (F0 = r.h0().F0()) != null) {
                F0.S();
            }
            if (this.f72888a != null) {
                SessionInfo f16 = n.e().f();
                this.f72888a.y0(f16.f73067q, f16.f73091w, f16.f73103z);
            }
        }
        h(true);
        i();
    }

    public void d() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.av.VideoRecoveryMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                VideoRecoveryMonitor.this.i();
            }
        });
    }

    public void e() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.av.VideoRecoveryMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                VideoRecoveryMonitor.this.i();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.tencent.av.app.SessionInfo] */
    public void f(int i3, boolean z16, String str, long j3) {
        String str2;
        boolean z17;
        ?? r36;
        long j16;
        if (!this.f72889b) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str2 = VideoUtil.e(this.f72888a.getCurrentAccountUin(), "start_dav_talk_recovery");
        } else {
            str2 = str;
        }
        if (!z16 && i3 != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        try {
            SharedPreferences sharedPreferences = this.f72888a.getApp().getSharedPreferences("last_call_info_sp", 0);
            long currentTimeMillis = System.currentTimeMillis() - sharedPreferences.getLong("last_recovery_time", 0L);
            long currentTimeMillis2 = System.currentTimeMillis() - j3;
            String string = sharedPreferences.getString("last_call_uin", null);
            String string2 = sharedPreferences.getString("last_call_display_name", null);
            int i16 = sharedPreferences.getInt("last_call_business_type", -1);
            int i17 = sharedPreferences.getInt("last_call_relation_type", -1);
            boolean z18 = sharedPreferences.getBoolean("last_call_is_friend", false);
            boolean z19 = z17;
            boolean z26 = sharedPreferences.getBoolean("last_call_speaker_on", false);
            final String str3 = str2;
            boolean z27 = sharedPreferences.getBoolean("last_call_local_mute", false);
            String str4 = "VideoRecoveryMonitor";
            try {
                long j17 = sharedPreferences.getLong("last_call_room_id", -1L);
                long d16 = com.tencent.av.utils.e.d();
                StringBuilder sb5 = new StringBuilder();
                try {
                    sb5.append("recoverLastCallIfNeed, source[");
                    sb5.append(i3);
                    sb5.append("], lastRecoveryInterval[");
                    sb5.append(currentTimeMillis);
                    sb5.append("], interruptInterval[");
                    sb5.append(currentTimeMillis2);
                    sb5.append("], peerUin[");
                    sb5.append(string);
                    sb5.append("], displayName[");
                    sb5.append(string2);
                    sb5.append("], businessType[");
                    sb5.append(i16);
                    sb5.append("], relationType[");
                    sb5.append(i17);
                    sb5.append("], isFriend[");
                    sb5.append(z18);
                    sb5.append("], speakerOn[");
                    sb5.append(z26);
                    sb5.append("], localMute[");
                    sb5.append(z27);
                    sb5.append("], roomId[");
                    sb5.append(j17);
                    sb5.append("], seq[");
                    sb5.append(d16);
                    sb5.append("]");
                    try {
                        QLog.w(str4, 1, sb5.toString());
                        try {
                            str4 = str4;
                            RtcVideoRecoveryNodeReport rtcVideoRecoveryNodeReport = new RtcVideoRecoveryNodeReport(this.f72888a.getCurrentUin(), string, str3, com.tencent.mobileqq.msf.core.c0.g.S0);
                            rtcVideoRecoveryNodeReport.e("video_recovery_cost_time_ms", String.valueOf(currentTimeMillis2));
                            r36 = (currentTimeMillis > 10000L ? 1 : (currentTimeMillis == 10000L ? 0 : -1));
                            try {
                                if (r36 > 0 && c(z19, currentTimeMillis2) && !TextUtils.isEmpty(string) && i16 != -1 && i17 != -1 && j17 != -1) {
                                    ?? a16 = n.e().a(n.b(i17, string, new int[0]), false);
                                    a16.f73067q = 0;
                                    a16.f73091w = string;
                                    a16.f73099y = string2;
                                    a16.S0 = i17;
                                    try {
                                        a16.f73081t1 = true;
                                        a16.f73089v1 = j17;
                                        a16.p0(d16, "recoverLastCallIfNeed", 1);
                                        a16.M0 = true;
                                        a16.f73084u0 = z18;
                                        a16.K = z27;
                                        a16.f73079t = "7";
                                        a16.f73083u = j3;
                                        r36 = str4;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        i17 = 1;
                                        r36 = str4;
                                    }
                                    try {
                                        a16.v0(r36, str3);
                                        j16 = currentTimeMillis2;
                                        com.tencent.avcore.rtc.node.report.utils.b.x(this.f72888a.getCurrentAccountUin(), string, str3, true, 0L);
                                    } catch (Throwable th6) {
                                        th = th6;
                                        r36 = r36;
                                        i17 = 1;
                                        QLog.e((String) r36, i17, "recoverLastCallIfNeed fail.", th);
                                    }
                                    try {
                                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.VideoRecoveryMonitor.3
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                com.tencent.avcore.rtc.node.report.utils.b.u(str3, "7");
                                                com.tencent.avcore.rtc.node.report.utils.b.t(str3, NodeModel$EndStatusCode.K_NORMAL.ordinal(), NodeModel$NodeEndReason.K_NORMAL.ordinal());
                                            }
                                        }, 128, null, true);
                                        r.h0().k2(d16, string, i16, i17, null, null, null, 0, null, null, null, null, null, 0, 0, null, str3);
                                        g();
                                        j();
                                        if (SmallScreenUtils.w()) {
                                            SmallScreenUtils.b(d16, 1, this.f72888a.getApp(), false, this.f72888a.getCurrentAccountUin(), false);
                                        } else {
                                            SmallScreenUtils.B(0L, this.f72888a, 2);
                                        }
                                        com.tencent.avcore.rtc.node.report.utils.b.k(str3);
                                        TraeHelper F0 = r.h0().F0();
                                        if (F0 != null) {
                                            F0.i0(TraeConstants.VOICE_CALL_CONFIG);
                                        }
                                        i17 = 1;
                                        this.f72893f = true;
                                        this.f72894g = System.currentTimeMillis();
                                        this.f72897j = z26;
                                        r36 = r36;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        i17 = 1;
                                        QLog.e((String) r36, i17, "recoverLastCallIfNeed fail.", th);
                                    }
                                } else {
                                    j16 = currentTimeMillis2;
                                    String str5 = str4;
                                    i17 = 1;
                                    rtcVideoRecoveryNodeReport.d(NodeModel$NodeEndReason.K_TIME_OUT.ordinal());
                                    QLog.d(str5, 1, "recoverLastCallIfNeed no need to recovery last call.");
                                    r36 = str5;
                                }
                                rtcVideoRecoveryNodeReport.c();
                                VideoRecoveryReporter.f(i3, j16, this.f72893f);
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            r36 = str4;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        i17 = 1;
                        r36 = str4;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    r36 = str4;
                    i17 = 1;
                    QLog.e((String) r36, i17, "recoverLastCallIfNeed fail.", th);
                }
            } catch (Throwable th12) {
                th = th12;
            }
        } catch (Throwable th13) {
            th = th13;
            r36 = "VideoRecoveryMonitor";
        }
    }

    public void k(int i3) {
        if (!this.f72889b) {
            return;
        }
        QLog.d("VideoRecoveryMonitor", 1, String.format("videoClose reason=%s", Integer.valueOf(i3)));
        this.f72893f = false;
        if (this.f72895h) {
            this.f72895h = false;
            VideoRecoveryReporter.e(i3, System.currentTimeMillis() - this.f72896i);
        }
        h(false);
        g();
    }
}
