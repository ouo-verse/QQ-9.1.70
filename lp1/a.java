package lp1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedFragment;
import com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedSectionFragment;
import com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildEmptySubFragment;
import com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildFrameMainProcessWebViewFragment;
import com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildKuiklyFragment;
import com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildWebViewFragment;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u000f\u0018\u0000 +2\u00020\u0001:\u0002,-B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b)\u0010*J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R0\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006."}, d2 = {"Llp1/a;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "Llp1/c;", "list", "", "j0", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "", "getItemId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/Fragment;", "parentFragment", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "Landroidx/fragment/app/FragmentManager;", "D", "Landroidx/fragment/app/FragmentManager;", "i0", "()Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "", "E", "Ljava/util/List;", "currentItems", "", UserInfo.SEX_FEMALE, "Ljava/util/Set;", "reportedSets", "value", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "G", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends FragmentStateAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IPerformanceReportTask reportTask;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final FragmentManager childFragmentManager;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<SubTabData> currentItems;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Set<Long> reportedSets;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment parentFragment;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Llp1/a$b;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "Llp1/c;", "a", "Ljava/util/List;", "oldDataList", "b", "newDataList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends DiffUtil.Callback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<SubTabData> oldDataList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<SubTabData> newDataList;

        public b(@NotNull List<SubTabData> oldDataList, @NotNull List<SubTabData> newDataList) {
            Intrinsics.checkNotNullParameter(oldDataList, "oldDataList");
            Intrinsics.checkNotNullParameter(newDataList, "newDataList");
            this.oldDataList = oldDataList;
            this.newDataList = newDataList;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics.areEqual(this.oldDataList.get(oldItemPosition).getName(), this.newDataList.get(newItemPosition).getName());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            if (this.oldDataList.get(oldItemPosition).getType() == this.newDataList.get(newItemPosition).getType() && this.oldDataList.get(oldItemPosition).getCategoryId() == this.newDataList.get(newItemPosition).getCategoryId()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newDataList.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldDataList.size();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Fragment parentFragment, @NotNull IPerformanceReportTask reportTask) {
        super(parentFragment);
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        Intrinsics.checkNotNullParameter(reportTask, "reportTask");
        this.parentFragment = parentFragment;
        this.reportTask = reportTask;
        FragmentManager childFragmentManager = parentFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "parentFragment.childFragmentManager");
        this.childFragmentManager = childFragmentManager;
        this.currentItems = new ArrayList();
        this.reportedSets = new LinkedHashSet();
    }

    private final void j0(List<SubTabData> list) {
        List list2;
        List list3;
        list2 = CollectionsKt___CollectionsKt.toList(this.currentItems);
        this.currentItems.clear();
        this.currentItems.addAll(list);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeTabFragmentAdapter", 1, "setItems oldList:" + list2.size() + " list:" + list.size());
        }
        list3 = CollectionsKt___CollectionsKt.toList(list);
        DiffUtil.calculateDiff(new b(list2, list3)).dispatchUpdatesTo(this);
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        Fragment guildHomeSubFeedFragment;
        String d16;
        String c16;
        SubTabData subTabData = this.currentItems.get(position);
        int type = subTabData.getType();
        if (type != 1) {
            if (type != 6) {
                if (type != 99) {
                    guildHomeSubFeedFragment = new GuildEmptySubFragment();
                } else {
                    guildHomeSubFeedFragment = new GuildHomeSubFeedSectionFragment();
                }
            } else {
                int urlType = subTabData.getUrlType();
                if (urlType != 1) {
                    if (urlType != 2) {
                        guildHomeSubFeedFragment = new GuildEmptySubFragment();
                    } else {
                        guildHomeSubFeedFragment = new GuildKuiklyFragment();
                    }
                } else if (com.tencent.mobileqq.guild.discoveryv2.fragment.configtab.b.f217432a.d(subTabData.getName())) {
                    guildHomeSubFeedFragment = new GuildFrameMainProcessWebViewFragment();
                } else {
                    guildHomeSubFeedFragment = new GuildWebViewFragment();
                }
            }
        } else {
            guildHomeSubFeedFragment = new GuildHomeSubFeedFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putAll(this.parentFragment.getArguments());
        bundle.putAll(subTabData.getExtra());
        if (this.reportedSets.add(Long.valueOf(subTabData.getCategoryId()))) {
            IPerformanceReportTask duplicate = this.reportTask.duplicate(new String[0]);
            d16 = lp1.b.d(subTabData);
            qw1.b.u(bundle, duplicate.setStageCode(d16), null, 2, null);
            IPerformanceReportTask newReportTask = Reporters.f231995a.b().newReportTask();
            c16 = lp1.b.c(subTabData);
            qw1.b.t(bundle, newReportTask.setEventCode(c16), "_extra_param_report_task_view_pager_tab");
        }
        guildHomeSubFeedFragment.setArguments(bundle);
        return guildHomeSubFeedFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.currentItems.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        long categoryId = this.currentItems.get(position).getCategoryId();
        return (androidx.fragment.app.a.a(categoryId) & 4294967295L) | (this.currentItems.get(position).getType() << 32);
    }

    @NotNull
    public final List<SubTabData> getItems() {
        List<SubTabData> list;
        list = CollectionsKt___CollectionsKt.toList(this.currentItems);
        return list;
    }

    @NotNull
    /* renamed from: i0, reason: from getter */
    public final FragmentManager getChildFragmentManager() {
        return this.childFragmentManager;
    }

    public final void setItems(@NotNull List<SubTabData> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        j0(value);
    }
}
