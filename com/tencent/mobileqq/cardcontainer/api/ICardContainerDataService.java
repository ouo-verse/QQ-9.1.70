package com.tencent.mobileqq.cardcontainer.api;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.annotation.Service;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(needUin = true, process = {""})
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\tH&J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH&J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&J@\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H&J\b\u0010\u001c\u001a\u00020\u0012H&J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH&J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020 H&\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/ICardContainerDataService;", "Lmqq/app/api/IRuntimeService;", "Lcooperation/vip/pb/TianShuAccess$AdPlacementInfo;", "cardAdPlacementInfo", "", "setNetAdPlacementInfo", "Lcom/tencent/mobileqq/cardcontainer/api/b;", "callback", "readDataFromMMKV", "Lcom/tencent/mobileqq/cardcontainer/api/c;", "readDataFromNet", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "getDataFromCache", "", "dataId", "", "itemId", "", "isAggregatedCard", "deleteCardData", "busiName", "cardType", AdMetricTag.Report.TYPE, "customData", "itemReportData", "reportData", "reportCardData", "canReqContainerDataAd", "", "data", "parsePushData", "Lcom/tencent/mobileqq/cardcontainer/api/d;", "setUpdateDataCallback", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface ICardContainerDataService extends IRuntimeService {
    boolean canReqContainerDataAd();

    void deleteCardData(int dataId, @NotNull String itemId, boolean isAggregatedCard);

    @Nullable
    List<com.tencent.mobileqq.cardcontainer.data.a> getDataFromCache();

    void parsePushData(@NotNull byte[] data);

    void readDataFromMMKV(@NotNull b callback);

    void readDataFromNet(@NotNull c callback);

    void reportCardData(int dataId, @NotNull String busiName, @NotNull String cardType, int reportType, @NotNull String customData, @NotNull String itemReportData, @NotNull String reportData);

    void setNetAdPlacementInfo(@Nullable TianShuAccess.AdPlacementInfo cardAdPlacementInfo);

    void setUpdateDataCallback(@NotNull d callback);
}
