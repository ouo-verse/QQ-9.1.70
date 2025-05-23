package com.tencent.filament.zplanservice.verify;

import bl0.a;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0082 J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/filament/zplanservice/verify/FilamentVerificationHelper;", "", "", QzoneZipCacheHelper.DIR, "", "algorithmSelect", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckResult;", "nCheck", "name", "", "nGenerateVerifyFile", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect;", "a", "b", "<init>", "()V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentVerificationHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FilamentVerificationHelper f106448a = new FilamentVerificationHelper();

    static {
        a aVar = a.f28591a;
    }

    FilamentVerificationHelper() {
    }

    private final native ResourceCheckResult nCheck(String dir, int algorithmSelect);

    private final native void nGenerateVerifyFile(String dir, String name);

    @NotNull
    public final ResourceCheckResult a(@NotNull String dir, @NotNull ResourceCheckAlgorithmSelect algorithmSelect) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(algorithmSelect, "algorithmSelect");
        return nCheck(dir, algorithmSelect.getValue());
    }

    public final void b(@NotNull String dir, @NotNull String name) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(name, "name");
        nGenerateVerifyFile(dir, name);
    }
}
