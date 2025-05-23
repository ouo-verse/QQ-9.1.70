package com.tencent.mobileqq.guild.mainframe.helper;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.discover.GuildDiscoverABTestHelper;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.guild.openentrance.GuildNewUserVideoAnimController;
import com.tencent.mobileqq.guild.openentrance.b;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNewUserGuideData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u00012\u00020\u0002:\u0001\u001eB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/helper/GuildGuideAnimHelper;", "Lcom/tencent/mobileqq/guild/mainframe/k;", "Lcom/tencent/mobileqq/guild/openentrance/b;", "Landroid/view/View;", "view", "", tl.h.F, "", "needShow", "i", "onVideoPlayStart", "d", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "getMView", "()Landroid/widget/FrameLayout;", "setMView", "(Landroid/widget/FrameLayout;)V", "mView", "Lcom/tencent/mobileqq/guild/openentrance/GuildNewUserVideoAnimController;", "f", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/guild/openentrance/GuildNewUserVideoAnimController;", "videoAnimController", "Lcom/tencent/mobileqq/guild/mainframe/i;", "mainViewContext", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/i;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildGuideAnimHelper extends k implements com.tencent.mobileqq.guild.openentrance.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy videoAnimController;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGuideAnimHelper(@NotNull com.tencent.mobileqq.guild.mainframe.i mainViewContext) {
        super(mainViewContext);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mainViewContext, "mainViewContext");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildNewUserVideoAnimController>() { // from class: com.tencent.mobileqq.guild.mainframe.helper.GuildGuideAnimHelper$videoAnimController$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildNewUserVideoAnimController invoke() {
                return new GuildNewUserVideoAnimController(GuildLivePlayerTag.GUILD_GUIDE_SHOW_ANIM);
            }
        });
        this.videoAnimController = lazy;
    }

    private final GuildNewUserVideoAnimController j() {
        return (GuildNewUserVideoAnimController) this.videoAnimController.getValue();
    }

    @Override // com.tencent.mobileqq.guild.openentrance.b
    public void c(boolean z16, boolean z17) {
        b.a.a(this, z16, z17);
    }

    @Override // com.tencent.mobileqq.guild.openentrance.b
    public void d() {
        GuildDiscoverABTestHelper.f216488d.p();
    }

    @Override // com.tencent.mobileqq.guild.openentrance.b
    public void e(@NotNull String str) {
        b.a.b(this, str);
    }

    @Override // com.tencent.mobileqq.guild.openentrance.b
    public void f() {
        b.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k
    public void h(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.h(view);
        if (QLog.isColorLevel()) {
            QLog.d("GuildGuideAnimHelper", 2, "initView");
        }
        if (view instanceof FrameLayout) {
            this.mView = (FrameLayout) view;
        } else {
            QLog.e("GuildGuideAnimHelper", 2, "initView view error !");
        }
    }

    public final void i(boolean needShow) {
        String str;
        IGProNewUserGuideData userGuideData;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildGuideAnimHelper", 2, "[checkNeedShowGuideAnim] needShow:" + needShow);
        }
        if (needShow) {
            if (j().getIsPlaying()) {
                QLog.e("GuildGuideAnimHelper", 2, "checkNeedShowGuideAnim is playing!");
                return;
            }
            j().s(this);
            GuildNewUserVideoAnimController j3 = j();
            FrameLayout frameLayout = this.mView;
            QBaseActivity activity = this.f227466d.getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            IGProGuildBottomTabExpData v3 = GuildDiscoverABTestHelper.f216488d.v();
            if (v3 != null && (userGuideData = v3.getUserGuideData()) != null) {
                str = userGuideData.getAnimationUrl();
            } else {
                str = null;
            }
            j3.t(frameLayout, activity, "GuildGuideAnimHelper", str);
        }
    }

    @Override // com.tencent.mobileqq.guild.openentrance.b
    public void onFirstFrameCome() {
        b.a.c(this);
    }

    @Override // com.tencent.mobileqq.guild.openentrance.b
    public void onVideoPlayStart() {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_page_type", "3"));
        VideoReport.reportEvent("ev_sgrp_new_user_guide_animation", mapOf);
    }
}
