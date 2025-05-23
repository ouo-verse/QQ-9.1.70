package com.tencent.mobileqq.guild.homev2.parts;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildHomeApi;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.homev2.views.GuildHomeV2VisitorJoinLayout;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/GuildHomeV2VisitorJoinPart;", "Lcom/tencent/mobileqq/guild/homev2/parts/a;", "", "initView", "initData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/guild/homev2/views/GuildHomeV2VisitorJoinLayout;", "e", "Lcom/tencent/mobileqq/guild/homev2/views/GuildHomeV2VisitorJoinLayout;", "visitorJoinLayout", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeV2VisitorJoinPart extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildHomeV2VisitorJoinLayout visitorJoinLayout;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initData() {
        LiveData asLiveData$default = FlowLiveDataConversions.asLiveData$default(C9().P1(), (CoroutineContext) null, 0L, 3, (Object) null);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<GuildHomeViewModel.GuildHomeUiState, Unit> function1 = new Function1<GuildHomeViewModel.GuildHomeUiState, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.GuildHomeV2VisitorJoinPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeViewModel.GuildHomeUiState guildHomeUiState) {
                invoke2(guildHomeUiState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildHomeViewModel.GuildHomeUiState guildHomeUiState) {
                GuildHomeV2VisitorJoinLayout guildHomeV2VisitorJoinLayout;
                guildHomeV2VisitorJoinLayout = GuildHomeV2VisitorJoinPart.this.visitorJoinLayout;
                if (guildHomeV2VisitorJoinLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("visitorJoinLayout");
                    guildHomeV2VisitorJoinLayout = null;
                }
                guildHomeV2VisitorJoinLayout.setVisibility(guildHomeUiState.getIsVisitorVisibleGuild() && !guildHomeUiState.getIsBanedGuild() && GuildHomeV2VisitorJoinPart.this.B9().a() != GuildFacadeType.GameCenter ? 0 : 8);
            }
        };
        asLiveData$default.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeV2VisitorJoinPart.G9(Function1.this, obj);
            }
        });
    }

    private final void initView() {
        View findViewById = getPartRootView().findViewById(R.id.x4w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026uild_visitor_join_layout)");
        GuildHomeV2VisitorJoinLayout guildHomeV2VisitorJoinLayout = (GuildHomeV2VisitorJoinLayout) findViewById;
        this.visitorJoinLayout = guildHomeV2VisitorJoinLayout;
        GuildHomeV2VisitorJoinLayout guildHomeV2VisitorJoinLayout2 = null;
        if (guildHomeV2VisitorJoinLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("visitorJoinLayout");
            guildHomeV2VisitorJoinLayout = null;
        }
        GuildHomeV2VisitorJoinLayout guildHomeV2VisitorJoinLayout3 = this.visitorJoinLayout;
        if (guildHomeV2VisitorJoinLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("visitorJoinLayout");
            guildHomeV2VisitorJoinLayout3 = null;
        }
        ViewGroup.LayoutParams layoutParams = guildHomeV2VisitorJoinLayout3.getLayoutParams();
        layoutParams.height = ((IGuildHomeApi) QRoute.api(IGuildHomeApi.class)).getVisitorBarHeight();
        guildHomeV2VisitorJoinLayout.setLayoutParams(layoutParams);
        GuildHomeV2VisitorJoinLayout guildHomeV2VisitorJoinLayout4 = this.visitorJoinLayout;
        if (guildHomeV2VisitorJoinLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("visitorJoinLayout");
        } else {
            guildHomeV2VisitorJoinLayout2 = guildHomeV2VisitorJoinLayout4;
        }
        guildHomeV2VisitorJoinLayout2.setJumpGuildParam(C9().getJumpGuildParam());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initView();
        initData();
    }
}
