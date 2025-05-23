package com.tencent.mobileqq.zplan.utils;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0003\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\b\u0010\u0012R\u001f\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\f\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/f;", "", "", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "url", "b", "d", "savePath", "", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "header", "", "Z", "()Z", "priority", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "progressFlow", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZLkotlinx/coroutines/flow/MutableStateFlow;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String url;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String savePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> header;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean priority;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final MutableStateFlow<Float> progressFlow;

    public f(String url, String savePath, Map<String, String> header, boolean z16, MutableStateFlow<Float> mutableStateFlow) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        Intrinsics.checkNotNullParameter(header, "header");
        this.url = url;
        this.savePath = savePath;
        this.header = header;
        this.priority = z16;
        this.progressFlow = mutableStateFlow;
    }

    public final Map<String, String> a() {
        return this.header;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getPriority() {
        return this.priority;
    }

    public final MutableStateFlow<Float> c() {
        return this.progressFlow;
    }

    /* renamed from: d, reason: from getter */
    public final String getSavePath() {
        return this.savePath;
    }

    /* renamed from: e, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public /* synthetic */ f(String str, String str2, Map map, boolean z16, MutableStateFlow mutableStateFlow, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? null : mutableStateFlow);
    }
}
