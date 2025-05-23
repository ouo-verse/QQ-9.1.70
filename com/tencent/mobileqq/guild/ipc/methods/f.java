package com.tencent.mobileqq.guild.ipc.methods;

import androidx.core.os.BundleKt;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ;\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/f;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "ipcContext", "", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @NotNull
    public EIPCResult a(@Nullable AbsIpcMethod.a ipcContext, @Nullable String method, @NotNull Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        try {
            EIPCResult createSuccessResult = EIPCResult.createSuccessResult(BundleKt.bundleOf(TuplesKt.to("FONT_SCALE_RATE", Float.valueOf(FontSettingManager.getFontScale()))));
            Intrinsics.checkNotNullExpressionValue(createSuccessResult, "{\n            EIPCResult\u2026)\n            )\n        }");
            return createSuccessResult;
        } catch (Exception e16) {
            EIPCResult createExceptionResult = EIPCResult.createExceptionResult(e16);
            Intrinsics.checkNotNullExpressionValue(createExceptionResult, "{\n            EIPCResult\u2026ptionResult(ex)\n        }");
            return createExceptionResult;
        }
    }
}
