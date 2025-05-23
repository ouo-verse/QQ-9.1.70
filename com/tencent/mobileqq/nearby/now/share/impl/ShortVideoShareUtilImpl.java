package com.tencent.mobileqq.nearby.now.share.impl;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.share.IShortVideoShareUtil;
import mqq.app.AppActivity;
import p92.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ShortVideoShareUtilImpl implements IShortVideoShareUtil {
    @Override // com.tencent.mobileqq.nearby.now.share.IShortVideoShareUtil
    public Bitmap drawableToBitmap(Drawable drawable) {
        return a.a(drawable);
    }

    @Override // com.tencent.mobileqq.nearby.now.share.IShortVideoShareUtil
    public Bitmap makeShareBitmap(String str) {
        return a.b(str);
    }

    @Override // com.tencent.mobileqq.nearby.now.share.IShortVideoShareUtil
    public void showShareActionSheet(AppInterface appInterface, AppActivity appActivity, String str, String str2, String str3, String str4, String str5, String str6, String str7, URLDrawable uRLDrawable, DialogInterface.OnDismissListener onDismissListener) {
        a.c((QQAppInterface) appInterface, (BaseActivity) appActivity, str, str2, str3, str4, str5, str6, str7, uRLDrawable, onDismissListener);
    }
}
