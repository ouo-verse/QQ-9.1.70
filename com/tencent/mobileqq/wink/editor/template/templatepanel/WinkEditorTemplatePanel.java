package com.tencent.mobileqq.wink.editor.template.templatepanel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.edit.manager.f;
import com.tencent.mobileqq.wink.edit.manager.h;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.template.g;
import com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorExpandedTemplateDialog;
import com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanel;
import com.tencent.mobileqq.wink.editor.template.templatepanel.a;
import com.tencent.mobileqq.wink.editor.template.templatepanel.b;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.report.e;
import com.tencent.mobileqq.wink.view.x;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes21.dex */
public class WinkEditorTemplatePanel extends WinkEditorTemplatePanelBase {
    private MetaCategory J;
    private MetaCategory K;
    private final List<MetaMaterial> L;
    private List<MetaCategory> M;
    private com.tencent.mobileqq.wink.editor.template.templatepanel.a N;
    private com.tencent.mobileqq.wink.editor.template.templatepanel.a P;
    private com.tencent.mobileqq.wink.editor.template.templatepanel.a Q;
    private boolean R;
    private RecyclerView S;
    private LinearLayout T;
    private RecyclerView U;
    private RecyclerView V;
    private LinearLayoutManager W;

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayoutManager f322409a0;

    /* renamed from: b0, reason: collision with root package name */
    private LinearLayoutManager f322410b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f322411c0;

    /* renamed from: d0, reason: collision with root package name */
    WinkEditorExpandedTemplateDialog f322412d0;

    /* renamed from: e0, reason: collision with root package name */
    private g.a f322413e0;

    /* renamed from: f0, reason: collision with root package name */
    private View.OnClickListener f322414f0;

    /* renamed from: g0, reason: collision with root package name */
    private List<String> f322415g0;

    /* renamed from: h0, reason: collision with root package name */
    MetaMaterial f322416h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f322417i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f322418j0;

    /* loaded from: classes21.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            if (1 == i3) {
                WinkEditorTemplatePanel winkEditorTemplatePanel = WinkEditorTemplatePanel.this;
                winkEditorTemplatePanel.I = false;
                if (winkEditorTemplatePanel.Q != null) {
                    WinkEditorTemplatePanel.this.Q.R = false;
                    WinkEditorTemplatePanel.this.Q.S = false;
                }
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            WinkEditorTemplatePanel winkEditorTemplatePanel = WinkEditorTemplatePanel.this;
            if (!winkEditorTemplatePanel.I && winkEditorTemplatePanel.V.getVisibility() == 0 && WinkEditorTemplatePanel.this.Q != null && !WinkEditorTemplatePanel.this.Q.R && !WinkEditorTemplatePanel.this.Q.S) {
                int findFirstVisibleItemPosition = WinkEditorTemplatePanel.this.f322410b0.findFirstVisibleItemPosition();
                WinkEditorTemplatePanel winkEditorTemplatePanel2 = WinkEditorTemplatePanel.this;
                WinkEditorTemplatePanel.this.D.B(com.tencent.mobileqq.wink.editor.c.f(winkEditorTemplatePanel2.F, winkEditorTemplatePanel2.L, findFirstVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b implements WinkEditorExpandedTemplateDialog.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorExpandedTemplateDialog.a
        public void a(@NonNull View view) {
            if (WinkEditorTemplatePanel.this.f322414f0 != null) {
                WinkEditorTemplatePanel.this.f322414f0.onClick(view);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorExpandedTemplateDialog.a
        public void b(@Nullable MetaMaterial metaMaterial) {
            WinkEditorTemplatePanel.this.i0(metaMaterial);
            if (WinkEditorTemplatePanel.this.f322413e0 != null) {
                WinkEditorTemplatePanel.this.f322413e0.b(-1, metaMaterial);
            }
            WinkEditorTemplatePanel.this.f322412d0 = null;
        }

        @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorExpandedTemplateDialog.a
        public void c(@Nullable MetaMaterial metaMaterial, @Nullable MetaMaterial metaMaterial2) {
            if (metaMaterial2 != null) {
                WinkEditorTemplatePanel.this.i0(metaMaterial2);
            } else {
                WinkEditorTemplatePanel.this.j0(metaMaterial);
            }
            WinkEditorTemplatePanel.this.f322412d0 = null;
        }

        @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorExpandedTemplateDialog.a
        public void d(@Nullable MetaMaterial metaMaterial) {
            WinkEditorTemplatePanel.this.j0(metaMaterial);
            WinkEditorTemplatePanel.this.f322425f.performClick();
            WinkEditorTemplatePanel.this.f322412d0 = null;
        }

        @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorExpandedTemplateDialog.a
        public void e(@Nullable MetaMaterial metaMaterial) {
            WinkEditorTemplatePanel.this.o0(metaMaterial);
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_BIG_PANEL, 1);
            WinkEditorTemplatePanel.this.f322412d0 = null;
        }
    }

    /* loaded from: classes21.dex */
    class c implements a.InterfaceC9043a {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.a.InterfaceC9043a
        public void a(@NonNull MetaMaterial metaMaterial) {
            if (WinkEditorTemplatePanel.this.N != null && WinkEditorTemplatePanel.this.N.B() != null) {
                List<MetaMaterial> B = WinkEditorTemplatePanel.this.N.B();
                MetaMaterial A = WinkEditorTemplatePanel.this.N.A(metaMaterial.f30533id);
                if (A != null) {
                    B.remove(A);
                }
                MetaMaterial copy = metaMaterial.copy();
                com.tencent.mobileqq.wink.editor.c.o1(copy, "star");
                com.tencent.mobileqq.wink.editor.c.p1(copy, "\u6536\u85cf");
                B.add(0, copy);
                WinkEditorTemplatePanel.this.f322415g0.remove(metaMaterial.f30533id);
                WinkEditorTemplatePanel.this.f322415g0.add(0, metaMaterial.f30533id);
                WinkEditorTemplatePanel.this.N.Y(B);
                WinkEditorTemplatePanel.this.N.e0(copy);
                WinkEditorTemplatePanel.this.N.N(copy);
                if (WinkEditorTemplatePanel.this.f322411c0) {
                    WinkEditorTemplatePanel.this.N.v0(copy);
                }
            }
            WinkEditorTemplatePanel.this.e0(metaMaterial);
        }

