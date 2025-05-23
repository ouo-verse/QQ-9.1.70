package org.libpag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.opengl.EGLContext;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.libpag.PAGAnimator;
import org.libpag.PAGFile;

/* loaded from: classes29.dex */
public class PAGView extends TextureView implements TextureView.SurfaceTextureListener, org.extra.tools.d, PAGAnimator.Listener {

    /* renamed from: p, reason: collision with root package name */
    private static final e f423755p = new e(null);

    /* renamed from: a, reason: collision with root package name */
    private TextureView.SurfaceTextureListener f423756a;

    /* renamed from: b, reason: collision with root package name */
    private PAGPlayer f423757b;

    /* renamed from: c, reason: collision with root package name */
    private PAGSurface f423758c;

    /* renamed from: d, reason: collision with root package name */
    private PAGAnimator f423759d;

    /* renamed from: e, reason: collision with root package name */
    private String f423760e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f423761f;

    /* renamed from: g, reason: collision with root package name */
    private EGLContext f423762g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f423763h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f423764i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f423765j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f423766k;

    /* renamed from: l, reason: collision with root package name */
    private int f423767l;

    /* renamed from: m, reason: collision with root package name */
    private PAGAudioReader f423768m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f423769n;

    /* renamed from: o, reason: collision with root package name */
    private f f423770o;

    @Deprecated
    /* loaded from: classes29.dex */
    public interface PAGFlushListener {
        void onFlush();
    }

    /* loaded from: classes29.dex */
    public interface PAGViewListener {
        void onAnimationCancel(PAGView pAGView);

        void onAnimationEnd(PAGView pAGView);

        void onAnimationRepeat(PAGView pAGView);

        void onAnimationStart(PAGView pAGView);

        void onAnimationUpdate(PAGView pAGView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean isOpaque = PAGView.this.isOpaque();
            PAGView.this.setOpaque(!isOpaque);
            PAGView.this.setOpaque(isOpaque);
        }
    }

    /* loaded from: classes29.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SurfaceTexture f423772a;

        b(SurfaceTexture surfaceTexture) {
            this.f423772a = surfaceTexture;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f423772a.release();
        }
    }

    /* loaded from: classes29.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            synchronized (PAGView.this) {
                arrayList = new ArrayList(PAGView.this.f423764i);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((PAGFlushListener) it.next()).onFlush();
            }
        }
    }

    /* loaded from: classes29.dex */
    class d implements f {
        d() {
        }

