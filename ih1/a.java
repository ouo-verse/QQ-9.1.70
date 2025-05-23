package ih1;

import androidx.core.os.BundleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.discovery.avblockdetail.model.GuildRecommendCardItem;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.delegates.GuildRecommendGuildCardDelegate;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendGuildNewCardDelegate;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import com.tencent.mobileqq.guild.widget.adapterdelegates.i;
import gh1.b;
import java.util.List;
import jh1.ExtraData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u000fB'\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006\u0010"}, d2 = {"Lih1/a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/i;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/a;", "", "", "pageFrom", "Lgh1/b;", "j0", "Landroidx/lifecycle/LifecycleOwner;", "viewCycleOwner", "", "mainSource", "subSource", "<init>", "(Landroidx/lifecycle/LifecycleOwner;ILjava/lang/String;Ljava/lang/String;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends i<com.tencent.mobileqq.guild.discovery.avblockdetail.model.a> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lih1/a$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/a;", "oldItem", "newItem", "", "b", "a", "", "", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ih1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C10528a extends DiffUtil.ItemCallback<com.tencent.mobileqq.guild.discovery.avblockdetail.model.a> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.discovery.avblockdetail.model.a oldItem, @NotNull com.tencent.mobileqq.guild.discovery.avblockdetail.model.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if ((oldItem instanceof GuildRecommendCardItem) && (newItem instanceof GuildRecommendCardItem)) {
                return ((GuildRecommendCardItem) newItem).areSameForUI(oldItem);
            }
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.discovery.avblockdetail.model.a oldItem, @NotNull com.tencent.mobileqq.guild.discovery.avblockdetail.model.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if ((oldItem instanceof GuildRecommendCardItem) && (newItem instanceof GuildRecommendCardItem)) {
                return Intrinsics.areEqual(((GuildRecommendCardItem) oldItem).getGuildId(), ((GuildRecommendCardItem) newItem).getGuildId());
            }
            return Intrinsics.areEqual(oldItem.getItemId(), newItem.getItemId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<Object> getChangePayload(@NotNull com.tencent.mobileqq.guild.discovery.avblockdetail.model.a oldItem, @NotNull com.tencent.mobileqq.guild.discovery.avblockdetail.model.a newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getDiffPayload(newItem);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull LifecycleOwner viewCycleOwner, int i3, @NotNull String mainSource, @NotNull String subSource) {
        super(viewCycleOwner, BundleKt.bundleOf(new Pair[0]), new C10528a());
        Intrinsics.checkNotNullParameter(viewCycleOwner, "viewCycleOwner");
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        switch (i3) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i0().c(new GuildRecommendGuildNewCardDelegate(new ExtraData(i3, mainSource, subSource, DiscoverTabType.DEFAULT, false, null, 48, null), viewCycleOwner, null, 4, null));
                return;
            default:
                i0().c(new GuildRecommendGuildCardDelegate(j0(i3), new ExtraData(i3, mainSource, subSource, DiscoverTabType.DEFAULT, false, null, 48, null), viewCycleOwner, null, 8, null));
                return;
        }
    }

    private final b j0(int pageFrom) {
        return new b(mh1.a.f416777a.a(pageFrom, DiscoverTabType.RECOMMEND));
    }
}
