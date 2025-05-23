package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.EffectMaterialHandler;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.fragment.NTBaseVideoFragment;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.x;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoUtil;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import fu.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes32.dex */
public class AVVideoLayerUIPart extends Part {

    /* renamed from: m, reason: collision with root package name */
    private static VideoUtil.AnimationTrigger f76248m;

    /* renamed from: d, reason: collision with root package name */
    private VideoLayerUI f76249d;

    /* renamed from: e, reason: collision with root package name */
    protected EffectFilterPanel f76250e;

    /* renamed from: f, reason: collision with root package name */
    private int f76251f = 0;

    /* renamed from: h, reason: collision with root package name */
    GestureDetector f76252h = null;

    /* renamed from: i, reason: collision with root package name */
    View f76253i;

    /* loaded from: classes32.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            GestureDetector gestureDetector = AVVideoLayerUIPart.this.f76252h;
            if (gestureDetector == null) {
                return true;
            }
            gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements Comparator<com.tencent.av.gaudio.c> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.av.gaudio.c cVar, com.tencent.av.gaudio.c cVar2) {
            return (cVar.f73829c || cVar2.f73829c) ? -1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VideoUtil.AnimationTrigger C9() {
        if (f76248m == null) {
            f76248m = new VideoUtil.AnimationTrigger(nw.b.b());
        }
        return f76248m;
    }

    private void D9() {
        ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(R.id.a2f);
        Context context = getContext();
        float dimension = context.getResources().getDimension(R.dimen.a3z);
        float dimension2 = context.getResources().getDimension(R.dimen.f159337a42);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) dimension);
        layoutParams.setMargins(0, (int) dimension2, 0, 0);
        EffectFilterPanel effectFilterPanel = new EffectFilterPanel(context, nw.b.b());
        this.f76250e = effectFilterPanel;
        effectFilterPanel.setLayoutParams(layoutParams);
        viewGroup.addView(this.f76250e, -1);
    }

    private void E9() {
        VideoAppInterface b16 = nw.b.b();
        if (this.f76249d == null && b16 != null) {
            AVActivity aVActivity = (AVActivity) getActivity();
            View findViewById = aVActivity.findViewById(R.id.a2f);
            QLog.d("AVVideoLayerUIPart", 1, "initVideoLayerUI rootView=" + findViewById + " mVideoLayerUI=" + this.f76249d + " this=" + this, new Throwable());
            K9();
            if (findViewById != null) {
                VideoLayerUI videoLayerUI = new VideoLayerUI(b16, getContext(), findViewById);
                this.f76249d = videoLayerUI;
                videoLayerUI.a3(C9());
                aVActivity.W3(this.f76249d);
            }
            if (getPartHost() instanceof NTBaseVideoFragment) {
                ((NTBaseVideoFragment) getPartHost()).Xh(aVActivity);
            }
            J9();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.part.base.AVVideoLayerUIPart.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        boolean isAEResExist = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.LIGHT_RES_BASE_PACKAGE);
                        if (QLog.isColorLevel()) {
                            QLog.i("AVVideoLayerUIPart", 2, "Async load ae res exist:" + isAEResExist);
                        }
                    } catch (Exception unused) {
                        QLog.i("AVVideoLayerUIPart", 2, "Async load ae res exception");
                    }
                }
            }, 64, null, true);
            return;
        }
        QLog.d("AVVideoLayerUIPart", 1, "initVideoLayerUI error..................");
    }

    private void J9() {
        EffectMaterialHandler effectMaterialHandler = (EffectMaterialHandler) nw.b.b().getBusinessHandler(EffectMaterialHandler.class.getName());
        effectMaterialHandler.F2("QQAVSinglePendantV2", "9");
        effectMaterialHandler.F2("QQAVDoublePendantV2", "9");
        effectMaterialHandler.F2("QQAVZPlanAvatar", "9");
    }

    private void L9() {
        if (this.f76250e != null) {
            ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(R.id.a2f);
            this.f76250e.setVisibility(8);
            viewGroup.removeView(this.f76250e);
            this.f76250e = null;
        }
    }

    public void A9() {
        if (this.f76249d != null) {
            return;
        }
        E9();
        VideoLayerUI videoLayerUI = this.f76249d;
        if (videoLayerUI != null) {
            videoLayerUI.F();
        }
    }

    public void B9(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f76252h;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
    }

    public void G9(int i3) {
        if (this.f76250e == null || r.h0() == null) {
            return;
        }
        this.f76250e.e(this.f76249d.N0(), n.e().f().G);
    }

    public void H9(int i3, long j3) {
        if (getActivity().isDestroyed()) {
            return;
        }
        QLog.w("AVVideoLayerUIPart", 1, "OnNotify_Effect_Toolbar_Selected, btnId[" + i3 + "], seq[" + j3 + "]");
        if (i3 == 100) {
            ((NTBaseVideoFragment) getPartHost()).Eh().X0(j3, 0, true);
        }
        if (i3 == 4) {
            boolean V = fu.a.V(getContext());
            a.C10338a.c(V);
            if (V) {
                if (this.f76250e == null) {
                    D9();
                }
                A9();
                VideoLayerUI videoLayerUI = this.f76249d;
                if (videoLayerUI != null) {
                    if (videoLayerUI.o2() != 3 && this.f76249d.o2() != 4) {
                        this.f76249d.o3("onChangeUI_EffectToolbarSelected");
                    }
                    this.f76250e.e(this.f76249d.N0(), n.e().f().G);
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.part.base.AVVideoLayerUIPart.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AVVideoLayerUIPart aVVideoLayerUIPart;
                        EffectFilterPanel effectFilterPanel;
                        if (AVVideoLayerUIPart.this.getActivity().isDestroyed() || (effectFilterPanel = (aVVideoLayerUIPart = AVVideoLayerUIPart.this).f76250e) == null) {
                            return;
                        }
                        effectFilterPanel.setAnimationTrigger(aVVideoLayerUIPart.C9());
                        AVVideoLayerUIPart.this.f76250e.setVisibility(0);
                    }
                });
                return;
            }
            return;
        }
        L9();
    }

    public void I9(long j3) {
        VideoLayerUI videoLayerUI = this.f76249d;
        if (videoLayerUI != null) {
            videoLayerUI.N2();
        }
    }

    public void K9() {
        if (this.f76252h != null) {
            this.f76252h = null;
            this.f76253i.setOnTouchListener(null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        ViewStub viewStub;
        super.onInitView(view);
        this.f76253i = view.findViewById(R.id.a2f);
        try {
            view.findViewById(R.id.a2c).setBackgroundColor(Color.parseColor("#2B2D2F"));
        } catch (OutOfMemoryError e16) {
            QLog.d("AVVideoLayerUIPart", 1, "onCreateUI OutOfMemoryError", e16);
        }
        if (ThemeUtil.isInNightMode(nw.b.b()) && (viewStub = (ViewStub) view.findViewById(R.id.f30210nq)) != null) {
            viewStub.inflate();
            view.findViewById(R.id.m18).setVisibility(0);
        }
        SessionInfo f16 = n.e().f();
        QLog.d("AVVideoLayerUIPart", 1, "onInitView sessionType=" + f16.f73035i);
        int i3 = f16.f73035i;
        if ((i3 != 1 && i3 != 3) || f16.f73060o0) {
            if (this.f76249d == null) {
                E9();
            }
            VideoLayerUI videoLayerUI = this.f76249d;
            if (videoLayerUI != null) {
                videoLayerUI.F();
            }
            QLog.d("AVVideoLayerUIPart", 1, "initVideoLayerUI");
            return;
        }
        this.f76251f = BaseAIOUtils.f(20.0f, getContext().getResources());
        if (this.f76252h == null) {
            this.f76252h = new GestureDetector(getContext(), new c());
        }
        QLog.d("AVVideoLayerUIPart", 1, "setOnTouchListener mVideoLayerView=" + this.f76253i);
        View view2 = this.f76253i;
        if (view2 != null) {
            view2.setOnTouchListener(new a());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        K9();
    }

    public void onPause() {
        VideoLayerUI videoLayerUI = this.f76249d;
        if (videoLayerUI != null) {
            videoLayerUI.W0();
        }
    }

    public void F9(ArrayList<com.tencent.av.gaudio.c> arrayList) {
        int i3;
        if (this.f76249d == null || arrayList == null) {
            return;
        }
        long d16 = com.tencent.av.utils.e.d();
        String I0 = r.h0().I0(arrayList);
        if (QLog.isColorLevel()) {
            QLog.w("AVVideoLayerUIPart", 1, "onChangeUI_CloseVideo, seq[" + d16 + "], infoLogs[" + I0 + "]");
        }
        Collections.sort(arrayList, new b());
        int i16 = 0;
        while (i16 < arrayList.size()) {
            com.tencent.av.gaudio.c cVar = arrayList.get(i16);
            String a16 = com.tencent.av.utils.i.a(cVar.f73827a);
            boolean z16 = cVar.f73829c;
            int i17 = cVar.f73828b;
            VideoAppInterface b16 = nw.b.b();
            if (b16 != null && !a16.equals(b16.getCurrentAccountUin())) {
                if (this.f76249d.L0(a16, i17)) {
                    cw.e.d(b16, 1037);
                }
                VideoLayerUI videoLayerUI = this.f76249d;
                i3 = i16;
                long j3 = cVar.f73833g;
                videoLayerUI.g3(d16, a16, i17, false, z16, j3 == 5 || j3 == 14);
            } else {
                i3 = i16;
                if (cVar.f73828b == 2) {
                    this.f76249d.e3(d16, false, false);
                }
            }
            i16 = i3 + 1;
        }
        L9();
    }

    /* loaded from: classes32.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (r.h0() == null) {
                return false;
            }
            try {
                long d16 = com.tencent.av.utils.e.d();
                if (QLog.isColorLevel()) {
                    QLog.w("AVVideoLayerUIPart", 1, "onSingleTapConfirmed [], seq[" + d16 + "]");
                }
                nw.b.b().k0(new Object[]{110, Long.valueOf(d16)});
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("AVVideoLayerUIPart", 2, "onSingleTapConfirmed --> Exception = " + e16);
                }
                return true;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            float y16;
            float x16;
            float x17;
            AVActivity aVActivity;
            int i3;
            int i16;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            NTBaseVideoFragment nTBaseVideoFragment;
            if (r.h0() != null && motionEvent != null && motionEvent2 != null && (AVVideoLayerUIPart.this.getPartHost() instanceof NTBaseVideoFragment)) {
                AVActivity aVActivity2 = (AVActivity) AVVideoLayerUIPart.this.getActivity();
                NTBaseVideoFragment nTBaseVideoFragment2 = (NTBaseVideoFragment) AVVideoLayerUIPart.this.getPartHost();
                QavPanel Eh = nTBaseVideoFragment2.Eh();
                if (Eh != null && aVActivity2 != null && aVActivity2.f74657h1 != null) {
                    boolean isToolBarDisplay = ((mw.j) RFWIocAbilityProvider.g().getIocInterface(mw.j.class, AVVideoLayerUIPart.this.getPartRootView(), null)).isToolBarDisplay();
                    boolean z26 = !aVActivity2.f74657h1.p();
                    boolean z27 = (Eh.v0(5) || !(n.e().f().B() ^ true) || x.g(AVVideoLayerUIPart.this.getContext()) || Eh.v0(6)) ? false : true;
                    long d16 = com.tencent.av.utils.e.d();
                    int panelRotation = nTBaseVideoFragment2.Bh() != null ? nTBaseVideoFragment2.Bh().getPanelRotation() : 0;
                    if (panelRotation != 90 && panelRotation != 270) {
                        y16 = motionEvent2.getX() - motionEvent.getX();
                        x16 = motionEvent2.getY();
                        x17 = motionEvent.getY();
                    } else {
                        y16 = motionEvent2.getY() - motionEvent.getY();
                        x16 = motionEvent2.getX();
                        x17 = motionEvent.getX();
                    }
                    float f18 = x16 - x17;
                    float f19 = y16;
                    float abs = Math.abs(f19);
                    float abs2 = Math.abs(f18);
                    boolean z28 = z27;
                    if (panelRotation == 180 || panelRotation == 270) {
                        aVActivity = aVActivity2;
                        i3 = 90;
                        i16 = 1;
                    } else {
                        aVActivity = aVActivity2;
                        i3 = 90;
                        i16 = -1;
                    }
                    int i17 = (panelRotation == i3 || panelRotation == 180) ? 1 : -1;
                    if (abs < abs2) {
                        float f26 = i16;
                        z19 = f26 * f18 >= ((float) AVVideoLayerUIPart.this.f76251f);
                        z18 = f26 * (-f18) >= ((float) AVVideoLayerUIPart.this.f76251f);
                        z17 = false;
                        z16 = false;
                    } else {
                        float f27 = i17;
                        boolean z29 = f27 * f19 >= ((float) AVVideoLayerUIPart.this.f76251f);
                        z16 = f27 * (-f19) >= ((float) AVVideoLayerUIPart.this.f76251f);
                        z17 = z29;
                        z18 = false;
                        z19 = false;
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        nTBaseVideoFragment = nTBaseVideoFragment2;
                        sb5.append("onFling, e1[");
                        sb5.append(motionEvent);
                        sb5.append("], e2[");
                        sb5.append(motionEvent2);
                        sb5.append("], velocityX[");
                        sb5.append(f16);
                        sb5.append("], velocityY[");
                        sb5.append(f17);
                        sb5.append("], xOffset[");
                        sb5.append(abs);
                        sb5.append("], yOffset[");
                        sb5.append(abs2);
                        sb5.append("], up[");
                        sb5.append(z19);
                        sb5.append("], down[");
                        sb5.append(z18);
                        sb5.append("], left[");
                        sb5.append(z17);
                        sb5.append("], right[");
                        sb5.append(z16);
                        sb5.append("], seq[");
                        sb5.append(d16);
                        sb5.append("], isStatusBarShow[");
                        sb5.append(isToolBarDisplay);
                        sb5.append("], allowUpAndDownGesture[");
                        sb5.append(z26);
                        sb5.append("]");
                        QLog.w("AVVideoLayerUIPart", 1, sb5.toString());
                    } else {
                        nTBaseVideoFragment = nTBaseVideoFragment2;
                    }
                    if (!isToolBarDisplay && (z19 || z18)) {
                        return false;
                    }
                    if (z19 && z26) {
                        if ((!Eh.v0(0) && !Eh.v0(-1)) || !nTBaseVideoFragment.zk(d16)) {
                            return false;
                        }
                        DataReport.a.a(true);
                        AVActivity aVActivity3 = aVActivity;
                        aVActivity3.Z0.n(d16, aVActivity3, 0, 0);
                        Eh.V0(d16, -1);
                        return true;
                    }
                    AVActivity aVActivity4 = aVActivity;
                    if (z18 && z26) {
                        if (!Eh.v0(5)) {
                            return false;
                        }
                        DataReport.a.a(false);
                        Eh.X0(d16, 0, true);
                        return true;
                    }
                    if (z16 && z28) {
                        aVActivity4.f74657h1.o(1);
                        com.tencent.av.chatroom.c.e("0X800A8D2");
                        return false;
                    }
                    if (!z17 || !z28) {
                        return false;
                    }
                    Eh.X0(d16, 0, false);
                    aVActivity4.Z0.n(d16, aVActivity4, 0, 1);
                    aVActivity4.f74657h1.A(2);
                    if (!isToolBarDisplay) {
                        aVActivity4.I0.V0();
                    }
                    com.tencent.av.chatroom.c.e("0X800A8D1");
                    return false;
                }
                QLog.d("AVVideoLayerUIPart", 1, "onFling error2.");
                return false;
            }
            QLog.d("AVVideoLayerUIPart", 1, "onFling error.");
            return false;
        }
    }
}
