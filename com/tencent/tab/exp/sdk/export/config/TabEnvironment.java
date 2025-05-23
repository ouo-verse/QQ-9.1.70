package com.tencent.tab.exp.sdk.export.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes26.dex */
public enum TabEnvironment {
    RELEASE,
    DEVELOP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f374014a;

        static {
            int[] iArr = new int[TabEnvironment.values().length];
            f374014a = iArr;
            try {
                iArr[TabEnvironment.DEVELOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @NonNull
    public static TabEnvironment deepCopy(@Nullable TabEnvironment tabEnvironment) {
        if (tabEnvironment == null) {
            return RELEASE;
        }
        if (a.f374014a[tabEnvironment.ordinal()] != 1) {
            return RELEASE;
        }
        return DEVELOP;
    }

    public static String toStorageName(@Nullable TabEnvironment tabEnvironment) {
        return deepCopy(tabEnvironment).name().toLowerCase();
    }
}
