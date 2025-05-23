package com.tencent.ecommerce.base.device;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.device.api.IECDeviceInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\b\u0010\n\u001a\u0004\u0018\u00010\bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/device/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isReturnRealHeight", "", "c", "Landroid/util/DisplayMetrics;", "e", "a", "", "b", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "", "f", "Lcom/tencent/ecommerce/base/device/api/IECDeviceInfo;", "Lcom/tencent/ecommerce/base/device/api/IECDeviceInfo;", "deviceInfoProxy", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f100685b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static IECDeviceInfo deviceInfoProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getDeviceInfo();

    a() {
    }

    public final DisplayMetrics a() {
        IECDeviceInfo iECDeviceInfo = deviceInfoProxy;
        if (iECDeviceInfo != null) {
            return iECDeviceInfo.getAppDisplayMetrics();
        }
        return null;
    }

    public final float b() {
        IECDeviceInfo iECDeviceInfo = deviceInfoProxy;
        if (iECDeviceInfo != null) {
            return iECDeviceInfo.getAppFontScale();
        }
        return 1.0f;
    }

    public final int c(Activity activity, boolean isReturnRealHeight) {
        Resources resources = activity.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
        if (!isReturnRealHeight) {
            return dimensionPixelSize;
        }
        try {
            float f16 = Resources.getSystem().getDisplayMetrics().density / e().density;
            float f17 = dimensionPixelSize;
            if (f16 <= 0) {
                f16 = 1.0f;
            }
            return (int) Math.ceil(f17 * f16);
        } catch (Exception e16) {
            cg0.a.a("ECDeviceInfo", "getNavigationBarHeight", "getNavigationBarHeight error:" + e16.getMessage());
            return dimensionPixelSize;
        }
    }

    public final DisplayMetrics e() {
        DisplayMetrics systemDisplayMetrics;
        IECDeviceInfo iECDeviceInfo = deviceInfoProxy;
        return (iECDeviceInfo == null || (systemDisplayMetrics = iECDeviceInfo.getSystemDisplayMetrics()) == null) ? Resources.getSystem().getDisplayMetrics() : systemDisplayMetrics;
    }

    public final void f(Context context, View view) {
        IECDeviceInfo iECDeviceInfo = deviceInfoProxy;
        if (iECDeviceInfo != null) {
            iECDeviceInfo.resetViewSize2Normal(context, view);
        }
    }

    public static /* synthetic */ int d(a aVar, Activity activity, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return aVar.c(activity, z16);
    }
}
