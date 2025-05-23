package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a extends ReportDialog implements View.OnClickListener {
    private ImageView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private Context G;
    private MiniAppInfo H;
    private InterfaceC9438a I;

    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.sdk.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC9438a {
        void onResult(boolean z16);
    }

    public a(Context context) {
        super(context, R.style.mini_sdk_MiniAppAuthDialog);
        this.G = context;
        initView(context);
    }

    private void initView(Context context) {
        super.setContentView(LayoutInflater.from(context).inflate(R.layout.mini_sdk_apply_add_to_my_app_layout, (ViewGroup) null));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
        }
        this.C = (ImageView) findViewById(R.id.iv_app_icon);
        this.D = (TextView) findViewById(R.id.tv_app_name);
        this.E = (TextView) findViewById(R.id.tv_allowed);
        TextView textView = (TextView) findViewById(R.id.tv_refused);
        this.F = textView;
        textView.setOnClickListener(this);
        this.E.setOnClickListener(this);
    }

    public void N(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        this.H = miniAppInfo;
        Drawable drawable = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(this.G, miniAppInfo.iconUrl, 0, 0, null);
        if (drawable != null) {
            this.C.setImageDrawable(drawable);
        }
        this.D.setText(miniAppInfo.name);
    }

    public void O(InterfaceC9438a interfaceC9438a) {
        this.I = interfaceC9438a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.F) {
            InterfaceC9438a interfaceC9438a = this.I;
            if (interfaceC9438a != null) {
                interfaceC9438a.onResult(false);
            }
            dismiss();
            MiniAppInfo miniAppInfo = this.H;
            SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), null, "page_view", "em_click", "apply_add_myminiapp_no", "");
        } else if (view == this.E) {
            dismiss();
            InterfaceC9438a interfaceC9438a2 = this.I;
            if (interfaceC9438a2 != null) {
                interfaceC9438a2.onResult(true);
            }
            MiniAppInfo miniAppInfo2 = this.H;
            SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), null, "page_view", "em_click", "apply_add_myminiapp_yes", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        MiniAppInfo miniAppInfo = this.H;
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), null, "page_view", "pg_expo", "apply_add_myminiapp", "");
    }
}
