package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.databinding.VasSquareChatLandInteractionMotionInvitePanelBinding;
import com.tencent.state.template.data.InviteInfo;
import com.tencent.state.utils.FaceUtils;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareSingleCheckBoxConfig;
import com.tencent.state.view.SquareSingleCheckBoxView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u000fJ\u0010\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\"J\b\u0010#\u001a\u00020\u0015H\u0014J\u0012\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0015H\u0014J\b\u0010(\u001a\u00020\u0015H\u0002J1\u0010)\u001a\u00020\u00152)\u0010*\u001a%\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011j\u0004\u0018\u0001`\u0016J[\u0010+\u001a\u00020\u00152S\u0010*\u001aO\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0018j\u0004\u0018\u0001`\u001aJ1\u0010,\u001a\u00020\u00152)\u0010*\u001a%\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011j\u0004\u0018\u0001`\u001cR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R1\u0010\u0010\u001a%\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011j\u0004\u0018\u0001`\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R[\u0010\u0017\u001aO\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0018j\u0004\u0018\u0001`\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R1\u0010\u001b\u001a%\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0011j\u0004\u0018\u0001`\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandInteractionMotionInvitePanel;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareChatLandInteractionMotionInvitePanelBinding;", "ignore7Days", "", "inviteInfo", "Lcom/tencent/state/template/data/InviteInfo;", "onClickHeadCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "", "Lcom/tencent/state/square/chatland/view/OnClickHeadCallbackFun;", "onSelectCallback", "Lkotlin/Function3;", "agree", "Lcom/tencent/state/square/chatland/view/OnSelectCallbackFun;", "onTimeoutCallback", "Lcom/tencent/state/square/chatland/view/OnTimeoutCallbackFun;", SemanticAttributes.FaasTriggerValues.TIMER, "Landroid/os/Handler;", "bind", "hide", "billNo", "", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_CLICK, "v", "Landroid/view/View;", NodeProps.ON_DETACHED_FROM_WINDOW, "onTimeout", "setOnClickHeadCallback", "cb", "setOnSelectCallback", "setOnTimeoutCallback", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandInteractionMotionInvitePanel extends FrameLayout implements View.OnClickListener {
    private static final String TAG = "ChatLandInteractionMotionInvitePanel";
    private final VasSquareChatLandInteractionMotionInvitePanelBinding binding;
    private boolean ignore7Days;
    private InviteInfo inviteInfo;
    private Function1<? super InviteInfo, Unit> onClickHeadCallback;
    private Function3<? super Boolean, ? super Boolean, ? super InviteInfo, Unit> onSelectCallback;
    private Function1<? super InviteInfo, Unit> onTimeoutCallback;
    private final Handler timer;

    public ChatLandInteractionMotionInvitePanel(Context context) {
        this(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTimeout() {
        Function1<? super InviteInfo, Unit> function1;
        SquareBaseKt.getSquareLog().d(TAG, "onTimeout: " + this.inviteInfo);
        ViewExtensionsKt.setVisibility(this, false);
        InviteInfo inviteInfo = this.inviteInfo;
        if (inviteInfo == null || (function1 = this.onTimeoutCallback) == null) {
            return;
        }
        function1.invoke(inviteInfo);
    }

    public final void bind(InviteInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.timer.removeCallbacks(new ChatLandInteractionMotionInvitePanelKt$sam$java_lang_Runnable$0(new ChatLandInteractionMotionInvitePanel$bind$1(this)));
        this.inviteInfo = info;
        long j3 = 1000;
        long expireTs = info.getExpireTs() * j3;
        Square square = Square.INSTANCE;
        long serverTime = expireTs - (square.getConfig().getCommonUtils().getServerTime() * j3);
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "bind invite info, serv expire time:" + (info.getExpireTs() * j3) + ", current serv time:" + (square.getConfig().getCommonUtils().getServerTime() * j3) + ", timeoutMs:" + serverTime, null, 4, null);
        this.timer.postDelayed(new ChatLandInteractionMotionInvitePanelKt$sam$java_lang_Runnable$0(new ChatLandInteractionMotionInvitePanel$bind$2(this)), serverTime);
        this.ignore7Days = false;
        final String valueOf = String.valueOf(info.getUser().getUin());
        FaceUtils.INSTANCE.loadHeadIcon(square.getConfig().getObtainInstanceHelper().getFaceDecoder(), this.binding.imgAvatar, valueOf, false, new Function1<String, Boolean>() { // from class: com.tencent.state.square.chatland.view.ChatLandInteractionMotionInvitePanel$bind$3
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
        ICommonUtils commonUtils = square.getConfig().getCommonUtils();
        String nick = info.getUser().getNick();
        if (nick.length() == 0) {
            nick = valueOf;
        }
        String friendRemarkName = commonUtils.getFriendRemarkName(valueOf, nick);
        TextView textView = this.binding.tvNickname;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvNickname");
        textView.setText(friendRemarkName);
        SquareSingleCheckBoxView squareSingleCheckBoxView = this.binding.checkboxIgnore;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        SquareSingleCheckBoxConfig squareSingleCheckBoxConfig = new SquareSingleCheckBoxConfig(context);
        squareSingleCheckBoxConfig.setTextSize(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 12));
        squareSingleCheckBoxConfig.setTextColor((int) 4287137928L);
        String string = getContext().getString(R.string.xeq);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026motion_invite_ignore_tip)");
        squareSingleCheckBoxConfig.setText(string);
        squareSingleCheckBoxConfig.setIconSize(new Size(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 11), com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 11)));
        squareSingleCheckBoxConfig.setIconDefaultSelected(this.ignore7Days);
        squareSingleCheckBoxConfig.setTextMargin(new Rect(com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 3), 0, 0, 0));
        Unit unit = Unit.INSTANCE;
        squareSingleCheckBoxView.refreshContent(squareSingleCheckBoxConfig);
        this.binding.checkboxIgnore.setOnCheckCallback(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandInteractionMotionInvitePanel$bind$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ChatLandInteractionMotionInvitePanel.this.ignore7Days = z16;
            }
        });
        this.binding.checkBoxIgnoreHotspot.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ChatLandInteractionMotionInvitePanel$bind$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSquareChatLandInteractionMotionInvitePanelBinding vasSquareChatLandInteractionMotionInvitePanelBinding;
                vasSquareChatLandInteractionMotionInvitePanelBinding = ChatLandInteractionMotionInvitePanel.this.binding;
                vasSquareChatLandInteractionMotionInvitePanelBinding.checkboxIgnore.toggle();
            }
        });
        TextView textView2 = this.binding.tvTitle;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.tvTitle");
        textView2.setText(getContext().getString(R.string.xer, info.getMotionName()));
        ViewExtensionsKt.setVisibility(this, true);
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandInteractionMotionInvitePanel$bind$7
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
                VasSquareChatLandInteractionMotionInvitePanelBinding vasSquareChatLandInteractionMotionInvitePanelBinding;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                vasSquareChatLandInteractionMotionInvitePanelBinding = ChatLandInteractionMotionInvitePanel.this.binding;
                View root = vasSquareChatLandInteractionMotionInvitePanelBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                squareReporter.reportEvent("imp", root, new LinkedHashMap());
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        View root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        squareReporter.setElementInfo(root, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_INVITE_PANEL, new LinkedHashMap(), false, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        Function1<? super InviteInfo, Unit> function1;
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        InviteInfo inviteInfo = this.inviteInfo;
        if (inviteInfo != null) {
            Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
            TextView textView = this.binding.btnAgree;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.btnAgree");
            int id5 = textView.getId();
            if (valueOf != null && valueOf.intValue() == id5) {
                Function3<? super Boolean, ? super Boolean, ? super InviteInfo, Unit> function3 = this.onSelectCallback;
                if (function3 != null) {
                    function3.invoke(Boolean.TRUE, Boolean.valueOf(this.ignore7Days), inviteInfo);
                }
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                View root = this.binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_is_selected_when_clck", Integer.valueOf(this.ignore7Days ? 1 : 0)), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_CLICK_TYPE, "agree"));
                squareReporter.reportEvent("clck", root, mutableMapOf2);
                return;
            }
            TextView textView2 = this.binding.btnIgnore;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.btnIgnore");
            int id6 = textView2.getId();
            if (valueOf != null && valueOf.intValue() == id6) {
                Function3<? super Boolean, ? super Boolean, ? super InviteInfo, Unit> function32 = this.onSelectCallback;
                if (function32 != null) {
                    function32.invoke(Boolean.FALSE, Boolean.valueOf(this.ignore7Days), inviteInfo);
                }
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                View root2 = this.binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_is_selected_when_clck", Integer.valueOf(this.ignore7Days ? 1 : 0)), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_POPUP_CLICK_TYPE, TagValue.IGNORE));
                squareReporter2.reportEvent("clck", root2, mutableMapOf);
                return;
            }
            CircleBoarderImageView circleBoarderImageView = this.binding.imgAvatar;
            Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.imgAvatar");
            int id7 = circleBoarderImageView.getId();
            if (valueOf == null || valueOf.intValue() != id7 || (function1 = this.onClickHeadCallback) == null) {
                return;
            }
            function1.invoke(inviteInfo);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.timer.removeCallbacks(new ChatLandInteractionMotionInvitePanelKt$sam$java_lang_Runnable$0(new ChatLandInteractionMotionInvitePanel$onDetachedFromWindow$1(this)));
    }

    public final void setOnClickHeadCallback(Function1<? super InviteInfo, Unit> cb5) {
        this.onClickHeadCallback = cb5;
    }

    public final void setOnSelectCallback(Function3<? super Boolean, ? super Boolean, ? super InviteInfo, Unit> cb5) {
        this.onSelectCallback = cb5;
    }

    public final void setOnTimeoutCallback(Function1<? super InviteInfo, Unit> cb5) {
        this.onTimeoutCallback = cb5;
    }

    public ChatLandInteractionMotionInvitePanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ChatLandInteractionMotionInvitePanel(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandInteractionMotionInvitePanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquareChatLandInteractionMotionInvitePanelBinding inflate = VasSquareChatLandInteractionMotionInvitePanelBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareChatLandInterac\u2026ater.from(context), this)");
        this.binding = inflate;
        this.timer = new Handler(Looper.getMainLooper());
        inflate.btnAgree.setOnClickListener(this);
        inflate.btnIgnore.setOnClickListener(this);
        inflate.imgAvatar.setOnClickListener(this);
        setClickable(true);
        ViewExtensionsKt.setVisibility(this, false);
    }

    public final void hide(String billNo) {
        if (billNo != null) {
            InviteInfo inviteInfo = this.inviteInfo;
            if (!Intrinsics.areEqual(inviteInfo != null ? inviteInfo.getBillNo() : null, billNo)) {
                return;
            }
        }
        this.inviteInfo = null;
        this.timer.removeCallbacks(new ChatLandInteractionMotionInvitePanelKt$sam$java_lang_Runnable$0(new ChatLandInteractionMotionInvitePanel$hide$1(this)));
        ViewExtensionsKt.setVisibility(this, false);
    }
}
