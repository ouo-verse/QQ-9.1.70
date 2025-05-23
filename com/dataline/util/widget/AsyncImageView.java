package com.dataline.util.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AsyncImageView extends ImageView {
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private int f32469d;

    /* renamed from: e, reason: collision with root package name */
    private int f32470e;

    /* renamed from: f, reason: collision with root package name */
    private int f32471f;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f32472h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f32473i;

    /* renamed from: m, reason: collision with root package name */
    private int f32474m;

    public AsyncImageView(Context context) {
        this(context, null);
    }

    public static URL a(String str, int i3, int i16, boolean z16) {
        String str2;
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            if (FileManagerUtil.getFileType(str) == 2) {
                str2 = ProtocolDownloaderConstants.PROTOCOL_VIDEO_THUMB;
            } else {
                str = str + "|" + i3 + "|" + i16 + "|0|" + z16;
                str2 = ProtocolDownloaderConstants.PROTOCOL_DATALINE_IMAGE;
            }
            try {
                return new URL(str2, "", str);
            } catch (MalformedURLException e16) {
                if (!QLog.isColorLevel()) {
                    return null;
                }
                QLog.d("AsyncImageView", 2, e16.getMessage(), e16);
                return null;
            }
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e17) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("AsyncImageView", 2, e17.getMessage(), e17);
            return null;
        }
    }

    public void setAsyncClipSize(int i3, int i16) {
        this.f32469d = i3;
        this.f32470e = i16;
    }

    public void setAsyncImage(String str) {
        int i3;
        URL a16 = a(str, this.f32469d, this.f32470e, this.f32473i);
        if (getDrawable() instanceof URLDrawable) {
            URLDrawable uRLDrawable = (URLDrawable) getDrawable();
            if (uRLDrawable.getURL().toString().equals(a16.toString())) {
                if (uRLDrawable.getStatus() != 1 && uRLDrawable.getStatus() != 0) {
                    uRLDrawable.restartDownload();
                    return;
                }
                return;
            }
        }
        Drawable drawable = this.f32472h;
        if (drawable == null) {
            if (this.C) {
                drawable = new ColorDrawable(this.f32474m);
            } else {
                drawable = getResources().getDrawable(this.f32471f);
            }
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mPlayGifImage = false;
        obtain.mGifRoundCorner = 0.0f;
        obtain.mDecodeFileStrategy = 3;
        int i16 = this.f32469d;
        if (i16 > 0 && (i3 = this.f32470e) > 0) {
            obtain.mRequestWidth = i16;
            obtain.mRequestHeight = i3;
        } else {
            obtain.mRequestWidth = 0;
            obtain.mRequestHeight = 0;
        }
        URLDrawable drawable2 = URLDrawable.getDrawable(a16, obtain);
        setImageDrawable(drawable2);
        drawable2.setURLDrawableListener(new a());
    }

    public void setDefaultColorDrawable(int i3) {
        this.f32474m = i3;
        this.C = true;
    }

    public void setDefaultImage(int i3) {
        this.f32471f = i3;
        this.C = false;
    }

    public void setDefaultImageByMargin() {
        int i3 = this.f32469d;
        int i16 = this.f32470e;
        Resources resources = getResources();
        if (URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable) {
            this.f32472h = new com.tencent.mobileqq.drawable.a(resources, ((SkinnableBitmapDrawable) URLDrawableHelper.getLoadingDrawable()).getBitmap(), i3, i16, URLDrawableHelper.AIO_IMAGE_DEFAULT_BG_COLOR);
        } else if (URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable) {
            this.f32472h = new com.tencent.mobileqq.drawable.a(resources, ((BitmapDrawable) URLDrawableHelper.getLoadingDrawable()).getBitmap(), i3, i16, URLDrawableHelper.AIO_IMAGE_DEFAULT_BG_COLOR);
        } else {
            this.f32472h = URLDrawableHelper.getLoadingDrawable();
        }
    }

    public void setImageDrawableDefault() {
        setImageDrawable(this.f32472h);
    }

    public void setIsDrawRound(boolean z16) {
        this.f32473i = z16;
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f32469d = 0;
        this.f32470e = 0;
        this.f32471f = 0;
        this.f32472h = null;
        this.f32473i = true;
        this.f32474m = Color.parseColor("#C8C8C8");
        this.C = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements URLDrawable.URLDrawableListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QLog.d("AsyncImageView", 1, "canceled ");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.d("AsyncImageView", 1, "urldrawable load failed ");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            AsyncImageView.this.setImageDrawable(null);
            AsyncImageView.this.setImageDrawable(uRLDrawable);
            QLog.d("AsyncImageView", 1, "successed ");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
