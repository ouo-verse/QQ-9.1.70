package bj4;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u0002H&J\b\u0010\u000f\u001a\u00020\fH&J\b\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lbj4/a;", "", "", "event", "Ldj4/a;", "product", "", "displayDuration", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getRoomId", "g1", "", "getProgramId", "getRoomType", "e0", "", "g", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: bj4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C0130a {
        public static /* synthetic */ void a(a aVar, int i3, dj4.a aVar2, long j3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    j3 = 0;
                }
                aVar.A(i3, aVar2, j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doReport");
        }
    }

    void A(int event, @NotNull dj4.a product, long displayDuration);

    @NotNull
    String e0();

    boolean g();

    long g1();

    @NotNull
    String getProgramId();

    long getRoomId();

    int getRoomType();
}
