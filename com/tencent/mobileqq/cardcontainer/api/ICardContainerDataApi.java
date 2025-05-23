package com.tencent.mobileqq.cardcontainer.api;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 &2\u00020\u0001:\u0001'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J@\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0013H&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H&J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u0019H&J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0019H&J\b\u0010\u001f\u001a\u00020\u0019H&J\b\u0010 \u001a\u00020\u0019H&J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H&J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020$H&\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/ICardContainerDataApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcooperation/vip/pb/TianShuAccess$AdPlacementInfo;", "adPlacementInfo", "", "setNetAdPlacementInfo", "", "dataId", "", "busiName", "cardType", AdMetricTag.Report.TYPE, "customData", "itemReportData", "reportData", "sendCardReport", "Lcom/tencent/mobileqq/cardcontainer/api/b;", "callback", "getCardDataFromMMKV", "Lcom/tencent/mobileqq/cardcontainer/api/c;", "getCardDataFromNet", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "getCardDataFromCache", "itemId", "", "isAggregatedCard", "deleteCardData", "getDeleteAllDataFlag", "isSwitch", "changeReqTime", "getReqLimit", "canReqContainerDataAd", "", "data", "parsePushData", "Lcom/tencent/mobileqq/cardcontainer/api/d;", "setUpdateDataCallback", "Companion", "a", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface ICardContainerDataApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int REPORT_CLICK = 1;
    public static final int REPORT_DELETE = 3;
    public static final int REPORT_EXP = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/ICardContainerDataApi$a;", "", "<init>", "()V", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.api.ICardContainerDataApi$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f201034a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36177);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f201034a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(36179), (Class<?>) ICardContainerDataApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f201034a;
        }
    }

    boolean canReqContainerDataAd();

    void changeReqTime(boolean isSwitch);

    void deleteCardData(int dataId, @NotNull String itemId, boolean isAggregatedCard);

    @NotNull
    List<com.tencent.mobileqq.cardcontainer.data.a> getCardDataFromCache();

    void getCardDataFromMMKV(@NotNull b callback);

    void getCardDataFromNet(@NotNull c callback);

    boolean getDeleteAllDataFlag();

    boolean getReqLimit();

    void parsePushData(@NotNull byte[] data);

    void sendCardReport(int dataId, @NotNull String busiName, @NotNull String cardType, int reportType, @NotNull String customData, @NotNull String itemReportData, @NotNull String reportData);

    void setNetAdPlacementInfo(@Nullable TianShuAccess.AdPlacementInfo adPlacementInfo);

    void setUpdateDataCallback(@NotNull d callback);
}
