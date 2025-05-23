package com.tencent.biz.richframework.localupload.recommend.delegate;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH&J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH&J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0010H&J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendConfigDelegate;", "", "disableGetPoi", "", "disableRecommend", "disableResearch", "enableAccessMediaLocationCheck", "enableSdCardSpaceAdjudge", "getClassifyCountConfig", "", "", "getClassifyTitleConfig", "getConfig", "key", "getDisableClassifier", "getFirstScanCountLimit", "", "getIncreaseScanCountLimit", "getPoiBatchSize", "getResearchThreadNum", "saveConfig", "", "value", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IRFWRecommendConfigDelegate {
    boolean disableGetPoi();

    boolean disableRecommend();

    boolean disableResearch();

    boolean enableAccessMediaLocationCheck();

    boolean enableSdCardSpaceAdjudge();

    @NotNull
    Map<String, String> getClassifyCountConfig();

    @NotNull
    Map<String, String> getClassifyTitleConfig();

    @NotNull
    String getConfig(@NotNull String key);

    @NotNull
    String getDisableClassifier();

    int getFirstScanCountLimit();

    int getIncreaseScanCountLimit();

    int getPoiBatchSize();

    int getResearchThreadNum();

    void saveConfig(@NotNull String key, @NotNull String value);
}
