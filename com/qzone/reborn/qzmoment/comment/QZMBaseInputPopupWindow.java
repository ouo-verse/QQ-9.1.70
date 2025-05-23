package com.qzone.reborn.qzmoment.comment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import com.qzone.util.l;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;

/* loaded from: classes37.dex */
public abstract class QZMBaseInputPopupWindow extends h implements View.OnClickListener, DialogInterface.OnDismissListener {
    protected g D;
    protected View E;
    protected View F;
    protected QZMCommentEditText G;
    protected Button H;
    protected b I;
    private InputMethodManager J;
    private AlphaAnimation K;
    private c L;
    private Handler M;
    protected int N;
    protected boolean P;

    /* loaded from: classes37.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes37.dex */
    public interface c {
        void onDismiss();
    }

    private void Y() {
        this.J = (InputMethodManager) this.C.get().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
    }

    @Override // com.qzone.reborn.qzmoment.comment.a
    public void N() {
        super.N();
        Window window = getWindow();
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        if (decorView instanceof ViewGroup) {
            View childAt = ((ViewGroup) decorView).getChildAt(0);
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = viewGroup.getChildAt(i3);
                    if (childAt2 == null || childAt2.getId() == 16908290) {
                        return;
                    }
                    if (!(childAt2 instanceof ViewStub)) {
                        childAt2.setAlpha(0.0f);
                    }
                }
            }
        }
    }

    protected void Q() {
        if (getWindow() == null || getWindow().getAttributes() == null) {
            return;
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        window.setSoftInputMode(16);
    }

    protected abstract int R();

    /* JADX INFO: Access modifiers changed from: protected */
    public Handler S() {
        if (this.M == null) {
            this.M = new Handler(Looper.getMainLooper());
        }
        return this.M;
    }

    public String U() {
        QZMCommentEditText qZMCommentEditText = this.G;
        if (qZMCommentEditText == null) {
            return "";
        }
        return QzoneEmotionUtils.splash2Emo(g0(qZMCommentEditText.getText()).replaceAll(l.a(R.string.f172111ng0), l.a(R.string.f172113ng2)).replaceAll(l.a(R.string.nfz), "/MM").replaceAll(l.a(R.string.f2192465w), "/chigua")).trim();
    }

    public void W(final View view) {
        view.post(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMBaseInputPopupWindow.2
            @Override // java.lang.Runnable
            public void run() {
                QZMBaseInputPopupWindow.this.J.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X() {
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = view.getHeight();
        layoutParams.weight = 0.0f;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a0() {
        if (this.E != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.K = alphaAnimation;
            alphaAnimation.setDuration(200L);
            this.K.setAnimationListener(new a());
            this.E.startAnimation(this.K);
        }
    }

    public void b0(String str) {
        QZMCommentEditText qZMCommentEditText = this.G;
        if (qZMCommentEditText != null) {
            qZMCommentEditText.setHint(str);
        }
    }

    public void c0(b bVar) {
        this.I = bVar;
    }

    public void d0(c cVar) {
        this.L = cVar;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        W(this.G);
        View view = this.E;
        if (view != null && view.getVisibility() == 0) {
            this.E.setVisibility(8);
        }
        super.dismiss();
    }

    public void e0(CharSequence charSequence) {
        QZMCommentEditText qZMCommentEditText = this.G;
        if (qZMCommentEditText == null) {
            return;
        }
        qZMCommentEditText.setText(charSequence);
        QZMCommentEditText qZMCommentEditText2 = this.G;
        qZMCommentEditText2.setSelection(qZMCommentEditText2.getText().length());
    }

    public void f0(final View view, int i3) {
        view.requestFocus();
        view.postDelayed(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMBaseInputPopupWindow.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QZMBaseInputPopupWindow", 1, "showKeyBoard");
                QZMBaseInputPopupWindow.this.J.showSoftInput(view, 1);
            }
        }, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i0(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = 0;
        layoutParams.weight = 1.0f;
        view.setLayoutParams(layoutParams);
    }

    protected abstract void initView();

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        g gVar = this.D;
        if (gVar != null) {
            gVar.f();
            this.D = null;
        }
        this.P = false;
        c cVar = this.L;
        if (cVar != null) {
            cVar.onDismiss();
        }
    }

    private String g0(Editable editable) {
        if (editable != null) {
            if (editable instanceof com.tencent.mobileqq.qzone.api.text.a) {
                return ((com.tencent.mobileqq.qzone.api.text.a) editable).toPlainText();
            }
            return editable.toString();
        }
        return "";
    }

    public QZMBaseInputPopupWindow(Context context) {
        super(context, R.style.f243084);
        this.E = LayoutInflater.from(context).inflate(R(), (ViewGroup) null);
        Q();
        setCancelable(true);
        initView();
        Y();
        setContentView(this.E);
        X();
        setOnDismissListener(this);
        N();
    }

    /* loaded from: classes37.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = QZMBaseInputPopupWindow.this.E;
            if (view != null) {
                view.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
