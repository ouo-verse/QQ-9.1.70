package j23;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.pay.page.j;
import com.tencent.mobileqq.vas.pay.page.o;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import du4.k;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u000e\u001a\u00020\u0006H\u0007R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lj23/e;", "", "", "d", "Ljava/util/Calendar;", "expiredCal", "", "b", "date1", "date2", "a", "Landroid/text/SpannableString;", "f", "c", "e", "Ldu4/k;", "Ldu4/k;", "g", "()Ldu4/k;", "vipState", "<init>", "(Ldu4/k;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k vipState;

    public e(@NotNull k vipState) {
        Intrinsics.checkNotNullParameter(vipState, "vipState");
        this.vipState = vipState;
    }

    private final int a(Calendar date1, Calendar date2) {
        date1.set(11, 0);
        date1.set(12, 0);
        date1.set(13, 0);
        date1.set(14, 0);
        date2.set(11, 0);
        date2.set(12, 0);
        date2.set(13, 0);
        date2.set(14, 0);
        return (int) ((date2.getTimeInMillis() - date1.getTimeInMillis()) / 86400000);
    }

    @RequiresApi(26)
    private final int b(Calendar expiredCal) {
        ChronoUnit chronoUnit;
        LocalDate now;
        LocalDate of5;
        long between;
        chronoUnit = ChronoUnit.DAYS;
        now = LocalDate.now();
        of5 = LocalDate.of(expiredCal.get(1), expiredCal.get(2) + 1, expiredCal.get(5));
        between = chronoUnit.between(now, of5);
        return (int) between;
    }

    private final String d() {
        String format = new SimpleDateFormat("yyyy.MM.dd", Locale.CHINA).format(Long.valueOf(this.vipState.f394995b * 1000));
        Intrinsics.checkNotNullExpressionValue(format, "dateFormat.format(vipState.expireTime * 1000)");
        return format;
    }

    public final int c() {
        int a16;
        Calendar expiredCal = Calendar.getInstance();
        expiredCal.setTime(new Date(this.vipState.f394995b * 1000));
        if (Build.VERSION.SDK_INT >= 26) {
            Intrinsics.checkNotNullExpressionValue(expiredCal, "expiredCal");
            a16 = b(expiredCal);
        } else {
            Calendar calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
            Intrinsics.checkNotNullExpressionValue(expiredCal, "expiredCal");
            a16 = a(calendar, expiredCal);
        }
        QLog.i("PersonalInfo", 1, "diff days is " + a16);
        return a16;
    }

    @ColorInt
    public final int e() {
        int i3 = this.vipState.f395000g;
        if (i3 != 0) {
            if (i3 != 2) {
                return Color.parseColor("#F74C30");
            }
            return Color.parseColor("#999999");
        }
        return Color.parseColor("#999999");
    }

    @NotNull
    public final SpannableString f() {
        int i3 = this.vipState.f395000g;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return new SpannableString("");
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(j.INSTANCE.e().getPerson().getAvaliableText(), Arrays.copyOf(new Object[]{d()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return new SpannableString(format);
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String expiredText = j.INSTANCE.e().getPerson().getExpiredText();
            int abs = Math.abs(c());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(abs);
            String format2 = String.format(expiredText, Arrays.copyOf(new Object[]{d(), sb5.toString()}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return new SpannableString(format2);
        }
        String str = j.INSTANCE.e().getPerson().getNewText() + "  ";
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = ContextCompat.getDrawable(BaseApplication.context, R.drawable.skin_more_arrow);
        if (drawable != null) {
            drawable.setBounds(0, 0, o.i(6), o.i(9));
            spannableString.setSpan(new ImageSpan(drawable, 1), str.length() - 1, str.length(), 17);
        }
        return spannableString;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final k getVipState() {
        return this.vipState;
    }
}
