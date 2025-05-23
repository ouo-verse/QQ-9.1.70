package com.tencent.mobileqq.vas.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasAudioApi;
import com.tencent.mobileqq.vas.theme.ThemeVipBehavior;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/util/c;", "Lmqq/app/IAccountCallback;", "", "a", "Lmqq/app/AppRuntime;", "newRuntime", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "", "e", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "", "f", "Z", "isRegistered", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c implements IAccountCallback {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final c f311229d = new c();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "VasAccountManager";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isRegistered;

    c() {
    }

    public final void a() {
        if (!isRegistered) {
            MobileQQ.sMobileQQ.registerAccountCallback(this);
            isRegistered = true;
        }
        com.tencent.xaction.log.b.a(TAG, 1, "onCreate");
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(@Nullable AppRuntime newRuntime) {
        com.tencent.xaction.log.b.a(TAG, 1, "onAccountChangeFailed");
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(@Nullable AppRuntime newRuntime) {
        com.tencent.xaction.log.b.a(TAG, 1, "onAccountChanged");
        ThemeVipBehavior.setCurrentUserVip(false);
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(@Nullable Constants.LogoutReason reason) {
        com.tencent.xaction.log.b.a(TAG, 1, "onLogout");
        ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).pause("");
    }
}
