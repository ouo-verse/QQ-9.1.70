package com.tencent.guild.aio.msglist.holder.component;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.msglist.reaction.ui.GuildReactionAdapter;
import com.tencent.guild.aio.msglist.reaction.ui.reactionholder.BaseReactionHolder;
import com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import gq0.EmojiReactionItem;
import gq0.EmojiTaskItem;
import gq0.ReplyReactionItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001BB\u000f\u0012\u0006\u0010,\u001a\u00020\u0019\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J(\u0010\u0010\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J&\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0016\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001d0#0\"H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020&H\u0016R\u0017\u0010,\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/p;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/guild/aio/msglist/reaction/ui/GuildReactionAdapter;", "l1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", ICustomDataEditor.NUMBER_PARAM_1, "Ljava/util/ArrayList;", "Lgq0/d;", "Lkotlin/collections/ArrayList;", "newList", "o1", "list", "", "guildId", "m1", "", "position", "", "", "payloads", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "bindViewAndData", "state", "handleUIState", "", "Ljava/lang/Class;", "getObserverStates", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/recyclerview/widget/RecyclerView;", "k1", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", tl.h.F, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "mMsgItem", "i", "Lcom/tencent/guild/aio/msglist/reaction/ui/GuildReactionAdapter;", "reactionAdapter", "Lcom/google/android/flexbox/FlexboxLayoutManager;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/google/android/flexbox/FlexboxLayoutManager;", "mLayoutManager", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "reactionLayout", "Lcom/tencent/guild/aio/msglist/text/util/c;", "D", "Lcom/tencent/guild/aio/msglist/text/util/c;", "mBubbleColorObserverHandle", "<init>", "(Landroid/view/View;)V", "E", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class p extends a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final RecyclerView reactionLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.guild.aio.msglist.text.util.c mBubbleColorObserverHandle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem mMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildReactionAdapter reactionAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FlexboxLayoutManager mLayoutManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/p$b", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "positionStart", "itemCount", "", "onItemRangeChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.AdapterDataObserver {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount) {
            if (p.this.reactionAdapter.m0().isEmpty()) {
                p.this.reactionLayout.setVisibility(8);
            } else {
                p.this.reactionLayout.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/p$c", "Lcom/tencent/guild/aio/msglist/text/util/j;", "Lcom/tencent/guild/aio/msglist/reaction/ui/GuildReactionAdapter;", "Landroid/graphics/Bitmap;", "closure", "value", "", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends com.tencent.guild.aio.msglist.text.util.j<GuildReactionAdapter, Bitmap> {
        c(GuildReactionAdapter guildReactionAdapter) {
            super(guildReactionAdapter);
        }

        @Override // com.tencent.guild.aio.msglist.text.util.j
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull GuildReactionAdapter closure, @Nullable Bitmap value) {
            Intrinsics.checkNotNullParameter(closure, "closure");
            closure.notifyItemRangeChanged(0, closure.getNUM_BACKGOURND_ICON(), BaseReactionHolder.PayloadType.ITEM_BG_REFRESH_PAYLOAD);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/p$d", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d extends DiffUtil.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<gq0.d> f111663a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<gq0.d> f111664b;

        d(ArrayList<gq0.d> arrayList, ArrayList<gq0.d> arrayList2) {
            this.f111663a = arrayList;
            this.f111664b = arrayList2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics.areEqual(this.f111663a.get(oldItemPosition), this.f111664b.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            if (this.f111663a.get(oldItemPosition).b() == this.f111664b.get(newItemPosition).b()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.f111664b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.f111663a.size();
        }
    }

    public p(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        GuildReactionAdapter l16 = l1();
        this.reactionAdapter = l16;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(root.getContext());
        flexboxLayoutManager.Z(0);
        flexboxLayoutManager.b0(0);
        this.mLayoutManager = flexboxLayoutManager;
        RecyclerView recyclerView = new RecyclerView(root.getContext());
        recyclerView.setAdapter(l16);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        recyclerView.setItemAnimator(null);
        recyclerView.setFocusable(false);
        this.reactionLayout = recyclerView;
    }

    private final GuildReactionAdapter l1() {
        GuildReactionAdapter guildReactionAdapter = new GuildReactionAdapter(new WeakReference(this));
        guildReactionAdapter.registerAdapterDataObserver(new b());
        return guildReactionAdapter;
    }

    private final void m1(ArrayList<gq0.d> list, String guildId) {
        if (!((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).isSafetySwitchOpen(guildId, 11)) {
            Iterator<gq0.d> it = list.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "list.iterator()");
            while (it.hasNext()) {
                gq0.d next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "it.next()");
                gq0.d dVar = next;
                if ((dVar instanceof gq0.a) || (dVar instanceof EmojiReactionItem) || (dVar instanceof EmojiTaskItem)) {
                    it.remove();
                }
            }
        }
    }

    private final void n1(com.tencent.aio.data.msglist.a msgItem) {
        LifecycleOwner lifecycleOwner;
        com.tencent.aio.api.runtime.a f16 = f1();
        if (f16 != null) {
            lifecycleOwner = f16.d();
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner == null) {
            return;
        }
        com.tencent.guild.aio.msglist.text.util.c cVar = this.mBubbleColorObserverHandle;
        if (cVar != null) {
            cVar.detach();
        }
        this.mBubbleColorObserverHandle = com.tencent.guild.aio.msglist.text.util.f.f111944a.q(msgItem.isSelf(), lifecycleOwner, new c(this.reactionAdapter));
    }

    private final void o1(ArrayList<gq0.d> newList) {
        ArrayList<gq0.d> m06 = this.reactionAdapter.m0();
        this.reactionAdapter.w0(newList);
        DiffUtil.calculateDiff(new d(m06, newList), false).dispatchUpdatesTo(this.reactionAdapter);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0162, code lost:
    
        if ((!r13.isEmpty()) != false) goto L41;
     */
    @Override // com.tencent.guild.aio.msglist.holder.component.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Object obj;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        this.mMsgItem = guildMsgItem;
        ArrayList<EmojiTaskItem> g16 = ReactionUtilsKt.g(guildMsgItem);
        if ((guildMsgItem.getMsgRecord().emojiLikesList.isEmpty() && guildMsgItem.getMsgRecord().commentCnt == 0 && g16.isEmpty()) || guildMsgItem.getMsgRecord().sendStatus != 2) {
            this.reactionLayout.setVisibility(8);
            this.reactionAdapter.m0().clear();
            return;
        }
        this.reactionLayout.setVisibility(0);
        ArrayList<gq0.d> arrayList = new ArrayList<>();
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = guildMsgItem.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
        String str2 = guildMsgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        boolean isSelfGuest = iGuildChannelApi.isSelfGuest(str, str2);
        if (QLog.isColorLevel()) {
            QLog.d("GuildBubbleReactionComponent", 2, "msgId=" + msgItem.getMsgId() + " cnt=" + ((GuildMsgItem) msgItem).getMsgRecord().commentCnt + " guest=" + isSelfGuest);
        }
        if (ReactionUtilsKt.k(guildMsgItem.getMsgRecord()) && !isSelfGuest) {
            arrayList.add(new ReplyReactionItem(guildMsgItem.getMsgRecord().commentCnt, guildMsgItem.getMsgRecord()));
        }
        arrayList.addAll(g16);
        Intrinsics.checkNotNullExpressionValue(guildMsgItem.getMsgRecord().emojiLikesList, "msgItem.msgRecord.emojiLikesList");
        if (!r1.isEmpty()) {
            ArrayList<MsgEmojiLikes> arrayList2 = guildMsgItem.getMsgRecord().emojiLikesList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "msgItem.msgRecord.emojiLikesList");
            for (MsgEmojiLikes emoji : arrayList2) {
                Iterator<T> it = g16.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        Intrinsics.checkNotNullExpressionValue(emoji, "emoji");
                        if (((EmojiTaskItem) obj).m(emoji)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                EmojiTaskItem emojiTaskItem = (EmojiTaskItem) obj;
                if (emojiTaskItem != null) {
                    emojiTaskItem.o(emoji.isClicked);
                    emojiTaskItem.p(emoji.likesCnt);
                } else {
                    Intrinsics.checkNotNullExpressionValue(emoji, "emoji");
                    EmojiReactionItem o16 = ReactionUtilsKt.o(emoji, guildMsgItem.getMsgRecord());
                    if (o16.getEmojiLocalId() != -1) {
                        arrayList.add(o16);
                    }
                }
            }
        }
        if (!(!g16.isEmpty())) {
            Intrinsics.checkNotNullExpressionValue(guildMsgItem.getMsgRecord().emojiLikesList, "msgItem.msgRecord.emojiLikesList");
        }
        arrayList.add(new gq0.a(guildMsgItem.getMsgRecord()));
        String str3 = guildMsgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.guildId");
        m1(arrayList, str3);
        o1(arrayList);
        n1(msgItem);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new q();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends MviUIState>> getObserverStates() {
        List<Class<? extends MviUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildEmojiSelectState.class);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        MsgRecord msgRecord;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildEmojiSelectState) {
            GuildMsgItem guildMsgItem = this.mMsgItem;
            boolean z16 = false;
            if (guildMsgItem != null && (msgRecord = guildMsgItem.getMsgRecord()) != null && msgRecord.msgId == ((GuildEmojiSelectState) state).getMsg().msgId) {
                z16 = true;
            }
            if (z16) {
                GuildEmojiSelectState guildEmojiSelectState = (GuildEmojiSelectState) state;
                this.reactionAdapter.t(guildEmojiSelectState.getEmojiId(), guildEmojiSelectState.getEmojiType(), guildEmojiSelectState.getMsg());
            }
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: k1, reason: from getter and merged with bridge method [inline-methods] */
    public RecyclerView d1() {
        return this.reactionLayout;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        com.tencent.guild.aio.msglist.text.util.c cVar = this.mBubbleColorObserverHandle;
        if (cVar != null) {
            cVar.detach();
        }
        this.mBubbleColorObserverHandle = null;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
    }
}
