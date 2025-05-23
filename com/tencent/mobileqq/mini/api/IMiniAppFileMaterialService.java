package com.tencent.mobileqq.mini.api;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniAppFileMaterialService extends QRouteApi {
    public static final String MIME_TYPE_IMAGE = "image/*";

    String getFileMimeTypeImpl(String str);

    boolean isFileSupported(String str);

    boolean isMimeTypeSupported(@NonNull String str);

    void showSupportedAppList(@NonNull Activity activity, String str);

    void showSupportedAppList(@NonNull Activity activity, String str, @NonNull String str2);
}
