package com.tencent.biz.qqcircle.bizparts;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleProgress;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.richframework.thread.RFWThreadManager;

/* loaded from: classes4.dex */
public class QCircleRichMediaDownLoadPart extends Part {

    /* renamed from: d, reason: collision with root package name */
    private Dialog f82759d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleProgress f82760e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f82761f;

    /* renamed from: h, reason: collision with root package name */
    private Context f82762h;

    /* JADX INFO: Access modifiers changed from: private */
    public void C9() {
        Dialog dialog = this.f82759d;
        if (dialog != null && dialog.isShowing()) {
            try {
                this.f82759d.dismiss();
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9(boolean z16) {
        String string;
        QLog.d("QCircleRichMediaDownLoadPart", 2, "[downLoadResult] success: ", Boolean.valueOf(z16));
        Dialog dialog = this.f82759d;
        if (dialog != null && dialog.isShowing()) {
            if (z16) {
                E9(100);
            }
            C9();
            Context context = getContext();
            if (context == null) {
                return;
            }
            com.tencent.biz.qqcircle.j f16 = com.tencent.biz.qqcircle.j.f();
            if (z16) {
                string = context.getResources().getString(R.string.f182963hw);
            } else {
                string = context.getResources().getString(R.string.f182953hv);
            }
            f16.l(context, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(int i3) {
        QCircleProgress qCircleProgress = this.f82760e;
        if (qCircleProgress != null) {
            qCircleProgress.setProgress(i3);
        }
        TextView textView = this.f82761f;
        if (textView != null) {
            textView.setText(i3 + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F9() {
        if (this.f82759d == null) {
            ReportDialog reportDialog = new ReportDialog(getContext(), R.style.f173523f9);
            this.f82759d = reportDialog;
            reportDialog.setCanceledOnTouchOutside(true);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g5k, (ViewGroup) null);
            QCircleProgress qCircleProgress = (QCircleProgress) inflate.findViewById(R.id.f30930po);
            this.f82760e = qCircleProgress;
            if (qCircleProgress == null) {
                return;
            }
            qCircleProgress.setStrokeWidth(4.0f);
            this.f82760e.setBgAndProgressColor(20, Color.parseColor(TipsElementData.DEFAULT_COLOR), 90, Color.parseColor(TipsElementData.DEFAULT_COLOR));
            this.f82761f = (TextView) inflate.findViewById(R.id.f30920pn);
            this.f82759d.setContentView(inflate);
            this.f82759d.setCancelable(false);
        }
        this.f82761f.setText("0%");
        this.f82760e.setProgress(0.0f);
        if (!this.f82759d.isShowing()) {
            try {
                this.f82759d.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Context getContext() {
        Context context = this.f82762h;
        if (context == null) {
            return super.getContext();
        }
        return context;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QCircleRichMediaDownLoadPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(final String str, final Object obj) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart.1
            @Override // java.lang.Runnable
            public void run() {
                if ("rich_media_download_show".equals(str)) {
                    QCircleRichMediaDownLoadPart.this.F9();
                    return;
                }
                if ("rich_media_download_status".equals(str)) {
                    Object obj2 = obj;
                    if (obj2 instanceof Boolean) {
                        QCircleRichMediaDownLoadPart.this.D9(((Boolean) obj2).booleanValue());
                        return;
                    }
                    return;
                }
                if ("rich_meida_download_progress".equals(str)) {
                    Object obj3 = obj;
                    if (obj3 instanceof Integer) {
                        QCircleRichMediaDownLoadPart.this.E9(((Integer) obj3).intValue());
                        return;
                    }
                    return;
                }
                if ("rich_media_download_dimiss".equals(str)) {
                    QCircleRichMediaDownLoadPart.this.C9();
                }
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        Dialog dialog = this.f82759d;
        if (dialog != null && dialog.isShowing()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }
}
