package com.tencent.rdelivery.reshub.processor;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rdelivery.reshub.patch.AbstractTryPatchProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nz3.DiffInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/b;", "Lcom/tencent/rdelivery/reshub/patch/AbstractTryPatchProcessor;", "", "getPriority", "Ljz3/e;", "remoteConfig", "", ReportConstant.COSTREPORT_PREFIX, "localConfig", "Lnz3/a;", "p", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "", "o", "patchPath", "targetPath", "Lcom/tencent/rdelivery/reshub/report/a;", "y", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b extends AbstractTryPatchProcessor {
    public b() {
        super("BigRes", true);
    }

    @Override // com.tencent.rdelivery.reshub.processor.a
    public int getPriority() {
        return 500;
    }

    @Override // com.tencent.rdelivery.reshub.patch.AbstractTryPatchProcessor
    public void m(@NotNull com.tencent.rdelivery.reshub.core.k req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        req.F(true);
    }

    @Override // com.tencent.rdelivery.reshub.patch.AbstractTryPatchProcessor
    @NotNull
    public String o(@NotNull com.tencent.rdelivery.reshub.core.k req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        return jz3.b.l(req);
    }

    @Override // com.tencent.rdelivery.reshub.patch.AbstractTryPatchProcessor
    @Nullable
    public DiffInfo p(@NotNull jz3.e remoteConfig, @NotNull jz3.e localConfig) {
        Intrinsics.checkParameterIsNotNull(remoteConfig, "remoteConfig");
        Intrinsics.checkParameterIsNotNull(localConfig, "localConfig");
        return jz3.f.b(remoteConfig, localConfig.f411261b);
    }

    @Override // com.tencent.rdelivery.reshub.patch.AbstractTryPatchProcessor
    public boolean s(@NotNull jz3.e remoteConfig) {
        Intrinsics.checkParameterIsNotNull(remoteConfig, "remoteConfig");
        if (remoteConfig.f411282w != null && remoteConfig.f411283x != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.rdelivery.reshub.patch.AbstractTryPatchProcessor
    @NotNull
    public com.tencent.rdelivery.reshub.report.a y(@NotNull String patchPath, @NotNull String targetPath, @NotNull jz3.e localConfig, @NotNull jz3.e remoteConfig) {
        Intrinsics.checkParameterIsNotNull(patchPath, "patchPath");
        Intrinsics.checkParameterIsNotNull(targetPath, "targetPath");
        Intrinsics.checkParameterIsNotNull(localConfig, "localConfig");
        Intrinsics.checkParameterIsNotNull(remoteConfig, "remoteConfig");
        return new com.tencent.rdelivery.reshub.patch.a().f(patchPath, targetPath, localConfig, remoteConfig);
    }
}
