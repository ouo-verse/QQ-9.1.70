package com.tencent.biz.bmqq.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes2.dex */
public interface IBmqqSegmentApi extends QRouteApi {
    void initSegmentCache(Context context);

    boolean isBmqqUin(Context context, String str);

    boolean isBmqqUin(String str);

    boolean isBmqqUinNoBlock(String str);

    boolean isCrm3ExtUin(Context context, String str);

    boolean isUin(String str);

    boolean isWeixinUin(Context context, String str);

    void updateEqqConfig(String str);
}
