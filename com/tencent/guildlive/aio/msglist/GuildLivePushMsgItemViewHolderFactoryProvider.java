package com.tencent.guildlive.aio.msglist;

import android.util.SparseArray;
import com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleItemViewHolder;
import com.tencent.guild.aio.component.combinestyle.ab;
import com.tencent.guild.aio.component.combinestyle.af;
import com.tencent.guild.aio.msglist.holder.component.v;
import com.tencent.guild.aio.msglist.holder.config.GuildItemViewHolderDelegate;
import com.tencent.guildlive.aio.msglist.item.excellent.GuildLiveExcellentItemViewHolder;
import com.tencent.guildlive.aio.msglist.item.graytips.GuildLiveCommonGrayTipsItemViewHolder;
import com.tencent.guildlive.aio.msglist.item.redpacket.GuildLiveRedPacketItemViewHolder;
import com.tencent.guildlive.aio.msglist.item.redpacket.GuildLiveUnSupportRedPacketTipsItemViewHolder;
import com.tencent.guildlive.aio.msglist.item.revoke.GuildLiveRevokeItemViewHolder;
import com.tencent.guildlive.aio.msglist.item.text.GuildLiveReplyTextItemViewHolder;
import com.tencent.guildlive.aio.msglist.item.text.GuildLiveTextItemViewHolder;
import com.tencent.guildlive.aio.msglist.item.unsupport.GuildLiveUnsupportedItemViewHolder;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/GuildLivePushMsgItemViewHolderFactoryProvider;", "Lcom/tencent/guild/aio/component/combinestyle/ab;", "", QQBrowserActivity.KEY_MSG_TYPE, "Lcom/tencent/guild/aio/component/combinestyle/af;", "b", "viewType", "Lcom/tencent/guild/aio/msglist/holder/component/v;", "a", "", "c", "", "Ljava/util/List;", "d", "()Ljava/util/List;", "SUPPORT_LONG_CLICK_VIEW_TYPES", "e", "SUPPORT_SELECT_VIEW_TYPES", "Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "Lkotlin/Lazy;", "f", "()Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "unsupportedDelegate", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "mItemViewHolderFactoryArray", "getComponents", "()Landroid/util/SparseArray;", "g", "(Landroid/util/SparseArray;)V", "components", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLivePushMsgItemViewHolderFactoryProvider implements ab {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildLivePushMsgItemViewHolderFactoryProvider f112780a = new GuildLivePushMsgItemViewHolderFactoryProvider();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> SUPPORT_LONG_CLICK_VIEW_TYPES;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> SUPPORT_SELECT_VIEW_TYPES;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy unsupportedDelegate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<v> mItemViewHolderFactoryArray;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SparseArray<af> components;

    static {
        List<Integer> listOf;
        List<Integer> listOf2;
        Lazy lazy;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{7, 6, 24, 23, 27, 28, 43, 42, 51});
        SUPPORT_LONG_CLICK_VIEW_TYPES = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{7, 6, 24, 23, 27, 28, 43, 42});
        SUPPORT_SELECT_VIEW_TYPES = listOf2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildItemViewHolderDelegate>() { // from class: com.tencent.guildlive.aio.msglist.GuildLivePushMsgItemViewHolderFactoryProvider$unsupportedDelegate$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildItemViewHolderDelegate invoke() {
                return new GuildLiveUnsupportedItemViewHolder().a();
            }
        });
        unsupportedDelegate = lazy;
        SparseArray<v> sparseArray = new SparseArray<>();
        com.tencent.guild.aio.msglist.holder.config.b bVar = new com.tencent.guild.aio.msglist.holder.config.b(new GuildLiveTextItemViewHolder().a());
        sparseArray.put(7, bVar);
        sparseArray.put(6, bVar);
        com.tencent.guild.aio.msglist.holder.config.b bVar2 = new com.tencent.guild.aio.msglist.holder.config.b(new GuildLiveReplyTextItemViewHolder().a());
        sparseArray.put(24, bVar2);
        sparseArray.put(23, bVar2);
        com.tencent.mobileqq.guild.message.a aVar = com.tencent.mobileqq.guild.message.a.f230108a;
        sparseArray.put(aVar.b(), new com.tencent.guild.aio.msglist.holder.config.b(new GuildMediaCombineStyleItemViewHolder().a()));
        com.tencent.guild.aio.msglist.holder.config.b bVar3 = new com.tencent.guild.aio.msglist.holder.config.b(new GuildMediaCombineStyleItemViewHolder().a());
        sparseArray.put(30, bVar3);
        sparseArray.put(31, bVar3);
        com.tencent.guild.aio.msglist.holder.config.b bVar4 = new com.tencent.guild.aio.msglist.holder.config.b(new GuildLiveRedPacketItemViewHolder().a());
        sparseArray.put(27, bVar4);
        sparseArray.put(28, bVar4);
        sparseArray.put(43, bVar4);
        sparseArray.put(42, bVar4);
        sparseArray.put(56, new com.tencent.guild.aio.msglist.holder.config.b(new GuildLiveCommonGrayTipsItemViewHolder().a()));
        sparseArray.put(51, new com.tencent.guild.aio.msglist.holder.config.b(new GuildLiveExcellentItemViewHolder().a()));
        com.tencent.guild.aio.msglist.holder.config.b bVar5 = new com.tencent.guild.aio.msglist.holder.config.b(new GuildLiveUnSupportRedPacketTipsItemViewHolder().a());
        sparseArray.put(45, bVar5);
        sparseArray.put(44, bVar5);
        sparseArray.put(50, new com.tencent.guild.aio.msglist.holder.config.b(new GuildLiveRevokeItemViewHolder().a()));
        sparseArray.put(aVar.c(), new com.tencent.guild.aio.msglist.holder.config.b(new GuildMediaCombineStyleItemViewHolder().a()));
        mItemViewHolderFactoryArray = sparseArray;
        components = new SparseArray<>();
    }

    GuildLivePushMsgItemViewHolderFactoryProvider() {
    }

    private final GuildItemViewHolderDelegate f() {
        return (GuildItemViewHolderDelegate) unsupportedDelegate.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.config.c
    @NotNull
    public v a(int viewType) {
        v vVar = mItemViewHolderFactoryArray.get(viewType);
        if (vVar == null) {
            return new com.tencent.guild.aio.msglist.holder.config.b(f());
        }
        return vVar;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ab
    @Nullable
    public af b(int msgType) {
        return components.get(msgType);
    }

    public final boolean c(int viewType) {
        if (mItemViewHolderFactoryArray.indexOfKey(viewType) >= 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<Integer> d() {
        return SUPPORT_LONG_CLICK_VIEW_TYPES;
    }

    @NotNull
    public final List<Integer> e() {
        return SUPPORT_SELECT_VIEW_TYPES;
    }

    public final void g(@NotNull SparseArray<af> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<set-?>");
        components = sparseArray;
    }
}
