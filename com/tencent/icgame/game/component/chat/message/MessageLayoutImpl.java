package com.tencent.icgame.game.component.chat.message;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
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
import com.tencent.icgame.game.component.chat.event.GreetingNewUserEvent;
import com.tencent.icgame.game.component.chat.message.MessageLayout;
import com.tencent.icgame.game.component.chat.message.MessageLayoutImpl;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001+B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u0012\b\b\u0002\u0010X\u001a\u00020D\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\u0005H\u0014J\b\u0010\f\u001a\u00020\u0005H\u0014J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\"H\u0016J\u0012\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040(0'H\u0016R\u0014\u0010-\u001a\u00020*8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0019\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010,R\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010R\u00a8\u0006["}, d2 = {"Lcom/tencent/icgame/game/component/chat/message/MessageLayoutImpl;", "Lcom/tencent/icgame/game/component/chat/message/MessageLayout;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "p", "o", "Lcom/tencent/icgame/game/component/chat/message/i;", "listener", "setMessageListener", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "Lcom/tencent/icgame/game/component/chat/message/MessageLayout$d;", "onScrollMsgListener", "setOnScrollMsgListener", "Lcom/tencent/icgame/game/component/chat/message/MessageLayout$b;", "viewProvider", "setViewProvider", "", "chatId", "setChatId", "Lcom/tencent/icgame/trpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "setRoomInfo", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "setQQUserId", "u", "Lcom/tencent/icgame/game/component/chat/message/MessageLayout$c;", "setLayoutClickListener", "setLayoutClickUpListener", "p0", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "", "d", "Ljava/lang/String;", "TAG", "e", "f", "Lcom/tencent/icgame/trpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "", "Lcom/tencent/icgame/game/tim/api/message/a;", tl.h.F, "Ljava/util/List;", "datas", "Landroidx/recyclerview/widget/LinearLayoutManager;", "i", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "newMsgView", "D", "newAtMsgView", "", "E", "I", "newMsgCount", "Lcom/tencent/icgame/game/component/chat/message/q;", UserInfo.SEX_FEMALE, "Lcom/tencent/icgame/game/component/chat/message/q;", "messageViewProvider", "G", "showAtMsgId", "", "H", "Z", "isAttachingWindow", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "selfUserId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class MessageLayoutImpl extends MessageLayout implements LifecycleEventObserver, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView newMsgView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView newAtMsgView;

    /* renamed from: E, reason: from kotlin metadata */
    private int newMsgCount;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final q messageViewProvider;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String showAtMsgId;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isAttachingWindow;

    /* renamed from: I, reason: from kotlin metadata */
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
    private final List<com.tencent.icgame.game.tim.api.message.a> datas;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RecyclerView recyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/icgame/game/component/chat/message/MessageLayoutImpl$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
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
                outRect.top = uu0.a.b(10);
            }
            outRect.bottom = uu0.a.b(20);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/icgame/game/component/chat/message/MessageLayoutImpl$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            com.tencent.icgame.game.utils.g.h(MessageLayoutImpl.this.TAG, "onScrollStateChanged newState:" + newState);
            if (newState == 0) {
                AbstractGifImage.resumeAll();
            } else {
                AbstractGifImage.pauseAll();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\r\u001a\u00020\nH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/icgame/game/component/chat/message/MessageLayoutImpl$c", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/icgame/game/component/chat/message/MessageLayoutImpl$d;", "Lcom/tencent/icgame/game/component/chat/message/MessageLayoutImpl;", "Landroid/view/View;", "view", "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "position", "getItemViewType", "getItemCount", "holder", "k0", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
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
            return MessageLayoutImpl.this.messageViewProvider.b((com.tencent.icgame.game.tim.api.message.a) MessageLayoutImpl.this.datas.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull final d holder, int position) {
            com.tencent.icgame.game.tim.api.message.a aVar;
            YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo;
            PBUInt64Field pBUInt64Field;
            TextMessageItemView textMessageItemView;
            Intrinsics.checkNotNullParameter(holder, "holder");
            View view = holder.itemView;
            if (view instanceof BaseMessageView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.icgame.game.component.chat.message.BaseMessageView");
                MessageLayoutImpl.h(MessageLayoutImpl.this);
                ((BaseMessageView) view).setImConfig(null);
                View view2 = holder.itemView;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.icgame.game.component.chat.message.BaseMessageView");
                ((BaseMessageView) view2).setYoloRoomInfo(MessageLayoutImpl.this.roomInfo);
                View view3 = holder.itemView;
                Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type com.tencent.icgame.game.component.chat.message.BaseMessageView");
                MessageLayoutImpl.i(MessageLayoutImpl.this);
                ((BaseMessageView) view3).setMessageListener(null);
            } else if (view instanceof CenterMessageView) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.icgame.game.component.chat.message.CenterMessageView");
                ((CenterMessageView) view).setYoloRoomInfo(MessageLayoutImpl.this.roomInfo);
                View view4 = holder.itemView;
                Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.icgame.game.component.chat.message.CenterMessageView");
                MessageLayoutImpl.h(MessageLayoutImpl.this);
                ((CenterMessageView) view4).setThemeConfig(null);
                View view5 = holder.itemView;
                Intrinsics.checkNotNull(view5, "null cannot be cast to non-null type com.tencent.icgame.game.component.chat.message.CenterMessageView");
                MessageLayoutImpl.i(MessageLayoutImpl.this);
                ((CenterMessageView) view5).setMessageListener(null);
            }
            com.tencent.icgame.game.tim.api.message.a aVar2 = (com.tencent.icgame.game.tim.api.message.a) MessageLayoutImpl.this.datas.get(position);
            if (aVar2.type() == xx0.e.d() && MessageLayoutImpl.this.roomInfo != null && (yoloRoomOuterClass$YoloRoomInfo = MessageLayoutImpl.this.roomInfo) != null && (pBUInt64Field = yoloRoomOuterClass$YoloRoomInfo.room_id) != null) {
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
                Intrinsics.checkNotNull(view7, "null cannot be cast to non-null type com.tencent.icgame.game.component.chat.message.CenterMessageView");
                ((CenterMessageView) view7).setPosition(position);
            }
            KeyEvent.Callback callback = holder.itemView;
            Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.icgame.game.component.chat.message.IMessageView");
            j jVar = (j) callback;
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = MessageLayoutImpl.this.selfUserId;
            if (position > 0) {
                aVar = (com.tencent.icgame.game.tim.api.message.a) MessageLayoutImpl.this.datas.get(position - 1);
            } else {
                aVar = null;
            }
            jVar.a(commonOuterClass$QQUserId, aVar2, aVar);
            if (position == MessageLayoutImpl.this.datas.size() - 1) {
                MessageLayoutImpl.this.p();
                MessageLayoutImpl.this.o();
            }
            MessageLayoutImpl.l(MessageLayoutImpl.this);
            if ((holder.itemView instanceof TextMessageItemView) && aVar2.type() == 1 && aVar2.getMemData() != null) {
                aVar2.e(null);
                holder.itemView.setVisibility(4);
                holder.itemView.postDelayed(new Runnable() { // from class: com.tencent.icgame.game.component.chat.message.o
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
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.icgame.game.component.chat.message.TouchPositionGetableRelativeLayout");
            return new d(messageLayoutImpl, (TouchPositionGetableRelativeLayout) a16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/icgame/game/component/chat/message/MessageLayoutImpl$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/icgame/game/component/chat/message/MessageLayoutImpl;Landroid/view/View;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
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

    public static final /* synthetic */ MessageLayout.a h(MessageLayoutImpl messageLayoutImpl) {
        messageLayoutImpl.getClass();
        return null;
    }

    public static final /* synthetic */ i i(MessageLayoutImpl messageLayoutImpl) {
        messageLayoutImpl.getClass();
        return null;
    }

    public static final /* synthetic */ MessageLayout.d l(MessageLayoutImpl messageLayoutImpl) {
        messageLayoutImpl.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        this.showAtMsgId = "";
        this.newMsgCount = 0;
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        TextView textView = this.newMsgView;
        if (textView != null) {
            uu0.b.i(textView, false);
        }
        this.newMsgCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(MessageLayoutImpl this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null) {
            int action = motionEvent.getAction();
            if (action == 0 || 3 == action) {
                this$0.getClass();
            }
            if (1 == action || 3 == action) {
                this$0.getClass();
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MessageLayoutImpl this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
        this$0.newMsgCount = 0;
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MessageLayoutImpl this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
        this$0.newMsgCount = 0;
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(MessageLayoutImpl this$0, SimpleBaseEvent simpleBaseEvent) {
        RecyclerView.Adapter adapter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<com.tencent.icgame.game.tim.api.message.a> it = this$0.datas.iterator();
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
        super.onDetachedFromWindow();
        this.isAttachingWindow = false;
        if (getContext() instanceof LifecycleOwner) {
            Object context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            ((LifecycleOwner) context).getLifecycle().removeObserver(this);
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
            com.tencent.icgame.game.utils.k.b(new Runnable() { // from class: com.tencent.icgame.game.component.chat.message.k
                @Override // java.lang.Runnable
                public final void run() {
                    MessageLayoutImpl.t(MessageLayoutImpl.this, p06);
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

    @Override // com.tencent.icgame.game.component.chat.message.MessageLayout
    public void setChatId(long chatId) {
        this.chatId = String.valueOf(chatId);
    }

    @Override // com.tencent.icgame.game.component.chat.message.MessageLayout
    public void setLayoutClickListener(@NotNull MessageLayout.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.icgame.game.component.chat.message.MessageLayout
    public void setLayoutClickUpListener(@NotNull MessageLayout.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public final void setMessageListener(@NotNull i listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.tencent.icgame.game.component.chat.message.MessageLayout
    public void setQQUserId(@NotNull CommonOuterClass$QQUserId qqUserId) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        this.selfUserId = qqUserId;
    }

    @Override // com.tencent.icgame.game.component.chat.message.MessageLayout
    public void setRoomInfo(@Nullable YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        this.roomInfo = roomInfo;
        if (roomInfo != null) {
            this.messageViewProvider.c(roomInfo.room_id.get());
            this.messageViewProvider.d(roomInfo.room_type.get());
        }
    }

    @Override // com.tencent.icgame.game.component.chat.message.MessageLayout
    public void setViewProvider(@Nullable MessageLayout.b viewProvider) {
        this.messageViewProvider.e(viewProvider);
        if (viewProvider != null) {
            viewProvider.a();
        }
    }

    public void u() {
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
        p();
        o();
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
        this.TAG = "ICGameMessageLayoutImplDebug";
        this.chatId = "";
        this.datas = new ArrayList();
        this.messageViewProvider = new q(null, 1, null);
        this.showAtMsgId = "";
        RecyclerView recyclerView = new RecyclerView(context);
        this.recyclerView = recyclerView;
        recyclerView.setEnabled(true);
        recyclerView.setOverScrollMode(2);
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.icgame.game.component.chat.message.l
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean q16;
                q16 = MessageLayoutImpl.q(MessageLayoutImpl.this, view, motionEvent);
                return q16;
            }
        });
        addView(recyclerView, new FrameLayout.LayoutParams(uu0.a.e(this), uu0.a.e(this)));
        TextView textView = new TextView(getContext());
        this.newMsgView = textView;
        uu0.a.g(textView, 10.0f);
        textView.setPadding(0, uu0.a.b(2), 0, 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.component.chat.message.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageLayoutImpl.r(MessageLayoutImpl.this, view);
            }
        });
        textView.setTextColor(cy0.b.a(R.color.f158017al3));
        textView.setGravity(1);
        textView.setVisibility(8);
        textView.setBackgroundResource(R.drawable.o9r);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(uu0.a.b(21), uu0.a.b(21));
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = uu0.a.b(14);
        layoutParams.rightMargin = uu0.a.b(14);
        Unit unit = Unit.INSTANCE;
        addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.newAtMsgView = textView2;
        uu0.a.g(textView2, 16.0f);
        textView2.setPadding(uu0.a.b(11), uu0.a.b(3), uu0.a.b(11), uu0.a.b(3));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.component.chat.message.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessageLayoutImpl.s(MessageLayoutImpl.this, view);
            }
        });
        textView2.setCompoundDrawablePadding(uu0.a.b(3));
        textView2.setTextColor(cy0.b.a(R.color.black));
        textView2.setGravity(1);
        textView2.setVisibility(8);
        textView2.setBackgroundResource(R.drawable.lqj);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(uu0.a.f(this), uu0.a.f(this));
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = uu0.a.b(16);
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

    @Override // com.tencent.icgame.game.component.chat.message.MessageLayout
    public void setOnScrollMsgListener(@Nullable MessageLayout.d onScrollMsgListener) {
    }
}
