package com.tencent.state.template.publicchat.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.ElemConfInfo;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.view.AbstractMessageItemView;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.utils.SpanUtils;
import com.tencent.state.view.EnhancedImageSpan;
import com.tencent.xweb.FileReaderHelper;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import yr4.b;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u000eJ\b\u0010\u0017\u001a\u00020\u000eH\u0002R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/template/publicchat/view/FocusKeepChatMsgItemView;", "Lcom/tencent/state/publicchat/view/AbstractMessageItemView;", "context", "Landroid/content/Context;", "conf", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lcom/tencent/state/publicchat/data/MsgConfInfo;Lcom/tencent/state/publicchat/data/MsgInfo;Lkotlin/jvm/functions/Function1;)V", "clickableSpan", "Landroid/text/style/ClickableSpan;", "textView", "Landroid/widget/TextView;", "isOuterMsgPanelEnabled", "", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "showUserPanel", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FocusKeepChatMsgItemView extends AbstractMessageItemView {
    private static final String TAG = "FocusKeepChatMsgItemView";
    private ClickableSpan clickableSpan;
    private TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusKeepChatMsgItemView(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction) {
        super(context, conf, msg2, dispatchAction, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        render();
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.template.publicchat.view.FocusKeepChatMsgItemView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FocusKeepChatMsgItemView.this.showUserPanel();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showUserPanel() {
        ClickableSpan clickableSpan;
        TextView textView = this.textView;
        if (textView == null || (clickableSpan = this.clickableSpan) == null) {
            return;
        }
        int[] clickPosition = SpanUtils.INSTANCE.clickPosition(textView, clickableSpan);
        triggerUserPanel(clickPosition[0], clickPosition[1], getMsg(), getMsg().getUser());
    }

    @Override // com.tencent.state.publicchat.view.AbstractMessageItemView
    public boolean isOuterMsgPanelEnabled() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void render() {
        int i3;
        int i16;
        final SpannableStringBuilder spannableStringBuilder;
        String decodeToString;
        String decodeToString2;
        try {
            final b c16 = b.c(getMsg().getBody());
            final TextView textView = new TextView(getContext());
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            int size = getConf().getTitleConfInfos().size();
            if (size > 0) {
                final ElemConfInfo elemConfInfo = getConf().getTitleConfInfos().get(0);
                String str = elemConfInfo.getDisplay().get("url");
                if (str != null) {
                    EnhancedImageSpan.Companion companion = EnhancedImageSpan.INSTANCE;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    Context context2 = getContext();
                    String str2 = elemConfInfo.getDisplay().get("width");
                    int dip = ViewExtensionsKt.dip(context2, str2 != null ? Integer.parseInt(str2) : 0);
                    Context context3 = getContext();
                    String str3 = elemConfInfo.getDisplay().get("height");
                    int dip2 = ViewExtensionsKt.dip(context3, str3 != null ? Integer.parseInt(str3) : 0);
                    int dip3 = ViewExtensionsKt.dip(getContext(), 0);
                    int dip4 = ViewExtensionsKt.dip(getContext(), 6);
                    spannableStringBuilder = spannableStringBuilder2;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.state.template.publicchat.view.FocusKeepChatMsgItemView$render$$inlined$also$lambda$1
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
                            textView.setText(spannableStringBuilder);
                        }
                    };
                    i3 = 0;
                    i16 = size;
                    companion.loadAndSetToSpan(context, spannableStringBuilder2, " ", str, dip, dip2, dip3, dip4, function0);
                    if (i16 > 1) {
                        spannableStringBuilder.append((CharSequence) getConf().getTitleConfInfos().get(1).getDisplay().get(FileReaderHelper.TXT_EXT));
                    }
                    String valueOf = String.valueOf(c16.f451089a);
                    ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                    byte[] bArr = c16.f451090b;
                    Intrinsics.checkNotNullExpressionValue(bArr, "info.nick");
                    decodeToString = StringsKt__StringsJVMKt.decodeToString(bArr);
                    if ((decodeToString.length() != 0 ? i3 : 1) != 0) {
                        decodeToString = valueOf;
                    }
                    String friendRemarkName = commonUtils.getFriendRemarkName(valueOf, decodeToString);
                    spannableStringBuilder.append((CharSequence) friendRemarkName);
                    int length = spannableStringBuilder.length() - friendRemarkName.length();
                    int length2 = spannableStringBuilder.length();
                    ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.tencent.state.template.publicchat.view.FocusKeepChatMsgItemView$render$$inlined$also$lambda$2
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View widget) {
                            Intrinsics.checkNotNullParameter(widget, "widget");
                            FocusKeepChatMsgItemView.this.showUserPanel();
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint ds5) {
                            Intrinsics.checkNotNullParameter(ds5, "ds");
                            ds5.setColor(Color.parseColor("#FFE6B3"));
                            ds5.setUnderlineText(false);
                        }
                    };
                    this.clickableSpan = clickableSpan;
                    spannableStringBuilder.setSpan(clickableSpan, length, length2, 33);
                    spannableStringBuilder.append((CharSequence) " ");
                    if (i16 <= 2) {
                        spannableStringBuilder.append((CharSequence) getConf().getTitleConfInfos().get(2).getDisplay().get(FileReaderHelper.TXT_EXT));
                    } else {
                        spannableStringBuilder.append((CharSequence) "\u4e13\u6ce8\u8d85\u8fc7");
                    }
                    spannableStringBuilder.append((CharSequence) String.valueOf(c16.f451094f));
                    if (i16 <= 3) {
                        spannableStringBuilder.append((CharSequence) getConf().getTitleConfInfos().get(3).getDisplay().get(FileReaderHelper.TXT_EXT));
                    } else {
                        spannableStringBuilder.append((CharSequence) "\u5206\u949f\u5566\uff0c");
                    }
                    byte[] bArr2 = c16.f451095g;
                    Intrinsics.checkNotNullExpressionValue(bArr2, "info.tip");
                    decodeToString2 = StringsKt__StringsJVMKt.decodeToString(bArr2);
                    spannableStringBuilder.append((CharSequence) decodeToString2);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    textView.setHighlightColor(i3);
                    textView.setText(spannableStringBuilder);
                    textView.setTextColor(-1);
                    textView.setTextSize(12.0f);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.template.publicchat.view.FocusKeepChatMsgItemView$render$$inlined$also$lambda$3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            FocusKeepChatMsgItemView.this.showUserPanel();
                        }
                    });
                    addView(textView);
                    Unit unit = Unit.INSTANCE;
                    this.textView = textView;
                }
            }
            i3 = 0;
            i16 = size;
            spannableStringBuilder = spannableStringBuilder2;
            if (i16 > 1) {
            }
            String valueOf2 = String.valueOf(c16.f451089a);
            ICommonUtils commonUtils2 = Square.INSTANCE.getConfig().getCommonUtils();
            byte[] bArr3 = c16.f451090b;
            Intrinsics.checkNotNullExpressionValue(bArr3, "info.nick");
            decodeToString = StringsKt__StringsJVMKt.decodeToString(bArr3);
            if ((decodeToString.length() != 0 ? i3 : 1) != 0) {
            }
            String friendRemarkName2 = commonUtils2.getFriendRemarkName(valueOf2, decodeToString);
            spannableStringBuilder.append((CharSequence) friendRemarkName2);
            int length3 = spannableStringBuilder.length() - friendRemarkName2.length();
            int length22 = spannableStringBuilder.length();
            ClickableSpan clickableSpan2 = new ClickableSpan() { // from class: com.tencent.state.template.publicchat.view.FocusKeepChatMsgItemView$render$$inlined$also$lambda$2
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    FocusKeepChatMsgItemView.this.showUserPanel();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds5) {
                    Intrinsics.checkNotNullParameter(ds5, "ds");
                    ds5.setColor(Color.parseColor("#FFE6B3"));
                    ds5.setUnderlineText(false);
                }
            };
            this.clickableSpan = clickableSpan2;
            spannableStringBuilder.setSpan(clickableSpan2, length3, length22, 33);
            spannableStringBuilder.append((CharSequence) " ");
            if (i16 <= 2) {
            }
            spannableStringBuilder.append((CharSequence) String.valueOf(c16.f451094f));
            if (i16 <= 3) {
            }
            byte[] bArr22 = c16.f451095g;
            Intrinsics.checkNotNullExpressionValue(bArr22, "info.tip");
            decodeToString2 = StringsKt__StringsJVMKt.decodeToString(bArr22);
            spannableStringBuilder.append((CharSequence) decodeToString2);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setHighlightColor(i3);
            textView.setText(spannableStringBuilder);
            textView.setTextColor(-1);
            textView.setTextSize(12.0f);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.template.publicchat.view.FocusKeepChatMsgItemView$render$$inlined$also$lambda$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FocusKeepChatMsgItemView.this.showUserPanel();
                }
            });
            addView(textView);
            Unit unit2 = Unit.INSTANCE;
            this.textView = textView;
        } catch (Exception e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "failed to parse body: " + e16, null, 4, null);
        }
    }
}
