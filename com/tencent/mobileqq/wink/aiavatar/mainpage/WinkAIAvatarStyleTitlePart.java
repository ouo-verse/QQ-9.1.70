package com.tencent.mobileqq.wink.aiavatar.mainpage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarGenerateBtnViewModel;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/WinkAIAvatarStyleTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "initView", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "shareBtn", "Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarGenerateBtnViewModel;", "e", "Lkotlin/Lazy;", "B9", "()Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarGenerateBtnViewModel;", "generateBtnViewModel", "<init>", "()V", "f", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarStyleTitlePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView shareBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy generateBtnViewModel;

    public WinkAIAvatarStyleTitlePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarGenerateBtnViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.WinkAIAvatarStyleTitlePart$generateBtnViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarGenerateBtnViewModel invoke() {
                return (WinkAIAvatarGenerateBtnViewModel) WinkAIAvatarStyleTitlePart.this.getViewModel(WinkAIAvatarGenerateBtnViewModel.class);
            }
        });
        this.generateBtnViewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkAIAvatarGenerateBtnViewModel B9() {
        Object value = this.generateBtnViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-generateBtnViewModel>(...)");
        return (WinkAIAvatarGenerateBtnViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(final WinkAIAvatarStyleTitlePart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        aVar.m(it);
        WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        winkAIAvatarUtils.C(activity, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.WinkAIAvatarStyleTitlePart$initView$2$1
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
                WinkAIAvatarGenerateBtnViewModel B9;
                B9 = WinkAIAvatarStyleTitlePart.this.B9();
                B9.c2();
                w53.b.a("WinkAIAvatarStyleTitlePart", "wx share success");
            }
        }, "");
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(WinkAIAvatarStyleTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView() {
        ImageView imageView;
        ImageView imageView2;
        View partRootView = getPartRootView();
        if (partRootView != null) {
            imageView = (ImageView) partRootView.findViewById(R.id.f166866ir0);
        } else {
            imageView = null;
        }
        this.shareBtn = imageView;
        if (imageView != null) {
            com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.n(imageView);
        }
        ImageView imageView3 = this.shareBtn;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkAIAvatarStyleTitlePart.C9(WinkAIAvatarStyleTitlePart.this, view);
                }
            });
        }
        View partRootView2 = getPartRootView();
        if (partRootView2 != null && (imageView2 = (ImageView) partRootView2.findViewById(R.id.az7)) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkAIAvatarStyleTitlePart.D9(WinkAIAvatarStyleTitlePart.this, view);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 52136 && resultCode == -1) {
            B9().c2();
            com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.D(1, 1, "");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        initView();
    }
}
