package com.qzone.album.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.widget.AvatarImageView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumDialog extends ReportDialog {
    TextView C;
    TextView D;
    TextView E;
    TextView F;
    EditText G;
    AvatarImageView H;
    LinearLayout I;
    LinearLayout J;
    TextView K;
    TextView L;
    TextView M;
    View N;
    View P;
    FrameLayout Q;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f44123d;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f44123d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f44123d;
            if (onClickListener != null) {
                onClickListener.onClick(AlbumDialog.this, 0);
            }
            try {
                if (AlbumDialog.this.isShowing()) {
                    AlbumDialog.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f44125d;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f44125d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f44125d;
            if (onClickListener != null) {
                onClickListener.onClick(AlbumDialog.this, 1);
            }
            try {
                if (AlbumDialog.this.isShowing()) {
                    AlbumDialog.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f44127d;

        c(DialogInterface.OnClickListener onClickListener) {
            this.f44127d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f44127d;
            if (onClickListener != null) {
                onClickListener.onClick(AlbumDialog.this, 0);
            }
            try {
                if (AlbumDialog.this.isShowing()) {
                    AlbumDialog.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f44129d;

        d(DialogInterface.OnClickListener onClickListener) {
            this.f44129d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f44129d;
            if (onClickListener != null) {
                onClickListener.onClick(AlbumDialog.this, 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f44131d;

        e(DialogInterface.OnClickListener onClickListener) {
            this.f44131d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f44131d;
            if (onClickListener != null) {
                onClickListener.onClick(AlbumDialog.this, 0);
            }
            try {
                if (AlbumDialog.this.isShowing()) {
                    AlbumDialog.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public AlbumDialog(Context context, int i3) {
        super(context, i3);
    }

    public String N() {
        if (!TextUtils.isEmpty(this.G.getText().toString().trim())) {
            return this.G.getText().toString().trim();
        }
        return "";
    }

    public void O(Activity activity) {
        ((InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.G.getWindowToken(), 0);
    }

    public void P(long j3) {
        this.H.j(j3);
        this.H.setVisibility(0);
    }

    public void Q(String str) {
        this.F.setText(str);
        this.F.setContentDescription(str);
        this.F.setVisibility(0);
    }

    public void S(int i3) {
        TextView textView = this.K;
        if (textView != null) {
            textView.setVisibility(i3);
        }
    }

    public void U(String str) {
        this.G.setText(str);
        this.G.setVisibility(0);
        try {
            this.G.setSelection(str.length());
        } catch (Exception unused) {
        }
    }

    public AlbumDialog Z(String str, int i3, DialogInterface.OnClickListener onClickListener) {
        this.E.setTextColor(i3);
        return a0(str, onClickListener);
    }

    public void c0(int i3) {
        TextView textView = this.L;
        if (textView != null) {
            textView.setCompoundDrawablePadding(u4.a.z().o(4.0f));
            this.L.setCompoundDrawablesWithIntrinsicBounds(0, 0, i3, 0);
        }
    }

    public void d0(final Activity activity) {
        this.G.setFocusable(true);
        this.G.setFocusableInTouchMode(true);
        this.G.requestFocus();
        this.G.postDelayed(new Runnable() { // from class: com.qzone.album.ui.widget.AlbumDialog.3
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = activity;
                if (activity2 == null || AlbumDialog.this.G == null) {
                    return;
                }
                ((InputMethodManager) activity2.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).toggleSoftInput(0, 2);
            }
        }, 800L);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.C = (TextView) findViewById(R.id.dialogTitle);
        TextView textView = (TextView) findViewById(R.id.dialogText);
        this.F = textView;
        textView.setVisibility(8);
        this.J = (LinearLayout) findViewById(R.id.aew);
        this.G = (EditText) findViewById(R.id.hgb);
        this.D = (TextView) findViewById(R.id.dialogLeftBtn);
        this.E = (TextView) findViewById(R.id.dialogRightBtn);
        AvatarImageView avatarImageView = (AvatarImageView) findViewById(R.id.hga);
        this.H = avatarImageView;
        avatarImageView.setVisibility(8);
        this.I = (LinearLayout) findViewById(R.id.koc);
        this.K = (TextView) findViewById(R.id.bki);
        this.L = (TextView) findViewById(R.id.bjb);
        this.M = (TextView) findViewById(R.id.bkj);
        this.I.setVisibility(8);
        this.N = findViewById(R.id.aeu);
        this.P = findViewById(R.id.aev);
        this.Q = (FrameLayout) findViewById(R.id.bjc);
    }

    public void setTitle(String str) {
        this.C.setText(str);
        this.C.setContentDescription(str);
        this.C.setVisibility(0);
    }

    public AlbumDialog R(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.K.setVisibility(8);
            return this;
        }
        this.K.setText(str);
        this.K.setContentDescription(str + getContext().getString(R.string.a_n));
        this.K.setVisibility(0);
        this.K.setOnClickListener(new c(onClickListener));
        return this;
    }

    public AlbumDialog W(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.M.setVisibility(8);
            return this;
        }
        this.M.setText(str);
        this.M.setContentDescription(str + getContext().getString(R.string.a_n));
        this.M.setVisibility(0);
        this.P.setVisibility(0);
        this.M.setOnClickListener(new e(onClickListener));
        return this;
    }

    public AlbumDialog Y(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.D.setVisibility(8);
            return this;
        }
        this.D.setText(str);
        this.D.setContentDescription(str + getContext().getString(R.string.a_n));
        this.D.setVisibility(0);
        this.D.setOnClickListener(new a(onClickListener));
        return this;
    }

    public AlbumDialog a0(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.E.setVisibility(8);
            return this;
        }
        this.E.setText(str);
        this.E.setContentDescription(str + getContext().getString(R.string.a_n));
        this.E.setVisibility(0);
        this.E.setOnClickListener(new b(onClickListener));
        return this;
    }

    public AlbumDialog b0(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.L.setVisibility(8);
            return this;
        }
        this.L.setText(str);
        this.L.setContentDescription(str + getContext().getString(R.string.a_n));
        this.L.setVisibility(0);
        if (this.K.getVisibility() == 8) {
            this.N.setVisibility(8);
        } else {
            this.N.setVisibility(0);
        }
        this.Q.setOnClickListener(new d(onClickListener));
        return this;
    }

    public void X(int i3) {
        if (i3 == 1) {
            this.J.setVisibility(0);
            this.I.setVisibility(8);
            this.G.setVisibility(0);
            this.H.setVisibility(0);
            return;
        }
        if (i3 == 2) {
            this.J.setVisibility(0);
            this.I.setVisibility(8);
            this.G.setVisibility(8);
            this.H.setVisibility(8);
            return;
        }
        if (i3 != 3) {
            return;
        }
        this.G.setVisibility(8);
        this.H.setVisibility(8);
        this.J.setVisibility(8);
        this.I.setVisibility(0);
    }
}
