package com.tencent.mobileqq.aio.msglist.holder.component.ark.view;

import com.tencent.ark.ArkViewModelBase;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.aio.msg.template.d;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAsyncRunnableProxy;", "Ljava/lang/Runnable;", "", "e", "f", TencentLocation.RUN_MODE, "d", "Ljava/lang/Runnable;", "runnable", "Lcom/tencent/ark/ArkViewModelBase$AppInfo;", "Lcom/tencent/ark/ArkViewModelBase$AppInfo;", "appInfo", "", "Z", "isTaskFinished", h.F, "isTaskStarted", "i", "delayCheck", "<init>", "(Ljava/lang/Runnable;Lcom/tencent/ark/ArkViewModelBase$AppInfo;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ArkAsyncRunnableProxy implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Runnable runnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ArkViewModelBase.AppInfo appInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isTaskFinished;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isTaskStarted;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable delayCheck = new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ark.view.a
        @Override // java.lang.Runnable
        public final void run() {
            ArkAsyncRunnableProxy.b(ArkAsyncRunnableProxy.this);
        }
    };

    @NotNull
    private static final AtomicBoolean C = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAsyncRunnableProxy$a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/a;", "", h.F, "", "e", "Z", "isThisTaskBlock", "()Z", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "runnable", "Lcom/tencent/mobileqq/aio/msg/template/d;", "templateMsgInfo", "<init>", "(Lcom/tencent/mobileqq/aio/msg/template/d;ZLjava/lang/Runnable;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends com.tencent.mobileqq.aio.msglist.holder.component.template.report.a {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isThisTaskBlock;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Runnable runnable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull d templateMsgInfo, boolean z16, @Nullable Runnable runnable) {
            super(templateMsgInfo);
            Intrinsics.checkNotNullParameter(templateMsgInfo, "templateMsgInfo");
            this.isThisTaskBlock = z16;
            this.runnable = runnable;
        }

        public final void h() {
            String str;
            HashMap<String, Object> c16 = c();
            boolean z16 = this.isThisTaskBlock;
            Runnable runnable = this.runnable;
            if (runnable != null) {
                str = runnable.getClass().getSimpleName();
            } else {
                str = null;
            }
            c16.put("error_msg", "old ark block, byThis = " + z16 + ", runnable=" + str);
            c().put("error_code", 89757);
            b("preview_ark2md_render_fail");
        }
    }

    public ArkAsyncRunnableProxy(@Nullable Runnable runnable, @Nullable ArkViewModelBase.AppInfo appInfo) {
        this.runnable = runnable;
        this.appInfo = appInfo;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ArkAsyncRunnableProxy this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("ArkApp.RunnableProxy", 4, "start check");
        if (this$0.isTaskFinished) {
            return;
        }
        this$0.f();
    }

    private final void e() {
        ThreadManagerV2.executeDelay(this.delayCheck, 16, null, true, 5000L);
    }

    private final void f() {
        String str;
        String str2;
        if (!this.isTaskStarted && !C.getAndSet(true)) {
            QLog.w("ArkApp.RunnableProxy", 1, "warning, runnable is blocked\uff0creport. isTaskStarted = " + this.isTaskStarted + ", runnable = " + this.runnable);
            d dVar = new d();
            ArkViewModelBase.AppInfo appInfo = this.appInfo;
            String str3 = null;
            if (appInfo != null) {
                str = appInfo.name;
            } else {
                str = null;
            }
            dVar.g(str);
            ArkViewModelBase.AppInfo appInfo2 = this.appInfo;
            if (appInfo2 != null) {
                str2 = appInfo2.bizSrc;
            } else {
                str2 = null;
            }
            dVar.h(str2);
            ArkViewModelBase.AppInfo appInfo3 = this.appInfo;
            if (appInfo3 != null) {
                str3 = appInfo3.view;
            }
            dVar.l(str3);
            new a(dVar, this.isTaskStarted, this.runnable).h();
            return;
        }
        QLog.w("ArkApp.RunnableProxy", 1, "warning, runnable is waiting too much time");
    }

    @Override // java.lang.Runnable
    public void run() {
        this.isTaskStarted = true;
        Runnable runnable = this.runnable;
        if (runnable != null) {
            runnable.run();
        }
        this.isTaskFinished = true;
    }
}
