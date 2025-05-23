package com.qzone.album.data.model;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import com.qzone.util.l;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.R;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TimeLine implements SmartParcelable {
    private final String TAG = "TimeLine";

    @NeedParcel
    public long beginTime = 0;

    @NeedParcel
    public long endTime = 0;

    @NeedParcel
    public int total = 0;

    @NeedParcel
    public int showTime = 0;

    @NeedParcel
    public int showYear = 0;

    @NeedParcel
    public int showMonth = 0;

    @NeedParcel
    public int showWeek = 0;

    @NeedParcel
    public int showDay = 0;

    @NeedParcel
    public Map<String, NS_MOBILE_PHOTO.TimeEvent> festivals = null;

    public SpannableStringBuilder toShowAgeSpanStr() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i3 = this.showYear;
        if (i3 == -1) {
            return appendSpan(spannableStringBuilder, "\u5b55\u671f", new AbsoluteSizeSpan(18, true));
        }
        if (i3 == 0 && this.showMonth == 0 && this.showDay == 0 && this.showWeek == 0) {
            return appendSpan(spannableStringBuilder, "\u51fa\u751f", new AbsoluteSizeSpan(18, true));
        }
        if (i3 > 0 && this.showMonth == 0 && this.showWeek == 0 && this.showDay == 0) {
            return appendSpan(appendSpan(spannableStringBuilder, "" + this.showYear, new AbsoluteSizeSpan(18, true)), "\u5c81\u751f\u65e5", new AbsoluteSizeSpan(12, true));
        }
        if (i3 == 0 && this.showMonth == 1 && this.showWeek == 0 && this.showDay == 0) {
            return appendSpan(spannableStringBuilder, "\u6ee1\u6708", new AbsoluteSizeSpan(18, true));
        }
        if (i3 == 0 && this.showMonth == 0 && this.showWeek > 0) {
            return appendSpan(appendSpan(spannableStringBuilder, "" + this.showWeek, new AbsoluteSizeSpan(18, true)), "\u5468", new AbsoluteSizeSpan(12, true));
        }
        if (i3 == 0 && this.showMonth == 0 && this.showWeek == 0 && this.showDay > 0) {
            return appendSpan(appendSpan(spannableStringBuilder, "" + this.showDay, new AbsoluteSizeSpan(18, true)), "\u5929", new AbsoluteSizeSpan(12, true));
        }
        if (i3 > 0) {
            spannableStringBuilder = appendSpan(appendSpan(spannableStringBuilder, "" + this.showYear, new AbsoluteSizeSpan(18, true)), "\u5c81", new AbsoluteSizeSpan(12, true));
        }
        if (this.showMonth > 0) {
            spannableStringBuilder = appendSpan(appendSpan(spannableStringBuilder, "" + this.showMonth, new AbsoluteSizeSpan(18, true)), "\u4e2a\u6708", new AbsoluteSizeSpan(12, true));
        }
        if (this.showDay <= 0) {
            return spannableStringBuilder;
        }
        return appendSpan(appendSpan(spannableStringBuilder, "" + this.showDay, new AbsoluteSizeSpan(18, true)), "\u5929", new AbsoluteSizeSpan(12, true));
    }

    public String toShowLoversDay() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i3 = this.showYear;
        if (i3 == 0 && this.showMonth == 0 && this.showDay == 0) {
            return l.a(R.string.f172782u61);
        }
        if (i3 == -1) {
            return l.a(R.string.f172783u62);
        }
        if (i3 > 0) {
            spannableStringBuilder.append((CharSequence) (this.showYear + "\u5e74"));
        }
        if (this.showMonth > 0) {
            spannableStringBuilder.append((CharSequence) (this.showMonth + "\u4e2a\u6708"));
        }
        if (this.showDay > 0) {
            spannableStringBuilder.append((CharSequence) (this.showDay + "\u5929"));
        }
        return spannableStringBuilder.toString();
    }

    public String toString() {
        return "(beginTime, " + this.beginTime + ")\n(endTime, " + this.endTime + ")\n(total, " + this.total + ")\n(showTime, " + this.showTime + ")\n(showYear, " + this.showYear + ")\n(showMonth, " + this.showMonth + ")\n(showWeek, " + this.showWeek + ")\n(showDay, " + this.showDay + ")\n++(festivals, " + this.festivals + ")++";
    }

    private SpannableStringBuilder appendSpan(SpannableStringBuilder spannableStringBuilder, String str, AbsoluteSizeSpan absoluteSizeSpan) {
        if (spannableStringBuilder == null) {
            return null;
        }
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(absoluteSizeSpan, length, str.length() + length, 33);
        return spannableStringBuilder;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof TimeLine) && this.showTime == ((TimeLine) obj).showTime;
    }

    public String toShowAgeStr(int i3) {
        if (i3 == 8) {
            int i16 = this.showYear;
            if (i16 == -1) {
                return l.a(R.string.u5m);
            }
            if (i16 == 0 && this.showMonth == 0 && this.showDay == 0 && this.showWeek == 0) {
                return l.a(R.string.u5s);
            }
            if (i16 > 0 && this.showMonth == 0 && this.showWeek == 0 && this.showDay == 0) {
                return this.showYear + l.a(R.string.u5u);
            }
            if (i16 == 0 && this.showMonth == 1 && this.showWeek == 0 && this.showDay == 0) {
                return l.a(R.string.u5v);
            }
            if (i16 == 0 && this.showMonth == 0 && this.showWeek > 0) {
                return this.showWeek + l.a(R.string.u5q);
            }
            if (i16 == 0 && this.showMonth == 0 && this.showWeek == 0 && this.showDay > 0) {
                return this.showDay + l.a(R.string.u5n);
            }
        } else if (i3 == 11) {
            int i17 = this.showYear;
            if (i17 == -1) {
                return l.a(R.string.u5y);
            }
            if (i17 == 0 && this.showMonth == 0 && this.showDay == 0 && this.showWeek == 0) {
                return l.a(R.string.u5p);
            }
            if (i17 > 0 && this.showMonth == 0 && this.showWeek == 0 && this.showDay == 0) {
                return this.showYear + l.a(R.string.u5x);
            }
            if (i17 == 0 && this.showMonth == 1 && this.showWeek == 0 && this.showDay == 0) {
                return l.a(R.string.u5t);
            }
            if (i17 == 0 && this.showMonth == 0 && this.showWeek > 0) {
                return this.showWeek + l.a(R.string.f172781u60);
            }
            if (i17 == 0 && this.showMonth == 0 && this.showWeek == 0 && this.showDay > 0) {
                return this.showDay + l.a(R.string.u5w);
            }
        }
        String str = "";
        if (this.showMonth > 0) {
            str = "" + String.valueOf(this.showMonth) + l.a(R.string.u5z);
        }
        if (this.showDay <= 0) {
            return str;
        }
        return str + String.valueOf(this.showDay) + l.a(R.string.u5r);
    }
}
