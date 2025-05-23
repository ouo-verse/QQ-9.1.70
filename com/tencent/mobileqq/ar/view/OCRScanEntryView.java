package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanDaTongApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.current.AnimationQIMCircleProgress;

/* compiled from: P */
/* loaded from: classes11.dex */
public class OCRScanEntryView extends ScanEntryProviderView implements View.OnClickListener {
    private RelativeLayout F;
    private View G;
    private TextView H;
    private TextView I;
    private AnimationQIMCircleProgress J;
    private ImageView K;
    private boolean L;
    private volatile boolean M;

    public OCRScanEntryView(Context context, d dVar, boolean z16) {
        super(context, dVar);
        this.L = z16;
    }

    private void I(String str) {
        if (this.M) {
            QLog.e("AREngine_OCRScanEntryView", 1, "handleTakePhotoBtnClick, is in recognize! filePath: " + str);
            return;
        }
        this.M = true;
        if (q.p(str)) {
            ((IOCR) QRoute.api(IOCR.class)).startOcrPerformFragment((Activity) this.f198780f, str, 0, -1008, null, false);
            ReportController.o(null, "dc00898", "", "", "0X800AE06", "0X800AE06", 2, 0, "", "0", "0", "");
            this.M = false;
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.view.OCRScanEntryView.1
            @Override // java.lang.Runnable
            public void run() {
                String w3 = CameraProxy.v().w();
                if (q.p(w3)) {
                    ((IOCR) QRoute.api(IOCR.class)).startOcrPerformFragment((Activity) OCRScanEntryView.this.f198780f, w3, 0, -1008, null, false);
                    ReportController.o(null, "dc00898", "", "", "0X800AE06", "0X800AE06", 1, 0, "", "0", "0", "");
                }
                OCRScanEntryView.this.M = false;
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void E() {
        super.E();
        ((IScanDaTongApi) QRoute.api(IScanDaTongApi.class)).setPageParams((ScanTorchActivity) this.f198780f, this, IScanDaTongApi.PAGE_ID_OCR, this.L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.fcn && id5 != R.id.f166450zw3) {
            if (id5 == R.id.fch) {
                w();
            }
        } else {
            ReportController.o(null, "dc00898", "", "", "0X8009C80", "0X8009C80", 0, 0, "", "0", "0", "");
            I(null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void x(String str) {
        if (!q.p(str)) {
            QLog.d("AREngine_OCRScanEntryView", 1, String.format("doDealGalleryPicFile path: %s is not exist", str));
        } else {
            I(str);
        }
    }

    @Override // com.tencent.mobileqq.ar.view.ScanEntryProviderView
    public void z(Bundle bundle) {
        if (this.F == null) {
            this.F = (RelativeLayout) LayoutInflater.from(this.f198780f).inflate(R.layout.arc, (ViewGroup) null, false);
            addView(this.F, new FrameLayout.LayoutParams(-1, -1));
            RelativeLayout relativeLayout = this.F;
            this.f198781h = relativeLayout;
            View findViewById = relativeLayout.findViewById(R.id.fcp);
            this.G = findViewById;
            z81.e.d(this.f198780f, findViewById);
            this.J = (AnimationQIMCircleProgress) this.F.findViewById(R.id.fcn);
            this.K = (ImageView) this.F.findViewById(R.id.f166450zw3);
            this.H = (TextView) this.F.findViewById(R.id.fch);
            this.I = (TextView) this.F.findViewById(R.id.f166449zw2);
            if (this.L) {
                this.K.setVisibility(0);
                this.J.setVisibility(8);
                this.I.setTextSize(16.0f);
            }
            this.J.setBackgroundResource(R.drawable.ebv);
            this.J.setCenterView();
            this.J.changeMode(0);
            this.H.setOnClickListener(this);
            this.J.setOnClickListener(this);
            this.K.setOnClickListener(this);
        }
    }
}
