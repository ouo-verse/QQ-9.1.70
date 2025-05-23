package com.tencent.open.filedownload.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WhiteListDownloadButton extends ApkFileDownloadButton {
    public WhiteListDownloadButton(Context context) {
        this(context, null);
    }

    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    protected String f(int i3) {
        if (i3 == 4) {
            return HardCodeUtil.qqStr(R.string.vlr);
        }
        return HardCodeUtil.qqStr(R.string.vls);
    }

    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    protected void o(String str, boolean z16) {
        if (z16) {
            if ("900".equals(str) || IndividuationPlugin.Business_Pendant.equals(str)) {
                QQAppInterface qQAppInterface = ((BaseActivity) getContext()).app;
                String str2 = this.C.f341570i;
                if (str2 == null) {
                    str2 = "";
                }
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X8009AC6", "0X8009AC6", 0, 0, "", "", str2, "");
            }
        }
    }

    public WhiteListDownloadButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WhiteListDownloadButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        j();
    }
}
