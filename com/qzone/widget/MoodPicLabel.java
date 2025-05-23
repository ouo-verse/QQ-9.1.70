package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* loaded from: classes37.dex */
public class MoodPicLabel extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f60419d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f60420e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f60421f;

    public MoodPicLabel(Context context) {
        super(context);
        d(context, null);
    }

    public ImageView a() {
        return this.f60420e;
    }

    public TextView b() {
        return this.f60421f;
    }

    public String c() {
        return this.f60421f.getText().toString();
    }

    public void setCheck(boolean z16) {
        super.setSelected(z16);
    }

    public void setContainerBackgroundResource(int i3) {
        this.f60419d.setBackgroundResource(i3);
    }

    public void setText(String str) {
        TextView textView = this.f60421f;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        this.f60421f.setContentDescription(str);
    }

    public MoodPicLabel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context, attributeSet);
    }

    public void setImageAndText(Drawable drawable, String str) {
        if (drawable != null) {
            this.f60420e.setImageDrawable(drawable);
        }
        this.f60421f.setText(str);
        this.f60421f.setContentDescription(str);
    }

    public MoodPicLabel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        d(context, attributeSet);
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray typedArray;
        int i3 = R.layout.bn5;
        if (attributeSet != null) {
            typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.MoodPicLabel);
            i3 = typedArray.getResourceId(3, R.layout.bn5);
        } else {
            typedArray = null;
        }
        LayoutInflater.from(context).inflate(i3, this);
        this.f60419d = findViewById(R.id.b8q);
        this.f60420e = (ImageView) findViewById(R.id.ezj);
        TextView textView = (TextView) findViewById(R.id.ezi);
        this.f60421f = textView;
        textView.setClickable(false);
        this.f60421f.setFocusable(false);
        if (typedArray != null) {
            Drawable drawable = typedArray.getDrawable(1);
            ImageView imageView = this.f60420e;
            if (imageView != null && drawable != null) {
                imageView.setImageDrawable(drawable);
            }
            String string = typedArray.getString(2);
            if (!TextUtils.isEmpty(string)) {
                this.f60421f.setText(string);
            }
            String string2 = typedArray.getString(0);
            if (!TextUtils.isEmpty(string2)) {
                this.f60421f.setContentDescription(string2);
            }
            this.f60421f.setTextColor(context.getResources().getColor(typedArray.getResourceId(4, R.color.qui_common_text_secondary)));
            typedArray.recycle();
        }
    }
}
