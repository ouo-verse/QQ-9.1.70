package com.tencent.luggage.wxa.w3;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends Preference {

    /* renamed from: a, reason: collision with root package name */
    public boolean f144080a;

    /* renamed from: b, reason: collision with root package name */
    public String f144081b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f144082c;

    /* renamed from: d, reason: collision with root package name */
    public CheckBox f144083d;

    public c(Context context) {
        this(context, null);
    }

    public void a(int i3) {
        this.f144081b = getContext().getString(i3);
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.axa);
        this.f144083d = checkBox;
        if (checkBox != null) {
            checkBox.setChecked(this.f144080a);
        }
        TextView textView = (TextView) view.findViewById(R.id.sxg);
        this.f144082c = textView;
        if (textView != null && !w0.c(this.f144081b)) {
            this.f144082c.setText(this.f144081b);
        }
    }

    @Override // android.preference.Preference
    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.iex);
        viewGroup2.removeAllViews();
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.fdb, viewGroup2);
        return onCreateView;
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(boolean z16) {
        this.f144080a = z16;
        CheckBox checkBox = this.f144083d;
        if (checkBox != null) {
            checkBox.setChecked(z16);
        }
    }

    public c(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f144080a = false;
        setLayoutResource(R.layout.fdg);
    }
}
