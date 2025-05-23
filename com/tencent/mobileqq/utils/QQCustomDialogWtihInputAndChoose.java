package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.widget.MyLinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQCustomDialogWtihInputAndChoose extends cw implements View.OnClickListener {

    /* renamed from: c0, reason: collision with root package name */
    public static final Integer f307202c0 = 1;

    /* renamed from: d0, reason: collision with root package name */
    public static final Integer f307203d0 = 2;
    SoftReference<Context> K;
    boolean L;
    EditText M;
    ImageView N;
    MyLinearLayout P;
    Handler Q;
    WindowManager R;
    WindowManager.LayoutParams S;
    boolean T;
    RelativeLayout U;
    final float V;
    final float W;
    final float X;
    boolean Y;
    ArrayList<String> Z;

    /* renamed from: a0, reason: collision with root package name */
    protected View f307204a0;

    /* renamed from: b0, reason: collision with root package name */
    protected View.OnClickListener f307205b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            QQCustomDialogWtihInputAndChoose.this.N.setImageResource(R.drawable.fqz);
            QQCustomDialogWtihInputAndChoose.this.N.setTag(Integer.valueOf(R.drawable.fqz));
            QQCustomDialogWtihInputAndChoose.this.d0();
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            View view2 = QQCustomDialogWtihInputAndChoose.this.f307204a0;
            if (view != view2) {
                if (view2 != null) {
                    view2.findViewById(R.id.eaq).setVisibility(8);
                }
                QQCustomDialogWtihInputAndChoose.this.g0(((TextView) view.findViewById(R.id.ear)).getText().toString());
                view.findViewById(R.id.eaq).setVisibility(0);
                QQCustomDialogWtihInputAndChoose.this.f307204a0 = view;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements MyLinearLayout.a {
        d() {
        }

        @Override // com.tencent.mobileqq.qwallet.widget.MyLinearLayout.a
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                QQCustomDialogWtihInputAndChoose qQCustomDialogWtihInputAndChoose = QQCustomDialogWtihInputAndChoose.this;
                if (qQCustomDialogWtihInputAndChoose.T) {
                    qQCustomDialogWtihInputAndChoose.d0();
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307212d;

        e(DialogInterface.OnClickListener onClickListener) {
            this.f307212d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307212d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialogWtihInputAndChoose.this, 0);
                QQCustomDialogWtihInputAndChoose.this.d0();
            }
            try {
                if (QQCustomDialogWtihInputAndChoose.this.isShowing()) {
                    QQCustomDialogWtihInputAndChoose.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307214d;

        f(DialogInterface.OnClickListener onClickListener) {
            this.f307214d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList<String> arrayList;
            EventCollector.getInstance().onViewClickedBefore(view);
            String inputValue = QQCustomDialogWtihInputAndChoose.this.getInputValue();
            if (!TextUtils.isEmpty(inputValue) && (arrayList = QQCustomDialogWtihInputAndChoose.this.Z) != null && arrayList.size() > 0) {
                for (int i3 = 0; i3 < QQCustomDialogWtihInputAndChoose.this.Z.size() && !inputValue.equals(QQCustomDialogWtihInputAndChoose.this.Z.get(i3)); i3++) {
                }
            }
            DialogInterface.OnClickListener onClickListener = this.f307214d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialogWtihInputAndChoose.this, 1);
                QQCustomDialogWtihInputAndChoose.this.d0();
            }
            try {
                if (QQCustomDialogWtihInputAndChoose.this.isShowing()) {
                    QQCustomDialogWtihInputAndChoose.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QQCustomDialogWtihInputAndChoose(Context context, int i3) {
        super(context, i3);
        this.L = false;
        this.Q = new Handler();
        this.V = 267.0f;
        this.W = 45.5f;
        this.X = 39.0f;
        this.Y = true;
        this.Z = new ArrayList<>();
        this.f307205b0 = new b();
        this.K = new SoftReference<>(context);
        getWindow().setSoftInputMode(19);
        this.R = (WindowManager) context.getSystemService("window");
    }

    int c0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public void d0() {
        if (this.T) {
            this.R.removeView(this.P);
            this.T = false;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.y = 0;
            getWindow().setAttributes(attributes);
        }
    }

    void e0(Context context) {
        MyLinearLayout myLinearLayout = (MyLinearLayout) View.inflate(context, R.layout.f167869k2, null);
        this.P = myLinearLayout;
        myLinearLayout.findViewById(R.id.eav).setOnClickListener(this);
        this.P.setDispatchKeyEventListener(new d());
    }

    public void f0(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.Z = arrayList;
            float f16 = getContext().getResources().getDisplayMetrics().density;
            LinearLayout linearLayout = (LinearLayout) this.P.findViewById(R.id.eas);
            linearLayout.removeAllViews();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                View inflate = View.inflate(getContext(), R.layout.k3, null);
                inflate.setTag(Integer.valueOf(i3));
                inflate.setClickable(true);
                inflate.setOnClickListener(this.f307205b0);
                ((TextView) inflate.findViewById(R.id.ear)).setText(arrayList.get(i3));
                linearLayout.addView(inflate, new LinearLayout.LayoutParams(-1, (int) (45.5f * f16)));
            }
            if (arrayList.size() >= 5) {
                this.S = new WindowManager.LayoutParams(-1, (int) (f16 * 267.0f), 2, 32, -1);
            } else {
                this.S = new WindowManager.LayoutParams(-1, (int) (((arrayList.size() * 45.5f) + 39.0f + 2.0f) * f16), 2, 32, -1);
            }
            this.S.gravity = 81;
        }
    }

    public void g0(String str) {
        if (str != null) {
            this.M.setText(str);
            EditText editText = this.M;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public EditText getEditText() {
        return this.M;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public String getInputValue() {
        return this.M.getText().toString();
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public void hideSoftInputFromWindow() {
        if (this.M != null) {
            ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.M.getWindowToken(), 0);
        }
    }

    public void i0(int i3) {
        EditText editText = this.M;
        if (editText != null) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
            this.M.addTextChangedListener(new c(i3));
        }
    }

    public void j0(boolean z16) {
        this.L = z16;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.dmn) {
            if (this.P != null) {
                if (this.T) {
                    d0();
                    this.N.setImageResource(R.drawable.fqz);
                    this.N.setTag(Integer.valueOf(R.drawable.fqz));
                    this.Q.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.5
                        @Override // java.lang.Runnable
                        public void run() {
                            InputMethodUtil.show(QQCustomDialogWtihInputAndChoose.this.M);
                        }
                    }, 200L);
                } else {
                    Object tag = this.N.getTag();
                    if (tag != null && (tag instanceof Integer) && ((Integer) tag).intValue() == R.drawable.buz) {
                        InputMethodUtil.show(this.M);
                        this.N.setImageResource(R.drawable.fqz);
                        this.N.setTag(Integer.valueOf(R.drawable.fqz));
                        this.T = false;
                    } else {
                        InputMethodUtil.hide(this.M);
                        this.N.setImageResource(R.drawable.buz);
                        this.N.setTag(Integer.valueOf(R.drawable.buz));
                        this.Q.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.6
                            @Override // java.lang.Runnable
                            public void run() {
                                QQCustomDialogWtihInputAndChoose qQCustomDialogWtihInputAndChoose = QQCustomDialogWtihInputAndChoose.this;
                                WindowManager.LayoutParams layoutParams = qQCustomDialogWtihInputAndChoose.S;
                                if (layoutParams == null) {
                                    return;
                                }
                                qQCustomDialogWtihInputAndChoose.R.addView(qQCustomDialogWtihInputAndChoose.P, layoutParams);
                                QQCustomDialogWtihInputAndChoose qQCustomDialogWtihInputAndChoose2 = QQCustomDialogWtihInputAndChoose.this;
                                qQCustomDialogWtihInputAndChoose2.T = true;
                                qQCustomDialogWtihInputAndChoose2.P.post(new Runnable() { // from class: com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.6.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        int i3;
                                        LinearLayout linearLayout;
                                        QQCustomDialogWtihInputAndChoose qQCustomDialogWtihInputAndChoose3 = QQCustomDialogWtihInputAndChoose.this;
                                        int c06 = qQCustomDialogWtihInputAndChoose3.c0(qQCustomDialogWtihInputAndChoose3.P);
                                        QQCustomDialogWtihInputAndChoose qQCustomDialogWtihInputAndChoose4 = QQCustomDialogWtihInputAndChoose.this;
                                        int c07 = qQCustomDialogWtihInputAndChoose4.c0(qQCustomDialogWtihInputAndChoose4.U);
                                        int height = QQCustomDialogWtihInputAndChoose.this.U.getHeight();
                                        int i16 = c06 - height;
                                        WindowManager.LayoutParams attributes = QQCustomDialogWtihInputAndChoose.this.getWindow().getAttributes();
                                        if (i16 > 0) {
                                            i3 = QQCustomDialogWtihInputAndChoose.this.P.getHeight() / 2;
                                        } else {
                                            i3 = (c07 + height) - c06;
                                        }
                                        attributes.y = -i3;
                                        QQCustomDialogWtihInputAndChoose.this.getWindow().setAttributes(attributes);
                                        QQCustomDialogWtihInputAndChoose qQCustomDialogWtihInputAndChoose5 = QQCustomDialogWtihInputAndChoose.this;
                                        int i17 = 0;
                                        if (qQCustomDialogWtihInputAndChoose5.Y && qQCustomDialogWtihInputAndChoose5.M.getText() != null && TextUtils.isEmpty(QQCustomDialogWtihInputAndChoose.this.M.getText().toString()) && (linearLayout = (LinearLayout) QQCustomDialogWtihInputAndChoose.this.P.findViewById(R.id.eas)) != null && linearLayout.getChildCount() > 0) {
                                            View childAt = linearLayout.getChildAt(0);
                                            TextView textView = (TextView) childAt.findViewById(R.id.ear);
                                            if (textView.getText() != null) {
                                                QQCustomDialogWtihInputAndChoose.this.g0(textView.getText().toString());
                                            }
                                            View findViewById = childAt.findViewById(R.id.eaq);
                                            findViewById.setVisibility(0);
                                            QQCustomDialogWtihInputAndChoose qQCustomDialogWtihInputAndChoose6 = QQCustomDialogWtihInputAndChoose.this;
                                            qQCustomDialogWtihInputAndChoose6.f307204a0 = findViewById;
                                            qQCustomDialogWtihInputAndChoose6.Y = false;
                                        }
                                        if (QLog.isColorLevel()) {
                                            Context context = QQCustomDialogWtihInputAndChoose.this.K.get();
                                            if (context != null) {
                                                i17 = context.getResources().getDisplayMetrics().heightPixels;
                                            }
                                            StringBuilder sb5 = new StringBuilder(128);
                                            if (context == null) {
                                                sb5.append("|context is null");
                                            } else {
                                                sb5.append("|context is not null");
                                            }
                                            sb5.append("|screenHeight=");
                                            sb5.append(i17);
                                            sb5.append("|emoSpaceY=");
                                            sb5.append(c06);
                                            sb5.append("|dialogY=");
                                            sb5.append(c07);
                                            sb5.append("|dialogHeight=");
                                            sb5.append(height);
                                            sb5.append("|moveY=");
                                            sb5.append(i3);
                                            QLog.d("QQCustomDialogWtihInputAndChoose.meassure", 2, sb5.toString());
                                        }
                                    }
                                });
                            }
                        }, 200L);
                    }
                }
            }
        } else if (view.getId() == R.id.eav) {
            d0();
        } else {
            d0();
            InputMethodUtil.hide(this.M);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return super.onTouchEvent(motionEvent);
        }
        d0();
        InputMethodUtil.hide(this.M);
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.cw, com.tencent.mobileqq.utils.QQCustomDialog, android.app.Dialog
    @TargetApi(11)
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.U = (RelativeLayout) findViewById(R.id.bja);
        this.M = (EditText) findViewById(R.id.input);
        ImageView imageView = (ImageView) findViewById(R.id.dmn);
        this.N = imageView;
        imageView.setOnClickListener(this);
        findViewById(R.id.iie).setOnClickListener(this);
        this.M.setSingleLine(this.L);
        this.M.setOnTouchListener(new a());
        Context context = this.K.get();
        if (context == null) {
            return;
        }
        com.tencent.devicelib.a.a(context, this.M);
        e0(context);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public void setEditLint(String str) {
        this.M.setHint(str);
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public QQCustomDialog setMessage(CharSequence charSequence) {
        TextView textView = (TextView) findViewById(R.id.bis);
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setText(charSequence);
            textView.setContentDescription(charSequence);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        return this;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public QQCustomDialog setNegativeButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(i3);
        this.lBtn.setContentDescription(getContext().getString(i3) + getContext().getString(R.string.a_n));
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new e(onClickListener));
        setSeperatorState();
        return this;
    }

    @Override // com.tencent.mobileqq.utils.QQCustomDialog
    public QQCustomDialog setPositiveButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(i3);
        this.rBtn.setContentDescription(getContext().getString(i3));
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new f(onClickListener));
        setSeperatorState();
        return this;
    }

    @Override // com.tencent.mobileqq.utils.cw, com.tencent.mobileqq.utils.QQCustomDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f307209d;

        c(int i3) {
            this.f307209d = i3;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            int length = QQCustomDialogWtihInputAndChoose.this.M.getText().length();
            int i18 = this.f307209d;
            if (length == i18 && charSequence.charAt(i18 - 1) == 20) {
                QQCustomDialogWtihInputAndChoose.this.M.setText(charSequence.subSequence(0, this.f307209d - 1));
                QQCustomDialogWtihInputAndChoose.this.M.setSelection(this.f307209d - 1);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
