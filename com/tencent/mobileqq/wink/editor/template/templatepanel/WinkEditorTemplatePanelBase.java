package com.tencent.mobileqq.wink.editor.template.templatepanel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.template.g;
import com.tencent.mobileqq.wink.editor.template.templatepanel.WinkEditorTemplatePanelBase;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.wink.reddot.WinkMaterialRedDotManager;
import com.tencent.mobileqq.wink.view.x;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q73.f;

/* loaded from: classes21.dex */
public abstract class WinkEditorTemplatePanelBase extends LinearLayout {
    protected ImageView C;
    protected x D;
    protected f E;
    protected List<MetaCategory> F;
    protected List<MetaMaterial> G;
    private String H;
    protected boolean I;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f322423d;

    /* renamed from: e, reason: collision with root package name */
    protected RecyclerView f322424e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f322425f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f322426h;

    /* renamed from: i, reason: collision with root package name */
    protected ImageView f322427i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f322428m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements x.b {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.view.x.b
        public void a(x.a aVar, int i3, @Nullable MetaCategory metaCategory) {
            WinkEditorTemplatePanelBase.b(WinkEditorTemplatePanelBase.this);
            WinkEditorTemplatePanelBase winkEditorTemplatePanelBase = WinkEditorTemplatePanelBase.this;
            winkEditorTemplatePanelBase.I = true;
            winkEditorTemplatePanelBase.r(aVar, i3, metaCategory);
        }

        @Override // com.tencent.mobileqq.wink.view.x.b
        public void b(x.a aVar, int i3, @Nullable MetaCategory metaCategory) {
            WinkEditorTemplatePanelBase.b(WinkEditorTemplatePanelBase.this);
        }
    }

    /* loaded from: classes21.dex */
    public interface b {
    }

    public WinkEditorTemplatePanelBase(Context context) {
        this(context, null);
    }

    static /* bridge */ /* synthetic */ b b(WinkEditorTemplatePanelBase winkEditorTemplatePanelBase) {
        winkEditorTemplatePanelBase.getClass();
        return null;
    }

    private void j(@Nullable AttributeSet attributeSet) {
        setOrientation(1);
        l();
        n(attributeSet);
        k();
        m();
    }

    private void k() {
        x xVar = new x(new ArrayList(), new a());
        this.D = xVar;
        xVar.A(new x.c() { // from class: q73.m
            @Override // com.tencent.mobileqq.wink.view.x.c
            public final void a(int i3, MetaCategory metaCategory) {
                WinkEditorTemplatePanelBase.this.p(i3, metaCategory);
            }
        });
        this.f322424e.setAdapter(this.D);
    }

