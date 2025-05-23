package com.tencent.aelight.camera.aebase;

import android.content.Intent;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.widget.m;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qmethod.pandoraex.monitor.CameraMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QFaceUnlockCameraCaptureUnit extends AEPituCameraUnit {
    private MediaRecorder A1;
    private TextView B1;
    private TextView C1;
    private LinearLayout D1;
    private RelativeLayout E1;
    private m F1;
    private int G1;
    private int H1;
    private String I1;
    private Runnable J1;
    private View K1;
    private View L1;
    private View M1;

    /* renamed from: v1, reason: collision with root package name */
    private String f66008v1;

    /* renamed from: w1, reason: collision with root package name */
    private Button f66009w1;

    /* renamed from: x1, reason: collision with root package name */
    private int f66010x1;

    /* renamed from: y1, reason: collision with root package name */
    private int f66011y1;

    /* renamed from: z1, reason: collision with root package name */
    private Handler f66012z1;

    public QFaceUnlockCameraCaptureUnit(or.e eVar, or.d dVar) {
        super(eVar, dVar);
        this.f66011y1 = 0;
        this.G1 = 155;
        this.H1 = 211;
        this.J1 = new Runnable() { // from class: com.tencent.aelight.camera.aebase.QFaceUnlockCameraCaptureUnit.1
            @Override // java.lang.Runnable
            public void run() {
                if (QFaceUnlockCameraCaptureUnit.this.f66010x1 != 1) {
                    return;
                }
                QFaceUnlockCameraCaptureUnit.this.f66011y1++;
                QFaceUnlockCameraCaptureUnit.this.f66012z1.postDelayed(this, 1000L);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G3(boolean z16) {
        MediaRecorder mediaRecorder = this.A1;
        if (mediaRecorder != null) {
            mediaRecorder.setPreviewDisplay(null);
            this.A1.setOnErrorListener(null);
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("QFaceUnlockCameraCaptureUnit", 2, "releaseRecord begin");
                }
                this.A1.release();
                if (z16) {
                    this.f66012z1.post(new Runnable() { // from class: com.tencent.aelight.camera.aebase.QFaceUnlockCameraCaptureUnit.4
                        @Override // java.lang.Runnable
                        public void run() {
                            Intent intent = new Intent();
                            intent.setAction("com.tencent.mobileqq.FaceUnblockCameraJsApiPlugin");
                            if (QFaceUnlockCameraCaptureUnit.this.f66011y1 > 10) {
                                intent.putExtra("recording_time_out", true);
                            }
                            intent.putExtra("target_media_url", QFaceUnlockCameraCaptureUnit.this.I1);
                            intent.setPackage(BaseApplication.getContext().getPackageName());
                            QFaceUnlockCameraCaptureUnit.this.z().sendBroadcast(intent);
                            QFaceUnlockCameraCaptureUnit.this.z().finish();
                            QFaceUnlockCameraCaptureUnit.this.z().overridePendingTransition(R.anim.f154548b2, R.anim.f154959fi);
                        }
                    });
                }
                if (QLog.isColorLevel()) {
                    QLog.i("QFaceUnlockCameraCaptureUnit", 2, "releaseRecord end");
                }
            } catch (IllegalStateException e16) {
                QLog.e("QFaceUnlockCameraCaptureUnit", 1, "releaseRecord failed, IllegalStateException: " + e16.getMessage());
            } catch (Exception e17) {
                QLog.e("QFaceUnlockCameraCaptureUnit", 1, "releaseRecord failed, Exception: " + e17.getMessage());
            }
        }
        this.A1 = null;
    }

    private void I3() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aebase.QFaceUnlockCameraCaptureUnit.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.i("QFaceUnlockCameraCaptureUnit", 2, "startRecord begin");
                    }
                    if (QFaceUnlockCameraCaptureUnit.this.A1 == null) {
                        QFaceUnlockCameraCaptureUnit.this.A1 = new MediaRecorder();
                    }
                    if (CameraControl.u().f288082c != null) {
                        Camera.Parameters parameters = CameraControl.u().f288082c.getParameters();
                        Camera.Size F3 = QFaceUnlockCameraCaptureUnit.this.F3(parameters.getSupportedPreviewSizes(), parameters.getSupportedVideoSizes());
                        CameraControl.u().f288082c.unlock();
                        QFaceUnlockCameraCaptureUnit.this.A1.setOrientationHint(270);
                        QFaceUnlockCameraCaptureUnit.this.A1.reset();
                        QFaceUnlockCameraCaptureUnit.this.A1.setCamera(CameraControl.u().f288082c);
                        AudioMonitor.setAudioSource(QFaceUnlockCameraCaptureUnit.this.A1, 0);
                        CameraMonitor.setVideoSource(QFaceUnlockCameraCaptureUnit.this.A1, 1);
                        QFaceUnlockCameraCaptureUnit.this.A1.setOutputFormat(2);
                        QFaceUnlockCameraCaptureUnit.this.A1.setVideoSize(F3.width, F3.height);
                        QFaceUnlockCameraCaptureUnit.this.A1.setVideoEncoder(2);
                        QFaceUnlockCameraCaptureUnit.this.A1.setAudioEncoder(3);
                        QFaceUnlockCameraCaptureUnit.this.A1.setVideoEncodingBitRate(5242880);
                        QFaceUnlockCameraCaptureUnit.this.I1 = ShortVideoUtils.getLocalShortVideoPath();
                        QFaceUnlockCameraCaptureUnit.this.A1.setOutputFile(QFaceUnlockCameraCaptureUnit.this.I1);
                        QFaceUnlockCameraCaptureUnit.this.A1.prepare();
                        AudioMonitor.start(QFaceUnlockCameraCaptureUnit.this.A1);
                        QFaceUnlockCameraCaptureUnit.this.f66012z1.postDelayed(QFaceUnlockCameraCaptureUnit.this.J1, 1000L);
                        if (QLog.isColorLevel()) {
                            QLog.i("QFaceUnlockCameraCaptureUnit", 2, "startRecord end");
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("QFaceUnlockCameraCaptureUnit", 1, "startRecord fail, Exception:" + e16.getMessage());
                    QFaceUnlockCameraCaptureUnit.this.G3(false);
                }
            }
        });
    }

    private void J3(final boolean z16) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aebase.QFaceUnlockCameraCaptureUnit.3
            @Override // java.lang.Runnable
            public void run() {
                if (QFaceUnlockCameraCaptureUnit.this.A1 != null) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.i("QFaceUnlockCameraCaptureUnit", 2, "stopRecord begin");
                        }
                        QFaceUnlockCameraCaptureUnit.this.A1.stop();
                        QFaceUnlockCameraCaptureUnit.this.A1.reset();
                        if (QLog.isColorLevel()) {
                            QLog.i("QFaceUnlockCameraCaptureUnit", 2, "stopRecord end");
                        }
                    } catch (IllegalStateException e16) {
                        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "stopRecord failed, IllegalStateException: " + e16.getMessage());
                    } catch (RuntimeException e17) {
                        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "stopRecord failed, RuntimeException: " + e17.getMessage());
                    } catch (Exception e18) {
                        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "stopRecord failed, Exception: " + e18.getMessage());
                    }
                }
                QFaceUnlockCameraCaptureUnit.this.G3(z16);
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected int K() {
        return R.layout.dns;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.AEBaseCameraUnit
    public xp.a P() {
        xp.a P = super.P();
        P.o(1);
        return P;
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.AEBaseCameraUnit
    protected boolean W() {
        return false;
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit
    public void c3() {
        H3();
        this.L1.setVisibility(8);
        this.K1.setVisibility(8);
        this.M1.setVisibility(8);
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityPause() {
        super.onActivityPause();
        if (QLog.isColorLevel()) {
            QLog.i("QFaceUnlockCameraCaptureUnit", 2, "onActivityPause");
        }
        J3(false);
        this.f66012z1.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.i("QFaceUnlockCameraCaptureUnit", 2, "onActivityResult");
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResume() {
        super.onActivityResume();
        if (QLog.isColorLevel()) {
            QLog.i("QFaceUnlockCameraCaptureUnit", 2, "onActivityResume");
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.q
    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.rqg) {
            z().finish();
            z().overridePendingTransition(R.anim.f154548b2, R.anim.f154959fi);
        } else {
            super.onClick(view);
            if (view.getId() == R.id.f163778rz0) {
                int i3 = this.f66010x1;
                if (i3 == 0) {
                    this.f66010x1 = 1;
                    this.f66009w1.setText(R.string.ixx);
                    this.C1.setVisibility(0);
                    this.D1.setVisibility(0);
                    this.B1.setVisibility(8);
                    I3();
                } else if (i3 == 1) {
                    this.f66009w1.setEnabled(false);
                    this.f66010x1 = 2;
                    J3(true);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onCreate(Bundle bundle) {
        z().getWindow().setFlags(1024, 1024);
        z().requestWindowFeature(1);
        super.onCreate(bundle);
        this.f66008v1 = this.f61817h.getActivity().getIntent().getStringExtra("key_face_unlock_code");
        this.f66012z1 = new Handler();
        if (TextUtils.isEmpty(this.f66008v1)) {
            this.f66008v1 = "6978";
            QLog.e("QFaceUnlockCameraCaptureUnit", 1, "verification code is null, use default code");
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onDestroy() {
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.i("QFaceUnlockCameraCaptureUnit", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.ae.AEBaseCameraUnit, com.tencent.aelight.camera.ae.q
    public View q(ViewGroup viewGroup) {
        View q16 = super.q(viewGroup);
        ((TextView) q16.findViewById(R.id.rqg)).setOnClickListener(this);
        this.f66009w1 = (Button) q16.findViewById(R.id.f163778rz0);
        this.M1 = q16.findViewById(R.id.rru);
        this.L1 = q16.findViewById(R.id.rts);
        this.K1 = q16.findViewById(R.id.rqx);
        this.B1 = (TextView) this.D.findViewById(R.id.f163790s11);
        this.D1 = (LinearLayout) this.D.findViewById(R.id.rzj);
        this.C1 = (TextView) this.D.findViewById(R.id.rt9);
        this.E1 = (RelativeLayout) q16.findViewById(R.id.rt6);
        c3();
        this.f66010x1 = 0;
        this.f66009w1.setEnabled(false);
        this.f66009w1.setText(R.string.ixu);
        this.f66009w1.setOnClickListener(this);
        this.f66011y1 = 0;
        int f16 = BaseAIOUtils.f(this.G1, z().getResources());
        m mVar = new m();
        this.F1 = mVar;
        mVar.e(BaseAIOUtils.f(this.G1 + this.H1, z().getResources()));
        this.F1.f(f16);
        this.F1.c(1);
        this.E1.setBackground(this.F1);
        this.C1.setText(this.f66008v1);
        return q16;
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit
    public void w2(boolean z16, String str) {
        super.w2(z16, str);
        if (z16) {
            this.f66009w1.setEnabled(true);
        } else {
            QLog.e("QFaceUnlockCameraCaptureUnit", 1, "Camera start fail!");
        }
    }

    private void H3() {
        this.f66010x1 = 0;
        this.f66009w1.setText(R.string.ixu);
        this.f66009w1.setVisibility(0);
        this.f66009w1.setEnabled(false);
        this.f66011y1 = 0;
        this.C1.setVisibility(8);
        this.D1.setVisibility(8);
        this.B1.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Camera.Size F3(List<Camera.Size> list, List<Camera.Size> list2) {
        int i3;
        Camera.Size size = null;
        if (list != null && list2 != null) {
            HashSet hashSet = new HashSet(list);
            int i16 = -1;
            for (Camera.Size size2 : list2) {
                if (hashSet.contains(size2) && (i3 = size2.width * size2.height) > i16) {
                    size = size2;
                    i16 = i3;
                }
            }
        }
        return size;
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit
    public void c(boolean z16) {
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.aebase.view.AbsAECaptureButton.a
    public void a() {
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit, com.tencent.aelight.camera.aebase.view.AbsAECaptureButton.a
    public void h() {
    }

    @Override // com.tencent.aelight.camera.ae.AEPituCameraUnit
    protected void n1() {
    }
}
