package com.tencent.mobileqq.qqexpand.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qqexpand.bean.common.Pair;
import com.tencent.mobileqq.qqexpand.bean.flutter.ApiDecodeRequest;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQFlutterFaceLoaderApi extends QRouteApi {

    /* compiled from: P */
    @PluginInterface
    /* loaded from: classes16.dex */
    public interface ApiFaceObserver {
        void onFaceUpdate(ApiDecodeRequest apiDecodeRequest, Bitmap bitmap, String str);
    }

    void addFaceObserver(ApiFaceObserver apiFaceObserver);

    void clearCache();

    Pair<Bitmap, Boolean> getBitmap(ApiDecodeRequest apiDecodeRequest);

    void onDestroy();

    void removeFaceObserver(ApiFaceObserver apiFaceObserver);

    void setContext(Context context);
}
