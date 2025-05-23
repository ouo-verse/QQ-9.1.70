package com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.GuildRecommendDetailViewModel;
import com.tencent.mobileqq.guild.discovery.widget.GDiscoveryStatusView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendDetailLoadingPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", "parentView", "", "onInitView", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/u;", "d", "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/u;", "parentHost", "", "e", "I", "layoutId", "Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryStatusView;", "f", "Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryStatusView;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel;", tl.h.F, "Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/GuildRecommendDetailViewModel;", "viewModel", "<init>", "(Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/u;I)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildRecommendDetailLoadingPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final u parentHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int layoutId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GDiscoveryStatusView rootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildRecommendDetailViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/GuildRecommendDetailLoadingPart$b", "Lcom/tencent/mobileqq/guild/discovery/widget/GDiscoveryStatusView$a;", "", HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GDiscoveryStatusView.a {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.discovery.widget.GDiscoveryStatusView.a
        public void onRefresh() {
            GDiscoveryStatusView gDiscoveryStatusView;
            GDiscoveryStatusView gDiscoveryStatusView2;
            GuildRecommendDetailViewModel guildRecommendDetailViewModel = null;
            if (!NetworkUtil.isNetSupport(GuildRecommendDetailLoadingPart.this.getContext())) {
                GDiscoveryStatusView gDiscoveryStatusView3 = GuildRecommendDetailLoadingPart.this.rootView;
                if (gDiscoveryStatusView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    gDiscoveryStatusView2 = null;
                } else {
                    gDiscoveryStatusView2 = gDiscoveryStatusView3;
                }
                GDiscoveryStatusView.h(gDiscoveryStatusView2, true, null, false, 6, null);
                return;
            }
            GDiscoveryStatusView gDiscoveryStatusView4 = GuildRecommendDetailLoadingPart.this.rootView;
            if (gDiscoveryStatusView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                gDiscoveryStatusView = null;
            } else {
                gDiscoveryStatusView = gDiscoveryStatusView4;
            }
            GDiscoveryStatusView.h(gDiscoveryStatusView, false, null, false, 6, null);
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("guild.re.new.GuildRecommendDetailLoadingPart", 1, HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
            }
            GuildRecommendDetailViewModel guildRecommendDetailViewModel2 = GuildRecommendDetailLoadingPart.this.viewModel;
            if (guildRecommendDetailViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                guildRecommendDetailViewModel = guildRecommendDetailViewModel2;
            }
            guildRecommendDetailViewModel.refresh();
        }
    }

    public GuildRecommendDetailLoadingPart(@NotNull u parentHost, int i3) {
        Intrinsics.checkNotNullParameter(parentHost, "parentHost");
        this.parentHost = parentHost;
        this.layoutId = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View parentView) {
        GDiscoveryStatusView gDiscoveryStatusView;
        GDiscoveryStatusView gDiscoveryStatusView2;
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        super.onInitView(parentView);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("guild.re.new.GuildRecommendDetailLoadingPart", 2, "onInitView");
        }
        View findViewById = parentView.findViewById(this.layoutId);
        Intrinsics.checkNotNullExpressionValue(findViewById, "parentView.findViewById(layoutId)");
        GDiscoveryStatusView gDiscoveryStatusView3 = (GDiscoveryStatusView) findViewById;
        this.rootView = gDiscoveryStatusView3;
        if (gDiscoveryStatusView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            gDiscoveryStatusView3 = null;
        }
        gDiscoveryStatusView3.i();
        GDiscoveryStatusView gDiscoveryStatusView4 = this.rootView;
        if (gDiscoveryStatusView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            gDiscoveryStatusView = null;
        } else {
            gDiscoveryStatusView = gDiscoveryStatusView4;
        }
        GDiscoveryStatusView.h(gDiscoveryStatusView, false, null, false, 6, null);
        GuildRecommendDetailViewModel y75 = this.parentHost.y7();
        this.viewModel = y75;
        if (y75 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            y75 = null;
        }
        e12.a<GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp> discoverRecommendDetailRsp = y75.getDiscoverRecommendDetailRsp();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp, Unit> function1 = new Function1<GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendDetailLoadingPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp discoverRecommendDetailRsp2) {
                invoke2(discoverRecommendDetailRsp2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildRecommendDetailViewModel.DiscoverRecommendDetailRsp discoverRecommendDetailRsp2) {
                GDiscoveryStatusView gDiscoveryStatusView5;
                GDiscoveryStatusView gDiscoveryStatusView6 = null;
                if (discoverRecommendDetailRsp2.getResult().d()) {
                    GDiscoveryStatusView gDiscoveryStatusView7 = GuildRecommendDetailLoadingPart.this.rootView;
                    if (gDiscoveryStatusView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    } else {
                        gDiscoveryStatusView6 = gDiscoveryStatusView7;
                    }
                    gDiscoveryStatusView6.e();
                    return;
                }
                GDiscoveryStatusView gDiscoveryStatusView8 = GuildRecommendDetailLoadingPart.this.rootView;
                if (gDiscoveryStatusView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    gDiscoveryStatusView5 = null;
                } else {
                    gDiscoveryStatusView5 = gDiscoveryStatusView8;
                }
                String qqStr = HardCodeUtil.qqStr(R.string.f147440ww);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_list_fetch_error)");
                GDiscoveryStatusView.h(gDiscoveryStatusView5, true, qqStr, false, 4, null);
            }
        };
        discoverRecommendDetailRsp.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRecommendDetailLoadingPart.E9(Function1.this, obj);
            }
        });
        GuildRecommendDetailViewModel guildRecommendDetailViewModel = this.viewModel;
        if (guildRecommendDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildRecommendDetailViewModel = null;
        }
        e12.a<Boolean> themeChanged = guildRecommendDetailViewModel.getThemeChanged();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendDetailLoadingPart$onInitView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                GDiscoveryStatusView gDiscoveryStatusView5 = GuildRecommendDetailLoadingPart.this.rootView;
                if (gDiscoveryStatusView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    gDiscoveryStatusView5 = null;
                }
                gDiscoveryStatusView5.f();
            }
        };
        themeChanged.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRecommendDetailLoadingPart.F9(Function1.this, obj);
            }
        });
        GuildRecommendDetailViewModel guildRecommendDetailViewModel2 = this.viewModel;
        if (guildRecommendDetailViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildRecommendDetailViewModel2 = null;
        }
        e12.a<Boolean> networkInvalid = guildRecommendDetailViewModel2.getNetworkInvalid();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendDetailLoadingPart$onInitView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                GDiscoveryStatusView gDiscoveryStatusView5 = GuildRecommendDetailLoadingPart.this.rootView;
                if (gDiscoveryStatusView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    gDiscoveryStatusView5 = null;
                }
                GDiscoveryStatusView.h(gDiscoveryStatusView5, true, null, false, 6, null);
            }
        };
        networkInvalid.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRecommendDetailLoadingPart.G9(Function1.this, obj);
            }
        });
        GuildRecommendDetailViewModel guildRecommendDetailViewModel3 = this.viewModel;
        if (guildRecommendDetailViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildRecommendDetailViewModel3 = null;
        }
        e12.a<Boolean> hideLoading = guildRecommendDetailViewModel3.getHideLoading();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendDetailLoadingPart$onInitView$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                GDiscoveryStatusView gDiscoveryStatusView5;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                GDiscoveryStatusView gDiscoveryStatusView6 = null;
                if (it.booleanValue()) {
                    GDiscoveryStatusView gDiscoveryStatusView7 = GuildRecommendDetailLoadingPart.this.rootView;
                    if (gDiscoveryStatusView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    } else {
                        gDiscoveryStatusView6 = gDiscoveryStatusView7;
                    }
                    gDiscoveryStatusView6.e();
                    return;
                }
                GDiscoveryStatusView gDiscoveryStatusView8 = GuildRecommendDetailLoadingPart.this.rootView;
                if (gDiscoveryStatusView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    gDiscoveryStatusView5 = null;
                } else {
                    gDiscoveryStatusView5 = gDiscoveryStatusView8;
                }
                GDiscoveryStatusView.h(gDiscoveryStatusView5, false, null, false, 6, null);
            }
        };
        hideLoading.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRecommendDetailLoadingPart.H9(Function1.this, obj);
            }
        });
        GDiscoveryStatusView gDiscoveryStatusView5 = this.rootView;
        if (gDiscoveryStatusView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            gDiscoveryStatusView5 = null;
        }
        gDiscoveryStatusView5.setOnRefreshListener(new b());
        if (!NetworkUtil.isNetSupport(getContext())) {
            GDiscoveryStatusView gDiscoveryStatusView6 = this.rootView;
            if (gDiscoveryStatusView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                gDiscoveryStatusView2 = null;
            } else {
                gDiscoveryStatusView2 = gDiscoveryStatusView6;
            }
            GDiscoveryStatusView.h(gDiscoveryStatusView2, true, null, false, 6, null);
        }
    }
}
