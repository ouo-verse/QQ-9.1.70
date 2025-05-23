package com.tencent.mobileqq.tianshu.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchImageHelper;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RedTouchImageHelperImpl implements IRedTouchImageHelper {
    static IPatchRedirector $redirector_ = null;
    public static final int PROMOTION_IMG_HEIGHT = 28;
    public static final int PROMOTION_IMG_WIDTH = 42;
    public static final int RED_POINT_MARGIN = 2;

    public RedTouchImageHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final int dp2px(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    private FrameLayout getRedOnTheTonAndRight(ImageView imageView, Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dp2px(42.0f, context.getResources()), dp2px(28.0f, context.getResources())));
        frameLayout.addView(imageView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageResource(R.drawable.skin_tips_dot);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        int dp2px = dp2px(2.0f, context.getResources());
        layoutParams.topMargin = dp2px;
        layoutParams.rightMargin = dp2px;
        imageView2.setLayoutParams(layoutParams);
        frameLayout.addView(imageView2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        frameLayout.setLayoutParams(layoutParams2);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.tianshu.api.IRedTouchImageHelper
    public View getApngImageView(String str, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) context);
        }
        int dp2px = dp2px(42.0f, context.getResources());
        int dp2px2 = dp2px(28.0f, context.getResources());
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp2px, dp2px2);
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setRequestWidth(dp2px);
        apngOptions.setRequestHeight(dp2px2);
        imageView.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("IRedTouchImageHelper", str, apngOptions));
        return getRedOnTheTonAndRight(imageView, context);
    }
}
