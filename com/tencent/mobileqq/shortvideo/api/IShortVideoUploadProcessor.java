package com.tencent.mobileqq.shortvideo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IShortVideoUploadProcessor extends QRouteApi {
    public static final int SWITCH_DEFAULT = 1;
    public static final int SWITCH_PRE_UPLOAD = 3;
    public static final int SWITCH_REQ_AVOID = 2;

    boolean isBDHSuccess();
}
