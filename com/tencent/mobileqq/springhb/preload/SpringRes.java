package com.tencent.mobileqq.springhb.preload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.core.content.ContextCompat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b(\b\u0086\b\u0018\u0000 A2\u00020\u0001:\u0002$)Bq\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0003\u00102\u001a\u00020\f\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b?\u0010@J\u001c\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J$\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u0004J,\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJL\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00122:\b\u0002\u0010\u001b\u001a4\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0014H\u0007J\u0006\u0010\u001d\u001a\u00020\u0018J\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018J\t\u0010 \u001a\u00020\u0007H\u00d6\u0001J\t\u0010!\u001a\u00020\fH\u00d6\u0001J\u0013\u0010#\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010(\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010+\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'R\u0019\u0010.\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010'R\u0017\u00102\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u00101R\u0019\u00105\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b3\u0010%\u001a\u0004\b4\u0010'R\u0019\u00108\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'R\u0019\u0010:\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b4\u0010%\u001a\u0004\b9\u0010'R\u0019\u0010<\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b;\u0010'R\u0019\u0010>\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b=\u0010'\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/springhb/preload/SpringRes;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/os/Bundle;", "bundle", "i", "", WadlProxyConsts.PARAM_FILENAME, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/springhb/preload/SpringRes$b;", "downloadCallback", "", "defaultResId", "width", "height", "Landroid/graphics/Bitmap;", tl.h.F, "Landroid/content/Context;", "context", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "res", "", "success", "", "callback", "d", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "toString", "hashCode", "other", "equals", "a", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "url", "b", "getKey", "key", "c", "getContentMd5", "contentMd5", "I", "getDrawableId", "()I", "drawableId", "e", "g", "assetPath", "f", "l", "preloadPath", "k", "fallbackPath", "getZipUrl", "zipUrl", "o", "zipFolderPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "j", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class SpringRes {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final Lazy<Drawable> f289484k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String key;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String contentMd5;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int drawableId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String assetPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String preloadPath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String fallbackPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String zipUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String zipFolderPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/springhb/preload/SpringRes$a;", "", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "transparentDrawable$delegate", "Lkotlin/Lazy;", "b", "()Landroid/graphics/drawable/Drawable;", "transparentDrawable", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.preload.SpringRes$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Drawable b() {
            return (Drawable) SpringRes.f289484k.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/springhb/preload/SpringRes$b;", "", "", "suc", "", "url", "result", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
        void a(boolean suc, @Nullable String url, @Nullable Object result);
    }

    static {
        Lazy<Drawable> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61205);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(SpringRes$Companion$transparentDrawable$2.INSTANCE);
        f289484k = lazy;
    }

    public SpringRes() {
        this(null, null, null, 0, null, null, null, null, null, 511, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) {
            return;
        }
        iPatchRedirector.redirect((short) 33, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Context context, final SpringRes this$0, final Function2 function2) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final boolean b16 = r.f289531a.b(context, this$0);
        QLog.d("SpringRes", 1, "copyAsset: res, " + this$0 + "; success: " + b16);
        if (function2 != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.springhb.preload.m
                @Override // java.lang.Runnable
                public final void run() {
                    SpringRes.f(Function2.this, this$0, b16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function2 it, SpringRes this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.invoke(this$0, Boolean.valueOf(z16));
    }

    public static /* synthetic */ Drawable j(SpringRes springRes, Drawable drawable, Bundle bundle, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            drawable = INSTANCE.b();
        }
        if ((i3 & 2) != 0) {
            bundle = new Bundle();
        }
        return springRes.i(drawable, bundle);
    }

    @MainThread
    public final void d(@NotNull final Context context, @Nullable final Function2<? super SpringRes, ? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) context, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (p()) {
            if (callback != null) {
                callback.invoke(this, Boolean.TRUE);
            }
            QLog.d("SpringRes", 1, "copyAsset: file exists " + this.fallbackPath);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.preload.l
            @Override // java.lang.Runnable
            public final void run() {
                SpringRes.e(context, this, callback);
            }
        }, 64, null, false);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpringRes)) {
            return false;
        }
        SpringRes springRes = (SpringRes) other;
        if (Intrinsics.areEqual(this.url, springRes.url) && Intrinsics.areEqual(this.key, springRes.key) && Intrinsics.areEqual(this.contentMd5, springRes.contentMd5) && this.drawableId == springRes.drawableId && Intrinsics.areEqual(this.assetPath, springRes.assetPath) && Intrinsics.areEqual(this.preloadPath, springRes.preloadPath) && Intrinsics.areEqual(this.fallbackPath, springRes.fallbackPath) && Intrinsics.areEqual(this.zipUrl, springRes.zipUrl) && Intrinsics.areEqual(this.zipFolderPath, springRes.zipFolderPath)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.assetPath;
    }

    @Nullable
    public final Bitmap h(@Nullable b downloadCallback, @DrawableRes int defaultResId, int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Bitmap) iPatchRedirector.redirect((short) 15, this, downloadCallback, Integer.valueOf(defaultResId), Integer.valueOf(width), Integer.valueOf(height));
        }
        String str = this.preloadPath;
        if (str == null || str.length() == 0) {
            z16 = true;
        }
        if (!z16 && new File(this.preloadPath).exists()) {
            return p.h(this.preloadPath, -1, width, height, true);
        }
        String str2 = this.url;
        int i3 = this.drawableId;
        if (i3 > 0) {
            defaultResId = i3;
        }
        return p.f(str2, defaultResId, downloadCallback, width, height);
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        String str = this.url;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.key;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.contentMd5;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (((i17 + hashCode3) * 31) + this.drawableId) * 31;
        String str4 = this.assetPath;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.preloadPath;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str6 = this.fallbackPath;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str7 = this.zipUrl;
        if (str7 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str7.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        String str8 = this.zipFolderPath;
        if (str8 != null) {
            i3 = str8.hashCode();
        }
        return i28 + i3;
    }

    @NotNull
    public final Drawable i(@Nullable Drawable drawable, @NotNull Bundle bundle) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Drawable) iPatchRedirector.redirect((short) 13, (Object) this, (Object) drawable, (Object) bundle);
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (drawable == null) {
            drawable = INSTANCE.b();
        }
        String str = this.fallbackPath;
        boolean z18 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.d("SpringRes", 1, "getDrawable: use from asset, key:" + this.key + ", url:" + this.url);
            drawable = QWalletPicHelper.getDrawableForQWallet(this.fallbackPath, drawable, bundle);
        } else if (this.drawableId != 0) {
            QLog.d("SpringRes", 1, "getDrawable: use from drawable id, key:" + this.key + ", url:" + this.url);
            Drawable drawable2 = ContextCompat.getDrawable(BaseApplicationImpl.getApplication(), this.drawableId);
            if (drawable2 != null) {
                drawable = drawable2;
            }
        } else {
            QLog.d("SpringRes", 1, "getDrawable: use fallback drawable, key:" + this.key + ", url:" + this.url);
        }
        String str2 = this.preloadPath;
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17 && new File(this.preloadPath).exists()) {
            QLog.d("SpringRes", 1, "getDrawable: load in preloadPath, key:" + this.key + ", url:" + this.url);
            URLDrawable drawableForQWallet = QWalletPicHelper.getDrawableForQWallet(this.preloadPath, drawable, bundle);
            Intrinsics.checkNotNullExpressionValue(drawableForQWallet, "{\n            QLog.d(TAG\u2026awable, bundle)\n        }");
            return drawableForQWallet;
        }
        String str3 = this.url;
        if (str3 == null || str3.length() == 0) {
            z18 = true;
        }
        if (!z18) {
            QLog.d("SpringRes", 1, "getDrawable: load from remote url, key:" + this.key + ", url:" + this.url);
            URLDrawable netDrawableForQWallet = QWalletPicHelper.getNetDrawableForQWallet(this.url, drawable, drawable, bundle);
            Intrinsics.checkNotNullExpressionValue(netDrawableForQWallet, "{\n            QLog.d(TAG\u2026awable, bundle)\n        }");
            return netDrawableForQWallet;
        }
        QLog.d("SpringRes", 1, "getDrawable: use from defaultDrawable, key:" + this.key + ", url:" + this.url);
        Intrinsics.checkNotNullExpressionValue(drawable, "{\n            QLog.d(TAG\u2026defaultDrawable\n        }");
        return drawable;
    }

    @Nullable
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.fallbackPath;
    }

    @Nullable
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.preloadPath;
    }

    @Nullable
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.url;
    }

    @NotNull
    public final Drawable n(@Nullable Drawable drawable, @NotNull String fileName, @NotNull Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Drawable) iPatchRedirector.redirect((short) 14, this, drawable, fileName, bundle);
        }
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (drawable == null) {
            drawable = INSTANCE.b();
        }
        String str = this.zipFolderPath + File.separator + fileName;
        String str2 = this.zipFolderPath;
        boolean z17 = false;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (str.length() > 0) {
                z17 = true;
            }
            if (z17 && new File(str).exists()) {
                QLog.d("SpringRes", 1, "getDrawable: load in preloadPath, key:" + this.key + ", url:" + this.url);
                URLDrawable drawableForQWallet = QWalletPicHelper.getDrawableForQWallet(str, drawable, bundle);
                Intrinsics.checkNotNullExpressionValue(drawableForQWallet, "{\n            QLog.d(TAG\u2026awable, bundle)\n        }");
                return drawableForQWallet;
            }
        }
        QLog.d("SpringRes", 1, "getDrawable: use from defaultDrawable, key:" + this.key + ", url:" + this.url);
        Intrinsics.checkNotNullExpressionValue(drawable, "{\n            QLog.d(TAG\u2026loadingDrawable\n        }");
        return drawable;
    }

    @Nullable
    public final String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.zipFolderPath;
    }

    public final boolean p() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        String str = this.fallbackPath;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return new File(str).exists();
    }

    public final boolean q() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        String str = this.preloadPath;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return new File(str).exists();
    }

    public final boolean r() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        String str = this.zipFolderPath;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return new File(str).exists();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return "SpringRes(url=" + this.url + ", key=" + this.key + ", contentMd5=" + this.contentMd5 + ", drawableId=" + this.drawableId + ", assetPath=" + this.assetPath + ", preloadPath=" + this.preloadPath + ", fallbackPath=" + this.fallbackPath + ", zipUrl=" + this.zipUrl + ", zipFolderPath=" + this.zipFolderPath + ")";
    }

    public SpringRes(@Nullable String str, @Nullable String str2, @Nullable String str3, @DrawableRes int i3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, Integer.valueOf(i3), str4, str5, str6, str7, str8);
            return;
        }
        this.url = str;
        this.key = str2;
        this.contentMd5 = str3;
        this.drawableId = i3;
        this.assetPath = str4;
        this.preloadPath = str5;
        this.fallbackPath = str6;
        this.zipUrl = str7;
        this.zipFolderPath = str8;
    }

    public /* synthetic */ SpringRes(String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7, String str8, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? null : str2, (i16 & 4) != 0 ? null : str3, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? null : str4, (i16 & 32) != 0 ? null : str5, (i16 & 64) != 0 ? null : str6, (i16 & 128) != 0 ? null : str7, (i16 & 256) != 0 ? null : str8);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, Integer.valueOf(i3), str4, str5, str6, str7, str8, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
