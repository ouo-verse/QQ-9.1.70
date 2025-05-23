package com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/adapter/QQKuiklyFontAdapter;", "Ld01/f;", "", "fontFamily", "Landroid/graphics/Typeface;", "d", tl.h.F, "g", "Lkotlin/Function1;", "", "result", "a", "", "fontSize", "b", "", "useHostDisplayMetrics", "Landroid/util/DisplayMetrics;", "c", "(Ljava/lang/Boolean;)Landroid/util/DisplayMetrics;", "", "[Ljava/lang/String;", "FONT_EXTENSIONS", "", "Ljava/util/Map;", "mFontCache", "Lkotlin/Lazy;", "e", "()Landroid/util/DisplayMetrics;", "customDisplayMetrics", "f", "hostDisplayMetrics", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyFontAdapter implements d01.f {

    /* renamed from: a, reason: collision with root package name */
    public static final QQKuiklyFontAdapter f262766a = new QQKuiklyFontAdapter();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String[] FONT_EXTENSIONS = {".ttf", ".otf"};

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Typeface> mFontCache = new HashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy customDisplayMetrics;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Lazy hostDisplayMetrics;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DisplayMetrics>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.QQKuiklyFontAdapter$customDisplayMetrics$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DisplayMetrics invoke() {
                if (!Intrinsics.areEqual(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102200", "1"), "1")) {
                    return null;
                }
                Configuration configuration = new Configuration();
                configuration.setTo(Resources.getSystem().getConfiguration());
                configuration.fontScale = 1.0f;
                Resources resources = BaseApplicationImpl.getApplication().createConfigurationContext(configuration).getResources();
                if (resources != null) {
                    return resources.getDisplayMetrics();
                }
                return null;
            }
        });
        customDisplayMetrics = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<DisplayMetrics>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.QQKuiklyFontAdapter$hostDisplayMetrics$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DisplayMetrics invoke() {
                Configuration configuration = new Configuration();
                configuration.setTo(BaseApplicationImpl.getApplication().getResources().getConfiguration());
                configuration.fontScale = 1.0f;
                Resources resources = BaseApplicationImpl.getApplication().createConfigurationContext(configuration).getResources();
                DisplayMetrics displayMetrics = resources != null ? resources.getDisplayMetrics() : null;
                if (displayMetrics != null) {
                    DisplayMetrics displayMetrics2 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
                    displayMetrics.density = (displayMetrics2 != null ? displayMetrics2.density : 0.0f) / FontSettingManager.getFontScale();
                }
                if (displayMetrics != null) {
                    DisplayMetrics displayMetrics3 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
                    displayMetrics.scaledDensity = (displayMetrics3 != null ? displayMetrics3.scaledDensity : 0.0f) / FontSettingManager.getFontScale();
                }
                return displayMetrics;
            }
        });
        hostDisplayMetrics = lazy2;
    }

    QQKuiklyFontAdapter() {
    }

    private final Typeface d(String fontFamily) {
        Typeface h16 = h(fontFamily);
        return h16 == null ? g(fontFamily) : h16;
    }

    private final DisplayMetrics e() {
        return (DisplayMetrics) customDisplayMetrics.getValue();
    }

    private final DisplayMetrics f() {
        return (DisplayMetrics) hostDisplayMetrics.getValue();
    }

    private final Typeface g(String fontFamily) {
        String[] list = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().getExternalApplicationContext().getAssets().list("fonts");
        if (list == null) {
            return null;
        }
        for (String str : list) {
            if (str.equals(fontFamily + ".ttf")) {
                QLog.i("QQKuiklyFontAdapter", 1, "useEcommerceFont name:" + str);
                return Typeface.createFromAsset(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().getExternalApplicationContext().getAssets(), "fonts/" + fontFamily + ".ttf");
            }
        }
        return null;
    }

    private final Typeface h(String fontFamily) {
        String hippyFontRootDir = HippyUtils.getHippyFontRootDir();
        for (String str : FONT_EXTENSIONS) {
            String str2 = hippyFontRootDir + fontFamily + str;
            File file = new File(str2);
            if (file.exists()) {
                QLog.i("QQKuiklyFontAdapter", 1, "useQQFontFile file:" + file);
                return Typeface.createFromFile(str2);
            }
        }
        return null;
    }

    @Override // d01.f
    public void a(String fontFamily, Function1<? super Typeface, Unit> result) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            if (fontFamily.length() == 0) {
                result.invoke(null);
                return;
            }
            Map<String, Typeface> map = mFontCache;
            if (map.containsKey(fontFamily) && map.get(fontFamily) != null) {
                result.invoke(map.get(fontFamily));
                return;
            }
            Typeface d16 = d(fontFamily);
            if (d16 != null) {
                map.put(fontFamily, d16);
            }
            result.invoke(d16);
        } catch (Exception e16) {
            QLog.e("QQKuiklyFontAdapter", 1, "getTypeface e:" + e16);
            result.invoke(null);
        }
    }

    @Override // d01.f
    public float b(float fontSize) {
        return fontSize * FontSettingManager.getFontScale();
    }

    @Override // d01.f
    public DisplayMetrics c(Boolean useHostDisplayMetrics) {
        if (Intrinsics.areEqual(useHostDisplayMetrics, Boolean.TRUE)) {
            return f();
        }
        return e();
    }
}
