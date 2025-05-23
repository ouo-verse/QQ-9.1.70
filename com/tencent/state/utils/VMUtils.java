package com.tencent.state.utils;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J/\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b\u00a2\u0006\u0002\u0010\fJ7\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/utils/VMUtils;", "", "()V", "TAG", "", "safelyGet", "T", "Landroidx/lifecycle/ViewModel;", "fragment", "Landroidx/fragment/app/Fragment;", "clazz", "Ljava/lang/Class;", "(Landroidx/fragment/app/Fragment;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "(Landroidx/fragment/app/Fragment;Ljava/lang/Class;Ljava/lang/String;)Landroidx/lifecycle/ViewModel;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VMUtils {
    public static final VMUtils INSTANCE = new VMUtils();
    private static final String TAG = "VMUtils";

    VMUtils() {
    }

    public final <T extends ViewModel> T safelyGet(Fragment fragment, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (fragment != null && !fragment.isDetached() && fragment.getContext() != null) {
            try {
                return (T) new ViewModelProvider(fragment).get(clazz);
            } catch (Throwable th5) {
                SquareBaseKt.getSquareLog().e(TAG, "safelyGet err.", th5);
            }
        }
        return null;
    }

    public final <T extends ViewModel> T safelyGet(Fragment fragment, Class<T> clazz, String key) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(key, "key");
        if (fragment != null && !fragment.isDetached() && fragment.getContext() != null) {
            try {
                return (T) new ViewModelProvider(fragment).get(clazz.getCanonicalName() + ":" + key, clazz);
            } catch (Throwable th5) {
                SquareBaseKt.getSquareLog().e(TAG, "safelyGet err.", th5);
            }
        }
        return null;
    }
}
