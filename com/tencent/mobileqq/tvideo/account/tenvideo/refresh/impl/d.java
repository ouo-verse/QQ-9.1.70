package com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl;

import com.tencent.qphone.base.util.QLog;
import fu2.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\fB\u001d\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/d;", "Lfu2/b$a;", "", "prev", "curr", "", "d", "isNetValid", "c", "isPageValid", "b", "isForeground", "a", "Lfu2/b;", "Lfu2/b;", "provider", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "refreshCallback", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/a;", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/a;", "state", "e", "()Z", "isRefreshValid", "<init>", "(Lfu2/b;Lkotlin/jvm/functions/Function0;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d implements b.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fu2.b provider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> refreshCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RefreshCaseState state;

    public d(@NotNull fu2.b provider, @NotNull Function0<Unit> refreshCallback) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(refreshCallback, "refreshCallback");
        this.provider = provider;
        this.refreshCallback = refreshCallback;
        RefreshCaseState refreshCaseState = new RefreshCaseState(provider.d(), provider.a(), provider.e());
        this.state = refreshCaseState;
        provider.c(this);
        QLog.d("VideoRefreshCaseHandler", 1, "init state: " + refreshCaseState);
    }

    private final void d(boolean prev, boolean curr) {
        if (!prev && curr) {
            this.refreshCallback.invoke();
        }
    }

    @Override // fu2.b.a
    public void a(boolean isForeground) {
        boolean e16 = e();
        this.state.b(isForeground);
        boolean e17 = e();
        QLog.d("VideoRefreshCaseHandler", 1, "onAppForegroundStatusChange state: " + this.state);
        d(e16, e17);
    }

    @Override // fu2.b.a
    public void b(boolean isPageValid) {
        boolean e16 = e();
        this.state.d(isPageValid);
        boolean e17 = e();
        QLog.d("VideoRefreshCaseHandler", 1, "onPageStatusChange state: " + this.state);
        d(e16, e17);
    }

    @Override // fu2.b.a
    public void c(boolean isNetValid) {
        boolean e16 = e();
        this.state.c(isNetValid);
        boolean e17 = e();
        QLog.d("VideoRefreshCaseHandler", 1, "onNetStatusChange state: " + this.state);
        d(e16, e17);
    }

    public final boolean e() {
        return this.state.a();
    }
}
