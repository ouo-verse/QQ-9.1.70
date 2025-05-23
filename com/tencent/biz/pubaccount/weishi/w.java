package com.tencent.biz.pubaccount.weishi;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class w extends com.tencent.biz.subscribe.comment.p implements View.OnClickListener {
    private Context D;
    private TextView E;

    public w(Context context) {
        this(context, R.style.f173446dj);
    }

    private void P() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void Q(String str) {
        this.E.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.f125137l9 || id5 == R.id.f125397ly) {
            WSFollowBeaconReport.t();
            P();
        }
    }

    protected w(Context context, int i3) {
        super(context, i3);
        this.D = context;
        initView();
    }

    private void initView() {
        setContentView(R.layout.fvt);
        this.E = (TextView) findViewById(R.id.f125477m6);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.f125137l9);
        TextView textView = (TextView) findViewById(R.id.f125397ly);
        frameLayout.setOnClickListener(this);
        textView.setOnClickListener(this);
    }
}
