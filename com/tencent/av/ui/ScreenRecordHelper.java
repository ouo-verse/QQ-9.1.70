package com.tencent.av.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.effects.g;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.ba;
import com.tencent.avcore.data.RecordParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
@RequiresApi(api = 21)
/* loaded from: classes3.dex */
public class ScreenRecordHelper {

    /* renamed from: r, reason: collision with root package name */
    static final int[][] f75154r = {new int[]{720, 1280}, new int[]{1080, 1920}, new int[]{1080, 1920}};

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f75155a;

    /* renamed from: b, reason: collision with root package name */
    private VirtualDisplay f75156b;

    /* renamed from: c, reason: collision with root package name */
    private MediaProjection f75157c;

    /* renamed from: d, reason: collision with root package name */
    private MediaProjectionManager f75158d;

    /* renamed from: e, reason: collision with root package name */
    private b f75159e;

    /* renamed from: f, reason: collision with root package name */
    private MediaProjection.Callback f75160f;

    /* renamed from: h, reason: collision with root package name */
    private int f75162h;

    /* renamed from: i, reason: collision with root package name */
    private int f75163i;

    /* renamed from: j, reason: collision with root package name */
    private int f75164j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.av.opengl.effects.g f75165k;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.av.audio.d f75168n;

    /* renamed from: p, reason: collision with root package name */
    private g.b f75170p;

    /* renamed from: g, reason: collision with root package name */
    private boolean f75161g = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f75166l = false;

    /* renamed from: m, reason: collision with root package name */
    private final RecordParam f75167m = new RecordParam();

