package com.tencent.av.ui.api.impl;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.aj;
import com.tencent.av.ui.api.IAVVideoRecordBizApi;
import com.tencent.av.ui.funchat.record.QavRecordButtonView;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.at;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AVVideoRecordBizApiImpl implements IAVVideoRecordBizApi {
    public static final int MSG_RECORD_SHOW_BTN = 272;
    private static final String TAG = "VideoRecordBizHelper";
    private WeakReference<AVActivity> mAVActivity;
    private QavRecordButtonView mRecordButton;
    private QavVideoRecordUICtrl mRecordUiCtrl = null;
    private Handler mHandler = new a();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends Handler {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 272) {
                long c16 = at.c(message.obj);
                if (AVVideoRecordBizApiImpl.this.mAVActivity != null) {
                    AVVideoRecordBizApiImpl.this.showRecordBtn(((AVActivity) AVVideoRecordBizApiImpl.this.mAVActivity.get()).e3(), c16, "handleMessage", true);
                }
                if (AVVideoRecordBizApiImpl.this.mRecordUiCtrl != null) {
                    AVVideoRecordBizApiImpl.this.mRecordUiCtrl.B0();
                }
                if (AVVideoRecordBizApiImpl.this.mAVActivity != null) {
                    ((AVActivity) AVVideoRecordBizApiImpl.this.mAVActivity.get()).R2(-1031L);
                    return;
                }
                return;
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onResume$0(Object obj) {
        ((ControlUIObserver) obj).z("self", String.valueOf(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRecordBtn(SessionInfo sessionInfo, long j3, String str, boolean z16) {
        QavRecordButtonView qavRecordButtonView = this.mRecordButton;
        if (qavRecordButtonView != null) {
            int i3 = z16 ? 0 : 8;
            int visibility = qavRecordButtonView.getVisibility();
            this.mRecordButton.setVisibility(i3);
            if (visibility != i3 && com.tencent.av.utils.e.k()) {
                QLog.w(TAG, 1, "ShowRecordBtn, from[" + str + "], bShown[" + z16 + "], seq[" + j3 + "]");
            }
        }
        if (z16 && sessionInfo != null && sessionInfo.f73024f3) {
            sessionInfo.f73024f3 = false;
            QavVideoRecordUICtrl qavVideoRecordUICtrl = this.mRecordUiCtrl;
            boolean z17 = qavVideoRecordUICtrl != null && qavVideoRecordUICtrl.U();
            boolean X = QavVideoRecordUICtrl.X();
            if (z17 && X) {
                QavRecordReporter.g("0X8008AB2");
            } else {
                QavRecordReporter.g("0X8008AB1");
            }
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public int calcControlUIOffset(SessionInfo sessionInfo) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl;
        if (!sessionInfo.E() || (!(sessionInfo.Y2 || sessionInfo.f73003a3) || (qavVideoRecordUICtrl = this.mRecordUiCtrl) == null || qavVideoRecordUICtrl.T())) {
            return 0;
        }
        return this.mRecordUiCtrl.E();
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void changeUIForDoubleToMulti(SessionInfo sessionInfo, long j3, String str) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl;
        QavVideoRecordUICtrl qavVideoRecordUICtrl2;
        QavRecordButtonView qavRecordButtonView = this.mRecordButton;
        if (qavRecordButtonView != null && qavRecordButtonView.getVisibility() == 0) {
            showRecordBtn(sessionInfo, j3, str, false);
        }
        if (sessionInfo.Y2 && (qavVideoRecordUICtrl2 = this.mRecordUiCtrl) != null) {
            qavVideoRecordUICtrl2.z();
        }
        if (sessionInfo.f73003a3 || !((qavVideoRecordUICtrl = this.mRecordUiCtrl) == null || qavVideoRecordUICtrl.M() == 1)) {
            sessionInfo.f73003a3 = false;
            QavVideoRecordUICtrl qavVideoRecordUICtrl3 = this.mRecordUiCtrl;
            if (qavVideoRecordUICtrl3 != null) {
                qavVideoRecordUICtrl3.y();
            }
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void changeVideoLayoutMode(Activity activity) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl = this.mRecordUiCtrl;
        if (qavVideoRecordUICtrl == null || !(activity instanceof AVActivity)) {
            return;
        }
        AVActivity aVActivity = (AVActivity) activity;
        qavVideoRecordUICtrl.t0(aVActivity.J0.N0(), aVActivity.I0, this.mRecordUiCtrl.P());
        QavVideoRecordUICtrl qavVideoRecordUICtrl2 = this.mRecordUiCtrl;
        qavVideoRecordUICtrl2.r0(qavVideoRecordUICtrl2.P());
        QavVideoRecordUICtrl qavVideoRecordUICtrl3 = this.mRecordUiCtrl;
        qavVideoRecordUICtrl3.x0(qavVideoRecordUICtrl3.P());
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void finish(SessionInfo sessionInfo) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl;
        if (!sessionInfo.Y2 || (qavVideoRecordUICtrl = this.mRecordUiCtrl) == null) {
            return;
        }
        qavVideoRecordUICtrl.z();
        sessionInfo.f73007b3 = this.mRecordUiCtrl.K() >= 1000 ? 1 : 2;
        DataReport.T(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void handleVideoOrientationChanged(int i3) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl = this.mRecordUiCtrl;
        if (qavVideoRecordUICtrl != null) {
            qavVideoRecordUICtrl.s0(i3);
            this.mRecordUiCtrl.A0();
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void init(Activity activity) {
        if (activity instanceof AVActivity) {
            this.mAVActivity = new WeakReference<>((AVActivity) activity);
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void initRecordUiCtrl(Activity activity, long j3) {
        AVActivity aVActivity = activity instanceof AVActivity ? (AVActivity) activity : null;
        ViewStub viewStub = (ViewStub) activity.findViewById(R.id.f30220nr);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.mRecordButton = (QavRecordButtonView) activity.findViewById(R.id.i3q);
        if (aVActivity == null || r.h0() == null || aVActivity.isDestroyed()) {
            return;
        }
        showRecordBtn(n.e().f(), j3, "onCreateUI", false);
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void initVideoLayerUI(Activity activity) {
        if (this.mRecordUiCtrl == null) {
            initRecordUiCtrl(activity);
        }
        if (activity instanceof AVActivity) {
            ((AVActivity) activity).J0.d1(this.mRecordUiCtrl);
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public boolean isEnableRecord() {
        QavVideoRecordUICtrl qavVideoRecordUICtrl = this.mRecordUiCtrl;
        return qavVideoRecordUICtrl != null && qavVideoRecordUICtrl.R();
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void onCloseSessionFinished() {
        QavVideoRecordUICtrl qavVideoRecordUICtrl = this.mRecordUiCtrl;
        if (qavVideoRecordUICtrl == null || qavVideoRecordUICtrl.M() == 1) {
            return;
        }
        this.mRecordUiCtrl.y();
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void onDestroy(SessionInfo sessionInfo) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(272);
        }
        if (sessionInfo != null && sessionInfo.Y2 && (qavVideoRecordUICtrl = this.mRecordUiCtrl) != null) {
            qavVideoRecordUICtrl.z();
        }
        QavVideoRecordUICtrl qavVideoRecordUICtrl2 = this.mRecordUiCtrl;
        if (qavVideoRecordUICtrl2 != null) {
            qavVideoRecordUICtrl2.a0();
            this.mRecordUiCtrl = null;
        }
        QavRecordButtonView qavRecordButtonView = this.mRecordButton;
        if (qavRecordButtonView != null) {
            qavRecordButtonView.e();
            this.mRecordButton = null;
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void onPauseVideo(Activity activity, SessionInfo sessionInfo, long j3) {
        ICameraManagerApi iCameraManagerApi;
        if (activity instanceof AVActivity) {
            AVActivity aVActivity = (AVActivity) activity;
            if (r.h0() == null || aVActivity.isDestroyed() || this.mRecordUiCtrl == null || (iCameraManagerApi = aVActivity.K0) == null) {
                return;
            }
            boolean z16 = sessionInfo.X;
            boolean isCameraOpened = iCameraManagerApi.isCameraOpened(j3);
            boolean z17 = sessionInfo.O;
            boolean z18 = sessionInfo.Y2;
            boolean z19 = sessionInfo.f73003a3;
            QLog.w(TAG, 1, "onPauseVideo, hangup[" + z16 + "], cameraOpen[" + isCameraOpened + "], remoteHasVideo[" + z17 + "], recording[" + z18 + "], recordedByOther[" + z19 + "]");
            if (z16 || !z17) {
                if (!z18) {
                    if (z19) {
                        this.mRecordUiCtrl.y();
                        return;
                    }
                    return;
                }
                this.mRecordUiCtrl.z();
                r.h0().T1();
                if (z16) {
                    return;
                }
                QavRecordReporter.g("0X8008ACB");
                VideoAppInterface videoAppInterface = aVActivity.H0;
                if (videoAppInterface != null) {
                    cw.e.o(videoAppInterface, 1023, R.string.dhi);
                }
            }
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void onPeerSwitchTerminal(Activity activity) {
        ControlUIObserver controlUIObserver;
        if (activity instanceof AVActivity) {
            AVActivity aVActivity = (AVActivity) activity;
            QavVideoRecordUICtrl.p0(r.h0());
            if (r.h0() == null || aVActivity.isDestroyed()) {
                return;
            }
            boolean z16 = n.e().f().Y2;
            boolean z17 = n.e().f().f73003a3;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onPeerSwitchTerminal, recording=" + z16 + ", beenRecorded=" + z17);
            }
            if (z16) {
                QavVideoRecordUICtrl qavVideoRecordUICtrl = this.mRecordUiCtrl;
                if (qavVideoRecordUICtrl != null) {
                    qavVideoRecordUICtrl.z();
                }
                r.h0().T1();
            } else if (z17 && (controlUIObserver = aVActivity.U0) != null) {
                controlUIObserver.z("self", String.valueOf(3));
            }
            n.e().f().X2 = false;
            QavVideoRecordUICtrl qavVideoRecordUICtrl2 = this.mRecordUiCtrl;
            if (qavVideoRecordUICtrl2 != null) {
                qavVideoRecordUICtrl2.B0();
            }
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void onResume(SessionInfo sessionInfo, final Object obj) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl;
        int i3 = sessionInfo.f73035i;
        if ((i3 == 2 || i3 == 1) && (qavVideoRecordUICtrl = this.mRecordUiCtrl) != null && qavVideoRecordUICtrl.M() == 1 && sessionInfo.f73003a3) {
            this.mHandler.post(new Runnable() { // from class: com.tencent.av.ui.api.impl.h
                @Override // java.lang.Runnable
                public final void run() {
                    AVVideoRecordBizApiImpl.lambda$onResume$0(obj);
                }
            });
        }
        if (sessionInfo.f73007b3 != 0) {
            if (this.mAVActivity.get() != null) {
                if (sessionInfo.f73007b3 == 1) {
                    QQToast.makeText(this.mAVActivity.get(), 2, this.mAVActivity.get().getResources().getString(R.string.dhp), 0).show();
                } else {
                    cw.e.o(this.mAVActivity.get().H0, 1023, R.string.f171255di0);
                    QavRecordReporter.g("0X8008AB0");
                }
            }
            sessionInfo.f73007b3 = 0;
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void onStop(SessionInfo sessionInfo) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl;
        if (!sessionInfo.Y2 || (qavVideoRecordUICtrl = this.mRecordUiCtrl) == null) {
            return;
        }
        qavVideoRecordUICtrl.z();
        sessionInfo.f73007b3 = this.mRecordUiCtrl.K() >= 1000 ? 1 : 2;
        DataReport.T(null, "CliOper", "", "", "0X800863D", "0X800863D", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void receiveEffect(int i3) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl = this.mRecordUiCtrl;
        if (qavVideoRecordUICtrl != null) {
            qavVideoRecordUICtrl.c0(i3);
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void receiveRecordMsg(String str, String str2) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl = this.mRecordUiCtrl;
        if (qavVideoRecordUICtrl != null) {
            qavVideoRecordUICtrl.d0(str, str2);
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void resetControlUI(Object obj) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl = this.mRecordUiCtrl;
        if (qavVideoRecordUICtrl != null) {
            qavVideoRecordUICtrl.m0((aj) obj);
        }
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void tryShowRecordBtn(SessionInfo sessionInfo, long j3, String str, boolean z16, int i3) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl;
        int i16;
        boolean z17 = true;
        if (QLog.isColorLevel()) {
            QavRecordButtonView qavRecordButtonView = this.mRecordButton;
            if (qavRecordButtonView != null) {
                i16 = qavRecordButtonView.getVisibility() == 0 ? 1 : 0;
            } else {
                i16 = -1;
            }
            QLog.w(TAG, 1, "tryShowRecordBtn[" + str + "], bShown[" + z16 + "], visibility[" + i16 + "], seq[" + j3 + "]");
        }
        if (!QavVideoRecordUICtrl.S() && (qavVideoRecordUICtrl = this.mRecordUiCtrl) != null) {
            int i17 = sessionInfo.f73035i;
            if (i17 != 1 && i17 != 2) {
                z17 = false;
            }
            if (!z16) {
                if (z17) {
                    if (sessionInfo.f73003a3) {
                        qavVideoRecordUICtrl.s0(0);
                        this.mRecordUiCtrl.A0();
                        this.mRecordUiCtrl.q();
                    }
                    this.mHandler.removeMessages(272);
                    showRecordBtn(sessionInfo, j3, "tryShowRecordBtn.2", false);
                    return;
                }
                return;
            }
            if (z17 && sessionInfo.f73003a3) {
                qavVideoRecordUICtrl.s0(i3);
                this.mRecordUiCtrl.A0();
            }
            if (!z17) {
                QavRecordButtonView qavRecordButtonView2 = this.mRecordButton;
                if (qavRecordButtonView2 == null || qavRecordButtonView2.getVisibility() != 0) {
                    return;
                }
                this.mHandler.removeMessages(272);
                showRecordBtn(sessionInfo, j3, "tryShowRecordBtn.1", false);
                return;
            }
            this.mHandler.removeMessages(272);
            Message obtainMessage = this.mHandler.obtainMessage(272);
            obtainMessage.obj = Long.valueOf(j3);
            this.mHandler.sendMessageDelayed(obtainMessage, 50L);
            return;
        }
        QavRecordButtonView qavRecordButtonView3 = this.mRecordButton;
        if (qavRecordButtonView3 == null || qavRecordButtonView3.getVisibility() == 8) {
            return;
        }
        this.mRecordButton.setVisibility(8);
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void updateRecordButton() {
        QavVideoRecordUICtrl qavVideoRecordUICtrl;
        QavRecordButtonView qavRecordButtonView = this.mRecordButton;
        if (qavRecordButtonView == null || qavRecordButtonView.getVisibility() != 0 || (qavVideoRecordUICtrl = this.mRecordUiCtrl) == null) {
            return;
        }
        qavVideoRecordUICtrl.B0();
    }

    @Override // com.tencent.av.ui.api.IAVVideoRecordBizApi
    public void onVideoClose(SessionInfo sessionInfo, int i3) {
        QavVideoRecordUICtrl qavVideoRecordUICtrl;
        if (i3 != 49 || sessionInfo == null || !sessionInfo.Y2 || (qavVideoRecordUICtrl = this.mRecordUiCtrl) == null) {
            return;
        }
        qavVideoRecordUICtrl.z();
    }

    private void initRecordUiCtrl(Activity activity) {
        if (!QavVideoRecordUICtrl.X()) {
            QLog.e(TAG, 1, "initRecordUiCtrl failed for System not Support.");
            return;
        }
        AVActivity aVActivity = activity instanceof AVActivity ? (AVActivity) activity : null;
        ((ViewStub) activity.findViewById(R.id.f30390o8)).inflate();
        RelativeLayout relativeLayout = (RelativeLayout) activity.findViewById(R.id.ktg);
        if (relativeLayout == null || aVActivity == null) {
            return;
        }
        QavVideoRecordUICtrl qavVideoRecordUICtrl = new QavVideoRecordUICtrl(aVActivity, relativeLayout, aVActivity.I0);
        this.mRecordUiCtrl = qavVideoRecordUICtrl;
        qavVideoRecordUICtrl.v0(1);
        VideoLayerUI videoLayerUI = aVActivity.J0;
        if (videoLayerUI != null) {
            videoLayerUI.d1(this.mRecordUiCtrl);
        }
    }
}
