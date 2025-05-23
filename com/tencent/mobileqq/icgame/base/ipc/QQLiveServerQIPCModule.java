package com.tencent.mobileqq.icgame.base.ipc;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.icgame.api.ipc.IQQLiveIPCServerApi;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.api.ipc.QQLiveIPCConstants;
import eipc.EIPCResult;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/ipc/QQLiveServerQIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "params", "", "c", "", "action", "", "callbackId", "Leipc/EIPCResult;", "onCall", "moduleName", "<init>", "(Ljava/lang/String;)V", "d", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLiveServerQIPCModule extends QIPCModule {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<QQLiveServerQIPCModule> f237146e;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/ipc/QQLiveServerQIPCModule$a;", "", "Lcom/tencent/mobileqq/icgame/base/ipc/QQLiveServerQIPCModule;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/icgame/base/ipc/QQLiveServerQIPCModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "", "isRegisterModule", "Z", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.icgame.base.ipc.QQLiveServerQIPCModule$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QQLiveServerQIPCModule a() {
            return (QQLiveServerQIPCModule) QQLiveServerQIPCModule.f237146e.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<QQLiveServerQIPCModule> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQLiveServerQIPCModule>() { // from class: com.tencent.mobileqq.icgame.base.ipc.QQLiveServerQIPCModule$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQLiveServerQIPCModule invoke() {
                return new QQLiveServerQIPCModule(IQQLiveIPCServerApi.MODULE_NAME_LIVE);
            }
        });
        f237146e = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveServerQIPCModule(@NotNull String moduleName) {
        super(moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        if (Intrinsics.areEqual(QQLiveIPCConstants.Action.ACTION_QQLIVE_QUALITY_REPORT, action) && params != null) {
            c(params);
            return null;
        }
        return null;
    }

    private final void c(Bundle params) {
    }
}
