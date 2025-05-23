package com.tencent.mobileqq.guild.media.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.widget.GuildRightIconLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001\u000bB\u001d\u0012\u0006\u0010\r\u001a\u00020\n\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaRankingUserCase;", "", "", "j", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "f", "e", "k", "l", "Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;", "a", "Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;", "mRightIconLayout", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", tl.h.F, "()Lkotlin/jvm/functions/Function0;", NodeProps.ON_CLICK, "c", "Z", "isShowing", "Landroid/view/View;", "kotlin.jvm.PlatformType", "d", "Landroid/view/View;", "mRightIv", "Landroid/widget/PopupWindow;", "Landroid/widget/PopupWindow;", "mIconBtnBubbleTip", "Ljava/lang/Runnable;", "Lkotlin/Lazy;", "i", "()Ljava/lang/Runnable;", "stopShowGuideFunc", "<init>", "(Lcom/tencent/mobileqq/guild/widget/GuildRightIconLayout;Lkotlin/jvm/functions/Function0;)V", "g", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaRankingUserCase {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildRightIconLayout mRightIconLayout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> onClick;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isShowing;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View mRightIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow mIconBtnBubbleTip;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy stopShowGuideFunc;

    public GuildMediaRankingUserCase(@NotNull GuildRightIconLayout mRightIconLayout, @NotNull Function0<Unit> onClick) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mRightIconLayout, "mRightIconLayout");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.mRightIconLayout = mRightIconLayout;
        this.onClick = onClick;
        this.mRightIv = mRightIconLayout.getChildAt(0);
        lazy = LazyKt__LazyJVMKt.lazy(new GuildMediaRankingUserCase$stopShowGuideFunc$2(this));
        this.stopShowGuideFunc = lazy;
    }

    private final void e() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(i());
    }

    private final void f() {
        LinearLayout linearLayout;
        if (this.isShowing && this.mRightIconLayout.getContext() != null) {
            if (this.mRightIconLayout.getContext() instanceof Activity) {
                Context context = this.mRightIconLayout.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                if (((Activity) context).isFinishing()) {
                    return;
                }
            }
            Context context2 = this.mRightIconLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "mRightIconLayout.context");
            n nVar = new n(context2, null, null, null, 0L, 30, null);
            View contentView = nVar.getContentView();
            Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
            jt1.b.b(contentView, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaRankingUserCase$doShowRankingListBubble$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    View view;
                    Intrinsics.checkNotNullParameter(it, "it");
                    IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
                    view = GuildMediaRankingUserCase.this.mRightIv;
                    iGuildDTReportApi.reportDtEventManual(view, "em_sgrp_contribute_charm_list_entry", "clck", new HashMap());
                    GuildMediaRankingUserCase.this.h().invoke();
                    GuildMediaRankingUserCase.this.l();
                }
            });
            this.mIconBtnBubbleTip = nVar;
            View contentView2 = nVar.getContentView();
            if (contentView2 instanceof LinearLayout) {
                linearLayout = (LinearLayout) contentView2;
            } else {
                linearLayout = null;
            }
            if (linearLayout != null) {
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(-2, -2);
                } else {
                    Intrinsics.checkNotNullExpressionValue(layoutParams, "it.layoutParams ?: Linea\u2026RAP_CONTENT\n            )");
                }
                layoutParams.width = ViewUtils.dpToPx(146.0f);
                layoutParams.height = ViewUtils.dpToPx(34.0f);
            }
            this.mRightIv.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.v
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaRankingUserCase.g(GuildMediaRankingUserCase.this);
                }
            });
            ThreadManagerV2.getUIHandlerV2().postDelayed(i(), 3000L);
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GuildMediaRankingUserCase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int dpToPx = ViewUtils.dpToPx(146.0f);
        int dpToPx2 = ViewUtils.dpToPx(12.0f);
        PopupWindow popupWindow = this$0.mIconBtnBubbleTip;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(this$0.mRightIv, ((-(dpToPx - this$0.mRightIconLayout.getWidth())) / 2) - (dpToPx2 / 2), ViewUtils.dip2px(6.0f));
        }
    }

    private final Runnable i() {
        return (Runnable) this.stopShowGuideFunc.getValue();
    }

    private final boolean j() {
        return bw.L().decodeBool("mmkv_key_guild_media_show_ranking_list_guide", true);
    }

    private final void m() {
        bw.L().encodeBool("mmkv_key_guild_media_show_ranking_list_guide", false);
    }

    @NotNull
    public final Function0<Unit> h() {
        return this.onClick;
    }

    public final void k() {
        if (this.mRightIconLayout.getVisibility() != 0 || this.mIconBtnBubbleTip != null || this.isShowing || !j()) {
            return;
        }
        QLog.d("GuildMediaRankingUserCase", 1, "showRankingListGuide");
        this.isShowing = true;
        f();
    }

    public final void l() {
        QLog.d("GuildMediaRankingUserCase", 1, "============ stopShowRankingListBubbleShow =============== isShowing =" + this.isShowing);
        if (this.isShowing) {
            this.isShowing = false;
            i().run();
            e();
        }
    }
}
