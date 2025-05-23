package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent;
import com.tencent.aelight.camera.ae.n;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.tips.AETipsManager;
import java.util.HashMap;
import mqq.util.WeakReference;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AETipsViewController {

    /* renamed from: a, reason: collision with root package name */
    private AEPituCameraUnit f63276a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.mode.c f63277b;

    /* renamed from: e, reason: collision with root package name */
    private boolean f63280e;

    /* renamed from: k, reason: collision with root package name */
    private View f63286k;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.tips.b f63287l;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.tips.a f63288m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.camera.ui.tips.c f63289n;

    /* renamed from: o, reason: collision with root package name */
    private final ViewStub f63290o;

    /* renamed from: p, reason: collision with root package name */
    private PAGView f63291p;

    /* renamed from: q, reason: collision with root package name */
    private ARCakeTipsViewStubHolder f63292q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f63293r;

    /* renamed from: s, reason: collision with root package name */
    private String f63294s;

    /* renamed from: t, reason: collision with root package name */
    private String f63295t;

    /* renamed from: u, reason: collision with root package name */
    private Bitmap f63296u;

    /* renamed from: v, reason: collision with root package name */
    private VideoMaterial f63297v;

    /* renamed from: c, reason: collision with root package name */
    private AECaptureMode f63278c = AECaptureMode.NORMAL;

    /* renamed from: d, reason: collision with root package name */
    private Handler f63279d = new d(this);

    /* renamed from: f, reason: collision with root package name */
    private boolean f63281f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f63282g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f63283h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f63284i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f63285j = false;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<AETipsViewController> f63301a;

        public d(AETipsViewController aETipsViewController) {
            this.f63301a = new WeakReference<>(aETipsViewController);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f63301a.get() != null && this.f63301a.get().f63286k.getContext() == null && (this.f63301a.get().f63286k.getContext() instanceof Activity) && !((Activity) this.f63301a.get().f63286k.getContext()).isFinishing() && !((Activity) this.f63301a.get().f63286k.getContext()).isDestroyed()) {
                int i3 = message.what;
                if (i3 == 1004 || i3 == 1009) {
                    this.f63301a.get().v();
                    return;
                } else {
                    if (i3 != 1018) {
                        return;
                    }
                    this.f63301a.get().o();
                    return;
                }
            }
            removeCallbacksAndMessages(null);
        }
    }

    public AETipsViewController(View view, com.tencent.aelight.camera.ae.part.c cVar) {
        this.f63286k = view;
        AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
        this.f63276a = aEPituCameraUnit;
        this.f63277b = (com.tencent.aelight.camera.ae.mode.c) n.a(aEPituCameraUnit).get(com.tencent.aelight.camera.ae.mode.c.class);
        this.f63287l = new com.tencent.aelight.camera.ae.camera.ui.tips.b((ViewStub) view.findViewById(R.id.s1c));
        this.f63288m = new com.tencent.aelight.camera.ae.camera.ui.tips.a((ViewStub) view.findViewById(R.id.s1d));
        this.f63289n = new com.tencent.aelight.camera.ae.camera.ui.tips.c((ViewStub) view.findViewById(R.id.s1q));
        this.f63292q = new ARCakeTipsViewStubHolder((ViewStub) view.findViewById(R.id.s1v));
        this.f63290o = (ViewStub) view.findViewById(R.id.s1o);
        this.f63277b.f65622i.observe(this.f63276a, new a());
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(PTFaceAttr.PTExpression.MOUTH_OPEN.value), "\u5f20\u5f00\u4f60\u7684\u5634");
        hashMap.put(Integer.valueOf(PTFaceAttr.PTExpression.EYEBROWS_RAISE.value), "\u6311\u52a8\u4f60\u7684\u7709\u6bdb");
        hashMap.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK.value), "\u7728\u7728\u4f60\u7684\u773c\u775b");
        hashMap.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_SHAKE.value), "\u6447\u4e00\u6447\u4f60\u7684\u5934");
        hashMap.put(Integer.valueOf(PTFaceAttr.PTExpression.KISS.value), "\u561f\u8d77\u4f60\u7684\u5634");
        hashMap.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK_LEFT_EYE.value), "\u7728\u7728\u4f60\u7684\u5de6\u773c");
        hashMap.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK_RIGHT_EYE.value), "\u7728\u7728\u4f60\u7684\u53f3\u773c");
        hashMap.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_NOD.value), "\u70b9\u4e00\u70b9\u4f60\u7684\u5934");
        hashMap.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_SHAKE_NEW.value), "\u6447\u4e00\u6447\u4f60\u7684\u5934");
        hashMap.put(Integer.valueOf(PTFaceAttr.PTExpression.TRY_CLICK_SCREEN.value), "\u70b9\u51fb\u5c4f\u5e55\u8bd5\u8bd5");
        AETipsManager.getInstance().updateActionTipsString(hashMap);
    }

    private void g() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.tips.AETipsViewController.2
            @Override // java.lang.Runnable
            public void run() {
                AETipsViewController.this.h();
            }
        });
    }

    private void u() {
        if (this.f63293r) {
            return;
        }
        this.f63289n.p(this.f63294s, TextUtils.isEmpty(this.f63295t) ? null : this.f63296u, 3000);
        this.f63293r = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.f63297v == null) {
            return;
        }
        this.f63280e = true;
        AECaptureMode aECaptureMode = this.f63278c;
        if (aECaptureMode == AECaptureMode.PLAY) {
            k();
            return;
        }
        if (aECaptureMode == AECaptureMode.NORMAL) {
            this.f63288m.n();
            this.f63287l.show();
        } else if (aECaptureMode == AECaptureMode.GIF) {
            this.f63287l.n();
            this.f63288m.show();
        }
    }

    private void y(VideoMaterial videoMaterial) {
        f();
        if (videoMaterial == null) {
            return;
        }
        this.f63297v = videoMaterial;
        AETipsManager.getInstance().setVideoMaterial(videoMaterial);
    }

    public Handler i() {
        return this.f63279d;
    }

    public void j() {
        this.f63292q.r();
    }

    public void k() {
        this.f63287l.n();
        this.f63288m.n();
        this.f63289n.o();
    }

    public void l() {
        ms.a.a("AETipsViewController", "hideNormalTip: ");
        this.f63289n.o();
    }

    public void m() {
        this.f63287l.o();
        this.f63288m.o();
    }

    public void n() {
        ms.a.a("AETipsViewController", "hidePagTip: ");
        PAGView pAGView = this.f63291p;
        if (pAGView == null) {
            return;
        }
        if (pAGView.isPlaying()) {
            this.f63291p.stop();
        }
        this.f63291p.setVisibility(8);
    }

    public void o() {
        this.f63287l.n();
        this.f63288m.n();
    }

    public void q(boolean z16, boolean z17) {
        this.f63281f = z16;
        this.f63283h = z17;
        if (z16 == this.f63282g && z17 == this.f63284i) {
            return;
        }
        QLog.d("AETipsViewController", 4, "### onDetectStateChange, materialNeedFace=" + z16 + ", hasFaceDetected=" + z17);
        this.f63282g = this.f63281f;
        this.f63284i = this.f63283h;
        g();
    }

    public void s(int i3) {
        this.f63292q.v(i3);
    }

    public void t() {
        this.f63292q.w();
    }

    public void w(String str, String str2, int i3) {
        ms.a.a("AETipsViewController", "showNormalTip: tip=" + str + ", icon=" + str2 + ", duration=" + i3);
        this.f63289n.p(str, BitmapUtils.decodeSampleBitmap(this.f63276a.z(), str2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT), i3);
    }

    public void x(String str, int i3) {
        ms.a.a("AETipsViewController", "showPagTip: pagPath=" + str + ", duration=" + i3);
        if (this.f63291p == null) {
            this.f63291p = (PAGView) this.f63290o.inflate();
        }
        this.f63291p.addPAGFlushListener(new b());
        this.f63291p.setPath(str);
        this.f63291p.setRepeatCount(1);
        this.f63291p.addListener(new c());
        this.f63291p.flush();
        this.f63291p.setProgress(0.0d);
        this.f63291p.setVisibility(0);
        this.f63291p.play();
    }

    private void f() {
        this.f63294s = null;
        this.f63295t = null;
        this.f63296u = null;
        this.f63297v = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f63280e = true;
        AECaptureMode aECaptureMode = this.f63278c;
        if (aECaptureMode == AECaptureMode.PLAY) {
            k();
            return;
        }
        if (aECaptureMode == AECaptureMode.NORMAL) {
            this.f63288m.n();
            VideoMaterial videoMaterial = this.f63297v;
            if (videoMaterial != null && videoMaterial.needFaceInfo()) {
                if (this.f63283h) {
                    this.f63287l.n();
                    u();
                    return;
                }
                return;
            }
            this.f63287l.n();
            u();
            return;
        }
        if (aECaptureMode == AECaptureMode.GIF) {
            this.f63287l.n();
            VideoMaterial videoMaterial2 = this.f63297v;
            if (videoMaterial2 != null && videoMaterial2.needFaceInfo()) {
                if (this.f63283h) {
                    this.f63288m.n();
                    u();
                    return;
                }
                return;
            }
            this.f63288m.n();
            u();
        }
    }

    public void p() {
        QLog.d("AETipsViewController", 4, "### onChangeCameraByMaterial");
        if (this.f63280e) {
            g();
        }
    }

    public void r(VideoMaterial videoMaterial) {
        this.f63293r = false;
        y(videoMaterial);
        g();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Observer<AECaptureModeChangingEvent> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(AECaptureModeChangingEvent aECaptureModeChangingEvent) {
            if (aECaptureModeChangingEvent == null) {
                return;
            }
            AETipsViewController.this.f63278c = aECaptureModeChangingEvent.f65599b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements PAGView.PAGViewListener {
        c() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView pAGView) {
            AETipsViewController.this.f63291p.setVisibility(8);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView pAGView) {
            AETipsViewController.this.f63291p.setVisibility(8);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView pAGView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView pAGView) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView pAGView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements PAGView.PAGFlushListener {
        b() {
        }

        @Override // org.libpag.PAGView.PAGFlushListener
        public void onFlush() {
        }
    }
}
