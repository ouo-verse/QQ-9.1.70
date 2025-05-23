package com.tencent.mobileqq.kandian.biz.common;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ReadInJoyBaseActivity extends BaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    protected float f239249a0;

    /* renamed from: c0, reason: collision with root package name */
    public View f239251c0;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f239252d0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f239250b0 = -1;

    /* renamed from: e0, reason: collision with root package name */
    protected View.OnClickListener f239253e0 = new a();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ReadInJoyBaseActivity.this.onBackEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        finish();
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i3) {
        if (!this.mNeedStatusTrans) {
            super.setContentView(i3);
            this.f239250b0 = i3;
            getWindow().setFeatureInt(7, R.layout.f167828is);
        }
        View view = this.f239251c0;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f239249a0 = getResources().getDisplayMetrics().density;
        init(getIntent());
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f239252d0;
        if (textView == null || !(textView instanceof TextView)) {
            return;
        }
        textView.setText(charSequence);
        super.setTitle(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(7);
    }

    @Override // android.app.Activity
    public void setTitle(int i3) {
        setTitle(getString(i3));
    }

    protected void init(Intent intent) {
    }
}