    /* renamed from: o, reason: collision with root package name */
    private boolean f75169o = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f75171q = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements com.tencent.av.audio.e {
        a() {
        }

        @Override // com.tencent.av.audio.e
        public void a(int i3, int i16, int i17, byte[] bArr) {
            IAudioProcessApi c16 = au.a.c();
            if (c16 != null) {
                c16.addPCMData(bArr, bArr.length);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void a(RecordParam recordParam, int i3, int i16);

        void c(int i3);

        void d(int i3);
    }

    private void B() {
        if (this.f75168n != null && ba.canShowAudioShareTips()) {
            ba.clearAudioShareTipsFlag();
            cw.e.n(VideoAppInterface.N(), 3020);
            QLog.i("ScreenRecordHelper", 4, "triggerAudioShareTips end");
        }
    }

    private void i() {
        synchronized (this) {
            this.f75156b = this.f75157c.createVirtualDisplay("ScreenRecordHelper", this.f75163i, this.f75164j, this.f75162h, 16, this.f75165k.o(), null, null);
        }
    }

    private void n(boolean z16) {
        b bVar;
        if (!z16 && (bVar = this.f75159e) != null) {
            bVar.d(1);
        }
    }

    private void p() {
        q(true);
    }

    public boolean A() {
        return this.f75169o;
    }

    public void C(int i3, int i16, int i17) {
        boolean z16;
        char c16;
        int min;
        int i18;
        if (this.f75163i < this.f75164j) {
            z16 = true;
        } else {
            z16 = false;
        }
        int e16 = AEFilterSupport.e();
        if (e16 != 4) {
            if (e16 != 7) {
                c16 = 0;
            } else {
                c16 = 2;
            }
        } else {
            c16 = 1;
        }
        if (Build.VERSION.SDK_INT < 29) {
            c16 = 0;
        }
        int[] iArr = f75154r[c16];
        int i19 = iArr[0];
        int i26 = iArr[1];
        if (i3 != 0 && i16 != 0 && Math.max(i3, i16) < Math.max(i19, i26)) {
            i19 = Math.min(i3, i16);
            i26 = Math.max(i3, i16);
        }
        if (z16) {
            int i27 = i19;
            i19 = i26;
            i26 = i27;
        }
        if (z16) {
            i18 = (Math.min(this.f75164j, i19) / 16) * 16;
            min = (((int) (i18 * (this.f75163i / this.f75164j))) / 16) * 16;
        } else {
            min = (Math.min(this.f75163i, i26) / 16) * 16;
            i18 = (((int) ((min * this.f75164j) / this.f75163i)) / 16) * 16;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("ScreenRecordHelper", 4, "updateRecordParam, pre[" + this.f75167m + "], display[" + this.f75163i + "," + this.f75164j + "], limit[" + i26 + "," + i19 + "], come[" + i3 + "," + i16 + "," + i17 + "], record[" + min + "," + i18 + "]");
        }
        RecordParam recordParam = this.f75167m;
        recordParam.width = min;
        recordParam.height = i18;
        if (i17 > 0) {
            recordParam.fps = i17;
        }
        com.tencent.av.opengl.effects.g gVar = this.f75165k;
        if (gVar != null) {
            gVar.w(recordParam);
        }
    }

    public synchronized boolean g() {
        QLog.d("ScreenRecordHelper", 1, "attachRecorder");
        return true;
    }

    public void h() {
        QLog.i("ScreenRecordHelper", 1, "closeShareAudio.");
        com.tencent.av.audio.d dVar = this.f75168n;
        if (dVar != null) {
            dVar.e();
        }
        this.f75169o = false;
    }

    public synchronized boolean j() {
        QLog.d("ScreenRecordHelper", 1, "detachRecorder");
        return true;
    }

    public void k(Context context) {
        l(context, true);
    }

    public void l(Context context, boolean z16) {
        this.f75155a = new WeakReference<>(context);
        if (!this.f75161g && context != null) {
            boolean z17 = true;
            this.f75161g = true;
            this.f75158d = (MediaProjectionManager) context.getApplicationContext().getSystemService("media_projection");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.f75162h = displayMetrics.densityDpi;
            Point point = new Point();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
            boolean z18 = this.f75171q;
            int i3 = point.y;
            int i16 = point.x;
            if (i3 <= i16) {
                z17 = false;
            }
            if (z18 ^ z17) {
                this.f75163i = i16;
                this.f75164j = i3;
            } else {
                this.f75163i = i3;
                this.f75164j = i16;
            }
            C(0, 0, 15);
            com.tencent.av.opengl.effects.g gVar = new com.tencent.av.opengl.effects.g();
            this.f75165k = gVar;
            gVar.u(this.f75163i, this.f75164j);
            this.f75165k.w(this.f75167m);
            this.f75165k.v();
            if (Build.VERSION.SDK_INT >= 29 && z16) {
                com.tencent.av.audio.d dVar = new com.tencent.av.audio.d();
                this.f75168n = dVar;
                dVar.d();
                this.f75168n.j(new a());
                au.a.a(com.tencent.av.r.h0().W(), com.tencent.av.r.h0());
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("ScreenRecordHelper", 4, "doBindActivityContext, density[" + this.f75162h + "], size[" + this.f75163i + "," + this.f75164j + "]");
            }
        }
    }

    public boolean m() {
        if (this.f75161g && this.f75166l) {
            return true;
        }
        return false;
    }

    public void o() {
        QLog.i("ScreenRecordHelper", 1, "openShareAudio.");
        com.tencent.av.audio.d dVar = this.f75168n;
        if (dVar != null) {
            dVar.g();
        }
        this.f75169o = true;
    }

    public void q(boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.i("ScreenRecordHelper", 4, "quit");
        }
        com.tencent.av.opengl.effects.g gVar = this.f75165k;
        if (gVar != null) {
            gVar.q(true);
            this.f75165k = null;
        }
        com.tencent.av.audio.d dVar = this.f75168n;
        if (dVar != null && z16) {
            dVar.m();
            this.f75168n = null;
            au.a.b();
        }
        this.f75158d = null;
        this.f75166l = false;
        this.f75161g = false;
    }

    public void r() {
        n(false);
    }

    public void s() {
        Object obj;
        WeakReference<Context> weakReference = this.f75155a;
        Activity activity = null;
        if (weakReference == null) {
            obj = null;
        } else {
            obj = (Context) weakReference.get();
        }
        if (obj instanceof Activity) {
            activity = (Activity) obj;
        }
        if (activity == null) {
            QLog.i("ScreenRecordHelper", 1, "requestScreenCapture, context not bind Activity .");
            return;
        }
        QLog.d("ScreenRecordHelper", 1, "Start requestScreenCapture");
        try {
            activity.startActivityForResult(this.f75158d.createScreenCaptureIntent(), 8080);
        } catch (ActivityNotFoundException unused) {
            QLog.d("ScreenRecordHelper", 1, "Start requestScreenCapture fail ActivityNotFoundException");
        }
    }

    public void t(boolean z16) {
        WeakReference<Context> weakReference;
        if (z16 != this.f75171q && (weakReference = this.f75155a) != null && weakReference.get() != null) {
            this.f75171q = z16;
            q(false);
            this.f75166l = true;
            l(this.f75155a.get(), false);
            com.tencent.av.opengl.effects.g gVar = this.f75165k;
            if (gVar != null && gVar.n() != null) {
                this.f75165k.n().post(new Runnable() { // from class: com.tencent.av.ui.ScreenRecordHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d("ScreenRecordHelper", 1, "mEGLScreenCapture.getHandler().post.");
                        synchronized (ScreenRecordHelper.this) {
                            if (ScreenRecordHelper.this.f75156b != null && ScreenRecordHelper.this.f75165k != null) {
                                ScreenRecordHelper.this.f75156b.setSurface(ScreenRecordHelper.this.f75165k.o());
                                ScreenRecordHelper.this.f75156b.resize(ScreenRecordHelper.this.f75163i, ScreenRecordHelper.this.f75164j, ScreenRecordHelper.this.f75162h);
                            }
                        }
                        ScreenRecordHelper screenRecordHelper = ScreenRecordHelper.this;
                        screenRecordHelper.v(screenRecordHelper.f75170p);
                    }
                });
            }
            QLog.d("ScreenRecordHelper", 1, "restart " + z16);
        }
    }

