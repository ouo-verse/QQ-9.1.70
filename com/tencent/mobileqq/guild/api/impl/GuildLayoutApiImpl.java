package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import com.tencent.mobileqq.guild.base.preload.LayoutLoaders;
import com.tencent.mobileqq.guild.main.channellist.view.GuildContentView;
import com.tencent.mobileqq.guild.main.channellist.view.GuildInnerClippedShadowView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.cy;
import com.tencent.mobileqq.guild.widget.navigation.chatlist.GuildNavigationBarController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildLayoutApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi;", "Landroid/view/View$OnClickListener;", "Landroid/widget/FrameLayout;", "frameLayout", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$c;", "param", "", "initGuildLayoutWithLogicController", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "avatarAreaWidth", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$a;", "initGuildNavigationBar", "navigationBarLayout", "removeNavigationBar", "initGuildLayout", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "guildContainer", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$b;", "initGuildReportController", "clearDiscoverPreloadView", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "target", "addInnerClippedShadowView", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildLayoutApiImpl implements IGuildLayoutApi, View.OnClickListener {

    @NotNull
    private static final String TAG = "Guild.GuildLayoutApiImpl";

    private final void initGuildLayoutWithLogicController(FrameLayout frameLayout, IGuildLayoutApi.c param) {
        throw null;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi
    @Nullable
    public View addInnerClippedShadowView(@NotNull View target) {
        GuildInnerClippedShadowView guildInnerClippedShadowView;
        Intrinsics.checkNotNullParameter(target, "target");
        TraceUtils traceUtils = TraceUtils.f235403a;
        if (!TraceUtils.m()) {
            traceUtils.l();
            ViewParent parent = target.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) parent;
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d(TAG, 1, "addShadow t: " + target.getLeft() + " " + target.getTop() + " " + target.getRight() + " " + target.getBottom() + " " + target.getElevation() + " parent: " + viewGroup.getWidth() + " " + viewGroup.getHeight());
            }
            if (target.getLeft() == 0 && target.getTop() == 0 && target.getRight() == 0 && target.getBottom() == 0) {
                return null;
            }
            GuildInnerClippedShadowView.Companion companion = GuildInnerClippedShadowView.INSTANCE;
            Context context = target.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "target.context");
            GuildInnerClippedShadowView c16 = companion.c(context);
            target.setOutlineProvider(null);
            viewGroup.getOverlay().remove(c16);
            viewGroup.getOverlay().add(c16);
            c16.layout(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
            c16.f(target.getLeft(), target.getTop(), target.getRight(), target.getBottom(), GuildContentView.INSTANCE.a(), target.getElevation());
            return c16;
        }
        try {
            cy.c("Guild.MainUi.Conversation.ShadowEffectInit.");
            ViewParent parent2 = target.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup2 = (ViewGroup) parent2;
            Logger logger2 = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger2.d().d(TAG, 1, "addShadow t: " + target.getLeft() + " " + target.getTop() + " " + target.getRight() + " " + target.getBottom() + " " + target.getElevation() + " parent: " + viewGroup2.getWidth() + " " + viewGroup2.getHeight());
            }
            if (target.getLeft() == 0 && target.getTop() == 0 && target.getRight() == 0 && target.getBottom() == 0) {
                guildInnerClippedShadowView = null;
            } else {
                GuildInnerClippedShadowView.Companion companion2 = GuildInnerClippedShadowView.INSTANCE;
                Context context2 = target.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "target.context");
                GuildInnerClippedShadowView c17 = companion2.c(context2);
                target.setOutlineProvider(null);
                viewGroup2.getOverlay().remove(c17);
                viewGroup2.getOverlay().add(c17);
                c17.layout(0, 0, viewGroup2.getWidth(), viewGroup2.getHeight());
                c17.f(target.getLeft(), target.getTop(), target.getRight(), target.getBottom(), GuildContentView.INSTANCE.a(), target.getElevation());
                guildInnerClippedShadowView = c17;
            }
            return guildInnerClippedShadowView;
        } finally {
            cy.d();
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi
    public void clearDiscoverPreloadView(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LayoutLoaders.f214751a.b(activity);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi
    public void initGuildLayout(@NotNull FrameLayout frameLayout, @NotNull IGuildLayoutApi.c param) {
        Intrinsics.checkNotNullParameter(frameLayout, "frameLayout");
        Intrinsics.checkNotNullParameter(param, "param");
        initGuildLayoutWithLogicController(frameLayout, param);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi
    @NotNull
    public IGuildLayoutApi.a initGuildNavigationBar(@NotNull ViewGroup rootView, @NotNull IGuildLayoutApi.c param, int avatarAreaWidth) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(param, "param");
        GuildNavigationBarController.Companion companion = GuildNavigationBarController.INSTANCE;
        throw null;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi
    @NotNull
    public IGuildLayoutApi.b initGuildReportController(@NotNull Activity activity, @NotNull ViewGroup guildContainer) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildContainer, "guildContainer");
        return new ir1.b(activity, guildContainer);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        QLog.e(TAG, 1, "onClick " + v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi
    public void removeNavigationBar(@NotNull ViewGroup navigationBarLayout) {
        Intrinsics.checkNotNullParameter(navigationBarLayout, "navigationBarLayout");
        navigationBarLayout.removeAllViews();
        navigationBarLayout.setTag(R.id.ws7, null);
    }
}
