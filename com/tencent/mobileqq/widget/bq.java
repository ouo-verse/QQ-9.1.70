package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bq extends ReportDialog {
    private TextView C;

    public bq(Context context) {
        super(context, R.style.DialogNoBackground);
        getWindow().setFlags(16, 16);
        getWindow().setFlags(8, 8);
        getWindow().setGravity(17);
        setContentView(R.layout.b3f);
        this.C = (TextView) findViewById(R.id.toast_msg);
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            this.C.setTextColor(Color.parseColor("#FF737373"));
        }
        setCancelable(false);
    }

    public void N(String str) {
        this.C.setText(str);
    }
}
