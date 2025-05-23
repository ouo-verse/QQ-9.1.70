package com.tencent.mobileqq.wink.aiavatar.detailpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarGenerateBtnViewModel;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.mobileqq.wink.aiavatar.view.WinkAIAvatarGenerateBtn;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$GetStatusReply;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/detailpage/WinkAIAvatarMaterialDetailUIStatePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "H9", "initViewModel", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "btnStatus", "G9", "", "D9", "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", "d", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", "makeSameKindBtn", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "generateChanceText", "Lcom/tencent/mobileqq/wink/aiavatar/detailpage/WinkAIAvatarMaterialDetailViewModel;", "f", "Lkotlin/Lazy;", "F9", "()Lcom/tencent/mobileqq/wink/aiavatar/detailpage/WinkAIAvatarMaterialDetailViewModel;", "materialDetailViewModel", "Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarGenerateBtnViewModel;", tl.h.F, "E9", "()Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarGenerateBtnViewModel;", "generateBtnViewModel", "<init>", "()V", "i", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarMaterialDetailUIStatePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkAIAvatarGenerateBtn makeSameKindBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView generateChanceText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy materialDetailViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy generateBtnViewModel;

    public WinkAIAvatarMaterialDetailUIStatePart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarMaterialDetailViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.WinkAIAvatarMaterialDetailUIStatePart$materialDetailViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarMaterialDetailViewModel invoke() {
                return (WinkAIAvatarMaterialDetailViewModel) WinkAIAvatarMaterialDetailUIStatePart.this.getViewModel(WinkAIAvatarMaterialDetailViewModel.class);
            }
        });
        this.materialDetailViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarGenerateBtnViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.WinkAIAvatarMaterialDetailUIStatePart$generateBtnViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarGenerateBtnViewModel invoke() {
                return (WinkAIAvatarGenerateBtnViewModel) WinkAIAvatarMaterialDetailUIStatePart.this.getViewModel(WinkAIAvatarGenerateBtnViewModel.class);
            }
        });
        this.generateBtnViewModel = lazy2;
    }

    private final boolean D9() {
        WinkAIAvatarGenerateBtnViewModel E9 = E9();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return E9.O1(context, true, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.WinkAIAvatarMaterialDetailUIStatePart$checkGenerateChance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
                Activity activity = WinkAIAvatarMaterialDetailUIStatePart.this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                final WinkAIAvatarMaterialDetailUIStatePart winkAIAvatarMaterialDetailUIStatePart = WinkAIAvatarMaterialDetailUIStatePart.this;
                WinkAIAvatarUtils.D(winkAIAvatarUtils, activity, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.WinkAIAvatarMaterialDetailUIStatePart$checkGenerateChance$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        WinkAIAvatarGenerateBtnViewModel E92;
                        E92 = WinkAIAvatarMaterialDetailUIStatePart.this.E9();
                        E92.c2();
                    }
                }, null, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkAIAvatarGenerateBtnViewModel E9() {
        Object value = this.generateBtnViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-generateBtnViewModel>(...)");
        return (WinkAIAvatarGenerateBtnViewModel) value;
    }

    private final WinkAIAvatarMaterialDetailViewModel F9() {
        Object value = this.materialDetailViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-materialDetailViewModel>(...)");
        return (WinkAIAvatarMaterialDetailViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(ShadowAIGCStatus$GetStatusReply btnStatus) {
        if (btnStatus == null) {
            return;
        }
        TextView textView = this.generateChanceText;
        if (textView != null) {
            textView.setText(com.tencent.mobileqq.wink.request.a.c(btnStatus));
        }
        if (com.tencent.mobileqq.wink.request.a.j(btnStatus)) {
            WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn = this.makeSameKindBtn;
            if (winkAIAvatarGenerateBtn != null) {
                winkAIAvatarGenerateBtn.setVipState(com.tencent.mobileqq.wink.request.a.b(btnStatus));
                return;
            }
            return;
        }
        if (com.tencent.mobileqq.wink.request.a.i(btnStatus)) {
            WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn2 = this.makeSameKindBtn;
            if (winkAIAvatarGenerateBtn2 != null) {
                winkAIAvatarGenerateBtn2.setText("\u7acb\u5373\u4f20\u56fe");
            }
            WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn3 = this.makeSameKindBtn;
            if (winkAIAvatarGenerateBtn3 != null) {
                WinkAIAvatarGenerateBtn.setEnableState$default(winkAIAvatarGenerateBtn3, null, 1, null);
            }
            WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Drawable o16 = winkAIAvatarUtils.o(context, 15.0f);
            TextView textView2 = this.generateChanceText;
            if (textView2 != null) {
                textView2.setCompoundDrawablesWithIntrinsicBounds(o16, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            return;
        }
        if (com.tencent.mobileqq.wink.request.a.f(btnStatus)) {
            WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn4 = this.makeSameKindBtn;
            if (winkAIAvatarGenerateBtn4 != null) {
                WinkAIAvatarGenerateBtn.setDisableState$default(winkAIAvatarGenerateBtn4, null, 1, null);
                return;
            }
            return;
        }
        if (com.tencent.mobileqq.wink.request.a.h(btnStatus)) {
            WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn5 = this.makeSameKindBtn;
            if (winkAIAvatarGenerateBtn5 != null) {
                winkAIAvatarGenerateBtn5.setEnableState(com.tencent.mobileqq.wink.request.a.b(btnStatus));
                return;
            }
            return;
        }
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn6 = this.makeSameKindBtn;
        if (winkAIAvatarGenerateBtn6 != null) {
            winkAIAvatarGenerateBtn6.setText("\u7acb\u5373\u4f20\u56fe");
        }
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn7 = this.makeSameKindBtn;
        if (winkAIAvatarGenerateBtn7 != null) {
            WinkAIAvatarGenerateBtn.setEnableState$default(winkAIAvatarGenerateBtn7, null, 1, null);
        }
    }

    private final void H9(final View rootView) {
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn;
        TextView textView = null;
        if (rootView != null) {
            winkAIAvatarGenerateBtn = (WinkAIAvatarGenerateBtn) rootView.findViewById(R.id.tfd);
        } else {
            winkAIAvatarGenerateBtn = null;
        }
        this.makeSameKindBtn = winkAIAvatarGenerateBtn;
        if (winkAIAvatarGenerateBtn != null) {
            winkAIAvatarGenerateBtn.setText("\u7acb\u5373\u4f20\u56fe");
        }
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn2 = this.makeSameKindBtn;
        if (winkAIAvatarGenerateBtn2 != null) {
            winkAIAvatarGenerateBtn2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkAIAvatarMaterialDetailUIStatePart.I9(WinkAIAvatarMaterialDetailUIStatePart.this, rootView, view);
                }
            });
        }
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.vnl);
        }
        this.generateChanceText = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkAIAvatarMaterialDetailUIStatePart.J9(WinkAIAvatarMaterialDetailUIStatePart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(WinkAIAvatarMaterialDetailUIStatePart this$0, View view, View view2) {
        Context context;
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.f(this$0.makeSameKindBtn);
        if (!NetworkUtil.isNetworkAvailable()) {
            w53.b.c("WinkAIAvatarMaterialDetailUIStatePart", "jumpToMediaPickerFragment network is not available");
            WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
            Context context2 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            winkAIAvatarUtils.F(context2, "\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        } else {
            if (view != null) {
                context = view.getContext();
            } else {
                context = null;
            }
            if (context != null && this$0.D9()) {
                WinkAIAvatarUtils winkAIAvatarUtils2 = WinkAIAvatarUtils.f317678a;
                Context context3 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "rootView.context");
                WinkAIAvatarUtils.q(winkAIAvatarUtils2, context3, this$0.F9().getOriginStyleMaterial(), false, 0, null, 28, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(WinkAIAvatarMaterialDetailUIStatePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkAIAvatarGenerateBtnViewModel E9 = this$0.E9();
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        E9.W1(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initViewModel() {
        LiveData<ShadowAIGCStatus$GetStatusReply> S1 = E9().S1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<ShadowAIGCStatus$GetStatusReply, Unit> function1 = new Function1<ShadowAIGCStatus$GetStatusReply, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.WinkAIAvatarMaterialDetailUIStatePart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                invoke2(shadowAIGCStatus$GetStatusReply);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                WinkAIAvatarMaterialDetailUIStatePart.this.G9(shadowAIGCStatus$GetStatusReply);
            }
        };
        S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarMaterialDetailUIStatePart.K9(Function1.this, obj);
            }
        });
        E9().X1();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 52136 && resultCode == -1) {
            E9().c2();
            com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
            String str = F9().getOriginStyleMaterial().f30533id;
            Intrinsics.checkNotNullExpressionValue(str, "materialDetailViewModel.getOriginMaterial().id");
            aVar.D(4, 1, str);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        H9(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        E9().X1();
        E9().T1();
    }
}
