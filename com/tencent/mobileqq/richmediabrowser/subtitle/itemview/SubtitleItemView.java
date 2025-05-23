package com.tencent.mobileqq.richmediabrowser.subtitle.itemview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.richmediabrowser.subtitle.itemview.SubtitleItemLoadingAnimator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SubtitleItemView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f281890d;

    /* renamed from: e, reason: collision with root package name */
    SubtitleItemLoadingAnimator f281891e;

    public SubtitleItemView(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        this.f281890d = (TextView) LayoutInflater.from(context).inflate(R.layout.hnn, (ViewGroup) this, true).findViewById(R.id.f906152y);
        this.f281891e = new SubtitleItemLoadingAnimator();
        c();
    }

    private void c() {
        this.f281891e.d(new SubtitleItemLoadingAnimator.a() { // from class: com.tencent.mobileqq.richmediabrowser.subtitle.itemview.SubtitleItemView.1
            @Override // com.tencent.mobileqq.richmediabrowser.subtitle.itemview.SubtitleItemLoadingAnimator.a
            public void a() {
                SubtitleItemView.this.f281890d.post(new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.subtitle.itemview.SubtitleItemView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SubtitleItemView.this.f281890d.setText(SubtitleItemView.this.f281891e.c());
                    }
                });
            }
        });
    }

    public void d(boolean z16) {
        int i3;
        this.f281890d.setText("");
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    public void e() {
        this.f281891e.e();
        d(true);
    }

    public void f() {
        this.f281891e.f();
        d(false);
    }

    public void setVideoSubtitleContent(String str) {
        this.f281890d.setText(str.replaceAll("\n", ""));
    }

    public SubtitleItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public SubtitleItemView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(context);
    }
}
