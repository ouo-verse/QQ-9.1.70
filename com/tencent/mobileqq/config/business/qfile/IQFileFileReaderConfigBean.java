package com.tencent.mobileqq.config.business.qfile;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IQFileFileReaderConfigBean extends QRouteApi {
    boolean getIsShowReaderBar();

    void setIsShowReaderBar(boolean z16);
}
