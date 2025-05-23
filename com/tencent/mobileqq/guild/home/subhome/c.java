package com.tencent.mobileqq.guild.home.subhome;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedFragment;
import com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubLiveFragment;
import com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildFrameMainProcessWebViewFragment;
import com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildKuiklyFragment;
import com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildWebViewFragment;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.webview.swift.utils.m;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0003)*+B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b&\u0010'J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/home/subhome/c;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "Lcom/tencent/mobileqq/guild/home/subhome/c$b;", "list", "", "setItems", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "", "getItemId", "itemId", "", "containsItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/Fragment;", "parentFragment", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "Landroidx/fragment/app/FragmentManager;", "D", "Landroidx/fragment/app/FragmentManager;", "k0", "()Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "", "E", "Ljava/util/List;", "currentItems", "", UserInfo.SEX_FEMALE, "Ljava/util/Set;", "reportedSets", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "G", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends FragmentStateAdapter {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IPerformanceReportTask reportTask;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final FragmentManager childFragmentManager;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<GuildHomeSubTabData> currentItems;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Set<Long> reportedSets;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment parentFragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/home/subhome/c$a;", "", "Lcom/tencent/mobileqq/guild/home/subhome/c$b;", "", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.subhome.c$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(GuildHomeSubTabData guildHomeSubTabData) {
            int type = guildHomeSubTabData.getType();
            if (type != 1) {
                if (type != 3) {
                    if (type != 6) {
                        if (type != 7) {
                            return "stage_unknown_tab";
                        }
                        return "stage_schedule_tab";
                    }
                    int urlType = guildHomeSubTabData.getUrlType();
                    if (urlType != 1) {
                        if (urlType != 2) {
                            return "stage_unknown_tab";
                        }
                        return "stage_kuikly_tab";
                    }
                    return "stage_h5_tab";
                }
                return "stage_live_tab";
            }
            return "stage_feed_tab";
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u0012\u0010\u0019R\u0019\u0010 \u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b!\u0010\u0019R\u0017\u0010$\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b#\u0010\u0015R\u0017\u0010(\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b#\u0010&\u001a\u0004\b\u001b\u0010'\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/home/subhome/c$b;", "", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "c", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "categoryId", "b", "I", "g", "()I", "type", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "name", "d", "categoryName", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "resId", "getUrl", "url", h.F, "urlType", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "extra", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.subhome.c$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GuildHomeSubTabData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long categoryId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String categoryName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer resId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String url;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int urlType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Bundle extra;

        /* renamed from: a, reason: from getter */
        public final long getCategoryId() {
            return this.categoryId;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getCategoryName() {
            return this.categoryName;
        }

        @Nullable
        public final Drawable c(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Integer num = this.resId;
            if (num == null) {
                return null;
            }
            return context.getDrawable(num.intValue());
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final Bundle getExtra() {
            return this.extra;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildHomeSubTabData)) {
                return false;
            }
            GuildHomeSubTabData guildHomeSubTabData = (GuildHomeSubTabData) other;
            if (this.categoryId == guildHomeSubTabData.categoryId && this.type == guildHomeSubTabData.type && Intrinsics.areEqual(this.name, guildHomeSubTabData.name) && Intrinsics.areEqual(this.categoryName, guildHomeSubTabData.categoryName) && Intrinsics.areEqual(this.resId, guildHomeSubTabData.resId) && Intrinsics.areEqual(this.url, guildHomeSubTabData.url) && this.urlType == guildHomeSubTabData.urlType && Intrinsics.areEqual(this.extra, guildHomeSubTabData.extra)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final Integer getResId() {
            return this.resId;
        }

        /* renamed from: g, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* renamed from: h, reason: from getter */
        public final int getUrlType() {
            return this.urlType;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int a16 = ((((androidx.fragment.app.a.a(this.categoryId) * 31) + this.type) * 31) + this.name.hashCode()) * 31;
            String str = this.categoryName;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (a16 + hashCode) * 31;
            Integer num = this.resId;
            if (num == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = num.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.url;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return ((((i17 + i3) * 31) + this.urlType) * 31) + this.extra.hashCode();
        }

        @NotNull
        public String toString() {
            return "GuildHomeSubTabData(categoryId=" + this.categoryId + ", type=" + this.type + ", name=" + this.name + ", categoryName=" + this.categoryName + ", resId=" + this.resId + ", url=" + this.url + ", urlType=" + this.urlType + ", extra=" + this.extra + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/home/subhome/c$c;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "Lcom/tencent/mobileqq/guild/home/subhome/c$b;", "a", "Ljava/util/List;", "oldDataList", "b", "newDataList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.subhome.c$c, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7800c extends DiffUtil.Callback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<GuildHomeSubTabData> oldDataList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<GuildHomeSubTabData> newDataList;

        public C7800c(@NotNull List<GuildHomeSubTabData> oldDataList, @NotNull List<GuildHomeSubTabData> newDataList) {
            Intrinsics.checkNotNullParameter(oldDataList, "oldDataList");
            Intrinsics.checkNotNullParameter(newDataList, "newDataList");
            this.oldDataList = oldDataList;
            this.newDataList = newDataList;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            if (Intrinsics.areEqual(this.oldDataList.get(oldItemPosition).getName(), this.newDataList.get(newItemPosition).getName()) && Intrinsics.areEqual(this.oldDataList.get(oldItemPosition).getResId(), this.newDataList.get(newItemPosition).getResId())) {
                return true;
            }
            return false;
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
    public c(@NotNull Fragment parentFragment, @NotNull IPerformanceReportTask reportTask) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0() {
        Logger.f235387a.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentAdapter", 1, "[onTbsCoreInitFinish] ");
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long itemId) {
        Iterator<T> it = this.currentItems.iterator();
        while (it.hasNext()) {
            if (((GuildHomeSubTabData) it.next()).getCategoryId() == itemId) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        Fragment guildHomeSubFeedFragment;
        GuildHomeSubTabData guildHomeSubTabData = this.currentItems.get(position);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentAdapter", 1, "createFragment pos:" + position + " curItem:" + guildHomeSubTabData.getName());
        }
        int type = guildHomeSubTabData.getType();
        if (type != 1) {
            if (type != 3) {
                if (type == 6) {
                    int urlType = guildHomeSubTabData.getUrlType();
                    if (urlType != 1) {
                        if (urlType == 2) {
                            guildHomeSubFeedFragment = new GuildKuiklyFragment();
                        } else {
                            throw new IllegalArgumentException("unexpected guildSubTab:" + position + " -> " + guildHomeSubTabData);
                        }
                    } else if (com.tencent.mobileqq.guild.discoveryv2.fragment.configtab.b.f217432a.d(guildHomeSubTabData.getName())) {
                        if (!m.e()) {
                            logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentAdapter", 1, "[TbsAccelerator.initAsync] start");
                            m.h(new m.a() { // from class: com.tencent.mobileqq.guild.home.subhome.b
                                @Override // com.tencent.mobileqq.webview.swift.utils.m.a
                                public final void a() {
                                    c.j0();
                                }
                            });
                        }
                        guildHomeSubFeedFragment = new GuildFrameMainProcessWebViewFragment();
                    } else {
                        guildHomeSubFeedFragment = new GuildWebViewFragment();
                    }
                } else {
                    throw new IllegalArgumentException("unexpected guildSubTab:" + position + " -> " + guildHomeSubTabData);
                }
            } else {
                guildHomeSubFeedFragment = new GuildHomeSubLiveFragment();
            }
        } else {
            guildHomeSubFeedFragment = new GuildHomeSubFeedFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putAll(this.parentFragment.getArguments());
        bundle.putAll(guildHomeSubTabData.getExtra());
        if (this.reportedSets.add(Long.valueOf(guildHomeSubTabData.getCategoryId()))) {
            qw1.b.u(bundle, this.reportTask.duplicate("guild_id").setStageCode(INSTANCE.b(guildHomeSubTabData)), null, 2, null);
        }
        guildHomeSubFeedFragment.setArguments(bundle);
        return guildHomeSubFeedFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.currentItems.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        if (position >= 0 && position < this.currentItems.size()) {
            return this.currentItems.get(position).getCategoryId();
        }
        return super.getItemId(position);
    }

    @NotNull
    /* renamed from: k0, reason: from getter */
    public final FragmentManager getChildFragmentManager() {
        return this.childFragmentManager;
    }

    public final void setItems(@NotNull List<GuildHomeSubTabData> list) {
        List list2;
        List list3;
        Intrinsics.checkNotNullParameter(list, "list");
        list2 = CollectionsKt___CollectionsKt.toList(this.currentItems);
        this.currentItems.clear();
        this.currentItems.addAll(list);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentAdapter", 1, "setItems oldList:" + list2.size() + " list:" + list.size());
        }
        list3 = CollectionsKt___CollectionsKt.toList(list);
        DiffUtil.calculateDiff(new C7800c(list2, list3)).dispatchUpdatesTo(this);
    }
}
