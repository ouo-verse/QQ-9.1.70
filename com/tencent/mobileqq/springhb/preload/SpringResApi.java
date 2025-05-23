package com.tencent.mobileqq.springhb.preload;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.springhb.preload.g;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.paysdk.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0002H\u0007J$\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J$\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R#\u0010#\u001a\n \u001f*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/springhb/preload/SpringResApi;", "", "", "key", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/springhb/interf/b;", "i", "url", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "k", "Lcom/tencent/mobileqq/springhb/preload/res/a;", "l", "Lcom/tencent/mobileqq/qwallet/preload/IPreloadResource;", "preloadResConfig", "c", "preloadRes", "g", "Lcom/tencent/mobileqq/springhb/preload/SpringHbZipMappingBean;", "zipMappingBean", "f", "b", "", "e", "zipFolderPath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "zipResId", "", tl.h.F, "a", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "d", "()Landroid/graphics/drawable/Drawable;", "emptyDrawable", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpringResApi {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final SpringResApi f289494a;

    /* renamed from: b, reason: from kotlin metadata */
    @NotNull
    private static final Lazy emptyDrawable;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61214);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f289494a = new SpringResApi();
        lazy = LazyKt__LazyJVMKt.lazy(SpringResApi$emptyDrawable$2.INSTANCE);
        emptyDrawable = lazy;
    }

    SpringResApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.mobileqq.springhb.interf.b b(SpringHbZipMappingBean zipMappingBean, Drawable defaultDrawable, Bundle bundle) {
        boolean z16;
        String str;
        boolean isBlank;
        String str2 = zipMappingBean.zipResId;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            r rVar = r.f289531a;
            String str3 = zipMappingBean.zipResId;
            Intrinsics.checkNotNullExpressionValue(str3, "zipMappingBean.zipResId");
            IPreloadResource h16 = rVar.h(str3);
            if (h16 != null) {
                str = h16.getUrl();
            } else {
                str = null;
            }
            String str4 = "";
            if (str == null) {
                str = "";
            }
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (true ^ isBlank) {
                String p16 = com.tencent.mobileqq.qwallet.preload.a.p(str);
                if (p16 != null) {
                    str4 = p16;
                }
                String m3 = m(str4, zipMappingBean);
                if (FileUtil.INSTANCE.d(m3)) {
                    return new com.tencent.mobileqq.springhb.preload.res.b(m3, defaultDrawable, bundle);
                }
            }
        }
        return null;
    }

    private final com.tencent.mobileqq.springhb.interf.b c(IPreloadResource preloadResConfig, Drawable defaultDrawable, Bundle bundle) {
        String url = preloadResConfig.getUrl();
        String str = "";
        if (url == null && (url = g.INSTANCE.d().get(preloadResConfig.getResId())) == null) {
            url = "";
        }
        String g16 = com.tencent.mobileqq.qwallet.preload.a.g(url, e());
        if (g16 != null) {
            str = g16;
        }
        if (FileUtil.INSTANCE.d(str)) {
            return new com.tencent.mobileqq.springhb.preload.res.b(str, defaultDrawable, bundle);
        }
        return null;
    }

    private final Drawable d() {
        return (Drawable) emptyDrawable.getValue();
    }

    private final int e() {
        return com.tencent.mobileqq.qwallet.preload.a.f278999a ? 1 : 0;
    }

    private final com.tencent.mobileqq.springhb.preload.res.a f(SpringHbZipMappingBean zipMappingBean) {
        boolean z16;
        String str;
        boolean isBlank;
        String str2 = zipMappingBean.zipResId;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            r rVar = r.f289531a;
            String str3 = zipMappingBean.zipResId;
            Intrinsics.checkNotNullExpressionValue(str3, "zipMappingBean.zipResId");
            IPreloadResource h16 = rVar.h(str3);
            if (h16 != null) {
                str = h16.getUrl();
            } else {
                str = null;
            }
            String str4 = "";
            if (str == null) {
                str = "";
            }
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (true ^ isBlank) {
                String p16 = com.tencent.mobileqq.qwallet.preload.a.p(str);
                if (p16 != null) {
                    str4 = p16;
                }
                String m3 = m(str4, zipMappingBean);
                if (FileUtil.INSTANCE.d(m3)) {
                    return new com.tencent.mobileqq.springhb.preload.res.a(m3);
                }
            }
        }
        return null;
    }

    private final com.tencent.mobileqq.springhb.preload.res.a g(IPreloadResource preloadRes) {
        String resId = preloadRes.getResId();
        String url = preloadRes.getUrl();
        String str = "";
        if (url == null && (url = g.INSTANCE.d().get(resId)) == null) {
            url = "";
        }
        String g16 = com.tencent.mobileqq.qwallet.preload.a.g(url, e());
        if (g16 != null) {
            str = g16;
        }
        if (FileUtil.INSTANCE.d(str)) {
            return new com.tencent.mobileqq.springhb.preload.res.a(str);
        }
        return null;
    }

    private final CharSequence h(String str) {
        int i3;
        CharSequence subSequence;
        if (str != null) {
            i3 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, ".zip", 0, false, 6, (Object) null);
        } else {
            i3 = -1;
        }
        if (i3 == -1 || str == null || (subSequence = str.subSequence(0, i3)) == null) {
            return "";
        }
        return subSequence;
    }

    @JvmStatic
    @NotNull
    public static final com.tencent.mobileqq.springhb.interf.b i(@NotNull String key, @NotNull Bundle bundle) {
        com.tencent.mobileqq.springhb.interf.b b16;
        com.tencent.mobileqq.springhb.interf.b c16;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringDrawableResByKey==start==" + key);
        SpringResApi springResApi = f289494a;
        Drawable a16 = springResApi.a(key, bundle);
        r rVar = r.f289531a;
        IPreloadResource h16 = rVar.h(key);
        if (h16 != null && (c16 = springResApi.c(h16, a16, bundle)) != null) {
            QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringDrawableResByKey==end==userSingleRes==" + key);
            return c16;
        }
        SpringHbZipMappingBean j3 = rVar.j(key);
        if (j3 != null && (b16 = springResApi.b(j3, a16, bundle)) != null) {
            QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringDrawableResByKey==end==userZipRes==" + key);
            return b16;
        }
        QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringDrawableResByKey==end==userLocalDefault==" + key);
        return new com.tencent.mobileqq.springhb.preload.res.b(null, a16, bundle, 1, null);
    }

    public static /* synthetic */ com.tencent.mobileqq.springhb.interf.b j(String str, Bundle bundle, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = new Bundle();
        }
        return i(str, bundle);
    }

    @JvmStatic
    @NotNull
    public static final com.tencent.mobileqq.springhb.interf.b k(@NotNull String url, @NotNull Drawable defaultDrawable, @NotNull Bundle bundle) {
        com.tencent.mobileqq.springhb.interf.b b16;
        com.tencent.mobileqq.springhb.interf.b c16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(defaultDrawable, "defaultDrawable");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringDrawableResByUrl==start==" + url);
        r rVar = r.f289531a;
        IPreloadResource i3 = rVar.i(url);
        if (i3 != null && (c16 = f289494a.c(i3, defaultDrawable, bundle)) != null) {
            QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringDrawableResByUrl==end==userSingleRes==" + url);
            return c16;
        }
        SpringHbZipMappingBean k3 = rVar.k(url);
        if (k3 != null && (b16 = f289494a.b(k3, defaultDrawable, bundle)) != null) {
            QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringDrawableResByUrl==end==userZipRes==" + url);
            return b16;
        }
        QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringDrawableResByUrl==end==userServiceRes==" + url);
        return new com.tencent.mobileqq.springhb.preload.res.c(url, defaultDrawable, bundle);
    }

    @JvmStatic
    @NotNull
    public static final com.tencent.mobileqq.springhb.preload.res.a l(@NotNull String url) {
        com.tencent.mobileqq.springhb.preload.res.a f16;
        com.tencent.mobileqq.springhb.preload.res.a g16;
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringFileResByUrl==start==" + url);
        r rVar = r.f289531a;
        IPreloadResource i3 = rVar.i(url);
        if (i3 != null && (g16 = f289494a.g(i3)) != null) {
            QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringFileResByUrl==end==userSingleRes==" + url);
            return g16;
        }
        SpringHbZipMappingBean k3 = rVar.k(url);
        if (k3 != null && (f16 = f289494a.f(k3)) != null) {
            QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringFileResByUrl==end==userZipRes==" + url);
            return f16;
        }
        QLog.d("SpringHb_Preload_SpringResApi", 2, "getSpringFileResByUrl==end==userEmptyFile==" + url);
        return new com.tencent.mobileqq.springhb.preload.res.a("");
    }

    private final String m(String str, SpringHbZipMappingBean springHbZipMappingBean) {
        String str2 = File.separator;
        String str3 = str + str2 + springHbZipMappingBean.resName;
        if (!FileUtils.fileExists(str3)) {
            CharSequence h16 = h(springHbZipMappingBean.zipResId);
            String str4 = str + str2 + ((Object) h16) + str2 + springHbZipMappingBean.resName;
            if (FileUtils.fileExists(str4)) {
                return str4;
            }
            return str3;
        }
        return str3;
    }

    @NotNull
    public final Drawable a(@NotNull String key, @NotNull Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) key, (Object) bundle);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        g.Companion companion = g.INSTANCE;
        Integer num = companion.b().get(key);
        boolean z16 = false;
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            Drawable drawable = ContextCompat.getDrawable(BaseApplicationImpl.getApplication(), i3);
            if (drawable == null) {
                Drawable emptyDrawable2 = d();
                Intrinsics.checkNotNullExpressionValue(emptyDrawable2, "emptyDrawable");
                return emptyDrawable2;
            }
            return drawable;
        }
        String str = companion.a().get(key);
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        }
        if (!z16) {
            str2 = r.f289531a.f() + str;
        }
        if (FileUtil.INSTANCE.d(str2)) {
            URLDrawable drawableForQWallet = QWalletPicHelper.getDrawableForQWallet(str2, d(), bundle);
            if (drawableForQWallet == null) {
                Drawable emptyDrawable3 = d();
                Intrinsics.checkNotNullExpressionValue(emptyDrawable3, "emptyDrawable");
                return emptyDrawable3;
            }
            return drawableForQWallet;
        }
        QLog.e("SpringHb_Preload_SpringResApi", 1, "key=" + key + " no corresponding back-up resource");
        Drawable emptyDrawable4 = d();
        Intrinsics.checkNotNullExpressionValue(emptyDrawable4, "emptyDrawable");
        return emptyDrawable4;
    }
}
