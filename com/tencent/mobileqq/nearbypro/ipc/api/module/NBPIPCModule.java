package com.tencent.mobileqq.nearbypro.ipc.api.module;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.nearbypro.media.NBPMediaSelector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import eipc.EIPCResult;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/ipc/api/module/NBPIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "moduleName", "<init>", "(Ljava/lang/String;)V", "d", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPIPCModule extends QIPCModule {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<NBPIPCModule> f253351e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/ipc/api/module/NBPIPCModule$a;", "", "Lcom/tencent/mobileqq/nearbypro/ipc/api/module/NBPIPCModule;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/nearbypro/ipc/api/module/NBPIPCModule;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.ipc.api.module.NBPIPCModule$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NBPIPCModule a() {
            return (NBPIPCModule) NBPIPCModule.f253351e.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<NBPIPCModule> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NBPIPCModule>() { // from class: com.tencent.mobileqq.nearbypro.ipc.api.module.NBPIPCModule$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NBPIPCModule invoke() {
                return new NBPIPCModule("NearbyProIPCModule");
            }
        });
        f253351e = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NBPIPCModule(@NotNull String moduleName) {
        super(moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        if (Intrinsics.areEqual(action, "ACTION_SELECTED_MEDIA_CALLBACK") && params != null) {
            params.setClassLoader(NBPIPCModule.class.getClassLoader());
            ArrayList parcelableArrayList = params.getParcelableArrayList(QQWinkConstants.INPUT_MEDIA);
            if (parcelableArrayList == null) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(parcelableArrayList, "it.getParcelableArrayLis\u2026PUT_MEDIA) ?: return null");
            NBPMediaSelector.f253605a.d(parcelableArrayList);
        }
        return null;
    }
}
