package com.tencent.av.ui.part.base.panel;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.m;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends Part {

    /* renamed from: f, reason: collision with root package name */
    protected QavPanel f76370f;

    /* renamed from: e, reason: collision with root package name */
    protected Toast f76369e = null;

    /* renamed from: d, reason: collision with root package name */
    public final String f76368d = getClass().getSimpleName();

    public e(QavPanel qavPanel) {
        this.f76370f = qavPanel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A9(long j3, int i3) {
        QavPanel qavPanel;
        if (r.h0() == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (m.e.f76019f != i3 && m.e.f76018e != i3 && m.e.f76025l != i3 && (qavPanel = this.f76370f) != null) {
            qavPanel.X0(j3, 0, true);
        }
        if (m.e.f76018e == i3) {
            AVUtil.r("0X800BC0C", DataReport.v(f16), 1, "", "", "", "");
        }
    }

    public void B9(int i3, int i16, int i17) {
        if (getContext() == null) {
            return;
        }
        Toast toast = this.f76369e;
        if (toast != null) {
            toast.cancel();
        }
        this.f76369e = null;
        Context context = getContext();
        if (context != null) {
            try {
                if (i17 == 0) {
                    this.f76369e = QQToast.makeText(context, i3, i16).show();
                } else {
                    this.f76369e = QQToast.makeText(context, i3, i16).show(i17);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(this.f76368d, 2, "showToast-->can not show toast-->e=" + e16.getMessage());
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
    }

    public rw.a x9(int i3, long j3) {
        QavPanel qavPanel;
        if (getContext() == null) {
            QLog.w(this.f76368d, 1, "getOperationBtnItem, context is null, seq[" + j3 + "], menuItemId[" + i3 + "]");
            return null;
        }
        AVActivity aVActivity = (AVActivity) getActivity();
        if (aVActivity == null || aVActivity.isDestroyed() || (qavPanel = this.f76370f) == null) {
            return null;
        }
        rw.a M = qavPanel.M(i3);
        if (M != null) {
            return M;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f76368d, 1, "getOperationBtnItem, null, seq[" + j3 + "], menuItemId[" + i3 + "]");
        }
        return null;
    }

    public QavEffectBaseMenuView z9() {
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            return (QavEffectBaseMenuView) qavPanel.N(5);
        }
        return null;
    }

    public void onDestroy() {
        this.f76369e = null;
    }
}
