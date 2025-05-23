package com.tencent.biz.richframework.part;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public final /* synthetic */ class a {
    @JvmDefault
    @Nullable
    public static Activity a(IPartFragmentHost iPartFragmentHost) {
        return iPartFragmentHost.getHostFragment().getActivity();
    }

    @JvmDefault
    @Nullable
    public static Context b(IPartFragmentHost iPartFragmentHost) {
        return iPartFragmentHost.getHostFragment().getContext();
    }

    @JvmDefault
    @Nullable
    public static LifecycleOwner c(IPartFragmentHost iPartFragmentHost) {
        return iPartFragmentHost.getHostFragment().getViewLifecycleOwner();
    }
}
