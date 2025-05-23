package com.tencent.state.publicchat.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.publicchat.IPublicChatUIOwner;
import com.tencent.state.publicchat.action.MarkAllReadAction;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.action.MsgInputBoxHidden;
import com.tencent.state.publicchat.action.MsgInputBoxShown;
import com.tencent.state.publicchat.action.SendTextMsgAction;
import com.tencent.state.publicchat.activity.MsgChangeEventData;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.data.ShowMsgPanelParams;
import com.tencent.state.publicchat.data.UserInfo;
import com.tencent.state.publicchat.view.msgPanel.IMessagePanelItemFactory;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.SimpleSquarePagViewListener;
import com.tencent.state.square.databinding.VasSquarePublicChatListBinding;
import com.tencent.state.utils.ISoftKeyboardStateListener;
import com.tencent.state.utils.SoftKeyboardStateWatcher;
import com.tencent.state.view.SquareImageView;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0002QRB@\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020\u000fJ\b\u0010'\u001a\u00020\u000fH\u0002J\u0010\u0010(\u001a\u00020\u000f2\b\b\u0002\u0010)\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020\u000fJ\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u000fH\u0002J\b\u0010.\u001a\u00020\u000fH\u0002J\u0006\u0010/\u001a\u00020\u000fJ\u0006\u00100\u001a\u00020\u000fJ\b\u00101\u001a\u00020\u000fH\u0002J\u0006\u00102\u001a\u00020\u000fJ\u000e\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u000205J\b\u00106\u001a\u00020\u000fH\u0014J\b\u00107\u001a\u00020\u000fH\u0016J\u0010\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020,H\u0016J\u0012\u0010:\u001a\u00020\u00142\b\u00104\u001a\u0004\u0018\u00010;H\u0016J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u0019H\u0002J\u0006\u0010>\u001a\u00020\u000fJ\b\u0010?\u001a\u00020\u000fH\u0002J\b\u0010@\u001a\u00020\u000fH\u0002J\u0006\u0010A\u001a\u00020\u000fJ&\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020,J\u0010\u0010H\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u001bH\u0002J\u000e\u0010J\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020,J.\u0010L\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020F2\u0006\u0010M\u001a\u00020N2\u0006\u0010G\u001a\u00020,J\b\u0010O\u001a\u00020\u000fH\u0002J\b\u0010P\u001a\u00020\u000fH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006S"}, d2 = {"Lcom/tencent/state/publicchat/view/MessageListView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/state/utils/ISoftKeyboardStateListener;", "context", "Landroid/content/Context;", "owner", "Lcom/tencent/state/publicchat/IPublicChatUIOwner;", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Landroid/content/Context;Lcom/tencent/state/publicchat/IPublicChatUIOwner;Lcom/tencent/state/publicchat/data/PublicChatConfInfo;Lkotlin/jvm/functions/Function1;)V", "adapter", "Lcom/tencent/state/publicchat/view/MessageListAdapter;", "autoScroll", "", "binding", "Lcom/tencent/state/square/databinding/VasSquarePublicChatListBinding;", "broadcastPAGTasks", "", "Lcom/tencent/state/publicchat/view/MessageListView$BroadcastTask;", "currentPanelParam", "Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;", "isBroadcastPlaying", "isFold", "softKeyboardStateWatcher", "Lcom/tencent/state/utils/SoftKeyboardStateWatcher;", "squarePagView", "Lcom/tencent/state/square/api/ISquarePagView;", "appendBroadcastPAGTask", "url", "", "content", "cleanMsgInputBox", "disableAutoScroll", "enableAutoScroll", "executeScroll", "expandMsgList", "getTopOffsetPx", "", "handlePAGAnimationEnd", "hideMsgInputBox", "hideMsgPanel", "hideUnreadNumBtn", "initReportCreated", "initView", "notifyItemsChanged", "event", "Lcom/tencent/state/publicchat/activity/MsgChangeEventData;", NodeProps.ON_DETACHED_FROM_WINDOW, "onSoftKeyboardClosed", "onSoftKeyboardOpened", "keyboardHeightInPx", "onTouchEvent", "Landroid/view/MotionEvent;", "playPAGWithTask", "task", "refreshThemeData", "scrollToBottom", "setupPAGViewIfNeeded", "showMsgInputBox", "showMsgPanel", HippyTKDListViewAdapter.X, "y", "msg", "Lcom/tencent/state/publicchat/data/MsgInfo;", "appId", "showPanel", "params", "showUnreadNumBtn", WidgetCacheConstellationData.NUM, "showUserPanel", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/publicchat/data/UserInfo;", "toggleMsgList", "updateUnreadNumBtnPosition", "BroadcastTask", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MessageListView extends FrameLayout implements ISoftKeyboardStateListener {
    public static final int MSG_LIST_PADDING_BOTTOM = 96;
    public static final int MSG_LIST_PADDING_TOP = 43;
    public static final int MSG_PANEL_ARROW_DEFAULT_LEFT = 35;
    public static final int MSG_PANEL_OUT_WINDOW_RIGHT_OFFSET = 5;
    public static final int MSG_PANEL_POINTER_X_OFFSET_DP = 41;
    public static final String TAG = "MessageListView";
    public static final int UNREAD_MSG_BTN_HEIGHT_DP = 27;
    private final MessageListAdapter adapter;
    private boolean autoScroll;
    private final VasSquarePublicChatListBinding binding;
    private final List<BroadcastTask> broadcastPAGTasks;
    private final PublicChatConfInfo conf;
    private ShowMsgPanelParams currentPanelParam;
    private final Function1<MsgAction, Unit> dispatchAction;
    private boolean isBroadcastPlaying;
    private boolean isFold;
    private final IPublicChatUIOwner owner;
    private SoftKeyboardStateWatcher softKeyboardStateWatcher;
    private ISquarePagView squarePagView;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/publicchat/view/MessageListView$BroadcastTask;", "", "pagUrl", "", "content", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getPagUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class BroadcastTask {
        private final String content;
        private final String pagUrl;

        public BroadcastTask() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPagUrl() {
            return this.pagUrl;
        }

        /* renamed from: component2, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        public final BroadcastTask copy(String pagUrl, String content) {
            Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
            Intrinsics.checkNotNullParameter(content, "content");
            return new BroadcastTask(pagUrl, content);
        }

        public final String getContent() {
            return this.content;
        }

        public final String getPagUrl() {
            return this.pagUrl;
        }

        public int hashCode() {
            String str = this.pagUrl;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.content;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "BroadcastTask(pagUrl=" + this.pagUrl + ", content=" + this.content + ")";
        }

        public BroadcastTask(String pagUrl, String content) {
            Intrinsics.checkNotNullParameter(pagUrl, "pagUrl");
            Intrinsics.checkNotNullParameter(content, "content");
            this.pagUrl = pagUrl;
            this.content = content;
        }

        public /* synthetic */ BroadcastTask(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BroadcastTask)) {
                return false;
            }
            BroadcastTask broadcastTask = (BroadcastTask) other;
            return Intrinsics.areEqual(this.pagUrl, broadcastTask.pagUrl) && Intrinsics.areEqual(this.content, broadcastTask.content);
        }

        public static /* synthetic */ BroadcastTask copy$default(BroadcastTask broadcastTask, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = broadcastTask.pagUrl;
            }
            if ((i3 & 2) != 0) {
                str2 = broadcastTask.content;
            }
            return broadcastTask.copy(str, str2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MessageListView(Context context, IPublicChatUIOwner owner, PublicChatConfInfo conf, Function1<? super MsgAction, Unit> dispatchAction) {
        super(context, null);
        List emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        this.owner = owner;
        this.conf = conf;
        this.dispatchAction = dispatchAction;
        VasSquarePublicChatListBinding inflate = VasSquarePublicChatListBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquarePublicChatListB\u2026 this,\n        true\n    )");
        this.binding = inflate;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.adapter = new MessageListAdapter(conf, emptyList, owner.getRoomThemeData(), dispatchAction);
        this.autoScroll = true;
        this.broadcastPAGTasks = new ArrayList();
        Activity activity = (Activity) (context instanceof Activity ? context : null);
        if (activity != null) {
            Window window = activity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "activity.window");
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            SoftKeyboardStateWatcher softKeyboardStateWatcher = new SoftKeyboardStateWatcher(decorView, false, 2, null);
            this.softKeyboardStateWatcher = softKeyboardStateWatcher;
            softKeyboardStateWatcher.addSoftKeyboardStateListener(this);
        }
        initView();
        initReportCreated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disableAutoScroll() {
        SquareBaseKt.getSquareLog().d(TAG, "disableAutoScroll");
        if (this.autoScroll) {
            this.autoScroll = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideMsgInputBox() {
        Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (!(systemService instanceof InputMethodManager)) {
            systemService = null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        EditText editText = this.binding.msgInputBox;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.msgInputBox");
        ViewExtensionsKt.setVisibility(editText, false);
        editText.clearFocus();
        if (inputMethodManager != null) {
            CoordinatorLayout mRv = this.binding.getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
            inputMethodManager.hideSoftInputFromWindow(mRv.getWindowToken(), 0);
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$hideMsgInputBox$1
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
                MessageListView.this.updateUnreadNumBtnPosition();
            }
        });
        this.dispatchAction.invoke(new MsgInputBoxHidden());
    }

    private final void initReportCreated() {
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout linearLayout = this.binding.foldBtn;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.foldBtn");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(this.owner.getAppId())));
        squareReporter.setElementInfo(linearLayout, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LIST_COLLAPSE_BTN, mutableMapOf, false, false);
        SquareBaseKt.getSquareThread().postOnUiDelayed(50L, new Function0<Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$initReportCreated$1
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
                VasSquarePublicChatListBinding vasSquarePublicChatListBinding;
                IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                vasSquarePublicChatListBinding = MessageListView.this.binding;
                LinearLayout linearLayout2 = vasSquarePublicChatListBinding.foldBtn;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.foldBtn");
                squareReporter2.reportEvent("imp", linearLayout2, new LinkedHashMap());
            }
        });
        IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
        RelativeLayout relativeLayout = this.binding.msgPanel;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.msgPanel");
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_PLOT_APPID_ID, Integer.valueOf(this.owner.getAppId())));
        squareReporter2.setElementInfo(relativeLayout, SquareReportConst.ElementId.ELEMENT_ID_CHAT_MSG_PANEL, mutableMapOf2, false, false);
    }

    private final void playPAGWithTask(BroadcastTask task) {
        if (this.isBroadcastPlaying) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new MessageListView$playPAGWithTask$1(this, task, null), 3, null);
    }

    private final void scrollToBottom() {
        SquareBaseKt.getSquareThread().postOnUiDelayed(200L, new Function0<Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$scrollToBottom$1
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
                MessageListAdapter messageListAdapter;
                VasSquarePublicChatListBinding vasSquarePublicChatListBinding;
                MessageListView.this.hideMsgPanel();
                messageListAdapter = MessageListView.this.adapter;
                int size = messageListAdapter.getItems().size();
                SquareBaseKt.getSquareLog().d(MessageListView.TAG, "\u6eda\u52a8\u5230\u5e95\u90e8 " + size);
                vasSquarePublicChatListBinding = MessageListView.this.binding;
                vasSquarePublicChatListBinding.msgsContainer.smoothScrollToPosition(size);
            }
        });
    }

    private final void setupPAGViewIfNeeded() {
        View view;
        ISquarePagView iSquarePagView = this.squarePagView;
        if (((iSquarePagView == null || (view = iSquarePagView.getView()) == null) ? null : view.getParent()) != null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this);
        ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ISquarePagView pagView = commonUtils.getPagView(context);
        if (pagView != null) {
            final View view2 = pagView.getView();
            pagView.setPagViewListener(new SimpleSquarePagViewListener() { // from class: com.tencent.state.publicchat.view.MessageListView$setupPAGViewIfNeeded$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(null, 1, null);
                }

                @Override // com.tencent.state.square.api.SimpleSquarePagViewListener, com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationCancel(ISquarePagView squarePagView) {
                    MessageListView messageListView = (MessageListView) weakReference.get();
                    if (messageListView != null) {
                        messageListView.handlePAGAnimationEnd();
                    }
                }

                @Override // com.tencent.state.square.api.SimpleSquarePagViewListener, com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationEnd(ISquarePagView squarePagView) {
                    MessageListView messageListView = (MessageListView) weakReference.get();
                    if (messageListView != null) {
                        messageListView.handlePAGAnimationEnd();
                    }
                }
            });
            this.binding.foldBtn.addView(view2);
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$setupPAGViewIfNeeded$$inlined$let$lambda$2
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
                    View view3 = view2;
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.state.square.common.ViewExtensionsKt.dip(this.getContext(), 175), com.tencent.state.square.common.ViewExtensionsKt.dip(this.getContext(), 35));
                    layoutParams.gravity = 80;
                    layoutParams.setMarginStart(com.tencent.state.square.common.ViewExtensionsKt.dip(this.getContext(), 8));
                    Unit unit = Unit.INSTANCE;
                    view3.setLayoutParams(layoutParams);
                }
            });
            MessageListView messageListView = (MessageListView) weakReference.get();
            if (messageListView != null) {
                messageListView.squarePagView = pagView;
            }
        }
    }

    private final void showPanel(ShowMsgPanelParams params) {
        SquareBaseKt.getSquareLog().d(TAG, "showMsgPanel " + params);
        if (params.isMyMsg()) {
            return;
        }
        if (params.isSame(this.currentPanelParam)) {
            hideMsgPanel();
            return;
        }
        this.currentPanelParam = params;
        disableAutoScroll();
        RelativeLayout relativeLayout = this.binding.msgPanel;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.msgPanel");
        relativeLayout.setVisibility(4);
        this.binding.panelContainer.removeAllViews();
        for (final IMessagePanelItemFactory iMessagePanelItemFactory : this.owner.getMsgPanelItemView(params)) {
            ShowMsgPanelParams showMsgPanelParams = this.currentPanelParam;
            if (showMsgPanelParams != null) {
                LinearLayout linearLayout = this.binding.panelContainer;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                linearLayout.addView(iMessagePanelItemFactory.create(context, showMsgPanelParams, new Function1<MsgAction, Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$showPanel$$inlined$forEach$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(MsgAction msgAction) {
                        invoke2(msgAction);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final MsgAction msgAction) {
                        VasSquarePublicChatListBinding vasSquarePublicChatListBinding;
                        Function1 function1;
                        Intrinsics.checkNotNullParameter(msgAction, "msgAction");
                        this.hideMsgPanel();
                        vasSquarePublicChatListBinding = this.binding;
                        EditText editText = vasSquarePublicChatListBinding.msgInputBox;
                        Intrinsics.checkNotNullExpressionValue(editText, "binding.msgInputBox");
                        if (ViewExtensionsKt.isVisible(editText)) {
                            this.hideMsgInputBox();
                            SquareBaseKt.getSquareThread().postOnUiDelayed(200L, new Function0<Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$showPanel$$inlined$forEach$lambda$1.1
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
                                    Function1 function12;
                                    function12 = this.dispatchAction;
                                    function12.invoke(msgAction);
                                }
                            });
                        } else {
                            function1 = this.dispatchAction;
                            function1.invoke(msgAction);
                        }
                    }
                }));
            }
        }
        SquareBaseKt.getSquareThread().postOnUi(new MessageListView$showPanel$2(this, params));
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        RelativeLayout relativeLayout2 = this.binding.msgPanel;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.msgPanel");
        squareReporter.reportEvent("imp", relativeLayout2, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleMsgList() {
        this.isFold = !this.isFold;
        RecyclerView recyclerView = this.binding.msgsContainer;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.msgsContainer");
        ViewExtensionsKt.setVisibility(recyclerView, !this.isFold);
        FrameLayout frameLayout = this.binding.unreadNumWrapper;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.unreadNumWrapper");
        ViewExtensionsKt.setVisibility(frameLayout, !this.isFold);
        SquareImageView squareImageView = this.binding.avatarBubbleIcon;
        Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.avatarBubbleIcon");
        squareImageView.setRotation(this.isFold ? 180.0f : 0.0f);
        hideMsgPanel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUnreadNumBtnPosition() {
        final Rect rect = new Rect();
        this.binding.msgsContainer.getGlobalVisibleRect(rect);
        FrameLayout frameLayout = this.binding.unreadNumWrapper;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.unreadNumWrapper");
        ViewExtensionsKt.updateLayoutParams(frameLayout, new Function1<CoordinatorLayout.LayoutParams, Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$updateUnreadNumBtnPosition$$inlined$let$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CoordinatorLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CoordinatorLayout.LayoutParams receiver) {
                int topOffsetPx;
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                int dip = rect.bottom - com.tencent.state.square.common.ViewExtensionsKt.dip(this.getContext(), 27);
                topOffsetPx = this.getTopOffsetPx();
                ((ViewGroup.MarginLayoutParams) receiver).topMargin = dip - topOffsetPx;
                ((ViewGroup.MarginLayoutParams) receiver).leftMargin = rect.left;
            }
        });
    }

    public final void appendBroadcastPAGTask(String url, String content) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(content, "content");
        BroadcastTask broadcastTask = new BroadcastTask(url, content);
        setupPAGViewIfNeeded();
        this.broadcastPAGTasks.add(broadcastTask);
        playPAGWithTask(broadcastTask);
    }

    public final void cleanMsgInputBox() {
        this.binding.msgInputBox.setText("");
    }

    public final void enableAutoScroll(boolean executeScroll) {
        SquareBaseKt.getSquareLog().d(TAG, "enableAutoScroll");
        this.autoScroll = true;
        this.dispatchAction.invoke(new MarkAllReadAction());
        if (executeScroll) {
            scrollToBottom();
        }
    }

    public final void expandMsgList() {
        if (this.isFold) {
            this.isFold = false;
            RecyclerView recyclerView = this.binding.msgsContainer;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.msgsContainer");
            ViewExtensionsKt.setVisibility(recyclerView, !this.isFold);
            FrameLayout frameLayout = this.binding.unreadNumWrapper;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.unreadNumWrapper");
            ViewExtensionsKt.setVisibility(frameLayout, !this.isFold);
            SquareImageView squareImageView = this.binding.avatarBubbleIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.avatarBubbleIcon");
            squareImageView.setRotation(this.isFold ? 180.0f : 0.0f);
            hideMsgPanel();
        }
    }

    public final void hideMsgPanel() {
        SquareBaseKt.getSquareLog().d(TAG, "hideMsgPanel");
        this.currentPanelParam = null;
        RelativeLayout relativeLayout = this.binding.msgPanel;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.msgPanel");
        if (ViewExtensionsKt.isVisible(relativeLayout)) {
            RelativeLayout relativeLayout2 = this.binding.msgPanel;
            ViewExtensionsKt.updateLayoutParams(relativeLayout2, new Function1<CoordinatorLayout.LayoutParams, Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$hideMsgPanel$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CoordinatorLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(CoordinatorLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    ((ViewGroup.MarginLayoutParams) receiver).topMargin = 0;
                    ((ViewGroup.MarginLayoutParams) receiver).leftMargin = 0;
                }
            });
            ViewExtensionsKt.setVisibility(relativeLayout2, false);
            this.binding.panelContainer.removeAllViews();
        }
    }

    public final void hideUnreadNumBtn() {
        TextView textView = this.binding.unreadNumBtn;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.unreadNumBtn");
        if (textView.getVisibility() == 0) {
            TextView textView2 = this.binding.unreadNumBtn;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.unreadNumBtn");
            ViewExtensionsKt.setVisibility(textView2, false);
        }
    }

    public final void initView() {
        this.binding.foldBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.publicchat.view.MessageListView$initView$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                MessageListView.this.toggleMsgList();
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                squareReporter.reportEvent("clck", it, new LinkedHashMap());
            }
        });
        EditText editText = this.binding.msgInputBox;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.msgInputBox");
        ViewExtensionsKt.setVisibility(editText, false);
        this.binding.msgInputBox.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.state.publicchat.view.MessageListView$initView$2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                VasSquarePublicChatListBinding vasSquarePublicChatListBinding;
                boolean isBlank;
                Function1 function1;
                if (i3 != 4) {
                    return false;
                }
                vasSquarePublicChatListBinding = MessageListView.this.binding;
                EditText editText2 = vasSquarePublicChatListBinding.msgInputBox;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.msgInputBox");
                String obj = editText2.getText().toString();
                isBlank = StringsKt__StringsJVMKt.isBlank(obj);
                if (!isBlank) {
                    MessageListView.this.hideMsgInputBox();
                    function1 = MessageListView.this.dispatchAction;
                    function1.invoke(new SendTextMsgAction(obj));
                }
                return true;
            }
        });
        EditText editText2 = this.binding.msgInputBox;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.msgInputBox");
        editText2.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(this.owner.getTextMsgMaxLen(this.conf))});
        RecyclerView view = this.binding.msgsContainer;
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        view.setLayoutManager(linearLayoutManager);
        view.setAdapter(this.adapter);
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 20);
        Unit unit = Unit.INSTANCE;
        view.setRecycledViewPool(recycledViewPool);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.state.publicchat.view.MessageListView$initView$$inlined$let$lambda$1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v3, MotionEvent event) {
                Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
                if ((valueOf == null || valueOf.intValue() != 0) && (valueOf == null || valueOf.intValue() != 2)) {
                    return false;
                }
                MessageListView.this.disableAutoScroll();
                MessageListView.this.hideMsgPanel();
                return false;
            }
        });
        view.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.tencent.state.publicchat.view.MessageListView$initView$$inlined$let$lambda$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                MessageListAdapter messageListAdapter;
                boolean z16;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0) {
                    int findLastCompletelyVisibleItemPosition = LinearLayoutManager.this.findLastCompletelyVisibleItemPosition();
                    messageListAdapter = this.adapter;
                    boolean z17 = findLastCompletelyVisibleItemPosition == messageListAdapter.getNUM_BACKGOURND_ICON() - 1;
                    if (z17) {
                        z16 = this.autoScroll;
                        if (!z16) {
                            this.enableAutoScroll(false);
                            this.hideUnreadNumBtn();
                        }
                    }
                    SquareBaseKt.getSquareLog().d(MessageListView.TAG, "\u6eda\u52a8\u5230\u6700\u5e95\u90e8 " + z17);
                }
            }
        });
        this.binding.unreadNumBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.publicchat.view.MessageListView$initView$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MessageListView.this.hideUnreadNumBtn();
                MessageListView.enableAutoScroll$default(MessageListView.this, false, 1, null);
            }
        });
        this.binding.chatList.setPadding(0, 0, 0, com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 96));
    }

    public final void notifyItemsChanged(MsgChangeEventData event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            this.adapter.setItems(event.getMsgs());
            if (event.isAdd()) {
                this.adapter.notifyItemRangeInserted(event.getIndex(), event.getCount());
            } else if (event.isDel()) {
                this.adapter.notifyItemRangeRemoved(event.getIndex(), event.getCount());
            } else {
                this.adapter.notifyDataSetChanged();
            }
            if (this.autoScroll) {
                this.dispatchAction.invoke(new MarkAllReadAction());
                scrollToBottom();
            }
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "notifyItemsChanged failed " + th5, null, 4, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SoftKeyboardStateWatcher softKeyboardStateWatcher = this.softKeyboardStateWatcher;
        if (softKeyboardStateWatcher != null) {
            softKeyboardStateWatcher.dispose();
        }
    }

    @Override // com.tencent.state.utils.ISoftKeyboardStateListener
    public void onSoftKeyboardClosed() {
        hideMsgInputBox();
        this.binding.chatList.setPadding(0, 0, 0, com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 96));
        hideMsgPanel();
    }

    public final void refreshThemeData() {
        this.adapter.refreshThemeData(this.owner.getRoomThemeData());
    }

    public final void showMsgInputBox() {
        Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (!(systemService instanceof InputMethodManager)) {
            systemService = null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        EditText editText = this.binding.msgInputBox;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.msgInputBox");
        this.binding.chatList.setPadding(0, com.tencent.state.square.common.ViewExtensionsKt.dip(getContext(), 43), 0, 0);
        hideMsgPanel();
        ViewExtensionsKt.setVisibility(editText, true);
        editText.requestFocus();
        editText.performClick();
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 0);
        }
        if (this.isFold) {
            toggleMsgList();
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$showMsgInputBox$1
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
                MessageListView.this.updateUnreadNumBtnPosition();
            }
        });
        this.dispatchAction.invoke(new MsgInputBoxShown());
    }

    public final void showMsgPanel(int x16, int y16, MsgInfo msg2, int appId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.getSys()) {
            return;
        }
        showPanel(new ShowMsgPanelParams(x16, y16, msg2, msg2.getUser(), appId, true, !Square.INSTANCE.getConfig().getCommonUtils().getStudyMode(), this.owner.isFriend(msg2.getUser().getUin())));
    }

    public final void showUnreadNumBtn(int num) {
        if (this.autoScroll) {
            return;
        }
        TextView textView = this.binding.unreadNumBtn;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.unreadNumBtn");
        textView.setText(num + "\u6761\u65b0\u6d88\u606f");
        updateUnreadNumBtnPosition();
        TextView textView2 = this.binding.unreadNumBtn;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.unreadNumBtn");
        ViewExtensionsKt.setVisibility(textView2, true);
    }

    public final void showUserPanel(int x16, int y16, MsgInfo msg2, UserInfo user, int appId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(user, "user");
        showPanel(new ShowMsgPanelParams(x16, y16, msg2, user, appId, false, !Square.INSTANCE.getConfig().getCommonUtils().getStudyMode(), this.owner.isFriend(user.getUin())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTopOffsetPx() {
        int[] iArr = new int[2];
        this.binding.offsetLocator.getLocationOnScreen(iArr);
        return iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePAGAnimationEnd() {
        Object first;
        this.isBroadcastPlaying = false;
        if (!this.broadcastPAGTasks.isEmpty()) {
            CollectionsKt__MutableCollectionsKt.removeFirst(this.broadcastPAGTasks);
        }
        if (!this.broadcastPAGTasks.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.broadcastPAGTasks);
            playPAGWithTask((BroadcastTask) first);
        } else {
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.publicchat.view.MessageListView$handlePAGAnimationEnd$1
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
                    ISquarePagView iSquarePagView;
                    ISquarePagView iSquarePagView2;
                    VasSquarePublicChatListBinding vasSquarePublicChatListBinding;
                    iSquarePagView = MessageListView.this.squarePagView;
                    if (iSquarePagView != null) {
                        iSquarePagView.stop();
                    }
                    iSquarePagView2 = MessageListView.this.squarePagView;
                    if (iSquarePagView2 != null) {
                        vasSquarePublicChatListBinding = MessageListView.this.binding;
                        vasSquarePublicChatListBinding.foldBtn.removeView(iSquarePagView2.getView());
                    }
                    MessageListView.this.squarePagView = null;
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event != null && event.getAction() == 0) {
            hideMsgPanel();
            SoftKeyboardStateWatcher softKeyboardStateWatcher = this.softKeyboardStateWatcher;
            if (softKeyboardStateWatcher != null && softKeyboardStateWatcher.getIsSoftKeyboardOpened()) {
                hideMsgInputBox();
                return true;
            }
        }
        return super.onTouchEvent(event);
    }

    public static /* synthetic */ void enableAutoScroll$default(MessageListView messageListView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        messageListView.enableAutoScroll(z16);
    }

    @Override // com.tencent.state.utils.ISoftKeyboardStateListener
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
    }
}
