package com.tencent.mobileqq.cardcontainer.api.impl;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerDataService;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerSwitchApi;
import com.tencent.mobileqq.cardcontainer.data.CardContainerSwitchState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J@\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020$H\u0016\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/CardContainerDataApiImpl;", "Lcom/tencent/mobileqq/cardcontainer/api/ICardContainerDataApi;", "Lcooperation/vip/pb/TianShuAccess$AdPlacementInfo;", "adPlacementInfo", "", "setNetAdPlacementInfo", "", "dataId", "", "busiName", "cardType", AdMetricTag.Report.TYPE, "customData", "itemReportData", "reportData", "sendCardReport", "Lcom/tencent/mobileqq/cardcontainer/api/b;", "callback", "getCardDataFromMMKV", "Lcom/tencent/mobileqq/cardcontainer/api/c;", "getCardDataFromNet", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "getCardDataFromCache", "itemId", "", "isAggregatedCard", "deleteCardData", "getDeleteAllDataFlag", "isSwitch", "changeReqTime", "getReqLimit", "canReqContainerDataAd", "", "data", "parsePushData", "Lcom/tencent/mobileqq/cardcontainer/api/d;", "setUpdateDataCallback", "<init>", "()V", "Companion", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CardContainerDataApiImpl implements ICardContainerDataApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "CardContainer.CardContainerDataApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/impl/CardContainerDataApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.api.impl.CardContainerDataApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39578);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CardContainerDataApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    public boolean canReqContainerDataAd() {
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (!com.tencent.mobileqq.cardcontainer.config.a.INSTANCE.a().e()) {
            return false;
        }
        CardContainerSwitchState remoteCardContainerSwitchState = ((ICardContainerSwitchApi) QRoute.api(ICardContainerSwitchApi.class)).getRemoteCardContainerSwitchState();
        QLog.i(TAG, 1, "[canReqContainerDataAd], remoteCardContainerSwitchState:" + remoteCardContainerSwitchState);
        if (remoteCardContainerSwitchState == CardContainerSwitchState.OFF || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return false;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ICardContainerDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(ICa\u2026va, ProcessConstant.MAIN)");
        return ((ICardContainerDataService) runtimeService).canReqContainerDataAd();
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    public void changeReqTime(boolean isSwitch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, isSwitch);
        } else {
            com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a.b(isSwitch);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    public void deleteCardData(int dataId, @NotNull String itemId, boolean isAggregatedCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(dataId), itemId, Boolean.valueOf(isAggregatedCard));
            return;
        }
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ICardContainerDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(ICa\u2026va, ProcessConstant.MAIN)");
            ((ICardContainerDataService) runtimeService).deleteCardData(dataId, itemId, isAggregatedCard);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    @NotNull
    public List<com.tencent.mobileqq.cardcontainer.data.a> getCardDataFromCache() {
        List<com.tencent.mobileqq.cardcontainer.data.a> emptyList;
        List<com.tencent.mobileqq.cardcontainer.data.a> emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ICardContainerDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(ICa\u2026va, ProcessConstant.MAIN)");
        List<com.tencent.mobileqq.cardcontainer.data.a> dataFromCache = ((ICardContainerDataService) runtimeService).getDataFromCache();
        if (dataFromCache == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        return dataFromCache;
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    public void getCardDataFromMMKV(@NotNull com.tencent.mobileqq.cardcontainer.api.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ICardContainerDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(ICa\u2026va, ProcessConstant.MAIN)");
            ((ICardContainerDataService) runtimeService).readDataFromMMKV(callback);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    public void getCardDataFromNet(@NotNull com.tencent.mobileqq.cardcontainer.api.c callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ICardContainerDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(ICa\u2026va, ProcessConstant.MAIN)");
            ((ICardContainerDataService) runtimeService).readDataFromNet(callback);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    public boolean getDeleteAllDataFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a.d();
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    public boolean getReqLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return com.tencent.mobileqq.cardcontainer.data.mmkv.a.f201087a.i();
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    public void parsePushData(@NotNull byte[] data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ICardContainerDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(ICa\u2026va, ProcessConstant.MAIN)");
            ((ICardContainerDataService) runtimeService).parsePushData(data);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    public void sendCardReport(int dataId, @NotNull String busiName, @NotNull String cardType, int reportType, @NotNull String customData, @NotNull String itemReportData, @NotNull String reportData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(dataId), busiName, cardType, Integer.valueOf(reportType), customData, itemReportData, reportData);
            return;
        }
        Intrinsics.checkNotNullParameter(busiName, "busiName");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(customData, "customData");
        Intrinsics.checkNotNullParameter(itemReportData, "itemReportData");
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ICardContainerDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(ICa\u2026va, ProcessConstant.MAIN)");
            ((ICardContainerDataService) runtimeService).reportCardData(dataId, busiName, cardType, reportType, customData, itemReportData, reportData);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    public void setNetAdPlacementInfo(@Nullable TianShuAccess.AdPlacementInfo adPlacementInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) adPlacementInfo);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ICardContainerDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(ICa\u2026va, ProcessConstant.MAIN)");
            ((ICardContainerDataService) runtimeService).setNetAdPlacementInfo(adPlacementInfo);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi
    public void setUpdateDataCallback(@NotNull com.tencent.mobileqq.cardcontainer.api.d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(ICardContainerDataService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "it.getRuntimeService(ICa\u2026va, ProcessConstant.MAIN)");
            ((ICardContainerDataService) runtimeService).setUpdateDataCallback(callback);
        }
    }
}
