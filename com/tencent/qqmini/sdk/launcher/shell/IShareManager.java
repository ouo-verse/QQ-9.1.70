package com.tencent.qqmini.sdk.launcher.shell;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IShareManager {
    void newShareInfoRequest(InnerShareData innerShareData);

    void shareAppMessage(InnerShareData innerShareData);

    void shareAppPictureMessage(IMiniAppContext iMiniAppContext, InnerShareData innerShareData);
}