    public void u(MediaProjection.Callback callback) {
        this.f75160f = callback;
    }

    public void v(g.b bVar) {
        com.tencent.av.opengl.effects.g gVar = this.f75165k;
        if (gVar != null) {
            gVar.t(bVar);
        }
        this.f75170p = bVar;
    }

    public void w(b bVar) {
        this.f75159e = bVar;
    }

    public boolean x(Intent intent) {
        Context context;
        QLog.d("ScreenRecordHelper", 1, "Start startProjection");
        long d16 = com.tencent.av.utils.e.d();
        WeakReference<Context> weakReference = this.f75155a;
        if (weakReference == null) {
            context = null;
        } else {
            context = weakReference.get();
        }
        if (context == null) {
            QLog.d("ScreenRecordHelper", 1, "Start startProjection, context is null.");
            return false;
        }
        MediaProjectionManager mediaProjectionManager = this.f75158d;
        if (mediaProjectionManager == null) {
            n(false);
            QLog.d("ScreenRecordHelper", 1, "Start startProjection, mMediaProjectionManager is null.");
            return false;
        }
        MediaProjection mediaProjection = mediaProjectionManager.getMediaProjection(-1, intent);
        this.f75157c = mediaProjection;
        if (mediaProjection == null) {
            n(false);
            return false;
        }
        MediaProjection.Callback callback = this.f75160f;
        if (callback != null) {
            mediaProjection.registerCallback(callback, null);
        }
        com.tencent.av.audio.d dVar = this.f75168n;
        if (dVar != null) {
            dVar.k(this.f75157c);
            if (this.f75169o) {
                this.f75168n.g();
            }
            B();
            au.a.c().startPlay(10);
        }
        n(true);
        i();
        b bVar = this.f75159e;
        if (bVar != null) {
            bVar.a(this.f75167m, this.f75163i, this.f75164j);
        }
        SmallScreenUtils.b(d16, 3, context, true, VideoAppInterface.N().getCurrentAccountUin(), true);
        this.f75166l = true;
        com.tencent.av.screenshare.d.f74296a = false;
        return true;
    }

    public void y(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("ScreenRecordHelper", 4, "stop, fromType[" + i3 + "]");
        }
        j();
        z(i3);
        p();
    }

    public boolean z(int i3) {
        Context context;
        long d16 = com.tencent.av.utils.e.d();
        QLog.d("ScreenRecordHelper", 1, "Start stopProjection fromType:=" + i3);
        this.f75171q = false;
        synchronized (this) {
            VirtualDisplay virtualDisplay = this.f75156b;
            context = null;
            if (virtualDisplay != null) {
                virtualDisplay.release();
                this.f75156b = null;
            }
        }
        com.tencent.av.audio.d dVar = this.f75168n;
        if (dVar != null) {
            dVar.a();
            this.f75168n.e();
            au.a.c().stopPlay();
        }
        MediaProjection mediaProjection = this.f75157c;
        if (mediaProjection != null) {
            try {
                mediaProjection.stop();
                MediaProjection.Callback callback = this.f75160f;
                if (callback != null) {
                    this.f75157c.unregisterCallback(callback);
                    this.f75160f = null;
                }
            } catch (Exception e16) {
                QLog.e("ScreenRecordHelper", 1, "stopProjection error: " + e16);
            }
            this.f75157c = null;
        }
        b bVar = this.f75159e;
        if (bVar != null) {
            bVar.c(i3);
        }
        v(null);
        w(null);
        this.f75166l = false;
        cw.e.b(VideoAppInterface.N(), true);
        WeakReference<Context> weakReference = this.f75155a;
        if (weakReference != null) {
            context = weakReference.get();
        }
        if (context != null) {
            if (i3 == 1) {
                SmallScreenUtils.a(d16, 3, context);
            } else if (i3 != 2) {
                SmallScreenUtils.a(d16, 3, context);
            }
        }
        return true;
    }
}
