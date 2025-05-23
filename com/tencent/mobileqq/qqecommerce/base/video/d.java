package com.tencent.mobileqq.qqecommerce.base.video;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H&J*\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\bH&J\b\u0010\u0012\u001a\u00020\bH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/video/d;", "", "", "what", "", "arg1", "arg2", "obj", "", "onInfo", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extInfo", "onError", "onComplete", "onSeekComplete", "onPrepared", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface d {
    void onComplete();

    void onError(int module, int errorType, int errorCode, String extInfo);

    void onInfo(int what, long arg1, long arg2, Object obj);

    void onPrepared();

    void onSeekComplete();
}
