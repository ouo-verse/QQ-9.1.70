package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.flashshow.util.v;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.aj;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends ReportDialog {
    private aj C;
    private final TextView D;
    private final TextView E;

    private aj N() {
        aj ajVar = new aj(getContext());
        ajVar.h(v.a(getContext(), 94.0f));
        ajVar.f(true);
        ajVar.r(-1711276033);
        ajVar.s(18);
        ajVar.p(true);
        ajVar.m(false);
        ajVar.e(0);
        ajVar.o(false);
        ajVar.j(-16722948);
        ajVar.k(872415231);
        ajVar.l(6);
        ajVar.n(true);
        ajVar.E = true;
        ajVar.A = 2;
        return ajVar;
    }

    public void O(View.OnClickListener onClickListener) {
        this.D.setOnClickListener(onClickListener);
    }

    public void P(String str) {
        this.E.setText(str);
    }

    public void Q(int i3) {
        aj ajVar = this.C;
        if (ajVar == null) {
            return;
        }
        ajVar.t();
        this.C.i(i3);
        this.C.q(i3 + "%");
    }

    public c(Context context) {
        super(context, R.style.qZoneInputDialog);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dnp);
        this.E = (TextView) findViewById(R.id.s3j);
        ImageView imageView = (ImageView) findViewById(R.id.f163767rw4);
        aj N = N();
        this.C = N;
        imageView.setImageDrawable(N);
        this.D = (TextView) findViewById(R.id.rp5);
    }
}
