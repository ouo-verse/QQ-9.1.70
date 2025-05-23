package com.tencent.state.template.publicchat.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.ElemConfInfo;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.view.AbstractMessageItemView;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.databinding.VasSquareLibNormalChatMsgItemViewBinding;
import com.tencent.state.template.data.PKResult;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.utils.DrawableUtil;
import com.tencent.state.utils.FaceUtils;
import com.tencent.state.view.EnhancedImageSpan;
import com.tencent.xweb.FileReaderHelper;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import yr4.e;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BL\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u0017\u001a\u00020\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/template/publicchat/view/FocusNormalChatMsgItemView;", "Lcom/tencent/state/publicchat/view/AbstractMessageItemView;", "context", "Landroid/content/Context;", "conf", "Lcom/tencent/state/publicchat/data/MsgConfInfo;", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "themeData", "Lcom/tencent/state/template/data/RoomThemeData;", "(Landroid/content/Context;Lcom/tencent/state/publicchat/data/MsgConfInfo;Lcom/tencent/state/publicchat/data/MsgInfo;Lkotlin/jvm/functions/Function1;Lcom/tencent/state/template/data/RoomThemeData;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibNormalChatMsgItemViewBinding;", "addPKTagView", "createNormalTagView", "Landroid/widget/TextView;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FocusNormalChatMsgItemView extends AbstractMessageItemView {
    private static final String TAG = "FocusNormalChatMsgItemView";
    private final VasSquareLibNormalChatMsgItemViewBinding binding;

    public /* synthetic */ FocusNormalChatMsgItemView(Context context, MsgConfInfo msgConfInfo, MsgInfo msgInfo, Function1 function1, RoomThemeData roomThemeData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, msgConfInfo, msgInfo, function1, (i3 & 16) != 0 ? null : roomThemeData);
    }

    private final void addPKTagView() {
        RoomThemeData themeData = getThemeData();
        String str = null;
        String option1 = themeData != null ? themeData.getOption1() : null;
        boolean z16 = true;
        if (option1 == null || option1.length() == 0) {
            return;
        }
        RoomThemeData themeData2 = getThemeData();
        String option2 = themeData2 != null ? themeData2.getOption2() : null;
        if (option2 != null && option2.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        PKResult pKResult = PKResult.UNSELECTED;
        String str2 = getMsg().getUser().getLabels().get("pk_option");
        PKResult fromInt = str2 != null ? PKResult.INSTANCE.fromInt(Integer.parseInt(str2)) : pKResult;
        if (pKResult == fromInt) {
            return;
        }
        TextView textView = new TextView(getContext());
        PKResult pKResult2 = PKResult.SUPPORT;
        textView.setBackground(DrawableUtil.INSTANCE.getDrawable(pKResult2 == fromInt ? R.drawable.i7c : R.drawable.i7b));
        ViewExtensionsKt.updatePadding(textView, com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 4), 0, com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 4), 0);
        if (pKResult2 == fromInt) {
            RoomThemeData themeData3 = getThemeData();
            if (themeData3 != null) {
                str = themeData3.getOption1();
            }
        } else {
            RoomThemeData themeData4 = getThemeData();
            if (themeData4 != null) {
                str = themeData4.getOption2();
            }
        }
        textView.setText(str);
        textView.setTextSize(9.5f);
        textView.setHeight(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 13));
        textView.setGravity(17);
        textView.setTextColor(-1);
        this.binding.lvTagLine.addView(textView);
        ViewExtensionsKt.updateLayoutParams(textView, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.template.publicchat.view.FocusNormalChatMsgItemView$addPKTagView$2
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
                receiver.setMarginEnd(com.tencent.state.square.common.ViewExtensionsKt.dip(FocusNormalChatMsgItemView.this.getContext(), 4.5f));
            }
        });
    }

    private final TextView createNormalTagView(Context context) {
        TextView textView = new TextView(context);
        textView.setTextSize(10.0f);
        textView.setBackground(DrawableUtil.INSTANCE.getDrawable(R.drawable.gvh));
        ViewExtensionsKt.updatePadding(textView, com.tencent.state.square.common.ViewExtensionsKt.dip(context, 4), 0, com.tencent.state.square.common.ViewExtensionsKt.dip(context, 4), 0);
        textView.setHeight(com.tencent.state.square.common.ViewExtensionsKt.dip(context, 13));
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#FFE5B3"));
        return textView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusNormalChatMsgItemView(Context context, MsgConfInfo conf, MsgInfo msg2, Function1<? super MsgAction, Unit> dispatchAction, RoomThemeData roomThemeData) {
        super(context, conf, msg2, dispatchAction, roomThemeData);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        VasSquareLibNormalChatMsgItemViewBinding inflate = VasSquareLibNormalChatMsgItemViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibNormalChatMs\u2026 this,\n        true\n    )");
        this.binding = inflate;
        render();
    }

    public final void render() {
        String decodeToString;
        Iterator it;
        TextView textView;
        try {
            e c16 = e.c(getMsg().getBody());
            final String valueOf = String.valueOf(getMsg().getUser().getUin());
            FaceUtils.INSTANCE.loadHeadIcon(Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder(), this.binding.imgAvatar, valueOf, false, new Function1<String, Boolean>() { // from class: com.tencent.state.template.publicchat.view.FocusNormalChatMsgItemView$render$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(String str) {
                    return Boolean.valueOf(invoke2(str));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(String str) {
                    return TextUtils.equals(str, valueOf);
                }
            });
            TextView textView2 = this.binding.tvMsg;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvMsg");
            byte[] bArr = c16.f451110d;
            Intrinsics.checkNotNullExpressionValue(bArr, "info.text");
            decodeToString = StringsKt__StringsJVMKt.decodeToString(bArr);
            textView2.setText(decodeToString);
            Iterator it5 = getConf().getTitleConfInfos().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                ElemConfInfo elemConfInfo = (ElemConfInfo) it5.next();
                String str = elemConfInfo.getDisplay().get(FileReaderHelper.TXT_EXT);
                String str2 = elemConfInfo.getDisplay().get("prefixImg");
                String str3 = getMsg().getUser().getLabels().get(str);
                if (str3 != null) {
                    final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    final TextView createNormalTagView = createNormalTagView(context);
                    if (str2 != null && str2.length() != 0) {
                        r4 = false;
                    }
                    if (r4) {
                        it = it5;
                        textView = createNormalTagView;
                    } else {
                        EnhancedImageSpan.Companion companion = EnhancedImageSpan.INSTANCE;
                        Context context2 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        it = it5;
                        textView = createNormalTagView;
                        companion.loadAndSetToSpan(context2, spannableStringBuilder, " ", str2, com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 9), com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 9), com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 0), com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 2), new Function0<Unit>() { // from class: com.tencent.state.template.publicchat.view.FocusNormalChatMsgItemView$render$2$1
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
                                createNormalTagView.setText(spannableStringBuilder);
                            }
                        });
                    }
                    spannableStringBuilder.append((CharSequence) str3);
                    textView.setText(spannableStringBuilder);
                    this.binding.lvTagLine.addView(textView);
                    ViewExtensionsKt.updateLayoutParams(textView, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.template.publicchat.view.FocusNormalChatMsgItemView$render$$inlined$forEach$lambda$1
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
                            receiver.setMarginEnd(com.tencent.state.square.common.ViewExtensionsKt.dip(FocusNormalChatMsgItemView.this.getContext(), 4.5f));
                        }
                    });
                    it5 = it;
                }
            }
            addPKTagView();
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            String nick = getMsg().getUser().getNick();
            if (nick.length() == 0) {
                nick = valueOf;
            }
            String friendRemarkName = commonUtils.getFriendRemarkName(valueOf, nick);
            TextView textView3 = new TextView(getContext());
            textView3.setText(friendRemarkName);
            textView3.setTextSize(10.0f);
            textView3.setHeight(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 13));
            textView3.setGravity(17);
            textView3.setTextColor(Color.parseColor("#B3FFFFFF"));
            this.binding.lvTagLine.addView(textView3);
        } catch (Exception e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "failed to parse body: " + e16, null, 4, null);
        }
    }
}
