package com.tencent.gdtad.kuikly;

import android.content.Context;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtKuiklyAPI extends QRouteApi {
    long getLocalVersion(Context context, String str, String str2);

    void init(Context context);

    void preDownload(Context context, String str, String str2);

    void registerExternalModule(b bVar);
}
