package com.tencent.filament.zplanservice.verify;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/filament/zplanservice/verify/ResourceCheckResult;", "", "intCode", "", "failList", "", "", "(I[Ljava/lang/String;)V", "code", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckCode;", "getCode", "()Lcom/tencent/filament/zplanservice/verify/ResourceCheckCode;", "getFailList", "()[Ljava/lang/String;", "[Ljava/lang/String;", "passVerification", "", "toString", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ResourceCheckResult {

    @NotNull
    private final ResourceCheckCode code;

    @NotNull
    private final String[] failList;

    @NativeMethodProxy
    public ResourceCheckResult(int i3, @NotNull String[] failList) {
        Intrinsics.checkNotNullParameter(failList, "failList");
        this.failList = failList;
        this.code = ResourceCheckCode.INSTANCE.a(i3);
    }

    @NotNull
    public final ResourceCheckCode getCode() {
        return this.code;
    }

    @NotNull
    public final String[] getFailList() {
        return this.failList;
    }

    public final boolean passVerification() {
        if (this.failList.length == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "code:" + this.code + ", failList:" + this.failList;
    }
}
