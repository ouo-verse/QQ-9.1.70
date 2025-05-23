package com.tencent.mobileqq.guild.homev2.parts;

import android.view.View;
import android.view.ViewStub;
import android.view.WindowInsets;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.views.ban.GuildHomeBanLayout;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.homev2.views.GuildNavigateTitleContainer;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2BanPart$initData$1 extends Lambda implements Function1<GuildHomeViewModel.GuildHomeUiState, Unit> {
    final /* synthetic */ GuildHomeV2BanPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeV2BanPart$initData$1(GuildHomeV2BanPart guildHomeV2BanPart) {
        super(1);
        this.this$0 = guildHomeV2BanPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets b(View this_apply, View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        ViewExtKt.f(this_apply, 0);
        return windowInsets;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildHomeViewModel.GuildHomeUiState guildHomeUiState) {
        invoke2(guildHomeUiState);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildHomeViewModel.GuildHomeUiState guildHomeUiState) {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        final View view7;
        if (!guildHomeUiState.getIsBanedGuild()) {
            view = this.this$0.bannedContainer;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        View findViewById = this.this$0.getPartRootView().findViewById(R.id.jp7);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        view2 = this.this$0.bannedContainer;
        if (view2 == null) {
            ViewStub viewStub = (ViewStub) this.this$0.getPartRootView().findViewById(R.id.f165532wi2);
            GuildHomeV2BanPart guildHomeV2BanPart = this.this$0;
            if (viewStub == null || (view7 = viewStub.inflate()) == null) {
                view7 = null;
            } else {
                view7.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.guild.homev2.parts.c
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public final WindowInsets onApplyWindowInsets(View view8, WindowInsets windowInsets) {
                        WindowInsets b16;
                        b16 = GuildHomeV2BanPart$initData$1.b(view7, view8, windowInsets);
                        return b16;
                    }
                });
            }
            guildHomeV2BanPart.bannedContainer = view7;
        }
        view3 = this.this$0.bannedContainer;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        view4 = this.this$0.bannedContainer;
        if (view4 != null) {
            ViewExtKt.f(view4, ImmersiveUtils.getStatusBarHeight(this.this$0.getContext()) + ((int) this.this$0.getContext().getResources().getDimension(R.dimen.cfd)));
        }
        view5 = this.this$0.bannedContainer;
        GuildHomeBanLayout guildHomeBanLayout = view5 != null ? (GuildHomeBanLayout) view5.findViewById(R.id.f165532wi2) : null;
        if (guildHomeBanLayout != null) {
            GuildHomeBanLayout.o(guildHomeBanLayout, this.this$0.x9(), guildHomeUiState.getGuildInfo(), false, 0, 8, null);
        }
        view6 = this.this$0.bannedContainer;
        GuildNavigateTitleContainer guildNavigateTitleContainer = view6 != null ? (GuildNavigateTitleContainer) view6.findViewById(R.id.ws8) : null;
        if (guildNavigateTitleContainer != null) {
            guildNavigateTitleContainer.M0(guildHomeUiState.getGuildInfo());
        }
        if (guildNavigateTitleContainer != null) {
            final GuildHomeV2BanPart guildHomeV2BanPart2 = this.this$0;
            guildNavigateTitleContainer.E0(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.GuildHomeV2BanPart$initData$1.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildHomeV2BanPart", 1, "onBackClick");
                    }
                    if (GuildHomeV2BanPart.this.x9().isFinishing() || GuildHomeV2BanPart.this.x9().isDestroyed()) {
                        return;
                    }
                    GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, GuildHomeV2BanPart.this.x9(), false, 2, null);
                }
            });
        }
    }
}
