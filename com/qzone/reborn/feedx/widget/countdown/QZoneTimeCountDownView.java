package com.qzone.reborn.feedx.widget.countdown;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.util.c;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneTimeCountDownView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Handler f56017d;

    /* renamed from: e, reason: collision with root package name */
    private QzoneCountDownCircleView f56018e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f56019f;

    /* renamed from: h, reason: collision with root package name */
    private long f56020h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f56021i;

    /* renamed from: m, reason: collision with root package name */
    private static final String f56016m = i.H().T("QZoneSetting", "QzoneMoodDeleteTimeFormat", "hh:mm:ss \u540e\u6d88\u5931&hh:mm:ss \u540e\u6d88\u5931&hh:mm:ss \u540e\u6d88\u5931");
    private static final long C = i.H().S("QZoneSetting", "QzoneMoodDeleteRefreshTime", 1);

    public QZoneTimeCountDownView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f56017d.removeCallbacks(this.f56021i);
        if (this.f56020h - (i.H().B0() / 1000) <= 0) {
            return;
        }
        this.f56017d.postDelayed(this.f56021i, C * 1000);
    }

    private void g() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cho, (ViewGroup) null);
        this.f56018e = (QzoneCountDownCircleView) inflate.findViewById(R.id.mtd);
        this.f56019f = (TextView) inflate.findViewById(R.id.mte);
        addView(inflate, new FrameLayout.LayoutParams(-2, -1));
    }

    public void h() {
        Runnable runnable;
        Handler handler = this.f56017d;
        if (handler == null || (runnable = this.f56021i) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public QZoneTimeCountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QZoneTimeCountDownView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f56017d = new Handler(Looper.getMainLooper());
        this.f56021i = new Runnable() { // from class: com.qzone.reborn.feedx.widget.countdown.QZoneTimeCountDownView.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneTimeCountDownView.this.f56019f.setText(c.c(QZoneTimeCountDownView.this.f56020h - (i.H().B0() / 1000), QZoneTimeCountDownView.f56016m));
                QZoneTimeCountDownView.this.f56018e.invalidate();
                QZoneTimeCountDownView.this.f();
            }
        };
        g();
    }

    public void setData(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getUser() != null) {
            long j3 = businessFeedData.getFeedCommInfo().feedsDelTime;
            this.f56020h = j3;
            this.f56018e.setFeedDelTime(j3);
            f();
            return;
        }
        setVisibility(8);
    }
}
