package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class bd {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a extends bc {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.bc
        public String b(Context context, String str, List<w> list) {
            if (list == null) {
                return au.k(context, new URL(str));
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (w wVar : list) {
                buildUpon.appendQueryParameter(wVar.a(), wVar.b());
            }
            return au.k(context, new URL(buildUpon.toString()));
        }
    }

    static int a(int i3, int i16) {
        return (((i16 + 243) / 1448) * 132) + 1080 + i3 + i16;
    }

    static int b(int i3, int i16, int i17) {
        return (((i16 + 200) / 1448) * 132) + 1011 + i16 + i3 + i17;
    }

    private static int c(bc bcVar, String str, List<w> list, String str2) {
        if (bcVar.a() == 1) {
            return a(str.length(), d(str2));
        }
        if (bcVar.a() == 2) {
            return b(str.length(), e(list), d(str2));
        }
        return -1;
    }

    static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    static int e(List<w> list) {
        int i3 = 0;
        for (w wVar : list) {
            if (!TextUtils.isEmpty(wVar.a())) {
                i3 += wVar.a().length();
            }
            if (!TextUtils.isEmpty(wVar.b())) {
                i3 += wVar.b().length();
            }
        }
        return i3 * 2;
    }

    public static String f(Context context, String str, List<w> list) {
        return g(context, str, list, new a(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00aa A[Catch: MalformedURLException -> 0x00c3, TRY_ENTER, TryCatch #4 {MalformedURLException -> 0x00c3, blocks: (B:6:0x000f, B:8:0x0016, B:10:0x0020, B:12:0x0027, B:14:0x002d, B:15:0x0030, B:16:0x0035, B:18:0x003b, B:20:0x0044, B:21:0x004c, B:42:0x00aa, B:43:0x00bc), top: B:5:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(Context context, String str, List<w> list, bc bcVar, boolean z16) {
        ax axVar;
        ArrayList arrayList;
        IOException iOException;
        String str2;
        String str3;
        if (au.t(context)) {
            try {
                ArrayList<String> arrayList2 = new ArrayList<>();
                if (z16) {
                    ax a16 = bb.c().a(str);
                    if (a16 != null) {
                        arrayList2 = a16.d(str);
                    }
                    axVar = a16;
                } else {
                    axVar = null;
                }
                if (!arrayList2.contains(str)) {
                    arrayList2.add(str);
                }
                Iterator<String> it = arrayList2.iterator();
                String str4 = null;
                while (it.hasNext()) {
                    String next = it.next();
                    if (list != null) {
                        arrayList = new ArrayList(list);
                    } else {
                        arrayList = null;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                    } catch (IOException e16) {
                        iOException = e16;
                        str2 = str4;
                    }
                    if (bcVar.c(context, next, arrayList)) {
                        String b16 = bcVar.b(context, next, arrayList);
                        try {
                        } catch (IOException e17) {
                            e = e17;
                            str3 = b16;
                        }
                        if (!TextUtils.isEmpty(b16)) {
                            if (axVar != null) {
                                try {
                                    axVar.l(next, System.currentTimeMillis() - currentTimeMillis, c(bcVar, next, arrayList, b16));
                                } catch (IOException e18) {
                                    iOException = e18;
                                    str2 = b16;
                                    if (axVar != null) {
                                        axVar.m(next, System.currentTimeMillis() - currentTimeMillis, c(bcVar, next, arrayList, str2), iOException);
                                    }
                                    iOException.printStackTrace();
                                    str4 = str2;
                                }
                            }
                            return b16;
                        }
                        if (axVar != null) {
                            str3 = b16;
                            try {
                                axVar.m(next, System.currentTimeMillis() - currentTimeMillis, c(bcVar, next, arrayList, b16), null);
                            } catch (IOException e19) {
                                e = e19;
                                String str5 = str3;
                                iOException = e;
                                str2 = str5;
                                if (axVar != null) {
                                }
                                iOException.printStackTrace();
                                str4 = str2;
                            }
                        } else {
                            str3 = b16;
                        }
                        str4 = str3;
                    } else {
                        return str4;
                    }
                }
                return str4;
            } catch (MalformedURLException e26) {
                e26.printStackTrace();
            }
        }
        return null;
    }
}
