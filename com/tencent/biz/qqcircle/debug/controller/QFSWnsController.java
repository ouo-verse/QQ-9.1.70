package com.tencent.biz.qqcircle.debug.controller;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$MultipleStateKey;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSWnsController extends com.tencent.qcircle.cooperation.config.debug.a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f84180b = QCircleDebugKey$MultipleStateKey.QCIRCLE_SCHEME_CONTROLLER.name();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f84182d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EditText f84183e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ EditText f84184f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Dialog f84185h;

        a(EditText editText, EditText editText2, EditText editText3, Dialog dialog) {
            this.f84182d = editText;
            this.f84183e = editText2;
            this.f84184f = editText3;
            this.f84185h = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = this.f84182d.getText().toString();
            String obj2 = this.f84183e.getText().toString();
            String obj3 = this.f84184f.getText().toString();
            if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj2) && !TextUtils.isEmpty(obj3)) {
                QzoneConfig.getInstance().updateOneConfig(obj, obj2, obj3);
                QCircleToast.o("\u4fee\u6539\u5b8c\u6210\uff0c\u5f53\u524d\u503c\u4e3a:" + QzoneConfig.getInstance().getConfig(obj, obj2, ""), 0);
                this.f84185h.dismiss();
            } else {
                QCircleToast.o("\u8bf7\u8865\u5168\u8f93\u5165", 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.setTextIsSelectable(true);
        editText.requestFocus();
        ((InputMethodManager) editText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(editText, 0);
    }

    private void i() {
        if (a() != null && a().get() != null) {
            ReportDialog reportDialog = new ReportDialog(a().get().getContext(), R.style.f173523f9);
            reportDialog.setCanceledOnTouchOutside(false);
            reportDialog.setContentView(R.layout.gtz);
            TextView textView = (TextView) reportDialog.findViewById(R.id.f94545ck);
            EditText editText = (EditText) reportDialog.findViewById(R.id.f95345eq);
            final EditText editText2 = (EditText) reportDialog.findViewById(R.id.f95695fo);
            EditText editText3 = (EditText) reportDialog.findViewById(R.id.f95845g3);
            editText.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f185513os));
            textView.setOnClickListener(new a(editText, editText2, editText3, reportDialog));
            reportDialog.getWindow().clearFlags(131072);
            reportDialog.show();
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.debug.controller.QFSWnsController.2
                @Override // java.lang.Runnable
                public void run() {
                    QFSWnsController.this.h(editText2);
                }
            }, 1000L);
        }
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String d() {
        return f84180b;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public String e() {
        return com.tencent.biz.qqcircle.utils.h.a(R.string.f185523ot);
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(View view) {
        i();
    }
}
