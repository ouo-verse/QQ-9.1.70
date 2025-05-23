package com.tencent.mobileqq.zootopia.portal.detail.rank;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.zootopia.utils.ae;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t74.m;
import zb3.ZootopiaUserRankData;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0013\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014J\u0014\u0010\u001a\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010#\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\"R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u001800j\b\u0012\u0004\u0012\u00020\u0018`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/detail/rank/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "getHeaderCount", "getFooterCount", "Landroid/view/ViewGroup;", "vg", "itemViewType", "onCreateViewHolder", "holder", "position", "", "onBindViewHolder", "getItemViewType", "Landroid/view/View;", "commentHeaderView", "k0", "loadMoreFooter", "j0", "", "isHide", "l0", "", "Lzb3/p;", "list", "i0", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "headerView", BdhLogUtil.LogTag.Tag_Conn, "footerView", "D", "I", "selfColor", "E", "otherColor", UserInfo.SEX_FEMALE, "otherScoreType", "Landroid/graphics/drawable/Drawable;", "G", "Landroid/graphics/drawable/Drawable;", "getDefaultAvatarDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultAvatarDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultAvatarDrawable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "data", "Z", "isHideDataStatus", "<init>", "()V", "J", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String K = "ZootopiaDetailRankAdapter";

    /* renamed from: C, reason: from kotlin metadata */
    private View footerView;

    /* renamed from: G, reason: from kotlin metadata */
    private Drawable defaultAvatarDrawable;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isHideDataStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View headerView;

    /* renamed from: D, reason: from kotlin metadata */
    private int selfColor = Color.parseColor("#ff4395f8");

    /* renamed from: E, reason: from kotlin metadata */
    private int otherColor = Color.parseColor("#ff34354b");

    /* renamed from: F, reason: from kotlin metadata */
    private int otherScoreType = Color.parseColor("#ff34354b");

    /* renamed from: H, reason: from kotlin metadata */
    private final ArrayList<ZootopiaUserRankData> data = new ArrayList<>();

    private final int getFooterCount() {
        return this.footerView != null ? 1 : 0;
    }

    private final int getHeaderCount() {
        return this.headerView != null ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.isHideDataStatus) {
            return getHeaderCount();
        }
        return this.data.size() + getHeaderCount() + getFooterCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position < getHeaderCount()) {
            return 1;
        }
        return (getFooterCount() <= 0 || position < getItemCount() - getFooterCount()) ? 0 : 2;
    }

    public final void i0(List<ZootopiaUserRankData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    public final void j0(View loadMoreFooter) {
        this.footerView = loadMoreFooter;
    }

    public final void k0(View commentHeaderView) {
        this.headerView = commentHeaderView;
    }

    public final void l0(boolean isHide) {
        if (this.isHideDataStatus != isHide) {
            this.isHideDataStatus = isHide;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int headerCount = position - getHeaderCount();
        ZootopiaUserRankData zootopiaUserRankData = (headerCount < 0 || headerCount >= this.data.size()) ? null : this.data.get(headerCount);
        if (zootopiaUserRankData == null || !(holder instanceof c)) {
            return;
        }
        c cVar = (c) holder;
        ae.INSTANCE.a(cVar.getAvatarView(), zootopiaUserRankData.f(), this.defaultAvatarDrawable, R.drawable.ibh);
        TextView noView = cVar.getNoView();
        if (noView != null) {
            int rank = zootopiaUserRankData.getRank();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(rank);
            noView.setText(sb5.toString());
        }
        TextView scoreView = cVar.getScoreView();
        if (scoreView != null) {
            scoreView.setText(zootopiaUserRankData.getScore());
        }
        TextView noView2 = cVar.getNoView();
        if (noView2 != null) {
            m mVar = m.f435564a;
            AssetManager assets = BaseApplication.context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
            noView2.setTypeface(mVar.f(assets));
        }
        TextView scoreView2 = cVar.getScoreView();
        if (scoreView2 != null) {
            m mVar2 = m.f435564a;
            AssetManager assets2 = BaseApplication.context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
            scoreView2.setTypeface(mVar2.f(assets2));
        }
        TextView nickView = cVar.getNickView();
        if (nickView != null) {
            nickView.setText(zootopiaUserRankData.h());
        }
        TextView scoreTypeView = cVar.getScoreTypeView();
        if (scoreTypeView != null) {
            scoreTypeView.setText(zootopiaUserRankData.getScoreSuffix());
        }
        if (zootopiaUserRankData.getIsSelf()) {
            TextView noView3 = cVar.getNoView();
            if (noView3 != null) {
                noView3.setTextColor(this.selfColor);
            }
            TextView scoreView3 = cVar.getScoreView();
            if (scoreView3 != null) {
                scoreView3.setTextColor(this.selfColor);
            }
            TextView nickView2 = cVar.getNickView();
            if (nickView2 != null) {
                nickView2.setTextColor(this.selfColor);
            }
            TextView scoreTypeView2 = cVar.getScoreTypeView();
            if (scoreTypeView2 != null) {
                scoreTypeView2.setTextColor(this.selfColor);
            }
            View mainContentView = cVar.getMainContentView();
            if (mainContentView != null) {
                mainContentView.setBackgroundResource(R.drawable.f159834ic0);
                return;
            }
            return;
        }
        TextView noView4 = cVar.getNoView();
        if (noView4 != null) {
            noView4.setTextColor(this.otherColor);
        }
        TextView scoreView4 = cVar.getScoreView();
        if (scoreView4 != null) {
            scoreView4.setTextColor(this.otherColor);
        }
        TextView nickView3 = cVar.getNickView();
        if (nickView3 != null) {
            nickView3.setTextColor(this.otherColor);
        }
        TextView scoreTypeView3 = cVar.getScoreTypeView();
        if (scoreTypeView3 != null) {
            scoreTypeView3.setTextColor(this.otherScoreType);
        }
        View mainContentView2 = cVar.getMainContentView();
        if (mainContentView2 != null) {
            mainContentView2.setBackgroundResource(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup vg5, int itemViewType) {
        Intrinsics.checkNotNullParameter(vg5, "vg");
        if (this.defaultAvatarDrawable == null) {
            Resources resources = vg5.getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "vg.context.resources");
            this.defaultAvatarDrawable = com.tencent.mobileqq.mvvm.f.c(resources, R.drawable.ibh);
        }
        if (itemViewType == 1) {
            View view = this.headerView;
            if (view == null) {
                view = new View(vg5.getContext());
            }
            return new b(view);
        }
        if (itemViewType != 2) {
            View itemView = LayoutInflater.from(vg5.getContext()).inflate(R.layout.f167424d83, vg5, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new c(itemView);
        }
        View view2 = this.footerView;
        if (view2 == null) {
            view2 = new View(vg5.getContext());
        }
        return new a(view2);
    }
}
