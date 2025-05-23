package com.tencent.open.filedownload.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
/* loaded from: classes22.dex */
public class NormalDownloadButton extends ApkFileDownloadButton {
    public NormalDownloadButton(Context context) {
        super(context);
    }

    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    protected String f(int i3) {
        if (i3 == 4) {
            return HardCodeUtil.qqStr(R.string.oru);
        }
        return HardCodeUtil.qqStr(R.string.ors);
    }

    @Override // com.tencent.open.filedownload.ui.ApkFileDownloadButton
    protected String g(int i3) {
        return HardCodeUtil.qqStr(R.string.ort);
    }

    public NormalDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NormalDownloadButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
