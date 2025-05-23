package com.tencent.luggage.wxa.a8;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Choreographer;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d implements com.tencent.luggage.wxa.ag.i {

    /* renamed from: e, reason: collision with root package name */
    private static final String f120906e = "MicroMsg.AppBrand.AbsXWebVideoContainerChannel";

    /* renamed from: f, reason: collision with root package name */
    private static com.tencent.luggage.wxa.ag.e f120907f = new a();

    /* renamed from: g, reason: collision with root package name */
    private static Handler f120908g = null;

    /* renamed from: a, reason: collision with root package name */
    protected final String f120909a = "MicroMsg.AppBrand.AbsXWebVideoContainerChannel#" + hashCode();

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<TextureView.SurfaceTextureListener> f120910b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private SparseArray<Pair<Surface, SurfaceTexture>> f120911c = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private boolean f120912d = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.ag.e {
        @Override // com.tencent.luggage.wxa.ag.e
        public boolean a() {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements SurfaceTexture.OnFrameAvailableListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Future f120913a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f120914b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v f120915c;

        public b(Future future, Runnable runnable, v vVar) {
            this.f120913a = future;
            this.f120914b = runnable;
            this.f120915c = vVar;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            com.tencent.luggage.wxa.tn.w.d(d.this.f120909a, "scheduleAfterTransferToTask, onFrameAvailable");
            this.f120913a.cancel(false);
            this.f120914b.run();
            this.f120915c.a(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Future f120917a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f120918b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Choreographer.FrameCallback {

            /* renamed from: a, reason: collision with root package name */
            public int f120920a = 0;

            public a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j3) {
                com.tencent.luggage.wxa.tn.w.d(d.this.f120909a, "scheduleAfterTransferFromTask, doFrame");
                int i3 = this.f120920a + 1;
                this.f120920a = i3;
                if (2 <= i3) {
                    c.this.f120917a.cancel(false);
                    c.this.f120918b.run();
                } else {
                    Choreographer.getInstance().postFrameCallback(this);
                }
            }
        }

        public c(Future future, Runnable runnable) {
            this.f120917a = future;
            this.f120918b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Choreographer.getInstance().postFrameCallback(new a());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a8.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C5991d implements SurfaceTexture.OnFrameAvailableListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f120922a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f120923b;

        public C5991d(Runnable runnable, v vVar) {
            this.f120922a = runnable;
            this.f120923b = vVar;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            com.tencent.luggage.wxa.tn.w.d(d.this.f120909a, "scheduleAfterTransferFromTask, onFrameAvailable");
            this.f120922a.run();
            this.f120923b.a(this);
        }
    }

    public abstract e c(View view, Runnable runnable);

    @Override // com.tencent.luggage.wxa.ag.i
    public void b(View view, Runnable runnable) {
        this.f120912d = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.wxa.ag.i
    public void a(@NonNull View view) {
        com.tencent.luggage.wxa.tn.w.a(this.f120909a, "recycleVideoContainerView");
        this.f120910b.remove(view.hashCode());
        ((i) view).setSurfaceTextureListener(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.wxa.ag.i
    public void b(@NonNull View view) {
        com.tencent.luggage.wxa.tn.w.d(this.f120909a, "onPlayEndWorkaround, textureImageViewLike: " + view);
        if (!this.f120912d) {
            com.tencent.luggage.wxa.tn.w.d(this.f120909a, "onPlayEndWorkaround, video is not in pip container");
        }
        i iVar = (i) view;
        Bitmap bitmap = iVar.getBitmap();
        if (bitmap == null) {
            com.tencent.luggage.wxa.tn.w.f(this.f120909a, "onPlayEndWorkaround, bitmap is null");
        } else {
            iVar.setImageBitmap(bitmap);
        }
    }

    @Override // com.tencent.luggage.wxa.ag.i
    @NonNull
    public com.tencent.luggage.wxa.ag.e a() {
        return f120907f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.luggage.wxa.ag.i
    public void a(@NonNull View view, @Nullable Runnable runnable) {
        com.tencent.luggage.wxa.tn.w.d(this.f120909a, "transferTo, textureImageViewLike: " + view);
        this.f120912d = true;
        ((i) view).setImageBitmap(null);
        int hashCode = view.hashCode();
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f120910b.get(hashCode);
        if (surfaceTextureListener != null) {
            com.tencent.luggage.wxa.tn.w.f(this.f120909a, "transferTo, surfaceTextureListener is not null");
            SurfaceTexture surfaceTexture = ((i) view).getSurfaceTexture();
            if (surfaceTexture != null) {
                surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, view.getWidth(), view.getHeight());
            }
            if (runnable != null) {
                com.tencent.luggage.wxa.tn.w.d(this.f120909a, "transferTo, run afterTransferToTask when surfaceTextureListener is not null");
                runnable.run();
                return;
            }
            return;
        }
        e c16 = c(view, runnable);
        com.tencent.luggage.wxa.tn.w.a(this.f120909a, "transferTo, setSurfaceTextureListener");
        ((i) view).setSurfaceTextureListener(c16);
        this.f120910b.put(hashCode, c16);
    }

    public final void b(Runnable runnable, SurfaceTexture surfaceTexture) {
        com.tencent.luggage.wxa.tn.w.d(this.f120909a, "scheduleAfterTransferToTask");
        v a16 = v.a(surfaceTexture);
        com.tencent.luggage.wxa.jq.c c16 = com.tencent.luggage.wxa.zp.h.f146825d.c(runnable, 300L);
        if (a16 != null) {
            a16.a(new b(c16, runnable, a16), b());
        }
    }

    public static Handler b() {
        if (f120908g == null) {
            f120908g = new Handler(Looper.getMainLooper());
        }
        return f120908g;
    }

    public void a(@NonNull Runnable runnable, @NonNull SurfaceTexture surfaceTexture) {
        com.tencent.luggage.wxa.tn.w.d(this.f120909a, "scheduleAfterTransferFromTask");
        v a16 = v.a(surfaceTexture);
        if (a16 != null) {
            com.tencent.luggage.wxa.tn.w.d(this.f120909a, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback");
            a16.a(new C5991d(new c(com.tencent.luggage.wxa.zp.h.f146825d.c(runnable, 600L), runnable), a16), b());
        } else {
            com.tencent.luggage.wxa.tn.w.d(this.f120909a, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback when surfaceTextureWrapper is null");
            com.tencent.luggage.wxa.zp.h.f146825d.c(runnable, 50L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public abstract class e implements TextureView.SurfaceTextureListener {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        protected final Object f120925a;

        /* renamed from: b, reason: collision with root package name */
        private final int f120926b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private volatile Runnable f120927c;

        public e(Object obj, Runnable runnable) {
            this.f120925a = obj;
            this.f120926b = obj.hashCode();
            this.f120927c = runnable;
        }

        public abstract void a();

        public final void a(SurfaceTexture surfaceTexture, int i3, int i16) {
            Surface surface;
            Pair pair = (Pair) d.this.f120911c.get(this.f120926b);
            if (pair != null && pair.second == surfaceTexture) {
                surface = (Surface) pair.first;
            } else {
                Surface surface2 = new Surface(surfaceTexture);
                pair = Pair.create(surface2, surfaceTexture);
                surface = surface2;
            }
            if (a(surface, i3, i16)) {
                d.this.f120911c.put(this.f120926b, pair);
            }
        }

        public abstract boolean a(Surface surface, int i3, int i16);

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int i3, int i16) {
            com.tencent.luggage.wxa.tn.w.a(d.this.f120909a, this.f120925a + " onSurfaceTextureAvailable, surfaceTexture: %s, width: %d, height: %d", surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            a(surfaceTexture, i3, i16);
            Runnable runnable = this.f120927c;
            this.f120927c = null;
            if (runnable != null) {
                d.this.b(runnable, surfaceTexture);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            com.tencent.luggage.wxa.tn.w.a(d.this.f120909a, this.f120925a + " onSurfaceTextureDestroyed, surfaceTexture: " + surfaceTexture);
            a();
            Pair pair = (Pair) d.this.f120911c.get(this.f120926b);
            if (pair == null) {
                return true;
            }
            d.this.f120911c.remove(this.f120926b);
            ((Surface) pair.first).release();
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i3, int i16) {
            if (!d.this.f120912d) {
                com.tencent.luggage.wxa.tn.w.f(d.this.f120909a, "onSurfaceTextureSizeChanged, video is not in pip container");
            } else {
                a(surfaceTexture, i3, i16);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
