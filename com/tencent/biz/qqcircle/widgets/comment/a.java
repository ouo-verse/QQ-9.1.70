package com.tencent.biz.qqcircle.widgets.comment;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends ReportDialog {
    private final Context C;

    public a(@NonNull Context context) {
        super(context);
        this.C = context;
    }

    public void N() {
        super.dismiss();
    }

    public void O() {
        super.show();
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(this.C);
        if (x16 != null) {
            x16.k(this);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(this.C);
        if (x16 != null) {
            x16.e(this);
        }
    }

    public a(@NonNull Context context, int i3) {
        super(context, i3);
        this.C = context;
    }
}
