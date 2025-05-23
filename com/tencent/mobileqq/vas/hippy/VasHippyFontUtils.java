package com.tencent.mobileqq.vas.hippy;

import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.dom.node.TypeFaceUtil;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasHippyFontUtils {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a extends f {

        /* renamed from: a, reason: collision with root package name */
        private Promise f309453a;

        /* renamed from: b, reason: collision with root package name */
        private int f309454b;

        /* renamed from: c, reason: collision with root package name */
        private int f309455c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f309456d = 0;

        public a(Promise promise, int i3) {
            this.f309453a = promise;
            this.f309454b = i3;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            boolean z16;
            String str;
            File file;
            String str2;
            if (gVar == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("download done task = ");
                sb5.append(gVar.f313011i);
                sb5.append(" path = ");
                Map<String, File> map = gVar.f313010h;
                if (map != null) {
                    str2 = map.toString();
                } else {
                    str2 = "";
                }
                sb5.append(str2);
                QLog.i("VasHippyFontUtils", 2, sb5.toString());
            }
            int i3 = 0;
            if (gVar.i() == 3 && gVar.f313006d == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.f309455c++;
                Map<String, File> map2 = gVar.f313010h;
                if (map2 != null) {
                    file = map2.get(gVar.f313011i);
                } else {
                    file = null;
                }
                VasHippyFontUtils.g(file);
            } else {
                this.f309456d++;
            }
            int i16 = this.f309455c;
            int i17 = this.f309456d;
            if (i16 + i17 == this.f309454b) {
                Promise promise = this.f309453a;
                if (i17 > 0) {
                    i3 = -1;
                }
                if (i17 > 0) {
                    str = "fail";
                } else {
                    str = "success";
                }
                VasHippyFontUtils.h(promise, i3, str);
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static g b(String str, String str2) {
        return new g(str, new File(str2));
    }

    public static ArrayList c(@NonNull HippyArray hippyArray) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < hippyArray.size(); i3++) {
            String string = hippyArray.getString(i3);
            if (!a(f(string))) {
                arrayList.add(string);
            }
        }
        return arrayList;
    }

    public static h d() {
        return ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(4);
    }

    public static HashMap<String, Typeface> e() {
        Object obj;
        try {
            Field declaredField = TypeFaceUtil.class.getDeclaredField("mFontCache");
            declaredField.setAccessible(true);
            obj = declaredField.get("mFontCache");
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("VasHippyFontUtils", 1, "getStaticFieldValue error ", e16);
            obj = null;
        }
        if (obj == null || !(obj instanceof HashMap)) {
            return null;
        }
        return (HashMap) obj;
    }

    public static String f(String str) {
        return HippyUtils.getHippyFontRootDir() + i(str);
    }

    public static void g(File file) {
        HashMap<String, Typeface> e16;
        if (file == null || !file.exists() || (e16 = e()) == null) {
            return;
        }
        String str = j(file.getAbsolutePath()) + 0;
        if (QLog.isColorLevel()) {
            QLog.i("VasHippyFontUtils", 2, "injectHippyTypeFace key = " + str);
        }
        try {
            e16.put(str, Typeface.createFromFile(file));
        } catch (RuntimeException e17) {
            e17.printStackTrace();
            QLog.e("VasHippyFontUtils", 1, "createFromFile error ", e17);
        }
    }

    public static void h(Promise promise, int i3, String str) {
        if (promise == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VasHippyFontUtils", 2, "notifyPromise returnCode = " + i3 + " msg = " + str);
        }
        promise.resolve(d.a(i3, str, null));
    }

    public static String i(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("/")) {
            return str.substring(str.lastIndexOf("/") + 1);
        }
        return "";
    }

    public static String j(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = File.separator;
            if (str.contains(str2)) {
                try {
                    String substring = str.substring(str.lastIndexOf(str2) + 1);
                    return substring.substring(0, substring.lastIndexOf("."));
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e("VasHippyFontUtils", 1, "parseFontFamily error , path = " + str, e16);
                }
            }
        }
        return "";
    }

    public static void k(final HippyArray hippyArray, final Promise promise) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.hippy.VasHippyFontUtils.1
            @Override // java.lang.Runnable
            public void run() {
                VasHippyFontUtils.l(HippyArray.this, promise);
            }
        }, 128, null, false);
    }

    public static void l(HippyArray hippyArray, Promise promise) {
        if (hippyArray != null && hippyArray.size() != 0) {
            ArrayList c16 = c(hippyArray);
            if (c16.size() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("VasHippyFontUtils", 2, "all file has downloaded");
                }
                h(promise, 0, "success");
            } else {
                a aVar = new a(promise, c16.size());
                h d16 = d();
                Iterator it = c16.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    d16.startDownload(b(str, f(str)), aVar, null);
                }
            }
        }
    }
}
