package o6;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.component.media.image.ImageKey;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f422154a;

    /* renamed from: b, reason: collision with root package name */
    private static a f422155b;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    static class b extends a {
        b() {
        }

        @Override // o6.a
        public String c(String str) {
            return ImageKey.getUrlKey(str, true);
        }
    }

    public static a d() {
        if (f422155b == null) {
            synchronized (a.class) {
                if (f422155b == null) {
                    f422155b = new C10888a();
                }
            }
        }
        return f422155b;
    }

    public static a e() {
        if (f422154a == null) {
            synchronized (a.class) {
                if (f422154a == null) {
                    f422154a = new b();
                }
            }
        }
        return f422154a;
    }

    public final String b(String str) {
        return (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) ? c(str) : str;
    }

    public abstract String c(String str);

    /* compiled from: P */
    /* renamed from: o6.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    static class C10888a extends a {
        C10888a() {
        }

        @Override // o6.a
        public String c(String str) {
            int indexOf;
            if (str == null) {
                return null;
            }
            if (!a.f(str, "http://")) {
                if (a.f(str, "https://")) {
                    indexOf = str.indexOf("/", 8);
                } else {
                    indexOf = str.indexOf("/");
                }
            } else {
                indexOf = str.indexOf("/", 7);
            }
            int indexOf2 = str.indexOf(".zip");
            if (indexOf == -1) {
                return null;
            }
            if (indexOf2 != -1) {
                return str.substring(indexOf + 1, indexOf2);
            }
            return str.substring(indexOf + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.regionMatches(true, 0, str2, 0, str2.length());
    }
}
