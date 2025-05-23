package com.tencent.guildmedia.aio.excellentdetail;

import android.util.SparseArray;
import com.tencent.guild.aio.msglist.holder.component.v;
import com.tencent.guild.aio.msglist.holder.config.GuildItemViewHolderDelegate;
import com.tencent.guild.aio.msglist.holder.config.b;
import com.tencent.guild.aio.msglist.holder.config.c;
import com.tencent.guildmedia.aio.excellentdetail.msglist.GuildMediaAnnounceTextItemViewHolder;
import com.tencent.guildmedia.aio.msglist.item.unsupport.GuildMediaUnsupportedItemViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guildmedia/aio/excellentdetail/GuildMediaAnnounceDetailVHFactoryProvider;", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "", "viewType", "Lcom/tencent/guild/aio/msglist/holder/component/v;", "a", "Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "b", "Lkotlin/Lazy;", "c", "()Lcom/tencent/guild/aio/msglist/holder/config/GuildItemViewHolderDelegate;", "unsupportedDelegate", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "mItemViewHolderFactoryArray", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaAnnounceDetailVHFactoryProvider implements c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildMediaAnnounceDetailVHFactoryProvider f112979a = new GuildMediaAnnounceDetailVHFactoryProvider();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy unsupportedDelegate;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<v> mItemViewHolderFactoryArray;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildItemViewHolderDelegate>() { // from class: com.tencent.guildmedia.aio.excellentdetail.GuildMediaAnnounceDetailVHFactoryProvider$unsupportedDelegate$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildItemViewHolderDelegate invoke() {
                return new GuildMediaUnsupportedItemViewHolder().a();
            }
        });
        unsupportedDelegate = lazy;
        SparseArray<v> sparseArray = new SparseArray<>();
        b bVar = new b(new GuildMediaAnnounceTextItemViewHolder().a());
        sparseArray.put(7, bVar);
        sparseArray.put(6, bVar);
        sparseArray.put(24, bVar);
        sparseArray.put(23, bVar);
        mItemViewHolderFactoryArray = sparseArray;
    }

    GuildMediaAnnounceDetailVHFactoryProvider() {
    }

    private final GuildItemViewHolderDelegate c() {
        return (GuildItemViewHolderDelegate) unsupportedDelegate.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.config.c
    @NotNull
    public v a(int viewType) {
        v vVar = mItemViewHolderFactoryArray.get(viewType);
        if (vVar == null) {
            return new b(c());
        }
        return vVar;
    }
}
