package com.tencent.mobileqq.pic.aio;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.i;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.ag;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    MessageForPic f258612a;

    /* renamed from: b, reason: collision with root package name */
    ChatThumbView f258613b;

    /* renamed from: c, reason: collision with root package name */
    int[] f258614c;

    /* renamed from: d, reason: collision with root package name */
    i.a f258615d;

    /* renamed from: e, reason: collision with root package name */
    Bundle f258616e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.pic.aio.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8223a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final MessageForPic f258617a;

        /* renamed from: b, reason: collision with root package name */
        ChatThumbView f258618b;

        /* renamed from: c, reason: collision with root package name */
        int[] f258619c;

        /* renamed from: d, reason: collision with root package name */
        i.a f258620d;

        /* renamed from: e, reason: collision with root package name */
        Bundle f258621e;

        public C8223a(MessageForPic messageForPic) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageForPic);
            } else {
                this.f258617a = messageForPic;
            }
        }

        public a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return new a(this);
        }

        public C8223a b(i.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C8223a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            }
            this.f258620d = aVar;
            return this;
        }

        public C8223a c(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (C8223a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            }
            this.f258621e = bundle;
            return this;
        }

        public C8223a d(int[] iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (C8223a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iArr);
            }
            this.f258619c = iArr;
            return this;
        }

        public C8223a e(ChatThumbView chatThumbView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C8223a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) chatThumbView);
            }
            this.f258618b = chatThumbView;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f258622a;

        /* renamed from: b, reason: collision with root package name */
        public int f258623b;

        /* renamed from: c, reason: collision with root package name */
        public float f258624c;

        public b(int i3, int i16, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16));
                return;
            }
            this.f258622a = i3;
            this.f258623b = i16;
            this.f258624c = f16;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "DrawableSize{width=" + this.f258622a + ", height=" + this.f258623b + ", roundCorner=" + this.f258624c + '}';
        }
    }

    a(C8223a c8223a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c8223a);
            return;
        }
        this.f258612a = c8223a.f258617a;
        this.f258613b = c8223a.f258618b;
        this.f258614c = c8223a.f258619c;
        this.f258615d = c8223a.f258620d;
        this.f258616e = c8223a.f258621e;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(File file, boolean z16, ThumbWidthHeightDP thumbWidthHeightDP) {
        Rect rect;
        int i3;
        int i16;
        int i17;
        float roundCorner;
        float f16;
        float height;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        float f28 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        if (z16) {
            try {
                rect = NativeGifImage.getImageSize(file, false);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            if (rect == null) {
                i3 = rect.width();
                i16 = rect.height();
            } else {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                try {
                    BaseImageUtil.decodeFileWithBufferedStream(file.getAbsolutePath(), options);
                } catch (Throwable th6) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AIOPicDrawableObject", 2, "getThumbDrawable", th6);
                    }
                }
                int i18 = options.outWidth;
                int i19 = options.outHeight;
                int exifRotation = URLDrawableHelper.getExifRotation(file.getAbsolutePath());
                if (exifRotation != 90 && exifRotation != 270) {
                    i3 = i18;
                    i16 = i19;
                } else {
                    i3 = options.outHeight;
                    i16 = options.outWidth;
                }
            }
            i17 = thumbWidthHeightDP.mMinWidth;
            int i26 = thumbWidthHeightDP.mMinHeight;
            int i27 = thumbWidthHeightDP.mMaxWidth;
            int i28 = thumbWidthHeightDP.mMaxHeight;
            roundCorner = URLDrawableHelper.getRoundCorner() * f28;
            if (i3 < i17 && i16 >= i26) {
                if (i3 >= i27 || i16 >= i28) {
                    if (i3 > i16) {
                        f18 = i27;
                        f19 = i3;
                    } else {
                        f18 = i28;
                        f19 = i16;
                    }
                    float f29 = f18 / f19;
                    if (i3 > i16) {
                        f26 = i26;
                        f27 = i16;
                    } else {
                        f26 = i17;
                        f27 = i3;
                    }
                    float max = Math.max(f29, f26 / f27);
                    i3 = (int) ((i3 * max) + 0.5f);
                    i16 = (int) ((i16 * max) + 0.5f);
                }
            } else {
                if (i3 >= i16) {
                    f16 = i17 / i3;
                    i16 = Math.min((int) ((i16 * f16) + 0.5f), i28);
                    i3 = i17;
                } else {
                    float f36 = i26 / i16;
                    i3 = Math.min((int) ((i3 * f36) + 0.5f), i27);
                    f16 = f36;
                    i16 = i26;
                }
                roundCorner *= f16;
            }
            int i29 = (int) ((i3 * f28) + 0.5f);
            int i36 = (int) ((i16 * f28) + 0.5f);
            if (rect != null) {
                if (rect.width() < i29) {
                    height = rect.width();
                    f17 = i29;
                } else if (rect.height() < i36) {
                    height = rect.height();
                    f17 = i36;
                }
                roundCorner *= height / f17;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOPicDrawableObject", 2, "calcWidthAndHeightWithFile thumbDP:" + thumbWidthHeightDP + " roundCorner:" + roundCorner + " w:" + i29 + " h:" + i36);
            }
            return new b(i29, i36, roundCorner);
        }
        rect = null;
        if (rect == null) {
        }
        i17 = thumbWidthHeightDP.mMinWidth;
        int i262 = thumbWidthHeightDP.mMinHeight;
        int i272 = thumbWidthHeightDP.mMaxWidth;
        int i282 = thumbWidthHeightDP.mMaxHeight;
        roundCorner = URLDrawableHelper.getRoundCorner() * f28;
        if (i3 < i17) {
        }
        if (i3 >= i16) {
        }
        roundCorner *= f16;
        int i292 = (int) ((i3 * f28) + 0.5f);
        int i362 = (int) ((i16 * f28) + 0.5f);
        if (rect != null) {
        }
        if (QLog.isColorLevel()) {
        }
        return new b(i292, i362, roundCorner);
    }

    public static b b(int i3, int i16, ThumbWidthHeightDP thumbWidthHeightDP) {
        int i17;
        int i18;
        float f16;
        float f17;
        float f18;
        float f19;
        int i19 = thumbWidthHeightDP.mMinWidth;
        int i26 = thumbWidthHeightDP.mMinHeight;
        int i27 = thumbWidthHeightDP.mMaxWidth;
        int i28 = thumbWidthHeightDP.mMaxHeight;
        if (i3 > 0 && i16 > 0) {
            if (i3 >= i19 && i16 >= i26) {
                if (i3 < i27 && i16 < i28) {
                    i17 = i3;
                    i18 = i16;
                } else {
                    if (i3 > i16) {
                        f16 = i27;
                        f17 = i3;
                    } else {
                        f16 = i28;
                        f17 = i16;
                    }
                    float f26 = f16 / f17;
                    if (i3 > i16) {
                        f18 = i26;
                        f19 = i16;
                    } else {
                        f18 = i19;
                        f19 = i3;
                    }
                    float max = Math.max(f26, f18 / f19);
                    i17 = (int) ((i3 * max) + 0.5f);
                    i18 = (int) ((i16 * max) + 0.5f);
                }
            } else {
                if (i3 < i16) {
                    i26 = Math.min((int) ((i16 * (i19 / i3)) + 0.5f), i28);
                } else {
                    i19 = Math.min((int) ((i3 * (i26 / i16)) + 0.5f), i27);
                }
                int i29 = i26;
                i17 = i19;
                i18 = i29;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AIOPicDrawableObject", 2, "MessageForPic without width/height of thumb, width = " + i3 + ", height = " + i16);
            }
            i17 = 99;
            i18 = 99;
        }
        float f27 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        int i36 = (int) ((i17 * f27) + 0.5f);
        int i37 = (int) ((i18 * f27) + 0.5f);
        if (QLog.isColorLevel()) {
            QLog.d("AIOPicDrawableObject", 2, "calcWidthAndHeightWithoutFile width:" + i3 + " height:" + i16 + " thumbDP:" + thumbWidthHeightDP + " w:" + i36 + " h:" + i37);
        }
        return new b(i36, i37, 0.0f);
    }

    private URLDrawable d() {
        com.tencent.mobileqq.drawable.a aVar;
        Resources resources = BaseApplication.getContext().getResources();
        int i3 = resources.getDisplayMetrics().densityDpi;
        i.a aVar2 = this.f258615d;
        URL url = aVar2.f179473a;
        boolean z16 = aVar2.f179474b;
        ThumbWidthHeightDP thumbWidthHeightDP = ((IPicAIO) QRoute.api(IPicAIO.class)).getThumbWidthHeightDP(this.f258612a, ((IPicUtil) QRoute.api(IPicUtil.class)).isDynamicImg(this.f258612a.imageType));
        MessageForPic messageForPic = this.f258612a;
        b b16 = b(messageForPic.thumbWidth, messageForPic.thumbHeight, thumbWidthHeightDP);
        int i16 = b16.f258622a;
        int i17 = b16.f258623b;
        Drawable loadingDrawable = URLDrawableHelper.getLoadingDrawable();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = i16;
        obtain.mRequestHeight = i17;
        obtain.mLoadingDrawable = loadingDrawable;
        obtain.mFailedDrawable = BaseURLDrawableHelper.getFailedDrawable();
        obtain.mPlayGifImage = z16;
        obtain.mGifRoundCorner = URLDrawableHelper.getRoundCorner();
        obtain.mImgType = this.f258612a.imageType;
        int[] iArr = this.f258614c;
        if (iArr != null) {
            iArr[0] = i16;
            iArr[1] = i17;
        }
        if (loadingDrawable instanceof SkinnableBitmapDrawable) {
            aVar = new com.tencent.mobileqq.drawable.a(resources, ((SkinnableBitmapDrawable) loadingDrawable).getBitmap(), i16, i17, URLDrawableHelper.AIO_IMAGE_DEFAULT_BG_COLOR);
        } else if (loadingDrawable instanceof BitmapDrawable) {
            aVar = new com.tencent.mobileqq.drawable.a(resources, ((BitmapDrawable) loadingDrawable).getBitmap(), i16, i17, URLDrawableHelper.AIO_IMAGE_DEFAULT_BG_COLOR);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            obtain.mLoadingDrawable = aVar;
        }
        Bundle bundle = this.f258616e;
        if (bundle != null) {
            obtain.mExtraInfo = bundle;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        drawable.setAutoDownload(true);
        drawable.setProgressDrawable(new ag(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
        return drawable;
    }

    private URLDrawable e(File file) {
        return f(file, this.f258615d.f179473a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private URLDrawable f(File file, URL url) {
        Drawable drawable;
        com.tencent.mobileqq.drawable.a aVar;
        ChatThumbView chatThumbView;
        Resources resources = BaseApplication.getContext().getResources();
        b a16 = a(file, this.f258615d.f179474b, ((IPicAIO) QRoute.api(IPicAIO.class)).getThumbWidthHeightDP(this.f258612a, ((IPicUtil) QRoute.api(IPicUtil.class)).isDynamicImg(this.f258612a.imageType)));
        int[] iArr = this.f258614c;
        if (iArr != null) {
            iArr[0] = a16.f258622a;
            iArr[1] = a16.f258623b;
        }
        Drawable loadingDrawable = URLDrawableHelper.getLoadingDrawable();
        if (loadingDrawable instanceof SkinnableBitmapDrawable) {
            aVar = new com.tencent.mobileqq.drawable.a(resources, ((SkinnableBitmapDrawable) loadingDrawable).getBitmap(), a16.f258622a, a16.f258623b, URLDrawableHelper.AIO_IMAGE_DEFAULT_BG_COLOR);
        } else if (loadingDrawable instanceof BitmapDrawable) {
            aVar = new com.tencent.mobileqq.drawable.a(resources, ((BitmapDrawable) loadingDrawable).getBitmap(), a16.f258622a, a16.f258623b, URLDrawableHelper.AIO_IMAGE_DEFAULT_BG_COLOR);
        } else {
            drawable = loadingDrawable;
            URLDrawable drawable2 = URLDrawableHelper.getDrawable(url, a16.f258622a, a16.f258623b, drawable, BaseURLDrawableHelper.getFailedDrawable(), true, a16.f258624c, this.f258616e);
            drawable2.setProgressDrawable(new ag(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
            drawable2.setIgnorePause(true);
            drawable2.setFadeInImage(true);
            chatThumbView = this.f258613b;
            if (chatThumbView != null) {
                chatThumbView.f179327d = true;
            }
            return drawable2;
        }
        drawable = aVar;
        URLDrawable drawable22 = URLDrawableHelper.getDrawable(url, a16.f258622a, a16.f258623b, drawable, BaseURLDrawableHelper.getFailedDrawable(), true, a16.f258624c, this.f258616e);
        drawable22.setProgressDrawable(new ag(URLDrawableHelper.getCommonProgressBitmap(), 0, false));
        drawable22.setIgnorePause(true);
        drawable22.setFadeInImage(true);
        chatThumbView = this.f258613b;
        if (chatThumbView != null) {
        }
        return drawable22;
    }

    private URLDrawable g() {
        URLDrawable drawable = URLDrawableHelper.getDrawable(this.f258615d.f179473a, 0, 0, null, null, true, URLDrawableHelper.getRoundCorner() * (BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi / 160.0f), this.f258616e);
        int[] iArr = this.f258614c;
        if (iArr != null) {
            iArr[0] = drawable.getIntrinsicWidth();
            this.f258614c[1] = drawable.getIntrinsicHeight();
        }
        return drawable;
    }

    private boolean h() {
        return true;
    }

    public URLDrawable c() {
        URLDrawable d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f258615d == null) {
            this.f258615d = new i.a(this.f258612a);
        }
        String url = this.f258615d.f179473a.toString();
        ChatThumbView chatThumbView = this.f258613b;
        if (chatThumbView != null) {
            chatThumbView.f179327d = false;
        }
        if (h() && ImageCacheHelper.f98636a.g(url) != null) {
            QLog.i("AIOPicDrawableObject", 1, "mem cache found, uniseq=" + this.f258612a.uniseq + ", url=" + url);
            d16 = g();
        } else {
            File file = AbsDownloader.getFile(url);
            if (file != null) {
                QLog.i("AIOPicDrawableObject", 1, "file cache found, uniseq=" + this.f258612a.uniseq + ", url=" + url + ", file=" + file);
                d16 = e(file);
            } else {
                QLog.i("AIOPicDrawableObject", 1, "thumb cache miss, uniseq=" + this.f258612a.uniseq + ", url=" + url + ", file=" + AbsDownloader.getFilePath(url));
                URL url2 = URLDrawableHelper.getURL(this.f258612a, 1, null);
                File file2 = AbsDownloader.getFile(url2.toString());
                if (file2 != null) {
                    QLog.i("AIOPicDrawableObject", 1, "cache miss, big image exist, uniseq=" + this.f258612a.uniseq + ", url=" + url + ", file=" + AbsDownloader.getFilePath(url));
                    d16 = f(file2, url2);
                } else {
                    d16 = d();
                }
            }
        }
        d16.setTag(this.f258612a);
        if (d16.getCurrDrawable() instanceof GifDrawable) {
            d16.getCurrDrawable().mutate();
        }
        return d16;
    }
}
