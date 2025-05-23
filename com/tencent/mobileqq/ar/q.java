package com.tencent.mobileqq.ar;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.mobileqq.olympic.activity.a f198550a;

    /* renamed from: b, reason: collision with root package name */
    public QQCustomDialog f198551b;

    /* renamed from: c, reason: collision with root package name */
    Context f198552c;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 != 0) {
                if (i3 == 1) {
                    QQToast.makeText(q.this.f198552c, 2, R.string.f170427qj, 0).show();
                    dialogInterface.dismiss();
                    ReportController.o(null, "dc00898", "", "", "0X8008353", "0X8008353", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            dialogInterface.dismiss();
        }
    }

    public q(Context context, com.tencent.mobileqq.olympic.activity.a aVar) {
        this.f198552c = context;
        this.f198550a = aVar;
        this.f198551b = DialogUtil.createCustomDialog(context, 230);
        a aVar2 = new a();
        this.f198551b.setPositiveButton(R.string.f170426qi, aVar2);
        this.f198551b.setNegativeButton(R.string.f170425qh, aVar2);
        this.f198551b.setMessage(R.string.f170428qk);
    }

    public void a() {
        if (!this.f198551b.isShowing()) {
            this.f198551b.show();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FaceUIController", 2, "doOnClickFeedBack");
        }
        ReportController.o(null, "dc00898", "", "", "0X8008352", "0X8008352", 0, 0, "", "", "", "");
    }
}
