package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareChatLandInteractionMotionIndicatorBinding;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.template.data.InteractionMotionState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\rJ\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fH\u0002J\u0006\u0010\"\u001a\u00020\u0016J\b\u0010#\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u0016H\u0014J\u0012\u0010%\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0016H\u0014J-\u0010)\u001a\u00020\u00162%\u0010*\u001a!\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0012j\u0002`\u0017J\u0018\u0010+\u001a\u00020\u00162\u0010\u0010*\u001a\f\u0012\u0004\u0012\u00020\u00160\u0019j\u0002`\u001aJ\u0010\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020 H\u0002J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010-\u001a\u00020 H\u0002J\u0010\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020 H\u0002J\u0010\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\bH\u0002J\b\u00103\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R1\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012j\u0004\u0018\u0001`\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandInteractionMotionIndicator;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareChatLandInteractionMotionIndicatorBinding;", "currentInfo", "Lcom/tencent/state/square/chatland/view/InterMotionIndicatorInfo;", "inviteTickLeft", "inviteTimer", "Landroid/os/Handler;", "onClickCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", "", "Lcom/tencent/state/square/chatland/view/OnClickCallbackFun;", "onInviteTimeoutCallback", "Lkotlin/Function0;", "Lcom/tencent/state/square/chatland/view/OnInviteTimeoutCallbackFun;", "tipsTimer", "bind", "info", "getReportParams", "", "", "", "hide", "hideTips", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_CLICK, "v", "Landroid/view/View;", NodeProps.ON_DETACHED_FROM_WINDOW, "setOnClickCallback", "callback", "setOnInviteTimeoutCallback", "showCancelTips", "msg", "showInviteTips", "showTips", "text", "startInviteTick", "leftSec", "updateInviteTick", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandInteractionMotionIndicator extends LinearLayout implements View.OnClickListener {
    private static final long INVITE_TICK_TIME = 1000;
    private static final String TAG = "ChatLandInteractionMotionIndicator";
    private static final long TIPS_TIMEOUT = 4000;
    private final VasSquareChatLandInteractionMotionIndicatorBinding binding;
    private InterMotionIndicatorInfo currentInfo;
    private int inviteTickLeft;
    private final Handler inviteTimer;
    private Function1<? super InterMotionIndicatorInfo, Unit> onClickCallback;
    private Function0<Unit> onInviteTimeoutCallback;
    private final Handler tipsTimer;
    private static final int INVITING_BG_RES = R.drawable.f159801gs1;
    private static final int PAIRING_BG_RES = R.drawable.f159802gs2;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InteractionMotionState.values().length];
            $EnumSwitchMapping$0 = iArr;
            InteractionMotionState interactionMotionState = InteractionMotionState.INVITING;
            iArr[interactionMotionState.ordinal()] = 1;
            InteractionMotionState interactionMotionState2 = InteractionMotionState.PAIRING;
            iArr[interactionMotionState2.ordinal()] = 2;
            int[] iArr2 = new int[InteractionMotionState.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[interactionMotionState.ordinal()] = 1;
            iArr2[interactionMotionState2.ordinal()] = 2;
        }
    }

    public ChatLandInteractionMotionIndicator(Context context) {
        this(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTips() {
        this.tipsTimer.removeCallbacks(new ChatLandInteractionMotionIndicatorKt$sam$java_lang_Runnable$0(new ChatLandInteractionMotionIndicator$hideTips$1(this)));
        LinearLayout linearLayout = this.binding.lvTips;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.lvTips");
        ViewExtensionsKt.setVisibility(linearLayout, false);
    }

    private final void showCancelTips(String msg2) {
        if (IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.ChatLand.HAS_SHOW_PAIR_PARING_TIPS, false, null, false, 12, null)) {
            SquareBaseKt.getSquareLog().d(TAG, "showCancelTips: has shown");
            return;
        }
        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.ChatLand.HAS_SHOW_PAIR_PARING_TIPS, true, null, false, 12, null);
        if (msg2.length() == 0) {
            msg2 = "\u70b9\u51fb\u53d6\u6d88\u5408\u4f53";
        }
        showTips(msg2);
    }

    private final void showInviteTips(String msg2) {
        if (IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.ChatLand.HAS_SHOW_PAIR_INVITE_TIPS, false, null, false, 12, null)) {
            SquareBaseKt.getSquareLog().d(TAG, "showInviteTips: has shown");
            return;
        }
        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.ChatLand.HAS_SHOW_PAIR_INVITE_TIPS, true, null, false, 12, null);
        if (msg2.length() == 0) {
            msg2 = "\u7b49\u5f85\u5bf9\u65b9\u63a5\u53d7\uff0c\u70b9\u51fb\u53d6\u6d88";
        }
        showTips(msg2);
    }

    private final void showTips(String text) {
        hideTips();
        TextView textView = this.binding.tvTips;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTips");
        textView.setText(text);
        LinearLayout linearLayout = this.binding.lvTips;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.lvTips");
        ViewExtensionsKt.setVisibility(linearLayout, true);
        this.tipsTimer.postDelayed(new ChatLandInteractionMotionIndicatorKt$sam$java_lang_Runnable$0(new ChatLandInteractionMotionIndicator$showTips$1(this)), 4000L);
    }

    private final void startInviteTick(int leftSec) {
        this.inviteTickLeft = leftSec;
        updateInviteTick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateInviteTick() {
        this.inviteTimer.removeCallbacks(new ChatLandInteractionMotionIndicatorKt$sam$java_lang_Runnable$0(new ChatLandInteractionMotionIndicator$updateInviteTick$1(this)));
        if (this.inviteTickLeft < 0) {
            Function0<Unit> function0 = this.onInviteTimeoutCallback;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        TextView textView = this.binding.tvTick;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTick");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.inviteTickLeft);
        sb5.append('s');
        textView.setText(sb5.toString());
        this.inviteTickLeft--;
        InterMotionIndicatorInfo interMotionIndicatorInfo = this.currentInfo;
        if ((interMotionIndicatorInfo != null ? interMotionIndicatorInfo.getStatus() : null) == InteractionMotionState.INVITING) {
            this.inviteTimer.postDelayed(new ChatLandInteractionMotionIndicatorKt$sam$java_lang_Runnable$0(new ChatLandInteractionMotionIndicator$updateInviteTick$2(this)), 1000L);
        }
    }

    public final void bind(InterMotionIndicatorInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.currentInfo = info;
        hideTips();
        int i3 = WhenMappings.$EnumSwitchMapping$0[info.getStatus().ordinal()];
        if (i3 == 1) {
            startInviteTick(info.getCountdown());
            ViewExtensionsKt.setVisibility(this, true);
            TextView textView = this.binding.tvTick;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tvTick");
            ViewExtensionsKt.setVisibility(textView, true);
            showInviteTips(info.getTips());
            this.binding.btnAction.setBackgroundResource(INVITING_BG_RES);
        } else if (i3 != 2) {
            ViewExtensionsKt.setVisibility(this, false);
        } else {
            ViewExtensionsKt.setVisibility(this, true);
            TextView textView2 = this.binding.tvTick;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvTick");
            ViewExtensionsKt.setVisibility(textView2, false);
            showCancelTips(info.getTips());
            this.binding.btnAction.setBackgroundResource(PAIRING_BG_RES);
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandInteractionMotionIndicator$bind$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                VasSquareChatLandInteractionMotionIndicatorBinding vasSquareChatLandInteractionMotionIndicatorBinding;
                Map<String, Object> reportParams;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                vasSquareChatLandInteractionMotionIndicatorBinding = ChatLandInteractionMotionIndicator.this.binding;
                View root = vasSquareChatLandInteractionMotionIndicatorBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                reportParams = ChatLandInteractionMotionIndicator.this.getReportParams();
                squareReporter.reportEvent("imp", root, reportParams);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        View root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        squareReporter.setElementInfo(root, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_INDICATOR, new LinkedHashMap(), false, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        InterMotionIndicatorInfo interMotionIndicatorInfo = this.currentInfo;
        if (interMotionIndicatorInfo != null) {
            Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
            FrameLayout frameLayout = this.binding.btnAction;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.btnAction");
            int id5 = frameLayout.getId();
            if (valueOf != null && valueOf.intValue() == id5) {
                hideTips();
                Function1<? super InterMotionIndicatorInfo, Unit> function1 = this.onClickCallback;
                if (function1 != null) {
                    function1.invoke(interMotionIndicatorInfo);
                }
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                View root = this.binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                squareReporter.reportEvent("clck", root, getReportParams());
                return;
            }
            LinearLayout linearLayout = this.binding.lvTips;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.lvTips");
            int id6 = linearLayout.getId();
            if (valueOf != null && valueOf.intValue() == id6) {
                hideTips();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.tipsTimer.removeCallbacks(new ChatLandInteractionMotionIndicatorKt$sam$java_lang_Runnable$0(new ChatLandInteractionMotionIndicator$onDetachedFromWindow$1(this)));
        this.inviteTimer.removeCallbacks(new ChatLandInteractionMotionIndicatorKt$sam$java_lang_Runnable$0(new ChatLandInteractionMotionIndicator$onDetachedFromWindow$2(this)));
    }

    public final void setOnClickCallback(Function1<? super InterMotionIndicatorInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.onClickCallback = callback;
    }

    public final void setOnInviteTimeoutCallback(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.onInviteTimeoutCallback = callback;
    }

    public ChatLandInteractionMotionIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> getReportParams() {
        Map<String, Object> mutableMapOf;
        int i3;
        Pair[] pairArr = new Pair[1];
        InterMotionIndicatorInfo interMotionIndicatorInfo = this.currentInfo;
        InteractionMotionState status = interMotionIndicatorInfo != null ? interMotionIndicatorInfo.getStatus() : null;
        pairArr[0] = TuplesKt.to("zplan_fit_status_id", Integer.valueOf((status == null || (i3 = WhenMappings.$EnumSwitchMapping$1[status.ordinal()]) == 1 || i3 != 2) ? 0 : 1));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    public final void hide() {
        this.currentInfo = null;
        hideTips();
        ViewExtensionsKt.setVisibility(this, false);
    }

    public /* synthetic */ ChatLandInteractionMotionIndicator(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandInteractionMotionIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareChatLandInteractionMotionIndicatorBinding inflate = VasSquareChatLandInteractionMotionIndicatorBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareChatLandInterac\u2026ater.from(context), this)");
        this.binding = inflate;
        this.tipsTimer = new Handler(Looper.getMainLooper());
        this.inviteTimer = new Handler(Looper.getMainLooper());
        this.inviteTickLeft = -1;
        ViewExtensionsKt.setVisibility(this, false);
        setOrientation(1);
        inflate.btnAction.setOnClickListener(this);
        inflate.lvTips.setOnClickListener(this);
    }
}
