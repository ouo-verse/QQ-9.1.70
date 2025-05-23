package ae1;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import java.text.Bidi;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u0019J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0010\u0010\u0017R\u0011\u0010\u001d\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lae1/a;", "", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "end", "", "d", "Ljava/util/Locale;", "locale", "e", "", "b", UserInfo.SEX_FEMALE, "sDensity", "c", "sDensity4Fonts", "I", "sLeadingMarging", "Landroid/util/DisplayMetrics;", "()Landroid/util/DisplayMetrics;", "displayMetrics", "()I", "getLeadingMarging$annotations", "()V", "leadingMarging", "a", "()F", "displayDensity", "<init>", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f25933a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static float sDensity = Float.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static float sDensity4Fonts = Float.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int sLeadingMarging = -1;

    a() {
    }

    private final DisplayMetrics b() {
        Object systemService = BaseApplication.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static final int c() {
        if (sLeadingMarging == -1) {
            sLeadingMarging = Math.round(28 * f25933a.a());
        }
        return sLeadingMarging;
    }

    @JvmStatic
    public static final boolean d(@Nullable CharSequence s16, int start, int end) {
        if (s16 != null && s16.length() != 0) {
            if (start == end && (start = Math.max(0, start - 1)) == end) {
                end = Math.min(s16.length(), end + 1);
            }
            try {
                return !new Bidi(s16.subSequence(start, end).toString(), -2).baseIsLeftToRight();
            } catch (IndexOutOfBoundsException unused) {
                return false;
            }
        }
        a aVar = f25933a;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        return aVar.e(locale);
    }

    private final boolean e(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        if (directionality != 1 && directionality != 2) {
            return false;
        }
        return true;
    }

    public final float a() {
        boolean z16;
        float f16;
        synchronized (a.class) {
            if (sDensity == Float.MAX_VALUE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                sDensity = f25933a.b().density;
            }
            f16 = sDensity;
        }
        return f16;
    }
}
