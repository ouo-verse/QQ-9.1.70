package com.tencent.biz.richframework.localupload.recommend.delegate;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWUploadRecommendDelegate;", "", "getConfigDelegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendConfigDelegate;", "getDbDelegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendDbDelegate;", "getLogDelegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendLogDelegate;", "getPoiDelegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate;", "getReportDelegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendReportDelegate;", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IRFWUploadRecommendDelegate {
    @NotNull
    IRFWRecommendConfigDelegate getConfigDelegate();

    @NotNull
    IRFWRecommendDbDelegate getDbDelegate();

    @NotNull
    IRFWRecommendLogDelegate getLogDelegate();

    @NotNull
    IRFWRecommendPoiDelegate getPoiDelegate();

    @NotNull
    IRFWRecommendReportDelegate getReportDelegate();
}
