package com.tencent.gdtad.basics.adbox;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtAdBoxNoMoreDialog extends ReportDialog {
    private View C;

    public GdtAdBoxNoMoreDialog(@NonNull Context context) {
        super(context, R.style.avo);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.eci, (ViewGroup) getWindow().getDecorView(), false);
        this.C = inflate;
        setContentView(inflate);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.gdtad.basics.adbox.GdtAdBoxNoMoreDialog.1
            @Override // java.lang.Runnable
            public void run() {
                GdtAdBoxNoMoreDialog.this.dismiss();
            }
        }, 16, null, true, 3000L);
    }
}
