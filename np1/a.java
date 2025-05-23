package np1;

import android.annotation.SuppressLint;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioActiveListenAdapterDelegate;
import com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioActiveLobbyAdapterDelegate;
import com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioActiveNormalAdapterDelegate;
import com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioActiveScreenAdapterDelegate;
import com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioInactiveAdapterDelegate;
import com.tencent.mobileqq.guild.homev2.live.adapter.common.GuildAVSpaceDelegate;
import com.tencent.mobileqq.guild.homev2.live.adapter.video.GuildAVLiveActiveAdapterDelegate;
import com.tencent.mobileqq.guild.homev2.live.adapter.video.GuildAVLiveInactiveAdapterDelegate;
import com.tencent.mobileqq.guild.widget.adapterdelegates.ViewHolderVisibleAwareNotifier;
import com.tencent.mobileqq.guild.widget.adapterdelegates.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pp1.g;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lnp1/a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lpp1/g;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/ViewHolderVisibleAwareNotifier;", "I", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/ViewHolderVisibleAwareNotifier;", "viewHolderVisibleAwareNotifier", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Lnp1/a$b;", "callback", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lnp1/a$b;)V", "J", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends d<g> {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ViewHolderVisibleAwareNotifier viewHolderVisibleAwareNotifier;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a8\u0006\u0007"}, d2 = {"Lnp1/a$a;", "", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lpp1/g;", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: np1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017\u00a8\u0006\b"}, d2 = {"np1/a$a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lpp1/g;", "oldItem", "newItem", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: np1.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C10859a extends DiffUtil.ItemCallback<g> {
            C10859a() {
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            @SuppressLint({"DiffUtilEquals"})
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull g oldItem, @NotNull g newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return newItem.c(oldItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull g oldItem, @NotNull g newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return newItem.d(oldItem);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DiffUtil.ItemCallback<g> b() {
            return new C10859a();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lnp1/a$b;", "", "Lpp1/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(@NotNull g item);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull LifecycleOwner viewLifecycleOwner, @NotNull b callback) {
        super(INSTANCE.b());
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ViewHolderVisibleAwareNotifier viewHolderVisibleAwareNotifier = new ViewHolderVisibleAwareNotifier();
        this.viewHolderVisibleAwareNotifier = viewHolderVisibleAwareNotifier;
        ViewHolderVisibleAwareNotifier.c(viewHolderVisibleAwareNotifier, viewLifecycleOwner, null, 2, null);
        this.f236209m.c(new GuildAVLiveActiveAdapterDelegate(callback)).c(new GuildAVLiveInactiveAdapterDelegate(callback)).c(new GuildAVAudioInactiveAdapterDelegate(callback)).c(new GuildAVAudioActiveNormalAdapterDelegate(callback)).c(new GuildAVAudioActiveListenAdapterDelegate(callback)).c(new GuildAVAudioActiveLobbyAdapterDelegate(callback)).c(new GuildAVAudioActiveScreenAdapterDelegate(callback)).c(new GuildAVSpaceDelegate());
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        this.viewHolderVisibleAwareNotifier.d(holder);
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        this.viewHolderVisibleAwareNotifier.e(holder);
    }
}
