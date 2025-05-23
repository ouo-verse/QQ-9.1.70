package com.tencent.mobileqq.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class h extends ReportDialog implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private AppRuntime C;
    private Context D;
    private boolean E;
    private TextView F;
    private TextView G;
    private CheckBox H;
    private TextView I;
    private TextView J;
    private a K;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(Dialog dialog, View view, boolean z16);
    }

    public h(Context context, AppRuntime appRuntime, boolean z16) {
        super(context, R.style.qZoneInputDialog);
        this.D = context;
        this.C = appRuntime;
        this.E = z16;
        O();
    }

    private void O() {
        setContentView(R.layout.ced);
        com.tencent.mobileqq.simpleui.c.f(this);
        com.tencent.mobileqq.simpleui.c.h(this);
        com.tencent.mobileqq.simpleui.c.d(this);
        this.F = (TextView) findViewById(R.id.dialogTitle);
        this.G = (TextView) findViewById(R.id.dialogText);
        this.H = (CheckBox) findViewById(R.id.checkBoxConfirm);
        this.I = (TextView) findViewById(R.id.dialogLeftBtn);
        this.J = (TextView) findViewById(R.id.dialogRightBtn);
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(HardCodeUtil.qqStr(R.string.lhx));
        }
        TextView textView2 = this.G;
        if (textView2 != null) {
            textView2.setText(HardCodeUtil.qqStr(R.string.lhw));
        }
        CheckBox checkBox = this.H;
        if (checkBox != null) {
            if (this.E) {
                checkBox.setVisibility(0);
                this.H.setText(HardCodeUtil.qqStr(R.string.lhy));
                this.H.setChecked(N(this.D, this.C.getCurrentUin()));
                this.H.setOnCheckedChangeListener(this);
            } else {
                checkBox.setVisibility(8);
                this.H.setChecked(false);
            }
        }
        TextView textView3 = this.I;
        if (textView3 != null) {
            textView3.setText(R.string.cancel);
            this.I.setOnClickListener(this);
        }
        TextView textView4 = this.J;
        if (textView4 != null) {
            textView4.setText(R.string.f171151ok);
            this.J.setOnClickListener(this);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    public boolean N(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("record_delete_roaming_setting_switch_" + str, false);
    }

    public boolean P() {
        CheckBox checkBox = this.H;
        if (checkBox != null) {
            return checkBox.isChecked();
        }
        return false;
    }

    public void Q(String str) {
        this.G.setText(str);
    }

    public void R(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("record_delete_roaming_setting_switch_" + str, z16);
        edit.apply();
    }

    public void S(a aVar) {
        this.K = aVar;
    }

    @Deprecated
    public void U(String str) {
        this.F.setText(str);
    }

    public void W(int i3) {
        super.show();
        ReportController.o(this.C, "dc00898", "", "", "0X800A363", "0X800A363", i3, 0, "1", "", "", "");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.E) {
            if (this.H.isChecked()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
        } else {
            i3 = 3;
        }
        int i16 = i3;
        int id5 = view.getId();
        if (id5 == R.id.dialogLeftBtn) {
            QLog.i("DeleteRecordDialog", 1, "onClick cancel btn");
            dismiss();
            ReportController.o(this.C, "dc00898", "", "", "0X800A365", "0X800A365", i16, 0, "1", "", "", "");
        } else if (id5 == R.id.dialogRightBtn) {
            QLog.i("DeleteRecordDialog", 1, "onClick confirm btn");
            a aVar = this.K;
            if (aVar != null) {
                aVar.a(this, view, P());
                if (this.E) {
                    R(this.D, this.C.getCurrentUin(), this.H.isChecked());
                }
                dismiss();
            }
            ReportController.o(this.C, "dc00898", "", "", "0X800A364", "0X800A364", i16, 0, "1", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
    }
}
