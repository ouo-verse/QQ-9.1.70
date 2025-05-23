package com.tencent.guild.aio.article.msglist.holder.component;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.msglist.holder.component.GuildEmojiSelectState;
import com.tencent.guild.aio.msglist.holder.component.q;
import com.tencent.guild.aio.msglist.reaction.ui.GuildReactionAdapter;
import com.tencent.guild.aio.msglist.reaction.ui.reactionholder.BaseReactionHolder;
import com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt;
import com.tencent.guild.aio.msglist.text.util.c;
import com.tencent.guild.aio.msglist.text.util.f;
import com.tencent.guild.aio.msglist.text.util.j;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import gq0.EmojiReactionItem;
import gq0.EmojiTaskItem;
import gq0.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020\u0013\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J&\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0016J\u0016\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u001a0\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\u0017\u0010%\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/holder/component/a;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "j1", "Ljava/util/ArrayList;", "Lgq0/d;", "Lkotlin/collections/ArrayList;", "newList", "k1", "", "position", "", "", "payloads", "b1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "", "Ljava/lang/Class;", "getObserverStates", "state", "handleUIState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/recyclerview/widget/RecyclerView;", "i1", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", h.F, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "mMsgItem", "Lcom/tencent/guild/aio/msglist/reaction/ui/GuildReactionAdapter;", "i", "Lcom/tencent/guild/aio/msglist/reaction/ui/GuildReactionAdapter;", "reactionAdapter", "Lcom/google/android/flexbox/FlexboxLayoutManager;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/google/android/flexbox/FlexboxLayoutManager;", "mLayoutManager", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "reactionLayout", "Lcom/tencent/guild/aio/msglist/text/util/c;", "D", "Lcom/tencent/guild/aio/msglist/text/util/c;", "mBubbleColorObserverHandle", "<init>", "(Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final RecyclerView reactionLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private c mBubbleColorObserverHandle;

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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/article/msglist/holder/component/a$a", "Lcom/tencent/guild/aio/msglist/text/util/j;", "Lcom/tencent/guild/aio/msglist/reaction/ui/GuildReactionAdapter;", "Landroid/graphics/Bitmap;", "closure", "value", "", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.article.msglist.holder.component.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1177a extends j<GuildReactionAdapter, Bitmap> {
        C1177a(GuildReactionAdapter guildReactionAdapter) {
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
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/guild/aio/article/msglist/holder/component/a$b", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends DiffUtil.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<d> f109994a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<d> f109995b;

        b(ArrayList<d> arrayList, ArrayList<d> arrayList2) {
            this.f109994a = arrayList;
            this.f109995b = arrayList2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics.areEqual(this.f109994a.get(oldItemPosition), this.f109995b.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            if (this.f109994a.get(oldItemPosition).b() == this.f109995b.get(newItemPosition).b()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.f109995b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.f109994a.size();
        }
    }

    public a(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        GuildReactionAdapter guildReactionAdapter = new GuildReactionAdapter(new WeakReference(this));
        this.reactionAdapter = guildReactionAdapter;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(root.getContext());
        flexboxLayoutManager.Z(0);
        flexboxLayoutManager.b0(0);
        this.mLayoutManager = flexboxLayoutManager;
        RecyclerView recyclerView = new RecyclerView(root.getContext());
        recyclerView.setAdapter(guildReactionAdapter);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.reactionLayout = recyclerView;
    }

    private final void j1(com.tencent.aio.data.msglist.a msgItem) {
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
        c cVar = this.mBubbleColorObserverHandle;
        if (cVar != null) {
            cVar.detach();
        }
        this.mBubbleColorObserverHandle = f.f111944a.q(msgItem.isSelf(), lifecycleOwner, new C1177a(this.reactionAdapter));
    }

    private final void k1(ArrayList<d> newList) {
        ArrayList<d> m06 = this.reactionAdapter.m0();
        this.reactionAdapter.w0(newList);
        DiffUtil.calculateDiff(new b(m06, newList), false).dispatchUpdatesTo(this.reactionAdapter);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ce, code lost:
    
        if ((!r11.isEmpty()) != false) goto L30;
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
        if (guildMsgItem.getMsgRecord().emojiLikesList.isEmpty() && g16.isEmpty()) {
            this.reactionLayout.setVisibility(8);
            this.reactionAdapter.m0().clear();
            return;
        }
        this.reactionLayout.setVisibility(0);
        ArrayList<d> arrayList = new ArrayList<>();
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
        k1(arrayList);
        j1(msgItem);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> getViewModel() {
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
    /* renamed from: i1, reason: from getter and merged with bridge method [inline-methods] */
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
        c cVar = this.mBubbleColorObserverHandle;
        if (cVar != null) {
            cVar.detach();
        }
        this.mBubbleColorObserverHandle = null;
        super.onDestroy();
    }
}
