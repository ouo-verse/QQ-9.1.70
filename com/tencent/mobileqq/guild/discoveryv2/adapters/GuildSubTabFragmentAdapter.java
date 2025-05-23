package com.tencent.mobileqq.guild.discoveryv2.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.widget.u;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.guild.discoveryv2.fragment.CategoryTabFragment;
import com.tencent.mobileqq.guild.discoveryv2.fragment.MyTabFeedsFragment;
import com.tencent.mobileqq.guild.discoveryv2.fragment.RecommendTabFragment;
import com.tencent.mobileqq.guild.report.DummyPerformanceReportTask;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0003+,-B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tJ\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter$SubTabData;", "curItem", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "k0", "", "position", "l0", "", "list", "", "setItems", "getItemCount", "", "getItemId", "Landroidx/fragment/app/Fragment;", "createFragment", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/Fragment;", "parentFragment", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "baseReportTask", "Landroidx/fragment/app/FragmentManager;", "D", "Landroidx/fragment/app/FragmentManager;", "i0", "()Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "", "E", "Ljava/util/List;", "j0", "()Ljava/util/List;", "currentItems", "", UserInfo.SEX_FEMALE, "Ljava/util/Set;", "reportedSets", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "G", "a", "SubTabData", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSubTabFragmentAdapter extends FragmentStateAdapter {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IPerformanceReportTask baseReportTask;

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

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0006\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010 \u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter$SubTabData;", "Landroid/os/Parcelable;", "", "e", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "name", "I", "getType", "()I", "type", "f", "b", QCircleLpReportDc010001.KEY_SUBTYPE, h.F, "c", "tabId", "<init>", "(Ljava/lang/String;III)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class SubTabData implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<SubTabData> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int subType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int tabId;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a implements Parcelable.Creator<SubTabData> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final SubTabData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SubTabData(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SubTabData[] newArray(int i3) {
                return new SubTabData[i3];
            }
        }

        public SubTabData(@NotNull String name, int i3, int i16, int i17) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.type = i3;
            this.subType = i16;
            this.tabId = i17;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: b, reason: from getter */
        public final int getSubType() {
            return this.subType;
        }

        /* renamed from: c, reason: from getter */
        public final int getTabId() {
            return this.tabId;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final long e() {
            return (this.type << 60) | (this.subType << 56) | (this.tabId & 4294967295L);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubTabData)) {
                return false;
            }
            SubTabData subTabData = (SubTabData) other;
            if (Intrinsics.areEqual(this.name, subTabData.name) && this.type == subTabData.type && this.subType == subTabData.subType && this.tabId == subTabData.tabId) {
                return true;
            }
            return false;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.type) * 31) + this.subType) * 31) + this.tabId;
        }

        @NotNull
        public String toString() {
            return "SubTabData(name=" + this.name + ", type=" + this.type + ", subType=" + this.subType + ", tabId=" + this.tabId + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.name);
            parcel.writeInt(this.type);
            parcel.writeInt(this.subType);
            parcel.writeInt(this.tabId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter$a;", "", "Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter$SubTabData;", "", "d", "c", "ARGUMENT_PARAM_SUB_TAB_DATA", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.adapters.GuildSubTabFragmentAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String c(SubTabData subTabData) {
            if (subTabData.getType() == 1) {
                return "discover_recommend_tab";
            }
            if (subTabData.getType() == 2) {
                return "discover_mine_tab";
            }
            if (subTabData.getType() == 3) {
                return "discover_category_tab";
            }
            if (subTabData.getType() == 4) {
                return "discover_config_tab";
            }
            return "discover_unknown_tab";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d(SubTabData subTabData) {
            if (subTabData.getType() == 1) {
                return "stage_recommend_tab";
            }
            if (subTabData.getType() == 2) {
                return "stage_me_tab";
            }
            if (subTabData.getType() == 3) {
                return "stage_category_tab";
            }
            if (subTabData.getType() == 4) {
                return "stage_config_tab";
            }
            return "stage_unknown_tab";
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter$b;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter$SubTabData;", "a", "Ljava/util/List;", "oldDataList", "b", "newDataList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
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
            return Intrinsics.areEqual(this.oldDataList.get(oldItemPosition), this.newDataList.get(newItemPosition));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            if (this.oldDataList.get(oldItemPosition).getType() == this.newDataList.get(newItemPosition).getType()) {
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
    public GuildSubTabFragmentAdapter(@NotNull Fragment parentFragment, @NotNull IPerformanceReportTask baseReportTask) {
        super(parentFragment);
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        Intrinsics.checkNotNullParameter(baseReportTask, "baseReportTask");
        this.parentFragment = parentFragment;
        this.baseReportTask = baseReportTask;
        FragmentManager childFragmentManager = parentFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "parentFragment.childFragmentManager");
        this.childFragmentManager = childFragmentManager;
        this.currentItems = new ArrayList();
        this.reportedSets = new LinkedHashSet();
    }

    private final IPerformanceReportTask k0(SubTabData curItem) {
        Map<String, ? extends Object> mapOf;
        try {
            IPerformanceReportTask realTime = Reporters.f231995a.b().newReportTask().setEventCode(INSTANCE.c(curItem)).setStageCode("stage_init").setRealTime(false);
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("tab_name", curItem.getName()), TuplesKt.to(u.COLUMN_TAB_ID, String.valueOf(curItem.getTabId())));
            return realTime.setExtras(mapOf).report().duplicate("tab_name", u.COLUMN_TAB_ID);
        } catch (Exception unused) {
            return DummyPerformanceReportTask.INSTANCE;
        }
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        Fragment fragment;
        SubTabData subTabData = this.currentItems.get(position);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeSubFragmentAdapter", 1, "createFragment pos:" + position + " curItem:" + subTabData.getName());
        }
        int type = subTabData.getType();
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            fragment = new Fragment();
                        } else {
                            fragment = com.tencent.mobileqq.guild.discoveryv2.fragment.configtab.b.f217432a.b(subTabData);
                        }
                    } else {
                        fragment = new CategoryTabFragment();
                    }
                } else {
                    fragment = new MyTabFeedsFragment();
                }
            } else {
                fragment = new RecommendTabFragment();
            }
        } else {
            fragment = new Fragment();
        }
        Intent intent = new Intent();
        intent.putExtra("url", "");
        intent.putExtra("key_url_source", "main.guild");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("intent", intent), TuplesKt.to("subTabData", subTabData));
        if (this.reportedSets.add(Long.valueOf(subTabData.getTabId()))) {
            qw1.b.u(bundleOf, this.baseReportTask.duplicate(new String[0]).setStageCode(INSTANCE.d(subTabData)).setAppChannel(com.tencent.mobileqq.guild.report.b.c()).setExtra(u.COLUMN_TAB_ID, String.valueOf(subTabData.getTabId())).setExtra("tab_name", subTabData.getName()).setExtra(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, String.valueOf(subTabData.getType())).setExtra("tab_sub_type", String.valueOf(subTabData.getSubType())), null, 2, null);
            qw1.b.t(bundleOf, k0(subTabData), "_extra_param_report_task_view_pager_tab");
        }
        fragment.setArguments(bundleOf);
        return fragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.currentItems.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        SubTabData l06 = l0(position);
        if (l06 != null) {
            return l06.e();
        }
        return Long.MIN_VALUE;
    }

    @NotNull
    /* renamed from: i0, reason: from getter */
    public final FragmentManager getChildFragmentManager() {
        return this.childFragmentManager;
    }

    @NotNull
    public final List<SubTabData> j0() {
        return this.currentItems;
    }

    @Nullable
    public final SubTabData l0(int position) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.currentItems, position);
        return (SubTabData) orNull;
    }

    public final void setItems(@NotNull List<SubTabData> list) {
        List list2;
        List list3;
        Intrinsics.checkNotNullParameter(list, "list");
        list2 = CollectionsKt___CollectionsKt.toList(this.currentItems);
        this.currentItems.clear();
        this.currentItems.addAll(list);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeSubFragmentAdapter", 1, "setItems oldList:" + list2.size() + " list:" + list.size());
        }
        list3 = CollectionsKt___CollectionsKt.toList(list);
        DiffUtil.calculateDiff(new b(list2, list3)).dispatchUpdatesTo(this);
    }
}
