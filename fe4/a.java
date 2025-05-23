package fe4;

import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.report.IReportable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \u000e2\u00020\u0001:\u0002\u0003\u000eB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lfe4/a;", "Lcom/tencent/tavkit/report/IReportable;", "Lfe4/a$b;", "a", "", "d", "", "I", "c", "()I", "e", "(I)V", "nodeIndex", "", "b", "()Ljava/lang/String;", "effectId", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public abstract class a implements IReportable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int nodeIndex = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lfe4/a$b;", "", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "renderInfo", "", "isNeedApply", "Lfe4/b;", "imageParams", "", "a", "release", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@NotNull fe4.b imageParams, @NotNull RenderInfo renderInfo);

        boolean isNeedApply(@Nullable RenderInfo renderInfo);

        void release();
    }

    @NotNull
    public abstract b a();

    @NotNull
    public final String b() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

    /* renamed from: c, reason: from getter */
    public final int getNodeIndex() {
        return this.nodeIndex;
    }

    public final void e(int i3) {
        this.nodeIndex = i3;
    }

    public void d() {
    }
}
