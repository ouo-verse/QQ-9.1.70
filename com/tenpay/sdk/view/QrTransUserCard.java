package com.tenpay.sdk.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QrTransUserCard extends FrameLayout {
    private TextView mAmount;
    protected Context mContext;
    protected ImageView mLogo;
    protected TextView mTitle;

    public QrTransUserCard(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context.getApplicationContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.ag9, (ViewGroup) this, true);
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        this.mTitle = textView;
        ol2.b.d(textView, 22);
        TextView textView2 = (TextView) inflate.findViewById(R.id.f164306ro);
        this.mAmount = textView2;
        ol2.b.c(textView2);
        this.mLogo = (ImageView) inflate.findViewById(R.id.f166149eh4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setAmount(int i3, String str) {
        this.mAmount.setText(str);
        if (i3 == 1) {
            this.mAmount.setTextColor(getResources().getColor(R.color.f157581tr));
        } else if (i3 == 2) {
            this.mAmount.setTextColor(getResources().getColor(R.color.f157675wg));
        } else {
            this.mAmount.setTextColor(getResources().getColor(R.color.f157581tr));
        }
    }

    public void setLogo(Bitmap bitmap) {
        this.mLogo.setBackgroundDrawable(new BitmapDrawable(bitmap));
    }

    public void setLogoDrawable(Drawable drawable) {
        this.mLogo.setImageDrawable(drawable);
    }

    public void setTitle(String str) {
        this.mTitle.setText(str);
    }

    public void setTitle(int i3) {
        this.mTitle.setText(i3);
    }

    public QrTransUserCard(Context context, AttributeSet attributeSet) {
        super(context);
        init(context);
    }

    public void setAmount(int i3) {
        this.mAmount.setText(i3);
    }
}
