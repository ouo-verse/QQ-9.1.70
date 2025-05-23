package com.tencent.mobileqq.tvideo.account.tenvideo.refresh;

import com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl.AlarmExecutorImpl;
import com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import fu2.a;
import fu2.b;
import fu2.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00052\u00020\u0001:\u0002\f B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/VideoLoginRefreshController;", "", "", "c", "f", "g", "b", h.F, "i", "e", "d", "Lfu2/a;", "a", "Lfu2/a;", "accountGetter", "Lfu2/c;", "Lfu2/c;", "refreshHandler", "Lfu2/b;", "Lfu2/b;", "refreshCaseProvider", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/c;", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/c;", "scheduler", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/d;", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/impl/d;", "refreshCaseHandler", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/VideoLoginRefreshController$VideoAccountState;", "Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/VideoLoginRefreshController$VideoAccountState;", "currState", "<init>", "(Lfu2/a;Lfu2/c;Lfu2/b;)V", "VideoAccountState", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class VideoLoginRefreshController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a accountGetter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c refreshHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b refreshCaseProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl.c scheduler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d refreshCaseHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VideoAccountState currState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/tvideo/account/tenvideo/refresh/VideoLoginRefreshController$VideoAccountState;", "", "(Ljava/lang/String;I)V", AegisLogger.LOGIN, "NotLogin", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public enum VideoAccountState {
        Login,
        NotLogin
    }

    public VideoLoginRefreshController(@NotNull a accountGetter, @NotNull c refreshHandler, @NotNull b refreshCaseProvider) {
        Intrinsics.checkNotNullParameter(accountGetter, "accountGetter");
        Intrinsics.checkNotNullParameter(refreshHandler, "refreshHandler");
        Intrinsics.checkNotNullParameter(refreshCaseProvider, "refreshCaseProvider");
        this.accountGetter = accountGetter;
        this.refreshHandler = refreshHandler;
        this.refreshCaseProvider = refreshCaseProvider;
        this.scheduler = new com.tencent.mobileqq.tvideo.account.tenvideo.refresh.impl.c(accountGetter, refreshHandler, new AlarmExecutorImpl());
        this.refreshCaseHandler = new d(refreshCaseProvider, new Function0<Unit>() { // from class: com.tencent.mobileqq.tvideo.account.tenvideo.refresh.VideoLoginRefreshController$refreshCaseHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VideoLoginRefreshController.this.c();
            }
        });
        this.currState = VideoAccountState.NotLogin;
    }

    private final void b() {
        g();
        this.refreshHandler.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        QLog.d("VideoLoginRefreshController", 1, "caseAutoRefresh currState: " + this.currState);
        VideoAccountState videoAccountState = this.currState;
        VideoAccountState videoAccountState2 = VideoAccountState.NotLogin;
        if (videoAccountState == videoAccountState2 && this.accountGetter.a() == null) {
            return;
        }
        b();
        bu2.a a16 = this.accountGetter.a();
        if (a16 != null) {
            if (this.currState == videoAccountState2) {
                this.refreshHandler.a(a16, 0);
            } else {
                this.refreshHandler.a(a16, 1);
            }
        }
    }

    private final void f() {
        this.scheduler.e();
    }

    private final void g() {
        this.scheduler.f();
    }

    public final void d() {
        QLog.d("VideoLoginRefreshController", 1, "manualRefresh currState: " + this.currState);
        if (this.currState != VideoAccountState.Login) {
            return;
        }
        b();
        bu2.a a16 = this.accountGetter.a();
        if (a16 != null) {
            this.refreshHandler.a(a16, 0);
        }
    }

    public final void e() {
        QLog.d("VideoLoginRefreshController", 1, "onAccountUpdate currState: " + this.currState);
        if (this.currState != VideoAccountState.Login) {
            return;
        }
        f();
    }

    public final void h() {
        QLog.d("VideoLoginRefreshController", 1, "switchToLoginState currState: " + this.currState);
        this.currState = VideoAccountState.Login;
        f();
    }

    public final void i() {
        QLog.d("VideoLoginRefreshController", 1, "switchToNotLogin currState: " + this.currState);
        this.currState = VideoAccountState.NotLogin;
        b();
    }
}
