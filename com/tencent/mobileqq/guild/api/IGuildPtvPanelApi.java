package com.tencent.mobileqq.guild.api;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildPtvPanelApi extends QRouteApi {
    Bundle getPtvBundleExt(QBaseActivity qBaseActivity, String str, String str2, int i3, boolean z16);
}
