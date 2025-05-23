package com.tencent.guild.aio.reserve2.busi.banner;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import at.d;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.aio.reserve2.busi.banner.GuildOperationBannerUIState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.operationbanner.GuildOperationBanner;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00130\u0012H\u0016J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/d;", "Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerUIState;", "state", "", "h1", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "g1", "Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerUIState$InitBanner;", "f1", "Lcom/tencent/guild/aio/reserve2/busi/banner/GuildOperationBannerUIState$AIOVisibilityChange;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/aio/base/mvvm/b;", "c1", "e1", "d", "Landroid/view/ViewGroup;", "mViewContainer", "Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner;", "e", "Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner;", "mBannerView", "<init>", "()V", "f", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildOperationBannerVB extends com.tencent.aio.base.mvvm.a<d, GuildOperationBannerUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mViewContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildOperationBanner mBannerView;

    private final void d1(GuildOperationBannerUIState.AIOVisibilityChange state) {
        GuildOperationBanner guildOperationBanner = this.mBannerView;
        if (guildOperationBanner != null) {
            guildOperationBanner.setAttachedPageVisibility(state.getCom.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String());
        }
    }

    private final void f1(GuildOperationBannerUIState.InitBanner state) {
        GuildOperationBanner guildOperationBanner = this.mBannerView;
        if (guildOperationBanner != null) {
            guildOperationBanner.u(state.getGuildId(), state.getChannelId(), state.getChannelType());
        }
    }

    private final void g1(ViewGroup container) {
        if (this.mBannerView == null) {
            this.mBannerView = new GuildOperationBanner(getMContext(), null, 2, null);
        }
        GuildOperationBanner guildOperationBanner = this.mBannerView;
        if (guildOperationBanner != null) {
            container.addView(guildOperationBanner);
        }
    }

    private final void h1(GuildOperationBannerUIState state) {
        int i3;
        ViewGroup viewGroup = this.mViewContainer;
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewContainer");
            viewGroup = null;
        }
        if (state.getIsContainerVisible()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
        ViewGroup viewGroup3 = this.mViewContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewContainer");
            viewGroup3 = null;
        }
        if (viewGroup3.getChildCount() == 0 && state.getIsLoad()) {
            ViewGroup viewGroup4 = this.mViewContainer;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewContainer");
            } else {
                viewGroup2 = viewGroup4;
            }
            g1(viewGroup2);
            return;
        }
        if (!state.getIsLoad()) {
            ViewGroup viewGroup5 = this.mViewContainer;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewContainer");
            } else {
                viewGroup2 = viewGroup5;
            }
            viewGroup2.removeAllViews();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<d, GuildOperationBannerUIState> createVM() {
        return new b(new Function0<Unit>() { // from class: com.tencent.guild.aio.reserve2.busi.banner.GuildOperationBannerVB$createVM$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                GuildOperationBanner guildOperationBanner;
                guildOperationBanner = GuildOperationBannerVB.this.mBannerView;
                if (guildOperationBanner != null) {
                    guildOperationBanner.n();
                }
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildOperationBannerUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        h1(state);
        if (state instanceof GuildOperationBannerUIState.InitBanner) {
            f1((GuildOperationBannerUIState.InitBanner) state);
        } else if (state instanceof GuildOperationBannerUIState.AIOVisibilityChange) {
            d1((GuildOperationBannerUIState.AIOVisibilityChange) state);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildOperationBannerUIState>> getObserverStates() {
        List<Class<? extends GuildOperationBannerUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildOperationBannerUIState.InitBanner.class, GuildOperationBannerUIState.AIOVisibilityChange.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout.LayoutParams a16 = com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -2, -2);
        a16.gravity = 53;
        a16.topMargin = createViewParams.a().getResources().getDimensionPixelOffset(R.dimen.ccr);
        a16.rightMargin = createViewParams.a().getResources().getDimensionPixelOffset(R.dimen.ccq);
        LinearLayout linearLayout = new LinearLayout(createViewParams.a());
        linearLayout.setLayoutParams(a16);
        linearLayout.setVisibility(8);
        linearLayout.setClickable(true);
        this.mViewContainer = linearLayout;
        return linearLayout;
    }
}
