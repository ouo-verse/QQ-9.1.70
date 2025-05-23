package com.tencent.biz.qqcircle.immersive.utils.ad;

import android.graphics.drawable.ColorDrawable;
import com.tencent.image.URLDrawable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {
    public static URLDrawable a(String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        return URLDrawable.getDrawable(str, obtain);
    }
}
