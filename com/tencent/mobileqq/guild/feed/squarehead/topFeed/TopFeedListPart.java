package com.tencent.mobileqq.guild.feed.squarehead.topFeed;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedRecommendCardUtils;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareTopViewModel;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTopView;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.m;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.data.base.UIStateData;
import ef1.c;
import ij1.GuildFeedsHeaderData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00015B\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b2\u00103J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\bH\u0016R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR#\u0010#\u001a\n \u001f*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0019R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/squarehead/topFeed/TopFeedListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/h;", "uiData", "", "K9", "Landroid/view/View;", "view", "feedData", "G9", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "detailInitBean", "P9", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "", "I9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "d", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "channelId", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTopView;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTopView;", "topListView", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "getGuildId", "guildId", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", h.F, "H9", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareTopViewModel;", "i", "J9", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareTopViewModel;", "viewModel", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isFirst", "<init>", "(Ljava/lang/String;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopFeedListPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildFeedSquareTopView topListView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildFacadeType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isFirst;

    public TopFeedListPart() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(View view, ij1.h feedData) {
        JumpGuildParam.JoinInfoParam joinInfoParam;
        if (feedData.Q > 0) {
            GuildFeedRecommendCardUtils guildFeedRecommendCardUtils = GuildFeedRecommendCardUtils.f219300a;
            Context context = view.getContext();
            com.tencent.mobileqq.guild.feed.feedsquare.utils.e eVar = new com.tencent.mobileqq.guild.feed.feedsquare.utils.e(feedData);
            xj1.c cVar = (xj1.c) PartIOCKt.getIocInterface(this, xj1.c.class);
            if (cVar != null) {
                joinInfoParam = cVar.b();
            } else {
                joinInfoParam = null;
            }
            guildFeedRecommendCardUtils.j(context, eVar, joinInfoParam);
            return;
        }
        GuildFeedDetailInitBean initFeedDetailInitBeanFromFeedTop = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeedTop(String.valueOf(feedData.H), String.valueOf(feedData.J), feedData);
        Intrinsics.checkNotNullExpressionValue(initFeedDetailInitBeanFromFeedTop, "this");
        P9(view, initFeedDetailInitBeanFromFeedTop);
        GProStFeed a16 = m.a(feedData.b().feed);
        initFeedDetailInitBeanFromFeedTop.setStFeed(a16);
        GuildFeedLauncher.x(view.getContext(), initFeedDetailInitBeanFromFeedTop, Boolean.valueOf(((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).needOpenNativeDetailPage(a16)));
    }

    private final GuildFacadeType H9() {
        return (GuildFacadeType) this.guildFacadeType.getValue();
    }

    private final int I9(GuildFeedBaseInitBean initBean) {
        if (initBean.getBusinessType() != 14) {
            return 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildFeedSquareTopViewModel J9() {
        return (GuildFeedSquareTopViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(UIStateData<List<ij1.h>> uiData) {
        if (uiData.isLoading()) {
            return;
        }
        GuildFeedSquareTopView guildFeedSquareTopView = this.topListView;
        GuildFeedSquareTopView guildFeedSquareTopView2 = null;
        if (guildFeedSquareTopView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topListView");
            guildFeedSquareTopView = null;
        }
        guildFeedSquareTopView.v0(this.isFirst);
        if (!uiData.isCacheData()) {
            this.isFirst = false;
        }
        List<ij1.h> data = uiData.getData();
        if (data == null) {
            data = new ArrayList<>();
        }
        QLog.i("GuildFeedTopFeedListPart", 1, "handleTopFeedUiStatus: size[" + data.size() + "]");
        GuildFeedSquareTopView guildFeedSquareTopView3 = this.topListView;
        if (guildFeedSquareTopView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topListView");
        } else {
            guildFeedSquareTopView2 = guildFeedSquareTopView3;
        }
        guildFeedSquareTopView2.setFeedTopListData(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(final TopFeedListPart this$0, tj1.a aVar) {
        List emptyList;
        GuildFeedsHeaderData data;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIStateData<GuildFeedsHeaderData> value = aVar.getData().getValue();
        if (value == null || (data = value.getData()) == null || (emptyList = data.d()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        QLog.i("GuildFeedTopFeedListPart", 1, "[IFeedsHeaderDataSource] initialData: size[" + emptyList.size() + "]");
        MutableLiveData<UIStateData<GuildFeedsHeaderData>> data2 = aVar.getData();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this$0);
        final Function1<UIStateData<GuildFeedsHeaderData>, Unit> function1 = new Function1<UIStateData<GuildFeedsHeaderData>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.squarehead.topFeed.TopFeedListPart$onInitView$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<GuildFeedsHeaderData> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<GuildFeedsHeaderData> uIStateData) {
                GuildFeedSquareTopViewModel J9;
                J9 = TopFeedListPart.this.J9();
                UIStateData<List<ij1.h>> dataList = UIStateData.obtainSuccess(uIStateData.isCacheData()).setDataList(uIStateData.getData().d());
                Intrinsics.checkNotNullExpressionValue(dataList, "obtainSuccess<MutableLis\u2026DataList(it.data.topData)");
                J9.U1(dataList);
            }
        };
        data2.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.squarehead.topFeed.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopFeedListPart.M9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(String str) {
        QLog.i("GuildFeedTopFeedListPart", 1, "getIoc fail [IFeedsHeaderDataSource] initialData is empty: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P9(View view, GuildFeedDetailInitBean detailInitBean) {
        GuildFeedBaseInitBean initBean;
        xj1.c cVar = (xj1.c) RFWIocAbilityProvider.g().getIocInterface(xj1.c.class, view, null);
        if (cVar != null && (initBean = cVar.getInitBean()) != null) {
            detailInitBean.setBusinessType(initBean.getBusinessType());
            detailInitBean.setShareSource(initBean.getShareSource());
            detailInitBean.setJoinInfoParam(initBean.getJoinInfoParam());
            detailInitBean.setImmersiveSource(mk1.e.f(initBean, I9(initBean)));
            detailInitBean.setFromPage(1);
            detailInitBean.setIsMember(true ^ ch.j0(detailInitBean.getGuildId()));
            detailInitBean.setBusinessType(16);
        }
    }

    private final String getGuildId() {
        return (String) this.guildId.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = ((ViewStub) rootView.findViewById(R.id.f99815qt)).inflate().findViewById(R.id.wew);
        Intrinsics.checkNotNullExpressionValue(findViewById, "inflatedView.findViewByI\u2026ild_feed_square_top_view)");
        GuildFeedSquareTopView guildFeedSquareTopView = (GuildFeedSquareTopView) findViewById;
        this.topListView = guildFeedSquareTopView;
        if (guildFeedSquareTopView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topListView");
            guildFeedSquareTopView = null;
        }
        guildFeedSquareTopView.setOnFeedTopItemClickListener(new Function2<ij1.h, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.squarehead.topFeed.TopFeedListPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ij1.h hVar, Integer num) {
                invoke(hVar, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable ij1.h hVar, int i3) {
                GuildFeedSquareTopView guildFeedSquareTopView2;
                if (hVar != null) {
                    TopFeedListPart topFeedListPart = TopFeedListPart.this;
                    guildFeedSquareTopView2 = topFeedListPart.topListView;
                    if (guildFeedSquareTopView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topListView");
                        guildFeedSquareTopView2 = null;
                    }
                    topFeedListPart.G9(guildFeedSquareTopView2, hVar);
                }
            }
        });
        GuildFeedSquareTopViewModel J9 = J9();
        String guildId = getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        J9.Q1(guildId, this.channelId, H9());
        RFWIocAbilityProvider.g().getIoc(tj1.a.class).originView(rootView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.squarehead.topFeed.b
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                TopFeedListPart.L9(TopFeedListPart.this, (tj1.a) obj);
            }
        }).fail(new OnPromiseRejected() { // from class: com.tencent.mobileqq.guild.feed.squarehead.topFeed.c
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public final void onFail(String str) {
                TopFeedListPart.N9(str);
            }
        }).run();
        LiveData<UIStateData<List<ij1.h>>> P1 = J9().P1();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final TopFeedListPart$onInitView$4 topFeedListPart$onInitView$4 = new TopFeedListPart$onInitView$4(this);
        P1.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.squarehead.topFeed.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopFeedListPart.O9(Function1.this, obj);
            }
        });
    }

    public TopFeedListPart(@NotNull String channelId) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.channelId = channelId;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.feed.squarehead.topFeed.TopFeedListPart$guildId$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return ax.o(TopFeedListPart.this.getHostFragment()).getGuildId();
            }
        });
        this.guildId = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildFacadeType>() { // from class: com.tencent.mobileqq.guild.feed.squarehead.topFeed.TopFeedListPart$guildFacadeType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFacadeType invoke() {
                Serializable serializable = GuildSplitViewUtils.f235370a.h(TopFeedListPart.this.getPartHost()).getSerializable("guild_facade_type");
                GuildFacadeType guildFacadeType = serializable instanceof GuildFacadeType ? (GuildFacadeType) serializable : null;
                return guildFacadeType == null ? GuildFacadeType.FeedsGuildHome9015 : guildFacadeType;
            }
        });
        this.guildFacadeType = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedSquareTopViewModel>() { // from class: com.tencent.mobileqq.guild.feed.squarehead.topFeed.TopFeedListPart$viewModel$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f223501a;

                public a(ViewModelStoreOwner viewModelStoreOwner) {
                    this.f223501a = viewModelStoreOwner;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new GuildFeedSquareTopViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFeedSquareTopViewModel invoke() {
                c.Companion companion = ef1.c.INSTANCE;
                IPartHost partHost = TopFeedListPart.this.getPartHost();
                Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
                ViewModel viewModel = new ViewModelProvider(partHost, new a(partHost)).get(GuildFeedSquareTopViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (GuildFeedSquareTopViewModel) viewModel;
            }
        });
        this.viewModel = lazy3;
        this.isFirst = true;
    }

    public /* synthetic */ TopFeedListPart(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "0" : str);
    }
}
