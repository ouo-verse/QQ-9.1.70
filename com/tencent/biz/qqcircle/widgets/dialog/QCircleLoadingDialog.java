package com.tencent.biz.qqcircle.widgets.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.animation.QCircleAnimationHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.richframework.thread.RFWThreadManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleLoadingDialog extends ReportDialog {
    private static RFWMultiDownloadHelper M;
    private final LayoutInflater C;
    private View D;
    private LinearLayout E;
    private ImageView F;
    private ImageView G;
    private TextView H;
    private Drawable I;
    private QQAnimationDrawable J;
    private b K;
    private final AnimationDrawableFactory.CreateResultListener L;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ QCircleLoadingDialog this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.isShowing()) {
                this.this$0.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QCircleLoadingDialog.this.isShowing()) {
                if (QCircleLoadingDialog.this.K != null) {
                    QCircleLoadingDialog.this.K.onClick();
                }
                QCircleLoadingDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void onClick();
    }

    static {
        RFWMultiDownloadHelper rFWMultiDownloadHelper = new RFWMultiDownloadHelper();
        M = rFWMultiDownloadHelper;
        rFWMultiDownloadHelper.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip", com.tencent.biz.qqcircle.f.r()));
        M.start();
    }

    @UiThread
    public QCircleLoadingDialog(@NonNull Context context) {
        super(context, R.style.az4);
        this.L = new AnimationDrawableFactory.CreateResultListener() { // from class: com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog.1
            @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
            public void onCreateResult(boolean z16, QQAnimationDrawable qQAnimationDrawable) {
                if (z16 && qQAnimationDrawable != null) {
                    QCircleLoadingDialog.this.J = qQAnimationDrawable;
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QCircleLoadingDialog.this.W();
                        }
                    });
                } else {
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QCircleLoadingDialog.this.Z();
                        }
                    });
                }
            }
        };
        LayoutInflater from = LayoutInflater.from(context);
        this.C = from;
        View inflate = from.inflate(R.layout.g3z, (ViewGroup) null);
        this.D = inflate;
        this.E = (LinearLayout) inflate.findViewById(R.id.f31490r7);
        this.F = (ImageView) this.D.findViewById(R.id.aga);
        this.G = (ImageView) this.D.findViewById(R.id.f31480r6);
        this.H = (TextView) this.D.findViewById(R.id.f31510r9);
        this.I = context.getResources().getDrawable(R.drawable.nal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        ImageView imageView;
        QQAnimationDrawable qQAnimationDrawable = this.J;
        if (qQAnimationDrawable != null && (imageView = this.G) != null) {
            imageView.setImageDrawable(qQAnimationDrawable);
            this.J.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        a0();
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setImageDrawable(this.I);
        }
    }

    private void a0() {
        QQAnimationDrawable qQAnimationDrawable = this.J;
        if (qQAnimationDrawable != null && qQAnimationDrawable.isRunning()) {
            this.J.stop();
        }
    }

    public void S(String str) {
        this.H.setText(str);
    }

    public ImageView U() {
        return this.F;
    }

    public void X(b bVar) {
        this.K = bVar;
    }

    public void Y(boolean z16) {
        if (z16) {
            this.F.setVisibility(0);
            this.F.setOnClickListener(new a());
        } else {
            this.F.setVisibility(4);
            this.F.setOnClickListener(null);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.K = null;
        try {
            super.dismiss();
        } catch (Exception e16) {
            QLog.e("QCircleLoadingDialog", 1, "dismiss error " + e16);
        }
        a0();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setContentView(this.D);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 17;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
    }

    public void showDialog() {
        if (this.J == null) {
            if (RFWDownloaderFactory.getDownloader(com.tencent.biz.qqcircle.f.r()).isFileDownLoaded("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip")) {
                AnimationDrawableCreateOption.Builder defaultBuilder = QCircleAnimationHelper.getDefaultBuilder("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip");
                defaultBuilder.setFrameDuration(67);
                defaultBuilder.setCreateTimeOut(TTL.MAX_VALUE);
                q50.a.a(hashCode(), defaultBuilder.build(), this.L);
            } else {
                Z();
            }
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.dialog.a
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleLoadingDialog.this.W();
                }
            });
        }
        show();
    }
}
