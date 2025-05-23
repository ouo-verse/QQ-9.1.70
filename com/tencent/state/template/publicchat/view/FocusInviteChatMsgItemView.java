package com.tencent.state.template.publicchat.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.ElemConfInfo;
import com.tencent.state.publicchat.data.ElemType;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.view.AbstractMessageItemView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareLibInviteMsgItemViewBinding;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.FaceUtils;
import com.tencent.state.view.EnhancedImageSpan;
import com.tencent.xweb.FileReaderHelper;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yr4.d;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0014J\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/template/publicchat/view/FocusInviteChatMsgItemView;", "Lcom/tencent/state/publicchat/view/AbstractMessageItemView;", "context", "Landroid/content/Context;", "conf", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lcom/tencent/state/publicchat/data/MsgConfInfo;Lcom/tencent/state/publicchat/data/MsgInfo;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibInviteMsgItemViewBinding;", "isOuterMsgPanelEnabled", "", NodeProps.ON_ATTACHED_TO_WINDOW, ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FocusInviteChatMsgItemView extends AbstractMessageItemView {
    private static final String TAG = "FocusInviteChatMsgItemView";
    private final VasSquareLibInviteMsgItemViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusInviteChatMsgItemView(final Context context, MsgConfInfo conf, final MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction) {
        super(context, conf, msg2, dispatchAction, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        VasSquareLibInviteMsgItemViewBinding inflate = VasSquareLibInviteMsgItemViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibInviteMsgIte\u2026 this,\n        true\n    )");
        this.binding = inflate;
        render();
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.template.publicchat.view.FocusInviteChatMsgItemView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                FocusInviteChatMsgItemView focusInviteChatMsgItemView = FocusInviteChatMsgItemView.this;
                int dip = iArr[0] + ViewExtensionsKt.dip(context, 41);
                int i3 = iArr[1];
                MsgInfo msgInfo = msg2;
                focusInviteChatMsgItemView.triggerUserPanel(dip, i3, msgInfo, msgInfo.getUser());
            }
        });
    }

    @Override // com.tencent.state.publicchat.view.AbstractMessageItemView
    public boolean isOuterMsgPanelEnabled() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        RelativeLayout mRv = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        squareReporter.setElementInfo(mRv, SquareReportConst.ElementId.ELEMENT_ID_CHAT_APPLY_CALL_MATE_BTN, new LinkedHashMap(), false, false);
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        RelativeLayout mRv2 = this.binding.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv2, "binding.root");
        squareReporter2.reportEvent("imp", mRv2, new LinkedHashMap());
    }

    public final void render() {
        Object obj;
        Object obj2;
        String str;
        TextView textView;
        try {
            final d c16 = d.c(getMsg().getBody());
            final String valueOf = String.valueOf(getMsg().getUser().getUin());
            FaceUtils.INSTANCE.loadHeadIcon(Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder(), this.binding.imgAvatar, valueOf, false, new Function1<String, Boolean>() { // from class: com.tencent.state.template.publicchat.view.FocusInviteChatMsgItemView$render$1
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
            Iterator<T> it = getConf().getTitleConfInfos().iterator();
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                ElemConfInfo elemConfInfo = (ElemConfInfo) it.next();
                String str2 = elemConfInfo.getDisplay().get(FileReaderHelper.TXT_EXT);
                String str3 = elemConfInfo.getDisplay().get("prefixImg");
                String str4 = getMsg().getUser().getLabels().get(str2);
                if (str4 != null) {
                    final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    final TextView textView2 = new TextView(getContext());
                    if (str3 != null && str3.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        textView = textView2;
                    } else {
                        EnhancedImageSpan.Companion companion = EnhancedImageSpan.INSTANCE;
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        textView = textView2;
                        companion.loadAndSetToSpan(context, spannableStringBuilder, " ", str3, ViewExtensionsKt.dip(getContext(), 9), ViewExtensionsKt.dip(getContext(), 9), ViewExtensionsKt.dip(getContext(), 0), ViewExtensionsKt.dip(getContext(), 2), new Function0<Unit>() { // from class: com.tencent.state.template.publicchat.view.FocusInviteChatMsgItemView$render$2$1
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
                                textView2.setText(spannableStringBuilder);
                            }
                        });
                    }
                    spannableStringBuilder.append((CharSequence) str4);
                    textView.setText(spannableStringBuilder);
                    textView.setTextSize(10.0f);
                    textView.setBackground(DrawableUtil.INSTANCE.getDrawable(R.drawable.gvh));
                    com.tencent.state.ViewExtensionsKt.updatePadding(textView, ViewExtensionsKt.dip(getContext(), 4), 0, ViewExtensionsKt.dip(getContext(), 4), 0);
                    textView.setHeight(ViewExtensionsKt.dip(getContext(), 13));
                    textView.setGravity(17);
                    textView.setTextColor(Color.parseColor("#FFE5B3"));
                    this.binding.lvTagLine.addView(textView);
                    com.tencent.state.ViewExtensionsKt.updateLayoutParams(textView, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.template.publicchat.view.FocusInviteChatMsgItemView$render$$inlined$forEach$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                            invoke2(layoutParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LinearLayout.LayoutParams receiver) {
                            Intrinsics.checkNotNullParameter(receiver, "$receiver");
                            receiver.setMarginEnd(ViewExtensionsKt.dip(FocusInviteChatMsgItemView.this.getContext(), 4.5f));
                        }
                    });
                }
            }
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            String nick = getMsg().getUser().getNick();
            if (nick.length() == 0) {
                nick = valueOf;
            }
            String friendRemarkName = commonUtils.getFriendRemarkName(valueOf, nick);
            TextView textView3 = new TextView(getContext());
            textView3.setText(friendRemarkName);
            textView3.setTextSize(10.0f);
            textView3.setHeight(ViewExtensionsKt.dip(getContext(), 13));
            textView3.setGravity(17);
            textView3.setTextColor(Color.parseColor("#B3FFFFFF"));
            this.binding.lvTagLine.addView(textView3);
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            Iterator<T> it5 = getConf().getBodyConfInfos().iterator();
            while (true) {
                obj = null;
                if (!it5.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it5.next();
                    if (((ElemConfInfo) obj2).getElemType() == ElemType.ET_IMAGE) {
                        break;
                    }
                }
            }
            final ElemConfInfo elemConfInfo2 = (ElemConfInfo) obj2;
            if (elemConfInfo2 != null && (str = elemConfInfo2.getDisplay().get("url")) != null) {
                EnhancedImageSpan.Companion companion2 = EnhancedImageSpan.INSTANCE;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                Context context3 = getContext();
                String str5 = elemConfInfo2.getDisplay().get("width");
                int dip = ViewExtensionsKt.dip(context3, str5 != null ? Integer.parseInt(str5) : 0);
                Context context4 = getContext();
                String str6 = elemConfInfo2.getDisplay().get("height");
                companion2.loadAndSetToSpan(context2, spannableStringBuilder2, " ", str, dip, ViewExtensionsKt.dip(context4, str6 != null ? Integer.parseInt(str6) : 0), ViewExtensionsKt.dip(getContext(), 0), ViewExtensionsKt.dip(getContext(), 6), new Function0<Unit>() { // from class: com.tencent.state.template.publicchat.view.FocusInviteChatMsgItemView$render$$inlined$let$lambda$1
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
                        VasSquareLibInviteMsgItemViewBinding vasSquareLibInviteMsgItemViewBinding;
                        vasSquareLibInviteMsgItemViewBinding = this.binding;
                        TextView textView4 = vasSquareLibInviteMsgItemViewBinding.tvMsg;
                        Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvMsg");
                        textView4.setText(spannableStringBuilder2);
                    }
                });
            }
            spannableStringBuilder2.append((CharSequence) c16.f451106h);
            Iterator<T> it6 = getConf().getBodyConfInfos().iterator();
            while (true) {
                if (!it6.hasNext()) {
                    break;
                }
                Object next = it6.next();
                if (((ElemConfInfo) next).getElemType() == ElemType.ET_HREF) {
                    obj = next;
                    break;
                }
            }
            final ElemConfInfo elemConfInfo3 = (ElemConfInfo) obj;
            if (elemConfInfo3 != null) {
                spannableStringBuilder2.append((CharSequence) " ");
                String str7 = elemConfInfo3.getDisplay().get(FileReaderHelper.TXT_EXT);
                if (str7 != null) {
                    spannableStringBuilder2.append((CharSequence) str7);
                    spannableStringBuilder2.setSpan(new ClickableSpan() { // from class: com.tencent.state.template.publicchat.view.FocusInviteChatMsgItemView$render$$inlined$let$lambda$2
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View widget) {
                            VasSquareLibInviteMsgItemViewBinding vasSquareLibInviteMsgItemViewBinding;
                            Intrinsics.checkNotNullParameter(widget, "widget");
                            FocusInviteChatMsgItemView focusInviteChatMsgItemView = FocusInviteChatMsgItemView.this;
                            d info = c16;
                            Intrinsics.checkNotNullExpressionValue(info, "info");
                            focusInviteChatMsgItemView.triggerFocusAction(info);
                            IReporter squareReporter = SquareBaseKt.getSquareReporter();
                            vasSquareLibInviteMsgItemViewBinding = FocusInviteChatMsgItemView.this.binding;
                            RelativeLayout mRv = vasSquareLibInviteMsgItemViewBinding.getMRv();
                            Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
                            squareReporter.reportEvent("clck", mRv, new LinkedHashMap());
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint ds5) {
                            Intrinsics.checkNotNullParameter(ds5, "ds");
                            ds5.setColor(Color.parseColor("#FFE6B3"));
                            ds5.setUnderlineText(false);
                        }
                    }, spannableStringBuilder2.length() - str7.length(), spannableStringBuilder2.length(), 33);
                }
                String str8 = elemConfInfo3.getDisplay().get("suffixImg");
                if (str8 != null) {
                    EnhancedImageSpan.Companion companion3 = EnhancedImageSpan.INSTANCE;
                    Context context5 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context5, "context");
                    Context context6 = getContext();
                    String str9 = elemConfInfo3.getDisplay().get("suffixImgWidth");
                    int dip2 = ViewExtensionsKt.dip(context6, str9 != null ? Integer.parseInt(str9) : 0);
                    Context context7 = getContext();
                    String str10 = elemConfInfo3.getDisplay().get("suffixImgHeight");
                    companion3.loadAndSetToSpan(context5, spannableStringBuilder2, " ", str8, dip2, ViewExtensionsKt.dip(context7, str10 != null ? Integer.parseInt(str10) : 0), ViewExtensionsKt.dip(getContext(), 5), ViewExtensionsKt.dip(getContext(), 0), new Function0<Unit>() { // from class: com.tencent.state.template.publicchat.view.FocusInviteChatMsgItemView$render$$inlined$let$lambda$3
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
                            VasSquareLibInviteMsgItemViewBinding vasSquareLibInviteMsgItemViewBinding;
                            vasSquareLibInviteMsgItemViewBinding = this.binding;
                            TextView textView4 = vasSquareLibInviteMsgItemViewBinding.tvMsg;
                            Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvMsg");
                            textView4.setText(spannableStringBuilder2);
                        }
                    });
                }
            }
            TextView textView4 = this.binding.tvMsg;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.tvMsg");
            textView4.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView5 = this.binding.tvMsg;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.tvMsg");
            textView5.setText(spannableStringBuilder2);
            TextView textView6 = this.binding.tvMsg;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.tvMsg");
            textView6.setHighlightColor(0);
            this.binding.tvMsg.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.template.publicchat.view.FocusInviteChatMsgItemView$render$7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FocusInviteChatMsgItemView focusInviteChatMsgItemView = FocusInviteChatMsgItemView.this;
                    focusInviteChatMsgItemView.triggerViewTaAction(focusInviteChatMsgItemView.getMsg().getUser());
                }
            });
        } catch (Exception e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "failed to parse body: " + e16, null, 4, null);
        }
    }
}
