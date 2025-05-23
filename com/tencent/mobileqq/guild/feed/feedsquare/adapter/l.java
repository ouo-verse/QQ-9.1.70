package com.tencent.mobileqq.guild.feed.feedsquare.adapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.data.SectionInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.fragment.GuildFeedSquareSectionFragmentHome;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.feed.util.av;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 32\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u00a2\u0006\u0004\b1\u00102J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0016\u0010\u0012\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u001d\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"RZ\u00100\u001a:\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000b\u0018\u00010$j\u0004\u0018\u0001`)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/l;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "list", "", "n0", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/m;", "info", "", "l0", "Landroidx/fragment/app/Fragment;", "k0", "", "position", "Landroid/os/Bundle;", "bundle", "j0", "setItems", "", "getItems", "itemId", "", "containsItem", "getItemId", "getItemCount", "createFragment", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/Fragment;", "parentFragment", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "sectionInfoList", "D", "Z", "isHomePage", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "sectionInfo", "parentArguments", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/SectionFragmentConstructor;", "E", "Lkotlin/jvm/functions/Function2;", "getSectionFragmentConstructor", "()Lkotlin/jvm/functions/Function2;", "setSectionFragmentConstructor", "(Lkotlin/jvm/functions/Function2;)V", "sectionFragmentConstructor", "<init>", "(Landroidx/fragment/app/Fragment;)V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l extends FragmentStateAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> sectionInfoList;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isHomePage;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function2<? super com.tencent.mobileqq.guild.feed.feedsquare.data.l, ? super Bundle, ? extends Fragment> sectionFragmentConstructor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment parentFragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull Fragment parentFragment) {
        super(parentFragment);
        Intrinsics.checkNotNullParameter(parentFragment, "parentFragment");
        this.parentFragment = parentFragment;
        this.sectionInfoList = new ArrayList();
        Bundle arguments = parentFragment.getArguments();
        boolean z16 = false;
        if (arguments != null && arguments.getInt("key_page_type", 0) == 4) {
            z16 = true;
        }
        this.isHomePage = z16;
    }

    private final Bundle j0(int position, Bundle bundle) {
        GuildFeedSquareInitBean guildFeedSquareInitBean = new GuildFeedSquareInitBean();
        GuildFeedBaseInitBean o16 = ax.o(this.parentFragment);
        guildFeedSquareInitBean.setChannelId(this.sectionInfoList.get(position).getSectionInfo().getChannelId());
        guildFeedSquareInitBean.setGuildId(o16.getGuildId());
        guildFeedSquareInitBean.setAttrs(o16.getAttrs());
        guildFeedSquareInitBean.setJoinInfoParam(o16.getJoinInfoParam());
        guildFeedSquareInitBean.setIsMember(o16.isMember());
        guildFeedSquareInitBean.setChannelName(this.sectionInfoList.get(position).getSectionInfo().getName());
        guildFeedSquareInitBean.setShareSource(o16.getShareSource());
        guildFeedSquareInitBean.setBusinessType(av.f223852a.a(this.sectionInfoList.get(position).getSectionInfo().getType()));
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putSerializable(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedSquareInitBean);
        Object obj = bundle2.get(com.tencent.mobileqq.guild.feed.b.f218115a);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean");
        GuildFeedSquareInitBean guildFeedSquareInitBean2 = (GuildFeedSquareInitBean) obj;
        com.tencent.xaction.log.b.a("GuildFeedSquareSectionAdapter", 1, "createFragmentArguments, bean = " + guildFeedSquareInitBean2 + ", channelId=" + guildFeedSquareInitBean2.getChannelId());
        return bundle2;
    }

    private final Fragment k0() {
        return new GuildFeedSquareSectionFragmentHome();
    }

    private final long l0(SectionInfo info) {
        int type = info.getType();
        if (type != 2 && type != 4 && type != 5) {
            return Long.parseLong(info.getChannelId());
        }
        return info.getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(l this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyDataSetChanged();
    }

    private final void n0(List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list) {
        this.sectionInfoList.clear();
        this.sectionInfoList.addAll(list);
        com.tencent.xaction.log.b.a("GuildFeedSquareSectionAdapter", 1, "[pageView2] updateItems, size = " + this.sectionInfoList.size());
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long itemId) {
        Iterator<com.tencent.mobileqq.guild.feed.feedsquare.data.l> it = this.sectionInfoList.iterator();
        while (it.hasNext()) {
            if (itemId == l0(it.next().getSectionInfo())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        Bundle parentBundle = this.parentFragment.getArguments();
        if (parentBundle == null) {
            parentBundle = Bundle.EMPTY;
        }
        Function2<? super com.tencent.mobileqq.guild.feed.feedsquare.data.l, ? super Bundle, ? extends Fragment> function2 = this.sectionFragmentConstructor;
        if (function2 != null) {
            com.tencent.mobileqq.guild.feed.feedsquare.data.l lVar = this.sectionInfoList.get(position);
            Intrinsics.checkNotNullExpressionValue(parentBundle, "parentBundle");
            return function2.invoke(lVar, parentBundle);
        }
        Bundle j06 = j0(position, parentBundle);
        Fragment k06 = k0();
        k06.setArguments(j06);
        return k06;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.sectionInfoList.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        if (position >= this.sectionInfoList.size()) {
            return super.getItemId(position);
        }
        return l0(this.sectionInfoList.get(position).getSectionInfo());
    }

    @NotNull
    public final List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> getItems() {
        return this.sectionInfoList;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setItems(@NotNull List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        n0(list);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.k
            @Override // java.lang.Runnable
            public final void run() {
                l.m0(l.this);
            }
        });
    }
}
