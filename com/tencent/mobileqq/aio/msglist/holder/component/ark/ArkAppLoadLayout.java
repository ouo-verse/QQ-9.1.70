package com.tencent.mobileqq.aio.msglist.holder.component.ark;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOTokenUtilsApi;
import com.tencent.util.LoadingUtil;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppLoadLayout extends RelativeLayout {
    public ArkAppLoadLayout(Context context) {
        super(context);
    }

    private void a() {
        int realTokenColor = ((IAIOTokenUtilsApi) a.b(IAIOTokenUtilsApi.class)).getRealTokenColor("fill_standard_primary", R.color.b6e);
        int realTokenColor2 = ((IAIOTokenUtilsApi) a.b(IAIOTokenUtilsApi.class)).getRealTokenColor("border_light", R.color.b6d);
        int i3 = (int) (getContext().getResources().getDisplayMetrics().density * 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke((int) (getContext().getResources().getDisplayMetrics().density * 0.5d), realTokenColor2);
        gradientDrawable.setCornerRadius(i3);
        gradientDrawable.setColor(realTokenColor);
        setBackground(gradientDrawable);
    }

    public void b(String str, boolean z16) {
        int i3;
        ImageView imageView = (ImageView) findViewById(R.id.yrs);
        TextView textView = (TextView) findViewById(R.id.f166128ys2);
        if (imageView != null && textView != null) {
            requestLayout();
            textView.setTextColor(((IAIOTokenUtilsApi) a.b(IAIOTokenUtilsApi.class)).getRealTokenColor("text_secondary", R.color.b6g));
            if (str == null) {
                textView.setText(getResources().getString(R.string.f170470s5));
            } else {
                textView.setText(str);
            }
            if (z16) {
                i3 = R.drawable.c_j;
            } else {
                i3 = R.drawable.c_i;
            }
            imageView.getResources().getDrawable(i3).setColorFilter(((IAIOTokenUtilsApi) a.b(IAIOTokenUtilsApi.class)).getRealTokenColor("icon_secondary", R.color.b6f), PorterDuff.Mode.SRC_IN);
            imageView.setImageDrawable(imageView.getResources().getDrawable(i3));
            a();
        }
    }

    public void c() {
        ImageView imageView = (ImageView) findViewById(R.id.yrs);
        TextView textView = (TextView) findViewById(R.id.f166128ys2);
        if (imageView != null && textView != null) {
            Drawable loadingDrawable = LoadingUtil.getLoadingDrawable(getContext(), 2);
            if (loadingDrawable != null) {
                imageView.setImageDrawable(loadingDrawable);
            }
            textView.setText(getResources().getString(R.string.f170468s3));
            a();
        }
    }

    public ArkAppLoadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ArkAppLoadLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void setArkView(ArkViewImplement arkViewImplement) {
    }
}
