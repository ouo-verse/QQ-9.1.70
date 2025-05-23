package com.tencent.guildmedia.aio.msglist;

import android.util.SparseArray;
import com.tencent.guild.aio.component.combinestyle.GuildMediaCombineStyleItemViewHolder;
import com.tencent.guild.aio.component.combinestyle.ab;
import com.tencent.guild.aio.component.combinestyle.af;
import com.tencent.guild.aio.msglist.holder.component.v;
import com.tencent.guild.aio.msglist.holder.config.GuildItemViewHolderDelegate;
import com.tencent.guildmedia.aio.msglist.item.excellent.GuildMediaExcellentItemViewHolder;
import com.tencent.guildmedia.aio.msglist.item.graytips.GuildMediaCommonGrayTipsItemViewHolder;
import com.tencent.guildmedia.aio.msglist.item.revoke.GuildMediaRevokeItemViewHolder;
import com.tencent.guildmedia.aio.msglist.item.text.GuildMediaReplyTextItemViewHolder;
import com.tencent.guildmedia.aio.msglist.item.text.GuildMediaTextItemViewHolder;
import com.tencent.guildmedia.aio.msglist.item.thirdapp.GuildMediaThirdAppMsgItemViewHolder;
import com.tencent.guildmedia.aio.msglist.item.unsupport.GuildMediaUnsupportedItemViewHolder;
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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/GuildMediaItemViewHolderFactoryProvider;", "Lcom/tencent/guild/aio/component/combinestyle/ab;", "", QQBrowserActivity.KEY_MSG_TYPE, "Lcom/tencent/guild/aio/component/combinestyle/af;", "b", "viewType", "Lcom/tencent/guild/aio/msglist/holder/component/v;", "a", "", "c", "", "Ljava/util/List;", "d", "()Ljava/util/List;", "SUPPORT_LONG_CLICK_VIEW_TYPES", "Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "Lkotlin/Lazy;", "e", "()Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "unsupportedDelegate", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "mItemViewHolderFactoryArray", "getGuildMediaOnlineMsgItemComponentArray", "()Landroid/util/SparseArray;", "f", "(Landroid/util/SparseArray;)V", "guildMediaOnlineMsgItemComponentArray", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaItemViewHolderFactoryProvider implements ab {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildMediaItemViewHolderFactoryProvider f113065a = new GuildMediaItemViewHolderFactoryProvider();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> SUPPORT_LONG_CLICK_VIEW_TYPES;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy unsupportedDelegate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<v> mItemViewHolderFactoryArray;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SparseArray<af> guildMediaOnlineMsgItemComponentArray;

    static {
        List<Integer> listOf;
        Lazy lazy;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{7, 6, 24, 23, 64, 51});
        SUPPORT_LONG_CLICK_VIEW_TYPES = listOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildItemViewHolderDelegate>() { // from class: com.tencent.guildmedia.aio.msglist.GuildMediaItemViewHolderFactoryProvider$unsupportedDelegate$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildItemViewHolderDelegate invoke() {
                return new GuildMediaUnsupportedItemViewHolder().a();
            }
        });
        unsupportedDelegate = lazy;
        SparseArray<v> sparseArray = new SparseArray<>();
        com.tencent.guild.aio.msglist.holder.config.b bVar = new com.tencent.guild.aio.msglist.holder.config.b(new GuildMediaTextItemViewHolder().a());
        sparseArray.put(7, bVar);
        sparseArray.put(6, bVar);
        com.tencent.guild.aio.msglist.holder.config.b bVar2 = new com.tencent.guild.aio.msglist.holder.config.b(new GuildMediaReplyTextItemViewHolder().a());
        sparseArray.put(24, bVar2);
        sparseArray.put(23, bVar2);
        sparseArray.put(56, new com.tencent.guild.aio.msglist.holder.config.b(new GuildMediaCommonGrayTipsItemViewHolder().a()));
        sparseArray.put(64, new com.tencent.guild.aio.msglist.holder.config.b(new GuildMediaThirdAppMsgItemViewHolder().a()));
        sparseArray.put(51, new com.tencent.guild.aio.msglist.holder.config.b(new GuildMediaExcellentItemViewHolder().a()));
        sparseArray.put(50, new com.tencent.guild.aio.msglist.holder.config.b(new GuildMediaRevokeItemViewHolder().a()));
        com.tencent.guild.aio.msglist.holder.config.b bVar3 = new com.tencent.guild.aio.msglist.holder.config.b(new GuildMediaCombineStyleItemViewHolder().a());
        sparseArray.put(30, bVar3);
        sparseArray.put(31, bVar3);
        sparseArray.put(com.tencent.mobileqq.guild.message.a.f230108a.c(), new com.tencent.guild.aio.msglist.holder.config.b(new GuildMediaCombineStyleItemViewHolder().a()));
        mItemViewHolderFactoryArray = sparseArray;
        guildMediaOnlineMsgItemComponentArray = new SparseArray<>();
    }

    GuildMediaItemViewHolderFactoryProvider() {
    }

    private final GuildItemViewHolderDelegate e() {
        return (GuildItemViewHolderDelegate) unsupportedDelegate.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.config.c
    @NotNull
    public v a(int viewType) {
        v vVar = mItemViewHolderFactoryArray.get(viewType);
        if (vVar == null) {
            return new com.tencent.guild.aio.msglist.holder.config.b(e());
        }
        return vVar;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ab
    @Nullable
    public af b(int msgType) {
        return guildMediaOnlineMsgItemComponentArray.get(msgType);
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

    public final void f(@NotNull SparseArray<af> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<set-?>");
        guildMediaOnlineMsgItemComponentArray = sparseArray;
    }
}
