package com.tencent.mobileqq.ecshop.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes5.dex */
public interface IEcshopService extends IRuntimeService {
    void enterGDTVideoActivity(qq_ad_get.QQAdGetRsp.AdInfo adInfo, String str, boolean z16, Activity activity);

    boolean enterGdtCanvasActivity(qq_ad_get.QQAdGetRsp.AdInfo adInfo, String str, boolean z16, Activity activity);
}
