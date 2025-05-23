package com.tencent.mobileqq.qwallet;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0006\u001a\u00020\u0005R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/i;", "T", "", "b", "()Ljava/lang/Object;", "", "a", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "weakRef", "Ljava/lang/Object;", "strongRef", "", "c", "Z", "isUseWeakRef", "obj", "", "switchKey", RemoteHandleConst.PARAM_DEFAULT_VALUE, "<init>", "(Ljava/lang/Object;Ljava/lang/String;Z)V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class i<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<T> weakRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T strongRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean isUseWeakRef;

    public i(T t16, @NotNull String switchKey, boolean z16) {
        Intrinsics.checkNotNullParameter(switchKey, "switchKey");
        boolean isFeatureSwitch = ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(switchKey, z16);
        this.isUseWeakRef = isFeatureSwitch;
        if (isFeatureSwitch) {
            this.weakRef = new WeakReference<>(t16);
        } else {
            this.strongRef = t16;
        }
    }

    public final void a() {
        WeakReference<T> weakReference = this.weakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.weakRef = null;
        this.strongRef = null;
    }

    @Nullable
    public final T b() {
        if (this.isUseWeakRef) {
            WeakReference<T> weakReference = this.weakRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return this.strongRef;
    }

    public /* synthetic */ i(Object obj, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, str, (i3 & 4) != 0 ? true : z16);
    }
}
