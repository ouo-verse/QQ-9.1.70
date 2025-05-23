package com.tencent.mobileqq.pic.api;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.Avif2JpgResult;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IDebugAvif2Jpg extends QRouteApi {
    Avif2JpgResult debugAvif2Jpg(String str, String str2, @Nullable String str3, @Nullable ThumbWidthHeightDP thumbWidthHeightDP, int i3, boolean z16);

    boolean isEnableLogMore();

    void setEnableLogMore(boolean z16);
}
