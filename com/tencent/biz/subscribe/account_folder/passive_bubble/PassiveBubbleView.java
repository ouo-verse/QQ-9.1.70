package com.tencent.biz.subscribe.account_folder.passive_bubble;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes5.dex */
public class PassiveBubbleView extends LinearLayout implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private TextView f95595d;

    public PassiveBubbleView(Context context) {
        super(context);
        b(context);
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6) {
        ReportController.o(null, "dc00898", "", "", str, str2, 0, 0, str3, str4, str5, str6);
    }

    protected void b(Context context) {
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.drawable.f160413gv);
        View.inflate(context, R.layout.f167699el, this);
        this.f95595d = (TextView) findViewById(R.id.eqt);
        setOnClickListener(this);
    }

    protected void c() {
        d.l("https://h5.qzone.qq.com/subscription/messagelist?_proxy=1&_wv=1&_wwv=4");
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        c();
        a("auth_page", "msg_clk", "", "", "", "");
        EventCollector.getInstance().onViewClicked(view);
    }

    public PassiveBubbleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public PassiveBubbleView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(context);
    }
}
