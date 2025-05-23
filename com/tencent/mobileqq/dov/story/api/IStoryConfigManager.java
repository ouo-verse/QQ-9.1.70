package com.tencent.mobileqq.dov.story.api;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IStoryConfigManager extends QRouteApi {
    int getHighBitrate();

    int getMaxUploadFileSize();

    <V> V getStoryValue(@NonNull String str, @NonNull V v3);
}
