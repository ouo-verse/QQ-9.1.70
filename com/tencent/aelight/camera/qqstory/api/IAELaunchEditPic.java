package com.tencent.aelight.camera.qqstory.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAELaunchEditPic extends QRouteApi {
    Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3);

    Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16, int i17);

    Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16, int i17, Bundle bundle);

    Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16, int i17, HashMap<String, Object> hashMap);

    Intent startEditPic(Activity activity, String str, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, int i3, int i16, int i17, boolean z36, HashMap<String, Object> hashMap);
}
