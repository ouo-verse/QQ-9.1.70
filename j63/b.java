package j63;

import com.tencent.videocut.utils.r;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0001\u0004B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lj63/b;", "Lj63/d;", "", "timeUs", "a", "", "", "b", "scrollX", "perPx", "c", "unitValue", "<init>", "(F)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends d {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final SimpleDateFormat f409523c = new SimpleDateFormat("mm:ss", Locale.US);

    public b(float f16) {
        super(f16);
    }

    @Override // j63.d
    public float a(float timeUs) {
        r rVar = r.f384266a;
        long f16 = rVar.f(timeUs);
        return (((float) (f16 * 30)) / getUnitValue()) + (((timeUs - ((float) rVar.c(f16))) / 33333.332f) / getUnitValue());
    }

    @Override // j63.d
    @NotNull
    public String b(long timeUs) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt((((float) timeUs) % 1000000.0f) / 33333.332f);
        if (roundToInt != 0 && roundToInt != 30) {
            return roundToInt + "f";
        }
        String format = f409523c.format(Long.valueOf(r.f384266a.d(timeUs)));
        Intrinsics.checkNotNullExpressionValue(format, "{\n            DATE_FORMA\u2026usToMs(timeUs))\n        }");
        return format;
    }

    @Override // j63.d
    public float c(float scrollX, float perPx) {
        return (((scrollX / perPx) * getUnitValue()) * 1000000.0f) / 30;
    }
}
