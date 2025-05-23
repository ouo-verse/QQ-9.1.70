package com.tencent.mobileqq.wink.aiavatar.base;

import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarDebugPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleTextView", "Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarGenerateBtnViewModel;", "e", "Lkotlin/Lazy;", "B9", "()Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarGenerateBtnViewModel;", "generateBtnViewModel", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarDebugPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titleTextView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy generateBtnViewModel;

    public WinkAIAvatarDebugPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarGenerateBtnViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarDebugPart$generateBtnViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarGenerateBtnViewModel invoke() {
                return (WinkAIAvatarGenerateBtnViewModel) WinkAIAvatarDebugPart.this.getViewModel(WinkAIAvatarGenerateBtnViewModel.class);
            }
        });
        this.generateBtnViewModel = lazy;
    }

    private final WinkAIAvatarGenerateBtnViewModel B9() {
        Object value = this.generateBtnViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-generateBtnViewModel>(...)");
        return (WinkAIAvatarGenerateBtnViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C9(WinkAIAvatarDebugPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D9();
        return true;
    }

    private final void D9() {
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton("\uff08debug\uff09\u91cd\u7f6e\u6b21\u6570");
        actionSheet.addButton("\uff08debug\uff09\u6d88\u8017\u6b21\u6570");
        actionSheet.addButton("\uff08debug\uff09\u5206\u4eab");
        actionSheet.addButton("\uff08debug\uff09\u4e0b\u8f7d");
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.base.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                WinkAIAvatarDebugPart.E9(WinkAIAvatarDebugPart.this, view, i3);
            }
        });
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.base.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkAIAvatarDebugPart.F9(ActionSheet.this, view);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(WinkAIAvatarDebugPart this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this$0.B9().P1();
                        return;
                    }
                    return;
                }
                this$0.B9().c2();
                return;
            }
            this$0.B9().Q1();
            return;
        }
        this$0.B9().b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        actionSheet.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        TextView textView;
        TextView textView2;
        super.onInitView(rootView);
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.sfq);
        } else {
            textView = null;
        }
        this.titleTextView = textView;
        if (com.tencent.mobileqq.wink.editor.hdr.e.f320476a.b() && (textView2 = this.titleTextView) != null) {
            textView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.base.b
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean C9;
                    C9 = WinkAIAvatarDebugPart.C9(WinkAIAvatarDebugPart.this, view);
                    return C9;
                }
            });
        }
    }
}
