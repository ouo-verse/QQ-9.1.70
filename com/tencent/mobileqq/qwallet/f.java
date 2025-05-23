package com.tencent.mobileqq.qwallet;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R$\u0010\f\u001a\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/f;", "T", "", "a", "()Ljava/lang/Object;", "", "Z", "needWeak", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "b", "Lmqq/util/WeakReference;", "weakRef", "c", "Ljava/lang/Object;", "strongRef", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "mmkvKey", "isDefaultWeak", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Z)V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean needWeak;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final WeakReference<T> weakRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final T strongRef;

    public f(T t16, @NotNull String mmkvKey, boolean z16) {
        WeakReference<T> weakReference;
        Intrinsics.checkNotNullParameter(mmkvKey, "mmkvKey");
        boolean isSwitchOn = ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(mmkvKey, z16);
        this.needWeak = isSwitchOn;
        if (isSwitchOn) {
            weakReference = new WeakReference<>(t16);
        } else {
            weakReference = null;
        }
        this.weakRef = weakReference;
        this.strongRef = isSwitchOn ? null : t16;
    }

    @Nullable
    public final T a() {
        if (this.needWeak) {
            WeakReference<T> weakReference = this.weakRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return this.strongRef;
    }
}
