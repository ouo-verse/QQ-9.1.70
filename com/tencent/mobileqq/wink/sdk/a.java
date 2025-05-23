package com.tencent.mobileqq.wink.sdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z93.b;
import z93.c;
import z93.d;
import z93.e;
import z93.f;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BM\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u000e\u0010\u001aR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u0018\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/sdk/a;", "", "Lz93/f;", "a", "Lz93/f;", "f", "()Lz93/f;", "winkThreadApi", "Lz93/a;", "b", "Lz93/a;", "()Lz93/a;", "winkEditorApi", "Lz93/b;", "c", "Lz93/b;", "()Lz93/b;", "winkNavigateApi", "Lz93/d;", "d", "Lz93/d;", "()Lz93/d;", "winkReportApi", "Lz93/c;", "e", "Lz93/c;", "()Lz93/c;", "winkQualityReportApi", "Lz93/e;", "Lz93/e;", "()Lz93/e;", "winkResourceApi", "<init>", "(Lz93/f;Lz93/a;Lz93/b;Lz93/d;Lz93/c;Lz93/e;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f winkThreadApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final z93.a winkEditorApi;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b winkNavigateApi;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d winkReportApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c winkQualityReportApi;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final e winkResourceApi;

    public a(@NotNull f winkThreadApi, @Nullable z93.a aVar, @Nullable b bVar, @Nullable d dVar, @Nullable c cVar, @Nullable e eVar) {
        Intrinsics.checkNotNullParameter(winkThreadApi, "winkThreadApi");
        this.winkThreadApi = winkThreadApi;
        this.winkEditorApi = aVar;
        this.winkNavigateApi = bVar;
        this.winkReportApi = dVar;
        this.winkQualityReportApi = cVar;
        this.winkResourceApi = eVar;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final z93.a getWinkEditorApi() {
        return this.winkEditorApi;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final b getWinkNavigateApi() {
        return this.winkNavigateApi;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final c getWinkQualityReportApi() {
        return this.winkQualityReportApi;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final d getWinkReportApi() {
        return this.winkReportApi;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final e getWinkResourceApi() {
        return this.winkResourceApi;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final f getWinkThreadApi() {
        return this.winkThreadApi;
    }
}
