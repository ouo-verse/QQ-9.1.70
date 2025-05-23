package com.tencent.biz.qui.quipolarlight.render;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import androidx.annotation.UiThread;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import td0.i;
import tl.h;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 V2\u00020\u0001:\u0002\u0011[B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0007R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010*R\"\u00101\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010-\u001a\u0004\b&\u0010.\"\u0004\b/\u00100R\"\u00104\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010-\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R*\u0010:\u001a\u00020\n2\u0006\u00105\u001a\u00020\n8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010=\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010-\u001a\u0004\b;\u0010.\"\u0004\b<\u00100R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010>R\"\u0010F\u001a\u00020@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010HR\u0016\u0010J\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010>R6\u0010Q\u001a\b\u0012\u0004\u0012\u00020\n0K2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\n0K8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR*\u0010X\u001a\u00020R2\u0006\u00105\u001a\u00020R8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W\u00a8\u0006\\"}, d2 = {"Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender;", "", "", h.F, "i", "", "fromGPU", "l", "k", "j", "", "result", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qui/quipolarlight/render/d;", "callback", "u", "v", "a", "I", "renderWidth", "b", "renderHeight", "Landroid/os/HandlerThread;", "c", "Landroid/os/HandlerThread;", "renderThread", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "renderHandler", "Lcom/tencent/biz/qui/quipolarlight/render/b;", "e", "Lcom/tencent/biz/qui/quipolarlight/render/b;", "gpuRender", "Lcom/tencent/biz/qui/quipolarlight/render/a;", "f", "Lcom/tencent/biz/qui/quipolarlight/render/a;", "cpuRender", "g", "Lcom/tencent/biz/qui/quipolarlight/render/d;", "renderCallback", "Ltd0/i;", "Ltd0/i;", "reportDelegate", "", UserInfo.SEX_FEMALE, "()F", DomainData.DOMAIN_NAME, "(F)V", "firstFrame", "getOffset", "r", "offset", "value", "getFps", "()I", "o", "(I)V", "fps", "getFrequency", "p", "frequency", "Z", "renderOnGPU", "Lcom/tencent/biz/qui/quipolarlight/a;", "Lcom/tencent/biz/qui/quipolarlight/a;", "getGradient", "()Lcom/tencent/biz/qui/quipolarlight/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/biz/qui/quipolarlight/a;)V", "gradient", "", "J", "frameTime", "renderStopped", "", "Ljava/util/List;", "getRenderColors", "()Ljava/util/List;", ReportConstant.COSTREPORT_PREFIX, "(Ljava/util/List;)V", "renderColors", "Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender$RenderSize;", "Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender$RenderSize;", "getRenderSize", "()Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender$RenderSize;", "t", "(Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender$RenderSize;)V", "renderSize", "<init>", "()V", "RenderSize", "QUIPolarLight_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class PolarImageRender {

    /* renamed from: s, reason: collision with root package name */
    private static boolean f95214s;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private HandlerThread renderThread;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Handler renderHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private b gpuRender;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private a cpuRender;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private d renderCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private i reportDelegate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float firstFrame;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean renderStopped;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Integer> renderColors;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RenderSize renderSize;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int renderWidth = 50;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int renderHeight = 50;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float offset = 0.5f;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int fps = 30;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float frequency = 0.025f;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean renderOnGPU = true;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.biz.qui.quipolarlight.a gradient = a.C0951a.f95204a;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long frameTime = 1000 / 30;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qui/quipolarlight/render/PolarImageRender$RenderSize;", "", "(Ljava/lang/String;I)V", "LARGE", "MEDIUM", "SMALL", "QUIPolarLight_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public enum RenderSize {
        LARGE,
        MEDIUM,
        SMALL
    }

    public PolarImageRender() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#FFFFFF")), Integer.valueOf(Color.parseColor("#E8FFF0")), Integer.valueOf(Color.parseColor("#7CD1F8")), Integer.valueOf(Color.parseColor("#0099FF")), Integer.valueOf(Color.parseColor("#026EFF")), Integer.valueOf(Color.parseColor("#C862FB")), Integer.valueOf(Color.parseColor("#FF8A74")), Integer.valueOf(Color.parseColor("#FAE366")), Integer.valueOf(Color.parseColor("#FFFFFF"))});
        this.renderColors = listOf;
        this.renderSize = RenderSize.MEDIUM;
    }

    private final void h() {
        Handler handler;
        Looper looper;
        if (this.renderThread == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("RenderingCapturing");
            this.renderThread = baseHandlerThread;
            baseHandlerThread.start();
            HandlerThread handlerThread = this.renderThread;
            if (handlerThread != null && (looper = handlerThread.getLooper()) != null) {
                handler = new Handler(looper);
            } else {
                handler = null;
            }
            this.renderHandler = handler;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        if (this.renderStopped) {
            return;
        }
        l(this.renderOnGPU);
    }

    private final void j() {
        int[] intArray;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.cpuRender == null) {
            this.cpuRender = new a(new Size(this.renderWidth, this.renderHeight));
        }
        a aVar = this.cpuRender;
        Intrinsics.checkNotNull(aVar);
        float f16 = this.firstFrame;
        intArray = CollectionsKt___CollectionsKt.toIntArray(this.renderColors);
        Bitmap d16 = aVar.d(f16, intArray, this.frequency, this.gradient);
        d dVar = this.renderCallback;
        if (dVar != null) {
            dVar.onSuccess(d16);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 66) {
            ud0.d.b("PolarImageRender", ud0.d.f438811e, "render on CPU time out" + currentTimeMillis2 + " limit time : 66");
            d dVar2 = this.renderCallback;
            if (dVar2 != null) {
                dVar2.onFailed("render time out");
            }
            v();
            m(2);
            return;
        }
        long max = Math.max(this.frameTime - currentTimeMillis2, 0L);
        Handler handler = this.renderHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.renderHandler;
        if (handler2 != null) {
            handler2.postDelayed(new Runnable() { // from class: com.tencent.biz.qui.quipolarlight.render.PolarImageRender$renderImageOnCPU$1
                @Override // java.lang.Runnable
                public final void run() {
                    PolarImageRender.this.i();
                }
            }, max);
        }
        this.firstFrame += this.offset;
    }

    private final void k() {
        int[] intArray;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.gpuRender == null) {
            this.gpuRender = new b(new Size(this.renderWidth, this.renderHeight));
        }
        b bVar = this.gpuRender;
        if (bVar != null) {
            float f16 = this.firstFrame;
            intArray = CollectionsKt___CollectionsKt.toIntArray(this.renderColors);
            Bitmap b16 = bVar.b(f16, intArray, this.frequency, this.gradient);
            if (b16 != null) {
                d dVar = this.renderCallback;
                if (dVar != null) {
                    dVar.onSuccess(b16);
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis2 > 66) {
                    ud0.d.b("PolarImageRender", ud0.d.f438811e, "time out cost time : " + currentTimeMillis2 + " limit time : 66");
                    d dVar2 = this.renderCallback;
                    if (dVar2 != null) {
                        dVar2.onFailed("render time out");
                    }
                    v();
                    m(3);
                }
                long max = Math.max(this.frameTime - currentTimeMillis2, 0L);
                Handler handler = this.renderHandler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                Handler handler2 = this.renderHandler;
                if (handler2 != null) {
                    handler2.postDelayed(new Runnable() { // from class: com.tencent.biz.qui.quipolarlight.render.PolarImageRender$renderImageOnGPU$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            PolarImageRender.this.i();
                        }
                    }, max);
                }
                this.firstFrame += this.offset;
            }
        }
    }

    private final Object l(boolean fromGPU) {
        if (fromGPU) {
            try {
                k();
                return Unit.INSTANCE;
            } catch (Exception e16) {
                ud0.d.b("PolarImageRender", ud0.d.f438811e, "render on GPU failed :" + e16);
                this.renderOnGPU = false;
                j();
                m(1);
                return Unit.INSTANCE;
            }
        }
        j();
        return Unit.INSTANCE;
    }

    private final void m(int result) {
        if (f95214s) {
            return;
        }
        if (this.reportDelegate == null) {
            this.reportDelegate = (i) ud0.c.a(i.class);
        }
        int i3 = c.f95244b[this.renderSize.ordinal()];
        int i16 = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    i16 = 2;
                }
            } else {
                i16 = 1;
            }
        }
        i iVar = this.reportDelegate;
        if (iVar != null) {
            iVar.a("dc00898", "", "0X800C5EC", "0X800C5EC", 0, result, String.valueOf(i16), "", "", "");
        }
        f95214s = true;
    }

    /* renamed from: g, reason: from getter */
    public final float getFirstFrame() {
        return this.firstFrame;
    }

    public final void n(float f16) {
        this.firstFrame = f16;
    }

    public final void o(int i3) {
        this.fps = i3;
        this.frameTime = 1000 / i3;
    }

    public final void p(float f16) {
        this.frequency = f16;
    }

    public final void q(@NotNull com.tencent.biz.qui.quipolarlight.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.gradient = aVar;
    }

    public final void r(float f16) {
        this.offset = f16;
    }

    public final void s(@NotNull List<Integer> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.isEmpty()) {
            return;
        }
        if (value.size() > 10) {
            value = value.subList(0, 9);
        }
        this.renderColors = value;
    }

    public final void t(@NotNull RenderSize value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.renderSize = value;
        int i3 = c.f95243a[value.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.renderWidth = 100;
                    this.renderHeight = 100;
                }
            } else {
                this.renderWidth = 50;
                this.renderHeight = 50;
            }
        } else {
            this.renderWidth = 25;
            this.renderHeight = 25;
        }
        a aVar = this.cpuRender;
        if (aVar != null) {
            aVar.f(new Size(this.renderWidth, this.renderHeight));
        }
        b bVar = this.gpuRender;
        if (bVar != null) {
            bVar.d(new Size(this.renderWidth, this.renderHeight));
        }
    }

    @UiThread
    public final void u(@NotNull d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.renderCallback = callback;
        this.renderStopped = false;
        h();
        Handler handler = this.renderHandler;
        Intrinsics.checkNotNull(handler);
        handler.post(new Runnable() { // from class: com.tencent.biz.qui.quipolarlight.render.PolarImageRender$startAnimation$1
            @Override // java.lang.Runnable
            public final void run() {
                PolarImageRender.this.i();
            }
        });
    }

    @UiThread
    public final void v() {
        Looper looper;
        this.renderStopped = true;
        Handler handler = null;
        this.renderCallback = null;
        Handler handler2 = this.renderHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread = this.renderThread;
        if (handlerThread != null && (looper = handlerThread.getLooper()) != null) {
            handler = new Handler(looper);
        }
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.biz.qui.quipolarlight.render.PolarImageRender$stopAnimation$1
                @Override // java.lang.Runnable
                public final void run() {
                    b bVar;
                    HandlerThread handlerThread2;
                    bVar = PolarImageRender.this.gpuRender;
                    if (bVar != null) {
                        bVar.c();
                    }
                    PolarImageRender.this.gpuRender = null;
                    handlerThread2 = PolarImageRender.this.renderThread;
                    if (handlerThread2 != null) {
                        handlerThread2.quitSafely();
                    }
                    PolarImageRender.this.renderThread = null;
                    PolarImageRender.this.renderHandler = null;
                }
            });
        }
    }
}
