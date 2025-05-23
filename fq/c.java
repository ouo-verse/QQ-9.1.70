package fq;

import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f400303a;

    /* renamed from: b, reason: collision with root package name */
    protected static final String f400304b;

    /* renamed from: c, reason: collision with root package name */
    protected static final String f400305c = BaseApplication.getContext().getFilesDir().getParent();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f400306a;

        /* renamed from: b, reason: collision with root package name */
        public static final String f400307b;

        static {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(c.f400304b);
            String str = File.separator;
            sb5.append(str);
            sb5.append("ae");
            f400306a = sb5.toString();
            f400307b = c.f400303a + str + "ae";
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final String f400308a = a.f400307b + File.separator + "tmp";
    }

    static {
        if ((BaseApplication.getContext().getExternalFilesDir(null) == null || BaseApplication.getContext().getExternalCacheDir() == null) ? false : true) {
            f400304b = BaseApplication.getContext().getExternalFilesDir(null).getPath();
            f400303a = BaseApplication.getContext().getExternalCacheDir().getPath();
        } else {
            f400304b = BaseApplication.getContext().getFilesDir().getPath();
            f400303a = BaseApplication.getContext().getCacheDir().getPath();
        }
    }
}
