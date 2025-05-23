package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSNormalNoMoreHintView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f89199d;

    public QFSNormalNoMoreHintView(@NonNull Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View.inflate(context, R.layout.g_a, this);
        this.f89199d = (TextView) findViewById(R.id.f47891yi);
    }

    public void setHintText(String str) {
        TextView textView = this.f89199d;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public void setHintTextColor(int i3) {
        TextView textView = this.f89199d;
        if (textView == null) {
            return;
        }
        textView.setTextColor(i3);
    }

    public QFSNormalNoMoreHintView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        TextView textView = this.f89199d;
        if (textView == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }
}
