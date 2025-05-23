package com.tencent.qqnt.emotion.api;

import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/emotion/api/IEmotionDownloaderFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDownloader", "Lcom/tencent/image/ProtocolDownloader;", AudienceReportConst.PROTOCOL, "", "emotion_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IEmotionDownloaderFactory extends QRouteApi {
    @Nullable
    ProtocolDownloader getDownloader(@NotNull String protocol2);
}
