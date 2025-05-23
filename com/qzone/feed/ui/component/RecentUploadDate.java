package com.qzone.feed.ui.component;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import com.qzone.proxy.feedcomponent.widget.FeedDate;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RecentUploadDate extends FeedDate {
    public RecentUploadDate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.FeedDate
    public void setData(long j3) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j3);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(6, -2);
        calendar3.set(11, 0);
        calendar3.set(12, 0);
        calendar3.set(13, 0);
        long timeInMillis = calendar.getTimeInMillis() - j3;
        if (!calendar2.before(calendar3) && timeInMillis >= 0) {
            int c16 = FeedDate.c(calendar, calendar2);
            if (c16 == 0) {
                setData(l.a(R.string.svf));
                return;
            } else if (c16 == 1) {
                setData(l.a(R.string.svg));
                return;
            } else {
                if (c16 == 2) {
                    setData(l.a(R.string.sve));
                    return;
                }
                return;
            }
        }
        setData(FeedDate.f50931h, calendar2.get(2) + 1, calendar2.get(5));
    }

    @Override // com.qzone.proxy.feedcomponent.widget.FeedDate
    public void setSpan(SpannableStringBuilder spannableStringBuilder, int i3, int i16) {
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(17, true), i3, i16, 33);
    }

    @Override // com.qzone.proxy.feedcomponent.widget.FeedDate
    public void setData(String str) {
        setUsed(true);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        setSpan(spannableStringBuilder, 0, spannableStringBuilder.length());
        setText(spannableStringBuilder);
    }
}
