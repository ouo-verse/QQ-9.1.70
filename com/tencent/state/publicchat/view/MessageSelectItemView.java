package com.tencent.state.publicchat.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.data.MsgInfoChecked;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.view.SquareImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/publicchat/view/MessageSelectItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkBox", "Lcom/tencent/state/view/SquareImageView;", "bind", "", "msgChecked", "Lcom/tencent/state/publicchat/data/MsgInfoChecked;", "conf", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "isFirst", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MessageSelectItemView extends LinearLayout {
    private static final String TAG = "MessageSelectItemView";
    private SquareImageView checkBox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageSelectItemView(Context context) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.checkBox = new SquareImageView(context);
    }

    public final void bind(MsgInfoChecked msgChecked, MsgConfInfo conf, boolean isFirst) {
        Drawable drawable;
        removeAllViews();
        if (msgChecked == null) {
            return;
        }
        MsgInfo msg2 = msgChecked.getMsg();
        if (conf == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "no message config for templateId " + msg2.getHeader().getTemplateId(), null, 4, null);
            return;
        }
        View view = this.checkBox;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewExtensionsKt.dip(view.getContext(), 24), ViewExtensionsKt.dip(view.getContext(), 24));
        if (!isFirst) {
            layoutParams.topMargin = ViewExtensionsKt.dip(view.getContext(), 5);
        }
        layoutParams.setMarginEnd(ViewExtensionsKt.dip(view.getContext(), 12));
        layoutParams.gravity = 48;
        if (msgChecked.getChecked()) {
            drawable = DrawableUtil.INSTANCE.getDrawable(R.drawable.f159798i93);
        } else {
            drawable = DrawableUtil.INSTANCE.getDrawable(R.drawable.i98);
        }
        view.setBackground(drawable);
        Unit unit = Unit.INSTANCE;
        view.setLayoutParams(layoutParams);
        addView(view);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        MessageItemView messageItemView = new MessageItemView(context, new Function1<MsgAction, Unit>() { // from class: com.tencent.state.publicchat.view.MessageSelectItemView$bind$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MsgAction it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MsgAction msgAction) {
                invoke2(msgAction);
                return Unit.INSTANCE;
            }
        });
        messageItemView.bind(msg2, conf, null, isFirst);
        addView(messageItemView);
    }
}
