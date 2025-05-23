package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.av.avatar.QavAvatarHelper;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.at;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QAVNotifyActionMonitor {

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f72995a;

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f72996b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f72997c = false;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class QAVNotifyActionReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<VideoAppInterface> f72998a;

        QAVNotifyActionReceiver(VideoAppInterface videoAppInterface) {
            this.f72998a = new WeakReference<>(videoAppInterface);
        }

        public void a(long j3, VideoAppInterface videoAppInterface, String str, String str2, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.i("QAVNotifyActionMonitor", 2, "rejectDoubleChat, session[" + str + "], peerUin[" + str2 + "], isDoubleVideoMeeting[" + z16 + "], seq[" + j3 + "]");
            }
            TraeHelper.n0(videoAppInterface);
            if (z16) {
                com.tencent.av.r.h0().g(j3, str2, 1, true);
                long g16 = com.tencent.av.utils.i.g(str2);
                com.tencent.av.r.h0().P0(j3, 3, g16);
                com.tencent.av.r.h0().o(j3, g16, 1);
            } else {
                com.tencent.av.r.h0().g(j3, str2, 1, false);
                com.tencent.av.r.h0().r(str2, 248);
                com.tencent.av.r.h0().j2(248);
                com.tencent.av.r.h0().q(str2, 1);
            }
            QAVNotification l3 = QAVNotification.l(videoAppInterface);
            if (l3 != null) {
                l3.f(str);
            }
        }

        public void b(long j3, VideoAppInterface videoAppInterface, String str, int i3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.i("QAVNotifyActionMonitor", 2, "rejectMultiChat, session[" + str + "], relationType[" + i3 + "], groupId[" + j16 + "], seq[" + j3 + "]");
            }
            TraeHelper.n0(videoAppInterface);
            com.tencent.av.r.h0().P0(j3, i3, j16);
            QAVNotification l3 = QAVNotification.l(videoAppInterface);
            if (l3 != null) {
                l3.f(str);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VideoAppInterface N;
            ChatRoomMng D;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            long a16 = at.a(intent);
            if (QLog.isColorLevel()) {
                QLog.i("QAVNotifyActionMonitor", 2, "onReceive action[" + action + "], seq[" + a16 + "]");
            }
            if ("com.tencent.qav.notify.refuse".equals(action)) {
                String stringExtra = intent.getStringExtra(ServiceConst.PARA_SESSION_ID);
                SessionInfo i3 = com.tencent.av.n.e().i(stringExtra);
                if (QLog.isColorLevel()) {
                    QLog.i("QAVNotifyActionMonitor", 2, "refuse call session[" + stringExtra + "], info[" + i3 + "], seq[" + a16 + "]");
                }
                if (i3 != null) {
                    VideoAppInterface videoAppInterface = this.f72998a.get();
                    if (com.tencent.av.n.l(i3)) {
                        if (!i3.f73060o0) {
                            RtcNodeReportReceiverHelper.s(intent.getStringExtra("traceId"), 2, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
                        }
                        a(a16, videoAppInterface, i3.f73030h, i3.f73091w, i3.f73060o0);
                    } else {
                        b(a16, videoAppInterface, stringExtra, i3.S0, i3.P0);
                    }
                }
                ReportController.o(null, "dc00898", "", "", "0X800A2C7", "0X800A2C7", 0, 0, "", "", "", "");
                return;
            }
            if ("tencent.video.q2v.ptusoDownloadRet".equals(action)) {
                uv.b.l(intent);
                return;
            }
            int i16 = 0;
            if ("tencent.video.q2v.avReceivePushMsg".equals(action)) {
                String stringExtra2 = intent.getStringExtra("msg_key");
                int intExtra = intent.getIntExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, 0);
                byte[] byteArrayExtra = intent.getByteArrayExtra("msg_content");
                if (TextUtils.equals(stringExtra2, "avChatRoom") && (N = VideoAppInterface.N()) != null && (D = N.D()) != null) {
                    D.q(intExtra, byteArrayExtra);
                }
                if (QLog.isDevelopLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("ACTION_AV_RECEIVE_PUSH_MSG , key[");
                    sb5.append(stringExtra2);
                    sb5.append("], msgType[");
                    sb5.append(intExtra);
                    sb5.append("], msgContent[");
                    if (byteArrayExtra != null) {
                        i16 = byteArrayExtra.length;
                    }
                    sb5.append(i16);
                    sb5.append("]");
                    QLog.i("ChatRoomMng", 4, sb5.toString());
                    return;
                }
                return;
            }
            if ("com.tencent.qqhead.getheadresp2".equals(action)) {
                final String stringExtra3 = intent.getStringExtra("uin");
                if (QLog.isDevelopLevel()) {
                    QLog.i("QavAvatarHelper", 4, "ACTION_ON_UPDATE_FRIEND_HEAD, uin = " + stringExtra3);
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.app.QAVNotifyActionMonitor.QAVNotifyActionReceiver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QavAvatarHelper.k().d(stringExtra3);
                    }
                }, 16, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QAVNotifyActionMonitor(VideoAppInterface videoAppInterface) {
        this.f72995a = videoAppInterface;
        this.f72996b = new QAVNotifyActionReceiver(videoAppInterface);
    }

    public void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.qav.notify.accept");
        intentFilter.addAction("com.tencent.qav.notify.refuse");
        intentFilter.addAction("tencent.video.q2v.ptusoDownloadRet");
        intentFilter.addAction("tencent.video.q2v.avReceivePushMsg");
        intentFilter.addAction("com.tencent.qqhead.getheadresp2");
        this.f72995a.getApplication().registerReceiver(this.f72996b, intentFilter);
        this.f72997c = true;
        if (QLog.isColorLevel()) {
            QLog.i("QAVNotifyActionMonitor", 2, "register");
        }
    }

    public void b() {
        if (this.f72997c) {
            this.f72995a.getApplication().unregisterReceiver(this.f72996b);
            this.f72997c = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QAVNotifyActionMonitor", 2, "unRegister");
        }
    }
}
