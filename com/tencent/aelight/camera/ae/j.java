package com.tencent.aelight.camera.ae;

import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f65585a;

    /* renamed from: b, reason: collision with root package name */
    protected static final String f65586b;

    /* renamed from: c, reason: collision with root package name */
    protected static final String f65587c = BaseApplication.getContext().getFilesDir().getParent();

    /* renamed from: d, reason: collision with root package name */
    protected static final String f65588d;

    /* renamed from: e, reason: collision with root package name */
    protected static final String f65589e;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f65590a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f65591b;

        /* renamed from: c, reason: collision with root package name */
        public static final String f65592c;

        static {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(j.f65589e);
            String str = File.separator;
            sb5.append(str);
            sb5.append("ae");
            f65590a = sb5.toString();
            f65591b = j.f65586b + str + "ae";
            f65592c = j.f65585a + str + "ae";
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String f65593a = a.f65592c + File.separator + "tmp";
    }

    static {
        if ((BaseApplication.getContext().getExternalFilesDir(null) == null || BaseApplication.getContext().getExternalCacheDir() == null) ? false : true) {
            f65586b = BaseApplication.getContext().getExternalFilesDir(null).getPath();
            f65585a = BaseApplication.getContext().getExternalCacheDir().getPath();
        } else {
            f65586b = BaseApplication.getContext().getFilesDir().getPath();
            f65585a = BaseApplication.getContext().getCacheDir().getPath();
        }
        f65589e = BaseApplication.getContext().getFilesDir().getPath();
        f65588d = BaseApplication.getContext().getCacheDir().getPath();
    }
}