        @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.a.InterfaceC9043a
        public void b(@NonNull MetaMaterial metaMaterial) {
            WinkEditorTemplatePanel.this.e0(metaMaterial);
        }
    }

    /* loaded from: classes21.dex */
    class d implements b.a {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.b.a
        public void a() {
            WinkEditorTemplatePanel.this.r0();
        }
    }

    public WinkEditorTemplatePanel(Context context) {
        this(context, null);
    }

    private MetaMaterial U() {
        int findFirstVisibleItemPosition;
        MetaCategory metaCategory;
        MetaCategory metaCategory2;
        MetaMaterial metaMaterial;
        MetaMaterial W = W();
        if (W != null) {
            return W;
        }
        if (this.S.getVisibility() == 0 && (metaCategory2 = this.J) != null && metaCategory2.materials != null) {
            int findFirstVisibleItemPosition2 = this.W.findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition2 >= 0 && findFirstVisibleItemPosition2 < this.J.materials.size() && (metaMaterial = this.J.materials.get(findFirstVisibleItemPosition2)) != null) {
                MetaMaterial copy = metaMaterial.copy();
                com.tencent.mobileqq.wink.editor.c.o1(copy, "star");
                com.tencent.mobileqq.wink.editor.c.p1(copy, "\u6536\u85cf");
                return copy;
            }
            return null;
        }
        if (this.U.getVisibility() == 0 && (metaCategory = this.K) != null && metaCategory.materials != null) {
            int findFirstVisibleItemPosition3 = this.f322409a0.findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition3 >= 0 && findFirstVisibleItemPosition3 < this.K.materials.size()) {
                return this.K.materials.get(findFirstVisibleItemPosition3);
            }
            return null;
        }
        if (this.V.getVisibility() == 0 && this.L != null && (findFirstVisibleItemPosition = this.f322410b0.findFirstVisibleItemPosition()) >= 0 && findFirstVisibleItemPosition < this.L.size()) {
            return this.L.get(findFirstVisibleItemPosition);
        }
        return null;
    }

    private MetaMaterial W() {
        MetaMaterial metaMaterial;
        MetaCategory t16 = this.D.t();
        if (t16 != null) {
            String str = t16.f30532id;
            str.hashCode();
            if (!str.equals("star")) {
                if (!str.equals("recommend")) {
                    metaMaterial = this.Q.E();
                } else {
                    metaMaterial = this.P.E();
                }
            } else {
                metaMaterial = this.N.E();
            }
        } else {
            metaMaterial = null;
        }
        if (metaMaterial != null) {
            return metaMaterial;
        }
        MetaMaterial E = this.N.E();
        if (E != null) {
            return E;
        }
        MetaMaterial E2 = this.P.E();
        if (E2 != null) {
            return E2;
        }
        return this.Q.E();
    }

    private void X(Context context, FrameLayout frameLayout) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.T = linearLayout;
        linearLayout.setOrientation(1);
        this.T.setGravity(1);
        TextView textView = new TextView(context);
        textView.setTextColor(context.getResources().getColor(R.color.bfq));
        textView.setText(R.string.f240117oa);
        textView.setTextSize(14.0f);
        this.T.addView(textView, -2, -2);
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).setMargins(0, ViewUtils.dpToPx(18.0f), 0, ViewUtils.dpToPx(16.0f));
        TextView textView2 = new TextView(context);
        this.f322418j0 = textView2;
        textView2.setBackgroundResource(R.drawable.l5h);
        this.f322418j0.setGravity(17);
        this.f322418j0.setTextSize(14.0f);
        this.f322418j0.setText(R.string.f240107o_);
        this.f322418j0.setTextColor(context.getResources().getColor(R.color.bfp));
        VideoReport.setElementId(this.f322418j0, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_LIBRARY);
        VideoReport.setElementEndExposePolicy(this.f322418j0, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.f322418j0, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.f322418j0, ClickPolicy.REPORT_ALL);
        this.f322418j0.setOnClickListener(new View.OnClickListener() { // from class: q73.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorTemplatePanel.this.Z(view);
            }
        });
        this.T.addView(this.f322418j0, ViewUtils.dpToPx(78.0f), ViewUtils.dpToPx(30.0f));
        frameLayout.addView(this.T, new LinearLayout.LayoutParams(-1, -1, 51.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        r0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        r0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(MetaMaterial metaMaterial) {
        this.N.N(metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(MetaMaterial metaMaterial) {
        this.P.N(metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(MetaMaterial metaMaterial) {
        this.Q.N(metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(@NonNull MetaMaterial metaMaterial) {
        if (this.D.t() == null) {
            return;
        }
        if ("star".equals(this.D.t().f30532id)) {
            if (metaMaterial.f30533id != null && this.P.E() != null && metaMaterial.f30533id.equals(this.P.E().f30533id)) {
                com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar = this.P;
                aVar.notifyItemChanged(aVar.D());
            }
            if (metaMaterial.f30533id != null && this.Q.E() != null && metaMaterial.f30533id.equals(this.Q.E().f30533id)) {
                com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar2 = this.Q;
                aVar2.notifyItemChanged(aVar2.D());
                return;
            }
            return;
        }
        if (metaMaterial.f30533id != null && this.N.E() != null && metaMaterial.f30533id.equals(this.N.E().f30533id)) {
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar3 = this.N;
            aVar3.notifyItemChanged(aVar3.D());
        }
    }

    private void h0(RecyclerView.ViewHolder viewHolder, MetaMaterial metaMaterial) {
        String str;
        if (viewHolder instanceof a.b) {
            Map<String, ?> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put("xsj_template_name", com.tencent.mobileqq.wink.editor.c.a0(metaMaterial));
            buildElementParams.put("xsj_template_id", metaMaterial.f30533id);
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEMPLATE_CATEGORY, com.tencent.mobileqq.wink.editor.c.p(metaMaterial));
            if (f.e().f(metaMaterial.f30533id)) {
                str = "\u6536\u85cf";
            } else {
                str = "\u53d6\u6d88\u6536\u85cf";
            }
            buildElementParams.put("xsj_action_type", str);
            e.f326265a.q("ev_xsj_abnormal_imp", ((a.b) viewHolder).getMFavoriteView(), "em_xsj_collect_button", buildElementParams, buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            return;
        }
        this.D.B(com.tencent.mobileqq.wink.editor.c.d(this.F, com.tencent.mobileqq.wink.editor.c.o(metaMaterial)));
        if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals(this.J.f30532id)) {
            s0();
            this.N.N(metaMaterial);
        } else if (this.K != null && com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals(this.K.f30532id)) {
            t0();
            this.P.N(metaMaterial);
        } else {
            q0();
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar = this.Q;
            aVar.R = true;
            aVar.N(metaMaterial);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            return;
        }
        this.D.B(com.tencent.mobileqq.wink.editor.c.d(this.F, com.tencent.mobileqq.wink.editor.c.o(metaMaterial)));
        if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals(this.J.f30532id)) {
            s0();
            this.N.O(metaMaterial.f30533id);
        } else if (this.K != null && com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals(this.K.f30532id)) {
            t0();
            this.P.O(metaMaterial.f30533id);
        } else {
            q0();
            this.Q.O(metaMaterial.f30533id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            return;
        }
        this.D.B(com.tencent.mobileqq.wink.editor.c.d(this.F, com.tencent.mobileqq.wink.editor.c.o(metaMaterial)));
        if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals("star")) {
            s0();
            this.N.Q(metaMaterial.f30533id);
        } else if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals("recommend")) {
            t0();
            this.P.Q(metaMaterial.f30533id);
        } else {
            q0();
            this.Q.Q(metaMaterial.f30533id);
        }
    }

    private void p0(String str) {
        if (str == null) {
            return;
        }
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar = this.N;
        aVar.v0(aVar.A(str));
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar2 = this.P;
        aVar2.v0(aVar2.A(str));
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar3 = this.Q;
        aVar3.v0(aVar3.A(str));
    }

    private void q0() {
        this.T.setVisibility(4);
        this.S.setVisibility(4);
        this.U.setVisibility(4);
        this.V.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        ArrayList<MetaMaterial> arrayList;
        ArrayList<MetaMaterial> arrayList2;
        MetaCategory metaCategory;
        if (FastClickUtils.isFastDoubleClick("WinkEditorTemplatePanelshowExpandedTemplateDialog")) {
            return;
        }
        List<MetaCategory> list = this.F;
        if (!this.R && (metaCategory = this.J) != null) {
            arrayList = metaCategory.materials;
        } else {
            arrayList = null;
        }
        MetaCategory metaCategory2 = this.K;
        if (metaCategory2 != null) {
            arrayList2 = metaCategory2.materials;
        } else {
            arrayList2 = null;
        }
        WinkEditorExpandedTemplateDialog winkEditorExpandedTemplateDialog = new WinkEditorExpandedTemplateDialog(new WinkEditorExpandedTemplateDialog.c(list, arrayList, arrayList2, this.L, d(), f(), g(), U(), W(), this.f322411c0, this.f322427i.getVisibility(), this.E.getDividerPosition()), new b());
        this.f322412d0 = winkEditorExpandedTemplateDialog;
        winkEditorExpandedTemplateDialog.show(((FragmentActivity) getContext()).getSupportFragmentManager(), "WinkEditorExpandedTemplateDialog");
    }

    private void s0() {
        int i3;
        ArrayList<MetaMaterial> arrayList;
        int visibility = this.T.getVisibility();
        MetaCategory metaCategory = this.J;
        if (metaCategory != null && (arrayList = metaCategory.materials) != null && !arrayList.isEmpty()) {
            this.T.setVisibility(4);
            this.S.setVisibility(0);
        } else {
            LinearLayout linearLayout = this.T;
            if (AECameraPrefsUtil.f318480r.equals(this.f322417i0)) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            linearLayout.setVisibility(i3);
            this.S.setVisibility(4);
        }
        this.D.B(0);
        this.U.setVisibility(4);
        this.V.setVisibility(4);
        if (this.T.getVisibility() == 0 && visibility != this.T.getVisibility()) {
            VideoReport.setElementId(this.f322418j0, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_LIBRARY);
            VideoReport.reportEvent("dt_imp", this.f322418j0, WinkDTParamBuilder.buildElementParams());
        }
    }

    private void t0() {
        this.T.setVisibility(4);
        this.S.setVisibility(4);
        this.U.setVisibility(0);
        this.D.B(1);
        this.V.setVisibility(4);
    }

    private ArrayList<MetaMaterial> v0(@NonNull List<MetaMaterial> list, List<MetaMaterial> list2) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            arrayList.addAll(list);
        }
        if (list2 != null && !list2.isEmpty()) {
            arrayList.addAll(list2);
        }
        ArrayList<MetaMaterial> arrayList2 = new ArrayList<>();
        for (String str : this.f322415g0) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    MetaMaterial metaMaterial = (MetaMaterial) it.next();
                    if (Objects.equals(metaMaterial.f30533id, str)) {
                        MetaMaterial copy = metaMaterial.copy();
                        com.tencent.mobileqq.wink.editor.c.o1(copy, "star");
                        com.tencent.mobileqq.wink.editor.c.p1(copy, "\u6536\u85cf");
                        if (!arrayList2.contains(copy)) {
                            arrayList2.add(copy);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    public void Q() {
        this.f322416h0 = null;
        this.N.a0(-1);
        this.P.a0(-1);
        this.Q.a0(-1);
    }

    public void R() {
        WinkEditorExpandedTemplateDialog winkEditorExpandedTemplateDialog = this.f322412d0;
        if (winkEditorExpandedTemplateDialog != null && winkEditorExpandedTemplateDialog.getDialog() != null && this.f322412d0.getDialog().isShowing()) {
            this.f322412d0.dismiss();
            this.f322412d0 = null;
        }
    }

    public int S(String str) {
        return this.Q.C(str);
    }

    public View T(MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            return null;
        }
        if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals("recommend")) {
            return this.f322409a0.findViewByPosition(com.tencent.mobileqq.wink.editor.c.g(this.K.materials, metaMaterial));
        }
        return this.f322410b0.findViewByPosition(com.tencent.mobileqq.wink.editor.c.g(this.L, metaMaterial));
    }

    public MetaMaterial V() {
        return this.f322416h0;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void d0() {
        x xVar = this.D;
        if (xVar != null) {
            xVar.notifyDataSetChanged();
        }
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar = this.Q;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar2 = this.N;
        if (aVar2 != null) {
            aVar2.notifyDataSetChanged();
        }
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar3 = this.P;
        if (aVar3 != null) {
            aVar3.notifyDataSetChanged();
        }
    }

    public void f0() {
        w53.b.a("WinkEditorTemplatePanel", "release called");
        setApplyMaterialTask(com.tencent.mobileqq.wink.flow.d.f322860d);
        RecyclerView recyclerView = this.V;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        RecyclerView recyclerView2 = this.U;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(null);
        }
        RecyclerView recyclerView3 = this.S;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(null);
        }
    }

    public void g0(int i3, MetaMaterial metaMaterial) {
        if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals("star")) {
            h0(this.S.findViewHolderForAdapterPosition(i3), metaMaterial);
        } else if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals("recommend")) {
            h0(this.U.findViewHolderForAdapterPosition(i3), metaMaterial);
        } else {
            h0(this.V.findViewHolderForAdapterPosition(i3), metaMaterial);
        }
    }

    public void k0(List<MetaMaterial> list) {
        int i3 = 0;
        while (true) {
            if (i3 < list.size()) {
                if (list.get(i3).hasRedDot) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        w53.b.a("WinkMaterialPanel", "scrollToFirstRedDot firstRedDot = " + i3);
        if (i3 >= 0) {
            com.tencent.mobileqq.wink.utils.b.i(this.V, this.Q.D(), i3, false, false);
        }
    }

    public boolean l0(String str) {
        int h16;
        MetaCategory metaCategory;
        int h17 = com.tencent.mobileqq.wink.editor.c.h(this.Q.B(), str);
        int h18 = com.tencent.mobileqq.wink.editor.c.h(this.P.B(), str);
        if (h17 == -1 && h18 == -1 && (h16 = com.tencent.mobileqq.wink.editor.c.h(this.G, str)) != -1 && (metaCategory = this.K) != null && metaCategory.materials != null) {
            MetaMaterial copy = this.G.get(h16).copy();
            com.tencent.mobileqq.wink.editor.c.o1(copy, "recommend");
            com.tencent.mobileqq.wink.editor.c.p1(copy, "\u63a8\u8350");
            this.K.materials.add(0, copy);
            this.P.i0(this.K.materials, this.G);
            if (this.P.Q(str)) {
                return true;
            }
        }
        if (this.Q.Q(str) || this.P.Q(str)) {
            return true;
        }
        return this.N.Q(str);
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    protected void m() {
        c cVar = new c();
        Context context = getContext();
        WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar = new com.tencent.mobileqq.wink.editor.template.templatepanel.a(context, editMode, cVar);
        this.Q = aVar;
        this.V.setAdapter(aVar);
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar2 = new com.tencent.mobileqq.wink.editor.template.templatepanel.a(getContext(), editMode, cVar);
        this.N = aVar2;
        this.S.setAdapter(aVar2);
        com.tencent.mobileqq.wink.editor.template.templatepanel.b bVar = new com.tencent.mobileqq.wink.editor.template.templatepanel.b(getContext(), editMode, new d(), cVar);
        this.P = bVar;
        this.U.setAdapter(bVar);
    }

    public void m0(int i3) {
        this.Q.R(i3);
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    protected void n(AttributeSet attributeSet) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        RecyclerView recyclerView = new RecyclerView(getContext());
        this.V = recyclerView;
        recyclerView.setOverScrollMode(2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.f322410b0 = linearLayoutManager;
        linearLayoutManager.setAutoMeasureEnabled(false);
        this.V.setLayoutManager(this.f322410b0);
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) this.V.getItemAnimator();
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2, 51.0f);
        frameLayout.addView(this.V, new LinearLayout.LayoutParams(-1, -2));
        this.S = new RecyclerView(getContext());
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), 0, false);
        this.W = linearLayoutManager2;
        linearLayoutManager2.setAutoMeasureEnabled(false);
        this.S.setLayoutManager(this.W);
        frameLayout.addView(this.S, layoutParams);
        X(getContext(), frameLayout);
        this.U = new RecyclerView(getContext());
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext(), 0, false);
        this.f322409a0 = linearLayoutManager3;
        linearLayoutManager3.setAutoMeasureEnabled(false);
        this.U.setLayoutManager(this.f322409a0);
        frameLayout.addView(this.U, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, com.tencent.mobileqq.util.x.c(getContext(), 12.0f), 0, 0);
        addView(frameLayout, layoutParams2);
        q0();
        this.V.addOnScrollListener(new a());
        setOnExpandBtnClickListener(new View.OnClickListener() { // from class: q73.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkEditorTemplatePanel.this.Y(view);
            }
        });
    }

    public void n0() {
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar = this.P;
        if (aVar != null && !aVar.B().isEmpty()) {
            t0();
            MetaMaterial metaMaterial = this.P.B().get(0);
            this.P.Q(metaMaterial.f30533id);
            w53.b.a("WinkEditorTemplatePanel", "selectDefaultRecommendMaterial material id: " + metaMaterial.f30533id);
            return;
        }
        w53.b.g("WinkEditorTemplatePanel", "selectDefaultRecommendMaterial failed: recommendMaterials is empty");
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public int o() {
        return 0;
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f0();
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    protected void r(x.a aVar, int i3, @Nullable MetaCategory metaCategory) {
        if (metaCategory == null) {
            return;
        }
        if (Objects.equals(metaCategory.f30532id, "star")) {
            s0();
            com.tencent.mobileqq.wink.utils.b.h(this.S, this.N.D(), 0, 8.0f);
        } else {
            if (Objects.equals(metaCategory.f30532id, "recommend")) {
                t0();
                com.tencent.mobileqq.wink.utils.b.h(this.U, this.P.D(), 0, 8.0f);
                return;
            }
            q0();
            int e16 = com.tencent.mobileqq.wink.editor.c.e(this.F, this.L, i3);
            if (aVar != null) {
                com.tencent.mobileqq.wink.utils.b.h(this.V, this.Q.D(), e16, 8.0f);
            } else {
                com.tencent.mobileqq.wink.utils.b.i(this.V, this.Q.D(), e16, false, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void s() {
        super.s();
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void setApplyMaterialTask(ApplyMaterialTask applyMaterialTask) {
        this.Q.S(applyMaterialTask);
        this.N.S(applyMaterialTask);
        this.P.S(applyMaterialTask);
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void setDisableClick(boolean z16) {
        this.Q.T(z16);
        this.N.T(z16);
        this.P.T(z16);
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void setEditableOverlay(MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            this.f322411c0 = false;
            this.N.v0(null);
            this.P.v0(null);
            this.Q.v0(null);
            return;
        }
        if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals("star")) {
            this.f322411c0 = true;
            this.N.v0(metaMaterial);
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar = this.P;
            aVar.v0(aVar.A(metaMaterial.f30533id));
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar2 = this.Q;
            aVar2.v0(aVar2.A(metaMaterial.f30533id));
            return;
        }
        if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals("recommend")) {
            this.f322411c0 = true;
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar3 = this.N;
            aVar3.v0(aVar3.A(metaMaterial.f30533id));
            this.P.v0(metaMaterial);
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar4 = this.Q;
            aVar4.v0(aVar4.A(metaMaterial.f30533id));
            return;
        }
        this.f322411c0 = true;
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar5 = this.N;
        aVar5.v0(aVar5.A(metaMaterial.f30533id));
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar6 = this.P;
        aVar6.v0(aVar6.A(metaMaterial.f30533id));
        this.Q.v0(metaMaterial);
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void setFilterButtonChecked(boolean z16) {
        super.setFilterButtonChecked(z16);
        WinkEditorExpandedTemplateDialog winkEditorExpandedTemplateDialog = this.f322412d0;
        if (winkEditorExpandedTemplateDialog != null && winkEditorExpandedTemplateDialog.getDialog() != null && this.f322412d0.getDialog().isShowing()) {
            this.f322412d0.Ah(z16);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void setItemSelectListener(g.a aVar) {
        this.f322413e0 = aVar;
        this.Q.W(aVar);
        this.N.W(aVar);
        this.P.W(aVar);
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void setOnFilterBtnClickListener(View.OnClickListener onClickListener) {
        this.f322414f0 = onClickListener;
        super.setOnFilterBtnClickListener(onClickListener);
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void setSelectedMaterial(final MetaMaterial metaMaterial) {
        MetaCategory metaCategory;
        ArrayList<MetaMaterial> arrayList;
        if (metaMaterial == null) {
            return;
        }
        this.f322416h0 = metaMaterial;
        this.D.B(com.tencent.mobileqq.wink.editor.c.d(this.F, com.tencent.mobileqq.wink.editor.c.o(metaMaterial)));
        metaMaterial.hasRedDot = false;
        if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals("star")) {
            s0();
            this.N.e0(metaMaterial);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: q73.h
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorTemplatePanel.this.a0(metaMaterial);
                }
            });
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar = this.P;
            aVar.c0(aVar.C(metaMaterial.f30533id), false, false);
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar2 = this.Q;
            aVar2.c0(aVar2.C(metaMaterial.f30533id), false, false);
            return;
        }
        if (com.tencent.mobileqq.wink.editor.c.o(metaMaterial).equals("recommend")) {
            if (com.tencent.mobileqq.wink.editor.c.g(this.P.B(), metaMaterial) == -1 && (metaCategory = this.K) != null && (arrayList = metaCategory.materials) != null) {
                arrayList.add(0, metaMaterial);
                this.P.i0(this.K.materials, this.G);
            }
            t0();
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar3 = this.N;
            aVar3.c0(aVar3.C(metaMaterial.f30533id), false, false);
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar4 = this.Q;
            aVar4.c0(aVar4.C(metaMaterial.f30533id), false, false);
            this.P.e0(metaMaterial);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: q73.i
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorTemplatePanel.this.b0(metaMaterial);
                }
            });
            return;
        }
        q0();
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar5 = this.N;
        aVar5.c0(aVar5.C(metaMaterial.f30533id), false, false);
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar6 = this.P;
        aVar6.c0(aVar6.C(metaMaterial.f30533id), false, false);
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar7 = this.Q;
        aVar7.R = true;
        aVar7.e0(metaMaterial);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: q73.j
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorTemplatePanel.this.c0(metaMaterial);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void setup(@NonNull List<MetaCategory> list, @NonNull List<MetaMaterial> list2, List<MetaMaterial> list3, boolean z16, boolean z17, String str, List<MetaCategory> list4, boolean z18) {
        String str2;
        ArrayList<MetaMaterial> arrayList;
        this.f322417i0 = str;
        this.G = list3;
        this.R = z18;
        this.K = null;
        this.M = list4;
        this.L.clear();
        MetaCategory metaCategory = this.J;
        if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
            arrayList.clear();
        }
        boolean z19 = true;
        for (MetaCategory metaCategory2 : list) {
            w53.b.a("WinkEditorTemplatePanel", metaCategory2.f30532id + "," + metaCategory2.name);
            if (Objects.equals(metaCategory2.f30532id, "recommend")) {
                this.K = metaCategory2;
                ArrayList<MetaMaterial> arrayList2 = metaCategory2.materials;
                if (arrayList2 != null) {
                    arrayList2.clear();
                }
            } else if (Objects.equals(metaCategory2.f30532id, "star")) {
                z19 = false;
            }
        }
        for (MetaMaterial metaMaterial : list2) {
            if (!Objects.equals(com.tencent.mobileqq.wink.editor.c.o(metaMaterial), "recommend")) {
                this.L.add(metaMaterial);
            } else {
                MetaCategory metaCategory3 = this.K;
                if (metaCategory3 != null) {
                    metaCategory3.materials.add(metaMaterial);
                }
            }
        }
        this.F = list;
        if (!z17) {
            this.f322415g0 = new ArrayList(f.e().d());
            MetaCategory c16 = h.d().c(list2, list3);
            this.J = c16;
            if (!z18) {
                this.F.add(0, c16);
            }
        } else if (!z18) {
            if (z19) {
                list.add(0, this.J);
            }
            MetaCategory metaCategory4 = this.J;
            if (metaCategory4 != null) {
                metaCategory4.materials = v0(list2, list3);
            }
        }
        MetaMaterial metaMaterial2 = this.f322416h0;
        if (metaMaterial2 != null) {
            str2 = metaMaterial2.f30533id;
        } else {
            str2 = "";
        }
        this.Q.w0(!this.R);
        this.Q.i0(this.L, null);
        com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar = this.Q;
        aVar.c0(aVar.C(str2), false, false);
        this.D.E(this.F);
        MetaCategory metaCategory5 = this.J;
        if (metaCategory5 != null) {
            this.N.i0(metaCategory5.materials, null);
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar2 = this.N;
            aVar2.c0(aVar2.C(str2), false, false);
        }
        if (this.K != null) {
            this.P.w0(!this.R);
            this.P.i0(this.K.materials, null);
            com.tencent.mobileqq.wink.editor.template.templatepanel.a aVar3 = this.P;
            aVar3.c0(aVar3.C(str2), false, false);
        }
        if (z16) {
            k0(this.L);
        }
        MetaCategory metaCategory6 = this.K;
        if (metaCategory6 != null && !this.R) {
            this.E.b(1);
        } else if (metaCategory6 == null && !this.R) {
            this.E.b(0);
        } else {
            this.E.b(-1);
        }
        String i3 = i();
        if (!"recommend".equals(i3) && z17) {
            if ("star".equals(i3)) {
                s0();
            } else {
                q0();
            }
        } else if (this.K == null) {
            q0();
        } else {
            t0();
        }
        if (this.f322411c0) {
            p0(str2);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void t() {
        super.t();
        if (this.T.getVisibility() == 0) {
            VideoReport.setElementId(this.f322418j0, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_LIBRARY);
            VideoReport.reportEvent("dt_imp", this.f322418j0, WinkDTParamBuilder.buildElementParams());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase
    public void u(int i3, boolean z16) {
        super.u(i3, z16);
        if (i3 >= 0) {
            String i16 = i();
            i16.hashCode();
            if (!i16.equals("star")) {
                if (!i16.equals("recommend")) {
                    this.f322410b0.scrollToPositionWithOffset(com.tencent.mobileqq.wink.editor.c.e(this.F, this.L, i3), 0);
                    return;
                } else {
                    this.f322409a0.scrollToPositionWithOffset(0, 0);
                    return;
                }
            }
            this.W.scrollToPositionWithOffset(0, 0);
        }
    }

    public void u0() {
        ArrayList<MetaMaterial> arrayList;
        WinkEditorExpandedTemplateDialog winkEditorExpandedTemplateDialog = this.f322412d0;
        if (winkEditorExpandedTemplateDialog != null && winkEditorExpandedTemplateDialog.getDialog() != null && this.f322412d0.getDialog().isShowing()) {
            WinkEditorExpandedTemplateDialog winkEditorExpandedTemplateDialog2 = this.f322412d0;
            List<MetaCategory> list = this.F;
            MetaCategory metaCategory = this.J;
            ArrayList<MetaMaterial> arrayList2 = null;
            if (metaCategory != null) {
                arrayList = metaCategory.materials;
            } else {
                arrayList = null;
            }
            MetaCategory metaCategory2 = this.K;
            if (metaCategory2 != null) {
                arrayList2 = metaCategory2.materials;
            }
            winkEditorExpandedTemplateDialog2.Bh(list, arrayList, arrayList2, this.L, W(), this.M, this.E.getDividerPosition());
        }
    }

    public WinkEditorTemplatePanel(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WinkEditorTemplatePanel(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.L = new ArrayList();
        this.M = new ArrayList();
        this.R = false;
        this.f322411c0 = false;
        this.f322416h0 = null;
        this.f322417i0 = AECameraPrefsUtil.f318480r;
    }
}
