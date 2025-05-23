package com.tencent.mobileqq.qqlive.widget.chat.giftmsg;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.qqlive.widget.chat.event.FontSizeChangeEvent;
import com.tencent.mobileqq.qqlive.widget.chat.giftmsg.a;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatMsgWarpView;
import com.tencent.mobileqq.qqlive.widget.chat.recyclerview.ChatRecyclerView;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import tl.h;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$AtUserMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import vi2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001NB#\b\u0007\u0012\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001\u0012\f\b\u0002\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001c\u0010\u0019\u001a\u00020\u0007*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0016J\u0012\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J(\u00100\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0010H\u0014J\u0018\u00103\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u0010H\u0014J\u0012\u00106\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u000104H\u0014J\u001a\u0010:\u001a\u00020\u00072\u0006\u00108\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u001aH\u0016J \u0010=\u001a\u00020\u00072\u0006\u00108\u001a\u0002072\u0006\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010>\u001a\u00020\u00072\u0006\u00108\u001a\u000207H\u0016J\b\u0010?\u001a\u00020\u0007H\u0014J\b\u0010-\u001a\u00020\u0007H\u0016J\u0010\u0010A\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020@H\u0016J\u0012\u0010D\u001a\u00020\u00072\b\u0010C\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J(\u0010G\u001a\u00020\u00072\u0006\u00108\u001a\u0002072\u0006\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0005H\u0016J\u0010\u0010H\u001a\u00020\u00072\u0006\u00108\u001a\u000207H\u0016J\u0010\u0010J\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0005H\u0016J\u0010\u0010K\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010L\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010N\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0005H\u0016J\b\u0010O\u001a\u00020\u0007H\u0016J\u0012\u0010R\u001a\u00020\u00072\b\u0010Q\u001a\u0004\u0018\u00010PH\u0016J$\u0010V\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040T0Sj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040T`UH\u0016R\u0016\u0010X\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010WR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00130Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010ZR\u0016\u0010\\\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010\u000fR\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u000fR\u0016\u0010^\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010]R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010<\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0016\u0010;\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010`R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00130a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010\u000fR\u0016\u0010o\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010]R\u0018\u0010q\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010pR\u0016\u0010t\u001a\u00020r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010sR\u0016\u0010w\u001a\u00020u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010vR\"\u0010~\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010kR\u001a\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010\u000fR\u001a\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/GiftMessageLayout;", "Landroid/widget/FrameLayout;", "Lvi2/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/qqlive/widget/chat/event/FontSizeChangeEvent;", "", "D", "", BdhLogUtil.LogTag.Tag_Conn, "K", "u", "up", "Landroid/view/View$OnClickListener;", "listener", "L", "I", "", "y", "t", "", "msg", "B", "Landroidx/recyclerview/widget/RecyclerView;", com.tencent.luggage.wxa.c8.c.G, "useScrollTo", "v", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, NodeProps.MAX_HEIGHT, "setMaxHeight", "Landroid/graphics/Typeface;", TextComponent.SpanStyle.TYPEFACE, "setTypeface", "Lcom/tencent/mobileqq/qqlive/widget/chat/recyclerview/ChatRecyclerView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "notifyDataSetChanged", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "setSupportFunc", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "widthSpec", "heightSpec", "onMeasure", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "roomId", QCircleAlphaUserReporter.KEY_PLATFORM, "i", "ownerId", "roomType", "b", "onExitRoom", NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout$e;", "setAnchorMessageItemClickListener", "Landroid/view/ViewGroup;", "view", "setTouchViewGroup", "g", "isSingleLineModel", "e", "f", "show", "a", "d", ReportConstant.COSTREPORT_PREFIX, LightConstants.DowngradeStrategyKey.SMOOTH, "c", "a0", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Z", "mIsLandscape", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "mCacheMsgInLanScape", "sizeHeight", "Ljava/lang/String;", "chatId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "", "E", "Ljava/util/List;", "datas", "Landroidx/recyclerview/widget/LinearLayoutManager;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "newMsgView", "H", "newMsgCount", "showAtMsgId", "Landroid/view/ViewGroup;", "touchViewGroup", "Landroid/view/View;", "Landroid/view/View;", "realMsgView", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "smoothScroller", "M", "Lcom/tencent/mobileqq/qqlive/widget/chat/recyclerview/ChatRecyclerView;", "getMsgRecyclerView", "()Lcom/tencent/mobileqq/qqlive/widget/chat/recyclerview/ChatRecyclerView;", "setMsgRecyclerView", "(Lcom/tencent/mobileqq/qqlive/widget/chat/recyclerview/ChatRecyclerView;)V", "msgRecyclerView", "N", "msgEmptyView", "Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/a;", "P", "Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/a;", "adapter", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "lastVisibleItemPos", BdhLogUtil.LogTag.Tag_Req, "Lvi2/a;", ExifInterface.LATITUDE_SOUTH, "Lvi2/c;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "T", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GiftMessageLayout extends FrameLayout implements vi2.b, SimpleEventReceiver<FontSizeChangeEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int roomType;

    /* renamed from: D, reason: from kotlin metadata */
    private long ownerId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<Object> datas;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView newMsgView;

    /* renamed from: H, reason: from kotlin metadata */
    private int newMsgCount;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String showAtMsgId;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ViewGroup touchViewGroup;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private View realMsgView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private LinearSmoothScroller smoothScroller;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private ChatRecyclerView msgRecyclerView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView msgEmptyView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.qqlive.widget.chat.giftmsg.a adapter;

    /* renamed from: Q, reason: from kotlin metadata */
    private int lastVisibleItemPos;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private vi2.a dataSupport;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private vi2.c playFunc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLandscape;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<Object> mCacheMsgInLanScape;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int sizeHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int maxHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String chatId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/giftmsg/GiftMessageLayout$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftMessageLayout.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            vi2.c cVar = GiftMessageLayout.this.playFunc;
            if (cVar != null) {
                if (newState != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                cVar.k(z16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/giftmsg/GiftMessageLayout$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int b16 = wi2.c.b(2);
            int b17 = wi2.c.b(2);
            if (view instanceof ChatMsgWarpView) {
                ((ChatMsgWarpView) view).setMargin(wi2.c.b(12), b16, wi2.c.b(12), b17);
                return;
            }
            if (view.getLayoutParams() instanceof RecyclerView.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = wi2.c.b(12);
                ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = wi2.c.b(12);
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = b16;
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = b17;
                view.setLayoutParams(layoutParams2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/GiftMessageLayout$c;", "", "", "DEFAULT_MIN_HEIGHT_DP", UserInfo.SEX_FEMALE, "", "DEFAULT_SHADOW_BLOCK_HEIGHT", "I", "DEFAULT_TOP_SHADOW_HEIGHT", "MAX_LOCAL_MSG", "REDUCING_SIZE", "SINGLE_ITEM_HEIGHT_DP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.giftmsg.GiftMessageLayout$c, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/giftmsg/GiftMessageLayout$d", "Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/a$b;", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements a.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftMessageLayout.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.widget.chat.giftmsg.a.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                GiftMessageLayout.this.u();
                GiftMessageLayout.this.t();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftMessageLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 37)) {
            return;
        }
        iPatchRedirector.redirect((short) 37, (Object) this, (Object) context);
    }

    private final boolean B(Object msg2) {
        boolean z16;
        MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent2;
        MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg2;
        PBRepeatMessageField<MessageOuterClass$AtUser> pBRepeatMessageField;
        boolean z17 = false;
        if (!(msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.e)) {
            return false;
        }
        com.tencent.mobileqq.qqlive.widget.chat.message.e eVar = (com.tencent.mobileqq.qqlive.widget.chat.message.e) msg2;
        MessageOuterClass$TimMsgBody a16 = eVar.a();
        if (a16 != null && (messageOuterClass$MsgContent2 = a16.content) != null && (messageOuterClass$AtUserMsg2 = messageOuterClass$MsgContent2.at_user_msg) != null && (pBRepeatMessageField = messageOuterClass$AtUserMsg2.user_list) != null && pBRepeatMessageField.size() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && TextUtils.isEmpty(this.showAtMsgId)) {
            vi2.a aVar = this.dataSupport;
            if (aVar != null) {
                MessageOuterClass$TimMsgBody a17 = eVar.a();
                if (a17 != null && (messageOuterClass$MsgContent = a17.content) != null) {
                    messageOuterClass$AtUserMsg = messageOuterClass$MsgContent.at_user_msg;
                } else {
                    messageOuterClass$AtUserMsg = null;
                }
                if (aVar.N(messageOuterClass$AtUserMsg)) {
                    z17 = true;
                }
            }
            if (z17) {
                this.showAtMsgId = eVar.id();
                return true;
            }
        }
        return !TextUtils.isEmpty(this.showAtMsgId);
    }

    private final void C() {
        this.mCacheMsgInLanScape.clear();
        if (this.datas.size() > 1000) {
            List<Object> list = this.datas;
            this.mCacheMsgInLanScape.addAll(new ArrayList(list.subList(list.size() - 1000, this.datas.size())));
            return;
        }
        this.mCacheMsgInLanScape.addAll(this.datas);
    }

    private final boolean D() {
        int findLastVisibleItemPosition = this.linearLayoutManager.findLastVisibleItemPosition();
        boolean z16 = false;
        if (findLastVisibleItemPosition >= 0 && findLastVisibleItemPosition < this.lastVisibleItemPos) {
            z16 = true;
        }
        this.lastVisibleItemPos = findLastVisibleItemPosition;
        return !z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E(GiftMessageLayout this$0, View view, MotionEvent motionEvent) {
        vi2.c cVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null && 1 == motionEvent.getAction() && (cVar = this$0.playFunc) != null) {
            cVar.i(motionEvent);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(GiftMessageLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c(false);
        this$0.newMsgCount = 0;
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(GiftMessageLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.a.a(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(GiftMessageLayout this$0, long j3) {
        List<Object> d16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vi2.a aVar = this$0.dataSupport;
        if (aVar != null && (d16 = aVar.d(j3)) != null) {
            this$0.datas.addAll(d16);
            RecyclerView.Adapter adapter = this$0.msgRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        b.a.a(this$0, false, 1, null);
    }

    private final void I() {
        final int y16 = y();
        AegisLogger.INSTANCE.d(z(), "showAtMsgShortCut: " + y16);
        L(false, new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.widget.chat.giftmsg.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GiftMessageLayout.J(GiftMessageLayout.this, y16, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(GiftMessageLayout this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(this$0.msgRecyclerView, Math.max(0, this$0.datas.size() - i3), true);
        this$0.t();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void K() {
        AegisLogger.INSTANCE.i(z(), "showCachedLandScapeMsg size=" + this.mCacheMsgInLanScape.size());
        this.datas.clear();
        this.datas.addAll(this.mCacheMsgInLanScape);
        RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        b.a.a(this, false, 1, null);
        this.mCacheMsgInLanScape.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        this.showAtMsgId = "";
        this.newMsgCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        TextView textView = this.newMsgView;
        if (textView != null) {
            wi2.d.e(textView, false);
        }
        this.newMsgCount = 0;
    }

    private final void v(final RecyclerView recyclerView, final int i3, final boolean z16) {
        if (i3 < this.datas.size() && i3 >= 0) {
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.chat.giftmsg.g
                @Override // java.lang.Runnable
                public final void run() {
                    GiftMessageLayout.w(RecyclerView.this, z16, i3, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(RecyclerView this_completeScrollToPos, boolean z16, int i3, GiftMessageLayout this$0) {
        Intrinsics.checkNotNullParameter(this_completeScrollToPos, "$this_completeScrollToPos");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_completeScrollToPos.stopScroll();
        if (z16) {
            this_completeScrollToPos.scrollToPosition(i3);
        } else {
            RecyclerView.LayoutManager layoutManager = this_completeScrollToPos.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i3, 0);
        }
        this$0.t();
    }

    private final int y() {
        int size;
        if (!TextUtils.isEmpty(this.showAtMsgId)) {
            int i3 = 0;
            for (Object obj : this.datas) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if ((obj instanceof com.tencent.mobileqq.qqlive.widget.chat.message.e) && Intrinsics.areEqual(this.showAtMsgId, ((com.tencent.mobileqq.qqlive.widget.chat.message.e) obj).id()) && (size = this.datas.size() - i3) >= 0) {
                    return size;
                }
                i3 = i16;
            }
        }
        return 0;
    }

    @Override // vi2.b
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public ChatRecyclerView x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ChatRecyclerView) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.msgRecyclerView;
    }

    @Override // vi2.b
    public void a(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, show);
        } else if (show) {
            this.realMsgView.setVisibility(0);
        } else {
            this.realMsgView.setVisibility(8);
        }
    }

    @Override // vi2.b
    public void a0() {
        boolean z16;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        if (this.datas.size() == 0) {
            TextView textView2 = this.msgEmptyView;
            if (textView2 != null && textView2.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && (textView = this.msgEmptyView) != null) {
                textView.setVisibility(0);
            }
        }
    }

    @Override // vi2.b
    public void b(long roomId, long ownerId, int roomType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(roomId), Long.valueOf(ownerId), Integer.valueOf(roomType));
            return;
        }
        AegisLogger.INSTANCE.i(z(), "onEnterRoom roomId[" + roomId + ']');
        vi2.a aVar = this.dataSupport;
        if (aVar != null) {
            aVar.unregister();
        }
        this.roomType = roomType;
        this.roomId = roomId;
        this.chatId = String.valueOf(roomId);
        if (this.ownerId == ownerId) {
            vi2.a aVar2 = this.dataSupport;
            if (aVar2 != null) {
                aVar2.register();
                return;
            }
            return;
        }
        this.ownerId = ownerId;
        vi2.a aVar3 = this.dataSupport;
        if (aVar3 != null) {
            aVar3.register();
        }
        this.adapter.k0(roomId, ownerId, this.datas, this.dataSupport, this.playFunc);
        this.adapter.i0(new d());
        this.msgRecyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.chat.giftmsg.d
            @Override // java.lang.Runnable
            public final void run() {
                GiftMessageLayout.G(GiftMessageLayout.this);
            }
        });
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // vi2.b
    public void c(boolean smooth) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, smooth);
            return;
        }
        RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
        if (adapter != null) {
            i3 = adapter.getItemCount();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return;
        }
        this.msgRecyclerView.stopScroll();
        if (smooth) {
            this.smoothScroller.setTargetPosition(i3 - 1);
            RecyclerView.LayoutManager layoutManager = this.msgRecyclerView.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.startSmoothScroll(this.smoothScroller);
            }
        } else {
            this.linearLayoutManager.scrollToPositionWithOffset(i3 - 1, 0);
        }
        u();
        t();
    }

    @Override // vi2.b
    public void d(@NotNull Object msg2) {
        String valueOf;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (D()) {
            TextView textView = this.newMsgView;
            if (textView != null && textView.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                s(msg2);
                b.a.a(this, false, 1, null);
                return;
            }
        }
        this.newMsgCount++;
        TextView textView2 = this.newMsgView;
        if (textView2 != null) {
            wi2.d.e(textView2, true);
        }
        s(msg2);
        TextView textView3 = this.newMsgView;
        if (textView3 != null) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = this.newMsgCount;
            if (i3 > 99) {
                valueOf = "99+";
            } else {
                valueOf = String.valueOf(i3);
            }
            sb5.append(valueOf);
            sb5.append("\u6761\u65b0\u6d88\u606f");
            textView3.setText(sb5.toString());
        }
        if (B(msg2)) {
            AegisLogger.INSTANCE.d(z(), "hasAtMeMessage: " + this.showAtMsgId);
            I();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if (r5.getPointerCount() == 1) goto L16;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) ev5)).booleanValue();
        }
        ViewGroup viewGroup = this.touchViewGroup;
        if (viewGroup != null) {
            if (ev5 != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                ev5.getPointerId(0);
                viewGroup.dispatchTouchEvent(ev5);
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // vi2.b
    public void e(long roomId, long ownerId, int roomType, boolean isSingleLineModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Long.valueOf(roomId), Long.valueOf(ownerId), Integer.valueOf(roomType), Boolean.valueOf(isSingleLineModel));
        }
    }

    @Override // vi2.b
    public void f(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, roomId);
        }
    }

    @Override // vi2.b
    public void g(@NotNull Object msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<FontSizeChangeEvent>> getEventClass() {
        ArrayList<Class<FontSizeChangeEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FontSizeChangeEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 36, (Object) this);
    }

    @Override // vi2.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        vi2.a aVar = this.dataSupport;
        if (aVar != null) {
            aVar.n(this.datas);
        }
    }

    @Override // vi2.b
    public void i(final long roomId, @Nullable String platfrom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Long.valueOf(roomId), platfrom);
            return;
        }
        AegisLogger.INSTANCE.i(z(), "onPreLoadRoom roomId[" + roomId + "] ownerId[" + this.ownerId + ']');
        this.roomId = roomId;
        this.chatId = String.valueOf(roomId);
        this.msgRecyclerView.setRoomId(roomId);
        this.adapter.k0(roomId, this.ownerId, this.datas, this.dataSupport, this.playFunc);
        ViewGroup.LayoutParams layoutParams = this.msgRecyclerView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = wi2.b.b(this);
            this.msgRecyclerView.setLayoutParams(layoutParams);
            this.msgRecyclerView.setHasFixedSize(false);
        }
        this.datas.clear();
        RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        this.msgRecyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.chat.giftmsg.e
            @Override // java.lang.Runnable
            public final void run() {
                GiftMessageLayout.H(GiftMessageLayout.this, roomId);
            }
        });
    }

    @Override // vi2.b
    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) newConfig);
            return;
        }
        super.onConfigurationChanged(newConfig);
        Intrinsics.checkNotNull(newConfig);
        if (newConfig.orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        AegisLogger.INSTANCE.i(z(), "onConfigurationChanged -> orientation: isLandscape:" + z16 + ",oldIsLandscape:" + this.mIsLandscape);
        boolean z17 = this.mIsLandscape;
        if (z17 == z16) {
            return;
        }
        if (z17 && !z16) {
            K();
            this.mIsLandscape = z16;
        } else if (!z17 && z16) {
            C();
            this.mIsLandscape = z16;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        AegisLogger.INSTANCE.i(z(), NodeProps.ON_DETACHED_FROM_WINDOW);
        h();
        vi2.a aVar = this.dataSupport;
        if (aVar != null) {
            aVar.unregister();
        }
    }

    @Override // vi2.b
    public void onExitRoom(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, roomId);
            return;
        }
        AegisLogger.INSTANCE.i(z(), "onExitRoom");
        if (roomId == this.roomId) {
            vi2.a aVar = this.dataSupport;
            if (aVar != null) {
                aVar.unregister();
            }
            this.datas.clear();
            RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            this.roomId = 0L;
            this.ownerId = 0L;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthSpec, int heightSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(widthSpec), Integer.valueOf(heightSpec));
            return;
        }
        int i3 = this.maxHeight;
        if (i3 > 0) {
            super.onMeasure(widthSpec, View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE));
        } else {
            super.onMeasure(widthSpec, heightSpec);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        FontSizeChangeEvent fontSizeChangeEvent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) event);
            return;
        }
        boolean z16 = event instanceof FontSizeChangeEvent;
        if (z16) {
            if (z16) {
                fontSizeChangeEvent = (FontSizeChangeEvent) event;
            } else {
                fontSizeChangeEvent = null;
            }
            if (fontSizeChangeEvent != null) {
                this.adapter.q0(fontSizeChangeEvent.getFontSize());
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
            return;
        }
        super.onSizeChanged(w3, h16, oldw, oldh);
        AegisLogger.INSTANCE.i(z(), "w = [" + w3 + "], h = [" + h16 + "], oldw = [" + oldw + "], oldh = [" + oldh + ']');
    }

    public void s(@NotNull Object msg2) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (this.mIsLandscape) {
            this.mCacheMsgInLanScape.add(msg2);
            int size = this.mCacheMsgInLanScape.size();
            if (size > 1000) {
                AegisLogger.INSTANCE.i(z(), "reduce 500 msg items");
                LinkedList linkedList = new LinkedList(this.mCacheMsgInLanScape.subList(500, size));
                this.mCacheMsgInLanScape.clear();
                this.mCacheMsgInLanScape.addAll(linkedList);
                return;
            }
            return;
        }
        this.datas.add(msg2);
        int size2 = this.datas.size();
        boolean z16 = false;
        if (size2 > 1000) {
            AegisLogger.INSTANCE.i(z(), "reduce 500 msg items");
            ArrayList arrayList = new ArrayList(this.datas.subList(500, size2));
            this.datas.clear();
            this.datas.addAll(arrayList);
            RecyclerView.Adapter adapter = this.msgRecyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemRangeRemoved(0, 500);
            }
        }
        RecyclerView.Adapter adapter2 = this.msgRecyclerView.getAdapter();
        if (adapter2 != null) {
            adapter2.notifyItemInserted(this.datas.size() - 1);
        }
        TextView textView2 = this.msgEmptyView;
        if (textView2 != null && textView2.getVisibility() == 0) {
            z16 = true;
        }
        if (z16 && (textView = this.msgEmptyView) != null) {
            textView.setVisibility(8);
        }
    }

    public void setAnchorMessageItemClickListener(@NotNull ChatMessageLayout.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }
    }

    public final void setMaxHeight(int maxHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, maxHeight);
            return;
        }
        AegisLogger.INSTANCE.i(z(), "setMaxHeight:" + maxHeight);
        this.maxHeight = maxHeight;
        postInvalidate();
        notifyDataSetChanged();
    }

    public final void setMsgRecyclerView(@NotNull ChatRecyclerView chatRecyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) chatRecyclerView);
        } else {
            Intrinsics.checkNotNullParameter(chatRecyclerView, "<set-?>");
            this.msgRecyclerView = chatRecyclerView;
        }
    }

    @Override // vi2.b
    public void setSupportFunc(@NotNull vi2.a dataSupport, @NotNull vi2.c playFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) dataSupport, (Object) playFunc);
            return;
        }
        Intrinsics.checkNotNullParameter(dataSupport, "dataSupport");
        Intrinsics.checkNotNullParameter(playFunc, "playFunc");
        this.dataSupport = dataSupport;
        this.playFunc = playFunc;
    }

    public void setTouchViewGroup(@Nullable ViewGroup view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view);
        } else {
            this.touchViewGroup = view;
        }
    }

    public final void setTypeface(@NotNull Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) typeface);
        } else {
            Intrinsics.checkNotNullParameter(typeface, "typeface");
            this.adapter.r0(typeface);
        }
    }

    @NotNull
    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "Chat_Message|GiftMessageLayout";
    }

    public /* synthetic */ GiftMessageLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mCacheMsgInLanScape = new LinkedList<>();
        int dip2px = DisplayUtil.dip2px(context, 50.0f);
        this.sizeHeight = dip2px;
        this.maxHeight = dip2px;
        this.chatId = "999L";
        this.datas = new ArrayList();
        this.showAtMsgId = "";
        this.smoothScroller = com.tencent.mobileqq.qqlive.widget.chat.ex.a.a(context);
        this.adapter = new com.tencent.mobileqq.qqlive.widget.chat.giftmsg.a(context);
        LayoutInflater.from(context).inflate(R.layout.ed5, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f70633lz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.real_msg_view)");
        this.realMsgView = findViewById;
        View findViewById2 = findViewById(R.id.vpi);
        ChatRecyclerView chatRecyclerView = (ChatRecyclerView) findViewById2;
        chatRecyclerView.setRoomId(this.roomId);
        chatRecyclerView.setEnabled(true);
        chatRecyclerView.setOverScrollMode(2);
        chatRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qqlive.widget.chat.giftmsg.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean E;
                E = GiftMessageLayout.E(GiftMessageLayout.this, view, motionEvent);
                return E;
            }
        });
        chatRecyclerView.addOnScrollListener(new a());
        chatRecyclerView.setRecycledViewPool(new com.tencent.mobileqq.qqlive.widget.chat.util.c());
        chatRecyclerView.setPadding(0, wi2.c.b(2), 0, wi2.c.b(2));
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ChatRecycle\u2026 2.dp, 0, 2.dp)\n        }");
        this.msgRecyclerView = chatRecyclerView;
        TextView _init_$lambda$4 = (TextView) findViewById(R.id.vqd);
        Intrinsics.checkNotNullExpressionValue(_init_$lambda$4, "_init_$lambda$4");
        wi2.b.d(_init_$lambda$4, 12.0f);
        _init_$lambda$4.setPadding(wi2.c.b(12), 0, wi2.c.b(12), 0);
        _init_$lambda$4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.widget.chat.giftmsg.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GiftMessageLayout.F(GiftMessageLayout.this, view);
            }
        });
        _init_$lambda$4.setTextColor(Color.parseColor("#6666FF"));
        _init_$lambda$4.setGravity(17);
        _init_$lambda$4.setVisibility(8);
        wi2.d.d(_init_$lambda$4, wi2.c.b(18), com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.f158017al3));
        this.newMsgView = _init_$lambda$4;
        this.msgEmptyView = (TextView) findViewById(R.id.vpb);
        setOverScrollMode(2);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(context);
        this.linearLayoutManager = safeLinearLayoutManager;
        safeLinearLayoutManager.setStackFromEnd(true);
        this.linearLayoutManager.setOrientation(1);
        this.msgRecyclerView.setLayoutManager(this.linearLayoutManager);
        this.msgRecyclerView.setItemViewCacheSize(20);
        RecyclerView.ItemAnimator itemAnimator = this.msgRecyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(0L);
            itemAnimator.setRemoveDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
        }
        this.msgRecyclerView.addItemDecoration(new b());
        this.msgRecyclerView.setAdapter(this.adapter);
    }

    private final void L(boolean up5, View.OnClickListener listener) {
    }
}
