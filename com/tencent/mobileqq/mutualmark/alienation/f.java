package com.tencent.mobileqq.mutualmark.alienation;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.richmedia.p2veffect.effect.base.P2VGlobalConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.config.business.bc;
import com.tencent.mobileqq.mutualmark.alienation.f;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static f f251974a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f251975b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Resources f251976d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f251977e;

        a(Resources resources, ImageView imageView) {
            this.f251976d = resources;
            this.f251977e = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) resources, (Object) imageView);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                return;
            }
            if (uRLDrawable != null) {
                int f16 = BaseAIOUtils.f(16.0f, this.f251976d);
                int intrinsicWidth = (uRLDrawable.getIntrinsicWidth() * f16) / uRLDrawable.getIntrinsicHeight();
                ViewGroup.LayoutParams layoutParams = this.f251977e.getLayoutParams();
                layoutParams.height = f16;
                layoutParams.width = intrinsicWidth;
                this.f251977e.setImageDrawable(null);
                this.f251977e.setImageDrawable(uRLDrawable);
                this.f251977e.setLayoutParams(layoutParams);
                this.f251977e.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b implements Function1<com.tencent.cachedrawable.dynamicdrawable.d, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<ImageView> f251978d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<FastDynamicDrawable> f251979e;

        /* renamed from: f, reason: collision with root package name */
        private final WeakReference<Resources> f251980f;

        public b(ImageView imageView, FastDynamicDrawable fastDynamicDrawable, Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, imageView, fastDynamicDrawable, resources);
                return;
            }
            this.f251978d = new WeakReference<>(imageView);
            this.f251979e = new WeakReference<>(fastDynamicDrawable);
            this.f251980f = new WeakReference<>(resources);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(ImageView imageView, FastDynamicDrawable fastDynamicDrawable, ViewGroup.LayoutParams layoutParams) {
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(fastDynamicDrawable);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Unit invoke(com.tencent.cachedrawable.dynamicdrawable.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            }
            final ImageView imageView = this.f251978d.get();
            final FastDynamicDrawable fastDynamicDrawable = this.f251979e.get();
            Resources resources = this.f251980f.get();
            if (imageView != null && fastDynamicDrawable != null && resources != null && fastDynamicDrawable.getIntrinsicHeight() != 0 && fastDynamicDrawable.getIntrinsicWidth() != 0) {
                int f16 = BaseAIOUtils.f(16.0f, resources);
                int intrinsicWidth = (fastDynamicDrawable.getIntrinsicWidth() * f16) / fastDynamicDrawable.getIntrinsicHeight();
                final ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.height = f16;
                layoutParams.width = intrinsicWidth;
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    imageView.setImageDrawable(null);
                    imageView.setImageDrawable(fastDynamicDrawable);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                } else {
                    imageView.post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.alienation.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.b.c(imageView, fastDynamicDrawable, layoutParams);
                        }
                    });
                }
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73283);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f251975b = ar.b("shouyouye", "2024-01-29", "vas_bug_120039689").isEnable(true);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String d(long j3, int i3, long j16, boolean z16) {
        String str;
        String str2 = MutualMarkConfProcessor.a().G + "/vas/";
        if (!TextUtils.isEmpty(str2) && i3 != 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            sb5.append(i3);
            sb5.append("_");
            sb5.append(j3);
            sb5.append("_");
            sb5.append(j16);
            sb5.append("_");
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            sb5.append(str);
            sb5.append(".png");
            return sb5.toString();
        }
        return str2;
    }

    public static String e(String str, int i3, boolean z16) {
        String str2;
        if (!TextUtils.isEmpty(str) && i3 != 0) {
            if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion() && com.tencent.relation.common.config.toggle.c.f364713z.g(false)) {
                return str;
            }
            int lastIndexOf = str.lastIndexOf("/");
            String substring = str.substring(0, lastIndexOf + 1);
            if (substring.length() < 4) {
                return str;
            }
            String substring2 = substring.substring(substring.length() - 4, substring.length() - 3);
            String substring3 = substring.substring(substring.length() - 3, substring.length() - 2);
            if (substring2.equals(String.valueOf(i3)) && substring3.equals("_")) {
                return str;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(substring);
            sb5.append(i3);
            sb5.append("_");
            if (z16) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            sb5.append(str2);
            sb5.append(str.substring(lastIndexOf));
            String sb6 = sb5.toString();
            if (QLog.isColorLevel()) {
                QLog.d("appendVasUrl", 2, "originUrl:" + str + " appendUrl:" + sb6);
            }
            return sb6;
        }
        return str;
    }

    private void f(String str, com.tencent.mobileqq.mutualmark.info.c cVar, bc bcVar) {
        String str2;
        if (bcVar != null && !TextUtils.isEmpty(bcVar.f202599d)) {
            int l3 = ff.l((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), str, 0);
            if (TextUtils.isEmpty(cVar.f252102r)) {
                str2 = cVar.f252103s;
            } else {
                str2 = cVar.f252102r;
            }
            String e16 = e(str2, l3, true);
            cVar.f252102r = e16;
            if (TextUtils.isEmpty(e16) && l3 > 0) {
                cVar.f252102r = d(5L, l3, cVar.f252086b, true);
            }
            if (QLog.isColorLevel()) {
                QLog.d("RelationVipHelper", 2, "iconApngUrl:" + cVar.f252102r + " sub_level:" + cVar.f252093i + " level:" + cVar.f252086b);
            }
        }
    }

    public static String h(String str) {
        HashMap<String, String> hashMap;
        bc bcVar = (bc) am.s().x(P2VGlobalConfig.WATER_MARKER_WIDTH);
        if (bcVar != null && (hashMap = bcVar.f202598c) != null) {
            return hashMap.get(str);
        }
        return "";
    }

    public static f i() {
        if (f251974a == null) {
            synchronized (f.class) {
                if (f251974a == null) {
                    f251974a = new f();
                }
            }
        }
        return f251974a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Drawable drawable, k kVar) {
        if (drawable != null) {
            kVar.x(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(ImageView imageView, FastDynamicDrawable fastDynamicDrawable, ViewGroup.LayoutParams layoutParams) {
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(fastDynamicDrawable);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit l(final FastDynamicDrawable fastDynamicDrawable, Resources resources, final ImageView imageView, com.tencent.cachedrawable.dynamicdrawable.d dVar) {
        if (fastDynamicDrawable.getIntrinsicHeight() != 0 && fastDynamicDrawable.getIntrinsicWidth() != 0) {
            int f16 = BaseAIOUtils.f(16.0f, resources);
            int intrinsicWidth = (fastDynamicDrawable.getIntrinsicWidth() * f16) / fastDynamicDrawable.getIntrinsicHeight();
            final ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = f16;
            layoutParams.width = intrinsicWidth;
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(fastDynamicDrawable);
                imageView.setLayoutParams(layoutParams);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            } else {
                imageView.post(new Runnable() { // from class: com.tencent.mobileqq.mutualmark.alienation.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.k(imageView, fastDynamicDrawable, layoutParams);
                    }
                });
            }
        }
        return null;
    }

    public static void m(final Resources resources, final ImageView imageView, String str, final Drawable drawable) {
        if (VasNormalToggle.VAS_BUG_112519979_2.isEnable(true)) {
            final FastDynamicDrawable a16 = new a.C1005a().k(str).d(VasApngUtil.getCacheFilePath(str)).g(new a.c() { // from class: com.tencent.mobileqq.mutualmark.alienation.c
                @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
                public final void a(k kVar) {
                    f.j(drawable, kVar);
                }
            }).a();
            if (f251975b) {
                a16.c0(new b(imageView, a16, resources));
                return;
            } else {
                a16.c0(new Function1() { // from class: com.tencent.mobileqq.mutualmark.alienation.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit l3;
                        l3 = f.l(FastDynamicDrawable.this, resources, imageView, (com.tencent.cachedrawable.dynamicdrawable.d) obj);
                        return l3;
                    }
                });
                return;
            }
        }
        URLDrawable apngURLDrawable = VasApngUtil.getApngURLDrawable(str, VasApngUtil.VIP_APNG_TAGS, drawable, null, new a(resources, imageView));
        if (apngURLDrawable != null) {
            int f16 = BaseAIOUtils.f(16.0f, resources);
            int intrinsicWidth = (apngURLDrawable.getIntrinsicWidth() * f16) / apngURLDrawable.getIntrinsicHeight();
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = f16;
            layoutParams.width = intrinsicWidth;
            imageView.setImageDrawable(apngURLDrawable);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    public void g(String str, com.tencent.mobileqq.mutualmark.info.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) cVar);
            return;
        }
        if (cVar != null && !TextUtils.isEmpty(str)) {
            bc bcVar = (bc) am.s().x(P2VGlobalConfig.WATER_MARKER_WIDTH);
            int i3 = (int) cVar.f252085a;
            if (i3 != 1) {
                String str2 = "svip";
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 5) {
                            if (i3 != 12) {
                                if (i3 != 26) {
                                    if (i3 != 19) {
                                        if (i3 == 20) {
                                            long j3 = cVar.f252086b;
                                            if (j3 == 1) {
                                                cVar.f252102r = "https://cmshow.qq.com/xydata/cmshow/devAct/7/24f5b4859404c4de52aa329d4d05ee5d.png";
                                                return;
                                            } else if (j3 == 2) {
                                                cVar.f252102r = "https://cmshow.qq.com/xydata/cmshow/devAct/7/16baf9bdf1b7a672001939b447e5f3c9.png";
                                                return;
                                            } else {
                                                if (j3 == 3) {
                                                    cVar.f252102r = "https://cmshow.qq.com/xydata/cmshow/devAct/7/c4e28479a1f47ff9e3104cf3e96c2430.png";
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    int l3 = ff.l((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), str, 5);
                                    if (l3 == 1 && cVar.f252086b == 1) {
                                        cVar.f252102r = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_MENTORSHIP_SVIP_APNG_URL, QzoneConfig.SECONDARY_MENTORSHIP_SVIP_APNG_URL_DEFAULT);
                                        return;
                                    }
                                    if (l3 == 2 && cVar.f252086b == 1) {
                                        cVar.f252102r = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_MENTORSHIP_APNG_URL, QzoneConfig.SECONDARY_MENTORSHIP_APNG_URL_DEFAULT);
                                        return;
                                    }
                                    if (l3 == 3 && cVar.f252086b == 1) {
                                        cVar.f252102r = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_MENTORSHIP_YELLOWVIP_APNG_URL, QzoneConfig.SECONDARY_MENTORSHIP_YELLOWVIP_APNG_URL_DEFAULT);
                                        return;
                                    } else {
                                        if (l3 == 4 && cVar.f252086b == 1) {
                                            cVar.f252102r = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_MENTORSHIP_NEWYEAR_APNG_URL, QzoneConfig.SECONDARY_MENTORSHIP_NEWYEAR_APNG_URL_DEFAULT);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (bcVar != null) {
                                    TextUtils.isEmpty(bcVar.f202599d);
                                    return;
                                }
                                return;
                            }
                            if (bcVar != null && !TextUtils.isEmpty(bcVar.f202599d)) {
                                int l16 = ff.l((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), str, 1);
                                long j16 = cVar.f252086b;
                                if (j16 == 1) {
                                    if (l16 == 2) {
                                        String replace = bcVar.f202599d.replace("{type}", "smallship");
                                        cVar.f252102r = replace;
                                        cVar.f252102r = replace.replace("{vip}", "union_vip");
                                        return;
                                    } else {
                                        if (l16 == 1) {
                                            String replace2 = bcVar.f202599d.replace("{type}", "smallship");
                                            cVar.f252102r = replace2;
                                            cVar.f252102r = replace2.replace("{vip}", "svip");
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (j16 == 2) {
                                    if (l16 == 2) {
                                        String replace3 = bcVar.f202599d.replace("{type}", "bigship");
                                        cVar.f252102r = replace3;
                                        cVar.f252102r = replace3.replace("{vip}", "union_vip");
                                        return;
                                    } else {
                                        if (l16 == 1) {
                                            String replace4 = bcVar.f202599d.replace("{type}", "bigship");
                                            cVar.f252102r = replace4;
                                            cVar.f252102r = replace4.replace("{vip}", "svip");
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        f(str, cVar, bcVar);
                        return;
                    }
                    if (bcVar != null && !TextUtils.isEmpty(bcVar.f202599d)) {
                        int l17 = ff.l((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), str, 4);
                        long j17 = cVar.f252086b;
                        if (j17 == 0 && l17 > 0) {
                            String replace5 = bcVar.f202599d.replace("{type}", "brother1");
                            cVar.f252102r = replace5;
                            if (l17 != 1) {
                                str2 = "union_vip";
                            }
                            cVar.f252102r = replace5.replace("{vip}", str2);
                            return;
                        }
                        if (j17 == 1 && l17 > 0) {
                            String replace6 = bcVar.f202599d.replace("{type}", "brother2");
                            cVar.f252102r = replace6;
                            if (l17 != 1) {
                                str2 = "union_vip";
                            }
                            cVar.f252102r = replace6.replace("{vip}", str2);
                            return;
                        }
                        if (j17 == 2 && l17 > 0) {
                            String replace7 = bcVar.f202599d.replace("{type}", "brother3");
                            cVar.f252102r = replace7;
                            if (l17 != 1) {
                                str2 = "union_vip";
                            }
                            cVar.f252102r = replace7.replace("{vip}", str2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (bcVar != null && !TextUtils.isEmpty(bcVar.f202599d)) {
                    int l18 = ff.l((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), str, 3);
                    long j18 = cVar.f252086b;
                    if (j18 == 0 && l18 > 0) {
                        String replace8 = bcVar.f202599d.replace("{type}", "sister1");
                        cVar.f252102r = replace8;
                        if (l18 != 1) {
                            str2 = "union_vip";
                        }
                        cVar.f252102r = replace8.replace("{vip}", str2);
                        return;
                    }
                    if (j18 == 1 && l18 > 0) {
                        String replace9 = bcVar.f202599d.replace("{type}", "sister2");
                        cVar.f252102r = replace9;
                        if (l18 != 1) {
                            str2 = "union_vip";
                        }
                        cVar.f252102r = replace9.replace("{vip}", str2);
                        return;
                    }
                    if (j18 == 2 && l18 > 0) {
                        String replace10 = bcVar.f202599d.replace("{type}", "sister3");
                        cVar.f252102r = replace10;
                        if (l18 != 1) {
                            str2 = "union_vip";
                        }
                        cVar.f252102r = replace10.replace("{vip}", str2);
                        return;
                    }
                    return;
                }
                return;
            }
            if (bcVar != null && !TextUtils.isEmpty(bcVar.f202599d)) {
                int l19 = ff.l((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), str, 2);
                long j19 = cVar.f252086b;
                if (j19 == 0 && l19 > 0) {
                    String replace11 = bcVar.f202599d.replace("{type}", "lover1");
                    cVar.f252102r = replace11;
                    cVar.f252102r = replace11.replace("{vip}", "vip");
                } else if (j19 == 1 && l19 > 0) {
                    String replace12 = bcVar.f202599d.replace("{type}", "lover2");
                    cVar.f252102r = replace12;
                    cVar.f252102r = replace12.replace("{vip}", "vip");
                } else if (j19 == 2 && l19 > 0) {
                    String replace13 = bcVar.f202599d.replace("{type}", "lover3");
                    cVar.f252102r = replace13;
                    cVar.f252102r = replace13.replace("{vip}", "vip");
                }
            }
        }
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        bc bcVar = (bc) am.s().x(P2VGlobalConfig.WATER_MARKER_WIDTH);
        if (bcVar != null && bcVar.f202597b != 0) {
            return true;
        }
        return false;
    }
}
