package com.tencent.state.square.chatland.publicchat.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.view.AbstractMessageItemView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.databinding.VasSquareChatLandDoubleClickMsgItemViewBinding;
import com.tencent.state.utils.FaceUtils;
import com.tencent.state.view.SquareImageView;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import yr4.f;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0014J\u0006\u0010\u0017\u001a\u00020\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/chatland/publicchat/view/InteractionDoubleClickMsgItemView;", "Lcom/tencent/state/publicchat/view/AbstractMessageItemView;", "context", "Landroid/content/Context;", "conf", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lcom/tencent/state/publicchat/data/MsgConfInfo;Lcom/tencent/state/publicchat/data/MsgInfo;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareChatLandDoubleClickMsgItemViewBinding;", "initiateUin", "", "isOuterMsgPanelEnabled", "", NodeProps.ON_ATTACHED_TO_WINDOW, ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionDoubleClickMsgItemView extends AbstractMessageItemView {
    private static final String TAG = "InteractionDoubleClickMsgItemView";
    private final VasSquareChatLandDoubleClickMsgItemViewBinding binding;
    private String initiateUin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionDoubleClickMsgItemView(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction) {
        super(context, conf, msg2, dispatchAction, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        VasSquareChatLandDoubleClickMsgItemViewBinding inflate = VasSquareChatLandDoubleClickMsgItemViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareChatLandDoubleC\u2026 this,\n        true\n    )");
        this.binding = inflate;
        render();
    }

    @Override // com.tencent.state.publicchat.view.AbstractMessageItemView
    public boolean isOuterMsgPanelEnabled() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Map<String, Object> mutableMapOf;
        super.onAttachedToWindow();
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        RelativeLayout mRv = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        Pair[] pairArr = new Pair[2];
        Object obj = this.initiateUin;
        if (obj == null) {
            obj = 0;
        }
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_INITIATE_UIN, obj);
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_TAPPED_UIN, SquareBaseKt.getSquareCommon().getCurrentAccountUin());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        squareReporter.setElementInfo(mRv, SquareReportConst.ElementId.ELEMENT_ID_CHAT_TAP_PROMPT, mutableMapOf, false, false);
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        RelativeLayout mRv2 = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv2, "binding.root");
        squareReporter2.reportEvent("imp", mRv2, new LinkedHashMap());
    }

    public final void render() {
        String str;
        try {
            f c16 = f.c(getMsg().getBody());
            final String valueOf = String.valueOf(getMsg().getUser().getUin());
            this.initiateUin = valueOf;
            FaceUtils faceUtils = FaceUtils.INSTANCE;
            Square square = Square.INSTANCE;
            faceUtils.loadHeadIcon(square.getConfig().getObtainInstanceHelper().getFaceDecoder(), this.binding.imgAvatar, valueOf, false, new Function1<String, Boolean>() { // from class: com.tencent.state.square.chatland.publicchat.view.InteractionDoubleClickMsgItemView$render$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(String str2) {
                    return Boolean.valueOf(invoke2(str2));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(String str2) {
                    return TextUtils.equals(str2, valueOf);
                }
            });
            boolean z16 = true;
            if (c16.f451113c != 0) {
                ICommonUtils commonUtils = square.getConfig().getCommonUtils();
                String valueOf2 = String.valueOf(c16.f451113c);
                String str2 = c16.f451114d;
                if (str2.length() == 0) {
                    str2 = String.valueOf(c16.f451113c);
                }
                Intrinsics.checkNotNullExpressionValue(str2, "info.nickReceiver.ifEmpt\u2026.uinReceiver.toString() }");
                String friendRemarkName = commonUtils.getFriendRemarkName(valueOf2, str2);
                String str3 = c16.f451112b;
                Intrinsics.checkNotNullExpressionValue(str3, "info.content");
                str = StringsKt__StringsJVMKt.replace$default(str3, "${receiver}", friendRemarkName, false, 4, (Object) null);
            } else {
                str = c16.f451112b;
            }
            TextView textView = this.binding.tvMsg;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvMsg");
            textView.setText(str);
            ICommonUtils commonUtils2 = square.getConfig().getCommonUtils();
            String nick = getMsg().getUser().getNick();
            if (nick.length() == 0) {
                nick = valueOf;
            }
            String friendRemarkName2 = commonUtils2.getFriendRemarkName(valueOf, nick);
            TextView textView2 = this.binding.lvName;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.lvName");
            textView2.setText(friendRemarkName2);
            String str4 = c16.f451111a;
            if (str4 != null && str4.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return;
            }
            SquareImageView squareImageView = this.binding.iconPai;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.iconPai");
            ViewExtensionsKt.setUri(squareImageView, c16.f451111a);
        } catch (Exception e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "failed to parse body: " + e16, null, 4, null);
        }
    }
}
