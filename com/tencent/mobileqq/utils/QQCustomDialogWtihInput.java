package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.lang.ref.SoftReference;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQCustomDialogWtihInput extends QQCustomDialog {
    private SoftReference<Context> C;
    private ClearableEditText D;
    private View E;
    private TextWatcher F;
    private long G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.utils.QQCustomDialogWtihInput$3, reason: invalid class name */
    /* loaded from: classes20.dex */
    public class AnonymousClass3 extends TimerTask {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            QQCustomDialogWtihInput.this.D.requestFocus();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Context context = (Context) QQCustomDialogWtihInput.this.C.get();
            if (context != null) {
                ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).toggleSoftInput(0, 2);
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fav_9030_119327898", true)) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.utils.cx
                        @Override // java.lang.Runnable
                        public final void run() {
                            QQCustomDialogWtihInput.AnonymousClass3.this.e();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307200d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f307200d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QLog.isColorLevel()) {
                QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick timeGap:" + (System.currentTimeMillis() - QQCustomDialogWtihInput.this.G) + " MANUFACTURER:" + Build.MANUFACTURER + " MODEL:" + DeviceInfoMonitor.getModel());
            }
            if (System.currentTimeMillis() - QQCustomDialogWtihInput.this.G < 800 && QQCustomDialogWtihInput.this.U()) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick skip");
                }
            } else {
                String obj = QQCustomDialogWtihInput.this.D.getText().toString();
                if (obj != null) {
                    if (!QQEmojiUtil.containsEmoji(obj) && !QQSysFaceUtil.containsExpression(obj)) {
                        if (QQCustomDialogWtihInput.this.F == null && 24 < obj.getBytes().length) {
                            Context context = (Context) QQCustomDialogWtihInput.this.C.get();
                            if (context != null) {
                                QQToast qQToast = new QQToast(context);
                                qQToast.setDuration(2000);
                                qQToast.setToastMsg(R.string.i39);
                                qQToast.show();
                            }
                        } else {
                            DialogInterface.OnClickListener onClickListener = this.f307200d;
                            if (onClickListener != null) {
                                onClickListener.onClick(QQCustomDialogWtihInput.this, 1);
                            }
                            QQCustomDialogWtihInput.this.dismiss();
                        }
                    } else {
                        Context context2 = (Context) QQCustomDialogWtihInput.this.C.get();
                        if (context2 != null) {
                            QQToast qQToast2 = new QQToast(context2);
                            qQToast2.setDuration(2000);
                            qQToast2.setToastMsg(R.string.i38);
                            qQToast2.show();
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QQCustomDialogWtihInput(Context context, int i3) {
        super(context, i3);
        this.F = null;
        this.C = new SoftReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U() {
        String str = Build.MANUFACTURER;
        if ("VIVO".equalsIgnoreCase(str)) {
            if (DeviceInfoMonitor.getModel().toUpperCase().contains("Y8") || DeviceInfoMonitor.getModel().toUpperCase().contains("V18")) {
                return true;
            }
            return false;
        }
        if ("HUAWEI".equalsIgnoreCase(str) && DeviceInfoMonitor.getModel().toUpperCase().contains("VOG-AL10")) {
            return true;
        }
        return false;
    }

    public EditText S() {
        return this.D;
    }

    public void W(int i3) {
        View view = this.E;
        if (view != null) {
            view.setVisibility(i3);
        }
    }

    public void X(String str) {
        if (str != null) {
            this.D.setText(str);
        }
    }

    public void Y(TextWatcher textWatcher) {
        if (textWatcher != null) {
            this.F = textWatcher;
            this.D.addTextChangedListener(textWatcher);
        }
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public String getInputValue() {
        return this.D.getText().toString();
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.D = (ClearableEditText) findViewById(R.id.input);
        this.E = findViewById(R.id.tjd);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public QQCustomDialog setPositiveButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(i3);
        AccessibilityUtil.p(this.rBtn, HardCodeUtil.qqStr(i3));
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new a(onClickListener));
        setSeperatorState();
        return this;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        Editable text = this.D.getText();
        if (text instanceof Spannable) {
            Selection.setSelection(text, text.length());
        }
        this.G = System.currentTimeMillis();
        Context context = this.C.get();
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101242", false);
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomDialogWtihInput", 2, "padOptSwitch = " + isSwitchOn);
        }
        if (isSwitchOn && context != null && PadUtil.a(context) == DeviceType.TABLET) {
            return;
        }
        if (this.D.isFocusable() || this.D.isFocusableInTouchMode()) {
            new BaseTimer().schedule(new AnonymousClass3(), 200L);
        }
    }
}
