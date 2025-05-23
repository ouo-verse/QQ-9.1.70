package com.tencent.mobileqq.qqvideoedit.editor.hdr;

import android.text.TextUtils;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f275777a = false;

    public static boolean a() {
        ms.a.f("HDRInitUtils", "checkHdrSo|WILL.");
        if (!f275777a) {
            String aEKitBaseResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEKitBaseResUnzipFinalPath();
            ms.a.f("HDRInitUtils", "checkHdrSo|filePath:" + aEKitBaseResUnzipFinalPath);
            if (!TextUtils.isEmpty(aEKitBaseResUnzipFinalPath)) {
                System.load(aEKitBaseResUnzipFinalPath + "libYTHDR.so");
                ms.a.f("HDRInitUtils", "checkHdrSo|finish.");
                f275777a = true;
            }
        }
        return true;
    }
}
