package com.tencent.filament.zplanservice.download;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@NativeProxy(allFields = true, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "", "result", "", "allFiles", "", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarFileDownloadDescriptor;", "(Ljava/lang/String;[Lcom/tencent/filament/zplanservice/download/ZPlanAvatarFileDownloadDescriptor;)V", "getAllFiles", "()[Lcom/tencent/filament/zplanservice/download/ZPlanAvatarFileDownloadDescriptor;", "[Lcom/tencent/filament/zplanservice/download/ZPlanAvatarFileDownloadDescriptor;", "getResult", "()Ljava/lang/String;", "isDownload", "", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanAvatarInterfaceResult {

    @NotNull
    private final ZPlanAvatarFileDownloadDescriptor[] allFiles;

    @NotNull
    private final String result;

    @NativeMethodProxy
    public ZPlanAvatarInterfaceResult(@NotNull String result, @NotNull ZPlanAvatarFileDownloadDescriptor[] allFiles) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(allFiles, "allFiles");
        this.result = result;
        this.allFiles = allFiles;
    }

    @NotNull
    public final ZPlanAvatarFileDownloadDescriptor[] getAllFiles() {
        return this.allFiles;
    }

    @NotNull
    public final String getResult() {
        return this.result;
    }

    public final boolean isDownload() {
        for (ZPlanAvatarFileDownloadDescriptor zPlanAvatarFileDownloadDescriptor : this.allFiles) {
            if (zPlanAvatarFileDownloadDescriptor.getIsDownload()) {
                return true;
            }
        }
        return false;
    }
}
