package com.tencent.biz.qqcircle.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppInterfaceUtil;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* loaded from: classes5.dex */
public class QCircleProgressDialog extends ReportDialog {
    private Context C;
    private LayoutInflater D;
    private View E;
    private TextView F;
    private ImageView G;
    private Animatable H;
    private LinearLayout I;
    private int J;
    private int K;
    private int L;
    String M;

    public QCircleProgressDialog(Context context) {
        this(context, 0);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            QCirclePluginUtil.fixMesssageLeak(this);
            throw th5;
        }
        QCirclePluginUtil.fixMesssageLeak(this);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (TextUtils.isEmpty(this.M)) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        if (QCircleHostConstants._AppSetting.enableTalkBack()) {
            HostAppInterfaceUtil.speak(this.M);
            return true;
        }
        return true;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setContentView(this.E);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = this.L;
        attributes.gravity = this.K;
        attributes.y += this.J;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        this.G.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleProgressDialog.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleProgressDialog.this.H.start();
            }
        }, 50L);
        super.onStart();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        if (this.H.isRunning()) {
            this.H.stop();
        }
        super.onStop();
    }

    public void setMessage(int i3) {
        this.F.setText(i3);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        Context context = this.C;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        super.show();
    }

    public QCircleProgressDialog(Context context, int i3) {
        this(context, i3, R.layout.g57, 48);
    }

    public QCircleProgressDialog(Context context, int i3, int i16, int i17) {
        super(context, R.style.f174242az2);
        this.L = -2;
        this.C = context;
        LayoutInflater from = LayoutInflater.from(context);
        this.D = from;
        View inflate = from.inflate(i16, (ViewGroup) null);
        this.E = inflate;
        this.I = (LinearLayout) inflate.findViewById(R.id.lac);
        this.F = (TextView) this.E.findViewById(R.id.f18);
        this.J = i3;
        this.K = i17;
        ImageView imageView = (ImageView) this.E.findViewById(R.id.jnn);
        this.G = imageView;
        this.H = (Animatable) imageView.getDrawable();
    }
}
