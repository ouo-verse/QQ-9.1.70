package j61;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u0006R\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\b\u0010\u0012\"\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lj61/d;", "", "", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "friendUin", "", "I", "e", "()I", h.F, "(I)V", AdMetricTag.Report.TYPE, "f", "currentType", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f409515a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String friendUin = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int reportType = 1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int currentType;

    d() {
    }

    public final void a() {
        friendUin = "";
        reportType = 1;
        currentType = 0;
    }

    public final int b() {
        return currentType;
    }

    @NotNull
    public final String c() {
        return friendUin;
    }

    @NotNull
    public final HashMap<String, Object> d() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("is_close_relation", String.valueOf(reportType - 1));
        hashMap.put("aio_swipleft_version", "2");
        hashMap.put("interaction_lab_id", "3");
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).restorePgSwipLeftData(hashMap);
        return hashMap;
    }

    public final int e() {
        return reportType;
    }

    public final void f(int i3) {
        currentType = i3;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        friendUin = str;
    }

    public final void h(int i3) {
        reportType = i3;
    }
}
