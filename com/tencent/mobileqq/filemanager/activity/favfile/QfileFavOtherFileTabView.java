package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileFavOtherFileTabView extends QfileFavFileTabView {
    public QfileFavOtherFileTabView(Context context, QfileFavFileRecordProvider qfileFavFileRecordProvider, QfileBaseFavFileTabView.d dVar) {
        super(context, qfileFavFileRecordProvider, dVar);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        if (this.f206603d.p3()) {
            this.f206603d.U2().v();
        } else {
            ReportController.o(this.f206604e, "dc00898", "", "", "0X800AFB2", "0X800AFB2", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView, com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected int K() {
        return 5;
    }
}
