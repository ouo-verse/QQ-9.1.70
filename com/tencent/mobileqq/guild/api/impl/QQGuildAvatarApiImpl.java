package com.tencent.mobileqq.guild.api.impl;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildAvatarApiImpl implements IQQGuildAvatarApi {
    private static final String TAG = "QQGuildAvatarApiImpl";

    private Drawable getDrawable(String str, int i3, int i16, String str2, boolean z16) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(QQGuildUIUtil.j(z16));
        if (TextUtils.isEmpty(str)) {
            return bitmapDrawable;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = bitmapDrawable;
        obtain.mFailedDrawable = bitmapDrawable;
        if (z16) {
            if (str2 != null) {
                obtain.mMemoryCacheKeySuffix = str2 + "_isCircle";
            } else {
                obtain.mMemoryCacheKeySuffix = RedTouchConst.PicDownload.ISCIRCLE;
            }
        } else {
            obtain.mMemoryCacheKeySuffix = str2;
        }
        try {
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
            } else {
                drawable.setTag(new int[]{i3, i16});
                if (z16) {
                    drawable.setDecodeHandler(ch.f235510c);
                }
            }
            return drawable;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "getDrawable error, url:" + str + " exception:" + e16);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "getDrawable defaultDrawable, url:" + str);
            }
            return bitmapDrawable;
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildAvatarApi
    public Drawable getAvatarDrawable(String str, int i3, int i16, String str2) {
        return getDrawable(str, i3, i16, str2, true);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildAvatarApi
    public String getAvatarUrl(AppRuntime appRuntime, String str, String str2) {
        return ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getFullGuildUserUserAvatarUrl(str, str2, 0);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildAvatarApi
    public Drawable getDefaultFaceDrawable(boolean z16) {
        return QQGuildUIUtil.k(z16);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildAvatarApi
    public void loadCommonPic(String str, ImageView imageView) {
        com.tencent.mobileqq.guild.u.p(str, imageView);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildAvatarApi
    public Drawable getAvatarDrawable(String str, int i3, int i16, String str2, boolean z16) {
        return getDrawable(str, i3, i16, str2, z16);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildAvatarApi
    public void loadCommonPic(String str, int i3, int i16, GuildLevelRoleView.a aVar) {
        com.tencent.mobileqq.guild.util.v.f(str, i3, i16, aVar);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildAvatarApi
    public Drawable getAvatarDrawable(String str, int i3, boolean z16, String str2) {
        int dip2px = ViewUtils.dip2px(140.0f);
        if (i3 == 0) {
            dip2px = ViewUtils.dip2px(140.0f);
        } else if (i3 == 1) {
            dip2px = ViewUtils.dip2px(640.0f);
        }
        int i16 = dip2px;
        return getDrawable(str, i16, i16, str2, z16);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildAvatarApi
    public void loadCommonPic(String str, ImageView imageView, boolean z16, Drawable drawable) {
        com.tencent.mobileqq.guild.u.r(str, imageView, z16, drawable);
    }

    @Override // com.tencent.mobileqq.guild.api.IQQGuildAvatarApi
    public Drawable getAvatarDrawable(AppRuntime appRuntime, String str, String str2) {
        return getAvatarDrawable(getAvatarUrl(appRuntime, str, str2), 0, true, "");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
    }
}
