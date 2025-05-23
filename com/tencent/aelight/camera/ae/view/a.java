package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.aelight.camera.ae.flashshow.util.v;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.aj;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends ReportDialog {
    private aj C;
    private final View D;

    private aj N() {
        aj ajVar = new aj(getContext());
        ajVar.h(v.a(getContext(), 56.0f));
        ajVar.f(true);
        ajVar.r(DownloadCardView.COLOR_APP_VERSION);
        ajVar.s(14);
        ajVar.p(true);
        ajVar.m(false);
        ajVar.e(0);
        ajVar.o(false);
        ajVar.j(-1);
        ajVar.k(1509949439);
        ajVar.l(4);
        ajVar.n(true);
        ajVar.E = true;
        ajVar.A = 2;
        return ajVar;
    }

    public void O(View.OnClickListener onClickListener) {
        this.D.setOnClickListener(onClickListener);
    }

    public void P(int i3) {
        aj ajVar = this.C;
        if (ajVar == null) {
            return;
        }
        ajVar.t();
        this.C.i(i3);
        this.C.q(i3 + "%");
    }

    public a(Context context) {
        super(context, R.style.qZoneInputDialog);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dmk);
        ImageView imageView = (ImageView) findViewById(R.id.f163767rw4);
        aj N = N();
        this.C = N;
        imageView.setImageDrawable(N);
        this.D = findViewById(R.id.rvm);
    }
}
