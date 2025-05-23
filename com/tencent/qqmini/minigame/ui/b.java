package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b extends ReportDialog implements View.OnClickListener {
    private Activity C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private a J;
    private Button K;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        void onConfirmResult(boolean z16);
    }

    public b(Activity activity) {
        super(activity, R.style.mini_sdk_permission_dialog);
        this.C = activity;
        initView();
    }

    private void O(boolean z16) {
        a aVar = this.J;
        if (aVar != null) {
            aVar.onConfirmResult(z16);
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.mini_sdk_permission_confirm_layout, (ViewGroup) null);
        super.setContentView(inflate);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
        }
        this.D = (ImageView) inflate.findViewById(R.id.mini_app_icon);
        this.E = (TextView) inflate.findViewById(R.id.mini_app_name);
        this.F = (TextView) inflate.findViewById(R.id.auth_title);
        this.G = (TextView) inflate.findViewById(R.id.tv_auth_function);
        this.H = (TextView) inflate.findViewById(R.id.tv_refused);
        this.I = (TextView) inflate.findViewById(R.id.tv_allowed);
        this.K = (Button) inflate.findViewById(R.id.btn_settings);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.K.setOnClickListener(this);
    }

    public void N(String str, String str2, String str3, String str4, a aVar) {
        this.J = aVar;
        this.E.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            this.D.setImageDrawable(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(getContext(), URLDecoder.decode(str2), 0, 0, null));
        }
        this.F.setText(str3);
        this.G.setText(str4);
        Activity activity = this.C;
        if (activity != null && !activity.isFinishing()) {
            show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.I) {
            O(true);
        } else if (view == this.H) {
            O(false);
        }
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }
}
