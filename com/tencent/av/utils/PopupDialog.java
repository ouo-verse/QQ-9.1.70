package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.BaseActivity;

/* loaded from: classes3.dex */
public class PopupDialog extends BaseActivity {

    /* renamed from: f, reason: collision with root package name */
    static c f76713f = new c();

    /* renamed from: d, reason: collision with root package name */
    QQCustomDialog f76714d = null;

    /* renamed from: e, reason: collision with root package name */
    boolean f76715e = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DialogInterface.OnClickListener onClickListener = PopupDialog.f76713f.f76727g;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            dialogInterface.dismiss();
            PopupDialog.g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            DialogInterface.OnClickListener onClickListener = PopupDialog.f76713f.f76728h;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i3);
            }
            dialogInterface.dismiss();
            PopupDialog.g0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: i, reason: collision with root package name */
        static PopupDialog f76720i;

        /* renamed from: a, reason: collision with root package name */
        boolean f76721a = false;

        /* renamed from: b, reason: collision with root package name */
        int f76722b;

        /* renamed from: c, reason: collision with root package name */
        String f76723c;

        /* renamed from: d, reason: collision with root package name */
        String f76724d;

        /* renamed from: e, reason: collision with root package name */
        int f76725e;

        /* renamed from: f, reason: collision with root package name */
        int f76726f;

        /* renamed from: g, reason: collision with root package name */
        DialogInterface.OnClickListener f76727g;

        /* renamed from: h, reason: collision with root package name */
        DialogInterface.OnClickListener f76728h;

        c() {
        }
    }

    public static void g0() {
        if (QLog.isColorLevel()) {
            QLog.d("PopupDialog", 2, "hideCustomDialog");
        }
        f76713f.f76721a = false;
        PopupDialog popupDialog = c.f76720i;
        if (popupDialog != null) {
            popupDialog.finish();
            c.f76720i = null;
        }
    }

    private void j0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("PopupDialog", 2, "sendIsResumeBroadcast isResume = " + z16);
        }
        if (this.f76715e) {
            SmallScreenUtils.A(BaseApplication.getContext(), z16);
        }
    }

    public static void k0(Context context, int i3, String str, String str2, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        g0();
        Intent intent = new Intent(context, (Class<?>) PopupDialog.class);
        intent.putExtra("invoke_type", "init");
        intent.addFlags(268435456);
        if (QLog.isColorLevel()) {
            QLog.d("PopupDialog", 2, "showCustomDialog");
        }
        c cVar = f76713f;
        cVar.f76721a = true;
        cVar.f76722b = i3;
        cVar.f76723c = str;
        cVar.f76724d = str2;
        cVar.f76725e = i16;
        cVar.f76726f = i17;
        cVar.f76727g = onClickListener2;
        cVar.f76728h = onClickListener;
        context.startActivity(intent);
    }

    public static void l0(Context context, int i3, String str, String str2, int i16, int i17, final DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2) {
        boolean z16;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i3);
        bundle.putString("titleText", str);
        bundle.putString("contentText", str2);
        bundle.putInt("leftBtnText", i16);
        bundle.putInt("rightBtnText", i17);
        boolean z17 = false;
        if (onClickListener2 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle.putBoolean("leftBtnVisiable", z16);
        if (onClickListener != null) {
            z17 = true;
        }
        bundle.putBoolean("rightBtnVisiable", z17);
        if (onClickListener != null || onClickListener2 != null) {
            bundle.putParcelable("resultReceiver", new ResultReceiver(new Handler()) { // from class: com.tencent.av.utils.PopupDialog.1
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i18, Bundle bundle2) {
                    DialogInterface.OnClickListener onClickListener3;
                    if (i18 == 0) {
                        DialogInterface.OnClickListener onClickListener4 = onClickListener2;
                        if (onClickListener4 != null) {
                            onClickListener4.onClick(null, i18);
                            return;
                        }
                        return;
                    }
                    if (i18 == 1 && (onClickListener3 = onClickListener) != null) {
                        onClickListener3.onClick(null, i18);
                    }
                }
            });
        }
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra(Const.BUNDLE_KEY_REQUEST, bundle);
        intent.addFlags(268435456);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, PopupDialogQQSide.class);
    }

    public static QQCustomDialog m0(Context context, int i3, String str, String str2, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = null;
        try {
            try {
                if (context != BaseApplication.getContext()) {
                    qQCustomDialog = DialogUtil.createCustomDialog(context, 230, str, str2, i16, i17, onClickListener, onClickListener2);
                    qQCustomDialog.show();
                } else {
                    k0(context, i3, str, str2, i16, i17, onClickListener, onClickListener2);
                }
            } catch (Exception unused) {
                k0(context, i3, str, str2, i16, i17, onClickListener, onClickListener2);
                return qQCustomDialog;
            }
        } catch (Exception unused2) {
        }
        return qQCustomDialog;
    }

    public static void n0(Context context, int i3, int i16, int i17, int i18, DialogInterface.OnClickListener onClickListener) {
        if (context == null) {
            context = BaseApplication.getContext();
        }
        if (context == null) {
            return;
        }
        String string = context.getString(i16);
        String string2 = context.getString(i17);
        try {
            if (context instanceof Activity) {
                DialogUtil.createCustomDialog(context, 230, string, string2, 0, i18, onClickListener, (DialogInterface.OnClickListener) null).show();
            } else {
                k0(context, i3, string, string2, 0, i18, onClickListener, null);
            }
        } catch (Exception unused) {
            k0(context, i3, string, string2, 0, i18, onClickListener, null);
        }
    }

    public static QQCustomDialog o0(Context context, int i3, String str, String str2, int i16, int i17, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = null;
        try {
            try {
                if (context != BaseApplication.getContext()) {
                    qQCustomDialog = DialogUtil.createCustomDialog(context, 230, str, str2, i16, i17, onClickListener, onClickListener2);
                    qQCustomDialog.show();
                } else {
                    l0(context, i3, str, str2, i16, i17, onClickListener, onClickListener2);
                }
            } catch (Exception unused) {
                l0(context, i3, str, str2, i16, i17, onClickListener, onClickListener2);
                return qQCustomDialog;
            }
        } catch (Exception unused2) {
        }
        return qQCustomDialog;
    }

    @Override // mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    void i0() {
        a aVar;
        int i3;
        int i16;
        QQCustomDialog qQCustomDialog;
        QQCustomDialog qQCustomDialog2;
        String stringExtra = super.getIntent().getStringExtra("invoke_type");
        if (TextUtils.equals(stringExtra, "reshow") && (qQCustomDialog2 = this.f76714d) != null) {
            if (!qQCustomDialog2.isShowing()) {
                this.f76714d.show();
                return;
            }
            return;
        }
        if (TextUtils.equals(stringExtra, "changeText") && (qQCustomDialog = this.f76714d) != null) {
            c cVar = f76713f;
            String str = cVar.f76723c;
            String str2 = cVar.f76724d;
            qQCustomDialog.setTitle(str);
            this.f76714d.setMessage(str2);
            if (!this.f76714d.isShowing()) {
                this.f76714d.show();
                return;
            }
            return;
        }
        c cVar2 = f76713f;
        int i17 = cVar2.f76722b;
        String str3 = cVar2.f76723c;
        String str4 = cVar2.f76724d;
        int i18 = cVar2.f76725e;
        int i19 = cVar2.f76726f;
        QQCustomDialog qQCustomDialog3 = this.f76714d;
        if (qQCustomDialog3 != null) {
            qQCustomDialog3.dismiss();
            this.f76714d = null;
        }
        a aVar2 = new a();
        b bVar = new b();
        if (i18 != 0 && f76713f.f76727g != null) {
            aVar = aVar2;
            i3 = i18;
        } else {
            aVar = null;
            i3 = R.string.idk;
        }
        if (i19 != 0 && f76713f.f76728h != null) {
            i16 = i19;
        } else {
            bVar = null;
            i16 = R.string.idk;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, i17, str3, str4, i3, i16, bVar, aVar);
        this.f76714d = createCustomDialog;
        createCustomDialog.setCancelable(false);
        this.f76714d.show();
    }

    @Override // mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (QLog.isColorLevel()) {
            QLog.d("PopupDialog", 2, "onCreate");
        }
        getWindow().setBackgroundDrawableResource(R.drawable.f162601b70);
        PopupDialog popupDialog = c.f76720i;
        if (popupDialog != null && popupDialog != this) {
            popupDialog.finish();
        }
        c.f76720i = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("PopupDialog", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        QQCustomDialog qQCustomDialog = this.f76714d;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.f76714d = null;
        }
        c.f76720i = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 != 4) {
            return super.onKeyDown(i3, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        super.setIntent(intent);
        if (QLog.isColorLevel()) {
            QLog.d("PopupDialog", 2, "onNewIntent");
        }
        PopupDialog popupDialog = c.f76720i;
        if (popupDialog != null && popupDialog != this) {
            popupDialog.finish();
        }
        c.f76720i = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        j0(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        i0();
        PopupDialog popupDialog = c.f76720i;
        if (popupDialog != null && popupDialog != this) {
            popupDialog.finish();
        }
        if (c.f76720i != this) {
            c.f76720i = this;
        }
        j0(true);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }
}
