package com.tencent.mobileqq.wink.qzone.templatelibrary.part;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/o;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "A9", "initViewModel", "onInitView", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleTextView", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "templateRecyclerView", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "f", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "templateViewModel", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class o extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titleTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView templateRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibViewModel templateViewModel;

    private final void A9(View rootView) {
        this.titleTextView = (TextView) rootView.findViewById(R.id.f124497ji);
        View findViewById = rootView.findViewById(R.id.f124437jc);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.B9(o.this, view);
                }
            });
        }
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.f124507jj);
        if (viewGroup != null) {
            int statusBarHeight = RFWImmersiveUtils.getStatusBarHeight(viewGroup.getContext());
            viewGroup.getLayoutParams().height = ViewUtils.dpToPx(44.0f) + statusBarHeight;
        }
        QQBlurViewWrapper qQBlurViewWrapper = (QQBlurViewWrapper) rootView.findViewById(R.id.f99755qn);
        boolean b16 = com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.b();
        RecyclerView recyclerView = this.templateRecyclerView;
        ColorDrawable colorDrawable = new ColorDrawable(qQBlurViewWrapper.getContext().getColor(R.color.qui_common_bg_bottom_light));
        colorDrawable.setAlpha(204);
        Unit unit = Unit.INSTANCE;
        f.a aVar = new f.a(b16, 80.0f, recyclerView, 0, colorDrawable, Integer.valueOf(R.drawable.qui_common_bg_bottom_light_bg));
        aVar.l(true);
        qQBlurViewWrapper.a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(o this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.report.e.m(eVar, it, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, null, null, 12, null);
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(o this$0, WinkQZoneTemplateLibViewModel.DetailPageData detailPageData) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.titleTextView;
        if (textView != null) {
            MetaCategory currentMaterialCategory = detailPageData.getCurrentMaterialCategory();
            if (currentMaterialCategory == null || (str = currentMaterialCategory.name) == null) {
                str = "";
            }
            textView.setText(str);
        }
    }

    private final void initViewModel() {
        LiveData<WinkQZoneTemplateLibViewModel.DetailPageData> O1;
        WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel = (WinkQZoneTemplateLibViewModel) getViewModel(WinkQZoneTemplateLibViewModel.class);
        this.templateViewModel = winkQZoneTemplateLibViewModel;
        if (winkQZoneTemplateLibViewModel != null && (O1 = winkQZoneTemplateLibViewModel.O1()) != null) {
            O1.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    o.C9(o.this, (WinkQZoneTemplateLibViewModel.DetailPageData) obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        A9(rootView);
        initViewModel();
    }
}
