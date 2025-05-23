package com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.EcommerceMsgCenterSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.EcommerceMsgDetailSource;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenter;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenterService;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.main_page.MessageCenterFragment;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.representation.settings.MessageTypeSettingsFragment;
import com.tencent.mobileqq.qqecommerce.biz.report.ECDataReportManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/impl/EcommerceMsgCenterImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/IEcommerceMsgCenter;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/EcommerceMsgCenterSource;", "source", "", "launchMainPage", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/EcommerceMsgDetailSource;", "launchDetailPage", "launchSettingsPage", "", "exposureTimeSec", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "messageItem", "reportExposureInAIO", "Lcom/tencent/mobileqq/qqecommerce/biz/report/ECDataReportManager;", "reportManager", "Lcom/tencent/mobileqq/qqecommerce/biz/report/ECDataReportManager;", "Loe2/a;", "localConfig", "Loe2/a;", "", "currentUinHasReportExposure", "Ljava/util/Set;", "<init>", "()V", "Companion", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class EcommerceMsgCenterImpl implements IEcommerceMsgCenter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LAST_EXPOSURE_MESSAGE_ID = "ecommerce_public_account_last_exposure_message_id";
    private static final String LAST_EXPOSURE_TIME_SEC = "ecommerce_public_account_last_exposure_time_sec";
    private static final String REPORT_KEY_MESSAGE_CENTER_ENTER = "ds_service_message_clk";
    private static final String REPORT_KEY_MESSAGE_CENTER_EXPOSURE = "ds_service_message_exp";
    private final ECDataReportManager reportManager = new ECDataReportManager();
    private final oe2.a localConfig = new oe2.a();
    private final Set<Long> currentUinHasReportExposure = new LinkedHashSet();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/impl/EcommerceMsgCenterImpl$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/EcommerceMsgDetailSource;", "source", "", "a", "", "LAST_EXPOSURE_MESSAGE_ID", "Ljava/lang/String;", "LAST_EXPOSURE_TIME_SEC", "REPORT_KEY_MESSAGE_CENTER_ENTER", "REPORT_KEY_MESSAGE_CENTER_EXPOSURE", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.impl.EcommerceMsgCenterImpl$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, EcommerceMsgDetailSource source) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(source, "source");
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPublicAccountDetailActivity.ROUTE_NAME);
            activityURIRequest.extra().putString("uin", AppConstants.Q_ECOMMERCE_MSG_PUBLIC_ACCOUNT_UIN);
            activityURIRequest.extra().putInt("uintype", 1008);
            activityURIRequest.extra().putInt("source", source.getValue());
            QRoute.startUri(activityURIRequest, (o) null);
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenter
    public void launchDetailPage(Context context, EcommerceMsgDetailSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        INSTANCE.a(context, source);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenter
    public void launchMainPage(BaseQQAppInterface app, Context context, EcommerceMsgCenterSource source) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        QPublicFragmentActivity.start(context, MessageCenterFragment.class);
        IRuntimeService runtimeService = app.getRuntimeService(IEcommerceMsgCenterService.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IE\u2026enterService::class.java)");
        IEcommerceMsgCenterService iEcommerceMsgCenterService = (IEcommerceMsgCenterService) runtimeService;
        iEcommerceMsgCenterService.fetchRedDotMessage(new Function1<MessageItem, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.impl.EcommerceMsgCenterImpl$launchMainPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageItem messageItem) {
                invoke2(messageItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MessageItem messageItem) {
                ECDataReportManager eCDataReportManager;
                Map mapOf;
                eCDataReportManager = EcommerceMsgCenterImpl.this.reportManager;
                Pair[] pairArr = new Pair[2];
                pairArr[0] = TuplesKt.to("uin", Long.valueOf(ECRuntimeManager.INSTANCE.e()));
                pairArr[1] = TuplesKt.to("red_dot", Long.valueOf(messageItem != null ? 1L : 0L));
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                IECDataReport.a.a(eCDataReportManager, "ds_service_message_clk", mapOf, false, 4, null);
            }
        });
        iEcommerceMsgCenterService.tryClearRedDotIfNeeded(app);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenter
    public void launchSettingsPage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, MessageTypeSettingsFragment.class);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.IEcommerceMsgCenter
    public void reportExposureInAIO(BaseQQAppInterface app, long exposureTimeSec, MessageItem messageItem) {
        Map mapOf;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(app, "app");
        long e16 = ECRuntimeManager.INSTANCE.e();
        if (messageItem != null) {
            String id5 = messageItem.getId();
            oe2.a aVar = this.localConfig;
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(aVar.getString(LAST_EXPOSURE_MESSAGE_ID, "", bool), id5)) {
                return;
            }
            this.localConfig.setString(LAST_EXPOSURE_MESSAGE_ID, id5, bool);
            ECDataReportManager eCDataReportManager = this.reportManager;
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("uin", Long.valueOf(e16)), TuplesKt.to("red_dot", 1L));
            IECDataReport.a.a(eCDataReportManager, REPORT_KEY_MESSAGE_CENTER_EXPOSURE, mapOf2, false, 4, null);
            this.currentUinHasReportExposure.add(Long.valueOf(e16));
            return;
        }
        if (this.currentUinHasReportExposure.contains(Long.valueOf(e16))) {
            return;
        }
        ECDataReportManager eCDataReportManager2 = this.reportManager;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("uin", Long.valueOf(e16)), TuplesKt.to("red_dot", 0L));
        IECDataReport.a.a(eCDataReportManager2, REPORT_KEY_MESSAGE_CENTER_EXPOSURE, mapOf, false, 4, null);
        this.currentUinHasReportExposure.add(Long.valueOf(e16));
    }
}
