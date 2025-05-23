package com.tencent.biz.qqcircle.immersive.search.prompt.rank;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import circlesearch.CircleSearchExhibition$PromptRankingInfo;
import com.tencent.biz.qqcircle.immersive.search.prompt.rank.list.QFSSearchPromptRankListFragment;
import com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered.QFSSearchPromptRankStaggeredFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/e;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "Lcirclesearch/CircleSearchExhibition$PromptRankingInfo;", "infos", "", "setData", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "getItemViewType", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "rankInfos", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e extends FragmentStateAdapter {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<CircleSearchExhibition$PromptRankingInfo> rankInfos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull Fragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.rankInfos = new ArrayList();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType != 1) {
            if (itemViewType != 2) {
                return new QFSSearchPromptRankListFragment();
            }
            Bundle bundle = new Bundle();
            bundle.putByteArray("key_rank_page_data", this.rankInfos.get(position).page.toByteArray());
            QFSSearchPromptRankStaggeredFragment qFSSearchPromptRankStaggeredFragment = new QFSSearchPromptRankStaggeredFragment();
            qFSSearchPromptRankStaggeredFragment.setArguments(bundle);
            return qFSSearchPromptRankStaggeredFragment;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putByteArray("key_rank_page_data", this.rankInfos.get(position).page.toByteArray());
        QFSSearchPromptRankListFragment qFSSearchPromptRankListFragment = new QFSSearchPromptRankListFragment();
        qFSSearchPromptRankListFragment.setArguments(bundle2);
        return qFSSearchPromptRankListFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.rankInfos.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.rankInfos.get(position).type.get();
    }

    public final void setData(@NotNull List<CircleSearchExhibition$PromptRankingInfo> infos) {
        Intrinsics.checkNotNullParameter(infos, "infos");
        this.rankInfos.clear();
        this.rankInfos.addAll(infos);
        notifyDataSetChanged();
    }
}
