package com.tencent.state.publicchat.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquarePublicChatNewButtonBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/publicchat/view/MessageNewButtonView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", DownloadInfo.spKey_Config, "Lcom/tencent/state/publicchat/view/MsgNewBtnConfig;", "(Landroid/content/Context;Lcom/tencent/state/publicchat/view/MsgNewBtnConfig;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquarePublicChatNewButtonBinding;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MessageNewButtonView extends FrameLayout {
    private static final String TAG = "MessageNewButton";
    private final VasSquarePublicChatNewButtonBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageNewButtonView(Context context, final MsgNewBtnConfig msgNewBtnConfig) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquarePublicChatNewButtonBinding inflate = VasSquarePublicChatNewButtonBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquarePublicChatNewBu\u2026 this,\n        true\n    )");
        this.binding = inflate;
        if (msgNewBtnConfig != null) {
            if (!msgNewBtnConfig.getShowIcon()) {
                inflate.titleText.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            TextView textView = inflate.titleText;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleText");
            textView.setText(msgNewBtnConfig.getText());
            inflate.titleText.setTextColor(msgNewBtnConfig.getTextColor());
            TextView textView2 = inflate.titleText;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleText");
            textView2.setTextSize(msgNewBtnConfig.getTextSize());
            TextView textView3 = inflate.titleText;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.titleText");
            ViewExtensionsKt.updateLayoutParams(textView3, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.publicchat.view.MessageNewButtonView$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FrameLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.gravity = MsgNewBtnConfig.this.getGravity();
                }
            });
            inflate.titleText.setPadding(com.tencent.state.square.common.ViewExtensionsKt.dip(context, msgNewBtnConfig.getPaddingLeft()), 0, 0, 0);
        }
    }
}
