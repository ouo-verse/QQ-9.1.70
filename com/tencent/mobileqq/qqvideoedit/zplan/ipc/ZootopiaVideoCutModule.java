package com.tencent.mobileqq.qqvideoedit.zplan.ipc;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqvideoedit.api.IQQVideoEditApi;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import ik2.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/ipc/ZootopiaVideoCutModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "c", "", "action", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "<init>", "()V", "d", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ZootopiaVideoCutModule extends QIPCModule {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<ZootopiaVideoCutModule> f276369e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/zplan/ipc/ZootopiaVideoCutModule$a;", "", "", "action", "Landroid/os/Bundle;", "params", "Leipc/EIPCResultCallback;", "callback", "", "a", "Lcom/tencent/mobileqq/qqvideoedit/zplan/ipc/ZootopiaVideoCutModule;", "instance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/qqvideoedit/zplan/ipc/ZootopiaVideoCutModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "TAG", "Ljava/lang/String;", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.zplan.ipc.ZootopiaVideoCutModule$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String action, @Nullable Bundle params, @Nullable EIPCResultCallback callback) {
            Intrinsics.checkNotNullParameter(action, "action");
            QIPCClientHelper.getInstance().callServer(IQQVideoEditApi.ZOOTOPIA_VIDEO_CUT_MODULE_NAME, action, params, callback);
        }

        @NotNull
        public final ZootopiaVideoCutModule b() {
            return (ZootopiaVideoCutModule) ZootopiaVideoCutModule.f276369e.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqvideoedit/zplan/ipc/ZootopiaVideoCutModule$b", "Lik2/a$a;", "", "soDir", "", "a", "", "errCode", "errMsg", "error", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements a.InterfaceC10536a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f276370a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f276371b;

        b(Bundle bundle, CountDownLatch countDownLatch) {
            this.f276370a = bundle;
            this.f276371b = countDownLatch;
        }

        @Override // ik2.a.InterfaceC10536a
        public void a(@NotNull String soDir) {
            Intrinsics.checkNotNullParameter(soDir, "soDir");
            QLog.i("HallServerIpcModule_", 1, "handleInitLightResReq#success soDir:" + soDir);
            this.f276370a.putString("param_feature_manager_so_path", soDir);
            this.f276371b.countDown();
        }

        @Override // ik2.a.InterfaceC10536a
        public void error(int errCode, @Nullable String errMsg) {
            QLog.e("HallServerIpcModule_", 1, "handleInitLightResReq#error errCode:" + errCode + ", errMsg:" + errMsg);
            this.f276371b.countDown();
        }
    }

    static {
        Lazy<ZootopiaVideoCutModule> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaVideoCutModule>() { // from class: com.tencent.mobileqq.qqvideoedit.zplan.ipc.ZootopiaVideoCutModule$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ZootopiaVideoCutModule invoke() {
                return new ZootopiaVideoCutModule();
            }
        });
        f276369e = lazy;
    }

    public ZootopiaVideoCutModule() {
        super(IQQVideoEditApi.ZOOTOPIA_VIDEO_CUT_MODULE_NAME);
    }

    private final Bundle c() {
        Bundle bundle = new Bundle();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        QLog.i("HallServerIpcModule_", 1, "handleInitLightResReq in");
        a.f407903a.b(new b(bundle, countDownLatch));
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (Exception unused) {
        }
        QLog.i("HallServerIpcModule_", 1, "handleInitLightResReq out");
        return bundle;
    }

    @Override // eipc.EIPCModule
    @NotNull
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        EIPCResult eIPCResult = new EIPCResult();
        if (Intrinsics.areEqual(action, "action_init_light_res")) {
            eIPCResult.data = c();
        }
        callbackResult(callbackId, eIPCResult);
        return eIPCResult;
    }
}
