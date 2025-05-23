package com.tencent.mobileqq.participle.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IParticipleUIApi extends QRouteApi {
    public static final String MAX_LENGTH = "max_length";
    public static final String ORIGIN_WORDS = "origin_words";
    public static final String SELECTED_WORDS = "selected_words";

    void startFragmentForResult(Activity activity, int i3, Intent intent);
}
