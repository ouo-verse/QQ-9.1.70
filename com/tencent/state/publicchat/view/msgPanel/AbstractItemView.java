package com.tencent.state.publicchat.view.msgPanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.ShowMsgPanelParams;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquarePublicChatMsgPanelItemBinding;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0014R\u0014\u0010\u000e\u001a\u00020\u000fX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/publicchat/view/msgPanel/AbstractItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "msg", "Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquarePublicChatMsgPanelItemBinding;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquarePublicChatMsgPanelItemBinding;", "doBindImage", "imageId", "", "doBindText", "textId", "text", "", "getItem", "Landroid/view/View;", "getRoot", "initPageReport", "appId", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class AbstractItemView extends LinearLayout {
    public static final String TAG = "AbstractItemView";
    private final VasSquarePublicChatMsgPanelItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractItemView(Context context, ShowMsgPanelParams msg2, Function1<? super MsgAction, Unit> dispatchAction) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        VasSquarePublicChatMsgPanelItemBinding inflate = VasSquarePublicChatMsgPanelItemBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquarePublicChatMsgPa\u2026.from(context),this,true)");
        this.binding = inflate;
    }

    public final void doBindImage(int imageId) {
        this.binding.image.setImageResource(imageId);
    }

    public final void doBindText(int textId) {
        TextView textView = this.binding.text;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.text");
        textView.setText(getContext().getString(textId));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final VasSquarePublicChatMsgPanelItemBinding getBinding() {
        return this.binding;
    }

    public final View getItem() {
        LinearLayout linearLayout = this.binding.itemIcon;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemIcon");
        return linearLayout;
    }

    public final View getRoot() {
        LinearLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void doBindText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.binding.text;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.text");
        textView.setText(text);
    }

    public final void initPageReport(int appId) {
        String checkNearby;
        if (appId == 1) {
            checkNearby = SquareReportConst.PageId.PAGE_ID_LIBRARY_HOMEPAGE;
        } else if (10001 <= appId && 19999 >= appId) {
            checkNearby = SquareReportConst.PageId.PAGE_ID_NEARBY;
        } else {
            checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        squareReporter.setPageInfo(this, root, checkNearby, new LinkedHashMap());
    }
}
