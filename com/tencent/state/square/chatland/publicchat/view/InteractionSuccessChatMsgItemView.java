package com.tencent.state.square.chatland.publicchat.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.ElemConfInfo;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.data.UserInfo;
import com.tencent.state.publicchat.view.AbstractMessageItemView;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.utils.SpanUtils;
import com.tencent.state.view.EnhancedImageSpan;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import yr4.c;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u000eJ \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/chatland/publicchat/view/InteractionSuccessChatMsgItemView;", "Lcom/tencent/state/publicchat/view/AbstractMessageItemView;", "context", "Landroid/content/Context;", "conf", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lcom/tencent/state/publicchat/data/MsgConfInfo;Lcom/tencent/state/publicchat/data/MsgInfo;Lkotlin/jvm/functions/Function1;)V", "isOuterMsgPanelEnabled", "", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "showUserPanel", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/publicchat/data/UserInfo;", "view", "Landroid/widget/TextView;", TtmlNode.TAG_SPAN, "Landroid/text/style/ClickableSpan;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class InteractionSuccessChatMsgItemView extends AbstractMessageItemView {
    private static final String RECEIVER_PLACEHOLDER = "${receiver}";
    private static final String SENDER_PLACEHOLDER = "${sender}";
    private static final String TAG = "InteractionSuccessChatMsgItemView";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionSuccessChatMsgItemView(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction) {
        super(context, conf, msg2, dispatchAction, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        render();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showUserPanel(UserInfo user, TextView view, ClickableSpan span) {
        if (CommonDataKt.isMe(user.getUin()) || view == null || span == null) {
            return;
        }
        int[] clickPosition = SpanUtils.INSTANCE.clickPosition(view, span);
        triggerUserPanel(clickPosition[0], clickPosition[1], getMsg(), user);
    }

    @Override // com.tencent.state.publicchat.view.AbstractMessageItemView
    public boolean isOuterMsgPanelEnabled() {
        return false;
    }

    public final void render() {
        int indexOf$default;
        int indexOf$default2;
        String replaceFirst$default;
        String replaceFirst$default2;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        SpannableStringBuilder spannableStringBuilder;
        int i3;
        try {
            c c16 = c.c(getMsg().getBody());
            String str = c16.f451098c;
            if (str == null) {
                str = "";
            }
            final InterSuccessMsgInfo interSuccessMsgInfo = new InterSuccessMsgInfo(str, new UserInfo(c16.f451096a), new UserInfo(c16.f451097b));
            final TextView textView = new TextView(getContext());
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (getConf().getBodyConfInfos().size() > 0) {
                final ElemConfInfo elemConfInfo = getConf().getBodyConfInfos().get(0);
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
                    companion.loadAndSetToSpan(context, spannableStringBuilder2, " ", str2, dip, ViewExtensionsKt.dip(context3, str4 != null ? Integer.parseInt(str4) : 0), ViewExtensionsKt.dip(getContext(), 0), ViewExtensionsKt.dip(getContext(), 6), new Function0<Unit>() { // from class: com.tencent.state.square.chatland.publicchat.view.InteractionSuccessChatMsgItemView$render$$inlined$also$lambda$1
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
                            textView.setText(spannableStringBuilder2);
                        }
                    });
                }
            }
            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
            String valueOf = String.valueOf(interSuccessMsgInfo.getSender().getUin());
            String nick = interSuccessMsgInfo.getSender().getNick();
            if (nick.length() == 0) {
                nick = String.valueOf(interSuccessMsgInfo.getSender().getUin());
            }
            String friendRemarkName = squareCommon.getFriendRemarkName(valueOf, nick);
            ICommonUtils squareCommon2 = SquareBaseKt.getSquareCommon();
            String valueOf2 = String.valueOf(interSuccessMsgInfo.getReceiver().getUin());
            String nick2 = interSuccessMsgInfo.getReceiver().getNick();
            if (nick2.length() == 0) {
                nick2 = String.valueOf(interSuccessMsgInfo.getReceiver().getUin());
            }
            String friendRemarkName2 = squareCommon2.getFriendRemarkName(valueOf2, nick2);
            if (friendRemarkName.length() > 10) {
                StringBuilder sb5 = new StringBuilder();
                String substring = friendRemarkName.substring(0, 10);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                sb5.append(substring);
                sb5.append("\u2026");
                friendRemarkName = sb5.toString();
            }
            final String str5 = friendRemarkName;
            if (friendRemarkName2.length() > 10) {
                StringBuilder sb6 = new StringBuilder();
                String substring2 = friendRemarkName2.substring(0, 10);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                sb6.append(substring2);
                sb6.append("\u2026");
                friendRemarkName2 = sb6.toString();
            }
            final String str6 = friendRemarkName2;
            final Ref.IntRef intRef3 = new Ref.IntRef();
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) interSuccessMsgInfo.getTemplate(), SENDER_PLACEHOLDER, 0, false, 6, (Object) null);
            intRef3.element = indexOf$default + 1;
            final Ref.IntRef intRef4 = new Ref.IntRef();
            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) interSuccessMsgInfo.getTemplate(), RECEIVER_PLACEHOLDER, 0, false, 6, (Object) null);
            intRef4.element = indexOf$default2 + 1;
            replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(interSuccessMsgInfo.getTemplate(), SENDER_PLACEHOLDER, str5, false, 4, (Object) null);
            replaceFirst$default2 = StringsKt__StringsJVMKt.replaceFirst$default(replaceFirst$default, RECEIVER_PLACEHOLDER, str6, false, 4, (Object) null);
            spannableStringBuilder2.append((CharSequence) replaceFirst$default2);
            int i16 = intRef3.element;
            if (i16 != 0 && (i3 = intRef4.element) != 0) {
                if (i16 < i3) {
                    intRef4.element = (i3 - 9) + str5.length();
                } else {
                    intRef3.element = (i16 - 11) + str6.length();
                }
            }
            if (intRef3.element != 0) {
                intRef = intRef4;
                intRef2 = intRef3;
                spannableStringBuilder = spannableStringBuilder2;
                ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.tencent.state.square.chatland.publicchat.view.InteractionSuccessChatMsgItemView$render$$inlined$also$lambda$2
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View widget) {
                        Intrinsics.checkNotNullParameter(widget, "widget");
                        this.showUserPanel(interSuccessMsgInfo.getSender(), textView, this);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint ds5) {
                        Intrinsics.checkNotNullParameter(ds5, "ds");
                        ds5.setColor(Color.parseColor("#FFE6B3"));
                        ds5.setUnderlineText(false);
                    }
                };
                int i17 = intRef2.element;
                spannableStringBuilder.setSpan(clickableSpan, i17, str5.length() + i17, 33);
            } else {
                intRef = intRef4;
                intRef2 = intRef3;
                spannableStringBuilder = spannableStringBuilder2;
            }
            if (intRef.element != 0) {
                final SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
                final Ref.IntRef intRef5 = intRef2;
                final Ref.IntRef intRef6 = intRef;
                ClickableSpan clickableSpan2 = new ClickableSpan() { // from class: com.tencent.state.square.chatland.publicchat.view.InteractionSuccessChatMsgItemView$render$$inlined$also$lambda$3
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View widget) {
                        Intrinsics.checkNotNullParameter(widget, "widget");
                        this.showUserPanel(interSuccessMsgInfo.getReceiver(), textView, this);
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint ds5) {
                        Intrinsics.checkNotNullParameter(ds5, "ds");
                        ds5.setColor(Color.parseColor("#FFE6B3"));
                        ds5.setUnderlineText(false);
                    }
                };
                int i18 = intRef.element;
                spannableStringBuilder.setSpan(clickableSpan2, i18, str6.length() + i18, 33);
            }
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setHighlightColor(0);
            textView.setText(spannableStringBuilder);
            textView.setTextColor(-1);
            textView.setTextSize(12.0f);
            addView(textView);
        } catch (Exception e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "failed to parse body: " + e16, null, 4, null);
        }
    }
}
