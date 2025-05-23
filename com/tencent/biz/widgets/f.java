package com.tencent.biz.widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f extends ReportDialog {
    private View C;
    private View D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private Context J;
    private boolean K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f97777d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f97777d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f97777d;
            if (onClickListener != null) {
                onClickListener.onClick(f.this, -2);
            }
            f.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f97779d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f97779d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f97779d;
            if (onClickListener != null) {
                onClickListener.onClick(f.this, -1);
            }
            f.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public f(Context context) {
        super(context, R.style.qZoneInputDialog);
        this.K = false;
        super.setContentView(R.layout.f167945np);
        this.J = context;
        initUI();
    }

    private void N(boolean z16) {
        int i3;
        int i16;
        QLog.i("ShareToQZone", 2, "width:" + this.E.getLayoutParams().width);
        int i17 = 0;
        if (z16) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
        View view = this.D;
        if (this.K) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        View view2 = this.C;
        if (this.K) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        view2.setVisibility(i16);
        TextView textView = this.I;
        if (this.K) {
            i17 = 8;
        }
        textView.setVisibility(i17);
    }

    private void initUI() {
        this.C = super.findViewById(R.id.f166985jo3);
        this.D = super.findViewById(R.id.jny);
        this.E = (TextView) super.findViewById(R.id.dialogLeftBtn);
        this.F = (TextView) super.findViewById(R.id.dialogRightBtn);
        this.G = (TextView) super.findViewById(R.id.f166983jo1);
        ((ImageView) super.findViewById(R.id.f166984jo2)).setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
        this.H = (TextView) super.findViewById(R.id.jnw);
        ((ImageView) super.findViewById(R.id.jnx)).setColorFilter(-909794, PorterDuff.Mode.MULTIPLY);
        this.I = (TextView) super.findViewById(R.id.j5r);
    }

    public void O(String str, DialogInterface.OnClickListener onClickListener) {
        this.E.setText(str);
        this.E.setOnClickListener(new a(onClickListener));
    }

    public void P(int i3) {
        TextView textView = this.I;
        if (textView != null) {
            if (i3 != 0) {
                textView.setText(i3);
            } else {
                textView.setText("");
            }
        }
    }

    public void Q(int i3) {
        TextView textView = this.H;
        if (textView != null) {
            textView.setText(i3);
        }
    }

    public void R(boolean z16) {
        this.K = z16;
    }

    public void S(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            N(false);
            return;
        }
        N(true);
        this.F.setText(str);
        this.F.setOnClickListener(new b(onClickListener));
    }

    public void U(int i3) {
        TextView textView = this.G;
        if (textView != null) {
            textView.setText(i3);
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        QLog.i("ShareResultDialog", 2, "onBackPressed");
        super.onBackPressed();
    }
}
