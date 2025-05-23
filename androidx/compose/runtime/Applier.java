package androidx.compose.runtime;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0007H&J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u000fJ \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH&J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH&J\b\u0010\u0018\u001a\u00020\u0007H&R\u0012\u0010\u0003\u001a\u00028\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0019\u00c0\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/Applier;", "N", "", "current", "getCurrent", "()Ljava/lang/Object;", QCircleLpReportDc05507.KEY_CLEAR, "", "down", "node", "(Ljava/lang/Object;)V", "insertBottomUp", "index", "", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "(ILjava/lang/Object;)V", "insertTopDown", "move", "from", "to", "count", "onBeginChanges", "onEndChanges", "remove", "up", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public interface Applier<N> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <N> void onBeginChanges(Applier<N> applier) {
            a.a(applier);
        }

        @Deprecated
        public static <N> void onEndChanges(Applier<N> applier) {
            a.b(applier);
        }
    }

    void clear();

    void down(N node);

    N getCurrent();

    void insertBottomUp(int index, N instance);

    void insertTopDown(int index, N instance);

    void move(int from, int to5, int count);

    void onBeginChanges();

    void onEndChanges();

    void remove(int index, int count);

    void up();
}
