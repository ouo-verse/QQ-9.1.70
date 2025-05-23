package com.tencent.mobileqq.wink.editor.effect;

import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.util.SystemUtil;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkEditorEffectAdapter extends com.tencent.mobileqq.wink.view.ab {
    public AbsWinkMaterialPanelContentAdapter.d T;
    public c U;
    private b V;
    private final Handler W;
    private Context X;
    private ab.a Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f319993a0;

    /* renamed from: b0, reason: collision with root package name */
    private final SparseIntArray f319994b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f319995c0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final Integer f320001a = 0;

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f320002b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static final Integer f320003c = 2;

        /* renamed from: d, reason: collision with root package name */
        public static final Integer f320004d = 3;

        /* renamed from: e, reason: collision with root package name */
        public static final Integer f320005e = 4;

        /* renamed from: f, reason: collision with root package name */
        public static final Integer f320006f = 5;

        /* renamed from: g, reason: collision with root package name */
        public static final Integer f320007g = 6;

        /* renamed from: h, reason: collision with root package name */
        public static final Integer f320008h = 7;
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
        boolean interceptor();
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
        void a(int i3, int i16, int i17, MetaMaterial metaMaterial);

        void b();
    }

    public WinkEditorEffectAdapter(@NonNull Context context, WinkEditorViewModel.EditMode editMode, AbsWinkMaterialPanelContentAdapter.d dVar) {
        super(context, editMode);
        this.W = new Handler();
        this.Y = null;
        this.Z = -1;
        this.f319993a0 = true;
        this.f319994b0 = new SparseIntArray();
        this.f319995c0 = "none";
        this.T = dVar;
        this.X = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(ab.a aVar, @NonNull MetaMaterial metaMaterial) {
        if (aVar != null && aVar.itemView != null) {
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_NAME, metaMaterial.f30533id);
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_CATEGORY, this.f319995c0);
            buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
            buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_TEXIAO_ITEM);
            VideoReport.setElementId(aVar.itemView, WinkDaTongReportConstant.ElementId.EM_XSJ_TEXIAO_ITEM);
            VideoReport.reportEvent("dt_clck", aVar.itemView, buildElementParams);
        }
    }

    private void H0(ab.a aVar, @NonNull MetaMaterial metaMaterial) {
        VideoReport.setElementId(aVar.itemView, WinkDaTongReportConstant.ElementId.EM_XSJ_TEXIAO_ITEM);
        VideoReport.setElementReuseIdentifier(aVar.itemView, String.valueOf(metaMaterial.hashCode()));
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_NAME, metaMaterial.f30533id);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_CATEGORY, this.f319995c0);
        VideoReport.setElementParams(aVar.itemView, buildElementParams);
        VideoReport.setElementExposePolicy(aVar.itemView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(aVar.itemView, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(aVar.itemView, EndExposurePolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(ab.a aVar, @NonNull MetaMaterial metaMaterial) {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_NAME, metaMaterial.f30533id);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXIAO_CATEGORY, this.f319995c0);
        buildElementParams.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
        buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_TEXIAO_ITEM);
        VideoReport.setElementId(aVar.itemView, WinkDaTongReportConstant.ElementId.EM_XSJ_TEXIAO_ITEM);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", aVar.itemView, buildElementParams);
    }

    public void E0(int i3, MetaMaterial metaMaterial) {
        if (this.f319994b0.get(i3) == a.f320003c.intValue() || this.f319994b0.get(i3) == a.f320004d.intValue()) {
            this.Z = i3;
            this.f319994b0.put(i3, a.f320005e.intValue());
            this.T.b(i3, metaMaterial);
            CardView cardView = (CardView) this.Y.itemView.findViewById(R.id.xib);
            if (cardView.isHapticFeedbackEnabled()) {
                cardView.performHapticFeedback(0);
            } else {
                ((Vibrator) this.X.getSystemService("vibrator")).vibrate(100L);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cardView.getLayoutParams());
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.width = SystemUtil.dp2px(64);
            layoutParams.height = SystemUtil.dp2px(64);
            cardView.setLayoutParams(layoutParams);
            if (this.f319994b0.get(i3) == a.f320007g.intValue()) {
                this.T.a(i3, metaMaterial);
                CardView cardView2 = (CardView) this.Y.itemView.findViewById(R.id.xib);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(cardView2.getLayoutParams());
                layoutParams2.setMargins(SystemUtil.dp2px(4), SystemUtil.dp2px(4), SystemUtil.dp2px(4), SystemUtil.dp2px(4));
                layoutParams2.width = SystemUtil.dp2px(56);
                layoutParams2.height = SystemUtil.dp2px(56);
                cardView2.setLayoutParams(layoutParams2);
                I0(this.Y, metaMaterial);
                this.Z = -1;
                this.f319993a0 = true;
                this.f319994b0.put(i3, a.f320008h.intValue());
                return;
            }
            this.f319994b0.put(i3, a.f320006f.intValue());
        }
    }

    public boolean F0(int i3) {
        if (this.f319994b0.get(i3) != a.f320008h.intValue()) {
            return true;
        }
        return false;
    }

    public void J0(String str) {
        this.f319995c0 = str;
    }

    public void K0(b bVar) {
        this.V = bVar;
    }

    public void L0(c cVar) {
        this.U = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.ab
    public void n0(final ab.a aVar, final int i3, @NonNull final MetaMaterial metaMaterial) {
        super.n0(aVar, i3, metaMaterial);
        ViewUtilsKt.k(aVar.f326923e, metaMaterial.thumbUrl, null);
        if (!WinkEditorResourceManager.a1().q(metaMaterial) && com.tencent.mobileqq.wink.editor.c.x(metaMaterial) < 0) {
            aVar.f326926i.setVisibility(0);
        } else {
            aVar.f326926i.setVisibility(4);
        }
        if (com.tencent.mobileqq.wink.editor.c.v(metaMaterial) == 1) {
            aVar.E.setVisibility(0);
        } else {
            aVar.E.setVisibility(8);
        }
        H0(aVar, metaMaterial);
        aVar.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectAdapter.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (WinkEditorEffectAdapter.this.Z != -1 && WinkEditorEffectAdapter.this.Z != i3) {
                    return true;
                }
                if ((WinkEditorEffectAdapter.this.Z == -1 && WinkEditorEffectAdapter.this.f319994b0.get(i3) == a.f320008h.intValue()) || WinkEditorEffectAdapter.this.f319994b0.get(i3, -1) == -1) {
                    WinkEditorEffectAdapter.this.f319994b0.put(i3, a.f320001a.intValue());
                }
                Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.effect.WinkEditorEffectAdapter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Objects.equals(Integer.valueOf(WinkEditorEffectAdapter.this.f319994b0.get(i3)), a.f320008h)) {
                            return;
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        WinkEditorEffectAdapter.this.Y = aVar;
                        WinkEditorEffectAdapter.this.f319994b0.put(i3, a.f320003c.intValue());
                        if (!WinkEditorResourceManager.a1().q(metaMaterial)) {
                            WinkEditorEffectAdapter.this.f319994b0.put(i3, a.f320004d.intValue());
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            WinkEditorEffectAdapter.this.F(i3, metaMaterial);
                        } else if (WinkEditorEffectAdapter.this.V == null || !WinkEditorEffectAdapter.this.V.interceptor()) {
                            AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                            WinkEditorEffectAdapter.this.E0(i3, metaMaterial);
                        }
                    }
                };
                if (motionEvent.getAction() == 0 && WinkEditorEffectAdapter.this.f319994b0.get(i3) == a.f320001a.intValue()) {
                    WinkEditorEffectAdapter.this.f319994b0.put(i3, a.f320002b.intValue());
                    if (WinkEditorEffectAdapter.this.f319993a0) {
                        WinkEditorEffectAdapter.this.W.postDelayed(runnable, 500L);
                        WinkEditorEffectAdapter.this.f319993a0 = false;
                    }
                }
                if (motionEvent.getAction() == 1) {
                    WinkEditorEffectAdapter.this.W.removeCallbacksAndMessages(null);
                    if (WinkEditorEffectAdapter.this.f319994b0.get(i3) == a.f320006f.intValue()) {
                        WinkEditorEffectAdapter.this.T.a(i3, metaMaterial);
                        CardView cardView = (CardView) WinkEditorEffectAdapter.this.Y.itemView.findViewById(R.id.xib);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(cardView.getLayoutParams());
                        layoutParams.setMargins(SystemUtil.dp2px(4), SystemUtil.dp2px(4), SystemUtil.dp2px(4), SystemUtil.dp2px(4));
                        layoutParams.width = SystemUtil.dp2px(56);
                        layoutParams.height = SystemUtil.dp2px(56);
                        cardView.setLayoutParams(layoutParams);
                        WinkEditorEffectAdapter winkEditorEffectAdapter = WinkEditorEffectAdapter.this;
                        winkEditorEffectAdapter.I0(winkEditorEffectAdapter.Y, metaMaterial);
                    } else if (WinkEditorEffectAdapter.this.f319994b0.get(i3) == a.f320002b.intValue()) {
                        int[] iArr = new int[2];
                        aVar.itemView.getLocationOnScreen(iArr);
                        if (WinkEditorResourceManager.a1().n2(metaMaterial)) {
                            j73.a.f409615a.k(metaMaterial);
                            WinkEditorEffectAdapter.this.U.a(iArr[0] - SystemUtil.dp2px(20), SystemUtil.dp2px(103), i3, metaMaterial);
                            WinkEditorEffectAdapter winkEditorEffectAdapter2 = WinkEditorEffectAdapter.this;
                            winkEditorEffectAdapter2.G0(winkEditorEffectAdapter2.Y, metaMaterial);
                        }
                    }
                    if (WinkEditorEffectAdapter.this.f319994b0.get(i3) == a.f320005e.intValue()) {
                        WinkEditorEffectAdapter.this.f319994b0.put(i3, a.f320007g.intValue());
                    } else {
                        WinkEditorEffectAdapter.this.f319994b0.put(i3, a.f320008h.intValue());
                        WinkEditorEffectAdapter.this.f319993a0 = true;
                        WinkEditorEffectAdapter.this.Z = -1;
                    }
                    if (!WinkEditorResourceManager.a1().n2(metaMaterial)) {
                        WinkEditorEffectAdapter.this.F(i3, metaMaterial);
                    }
                }
                if (motionEvent.getAction() == 2) {
                    WinkEditorEffectAdapter.this.U.b();
                }
                if (motionEvent.getAction() == 3) {
                    WinkEditorEffectAdapter.this.W.removeCallbacksAndMessages(null);
                    if (WinkEditorEffectAdapter.this.f319994b0.get(i3) == a.f320006f.intValue()) {
                        WinkEditorEffectAdapter.this.T.a(i3, metaMaterial);
                        CardView cardView2 = (CardView) WinkEditorEffectAdapter.this.Y.itemView.findViewById(R.id.xib);
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(cardView2.getLayoutParams());
                        layoutParams2.setMargins(SystemUtil.dp2px(4), SystemUtil.dp2px(4), SystemUtil.dp2px(4), SystemUtil.dp2px(4));
                        layoutParams2.width = SystemUtil.dp2px(56);
                        layoutParams2.height = SystemUtil.dp2px(56);
                        cardView2.setLayoutParams(layoutParams2);
                    }
                    if (WinkEditorEffectAdapter.this.f319994b0.get(i3) == a.f320005e.intValue()) {
                        WinkEditorEffectAdapter.this.f319994b0.put(i3, a.f320007g.intValue());
                    } else {
                        WinkEditorEffectAdapter.this.f319994b0.put(i3, a.f320008h.intValue());
                        WinkEditorEffectAdapter.this.Z = -1;
                        WinkEditorEffectAdapter.this.f319993a0 = true;
                    }
                }
                return true;
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.view.ab
    protected ab.a o0(ViewGroup viewGroup, int i3) {
        return new ab.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hdi, viewGroup, false));
    }
}
