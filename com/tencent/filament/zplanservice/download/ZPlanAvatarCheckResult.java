package com.tencent.filament.zplanservice.download;

import androidx.annotation.Keep;
import com.tencent.filament.zplanservice.verify.ResourceCheckResult;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@NativeProxy(allFields = true, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/filament/zplanservice/download/ZPlanAvatarCheckResult;", "", "url", "", QzoneZipCacheHelper.DIR, "checkResult", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckResult;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/filament/zplanservice/verify/ResourceCheckResult;)V", "getCheckResult", "()Lcom/tencent/filament/zplanservice/verify/ResourceCheckResult;", "getDir", "()Ljava/lang/String;", "getUrl", "toString", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanAvatarCheckResult {

    @NotNull
    private final ResourceCheckResult checkResult;

    @NotNull
    private final String dir;

    @NotNull
    private final String url;

    @NativeMethodProxy
    public ZPlanAvatarCheckResult(@NotNull String url, @NotNull String dir, @NotNull ResourceCheckResult checkResult) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(checkResult, "checkResult");
        this.url = url;
        this.dir = dir;
        this.checkResult = checkResult;
    }

    @NotNull
    public final ResourceCheckResult getCheckResult() {
        return this.checkResult;
    }

    @NotNull
    public final String getDir() {
        return this.dir;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public String toString() {
        return "url:" + this.url + ", dir:" + this.dir + ", avatarCheckResult:" + this.checkResult;
    }
}
