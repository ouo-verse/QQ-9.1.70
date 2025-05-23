package com.tencent.mobileqq.qqlive.sail.ui.ecommerce;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.sail.model.anchor.SettingInfo;
import com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAnchorECViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R#\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/QQLiveAnchorECPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/QQLiveAnchorECViewModel$b;", "it", "", "ra", "qa", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "V9", "Y9", "U9", "Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/QQLiveAnchorECViewModel;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "na", "()Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/QQLiveAnchorECViewModel;", "ecommerceViewModel", "f", "Landroid/view/View;", "entryGoodsLayout", "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "entryGoodsNumLayout", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "entryGoodsNumTextView", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAnchorECPart extends com.tencent.mobileqq.qqlive.sail.base.c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy ecommerceViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View entryGoodsLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout entryGoodsNumLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView entryGoodsNumTextView;

    public QQLiveAnchorECPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQLiveAnchorECViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAnchorECPart$ecommerceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQLiveAnchorECViewModel invoke() {
                return (QQLiveAnchorECViewModel) QQLiveAnchorECPart.this.getViewModel(QQLiveAnchorECViewModel.class);
            }
        });
        this.ecommerceViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQLiveAnchorECViewModel na() {
        return (QQLiveAnchorECViewModel) this.ecommerceViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(QQLiveAnchorECPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new QQLiveAnchorECPart$onInitView$1$1(this$0, null), 3, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void qa() {
        Map<String, String> mutableMapOf;
        HashMap<String, String> a16 = com.tencent.mobileqq.qqlive.sail.report.a.f272382a.f(H9()).a();
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : a16.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        cj4.c.f31003a.c("ACTION_SETUP_LIVE_REPORT_INFO", bundle, null);
        View view = this.entryGoodsLayout;
        if (view != null) {
            nf4.d liveReportUtil = ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("qqlive_anchor_button_type", "5"));
            liveReportUtil.reportEvent("imp", view, mutableMapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra(QQLiveAnchorECViewModel.GoodsViewObject it) {
        com.tencent.mobileqq.qqlive.sail.room.c cVar;
        SettingInfo a16;
        int i3;
        int productNum = it.getProductNum() + it.getShopProductNum();
        FrameLayout frameLayout = this.entryGoodsNumLayout;
        if (frameLayout != null) {
            if (it.getGoodsNumVisible()) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            frameLayout.setVisibility(i3);
            if (productNum > 999) {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                layoutParams.width = -2;
                frameLayout.setLayoutParams(layoutParams);
            } else if (productNum >= 100) {
                ViewGroup.LayoutParams layoutParams2 = frameLayout.getLayoutParams();
                layoutParams2.width = ViewUtils.dip2px(24.0f);
                layoutParams2.height = ViewUtils.dip2px(14.0f);
                frameLayout.setLayoutParams(layoutParams2);
            } else {
                ViewGroup.LayoutParams layoutParams3 = frameLayout.getLayoutParams();
                layoutParams3.width = -2;
                layoutParams3.height = -2;
                frameLayout.setLayoutParams(layoutParams3);
            }
        }
        TextView textView = this.entryGoodsNumTextView;
        if (textView != null) {
            textView.setText(String.valueOf(productNum));
        }
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.c) {
            cVar = (com.tencent.mobileqq.qqlive.sail.room.c) F9;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            a16 = r4.a((r24 & 1) != 0 ? r4.roomType : 0, (r24 & 2) != 0 ? r4.roomName : null, (r24 & 4) != 0 ? r4.locationInfo : null, (r24 & 8) != 0 ? r4.coverInfo : null, (r24 & 16) != 0 ? r4.enableGif : false, (r24 & 32) != 0 ? r4.streamRecordType : 0, (r24 & 64) != 0 ? r4.styleInfo : null, (r24 & 128) != 0 ? r4.isPrivateLive : false, (r24 & 256) != 0 ? r4.source : null, (r24 & 512) != 0 ? r4.isECGoodsLive : na().a2(), (r24 & 1024) != 0 ? cVar.b().r().openTabLevel : na().T1());
            cVar.B(null, a16);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        if (F9() != null) {
            na().e2();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            na().f2();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        super.V9();
        na().f2();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void Y9() {
        com.tencent.mobileqq.qqlive.sail.model.d dVar;
        QQLiveAnchorECViewModel na5 = na();
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            dVar = F9.b();
        } else {
            dVar = null;
        }
        na5.g2(dVar);
        qa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.entryGoodsLayout = rootView.findViewById(R.id.f60322v4);
        this.entryGoodsNumLayout = (FrameLayout) rootView.findViewById(R.id.f60332v5);
        this.entryGoodsNumTextView = (TextView) rootView.findViewById(R.id.f60342v6);
        FrameLayout frameLayout = this.entryGoodsNumLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        View view = this.entryGoodsLayout;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QQLiveAnchorECPart.oa(QQLiveAnchorECPart.this, view2);
                }
            });
        }
        MutableLiveData<QQLiveAnchorECViewModel.GoodsViewObject> P1 = na().P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QQLiveAnchorECViewModel.GoodsViewObject, Unit> function1 = new Function1<QQLiveAnchorECViewModel.GoodsViewObject, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveAnchorECPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveAnchorECViewModel.GoodsViewObject goodsViewObject) {
                invoke2(goodsViewObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QQLiveAnchorECViewModel.GoodsViewObject it) {
                QQLiveAnchorECPart qQLiveAnchorECPart = QQLiveAnchorECPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQLiveAnchorECPart.ra(it);
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveAnchorECPart.pa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        QQLiveAnchorECViewModel na5 = na();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        na5.W1(intent);
    }
}
