package com.tencent.mobileqq.guild.home.parts;

import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.event.GuildJoinSuccessEvent;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0002R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeVisitorJoinPart;", "Lcom/tencent/mobileqq/guild/home/parts/a;", "", "initData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "J9", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "frameLayout", "Lcom/tencent/mobileqq/guild/widget/ShadowFrameLayout;", "f", "Lcom/tencent/mobileqq/guild/widget/ShadowFrameLayout;", "shadowLayout", "Lcom/tencent/biz/qui/quibutton/QUIButton;", tl.h.F, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "guildJoin", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeVisitorJoinPart extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout frameLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ShadowFrameLayout shadowLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUIButton guildJoin;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(GuildHomeVisitorJoinPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!QQGuildUIUtil.v()) {
            this$0.D9().i().g(view, false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initData() {
        LiveData<IGProGuildInfo> e26 = E9().getGuildHomeTitleViewModel().e2();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeVisitorJoinPart$initData$1
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
                FrameLayout frameLayout;
                FrameLayout frameLayout2;
                FrameLayout frameLayout3 = null;
                if (iGProGuildInfo == null || !iGProGuildInfo.isMember()) {
                    frameLayout = GuildHomeVisitorJoinPart.this.frameLayout;
                    if (frameLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
                    } else {
                        frameLayout3 = frameLayout;
                    }
                    frameLayout3.setVisibility(0);
                    GuildHomeVisitorJoinPart.this.J9();
                    return;
                }
                frameLayout2 = GuildHomeVisitorJoinPart.this.frameLayout;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
                } else {
                    frameLayout3 = frameLayout2;
                }
                frameLayout3.setVisibility(8);
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                String guildID = iGProGuildInfo.getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
                simpleEventBus.dispatchEvent(new GuildJoinSuccessEvent(guildID));
            }
        };
        e26.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.ce
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeVisitorJoinPart.K9(Function1.this, obj);
            }
        });
        QUIButton qUIButton = this.guildJoin;
        FrameLayout frameLayout = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildJoin");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.parts.cf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeVisitorJoinPart.L9(GuildHomeVisitorJoinPart.this, view);
            }
        });
        ShadowFrameLayout shadowFrameLayout = this.shadowLayout;
        if (shadowFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shadowLayout");
            shadowFrameLayout = null;
        }
        ShadowFrameLayout shadowFrameLayout2 = this.shadowLayout;
        if (shadowFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shadowLayout");
            shadowFrameLayout2 = null;
        }
        shadowFrameLayout.setShadowColor(shadowFrameLayout2.getContext().getResources().getColorStateList(R.color.qui_common_brand_light));
        FrameLayout frameLayout2 = this.frameLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            frameLayout2 = null;
        }
        int color = frameLayout2.getContext().getResources().getColor(R.color.qui_common_fill_light_primary);
        FrameLayout frameLayout3 = this.frameLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        } else {
            frameLayout = frameLayout3;
        }
        frameLayout.setBackground(GuildUIUtils.f235378a.i(color, kotlin.g.a(color, 0), 255));
    }

    public final void J9() {
        FrameLayout frameLayout = this.frameLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
            frameLayout = null;
        }
        com.tencent.mobileqq.guild.util.ch.Y0(frameLayout, "em_sgrp_bottom_join_channel", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.x4w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026uild_visitor_join_layout)");
        this.frameLayout = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f84044l7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.shadow_header_entrance)");
        this.shadowLayout = (ShadowFrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.wku);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.guild_join)");
        this.guildJoin = (QUIButton) findViewById3;
        initData();
    }
}
