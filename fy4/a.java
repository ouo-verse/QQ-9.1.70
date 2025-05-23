package fy4;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import java.util.Random;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lfy4/a;", "", "", "a", "b", "Ljava/util/Random;", "Ljava/util/Random;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "<init>", "()V", "zplan-tracing_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f400951b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Random random = new Random();

    a() {
    }

    @NotNull
    public final String a() {
        long nextLong;
        do {
            nextLong = random.nextLong();
        } while (nextLong == 0);
        return b.f400952a.a(nextLong);
    }

    @NotNull
    public final String b() {
        long nextLong;
        long nextLong2 = random.nextLong();
        do {
            nextLong = random.nextLong();
        } while (nextLong == 0);
        return c.f400953a.a(nextLong2, nextLong);
    }
}
