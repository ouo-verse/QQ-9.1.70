package com.tencent.mobileqq.qqecommerce.base.device;

import af2.b;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.device.api.IECDeviceInfo;
import com.tencent.luggage.wxa.yf.e;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/device/ECDeviceManager;", "Lcom/tencent/ecommerce/base/device/api/IECDeviceInfo;", "Landroid/content/Context;", "context", "", "checkDeviceHasNavigationBar", "", "getNavigationBarHeight", "Landroid/util/DisplayMetrics;", "getSystemDisplayMetrics", "getAppDisplayMetrics", "", "getAppFontScale", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", e.NAME, "Landroid/view/View;", "view", "resetViewSize2Normal", "a", "Lkotlin/Lazy;", "()Landroid/util/DisplayMetrics;", "customDisplayMetrics", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECDeviceManager implements IECDeviceInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy customDisplayMetrics;

    public ECDeviceManager() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DisplayMetrics>() { // from class: com.tencent.mobileqq.qqecommerce.base.device.ECDeviceManager$customDisplayMetrics$2
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
        this.customDisplayMetrics = lazy;
    }

    private final DisplayMetrics a() {
        return (DisplayMetrics) this.customDisplayMetrics.getValue();
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public boolean checkDeviceHasNavigationBar(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ScreenUtil.checkDeviceHasNavigationBar(context);
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public DisplayMetrics getAppDisplayMetrics() {
        return a();
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public float getAppFontScale() {
        return FontSettingManager.getFontScale();
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public int getNavigationBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ScreenUtil.getNavigationBarHeight(context);
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public DisplayMetrics getSystemDisplayMetrics() {
        DisplayMetrics systemMetrics = FontSettingManager.systemMetrics;
        Intrinsics.checkNotNullExpressionValue(systemMetrics, "systemMetrics");
        return systemMetrics;
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public void hideNavigationBar(Context activity) {
        Window window;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity a16 = b.f25996a.a(activity);
        View decorView = (a16 == null || (window = a16.getWindow()) == null) ? null : window.getDecorView();
        if (decorView == null) {
            return;
        }
        decorView.setSystemUiVisibility(7942);
    }

    @Override // com.tencent.ecommerce.base.device.api.IECDeviceInfo
    public void resetViewSize2Normal(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        FontSettingManager.resetViewSize2Normal(context, view);
    }
}
