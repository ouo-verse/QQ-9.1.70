package com.qzone.feed.ui.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.aa;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.bk;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends aa implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private final AsyncImageView f47340d;

    /* renamed from: e, reason: collision with root package name */
    private final AsyncImageView f47341e;

    /* renamed from: f, reason: collision with root package name */
    private final TextView f47342f;

    /* renamed from: h, reason: collision with root package name */
    private final TextView f47343h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f47344i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f47345m;

    public e(View view) {
        super(view);
        AsyncImageView asyncImageView = (AsyncImageView) findViewById(R.id.hyu);
        this.f47340d = asyncImageView;
        AsyncImageView asyncImageView2 = (AsyncImageView) findViewById(R.id.hyq);
        this.f47341e = asyncImageView2;
        TextView textView = (TextView) findViewById(R.id.f166718i04);
        this.f47342f = textView;
        TextView textView2 = (TextView) findViewById(R.id.i0r);
        this.f47343h = textView2;
        asyncImageView2.setOnClickListener(this);
        if (i.H().p1()) {
            asyncImageView.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20200107144932_Av7a1libMF.png");
            asyncImageView2.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20200107152803_pBUNqhO6gG.png");
            textView.setTextColor(-1);
            textView2.setTextColor(-16748033);
            this.rootView.setBackgroundColor(-14737633);
        } else {
            asyncImageView.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20200107144932_qylHrAOrUI.png");
            asyncImageView2.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20200107152803_znJkKq625s.png");
            textView.setTextColor(-16578534);
            textView2.setTextColor(-11692801);
            this.rootView.setBackgroundColor(-1);
        }
        setOnClickListener(this);
    }

    public boolean e() {
        return this.f47344i;
    }

    public void f() {
        if (this.f47345m) {
            return;
        }
        QZLog.i("QZoneMyFeedNoticeHeader", "onExpose: ");
        g(1);
        this.f47345m = true;
    }

    public void h(String str, String str2) {
        QZLog.i("QZoneMyFeedNoticeHeader", "setText: " + str + " " + str2);
        if (TextUtils.isEmpty(str)) {
            str = "\u5f00\u542f\u6d88\u606f\u901a\u77e5\uff0c\u4e0d\u518d\u9519\u8fc7\u597d\u53cb\u4e92\u52a8";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "\u7acb\u5373\u8bbe\u7f6e";
        }
        this.f47342f.setText(str);
        this.f47343h.setText(str2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.hyq) {
            this.f47344i = true;
            NoticeBannerConfProxy.a().c();
            g(3);
        } else {
            Context context = this.rootView.getContext();
            context.startActivity(bk.a(context));
            g(2);
        }
        finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void g(int i3) {
        LpReportInfo_pf00064.allReport(252, i3);
    }
}
