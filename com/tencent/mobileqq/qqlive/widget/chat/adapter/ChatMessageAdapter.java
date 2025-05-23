package com.tencent.mobileqq.qqlive.widget.chat.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.qqlive.widget.chat.font.FontSize;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatAnnounceMsgItemView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatGiftMsgItemView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatMsgWarpView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatSysMsgItemView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTeamHintMsgItemView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTeamJoinMsgView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView;
import com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatWishHelpItemView;
import com.tencent.mobileqq.qqlive.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.qqlive.widget.chat.message.d;
import com.tencent.mobileqq.qqlive.widget.chat.message.e;
import com.tencent.mobileqq.qqlive.widget.chat.message.g;
import com.tencent.mobileqq.qqlive.widget.chat.message.j;
import com.tencent.mobileqq.qqlive.widget.chat.message.k;
import com.tencent.mobileqq.qqlive.widget.chat.message.l;
import com.tencent.mobileqq.qqlive.widget.chat.message.n;
import com.tencent.mobileqq.qqlive.widget.chat.message.o;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$AnchorRoomBulletScreenMsg;
import vi2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002CDB\u000f\u0012\u0006\u0010-\u001a\u00020(\u00a2\u0006\u0004\bA\u0010BJ$\u0010\t\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J8\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\nJ\u001c\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0004H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J*\u0010&\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016J\u001c\u0010'\u001a\u00020\b2\n\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00103\u001a\u00020.8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00105R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/adapter/ChatMessageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/qqlive/widget/chat/adapter/ChatMessageAdapter$b;", "holder", "", "position", "", "msg", "", "n0", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "k0", "m0", "", "roomId", "ownerId", "", "dataList", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "l0", "Lcom/tencent/mobileqq/qqlive/widget/chat/adapter/ChatMessageAdapter$a;", "updateLastItemListener", "j0", "Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout$e;", "listener", "r0", "fontSize", "s0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "q0", "getItemViewType", "getItemCount", "payloads", "p0", "o0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "D", "J", "E", UserInfo.SEX_FEMALE, "Ljava/util/List;", "G", "Lcom/tencent/mobileqq/qqlive/widget/chat/adapter/ChatMessageAdapter$a;", "H", "Lvi2/a;", "I", "Lvi2/c;", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "currentFontSize", "<init>", "(Landroid/content/Context;)V", "a", "b", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ChatMessageAdapter extends RecyclerView.Adapter<b> {
    static IPatchRedirector $redirector_;

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
    private vi2.a dataSupport;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private c playFunc;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private FontSize currentFontSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/adapter/ChatMessageAdapter$a;", "", "", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/adapter/ChatMessageAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/qqlive/widget/chat/adapter/ChatMessageAdapter;Landroid/view/View;)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        final /* synthetic */ ChatMessageAdapter E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull ChatMessageAdapter chatMessageAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = chatMessageAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatMessageAdapter, (Object) itemView);
            }
        }
    }

    public ChatMessageAdapter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.TAG = "Chat_Message|ChatMessageAdapter";
        this.dataList = new ArrayList();
        this.currentFontSize = FontSize.STANDARD;
    }

    public static final /* synthetic */ ChatMessageLayout.e i0(ChatMessageAdapter chatMessageAdapter) {
        chatMessageAdapter.getClass();
        return null;
    }

    private final FontSize k0() {
        vi2.a aVar = this.dataSupport;
        boolean z16 = false;
        if (aVar != null && aVar.b()) {
            z16 = true;
        }
        if (z16) {
            return this.currentFontSize;
        }
        return FontSize.STANDARD;
    }

    private final void m0() {
        FontSize fontSize;
        vi2.a aVar = this.dataSupport;
        boolean z16 = false;
        if (aVar != null && aVar.b()) {
            z16 = true;
        }
        if (z16) {
            fontSize = com.tencent.mobileqq.qqlive.widget.chat.font.a.f273775a.a();
        } else {
            fontSize = FontSize.STANDARD;
        }
        this.currentFontSize = fontSize;
    }

    private final void n0(b holder, int position, Object msg2) {
        l lVar;
        a aVar;
        View view = holder.itemView;
        if (view instanceof ChatBaseText) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText");
            ((ChatBaseText) view).setRoomId(this.roomId);
            View view2 = holder.itemView;
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText");
            ((ChatBaseText) view2).k();
            View view3 = holder.itemView;
            Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText");
            ((ChatBaseText) view3).setSupportFunc(this.dataSupport, this.playFunc);
            View view4 = holder.itemView;
            Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatBaseText");
            ((ChatBaseText) view4).setFontSize(k0());
        } else if (view instanceof ChatMsgWarpView) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatMsgWarpView");
            ((ChatMsgWarpView) view).setRoomId(this.roomId);
            View view5 = holder.itemView;
            Intrinsics.checkNotNull(view5, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatMsgWarpView");
            ((ChatMsgWarpView) view5).b();
            View view6 = holder.itemView;
            Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatMsgWarpView");
            ((ChatMsgWarpView) view6).setSupportFunc(this.dataSupport, this.playFunc);
            View view7 = holder.itemView;
            Intrinsics.checkNotNull(view7, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatMsgWarpView");
            ((ChatMsgWarpView) view7).setFontSize(k0());
        } else if (view instanceof ChatAnnounceMsgItemView) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatAnnounceMsgItemView");
            ((ChatAnnounceMsgItemView) view).setFontSize(k0());
        } else if (view instanceof ChatWishHelpItemView) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatWishHelpItemView");
            ((ChatWishHelpItemView) view).setFontSize(k0());
        }
        View view8 = holder.itemView;
        if (view8 instanceof ChatSysMsgItemView) {
            if (msg2 instanceof j) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatSysMsgItemView");
                ((ChatSysMsgItemView) view8).m((j) msg2);
            }
        } else if (view8 instanceof ChatTextMsgItemView) {
            if (msg2 instanceof e) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view8).G((e) msg2, this.ownerId);
            } else if (msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.c) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view8).E((com.tencent.mobileqq.qqlive.widget.chat.message.c) msg2, this.ownerId, new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.widget.chat.adapter.ChatMessageAdapter$innerOnBindViewHolder$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatMessageAdapter.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            ChatMessageAdapter.this.notifyDataSetChanged();
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                });
            } else if (msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.b) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view8).D((com.tencent.mobileqq.qqlive.widget.chat.message.b) msg2, this.ownerId);
            } else if (msg2 instanceof g) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view8).F((g) msg2, this.ownerId);
            } else if (msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.a) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view8).B((com.tencent.mobileqq.qqlive.widget.chat.message.a) msg2, this.ownerId);
            } else if (msg2 instanceof j) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view8).J((j) msg2, this.ownerId);
            } else if (msg2 instanceof LiveLocalMsg) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view8).H((LiveLocalMsg) msg2, this.ownerId);
            } else if (msg2 instanceof MessageOuterClass$AnchorRoomBulletScreenMsg) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view8).C((MessageOuterClass$AnchorRoomBulletScreenMsg) msg2, this.ownerId);
            } else if (msg2 instanceof n) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTextMsgItemView");
                ((ChatTextMsgItemView) view8).K((n) msg2, this.ownerId);
            }
        } else if (view8 instanceof ChatMsgWarpView) {
            if (msg2 instanceof e) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatMsgWarpView");
                ((ChatMsgWarpView) view8).f((e) msg2, this.ownerId);
            } else if (msg2 instanceof LiveLocalMsg) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatMsgWarpView");
                ((ChatMsgWarpView) view8).g((LiveLocalMsg) msg2, this.ownerId);
            } else if (msg2 instanceof g) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatMsgWarpView");
                ((ChatMsgWarpView) view8).e((g) msg2, this.ownerId);
            } else if (msg2 instanceof MessageOuterClass$AnchorRoomBulletScreenMsg) {
                Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatMsgWarpView");
                ((ChatMsgWarpView) view8).d((MessageOuterClass$AnchorRoomBulletScreenMsg) msg2, this.ownerId);
            }
        } else if (view8 instanceof ChatAnnounceMsgItemView) {
            Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatAnnounceMsgItemView");
            Intrinsics.checkNotNull(msg2, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage");
            ((ChatAnnounceMsgItemView) view8).c((AnnouncePushMessage) msg2, this.roomId, this.dataSupport, this.playFunc);
        } else if (view8 instanceof ChatTeamHintMsgItemView) {
            if (msg2 instanceof l) {
                lVar = (l) msg2;
            } else {
                lVar = null;
            }
            if (lVar == null) {
                return;
            }
            Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTeamHintMsgItemView");
            ((ChatTeamHintMsgItemView) view8).o(lVar, new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.qqlive.widget.chat.adapter.ChatMessageAdapter$innerOnBindViewHolder$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatMessageAdapter.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke(l3.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ChatMessageAdapter.i0(ChatMessageAdapter.this);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, j3);
                    }
                }
            });
        } else if (view8 instanceof ChatGiftMsgItemView) {
            Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatGiftMsgItemView");
            Intrinsics.checkNotNull(msg2, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.message.GiftScreenMsg");
            ((ChatGiftMsgItemView) view8).y((d) msg2, this.ownerId);
        } else if (view8 instanceof ChatTeamJoinMsgView) {
            Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTeamJoinMsgView");
            Intrinsics.checkNotNull(msg2, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.message.TeamPlayJoinMsg");
            ((ChatTeamJoinMsgView) view8).t((k) msg2, this.ownerId);
        } else if (view8 instanceof ChatWishHelpItemView) {
            Intrinsics.checkNotNull(view8, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatWishHelpItemView");
            Intrinsics.checkNotNull(msg2, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.widget.chat.message.WishScreenHelpMessage");
            ((ChatWishHelpItemView) view8).c((o) msg2, this.roomId, this.ownerId, this.dataSupport, this.playFunc);
        }
        if (position == this.dataList.size() - 1 && (aVar = this.updateLastItemListener) != null) {
            aVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, position)).intValue();
        }
        return com.tencent.mobileqq.qqlive.widget.chat.util.a.a(this.dataList.get(position));
    }

    public final void j0(@NotNull a updateLastItemListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) updateLastItemListener);
        } else {
            Intrinsics.checkNotNullParameter(updateLastItemListener, "updateLastItemListener");
            this.updateLastItemListener = updateLastItemListener;
        }
    }

    public final void l0(long roomId, long ownerId, @NotNull List<Object> dataList, @Nullable vi2.a dataSupport, @Nullable c playFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(roomId), Long.valueOf(ownerId), dataList, dataSupport, playFunc);
            return;
        }
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.roomId = roomId;
        this.ownerId = ownerId;
        this.dataList = dataList;
        this.dataSupport = dataSupport;
        this.playFunc = playFunc;
        m0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Object obj = this.dataList.get(position);
        AegisLogger.INSTANCE.d(this.TAG, "onBindViewHolder... itemView:" + holder.itemView + " msg:" + obj);
        n0(holder, position, obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Object obj = this.dataList.get(position);
        AegisLogger.INSTANCE.d(this.TAG, "onBindViewHolder... itemView:" + holder.itemView + " msg:" + obj, "payloads.isEmpty():" + payloads.isEmpty());
        n0(holder, position, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View chatSysMsgItemView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 11) {
            if (viewType != 12) {
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
                chatSysMsgItemView = new ChatWishHelpItemView(this.context);
            }
        } else {
            chatSysMsgItemView = new ChatSysMsgItemView(this.context, null, 0, 6, null);
        }
        chatSysMsgItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new b(this, chatSysMsgItemView);
    }

    public final void r0(@NotNull ChatMessageLayout.e listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
        }
    }

    public final void s0(@NotNull FontSize fontSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fontSize);
            return;
        }
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        this.currentFontSize = fontSize;
        notifyDataSetChanged();
    }
}
