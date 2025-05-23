package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.utils.RtcVideoRecoveryNodeReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.opentelemetry.sdk.trace.IdGenerator;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoUtil {

    /* renamed from: a, reason: collision with root package name */
    private static long f76920a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AnimationTrigger implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        VideoAppInterface f76921d;

        /* renamed from: e, reason: collision with root package name */
        float f76922e = -1.0f;

        /* renamed from: f, reason: collision with root package name */
        float f76923f = -1.0f;

        /* renamed from: h, reason: collision with root package name */
        boolean f76924h = false;

        public AnimationTrigger(VideoAppInterface videoAppInterface) {
            this.f76921d = videoAppInterface;
        }

        public void cancel() {
            if (QLog.isColorLevel()) {
                QLog.e("AnimationTrigger", 2, "[childLock] cancel animation");
            }
            this.f76924h = false;
            this.f76921d.k0(new Object[]{119, 0});
        }

        public boolean e() {
            return this.f76924h;
        }

        public void f(float f16, float f17) {
            this.f76922e = f16;
            this.f76923f = f17;
            this.f76924h = false;
            this.f76921d.M().removeCallbacks(this);
            this.f76921d.M().postDelayed(this, 1000L);
        }

        public void g() {
            if (QLog.isColorLevel()) {
                QLog.e("AnimationTrigger", 2, "[childLock] requestShowOrHiddenChildLockUI");
            }
            this.f76921d.k0(new Object[]{119, 3});
        }

        public void h() {
            if (QLog.isColorLevel()) {
                QLog.e("AnimationTrigger", 2, "[childLock] requestShowTips");
            }
            this.f76921d.k0(new Object[]{119, 2});
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f76921d != null) {
                if (QLog.isColorLevel()) {
                    QLog.w("AnimationTrigger", 1, "[childLock] trigger animation, isTriggeredAnimation[" + this.f76924h + "]");
                }
                this.f76924h = true;
                this.f76921d.k0(new Object[]{119, 1, Float.valueOf(this.f76922e), Float.valueOf(this.f76923f)});
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public static boolean a(VideoAppInterface videoAppInterface) {
        if (com.tencent.av.r.h0() == null) {
            return false;
        }
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (2 != com.tencent.av.n.e().f().S0 || i3 != 4) {
            return false;
        }
        return true;
    }

    public static boolean b(VideoAppInterface videoAppInterface) {
        if (com.tencent.av.r.h0() == null) {
            return false;
        }
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (1 != com.tencent.av.n.e().f().S0 || i3 != 4) {
            return false;
        }
        return true;
    }

    public static boolean c(Context context) {
        return !com.tencent.av.r.g1(context);
    }

    public static long d(VideoAppInterface videoAppInterface) {
        if (videoAppInterface != null && com.tencent.av.r.h0() != null) {
            return com.tencent.av.r.h0().O();
        }
        return 0L;
    }

    public static String e(String str, String str2) {
        if (Build.VERSION.SDK_INT > 27) {
            com.tencent.avcore.rtc.node.report.utils.c.c(str);
            return com.tencent.avcore.rtc.node.report.utils.c.b().r(str2);
        }
        IdGenerator a16 = com.tencent.opentelemetry.sdk.trace.c.a();
        String generateSpanId = a16.generateSpanId();
        return String.format(Locale.getDefault(), "%s-%s-%s-01", "00", a16.generateTraceId(), generateSpanId);
    }

    public static boolean f(VideoAppInterface videoAppInterface) {
        if (videoAppInterface == null || com.tencent.av.r.h0() == null) {
            return false;
        }
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 != 1 && i3 != 3) {
            return false;
        }
        return true;
    }

    public static boolean g(VideoAppInterface videoAppInterface, boolean z16) {
        if (com.tencent.av.r.h0() == null) {
            return false;
        }
        int i3 = com.tencent.av.n.e().f().f73035i;
        int i16 = com.tencent.av.n.e().f().S0;
        boolean z17 = com.tencent.av.n.e().f().N;
        if (3 != i16) {
            return false;
        }
        if (z16 && (i3 != 2 || !z17)) {
            return false;
        }
        return true;
    }

    public static boolean h(VideoAppInterface videoAppInterface) {
        if (videoAppInterface == null || com.tencent.av.r.h0() == null || com.tencent.av.n.e().f().f73035i != 1) {
            return false;
        }
        return true;
    }

    public static boolean i() {
        return ABTestController.getInstance().getExpEntity("exp_qq_group_video_aio_entrance").isExperiment();
    }

    public static boolean j() {
        EIPCResult callServer;
        EIPCClient client = QIPCClientHelper.getInstance().getClient();
        if (client != null && (callServer = BinderMethodProxy.callServer(client, "QavQIPCModule", "action_is_qq_pause", new Bundle())) != null && callServer.isSuccess()) {
            return callServer.data.getBoolean("key_is_qq_pause");
        }
        return false;
    }

    public static void k(Context context, String str, int i3) {
        QLog.i("VideoUtil", 1, "openUrl MSG_SECURITY_LIMIT context: " + context + " safe url: " + str);
        if (System.currentTimeMillis() - f76920a < 500) {
            return;
        }
        f76920a = System.currentTimeMillis();
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        ((Activity) context).startActivityForResult(intent, i3);
    }

    public static void l(String str, String str2, String str3) {
        RtcVideoRecoveryNodeReport rtcVideoRecoveryNodeReport = new RtcVideoRecoveryNodeReport(str, str2, e(str, "reportAVBlocked"), 4000);
        rtcVideoRecoveryNodeReport.e(str3, "0");
        rtcVideoRecoveryNodeReport.d(NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
        rtcVideoRecoveryNodeReport.c();
    }

    public static void m(Activity activity, VideoAppInterface videoAppInterface, boolean z16) {
        int i3;
        int i16;
        if (videoAppInterface != null && com.tencent.av.r.h0() != null && com.tencent.av.n.e().f() != null) {
            SessionInfo f16 = com.tencent.av.n.e().f();
            String str = f16.f73091w;
            if (!z16 ? com.tencent.av.r.h0().b1(f16) : com.tencent.av.r.h0().a1(f16)) {
                i3 = 1;
            } else {
                i3 = 3000;
            }
            if (QLog.isColorLevel()) {
                QLog.i("double_2_multi", 2, "sendAddMemberBroadcast, peerUin[" + str + "], supportUinType[" + i3 + "], fromDoubleMeeting[" + z16 + "], activity[" + activity + "]");
            }
            if (i3 == 1) {
                i16 = 1;
            } else {
                i16 = 2;
            }
            DataReport.T(null, "dc00898", "", "", "0X800A2D3", "0X800A2D3", i16, 0, "", "", "", "");
            if (i3 == 3000 && activity != null && af.h()) {
                String i17 = af.i();
                DialogUtil.createCustomDialog(activity, 230, (String) null, i17, "", HardCodeUtil.qqStr(R.string.lq_), new a(), (DialogInterface.OnClickListener) null).show();
                if (QLog.isColorLevel()) {
                    QLog.i("double_2_multi", 2, "sendAddMemberBroadcast tip[" + i17 + "]");
                }
                DataReport.T(null, "dc00898", "", "", "0X800A2CB", "0X800A2CB", 0, 0, "", "", "", "");
                return;
            }
            Intent intent = new Intent();
            intent.setAction("tencent.video.v2q.AddContactsFromC2C");
            intent.putExtra("peerUin", str);
            intent.putExtra("supportUinType", i3);
            intent.setPackage(videoAppInterface.getApp().getPackageName());
            videoAppInterface.getApp().sendBroadcast(intent);
            return;
        }
        QLog.d("VideoUtil", 1, "sendAddMemberBroadcast error for null pointer.");
    }

    public static void n(VideoAppInterface videoAppInterface, int i3) {
        int i16;
        int i17;
        if (i3 != 0) {
            i17 = 1048;
            if (i3 != 1) {
                if (i3 != 2) {
                    i16 = 0;
                } else {
                    i16 = R.string.dly;
                }
            } else {
                i16 = R.string.f171267dm0;
            }
        } else {
            i16 = R.string.f171269dm3;
            i17 = 1040;
        }
        if (i17 != 1040) {
            cw.e.d(videoAppInterface, 1040);
        }
        if (i16 > 0) {
            cw.e.o(videoAppInterface, i17, i16);
        } else {
            cw.e.d(videoAppInterface, i17);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
    
        if (r1 != 3) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x002d, code lost:
    
        if (r0 < 45) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void o(VideoAppInterface videoAppInterface) {
        String str = com.tencent.av.n.e().f().f73091w;
        int t06 = com.tencent.av.r.h0().t0(str);
        int s06 = com.tencent.av.r.h0().s0(str);
        int i3 = com.tencent.av.n.e().f().f73067q;
        int i16 = R.string.d_0;
        if (i3 != 1011) {
            if (!AVCoreSystemInfo.isNormalSharp()) {
                i16 = R.string.ie9;
            } else if (tv.c.c(VideoAppInterface.N().getApp().getApplicationContext()) == 1) {
                i16 = R.string.icj;
            } else if (s06 < 16) {
                i16 = R.string.d_1;
            } else {
                if (t06 != 4) {
                    if (t06 != 8) {
                        if (t06 != 2) {
                        }
                    }
                }
                i16 = 0;
            }
        }
        if (i16 != 0) {
            cw.e.o(videoAppInterface, 1012, i16);
        } else {
            cw.e.d(videoAppInterface, 1012);
        }
    }
}
