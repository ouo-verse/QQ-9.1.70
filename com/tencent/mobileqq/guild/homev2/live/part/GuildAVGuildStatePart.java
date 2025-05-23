package com.tencent.mobileqq.guild.homev2.live.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.util.QQToastUtil;
import ef1.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/part/GuildAVGuildStatePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "initView", "initData", "G9", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "d", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "mJumpGuildParam", "e", "Landroid/view/View;", "mJoinBg", "f", "mJoinView", "Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/b;", tl.h.F, "Lcom/tencent/mobileqq/guild/homev2/live/viewmodel/b;", "mViewModel", "<init>", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAVGuildStatePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam mJumpGuildParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mJoinBg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mJoinView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.homev2.live.viewmodel.b mViewModel;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f225804a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildAVGuildStatePart f225805b;

        public b(ViewModelStoreOwner viewModelStoreOwner, GuildAVGuildStatePart guildAVGuildStatePart) {
            this.f225804a = viewModelStoreOwner;
            this.f225805b = guildAVGuildStatePart;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.homev2.live.viewmodel.b(this.f225805b.mJumpGuildParam), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f225806d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildAVGuildStatePart f225807e;

        public c(View view, GuildAVGuildStatePart guildAVGuildStatePart) {
            this.f225806d = view;
            this.f225807e = guildAVGuildStatePart;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.c("fastClickGuard")) {
                com.tencent.mobileqq.guild.homev2.live.viewmodel.b bVar = this.f225807e.mViewModel;
                if (bVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
                    bVar = null;
                }
                Context context = this.f225807e.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                bVar.R1(context);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GuildAVGuildStatePart(@NotNull JumpGuildParam mJumpGuildParam) {
        Intrinsics.checkNotNullParameter(mJumpGuildParam, "mJumpGuildParam");
        this.mJumpGuildParam = mJumpGuildParam;
    }

    private final void E9() {
        View view = this.mJoinView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJoinView");
            view = null;
        }
        VideoReport.setElementId(view, "em_sgrp_bottom_join_channel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9() {
        QQToastUtil.showQQToast(1, "\u4f60\u5df2\u88ab\u79fb\u51fa\u9891\u9053");
    }

    private final void initData() {
        c.Companion companion = ef1.c.INSTANCE;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        ViewModel viewModel = new ViewModelProvider(partHost, new b(partHost, this)).get(com.tencent.mobileqq.guild.homev2.live.viewmodel.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        com.tencent.mobileqq.guild.homev2.live.viewmodel.b bVar = (com.tencent.mobileqq.guild.homev2.live.viewmodel.b) viewModel;
        this.mViewModel = bVar;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar = null;
        }
        LiveData<IGProGuildInfo> Q1 = bVar.Q1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.live.part.GuildAVGuildStatePart$initData$2
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
            public final void invoke2(IGProGuildInfo iGProGuildInfo) {
                View view;
                View view2;
                if (iGProGuildInfo != null) {
                    view = GuildAVGuildStatePart.this.mJoinBg;
                    View view3 = null;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mJoinBg");
                        view = null;
                    }
                    view.setVisibility(iGProGuildInfo.isMember() ^ true ? 0 : 8);
                    view2 = GuildAVGuildStatePart.this.mJoinView;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mJoinView");
                    } else {
                        view3 = view2;
                    }
                    view3.setVisibility(iGProGuildInfo.isMember() ^ true ? 0 : 8);
                    return;
                }
                Logger.f235387a.d().w("GuildLiveGuildStatePart", 1, "guildInfo is null, exit!");
                GuildAVGuildStatePart.this.G9();
                if (GuildAVGuildStatePart.this.getPartHost().getHostActivity().isFinishing() || GuildAVGuildStatePart.this.getPartHost().getHostActivity().isDestroyed()) {
                    return;
                }
                GuildAVGuildStatePart.this.getPartHost().getHostActivity().finish();
            }
        };
        Q1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.live.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildAVGuildStatePart.F9(Function1.this, obj);
            }
        });
    }

    private final void initView() {
        View findViewById = getPartRootView().findViewById(R.id.f165978ya3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.join_bg)");
        this.mJoinBg = findViewById;
        View findViewById2 = getPartRootView().findViewById(R.id.yai);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.join_tv)");
        this.mJoinView = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJoinView");
            findViewById2 = null;
        }
        findViewById2.setOnClickListener(new c(findViewById2, this));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initView();
        initData();
        E9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        com.tencent.mobileqq.guild.homev2.live.viewmodel.b bVar = this.mViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            bVar = null;
        }
        bVar.T1("onPartResume");
    }
}
