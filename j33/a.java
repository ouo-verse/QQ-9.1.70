package j33;

import android.graphics.Color;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u0011\u0010\n\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0014\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lj33/a;", "", "", "color", "", "a", "", h.F, "g", "()I", "text_primary", "f", "qqsvip_text_primary", "d", "qqsvip_qqcard_button_border_default", "e", "qqsvip_qqcard_button_text_default", "c", "qqsvip_qqcard_button_bg_default", "b", "qqsvip_color_gold_02", "<init>", "()V", "vas_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f409200a = new a();

    a() {
    }

    private final int a(long color) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String l3 = Long.toString(color, checkRadix);
        Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
        return Color.parseColor("#" + l3);
    }

    public final int b() {
        long j3;
        if (!h()) {
            j3 = 4294768106L;
        } else {
            j3 = 4280227853L;
        }
        return a(j3);
    }

    public final int c() {
        h();
        return a(4294956089L);
    }

    public final int d() {
        h();
        return a(16777215L);
    }

    public final int e() {
        h();
        return a(4278190080L);
    }

    public final int f() {
        long j3;
        if (!h()) {
            j3 = 4286729998L;
        } else {
            j3 = 4293769836L;
        }
        return a(j3);
    }

    public final int g() {
        long j3;
        if (!h()) {
            j3 = 4279901214L;
        } else {
            j3 = 4293980404L;
        }
        return a(j3);
    }

    public final boolean h() {
        return QQTheme.isNowThemeIsNight();
    }
}
