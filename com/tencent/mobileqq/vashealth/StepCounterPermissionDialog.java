package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes20.dex */
public class StepCounterPermissionDialog extends ReportDialog implements View.OnClickListener {
    private t C;
    private final Context D;
    private final MMKVOptionEntity E;
    private RelativeLayout F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;

    public StepCounterPermissionDialog(@NonNull Context context) {
        super(context, R.style.azt);
        this.D = context;
        this.E = QMMKV.from(context, "common_mmkv_configurations");
        initView();
    }

    private void O(String str) {
        QQBeaconReport.reportWithAppKey(QQHealthReportApiImpl.APP_KEY, VasUtil.getCurrentUin(), str, a.f312206a.a());
    }

    private void adaptNightMode() {
        AppRuntime peekAppRuntime;
        Resources resources;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        int i3;
        if (this.F == null || this.G == null || this.I == null || this.J == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (resources = this.D.getResources()) == null) {
            return;
        }
        boolean isInNightMode = ThemeUtil.isInNightMode(peekAppRuntime);
        if (isInNightMode) {
            drawable = resources.getDrawable(R.drawable.lhg);
        } else {
            drawable = resources.getDrawable(R.drawable.lhf);
        }
        if (isInNightMode) {
            drawable2 = resources.getDrawable(R.drawable.lhi);
        } else {
            drawable2 = resources.getDrawable(R.drawable.lhh);
        }
        if (isInNightMode) {
            drawable3 = resources.getDrawable(R.drawable.lhk);
        } else {
            drawable3 = resources.getDrawable(R.drawable.lhj);
        }
        if (isInNightMode) {
            i3 = R.color.f158017al3;
        } else {
            i3 = R.color.black;
        }
        int color = resources.getColor(i3);
        this.F.setBackground(drawable);
        this.G.setTextColor(color);
        this.I.setTextColor(color);
        this.I.setBackground(drawable2);
        this.J.setBackground(drawable3);
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.D).inflate(R.layout.hqw, (ViewGroup) null);
        super.setContentView(inflate);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
        }
        this.F = (RelativeLayout) inflate.findViewById(R.id.bja);
        this.G = (TextView) inflate.findViewById(R.id.a19);
        this.H = (TextView) inflate.findViewById(R.id.f1061367w);
        this.I = (TextView) inflate.findViewById(R.id.f110606iz);
        this.J = (TextView) inflate.findViewById(R.id.f1059767g);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        adaptNightMode();
    }

    public void P(t tVar) {
        this.C = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.J) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.StepCounterPermissionDialog.1
                @Override // java.lang.Runnable
                public void run() {
                    StepCounterPermissionUtils.z(true);
                    if (StepCounterPermissionDialog.this.C != null) {
                        StepCounterPermissionDialog.this.C.b();
                    }
                }
            }, 16, null, true);
            O(QQHealthReportApiImpl.AUTH_BUTTON_CLICK);
        } else if (view == this.I) {
            StepCounterPermissionUtils.z(false);
            t tVar = this.C;
            if (tVar != null) {
                tVar.a();
            }
            O(QQHealthReportApiImpl.AUTH_BUTTON_REJECT_CLICK);
        }
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    public void showDialog() {
        if (this.G != null && this.H != null) {
            try {
                show();
                O(QQHealthReportApiImpl.AUTH_WINDOW_AUTH_EXPOSE);
                QLog.d("StepCounterPermissionDialog", 1, "showDialog success");
            } catch (Throwable th5) {
                QLog.e("StepCounterPermissionDialog", 1, "showDialog fail: " + th5);
            }
        }
    }
}
