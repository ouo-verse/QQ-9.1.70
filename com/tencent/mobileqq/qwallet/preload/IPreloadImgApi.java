package com.tencent.mobileqq.qwallet.preload;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Set;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPreloadImgApi extends QRouteApi {
    public static final String IMG_SUFFIX = ".png";
    public static final String ZIP_SUFFIX = ".zip";

    /* loaded from: classes16.dex */
    public interface a {
        void a();

        void b(Object obj);
    }

    void download(AppInterface appInterface, String str, a aVar);

    void downloadWithSuffix(AppInterface appInterface, String str, String str2, a aVar);

    Bitmap getBitmap(AppInterface appInterface, String str);

    Drawable getDrawableByTheme(AppInterface appInterface, String str);

    String getZipFolderPath(AppInterface appInterface, String str);

    void onDestory();

    void startDownload(AppInterface appInterface, Set<String> set);
}
