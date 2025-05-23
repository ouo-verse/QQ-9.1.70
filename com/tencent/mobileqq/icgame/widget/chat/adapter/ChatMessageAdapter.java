package com.tencent.mobileqq.icgame.widget.chat.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AnchorRoomBulletScreenMsg;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatAnnounceMsgItemView;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatGiftMsgItemView;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatMsgWarpView;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatSysMsgItemView;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTeamHintMsgItemView;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTeamJoinMsgView;
import com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView;
import com.tencent.mobileqq.icgame.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w42.FollowPushScreenMessage;
import w42.GiftScreenMsg;
import w42.TeamPlayJoinMsg;
import w42.e;
import w42.g;
import w42.j;
import w42.k;
import w42.m;
import z42.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002<=B\u000f\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\b:\u0010;J$\u0010\t\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J8\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017J\u001c\u0010\u001d\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J*\u0010!\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0016J\u001c\u0010\"\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010.\u001a\u00020)8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00100R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/adapter/ChatMessageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/icgame/widget/chat/adapter/ChatMessageAdapter$b;", "holder", "", "position", "", "msg", "", "l0", "", "roomId", "ownerId", "", "dataList", "Lz42/a;", "dataSupport", "Lz42/c;", "playFunc", "k0", "Lcom/tencent/mobileqq/icgame/widget/chat/adapter/ChatMessageAdapter$a;", "updateLastItemListener", "j0", "Lcom/tencent/mobileqq/icgame/widget/chat/ChatMessageLayout$d;", "listener", "p0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "o0", "getItemViewType", "getItemCount", "payloads", "n0", "m0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "D", "J", "E", UserInfo.SEX_FEMALE, "Ljava/util/List;", "G", "Lcom/tencent/mobileqq/icgame/widget/chat/adapter/ChatMessageAdapter$a;", "H", "Lz42/a;", "I", "Lz42/c;", "<init>", "(Landroid/content/Context;)V", "a", "b", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ChatMessageAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: D, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: E, reason: from kotlin metadata */
    private long ownerId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<Object> dataList;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private a updateLastItemListener;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private z42.a dataSupport;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private c playFunc;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/adapter/ChatMessageAdapter$a;", "", "", "a", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/adapter/ChatMessageAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/icgame/widget/chat/adapter/ChatMessageAdapter;Landroid/view/View;)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class b extends RecyclerView.ViewHolder {
        final /* synthetic */ ChatMessageAdapter E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull ChatMessageAdapter chatMessageAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = chatMessageAdapter;
        }
    }

    public ChatMessageAdapter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.TAG = "ICGameChat_Message|ICGameChatMessageAdapter";
        this.dataList = new ArrayList();
    }

    public static final /* synthetic */ ChatMessageLayout.d i0(ChatMessageAdapter chatMessageAdapter) {
        chatMessageAdapter.getClass();
        return null;
    }

    private final void l0(b holder, int position, Object msg2) {
        m mVar;
        a aVar;
        View view = holder.itemView;
        if (view instanceof ChatBaseText) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText");
            ((ChatBaseText) view).setRoomId(this.roomId);
            View view2 = holder.itemView;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText");
            ((ChatBaseText) view2).j();
            View view3 = holder.itemView;
            Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatBaseText");
            ((ChatBaseText) view3).setSupportFunc(this.dataSupport, this.playFunc);
        } else if (view instanceof ChatMsgWarpView) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatMsgWarpView");
            ((ChatMsgWarpView) view).setRoomId(this.roomId);
            View view4 = holder.itemView;
            Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatMsgWarpView");
            ((ChatMsgWarpView) view4).a();
            View view5 = holder.itemView;
            Intrinsics.checkNotNull(view5, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatMsgWarpView");
            ((ChatMsgWarpView) view5).setSupportFunc(this.dataSupport, this.playFunc);
        }
        View view6 = holder.itemView;
        if (view6 instanceof ChatSysMsgItemView) {
            if (msg2 instanceof j) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatSysMsgItemView");
                ((ChatSysMsgItemView) view6).l((j) msg2);
            }
        } else if (view6 instanceof ChatTextMsgItemView) {
            if (msg2 instanceof e) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view6).C((e) msg2, this.ownerId);
            } else if (msg2 instanceof FollowPushScreenMessage) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view6).A((FollowPushScreenMessage) msg2, this.ownerId, new Function0<Unit>() { // from class: com.tencent.mobileqq.icgame.widget.chat.adapter.ChatMessageAdapter$innerOnBindViewHolder$1
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
                        ChatMessageAdapter.this.notifyDataSetChanged();
                    }
                });
            } else if (msg2 instanceof w42.b) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view6).z((w42.b) msg2, this.ownerId);
            } else if (msg2 instanceof g) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view6).B((g) msg2, this.ownerId);
            } else if (msg2 instanceof w42.a) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view6).x((w42.a) msg2, this.ownerId);
            } else if (msg2 instanceof j) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view6).I((j) msg2, this.ownerId);
            } else if (msg2 instanceof LiveLocalMsg) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view6).D((LiveLocalMsg) msg2, this.ownerId);
            } else if (msg2 instanceof MessageOuterClass$AnchorRoomBulletScreenMsg) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view6).y((MessageOuterClass$AnchorRoomBulletScreenMsg) msg2, this.ownerId);
            } else if (msg2 instanceof k) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view6).G((k) msg2, this.ownerId);
            }
        } else if (view6 instanceof ChatMsgWarpView) {
            if (msg2 instanceof e) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatMsgWarpView");
                ((ChatMsgWarpView) view6).d((e) msg2, this.ownerId);
            } else if (msg2 instanceof LiveLocalMsg) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatMsgWarpView");
                ((ChatMsgWarpView) view6).e((LiveLocalMsg) msg2, this.ownerId);
            } else if (msg2 instanceof g) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatMsgWarpView");
                ((ChatMsgWarpView) view6).c((g) msg2, this.ownerId);
            } else if (msg2 instanceof MessageOuterClass$AnchorRoomBulletScreenMsg) {
                Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatMsgWarpView");
                ((ChatMsgWarpView) view6).b((MessageOuterClass$AnchorRoomBulletScreenMsg) msg2, this.ownerId);
            }
        } else if (view6 instanceof ChatAnnounceMsgItemView) {
            Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatAnnounceMsgItemView");
            Intrinsics.checkNotNull(msg2, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage");
            ((ChatAnnounceMsgItemView) view6).c((AnnouncePushMessage) msg2, this.roomId, this.dataSupport, this.playFunc);
        } else if (view6 instanceof ChatTeamHintMsgItemView) {
            if (msg2 instanceof m) {
                mVar = (m) msg2;
            } else {
                mVar = null;
            }
            if (mVar == null) {
                return;
            }
            Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTeamHintMsgItemView");
            ((ChatTeamHintMsgItemView) view6).n(mVar, new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.icgame.widget.chat.adapter.ChatMessageAdapter$innerOnBindViewHolder$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke(l3.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j3) {
                    ChatMessageAdapter.i0(ChatMessageAdapter.this);
                }
            });
        } else if (view6 instanceof ChatGiftMsgItemView) {
            Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatGiftMsgItemView");
            Intrinsics.checkNotNull(msg2, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.message.GiftScreenMsg");
            ((ChatGiftMsgItemView) view6).q((GiftScreenMsg) msg2, this.ownerId);
        } else if (view6 instanceof ChatTeamJoinMsgView) {
            Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTeamJoinMsgView");
            Intrinsics.checkNotNull(msg2, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.widget.chat.message.TeamPlayJoinMsg");
            ((ChatTeamJoinMsgView) view6).r((TeamPlayJoinMsg) msg2, this.ownerId);
        }
        if (position == this.dataList.size() - 1 && (aVar = this.updateLastItemListener) != null) {
            aVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return a52.a.a(this.dataList.get(position));
    }

    public final void j0(@NotNull a updateLastItemListener) {
        Intrinsics.checkNotNullParameter(updateLastItemListener, "updateLastItemListener");
        this.updateLastItemListener = updateLastItemListener;
    }

    public final void k0(long roomId, long ownerId, @NotNull List<Object> dataList, @Nullable z42.a dataSupport, @Nullable c playFunc) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.roomId = roomId;
        this.ownerId = ownerId;
        this.dataList = dataList;
        this.dataSupport = dataSupport;
        this.playFunc = playFunc;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object obj = this.dataList.get(position);
        rt0.a.INSTANCE.f(this.TAG, "onBindViewHolder... itemView:" + holder.itemView + " msg:" + obj);
        l0(holder, position, obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Object obj = this.dataList.get(position);
        rt0.a.INSTANCE.g(this.TAG, "onBindViewHolder... itemView:" + holder.itemView + " msg:" + obj, "payloads.isEmpty():" + payloads.isEmpty());
        l0(holder, position, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View chatSysMsgItemView;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 11) {
            if (viewType != 13) {
                switch (viewType) {
                    case 1:
                        chatSysMsgItemView = new ChatMsgWarpView(this.context, null, 0, 6, null);
                        break;
                    case 2:
                    case 3:
                    case 6:
                    case 9:
                        chatSysMsgItemView = new ChatTextMsgItemView(this.context, null, 0, 6, null);
                        break;
                    case 4:
                        chatSysMsgItemView = new ChatAnnounceMsgItemView(this.context, null, 0, 6, null);
                        break;
                    case 5:
                        chatSysMsgItemView = new ChatGiftMsgItemView(this.context, null, 0, 6, null);
                        break;
                    case 7:
                        chatSysMsgItemView = new ChatTeamHintMsgItemView(this.context, null, 0, 6, null);
                        break;
                    case 8:
                        chatSysMsgItemView = new ChatTeamJoinMsgView(this.context, null, 0, 6, null);
                        break;
                    default:
                        switch (viewType) {
                            case 100:
                            case 101:
                                break;
                            case 102:
                                chatSysMsgItemView = new ChatTextMsgItemView(this.context, null, 0, 6, null);
                                break;
                            default:
                                chatSysMsgItemView = new ChatTextMsgItemView(this.context, null, 0, 6, null);
                                break;
                        }
                }
            } else {
                chatSysMsgItemView = new ChatTextMsgItemView(this.context, null, 0, 6, null);
            }
        } else {
            chatSysMsgItemView = new ChatSysMsgItemView(this.context, null, 0, 6, null);
        }
        return new b(this, chatSysMsgItemView);
    }

    public final void p0(@NotNull ChatMessageLayout.d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }
}
