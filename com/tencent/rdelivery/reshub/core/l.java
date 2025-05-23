package com.tencent.rdelivery.reshub.core;

import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.api.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/l;", "Lcom/tencent/rdelivery/reshub/api/h;", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "", "onComplete", "", "a", "Ljava/lang/String;", "getResId", "()Ljava/lang/String;", "resId", "<init>", "(Ljava/lang/String;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class l implements com.tencent.rdelivery.reshub.api.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String resId;

    public l(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        this.resId = resId;
    }

    @Override // com.tencent.rdelivery.reshub.api.h
    public void onComplete(boolean isSuccess, @Nullable com.tencent.rdelivery.reshub.api.g result, @NotNull n error) {
        Long l3;
        Intrinsics.checkParameterIsNotNull(error, "error");
        if (isSuccess) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Locked Res[");
            sb5.append(this.resId);
            sb5.append("] Success. Version: ");
            if (result != null) {
                l3 = Long.valueOf(result.getVersion());
            } else {
                l3 = null;
            }
            sb5.append(l3);
            jz3.d.e("ResHubResLoader", sb5.toString());
            return;
        }
        jz3.d.c("ResHubResLoader", "Locked Res[" + this.resId + "] Fail: " + error.b() + ", " + error.message());
    }

    @Override // com.tencent.rdelivery.reshub.api.h
    public void onProgress(float f16) {
        h.a.a(this, f16);
    }
}
