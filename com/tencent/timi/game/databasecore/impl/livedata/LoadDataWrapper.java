package com.tencent.timi.game.databasecore.impl.livedata;

import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LoadDataWrapper<T> {

    /* renamed from: a, reason: collision with root package name */
    public int f376794a;

    /* renamed from: b, reason: collision with root package name */
    public String f376795b;

    /* renamed from: c, reason: collision with root package name */
    public int f376796c;

    /* renamed from: d, reason: collision with root package name */
    public T f376797d;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface NetStatus {
    }

    public LoadDataWrapper(int i3, T t16) {
        this.f376797d = t16;
        this.f376796c = i3;
    }

    public static <Q> LoadDataWrapper<Q> a(int i3, String str, Q q16) {
        LoadDataWrapper<Q> loadDataWrapper = new LoadDataWrapper<>(3, q16);
        loadDataWrapper.f376794a = i3;
        loadDataWrapper.f376795b = str;
        return loadDataWrapper;
    }

    @Nullable
    public T b() {
        return this.f376797d;
    }
}
