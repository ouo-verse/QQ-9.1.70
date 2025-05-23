package com.tencent.state.template.publicchat.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.ElemConfInfo;
import com.tencent.state.publicchat.data.ElemType;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.view.AbstractMessageItemView;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.view.EnhancedImageSpan;
import com.tencent.xweb.FileReaderHelper;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yr4.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/template/publicchat/view/FocusWelcomeAnnouncementMsgItemView;", "Lcom/tencent/state/publicchat/view/AbstractMessageItemView;", "context", "Landroid/content/Context;", "conf", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lcom/tencent/state/publicchat/data/MsgConfInfo;Lcom/tencent/state/publicchat/data/MsgInfo;Lkotlin/jvm/functions/Function1;)V", "isOuterMsgPanelEnabled", "", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FocusWelcomeAnnouncementMsgItemView extends AbstractMessageItemView {
    private static final String TAG = "FocusWelcomeAnnouncementMsgItemView";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ElemType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ElemType.ET_IMAGE.ordinal()] = 1;
            iArr[ElemType.ET_TEXT.ordinal()] = 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusWelcomeAnnouncementMsgItemView(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction) {
        super(context, conf, msg2, dispatchAction, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        render();
    }

    @Override // com.tencent.state.publicchat.view.AbstractMessageItemView
    public boolean isOuterMsgPanelEnabled() {
        return false;
    }

    public final void render() {
        a aVar;
        SpannableStringBuilder spannableStringBuilder;
        String str;
        try {
            aVar = a.c(getMsg().getBody());
        } catch (Exception e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "failed to parse body: " + e16, null, 4, null);
            aVar = null;
        }
        final TextView textView = new TextView(getContext());
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        for (final ElemConfInfo elemConfInfo : getConf().getBodyConfInfos()) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[elemConfInfo.getElemType().ordinal()];
            if (i3 == 1) {
                String str2 = elemConfInfo.getDisplay().get("url");
                if (str2 != null) {
                    EnhancedImageSpan.Companion companion = EnhancedImageSpan.INSTANCE;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    Context context2 = getContext();
                    String str3 = elemConfInfo.getDisplay().get("width");
                    int dip = ViewExtensionsKt.dip(context2, str3 != null ? Integer.parseInt(str3) : 0);
                    Context context3 = getContext();
                    String str4 = elemConfInfo.getDisplay().get("height");
                    int parseInt = str4 != null ? Integer.parseInt(str4) : 0;
                    final SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder2;
                    final a aVar2 = aVar;
                    spannableStringBuilder = spannableStringBuilder2;
                    companion.loadAndSetToSpan(context, spannableStringBuilder2, " ", str2, dip, ViewExtensionsKt.dip(context3, parseInt), ViewExtensionsKt.dip(getContext(), 0), ViewExtensionsKt.dip(getContext(), 6), new Function0<Unit>() { // from class: com.tencent.state.template.publicchat.view.FocusWelcomeAnnouncementMsgItemView$render$$inlined$also$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            textView.setText(spannableStringBuilder3);
                        }
                    });
                    spannableStringBuilder2 = spannableStringBuilder;
                }
            } else if (i3 != 2) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "unknown element type " + elemConfInfo.getElemType(), null, 4, null);
            } else {
                if (aVar != null && (str = aVar.f451088a) != null) {
                    if (str.length() > 0) {
                        spannableStringBuilder2.append((CharSequence) aVar.f451088a);
                    }
                }
                spannableStringBuilder2.append((CharSequence) elemConfInfo.getDisplay().get(FileReaderHelper.TXT_EXT));
            }
            spannableStringBuilder = spannableStringBuilder2;
            spannableStringBuilder2 = spannableStringBuilder;
        }
        textView.setText(spannableStringBuilder2);
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        addView(textView);
    }
}
