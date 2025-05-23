package com.tencent.mobileqq.qqui.tempapi;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQUITempApi extends QRouteApi {
    void initUrlDrawable();

    boolean isNewVersionDataline();

    void requestRecordAudioPermission(Activity activity, String str, String str2);
}
