package mj1;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.multitouchimg.MultiTouchImageView;
import com.tencent.mobileqq.guild.component.multitouchimg.p;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.detail.banner.item.GuildBannerPicItemView;
import com.tencent.mobileqq.guild.feed.detail.banner.item.GuildBannerVideoItemView;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryPreloadEvent;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class c extends com.tencent.mobileqq.guild.component.imagebanner.a<a> {
    private List<GuildFeedRichMediaData> G;
    private int H;
    private p I;
    private GProStFeed J;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class a extends RecyclerView.ViewHolder implements b {
        public a(@NonNull View view) {
            super(view);
        }

        @Override // mj1.c.b
        public void X(int i3) {
            KeyEvent.Callback callback = this.itemView;
            if (callback instanceof b) {
                ((b) callback).X(i3);
            }
        }

        public void l(int i3) {
            if (this.itemView.getTag(R.id.f165513we3) == null) {
                this.itemView.setTag(R.id.f165513we3, Integer.valueOf(i3));
                onSelected(i3);
            }
        }

        @Override // mj1.c.b
        public void onSelected(int i3) {
            KeyEvent.Callback callback = this.itemView;
            if (callback instanceof b) {
                ((b) callback).onSelected(i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface b {
        void X(int i3);

        void onSelected(int i3);
    }

    /* compiled from: P */
    /* renamed from: mj1.c$c, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C10789c extends a {
        public GuildBannerPicItemView E;

        public C10789c(@NonNull GuildBannerPicItemView guildBannerPicItemView) {
            super(guildBannerPicItemView);
            this.E = guildBannerPicItemView;
        }

        public void m(GProStFeed gProStFeed, GuildFeedRichMediaData guildFeedRichMediaData, int i3) {
            this.E.setFeedInfo(gProStFeed);
            this.E.setData(guildFeedRichMediaData, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class d extends a {
        public GuildBannerVideoItemView E;

        public d(@NonNull GuildBannerVideoItemView guildBannerVideoItemView) {
            super(guildBannerVideoItemView);
            this.E = guildBannerVideoItemView;
        }

        public void m(GProStFeed gProStFeed, GuildFeedRichMediaData guildFeedRichMediaData, int i3) {
            this.E.setFeedInfo(gProStFeed);
            this.E.setData(guildFeedRichMediaData, i3);
        }

        public void onPause() {
            this.E.onPause();
        }

        public void onResume() {
            this.E.onResume();
        }
    }

    private void p0(View view) {
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void A0(GProStFeed gProStFeed, List<GuildFeedRichMediaData> list, int i3) {
        if (list == null) {
            return;
        }
        boolean z16 = false;
        if (i3 >= 0 && i3 < list.size()) {
            this.H = i3;
        } else {
            this.H = 0;
        }
        this.G = list;
        this.J = gProStFeed;
        if (list.size() > 1) {
            z16 = true;
        }
        o0(z16);
    }

    public void B0(p pVar) {
        this.I = pVar;
    }

    public void C0(int i3) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = getRecyclerView().findViewHolderForAdapterPosition(i3);
        if (findViewHolderForAdapterPosition instanceof a) {
            ((a) findViewHolderForAdapterPosition).X(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 >= 0 && i3 < this.G.size()) {
            return this.G.get(i3).getType();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.component.imagebanner.a
    public int getRealPosition(int i3) {
        return super.getRealPosition(i3);
    }

    @Override // com.tencent.mobileqq.guild.component.imagebanner.a
    public int k0() {
        List<GuildFeedRichMediaData> list = this.G;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.component.imagebanner.a
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void j0(a aVar, int i3, @NonNull List<Object> list) {
        if (this.G != null && aVar.itemView != null) {
            if (aVar instanceof C10789c) {
                C10789c c10789c = (C10789c) aVar;
                c10789c.E.setOnViewTapListener(this.I);
                c10789c.m(this.J, this.G.get(i3), i3);
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryPreloadEvent(i3), false);
            }
            if (aVar instanceof d) {
                ((d) aVar).m(this.J, this.G.get(i3), i3);
            }
            aVar.l(this.H);
        }
    }

    public boolean s0() {
        if (getItemViewType(this.H) == 1) {
            return true;
        }
        return false;
    }

    public MultiTouchImageView t0(int i3) {
        if (getRecyclerView() != null && getRecyclerView().getLayoutManager() != null) {
            View findViewByPosition = getRecyclerView().getLayoutManager().findViewByPosition(i3);
            if (findViewByPosition instanceof GuildBannerPicItemView) {
                return ((GuildBannerPicItemView) findViewByPosition).o0();
            }
            if (findViewByPosition instanceof GuildBannerVideoItemView) {
                return ((GuildBannerVideoItemView) findViewByPosition).N0();
            }
        }
        return null;
    }

    public GuildFeedRichMediaData u0(int i3) {
        List<GuildFeedRichMediaData> list;
        int i16;
        if (i3 >= 0 && (list = this.G) != null && list.size() > i3) {
            GuildFeedRichMediaData guildFeedRichMediaData = this.G.get(i3);
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = getRecyclerView().findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition instanceof d) {
                i16 = ((d) findViewHolderForAdapterPosition).E.O0();
            } else {
                i16 = 0;
            }
            guildFeedRichMediaData.setCurrentPlayPosition(i16);
            return guildFeedRichMediaData;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            GuildBannerVideoItemView guildBannerVideoItemView = new GuildBannerVideoItemView(viewGroup.getContext());
            p0(guildBannerVideoItemView);
            return new d(guildBannerVideoItemView);
        }
        GuildBannerPicItemView guildBannerPicItemView = new GuildBannerPicItemView(viewGroup.getContext());
        p0(guildBannerPicItemView);
        return new C10789c(guildBannerPicItemView);
    }

    public void w0(int i3) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = getRecyclerView().findViewHolderForAdapterPosition(i3);
        if (findViewHolderForAdapterPosition instanceof d) {
            ((d) findViewHolderForAdapterPosition).onResume();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NonNull a aVar) {
        super.onViewAttachedToWindow(aVar);
    }

    public void y0() {
        if (bl.b(this.G)) {
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        for (int i3 = 0; i3 < this.G.size(); i3++) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition instanceof d) {
                ((d) findViewHolderForAdapterPosition).onPause();
            }
        }
    }

    public void z0(int i3) {
        this.H = i3;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = getRecyclerView().findViewHolderForAdapterPosition(i3);
        if (findViewHolderForAdapterPosition instanceof a) {
            ((a) findViewHolderForAdapterPosition).onSelected(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.component.imagebanner.a
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void i0(a aVar, int i3) {
    }
}
