package com.tencent.now.pkgame.pkgame.animation;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    public static void a(String str, ImageView imageView) {
        imageView.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(a.class.getName(), str, b(1)));
    }

    private static ApngOptions b(int i3) {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(i3);
        apngOptions.setUseCache(true);
        return apngOptions;
    }

    private void c(ImageView imageView, URLDrawable uRLDrawable) {
        i f16 = x.f(imageView.getContext());
        float intrinsicWidth = (uRLDrawable.getIntrinsicWidth() * 1.0f) / uRLDrawable.getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (uRLDrawable.getIntrinsicWidth() >= 0 && uRLDrawable.getIntrinsicHeight() >= 0) {
            int i3 = f16.f185860a;
            layoutParams.height = (int) ((i3 * 1.0f) / intrinsicWidth);
            layoutParams.width = i3;
        } else {
            layoutParams.height = 0;
            layoutParams.width = 0;
        }
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(uRLDrawable);
    }

    public void d(ImageView imageView, ImageView imageView2) {
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(a.class.getName(), "https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEJ3KEZ1DBTgFTxxdENGzoZbtTl61Bgj5yiaTvp2bJLqm9w/", b(0));
        URLDrawable apngURLDrawable2 = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(a.class.getName(), "https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEIKdIZoibWQ0kPOwHWD4bXiaxjicDZqvGM0XpwJcY0ibBFPpA/", b(0));
        c(imageView, apngURLDrawable);
        c(imageView2, apngURLDrawable2);
    }
}
