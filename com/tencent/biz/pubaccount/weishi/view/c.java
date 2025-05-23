package com.tencent.biz.pubaccount.weishi.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends Dialog {

    /* renamed from: d, reason: collision with root package name */
    private View f82443d;

    /* renamed from: e, reason: collision with root package name */
    private String f82444e;

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        TextView textView;
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fxa, (ViewGroup) null);
        Window window = getWindow();
        window.setContentView(inflate);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        if (!TextUtils.isEmpty(this.f82444e) && (textView = (TextView) inflate.findViewById(R.id.f18)) != null) {
            textView.setText(this.f82444e);
        }
        this.f82443d = inflate;
        setCanceledOnTouchOutside(false);
    }

    public c(Context context, String str) {
        super(context, R.style.f173741jd);
        this.f82444e = str;
    }
}
