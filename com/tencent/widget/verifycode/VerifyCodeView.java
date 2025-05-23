package com.tencent.widget.verifycode;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.verifycode.VerifyCodeItemView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VerifyCodeView extends RelativeLayout {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VerifyCodeView";
    private static final int VERIFY_CODE_DEFAULT_NUMBER = 4;
    private static final int VERIFY_CODE_DEFAULT_TEXT_SIZE = 28;
    private int mCodeNumber;
    private Context mContext;
    List<VerifyCodeItemView> mEditViews;
    private LinearLayout mLlContent;
    private OnInputListener mOnInputListener;
    private int mTextColor;
    private int mTextSize;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnInputListener {
        void onInputFinish(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VerifyCodeItemView f384860d;

        a(VerifyCodeItemView verifyCodeItemView) {
            this.f384860d = verifyCodeItemView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerifyCodeView.this, (Object) verifyCodeItemView);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            if (editable != null && editable.length() > 0) {
                String obj = editable.toString();
                int id5 = this.f384860d.getId();
                String str = "";
                if (obj.length() + id5 <= VerifyCodeView.this.mCodeNumber) {
                    if (obj.length() > 1 && id5 < VerifyCodeView.this.mCodeNumber - 1) {
                        for (int i3 = id5; i3 < VerifyCodeView.this.mEditViews.size(); i3++) {
                            VerifyCodeView.this.mEditViews.get(i3).setText("");
                        }
                        for (int i16 = 0; i16 < obj.length(); i16++) {
                            VerifyCodeView.this.operationVerifyCode(i16 + id5, obj.charAt(i16) + "");
                        }
                        VerifyCodeView.this.mEditViews.get((id5 + obj.length()) - 1).setSelection(1);
                        return;
                    }
                    if (id5 < VerifyCodeView.this.mCodeNumber - 1) {
                        VerifyCodeView.this.operationVerifyCode(id5 + 1, "");
                        return;
                    }
                    for (int i17 = 0; i17 < VerifyCodeView.this.mCodeNumber; i17++) {
                        str = str + ((Object) VerifyCodeView.this.mEditViews.get(i17).getText());
                    }
                    if (VerifyCodeView.this.mOnInputListener != null) {
                        VerifyCodeView verifyCodeView = VerifyCodeView.this;
                        VerifyCodeItemView verifyCodeItemView = verifyCodeView.mEditViews.get(verifyCodeView.mCodeNumber - 1);
                        verifyCodeItemView.clearFocus();
                        verifyCodeItemView.setEnabled(false);
                        VerifyCodeView.this.mOnInputListener.onInputFinish(str);
                        return;
                    }
                    return;
                }
                this.f384860d.setText("");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b implements View.OnKeyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VerifyCodeItemView f384862d;

        b(VerifyCodeItemView verifyCodeItemView) {
            this.f384862d = verifyCodeItemView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerifyCodeView.this, (Object) verifyCodeItemView);
            }
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 67 && keyEvent.getAction() == 0) {
                int id5 = this.f384862d.getId();
                if (this.f384862d.getText().toString().equals("")) {
                    if (id5 >= 1) {
                        VerifyCodeView.this.operationVerifyCode(id5 - 1, "");
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class c implements VerifyCodeItemView.OnTextContextMenuItemListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VerifyCodeView.this);
            }
        }

        @Override // com.tencent.widget.verifycode.VerifyCodeItemView.OnTextContextMenuItemListener
        public boolean onTextContextMenuItem(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str)).booleanValue();
            }
            if (str.length() > VerifyCodeView.this.mCodeNumber) {
                QLog.d(VerifyCodeView.TAG, 1, String.format("\u957f\u5ea6\u8d85\u8fc7 %s \u8bf7\u68c0\u67e5", String.valueOf(VerifyCodeView.this.mCodeNumber)));
            } else if (str.length() > 0) {
                for (int i16 = 0; i16 < VerifyCodeView.this.mEditViews.size(); i16++) {
                    VerifyCodeView.this.mEditViews.get(i16).setText("");
                }
                VerifyCodeView.this.operationVerifyCode(0, "");
                for (int i17 = 0; i17 < str.length(); i17++) {
                    VerifyCodeView.this.operationVerifyCode(i17, str.charAt(i17) + "");
                }
                VerifyCodeView.this.mEditViews.get(str.length() - 1).setSelection(1);
            }
            return false;
        }
    }

    public VerifyCodeView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void addChildView(int i3, int i16) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ScreenUtil.dip2px(60.0f), ScreenUtil.dip2px(67.0f));
        if (i3 > 0) {
            layoutParams.leftMargin = i16;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.i38, (ViewGroup) null);
        VerifyCodeItemView verifyCodeItemView = (VerifyCodeItemView) inflate.findViewById(R.id.f1068669v);
        verifyCodeItemView.setTextColor(this.mTextColor);
        verifyCodeItemView.setTextSize(this.mTextSize);
        verifyCodeItemView.setContentDescription(HardCodeUtil.qqStr(R.string.zxg) + (i3 + 1));
        verifyCodeItemView.setId(i3);
        verifyCodeItemView.addTextChangedListener(new a(verifyCodeItemView));
        verifyCodeItemView.setOnKeyListener(new b(verifyCodeItemView));
        verifyCodeItemView.setTextContentListener(new c());
        this.mLlContent.addView(inflate, layoutParams);
        this.mEditViews.add(verifyCodeItemView);
    }

    private int dip2pxCustom(float f16) {
        return (int) ((f16 * FontSettingManager.systemMetrics.density) + 0.5f);
    }

    private void initView() {
        this.mEditViews = new ArrayList();
        int realWidth = ScreenUtil.getRealWidth(this.mContext);
        int dip2px = ((realWidth - (ScreenUtil.dip2px(40.0f) * 2)) - (this.mCodeNumber * ScreenUtil.dip2px(60.0f))) / (this.mCodeNumber - 1);
        if (dip2px < 0 && FontSettingManager.isFontSizeLarge()) {
            dip2px = ((realWidth - (dip2pxCustom(40.0f) * 2)) - (this.mCodeNumber * dip2pxCustom(60.0f))) / (this.mCodeNumber - 1);
        }
        for (int i3 = 0; i3 < this.mCodeNumber; i3++) {
            addChildView(i3, dip2px);
        }
        this.mEditViews.get(this.mCodeNumber - 1).setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        VerifyCodeItemView verifyCodeItemView = this.mEditViews.get(0);
        verifyCodeItemView.setFocusable(true);
        verifyCodeItemView.setFocusableInTouchMode(true);
        verifyCodeItemView.requestFocus();
        verifyCodeItemView.setText("");
    }

    private void loadView(AttributeSet attributeSet) {
        this.mLlContent = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.i37, this).findViewById(R.id.ynq);
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, jj2.b.f410155oa);
        this.mTextColor = obtainStyledAttributes.getColor(jj2.b.f410167pa, getResources().getColor(R.color.qui_common_text_primary));
        this.mTextSize = obtainStyledAttributes.getColor(jj2.b.f410191ra, 28);
        this.mCodeNumber = obtainStyledAttributes.getInt(jj2.b.f410179qa, 4);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void operationVerifyCode(int i3, String str) {
        VerifyCodeItemView verifyCodeItemView = this.mEditViews.get(i3);
        verifyCodeItemView.setEnabled(true);
        verifyCodeItemView.setFocusable(true);
        verifyCodeItemView.setFocusableInTouchMode(true);
        verifyCodeItemView.requestFocus();
        verifyCodeItemView.setText(str);
        for (int i16 = 0; i16 < this.mCodeNumber && i16 != i3; i16++) {
            VerifyCodeItemView verifyCodeItemView2 = this.mEditViews.get(i16);
            verifyCodeItemView2.setEnabled(false);
            verifyCodeItemView2.setFocusable(false);
            verifyCodeItemView2.setFocusableInTouchMode(false);
        }
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        List<VerifyCodeItemView> list = this.mEditViews;
        if (list != null && !list.isEmpty()) {
            Iterator<VerifyCodeItemView> it = list.iterator();
            while (it.hasNext()) {
                it.next().setText("");
            }
            operationVerifyCode(0, "");
            InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.toggleSoftInput(2, 1);
            }
        }
    }

    public void setOnInputListener(OnInputListener onInputListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onInputListener);
        } else {
            this.mOnInputListener = onInputListener;
        }
    }

    public VerifyCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public VerifyCodeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mContext = context;
            loadView(attributeSet);
        }
    }
}
