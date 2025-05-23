package com.tencent.aelight.camera.education.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IEducationEditPic extends QRouteApi {
    void startAnswerSearchPicEditActivity(Activity activity, String str, int i3, boolean z16);
}
