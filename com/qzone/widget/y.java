package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import com.qzone.widget.util.sensor.GifReverseGenerator;
import com.qzone.widget.util.sensor.a;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.drawable.AutoGifDrawable;
import common.config.service.QzoneConfig;
import java.io.File;

/* compiled from: P */
/* loaded from: classes37.dex */
public class y implements a.b {

    /* renamed from: b, reason: collision with root package name */
    private AutoGifDrawable f61182b;

    /* renamed from: l, reason: collision with root package name */
    private String f61192l;

    /* renamed from: m, reason: collision with root package name */
    private ImageLoader.Options f61193m;

    /* renamed from: n, reason: collision with root package name */
    private Context f61194n;

    /* renamed from: o, reason: collision with root package name */
    private AutoGifDrawable.AutoGifCallback f61195o;

    /* renamed from: d, reason: collision with root package name */
    private int f61184d = 1;

    /* renamed from: e, reason: collision with root package name */
    private int f61185e = 1;

    /* renamed from: f, reason: collision with root package name */
    private float f61186f = 1.0f;

    /* renamed from: g, reason: collision with root package name */
    private int f61187g = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f61188h = 15;

    /* renamed from: i, reason: collision with root package name */
    private int f61189i = 5;

    /* renamed from: j, reason: collision with root package name */
    private int f61190j = 10;

    /* renamed from: k, reason: collision with root package name */
    private int f61191k = 3;

    /* renamed from: p, reason: collision with root package name */
    private int f61196p = 1;

    /* renamed from: q, reason: collision with root package name */
    private int f61197q = 16;

    /* renamed from: r, reason: collision with root package name */
    private long f61198r = 0;

    /* renamed from: a, reason: collision with root package name */
    private AutoGifDrawable f61181a = AutoGifDrawable.newAutoGifDrawable();

    /* renamed from: c, reason: collision with root package name */
    private com.qzone.widget.util.sensor.a f61183c = new com.qzone.widget.util.sensor.a(this);

    private void e(String str, ImageLoader.Options options, Context context, AutoGifDrawable.AutoGifCallback autoGifCallback) {
        if (this.f61187g != 1) {
            com.qzone.proxy.feedcomponent.b.e("SensorAutoGifDrawable", "initReverseGif fail, mCanChangeControlType " + this.f61187g);
            return;
        }
        File imageFile = ImageManager.getInstance().getImageFile(str, options);
        if (imageFile != null && imageFile.exists()) {
            String str2 = imageFile.getAbsolutePath() + "_r";
            if (new File(str2).exists()) {
                com.qzone.proxy.feedcomponent.b.e("SensorAutoGifDrawable", "reverse file exist");
                AutoGifDrawable autoGifDrawable = this.f61182b;
                if (autoGifDrawable == null || autoGifDrawable.getRealDrawable() == null) {
                    AutoGifDrawable newAutoGifDrawable = AutoGifDrawable.newAutoGifDrawable();
                    this.f61182b = newAutoGifDrawable;
                    newAutoGifDrawable.init(str2, options, context, autoGifCallback);
                }
                this.f61182b.start();
                return;
            }
            com.qzone.proxy.feedcomponent.b.e("SensorAutoGifDrawable", "reverse file not exist");
            this.f61182b = null;
            GifReverseGenerator.i().l(str, options);
            return;
        }
        com.qzone.proxy.feedcomponent.b.e("SensorAutoGifDrawable", "origin file not download");
        this.f61182b = null;
    }

