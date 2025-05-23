package com.tencent.mobileqq.troop.homework.clockin;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/a;", "", "", "errCode", "", "a", "", "Ljava/util/Map;", "errMap", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, String> errMap;

    public a() {
        Map<Integer, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(10004, "\u5bb6\u957f\u65e0\u540c\u6b65\u5176\u4ed6\u7fa4\u6743\u9650"), TuplesKt.to(10005, "\u540c\u6b65\u7fa4\u9700\u662f\u8001\u5e08\u89d2\u8272"), TuplesKt.to(10009, "\u6253\u5361\u4efb\u52a1\u5df2\u88ab\u5220\u9664"), TuplesKt.to(10010, "\u8bf7\u5148\u8bbe\u7f6e\u7fa4\u8eab\u4efd"), TuplesKt.to(10011, "\u53ea\u80fd\u4fee\u6539\u81ea\u5df1\u53d1\u5e03\u7684\u6253\u5361"), TuplesKt.to(10012, "\u4e0d\u9700\u8981\u53d1\u9001\u63d0\u9192"), TuplesKt.to(10013, "\u8bf7\u52ff\u91cd\u590d\u63d0\u9192"), TuplesKt.to(10015, "\u4e0d\u9700\u8981\u6253\u5361"), TuplesKt.to(10016, "\u65e0\u63d0\u9192\u6743\u9650"), TuplesKt.to(10017, "\u65e0\u83b7\u53d6\u7edf\u8ba1\u4fe1\u606f\u6743\u9650"), TuplesKt.to(10018, "\u540c\u6b65\u7fa4\u4e2a\u6570\u8d85\u51fa\u8303\u56f4"), TuplesKt.to(10019, "\u7f51\u7edc\u5f02\u5e38\u8d85\u65f6"), TuplesKt.to(10020, "\u5df2\u8fbe\u672c\u65e5\u53d1\u5e03\u4e0a\u9650"), TuplesKt.to(10022, "\u5f53\u524d\u65e0\u6cd5\u63d0\u9192\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5"), TuplesKt.to(10023, "\u540c\u6b65\u7684\u7fa4\u8d85\u8fc7\u53d1\u5e03\u9650\u5236\u6761\u6570"), TuplesKt.to(10024, "\u4e0d\u5141\u8bb8\u8865\u6253\u5361"), TuplesKt.to(10025, "\u6253\u5361\u5df2\u7ecf\u505c\u6b62"));
            this.errMap = mapOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final String a(int errCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, errCode);
        }
        return this.errMap.get(Integer.valueOf(errCode));
    }
}
