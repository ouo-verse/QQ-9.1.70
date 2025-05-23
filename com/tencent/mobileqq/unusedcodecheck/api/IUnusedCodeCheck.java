package com.tencent.mobileqq.unusedcodecheck.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IUnusedCodeCheck extends QRouteApi {
    boolean analysis(Context context, File file, boolean z16);

    void clearCheckInfo();

    void trigger();
}