    private void f() {
        com.qzone.proxy.feedcomponent.b.e("SensorAutoGifDrawable", "initWnsControl");
        this.f61188h = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_FEED_GIF_ANGLE_DIFF_SENSOR_TYPE, 15);
        this.f61189i = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_FEED_GIF_ANGLE_LOOP_TYPE, 5);
        this.f61190j = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_FEED_GIF_ANGLE_TO_FACTOR, 10);
        this.f61191k = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_FEED_GIF_MAX_FACTOR, 3);
        this.f61196p = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_FEED_GIF_SENSOR_MODEL, 1);
        this.f61197q = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_FEED_GIF_SENSOR_MODEL2_MAX_FACTOR, 16);
    }

    private void g(double d16, double d17, double d18, double d19) {
        if (Math.abs(d17) > this.f61188h && this.f61185e != 2) {
            this.f61185e = 2;
            com.qzone.proxy.feedcomponent.b.e("SensorAutoGifDrawable", "control type change to TYPE_SENSOR_CONTROL=2");
        }
        if (this.f61185e == 2) {
            if (d16 > this.f61189i) {
                this.f61184d = 1;
            } else if (Math.abs(d16) > this.f61189i && k()) {
                this.f61184d = 2;
            } else {
                this.f61184d = 1;
            }
            double abs = Math.abs(d16);
            int i3 = this.f61190j;
            if (abs > i3) {
                if (i3 != 0) {
                    this.f61186f = (float) (Math.abs(d16) / this.f61190j);
                }
                float f16 = this.f61186f;
                int i16 = this.f61191k;
                if (f16 > i16) {
                    this.f61186f = i16;
                }
            } else {
                this.f61186f = 1.0f;
            }
            i(this.f61186f);
        }
    }

    private void h(double d16, double d17, double d18, double d19) {
        if (Math.abs(d17) > this.f61188h && this.f61185e != 2) {
            this.f61185e = 2;
            com.qzone.proxy.feedcomponent.b.e("SensorAutoGifDrawable", "control type change to TYPE_SENSOR_CONTROL=2");
        }
        if (this.f61185e != 2 || Math.abs(d17) <= 15.0d || System.currentTimeMillis() - this.f61198r <= 1000) {
            return;
        }
        float f16 = this.f61186f * 2.0f;
        this.f61186f = f16;
        if (f16 > this.f61197q) {
            this.f61186f = 1.0f;
        }
        i(this.f61186f);
        this.f61198r = System.currentTimeMillis();
    }

    private void i(float f16) {
        AutoGifDrawable autoGifDrawable;
        if (this.f61184d == 1 && (autoGifDrawable = this.f61181a) != null) {
            autoGifDrawable.setSpeed(f16);
        }
        if (this.f61184d == 2 && k()) {
            this.f61182b.setSpeed(f16);
        }
    }

    private boolean k() {
        AutoGifDrawable autoGifDrawable = this.f61182b;
        return (autoGifDrawable == null || autoGifDrawable.getRealDrawable() == null) ? false : true;
    }

    @Override // com.qzone.widget.util.sensor.a.b
    public void a(double d16, double d17, double d18, double d19) {
        if (this.f61181a == null || this.f61187g != 1) {
            return;
        }
        int i3 = this.f61196p;
        if (i3 == 1) {
            g(d16, d17, d18, d19);
        } else if (i3 == 2) {
            h(d16, d17, d18, d19);
        }
    }

    public boolean b(Canvas canvas, int i3, int i16) {
        if (this.f61184d == 2 && k()) {
            return this.f61182b.draw(canvas, i3, i16);
        }
        AutoGifDrawable autoGifDrawable = this.f61181a;
        if (autoGifDrawable != null) {
            return autoGifDrawable.draw(canvas, i3, i16);
        }
        return false;
    }

    public String c() {
        return null;
    }

    public void d(String str, ImageLoader.Options options, Context context, AutoGifDrawable.AutoGifCallback autoGifCallback, AutoGifDrawable.GifDownloadCallBackListener gifDownloadCallBackListener) {
        AutoGifDrawable autoGifDrawable = this.f61181a;
        if (autoGifDrawable != null) {
            autoGifDrawable.init(str, options, context, autoGifCallback, gifDownloadCallBackListener);
            this.f61192l = str;
            this.f61193m = options;
            this.f61194n = context;
            this.f61195o = autoGifCallback;
        }
        this.f61182b = null;
        f();
    }

    public void j() {
        com.qzone.widget.util.sensor.a aVar = this.f61183c;
        if (aVar != null) {
            aVar.f();
            this.f61183c = null;
        }
        AutoGifDrawable autoGifDrawable = this.f61181a;
        if (autoGifDrawable != null) {
            autoGifDrawable.recycled();
            this.f61181a = null;
        }
        AutoGifDrawable autoGifDrawable2 = this.f61182b;
        if (autoGifDrawable2 != null) {
            autoGifDrawable2.recycled();
            this.f61182b = null;
        }
        this.f61193m = null;
        this.f61194n = null;
        this.f61195o = null;
    }

    public void m() {
        com.qzone.widget.util.sensor.a aVar = this.f61183c;
        if (aVar != null) {
            aVar.f();
        }
        AutoGifDrawable autoGifDrawable = this.f61181a;
        if (autoGifDrawable != null) {
            autoGifDrawable.stop();
        }
        AutoGifDrawable autoGifDrawable2 = this.f61182b;
        if (autoGifDrawable2 != null) {
            autoGifDrawable2.stop();
        }
    }

    public void l() {
        this.f61185e = 1;
        this.f61184d = 1;
        this.f61186f = 1.0f;
        i(1.0f);
        AutoGifDrawable autoGifDrawable = this.f61181a;
        if (autoGifDrawable != null) {
            autoGifDrawable.start();
        }
        if (k()) {
            this.f61182b.start();
        }
        com.qzone.widget.util.sensor.a aVar = this.f61183c;
        if (aVar != null) {
            if (this.f61187g == 1) {
                aVar.e();
            } else {
                aVar.f();
            }
        }
        if (this.f61187g == 1 && this.f61196p == 1 && !k()) {
            e(this.f61192l, this.f61193m, this.f61194n, this.f61195o);
        }
    }
}
