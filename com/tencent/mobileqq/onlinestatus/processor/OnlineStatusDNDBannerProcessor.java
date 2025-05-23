package com.tencent.mobileqq.onlinestatus.processor;

import android.annotation.SuppressLint;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@KeepClassConstructor
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/processor/OnlineStatusDNDBannerProcessor;", "Lcom/tencent/mobileqq/banner/processor/BaseBannerProcessor;", "", h.F, "", "getId", "Lcom/tencent/mobileqq/banner/a;", "banner", "Landroid/view/View;", "initBanner", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", "d", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusDNDBannerProcessor extends BaseBannerProcessor {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final int f256109e = com.tencent.mobileqq.banner.d.f200267t;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/processor/OnlineStatusDNDBannerProcessor$a;", "", "", "BANNER_ID", "I", "a", "()I", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.processor.OnlineStatusDNDBannerProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return OnlineStatusDNDBannerProcessor.f256109e;
        }

        Companion() {
        }
    }

    public OnlineStatusDNDBannerProcessor(@NotNull QBaseActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    private final void h() {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026nstant.MAIN\n            )");
        ((IOnlineStatusService) runtimeService).newAccountPanel(baseActivity, 7).show();
        ReportController.y(MobileQQ.sMobileQQ.peekAppRuntime(), "0x800C3E1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(OnlineStatusDNDBannerProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(OnlineStatusDNDBannerProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        return f256109e;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    @SuppressLint({"UseCompatLoadingForDrawables"})
    @Nullable
    public View initBanner(@Nullable com.tencent.mobileqq.banner.a banner) {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        ReportController.y(MobileQQ.sMobileQQ.peekAppRuntime(), "0x800C3E0");
        return QUINoticeBarManager.INSTANCE.a().h(baseActivity).setMsg("\u201c\u8bf7\u52ff\u6253\u6270\u201d\u72b6\u6001\u4e0b\u65e0\u6cd5\u63a5\u6536\u901a\u77e5").b("\u5207\u6362\u72b6\u6001", new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.processor.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineStatusDNDBannerProcessor.i(OnlineStatusDNDBannerProcessor.this, view);
            }
        }).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.processor.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineStatusDNDBannerProcessor.j(OnlineStatusDNDBannerProcessor.this, view);
            }
        }).getView();
    }
}
