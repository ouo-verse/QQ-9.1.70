package com.tencent.mobileqq.vas.kuikly.reader.delegate;

import android.os.SystemClock;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\f\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR>\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e`\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/i;", "", "", "tag", "", MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, "", "a", "b", "I", "getMAX_TAG_COUNT", "()I", "MAX_TAG_COUNT", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "getSClickTimeMap", "()Ljava/util/HashMap;", "setSClickTimeMap", "(Ljava/util/HashMap;)V", "sClickTimeMap", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f309926a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int MAX_TAG_COUNT = 10;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<String, Long> sClickTimeMap = new HashMap<>();

    i() {
    }

    public final boolean a(@NotNull String tag, int timeInterval) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Long l3 = sClickTimeMap.get(tag);
        boolean z16 = true;
        if (l3 != null) {
            if (sClickTimeMap.size() > MAX_TAG_COUNT) {
                sClickTimeMap.clear();
            }
            if (elapsedRealtime - l3.longValue() <= timeInterval) {
                z16 = false;
            }
            if (z16) {
                sClickTimeMap.put(tag, Long.valueOf(elapsedRealtime));
            }
            return z16;
        }
        sClickTimeMap.put(tag, Long.valueOf(elapsedRealtime));
        return true;
    }
}
