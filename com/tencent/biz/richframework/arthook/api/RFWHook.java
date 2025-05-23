package com.tencent.biz.richframework.arthook.api;

import androidx.annotation.Nullable;
import com.tencent.biz.richframework.arthook.api.callback.MethodHook;
import java.lang.reflect.Member;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWHook {
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    @Nullable
    public static MethodHook.Unhook hook(Member member, MethodHook methodHook, boolean z16) {
        return null;
    }

    @Nullable
    public static MethodHook.Unhook hook(Member member, MethodHook methodHook) {
        hook(member, methodHook, true);
        return null;
    }
}
