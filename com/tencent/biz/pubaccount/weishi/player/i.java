package com.tencent.biz.pubaccount.weishi.player;

import android.app.Activity;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String f81140a = String.valueOf(20191226);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f81141a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f81142b;

        a(d dVar, c cVar) {
            this.f81141a = dVar;
            this.f81142b = cVar;
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.i.c
        public void a(int i3, int i16, int i17) {
            i.M(this.f81141a, i3);
            i.K(this.f81141a, i16, i17);
            c cVar = this.f81142b;
            if (cVar != null) {
                cVar.a(i3, i16, i17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f81143a;

        /* renamed from: b, reason: collision with root package name */
        int f81144b;

        /* renamed from: c, reason: collision with root package name */
        int f81145c;

        /* renamed from: d, reason: collision with root package name */
        int f81146d;

        /* renamed from: e, reason: collision with root package name */
        int f81147e;

        /* renamed from: f, reason: collision with root package name */
        int f81148f;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a(int i3, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        View f81149a;

        /* renamed from: b, reason: collision with root package name */
        View f81150b;

        /* renamed from: c, reason: collision with root package name */
        int f81151c;

        /* renamed from: d, reason: collision with root package name */
        int f81152d;

        /* renamed from: e, reason: collision with root package name */
        int f81153e;

        /* renamed from: f, reason: collision with root package name */
        int f81154f;

        public d(View view, View view2, int i3, int i16, int i17, int i18) {
            this.f81149a = view;
            this.f81150b = view2;
            this.f81151c = i3;
            this.f81152d = i16;
            this.f81153e = i17;
            this.f81154f = i18;
        }

        public String toString() {
            return "PlayerLayoutParams{videoWidth=" + this.f81151c + ", videoHeight=" + this.f81152d + ", topBarHeight=" + this.f81153e + ", bottomBarHeight=" + this.f81154f + '}';
        }
    }

    private static float B(d dVar) {
        int i3;
        int i16 = dVar.f81151c;
        if (i16 == 0 || (i3 = dVar.f81152d) == 0) {
            return 0.0f;
        }
        return i16 / i3;
    }

    public static boolean C(int i3, int i16) {
        if (i3 > 0 && i16 > 0 && i16 / i3 > 1.5555556f) {
            return true;
        }
        return false;
    }

    private static boolean D(int i3, int i16) {
        int o16 = ba.o();
        int n3 = ba.n();
        if (o16 > 0 && n3 > 0) {
            float f16 = o16 / n3;
            if (f16 > 0.625f || f16 < 0.4375f) {
                return true;
            }
        }
        return i3 > 0 && i16 > 0 && ((float) i16) / ((float) i3) <= 1.5555556f;
    }

    public static boolean E(e eVar, e eVar2) {
        String y16 = y(eVar);
        String A = A(eVar);
        return !TextUtils.isEmpty(y16) && y16.equals(y(eVar2)) && !TextUtils.isEmpty(A) && A.equals(A(eVar2));
    }

    public static String F(String str) {
        URL o16 = o(str);
        if (o16 == null) {
            return "";
        }
        return o16.getHost();
    }

    public static Properties G(String str) {
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(str));
            return properties;
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void H(l lVar) {
        WSRetryVideoSpecUrl wSRetryVideoSpecUrl = lVar.f81189x;
        lVar.f81171f = wSRetryVideoSpecUrl.getVideoUrl();
        lVar.f81170e = wSRetryVideoSpecUrl.getFileSize();
        lVar.f81167b = wSRetryVideoSpecUrl.getWidth();
        lVar.f81168c = wSRetryVideoSpecUrl.getHeight();
        lVar.f81179n = wSRetryVideoSpecUrl.getDecodeStrategyType();
        lVar.f81180o = wSRetryVideoSpecUrl.getSelectedVideoSpecReason();
    }

    public static void I(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            ThreadManager.getUIHandler().post(runnable);
        }
    }

    public static String J(Set<Integer> set) {
        HashSet hashSet = new HashSet(set);
        StringBuilder sb5 = new StringBuilder();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            sb5.append((Integer) it.next());
            sb5.append(",");
        }
        String sb6 = sb5.toString();
        if (sb6.length() <= 2) {
            return sb6;
        }
        try {
            return sb6.substring(0, sb6.length() - 1);
        } catch (StringIndexOutOfBoundsException e16) {
            e16.printStackTrace();
            return sb6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(d dVar, int i3, int i16) {
        View view = dVar.f81150b;
        if (view == null || !(view.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (i16 != 5) {
            i3 = -1;
        }
        layoutParams.height = i3;
        layoutParams.width = n(dVar);
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M(d dVar, int i3) {
        View view = dVar.f81149a;
        if (view == null || !(view.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i3;
        layoutParams.width = n(dVar);
        view.setLayoutParams(layoutParams);
    }

    public static int N(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return i3;
        }
    }

    private static void c(List<WSVideoPreDownloadManager.c> list, List<l> list2, int i3) {
        if (list2.size() <= i3 || i3 < 0) {
            return;
        }
        l lVar = list2.get(i3);
        WSVideoPreDownloadManager.c cVar = new WSVideoPreDownloadManager.c(lVar.f81171f, lVar.f81169d, lVar.f81170e, lVar.f81187v);
        cVar.f81110a = lVar.f81166a;
        cVar.f81112c = lVar.f81175j;
        cVar.f81117h = lVar.f81188w;
        list.add(cVar);
    }

    public static int g(Activity activity, d dVar) {
        boolean D = D(dVar.f81151c, dVar.f81152d);
        b m3 = m(activity, dVar, D ? 5 : 1);
        L(dVar.f81149a, m3.f81143a, m3.f81144b, m3.f81145c);
        L(dVar.f81150b, m3.f81146d, m3.f81147e, m3.f81148f);
        return D ? 0 : 2;
    }

    public static int h(Activity activity, d dVar, c cVar) {
        return i(activity, dVar, new a(dVar, cVar));
    }

    private static int i(Activity activity, d dVar, c cVar) {
        int i3;
        int i16;
        int i17;
        int i18;
        int j3 = ba.j(activity);
        int o16 = ba.o();
        int q16 = ba.q(activity) + ba.f81729d;
        int i19 = dVar.f81154f;
        int i26 = (j3 - q16) - i19;
        int i27 = dVar.f81153e;
        int i28 = i26 - i27;
        int i29 = dVar.f81152d;
        float f16 = (i29 <= 0 || (i18 = dVar.f81151c) <= 0) ? 0.0f : i29 / i18;
        float f17 = o16;
        float f18 = i26 / f17;
        float f19 = i28 / f17;
        float f26 = 0.9f * f19;
        float f27 = 0.95f * f19;
        int i36 = j3 - i19;
        if (f16 > f18) {
            int i37 = j3 - i19;
            i16 = 1;
            i3 = i37;
            i17 = 0;
        } else if (f16 > f19 && f16 <= f18) {
            i17 = q16;
            i3 = i26;
            i16 = 2;
        } else if (f16 > f27 && f16 <= f19) {
            i17 = i27 + q16;
            i16 = 3;
            i3 = i28;
        } else if (f16 > f26 && f16 <= f27) {
            i17 = i27 + q16;
            i3 = (int) (f17 * f16);
            i16 = 4;
        } else if (f16 <= f26) {
            i17 = q16;
            i16 = 5;
            i3 = f16 > 0.0f ? (int) (f17 * f16) : -1;
        } else {
            i3 = i36;
            i16 = 0;
            i17 = 0;
        }
        if (cVar != null) {
            cVar.a(i17, i3, i16);
        }
        x.j("WSPlayerUtils", "[WSPlayerUtils.java][setPlayerLayout] ratioType:" + i16 + ", videoRate:" + f16 + ", h1Rate90f:" + f26 + ", h1Rate95f:" + f27 + ", h1Rate:" + f19 + ", h2Rate:" + f18 + ", videoWidth:" + dVar.f81151c + ", videoHeight:" + dVar.f81152d + ", h1:" + i28 + ", h2:" + i26 + ", statusHeight:" + q16 + ", bottomBarHeight:" + dVar.f81154f + ", screenWidth:" + o16 + ", screenHeight:" + j3 + ", playerHeight:" + i3);
        return i16 == 5 ? 0 : 2;
    }

    private static b j(float f16, float f17) {
        b bVar = new b();
        bVar.f81146d = -1;
        bVar.f81143a = -1;
        int i3 = (int) (f16 / f17);
        bVar.f81147e = i3;
        bVar.f81144b = i3;
        bVar.f81148f = 15;
        bVar.f81145c = 15;
        return bVar;
    }

    private static b k(Activity activity, d dVar, int i3, float f16, float f17) {
        b bVar = new b();
        if (f17 > f16) {
            int u16 = (int) (f16 * u(activity, dVar));
            bVar.f81146d = u16;
            bVar.f81143a = u16;
            bVar.f81147e = -1;
            bVar.f81144b = -1;
            bVar.f81148f = 14;
            bVar.f81145c = 14;
        } else {
            bVar.f81146d = -1;
            bVar.f81143a = -1;
            int i16 = (int) (i3 / f16);
            bVar.f81147e = i16;
            bVar.f81144b = i16;
            bVar.f81148f = 15;
            bVar.f81145c = 15;
        }
        return bVar;
    }

    private static b l(d dVar, int i3) {
        b bVar = new b();
        bVar.f81146d = -1;
        bVar.f81143a = -1;
        bVar.f81144b = -1;
        bVar.f81148f = 14;
        bVar.f81145c = 14;
        float x16 = x(dVar);
        if (x16 > 1.5555556f) {
            bVar.f81147e = -1;
        } else {
            bVar.f81147e = (int) (i3 * x16);
        }
        return bVar;
    }

    private static b m(Activity activity, d dVar, int i3) {
        b bVar = new b();
        bVar.f81146d = -1;
        bVar.f81143a = -1;
        bVar.f81147e = -1;
        bVar.f81144b = -1;
        bVar.f81148f = 14;
        bVar.f81145c = 14;
        int o16 = ba.o();
        int n3 = ba.n();
        float B = B(dVar);
        if (i3 != 5 || B <= 0.0f || n3 <= 0) {
            return bVar;
        }
        float f16 = o16;
        float f17 = f16 / n3;
        if (f17 > 0.625f) {
            return k(activity, dVar, o16, B, f17);
        }
        if (f17 < 0.4375f) {
            return j(f16, B);
        }
        return l(dVar, o16);
    }

    private static int n(d dVar) {
        int i3;
        int o16 = ba.o();
        int n3 = ba.n();
        if (o16 >= n3 && n3 != 0 && (i3 = dVar.f81152d) != 0) {
            float f16 = n3;
            float f17 = dVar.f81151c / i3;
            if (o16 / f16 > f17) {
                return (int) (f17 * f16);
            }
        }
        return -1;
    }

    public static URL o(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new URL(str);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String p(String str) {
        return com.tencent.open.base.g.d(str);
    }

    public static String q(String str, long j3) {
        try {
            String path = new URL(str).getPath();
            if (!TextUtils.isEmpty(path) && path.contains("/")) {
                path = path.substring(path.lastIndexOf(47) + 1);
            }
            String replace = (path + "-" + j3).replace("/", "");
            if (replace.length() <= 100) {
                return replace;
            }
            return "_" + replace.substring(replace.length() - 100);
        } catch (Exception e16) {
            x.f("WSPlayerUtils", "error:" + e16.getMessage());
            return "";
        }
    }

    public static long r(String str, long j3) {
        File w3 = w(str, j3);
        if (w3 == null) {
            return 0L;
        }
        return w3.length();
    }

    private static int u(Activity activity, d dVar) {
        return activity != null ? ba.j(activity) - dVar.f81154f : ba.n() - dVar.f81154f;
    }

    private static File v() {
        File externalCacheDir = BaseApplication.getContext().getExternalCacheDir();
        if (externalCacheDir == null) {
            return null;
        }
        return new File(externalCacheDir, "superplayer/170303112");
    }

    public static File w(String str, long j3) {
        File v3;
        File[] listFiles;
        String q16 = q(str, j3);
        if (str == null || j3 == 0 || TextUtils.isEmpty(q16) || (v3 = v()) == null || (listFiles = v3.listFiles()) == null) {
            return null;
        }
        for (File file : listFiles) {
            if (file.getName().startsWith(q16) && file.getName().endsWith("mp4")) {
                return file;
            }
        }
        return null;
    }

    private static float x(d dVar) {
        int i3;
        int i16 = dVar.f81151c;
        if (i16 == 0 || (i3 = dVar.f81152d) == 0) {
            return 0.0f;
        }
        return i3 / i16;
    }

    public static List<WSVideoPreDownloadManager.c> z(List<l> list, int i3, boolean z16) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        if (z16) {
            int i16 = i3 + 1;
            for (int i17 = i16; i17 < i16 + 3; i17++) {
                c(arrayList, arrayList2, i17);
            }
        } else {
            int i18 = i3 - 1;
            for (int i19 = i18; i19 > i18 - 3; i19--) {
                c(arrayList, arrayList2, i19);
            }
        }
        return arrayList;
    }

    public static int d(List<Integer> list) {
        return e(list, true);
    }

    public static int f(d dVar) {
        M(dVar, 0);
        K(dVar, t(dVar.f81151c, dVar.f81152d), 5);
        return 0;
    }

    public static String A(e eVar) {
        l lVar;
        String str;
        return (eVar == null || (lVar = eVar.f81127c) == null || (str = lVar.f81171f) == null) ? "" : str;
    }

    private static void L(View view, int i3, int i16, int i17) {
        if (view == null || !(view.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        layoutParams.addRule(i17);
        view.setLayoutParams(layoutParams);
    }

    public static int e(List<Integer> list, boolean z16) {
        if (z16) {
            list = new ArrayList(list);
        }
        int size = list.size();
        int i3 = 0;
        if (size <= 0) {
            return 0;
        }
        for (Integer num : list) {
            if (num != null) {
                i3 += num.intValue();
            }
        }
        return i3 / size;
    }

    public static String y(e eVar) {
        l lVar;
        String str;
        return (eVar == null || (lVar = eVar.f81127c) == null || (str = lVar.f81166a) == null) ? "" : str;
    }

    public static String s(int i3) {
        switch (i3) {
            case 0:
                return " PLAY_STATE_IDLE ";
            case 1:
                return " PLAY_STATE_PREPARING ";
            case 2:
                return " PLAY_STATE_PREPARED ";
            case 3:
                return " PLAY_STATE_PLAYING ";
            case 4:
                return " PLAY_STATE_BUFFERING ";
            case 5:
                return " PLAY_STATE_PAUSED ";
            case 6:
                return " PLAY_STATE_ERROR ";
            case 7:
                return " PLAY_STATE_COMPLETE ";
            default:
                return " PLAY_STATE_UNKNOWN ";
        }
    }

    private static int t(int i3, int i16) {
        if (i3 <= 0 || i16 <= 0) {
            return -1;
        }
        return (int) (ba.o() * (i16 / i3));
    }
}
