package com.tencent.mobileqq.ad.loadingad;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\"\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/ad/loadingad/b;", "", "", "adJson", "", "aid", "", "needExtraDownload", "", "onChooseAdEnd", "onDownloadAdEnd", "needWait", "cacheAid", "onNeedWaitRealTime", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface b {
    void onChooseAdEnd(@Nullable String adJson, long aid, boolean needExtraDownload);

    void onDownloadAdEnd(@Nullable String adJson, long aid);

    void onNeedWaitRealTime(@Nullable String adJson, boolean needWait, long cacheAid);
}
