package com.tencent.mobileqq.profilecard.component.instep;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;

/* loaded from: classes35.dex */
public abstract class ProfileInStepBaseCardHolder {
    /* JADX INFO: Access modifiers changed from: protected */
    public void initIconView(ImageView imageView, String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            imageView.setImageResource(R.drawable.g9b);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = imageView.getResources().getDrawable(R.drawable.qui_cardlist_icon_default);
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mUseApngImage = false;
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        if (drawable2.getStatus() == 2) {
            drawable2.restartDownload();
        }
        imageView.setImageDrawable(drawable2);
    }
}
