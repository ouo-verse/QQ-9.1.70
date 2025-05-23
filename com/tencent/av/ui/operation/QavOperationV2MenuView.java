package com.tencent.av.ui.operation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.QavFunctionPanel;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.k;
import com.tencent.av.ui.r;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import rw.c;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavOperationV2MenuView extends QavOperationBaseMenuView {
    private QavFunctionPanel C;
    private r D;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements k {
        a() {
        }

        @Override // com.tencent.av.ui.k
        public void b(View view) {
            QavOperationV2MenuView.this.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements QavFunctionPanel.b {
        b() {
        }

        @Override // com.tencent.av.ui.QavFunctionPanel.b
        public void dismiss() {
            QavOperationV2MenuView.this.r(false);
            QavOperationV2MenuView.this.setVisibility(8);
            long d16 = e.d();
            if (((QavMenuBaseView) QavOperationV2MenuView.this).f75039f != null) {
                ((QavMenuBaseView) QavOperationV2MenuView.this).f75039f.X0(d16, 0, true);
            }
        }
    }

    public QavOperationV2MenuView(Context context) {
        this(context, null);
    }

    private void l() {
        this.f75037d = "QavOperationV2MenuView_" + e.d();
        q(getContext());
    }

    private r p() {
        c cVar = this.f76180h;
        r rVar = null;
        if (cVar == null) {
            return null;
        }
        ArrayList<rw.a> b16 = cVar.b();
        if (b16 != null && b16.size() != 0) {
            rVar = new r();
            rVar.f76590a = new ArrayList();
            rVar.f76591b = new ArrayList();
            Iterator<rw.a> it = b16.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                rw.a next = it.next();
                if (next.h()) {
                    if (i3 < 4) {
                        rVar.f76590a.add(next);
                    } else {
                        rVar.f76591b.add(next);
                    }
                    i3++;
                }
            }
        }
        return rVar;
    }

    private void q(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fub, this);
        QavFunctionPanel qavFunctionPanel = (QavFunctionPanel) findViewById(R.id.f166478fi0);
        this.C = qavFunctionPanel;
        qavFunctionPanel.setPanelClickListener(new a());
        this.C.setOnDismissListener(new b());
        this.C.k(this.D);
        this.C.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z16) {
        VideoAppInterface videoAppInterface = this.f75038e;
        if (videoAppInterface != null) {
            videoAppInterface.k0(new Object[]{22204, Boolean.valueOf(z16)});
        }
    }

    @Override // com.tencent.av.ui.operation.QavOperationBaseMenuView, com.tencent.av.ui.QavMenuBaseView
    public void a(QavPanel qavPanel) {
        super.a(qavPanel);
    }

    @Override // com.tencent.av.ui.operation.QavOperationBaseMenuView, com.tencent.av.ui.QavMenuBaseView
    public void f(long j3, boolean z16) {
        super.f(j3, z16);
        if (z16) {
            if (QLog.isDevelopLevel()) {
                QLog.i(this.f75037d, 2, "onHide");
            }
            r(false);
            this.C.q();
        }
    }

    @Override // com.tencent.av.ui.operation.QavOperationBaseMenuView, com.tencent.av.ui.QavMenuBaseView
    public void g(long j3, boolean z16) {
        super.g(j3, z16);
        if (z16) {
            r(true);
            h();
            this.C.o();
        }
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    @SuppressLint({"ResourceType"})
    public void h() {
        super.h();
        r p16 = p();
        this.D = p16;
        s(p16);
    }

    public void s(r rVar) {
        this.C.r(rVar);
    }

    public void setClickActionListener(k kVar) {
        this.C.setPanelClickListener(kVar);
    }

    public QavOperationV2MenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QavOperationV2MenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        l();
    }
}
