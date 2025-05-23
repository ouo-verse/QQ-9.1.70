package com.tencent.mobileqq.icgame.widget.chat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AnchorRoomBulletScreenMsg;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUser;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUserMsg;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.icgame.widget.chat.floating.ChatAnnounceMsgFloatingItemView;
import com.tencent.mobileqq.icgame.widget.chat.floating.ChatGiftMsgFloatingItemView;
import com.tencent.mobileqq.icgame.widget.chat.floating.ChatSysMsgFloatingItemView;
import com.tencent.mobileqq.icgame.widget.chat.floating.ChatTextMsgFloatingItemView;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTeamHintMsgItemView;
import com.tencent.mobileqq.icgame.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import w42.FollowPushScreenMessage;
import w42.GiftScreenMsg;
import w42.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0004-7a#B'\b\u0007\u0012\u0006\u0010[\u001a\u00020Z\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\\u0012\b\b\u0002\u0010^\u001a\u00020\u0011\u00a2\u0006\u0004\b_\u0010`J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u0018\u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J(\u0010\"\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011H\u0014J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016J \u0010-\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u0011H\u0016J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0003H\u0016J\u0010\u00102\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u000201H\u0016J\u0012\u00105\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u0010\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0003H\u0016J\u0006\u00108\u001a\u00020\u0007R\u0016\u0010:\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00109R\"\u0010<\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010AR\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010CR\u0016\u0010E\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010CR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00050F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010KR\u0016\u0010O\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010QR\u0016\u0010T\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00109R\u0016\u0010V\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010AR\u0016\u0010W\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010;R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010XR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010Y\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/ChatFloatingMessageLayout;", "Landroid/widget/FrameLayout;", "Lz42/b;", "", "G", "", "msg", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "Landroid/text/SpannableStringBuilder;", "y", "up", "Landroid/view/View$OnClickListener;", "listener", "N", "L", "", "E", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", com.tencent.luggage.wxa.c8.c.G, "useScrollTo", BdhLogUtil.LogTag.Tag_Conn, "Lz42/a;", "dataSupport", "Lz42/c;", "playFunc", "setSupportFunc", "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "d", "g", "notifyDataSetChanged", "Lw42/f;", "f", "", "roomId", "e", "anchorUid", "roomType", "b", "onExitRoom", "show", "a", "Lcom/tencent/mobileqq/icgame/widget/chat/ChatMessageLayout$d;", "setAnchorMessageItemClickListener", "Landroid/view/ViewGroup;", "view", "setTouchViewGroup", LightConstants.DowngradeStrategyKey.SMOOTH, "c", "K", "I", "sizeHeight", "Z", "isAnchor", "()Z", "setAnchor", "(Z)V", "", "Ljava/lang/String;", "chatId", "J", "i", "ownerId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "datas", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "D", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "newMsgView", "newAtMsgView", "newMsgCount", "H", "showAtMsgId", "isSingleLineModel", "Lz42/a;", "Lz42/c;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MsgRecyclerView", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ChatFloatingMessageLayout extends FrameLayout implements z42.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private RecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView newMsgView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView newAtMsgView;

    /* renamed from: G, reason: from kotlin metadata */
    private int newMsgCount;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String showAtMsgId;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isSingleLineModel;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private z42.a dataSupport;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private z42.c playFunc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int sizeHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isAnchor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String chatId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long ownerId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Object> datas;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/icgame/widget/chat/ChatFloatingMessageLayout$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.bottom = wi2.c.b(7);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/ChatFloatingMessageLayout$c;", "", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/ChatFloatingMessageLayout$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/icgame/widget/chat/ChatFloatingMessageLayout;Landroid/view/View;)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class d extends RecyclerView.ViewHolder {
        final /* synthetic */ ChatFloatingMessageLayout E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull ChatFloatingMessageLayout chatFloatingMessageLayout, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = chatFloatingMessageLayout;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatFloatingMessageLayout(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        this.showAtMsgId = "";
        this.newMsgCount = 0;
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        TextView textView = this.newMsgView;
        if (textView != null) {
            wi2.d.e(textView, false);
        }
        this.newMsgCount = 0;
    }

    private final void C(final RecyclerView recyclerView, final int i3, final boolean z16) {
        if (i3 < this.datas.size() && i3 >= 0) {
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.widget.chat.e
                @Override // java.lang.Runnable
                public final void run() {
                    ChatFloatingMessageLayout.D(RecyclerView.this, z16, i3, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(RecyclerView this_completeScrollToPos, boolean z16, int i3, ChatFloatingMessageLayout this$0) {
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
        this$0.A();
    }

    private final int E() {
        int size;
        if (!TextUtils.isEmpty(this.showAtMsgId)) {
            int i3 = 0;
            for (Object obj : this.datas) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if ((obj instanceof w42.e) && Intrinsics.areEqual(this.showAtMsgId, ((w42.e) obj).id()) && (size = this.datas.size() - i3) >= 0) {
                    return size;
                }
                i3 = i16;
            }
        }
        return 0;
    }

    private final boolean F(Object msg2) {
        boolean z16;
        MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent2;
        MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg2;
        PBRepeatMessageField<MessageOuterClass$AtUser> pBRepeatMessageField;
        boolean z17 = false;
        if (!(msg2 instanceof w42.e)) {
            return false;
        }
        w42.e eVar = (w42.e) msg2;
        MessageOuterClass$TimMsgBody a16 = eVar.a();
        if (a16 != null && (messageOuterClass$MsgContent2 = a16.content) != null && (messageOuterClass$AtUserMsg2 = messageOuterClass$MsgContent2.at_user_msg) != null && (pBRepeatMessageField = messageOuterClass$AtUserMsg2.user_list) != null && pBRepeatMessageField.size() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && TextUtils.isEmpty(this.showAtMsgId)) {
            z42.a aVar = this.dataSupport;
            if (aVar != null) {
                MessageOuterClass$TimMsgBody a17 = eVar.a();
                if (a17 != null && (messageOuterClass$MsgContent = a17.content) != null) {
                    messageOuterClass$AtUserMsg = messageOuterClass$MsgContent.at_user_msg;
                } else {
                    messageOuterClass$AtUserMsg = null;
                }
                if (aVar.b(messageOuterClass$AtUserMsg)) {
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

    private final boolean G() {
        return !this.recyclerView.canScrollVertically(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H(ChatFloatingMessageLayout this$0, View view, MotionEvent motionEvent) {
        z42.c cVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent != null && 1 == motionEvent.getAction() && (cVar = this$0.playFunc) != null) {
            cVar.i(motionEvent);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(ChatFloatingMessageLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
        this$0.newMsgCount = 0;
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ChatFloatingMessageLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
        this$0.newMsgCount = 0;
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L() {
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setText(y());
        }
        final int E = E();
        rt0.a.INSTANCE.f("ICGameChat_Message|ICGameChatFloatingMessageLayout", "showAtMsgShortCut: " + E);
        N(false, new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatFloatingMessageLayout.M(ChatFloatingMessageLayout.this, E, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(ChatFloatingMessageLayout this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C(this$0.recyclerView, Math.max(0, this$0.datas.size() - i3), true);
        this$0.A();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void N(boolean up5, View.OnClickListener listener) {
        TextView textView = this.newAtMsgView;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.newAtMsgView;
        if (textView2 != null) {
            textView2.setOnClickListener(listener);
        }
    }

    public static final /* synthetic */ c o(ChatFloatingMessageLayout chatFloatingMessageLayout) {
        chatFloatingMessageLayout.getClass();
        return null;
    }

    private final SpannableStringBuilder y() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("\u6709\u4eba@\u4f60");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(c52.a.a(R.color.f158017al3)), 2, 4, 33);
        return spannableStringBuilder;
    }

    private final void z(Object msg2) {
        this.datas.add(msg2);
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemInserted(this.datas.size() - 1);
        }
    }

    public final void K() {
        int i3;
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            i3 = adapter.getItemCount();
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            return;
        }
        this.recyclerView.stopScroll();
        this.linearLayoutManager.scrollToPositionWithOffset(i3 - 1, 0);
        B();
        A();
    }

    @Override // z42.b
    public void d(@NotNull Object msg2) {
        String valueOf;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (G()) {
            z(msg2);
            K();
            return;
        }
        this.newMsgCount++;
        TextView textView = this.newMsgView;
        if (textView != null) {
            wi2.d.e(textView, true);
        }
        z(msg2);
        TextView textView2 = this.newMsgView;
        if (textView2 != null) {
            StringBuilder sb5 = new StringBuilder();
            int i3 = this.newMsgCount;
            if (i3 > 99) {
                valueOf = "99+";
            } else {
                valueOf = String.valueOf(i3);
            }
            sb5.append(valueOf);
            sb5.append("\u6761\u65b0\u6d88\u606f");
            textView2.setText(sb5.toString());
        }
        if (F(msg2)) {
            rt0.a.INSTANCE.f("ICGameChat_Message|ICGameChatFloatingMessageLayout", "hasAtMeMessage: " + this.showAtMsgId);
            L();
        }
    }

    @Override // z42.b
    public void f(@NotNull w42.f msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }

    @Override // z42.b
    public void g(int pos) {
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(pos, 0);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        rt0.a.INSTANCE.j("ICGameChat_Message|ICGameChatFloatingMessageLayout", "w = [" + w3 + "], h = [" + h16 + "], oldw = [" + oldw + "], oldh = [" + oldh + ']');
        this.sizeHeight = h16;
    }

    public final void setAnchor(boolean z16) {
        this.isAnchor = z16;
    }

    public void setAnchorMessageItemClickListener(@NotNull ChatMessageLayout.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // z42.b
    public void setSupportFunc(@NotNull z42.a dataSupport, @NotNull z42.c playFunc) {
        Intrinsics.checkNotNullParameter(dataSupport, "dataSupport");
        Intrinsics.checkNotNullParameter(playFunc, "playFunc");
        this.dataSupport = dataSupport;
        this.playFunc = playFunc;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0014J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/ChatFloatingMessageLayout$MsgRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/ViewParent;", BdhLogUtil.LogTag.Tag_Conn, "", "w", tl.h.F, "oldw", "oldh", "", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "widthSpec", "heightSpec", "onMeasure", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "direction", "canScrollHorizontally", "e", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "def", "<init>", "(Lcom/tencent/mobileqq/icgame/widget/chat/ChatFloatingMessageLayout;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class MsgRecyclerView extends RecyclerView {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ChatFloatingMessageLayout f237836f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public MsgRecyclerView(@NotNull ChatFloatingMessageLayout chatFloatingMessageLayout, @Nullable Context ctx, AttributeSet attributeSet, int i3) {
            super(ctx, attributeSet, i3);
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            this.f237836f = chatFloatingMessageLayout;
        }

        private final ViewParent C() {
            ViewParent parent = getParent();
            while (true) {
                z42.a aVar = this.f237836f.dataSupport;
                boolean z16 = false;
                if (aVar != null && aVar.u(parent)) {
                    z16 = true;
                }
                if (z16) {
                    if (parent != null) {
                        parent = parent.getParent();
                    } else {
                        parent = null;
                    }
                } else {
                    return parent;
                }
            }
        }

        @Override // android.view.View
        public boolean canScrollHorizontally(int direction) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
            return super.dispatchTouchEvent(ev5);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(@Nullable MotionEvent e16) {
            Integer num;
            ViewParent C;
            if (e16 != null) {
                num = Integer.valueOf(e16.getAction());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                ViewParent C2 = C();
                if (this.f237836f.isSingleLineModel) {
                    if (C2 != null) {
                        C2.requestDisallowInterceptTouchEvent(false);
                    }
                } else if (C2 != null) {
                    C2.requestDisallowInterceptTouchEvent(true);
                }
            } else if (((num != null && num.intValue() == 1) || (num != null && num.intValue() == 3)) && (C = C()) != null) {
                C.requestDisallowInterceptTouchEvent(false);
            }
            return super.onInterceptTouchEvent(e16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public void onMeasure(int widthSpec, int heightSpec) {
            if (this.f237836f.sizeHeight > 0 && View.MeasureSpec.getSize(heightSpec) > this.f237836f.sizeHeight) {
                super.onMeasure(widthSpec, View.MeasureSpec.makeMeasureSpec(this.f237836f.sizeHeight, Integer.MIN_VALUE));
            } else {
                super.onMeasure(widthSpec, heightSpec);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public void onSizeChanged(int w3, int h16, int oldw, int oldh) {
            ViewGroup.LayoutParams layoutParams;
            super.onSizeChanged(w3, h16, oldw, oldh);
            rt0.a.INSTANCE.f("ICGameChat_Message|ICGameChatFloatingMessageLayout", "MsgRecyclerView onSizeChanged w = [" + w3 + "], h = [" + h16 + "], oldw = [" + oldw + "], oldh = [" + oldh + ']');
            if (h16 >= this.f237836f.sizeHeight && (layoutParams = getLayoutParams()) != null) {
                ChatFloatingMessageLayout chatFloatingMessageLayout = this.f237836f;
                layoutParams.height = chatFloatingMessageLayout.sizeHeight;
                setLayoutParams(layoutParams);
                chatFloatingMessageLayout.linearLayoutManager.setAutoMeasureEnabled(false);
                setHasFixedSize(true);
            }
        }

        public /* synthetic */ MsgRecyclerView(ChatFloatingMessageLayout chatFloatingMessageLayout, Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(chatFloatingMessageLayout, context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatFloatingMessageLayout(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ChatFloatingMessageLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatFloatingMessageLayout(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.isAnchor = true;
        this.chatId = "999L";
        this.datas = new ArrayList();
        this.showAtMsgId = "";
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        MsgRecyclerView msgRecyclerView = new MsgRecyclerView(this, context, null, 0, 6, null);
        this.recyclerView = msgRecyclerView;
        msgRecyclerView.setEnabled(true);
        msgRecyclerView.setOverScrollMode(2);
        msgRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean H;
                H = ChatFloatingMessageLayout.H(ChatFloatingMessageLayout.this, view, motionEvent);
                return H;
            }
        });
        msgRecyclerView.setRecycledViewPool(new a52.b());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(wi2.b.a(this), wi2.b.b(this));
        layoutParams.gravity = 80;
        Unit unit = Unit.INSTANCE;
        addView(msgRecyclerView, layoutParams);
        TextView textView = new TextView(getContext());
        this.newMsgView = textView;
        wi2.b.d(textView, 12.0f);
        textView.setPadding(wi2.c.b(10), 0, wi2.c.b(10), 0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatFloatingMessageLayout.I(ChatFloatingMessageLayout.this, view);
            }
        });
        textView.setTextColor(Color.parseColor("#6666FF"));
        textView.setGravity(17);
        textView.setVisibility(8);
        wi2.d.d(textView, wi2.c.b(18), c52.a.a(R.color.f158017al3));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(wi2.b.b(this), wi2.c.b(26));
        layoutParams2.gravity = 83;
        layoutParams2.bottomMargin = wi2.c.b(14);
        layoutParams2.leftMargin = wi2.c.b(16);
        setMinimumWidth(wi2.c.b(80));
        addView(textView, layoutParams2);
        TextView textView2 = new TextView(getContext());
        this.newAtMsgView = textView2;
        wi2.b.d(textView2, 12.0f);
        textView2.setPadding(wi2.c.b(11), 0, wi2.c.b(11), 0);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.widget.chat.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatFloatingMessageLayout.J(ChatFloatingMessageLayout.this, view);
            }
        });
        textView2.setCompoundDrawablePadding(wi2.c.b(3));
        textView2.setTextColor(c52.a.a(R.color.black));
        textView2.setGravity(17);
        textView2.setVisibility(8);
        wi2.d.d(textView2, wi2.c.b(18), c52.a.a(R.color.f158017al3));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(wi2.b.b(this), wi2.c.b(26));
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = wi2.c.b(14);
        addView(textView2, layoutParams3);
        setOverScrollMode(2);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext());
        this.linearLayoutManager = safeLinearLayoutManager;
        safeLinearLayoutManager.setOrientation(1);
        this.recyclerView.setLayoutManager(this.linearLayoutManager);
        this.recyclerView.setItemViewCacheSize(20);
        RecyclerView.ItemAnimator itemAnimator = this.recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(0L);
            itemAnimator.setRemoveDuration(0L);
            itemAnimator.setChangeDuration(0L);
            itemAnimator.setMoveDuration(0L);
        }
        this.recyclerView.addItemDecoration(new a());
        this.recyclerView.setAdapter(new RecyclerView.Adapter<d>() { // from class: com.tencent.mobileqq.icgame.widget.chat.ChatFloatingMessageLayout.9
            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return ChatFloatingMessageLayout.this.datas.size();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemViewType(int position) {
                return a52.a.a(ChatFloatingMessageLayout.this.datas.get(position));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            /* renamed from: i0, reason: merged with bridge method [inline-methods] */
            public void onBindViewHolder(@NotNull d holder, int position) {
                m mVar;
                Intrinsics.checkNotNullParameter(holder, "holder");
                Object obj = ChatFloatingMessageLayout.this.datas.get(position);
                rt0.a.INSTANCE.g("ICGameChat_Message|ICGameChatFloatingMessageLayout", "onBindViewHolder", "msg:" + obj);
                View view = holder.itemView;
                if (view instanceof ChatBaseText) {
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText");
                    ((ChatBaseText) view).setRoomId(ChatFloatingMessageLayout.this.roomId);
                    View view2 = holder.itemView;
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText");
                    ((ChatBaseText) view2).j();
                    View view3 = holder.itemView;
                    Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText");
                    ((ChatBaseText) view3).setSupportFunc(ChatFloatingMessageLayout.this.dataSupport, ChatFloatingMessageLayout.this.playFunc);
                }
                View view4 = holder.itemView;
                if (view4 instanceof ChatSysMsgFloatingItemView) {
                    if (obj instanceof w42.j) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.floating.ChatSysMsgFloatingItemView");
                        ((ChatSysMsgFloatingItemView) view4).l((w42.j) obj);
                    }
                } else if (view4 instanceof ChatTextMsgFloatingItemView) {
                    if (obj instanceof w42.e) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).C((w42.e) obj, ChatFloatingMessageLayout.this.ownerId);
                    } else if (obj instanceof FollowPushScreenMessage) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.floating.ChatTextMsgFloatingItemView");
                        long j3 = ChatFloatingMessageLayout.this.ownerId;
                        final ChatFloatingMessageLayout chatFloatingMessageLayout = ChatFloatingMessageLayout.this;
                        ((ChatTextMsgFloatingItemView) view4).A((FollowPushScreenMessage) obj, j3, new Function0<Unit>() { // from class: com.tencent.mobileqq.icgame.widget.chat.ChatFloatingMessageLayout$9$onBindViewHolder$1
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
                                RecyclerView recyclerView;
                                recyclerView = ChatFloatingMessageLayout.this.recyclerView;
                                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                                if (adapter != null) {
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        });
                    } else if (obj instanceof w42.b) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).z((w42.b) obj, ChatFloatingMessageLayout.this.ownerId);
                    } else if (obj instanceof w42.g) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).B((w42.g) obj, ChatFloatingMessageLayout.this.ownerId);
                    } else if (obj instanceof w42.j) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).I((w42.j) obj, ChatFloatingMessageLayout.this.ownerId);
                    } else if (obj instanceof LiveLocalMsg) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).D((LiveLocalMsg) obj, ChatFloatingMessageLayout.this.ownerId);
                    } else if (obj instanceof MessageOuterClass$AnchorRoomBulletScreenMsg) {
                        Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.floating.ChatTextMsgFloatingItemView");
                        ((ChatTextMsgFloatingItemView) view4).y((MessageOuterClass$AnchorRoomBulletScreenMsg) obj, ChatFloatingMessageLayout.this.ownerId);
                    }
                } else if (view4 instanceof ChatAnnounceMsgFloatingItemView) {
                    Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.floating.ChatAnnounceMsgFloatingItemView");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage");
                    ((ChatAnnounceMsgFloatingItemView) view4).c((AnnouncePushMessage) obj, ChatFloatingMessageLayout.this.roomId, ChatFloatingMessageLayout.this.dataSupport, ChatFloatingMessageLayout.this.playFunc);
                } else if (view4 instanceof ChatTeamHintMsgItemView) {
                    if (obj instanceof m) {
                        mVar = (m) obj;
                    } else {
                        mVar = null;
                    }
                    if (mVar == null) {
                        return;
                    }
                    Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTeamHintMsgItemView");
                    final ChatFloatingMessageLayout chatFloatingMessageLayout2 = ChatFloatingMessageLayout.this;
                    ((ChatTeamHintMsgItemView) view4).n(mVar, new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.icgame.widget.chat.ChatFloatingMessageLayout$9$onBindViewHolder$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                            invoke(l3.longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(long j16) {
                            ChatFloatingMessageLayout.o(ChatFloatingMessageLayout.this);
                        }
                    });
                } else if (view4 instanceof ChatGiftMsgFloatingItemView) {
                    Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.floating.ChatGiftMsgFloatingItemView");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.message.GiftScreenMsg");
                    ((ChatGiftMsgFloatingItemView) view4).q((GiftScreenMsg) obj, ChatFloatingMessageLayout.this.ownerId);
                }
                if (ChatFloatingMessageLayout.this.isSingleLineModel) {
                    ViewGroup.LayoutParams layoutParams4 = holder.itemView.getLayoutParams();
                    if (layoutParams4 != null) {
                        layoutParams4.height = wi2.c.b(25);
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams5 = holder.itemView.getLayoutParams();
                    if (layoutParams5 != null) {
                        layoutParams5.height = -2;
                    }
                }
                if (position == ChatFloatingMessageLayout.this.datas.size() - 1) {
                    ChatFloatingMessageLayout.this.B();
                    ChatFloatingMessageLayout.this.A();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            @NotNull
            /* renamed from: j0, reason: merged with bridge method [inline-methods] */
            public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
                View chatTextMsgFloatingItemView;
                Intrinsics.checkNotNullParameter(parent, "parent");
                rt0.a.INSTANCE.f("ICGameChat_Message|ICGameChatFloatingMessageLayout", "onCreateViewHolder, viewType = [" + viewType + ']');
                ChatFloatingMessageLayout chatFloatingMessageLayout = ChatFloatingMessageLayout.this;
                if (viewType != 1 && viewType != 2 && viewType != 3) {
                    if (viewType != 5) {
                        if (viewType != 6) {
                            if (viewType != 11) {
                                switch (viewType) {
                                    case 100:
                                    case 101:
                                    case 102:
                                        Context context2 = ChatFloatingMessageLayout.this.getContext();
                                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                                        chatTextMsgFloatingItemView = new ChatTextMsgFloatingItemView(context2, ChatFloatingMessageLayout.this.isSingleLineModel);
                                        break;
                                    default:
                                        Context context3 = ChatFloatingMessageLayout.this.getContext();
                                        Intrinsics.checkNotNullExpressionValue(context3, "context");
                                        chatTextMsgFloatingItemView = new ChatTextMsgFloatingItemView(context3, ChatFloatingMessageLayout.this.isSingleLineModel);
                                        break;
                                }
                            } else {
                                Context context4 = ChatFloatingMessageLayout.this.getContext();
                                Intrinsics.checkNotNullExpressionValue(context4, "context");
                                chatTextMsgFloatingItemView = new ChatTextMsgFloatingItemView(context4, ChatFloatingMessageLayout.this.isSingleLineModel);
                            }
                        }
                    } else {
                        chatTextMsgFloatingItemView = new ChatGiftMsgFloatingItemView(ChatFloatingMessageLayout.this.getContext());
                    }
                    return new d(chatFloatingMessageLayout, chatTextMsgFloatingItemView);
                }
                Context context5 = ChatFloatingMessageLayout.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "context");
                chatTextMsgFloatingItemView = new ChatTextMsgFloatingItemView(context5, ChatFloatingMessageLayout.this.isSingleLineModel);
                return new d(chatFloatingMessageLayout, chatTextMsgFloatingItemView);
            }
        });
    }

    @Override // z42.b
    public void notifyDataSetChanged() {
    }

    @Override // z42.b
    public void a(boolean show) {
    }

    @Override // z42.b
    public void c(boolean smooth) {
    }

    @Override // z42.b
    public void e(long roomId) {
    }

    @Override // z42.b
    public void onExitRoom(long roomId) {
    }

    public void setTouchViewGroup(@Nullable ViewGroup view) {
    }

    @Override // z42.b
    public void b(long roomId, long anchorUid, int roomType) {
    }
}
