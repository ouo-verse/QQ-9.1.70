package com.tencent.mobileqq.guild.nt.misc.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IActivityClassesApi extends QRouteApi {
    Class<? extends Activity> getJumpActivityClass();
}
