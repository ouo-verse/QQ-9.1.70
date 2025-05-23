package com.tencent.av.utils;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f extends ReportDialog {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            f.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f(Context context, boolean z16) {
        super(context, r2);
        int i3;
        if (z16) {
            i3 = R.style.f173523f9;
        } else {
            i3 = R.style.qZoneInputDialog;
        }
        init();
    }

    public void N(View view, boolean z16) {
        if (z16) {
            O();
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.gde);
        frameLayout.setOnClickListener(new a());
        if (view != null) {
            frameLayout.addView(view);
        }
    }

    void O() {
        findViewById(R.id.gdd).setOnClickListener(new b());
    }

    void init() {
        super.getWindow().setGravity(17);
        super.setContentView(R.layout.f168521zi);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }
}
