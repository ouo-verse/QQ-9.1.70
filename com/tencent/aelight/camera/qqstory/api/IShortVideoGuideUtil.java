package com.tencent.aelight.camera.qqstory.api;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IShortVideoGuideUtil extends QRouteApi {
    public static final String TAG = "ShortVideoGuideUtil";

    boolean isAllResourceReady();

    boolean isResourceReady(AppInterface appInterface);

    boolean startPTVActivity(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3);
}
