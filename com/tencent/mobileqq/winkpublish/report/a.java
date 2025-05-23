package com.tencent.mobileqq.winkpublish.report;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkpublish.config.l;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/a;", "", "Lcom/tencent/mobileqq/winkpublish/config/l;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "reportData", "", "a", "", "key", "startKey", "b", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface a {
    void a(l config, WinkPublishQualityReportData reportData);

    void b(l config, WinkPublishQualityReportData reportData);

    void startKey(String key);
}
