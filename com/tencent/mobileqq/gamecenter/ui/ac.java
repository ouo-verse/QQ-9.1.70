package com.tencent.mobileqq.gamecenter.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ac extends ReportDialog {
    private String C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ac.this.dismiss();
            GameCenterUnissoHandler.N2().A3();
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(ac.this.C, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "208814", "", "", "20", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ac(Context context) {
        this(context, R.style.qZoneInputDialog);
    }

    private void O() {
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.7f);
    }

    private void initView() {
        findViewById(R.id.f95185ea).setOnClickListener(new a());
    }

    public ac P(String str) {
        if (str == null) {
            str = "";
        }
        this.C = str;
        return this;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (isShowing()) {
                super.dismiss();
            }
        } catch (Throwable th5) {
            QLog.e("ProfileGuideDialog", 1, "dismiss e:" + th5);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.f167598dv4);
        initView();
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.C, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "208813", "", "", "8", "");
    }

    public ac(Context context, int i3) {
        super(context, i3);
        this.C = "";
        O();
    }
}
