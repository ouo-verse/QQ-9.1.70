package com.tencent.mobileqq.guild.channel.joinchannel;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.UiThread;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSafetyRisk;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0002\u000f$B)\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0003J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\r\u001a\u00020\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R#\u0010 \u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/RiskGuildTipsIntercept;", "", "", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "dialog", "", "riskLevel", "j", "Ljava/lang/Runnable;", "runnable", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "a", "Ljava/lang/String;", "guildId", "Landroid/content/Context;", "b", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "notInterceptFun", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "i", "()Landroid/os/Handler;", "uiHandler", "<init>", "(Ljava/lang/String;Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "e", "CountDownRunnable", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class RiskGuildTipsIntercept {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function0<Unit> notInterceptFun;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\u00020\u0001B1\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/RiskGuildTipsIntercept$CountDownRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lkotlin/Function1;", "", "d", "Lkotlin/jvm/functions/Function1;", "getCountingDownCb", "()Lkotlin/jvm/functions/Function1;", "countingDownCb", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "getCountDownFinishCb", "()Lkotlin/jvm/functions/Function0;", "countDownFinishCb", "f", "I", "getCurSecondTime", "()I", "setCurSecondTime", "(I)V", "curSecondTime", "<init>", "(Lcom/tencent/mobileqq/guild/channel/joinchannel/RiskGuildTipsIntercept;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public final class CountDownRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<Integer, Unit> countingDownCb;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function0<Unit> countDownFinishCb;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int curSecondTime;
        final /* synthetic */ RiskGuildTipsIntercept this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public CountDownRunnable(@NotNull RiskGuildTipsIntercept riskGuildTipsIntercept, @NotNull Function1<? super Integer, Unit> countingDownCb, Function0<Unit> countDownFinishCb, int i3) {
            Intrinsics.checkNotNullParameter(countingDownCb, "countingDownCb");
            Intrinsics.checkNotNullParameter(countDownFinishCb, "countDownFinishCb");
            this.this$0 = riskGuildTipsIntercept;
            this.countingDownCb = countingDownCb;
            this.countDownFinishCb = countDownFinishCb;
            this.curSecondTime = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            QLog.i("RiskGuildTipsIntercept", 1, "CountDownRunnable run curSecondTime:" + this.curSecondTime);
            int i3 = this.curSecondTime;
            if (i3 > 0) {
                this.countingDownCb.invoke(Integer.valueOf(i3));
                this.curSecondTime--;
                this.this$0.t(this);
                return;
            }
            this.countDownFinishCb.invoke();
        }
    }

    public RiskGuildTipsIntercept(@NotNull String guildId, @NotNull Context context, @Nullable Function0<Unit> function0) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(context, "context");
        this.guildId = guildId;
        this.context = context;
        this.notInterceptFun = function0;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.RiskGuildTipsIntercept$uiHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return ThreadManagerV2.getUIHandlerV2();
            }
        });
        this.uiHandler = lazy;
    }

    private final Handler i() {
        return (Handler) this.uiHandler.getValue();
    }

    private final void j(QQCustomDialog dialog, int riskLevel) {
        Map mapOf;
        ViewGroup rootView = dialog.getRootView();
        VideoReport.setPageId(rootView, "pg_sgrp_danger_join_pop");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_channel_id", this.guildId), TuplesKt.to("sgrp_danger_level", Integer.valueOf(riskLevel)));
        VideoReport.setPageParams(rootView, new PageParams((Map<String, ?>) mapOf));
        VideoReport.setPageReportPolicy(dialog.getRootView(), PageReportPolicy.REPORT_ALL);
        TextView btnLeft = dialog.getBtnLeft();
        TextView btnight = dialog.getBtnight();
        if (btnLeft != null) {
            VideoReport.setElementId(btnLeft, "em_sgrp_join_channel_btn");
            VideoReport.setElementClickPolicy(btnLeft, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(btnLeft, ExposurePolicy.REPORT_ALL);
        }
        if (btnight != null) {
            VideoReport.setElementId(btnight, "em_sgrp_cancel_btn");
            VideoReport.setElementClickPolicy(btnight, ClickPolicy.REPORT_ALL);
        }
    }

    @UiThread
    private final void k() {
        QQCustomDialog dialog = DialogUtil.createCustomDialog(this.context, 230, "\u5b89\u5168\u63d0\u9192", "\u9891\u9053\u6d89\u5acc\u8fdd\u89c4\uff0c\u65e0\u6cd5\u52a0\u5165\u3002", R.string.cancel, R.string.f155561hu, (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RiskGuildTipsIntercept.l(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
        j(dialog, JoinGuildRiskLevel.HIGH_RISK.getValue());
        dialog.show();
    }

    @UiThread
    private final void m() {
        QQCustomDialog dialog = DialogUtil.createCustomDialog(this.context, 230, "\u5b89\u5168\u63d0\u9192", "\u9891\u9053\u88ab\u591a\u4eba\u4e3e\u62a5\uff0c\u8bf7\u8c28\u614e\u52a0\u5165\u3002", R.string.f155561hu, R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RiskGuildTipsIntercept.n(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RiskGuildTipsIntercept.o(RiskGuildTipsIntercept.this, dialogInterface, i3);
            }
        });
        final TextView btnLeft = dialog.getBtnLeft();
        Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.RiskGuildTipsIntercept$showRowRiskConfirmDialog$showJoinBtnInCountingSecondFun$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                TextView textView = btnLeft;
                if (textView != null) {
                    textView.setText("\u52a0\u5165(" + i3 + "s)");
                }
                TextView textView2 = btnLeft;
                if (textView2 != null) {
                    textView2.setAlpha(0.3f);
                }
                TextView textView3 = btnLeft;
                if (textView3 == null) {
                    return;
                }
                textView3.setClickable(false);
            }
        };
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.RiskGuildTipsIntercept$showRowRiskConfirmDialog$showJoinBtnInFinishCountingFun$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Context context;
                TextView textView = btnLeft;
                if (textView != null) {
                    context = this.context;
                    textView.setText(context.getString(R.string.f155561hu));
                }
                TextView textView2 = btnLeft;
                if (textView2 != null) {
                    textView2.setAlpha(1.0f);
                }
                TextView textView3 = btnLeft;
                if (textView3 == null) {
                    return;
                }
                textView3.setClickable(true);
            }
        };
        function1.invoke(2);
        final CountDownRunnable countDownRunnable = new CountDownRunnable(this, function1, function0, 1);
        t(countDownRunnable);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.n
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RiskGuildTipsIntercept.p(RiskGuildTipsIntercept.this, countDownRunnable, dialogInterface);
            }
        });
        Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
        j(dialog, JoinGuildRiskLevel.ROW_RISK.getValue());
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(RiskGuildTipsIntercept this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.notInterceptFun;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(RiskGuildTipsIntercept this$0, CountDownRunnable runnable, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        this$0.i().removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final RiskGuildTipsIntercept this$0, int i3, String str, final IGProGuildInfo iGProGuildInfo) {
        GProGuildSafetyRisk gProGuildSafetyRisk;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            if (iGProGuildInfo != null) {
                gProGuildSafetyRisk = iGProGuildInfo.getGProGuildSafetyRisk();
            } else {
                gProGuildSafetyRisk = null;
            }
            if (gProGuildSafetyRisk != null) {
                QLog.i("RiskGuildTipsIntercept", 1, "RiskGuildTipsIntercept startInterceptCheck info:" + iGProGuildInfo.getGProGuildSafetyRisk());
                this$0.i().post(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        RiskGuildTipsIntercept.s(IGProGuildInfo.this, this$0);
                    }
                });
                return;
            }
        }
        Function0<Unit> function0 = this$0.notInterceptFun;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(IGProGuildInfo iGProGuildInfo, RiskGuildTipsIntercept this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = iGProGuildInfo.getGProGuildSafetyRisk().riskLevel;
        if (i3 == JoinGuildRiskLevel.NO_RISK.getValue()) {
            Function0<Unit> function0 = this$0.notInterceptFun;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        if (i3 == JoinGuildRiskLevel.ROW_RISK.getValue()) {
            this$0.m();
        } else if (i3 == JoinGuildRiskLevel.HIGH_RISK.getValue()) {
            this$0.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(Runnable runnable) {
        i().postDelayed(runnable, 1000L);
    }

    public final void q() {
        ((IGPSService) ch.R0(IGPSService.class)).fetchGuildInfoOnly(this.guildId, 140, new vh2.v() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.i
            @Override // vh2.v
            public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                RiskGuildTipsIntercept.r(RiskGuildTipsIntercept.this, i3, str, iGProGuildInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(DialogInterface dialogInterface, int i3) {
    }
}
