package com.tencent.mobileqq.wink.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&J4\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&J$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IQQWinkPublishAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "publishFeedByEditDraft", "", "publishSource", "", "missionId", "", "content", "extras", "Landroid/os/Bundle;", "publishFeedWithRecommendMusic", "mediaPaths", "", "publishTextContent", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IQQWinkPublishAPI extends QRouteApi {
    void publishFeedByEditDraft(int publishSource, @NotNull String missionId, @Nullable String content, @Nullable Bundle extras);

    void publishFeedWithRecommendMusic(int publishSource, @NotNull List<String> mediaPaths, @Nullable String content, @Nullable Bundle extras);

    void publishTextContent(int publishSource, @NotNull String content, @Nullable Bundle extras);
}
