package com.tencent.mobileqq.guild;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.cw;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class u {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends GuildPicStateListener {
        a(boolean z16) {
            super(z16);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            u.v(loadState, option);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildPicStateListener f235305e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f235306f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z16, GuildPicStateListener guildPicStateListener, String str) {
            super(z16);
            this.f235305e = guildPicStateListener;
            this.f235306f = str;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            GuildPicStateListener guildPicStateListener = this.f235305e;
            if (guildPicStateListener != null) {
                guildPicStateListener.c(loadState, option);
            }
            Bitmap resultBitMap = option.getResultBitMap();
            if (loadState == LoadState.STATE_SUCCESS && resultBitMap != null) {
                u.u(this.f235306f, resultBitMap);
            }
            if (loadState == LoadState.STATE_DECODE_FAILED || loadState == LoadState.STATE_DOWNLOAD_FAILED) {
                QLog.d("Guild.user.QCircleFeedPicLoaderGuildUtils", 2, "loadStatus:" + loadState + " :" + this.f235306f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c extends GuildPicStateListener {
        c(boolean z16) {
            super(z16);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            u.v(loadState, option);
        }
    }

    private static boolean c(ImageView imageView, Option option) {
        if (imageView.getTag(R.id.w0_) != null && imageView.getTag(R.id.f165436w01) != null) {
            option.setRequestWidth(((Integer) imageView.getTag(R.id.w0_)).intValue()).setRequestHeight(((Integer) imageView.getTag(R.id.f165436w01)).intValue());
            return true;
        }
        return false;
    }

    private static Drawable d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bitmap f16 = ImageCacheHelper.f98636a.f(e(str));
        if (f16 != null && !f16.isRecycled()) {
            return new BitmapDrawable(f16);
        }
        return BaseImageUtil.getDefaultFaceDrawable();
    }

    private static String e(String str) {
        return "Guild.user.QCircleFeedPicLoaderGuildUtils_" + str;
    }

    private static String f(View view) {
        Object obj;
        if (view == null) {
            obj = "";
        } else {
            obj = view.getTag(R.id.f165440w05);
        }
        if (!(obj instanceof String)) {
            return "";
        }
        return (String) obj;
    }

    private static boolean g(String str, String str2, int i3) {
        return TextUtils.equals(str2, str);
    }

    public static void h(String str, String str2, int i3, ImageView imageView) {
        i(str, str2, "", i3, imageView);
    }

    public static void i(String str, String str2, String str3, int i3, ImageView imageView) {
        j(str, str2, str3, i3, imageView, false);
    }

    private static void j(String str, String str2, String str3, int i3, ImageView imageView, boolean z16) {
        if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) || imageView == null) {
            QLog.e("Guild.user.QCircleFeedPicLoaderGuildUtils", 1, "loadAvatar params error");
        } else {
            w(str, str2, str3, i3, imageView, z16);
        }
    }

    public static void k(ImageView imageView, String str, int i3, int i16, GuildPicStateListener guildPicStateListener) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            Option loadingDrawable = Option.obtain().setUrl(str).setTargetView(imageView).setLoadingDrawable(d(str));
            imageView.setImageDrawable(d(str));
            if (i3 > 0 && i16 > 0) {
                loadingDrawable.setRequestWidth(i3);
                loadingDrawable.setRequestHeight(i16);
            }
            com.tencent.mobileqq.guild.picload.e.a().f(loadingDrawable, new b(true, guildPicStateListener, str));
            return;
        }
        QLog.d("Guild.user.QCircleFeedPicLoaderGuildUtils", 2, "loadAvatarPicByUrl url is empty");
    }

    public static void l(ImageView imageView, String str, GuildPicStateListener guildPicStateListener) {
        k(imageView, str, 0, 0, guildPicStateListener);
    }

    private static void m(String str, ImageView imageView) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            Option failDrawable = new Option().setTargetView(imageView).setNeedFilterUrl(false).setUrl(str).setLoadingDrawable(BaseImageUtil.getDefaultFaceDrawable()).setFailDrawable(BaseImageUtil.getDefaultFaceDrawable());
            if (!c(imageView, failDrawable)) {
                failDrawable.setRequestWidth(imageView.getWidth()).setRequestHeight(imageView.getHeight());
            }
            com.tencent.mobileqq.guild.picload.e.a().f(failDrawable, new a(true));
        }
    }

    public static void n(String str, String str2, String str3, int i3, ImageView imageView) {
        j(str, str2, str3, i3, imageView, true);
    }

    public static void o(String str, int i3, int i16, GuildPicStateListener guildPicStateListener) {
        com.tencent.mobileqq.guild.picload.e.a().f(v.b(str, true, Integer.valueOf(i3), Integer.valueOf(i16)), guildPicStateListener);
    }

    public static void p(String str, ImageView imageView) {
        q(str, imageView, false);
    }

    public static void q(String str, ImageView imageView, boolean z16) {
        r(str, imageView, z16, BaseImageUtil.getDefaultFaceDrawable());
    }

    public static void r(String str, ImageView imageView, boolean z16, Drawable drawable) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            Option loadingDrawable = new Option().setTargetView(imageView).setNeedFilterUrl(false).setUrl(str).setLoadingDrawable(drawable);
            if (z16) {
                loadingDrawable.setRequestWidth(imageView.getWidth()).setRequestHeight(imageView.getHeight());
            }
            com.tencent.mobileqq.guild.picload.e.a().f(loadingDrawable, new c(true));
        }
    }

    public static void s(String str, GuildPicStateListener guildPicStateListener) {
        com.tencent.mobileqq.guild.picload.e.a().f(v.b(str, true, 0, 0), guildPicStateListener);
    }

    public static void t(String str, int i3, int i16) {
        com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(str).setFromPreLoad(true).setPredecode(true).setNeedFilterUrl(false).setRequestWidth(i3).setRequestHeight(i16), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(String str, Bitmap bitmap) {
        if (bitmap != null && !TextUtils.isEmpty(str)) {
            ImageCacheHelper.f98636a.i(e(str), bitmap, Business.Guild);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v(LoadState loadState, Option option) {
        if (TextUtils.isEmpty(f(option.getTargetView()))) {
            return;
        }
        com.tencent.mobileqq.guild.performance.report.t.b(loadState, option, "3");
    }

    private static void w(String str, String str2, String str3, int i3, ImageView imageView, boolean z16) {
        String fullGuildUserUserAvatarUrl;
        IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
        if (!TextUtils.isEmpty(str3)) {
            fullGuildUserUserAvatarUrl = iGPSService.getFullAvatarUrl(new cw(str2, str3), i3);
        } else {
            fullGuildUserUserAvatarUrl = iGPSService.getFullGuildUserUserAvatarUrl(str, str2, i3);
        }
        if (TextUtils.isEmpty(fullGuildUserUserAvatarUrl)) {
            QLog.d("Guild.user.QCircleFeedPicLoaderGuildUtils", 1, "service.getFullAvatarUrl is empty guildId:", str, ", tinyId:", str2, " view:", Integer.valueOf(imageView.hashCode()));
            if (TextUtils.isEmpty(f(imageView))) {
                imageView.setImageDrawable(BaseImageUtil.getDefaultFaceDrawable());
                return;
            }
            return;
        }
        if (z16) {
            QLog.i("Guild.user.QCircleFeedPicLoaderGuildUtils", 1, "AvatarUrl:" + fullGuildUserUserAvatarUrl + ", guildId:" + str + ", tinyId:" + str2 + ", avatarMeta:" + str3 + " view:" + imageView.hashCode());
        }
        if (g(fullGuildUserUserAvatarUrl, f(imageView), imageView.hashCode())) {
            return;
        }
        x(imageView, fullGuildUserUserAvatarUrl);
        m(fullGuildUserUserAvatarUrl, imageView);
    }

    public static void x(View view, String str) {
        view.setTag(R.id.f165440w05, str);
    }
}
