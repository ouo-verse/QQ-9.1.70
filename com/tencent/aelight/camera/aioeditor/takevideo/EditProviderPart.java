package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderViewEditContainer;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.TransitionProviderView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.AEFilterContentView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.Pair;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import com.tencent.widget.ScaleGestureDetector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import hr.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class EditProviderPart extends u implements ProviderView.a, DoodleLayout.r, o {
    public static String T = "EditProviderPart";
    protected View C;
    FrameLayout D;
    private RelativeLayout E;
    View F;
    private boolean G;
    private ScaleGestureDetector H;
    private GestureDetector I;
    private boolean J;
    private TextView K;
    private View L;
    public boolean M;
    public ProviderViewEditContainer N;
    public boolean P;
    private int Q;
    private QIMFilterCategoryItem R;
    public int S;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.aelight.camera.aioeditor.capture.util.h f67730d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, ProviderView> f67731e;

    /* renamed from: f, reason: collision with root package name */
    private ProviderView f67732f;

    /* renamed from: h, reason: collision with root package name */
    private AEFilterContentView f67733h;

    /* renamed from: i, reason: collision with root package name */
    private DoodleLayout f67734i;

    /* renamed from: m, reason: collision with root package name */
    private VideoFilterViewPager f67735m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart$3, reason: invalid class name */
    /* loaded from: classes32.dex */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f67736d;

        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart$3$1, reason: invalid class name */
        /* loaded from: classes32.dex */
        class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
            AnonymousClass1() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                EditProviderPart editProviderPart = EditProviderPart.this;
                if (editProviderPart.mUi != null && editProviderPart.L != null) {
                    ViewTreeObserver viewTreeObserver = EditProviderPart.this.L.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                    if (EditProviderPart.this.mParent.c0() != null) {
                        EditProviderPart.this.L.setX((r0.getLeft() + (r0.getWidth() / 2)) - (EditProviderPart.this.L.getWidth() / 2));
                    }
                    GridView gridView = (GridView) EditProviderPart.this.findViewSure(R.id.f163801s30);
                    gridView.setNumColumns(3);
                    gridView.setSelector(new ColorDrawable(0));
                    gridView.setClipToPadding(false);
                    gridView.setVerticalScrollBarEnabled(false);
                    gridView.setHorizontalScrollBarEnabled(false);
                    gridView.setOverScrollMode(2);
                    final com.tencent.aelight.camera.aioeditor.capture.adapter.f fVar = new com.tencent.aelight.camera.aioeditor.capture.adapter.f(EditProviderPart.this.getContext(), EditProviderPart.this.z0());
                    fVar.f66649e = true;
                    fVar.setData(AnonymousClass3.this.f67736d);
                    gridView.setAdapter((ListAdapter) fVar);
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.3.1.1
                        @Override // com.tencent.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
                            List list;
                            if (view == null || (list = AnonymousClass3.this.f67736d) == null || i3 >= list.size()) {
                                return;
                            }
                            TransitionCategoryItem transitionCategoryItem = (TransitionCategoryItem) AnonymousClass3.this.f67736d.get(i3);
                            if (transitionCategoryItem != null && !transitionCategoryItem.equals(com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().v())) {
                                com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().T(transitionCategoryItem);
                                fVar.e();
                                EditProviderPart.this.n(Integer.parseInt(transitionCategoryItem.f66697d));
                                id0.a.n("video_edit_transition", "clk_effects", z.k0(EditProviderPart.this.mParent.C.l("extra_transiton_src_from", -1)), 0, transitionCategoryItem.Q, transitionCategoryItem.T, transitionCategoryItem.R, transitionCategoryItem.S);
                            }
                            view.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.3.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    EditVideoPartManager editVideoPartManager;
                                    EditProviderPart editProviderPart2 = EditProviderPart.this;
                                    if (editProviderPart2.mUi == null || (editVideoPartManager = editProviderPart2.mParent) == null) {
                                        return;
                                    }
                                    editVideoPartManager.t(0);
                                }
                            }, 500L);
                        }
                    });
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("EditProviderPart", 2, "initTransitionRecommendView onGlobalLayout null");
                }
            }
        }

        AnonymousClass3(List list) {
            this.f67736d = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EditProviderPart.this.Q != 0) {
                if (QLog.isColorLevel()) {
                    QLog.e("EditProviderPart", 2, "EditVideoState is not idle");
                    return;
                }
                return;
            }
            EditProviderPart editProviderPart = EditProviderPart.this;
            if (editProviderPart.mUi != null && editProviderPart.L != null) {
                EditProviderPart.this.mParent.t(18);
                EditProviderPart.this.L.setVisibility(0);
                EditProviderPart.this.L.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass1());
            } else if (QLog.isColorLevel()) {
                QLog.d("EditProviderPart", 2, "initTransitionRecommendView postDelayed null");
            }
        }
    }

    /* loaded from: classes32.dex */
    class a implements VideoFilterViewPager.a {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.a
        public void a(String str) {
            EditProviderPart.this.mParent.q(str);
        }
    }

    /* loaded from: classes32.dex */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            EditProviderPart editProviderPart = EditProviderPart.this;
            if (editProviderPart.mUi == null || editProviderPart.mParent == null) {
                return false;
            }
            if (editProviderPart.f67734i == null) {
                EditProviderPart editProviderPart2 = EditProviderPart.this;
                EditVideoDoodle editVideoDoodle = editProviderPart2.mParent.I;
                if (editVideoDoodle == null) {
                    return false;
                }
                editProviderPart2.f67734i = editVideoDoodle.V();
            }
            if (EditProviderPart.this.M) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                EditProviderPart.this.G = false;
                EditProviderPart.this.J = false;
            }
            EditVideoPartManager editVideoPartManager = EditProviderPart.this.mParent;
            if (editVideoPartManager != null && editVideoPartManager.l0()) {
                EditProviderPart.this.H.onTouchEvent(motionEvent);
                if (EditProviderPart.this.H.isInProgress()) {
                    EditProviderPart.this.J = true;
                }
            }
            boolean z16 = EditProviderPart.this.H.isInProgress() || (!EditProviderPart.this.J && EditProviderPart.this.I.onTouchEvent(motionEvent));
            if (z16) {
                if (EditProviderPart.this.G) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction(3);
                    EditProviderPart.this.f67735m.a(obtain);
                    obtain.recycle();
                    EditProviderPart.this.G = false;
                }
            } else {
                z16 = EditProviderPart.this.f67735m.a(motionEvent);
                if (actionMasked == 0) {
                    EditProviderPart.this.G = true;
                }
            }
            return z16;
        }
    }

    /* loaded from: classes32.dex */
    private class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        c() {
        }

        @Override // com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener, com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            EditPicRawImage editPicRawImage = EditProviderPart.this.mParent.L;
            if (editPicRawImage != null) {
                editPicRawImage.t0(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            }
            return editPicRawImage != null;
        }

        @Override // com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener, com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            EditPicRawImage editPicRawImage = EditProviderPart.this.mParent.L;
            if (editPicRawImage != null) {
                editPicRawImage.u0(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            }
            return editPicRawImage != null;
        }

        @Override // com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener, com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            EditPicRawImage editPicRawImage = EditProviderPart.this.mParent.L;
            if (editPicRawImage != null) {
                editPicRawImage.v0();
            }
        }
    }

    /* loaded from: classes32.dex */
    private class d extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f67745d = false;

        d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            com.tencent.aelight.camera.aioeditor.takevideo.d dVar;
            if (EditProviderPart.this.f67734i.Z0() && (dVar = (com.tencent.aelight.camera.aioeditor.takevideo.d) EditProviderPart.this.getEditExport(com.tencent.aelight.camera.aioeditor.takevideo.d.class)) != null) {
                dVar.W();
            }
            if (!EditProviderPart.this.mParent.l0()) {
                return false;
            }
            EditVideoPartManager editVideoPartManager = EditProviderPart.this.mParent;
            int i3 = editVideoPartManager.f67780d;
            if (i3 == 0) {
                this.f67745d = true;
                editVideoPartManager.t(11);
                return true;
            }
            if (this.f67745d && i3 == 11) {
                this.f67745d = false;
                editVideoPartManager.t(0);
                return true;
            }
            return false;
        }
    }

    public EditProviderPart(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.f67731e = new HashMap<>();
        this.Q = 0;
        this.R = null;
        this.S = -1;
    }

    private Bundle C0() {
        Bundle bundle = this.mParent.Y;
        if (bundle != null) {
            return bundle.getBundle(ParseCommon.CONTAINER);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        if (this.f67733h == null) {
            ms.a.a("EditProviderPart", "view is null.");
            AEFilterContentView aEFilterContentView = new AEFilterContentView(getContext());
            this.f67733h = aEFilterContentView;
            this.E.addView(aEFilterContentView);
            this.f67733h.setProviderViewListener(this);
        }
        this.f67733h.g(z0());
    }

    private void F0() {
        EditVideoPartManager editVideoPartManager = this.mParent;
        if (editVideoPartManager == null || !EditVideoPartManager.v(editVideoPartManager.C.f204057f, 16)) {
            return;
        }
        m.a aVar = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).I;
        if (aVar == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QCombo", 2, "comboFilterData null");
                return;
            }
            return;
        }
        ArrayList<QIMFilterCategoryItem> e16 = aVar.e();
        if (e16 != null && e16.size() < 3) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QCombo", 2, "recommend trans less than 3");
                return;
            }
            return;
        }
        View findViewSure = findViewSure(R.id.s2z);
        this.L = findViewSure;
        EditVideoPartManager editVideoPartManager2 = this.mParent;
        if (editVideoPartManager2.U != null) {
            if (editVideoPartManager2.V) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewSure(R.id.rsq);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.L.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.addRule(12, -1);
                layoutParams.addRule(2, 0);
                ((ViewGroup) this.L.getParent()).removeView(this.L);
                relativeLayout.addView(this.L, layoutParams);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) findViewSure.getLayoutParams();
                layoutParams2.addRule(12, -1);
                layoutParams2.addRule(2, 0);
                this.L.setLayoutParams(layoutParams2);
            }
        }
        this.L.postDelayed(new AnonymousClass3(e16), 1000L);
    }

    private void I0() {
        E0();
        this.E.setVisibility(0);
        if (this.f67735m.getAdapter() == null || this.f67733h.a() <= this.f67735m.getAdapter().getF373114d() / 100) {
            return;
        }
        L0(false);
    }

    private void J0(int i3) {
        ProviderView a16;
        View view = this.L;
        if (view != null && view.getVisibility() == 0) {
            this.L.setVisibility(8);
            this.L = null;
        }
        ProviderView providerView = this.f67732f;
        if (providerView != null) {
            providerView.x();
            this.f67732f.setVisibility(8);
            this.f67732f = null;
        }
        if (this.f67731e.containsKey(Integer.valueOf(i3))) {
            a16 = this.f67731e.get(Integer.valueOf(i3));
        } else {
            a16 = this.f67730d.a(getContext(), i3);
            if (a16 != null) {
                this.f67731e.put(Integer.valueOf(i3), a16);
            }
            if (a16 instanceof TransitionProviderView) {
                ((TransitionProviderView) a16).S = this.mParent.C.l("extra_transiton_src_from", -1);
            }
        }
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.e("EditProviderPart", 2, "build provider view failed " + i3);
                return;
            }
            return;
        }
        if (!a16.s()) {
            if (this.f67734i == null) {
                this.f67734i = this.mParent.I.V();
            }
            if (this.mParent.U != null) {
                a16.m(a16.o() + ((int) UIUtils.o(getContext(), this.mParent.U.getHeight())));
            }
            a16.v(C0());
        }
        this.f67732f = a16;
        if (a16.getId() != R.id.apf) {
            j(false);
        }
        this.f67732f.setVisibility(0);
        this.f67732f.y();
        this.D.setVisibility(0);
        this.F.setVisibility(0);
    }

    public String A0(Bitmap bitmap) {
        VideoFilterViewPager videoFilterViewPager = this.f67735m;
        if (videoFilterViewPager != null) {
            return videoFilterViewPager.K(bitmap);
        }
        return "";
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public boolean B() {
        return false;
    }

    public void B0(JSONObject jSONObject) {
        boolean z16;
        QIMFilterCategoryItem qIMFilterCategoryItem;
        QIMFilterCategoryItem qIMFilterCategoryItem2;
        try {
            JSONObject jSONObject2 = new JSONObject();
            com.tencent.aelight.camera.aioeditor.capture.data.d dVar = (com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5);
            com.tencent.aelight.camera.aioeditor.capture.data.h hVar = dVar.L[this.S].f66723a;
            boolean z17 = true;
            if (hVar == null || (qIMFilterCategoryItem2 = (QIMFilterCategoryItem) hVar.f66709i) == null) {
                z16 = false;
            } else {
                jSONObject2.put("comboItem", qIMFilterCategoryItem2.c());
                z16 = true;
            }
            com.tencent.aelight.camera.aioeditor.capture.data.j jVar = dVar.L[this.S].f66725c;
            if (jVar != null && (qIMFilterCategoryItem = (QIMFilterCategoryItem) jVar.f66709i) != null) {
                jSONObject2.put("filterItem", qIMFilterCategoryItem.c());
                z16 = true;
            }
            MusicItemInfo j3 = ((com.tencent.aelight.camera.aioeditor.capture.music.g) fr.f.d().g(8)).j();
            if (j3 != null) {
                jSONObject2.put("musicItem", j3.convertToJSON());
            } else {
                z17 = z16;
            }
            if (z17) {
                jSONObject.put(T, jSONObject2);
            }
        } catch (Exception unused) {
        }
    }

    public <T extends ProviderView> T D0(Class<? extends ProviderView> cls) {
        Iterator<ProviderView> it = this.f67731e.values().iterator();
        while (it.hasNext()) {
            T t16 = (T) it.next();
            if (cls.isInstance(t16)) {
                return t16;
            }
        }
        return null;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.a
    public void E(int i3) {
        this.mParent.t(16);
        this.mParent.t(i3);
        ProviderViewEditContainer providerViewEditContainer = this.N;
        if (providerViewEditContainer != null) {
            providerViewEditContainer.c();
        }
    }

    public boolean G0() {
        QIMFilterCategoryItem qIMFilterCategoryItem = this.R;
        return (qIMFilterCategoryItem == null || qIMFilterCategoryItem.k()) ? false : true;
    }

    void K0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("EditProviderPart", 2, "preloadProviderView count" + this.f67730d.b());
        }
        Bundle C0 = C0();
        for (int i3 = 0; i3 < this.f67730d.b(); i3++) {
            int d16 = this.f67730d.d(i3);
            if ((!z16 || this.f67730d.f(d16)) && this.f67731e.get(Integer.valueOf(d16)) == null) {
                ProviderView a16 = this.f67730d.a(getContext(), d16);
                if (a16 != null) {
                    this.f67731e.put(Integer.valueOf(this.f67730d.d(i3)), a16);
                    a16.setProviderViewListener(this);
                    a16.setDoodleEventListener(this);
                    a16.C(C0);
                    this.D.addView(a16);
                    a16.setVisibility(8);
                    if (a16 instanceof TransitionProviderView) {
                        ((TransitionProviderView) a16).S = this.mParent.C.l("extra_transiton_src_from", -1);
                    }
                    if (!z16) {
                        a16.z();
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e("EditProviderPart", 2, "preloadProviderView failed " + i3);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.a
    public void R(int i3, Object... objArr) {
        this.mParent.u(15, new Pair(Integer.valueOf(i3), objArr));
        ProviderViewEditContainer providerViewEditContainer = this.N;
        if (providerViewEditContainer != null) {
            providerViewEditContainer.f(i3, objArr);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.a
    public void b0(int i3, QIMFilterCategoryItem qIMFilterCategoryItem) {
        QLog.e("EditProviderPart", 1, "onFilterItemClicked: " + i3);
        if (i3 != -1) {
            this.R = qIMFilterCategoryItem;
            this.f67735m.setCurrentItem(i3, false);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        super.editVideoPrePublish(i3, bVar);
        if (((QIMFilterProviderView) D0(QIMFilterProviderView.class)) != null) {
            boolean z16 = com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().u(this.S) != null;
            bVar.f400391h = z16;
            if (z16 && this.mParent.l0()) {
                bVar.f400395l.f400420f++;
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        super.editVideoStateChanged(i3, obj);
        this.Q = i3;
        if (i3 == 0) {
            this.M = false;
            y0();
            ProviderViewEditContainer providerViewEditContainer = this.N;
            if (providerViewEditContainer != null) {
                providerViewEditContainer.c();
                return;
            }
            return;
        }
        if (i3 == 1) {
            J0(104);
            if (SlideShowPhotoListManager.n().m() == 22) {
                LpReportInfo_pf00064.allReport(680, 3, 1);
                return;
            }
            return;
        }
        if (i3 == 3) {
            J0(103);
            return;
        }
        if (i3 == 17) {
            J0(108);
            return;
        }
        if (i3 == 24) {
            if (this.f67735m == null || !this.mParent.l0()) {
                return;
            }
            this.f67735m.D();
            this.f67735m.M(0, true);
            return;
        }
        if (i3 == 13) {
            I0();
        } else if (i3 != 14) {
            y0();
        } else {
            J0(106);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.o
    public void f0() {
        F0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.a
    public int getVideoDuration() {
        EditVideoPartManager editVideoPartManager = this.mParent;
        return (int) editVideoPartManager.a0(editVideoPartManager.N());
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.a
    public void j(boolean z16) {
        if (this.K == null) {
            return;
        }
        MusicProviderView musicProviderView = (MusicProviderView) this.f67731e.get(104);
        MusicItemInfo j3 = ((com.tencent.aelight.camera.aioeditor.capture.music.g) fr.f.d().g(8)).j();
        final boolean z17 = z16 && musicProviderView != null && (j3 == null || !j3.needPlay()) && musicProviderView.L();
        aa aaVar = this.mUi;
        if (aaVar == null || !(aaVar instanceof EditVideoActivity) || aaVar.getActivity() == null) {
            return;
        }
        this.mUi.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.5
            @Override // java.lang.Runnable
            public void run() {
                if (EditProviderPart.this.K == null) {
                    return;
                }
                if (z17) {
                    EditProviderPart.this.K.setVisibility(0);
                } else {
                    EditProviderPart.this.K.setVisibility(8);
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.a
    public void n(int i3) {
        ((q) getEditExport(q.class)).o(i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityFinish() {
        super.onActivityFinish();
        ProviderViewEditContainer providerViewEditContainer = this.N;
        if (providerViewEditContainer != null) {
            providerViewEditContainer.d();
        }
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).L[this.S].b((Activity) this.D.getContext());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityResult(int i3, int i16, Intent intent) {
        Iterator<Map.Entry<Integer, ProviderView>> it = this.f67731e.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().t(i3, i16, intent);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        publishEditExport(o.class, this);
        int z06 = z0();
        this.S = z06;
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().Q(this.mParent);
        this.D = (FrameLayout) findViewSure(R.id.ryu);
        this.E = (RelativeLayout) findViewSure(R.id.rtb);
        this.F = findViewSure(R.id.rr6);
        RelativeLayout relativeLayout = this.mParent.U;
        if (relativeLayout != null) {
            int height = relativeLayout.getHeight();
            ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
            if (height <= 0) {
                layoutParams.height += LiuHaiUtils.BOTTOM_HEIGHT;
            } else {
                layoutParams.height += height;
            }
            this.D.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.F.getLayoutParams();
            if (height <= 0) {
                layoutParams2.height += LiuHaiUtils.BOTTOM_HEIGHT;
            } else {
                layoutParams2.height += height;
            }
            this.F.setLayoutParams(layoutParams2);
        }
        com.tencent.aelight.camera.aioeditor.capture.util.h hVar = new com.tencent.aelight.camera.aioeditor.capture.util.h(z06);
        this.f67730d = hVar;
        hVar.g();
        VideoFilterViewPager videoFilterViewPager = (VideoFilterViewPager) findViewSure(R.id.f163779rz1);
        this.f67735m = videoFilterViewPager;
        videoFilterViewPager.setReadyToApply(false);
        this.f67735m.setCaptureScene(this.S);
        if (js.a.f410906f.d(this.mParent.C.D)) {
            this.f67735m.G = true;
        }
        this.f67735m.setIaiSubLabelReady(new a());
        L0(true);
        this.H = new ScaleGestureDetector(getContext(), new c());
        this.I = new GestureDetector(getContext(), new d());
        View findViewSure = findViewSure(R.id.f163780rz2);
        this.C = findViewSure;
        findViewSure.setOnTouchListener(new b());
        if (this.mUi instanceof EditVideoActivity) {
            this.K = (TextView) findViewSure(R.id.rsk);
        }
        K0(true);
        if (this.N == null) {
            ((ViewStub) findViewSure(R.id.f163781rz3)).inflate();
            this.N = (ProviderViewEditContainer) findViewSure(R.id.ryt);
            this.N.h(this.mParent.M());
            this.N.setProviderViewListener(this);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
        Iterator<Map.Entry<Integer, ProviderView>> it = this.f67731e.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().w();
        }
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().e();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onPause() {
        super.onPause();
        Iterator<ProviderView> it = this.f67731e.values().iterator();
        while (it.hasNext()) {
            it.next().A();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onResume() {
        super.onResume();
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().O(this.S);
        Iterator<ProviderView> it = this.f67731e.values().iterator();
        while (it.hasNext()) {
            it.next().z();
        }
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).L[this.S].e((Activity) this.D.getContext());
        if (this.P) {
            return;
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.4
            @Override // java.lang.Runnable
            public void run() {
                aa aaVar;
                EditProviderPart editProviderPart = EditProviderPart.this;
                if (editProviderPart.P || (aaVar = editProviderPart.mUi) == null || aaVar.getActivity() == null || EditProviderPart.this.mUi.getActivity().isFinishing() || EditProviderPart.this.mUi.getActivity().isDestroyed()) {
                    return;
                }
                EditProviderPart editProviderPart2 = EditProviderPart.this;
                editProviderPart2.P = true;
                editProviderPart2.K0(false);
                EditProviderPart.this.E0();
            }
        }, 500L);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.o
    public void t() {
        View view = this.L;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.L.setVisibility(8);
    }

    public void x0() {
        VideoFilterViewPager videoFilterViewPager = this.f67735m;
        if (videoFilterViewPager != null) {
            videoFilterViewPager.D();
        }
    }

    public void y0() {
        View view = this.L;
        if (view != null && view.getVisibility() == 0) {
            this.L.setVisibility(8);
            this.L = null;
        }
        ProviderView providerView = this.f67732f;
        if (providerView != null) {
            providerView.x();
            this.f67732f.setVisibility(8);
            this.f67732f = null;
        }
        this.E.setVisibility(8);
        this.D.setVisibility(8);
        this.F.setVisibility(8);
    }

    public int z0() {
        return this.mParent.k0() ? this.mParent.l0() ? 3 : 4 : this.mParent.l0() ? 1 : 2;
    }

    public void L0(final boolean z16) {
        VideoFilterViewPager videoFilterViewPager;
        m.a aVar = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).I;
        if (aVar != null && (videoFilterViewPager = this.f67735m) != null) {
            videoFilterViewPager.W(m.a.b(aVar.c(this.S).f66517c), new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.p
                @Override // java.lang.Runnable
                public final void run() {
                    EditProviderPart.this.H0(z16);
                }
            });
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            objArr[0] = "comboFilterData is null, ";
            objArr[1] = Boolean.valueOf(aVar == null);
            objArr[2] = " ";
            objArr[3] = Boolean.valueOf(this.f67735m == null);
            QLog.d("EditProviderPart", 2, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(boolean z16) {
        if (z16) {
            this.f67735m.C();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void v(e.a aVar) {
        ((com.tencent.biz.qqstory.model.h) com.tencent.biz.qqstory.model.i.c(10)).m("has_show_add_poi_paster_guide", Boolean.TRUE);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void f(int i3, Object obj) {
        if (i3 == 7) {
            y0();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void i(int i3, int i16) {
        if (1 == i3) {
            QQToast.makeText(this.mUi.getContext(), HardCodeUtil.qqStr(R.string.lx7), 0).show();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.a
    public void H(boolean z16) {
        if (z16) {
            this.mParent.s(Message.obtain(null, 3, 1, 0));
        } else {
            this.mParent.s(Message.obtain(null, 3, 2, 0));
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.a
    public void J(boolean z16) {
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void U(byte[] bArr) {
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void P() {
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void close() {
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void e() {
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.a
    public void p() {
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.r
    public void g(Bitmap bitmap, boolean z16) {
    }
}
