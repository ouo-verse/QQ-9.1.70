package com.tencent.aelight.camera.qqstory.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQIMBeautyManager extends QRouteApi {
    int getBeautyConfigVersion(Context context);

    void parseConfig();

    boolean saveBeautyConfig(String str, int i3, Context context);
}
