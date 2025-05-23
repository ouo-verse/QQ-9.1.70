package com.tencent.pubaccount.publish;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qzone.common.activities.titlebuilder.QzoneBaseTitle;
import com.qzone.common.activities.titlebuilder.f;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes34.dex */
public class b extends QzoneBaseTitle {

    /* renamed from: a0, reason: collision with root package name */
    public TextView f342318a0;

    public b(f fVar) {
        super(fVar);
    }

    public void E(int i3, String str, int i16, boolean z16) {
        TextView textView = this.f342318a0;
        if (textView != null) {
            textView.setVisibility(i3);
            this.f342318a0.setTextColor(i16);
            this.f342318a0.setEnabled(z16);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f342318a0.setText(str);
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.QzoneBaseTitle, com.qzone.common.activities.titlebuilder.a
    public void E1(int i3, int i16, boolean z16) {
        super.E1(i3, i16, z16);
        TextView textView = this.f45555d;
        if (textView != null) {
            textView.setTextColor(-16777216);
            this.f45555d.setBackgroundResource(0);
        }
        TextView textView2 = this.f45557f;
        if (textView2 != null) {
            textView2.setTextColor(getResources().getColorStateList(R.color.f157916aa0));
            this.f45557f.setBackgroundResource(R.drawable.art);
            this.f45557f.setTextSize(2, 14.0f);
            this.f45557f.setPadding(ar.e(15.0f), ar.e(3.5f), ar.e(15.0f), ar.e(3.5f));
            this.f45557f.getLayoutParams().height = ar.e(29.0f);
        }
        TextView textView3 = this.f342318a0;
        if (textView3 != null) {
            textView3.setBackgroundResource(R.drawable.a_3);
            this.f342318a0.setTextSize(2, 14.0f);
            this.f342318a0.setPadding(ar.e(15.0f), ar.e(3.5f), ar.e(15.0f), ar.e(3.5f));
            this.f342318a0.getLayoutParams().height = ar.e(29.0f);
        }
        ViewGroup viewGroup = this.M;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(-1);
        }
        ViewGroup viewGroup2 = this.f45558h;
        if (viewGroup2 != null) {
            viewGroup2.setBackgroundResource(0);
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.QzoneBaseTitle, com.qzone.common.activities.titlebuilder.a
    public void K3(Intent intent) {
        super.K3(intent);
        TextView textView = (TextView) d(R.id.b9f);
        this.f342318a0 = textView;
        textView.setText(R.string.vxg);
        QzoneBaseTitle.C(this.f342318a0);
    }
}
