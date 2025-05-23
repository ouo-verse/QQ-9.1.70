package com.tencent.mobileqq.qqvideoedit.editor.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* loaded from: classes17.dex */
public class ProgressView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private ProgressBar f275847d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f275848e;

    public ProgressView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.f168383uh, this);
        this.f275847d = (ProgressBar) findViewById(R.id.f166511fq3);
        this.f275848e = (TextView) findViewById(R.id.photo_prievew_progress_dialog_text);
    }

    public void setProgressText(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0) {
            this.f275848e.setVisibility(0);
            this.f275848e.setText(charSequence);
        } else {
            this.f275848e.setVisibility(8);
        }
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
