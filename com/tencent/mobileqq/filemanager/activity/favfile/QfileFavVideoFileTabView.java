package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QfileFavVideoFileTabView extends QfileFavFileTabView {
    public QfileFavVideoFileTabView(Context context, QfileFavFileRecordProvider qfileFavFileRecordProvider, QfileBaseFavFileTabView.d dVar) {
        super(context, qfileFavFileRecordProvider, dVar);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        super.A();
        if (this.f206603d.p3()) {
            this.f206603d.U2().l0();
        } else {
            ReportController.o(this.f206604e, "dc00898", "", "", "0X800AFAA", "0X800AFAA", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView, com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView
    protected int K() {
        return 3;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileTabView
    protected void h0(boolean z16) {
        ReportController.o(this.f206604e, "dc00898", "", "", "0X800AFAB", "0X800AFAB", 0, 0, "", "", "", "");
    }
}
