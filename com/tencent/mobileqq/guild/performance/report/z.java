package com.tencent.mobileqq.guild.performance.report;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J0\u0010\n\u001a\u00020\u00052&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\bH&J:\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022(\b\u0002\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\bH&J\b\u0010\u000e\u001a\u00020\u0005H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/performance/report/z;", "", "", "b", "d", "", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "a", "event", "extraInfo", "e", "endTask", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface z {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(z zVar, String str, HashMap hashMap, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    hashMap = null;
                }
                zVar.e(str, hashMap);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addLog");
        }
    }

    void a(@Nullable HashMap<String, String> params);

    @NotNull
    String b();

    void c();

    @NotNull
    String d();

    void e(@NotNull String event, @Nullable HashMap<String, String> extraInfo);

    void endTask();
}
