package com.qzone.reborn.feedx.util;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.reborn.feedx.util.e;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.b;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final OvalProcessor f55743a = new OvalProcessor();

    /* renamed from: b, reason: collision with root package name */
    private static Drawable f55744b = null;

    /* renamed from: c, reason: collision with root package name */
    private static final int f55745c = com.tencent.mobileqq.util.x.c(MobileQQ.sMobileQQ, 34.0f);

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<ImageView> f55746d;

        /* renamed from: e, reason: collision with root package name */
        private final Long f55747e;

        public a(ImageView imageView, long j3) {
            this.f55746d = new WeakReference<>(imageView);
            this.f55747e = Long.valueOf(j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, Drawable drawable) {
            if (this.f55746d.get() == null) {
                QLog.d("QZoneAvatarViewUtils", 1, "onImageLoaded fail of post mAvatarViewRef " + this.f55746d.get() + ", url: " + str);
                return;
            }
            QLog.d("QZoneAvatarViewUtils", 1, "onImageLoaded success, url: " + str + ", image: " + drawable);
            this.f55746d.get().setImageDrawable(drawable);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            QLog.d("QZoneAvatarViewUtils", 1, "onImageCanceled, url: " + str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            QLog.d("QZoneAvatarViewUtils", 1, "onImageFailed, url: " + str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(final String str, final Drawable drawable, ImageLoader.Options options) {
            if (options != null) {
                Object obj = options.obj;
                if (obj instanceof Long) {
                    Long l3 = this.f55747e;
                    if (l3 != null && l3.equals(obj)) {
                        if (this.f55746d.get() == null) {
                            QLog.d("QZoneAvatarViewUtils", 1, "onImageLoaded fail of mAvatarViewRef " + this.f55746d.get() + ", url: " + str);
                            return;
                        }
                        this.f55746d.get().post(new Runnable() { // from class: com.qzone.reborn.feedx.util.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                e.a.this.b(str, drawable);
                            }
                        });
                        return;
                    }
                    QLog.d("QZoneAvatarViewUtils", 1, "onImageLoaded fail of mKey " + this.f55747e + ", options.obj: " + options.obj + ", url: " + str);
                    return;
                }
            }
            QLog.d("QZoneAvatarViewUtils", 1, "onImageLoaded fail of options " + options);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    public static Drawable a() {
        if (f55744b == null) {
            f55744b = ContextCompat.getDrawable(BaseApplicationImpl.getApplication(), R.drawable.f160830com);
        }
        return f55744b;
    }

    private static Drawable b(ImageView imageView, String str, boolean z16, boolean z17) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        FaceDrawable outboundUserFaceDrawable = FaceDrawable.getOutboundUserFaceDrawable(qQAppInterface, str, z16 ? (byte) 1 : (byte) 3, z17, 1);
        if (outboundUserFaceDrawable == null) {
            outboundUserFaceDrawable = FaceDrawable.getUserFaceDrawable(qQAppInterface, str, (byte) 3);
        }
        QLog.d("QZoneAvatarViewUtils", 1, "loadOutBoundFaceDrawable   | uin = " + str + " | isOpenOutBound = " + z17 + " | faceDrawable = " + outboundUserFaceDrawable);
        return outboundUserFaceDrawable;
    }

    public static QQProAvatarDrawable c(ImageView imageView) {
        if (imageView instanceof RFWRoundImageView) {
            ((RFWRoundImageView) imageView).setDisableCircularTransformation(true);
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof QQProAvatarDrawable) {
            return (QQProAvatarDrawable) drawable;
        }
        return new QQProAvatarDrawable();
    }

    public static boolean d() {
        return km.a.f412646a.a();
    }

    public static Drawable h(ImageView imageView, ImageUrl imageUrl, String str, long j3) {
        if (d()) {
            return g(imageView, imageUrl, str);
        }
        return i(imageView, imageUrl, str, j3, false);
    }

    private static Drawable i(ImageView imageView, ImageUrl imageUrl, String str, long j3, boolean z16) {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.obj = Long.valueOf(j3);
        if (!z16) {
            obtain.extraProcessor = f55743a;
        }
        int i3 = f55745c;
        obtain.clipHeight = i3;
        obtain.clipWidth = i3;
        return ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImage(imageUrl, str, new a(imageView, j3), obtain);
    }

    public static void j(ImageView imageView, b.a aVar) {
        if (imageView instanceof RFWRoundImageView) {
            RFWRoundImageView rFWRoundImageView = (RFWRoundImageView) imageView;
            int borderWidth = rFWRoundImageView.getBorderWidth();
            int borderColor = rFWRoundImageView.getBorderColor();
            if (borderWidth > 0) {
                aVar.a(FaceConstant.KEY_PRO_AVATAR_FRAME_SIZE, Integer.valueOf(borderWidth));
                aVar.a(FaceConstant.KEY_PRO_AVATAR_FRAME_COLOR, Integer.valueOf(borderColor));
            }
        }
    }

    public static Drawable g(ImageView imageView, ImageUrl imageUrl, String str) {
        if ((imageUrl == null || TextUtils.isEmpty(imageUrl.url)) && TextUtils.isEmpty(str)) {
            QLog.e("QZoneAvatarViewUtils", 1, "loadAvatarByUrl  url == null");
            return a();
        }
        String str2 = (imageUrl == null || TextUtils.isEmpty(imageUrl.url)) ? str : imageUrl.url;
        QQProAvatarDrawable c16 = c(imageView);
        b.a aVar = new b.a(Uri.parse(str2), false);
        aVar.a("KEY_BEAN_KEY_SUFFIX", str);
        j(imageView, aVar);
        c16.y(imageView.getContext(), new com.tencent.qqnt.avatar.fetch.c(aVar.b(), null, BaseImageUtil.getDefaultFaceDrawable(), null, true, null));
        QLog.d("QZoneAvatarViewUtils", 1, "loadAvatarByUrl   | loadUrl = " + str2 + " | url = " + str + " | drawable = " + c16 + " | hashcode = " + imageView.hashCode());
        return c16;
    }

    public static Drawable e(ImageView imageView, long j3, QZoneUserAvatarView.b bVar) {
        Drawable b16;
        QZoneUserAvatarView.b bVar2 = bVar == null ? new QZoneUserAvatarView.b() : bVar;
        if (d()) {
            return f(imageView, j3, bVar2);
        }
        if (j3 <= 0) {
            QLog.e("QZoneAvatarViewUtils", 1, "loadAvatarByUin  uin <= 0");
            return a();
        }
        if (bVar2.f55960b && (b16 = b(imageView, String.valueOf(j3), bVar2.f55959a, true)) != null && (imageView instanceof RFWRoundImageView)) {
            ((RFWRoundImageView) imageView).setDisableCircularTransformation(true);
            QLog.d("QZoneAvatarViewUtils", 1, "loadAvatarByUin   | uin = " + j3 + " | drawable = " + b16 + " | hashcode = " + imageView.hashCode());
            return b16;
        }
        String P = com.qzone.adapter.feedcomponent.i.H().P(Long.valueOf(j3));
        Drawable i3 = i(imageView, PictureUrl.calculateAvaterImageUrl(P), P, j3, bVar2.f55959a);
        if (i3 == null) {
            QLog.d("QZoneAvatarViewUtils", 1, "loadAvatarByUin  | uin = " + j3 + " , drawable == null");
            return a();
        }
        QLog.d("QZoneAvatarViewUtils", 1, "loadAvatarByUin   | uin = " + j3 + " | drawable = " + i3 + " | hashcode = " + imageView.hashCode());
        return i3;
    }

    public static Drawable f(ImageView imageView, long j3, QZoneUserAvatarView.b bVar) {
        if (j3 <= 0) {
            QLog.e("QZoneAvatarViewUtils", 1, "loadAvatarByUinNew  uin <= 0");
            return a();
        }
        QQProAvatarDrawable c16 = c(imageView);
        b.a aVar = new b.a(1, String.valueOf(j3), 140, false);
        j(imageView, aVar);
        if (bVar.f55960b) {
            aVar.a(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.TRUE);
            aVar.a("KEY_BEAN_KEY_SUFFIX", "sz");
        }
        c16.y(imageView.getContext(), new com.tencent.qqnt.avatar.fetch.c(aVar.b(), null, BaseImageUtil.getDefaultFaceDrawable(), null, true, null));
        return c16;
    }
}
