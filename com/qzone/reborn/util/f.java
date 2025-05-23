package com.qzone.reborn.util;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QZoneConfigHelper;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/util/f;", "", "", "a", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f59544a = new f();

    f() {
    }

    private final boolean a() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 == 29 || i3 == 28) {
            return QZoneConfigHelper.o();
        }
        return false;
    }

    public final void b(Context context, Bundle bundle) {
        Set<String> keySet;
        if (context == null || bundle == null) {
            return;
        }
        try {
            if (a()) {
                bundle.setClassLoader(context.getClass().getClassLoader());
                Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                if (bundle2 == null || (keySet = bundle2.keySet()) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(keySet, "keySet()");
                Iterator<T> it = keySet.iterator();
                while (it.hasNext()) {
                    Object obj = bundle2.get((String) it.next());
                    Bundle bundle3 = obj instanceof Bundle ? (Bundle) obj : null;
                    if (bundle3 != null) {
                        bundle3.setClassLoader(context.getClass().getClassLoader());
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("QZoneFragmentStateFixer", 1, e16, new Object[0]);
        }
    }
}