    private void l() {
        String str;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f322423d = linearLayout;
        linearLayout.setOrientation(0);
        this.f322423d.setGravity(16);
        this.f322425f = new ImageView(getContext());
        int c16 = com.tencent.mobileqq.util.x.c(getContext(), 10.0f);
        this.f322425f.setPadding(c16, c16, c16, c16);
        int c17 = com.tencent.mobileqq.util.x.c(getContext(), 40.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c17, c17);
        layoutParams.setMargins(com.tencent.mobileqq.util.x.c(getContext(), 10.0f), 0, 0, 0);
        this.f322423d.addView(this.f322425f, layoutParams);
        setClearButtonEnable(false);
        int c18 = com.tencent.mobileqq.util.x.c(getContext(), 10.0f);
        int c19 = com.tencent.mobileqq.util.x.c(getContext(), 20.0f);
        int c26 = com.tencent.mobileqq.util.x.c(getContext(), 6.0f);
        int c27 = com.tencent.mobileqq.util.x.c(getContext(), 14.0f);
        int c28 = com.tencent.mobileqq.util.x.c(getContext(), 16.0f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RecyclerView recyclerView = new RecyclerView(getContext());
        this.f322424e = recyclerView;
        recyclerView.setOverScrollMode(2);
        this.f322424e.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) this.f322424e.getItemAnimator();
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        relativeLayout.addView(this.f322424e, -1, -1);
        c(c27, c19, relativeLayout);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.weight = 1.0f;
        this.f322423d.addView(relativeLayout, layoutParams2);
        addView(this.f322423d, new LinearLayout.LayoutParams(-1, com.tencent.mobileqq.util.x.c(getContext(), 40.0f)));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.f322426h = linearLayout2;
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, c19);
        layoutParams3.setMargins(0, 0, c28, 0);
        this.f322426h.setPadding(c27, 0, 0, 0);
        this.f322423d.addView(this.f322426h, layoutParams3);
        this.f322427i = new ImageView(getContext());
        this.f322426h.addView(this.f322427i, new LinearLayout.LayoutParams(c19, c19));
        setFilterButtonChecked(false);
        this.f322428m = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(c26, c26);
        this.f322428m.setBackgroundResource(R.drawable.f162020l71);
        this.f322426h.addView(this.f322428m, layoutParams4);
        this.f322428m.setVisibility(8);
        this.C = new ImageView(getContext());
        v(true);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(c19, c19);
        layoutParams5.setMargins(c18, 0, 0, 0);
        this.f322426h.addView(this.C, layoutParams5);
        f fVar = new f();
        this.E = fVar;
        this.f322424e.addItemDecoration(fVar);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_BIG_PANEL, Integer.valueOf(o()));
        VideoReport.setElementId(this.f322427i, WinkDaTongReportConstant.ElementId.EM_XSJ_RHYFILTER_BUTTON);
        VideoReport.setElementParams(this.f322427i, buildElementParams);
        ImageView imageView = this.f322427i;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(imageView, clickPolicy);
        ImageView imageView2 = this.f322427i;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(imageView2, exposurePolicy);
        Map<String, Object> buildElementParams2 = WinkDTParamBuilder.buildElementParams();
        if (o() == 1) {
            str = QCircleDaTongConstant.ElementParamValue.PYMK_FOLD;
        } else {
            str = "expand";
        }
        buildElementParams2.put("xsj_action_type", str);
        VideoReport.setElementId(this.C, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_LIBRARY_EXPAND_FOLD_BUTTON);
        VideoReport.setElementParams(this.C, buildElementParams2);
        VideoReport.setElementClickPolicy(this.C, clickPolicy);
        VideoReport.setElementExposePolicy(this.C, exposurePolicy);
        Map<String, Object> buildElementParams3 = WinkDTParamBuilder.buildElementParams();
        VideoReport.setElementId(this.f322425f, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_CLOSE_TEMPLATE_BUTTON);
        VideoReport.setElementParams(this.f322425f, buildElementParams3);
        VideoReport.setElementClickPolicy(this.f322425f, clickPolicy);
        VideoReport.setElementExposePolicy(this.f322425f, exposurePolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(int i3, MetaCategory metaCategory) {
        if (metaCategory != null) {
            w53.b.a("WinkMaterialPanel", "Select position = " + i3 + " id = " + metaCategory.f30532id);
            WinkMaterialRedDotManager.f326249a.c(metaCategory.f30532id);
            this.H = metaCategory.f30532id;
        }
    }

    protected void c(int i3, int i16, RelativeLayout relativeLayout) {
        View view = new View(getContext());
        view.setBackgroundResource(R.drawable.l5r);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i16);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        relativeLayout.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d() {
        return this.f322425f.isEnabled();
    }

    public ImageView e() {
        return this.f322427i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f() {
        if (this.f322427i.getTag() instanceof Boolean) {
            return ((Boolean) this.f322427i.getTag()).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        ImageView imageView = this.f322428m;
        if (imageView == null || imageView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public int h(String str) {
        x xVar;
        if (str != null && (xVar = this.D) != null) {
            return xVar.s(str);
        }
        return -1;
    }

    public String i() {
        return this.H;
    }

    protected abstract void m();

    protected abstract void n(AttributeSet attributeSet);

    public abstract int o();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RecyclerView recyclerView = this.f322424e;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
    }

    public void q(List<String> list) {
        if (list != null && !list.isEmpty()) {
            list.remove(WinkMaterialRedDotManager.f326249a.a(MenuType.VIDEO_TEMPLATE));
            if (list.isEmpty()) {
                return;
            }
            this.D.y(list);
        }
    }

    protected abstract void r(x.a aVar, int i3, @Nullable MetaCategory metaCategory);

    public void s() {
        String str;
        WinkDTParamBuilder.buildElementParams();
        VideoReport.setElementId(this.f322425f, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_CLOSE_TEMPLATE_BUTTON);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (o() == 1) {
            str = QCircleDaTongConstant.ElementParamValue.PYMK_FOLD;
        } else {
            str = "expand";
        }
        buildElementParams.put("xsj_action_type", str);
        VideoReport.reportEvent("dt_imp_end", this.f322425f, buildElementParams);
        VideoReport.traversePage(this.f322424e);
    }

    public void setClearButtonEnable(boolean z16) {
        int i3;
        this.f322425f.setEnabled(z16);
        ImageView imageView = this.f322425f;
        if (z16) {
            i3 = R.drawable.owd;
        } else {
            i3 = R.drawable.owe;
        }
        imageView.setImageResource(i3);
    }

    public void setFilterBtnVisibility(int i3) {
        this.f322427i.setVisibility(i3);
    }

    public void setFilterButtonChecked(boolean z16) {
        int i3;
        ImageView imageView = this.f322427i;
        if (imageView != null) {
            if (z16) {
                i3 = R.drawable.nro;
            } else {
                i3 = R.drawable.nrp;
            }
            imageView.setImageResource(i3);
            this.f322427i.setTag(Boolean.valueOf(z16));
        }
    }

    public void setOnClearButtonClickListener(View.OnClickListener onClickListener) {
        this.f322425f.setOnClickListener(onClickListener);
    }

    public void setOnExpandBtnClickListener(View.OnClickListener onClickListener) {
        this.C.setOnClickListener(onClickListener);
    }

    public void setOnFilterBtnClickListener(View.OnClickListener onClickListener) {
        this.f322427i.setOnClickListener(onClickListener);
    }

    public void t() {
        Object obj;
        VideoReport.setElementId(this.f322427i, WinkDaTongReportConstant.ElementId.EM_XSJ_RHYFILTER_BUTTON);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_BIG_PANEL, Integer.valueOf(o()));
        VideoReport.reportEvent("dt_imp", this.f322427i, buildElementParams);
        VideoReport.setElementId(this.C, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_LIBRARY_EXPAND_FOLD_BUTTON);
        Map<String, Object> buildElementParams2 = WinkDTParamBuilder.buildElementParams();
        int o16 = o();
        String str = QCircleDaTongConstant.ElementParamValue.PYMK_FOLD;
        if (o16 != 1) {
            obj = "expand";
        } else {
            obj = QCircleDaTongConstant.ElementParamValue.PYMK_FOLD;
        }
        buildElementParams2.put("xsj_action_type", obj);
        VideoReport.reportEvent("dt_imp", this.C, buildElementParams2);
        VideoReport.setElementId(this.f322425f, WinkDaTongReportConstant.ElementId.EM_XSJ_TEMPLATE_CLOSE_TEMPLATE_BUTTON);
        Map<String, Object> buildElementParams3 = WinkDTParamBuilder.buildElementParams();
        if (o() != 1) {
            str = "expand";
        }
        buildElementParams3.put("xsj_action_type", str);
        VideoReport.reportEvent("dt_imp", this.f322425f, buildElementParams3);
    }

    public void u(int i3, boolean z16) {
        int i16;
        x xVar = this.D;
        if (xVar != null) {
            if (i3 < 0) {
                i16 = xVar.getItemCount() - 1;
            } else {
                i16 = i3;
            }
            this.H = this.D.r(i16);
            this.I = true;
            this.D.z(i3, z16);
            w53.b.a("scrollCatAdapterToPosition", "selectedCatId = " + this.H);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(boolean z16) {
        this.C.setImageResource(R.drawable.nrh);
        if (!z16) {
            this.C.setRotation(180.0f);
        }
    }

    public void w(boolean z16) {
        if (this.f322426h == null) {
            return;
        }
        if (z16) {
            this.f322428m.setVisibility(0);
        } else {
            this.f322428m.setVisibility(8);
        }
    }

    public WinkEditorTemplatePanelBase(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WinkEditorTemplatePanelBase(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        j(attributeSet);
    }

    public void setApplyMaterialTask(ApplyMaterialTask applyMaterialTask) {
    }

    public void setCategoryItemListener(b bVar) {
    }

    public void setDisableClick(boolean z16) {
    }

    public void setEditableOverlay(MetaMaterial metaMaterial) {
    }

    public void setItemSelectListener(g.a aVar) {
    }

    public void setSelectedMaterial(MetaMaterial metaMaterial) {
    }

    public void setup(@NonNull List<MetaCategory> list, @NonNull List<MetaMaterial> list2, List<MetaMaterial> list3, boolean z16, boolean z17, String str, List<MetaCategory> list4, boolean z18) {
    }
}