        @Override // org.libpag.PAGView.f
        public void a(long j3) {
            double progress;
            boolean isRunning = PAGView.this.f423759d.isRunning();
            long duration = PAGView.this.f423759d.duration() / 1000;
            double d16 = duration;
            long progress2 = (long) (PAGView.this.f423759d.progress() * d16);
            long j16 = (j3 / 1000) - PAGView.this.f423767l;
            long j17 = j16 - progress2;
            long j18 = (j16 + duration) - progress2;
            if (Math.abs(j17) > Math.abs(j18)) {
                j17 = j18;
            } else {
                long j19 = (j16 - duration) - progress2;
                if (Math.abs(j17) > Math.abs(j19)) {
                    j17 = j19;
                }
            }
            if (-100 > j17) {
                if (isRunning) {
                    PAGView.this.f423759d.cancel();
                    PAGView.this.f423769n = true;
                    return;
                }
                return;
            }
            if (25 < j17) {
                if (isRunning) {
                    progress = PAGView.this.f423759d.progress();
                } else {
                    progress = PAGView.this.f423757b.getProgress();
                }
                PAGView.this.f423759d.setProgress(progress + ((j17 + 25) / d16));
                return;
            }
            if (!isRunning && PAGView.this.f423769n && j17 >= 0) {
                PAGView.this.f423759d.a();
                PAGView.this.f423769n = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public interface f {
        void a(long j3);
    }

    public PAGView(Context context) {
        super(context);
        this.f423760e = "";
        this.f423761f = false;
        this.f423762g = null;
        this.f423763h = new ArrayList();
        this.f423764i = new ArrayList();
        this.f423765j = false;
        this.f423766k = true;
        this.f423767l = 0;
        this.f423768m = null;
        this.f423769n = false;
        this.f423770o = new d();
        c();
        setupAudioReader(context);
        if (context != null) {
            PAGLicenseManager.a(context);
        }
    }

    private void setupAudioReader(Context context) {
        PAGAudioReader Make = PAGAudioReader.Make(44100, 1024, 2, 1.0f);
        this.f423768m = Make;
        if (Make == null) {
            return;
        }
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            this.f423767l = ((Integer) audioManager.getClass().getMethod("getOutputLatency", Integer.TYPE).invoke(audioManager, 3)).intValue();
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (NoSuchMethodException e17) {
            e17.printStackTrace();
        } catch (InvocationTargetException e18) {
            e18.printStackTrace();
        }
    }

    public void addListener(PAGViewListener pAGViewListener) {
        synchronized (this) {
            this.f423763h.add(pAGViewListener);
        }
    }

    @Deprecated
    public void addPAGFlushListener(PAGFlushListener pAGFlushListener) {
        synchronized (this) {
            this.f423764i.add(pAGFlushListener);
        }
    }

    public boolean cacheEnabled() {
        return this.f423757b.cacheEnabled();
    }

    public float cacheScale() {
        return this.f423757b.cacheScale();
    }

    public long currentFrame() {
        return this.f423757b.currentFrame();
    }

    public long duration() {
        return this.f423757b.duration();
    }

    public boolean flush() {
        return this.f423757b.flush();
    }

    public void freeCache() {
        PAGSurface pAGSurface = this.f423758c;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
    }

    public RectF getBounds(PAGLayer pAGLayer) {
        if (pAGLayer != null) {
            return this.f423757b.getBounds(pAGLayer);
        }
        return new RectF();
    }

    public PAGComposition getComposition() {
        return this.f423757b.getComposition();
    }

    public PAGLayer[] getLayersUnderPoint(float f16, float f17) {
        return this.f423757b.getLayersUnderPoint(f16, f17);
    }

    public String getPath() {
        return this.f423760e;
    }

    public double getProgress() {
        return this.f423757b.getProgress();
    }

    public boolean isAudioEnable() {
        return this.f423766k;
    }

    public boolean isPlaying() {
        return this.f423759d.isRunning();
    }

    public boolean isSync() {
        return this.f423759d.isSync();
    }

    public Bitmap makeSnapshot() {
        PAGSurface pAGSurface = this.f423758c;
        if (pAGSurface != null) {
            return pAGSurface.makeSnapshot();
        }
        return null;
    }

    public Matrix matrix() {
        return this.f423757b.matrix();
    }

    public float maxFrameRate() {
        return this.f423757b.maxFrameRate();
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationCancel(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f423763h);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationCancel(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationEnd(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        PAGAudioReader pAGAudioReader = this.f423768m;
        if (pAGAudioReader != null) {
            f423755p.b(pAGAudioReader);
        }
        synchronized (this) {
            arrayList = new ArrayList(this.f423763h);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationEnd(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationRepeat(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f423763h);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationRepeat(this);
        }
        PAGAudioReader pAGAudioReader = this.f423768m;
        if (pAGAudioReader != null) {
            pAGAudioReader.seek(0L);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationStart(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        PAGAudioReader pAGAudioReader = this.f423768m;
        if (pAGAudioReader != null) {
            a(pAGAudioReader);
        }
        synchronized (this) {
            arrayList = new ArrayList(this.f423763h);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationStart(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationUpdate(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        this.f423757b.setProgress(pAGAnimator.progress());
        synchronized (this) {
            if (!this.f423761f) {
                return;
            }
            if (this.f423765j) {
                pAGAnimator.setDuration(this.f423757b.duration());
            }
            if (flush()) {
                d();
            }
            synchronized (this) {
                arrayList = new ArrayList(this.f423763h);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((PAGViewListener) it.next()).onAnimationUpdate(this);
            }
            if (!this.f423764i.isEmpty()) {
                post(new c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        this.f423761f = true;
        super.onAttachedToWindow();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.f423761f = false;
        super.onDetachedFromWindow();
        PAGSurface pAGSurface = this.f423758c;
        if (pAGSurface != null) {
            pAGSurface.release();
            this.f423758c = null;
        }
        a();
    }

    @Override // org.extra.tools.d
    public void onResume() {
        if (this.f423765j) {
            setVisibility(4);
            setVisibility(0);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        PAGSurface pAGSurface = this.f423758c;
        if (pAGSurface != null) {
            pAGSurface.release();
            this.f423758c = null;
        }
        PAGSurface FromSurfaceTexture = PAGSurface.FromSurfaceTexture(surfaceTexture, this.f423762g);
        this.f423758c = FromSurfaceTexture;
        this.f423757b.setSurface(FromSurfaceTexture);
        PAGSurface pAGSurface2 = this.f423758c;
        if (pAGSurface2 == null) {
            return;
        }
        pAGSurface2.clearAll();
        this.f423759d.update();
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f423756a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i3, i16);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f423757b.setSurface(null);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f423756a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        PAGSurface pAGSurface = this.f423758c;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
        post(new b(surfaceTexture));
        PAGAudioReader pAGAudioReader = this.f423768m;
        if (pAGAudioReader != null) {
            f423755p.b(pAGAudioReader);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        PAGSurface pAGSurface = this.f423758c;
        if (pAGSurface != null) {
            pAGSurface.updateSize();
            this.f423758c.clearAll();
            this.f423759d.update();
        }
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f423756a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i3, i16);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f423756a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z16) {
        super.onVisibilityAggregated(z16);
        a();
        if (z16) {
            PAGAudioReader pAGAudioReader = this.f423768m;
            if (pAGAudioReader != null) {
                a(pAGAudioReader);
                return;
            }
            return;
        }
        PAGAudioReader pAGAudioReader2 = this.f423768m;
        if (pAGAudioReader2 != null) {
            f423755p.b(pAGAudioReader2);
        }
    }

    public void pause() {
        stop();
    }

    public void play() {
        this.f423757b.prepare();
        this.f423759d.a();
    }

    public void removeListener(PAGViewListener pAGViewListener) {
        synchronized (this) {
            this.f423763h.remove(pAGViewListener);
        }
    }

    @Deprecated
    public void removePAGFlushListener(PAGFlushListener pAGFlushListener) {
        synchronized (this) {
            this.f423764i.remove(pAGFlushListener);
        }
    }

    public int repeatCount() {
        return this.f423759d.repeatCount();
    }

    public int scaleMode() {
        return this.f423757b.scaleMode();
    }

    public void setAudioEnable(boolean z16) {
        this.f423766k = z16;
        if (this.f423768m == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a(this.f423768m);
        } else {
            post(new Runnable() { // from class: org.libpag.h
                @Override // java.lang.Runnable
                public final void run() {
                    PAGView.this.b();
                }
            });
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24 && drawable != null) {
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setCacheEnabled(boolean z16) {
        this.f423757b.setCacheEnabled(z16);
    }

    public void setCacheScale(float f16) {
        this.f423757b.setCacheScale(f16);
    }

    public void setComposition(PAGComposition pAGComposition) {
        this.f423760e = null;
        this.f423757b.setComposition(pAGComposition);
        PAGAudioReader pAGAudioReader = this.f423768m;
        if (pAGAudioReader != null) {
            pAGAudioReader.setComposition(pAGComposition);
        }
        this.f423759d.setProgress(this.f423757b.getProgress());
        if (this.f423765j) {
            this.f423759d.setDuration(this.f423757b.duration());
        }
    }

    public void setMatrix(Matrix matrix) {
        this.f423757b.setMatrix(matrix);
    }

    public void setMaxFrameRate(float f16) {
        this.f423757b.setMaxFrameRate(f16);
    }

    public boolean setPath(String str) {
        PAGFile Load;
        if (str != null && str.startsWith("assets://")) {
            Load = PagViewMonitor.Load(getContext().getAssets(), str.substring(9));
        } else {
            Load = PagViewMonitor.Load(str);
        }
        setComposition(Load);
        this.f423760e = str;
        if (Load != null) {
            return true;
        }
        return false;
    }

    public void setPathAsync(final String str, final PAGFile.LoadListener loadListener) {
        NativeTask.Run(new Runnable() { // from class: org.libpag.g
            @Override // java.lang.Runnable
            public final void run() {
                PAGView.this.a(str, loadListener);
            }
        });
    }

    public void setProgress(double d16) {
        this.f423757b.setProgress(d16);
        PAGAudioReader pAGAudioReader = this.f423768m;
        if (pAGAudioReader != null) {
            pAGAudioReader.seek((long) (this.f423757b.duration() * d16));
        }
        this.f423759d.setProgress(this.f423757b.getProgress());
        this.f423759d.update();
    }

    public void setRepeatCount(int i3) {
        this.f423759d.setRepeatCount(i3);
    }

    public void setScaleMode(int i3) {
        this.f423757b.setScaleMode(i3);
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        if (surfaceTextureListener == this) {
            super.setSurfaceTextureListener(surfaceTextureListener);
        } else {
            this.f423756a = surfaceTextureListener;
        }
    }

    public void setSync(boolean z16) {
        this.f423759d.setSync(z16);
    }

    public void setUseDiskCache(boolean z16) {
        this.f423757b.setUseDiskCache(z16);
    }

    public void setVideoEnabled(boolean z16) {
        this.f423757b.setVideoEnabled(z16);
    }

    public void stop() {
        this.f423759d.cancel();
        PAGAudioReader pAGAudioReader = this.f423768m;
        if (pAGAudioReader != null) {
            f423755p.b(pAGAudioReader);
        }
    }

    public boolean useDiskCache() {
        return this.f423757b.useDiskCache();
    }

    public boolean videoEnabled() {
        return this.f423757b.videoEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        a(this.f423768m);
    }

    private void c() {
        org.extra.tools.b.a().a(this);
        setOpaque(false);
        this.f423757b = new PAGPlayer();
        setSurfaceTextureListener(this);
        this.f423759d = PAGAnimator.a(getContext(), this);
    }

    private void d() {
        post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, PAGFile.LoadListener loadListener) {
        setPath(str);
        if (loadListener != null) {
            loadListener.onLoad((PAGFile) this.f423757b.getComposition());
        }
    }

    private void a() {
        boolean z16 = this.f423761f && isShown();
        if (this.f423765j == z16) {
            return;
        }
        this.f423765j = z16;
        if (z16) {
            this.f423759d.setDuration(this.f423757b.duration());
            this.f423759d.update();
            PAGAudioReader pAGAudioReader = this.f423768m;
            if (pAGAudioReader != null) {
                a(pAGAudioReader);
                return;
            }
            return;
        }
        this.f423759d.setDuration(0L);
        PAGAudioReader pAGAudioReader2 = this.f423768m;
        if (pAGAudioReader2 != null) {
            f423755p.b(pAGAudioReader2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes29.dex */
    public static class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Object f423776a;

        /* renamed from: b, reason: collision with root package name */
        private Map f423777b;

        /* renamed from: c, reason: collision with root package name */
        private AudioTrack f423778c;

        /* renamed from: d, reason: collision with root package name */
        private Thread f423779d;

        /* renamed from: e, reason: collision with root package name */
        private volatile boolean f423780e;

        e() {
            this.f423776a = new Object();
            this.f423777b = new HashMap();
            this.f423778c = null;
            this.f423779d = null;
            this.f423780e = false;
        }

        void a(PAGAudioReader pAGAudioReader, f fVar) {
            synchronized (this.f423776a) {
                if (!this.f423777b.containsKey(pAGAudioReader)) {
                    this.f423777b.put(pAGAudioReader, fVar);
                }
            }
            if (this.f423780e) {
                return;
            }
            this.f423780e = true;
            if (this.f423778c == null) {
                a();
            }
            if (this.f423779d == null) {
                BaseThread baseThread = new BaseThread(this);
                this.f423779d = baseThread;
                baseThread.start();
            }
        }

        void b(PAGAudioReader pAGAudioReader) {
            boolean isEmpty;
            synchronized (this.f423776a) {
                if (this.f423777b.containsKey(pAGAudioReader)) {
                    this.f423777b.remove(pAGAudioReader);
                }
                isEmpty = this.f423777b.isEmpty();
            }
            if (isEmpty && this.f423779d != null && this.f423778c != null) {
                this.f423780e = false;
                AudioTrack audioTrack = this.f423778c;
                if (audioTrack != null) {
                    audioTrack.stop();
                }
                try {
                    this.f423779d.join();
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                this.f423778c.release();
                this.f423778c = null;
                this.f423779d = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            ByteBuffer MergeFrames;
            while (this.f423780e) {
                ArrayList arrayList = new ArrayList();
                synchronized (this.f423776a) {
                    hashMap = new HashMap(this.f423777b);
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    PAGAudioReader pAGAudioReader = (PAGAudioReader) entry.getKey();
                    f fVar = (f) entry.getValue();
                    PAGAudioSample readNextSample = pAGAudioReader.readNextSample();
                    if (readNextSample != null) {
                        arrayList.add(readNextSample);
                    }
                    if (fVar != null) {
                        fVar.a(readNextSample.timestamp);
                    }
                }
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    if (size == 1) {
                        MergeFrames = ((PAGAudioSample) arrayList.get(0)).data;
                    } else {
                        MergeFrames = PAGAudioSample.MergeFrames((PAGAudioSample[]) arrayList.toArray(new PAGAudioSample[size]));
                    }
                    this.f423778c.write(MergeFrames, MergeFrames.capacity(), 0);
                }
            }
        }

        /* synthetic */ e(a aVar) {
            this();
        }

        boolean a(PAGAudioReader pAGAudioReader) {
            boolean containsKey;
            synchronized (this.f423776a) {
                containsKey = this.f423777b.containsKey(pAGAudioReader);
            }
            return containsKey;
        }

        private void a() {
            AudioTrack audioTrack = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), new AudioFormat.Builder().setSampleRate(44100).setEncoding(2).setChannelMask(12).build(), AudioTrack.getMinBufferSize(44100, 12, 2), 1, 0);
            this.f423778c = audioTrack;
            if (audioTrack.getState() != 1) {
                Log.e("PAGView", "Create AudioTrack failure");
                this.f423778c = null;
            } else {
                this.f423778c.play();
            }
        }
    }

    private void a(PAGAudioReader pAGAudioReader) {
        boolean z16 = pAGAudioReader.isEmpty() || !this.f423766k;
        e eVar = f423755p;
        if (eVar.a(pAGAudioReader) == z16) {
            if (!z16) {
                boolean isRunning = this.f423759d.isRunning();
                pAGAudioReader.seek((long) (this.f423759d.progress() * this.f423759d.duration()));
                if (isRunning || this.f423769n) {
                    eVar.a(pAGAudioReader, this.f423770o);
                    return;
                }
                return;
            }
            eVar.b(pAGAudioReader);
        }
    }

    public PAGView(Context context, EGLContext eGLContext) {
        super(context);
        this.f423760e = "";
        this.f423761f = false;
        this.f423762g = null;
        this.f423763h = new ArrayList();
        this.f423764i = new ArrayList();
        this.f423765j = false;
        this.f423766k = true;
        this.f423767l = 0;
        this.f423768m = null;
        this.f423769n = false;
        this.f423770o = new d();
        this.f423762g = eGLContext;
        c();
        setupAudioReader(context);
        if (context != null) {
            PAGLicenseManager.a(context);
        }
    }

    public PAGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f423760e = "";
        this.f423761f = false;
        this.f423762g = null;
        this.f423763h = new ArrayList();
        this.f423764i = new ArrayList();
        this.f423765j = false;
        this.f423766k = true;
        this.f423767l = 0;
        this.f423768m = null;
        this.f423769n = false;
        this.f423770o = new d();
        c();
        setupAudioReader(context);
        if (context != null) {
            PAGLicenseManager.a(context);
        }
    }

    public PAGView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f423760e = "";
        this.f423761f = false;
        this.f423762g = null;
        this.f423763h = new ArrayList();
        this.f423764i = new ArrayList();
        this.f423765j = false;
        this.f423766k = true;
        this.f423767l = 0;
        this.f423768m = null;
        this.f423769n = false;
        this.f423770o = new d();
        c();
        setupAudioReader(context);
        if (context != null) {
            PAGLicenseManager.a(context);
        }
    }
}
