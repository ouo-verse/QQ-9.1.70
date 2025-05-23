package com.tencent.guild.aio.msglist.reaction.ui;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.msglist.holder.component.u;
import com.tencent.guild.aio.msglist.reaction.ui.reactionholder.BaseReactionHolder;
import com.tencent.guild.aio.msglist.reaction.ui.reactionholder.EmojiReactionHolder;
import com.tencent.guild.aio.msglist.reaction.ui.reactionholder.EmojiTaskHolder;
import com.tencent.guild.aio.msglist.reaction.ui.reactionholder.b;
import com.tencent.guild.aio.msglist.reaction.ui.reactionholder.e;
import com.tencent.guild.aio.msglist.reaction.utils.ReactionUtilsKt;
import com.tencent.guild.aio.util.n;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesForRoleCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import fo0.h;
import gq0.EmojiReactionItem;
import gq0.EmojiTaskItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001>B!\u0012\u0018\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,0+0*\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H\u0016J\u001e\u0010\u001a\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00192\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0004H\u0016J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010$\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\u000e\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%J\u000e\u0010)\u001a\u00020(2\u0006\u0010\t\u001a\u00020\u0019R)\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020,0+0*8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R2\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u000602j\b\u0012\u0004\u0012\u00020\u0006`38\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/guild/aio/msglist/reaction/ui/GuildReactionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/BaseReactionHolder;", "Lcom/tencent/guild/aio/msglist/reaction/ui/reactionholder/d;", "", "position", "Lgq0/d;", "n0", "Lgq0/b;", "emojiItem", "", "u0", "k0", "getItemCount", "", "getItemId", "getItemViewType", "emojiId", "emojiType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "t", "Lkotlin/Function0;", "updateUI", "G", "Lgq0/c;", HippyTKDListViewAdapter.X, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "r0", "holder", "p0", "", "", "payloads", "q0", "Lol3/b;", "intent", "v0", "", "l0", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mvi/base/mvi/MviUIState;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/ref/WeakReference;", "o0", "()Ljava/lang/ref/WeakReference;", "parentVB", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "m0", "()Ljava/util/ArrayList;", "w0", "(Ljava/util/ArrayList;)V", "dataList", "<init>", "(Ljava/lang/ref/WeakReference;)V", "D", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildReactionAdapter extends RecyclerView.Adapter<BaseReactionHolder> implements com.tencent.guild.aio.msglist.reaction.ui.reactionholder.d {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<gq0.d> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<com.tencent.aio.base.mvvm.a<ol3.b, MviUIState>> parentVB;

    public GuildReactionAdapter(@NotNull WeakReference<com.tencent.aio.base.mvvm.a<ol3.b, MviUIState>> parentVB) {
        Intrinsics.checkNotNullParameter(parentVB, "parentVB");
        this.parentVB = parentVB;
        this.dataList = new ArrayList<>();
    }

    private final void k0(EmojiReactionItem emojiItem) {
        Object obj;
        MsgRecord g16 = emojiItem.g();
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((gq0.d) obj) instanceof gq0.a) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((gq0.d) obj) == null) {
            this.dataList.add(new gq0.a(g16));
        }
        ArrayList<gq0.d> arrayList = this.dataList;
        arrayList.add(arrayList.size() - 1, emojiItem);
        notifyItemRangeChanged(this.dataList.size() - 1, 1);
    }

    private final gq0.d n0(int position) {
        gq0.d dVar = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(dVar, "dataList[position]");
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void s0(GuildReactionAdapter this$0, int i3, String errMsg, long j3, String str) {
        String str2;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            if (errMsg.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str2 = errMsg;
                ReactionUtilsKt.n(i3, j3, str2);
                if (i3 != 0) {
                    this$0.v0(new u("GuildReactionAdapter"));
                }
                n.a(errMsg + i3 + str + j3, "GuildReactionAdapter");
            }
        }
        str2 = str;
        ReactionUtilsKt.n(i3, j3, str2);
        if (i3 != 0) {
        }
        n.a(errMsg + i3 + str + j3, "GuildReactionAdapter");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void t0(GuildReactionAdapter this$0, int i3, String errMsg, long j3, String str) {
        String str2;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            if (errMsg.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str2 = errMsg;
                ReactionUtilsKt.n(i3, j3, str2);
                if (i3 != 0) {
                    this$0.v0(new u("GuildReactionAdapter"));
                }
                n.a(errMsg + i3 + str + j3, "GuildReactionAdapter");
            }
        }
        str2 = str;
        ReactionUtilsKt.n(i3, j3, str2);
        if (i3 != 0) {
        }
        n.a(errMsg + i3 + str + j3, "GuildReactionAdapter");
    }

    private final void u0(EmojiReactionItem emojiItem) {
        Object obj;
        Object obj2;
        boolean z16;
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (emojiItem.k((gq0.d) obj2)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        gq0.d dVar = (gq0.d) obj2;
        if (dVar != null) {
            int indexOf = this.dataList.indexOf(dVar);
            this.dataList.remove(dVar);
            notifyItemRemoved(indexOf);
        }
        Iterator<T> it5 = this.dataList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            gq0.d dVar2 = (gq0.d) next;
            if (!(dVar2 instanceof EmojiReactionItem) && !(dVar2 instanceof EmojiTaskItem)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        if (((gq0.d) obj) == null) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.dataList, (Function1) new Function1<gq0.d, Boolean>() { // from class: com.tencent.guild.aio.msglist.reaction.ui.GuildReactionAdapter$removeEmojiReactionItem$4$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull gq0.d it6) {
                    Intrinsics.checkNotNullParameter(it6, "it");
                    return Boolean.valueOf(it6 instanceof gq0.a);
                }
            });
            notifyItemRemoved(this.dataList.size());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.guild.aio.msglist.reaction.ui.reactionholder.d
    public void G(@NotNull EmojiReactionItem emojiItem, @NotNull Function0<Unit> updateUI) {
        Intrinsics.checkNotNullParameter(emojiItem, "emojiItem");
        Intrinsics.checkNotNullParameter(updateUI, "updateUI");
        String str = emojiItem.g().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "emojiItem.msg.guildId");
        String str2 = emojiItem.g().channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "emojiItem.msg.channelId");
        if (GuildSpeakLimitStatus.INSTANCE.F(h.a(str, str2))) {
            g.b(R.string.f1384809o);
            return;
        }
        emojiItem.h();
        if (emojiItem.getEmojiLikeCnt() <= 0) {
            u0(emojiItem);
        }
        updateUI.invoke();
        MsgRecord g16 = emojiItem.g();
        String valueOf = String.valueOf(ReactionUtilsKt.a(emojiItem.getEmojiLocalId(), emojiItem.getEmojiType()));
        long emojiType = emojiItem.getEmojiType();
        boolean emojiIsClicked = emojiItem.getEmojiIsClicked();
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str3 = emojiItem.g().channelId;
        Intrinsics.checkNotNullExpressionValue(str3, "emojiItem.msg.channelId");
        String str4 = emojiItem.g().guildId;
        Intrinsics.checkNotNullExpressionValue(str4, "emojiItem.msg.guildId");
        ReactionUtilsKt.l(g16, valueOf, emojiType, 0L, 0L, emojiIsClicked, iGuildChannelApi.isSelfGuest(str3, str4), new ISetMsgEmojiLikesForRoleCallback() { // from class: com.tencent.guild.aio.msglist.reaction.ui.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesForRoleCallback
            public final void onResult(int i3, String str5, long j3, String str6) {
                GuildReactionAdapter.s0(GuildReactionAdapter.this, i3, str5, j3, str6);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return n0(position).b();
    }

    public final boolean l0(@NotNull EmojiTaskItem emojiItem) {
        Intrinsics.checkNotNullParameter(emojiItem, "emojiItem");
        if (!emojiItem.getIsMultiple() && !emojiItem.getEmojiIsClicked()) {
            for (gq0.d dVar : this.dataList) {
                if (dVar instanceof EmojiTaskItem) {
                    EmojiTaskItem emojiTaskItem = (EmojiTaskItem) dVar;
                    if (!emojiTaskItem.n(emojiItem) && emojiTaskItem.getEmojiIsClicked()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @NotNull
    public final ArrayList<gq0.d> m0() {
        return this.dataList;
    }

    @NotNull
    public final WeakReference<com.tencent.aio.base.mvvm.a<ol3.b, MviUIState>> o0() {
        return this.parentVB;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull BaseReactionHolder holder, int position) {
        List<? extends Object> emptyList;
        Intrinsics.checkNotNullParameter(holder, "holder");
        gq0.d n06 = n0(position);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        holder.n(n06, emptyList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull BaseReactionHolder holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.n(n0(position), payloads);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public BaseReactionHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            if (viewType != 2) {
                if (viewType != 3) {
                    if (viewType == 4) {
                        EmojiTaskHolder.Companion companion = EmojiTaskHolder.INSTANCE;
                        Context context = parent.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                        return new EmojiTaskHolder(companion.a(context), this);
                    }
                    throw new IllegalArgumentException("Unknown viewType: " + viewType);
                }
                b.Companion companion2 = com.tencent.guild.aio.msglist.reaction.ui.reactionholder.b.INSTANCE;
                Context context2 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                return new com.tencent.guild.aio.msglist.reaction.ui.reactionholder.b(companion2.a(context2), this);
            }
            e.Companion companion3 = com.tencent.guild.aio.msglist.reaction.ui.reactionholder.e.INSTANCE;
            Context context3 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
            return new com.tencent.guild.aio.msglist.reaction.ui.reactionholder.e(companion3.a(context3), this);
        }
        EmojiReactionHolder.Companion companion4 = EmojiReactionHolder.INSTANCE;
        Context context4 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "parent.context");
        return new EmojiReactionHolder(companion4.a(context4), this);
    }

    @Override // com.tencent.guild.aio.msglist.reaction.ui.reactionholder.d
    public void t(int emojiId, int emojiType, @NotNull MsgRecord msg2) {
        Unit unit;
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        String str = msg2.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msg.guildId");
        String str2 = msg2.channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "msg.channelId");
        if (GuildSpeakLimitStatus.INSTANCE.F(h.a(str, str2))) {
            g.b(R.string.f1384809o);
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildReactionAdapter", 2, "onEmojiSelected id:" + emojiId + ", type:" + emojiType + ", msgseq:" + msg2.msgSeq + ", dataListSize:" + m0().size());
        }
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            unit = null;
            if (it.hasNext()) {
                obj = it.next();
                gq0.d dVar = (gq0.d) obj;
                if (((dVar instanceof EmojiReactionItem) && ((EmojiReactionItem) dVar).i(emojiId, emojiType)) || ((dVar instanceof EmojiTaskItem) && ((EmojiTaskItem) dVar).l(emojiId, emojiType))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        final gq0.d dVar2 = (gq0.d) obj;
        if (dVar2 != null) {
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("GuildReactionAdapter", 2, "onEmojiSelected findItem type:" + dVar2.b());
            }
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.reaction.ui.GuildReactionAdapter$onEmojiSelected$3$updateUI$1
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
                    GuildReactionAdapter guildReactionAdapter = GuildReactionAdapter.this;
                    guildReactionAdapter.notifyItemChanged(guildReactionAdapter.m0().indexOf(dVar2));
                }
            };
            if (dVar2 instanceof EmojiReactionItem) {
                EmojiReactionItem emojiReactionItem = (EmojiReactionItem) dVar2;
                if (!emojiReactionItem.getEmojiIsClicked()) {
                    G(emojiReactionItem, function0);
                    unit = Unit.INSTANCE;
                }
            }
            if (dVar2 instanceof EmojiTaskItem) {
                EmojiTaskItem emojiTaskItem = (EmojiTaskItem) dVar2;
                if (!emojiTaskItem.getEmojiIsClicked()) {
                    x(emojiTaskItem, function0);
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            if (msg2.emojiLikesList.size() >= 20) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f143480m7, 0).show();
                return;
            }
            final EmojiReactionItem emojiReactionItem2 = new EmojiReactionItem(false, emojiType, 0L, emojiId, msg2);
            k0(emojiReactionItem2);
            G(emojiReactionItem2, new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.reaction.ui.GuildReactionAdapter$onEmojiSelected$4$1
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
                    GuildReactionAdapter guildReactionAdapter = GuildReactionAdapter.this;
                    guildReactionAdapter.notifyItemChanged(guildReactionAdapter.m0().indexOf(emojiReactionItem2));
                }
            });
        }
    }

    public final void v0(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        com.tencent.aio.base.mvvm.a<ol3.b, MviUIState> aVar = this.parentVB.get();
        if (aVar != null) {
            aVar.sendIntent(intent);
        }
    }

    public final void w0(@NotNull ArrayList<gq0.d> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.dataList = arrayList;
    }

    @Override // com.tencent.guild.aio.msglist.reaction.ui.reactionholder.d
    public void x(@NotNull EmojiTaskItem emojiItem, @NotNull Function0<Unit> updateUI) {
        Intrinsics.checkNotNullParameter(emojiItem, "emojiItem");
        Intrinsics.checkNotNullParameter(updateUI, "updateUI");
        if (!l0(emojiItem)) {
            QQToast.makeText(BaseApplication.context, R.string.f143490m8, 0).show();
            return;
        }
        emojiItem.k();
        updateUI.invoke();
        MsgRecord g16 = emojiItem.g();
        String valueOf = String.valueOf(ReactionUtilsKt.a(emojiItem.getEmojiLocalId(), emojiItem.getEmojiType()));
        long emojiType = emojiItem.getEmojiType();
        long taskId = emojiItem.getTaskId();
        long taskType = emojiItem.getTaskType();
        boolean emojiIsClicked = emojiItem.getEmojiIsClicked();
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = emojiItem.g().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "emojiItem.msg.channelId");
        String str2 = emojiItem.g().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "emojiItem.msg.guildId");
        ReactionUtilsKt.l(g16, valueOf, emojiType, taskId, taskType, emojiIsClicked, iGuildChannelApi.isSelfGuest(str, str2), new ISetMsgEmojiLikesForRoleCallback() { // from class: com.tencent.guild.aio.msglist.reaction.ui.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesForRoleCallback
            public final void onResult(int i3, String str3, long j3, String str4) {
                GuildReactionAdapter.t0(GuildReactionAdapter.this, i3, str3, j3, str4);
            }
        });
    }
}
