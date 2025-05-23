package com.tencent.av;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.api.IKernelAVSDKListenerApi;
import com.tencent.av.utils.at;
import com.tencent.av.utils.x;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoMsgBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f72868a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f72869b;

    private void a(Bundle bundle) {
        final long j3 = bundle.getLong("cmd_seq");
        final int i3 = bundle.getInt("cmd_type");
        final byte[] byteArray = bundle.getByteArray("cmd_content");
        Runnable runnable = new Runnable() { // from class: com.tencent.av.VideoMsgBroadcastReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                if (r.h0() != null) {
                    x.a(j3);
                    r.h0().l0().receiveSSOMultiVideoMsg(i3, byteArray, false);
                }
            }
        };
        MqqHandler D = r.h0().D();
        if (D != null) {
            D.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void b(final Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoMsgBroadcastReceiver", 2, "processMultiVideoOfflineMsg");
        }
        MqqHandler D = r.h0().D();
        if (D != null) {
            D.post(new Runnable() { // from class: com.tencent.av.VideoMsgBroadcastReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    r.h0().l0().receiveMultiVideoOfflineMsg(bundle);
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoMsgBroadcastReceiver", 2, "processMultiVideoOfflineMsg, async");
                    }
                }
            });
            return;
        }
        r.h0().l0().receiveMultiVideoOfflineMsg(bundle);
        if (QLog.isColorLevel()) {
            QLog.d("VideoMsgBroadcastReceiver", 2, "processMultiVideoOfflineMsg, sync");
        }
    }

    private void c(final Bundle bundle, String str) {
        if (bundle != null && r.h0() != null) {
            long j3 = bundle.getLong("onLineStatus");
            final boolean z16 = bundle.getBoolean("isRequest");
            QLog.d("VideoMsgBroadcastReceiver", 1, "avideo processSharpVideoOfflineMsg, onLineStatus[" + j3 + "], isRequest[" + z16 + "]");
            MqqHandler D = r.h0().D();
            if (D != null) {
                D.post(new Runnable() { // from class: com.tencent.av.VideoMsgBroadcastReceiver.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (r.h0() != null) {
                            r.h0().l0().receiveSharpVideoOfflineMsg(bundle);
                            if (z16) {
                                t.A(VideoAppInterface.N(), bundle.getByteArray("buffer"));
                            }
                        }
                        QLog.d("VideoMsgBroadcastReceiver", 1, "processSharpVideoOfflineMsg, data[" + bundle + "], async");
                    }
                });
            } else {
                r.h0().l0().receiveSharpVideoOfflineMsg(bundle);
                if (z16) {
                    t.A(VideoAppInterface.N(), bundle.getByteArray("buffer"));
                }
                QLog.d("VideoMsgBroadcastReceiver", 1, "processSharpVideoOfflineMsg, data[" + bundle + "], sync");
            }
            if (z16) {
                r.h0().P3(201, str);
                if (r.h0().M() == 0) {
                    r.h0().P3(207, str);
                } else {
                    r.h0().P3(206, str);
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (QLog.isDevelopLevel() && intent != null) {
            com.tencent.av.utils.e.n("VideoMsgBroadcastReceiver.onReceive", intent.getExtras(), true);
        }
        if (intent != null && context != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive data is null!");
                return;
            }
            String string = extras.getString("uin");
            String string2 = extras.getString("fromUin");
            String string3 = extras.getString("gatewayip");
            if (string == null) {
                QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive uin is null!");
                return;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive action is null!");
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive Recv uin = " + string + " action " + action);
            }
            try {
                MobileQQ mobileQQ = MobileQQ.sMobileQQ;
                if (mobileQQ == null) {
                    QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive mobileQQ is null!");
                    return;
                }
                VideoAppInterface videoAppInterface = (VideoAppInterface) mobileQQ.getAppRuntime(string);
                if (videoAppInterface == null) {
                    QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive app is null!");
                    return;
                }
                if (string3 != null) {
                    r.h0().c2(string3, 0);
                }
                if (x.d(intent.getAction())) {
                    if (x.b(extras)) {
                        a(extras);
                        return;
                    } else {
                        QLog.e("VideoMsgBroadcastReceiver", 1, " MavSSOPushVideoHelper cannot handle");
                        return;
                    }
                }
                if ("com.tencent.av.ui.VChatActivity".equals(action)) {
                    int i3 = extras.getInt("source");
                    int i16 = extras.getInt("type");
                    boolean z16 = extras.getBoolean("isQQBackGround", false);
                    long j3 = extras.getLong("processExitTimestamp");
                    String string4 = extras.getString("traceId");
                    if (f72868a) {
                        videoAppInterface.r0(true);
                    }
                    f72868a = false;
                    if (i16 == 1) {
                        VideoRecoveryMonitor T = videoAppInterface.T();
                        if (!f72869b && T != null) {
                            T.f(i3, z16, string4, j3);
                            f72869b = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ("tencent.video.q2v.RecvSharpVideoCall".equals(action)) {
                    c(extras, string2);
                    return;
                }
                if ("tencent.video.q2v.RecvMultiVideoCall".equals(action)) {
                    b(extras);
                    return;
                }
                if ("tencent.video.q2v.RecvBaseIMSharpMsg".equals(action)) {
                    Bundle bundleExtra = intent.getBundleExtra(AppConstants.Key.COLUMN_MSG_DATA);
                    QLog.d("VideoMsgBroadcastReceiver", 1, "RecvBaseIMSharpMsg:" + bundleExtra);
                    if (bundleExtra != null) {
                        byte[] byteArray = bundleExtra.getByteArray("value");
                        long longExtra = intent.getLongExtra("tinyid", 0L);
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("buffer", byteArray);
                        bundle.putLong(INetChannelCallback.KEY_TINY_ID, longExtra);
                        r.h0().l0().receiveDeviceMsg(bundle);
                        return;
                    }
                    return;
                }
                if ("tencent.video.q2v.sendQueryRoomInfoRequest".equals(action)) {
                    long longExtra2 = intent.getLongExtra("roomId", 0L);
                    long longExtra3 = intent.getLongExtra("peerUin", 0L);
                    QLog.w("VideoMsgBroadcastReceiver", 1, "QueryRoomInfo.receive, roomId[" + longExtra2 + "], peerUin[" + longExtra3 + "], seq[" + at.a(intent) + "]");
                    r.h0().z2(longExtra2, longExtra3);
                    return;
                }
                if ("tencent.video.q2v.RecvSharpVideoCallOnline".equals(action)) {
                    ((IKernelAVSDKListenerApi) QRoute.api(IKernelAVSDKListenerApi.class)).processSharpVideoOnlineMsg(extras, string2);
                    return;
                } else {
                    if ("tencent.video.q2v.RecvMultiVideoCallOnline".equals(action)) {
                        ((IKernelAVSDKListenerApi) QRoute.api(IKernelAVSDKListenerApi.class)).processMultiVideoOnlineMsg(extras, string2, true);
                        return;
                    }
                    return;
                }
            } catch (AccountNotMatchException unused) {
                QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive Account not match: uin = " + string);
                return;
            } catch (Exception e16) {
                QLog.d("VideoMsgBroadcastReceiver", 1, "onReceive Exception Account not match: uin = " + string + "app == null", e16);
                return;
            }
        }
        QLog.w("VideoMsgBroadcastReceiver", 1, "onReceive, intent or context is null!");
    }
}
