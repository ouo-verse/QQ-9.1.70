package b4;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends ReportDialog implements Handler.Callback {
    Animatable C;
    TextView D;
    Context E;
    protected boolean F;
    protected boolean G;
    private final Handler H;
    private final BroadcastReceiver I;

    /* compiled from: P */
    /* renamed from: b4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0093a extends BroadcastReceiver {
        C0093a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a.this.O();
        }
    }

    public a(Context context, boolean z16) {
        this(context, R.style.f174222az0, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        Context context = this.E;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        try {
            dismiss();
        } catch (Exception e16) {
            QLog.e("QWalletLoadingDialog", 1, "dismissSafely: ", e16);
        }
    }

    protected void P(View view, View view2) {
        if (view != null && QQTheme.isNowThemeIsNight()) {
            view.findViewById(R.id.ivTitleBtnLeft).setVisibility(8);
            view.findViewById(R.id.dsa).setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        QLog.d("QWalletLoadingDialog", 2, "dismiss");
        this.H.removeMessages(102);
        try {
            this.E.unregisterReceiver(this.I);
        } catch (IllegalArgumentException e16) {
            QLog.e("QWalletLoadingDialog", 1, "dismiss: error when unregisterReceiver ", e16);
        }
        if (this.F) {
            Context context = this.E;
            if (context instanceof QBaseActivity) {
                ((QBaseActivity) context).setCanLock(this.G);
                QBaseActivity.isUnLockSuccess = true;
            }
        }
        Animatable animatable = this.C;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 102) {
            O();
            return true;
        }
        return false;
    }

    protected void init(Context context) {
        WindowManager.LayoutParams attributes;
        if (this.F && (context instanceof QBaseActivity)) {
            QBaseActivity qBaseActivity = (QBaseActivity) context;
            this.G = qBaseActivity.getCanLock();
            qBaseActivity.setCanLock(false);
        }
        super.requestWindowFeature(1);
        this.E = context;
        Window window = getWindow();
        if (window != null && ImmersiveUtils.isSupporImmersive() == 1) {
            if (Build.VERSION.SDK_INT >= 28 && (attributes = window.getAttributes()) != null) {
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            getWindow().clearFlags(67108864);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
            getWindow().getDecorView().setSystemUiVisibility(9216);
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.bfs, (ViewGroup) null);
        setContentView(inflate);
        View findViewById = inflate.findViewById(R.id.j1w);
        findViewById.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(this.E);
        inflate.setFitsSystemWindows(false);
        if (window != null) {
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            attributes2.width = -1;
            attributes2.height = -1;
            window.setAttributes(attributes2);
        }
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) inflate.findViewById(R.id.ivTitleName);
        this.D = textView;
        if (textView != null) {
            textView.setVisibility(0);
            this.D.setText(R.string.g78);
        }
        ImageView imageView = (ImageView) super.findViewById(R.id.gez);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, -1.0f, 2, 1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(800L);
        translateAnimation.setRepeatCount(-1);
        imageView.startAnimation(translateAnimation);
        P(inflate, findViewById);
        super.setCancelable(false);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        TextView textView;
        super.onWindowFocusChanged(z16);
        Animatable animatable = (Animatable) this.E.getResources().getDrawable(R.drawable.common_loading6);
        this.C = animatable;
        if (animatable != null && (textView = this.D) != null) {
            textView.setCompoundDrawablePadding(10);
            this.D.setCompoundDrawablesWithIntrinsicBounds((Drawable) this.C, (Drawable) null, (Drawable) null, (Drawable) null);
            this.C.start();
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        QLog.d("QWalletLoadingDialog", 2, "show: context=" + getContext());
        this.H.sendEmptyMessageDelayed(102, 5000L);
        this.E.registerReceiver(this.I, new IntentFilter("com.qwallet.dialog.QWalletLoadingDialog.dismiss"));
    }

    protected a(Context context, int i3, boolean z16) {
        super(context, i3);
        this.C = null;
        this.D = null;
        this.E = null;
        this.G = true;
        this.H = new Handler(Looper.getMainLooper(), this);
        this.I = new C0093a();
        this.F = z16;
        init(context);
    }
}
