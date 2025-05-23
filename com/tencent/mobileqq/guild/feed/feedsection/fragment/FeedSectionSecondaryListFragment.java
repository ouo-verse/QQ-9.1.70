package com.tencent.mobileqq.guild.feed.feedsection.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.util.Supplier;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart;
import com.tencent.mobileqq.guild.feed.feedsection.part.GuildFeedVisitorMarginPart;
import com.tencent.mobileqq.guild.feed.feedsquare.data.l;
import com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareLoadingAnimPart;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.n;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.h;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSectionFeedListViewModel;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.part.GuildFeedSectionPublishBridgePart;
import com.tencent.mobileqq.guild.feed.part.RecyclerViewGifAutoPlayPart;
import com.tencent.mobileqq.guild.feed.part.at;
import com.tencent.mobileqq.guild.feed.report.f;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.feed.util.av;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.richframework.argus.node.ArgusTag;
import ef1.c;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Guild", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0002\b?\b\u0007\u0018\u0000 K2\u00020\u0001:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0014\u001a\u00020\u00042\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00060\u0012j\u0002`\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0014J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\b\u0010 \u001a\u00020\u0004H\u0014R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010.\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R$\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012j\u0004\u0018\u0001`\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001d\u00109\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010+\u001a\u0004\b7\u00108R\u001d\u0010>\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010+\u001a\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR#\u0010H\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010+\u001a\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsection/fragment/FeedSectionSecondaryListFragment;", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/f;", "sectionContext", "", "Hh", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "bean", "com/tencent/mobileqq/guild/feed/feedsection/fragment/FeedSectionSecondaryListFragment$d", "Gh", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;)Lcom/tencent/mobileqq/guild/feed/feedsection/fragment/FeedSectionSecondaryListFragment$d;", "Ih", "Jh", "Landroid/os/Bundle;", "args", "Lh", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "Fh", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionBeanImplContext;", "Mh", "Landroid/view/View;", "view", "Dh", "contentView", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "Ljava/util/LinkedList;", "Lcom/tencent/biz/richframework/part/Part;", "wh", "", "getContentLayoutId", "onFragmentViewDestroyed", "Lcom/tencent/mvi/base/route/j;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/base/route/j;", "messenger", "Lxj1/c;", "D", "Lxj1/c;", "dtReporter", "Lmp1/a;", "E", "Lkotlin/Lazy;", OcrConfig.CHINESE, "()Lmp1/a;", "homeProvider", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "", "G", "Ljava/lang/Object;", "abilityProviderRef", "Lcom/tencent/mobileqq/guild/home/subhome/a;", "H", "Ch", "()Lcom/tencent/mobileqq/guild/home/subhome/a;", "subHomeViewModel", "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", "I", "Ah", "()Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", "mInitBean", "com/tencent/mobileqq/guild/feed/feedsection/fragment/FeedSectionSecondaryListFragment$b", "J", "Lcom/tencent/mobileqq/guild/feed/feedsection/fragment/FeedSectionSecondaryListFragment$b;", "feedSectionInfoIoc", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "K", "Bh", "()Landroidx/lifecycle/LiveData;", "sectionInfoLiveData", "<init>", "()V", "L", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSectionSecondaryListFragment extends BasePartFragment {

    @NotNull
    private static final a L = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private j messenger;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private xj1.c dtReporter;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeProvider;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> sectionContext;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Object abilityProviderRef;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy subHomeViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy mInitBean;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b feedSectionInfoIoc;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy sectionInfoLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsection/fragment/FeedSectionSecondaryListFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsection/fragment/FeedSectionSecondaryListFragment$b", "Lxj1/e;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "b", "()Ljava/util/List;", "sectionInfoList", "a", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "currentSectionInfo", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements xj1.e {
        b() {
        }

        @Override // xj1.e
        @Nullable
        public l a() {
            LiveData Bh = FeedSectionSecondaryListFragment.this.Bh();
            if (Bh != null) {
                return (l) Bh.getValue();
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
        
            r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r0);
         */
        @Override // xj1.e
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<l> b() {
            List<l> emptyList;
            List<l> listOf;
            LiveData Bh = FeedSectionSecondaryListFragment.this.Bh();
            if (Bh == null || (r0 = (l) Bh.getValue()) == null || listOf == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            return listOf;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f218626a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildFeedMainInitBean f218627b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FeedSectionSecondaryListFragment f218628c;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildFeedMainInitBean guildFeedMainInitBean, FeedSectionSecondaryListFragment feedSectionSecondaryListFragment) {
            this.f218626a = viewModelStoreOwner;
            this.f218627b = guildFeedMainInitBean;
            this.f218628c = feedSectionSecondaryListFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Integer num;
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            GuildFeedSectionFeedListViewModel guildFeedSectionFeedListViewModel = new GuildFeedSectionFeedListViewModel(null, this.f218627b, 1, 0 == true ? 1 : 0);
            jj1.b c16 = jj1.b.c();
            co1.d dVar = co1.d.f31167a;
            String guildId = this.f218627b.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "bean.guildId");
            String channelId = this.f218627b.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "bean.channelId");
            String c17 = av.f223852a.c(Integer.valueOf(this.f218627b.getBusinessType()));
            Context context = this.f218628c.getContext();
            if (context != null) {
                num = Integer.valueOf(context.hashCode());
            } else {
                num = null;
            }
            c16.registerDisplaySurface(dVar.d(guildId, channelId, c17, String.valueOf(num)), guildFeedSectionFeedListViewModel);
            TimedValue timedValue = new TimedValue(guildFeedSectionFeedListViewModel, TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsection/fragment/FeedSectionSecondaryListFragment$d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionInitBeanSession;", "Lcom/tencent/mobileqq/guild/data/GuildSimpleContact;", "a", "Lcom/tencent/mobileqq/guild/data/GuildSimpleContact;", "d", "()Lcom/tencent/mobileqq/guild/data/GuildSimpleContact;", "contact", "", "b", "I", "c", "()I", "sectionType", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "e", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "transparentObj", "getBusinessType", "businessType", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements i<GuildFeedMainInitBean> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildSimpleContact contact;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int sectionType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildFeedMainInitBean transparentObj;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GuildFeedMainInitBean f218632d;

        d(GuildFeedMainInitBean guildFeedMainInitBean) {
            this.f218632d = guildFeedMainInitBean;
            String guildId = guildFeedMainInitBean.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "bean.guildId");
            String channelId = guildFeedMainInitBean.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "bean.channelId");
            this.contact = new GuildSimpleContact(guildId, channelId);
            this.sectionType = av.f223852a.g(guildFeedMainInitBean.getBusinessType());
            this.transparentObj = guildFeedMainInitBean;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i
        /* renamed from: c, reason: from getter */
        public int getSectionType() {
            return this.sectionType;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i
        @NotNull
        /* renamed from: d, reason: from getter and merged with bridge method [inline-methods] */
        public GuildSimpleContact a() {
            return this.contact;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i
        @NotNull
        /* renamed from: e, reason: from getter and merged with bridge method [inline-methods] */
        public GuildFeedMainInitBean b() {
            return this.transparentObj;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i
        public int getBusinessType() {
            return this.f218632d.getBusinessType();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsection/fragment/FeedSectionSecondaryListFragment$e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/g;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionBeanImplContext;", "getContext", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "context", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "a", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "perfStageReportTask", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.feed.feedsquare.part.remake.f f218633a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IPerformanceReportTask f218634b;

        e(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.f fVar, IPerformanceReportTask iPerformanceReportTask) {
            this.f218633a = fVar;
            this.f218634b = iPerformanceReportTask;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g
        @NotNull
        /* renamed from: a, reason: from getter */
        public IPerformanceReportTask getF218634b() {
            return this.f218634b;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g
        @NotNull
        public com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> getContext() {
            return this.f218633a;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R$\u0010\r\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsection/fragment/FeedSectionSecondaryListFragment$f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/h;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", "a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", "recyclerViewGlobalConfig", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionBeanImplContext;", "b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "sectionContext", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j recyclerViewGlobalConfig;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> sectionContext;

        f(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.a aVar, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> bVar) {
            this.recyclerViewGlobalConfig = aVar;
            this.sectionContext = bVar;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.h
        @NotNull
        /* renamed from: a, reason: from getter */
        public com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j getRecyclerViewGlobalConfig() {
            return this.recyclerViewGlobalConfig;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.h
        @NotNull
        public com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> b() {
            return this.sectionContext;
        }
    }

    public FeedSectionSecondaryListFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<mp1.a>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.fragment.FeedSectionSecondaryListFragment$homeProvider$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final mp1.a invoke() {
                return (mp1.a) PartFragmentIOCKt.getIocInterface(FeedSectionSecondaryListFragment.this, mp1.a.class);
            }
        });
        this.homeProvider = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.home.subhome.a>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.fragment.FeedSectionSecondaryListFragment$subHomeViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final com.tencent.mobileqq.guild.home.subhome.a invoke() {
                Object m476constructorimpl;
                FeedSectionSecondaryListFragment feedSectionSecondaryListFragment = FeedSectionSecondaryListFragment.this;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl((com.tencent.mobileqq.guild.home.subhome.a) new ViewModelProvider(feedSectionSecondaryListFragment.requireParentFragment()).get(com.tencent.mobileqq.guild.home.subhome.a.class));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                    m476constructorimpl = null;
                }
                com.tencent.mobileqq.guild.home.subhome.a aVar = (com.tencent.mobileqq.guild.home.subhome.a) m476constructorimpl;
                Logger.f235387a.d().i("FeedSection.SecondaryListFragment", 1, "initViewModel(GuildHomeSubFeedSectionViewModel) id:" + System.identityHashCode(aVar));
                return aVar;
            }
        });
        this.subHomeViewModel = lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<GuildFeedSquareInitBean>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.fragment.FeedSectionSecondaryListFragment$mInitBean$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GuildFeedSquareInitBean invoke() {
                Bundle arguments = FeedSectionSecondaryListFragment.this.getArguments();
                Serializable serializable = arguments != null ? arguments.getSerializable(com.tencent.mobileqq.guild.feed.b.f218115a) : null;
                if (serializable instanceof GuildFeedSquareInitBean) {
                    return (GuildFeedSquareInitBean) serializable;
                }
                return null;
            }
        });
        this.mInitBean = lazy3;
        this.feedSectionInfoIoc = new b();
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new FeedSectionSecondaryListFragment$sectionInfoLiveData$2(this));
        this.sectionInfoLiveData = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildFeedSquareInitBean Ah() {
        return (GuildFeedSquareInitBean) this.mInitBean.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveData<l> Bh() {
        return (LiveData) this.sectionInfoLiveData.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.home.subhome.a Ch() {
        return (com.tencent.mobileqq.guild.home.subhome.a) this.subHomeViewModel.getValue();
    }

    private final void Dh(final View view) {
        String str;
        String str2;
        GuildFacadeType guildFacadeType;
        String str3;
        Map map;
        MutableLiveData<Integer> N1;
        String string;
        VideoReport.setPageId(view, "pg_sgrp_channel_feed_section");
        VideoReport.setPageLinkEnable(view, true);
        GuildFeedSquareInitBean Ah = Ah();
        if (Ah != null) {
            com.tencent.mobileqq.guild.feed.report.d.f223284a.g(view, Ah);
        }
        final HashMap hashMap = new HashMap();
        GuildFeedSquareInitBean Ah2 = Ah();
        Unit unit = null;
        if (Ah2 != null) {
            str = Ah2.getChannelId();
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put("sgrp_sub_channel_id", str);
        GuildFeedSquareInitBean Ah3 = Ah();
        if (Ah3 != null) {
            str2 = Ah3.getChannelName();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("sgrp_section_name", str2);
        mp1.a zh5 = zh();
        if (zh5 != null) {
            guildFacadeType = zh5.a();
        } else {
            guildFacadeType = null;
        }
        if (guildFacadeType == GuildFacadeType.GameCenter) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap.put("sgrp_distribute_scene", str3);
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("sgrp_channel_extension_info")) != null) {
            str4 = string;
        }
        hashMap.put("sgrp_channel_extension_info", str4);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setPageParams(view, new PageParams(hashMap));
        com.tencent.mobileqq.guild.home.subhome.a Ch = Ch();
        if (Ch != null && (N1 = Ch.N1()) != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsection.fragment.FeedSectionSecondaryListFragment$initDtReport$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer it) {
                    Map mapOf;
                    Map plus;
                    Map<String, Object> map2 = hashMap;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_sort_type", Short.valueOf(f.i(it.intValue()))));
                    plus = MapsKt__MapsKt.plus(map2, mapOf);
                    VideoReport.setPageParams(view, new PageParams((Map<String, ?>) plus));
                }
            };
            N1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsection.fragment.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FeedSectionSecondaryListFragment.Eh(Function1.this, obj);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            VideoReport.setPageParams(view, new PageParams(hashMap));
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        map = MapsKt__MapsKt.toMap(hashMap);
        com.tencent.mobileqq.guild.feed.report.d.d(view, "em_sgrp_page_section", clickPolicy, exposurePolicy, endExposurePolicy, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final k Fh(GuildFeedMainInitBean bean) {
        c.Companion companion = ef1.c.INSTANCE;
        Object obj = new ViewModelProvider(this, new c(this, bean, this)).get(GuildFeedSectionFeedListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(obj, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        return (k) obj;
    }

    private final d Gh(GuildFeedMainInitBean bean) {
        return new d(bean);
    }

    private final void Hh(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.f sectionContext) {
        e eVar = new e(sectionContext, com.tencent.mobileqq.guild.feed.report.c.f223280a.G());
        PartFragmentIOCKt.registerIoc(this, eVar, g.class);
        this.abilityProviderRef = eVar;
    }

    private final void Ih() {
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> bVar = this.sectionContext;
        Intrinsics.checkNotNull(bVar);
        GuildFeedMainInitBean b16 = bVar.d().b();
        Intrinsics.checkNotNull(b16);
        ek1.a aVar = new ek1.a(b16);
        PartFragmentIOCKt.registerIoc(this, aVar, xj1.c.class);
        this.dtReporter = aVar;
        Jh();
    }

    private final void Jh() {
        final String str;
        boolean z16;
        i<GuildFeedMainInitBean> d16;
        GuildFeedMainInitBean b16;
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> bVar = this.sectionContext;
        if (bVar != null && (d16 = bVar.d()) != null && (b16 = d16.b()) != null) {
            str = b16.getChannelId();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsection.fragment.a
                @Override // java.lang.Runnable
                public final void run() {
                    FeedSectionSecondaryListFragment.Kh(str);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(String str) {
        GuildInfoManager.q().m(str);
    }

    private final GuildFeedMainInitBean Lh(Bundle args) {
        GuildFeedMainInitBean guildFeedMainInitBean;
        Serializable serializable = args.getSerializable(com.tencent.mobileqq.guild.feed.b.f218115a);
        if (serializable instanceof GuildFeedMainInitBean) {
            guildFeedMainInitBean = (GuildFeedMainInitBean) serializable;
        } else {
            guildFeedMainInitBean = null;
        }
        if (guildFeedMainInitBean == null) {
            return new GuildFeedSquareInitBean();
        }
        return guildFeedMainInitBean;
    }

    private final void Mh(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> sectionContext) {
        MutableLiveData<Integer> mutableLiveData;
        List<Part> listOf;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        f fVar = new f(new com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.a(requireContext), sectionContext);
        PartManager partManager = getPartManager();
        if (partManager != null) {
            com.tencent.mobileqq.guild.home.subhome.a Ch = Ch();
            if (Ch == null || (mutableLiveData = Ch.N1()) == null) {
                mutableLiveData = new MutableLiveData<>(3);
            }
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new FeedSectionListPart(new n(mutableLiveData), fVar));
            partManager.registerPart(listOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GuildFeedBaseInitBean xh(FeedSectionSecondaryListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.Ah();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GuildFeedBaseInitBean yh(FeedSectionSecondaryListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.Ah();
    }

    private final mp1.a zh() {
        return (mp1.a) this.homeProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eql;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onFragmentViewDestroyed() {
        super.onFragmentViewDestroyed();
        PartFragmentIOCKt.unregisterIoc(this, g.class);
        PartFragmentIOCKt.unregisterIoc(this, xj1.c.class);
        PartFragmentIOCKt.unregisterIoc(this, xj1.e.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        j jVar = (j) PartFragmentIOCKt.getIocInterface(this, j.class);
        this.messenger = jVar;
        if (jVar == null) {
            QLog.e("FeedSection.SecondaryListFragment", 1, "[onViewCreatedBeforePartInit]: didn't find any messenger, functionality may be affected");
            return;
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = Bundle.EMPTY;
        }
        Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: Bundle.EMPTY");
        GuildFeedMainInitBean Lh = Lh(arguments);
        k Fh = Fh(Lh);
        j jVar2 = this.messenger;
        Intrinsics.checkNotNull(jVar2);
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.f fVar = new com.tencent.mobileqq.guild.feed.feedsquare.part.remake.f(jVar2, this, Gh(Lh), this, Fh);
        this.sectionContext = fVar;
        Hh(fVar);
        Mh(fVar);
        Ih();
        PartFragmentIOCKt.registerIoc(this, this.feedSectionInfoIoc, xj1.e.class);
        Dh(contentView);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    /* renamed from: wh, reason: merged with bridge method [inline-methods] */
    public LinkedList<Part> assembleParts() {
        LinkedList<Part> linkedList = new LinkedList<>();
        linkedList.add(new RecyclerViewGifAutoPlayPart(R.id.wen));
        linkedList.add(new at(R.id.wen));
        linkedList.add(new com.tencent.mobileqq.guild.feed.feedsquare.part.h());
        linkedList.add(new GuildFeedSquareLoadingAnimPart());
        linkedList.add(new FeedSectionUnitedBridgePart());
        linkedList.add(new GuildFeedSectionPublishBridgePart(new Supplier() { // from class: com.tencent.mobileqq.guild.feed.feedsection.fragment.b
            @Override // androidx.core.util.Supplier
            public final Object get() {
                GuildFeedBaseInitBean xh5;
                xh5 = FeedSectionSecondaryListFragment.xh(FeedSectionSecondaryListFragment.this);
                return xh5;
            }
        }));
        linkedList.add(new GuildFeedVisitorMarginPart(new Supplier() { // from class: com.tencent.mobileqq.guild.feed.feedsection.fragment.c
            @Override // androidx.core.util.Supplier
            public final Object get() {
                GuildFeedBaseInitBean yh5;
                yh5 = FeedSectionSecondaryListFragment.yh(FeedSectionSecondaryListFragment.this);
                return yh5;
            }
        }));
        linkedList.add(new com.tencent.mobileqq.guild.feed.gallery.part.a(15));
        return linkedList;
    }
}
