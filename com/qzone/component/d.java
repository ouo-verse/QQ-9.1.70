package com.qzone.component;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends ReportDialog {
    public d(Context context, String str) {
        super(context, R.style.f174063on);
        setContentView(R.layout.f169003bk1);
        ((TextView) findViewById(R.id.title)).setText(str);
        getWindow().setFlags(1024, 2048);
    }
}
