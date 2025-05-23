package com.tencent.comic;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.comic.VipComicJumpActivity;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends Dialog implements DialogInterface.OnDismissListener {

    /* renamed from: d, reason: collision with root package name */
    private final VipComicJumpActivity.f f99239d;

    /* renamed from: e, reason: collision with root package name */
    private C1009a f99240e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.comic.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C1009a extends BroadcastReceiver {
        C1009a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (QLog.isColorLevel()) {
                QLog.i("BoodoPluginLoadingDialog", 1, "HippyActivityLaunchReceiver onReceive");
            }
            if ("action_hippy_activity_launch".equals(intent.getAction())) {
                a.this.dismiss();
            }
        }
    }

    private void d() {
        setOnDismissListener(this);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        Window window = getWindow();
        window.setGravity(80);
        window.setDimAmount(0.0f);
        window.setGravity(17);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f167471di0, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.r_x)).setImageResource(R.drawable.h86);
        setContentView(inflate);
        if (this.f99240e == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_hippy_activity_launch");
            this.f99240e = new C1009a();
            getContext().registerReceiver(this.f99240e, intentFilter);
        }
    }

    private void e() {
        if (this.f99240e != null) {
            getContext().unregisterReceiver(this.f99240e);
            this.f99240e = null;
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        VipComicJumpActivity.f fVar = this.f99239d;
        if (fVar != null) {
            fVar.f99233b = true;
        }
        e();
    }

    public a(Context context, VipComicJumpActivity.f fVar) {
        super(context, R.style.qZoneInputDialog);
        setContentView(R.layout.f167856jn);
        this.f99239d = fVar;
        d();
    }
}
