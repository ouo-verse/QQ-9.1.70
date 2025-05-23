package com.tenpay.sdk.view;

import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CoverDialog extends ReportDialog {
    private static final String TAG = "CoverDialog";

    public CoverDialog(@NonNull Context context) {
        super(context, R.style.MenuDialogStyle);
        initWindow();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(Integer.MIN_VALUE);
        super.setContentView(frameLayout);
    }

    private void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }
}
