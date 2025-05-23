package p0;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\u0010\u001a\u00020\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lp0/a;", "", "", "result", "", "callback", "", "isASync", "getEventName", "()Ljava/lang/String;", AdMetricTag.EVENT_NAME, "getParams", "params", "", "getCallbackId", "()I", "callbackId", "render_library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* renamed from: p0.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C10971a {
        public static boolean a(a aVar) {
            if (aVar.getCallbackId() >= 0) {
                return true;
            }
            return false;
        }
    }

    void callback(@Nullable String result);

    int getCallbackId();

    @NotNull
    String getEventName();

    @NotNull
    String getParams();

    boolean isASync();
}
