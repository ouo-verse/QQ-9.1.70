package com.tencent.biz.pubaccount.imagecollection;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class PublicAccountImageCollectionCommentActivity extends BaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    private View f79687a0;

    /* renamed from: b0, reason: collision with root package name */
    private EditText f79688b0;

    /* renamed from: c0, reason: collision with root package name */
    private CheckBox f79689c0;

    /* renamed from: d0, reason: collision with root package name */
    private Button f79690d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f79691e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f79692f0;

    /* loaded from: classes32.dex */
    class b implements TextView.OnEditorActionListener {
        b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            return keyEvent.getKeyCode() == 66;
        }
    }

    /* loaded from: classes32.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PublicAccountImageCollectionCommentActivity.this.Q2();
            PublicAccountImageCollectionCommentActivity.this.P2(0);
        }
    }

    /* loaded from: classes32.dex */
    class d implements ViewTreeObserver.OnGlobalLayoutListener {
        d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int height = PublicAccountImageCollectionCommentActivity.this.f79687a0.getRootView().getHeight() - PublicAccountImageCollectionCommentActivity.this.f79687a0.getHeight();
            if (QLog.isDevelopLevel()) {
                QLog.d("ImageCollectionCommentActivity", 2, "heightDiff:" + height);
            }
            if (height > 150) {
                PublicAccountImageCollectionCommentActivity.this.f79692f0 = true;
            } else if (PublicAccountImageCollectionCommentActivity.this.f79692f0) {
                PublicAccountImageCollectionCommentActivity.this.f79692f0 = false;
                PublicAccountImageCollectionCommentActivity.this.P2(0);
            }
        }
    }

    /* loaded from: classes32.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PublicAccountImageCollectionCommentActivity.this.Q2();
            PublicAccountImageCollectionCommentActivity.this.P2(-1);
            PublicAccountImageCollectionCommentActivity.this.f79691e0 = false;
        }
    }

    /* loaded from: classes32.dex */
    class f implements CompoundButton.OnCheckedChangeListener {
        f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            PublicAccountImageCollectionCommentActivity.this.f79691e0 = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M2(String str) {
        boolean N2 = N2(str);
        this.f79690d0.setEnabled(N2);
        if (N2) {
            this.f79690d0.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.f79690d0.setTextColor(Color.parseColor("#9D9D9D"));
        }
    }

    private boolean N2(String str) {
        return (TextUtils.isEmpty(str) || str.trim().length() == 0 || str.length() > 100) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2(int i3) {
        this.f79687a0.setVisibility(8);
        String obj = this.f79688b0.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("comment", obj);
        intent.putExtra("anonymous", this.f79691e0);
        setResult(i3, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2() {
        this.f79688b0.clearFocus();
        ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f79688b0.getWindowToken(), 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mNeedStatusTrans = false;
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f168411ve);
        View findViewById = findViewById(R.id.b39);
        this.f79687a0 = findViewById;
        EditText editText = (EditText) findViewById.findViewById(R.id.b36);
        this.f79688b0 = editText;
        editText.requestFocus();
        this.f79688b0.addTextChangedListener(new a());
        this.f79688b0.setOnEditorActionListener(new b());
        this.f79687a0.findViewById(R.id.f164847b30).setOnClickListener(new c());
        this.f79687a0.getViewTreeObserver().addOnGlobalLayoutListener(new d());
        Button button = (Button) findViewById(R.id.f166847in3);
        this.f79690d0 = button;
        button.setOnClickListener(new e());
        this.f79691e0 = getIntent().getBooleanExtra("anonymous", false);
        CheckBox checkBox = (CheckBox) findViewById(R.id.f164337sc);
        this.f79689c0 = checkBox;
        checkBox.setChecked(this.f79691e0);
        this.f79689c0.setOnCheckedChangeListener(new f());
        String stringExtra = getIntent().getStringExtra("comment");
        if (TextUtils.isEmpty(stringExtra)) {
            return true;
        }
        this.f79688b0.setText(stringExtra);
        this.f79688b0.setSelection(stringExtra.length());
        M2(stringExtra);
        return true;
    }

    /* loaded from: classes32.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PublicAccountImageCollectionCommentActivity.this.M2(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (TextUtils.isEmpty(charSequence) || (charSequence.length() - i16) + i17 <= 100) {
                return;
            }
            PublicAccountImageCollectionCommentActivity publicAccountImageCollectionCommentActivity = PublicAccountImageCollectionCommentActivity.this;
            QQToast.makeText(publicAccountImageCollectionCommentActivity, 0, publicAccountImageCollectionCommentActivity.getString(R.string.d5x), 0).show(PublicAccountImageCollectionCommentActivity.this.getTitleBarHeight());
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
