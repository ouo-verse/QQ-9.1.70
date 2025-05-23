package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j extends ReportDialog {
    public j(@NonNull Context context) {
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
            QLog.e("CoverDialog", 1, e16, new Object[0]);
        }
    }
}
