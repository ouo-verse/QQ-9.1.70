package fk1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.util.c;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.gallery.widget.item.GuildBannerImageItemViewV2;
import com.tencent.mobileqq.guild.feed.gallery.widget.item.GuildBannerVideoItemViewV2;
import com.tencent.mobileqq.guild.feed.gallery.widget.item.ImageFeedGalleryViewHolder;
import com.tencent.mobileqq.guild.feed.gallery.widget.item.n;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0017\u001a\u00020\u0005J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\fH\u0016J\u001a\u0010\"\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\fH\u0014J(\u0010&\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0014J\u0010\u0010(\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\fH\u0016J(\u0010-\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0006\u0010,\u001a\u00020\fJ\u0010\u00100\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010.J\u000e\u00102\u001a\u0002012\u0006\u0010\r\u001a\u00020\fR$\u00107\u001a\u0012\u0012\u0004\u0012\u00020*03j\b\u0012\u0004\u0012\u00020*`48\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010;\u00a8\u0006D"}, d2 = {"Lfk1/a;", "Lcom/tencent/mobileqq/guild/component/imagebanner/a;", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/b;", "Landroid/view/View;", "view", "", "p0", "targetView", "E0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "", "currentPos", "y0", "x0", "position", "Landroid/widget/ImageView;", "s0", "B0", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "w0", "v0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "u0", "holder", "z0", "A0", "getItemViewType", "k0", "realPosition", "q0", "", "", "payloads", "r0", "", "getItemId", "", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "dataList", "verPos", "C0", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", "D0", "", "t0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "G", "Ljava/util/ArrayList;", "mRichMediaList", "H", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "mFeedInfo", "I", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "mInitBean", "J", "mVerPos", "<init>", "()V", "K", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends com.tencent.mobileqq.guild.component.imagebanner.a<com.tencent.mobileqq.guild.feed.gallery.widget.item.b> {
    private static int L = c.b(50);

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GProStFeed mFeedInfo;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private GuildFeedGalleryInitBean mInitBean;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<GuildFeedRichMediaData> mRichMediaList = new ArrayList<>();

    /* renamed from: J, reason: from kotlin metadata */
    private int mVerPos = -1;

    private final void E0(View targetView) {
        ViewExtKt.c(targetView, L);
        targetView.requestLayout();
    }

    private final void p0(View view) {
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(@NotNull com.tencent.mobileqq.guild.feed.gallery.widget.item.b holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        holder.onViewDetachedFromWindow();
    }

    public final void B0() {
        RecyclerView.ViewHolder viewHolder;
        if (bl.b(this.mRichMediaList)) {
            return;
        }
        int i3 = 0;
        for (Object obj : this.mRichMediaList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RecyclerView recyclerView = getRecyclerView();
            if (recyclerView != null) {
                viewHolder = recyclerView.findViewHolderForAdapterPosition(i3);
            } else {
                viewHolder = null;
            }
            if (viewHolder instanceof com.tencent.mobileqq.guild.feed.gallery.widget.item.b) {
                ((com.tencent.mobileqq.guild.feed.gallery.widget.item.b) viewHolder).onPause();
            } else {
                QLog.w("Guild_Feed_GAL_GuildFeedGalleryContentAdapter", 1, "[pauseAllItems] viewHolder not found!!. " + viewHolder);
            }
            i3 = i16;
        }
    }

    public final void C0(@Nullable GProStFeed feed, @Nullable List<? extends GuildFeedRichMediaData> dataList, int verPos) {
        this.mVerPos = verPos;
        boolean z16 = false;
        boolean z17 = true;
        if (dataList != null && feed != null) {
            boolean z18 = !this.mRichMediaList.isEmpty();
            this.mRichMediaList.clear();
            this.mRichMediaList.addAll(dataList);
            this.mFeedInfo = feed;
            if (this.mRichMediaList.size() <= 1) {
                z17 = false;
            }
            o0(z17);
            if (z18) {
                notifyItemRangeChanged(0, dataList.size(), feed);
                return;
            }
            return;
        }
        if (feed == null) {
            z16 = true;
        }
        QLog.w("Guild_Feed_GAL_GuildFeedGalleryContentAdapter", 1, "[setData] failed. params is null. feed is null? --> " + z16);
    }

    public final void D0(@Nullable GuildFeedGalleryInitBean initBean) {
        this.mInitBean = initBean;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        int realPosition = getRealPosition(position);
        int i3 = this.mVerPos;
        if (i3 != -1) {
            return (i3 * 10000) + realPosition;
        }
        GProStFeed gProStFeed = this.mFeedInfo;
        if (gProStFeed != null) {
            return gProStFeed.createTime;
        }
        return System.currentTimeMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mRichMediaList, position);
        GuildFeedRichMediaData guildFeedRichMediaData = (GuildFeedRichMediaData) orNull;
        if (guildFeedRichMediaData != null) {
            return guildFeedRichMediaData.getType();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.component.imagebanner.a
    public int k0() {
        return this.mRichMediaList.size();
    }

    @Override // com.tencent.mobileqq.guild.component.imagebanner.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.setRecycledViewPool(mk1.b.f416885a.b(recyclerView.getContext().hashCode()));
        recyclerView.setItemViewCacheSize(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.component.imagebanner.a
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void j0(@Nullable com.tencent.mobileqq.guild.feed.gallery.widget.item.b holder, int realPosition, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (holder != null && payloads.isEmpty()) {
            holder.x(this.mInitBean);
            GProStFeed gProStFeed = this.mFeedInfo;
            GuildFeedRichMediaData guildFeedRichMediaData = this.mRichMediaList.get(realPosition);
            Intrinsics.checkNotNullExpressionValue(guildFeedRichMediaData, "mRichMediaList[realPosition]");
            holder.w(gProStFeed, guildFeedRichMediaData, realPosition, this.mVerPos);
            if (holder instanceof n) {
                ((n) holder).C(realPosition);
                return;
            }
            return;
        }
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryContentAdapter", 1, "[childBindViewHolder] holder[" + holder + "]: realPosition " + realPosition + ", payloads size " + payloads.size());
    }

    @Nullable
    public final ImageView s0(int position) {
        View view;
        RecyclerView.LayoutManager layoutManager;
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            view = layoutManager.findViewByPosition(position);
        } else {
            view = null;
        }
        if (view instanceof GuildBannerVideoItemViewV2) {
            return ((GuildBannerVideoItemViewV2) view).O0();
        }
        if (!(view instanceof GuildBannerImageItemViewV2)) {
            return null;
        }
        return ((GuildBannerImageItemViewV2) view).V0();
    }

    public final boolean t0(int currentPos) {
        RecyclerView.ViewHolder viewHolder;
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            viewHolder = recyclerView.findViewHolderForAdapterPosition(currentPos);
        } else {
            viewHolder = null;
        }
        if (viewHolder instanceof com.tencent.mobileqq.guild.feed.gallery.widget.item.b) {
            return ((com.tencent.mobileqq.guild.feed.gallery.widget.item.b) viewHolder).p();
        }
        QLog.w("Guild_Feed_GAL_GuildFeedGalleryContentAdapter", 1, "[needRequestLayoutAgain] viewHolder not found!!. " + viewHolder);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.guild.feed.gallery.widget.item.b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            if (viewType != 1) {
                QLog.w("Guild_Feed_GAL_GuildFeedGalleryContentAdapter", 1, "[onCreateViewHolder] failed. invalid view type: " + viewType);
                TextView textView = new TextView(parent.getContext());
                p0(textView);
                textView.setText("");
                return new com.tencent.mobileqq.guild.feed.gallery.widget.item.c(textView);
            }
            GuildBannerVideoItemViewV2 guildBannerVideoItemViewV2 = new GuildBannerVideoItemViewV2(parent.getContext());
            guildBannerVideoItemViewV2.setParentView(parent);
            E0(guildBannerVideoItemViewV2);
            p0(guildBannerVideoItemViewV2);
            return new n(guildBannerVideoItemViewV2);
        }
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        GuildBannerImageItemViewV2 guildBannerImageItemViewV2 = new GuildBannerImageItemViewV2(context);
        guildBannerImageItemViewV2.setParentView(parent);
        p0(guildBannerImageItemViewV2);
        return new ImageFeedGalleryViewHolder(guildBannerImageItemViewV2);
    }

    public final void v0() {
        RecyclerView.ViewHolder viewHolder;
        int size = this.mRichMediaList.size();
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = getRecyclerView();
            com.tencent.mobileqq.guild.feed.gallery.widget.item.b bVar = null;
            if (recyclerView != null) {
                viewHolder = recyclerView.findViewHolderForAdapterPosition(i3);
            } else {
                viewHolder = null;
            }
            if (viewHolder instanceof com.tencent.mobileqq.guild.feed.gallery.widget.item.b) {
                bVar = (com.tencent.mobileqq.guild.feed.gallery.widget.item.b) viewHolder;
            }
            if (bVar != null) {
                bVar.q();
            }
        }
    }

    public final void w0(@Nullable GProStFeed feed) {
        RecyclerView.ViewHolder viewHolder;
        int i3 = 0;
        for (Object obj : this.mRichMediaList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RecyclerView recyclerView = getRecyclerView();
            if (recyclerView != null) {
                viewHolder = recyclerView.findViewHolderForAdapterPosition(i3);
            } else {
                viewHolder = null;
            }
            if (viewHolder instanceof com.tencent.mobileqq.guild.feed.gallery.widget.item.b) {
                ((com.tencent.mobileqq.guild.feed.gallery.widget.item.b) viewHolder).r(feed);
            } else {
                QLog.w("Guild_Feed_GAL_GuildFeedGalleryContentAdapter", 1, "[onFeedDataReady] pos:" + i3 + " viewHolder not found!!. " + viewHolder);
            }
            i3 = i16;
        }
    }

    public final void x0(int currentPos) {
        RecyclerView.ViewHolder viewHolder;
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            viewHolder = recyclerView.findViewHolderForAdapterPosition(currentPos);
        } else {
            viewHolder = null;
        }
        if (viewHolder instanceof com.tencent.mobileqq.guild.feed.gallery.widget.item.b) {
            ((com.tencent.mobileqq.guild.feed.gallery.widget.item.b) viewHolder).onPause();
            return;
        }
        QLog.w("Guild_Feed_GAL_GuildFeedGalleryContentAdapter", 1, "[onPause] viewHolder not found!!. " + viewHolder);
    }

    public final void y0(int currentPos) {
        RecyclerView.ViewHolder viewHolder;
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            viewHolder = recyclerView.findViewHolderForAdapterPosition(currentPos);
        } else {
            viewHolder = null;
        }
        if (viewHolder instanceof com.tencent.mobileqq.guild.feed.gallery.widget.item.b) {
            ((com.tencent.mobileqq.guild.feed.gallery.widget.item.b) viewHolder).onResume();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull com.tencent.mobileqq.guild.feed.gallery.widget.item.b holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        holder.onViewAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.component.imagebanner.a
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void i0(@Nullable com.tencent.mobileqq.guild.feed.gallery.widget.item.b holder, int realPosition) {
    }
}
