package cp1;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mtt.hippy.dom.node.TextNode;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcp1/c;", "", "", "f", "population", "", TextNode.MODE_TAIL, "", "a", "c", "b", "I", "e", "()I", "dp2", "getDp50", "dp50", "d", "getDp15", "dp15", "getGuildInfoLayoutMarginBottomToBanner", "guildInfoLayoutMarginBottomToBanner", "", "D", "guildCriticalValue", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f391536a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int dp2 = cx.a(2.0f);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int dp50 = cx.a(55.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int dp15 = cx.a(15.0f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final int guildInfoLayoutMarginBottomToBanner = (int) ((FontSettingManager.systemMetrics.density * 46.0f) + 0.5f);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static double guildCriticalValue = 10000.0d;

    c() {
    }

    public static /* synthetic */ CharSequence b(c cVar, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "\u6210\u5458";
        }
        return cVar.a(i3, str);
    }

    public static /* synthetic */ CharSequence d(c cVar, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "\u6210\u5458";
        }
        return cVar.c(i3, str);
    }

    @NotNull
    public final CharSequence a(int population, @NotNull String tail) {
        boolean z16;
        String valueOf;
        Intrinsics.checkNotNullParameter(tail, "tail");
        double d16 = population;
        double d17 = guildCriticalValue;
        if (d16 < d17) {
            SpannableString spannableString = new SpannableString(population + tail);
            spannableString.setSpan(new StyleSpan(1), 0, String.valueOf(population).length(), 18);
            return spannableString;
        }
        double d18 = d16 / d17;
        double d19 = d18 % 1;
        if (d19 == 0.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && d19 >= 0.1d) {
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            decimalFormat.setMaximumFractionDigits(1);
            valueOf = decimalFormat.format(d18);
        } else {
            valueOf = String.valueOf((int) d18);
        }
        SpannableString spannableString2 = new SpannableString(valueOf + "\u4e07" + tail);
        spannableString2.setSpan(new StyleSpan(1), 0, (valueOf + "\u4e07").length(), 18);
        return spannableString2;
    }

    @NotNull
    public final CharSequence c(int population, @NotNull String tail) {
        boolean z16;
        String valueOf;
        Intrinsics.checkNotNullParameter(tail, "tail");
        double d16 = population;
        double d17 = guildCriticalValue;
        if (d16 < d17) {
            return population + tail;
        }
        double d18 = d16 / d17;
        double d19 = d18 % 1;
        if (d19 == 0.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && d19 >= 0.1d) {
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            decimalFormat.setMaximumFractionDigits(1);
            valueOf = decimalFormat.format(d18);
        } else {
            valueOf = String.valueOf((int) d18);
        }
        return valueOf + "\u4e07" + tail;
    }

    public final int e() {
        return dp2;
    }

    public final int f() {
        return guildInfoLayoutMarginBottomToBanner;
    }
}
