package com.tencent.mobileqq.guild.nt.share.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IWxShareApi extends QRouteApi {
    boolean isWxInstalled();

    boolean isWxSupportApi();

    void shareImageToWx(String str, Bitmap bitmap, int i3);
}
