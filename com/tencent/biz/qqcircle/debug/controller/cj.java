package com.tencent.biz.qqcircle.debug.controller;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$MultipleStateKey;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class cj extends com.tencent.qcircle.cooperation.config.debug.a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f84251b = QCircleDebugKey$MultipleStateKey.QCIRCLE_QIMEI_CONTROLLER.name();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f84252d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f84253e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Dialog f84254f;

        a(Context context, String str, Dialog dialog) {
            this.f84252d = context;
            this.f84253e = str;
            this.f84254f = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.qqcircle.utils.s.a(this.f84252d, this.f84253e);
            QCircleToast.h(R.string.f189313z2, 0);
            this.f84254f.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void g() {
        if (a() != null && a().get() != null && a().get().getContext() != null) {
            Context context = a().get().getContext();
            ReportDialog reportDialog = new ReportDialog(context, R.style.f173523f9);
            reportDialog.setCanceledOnTouchOutside(false);
            reportDialog.setContentView(R.layout.g_l);
            TextView textView = (TextView) reportDialog.findViewById(R.id.f365014q);
            TextView textView2 = (TextView) reportDialog.findViewById(R.id.f365614w);
            String c16 = com.tencent.mobileqq.statistics.o.c();
            textView2.setText(c16);
            textView.setOnClickListener(new a(context, c16, reportDialog));
            reportDialog.getWindow().clearFlags(131072);
            reportDialog.show();
        }
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84251b;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f182943hu);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        g();
    }
}
