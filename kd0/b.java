package kd0;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.maxvideo.trim.TrimNative;
import hd0.c;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends nd0.a<Integer> {
    private MediaMetadataRetriever E;
    private String F;
    private int G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    public C10648b M;
    private LruCache<Integer, Drawable> N;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a extends nd0.b {

        /* renamed from: i, reason: collision with root package name */
        private Integer f412043i;

        /* renamed from: j, reason: collision with root package name */
        private MediaMetadataRetriever f412044j;

        /* renamed from: k, reason: collision with root package name */
        private int f412045k;

        /* renamed from: l, reason: collision with root package name */
        private int f412046l;

        /* renamed from: m, reason: collision with root package name */
        private long f412047m;

        /* renamed from: n, reason: collision with root package name */
        private int f412048n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f412049o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f412050p;

        /* renamed from: q, reason: collision with root package name */
        private C10648b f412051q;

        public a(ImageView imageView, MediaMetadataRetriever mediaMetadataRetriever, Integer num, int i3, int i16, long j3, int i17, boolean z16, C10648b c10648b, boolean z17) {
            super(imageView);
            this.f412043i = num;
            this.f412044j = mediaMetadataRetriever;
            this.f412045k = i3;
            this.f412046l = i16;
            this.f412047m = j3;
            this.f412048n = i17;
            this.f412049o = z16;
            this.f412051q = c10648b;
            this.f412050p = z17;
        }

        @Override // nd0.b
        public String d() {
            return String.valueOf(this.f412043i);
        }

        @Override // nd0.b
        @TargetApi(10)
        public void g() {
            Bitmap createBitmap;
            c.v("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround:%s", d());
            long currentTimeMillis = System.currentTimeMillis();
            if (UIUtils.v() && this.f412050p) {
                c.v("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: TrimNative:%s", d());
                try {
                    if (this.f412049o) {
                        createBitmap = Bitmap.createBitmap(this.f412046l, this.f412045k, Bitmap.Config.ARGB_8888);
                    } else {
                        createBitmap = Bitmap.createBitmap(this.f412045k, this.f412046l, Bitmap.Config.ARGB_8888);
                    }
                    this.f412043i.intValue();
                    long intValue = (this.f412043i.intValue() + 1) * this.f412048n;
                    long j3 = this.f412047m;
                    if (intValue > j3) {
                        intValue = j3;
                    }
                    if (TrimNative.getThumbnail(0L, intValue, createBitmap) == 0) {
                        Bitmap copy = createBitmap.copy(Bitmap.Config.RGB_565, true);
                        if (this.f412049o) {
                            copy = UIUtils.p(copy, 90.0f);
                        }
                        b(new BitmapDrawable(copy));
                        createBitmap.recycle();
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        c.v("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: TrimNative \u5b8c\u6210\u65f6\u95f4:%s,key=%s", Long.valueOf(currentTimeMillis2), d());
                        this.f412051q.a(this.f412043i.intValue(), currentTimeMillis2);
                        return;
                    }
                    if (createBitmap != null && !createBitmap.isRecycled()) {
                        createBitmap.recycle();
                    } else {
                        c.g("Q.qqstory.frameWidget.FrameLoader", "TrimNative return error!");
                    }
                } catch (Exception e16) {
                    c.i("Q.qqstory.frameWidget.FrameLoader", "create bitmap width=%s,height=%s,error:%s", Integer.valueOf(this.f412045k), Integer.valueOf(this.f412046l), e16);
                }
            }
            MediaMetadataRetriever mediaMetadataRetriever = this.f412044j;
            if (mediaMetadataRetriever == null) {
                c.g("Q.qqstory.frameWidget.FrameLoader", "mRetriever is null!");
                return;
            }
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.f412043i.intValue() * this.f412048n * 1000);
            if (frameAtTime == null) {
                c.g("Q.qqstory.frameWidget.FrameLoader", "mRetriever return null!");
                return;
            }
            Matrix matrix = new Matrix();
            if (this.f412049o) {
                matrix.postRotate(90.0f);
                matrix.postScale(this.f412045k / frameAtTime.getHeight(), this.f412046l / frameAtTime.getWidth());
            } else {
                matrix.postScale(this.f412045k / frameAtTime.getWidth(), this.f412046l / frameAtTime.getHeight());
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
            frameAtTime.recycle();
            b(new BitmapDrawable(createBitmap2));
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            c.v("Q.qqstory.frameWidget.FrameLoader", "runOnBackGround: mRetriever \u5b8c\u6210\u65f6\u95f4:%s,key=%s", Long.valueOf(currentTimeMillis3), d());
            this.f412051q.a(this.f412043i.intValue(), currentTimeMillis3);
        }
    }

    /* compiled from: P */
    /* renamed from: kd0.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C10648b {

        /* renamed from: a, reason: collision with root package name */
        public int f412052a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f412053b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f412054c = -1;

        /* renamed from: d, reason: collision with root package name */
        private Map<Integer, Long> f412055d = new ConcurrentHashMap();

        public void a(int i3, long j3) {
            this.f412055d.put(Integer.valueOf(i3), Long.valueOf(j3));
            if (this.f412053b < j3) {
                this.f412053b = j3;
                this.f412054c = i3;
            }
        }

        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            Iterator<Map.Entry<Integer, Long>> it = this.f412055d.entrySet().iterator();
            long j3 = 0;
            while (it.hasNext()) {
                j3 += it.next().getValue().longValue();
            }
            if (this.f412055d.size() == 0) {
                return "there_is_no_frame";
            }
            this.f412052a = ((int) j3) / this.f412055d.size();
            sb5.append("avg:");
            sb5.append(this.f412052a);
            sb5.append("|max:");
            sb5.append(this.f412053b);
            sb5.append("|maxId:");
            sb5.append(this.f412054c);
            return sb5.toString();
        }
    }

    public b(String str, int i3, int i16, boolean z16) {
        super(str);
        this.L = false;
        this.M = new C10648b();
        this.N = new LruCache<>(180);
        this.G = i3;
        this.H = i16;
        this.K = z16;
    }

    @Override // nd0.a
    public LruCache<Integer, Drawable> e() {
        return this.N;
    }

    @Override // nd0.a
    @TargetApi(10)
    public void g() {
        super.g();
        this.N.evictAll();
        MediaMetadataRetriever mediaMetadataRetriever = this.E;
        if (mediaMetadataRetriever != null) {
            mediaMetadataRetriever.release();
        }
    }

    @Override // nd0.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public nd0.b d(ImageView imageView, Integer num) {
        return new a(imageView, this.E, num, this.G, this.H, this.J, this.I, this.K, this.M, this.L);
    }

    @TargetApi(10)
    public void j(String str, int i3, int i16) {
        this.J = i3;
        c.c("Q.qqstory.frameWidget.FrameLoader", "initVideo,duration=%s,path=%s", Integer.valueOf(i3), str);
        try {
            if (this.K) {
                int i17 = this.H;
                int i18 = this.G;
                o71.b.c(str, i17, i18, 0, 0, i17, i18);
            } else {
                int i19 = this.G;
                int i26 = this.H;
                o71.b.c(str, i19, i26, 0, 0, i19, i26);
            }
            this.L = true;
        } catch (Exception e16) {
            this.L = false;
            c.h("Q.qqstory.frameWidget.FrameLoader", "ThumbnailUtils init failed! e:%s", e16);
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            this.E = mediaMetadataRetriever;
            mediaMetadataRetriever.setDataSource(str);
            if (Build.VERSION.SDK_INT >= 26) {
                this.L = false;
            }
        } catch (Exception e17) {
            c.g("Q.qqstory.frameWidget.FrameLoader", gd0.b.a("MediaMetadataRetriever init failed! mVideoPath = ", str, "  e=", e17));
            id0.a.k("story_local_video", "frame_loader", 0, 0, str, e17.getMessage());
            this.E = null;
        }
        this.F = str;
        this.I = i16;
        f();
    }
}
