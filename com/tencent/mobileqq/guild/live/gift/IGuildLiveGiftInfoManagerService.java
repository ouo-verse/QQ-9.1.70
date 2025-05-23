package com.tencent.mobileqq.guild.live.gift;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J_\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052M\u0010\t\u001aI\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\nH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/live/gift/IGuildLiveGiftInfoManagerService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getGiftResFilePathByGiftId", "", "giftId", "", "getGiftResFilePathByMaterialId", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "suc", "filePath", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildLiveGiftInfoManagerService extends QRouteApi {
    @Deprecated(message = "\u4e0d\u8981\u4f7f\u7528\u8fd9\u4e2a\u63a5\u53e3\u4e86\uff0c\u9996\u6b21\u8fdb\u5165\u76f4\u64adAIO\u65f6\u540c\u6b65\u8c03\u7528\u57fa\u672c\u8fd4\u56de\u4e3a\u7a7a\uff01")
    @Nullable
    String getGiftResFilePathByGiftId(int giftId);

    void getGiftResFilePathByMaterialId(int materialId, @NotNull Function3<? super Boolean, ? super Integer, ? super String, Unit> callback);
}
