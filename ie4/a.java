package ie4;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lie4/a;", "", "", "timeUs", "Lcom/tencent/tav/coremedia/CMTime;", "a", "start", "duration", "Lcom/tencent/tav/coremedia/CMTimeRange;", "b", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f407564a = new a();

    a() {
    }

    @NotNull
    public final CMTime a(long timeUs) {
        return new CMTime(timeUs, 1000000);
    }

    @NotNull
    public final CMTimeRange b(long start, long duration) {
        return new CMTimeRange(a(start), a(duration));
    }
}
