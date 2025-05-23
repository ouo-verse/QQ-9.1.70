package com.tencent.mobileqq.guild.feed.feedsquare.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionMediaRoomPart;
import com.tencent.mobileqq.guild.feed.feedsection.part.FeedSectionUnitedBridgePart;
import com.tencent.mobileqq.guild.feed.feedsection.part.GuildFeedVisitorMarginPart;
import com.tencent.mobileqq.guild.feed.feedsquare.data.l;
import com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareLoadingAnimPart;
import com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareNewFeedNavPart;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.FeedSectionListPart;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareFeedListViewModel;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k;
import com.tencent.mobileqq.guild.feed.fragment.GuildBasePartFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.part.GuildFeedSectionPublishBridgePart;
import com.tencent.mobileqq.guild.feed.part.RecyclerViewGifAutoPlayPart;
import com.tencent.mobileqq.guild.feed.part.at;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.feed.util.av;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.heartbeatreport.IFragmentStatusReportApi;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.VMMessenger;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.richframework.argus.node.ArgusTag;
import ef1.c;
import java.util.HashMap;
import java.util.Iterator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yl1.n;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Guild", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0002'D\b\u0007\u0018\u0000 P2\u00020\u0001:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0014J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0014J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J&\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\u0017\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%H\u0002\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020*2\u0006\u0010&\u001a\u00020%H\u0002J\u001a\u0010.\u001a\u00020\u00062\u0010\u0010\"\u001a\f\u0012\u0004\u0012\u00020%0,j\u0002`-H\u0002J\u0010\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0002H\u0002J\b\u00101\u001a\u00020\u0006H\u0002J\u0010\u00102\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0002R$\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020%\u0018\u00010,j\u0004\u0018\u0001`-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001d\u0010>\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010C\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR#\u0010M\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010;\u001a\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareSectionFragmentHome;", "Lcom/tencent/mobileqq/guild/feed/fragment/GuildBasePartFragment;", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onViewCreatedBeforePartInit", "onViewCreatedAfterPartInit", "Landroidx/fragment/app/Fragment;", "childFragment", "onAttachFragment", "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getStatusBarColor", "", "enableSetStatusBarColor", "needSupportFullScreen", "needAdjustImmersive", "enableRootViewSetFitsSystemWindows", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getContentLayoutId", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "getInitBean", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/c;", "sectionContext", "Mh", "Ph", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "bean", "com/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareSectionFragmentHome$d", "Kh", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;)Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareSectionFragmentHome$d;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "Jh", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionBeanImplContext;", "Rh", "view", "Gh", "Ih", "Lh", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", "D", "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", "mInitBean", "Lmp1/b;", "E", "Lkotlin/Lazy;", "Dh", "()Lmp1/b;", "guildHomeViewModel", "Lmp1/a;", UserInfo.SEX_FEMALE, "Eh", "()Lmp1/a;", "homeProvider", "com/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareSectionFragmentHome$b", "G", "Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareSectionFragmentHome$b;", "feedSquareSectionInfoIoc", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "H", "Fh", "()Landroidx/lifecycle/LiveData;", "sectionInfoLiveData", "<init>", "()V", "I", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareSectionFragmentHome extends GuildBasePartFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> sectionContext;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private GuildFeedSquareInitBean mInitBean;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildHomeViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeProvider;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b feedSquareSectionInfoIoc;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy sectionInfoLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareSectionFragmentHome$b", "Lxj1/e;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "b", "()Ljava/util/List;", "sectionInfoList", "a", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "currentSectionInfo", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements xj1.e {
        b() {
        }

        @Override // xj1.e
        @Nullable
        public l a() {
            LiveData Fh = GuildFeedSquareSectionFragmentHome.this.Fh();
            if (Fh != null) {
                return (l) Fh.getValue();
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
            LiveData Fh = GuildFeedSquareSectionFragmentHome.this.Fh();
            if (Fh == null || (r0 = (l) Fh.getValue()) == null || listOf == null) {
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
        final /* synthetic */ ViewModelStoreOwner f218854a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildFeedMainInitBean f218855b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildFeedSquareSectionFragmentHome f218856c;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildFeedMainInitBean guildFeedMainInitBean, GuildFeedSquareSectionFragmentHome guildFeedSquareSectionFragmentHome) {
            this.f218854a = viewModelStoreOwner;
            this.f218855b = guildFeedMainInitBean;
            this.f218856c = guildFeedSquareSectionFragmentHome;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Integer num;
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            Intrinsics.checkNotNull(this.f218855b, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean");
            GuildFeedSquareFeedListViewModel guildFeedSquareFeedListViewModel = new GuildFeedSquareFeedListViewModel(null, (GuildFeedSquareInitBean) this.f218855b, 1, null);
            jj1.b c16 = jj1.b.c();
            co1.d dVar = co1.d.f31167a;
            String guildId = ((GuildFeedSquareInitBean) this.f218855b).getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "bean.guildId");
            String channelId = ((GuildFeedSquareInitBean) this.f218855b).getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "bean.channelId");
            String c17 = av.f223852a.c(Integer.valueOf(((GuildFeedSquareInitBean) this.f218855b).getBusinessType()));
            Context context = this.f218856c.getContext();
            if (context != null) {
                num = Integer.valueOf(context.hashCode());
            } else {
                num = null;
            }
            c16.registerDisplaySurface(dVar.d(guildId, channelId, c17, String.valueOf(num)), guildFeedSquareFeedListViewModel);
            TimedValue timedValue = new TimedValue(guildFeedSquareFeedListViewModel, TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareSectionFragmentHome$d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/i;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionInitBeanSession;", "Lcom/tencent/mobileqq/guild/data/GuildSimpleContact;", "a", "Lcom/tencent/mobileqq/guild/data/GuildSimpleContact;", "d", "()Lcom/tencent/mobileqq/guild/data/GuildSimpleContact;", "contact", "", "b", "I", "c", "()I", "sectionType", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "e", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "transparentObj", "getBusinessType", "businessType", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<GuildFeedMainInitBean> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildSimpleContact contact;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int sectionType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildFeedMainInitBean transparentObj;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GuildFeedMainInitBean f218860d;

        d(GuildFeedMainInitBean guildFeedMainInitBean) {
            this.f218860d = guildFeedMainInitBean;
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
        /* renamed from: d, reason: from getter */
        public GuildSimpleContact getContact() {
            return this.contact;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i
        @NotNull
        /* renamed from: e, reason: from getter */
        public GuildFeedMainInitBean getTransparentObj() {
            return this.transparentObj;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i
        public int getBusinessType() {
            return this.f218860d.getBusinessType();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareSectionFragmentHome$e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/g;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionBeanImplContext;", "getContext", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "context", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "a", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "perfStageReportTask", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.feed.feedsquare.part.remake.c f218861a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IPerformanceReportTask f218862b;

        e(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.c cVar, IPerformanceReportTask iPerformanceReportTask) {
            this.f218861a = cVar;
            this.f218862b = iPerformanceReportTask;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g
        @NotNull
        /* renamed from: a, reason: from getter */
        public IPerformanceReportTask getF218862b() {
            return this.f218862b;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g
        @NotNull
        public com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> getContext() {
            return this.f218861a;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareSectionFragmentHome$f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/h;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/a;", "a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/a;", "c", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/a;", "recyclerViewGlobalConfig", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionBeanImplContext;", "b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "sectionContext", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f implements com.tencent.mobileqq.guild.feed.feedsquare.part.remake.h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.a recyclerViewGlobalConfig;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> sectionContext;

        f(GuildFeedSquareSectionFragmentHome guildFeedSquareSectionFragmentHome, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> bVar) {
            Context requireContext = guildFeedSquareSectionFragmentHome.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            this.recyclerViewGlobalConfig = new com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.a(requireContext);
            this.sectionContext = bVar;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.h
        @NotNull
        public com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> b() {
            return this.sectionContext;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.h
        @NotNull
        /* renamed from: c, reason: from getter */
        public com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.a getRecyclerViewGlobalConfig() {
            return this.recyclerViewGlobalConfig;
        }
    }

    public GuildFeedSquareSectionFragmentHome() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeViewModel>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.GuildFeedSquareSectionFragmentHome$guildHomeViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final GuildHomeViewModel invoke() {
                Object m476constructorimpl;
                String logTag;
                String logTag2;
                ViewModelStoreOwner b16 = com.tencent.mobileqq.guild.base.fragments.f.b(GuildFeedSquareSectionFragmentHome.this);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl((GuildHomeViewModel) new ViewModelProvider(b16).get(GuildHomeViewModel.class));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                GuildFeedSquareSectionFragmentHome guildFeedSquareSectionFragmentHome = GuildFeedSquareSectionFragmentHome.this;
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                    Logger logger = Logger.f235387a;
                    logTag2 = guildFeedSquareSectionFragmentHome.getTAG();
                    Intrinsics.checkNotNullExpressionValue(logTag2, "logTag");
                    Logger.b bVar = new Logger.b();
                    String str = "initViewModel(GuildHomeViewModel) error:" + m479exceptionOrNullimpl.getMessage();
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e(logTag2, 1, (String) it.next(), null);
                    }
                    m476constructorimpl = null;
                }
                GuildFeedSquareSectionFragmentHome guildFeedSquareSectionFragmentHome2 = GuildFeedSquareSectionFragmentHome.this;
                GuildHomeViewModel guildHomeViewModel = (GuildHomeViewModel) m476constructorimpl;
                Logger logger2 = Logger.f235387a;
                logTag = guildFeedSquareSectionFragmentHome2.getTAG();
                Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
                logger2.d().i(logTag, 1, "initViewModel(GuildHomeViewModel) id:" + System.identityHashCode(guildHomeViewModel));
                return guildHomeViewModel;
            }
        });
        this.guildHomeViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<mp1.a>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.GuildFeedSquareSectionFragmentHome$homeProvider$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final mp1.a invoke() {
                return (mp1.a) PartFragmentIOCKt.getIocInterface(GuildFeedSquareSectionFragmentHome.this, mp1.a.class);
            }
        });
        this.homeProvider = lazy2;
        this.feedSquareSectionInfoIoc = new b();
        lazy3 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new GuildFeedSquareSectionFragmentHome$sectionInfoLiveData$2(this));
        this.sectionInfoLiveData = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GuildFeedBaseInitBean Bh(GuildFeedSquareSectionFragmentHome this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.mInitBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GuildFeedBaseInitBean Ch(GuildFeedSquareSectionFragmentHome this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.getInitBean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final mp1.b Dh() {
        return (mp1.b) this.guildHomeViewModel.getValue();
    }

    private final mp1.a Eh() {
        return (mp1.a) this.homeProvider.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveData<l> Fh() {
        return (LiveData) this.sectionInfoLiveData.getValue();
    }

    private final void Gh(final View view) {
        String str;
        GuildFacadeType guildFacadeType;
        String str2;
        Map map;
        com.tencent.mobileqq.guild.home.viewmodels.e guildSubTabPageViewModel;
        LiveData<Integer> O1;
        String string;
        VideoReport.setPageId(view, "pg_sgrp_channel_feed_section");
        VideoReport.setPageLinkEnable(view, true);
        GuildFeedBaseInitBean initBean = getInitBean();
        if (initBean != null) {
            com.tencent.mobileqq.guild.feed.report.d.f223284a.g(view, initBean);
        }
        final HashMap hashMap = new HashMap();
        GuildFeedSquareInitBean guildFeedSquareInitBean = this.mInitBean;
        Unit unit = null;
        if (guildFeedSquareInitBean != null) {
            str = guildFeedSquareInitBean.getChannelId();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put("sgrp_sub_channel_id", str);
        hashMap.put("sgrp_section_name", "\u5168\u90e8");
        mp1.a Eh = Eh();
        if (Eh != null) {
            guildFacadeType = Eh.a();
        } else {
            guildFacadeType = null;
        }
        if (guildFacadeType == GuildFacadeType.GameCenter) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("sgrp_distribute_scene", str2);
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("sgrp_channel_extension_info")) != null) {
            str3 = string;
        }
        hashMap.put("sgrp_channel_extension_info", str3);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        mp1.b Dh = Dh();
        if (Dh != null && (guildSubTabPageViewModel = Dh.getGuildSubTabPageViewModel()) != null && (O1 = guildSubTabPageViewModel.O1()) != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.GuildFeedSquareSectionFragmentHome$initDtReport$2
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
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_sort_type", Short.valueOf(com.tencent.mobileqq.guild.feed.report.f.i(it.intValue()))));
                    plus = MapsKt__MapsKt.plus(map2, mapOf);
                    VideoReport.setPageParams(view, new PageParams((Map<String, ?>) plus));
                }
            };
            O1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedSquareSectionFragmentHome.Hh(Function1.this, obj);
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
    public static final void Hh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ih() {
        String str;
        GuildFeedBaseInitBean o16 = ax.o(this);
        if (o16 instanceof GuildFeedSquareInitBean) {
            GuildFeedSquareInitBean guildFeedSquareInitBean = (GuildFeedSquareInitBean) o16;
            this.mInitBean = guildFeedSquareInitBean;
            QLog.d("GuildFeedSquareSectionFragmentHome", 1, "getInitBeanSuccess:" + guildFeedSquareInitBean);
        }
        GuildFeedSquareInitBean guildFeedSquareInitBean2 = this.mInitBean;
        String str2 = null;
        if (guildFeedSquareInitBean2 != null) {
            str = guildFeedSquareInitBean2.getGuildId();
        } else {
            str = null;
        }
        GuildFeedSquareInitBean guildFeedSquareInitBean3 = this.mInitBean;
        if (guildFeedSquareInitBean3 != null) {
            str2 = guildFeedSquareInitBean3.getChannelId();
        }
        QLog.d("GuildFeedSquareSectionFragmentHome", 1, "initPageBean, guildId: " + str + ", channelId: " + str2);
    }

    private final k Jh(GuildFeedMainInitBean bean) {
        c.Companion companion = ef1.c.INSTANCE;
        Object obj = new ViewModelProvider(this, new c(this, bean, this)).get(GuildFeedSquareFeedListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(obj, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        return (k) obj;
    }

    private final d Kh(GuildFeedMainInitBean bean) {
        return new d(bean);
    }

    private final void Lh(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.c sectionContext) {
        PartFragmentIOCKt.registerIoc(this, new e(sectionContext, com.tencent.mobileqq.guild.feed.report.c.f223280a.y(qw1.b.f(getArguments(), "_extra_param_report_task_view_pager_tab"))), com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
    }

    private final void Mh(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.c sectionContext) {
        Rh(sectionContext);
        Ph();
        ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).initGuildTaskQueueManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(final GuildFeedMainInitBean bean, xj1.b bVar) {
        Intrinsics.checkNotNullParameter(bean, "$bean");
        bVar.x8(new Supplier() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.h
            @Override // androidx.core.util.Supplier
            public final Object get() {
                GuildFeedBaseInitBean Oh;
                Oh = GuildFeedSquareSectionFragmentHome.Oh(GuildFeedMainInitBean.this);
                return Oh;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GuildFeedBaseInitBean Oh(GuildFeedMainInitBean bean) {
        Intrinsics.checkNotNullParameter(bean, "$bean");
        return bean;
    }

    private final void Ph() {
        final String str;
        boolean z16;
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<GuildFeedMainInitBean> d16;
        GuildFeedMainInitBean transparentObj;
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> bVar = this.sectionContext;
        if (bVar != null && (d16 = bVar.d()) != null && (transparentObj = d16.getTransparentObj()) != null) {
            str = transparentObj.getChannelId();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.g
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedSquareSectionFragmentHome.Qh(str);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(String str) {
        GuildInfoManager.q().m(str);
    }

    private final void Rh(com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> sectionContext) {
        List<Part> listOf;
        LiveData<Integer> mutableLiveData;
        List<Part> listOf2;
        com.tencent.mobileqq.guild.home.viewmodels.e guildSubTabPageViewModel;
        f fVar = new f(this, sectionContext);
        PartManager partManager = getPartManager();
        if (partManager != null) {
            mp1.b Dh = Dh();
            if (Dh == null || (guildSubTabPageViewModel = Dh.getGuildSubTabPageViewModel()) == null || (mutableLiveData = guildSubTabPageViewModel.O1()) == null) {
                mutableLiveData = new MutableLiveData<>(3);
            }
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new FeedSectionListPart(new com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.l(mutableLiveData), fVar));
            partManager.registerPart(listOf2);
        }
        PartManager partManager2 = getPartManager();
        if (partManager2 != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new GuildFeedSquareNewFeedNavPart(sectionContext.getVmApi()));
            partManager2.registerPart(listOf);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new GuildFeedSquareLoadingAnimPart());
        linkedList.add(new com.tencent.mobileqq.guild.feed.feedsquare.part.h());
        linkedList.add(new FeedSectionUnitedBridgePart());
        linkedList.add(new FeedSectionMediaRoomPart());
        linkedList.add(new com.tencent.mobileqq.guild.feed.gallery.part.a(16));
        linkedList.add(new GuildFeedSectionPublishBridgePart(new Supplier() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.e
            @Override // androidx.core.util.Supplier
            public final Object get() {
                GuildFeedBaseInitBean Bh;
                Bh = GuildFeedSquareSectionFragmentHome.Bh(GuildFeedSquareSectionFragmentHome.this);
                return Bh;
            }
        }));
        linkedList.add(new GuildFeedVisitorMarginPart(new Supplier() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.f
            @Override // androidx.core.util.Supplier
            public final Object get() {
                GuildFeedBaseInitBean Ch;
                Ch = GuildFeedSquareSectionFragmentHome.Ch(GuildFeedSquareSectionFragmentHome.this);
                return Ch;
            }
        }));
        linkedList.add(new RecyclerViewGifAutoPlayPart(R.id.wen));
        linkedList.add(new at(R.id.wen));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected boolean enableSetStatusBarColor() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.erb;
    }

    @Nullable
    protected GuildFeedBaseInitBean getInitBean() {
        if (this.mInitBean == null) {
            Ih();
        }
        return this.mInitBean;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(@NotNull Fragment childFragment) {
        Intrinsics.checkNotNullParameter(childFragment, "childFragment");
        super.onAttachFragment(childFragment);
        Ih();
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildBasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.f235387a.d().i("GuildFeedSquareSectionFragmentHome", 1, "onCreate id:" + System.identityHashCode(this));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPerformanceReportTask duplicate;
        IPerformanceReportTask stageCode;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        IPerformanceReportTask g16 = qw1.b.g(getArguments(), null, 1, null);
        if (g16 != null && (duplicate = g16.duplicate(new String[0])) != null && (stageCode = duplicate.setStageCode("feed_square_pre_draw")) != null) {
            qw1.b.k(stageCode, onCreateView, null, 2, null);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildBasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mInitBean != null) {
            RFWIocAbilityProvider.g().unregisterSingleIoc(getView(), xj1.c.class);
        }
        PartFragmentIOCKt.unregisterIoc(this, xj1.e.class);
        com.tencent.mobileqq.guild.feed.widget.comment.d.f224303h.d();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        int i3;
        String str;
        boolean z16;
        super.onResume();
        GuildFeedSquareInitBean guildFeedSquareInitBean = this.mInitBean;
        if (guildFeedSquareInitBean != null) {
            if (guildFeedSquareInitBean.getJumpExtraInfo() != null) {
                String pageInSourceName = guildFeedSquareInitBean.getJumpExtraInfo().getPageInSourceName();
                Intrinsics.checkNotNullExpressionValue(pageInSourceName, "it.jumpExtraInfo.pageInSourceName");
                i3 = guildFeedSquareInitBean.getJumpExtraInfo().extraInfo.channelOpenSourceForOnlineReport;
                str = pageInSourceName;
                z16 = guildFeedSquareInitBean.getJumpExtraInfo().getStartFromGuildTab();
            } else {
                i3 = 0;
                str = "";
                z16 = false;
            }
            ((IFragmentStatusReportApi) QRoute.api(IFragmentStatusReportApi.class)).reportResume(guildFeedSquareInitBean.getGuildId(), guildFeedSquareInitBean.getChannelId(), Integer.valueOf(i3), str, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        GuildFeedSquareInitBean guildFeedSquareInitBean = this.mInitBean;
        if (guildFeedSquareInitBean == null) {
            Ih();
            guildFeedSquareInitBean = this.mInitBean;
            if (guildFeedSquareInitBean == null) {
                QLog.e("GuildFeedSquareSectionFragmentHome", 1, "[onViewCreatedAfterPartInit]: initPageBean fail");
                return;
            }
        }
        PartFragmentIOCKt.registerIoc(this, new ek1.a(guildFeedSquareInitBean), xj1.c.class);
        PartFragmentIOCKt.registerIoc(this, this.feedSquareSectionInfoIoc, xj1.e.class);
        Gh(contentView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildBasePartFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        GuildFeedMainInitBean guildFeedMainInitBean = null;
        VMMessenger vMMessenger = new VMMessenger(false, null, 3, null);
        PartFragmentIOCKt.registerIoc(this, vMMessenger, j.class);
        GuildFeedBaseInitBean initBean = getInitBean();
        if (initBean instanceof GuildFeedMainInitBean) {
            guildFeedMainInitBean = (GuildFeedMainInitBean) initBean;
        }
        final GuildFeedMainInitBean guildFeedMainInitBean2 = guildFeedMainInitBean;
        if (guildFeedMainInitBean2 == null) {
            return;
        }
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.c cVar = new com.tencent.mobileqq.guild.feed.feedsquare.part.remake.c(vMMessenger, this, Kh(guildFeedMainInitBean2), this, Jh(guildFeedMainInitBean2));
        this.sectionContext = cVar;
        Lh(cVar);
        uj1.d.f439072a.u();
        Mh(cVar);
        View fragmentContentView = getFragmentContentView();
        Intrinsics.checkNotNullExpressionValue(fragmentContentView, "fragmentContentView");
        n.t(fragmentContentView, xj1.b.class).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.fragment.d
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                GuildFeedSquareSectionFragmentHome.Nh(GuildFeedMainInitBean.this, (xj1.b) obj);
            }
        }).run();
    }
}
