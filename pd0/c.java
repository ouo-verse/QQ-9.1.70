package pd0;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, List<Integer>> f425910c;

    /* renamed from: a, reason: collision with root package name */
    private static final List<Integer> f425908a = Arrays.asList(120, 200, 320, 512, 640, 750, 1000);

    /* renamed from: b, reason: collision with root package name */
    private static final List<Integer> f425909b = Arrays.asList(40, 60, 80, 100, 120, 140, 160, 200);

    /* renamed from: d, reason: collision with root package name */
    private static final List<Integer> f425911d = Arrays.asList(180, 200, 320);

    private static int a(List<Integer> list, int i3) {
        if (list != null && list.size() != 0) {
            int size = list.size() - 1;
            int i16 = 0;
            while (i16 < size - 1) {
                int i17 = ((size - i16) / 2) + i16;
                if (list.get(i17).intValue() > i3) {
                    size = i17;
                } else {
                    i16 = i17;
                }
            }
            if (list.get(size).intValue() == i3) {
                return i3;
            }
            return list.get(i16).intValue();
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        boolean z16;
        if (g(str)) {
            return j(str);
        }
        if (str.endsWith("/")) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf >= 0 && lastIndexOf < str.length() - 1) {
            String substring = str.substring(lastIndexOf + 1, str.length());
            int length = substring.length() - 1;
            z16 = false;
            while (length >= 0) {
                if (Character.isDigit(substring.charAt(length))) {
                    length--;
                    z16 = true;
                }
            }
            if (z16) {
                str = str.substring(0, lastIndexOf);
            }
            return str + "/";
        }
        z16 = false;
        if (z16) {
        }
        return str + "/";
    }

    @Nullable
    private static String c(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] split = str.split("/");
        if (split.length < 4) {
            return null;
        }
        return split[3];
    }

    private static int d(String str, int i3) {
        if (str == null) {
            hd0.c.t("Q.qqstory.home.ThumbnailUrlHelper", "origPath is null");
            return -1;
        }
        if (h(str)) {
            return a(f425908a, i3);
        }
        if (i(str)) {
            return a(f425909b, i3);
        }
        if (!g(str)) {
            return -1;
        }
        return a(f425911d, i3);
    }

    public static String e(String str) {
        int f16 = f(str, 120);
        if (f16 < 0) {
            hd0.c.t("Q.qqstory.home.ThumbnailUrlHelper", "cannot find thumbsize in getMinimumThumbnailPath " + str);
            return str;
        }
        String b16 = b(str);
        hd0.c.a("Q.qqstory.home.ThumbnailUrlHelper", "getMinimumThumbnailPath " + b16 + f16);
        return b16 + f16;
    }

    private static int f(String str, int i3) {
        if (str == null) {
            hd0.c.t("Q.qqstory.home.ThumbnailUrlHelper", "origPath is null");
            return -1;
        }
        if (f425910c == null) {
            return d(str, i3);
        }
        String c16 = c(str);
        if (c16 == null) {
            hd0.c.t("Q.qqstory.home.ThumbnailUrlHelper", "cannot find bid with url " + str);
            return -1;
        }
        List<Integer> list = f425910c.get(c16);
        if (list == null) {
            hd0.c.t("Q.qqstory.home.ThumbnailUrlHelper", "cannot find specs with bid " + c16 + ", check log");
            return -1;
        }
        return a(list, i3);
    }

    private static boolean g(@NonNull String str) {
        int i3;
        if (str.startsWith("http://")) {
            i3 = 7;
        } else {
            if (str.startsWith("https://")) {
                i3 = 8;
            }
            return false;
        }
        if (!str.startsWith("qqpublic.qpic.cn/", i3)) {
            return false;
        }
        int i16 = i3 + 17;
        if (!str.startsWith("qq_public_cover/", i16) && !str.startsWith("qq_public/", i16)) {
            return false;
        }
        return true;
    }

    public static boolean h(@NonNull String str) {
        if (str.length() >= 30 && str.startsWith("/qqstory_pic/", 17)) {
            return true;
        }
        return str.contains("/qqstory_pic/");
    }

    @Deprecated
    public static boolean i(@NonNull String str) {
        if (str.length() >= 26 && str.startsWith("/qqstory/", 17)) {
            return true;
        }
        return str.contains("/qqstory/");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String j(String str) {
        boolean z16;
        if (str.endsWith("/")) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf >= 0 && lastIndexOf < str.length() - 1) {
            String substring = str.substring(lastIndexOf + 1, str.length());
            int i3 = 0;
            z16 = false;
            while (true) {
                if (i3 >= substring.length()) {
                    break;
                }
                char charAt = substring.charAt(i3);
                if (!Character.isDigit(charAt)) {
                    if (charAt == '?') {
                        z16 = true;
                    }
                } else {
                    i3++;
                    z16 = true;
                }
            }
            if (!z16) {
                return str.substring(0, lastIndexOf + 1);
            }
            return str;
        }
        z16 = false;
        if (!z16) {
        }
    }
}
