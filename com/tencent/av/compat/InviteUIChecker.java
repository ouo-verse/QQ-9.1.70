package com.tencent.av.compat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.av.VideoRecoveryReporter;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.ad;
import com.tencent.av.utils.e;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class InviteUIChecker {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, CheckTask> f73547a = new ConcurrentHashMap<>(2);

    /* renamed from: b, reason: collision with root package name */
    private final Handler f73548b = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class CheckTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final long f73549d = e.d();

        /* renamed from: e, reason: collision with root package name */
        private final String f73550e;

        /* renamed from: f, reason: collision with root package name */
        private final Intent f73551f;

        /* renamed from: h, reason: collision with root package name */
        private final WeakReference<VideoAppInterface> f73552h;

        CheckTask(String str, Intent intent, VideoAppInterface videoAppInterface) {
            this.f73550e = str;
            this.f73551f = intent;
            this.f73552h = new WeakReference<>(videoAppInterface);
        }

        public void b(VideoAppInterface videoAppInterface, Intent intent) {
            String b16;
            String str;
            String str2;
            boolean z16;
            String stringExtra = intent.getStringExtra("traceId");
            String stringExtra2 = intent.getStringExtra("peerUin");
            int intExtra = intent.getIntExtra("relationType", 0);
            if (intent.getBooleanExtra("isDoubleVideoMeeting", false)) {
                b16 = n.b(100, stringExtra2, new int[0]);
            } else {
                b16 = n.b(3, stringExtra2, new int[0]);
            }
            String str3 = b16;
            SessionInfo i3 = n.e().i(str3);
            if (i3 == null || !i3.u() || intExtra != 3) {
                str = "InviteUIChecker";
                str2 = str3;
            } else {
                int i16 = i3.f73067q;
                String str4 = i3.f73103z;
                Bitmap J = videoAppInterface.J(i16, stringExtra2, str4, true, true);
                String G = videoAppInterface.G(i16, stringExtra2, str4);
                QAVNotification l3 = QAVNotification.l(videoAppInterface);
                RtcNodeReportReceiverHelper.v(stringExtra);
                if (r.h0() != null && !TextUtils.isEmpty(stringExtra2)) {
                    long currentTimeMillis = System.currentTimeMillis() - r.h0().k0(Long.valueOf(stringExtra2).longValue());
                    if (currentTimeMillis > 5 && currentTimeMillis < 10000) {
                        RtcNodeReportReceiverHelper.t(stringExtra, currentTimeMillis);
                    }
                }
                if (i3.M0) {
                    z16 = false;
                    l3.a(true, str3, G, J, null, 45, i16, 1, null, stringExtra);
                    str2 = str3;
                    str = "InviteUIChecker";
                } else {
                    z16 = false;
                    str = "InviteUIChecker";
                    str2 = str3;
                    l3.a(true, str3, G, J, null, 40, i16, 2, null, stringExtra);
                }
                boolean k3 = AVUtil.k(videoAppInterface.getCurrentAccountUin());
                if (k3) {
                    if (ad.m(videoAppInterface.getApplicationContext())) {
                        l3.v(str2);
                        TraeHelper.j0(videoAppInterface, z16, this.f73549d);
                        AudioUtil.l(R.raw.f169424w, -1, null);
                    } else if (ad.o(videoAppInterface.getApplicationContext())) {
                        TraeHelper.j0(videoAppInterface, z16, this.f73549d);
                    }
                }
                QLog.d(str, 1, "showInviteNotifyForDouble avCallBtnState=" + k3);
                VideoRecoveryReporter.c();
            }
            if (QLog.isColorLevel()) {
                QLog.i(str, 2, "showInviteNotifyForDouble sessionId[" + str2 + "]");
            }
        }

        public void c(VideoAppInterface videoAppInterface, Intent intent) {
            String str;
            long longExtra = intent.getLongExtra("discussId", 0L);
            int intExtra = intent.getIntExtra("relationType", 0);
            long longExtra2 = intent.getLongExtra("friendUin", 0L);
            String b16 = n.b(intExtra, String.valueOf(longExtra), new int[0]);
            SessionInfo i3 = n.e().i(b16);
            if (i3 != null && i3.u()) {
                int i16 = i3.f73067q;
                String str2 = i3.f73103z;
                str = b16;
                QAVNotification.l(videoAppInterface).a(true, b16, videoAppInterface.G(AVUtil.f(i3.S0), String.valueOf(longExtra2), String.valueOf(i3.Y0)), videoAppInterface.J(i16, String.valueOf(longExtra), str2, true, true), String.valueOf(longExtra), 61, i16, 3, videoAppInterface.G(i16, String.valueOf(longExtra), str2), VipFunCallConstants.KEY_GROUP);
                VideoRecoveryReporter.c();
            } else {
                str = b16;
            }
            if (QLog.isColorLevel()) {
                QLog.i("InviteUIChecker", 2, "showInviteNotifyForGroup session[" + str + "]");
            }
        }

        public void d(VideoAppInterface videoAppInterface, Intent intent) {
            String b16;
            String str;
            int intExtra = intent.getIntExtra("uinType", -1);
            if (AVUtil.o(intExtra)) {
                long longExtra = intent.getLongExtra("discussId", 0L);
                int intExtra2 = intent.getIntExtra("relationType", 0);
                long longExtra2 = intent.getLongExtra("friendUin", 0L);
                str = n.b(intExtra2, String.valueOf(longExtra), new int[0]);
                SessionInfo i3 = n.e().i(str);
                if (i3 != null && i3.u()) {
                    String str2 = i3.f73103z;
                    QAVNotification.l(videoAppInterface).d(i3.f73030h, videoAppInterface.G(AVUtil.f(i3.S0), String.valueOf(longExtra2), String.valueOf(i3.Y0)), videoAppInterface.J(intExtra, String.valueOf(longExtra), str2, true, true), String.valueOf(longExtra), 57, intExtra, 3, videoAppInterface.G(intExtra, String.valueOf(longExtra), str2));
                }
            } else {
                String stringExtra = intent.getStringExtra("peerUin");
                int intExtra3 = intent.getIntExtra("relationType", 0);
                boolean booleanExtra = intent.getBooleanExtra("isDoubleVideoMeeting", false);
                if (booleanExtra) {
                    b16 = n.b(100, stringExtra, new int[0]);
                } else {
                    b16 = n.b(3, stringExtra, new int[0]);
                }
                String str3 = b16;
                SessionInfo i16 = n.e().i(str3);
                if (i16 != null && i16.u() && intExtra3 == 3) {
                    String str4 = i16.f73103z;
                    Bitmap J = videoAppInterface.J(intExtra, stringExtra, str4, true, true);
                    String G = videoAppInterface.G(intExtra, stringExtra, str4);
                    QAVNotification l3 = QAVNotification.l(videoAppInterface);
                    if (!i16.M0 && !booleanExtra) {
                        l3.c(i16.f73030h, G, J, i16.f73091w, 56, intExtra, 2);
                    } else {
                        l3.c(i16.f73030h, G, J, i16.f73091w, 55, intExtra, 1);
                    }
                }
                str = str3;
            }
            if (QLog.isColorLevel()) {
                QLog.i("InviteUIChecker", 2, "showInviteNotifyForMultiIncomingCall session[" + str + "]");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoAppInterface videoAppInterface = this.f73552h.get();
            if (videoAppInterface == null) {
                QLog.e("InviteUIChecker", 1, "CheckTask app is null.");
                return;
            }
            try {
                if (VideoInviteActivity.class.getName().equals(this.f73550e)) {
                    b(videoAppInterface, this.f73551f);
                } else if (GaInviteLockActivity.class.getName().equals(this.f73550e)) {
                    c(videoAppInterface, this.f73551f);
                } else if (MultiIncomingCallsActivity.class.getName().equals(this.f73550e)) {
                    d(videoAppInterface, this.f73551f);
                }
                ReportController.o(null, "dc00898", "", "", "0X800A2C4", "0X800A2C4", 0, 0, "", "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.i("InviteUIChecker", 2, "CheckTask className[" + this.f73550e + "]");
                }
            } catch (Throwable th5) {
                QLog.e("InviteUIChecker", 1, "CheckTask  fail.", th5);
            }
        }

        public String toString() {
            return "CheckTask{" + this.f73549d + ", " + this.f73550e + "}";
        }
    }

    public long a(VideoAppInterface videoAppInterface, Intent intent, boolean z16) {
        String str;
        long j3;
        if (intent != null && intent.getComponent() != null) {
            str = intent.getComponent().getClassName();
        } else {
            str = null;
        }
        if (intent != null && videoAppInterface != null && !TextUtils.isEmpty(str)) {
            String stringExtra = intent.getStringExtra(ServiceConst.PARA_SESSION_ID);
            if (TextUtils.isEmpty(stringExtra)) {
                if (QLog.isColorLevel()) {
                    QLog.d("InviteUIChecker", 2, "addInviteUITimeoutChecker session[" + stringExtra + "]");
                }
                return 0L;
            }
            b(str);
            c(stringExtra);
            if (!z16) {
                j3 = 200;
            } else if (AVUtil.p()) {
                j3 = 1500;
            } else {
                j3 = 5000;
            }
            CheckTask checkTask = new CheckTask(str, intent, videoAppInterface);
            this.f73547a.put(stringExtra, checkTask);
            this.f73548b.postDelayed(checkTask, j3);
            if (QLog.isColorLevel()) {
                QLog.i("InviteUIChecker", 2, "addInviteUITimeoutChecker session[" + stringExtra + "], task[" + checkTask + "], timeout[" + j3 + "]");
            }
            return j3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("InviteUIChecker", 2, "addInviteUITimeoutChecker className[" + str + "], app[" + videoAppInterface + "], intent[" + intent + "]");
        }
        return 0L;
    }

    public void b(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("InviteUIChecker", 2, "removeCheckTaskByClass class[" + str + "]");
        }
        for (String str2 : this.f73547a.keySet()) {
            CheckTask checkTask = this.f73547a.get(str2);
            if (checkTask != null && checkTask.f73550e.equals(str)) {
                c(str2);
            }
        }
    }

    public void c(String str) {
        CheckTask checkTask;
        if (!TextUtils.isEmpty(str)) {
            checkTask = this.f73547a.remove(str);
            if (checkTask != null) {
                this.f73548b.removeCallbacks(checkTask);
            }
        } else {
            checkTask = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("InviteUIChecker", 2, "removeCheckTaskBySession session[" + str + "], task[" + checkTask + "]");
        }
    }
}
