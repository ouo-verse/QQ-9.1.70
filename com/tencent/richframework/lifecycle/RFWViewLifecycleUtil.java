package com.tencent.richframework.lifecycle;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.fragment.app.Argus;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.RFWFragmentUtil;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.argus.node.ArgusNode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/lifecycle/RFWViewLifecycleUtil;", "", "Landroid/view/View;", "view", "", "extendBlock", "Landroidx/lifecycle/LifecycleOwner;", "getViewLifecycleOwner", "<init>", "()V", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWViewLifecycleUtil {

    @NotNull
    public static final RFWViewLifecycleUtil INSTANCE = new RFWViewLifecycleUtil();

    RFWViewLifecycleUtil() {
    }

    @JvmStatic
    @Nullable
    public static final LifecycleOwner getViewLifecycleOwner(@Nullable View view, boolean extendBlock) {
        LifecycleOwner lifecycleOwner;
        ArgusNode findViewBlockNode$default;
        if (view == null) {
            RFWLog.e("RFWViewLifecycleUtil", RFWLog.USR, "getViewLifecycleOwner but find view is empty");
            return null;
        }
        Fragment findViewFragment = RFWFragmentUtil.findViewFragment(view);
        if (findViewFragment != null) {
            try {
                lifecycleOwner = findViewFragment.getViewLifecycleOwner();
            } catch (IllegalStateException e16) {
                RFWLog.e("RFWViewLifecycleUtil", RFWLog.USR, "getViewLifecycleOwner error:" + e16);
                lifecycleOwner = null;
            }
            if (lifecycleOwner == null || !extendBlock || (findViewBlockNode$default = Argus.findViewBlockNode$default(Argus.INSTANCE, view, false, 2, null)) == null) {
                return lifecycleOwner;
            }
            return findViewBlockNode$default;
        }
        if (view.getContext() instanceof LifecycleOwner) {
            Object context = view.getContext();
            if (context != null) {
                return (LifecycleOwner) context;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        if (!(view.getContext() instanceof ContextWrapper)) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 != null) {
            Context baseContext = ((ContextWrapper) context2).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
            if (baseContext.getApplicationContext() == null || !(baseContext instanceof LifecycleOwner)) {
                return null;
            }
            return (LifecycleOwner) ((ContextWrapper) baseContext);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.content.ContextWrapper");
    }
}
