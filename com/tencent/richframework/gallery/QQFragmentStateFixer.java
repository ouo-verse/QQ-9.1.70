package com.tencent.richframework.gallery;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.biz.richframework.util.RFWDeviceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/richframework/gallery/QQFragmentStateFixer;", "", "", "checkCondition", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "fixBadParcelException", "canFixState", "Z", "<init>", "()V", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QQFragmentStateFixer {

    @NotNull
    public static final QQFragmentStateFixer INSTANCE = new QQFragmentStateFixer();
    private static final boolean canFixState = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("RFW_FIX_GALLERY_FRAGMENT_STATE", true);

    QQFragmentStateFixer() {
    }

    private final boolean checkCondition() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 != 28 && i3 != 29) {
            return false;
        }
        RFWDeviceUtil rFWDeviceUtil = RFWDeviceUtil.INSTANCE;
        if (!rFWDeviceUtil.isHuaWei() && !rFWDeviceUtil.isHonor()) {
            return false;
        }
        return canFixState;
    }

    public final void fixBadParcelException(@Nullable Context context, @Nullable Bundle bundle) {
        Set<String> keySet;
        Bundle bundle2;
        if (context != null && bundle != null) {
            try {
                if (checkCondition()) {
                    bundle.setClassLoader(context.getClass().getClassLoader());
                    Bundle bundle3 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                    if (bundle3 != null && (keySet = bundle3.keySet()) != null) {
                        Intrinsics.checkNotNullExpressionValue(keySet, "keySet()");
                        Iterator<T> it = keySet.iterator();
                        while (it.hasNext()) {
                            Object obj = bundle3.get((String) it.next());
                            if (obj instanceof Bundle) {
                                bundle2 = (Bundle) obj;
                            } else {
                                bundle2 = null;
                            }
                            if (bundle2 != null) {
                                bundle2.setClassLoader(context.getClass().getClassLoader());
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("QQFragmentStateFixer", 1, e16, new Object[0]);
            }
        }
    }
}
