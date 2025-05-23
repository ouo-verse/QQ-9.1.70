package com.tencent.filament.zplanservice.download;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/filament/zplanservice/download/ZPlanAvatarFileDownloadDescriptor;", "", "url", "", "localSavePath", "isDownload", "", "resourceDir", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "()Z", "getLocalSavePath", "()Ljava/lang/String;", "getResourceDir", "getUrl", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanAvatarFileDownloadDescriptor {
    private final boolean isDownload;

    @NotNull
    private final String localSavePath;

    @NotNull
    private final String resourceDir;

    @NotNull
    private final String url;

    public ZPlanAvatarFileDownloadDescriptor(@NotNull String url, @NotNull String localSavePath, boolean z16, @NotNull String resourceDir) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(localSavePath, "localSavePath");
        Intrinsics.checkNotNullParameter(resourceDir, "resourceDir");
        this.url = url;
        this.localSavePath = localSavePath;
        this.isDownload = z16;
        this.resourceDir = resourceDir;
    }

    @NotNull
    public final String getLocalSavePath() {
        return this.localSavePath;
    }

    @NotNull
    public final String getResourceDir() {
        return this.resourceDir;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: isDownload, reason: from getter */
    public final boolean getIsDownload() {
        return this.isDownload;
    }
}
