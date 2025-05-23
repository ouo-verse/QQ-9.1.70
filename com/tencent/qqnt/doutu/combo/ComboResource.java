package com.tencent.qqnt.doutu.combo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.doutu.api.IDoutuUtils;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
@TargetApi(12)
/* loaded from: classes24.dex */
public class ComboResource {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f356066a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f356067b;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f356068c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f356069d;

    /* renamed from: e, reason: collision with root package name */
    public static float f356070e;

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f356071f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f356072g;

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f356073h;

    /* renamed from: i, reason: collision with root package name */
    private static LruCache<String, a> f356074i;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f356077a;

        /* renamed from: b, reason: collision with root package name */
        public int f356078b;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f356079c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31375);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        String str = IDoutuUtils.DOUTU_ANIMA_RES_PATH;
        sb5.append(str);
        sb5.append("combo");
        String str2 = File.separator;
        sb5.append(str2);
        f356066a = VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
        f356067b = new String[]{"ribbon0.png", "ribbon1.png", "ribbon2.png", "ribbon3.png", "ribbon4.png", "ribbon5.png", "ribbon6.png", "ribbon7.png", "ribbon8.png", "ribbon9.png"};
        f356068c = new String[]{"0.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png"};
        f356069d = false;
        f356070e = 2.0f;
        f356071f = new String[]{"1bitX.png", "2bitX.png", "3bitX.png"};
        f356072g = str;
        f356073h = new String[]{str + "bonus_8" + str2 + "doutuX8_", str + "bonus_18" + str2 + "doutuX18_", str + "bonus_88" + str2 + "doutuX88_", str + "bonus_888" + str2 + "doutuX888_"};
        f356074i = new LruCache<>(15);
    }

    public static void a() {
        f356074i.evictAll();
    }

    public static a b(int i3, Context context) {
        return f(f356066a + f356068c[i3], 1, context);
    }

    public static a c(int i3, Context context) {
        return f(f356066a + f356071f[i3 - 1], 1, context);
    }

    public static a d(Context context) {
        return f(f356066a + "dui.png", 2, context);
    }

    public static File[] e(int i3) {
        int i16 = 0;
        String str = null;
        while (true) {
            int[] iArr = ComboEggView.D;
            if (i16 >= iArr.length) {
                break;
            }
            if (i3 == iArr[i16]) {
                str = f356073h[i16];
            }
            i16++;
        }
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i17 = 1; i17 <= 31; i17++) {
            File file = new File(str + i17 + ".png");
            if (file.exists()) {
                arrayList.add(file);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public static a f(String str, int i3, Context context) {
        int n3;
        int n16;
        a aVar = f356074i.get(str);
        if (aVar != null) {
            return aVar;
        }
        int i16 = 0;
        if (!new File(str).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("ComboUIManager", 2, "resource missing: " + str);
            }
            if (!f356069d) {
                f356069d = true;
                ThreadManagerV2.post(new Runnable(context) { // from class: com.tencent.qqnt.doutu.combo.ComboResource.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Context f356075d;

                    {
                        this.f356075d = context;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            ((IDoutuUtils) QRoute.api(IDoutuUtils.class)).markResDamaged(this.f356075d);
                        }
                    }
                }, 5, null, false);
            }
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        Resources resources = context.getResources();
        int i17 = options.outHeight;
        int i18 = options.outWidth;
        try {
            Drawable createFromPath = Drawable.createFromPath(str);
            if (i18 != 0 && i17 != 0 && createFromPath != null) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            n3 = 0;
                        } else {
                            n16 = Utils.n(24.0f, resources);
                        }
                    } else {
                        n16 = Utils.n(32.0f, resources);
                    }
                    int i19 = n16;
                    i16 = (int) ((n16 / i17) * i18);
                    n3 = i19;
                } else {
                    i16 = Utils.n(i18 / f356070e, resources);
                    n3 = Utils.n(i17 / f356070e, resources);
                }
                a aVar2 = new a();
                aVar2.f356077a = i16;
                aVar2.f356078b = n3;
                aVar2.f356079c = createFromPath;
                f356074i.put(str, aVar2);
                return aVar2;
            }
            if (!f356069d) {
                f356069d = true;
                ThreadManagerV2.post(new Runnable(context) { // from class: com.tencent.qqnt.doutu.combo.ComboResource.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Context f356076d;

                    {
                        this.f356076d = context;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            ((IDoutuUtils) QRoute.api(IDoutuUtils.class)).markResDamaged(this.f356076d);
                        }
                    }
                }, 5, null, false);
            }
            return null;
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.d("ComboUIManager", 2, "load resource oom: " + str);
            }
            return null;
        }
    }

    public static a g(Context context) {
        return f(f356066a + "ribbonX.png", 3, context);
    }

    public static a h(int i3, Context context) {
        if (i3 >= 0) {
            String[] strArr = f356067b;
            if (i3 < strArr.length) {
                return f(f356066a + strArr[i3], 2, context);
            }
        }
        QLog.e("ComboResource", 1, "[getNumber] error, number=", Integer.valueOf(i3));
        return null;
    }
}
