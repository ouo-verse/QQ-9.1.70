package com.tencent.now.linkpkanchorplay.base;

import an3.a;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ilive.widget.circleimageview.CircleImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.utils.c;
import com.tencent.now.app.misc.ui.UIUtil;

/* loaded from: classes22.dex */
public class LinkPKHeadImageView extends CircleImageView {
    public LinkPKHeadImageView(Context context) {
        super(context);
        e();
    }

    private void e() {
        c.b(this, a.INSTANCE.b());
        setImageResource(R.drawable.ogj);
        setBorderWidth(UIUtil.b(getContext(), 2.0f));
        setBorderColor(0);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void f(boolean z16) {
        if (z16) {
            c.b(this, a.INSTANCE.b());
            setBorderWidth(UIUtil.b(getContext(), 2.0f));
        } else {
            setBackground(null);
            setBorderWidth(0);
        }
    }

    public LinkPKHeadImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        e();
    }
}
