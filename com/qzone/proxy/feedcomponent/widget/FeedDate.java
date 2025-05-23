package com.qzone.proxy.feedcomponent.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDate extends TextView implements g {

    /* renamed from: h, reason: collision with root package name */
    public static int f50931h = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    boolean f50932d;

    /* renamed from: e, reason: collision with root package name */
    boolean f50933e;

    /* renamed from: f, reason: collision with root package name */
    int f50934f;

    public FeedDate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50933e = true;
        this.f50934f = 24;
        try {
            setTextColor(FeedGlobalEnv.g().getColor(20));
        } catch (Throwable th5) {
            Log.e("mars", "setTextColor ", th5);
        }
    }

    public static int c(Calendar calendar, Calendar calendar2) {
        Calendar calendar3 = Calendar.getInstance();
        Calendar calendar4 = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        long timeInMillis2 = calendar2.getTimeInMillis();
        if (timeInMillis < timeInMillis2) {
            calendar3.setTimeInMillis(timeInMillis);
            calendar4.setTimeInMillis(timeInMillis2);
        } else {
            calendar3.setTimeInMillis(timeInMillis2);
            calendar4.setTimeInMillis(timeInMillis);
        }
        int i3 = 0;
        while (calendar3.before(calendar4) && (calendar3.get(1) != calendar4.get(1) || calendar3.get(6) != calendar4.get(6))) {
            calendar3.add(6, 1);
            i3++;
        }
        return i3;
    }

    public void a(boolean z16) {
        this.f50933e = z16;
    }

    public boolean d() {
        return this.f50932d;
    }

    public void setData(long j3) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j3);
        int i3 = calendar2.get(1);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(6, -2);
        calendar3.set(11, 0);
        calendar3.set(12, 0);
        calendar3.set(13, 0);
        if (calendar2.before(calendar3)) {
            int i16 = f50931h;
            if (calendar.get(1) == i3) {
                i3 = i16;
            }
            setData(i3, calendar2.get(2) + 1, calendar2.get(5));
            return;
        }
        int b16 = b(calendar, calendar2);
        if (b16 == 0) {
            setData("\u4eca\u5929");
            return;
        }
        if (b16 == 1) {
            setData("\u6628\u5929");
            return;
        }
        if (b16 == 2) {
            setData("\u524d\u5929");
            return;
        }
        int i17 = f50931h;
        if (calendar.get(1) == i3) {
            i3 = i17;
        }
        setData(i3, calendar2.get(2) + 1, calendar2.get(5));
    }

    public void setDataForTodaysInHistoryFeed(long j3) {
        String valueOf;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        int i3 = calendar.get(1);
        int i16 = Calendar.getInstance().get(1);
        if (i3 == i16) {
            valueOf = "\u4eca";
        } else if (i3 + 1 == i16) {
            valueOf = "\u53bb";
        } else if (i3 + 2 == i16) {
            valueOf = "\u524d";
        } else {
            valueOf = String.valueOf(i3);
        }
        setData(valueOf + "\u5e74");
    }

    public void setSpan(SpannableStringBuilder spannableStringBuilder, int i3, int i16) {
        if (this.f50933e) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(24, true), i3, i16, 33);
        }
    }

    public void setSpanTextSize(int i3) {
        this.f50934f = i3;
    }

    public void setUsed(boolean z16) {
        this.f50932d = z16;
    }

    public static int b(Calendar calendar, Calendar calendar2) {
        int i3 = 0;
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return 0;
        }
        long timeInMillis = calendar.getTimeInMillis();
        long timeInMillis2 = calendar2.getTimeInMillis();
        if (timeInMillis < timeInMillis2) {
            return -1;
        }
        Calendar calendar3 = Calendar.getInstance();
        Calendar calendar4 = Calendar.getInstance();
        calendar3.setTimeInMillis(timeInMillis2);
        calendar4.setTimeInMillis(timeInMillis);
        while (calendar3.before(calendar4) && (calendar3.get(1) != calendar4.get(1) || calendar3.get(6) != calendar4.get(6))) {
            calendar3.add(6, 1);
            i3++;
            if (i3 == 3) {
                return -1;
            }
        }
        return i3;
    }

    @Override // com.qzone.proxy.feedcomponent.widget.g
    public void onRecycled() {
    }

    public void setData(String str) {
        this.f50932d = true;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        setSpan(spannableStringBuilder, 0, spannableStringBuilder.length());
        setText(spannableStringBuilder);
    }

    public void setData(int i3, int i16, int i17) {
        setData(i3 < 0 ? null : String.valueOf(i3), String.valueOf(i16), String.valueOf(i17));
    }

    public void setData(String str, String str2, String str3) {
        this.f50932d = true;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str).append("\u5e74");
            setSpan(spannableStringBuilder, 0, spannableStringBuilder.length() - 1);
        }
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str2).append("\u6708");
        setSpan(spannableStringBuilder, length, spannableStringBuilder.length() - 1);
        int length2 = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str3).append("\u65e5");
        setSpan(spannableStringBuilder, length2, spannableStringBuilder.length() - 1);
        setText(spannableStringBuilder);
    }
}
