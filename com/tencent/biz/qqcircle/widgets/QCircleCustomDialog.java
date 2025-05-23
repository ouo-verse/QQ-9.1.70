package com.tencent.biz.qqcircle.widgets;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.wink.view.WinkRoundedCornerImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleCustomDialog extends ReportDialog {
    private static WeakReference<Dialog> J;
    protected TextView C;
    protected TextView D;
    protected TextView E;
    protected TextView F;
    protected LinearLayout G;
    private ViewGroup H;
    private Context I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f92948d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f92948d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f92948d.onClick(QCircleCustomDialog.this, 0);
            try {
                if (QCircleCustomDialog.this.isShowing()) {
                    QCircleCustomDialog.this.dismiss();
                }
            } catch (Exception e16) {
                QLog.e("QCircleCustomDialog", 1, "setNegativeButton click trigger dismiss error:" + e16.toString());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f92950d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f92950d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f92950d;
            if (onClickListener != null) {
                onClickListener.onClick(QCircleCustomDialog.this, 0);
            }
            try {
                QLog.d("QCircleCustomDialog", 1, "setNegativeButton, onClick, isShowing: " + QCircleCustomDialog.this.isShowing() + ", this: " + QCircleCustomDialog.this);
                if (QCircleCustomDialog.this.isShowing()) {
                    QCircleCustomDialog.this.dismiss();
                }
            } catch (Exception e16) {
                QLog.e("QCircleCustomDialog", 1, "setNegativeButton click trigger dismiss error:", e16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f92952d;

        c(DialogInterface.OnClickListener onClickListener) {
            this.f92952d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f92952d.onClick(QCircleCustomDialog.this, 1);
            try {
                if (QCircleCustomDialog.this.isShowing()) {
                    QCircleCustomDialog.this.dismiss();
                }
            } catch (Exception e16) {
                QLog.e("QCircleCustomDialog", 1, "setPositiveButton click trigger dismiss error:" + e16.toString());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f92954d;

        d(DialogInterface.OnClickListener onClickListener) {
            this.f92954d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f92954d;
            if (onClickListener != null) {
                onClickListener.onClick(QCircleCustomDialog.this, 1);
            }
            try {
                QLog.d("QCircleCustomDialog", 1, "setPositiveButton, onClick, isShowing: " + QCircleCustomDialog.this.isShowing() + ", this: " + QCircleCustomDialog.this);
                if (QCircleCustomDialog.this.isShowing()) {
                    QCircleCustomDialog.this.dismiss();
                }
            } catch (Exception e16) {
                QLog.e("QCircleCustomDialog", 1, "setPositiveButton click trigger dismiss error:", e16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f92956d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QCircleCustomDialog f92957e;

        e(Context context, QCircleCustomDialog qCircleCustomDialog) {
            this.f92956d = context;
            this.f92957e = qCircleCustomDialog;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            com.tencent.biz.qqcircle.launcher.c.k0(this.f92956d, new QCircleSettingBean());
            this.f92957e.dismiss();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            textPaint.setColor(BaseApplication.getContext().getColor(R.color.qui_common_text_link));
            textPaint.setUnderlineText(false);
        }
    }

    @TargetApi(14)
    public QCircleCustomDialog(Context context, int i3) {
        super(context, i3);
        init(context);
    }

    public static QCircleCustomDialog O(Context context) {
        return Q(context, null, null, null, null);
    }

    public static QCircleCustomDialog P(Context context, String str, String str2, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QCircleCustomDialog qCircleCustomDialog = new QCircleCustomDialog(context, R.style.f174242az2);
        qCircleCustomDialog.setContentView(R.layout.g2k);
        qCircleCustomDialog.i0(str);
        qCircleCustomDialog.c0(str2);
        qCircleCustomDialog.d0(i3, onClickListener2);
        qCircleCustomDialog.f0(i16, onClickListener);
        qCircleCustomDialog.setCanceledOnTouchOutside(false);
        J = new WeakReference<>(qCircleCustomDialog);
        return qCircleCustomDialog;
    }

    public static QCircleCustomDialog Q(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return P(context, str, str2, R.string.cancel, R.string.f171151ok, onClickListener, onClickListener2);
    }

    public static QCircleCustomDialog R(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QCircleCustomDialog qCircleCustomDialog = new QCircleCustomDialog(context, R.style.f174242az2);
        qCircleCustomDialog.setContentView(R.layout.g2k);
        qCircleCustomDialog.i0(str);
        qCircleCustomDialog.c0(str2);
        qCircleCustomDialog.e0(str3, onClickListener2);
        qCircleCustomDialog.g0(str4, onClickListener);
        qCircleCustomDialog.setCanceledOnTouchOutside(false);
        return qCircleCustomDialog;
    }

    public static QCircleCustomDialog S(Context context, String str, String str2, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QCircleCustomDialog qCircleCustomDialog = new QCircleCustomDialog(context, R.style.f174242az2);
        qCircleCustomDialog.setContentView(R.layout.g2m);
        qCircleCustomDialog.i0(str);
        qCircleCustomDialog.c0(str2);
        qCircleCustomDialog.d0(i3, onClickListener2);
        qCircleCustomDialog.f0(i16, onClickListener);
        qCircleCustomDialog.setCanceledOnTouchOutside(false);
        return qCircleCustomDialog;
    }

    public static QCircleCustomDialog U(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QCircleCustomDialog qCircleCustomDialog = new QCircleCustomDialog(context, R.style.f174242az2);
        qCircleCustomDialog.setContentView(R.layout.g2m);
        qCircleCustomDialog.i0(str);
        qCircleCustomDialog.c0(str2);
        qCircleCustomDialog.e0(str3, onClickListener2);
        qCircleCustomDialog.g0(str4, onClickListener);
        qCircleCustomDialog.setCanceledOnTouchOutside(false);
        return qCircleCustomDialog;
    }

    public static QCircleCustomDialog W(Context context, String str, String str2, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QCircleCustomDialog qCircleCustomDialog = new QCircleCustomDialog(context, R.style.f174242az2);
        qCircleCustomDialog.setContentView(R.layout.g2n);
        qCircleCustomDialog.c0(str);
        qCircleCustomDialog.d0(i3, onClickListener2);
        qCircleCustomDialog.f0(i16, onClickListener);
        qCircleCustomDialog.setCanceledOnTouchOutside(false);
        qCircleCustomDialog.setCancelable(false);
        final WinkRoundedCornerImageView winkRoundedCornerImageView = (WinkRoundedCornerImageView) qCircleCustomDialog.getRootView().findViewById(R.id.bj8);
        winkRoundedCornerImageView.setCornerRadius(cx.a(4.0f), cx.a(4.0f), 0.0f, 0.0f);
        Option obtain = Option.obtain();
        obtain.setUrl(str2).setPredecode(true).setRequestWidth(cx.a(260.0f)).setRequestHeight(cx.a(260.0f));
        QCircleFeedPicLoader.g().loadImage(obtain, new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.widgets.QCircleCustomDialog.7
            @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(final LoadState loadState, final Option option) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleCustomDialog.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (loadState == LoadState.STATE_SUCCESS) {
                            WinkRoundedCornerImageView.this.setImageDrawable(new BitmapDrawable(option.getResultBitMap()));
                        }
                    }
                });
            }
        });
        Z(qCircleCustomDialog.E, QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_PANEL_CANCEL_BUTTON);
        Z(qCircleCustomDialog.F, QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_PANEL_CONTINUE_BUTTON);
        return qCircleCustomDialog;
    }

    public static QCircleCustomDialog X(Context context, String str, String str2, String str3, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QCircleCustomDialog qCircleCustomDialog = new QCircleCustomDialog(context, R.style.f174242az2);
        qCircleCustomDialog.setContentView(R.layout.g2o);
        qCircleCustomDialog.i0(str);
        qCircleCustomDialog.c0(str2);
        qCircleCustomDialog.d0(i3, onClickListener2);
        qCircleCustomDialog.f0(i16, onClickListener);
        qCircleCustomDialog.setCanceledOnTouchOutside(false);
        final RoundCornerImageView roundCornerImageView = (RoundCornerImageView) qCircleCustomDialog.getRootView().findViewById(R.id.bj8);
        roundCornerImageView.setCorner(cx.a(4.0f));
        roundCornerImageView.setBorder(true);
        roundCornerImageView.setBorderWidth(cx.a(1.0f));
        roundCornerImageView.setColor(-1644826);
        Option obtain = Option.obtain();
        obtain.setUrl(str3).setPredecode(true).setRequestWidth(cx.a(105.0f)).setRequestHeight(cx.a(136.0f));
        QCircleFeedPicLoader.g().loadImage(obtain, new QCirclePicStateListener() { // from class: com.tencent.biz.qqcircle.widgets.QCircleCustomDialog.6
            @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(final LoadState loadState, final Option option) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleCustomDialog.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (loadState == LoadState.STATE_SUCCESS) {
                            RoundCornerImageView.this.setImageDrawable(new BitmapDrawable(option.getResultBitMap()));
                        }
                    }
                });
            }
        });
        Z(qCircleCustomDialog.E, QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_PANEL_CANCEL_BUTTON);
        Z(qCircleCustomDialog.F, QCircleDaTongConstant.ElementId.EM_XSJ_DRAFT_PANEL_CONTINUE_BUTTON);
        return qCircleCustomDialog;
    }

    public static boolean Y() {
        WeakReference<Dialog> weakReference = J;
        if (weakReference != null && weakReference.get() != null) {
            J.get().dismiss();
            return true;
        }
        return false;
    }

    public static void Z(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    @NonNull
    private static ClickableSpan a0(Context context, QCircleCustomDialog qCircleCustomDialog) {
        return new e(context, qCircleCustomDialog);
    }

    private void init(Context context) {
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.5f);
        this.I = context;
    }

    public static void j0(Context context) {
        if (bz.r()) {
            context = ASEngineUtils.getHostContext(context);
        }
        if (context == null) {
            return;
        }
        QCircleCustomDialog qCircleCustomDialog = new QCircleCustomDialog(context, R.style.f174242az2);
        qCircleCustomDialog.setContentView(R.layout.g2k);
        com.tencent.biz.qqcircle.comment.recpic.z zVar = com.tencent.biz.qqcircle.comment.recpic.z.f83900a;
        String string = RFWApplication.getApplication().getString(R.string.f158741qf, zVar.w().getHelpTitle());
        String helpDesc = zVar.w().getHelpDesc();
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f16237209);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(helpDesc);
        if (helpDesc.contains(a16)) {
            spannableStringBuilder.setSpan(a0(context, qCircleCustomDialog), helpDesc.indexOf(a16), helpDesc.indexOf(a16) + a16.length(), 33);
        }
        String string2 = context.getResources().getString(R.string.f1910643s);
        qCircleCustomDialog.i0(string);
        qCircleCustomDialog.c0(spannableStringBuilder);
        qCircleCustomDialog.D.setMovementMethod(LinkMovementMethod.getInstance());
        qCircleCustomDialog.D.setHighlightColor(0);
        qCircleCustomDialog.e0(string2, new DialogInterface.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                dialogInterface.dismiss();
            }
        });
        qCircleCustomDialog.getWindow().setFlags(131072, 131072);
        qCircleCustomDialog.show();
    }

    public QCircleCustomDialog c0(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.D.setText(charSequence);
            this.D.setContentDescription(charSequence);
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
        return this;
    }

    public QCircleCustomDialog d0(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.E.setVisibility(8);
            return this;
        }
        this.E.setText(i3);
        this.E.setContentDescription(getContext().getString(i3) + getContext().getString(R.string.a_n));
        this.E.setVisibility(0);
        this.E.setOnClickListener(new b(onClickListener));
        return this;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            try {
                super.dismiss();
            } catch (Exception e16) {
                QLog.e("QCircleCustomDialog", 1, "dismiss, error ", e16);
            }
        } finally {
            QCirclePluginUtil.fixMesssageLeak(this);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.getText().add(getContext().getString(R.string.a_q));
        }
        super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Dialog.class.getName());
        return false;
    }

    public QCircleCustomDialog e0(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.E.setVisibility(8);
            return this;
        }
        this.E.setText(str);
        this.E.setContentDescription(str + getContext().getString(R.string.a_n));
        this.E.setVisibility(0);
        this.E.setOnClickListener(new a(onClickListener));
        return this;
    }

    public QCircleCustomDialog f0(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.F.setVisibility(8);
            return this;
        }
        this.F.setText(i3);
        this.F.setContentDescription(getContext().getString(i3));
        this.F.setVisibility(0);
        this.F.setOnClickListener(new d(onClickListener));
        return this;
    }

    public QCircleCustomDialog g0(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.F.setVisibility(8);
            return this;
        }
        this.F.setText(str);
        this.F.setContentDescription(str + getContext().getString(R.string.a_n));
        this.F.setVisibility(0);
        this.F.setOnClickListener(new c(onClickListener));
        return this;
    }

    public ViewGroup getRootView() {
        return this.H;
    }

    public QCircleCustomDialog i0(String str) {
        if (str != null) {
            this.C.setText(str);
            this.C.setContentDescription(str);
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
        return this;
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.C = (TextView) findViewById(R.id.dialogTitle);
        this.D = (TextView) findViewById(R.id.dialogText);
        this.E = (TextView) findViewById(R.id.dialogLeftBtn);
        this.F = (TextView) findViewById(R.id.dialogRightBtn);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.G = (LinearLayout) findViewById(R.id.abb);
        this.H = (ViewGroup) findViewById(R.id.bja);
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        this.C.setText(i3);
        this.C.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        Context context = this.I;
        if ((context instanceof Activity) && !((Activity) context).isFinishing() && !((Activity) this.I).isDestroyed()) {
            super.show();
        }
    }
}
