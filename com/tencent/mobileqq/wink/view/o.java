package com.tencent.mobileqq.wink.view;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class o extends ReportDialog {
    protected TextView C;
    protected TextView D;
    protected TextView E;
    protected TextView F;
    protected LinearLayout G;
    ViewGroup H;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f327067d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f327068e;

        a(DialogInterface.OnClickListener onClickListener, boolean z16) {
            this.f327067d = onClickListener;
            this.f327068e = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f327067d;
            if (onClickListener != null) {
                onClickListener.onClick(o.this, 1);
            }
            try {
                if (o.this.isShowing() && this.f327068e) {
                    o.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f327070d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f327070d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f327070d;
            if (onClickListener != null) {
                onClickListener.onClick(o.this, 0);
            }
            try {
                if (o.this.isShowing()) {
                    o.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f327072d;

        c(DialogInterface.OnClickListener onClickListener) {
            this.f327072d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f327072d;
            if (onClickListener != null) {
                onClickListener.onClick(o.this, 1);
            }
            try {
                if (o.this.isShowing()) {
                    o.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @TargetApi(14)
    public o(Context context, int i3) {
        super(context, i3);
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.5f);
    }

    public static o N(Context context, String str, String str2, int i3, int i16, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        o oVar = new o(context, R.style.a0y);
        oVar.setContentView(R.layout.gu7);
        oVar.setBackground(R.drawable.qvideo_skin_toast_and_dialog_background);
        oVar.S(str);
        oVar.O(str2);
        oVar.P(i3, onClickListener2);
        oVar.Q(i16, onClickListener);
        oVar.setCanceledOnTouchOutside(false);
        return oVar;
    }

    public o O(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.D.setText(charSequence);
            this.D.setContentDescription(charSequence);
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
        return this;
    }

    public o P(int i3, DialogInterface.OnClickListener onClickListener) {
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

    public o Q(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.F.setVisibility(8);
            return this;
        }
        this.F.setText(i3);
        this.F.setContentDescription(getContext().getString(i3));
        this.F.setVisibility(0);
        this.F.setOnClickListener(new c(onClickListener));
        return this;
    }

    public o R(int i3, DialogInterface.OnClickListener onClickListener, boolean z16) {
        if (onClickListener == null) {
            this.F.setVisibility(8);
            return this;
        }
        this.F.setText(i3);
        this.F.setContentDescription(getContext().getString(i3) + getContext().getString(R.string.a_n));
        this.F.setVisibility(0);
        this.F.setOnClickListener(new a(onClickListener, z16));
        return this;
    }

    public o S(String str) {
        if (str != null) {
            this.C.setText(str);
            this.C.setContentDescription(str);
            this.C.setVisibility(0);
        } else {
            this.C.setVisibility(8);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
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

    public void setBackground(int i3) {
        ViewGroup viewGroup = this.H;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(i3);
        }
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
}
