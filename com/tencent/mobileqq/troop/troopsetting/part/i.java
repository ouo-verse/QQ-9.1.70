package com.tencent.mobileqq.troop.troopsetting.part;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.part.Part;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/biz/richframework/part/Part;", "Landroidx/lifecycle/LifecycleOwner;", "a", "(Lcom/tencent/biz/richframework/part/Part;)Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class i {
    @Nullable
    public static final LifecycleOwner a(@NotNull Part part) {
        Fragment fragment;
        Intrinsics.checkNotNullParameter(part, "<this>");
        try {
            Object partHost = part.getPartHost();
            if (partHost instanceof Fragment) {
                fragment = (Fragment) partHost;
            } else {
                fragment = null;
            }
            if (fragment == null) {
                return null;
            }
            return fragment.getViewLifecycleOwner();
        } catch (IllegalStateException unused) {
            return null;
        }
    }
}
