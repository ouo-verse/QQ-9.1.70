package pl3;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lpl3/a;", "Lol3/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", BdhLogUtil.LogTag.Tag_Req, "action", "", "a", "(Lol3/a;)V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public interface a<A extends ol3.a, R> {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: pl3.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C11027a {
        public static <A extends ol3.a, R> void a(@NotNull a<A, R> aVar, @NotNull A action) {
            Intrinsics.checkNotNullParameter(action, "action");
        }
    }

    void a(@NotNull A action);
}
