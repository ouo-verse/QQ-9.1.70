package com.tencent.mobileqq.vashealth.huaweistep;

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
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vashealth.StepCounterPermissionUtils;
import com.tencent.mobileqq.vashealth.honorstep.g;
import com.tencent.mobileqq.vashealth.honorstep.h;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import m43.b;
import m43.c;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DeviceStepRequestAuthDialog extends ReportDialog implements View.OnClickListener {
    private static final String TAG = "DeviceStepRequestAuthDialog";
    private TextView mBottomContent;
    private TextView mContent;
    private final Context mContext;
    private RelativeLayout mDialogRoot;
    private final MMKVOptionEntity mEntity;
    private volatile boolean mHasRequestedAuth;
    private final int mSystemType;
    private TextView mTvAllowed;
    private TextView mTvRefused;
    private TextView mTvTitle;

    public DeviceStepRequestAuthDialog(@NonNull Context context) {
        super(context, R.style.azt);
        this.mHasRequestedAuth = false;
        this.mSystemType = g.f312292a.m();
        this.mContext = context;
        this.mEntity = QMMKV.from(context, "common_mmkv_configurations");
        initView();
    }

    private void adaptNightMode() {
        AppRuntime peekAppRuntime;
        Resources resources;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        int i3;
        if (this.mDialogRoot == null || this.mTvTitle == null || this.mTvRefused == null || this.mTvAllowed == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (resources = this.mContext.getResources()) == null) {
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
        this.mDialogRoot.setBackground(drawable);
        this.mTvTitle.setTextColor(color);
        this.mTvRefused.setTextColor(color);
        this.mTvRefused.setBackground(drawable2);
        this.mTvAllowed.setBackground(drawable3);
    }

    private boolean allowRequestAuthPopUp() {
        float f16;
        boolean z16;
        boolean z17;
        boolean z18;
        int i3 = this.mSystemType;
        boolean z19 = false;
        if (i3 == 1) {
            f16 = (float) this.mEntity.decodeLong("recent_request_qq_health_honor_permission_time", 0L);
            z16 = this.mEntity.decodeBool("request_honor_health_permission", false);
        } else if (i3 == 2) {
            f16 = (float) this.mEntity.decodeLong("recent_request_huawei_health_permission_time", 0L);
            z16 = this.mEntity.decodeBool("request_huawei_health_permission", false);
        } else if (i3 == 3) {
            f16 = (float) this.mEntity.decodeLong("recent_request_qq_health_oppo_permission_time", 0L);
            z16 = this.mEntity.decodeBool("oppo_heytap_step_permission", false);
        } else {
            f16 = 0.0f;
            z16 = false;
        }
        float decodeLong = (float) this.mEntity.decodeLong("recent_request_qq_health_permission_time", 0L);
        QLog.d(TAG, 1, "isHasHuaWeiSdkPermission: " + z16);
        if (((float) System.currentTimeMillis()) - f16 > 8.64E7f) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.d(TAG, 1, "isHuaWeiPermissionTimeAllow: " + z17);
        if (((float) System.currentTimeMillis()) - decodeLong > 8.64E7f) {
            z18 = true;
        } else {
            z18 = false;
        }
        QLog.d(TAG, 1, "isQQPermissionTimeAllow: " + z18);
        if (!z16 && z17 && z18) {
            z19 = true;
        }
        QLog.d(TAG, 1, "allowRequestAuthPopUp: " + z19);
        return z19;
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.faa, (ViewGroup) null);
        super.setContentView(inflate);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
        }
        this.mDialogRoot = (RelativeLayout) inflate.findViewById(R.id.bja);
        this.mTvTitle = (TextView) inflate.findViewById(R.id.a19);
        this.mContent = (TextView) inflate.findViewById(R.id.f1061367w);
        this.mTvRefused = (TextView) inflate.findViewById(R.id.f110606iz);
        this.mTvAllowed = (TextView) inflate.findViewById(R.id.f1059767g);
        this.mBottomContent = (TextView) inflate.findViewById(R.id.f1061267v);
        this.mTvRefused.setOnClickListener(this);
        this.mTvAllowed.setOnClickListener(this);
        adaptNightMode();
    }

    private boolean isStepCounterEnable() {
        if (this.mSystemType == 2) {
            return StepCounterPermissionUtils.k();
        }
        return true;
    }

    private void recordHuaWeiPermissionTime() {
        this.mEntity.encodeLong("recent_request_huawei_health_permission_time", System.currentTimeMillis());
    }

    private void recordQQHealthPermissionTime() {
        this.mEntity.encodeLong("recent_request_qq_health_permission_time", System.currentTimeMillis());
    }

    private void setElementVisible() {
        String str;
        int i3 = this.mSystemType;
        if (i3 == 1) {
            this.mContent.setText(R.string.f159071rb);
            str = "\u300cQQ\u8fd0\u52a8\u300d\u7533\u8bf7\u8363\u8000\u8fd0\u52a8\u5065\u5eb7\u6743\u9650";
        } else if (i3 == 2) {
            if (this.mHasRequestedAuth) {
                str = "\u300cQQ\u8fd0\u52a8\u300d\u7533\u8bf7\u534e\u4e3a\u8fd0\u52a8\u5065\u5eb7\u6743\u9650";
            } else {
                str = "\u300cQQ\u8fd0\u52a8\u300d\u6253\u5f00\u534e\u4e3a\u8fd0\u52a8\u5065\u5eb7\u670d\u52a1";
            }
            this.mContent.setText(R.string.f159271rv);
        } else if (i3 == 3) {
            this.mContent.setText(R.string.f173062s5);
            str = "\u300cQQ\u8fd0\u52a8\u300d\u7533\u8bf7OPPO\u5065\u5eb7\u6743\u9650";
        } else {
            str = "";
        }
        this.mTvTitle.setText(str);
        if (!this.mHasRequestedAuth) {
            this.mTvAllowed.setText("\u597d\u7684");
            this.mTvRefused.setText("\u4e0d\u518d\u63d0\u9192");
            this.mContent.setText(R.string.f159301ry);
            this.mBottomContent.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.mTvAllowed) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.huaweistep.DeviceStepRequestAuthDialog.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DeviceStepRequestAuthDialog.this.mSystemType == 1) {
                        h.f312298a.a(0, true);
                    } else if (DeviceStepRequestAuthDialog.this.mSystemType == 2) {
                        HuaweiStepManager.getInstance().queryHuaWeiSdkTodaySteps(0, true);
                    } else if (DeviceStepRequestAuthDialog.this.mSystemType == 3) {
                        b.f416141a.i();
                    }
                }
            }, 16, null, true);
        } else if (view == this.mTvRefused) {
            int i3 = this.mSystemType;
            if (i3 == 1) {
                this.mEntity.encodeLong("recent_request_qq_health_honor_permission_time", System.currentTimeMillis());
                StepCounterPermissionUtils.n(false);
            } else if (i3 == 2) {
                recordHuaWeiPermissionTime();
                StepCounterPermissionUtils.p(false);
            } else if (i3 == 3) {
                this.mEntity.encodeLong("recent_request_qq_health_oppo_permission_time", System.currentTimeMillis());
                c.f416147a.f(false);
            }
            QQToast.makeText(QBaseActivity.sTopActivity, 1, "\u6388\u6743\u5931\u8d25", 0).show();
        }
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    public void showDialog() {
        if (this.mTvTitle != null && this.mContent != null && this.mBottomContent != null && allowRequestAuthPopUp()) {
            this.mHasRequestedAuth = isStepCounterEnable();
            setElementVisible();
            try {
                show();
                QLog.d(TAG, 1, "showDialog success");
                recordQQHealthPermissionTime();
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "showDialog fail: " + th5);
            }
        }
    }
}
