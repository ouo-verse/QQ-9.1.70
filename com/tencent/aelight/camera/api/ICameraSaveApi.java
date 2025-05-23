package com.tencent.aelight.camera.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.File;
import ss.e;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ICameraSaveApi extends QRouteApi {
    void saveMediaToAlbum(Context context, File file, String str, e eVar);
}
