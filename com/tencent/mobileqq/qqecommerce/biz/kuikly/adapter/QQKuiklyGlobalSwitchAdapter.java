package com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter;

import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.config.QQKuiklyConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/adapter/QQKuiklyGlobalSwitchAdapter;", "Ld01/g;", "", "a", "Lkotlin/Lazy;", "b", "()Z", "enableReuseClassLoader", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyGlobalSwitchAdapter implements d01.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy enableReuseClassLoader;

    public QQKuiklyGlobalSwitchAdapter() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.QQKuiklyGlobalSwitchAdapter$enableReuseClassLoader$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(QQKuiklyConfigManager.f262835a.c());
            }
        });
        this.enableReuseClassLoader = lazy;
    }

    private final boolean b() {
        return ((Boolean) this.enableReuseClassLoader.getValue()).booleanValue();
    }

    @Override // d01.g
    public boolean a() {
        boolean equals;
        if (!b()) {
            return false;
        }
        if (Build.VERSION.SDK_INT == 26) {
            return true;
        }
        equals = StringsKt__StringsJVMKt.equals(Build.MANUFACTURER, CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU, true);
        if (!(equals && DeviceInfoMonitor.getModel().equals("15"))) {
            return false;
        }
        QLog.i("enableClassLoaderReuse", 1, "is meizu 15, enableClassLoaderReuse");
        return true;
    }
}
