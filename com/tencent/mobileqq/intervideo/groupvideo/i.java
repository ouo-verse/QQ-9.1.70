package com.tencent.mobileqq.intervideo.groupvideo;

import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* compiled from: P */
/* loaded from: classes33.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f238215a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f238216b;

    /* renamed from: c, reason: collision with root package name */
    public static int[] f238217c = {3, 7, 9, 5, 10};

    public static boolean a() {
        if (f238216b) {
            return f238215a;
        }
        File file = null;
        try {
            file = new File(BaseApplication.getContext().getExternalFilesDir(null).getPath(), "versionchecker.test");
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (file != null) {
            f238215a = file.exists();
            f238216b = true;
        }
        return f238215a;
    }
}
