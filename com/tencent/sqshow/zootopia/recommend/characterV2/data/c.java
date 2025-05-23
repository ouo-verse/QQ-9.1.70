package com.tencent.sqshow.zootopia.recommend.characterV2.data;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.sqshow.zootopia.utils.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\f\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/c;", "", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "c", "Lcom/tencent/sqshow/zootopia/utils/j;", "", "b", "Lcom/tencent/sqshow/zootopia/utils/j;", "()Lcom/tencent/sqshow/zootopia/utils/j;", "roleCanTouch", "a", "enableDynamicBackground", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f372487a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final j<Boolean> roleCanTouch = new j<>(null, Boolean.TRUE, null, 5, null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final j<Boolean> enableDynamicBackground = new j<>(null, Boolean.FALSE, null, 5, null);

    c() {
    }

    public final j<Boolean> a() {
        return enableDynamicBackground;
    }

    public final j<Boolean> b() {
        return roleCanTouch;
    }

    public final void c(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        enableDynamicBackground.a().removeObservers(owner);
    }
}
