package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes5.dex */
public class MoreCommentPanel extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private Context f95937d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f95938e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f95939f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f95940h;

    public MoreCommentPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95940h = false;
        this.f95937d = context;
        a();
    }

    private void a() {
        try {
            LayoutInflater.from(this.f95937d).inflate(R.layout.bu8, this);
            this.f95938e = (TextView) findViewById(R.id.f166318f03);
            this.f95939f = (ImageView) findViewById(R.id.f166316f01);
            if (this.f95940h) {
                setBackgroundColor(this.f95937d.getResources().getColor(R.color.a_x));
                setBackgroundResource(R.drawable.gi7);
                this.f95938e.setTextColor(this.f95937d.getResources().getColor(R.color.f156803br));
                this.f95939f.setImageResource(R.drawable.gi5);
            } else {
                setBackgroundColor(this.f95937d.getResources().getColor(R.color.f157363np));
                setBackgroundResource(R.drawable.gi6);
            }
        } catch (OutOfMemoryError e16) {
            QLog.e("MoreCommentPanel", 1, "init OOM", e16);
            System.gc();
        }
    }

    public void setHintText(CharSequence charSequence) {
        TextView textView = this.f95938e;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public MoreCommentPanel(Context context) {
        super(context);
        this.f95940h = false;
        this.f95937d = context;
        a();
    }
}
