package hp1;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import ar1.h;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderNavigationBar;
import com.tencent.mobileqq.guild.home.views.header.delegates.HeaderGameDistributeAdapterDelegate;
import com.tencent.mobileqq.guild.home.views.header.delegates.HeaderGroupChatAdapterDelegate;
import com.tencent.mobileqq.guild.home.views.header.delegates.HeaderNavigationAdapterDelegate;
import com.tencent.mobileqq.guild.home.views.header.delegates.HeaderSpaceGapAdapterDelegate;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.adapterdelegates.ViewHolderVisibleAwareNotifier;
import com.tencent.mobileqq.guild.widget.adapterdelegates.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lhp1/a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/f;", "k0", "Lhp1/b;", "I", "Lhp1/b;", "getEventHandler", "()Lhp1/b;", "eventHandler", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/ViewHolderVisibleAwareNotifier;", "J", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/ViewHolderVisibleAwareNotifier;", "viewHolderVisibleAwareNotifier", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lar1/h;", "redPointDragHandler", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lhp1/b;Lar1/h;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends d<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final b eventHandler;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ViewHolderVisibleAwareNotifier viewHolderVisibleAwareNotifier;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lhp1/a$a;", "", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hp1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"hp1/a$a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "oldItem", "newItem", "", "b", "a", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: hp1.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C10461a extends DiffUtil.ItemCallback<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> {
            C10461a() {
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b oldItem, @NotNull com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.a(newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b oldItem, @NotNull com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.b(newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            @Nullable
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Object getChangePayload(@NotNull com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b oldItem, @NotNull com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.c(newItem);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DiffUtil.ItemCallback<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> b() {
            return new C10461a();
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull b eventHandler, @NotNull h redPointDragHandler) {
        super(INSTANCE.b(), new com.tencent.mobileqq.guild.widget.adapterdelegates.h());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Intrinsics.checkNotNullParameter(redPointDragHandler, "redPointDragHandler");
        this.eventHandler = eventHandler;
        ViewHolderVisibleAwareNotifier viewHolderVisibleAwareNotifier = new ViewHolderVisibleAwareNotifier();
        this.viewHolderVisibleAwareNotifier = viewHolderVisibleAwareNotifier;
        Logger.f235387a.d().d("Guild.NewHome.GuildHomeHeaderBarsAdapter", 1, "context:" + context);
        viewHolderVisibleAwareNotifier.b(lifecycleOwner, "GuildHeaderBarsAdapter");
        this.f236209m.c(new HeaderNavigationAdapterDelegate(eventHandler.c())).c(new HeaderGameDistributeAdapterDelegate()).c(new HeaderSpaceGapAdapterDelegate()).c(new HeaderGroupChatAdapterDelegate(redPointDragHandler, eventHandler.b(), eventHandler.a()));
    }

    @Nullable
    public final Pair<Integer, GuildHomeHeaderNavigationBar> k0() {
        List<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "items");
        int i3 = 0;
        for (Object obj : items) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b bVar = (com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b) obj;
            if (bVar instanceof GuildHomeHeaderNavigationBar) {
                return new Pair<>(Integer.valueOf(i3), bVar);
            }
            i3 = i16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.viewHolderVisibleAwareNotifier.d(holder);
        this.f236209m.o(holder);
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.viewHolderVisibleAwareNotifier.e(holder);
        this.f236209m.p(holder);
    }
}
