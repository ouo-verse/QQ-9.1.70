package com.tencent.qqnt.trace.perf;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/trace/perf/a;", "T", "", "Lcom/tencent/qqnt/trace/perf/AIOPerfDataType;", "getType", "", "getTitle", "", "getContentList", "prevData", "", "a", "(Ljava/lang/Object;)V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a<T> {
    void a(T prevData);

    @NotNull
    List<String> getContentList();

    @NotNull
    String getTitle();

    @NotNull
    AIOPerfDataType getType();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.trace.perf.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9704a {
        public static <T> void a(@NotNull a<T> aVar, T t16) {
        }
    }
}
