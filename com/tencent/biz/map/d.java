package com.tencent.biz.map;

import com.tencent.mobileqq.app.ck;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R$\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/map/d;", "", "", "userAccount", "", "a", "b", "Lcom/tencent/mobileqq/app/ck;", "Lcom/tencent/mobileqq/app/ck;", "getMQQMapActivityProxy", "()Lcom/tencent/mobileqq/app/ck;", "setMQQMapActivityProxy", "(Lcom/tencent/mobileqq/app/ck;)V", "mQQMapActivityProxy", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f78690a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ck mQQMapActivityProxy;

    d() {
    }

    public final void a(@NotNull String userAccount) {
        Intrinsics.checkNotNullParameter(userAccount, "userAccount");
        if (mQQMapActivityProxy == null) {
            mQQMapActivityProxy = new ck(userAccount);
        }
    }

    public final void b() {
        ck ckVar = mQQMapActivityProxy;
        if (ckVar != null) {
            ckVar.e();
        }
        mQQMapActivityProxy = null;
    }
}
