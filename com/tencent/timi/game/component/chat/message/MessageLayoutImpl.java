package com.tencent.timi.game.component.chat.message;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.chat.at.SpecialMsgUtil;
import com.tencent.timi.game.component.chat.event.GreetingNewUserEvent;
import com.tencent.timi.game.component.chat.message.MessageLayout;
import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.SmobaDataOuterClass$GameCampSettleInfo;
import trpc.yes.common.SmobaDataOuterClass$PlayerSettleInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001MB'\b\u0007\u0012\u0006\u0010z\u001a\u00020y\u0012\n\b\u0002\u0010|\u001a\u0004\u0018\u00010{\u0012\b\b\u0002\u0010}\u001a\u00020\u0014\u00a2\u0006\u0004\b~\u0010\u007fJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u001c\u001a\u00020\u0005*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u001dJ\b\u0010\u001f\u001a\u00020\u0005H\u0014J\b\u0010 \u001a\u00020\u0005H\u0014J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0016J\u0012\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0016J\u0012\u00101\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u000202H\u0016J\u0016\u00107\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000705H\u0016J\u0010\u00108\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010;\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010<\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010=\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010?\u001a\u00020\u0005H\u0016J\b\u0010@\u001a\u00020\u000eH\u0016J\n\u0010A\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0007H\u0016J\b\u0010D\u001a\u00020\u0014H\u0016J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020EH\u0016J\u0010\u0010G\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020EH\u0016J\u0012\u0010I\u001a\u00020\u00052\b\u0010H\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040K0JH\u0016R\u0014\u0010O\u001a\u0002098\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010-\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00070S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010aR\u0016\u0010d\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010cR\u0018\u0010g\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010fR\u0016\u0010i\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010\u0018R\u0018\u0010k\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010jR\u0018\u0010l\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010jR\u0014\u0010o\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010nR\u0018\u0010r\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010NR\u0016\u0010v\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010\u0006R\u0018\u0010x\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010w\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/MessageLayoutImpl;", "Lcom/tencent/timi/game/component/chat/message/MessageLayout;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Z", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "U", "Landroid/text/SpannableStringBuilder;", "u", "", "up", "Landroid/view/View$OnClickListener;", "listener", "Y", ExifInterface.LATITUDE_SOUTH, "", UserInfo.SEX_FEMALE, "E", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "I", "Landroidx/recyclerview/widget/RecyclerView;", com.tencent.luggage.wxa.c8.c.G, "useScrollTo", "B", "Lcom/tencent/timi/game/component/chat/message/n;", "setMessageListener", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$d;", "onScrollMsgListener", "setOnScrollMsgListener", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$b;", "viewProvider", "setViewProvider", "", "chatId", "setChatId", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "setRoomInfo", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "setQQUserId", "", "msgs", "v", "y", "", "msgId", "O", "b0", "D", "P", BdhLogUtil.LogTag.Tag_Req, "K", "G", "localMsg", "J", "H", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$c;", "setLayoutClickListener", "setLayoutClickUpListener", "p0", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "d", "Ljava/lang/String;", "TAG", "e", "f", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "", tl.h.F, "Ljava/util/List;", "datas", "Landroidx/recyclerview/widget/LinearLayoutManager;", "i", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/timi/game/component/chat/message/MessageLayout$d;", "scrollMsgListener", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/timi/game/component/chat/message/MessageLayout$b;", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", "iImConfig", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "newMsgView", "newAtMsgView", "newMsgCount", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$c;", "layoutClickListener", "layoutClickUpListener", "Lcom/tencent/timi/game/component/chat/message/ad;", "Lcom/tencent/timi/game/component/chat/message/ad;", "messageViewProvider", "L", "Lcom/tencent/timi/game/component/chat/message/n;", "messageListener", "M", "showAtMsgId", "N", "isAttachingWindow", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "selfUserId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class MessageLayoutImpl extends MessageLayout implements LifecycleEventObserver, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private MessageLayout.b viewProvider;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MessageLayout.a iImConfig;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private RecyclerView recyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView newMsgView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView newAtMsgView;

    /* renamed from: H, reason: from kotlin metadata */
    private int newMsgCount;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private MessageLayout.c layoutClickListener;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private MessageLayout.c layoutClickUpListener;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ad messageViewProvider;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private n messageListener;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String showAtMsgId;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isAttachingWindow;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId selfUserId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String chatId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private YoloRoomOuterClass$YoloRoomInfo roomInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.timi.game.tim.api.message.a> datas;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessageLayout.d scrollMsgListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/component/chat/message/MessageLayoutImpl$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = fh4.b.b(10);
            }
            outRect.bottom = fh4.b.b(20);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/component/chat/message/MessageLayoutImpl$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            com.tencent.timi.game.utils.l.i(MessageLayoutImpl.this.TAG, "onScrollStateChanged newState:" + newState);
            if (newState == 0) {
                AbstractGifImage.resumeAll();
            } else {
                AbstractGifImage.pauseAll();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\r\u001a\u00020\nH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/timi/game/component/chat/message/MessageLayoutImpl$c", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/component/chat/message/MessageLayoutImpl$d;", "Lcom/tencent/timi/game/component/chat/message/MessageLayoutImpl;", "Landroid/view/View;", "view", "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "position", "getItemViewType", "getItemCount", "holder", "k0", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends RecyclerView.Adapter<d> {
        c() {
        }

        private final void j0(View view) {
            view.setTranslationY(view.getHeight());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY(), 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(view, \"translati\u2026\", view.translationY, 0f)");
            ofFloat.setInterpolator(new ss.b(0.165f, 0.84f, 0.44f, 1.0f));
            ofFloat.setDuration(200L).start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(view, \"alpha\", 0f, 1f)");
            ofFloat2.setInterpolator(new ss.b(0.165f, 0.84f, 0.44f, 1.0f));
            ofFloat2.setDuration(200L).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l0(d holder, c this$0) {
            Intrinsics.checkNotNullParameter(holder, "$holder");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            holder.itemView.setVisibility(0);
            holder.itemView.clearAnimation();
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            this$0.j0(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return MessageLayoutImpl.this.datas.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return MessageLayoutImpl.this.messageViewProvider.b((com.tencent.timi.game.tim.api.message.a) MessageLayoutImpl.this.datas.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull final d holder, int position) {
            com.tencent.timi.game.tim.api.message.a aVar;
            YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
            PBUInt64Field pBUInt64Field;
            TextMessageItemView textMessageItemView;
            Intrinsics.checkNotNullParameter(holder, "holder");
            View view = holder.itemView;
            if (view instanceof BaseMessageView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.timi.game.component.chat.message.BaseMessageView");
                ((BaseMessageView) view).setImConfig(MessageLayoutImpl.this.iImConfig);
                View view2 = holder.itemView;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.timi.game.component.chat.message.BaseMessageView");
                ((BaseMessageView) view2).setYoloRoomInfo(MessageLayoutImpl.this.roomInfo);
                View view3 = holder.itemView;
                Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type com.tencent.timi.game.component.chat.message.BaseMessageView");
                ((BaseMessageView) view3).setMessageListener(MessageLayoutImpl.this.messageListener);
            } else if (view instanceof CenterMessageView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.timi.game.component.chat.message.CenterMessageView");
                ((CenterMessageView) view).setYoloRoomInfo(MessageLayoutImpl.this.roomInfo);
                View view4 = holder.itemView;
                Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.timi.game.component.chat.message.CenterMessageView");
                ((CenterMessageView) view4).setThemeConfig(MessageLayoutImpl.this.iImConfig);
                View view5 = holder.itemView;
                Intrinsics.checkNotNull(view5, "null cannot be cast to non-null type com.tencent.timi.game.component.chat.message.CenterMessageView");
                ((CenterMessageView) view5).setMessageListener(MessageLayoutImpl.this.messageListener);
            }
            com.tencent.timi.game.tim.api.message.a aVar2 = (com.tencent.timi.game.tim.api.message.a) MessageLayoutImpl.this.datas.get(position);
            if (aVar2.type() == pn4.e.d() && MessageLayoutImpl.this.roomInfo != null && (yoloRoomOuterClass$YoloRoomInfo = MessageLayoutImpl.this.roomInfo) != null && (pBUInt64Field = yoloRoomOuterClass$YoloRoomInfo.room_id) != null) {
                long j3 = pBUInt64Field.get();
                View view6 = holder.itemView;
                if (view6 instanceof TextMessageItemView) {
                    textMessageItemView = (TextMessageItemView) view6;
                } else {
                    textMessageItemView = null;
                }
                if (textMessageItemView != null) {
                    textMessageItemView.setRoomId(j3);
                }
            }
            View view7 = holder.itemView;
            if (view7 instanceof CenterMessageView) {
                Intrinsics.checkNotNull(view7, "null cannot be cast to non-null type com.tencent.timi.game.component.chat.message.CenterMessageView");
                ((CenterMessageView) view7).setPosition(position);
            }
            KeyEvent.Callback callback = holder.itemView;
            Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.timi.game.component.chat.message.IMessageView");
            o oVar = (o) callback;
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = MessageLayoutImpl.this.selfUserId;
            if (position > 0) {
                aVar = (com.tencent.timi.game.tim.api.message.a) MessageLayoutImpl.this.datas.get(position - 1);
            } else {
                aVar = null;
            }
            oVar.a(commonOuterClass$QQUserId, aVar2, aVar);
            if (position == MessageLayoutImpl.this.datas.size() - 1) {
                MessageLayoutImpl.this.A();
                MessageLayoutImpl.this.z();
            }
            MessageLayout.d dVar = MessageLayoutImpl.this.scrollMsgListener;
            if (dVar != null) {
                dVar.a(aVar2, position);
            }
            if ((holder.itemView instanceof TextMessageItemView) && aVar2.type() == 1 && aVar2.getMemData() != null) {
                aVar2.e(null);
                holder.itemView.setVisibility(4);
                holder.itemView.postDelayed(new Runnable() { // from class: com.tencent.timi.game.component.chat.message.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        MessageLayoutImpl.c.l0(MessageLayoutImpl.d.this, this);
                    }
                }, 100L);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            MessageLayoutImpl messageLayoutImpl = MessageLayoutImpl.this;
            View a16 = messageLayoutImpl.messageViewProvider.a(parent, viewType);
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.timi.game.component.chat.message.TouchPositionGetableRelativeLayout");
            return new d(messageLayoutImpl, (TouchPositionGetableRelativeLayout) a16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/MessageLayoutImpl$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/timi/game/component/chat/message/MessageLayoutImpl;Landroid/view/View;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class d extends RecyclerView.ViewHolder {
        final /* synthetic */ MessageLayoutImpl E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull MessageLayoutImpl messageLayoutImpl, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = messageLayoutImpl;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageLayoutImpl(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        TextView textView = this.newMsgView;
        if (textView != null) {
            fh4.g.o(textView, false);
        }
        this.newMsgCount = 0;
    }

    private final void B(final RecyclerView recyclerView, final int i3, final boolean z16) {
        if (i3 < this.datas.size() && i3 >= 0) {
            recyclerView.post(new Runnable() { // from class: com.tencent.timi.game.component.chat.message.w
                @Override // java.lang.Runnable
                public final void run() {
                    MessageLayoutImpl.C(RecyclerView.this, z16, i3, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(RecyclerView this_completeScrollToPos, boolean z16, int i3, MessageLayoutImpl this$0) {
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
        this$0.z();
    }

    private final int E() {
        List reversed;
        reversed = CollectionsKt___CollectionsKt.reversed(this.datas);
        int i3 = 0;
        for (Object obj : reversed) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (com.tencent.timi.game.component.chat.at.b.INSTANCE.a().d(this.chatId, ((com.tencent.timi.game.tim.api.message.a) obj).id())) {
                return (this.datas.size() - i3) - 1;
            }
            i3 = i16;
        }
        return -1;
    }

    private final int F() {
        int size;
        if (!TextUtils.isEmpty(this.showAtMsgId)) {
            int i3 = 0;
            for (Object obj : this.datas) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(this.showAtMsgId, ((com.tencent.timi.game.tim.api.message.a) obj).id()) && (size = this.datas.size() - i3) >= 0) {
                    return size;
                }
                i3 = i16;
            }
        }
        return 0;
    }

    private final boolean I(com.tencent.timi.game.tim.api.message.a msg2) {
        if (msg2.a().at_user_msg.user_list.size() > 0 && TextUtils.isEmpty(this.showAtMsgId) && SpecialMsgUtil.f376345a.c(msg2, this.selfUserId)) {
            this.showAtMsgId = msg2.id();
            return true;
        }
        return !TextUtils.isEmpty(this.showAtMsgId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L(MessageLayoutImpl this$0, View view, MotionEvent motionEvent) {
        MessageLayout.c cVar;
        MessageLayout.c cVar2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if ((action == 0 || 3 == action) && (cVar = this$0.layoutClickListener) != null) {
                cVar.a();
            }
            if ((1 == action || 3 == action) && (cVar2 = this$0.layoutClickUpListener) != null) {
                cVar2.a();
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(MessageLayoutImpl this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R();
        this$0.newMsgCount = 0;
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(MessageLayoutImpl this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R();
        this$0.newMsgCount = 0;
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(MessageLayoutImpl this$0, SimpleBaseEvent simpleBaseEvent) {
        RecyclerView.Adapter adapter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<com.tencent.timi.game.tim.api.message.a> it = this$0.datas.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().id(), ((GreetingNewUserEvent) simpleBaseEvent).getMessageID())) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0 && (adapter = this$0.recyclerView.getAdapter()) != null) {
            adapter.notifyItemChanged(i3);
        }
    }

    private final void S() {
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setText(u());
        }
        final int F = F();
        com.tencent.timi.game.utils.l.b(this.TAG, "showAtMsgShortCut: " + F);
        Y(false, new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageLayoutImpl.T(MessageLayoutImpl.this, F, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(MessageLayoutImpl this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B(this$0.recyclerView, Math.max(0, this$0.datas.size() - i3), true);
        this$0.z();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void U() {
        Iterator<T> it = this.datas.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (com.tencent.timi.game.component.chat.at.b.INSTANCE.a().d(this.chatId, ((com.tencent.timi.game.tim.api.message.a) it.next()).id())) {
                z16 = true;
            }
        }
        com.tencent.timi.game.utils.l.b(this.TAG, "showAtMsgWhenFirstLoad: " + z16);
        if (z16) {
            com.tencent.timi.game.utils.w.d(new Runnable() { // from class: com.tencent.timi.game.component.chat.message.z
                @Override // java.lang.Runnable
                public final void run() {
                    MessageLayoutImpl.W(MessageLayoutImpl.this);
                }
            }, 700L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(final MessageLayoutImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAttachingWindow) {
            int E = this$0.E();
            com.tencent.timi.game.utils.l.b(this$0.TAG, "showAtMsgWhenFirstLoad: findPos=" + E);
            if (E >= 0) {
                TextView textView = this$0.newAtMsgView;
                if (textView != null) {
                    textView.setText(this$0.u());
                }
                this$0.Y(true, new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.aa
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MessageLayoutImpl.X(MessageLayoutImpl.this, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(MessageLayoutImpl this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int E = this$0.E();
        com.tencent.timi.game.utils.l.b(this$0.TAG, "showAtMsgWhenFirstLoad: next " + E);
        this$0.B(this$0.recyclerView, Math.max(0, E), true);
        this$0.z();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Y(boolean up5, View.OnClickListener listener) {
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.newAtMsgView;
        if (textView2 != null) {
            textView2.setOnClickListener(listener);
        }
    }

    private final void Z() {
        CollectionsKt__MutableCollectionsJVMKt.sortWith(this.datas, new Comparator() { // from class: com.tencent.timi.game.component.chat.message.y
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int a06;
                a06 = MessageLayoutImpl.a0((com.tencent.timi.game.tim.api.message.a) obj, (com.tencent.timi.game.tim.api.message.a) obj2);
                return a06;
            }
        });
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int a0(com.tencent.timi.game.tim.api.message.a aVar, com.tencent.timi.game.tim.api.message.a aVar2) {
        return Intrinsics.compare(aVar.time(), aVar2.time());
    }

    private final SpannableStringBuilder u() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("\u6709\u4eba@\u4f60");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(yn4.c.a(R.color.f157985cu1)), 2, 4, 33);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(MessageLayoutImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isAttachingWindow) {
            this$0.U();
        }
    }

    private final void x(com.tencent.timi.game.tim.api.message.a msg2) {
        this.datas.add(msg2);
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemInserted(this.datas.size() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        this.showAtMsgId = "";
        this.newMsgCount = 0;
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void D(@Nullable final String msgId) {
        CollectionsKt__MutableCollectionsKt.removeAll((List) this.datas, (Function1) new Function1<com.tencent.timi.game.tim.api.message.a, Boolean>() { // from class: com.tencent.timi.game.component.chat.message.MessageLayoutImpl$deleteMsg$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.timi.game.tim.api.message.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(msgId, it.id()));
            }
        });
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Nullable
    public com.tencent.timi.game.tim.api.message.a G() {
        if (!this.datas.isEmpty()) {
            return this.datas.get(0);
        }
        return null;
    }

    public int H() {
        return this.datas.size();
    }

    public void J(@NotNull com.tencent.timi.game.tim.api.message.a localMsg) {
        Intrinsics.checkNotNullParameter(localMsg, "localMsg");
        this.datas.add(localMsg);
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemInserted(this.datas.size());
        }
    }

    public boolean K() {
        return !this.recyclerView.canScrollVertically(1);
    }

    public void O(@Nullable String msgId) {
        Iterable withIndex;
        Object obj;
        withIndex = CollectionsKt___CollectionsKt.withIndex(this.datas);
        Iterator it = withIndex.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(msgId, ((com.tencent.timi.game.tim.api.message.a) ((IndexedValue) obj).getValue()).id())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        if (indexedValue != null) {
            ((com.tencent.timi.game.tim.api.message.a) indexedValue.getValue()).q(MsgStatus.REVOKE);
            RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(indexedValue.getIndex());
            }
        }
    }

    public void P(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        String valueOf;
        Object obj;
        boolean z16;
        int i3;
        String str;
        PBInt32Field pBInt32Field;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.roomInfo;
        if (yoloRoomOuterClass$YoloRoomInfo == null || !q.a(this.messageViewProvider, msg2, yoloRoomOuterClass$YoloRoomInfo)) {
            return;
        }
        if (msg2.b()) {
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            ConcurrentHashMap<String, String> L = YoloRoomUtil.L(yoloRoomOuterClass$YoloRoomInfo);
            L.put("yes_msg_type", String.valueOf(msg2.type()));
            L.put("yes_emo_type", String.valueOf(msg2.o()));
            if (this.messageViewProvider.b(msg2) == 6) {
                List<SmobaDataOuterClass$GameCampSettleInfo> list = msg2.a().yolo_room_action_msg.yolo_room_action.yolo_smoba_room_battle_result_action.smoba_battle_result.camp_settle_list.get();
                Intrinsics.checkNotNullExpressionValue(list, "msg.content().yolo_room_\u2026lt.camp_settle_list.get()");
                Iterator<T> it = list.iterator();
                while (true) {
                    obj = null;
                    z16 = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    List<SmobaDataOuterClass$PlayerSettleInfo> list2 = ((SmobaDataOuterClass$GameCampSettleInfo) next).campsettledetail.get();
                    Intrinsics.checkNotNullExpressionValue(list2, "list.campsettledetail.get()");
                    Iterator<T> it5 = list2.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        Object next2 = it5.next();
                        if (((SmobaDataOuterClass$PlayerSettleInfo) next2).uid.get() > 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            obj = next2;
                            break;
                        }
                    }
                    if (obj != null) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        obj = next;
                        break;
                    }
                }
                SmobaDataOuterClass$GameCampSettleInfo smobaDataOuterClass$GameCampSettleInfo = (SmobaDataOuterClass$GameCampSettleInfo) obj;
                if (smobaDataOuterClass$GameCampSettleInfo != null && (pBInt32Field = smobaDataOuterClass$GameCampSettleInfo.campresult) != null) {
                    i3 = pBInt32Field.get();
                } else {
                    i3 = 0;
                }
                if (i3 == 1) {
                    z16 = true;
                }
                if (z16) {
                    str = "1";
                } else {
                    str = "0";
                }
                L.put("yes_battle_result", str);
            }
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportP\u2026      }\n                }");
            bVar.reportEvent("ev_yes_msg_send", L);
        }
        if (K()) {
            x(msg2);
            R();
            return;
        }
        this.newMsgCount++;
        TextView textView = this.newMsgView;
        if (textView != null) {
            fh4.g.o(textView, true);
        }
        x(msg2);
        TextView textView2 = this.newMsgView;
        if (textView2 != null) {
            int i16 = this.newMsgCount;
            if (i16 > 99) {
                valueOf = ThemeBackground.DIY_UPLOAD_BG_ID;
            } else {
                valueOf = String.valueOf(i16);
            }
            textView2.setText(String.valueOf(valueOf));
        }
        if (I(msg2)) {
            com.tencent.timi.game.utils.l.b(this.TAG, "hasAtMeMessage: " + this.showAtMsgId);
            S();
        }
    }

    public void R() {
        int i3;
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            i3 = adapter.getNUM_BACKGOURND_ICON();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return;
        }
        this.recyclerView.stopScroll();
        this.linearLayoutManager.scrollToPositionWithOffset(i3 - 1, 0);
        A();
        z();
    }

    public void b0(@Nullable String msgId) {
        Iterable withIndex;
        Object obj;
        RecyclerView.Adapter adapter;
        withIndex = CollectionsKt___CollectionsKt.withIndex(this.datas);
        Iterator it = withIndex.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(msgId, ((com.tencent.timi.game.tim.api.message.a) ((IndexedValue) obj).getValue()).id())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        if (indexedValue != null && (adapter = this.recyclerView.getAdapter()) != null) {
            adapter.notifyItemChanged(indexedValue.getIndex());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(GreetingNewUserEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachingWindow = true;
        if (getContext() instanceof LifecycleOwner) {
            Object context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            ((LifecycleOwner) context).getLifecycle().addObserver(this);
        }
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        PBInt32Field pBInt32Field;
        super.onDetachedFromWindow();
        boolean z16 = false;
        this.isAttachingWindow = false;
        if (getContext() instanceof LifecycleOwner) {
            Object context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            ((LifecycleOwner) context).getLifecycle().removeObserver(this);
        }
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.roomInfo;
        if (yoloRoomOuterClass$YoloRoomInfo != null && (pBInt32Field = yoloRoomOuterClass$YoloRoomInfo.room_type) != null && pBInt32Field.get() == 5) {
            z16 = true;
        }
        if (z16) {
            TeamInfoAutoUpdateService.h().e();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable final SimpleBaseEvent p06) {
        PBUInt64Field pBUInt64Field;
        if (p06 instanceof GreetingNewUserEvent) {
            YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.roomInfo;
            boolean z16 = false;
            if (yoloRoomOuterClass$YoloRoomInfo != null && (pBUInt64Field = yoloRoomOuterClass$YoloRoomInfo.room_id) != null && ((GreetingNewUserEvent) p06).getRoomId() == pBUInt64Field.get()) {
                z16 = true;
            }
            if (!z16) {
                return;
            }
            com.tencent.timi.game.utils.w.c(new Runnable() { // from class: com.tencent.timi.game.component.chat.message.u
                @Override // java.lang.Runnable
                public final void run() {
                    MessageLayoutImpl.Q(MessageLayoutImpl.this, p06);
                }
            });
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        Lifecycle.Event event2 = Lifecycle.Event.ON_CREATE;
    }

    @Override // com.tencent.timi.game.component.chat.message.MessageLayout
    public void setChatId(long chatId) {
        this.chatId = String.valueOf(chatId);
    }

    @Override // com.tencent.timi.game.component.chat.message.MessageLayout
    public void setLayoutClickListener(@NotNull MessageLayout.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.layoutClickListener = listener;
    }

    @Override // com.tencent.timi.game.component.chat.message.MessageLayout
    public void setLayoutClickUpListener(@NotNull MessageLayout.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.layoutClickUpListener = listener;
    }

    public final void setMessageListener(@NotNull n listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.messageListener = listener;
    }

    @Override // com.tencent.timi.game.component.chat.message.MessageLayout
    public void setOnScrollMsgListener(@Nullable MessageLayout.d onScrollMsgListener) {
        this.scrollMsgListener = onScrollMsgListener;
    }

    @Override // com.tencent.timi.game.component.chat.message.MessageLayout
    public void setQQUserId(@NotNull CommonOuterClass$QQUserId qqUserId) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        this.selfUserId = qqUserId;
    }

    @Override // com.tencent.timi.game.component.chat.message.MessageLayout
    public void setRoomInfo(@Nullable YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        this.roomInfo = roomInfo;
        if (roomInfo != null) {
            this.messageViewProvider.c(roomInfo.room_id.get());
            this.messageViewProvider.d(roomInfo.room_type.get());
        }
    }

    @Override // com.tencent.timi.game.component.chat.message.MessageLayout
    public void setViewProvider(@Nullable MessageLayout.b viewProvider) {
        MessageLayout.a aVar;
        this.viewProvider = viewProvider;
        this.messageViewProvider.e(viewProvider);
        if (viewProvider != null) {
            aVar = viewProvider.a();
        } else {
            aVar = null;
        }
        this.iImConfig = aVar;
    }

    public void v(@NotNull List<? extends com.tencent.timi.game.tim.api.message.a> msgs) {
        Intrinsics.checkNotNullParameter(msgs, "msgs");
        ArrayList<com.tencent.timi.game.tim.api.message.a> arrayList = new ArrayList();
        Iterator<T> it = msgs.iterator();
        while (true) {
            boolean z16 = false;
            if (it.hasNext()) {
                Object next = it.next();
                com.tencent.timi.game.tim.api.message.a aVar = (com.tencent.timi.game.tim.api.message.a) next;
                YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.roomInfo;
                if (yoloRoomOuterClass$YoloRoomInfo == null) {
                    return;
                }
                if (q.a(this.messageViewProvider, aVar, yoloRoomOuterClass$YoloRoomInfo) && (this.messageViewProvider.b(aVar) != 5 || aVar.m() != 1)) {
                    z16 = true;
                }
                if (z16) {
                    arrayList.add(next);
                }
            } else {
                if (arrayList.isEmpty()) {
                    return;
                }
                for (com.tencent.timi.game.tim.api.message.a aVar2 : arrayList) {
                    if (aVar2.type() == 84) {
                        int i3 = aVar2.a().share_ark_msg.card_type.get();
                        int m3 = aVar2.m();
                        com.tencent.timi.game.component.chat.message.a aVar3 = com.tencent.timi.game.component.chat.message.a.f376607a;
                        if (m3 > aVar3.a(i3)) {
                            aVar3.b(i3, aVar2.m());
                        }
                    }
                }
                if (this.datas.isEmpty()) {
                    this.datas.addAll(arrayList);
                    Z();
                    R();
                    com.tencent.timi.game.utils.w.d(new Runnable() { // from class: com.tencent.timi.game.component.chat.message.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            MessageLayoutImpl.w(MessageLayoutImpl.this);
                        }
                    }, 100L);
                    return;
                }
                this.datas.addAll(0, arrayList);
                RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyItemRangeInserted(0, arrayList.size());
                    return;
                }
                return;
            }
        }
    }

    public void y(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        com.tencent.timi.game.utils.l.b(this.TAG, "addSendMsg " + msg2.id());
        this.datas.add(msg2);
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemInserted(this.datas.size());
        }
        R();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageLayoutImpl(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MessageLayoutImpl(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MessageLayoutImpl(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "MessageLayoutImplDebug";
        this.chatId = "";
        this.datas = new ArrayList();
        this.messageViewProvider = new ad(null, 1, 0 == true ? 1 : 0);
        this.showAtMsgId = "";
        RecyclerView recyclerView = new RecyclerView(context);
        this.recyclerView = recyclerView;
        recyclerView.setEnabled(true);
        recyclerView.setOverScrollMode(2);
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.timi.game.component.chat.message.r
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean L;
                L = MessageLayoutImpl.L(MessageLayoutImpl.this, view, motionEvent);
                return L;
            }
        });
        addView(recyclerView, new FrameLayout.LayoutParams(fh4.b.e(this), fh4.b.e(this)));
        TextView textView = new TextView(getContext());
        this.newMsgView = textView;
        fh4.b.g(textView, 10.0f);
        textView.setPadding(0, fh4.b.b(2), 0, 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageLayoutImpl.M(MessageLayoutImpl.this, view);
            }
        });
        textView.setTextColor(yn4.c.a(R.color.f158017al3));
        textView.setGravity(1);
        textView.setVisibility(8);
        textView.setBackgroundResource(R.drawable.o9r);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fh4.b.b(21), fh4.b.b(21));
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = fh4.b.b(14);
        layoutParams.rightMargin = fh4.b.b(14);
        Unit unit = Unit.INSTANCE;
        addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.newAtMsgView = textView2;
        fh4.b.g(textView2, 16.0f);
        textView2.setPadding(fh4.b.b(11), fh4.b.b(3), fh4.b.b(11), fh4.b.b(3));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageLayoutImpl.N(MessageLayoutImpl.this, view);
            }
        });
        textView2.setCompoundDrawablePadding(fh4.b.b(3));
        textView2.setTextColor(yn4.c.a(R.color.black));
        textView2.setGravity(1);
        textView2.setVisibility(8);
        textView2.setBackgroundResource(R.drawable.lqj);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(fh4.b.f(this), fh4.b.f(this));
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = fh4.b.b(16);
        addView(textView2, layoutParams2);
        setOverScrollMode(2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.linearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.recyclerView.setLayoutManager(this.linearLayoutManager);
        RecyclerView.ItemAnimator itemAnimator = this.recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setAddDuration(100L);
            itemAnimator.setRemoveDuration(100L);
            itemAnimator.setMoveDuration(100L);
        }
        this.recyclerView.addItemDecoration(new a());
        this.recyclerView.addOnScrollListener(new b());
        this.recyclerView.setAdapter(new c());
    }
}
