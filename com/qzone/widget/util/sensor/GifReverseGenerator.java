package com.qzone.widget.util.sensor;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.qzone.proxy.feedcomponent.b;
import com.tencent.component.media.gif.GifError;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.gif.SharpPNewGifDecoder;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.sharpP.SharpPDecoderHelper;
import com.tencent.sharpP.SharpPUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.GifCoder;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes37.dex */
public class GifReverseGenerator {

    /* renamed from: f, reason: collision with root package name */
    private static GifCoder f61138f = null;

    /* renamed from: g, reason: collision with root package name */
    private static GifReverseGenerator f61139g = null;

    /* renamed from: h, reason: collision with root package name */
    public static int f61140h = 100;

    /* renamed from: a, reason: collision with root package name */
    private String f61141a;

    /* renamed from: b, reason: collision with root package name */
    private String f61142b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f61143c = false;

    /* renamed from: d, reason: collision with root package name */
    private NewGifDecoder.Options f61144d = new NewGifDecoder.Options();

    /* renamed from: e, reason: collision with root package name */
    private ImageLoader.ImageLoadListener f61145e = new ImageLoader.ImageLoadListener() { // from class: com.qzone.widget.util.sensor.GifReverseGenerator.1

        /* compiled from: P */
        /* renamed from: com.qzone.widget.util.sensor.GifReverseGenerator$1$a */
        /* loaded from: classes37.dex */
        class a implements ThreadExcutor.IThreadListener {
            a() {
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onAdded() {
                b.e("GifReverseGenerator", "generate onAdded " + GifReverseGenerator.this.f61141a);
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPostRun() {
                GifReverseGenerator.this.n();
                b.e("GifReverseGenerator", "generate onPostRun " + GifReverseGenerator.this.f61141a);
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPreRun() {
                b.e("GifReverseGenerator", "generate onPreRun " + GifReverseGenerator.this.f61141a);
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            GifReverseGenerator.this.n();
            b.e("GifReverseGenerator", "onImageCanceled");
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            GifReverseGenerator.this.n();
            b.e("GifReverseGenerator", "onImageFailed");
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            b.e("GifReverseGenerator", "onImageLoaded");
            if (drawable instanceof NewGifDrawable) {
                b.e("GifReverseGenerator", "drawable instanceof NewGifDrawable");
                File imageFile = ImageManager.getInstance().getImageFile(str, options);
                if (imageFile == null || !imageFile.exists()) {
                    GifReverseGenerator.this.n();
                    return;
                }
                GifReverseGenerator.this.f61141a = imageFile.getAbsolutePath();
                GifReverseGenerator.this.f61142b = GifReverseGenerator.this.f61141a + "_r";
                ThreadManagerV2.post(new Runnable() { // from class: com.qzone.widget.util.sensor.GifReverseGenerator.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            GifReverseGenerator.this.j();
                        } catch (Throwable th5) {
                            b.d("GifReverseGenerator", "Throwable ", th5);
                            try {
                                if (GifReverseGenerator.f61138f != null) {
                                    GifReverseGenerator.f61138f.closeEncoder();
                                    GifReverseGenerator.f61138f = null;
                                }
                            } catch (Throwable th6) {
                                b.d("GifReverseGenerator", "Throwable ", th6);
                            }
                        }
                    }
                }, 5, new a(), true);
                return;
            }
            b.e("GifReverseGenerator", "drawable not NewGifDrawable running gif logic!!!");
            GifReverseGenerator.this.n();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            b.e("GifReverseGenerator", "onImageProgress");
        }
    };

    GifReverseGenerator() {
        f61140h = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_FEED_GIF_SENSOR_MODEL_MAX_COUNT, 100);
    }

    public static GifReverseGenerator i() {
        if (f61139g == null) {
            f61139g = new GifReverseGenerator();
        }
        return f61139g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        GifCoder gifCoder;
        if (new File(this.f61142b).exists()) {
            b.e("GifReverseGenerator", "reverse file exist");
            return;
        }
        boolean z16 = true;
        if (f61138f == null) {
            GifCoder gifCoder2 = new GifCoder();
            f61138f = gifCoder2;
            gifCoder2.setUseOrignalBitmap(true);
        }
        this.f61144d.inPreferredConfig = Bitmap.Config.ARGB_8888;
        NewGifDrawable k3 = k(this.f61141a);
        if (k3 != null) {
            k3.stop();
            int numberOfFrames = k3.getNumberOfFrames();
            b.e("GifReverseGenerator", "count = " + numberOfFrames);
            if (numberOfFrames > f61140h) {
                b.e("GifReverseGenerator", "gif max frames limit = " + f61140h);
                return;
            }
            String str = this.f61141a + "_t";
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (numberOfFrames > 0) {
                k3.getFrame(numberOfFrames - 1);
            }
            int i3 = numberOfFrames - 1;
            while (true) {
                if (i3 < 0) {
                    z16 = false;
                    break;
                }
                Bitmap frame = k3.getFrame(i3);
                GifError error = k3.getError();
                if (error != null && error.getErrorCode() != 0) {
                    b.c("GifReverseGenerator", "decode frame error " + error.getErrorCode());
                    if (frame != null) {
                        frame.recycle();
                    }
                } else {
                    int frameDuration = k3.getFrameDuration(i3);
                    if (frame != null && !frame.isRecycled() && (gifCoder = f61138f) != null) {
                        gifCoder.encodeGif(frame, str, frameDuration);
                    }
                    if (frame != null) {
                        frame.recycle();
                    }
                    i3--;
                }
            }
            f61138f.closeEncoder();
            if (!z16) {
                if (new File(str).renameTo(new File(this.f61142b))) {
                    b.e("GifReverseGenerator", "gif generate succeed " + this.f61142b);
                    return;
                }
                b.e("GifReverseGenerator", "rename fail");
                return;
            }
            new File(str).delete();
            b.e("GifReverseGenerator", "delete error frame file");
        }
    }

    private NewGifDrawable k(String str) {
        try {
            File file = new File(str);
            if (file.exists() && SharpPUtils.isSharpP(file)) {
                SharpPDecoderHelper sharpPDecoderHelper = new SharpPDecoderHelper(this.f61141a);
                if (sharpPDecoderHelper.parseHeader() == 0) {
                    return new NewGifDrawable(new SharpPNewGifDecoder(str, sharpPDecoderHelper.getFeatureInfo().getWidth(), sharpPDecoderHelper.getFeatureInfo().getHeight()), this.f61144d);
                }
                QZLog.e("GifReverseGenerator", "GifReverseGenerator error:decodeSharppGif error");
                return null;
            }
            return new NewGifDrawable(str, this.f61144d);
        } catch (Throwable th5) {
            QZLog.e("GifReverseGenerator", "catch an throwable:", th5);
            return null;
        }
    }

    private boolean m() {
        return this.f61143c;
    }

    public void l(String str, ImageLoader.Options options) {
        if (m()) {
            b.e("GifReverseGenerator", "init fail = isUsing");
            return;
        }
        if (options != null) {
            ImageLoader.Options copy = ImageLoader.Options.copy(options);
            if (copy != null) {
                copy.needShowGifAnimation = true;
                NewGifDecoder.Options options2 = this.f61144d;
                options2.inPreferWidth = copy.clipWidth;
                options2.inPreferHeight = copy.clipHeight;
                h();
                ImageLoader.getInstance().loadImageAsync(str, this.f61145e, copy);
                return;
            }
            b.c("GifReverseGenerator", "gifOptions == null");
            return;
        }
        b.c("GifReverseGenerator", "options == null");
    }

    private void h() {
        this.f61143c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f61143c = false;
    }
}
