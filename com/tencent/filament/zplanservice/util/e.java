package com.tencent.filament.zplanservice.util;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.util.ReflectionUtil;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplanservice/util/e;", "", "", PushClientConstants.TAG_CLASS_NAME, "fieldName", "a", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f106444a = new e();

    e() {
    }

    @Nullable
    public final Object a(@NotNull String className, @NotNull String fieldName) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        if (TextUtils.isEmpty(className) || TextUtils.isEmpty(fieldName)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(className);
            return cls.getField(fieldName).get(cls);
        } catch (ClassNotFoundException e16) {
            Log.w(ReflectionUtil.TAG, "ClassNotFoundException: " + e16);
            return null;
        } catch (IllegalAccessException e17) {
            Log.w(ReflectionUtil.TAG, "IllegalAccessException: " + e17);
            return null;
        } catch (NoSuchFieldException e18) {
            Log.w(ReflectionUtil.TAG, "NoSuchFieldException: " + e18);
            return null;
        } catch (SecurityException e19) {
            Log.w(ReflectionUtil.TAG, "SecurityException: " + e19);
            return null;
        }
    }
}
