package com.tencent.mobileqq.qwallet.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.plugin.IQWalletHelper;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends ReportDialog {
    private AnimationView C;
    private AnimationView.AnimationInfo D;
    protected boolean E;
    protected String F;
    protected String G;
    protected String H;
    protected Activity I;
    private BroadcastReceiver J;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals("qwallet.facetoface")) {
                a.this.dismiss();
            }
        }
    }

    public a(Activity activity, int i3, AnimationView.AnimationInfo animationInfo) {
        super(activity, i3);
        this.E = false;
        this.J = new b();
        this.D = animationInfo;
        this.I = activity;
        init();
    }

    private void init() {
        super.requestWindowFeature(1);
        Window window = getWindow();
        setContentView(R.layout.bfv);
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            window.addFlags(67108864);
        }
        setCanceledOnTouchOutside(false);
        AnimationView animationView = (AnimationView) findViewById(R.id.asc);
        this.C = animationView;
        animationView.setAnimationFromInfo(this.D);
        this.C.setAnimationListener(new C8487a());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("qwallet.facetoface");
        getContext().registerReceiver(this.J, intentFilter);
    }

    public void N(String str, String str2, String str3) {
        this.F = str;
        this.G = str2;
        this.H = str3;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getContext().unregisterReceiver(this.J);
        this.C.stop();
        this.C.setImageDrawable(null);
        AnimationView.AnimationInfo animationInfo = this.D;
        if (animationInfo != null) {
            animationInfo.destoryBitmaps();
            this.D = null;
        }
        this.I = null;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        this.C.play();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qwallet.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8487a implements AnimationView.MyAnimationListener {
        C8487a() {
        }

        @Override // com.tencent.mobileqq.widget.AnimationView.MyAnimationListener
        public void onAnimationRepeat(AnimationView animationView) {
            a aVar = a.this;
            if (!aVar.E) {
                aVar.E = true;
                IQWalletHelper iQWalletHelper = (IQWalletHelper) QRoute.api(IQWalletHelper.class);
                a aVar2 = a.this;
                iQWalletHelper.gotoF2FRedpack(aVar2.F, aVar2.G, aVar2.I, aVar2.H, true);
            }
        }

        @Override // com.tencent.mobileqq.widget.AnimationView.MyAnimationListener
        public void onAnimationEnd(AnimationView animationView) {
        }

        @Override // com.tencent.mobileqq.widget.AnimationView.MyAnimationListener
        public void onAnimationStart(AnimationView animationView) {
        }
    }
}
