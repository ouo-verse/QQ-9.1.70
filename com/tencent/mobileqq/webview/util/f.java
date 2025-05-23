package com.tencent.mobileqq.webview.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.HalfScreenBrowserFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.HalfScreenBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002JM\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010\u0017\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\u001a\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rJ\u001e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\r\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/webview/util/f;", "", "Landroid/os/Bundle;", "bundle", "", "heightRatio", "", "bgColorId", "webViewBgRes", "", "e", "Landroid/content/Context;", "context", "", "url", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/activity/QQBrowserActivity;", "targetActivityClass", "launchFlag", "Landroid/content/Intent;", "f", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Integer;F)Landroid/content/Intent;", "k", "a", "j", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "g", "b", "filterDevice", "d", "businessId", "c", tl.h.F, "deviceString", "", "i", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f314875a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46177);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f314875a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(Bundle bundle, float heightRatio, int bgColorId, int webViewBgRes) {
        if (!bundle.containsKey("halfFragmentClass")) {
            bundle.putSerializable("halfFragmentClass", HalfScreenBrowserFragment.class);
        }
        bundle.putBoolean("isTransparentTitle", true);
        bundle.putInt("webViewBgRes", webViewBgRes);
        bundle.putFloat("webViewHeightRatio", heightRatio);
        bundle.putInt("backgroundColorId", bgColorId);
    }

    private final Intent f(Context context, String url, Bundle bundle, Class<? extends QQBrowserActivity> targetActivityClass, Integer launchFlag, float heightRatio) {
        Object obj;
        Object obj2;
        Object obj3;
        float f16;
        Intent intent = new Intent(context, targetActivityClass);
        String j3 = j(url, heightRatio);
        intent.putExtra("url", j3);
        intent.putExtra("key_url_source", "QZoneHalf");
        Object obj4 = null;
        if (bundle != null) {
            obj = bundle.get("webViewUrlBeforeClose");
        } else {
            obj = null;
        }
        if (obj != null && !TextUtils.isEmpty(String.valueOf(bundle.get("webViewUrlBeforeClose")))) {
            intent.putExtra("webViewUrlBeforeClose", String.valueOf(bundle.get("webViewUrlBeforeClose")));
        }
        if (bundle != null) {
            obj4 = bundle.get("webViewRatioBeforeClose");
        }
        if (obj4 != null) {
            boolean z16 = true;
            try {
                f16 = bundle.getFloat("webViewRatioBeforeClose");
            } catch (Exception e16) {
                QLog.e("HalfScreenBrowserUtil", 1, "parse close float exception is " + e16);
                f16 = 0.0f;
            }
            if (f16 != 0.0f) {
                z16 = false;
            }
            if (!z16) {
                intent.putExtra("webViewRatioBeforeClose", f16);
            }
        }
        if (bundle == null || (obj2 = bundle.get("webViewBgColor")) == null) {
            obj2 = "";
        }
        intent.putExtra("webViewBgColor", obj2.toString());
        if (bundle == null || (obj3 = bundle.get("isNeedCloseBefore")) == null) {
            obj3 = "0";
        }
        intent.putExtra("isNeedCloseBefore", obj3.toString());
        intent.setData(Uri.parse(j3));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (launchFlag != null) {
            intent.setFlags(launchFlag.intValue());
        }
        return intent;
    }

    @NotNull
    public final Intent a(@NotNull Context context, @NotNull String url, @NotNull Bundle bundle, float heightRatio) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, this, context, url, bundle, Float.valueOf(heightRatio));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!bundle.containsKey("halfFragmentClass")) {
            bundle.putSerializable("halfFragmentClass", HalfScreenBrowserFragment.class);
        }
        e(bundle, heightRatio, R.color.by, R.drawable.jsk);
        boolean z16 = context instanceof Activity;
        if (z16) {
            num = null;
        } else {
            num = 268435456;
        }
        Integer num2 = num;
        if (!z16) {
            context = BaseApplication.getContext();
        }
        Context launchContext = context;
        Intrinsics.checkNotNullExpressionValue(launchContext, "launchContext");
        return f(launchContext, url, bundle, HalfScreenBrowserActivity.class, num2, heightRatio);
    }

    @NotNull
    public final String b(float heightRatio, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, Float.valueOf(heightRatio), url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return "mqqapi://openhalfscreenweb/?height=" + heightRatio + "&url=" + URLEncoder.encode(url);
    }

    @NotNull
    public final String c(float heightRatio, @NotNull String url, int businessId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, Float.valueOf(heightRatio), url, Integer.valueOf(businessId));
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return "mqqapi://openhalfscreenweb/?height=" + heightRatio + "&url=" + URLEncoder.encode(url) + "&id=" + businessId;
    }

    @NotNull
    public final String d(float heightRatio, @NotNull String url, @NotNull String filterDevice) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, Float.valueOf(heightRatio), url, filterDevice);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filterDevice, "filterDevice");
        return "mqqapi://openhalfscreenweb/?height=" + heightRatio + "&url=" + URLEncoder.encode(url) + "&filterDevice=" + filterDevice;
    }

    @Nullable
    public final Class<? extends WebViewFragment> g(@Nullable Bundle bundle) {
        Class<? extends WebViewFragment> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
        }
        if (bundle != null && (cls = (Class) bundle.getSerializable("halfFragmentClass")) != null) {
            return cls;
        }
        return HalfScreenBrowserFragment.class;
    }

    public final int h(float heightRatio) {
        int a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, Float.valueOf(heightRatio))).intValue();
        }
        o oVar = o.f314876a;
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (oVar.e(context)) {
            BaseApplication context2 = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            a16 = oVar.a(context2);
        } else {
            BaseApplication context3 = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            a16 = oVar.a(context3) + ImmersiveUtils.getStatusBarHeight(BaseApplication.context);
        }
        QLog.i("HalfScreenBrowserFragment", 1, "realHeight is " + a16);
        return (int) (a16 * heightRatio);
    }

    public final boolean i(@NotNull String deviceString) {
        boolean z16;
        List<String> split$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) deviceString)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(deviceString, "deviceString");
        String modelName = DeviceInfoMonitor.getModel();
        String str = "M1852+MI 5C+R9sPlus+OPPO R9s Plus+15+DE106+VTR-AL00+V1813A" + deviceString;
        if (!TextUtils.isEmpty(str)) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{Marker.ANY_NON_NULL_MARKER}, false, 0, 6, (Object) null);
            if (!split$default.isEmpty()) {
                for (String str2 : split$default) {
                    Intrinsics.checkNotNullExpressionValue(modelName, "modelName");
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                    String upperCase = modelName.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                    Locale locale2 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                    String upperCase2 = str2.toUpperCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(locale)");
                    if (TextUtils.equals(upperCase, upperCase2)) {
                        z16 = true;
                        break;
                    }
                }
            }
        }
        z16 = false;
        QLog.i("HalfScreenBrowserUtil", 1, "filter is " + z16 + ", model name is " + modelName);
        return z16;
    }

    @NotNull
    public final String j(@NotNull String url, float heightRatio) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, url, Float.valueOf(heightRatio));
        }
        Intrinsics.checkNotNullParameter(url, "url");
        String str = "&halfheight=" + h(heightRatio);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            dimensionPixelSize += ImmersiveUtils.getStatusBarHeight(context);
        }
        String b16 = HtmlOffline.b(url, "_titleBarHeight=" + ((int) ((dimensionPixelSize - 0.5f) / context.getResources().getDisplayMetrics().density)));
        Intrinsics.checkNotNullExpressionValue(b16, "addParamToUrl(url, \"_titleBarHeight=$height\")");
        String str2 = b16 + "&_cwv=256&float=1" + str;
        if (QLog.isDevelopLevel()) {
            QLog.d("HalfScreenBrowserUtil", 4, "parseUrl url:" + str2);
        }
        return str2;
    }

    public final void k(@NotNull Context context, @NotNull String url, @NotNull Bundle bundle, float heightRatio) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, url, bundle, Float.valueOf(heightRatio));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        context.startActivity(a(context, url, bundle, heightRatio));
    }
}
