package com.tencent.mobileqq.vas.font.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IFontSoLoaderAdapter extends QRouteApi {
    boolean isVipFontSoDownloaded();

    boolean isVipFontSoLoaded();

    boolean loadSo();

    void setVipFontSoLoad(boolean z16);
}
