package com.tencent.aelight.camera.ae.flashshow.tips;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.mode.LSCaptureMode;
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
public class LSTipsViewController {

    /* renamed from: a, reason: collision with root package name */
    private LSMiddleCameraUnit f64376a;

    /* renamed from: d, reason: collision with root package name */
    private boolean f64379d;

    /* renamed from: j, reason: collision with root package name */
    private View f64385j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.flashshow.tips.b f64386k;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.flashshow.tips.a f64387l;

    /* renamed from: m, reason: collision with root package name */
    private d f64388m;

    /* renamed from: n, reason: collision with root package name */
    private final ViewStub f64389n;

    /* renamed from: o, reason: collision with root package name */
    private PAGView f64390o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f64391p;

    /* renamed from: q, reason: collision with root package name */
    private String f64392q;

    /* renamed from: r, reason: collision with root package name */
    private String f64393r;

    /* renamed from: s, reason: collision with root package name */
    private Bitmap f64394s;

    /* renamed from: t, reason: collision with root package name */
    private VideoMaterial f64395t;

    /* renamed from: b, reason: collision with root package name */
    private LSCaptureMode f64377b = LSCaptureMode.NORMAL;

    /* renamed from: c, reason: collision with root package name */
    private Handler f64378c = new c(this);

    /* renamed from: e, reason: collision with root package name */
    private boolean f64380e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f64381f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f64382g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f64383h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f64384i = false;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<LSTipsViewController> f64398a;

        public c(LSTipsViewController lSTipsViewController) {
            this.f64398a = new WeakReference<>(lSTipsViewController);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f64398a.get() != null && this.f64398a.get().f64385j.getContext() == null && (this.f64398a.get().f64385j.getContext() instanceof Activity) && !((Activity) this.f64398a.get().f64385j.getContext()).isFinishing() && !((Activity) this.f64398a.get().f64385j.getContext()).isDestroyed()) {
                int i3 = message.what;
                if (i3 == 1004 || i3 == 1009) {
                    this.f64398a.get().r();
                    return;
                } else {
                    if (i3 != 1018) {
                        return;
                    }
                    this.f64398a.get().m();
                    return;
                }
            }
            removeCallbacksAndMessages(null);
        }
    }

    public LSTipsViewController(View view, lq.b bVar) {
        this.f64385j = view;
        this.f64376a = (LSMiddleCameraUnit) bVar.b(65537, new Object[0]);
        this.f64386k = new com.tencent.aelight.camera.ae.flashshow.tips.b((ViewStub) view.findViewById(R.id.s1c));
        this.f64387l = new com.tencent.aelight.camera.ae.flashshow.tips.a((ViewStub) view.findViewById(R.id.s1d));
        this.f64388m = new d((ViewStub) view.findViewById(R.id.s1q));
        this.f64389n = (ViewStub) view.findViewById(R.id.s1o);
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

    private void f() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.tips.LSTipsViewController.1
            @Override // java.lang.Runnable
            public void run() {
                LSTipsViewController.this.g();
            }
        });
    }

    private void q() {
        if (this.f64391p) {
            return;
        }
        this.f64388m.i(this.f64392q, TextUtils.isEmpty(this.f64393r) ? null : this.f64394s, 3000);
        this.f64391p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.f64395t == null) {
            return;
        }
        this.f64379d = true;
        this.f64387l.g();
        this.f64386k.i();
    }

    private void u(VideoMaterial videoMaterial) {
        e();
        if (videoMaterial == null) {
            return;
        }
        this.f64395t = videoMaterial;
        AETipsManager.getInstance().setVideoMaterial(videoMaterial);
    }

    public Handler h() {
        return this.f64378c;
    }

    public void i() {
        this.f64386k.g();
        this.f64387l.g();
        this.f64388m.h();
    }

    public void j() {
        ms.a.a("LSTipsViewController", "hideNormalTip: ");
        this.f64388m.h();
    }

    public void k() {
        this.f64386k.h();
        this.f64387l.h();
    }

    public void l() {
        ms.a.a("LSTipsViewController", "hidePagTip: ");
        PAGView pAGView = this.f64390o;
        if (pAGView == null) {
            return;
        }
        if (pAGView.isPlaying()) {
            this.f64390o.stop();
        }
        this.f64390o.setVisibility(8);
    }

    public void m() {
        this.f64386k.g();
        this.f64387l.g();
    }

    public void s(String str, String str2, int i3) {
        ms.a.a("LSTipsViewController", "showNormalTip: tip=" + str + ", icon=" + str2 + ", duration=" + i3);
        this.f64388m.i(str, BitmapUtils.decodeSampleBitmap(this.f64376a.A(), str2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT), i3);
    }

    public void t(String str, int i3) {
        ms.a.a("LSTipsViewController", "showPagTip: pagPath=" + str + ", duration=" + i3);
        if (this.f64390o == null) {
            this.f64390o = (PAGView) this.f64389n.inflate();
        }
        this.f64390o.addPAGFlushListener(new a());
        this.f64390o.setPath(str);
        this.f64390o.setRepeatCount(1);
        this.f64390o.addListener(new b());
        this.f64390o.flush();
        this.f64390o.setProgress(0.0d);
        this.f64390o.setVisibility(0);
        this.f64390o.play();
    }

    private void e() {
        this.f64392q = null;
        this.f64393r = null;
        this.f64394s = null;
        this.f64395t = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f64379d = true;
        if (this.f64377b == LSCaptureMode.NORMAL) {
            this.f64387l.g();
            VideoMaterial videoMaterial = this.f64395t;
            if (videoMaterial != null && videoMaterial.needFaceInfo()) {
                if (this.f64382g) {
                    this.f64386k.g();
                    q();
                    return;
                }
                return;
            }
            this.f64386k.g();
            q();
        }
    }

    public void n() {
        QLog.d("LSTipsViewController", 4, "### onChangeCameraByMaterial");
        if (this.f64379d) {
            f();
        }
    }

    public void o() {
        this.f64385j = null;
        this.f64378c = null;
    }

    public void p(VideoMaterial videoMaterial) {
        this.f64391p = false;
        u(videoMaterial);
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements PAGView.PAGViewListener {
        b() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView pAGView) {
            LSTipsViewController.this.f64390o.setVisibility(8);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView pAGView) {
            LSTipsViewController.this.f64390o.setVisibility(8);
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
    public class a implements PAGView.PAGFlushListener {
        a() {
        }

        @Override // org.libpag.PAGView.PAGFlushListener
        public void onFlush() {
        }
    }
}
