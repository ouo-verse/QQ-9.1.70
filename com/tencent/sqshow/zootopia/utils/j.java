package com.tencent.sqshow.zootopia.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0016\u0010\u0017J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\r\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\b\u001a\u00020\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0014\u0010\u0012\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/sqshow/zootopia/utils/j;", "T", "", "Landroidx/lifecycle/LiveData;", "a", "b", "()Ljava/lang/Object;", "", "c", "value", "", "e", "(Ljava/lang/Object;)V", "d", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "liveData", "Ljava/lang/Object;", "default", "", "Ljava/lang/String;", "tag", "<init>", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<T> liveData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final T default;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String tag;

    public j(MutableLiveData<T> liveData, T t16, String tag) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.liveData = liveData;
        this.default = t16;
        this.tag = tag;
    }

    public final LiveData<T> a() {
        return this.liveData;
    }

    public final T b() {
        T value = this.liveData.getValue();
        return value == null ? this.default : value;
    }

    public final boolean c() {
        return (this.liveData.getValue() == null || Intrinsics.areEqual(this.liveData.getValue(), this.default)) ? false : true;
    }

    public final void d() {
        this.liveData.setValue(this.default);
    }

    public final void e(T value) {
        this.liveData.setValue(value);
    }

    public /* synthetic */ j(MutableLiveData mutableLiveData, Object obj, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new MutableLiveData() : mutableLiveData, obj, (i3 & 4) != 0 ? "" : str);
    }
}
