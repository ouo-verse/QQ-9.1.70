package com.tencent.mobileqq.guild.discoveryv2.parts;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.GuildAISearchChatFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.discoveryv2.widget.DiscoverV2AISearchView;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/AISearchPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "E9", "G9", "B9", "", "eventId", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "aiSearchContainer", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/DiscoverV2AISearchView;", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/DiscoverV2AISearchView;", "aiSearchView", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class AISearchPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout aiSearchContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private DiscoverV2AISearchView aiSearchView;

    private final void B9() {
        FrameLayout frameLayout = this.aiSearchContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiSearchContainer");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AISearchPart.C9(AISearchPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(AISearchPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            GuildAISearchChatFragment.Companion companion = GuildAISearchChatFragment.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            companion.a(context, new Intent());
        }
        this$0.D9("clck");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void D9(String eventId) {
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        FrameLayout frameLayout = this.aiSearchContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiSearchContainer");
            frameLayout = null;
        }
        iGuildDTReportApi.reportDtEventManual(frameLayout, "em_sgrp_ai_search_box", eventId, new HashMap());
    }

    private final void E9() {
        e12.a<String> e16 = GuildThemeManager.f235286a.e();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.AISearchPart$observeTabContainerBackgroundUpdateEvents$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                AISearchPart.this.G9();
            }
        };
        e16.observe(a16, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AISearchPart.F9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9() {
        FrameLayout frameLayout = this.aiSearchContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiSearchContainer");
            frameLayout = null;
        }
        MainResourceConfig e16 = MainResourceConfig.INSTANCE.e();
        FrameLayout frameLayout3 = this.aiSearchContainer;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiSearchContainer");
        } else {
            frameLayout2 = frameLayout3;
        }
        Context context = frameLayout2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "aiSearchContainer.context");
        frameLayout.setBackground(e16.m(context, false, 1.0f, false));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        DiscoverV2AISearchView discoverV2AISearchView = this.aiSearchView;
        if (discoverV2AISearchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiSearchView");
            discoverV2AISearchView = null;
        }
        discoverV2AISearchView.e();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.vwz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026uild_ai_search_container)");
        this.aiSearchContainer = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f165421vx1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.guild_ai_search_view)");
        DiscoverV2AISearchView discoverV2AISearchView = (DiscoverV2AISearchView) findViewById2;
        this.aiSearchView = discoverV2AISearchView;
        if (discoverV2AISearchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiSearchView");
            discoverV2AISearchView = null;
        }
        discoverV2AISearchView.g();
        G9();
        E9();
        B9();
        D9("imp");
    }
}
