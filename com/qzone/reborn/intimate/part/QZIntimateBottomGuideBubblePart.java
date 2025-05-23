package com.qzone.reborn.intimate.part;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimateBottomGuideBubblePart;", "Lcom/qzone/reborn/base/k;", "", "F9", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "uiStateData", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lnk/at;", "d", "Lnk/at;", "mainTabViewModel", "e", "Landroid/view/View;", "bubbleRoot", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateBottomGuideBubblePart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.at mainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View bubbleRoot;

    private final void F9() {
        mk.d dVar = mk.d.f416875a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        dVar.J(context);
        fo.c.d("em_qz_guest_suspension_inlet", "pg_qz_intimate_space_home", this.bubbleRoot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(UIStateData<QZoneIntimateSpaceBean> uiStateData) {
        View view;
        int state = uiStateData.getState();
        if (state != 2 && state != 3) {
            if (state == 4 && (view = this.bubbleRoot) != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        mk.d dVar = mk.d.f416875a;
        QZoneIntimateSpaceBean data = uiStateData.getData();
        Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
        if (dVar.I(data)) {
            View view2 = this.bubbleRoot;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(8);
            return;
        }
        nk.at atVar = this.mainTabViewModel;
        nk.at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar = null;
        }
        if (!atVar.getIsDraft()) {
            nk.at atVar3 = this.mainTabViewModel;
            if (atVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            } else {
                atVar2 = atVar3;
            }
            if (atVar2.getMIsIntercept() != 1) {
                View view3 = this.bubbleRoot;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                fo.c.f("em_qz_guest_suspension_inlet", "pg_qz_intimate_space_home", this.bubbleRoot);
                return;
            }
        }
        View view4 = this.bubbleRoot;
        if (view4 == null) {
            return;
        }
        view4.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(QZIntimateBottomGuideBubblePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(nk.at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        nk.at atVar = (nk.at) viewModel;
        this.mainTabViewModel = atVar;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar = null;
        }
        QZoneIntimateMainPageInitBean initBean = atVar.getInitBean();
        boolean z16 = false;
        if (initBean != null && !initBean.getIsFromQRCode()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        nk.at atVar2 = this.mainTabViewModel;
        if (atVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar2 = null;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar2.U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateBottomGuideBubblePart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> it) {
                QZIntimateBottomGuideBubblePart qZIntimateBottomGuideBubblePart = QZIntimateBottomGuideBubblePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZIntimateBottomGuideBubblePart.G9(it);
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateBottomGuideBubblePart.H9(Function1.this, obj);
            }
        });
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.cjd, (ViewGroup) null);
        this.bubbleRoot = inflate;
        if (inflate == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, com.qzone.util.ar.e(50.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = com.qzone.util.ar.e(140.0f);
        View view = this.bubbleRoot;
        Intrinsics.checkNotNull(view);
        view.setVisibility(8);
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) rootView).addView(this.bubbleRoot, layoutParams);
        View view2 = this.bubbleRoot;
        Intrinsics.checkNotNull(view2);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                QZIntimateBottomGuideBubblePart.I9(QZIntimateBottomGuideBubblePart.this, view3);
            }
        });
    }
}
