package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import bp1.RefreshAnimateState;
import bp1.StartRefreshAnimateState;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.subhome.GuildHomeSubFragmentBehavior;
import com.tencent.mobileqq.guild.home.subhome.g;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.views.GuildLoadingFrameLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.guild.widget.banner.OverScrollLoadingView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\u0007\u001a\u00020\u0002*\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeRefreshLoadingPart;", "Lcom/tencent/mobileqq/guild/home/parts/a;", "", "S9", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "T9", "Lcom/tencent/mobileqq/guild/home/views/GuildLoadingFrameLayout;", "Q9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "e", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "onStateUpdate", "f", "Lcom/tencent/mobileqq/guild/home/views/GuildLoadingFrameLayout;", "loadingLayout", "", tl.h.F, "Z", "isLoading", "", "i", "J", "refreshTimeStamp", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeRefreshLoadingPart extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.subhome.g onStateUpdate = T9();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildLoadingFrameLayout loadingLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isLoading;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long refreshTimeStamp;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeRefreshLoadingPart$b", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "Lbp1/a;", "state", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.home.subhome.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f224961b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildHomeRefreshLoadingPart f224962c;

        public b(String str, GuildHomeRefreshLoadingPart guildHomeRefreshLoadingPart) {
            this.f224961b = str;
            this.f224962c = guildHomeRefreshLoadingPart;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.home.subhome.g
        public void a(@NotNull bp1.a state) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (!this.f224962c.isLoading) {
                GuildLoadingFrameLayout guildLoadingFrameLayout = null;
                if (state instanceof bp1.w) {
                    GuildLoadingFrameLayout guildLoadingFrameLayout2 = this.f224962c.loadingLayout;
                    if (guildLoadingFrameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                        guildLoadingFrameLayout2 = null;
                    }
                    if (guildLoadingFrameLayout2.getVisibility() != 0) {
                        GuildLoadingFrameLayout guildLoadingFrameLayout3 = this.f224962c.loadingLayout;
                        if (guildLoadingFrameLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                            guildLoadingFrameLayout3 = null;
                        }
                        guildLoadingFrameLayout3.setVisibility(0);
                    }
                    GuildLoadingFrameLayout guildLoadingFrameLayout4 = this.f224962c.loadingLayout;
                    if (guildLoadingFrameLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                        guildLoadingFrameLayout4 = null;
                    }
                    guildLoadingFrameLayout4.getInnerLoadingView().setLoadingDistance(((bp1.w) state).getLoadingDistance());
                    GuildLoadingFrameLayout guildLoadingFrameLayout5 = this.f224962c.loadingLayout;
                    if (guildLoadingFrameLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                        guildLoadingFrameLayout5 = null;
                    }
                    guildLoadingFrameLayout5.getInnerLoadingView().h((int) state.getOffset());
                    if (state instanceof RefreshAnimateState) {
                        if (((bp1.w) state).getIsDisplayLoadingView()) {
                            GuildLoadingFrameLayout guildLoadingFrameLayout6 = this.f224962c.loadingLayout;
                            if (guildLoadingFrameLayout6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                            } else {
                                guildLoadingFrameLayout = guildLoadingFrameLayout6;
                            }
                            guildLoadingFrameLayout.getInnerLoadingView().setDynamicImageDrawable();
                            this.f224962c.isLoading = true;
                            this.f224962c.refreshTimeStamp = SystemClock.uptimeMillis();
                            final GuildHomeRefreshLoadingPart guildHomeRefreshLoadingPart = this.f224962c;
                            Function0.b(30000, new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeRefreshLoadingPart$newStateUpdateCallback$1$1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    GuildHomeRefreshLoadingPart.this.S9();
                                }
                            });
                            return;
                        }
                        GuildLoadingFrameLayout guildLoadingFrameLayout7 = this.f224962c.loadingLayout;
                        if (guildLoadingFrameLayout7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                        } else {
                            guildLoadingFrameLayout = guildLoadingFrameLayout7;
                        }
                        guildLoadingFrameLayout.getInnerLoadingView().setStaticImageDrawable();
                        return;
                    }
                    if (state instanceof StartRefreshAnimateState) {
                        Logger.f235387a.d().i("Guild.NewHome.GuildHomeRefreshLoadingPart", 1, "startRefresh! ");
                        this.f224962c.E9().h2();
                        return;
                    }
                    return;
                }
                GuildLoadingFrameLayout guildLoadingFrameLayout8 = this.f224962c.loadingLayout;
                if (guildLoadingFrameLayout8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    guildLoadingFrameLayout8 = null;
                }
                if (guildLoadingFrameLayout8.getVisibility() == 0) {
                    GuildLoadingFrameLayout guildLoadingFrameLayout9 = this.f224962c.loadingLayout;
                    if (guildLoadingFrameLayout9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    } else {
                        guildLoadingFrameLayout = guildLoadingFrameLayout9;
                    }
                    guildLoadingFrameLayout.setVisibility(4);
                }
            }
        }
    }

    private final void Q9(GuildLoadingFrameLayout guildLoadingFrameLayout) {
        if (B9() != GuildFacadeType.GameCenter) {
            return;
        }
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, (int) cw.d(50));
        OverScrollLoadingView innerLoadingView = guildLoadingFrameLayout.getInnerLoadingView();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) cw.d(20), (int) cw.d(20));
        layoutParams2.gravity = 17;
        layoutParams2.bottomMargin = (int) cw.d(10);
        innerLoadingView.setLayoutParams(layoutParams2);
        guildLoadingFrameLayout.setLayoutParams(layoutParams);
        GuildLoadingFrameLayout guildLoadingFrameLayout2 = this.loadingLayout;
        if (guildLoadingFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            guildLoadingFrameLayout2 = null;
        }
        guildLoadingFrameLayout2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.home.parts.bi
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                GuildHomeRefreshLoadingPart.R9(GuildHomeRefreshLoadingPart.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(GuildHomeRefreshLoadingPart this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildHomeSubFragmentBehavior A9 = this$0.A9();
        GuildLoadingFrameLayout guildLoadingFrameLayout = this$0.loadingLayout;
        GuildLoadingFrameLayout guildLoadingFrameLayout2 = null;
        if (guildLoadingFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            guildLoadingFrameLayout = null;
        }
        A9.o(guildLoadingFrameLayout.getMeasuredHeight());
        GuildHomeSubFragmentBehavior A92 = this$0.A9();
        GuildLoadingFrameLayout guildLoadingFrameLayout3 = this$0.loadingLayout;
        if (guildLoadingFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        } else {
            guildLoadingFrameLayout2 = guildLoadingFrameLayout3;
        }
        A92.F(guildLoadingFrameLayout2.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        this.isLoading = false;
        GuildLoadingFrameLayout guildLoadingFrameLayout = this.loadingLayout;
        GuildLoadingFrameLayout guildLoadingFrameLayout2 = null;
        if (guildLoadingFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            guildLoadingFrameLayout = null;
        }
        guildLoadingFrameLayout.getInnerLoadingView().setStaticImageDrawable();
        GuildLoadingFrameLayout guildLoadingFrameLayout3 = this.loadingLayout;
        if (guildLoadingFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        } else {
            guildLoadingFrameLayout2 = guildLoadingFrameLayout3;
        }
        guildLoadingFrameLayout2.getInnerLoadingView().i();
        A9().m();
    }

    private final com.tencent.mobileqq.guild.home.subhome.g T9() {
        g.Companion companion = com.tencent.mobileqq.guild.home.subhome.g.INSTANCE;
        return new b("Guild.NewHome.GuildHomeRefreshLoadingPart", this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.loading_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.loading_layout)");
        GuildLoadingFrameLayout guildLoadingFrameLayout = (GuildLoadingFrameLayout) findViewById;
        this.loadingLayout = guildLoadingFrameLayout;
        GuildLoadingFrameLayout guildLoadingFrameLayout2 = null;
        if (guildLoadingFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            guildLoadingFrameLayout = null;
        }
        guildLoadingFrameLayout.getInnerLoadingView().h(0);
        GuildLoadingFrameLayout guildLoadingFrameLayout3 = this.loadingLayout;
        if (guildLoadingFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        } else {
            guildLoadingFrameLayout2 = guildLoadingFrameLayout3;
        }
        Q9(guildLoadingFrameLayout2);
        LiveData<GuildHomeCoverColors> T1 = E9().getHeaderColorsViewModel().T1();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final Function1<GuildHomeCoverColors, Unit> function1 = new Function1<GuildHomeCoverColors, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeRefreshLoadingPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeCoverColors guildHomeCoverColors) {
                invoke2(guildHomeCoverColors);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildHomeCoverColors guildHomeCoverColors) {
                GuildLoadingFrameLayout guildLoadingFrameLayout4 = null;
                if (guildHomeCoverColors.getType() == 2) {
                    GuildLoadingFrameLayout guildLoadingFrameLayout5 = GuildHomeRefreshLoadingPart.this.loadingLayout;
                    if (guildLoadingFrameLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                    } else {
                        guildLoadingFrameLayout4 = guildLoadingFrameLayout5;
                    }
                    guildLoadingFrameLayout4.getInnerLoadingView().setLoadingColorType(1, true);
                    return;
                }
                GuildLoadingFrameLayout guildLoadingFrameLayout6 = GuildHomeRefreshLoadingPart.this.loadingLayout;
                if (guildLoadingFrameLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
                } else {
                    guildLoadingFrameLayout4 = guildLoadingFrameLayout6;
                }
                guildLoadingFrameLayout4.getInnerLoadingView().setLoadingColorType(0, true);
            }
        };
        T1.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.bf
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeRefreshLoadingPart.U9(Function1.this, obj);
            }
        });
        LiveData<ef1.a<Boolean>> c26 = E9().c2();
        LifecycleOwner hostLifecycleOwner2 = getPartHost().getHostLifecycleOwner();
        final GuildHomeRefreshLoadingPart$onInitView$2 guildHomeRefreshLoadingPart$onInitView$2 = new GuildHomeRefreshLoadingPart$onInitView$2(this);
        c26.observe(hostLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.bg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeRefreshLoadingPart.V9(Function1.this, obj);
            }
        });
        LiveData<IGProGuildInfo> e26 = E9().getGuildHomeTitleViewModel().e2();
        LifecycleOwner hostLifecycleOwner3 = getPartHost().getHostLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function12 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeRefreshLoadingPart$onInitView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                if (iGProGuildInfo == null || iGProGuildInfo.isVisibleForVisitor() || !gr1.a.a(GuildHomeRefreshLoadingPart.this.z9()) || iGProGuildInfo.getIsBanned()) {
                    return;
                }
                GuildHomeRefreshLoadingPart.this.isLoading = true;
            }
        };
        e26.observe(hostLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.bh
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeRefreshLoadingPart.W9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.home.parts.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        A9().h(this.onStateUpdate);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        A9().C(this.onStateUpdate);
    }
}
