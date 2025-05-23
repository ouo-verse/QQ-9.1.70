package com.tencent.filament.zplanservice.download;

import com.tencent.filament.zplanservice.verify.ResourceCheckAlgorithmSelect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/filament/zplanservice/download/a;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "urlTemplate", "", "b", "Z", "()Z", "enableResourceCheck", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect;", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect;", "()Lcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect;", "algorithmSelect", "<init>", "(Ljava/lang/String;ZLcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect;)V", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String urlTemplate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean enableResourceCheck;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ResourceCheckAlgorithmSelect algorithmSelect;

    public a(@NotNull String urlTemplate, boolean z16, @NotNull ResourceCheckAlgorithmSelect algorithmSelect) {
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        Intrinsics.checkNotNullParameter(algorithmSelect, "algorithmSelect");
        this.urlTemplate = urlTemplate;
        this.enableResourceCheck = z16;
        this.algorithmSelect = algorithmSelect;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ResourceCheckAlgorithmSelect getAlgorithmSelect() {
        return this.algorithmSelect;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableResourceCheck() {
        return this.enableResourceCheck;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getUrlTemplate() {
        return this.urlTemplate;
    }
}
