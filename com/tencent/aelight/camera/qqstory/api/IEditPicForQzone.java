package com.tencent.aelight.camera.qqstory.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IEditPicForQzone extends QRouteApi {
    Intent newPictureEditIntentWithoutPublish(Activity activity, String str);
}
