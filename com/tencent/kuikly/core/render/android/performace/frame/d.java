package com.tencent.kuikly.core.render.android.performace.frame;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import d01.w;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u0016\u0010\u0017\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001e\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/kuikly/core/render/android/performace/frame/d;", "Lcom/tencent/kuikly/core/render/android/performace/b;", "Lcom/tencent/kuikly/core/render/android/performace/frame/c;", "Lcom/tencent/kuikly/core/render/android/performace/frame/a;", "", "u", ReportConstant.COSTREPORT_PREFIX, "t", "v", "", "p", "e", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "r", "", "frameTimeNanos", "doFrame", "", h.f248218g, "f", "Z", "isStarted", tl.h.F, "isResumed", "i", "isInForeground", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "lastFrameTimeNanos", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/kuikly/core/render/android/performace/frame/c;", "frameData", "Lcom/tencent/kuikly/core/render/android/performace/frame/b;", "D", "Lcom/tencent/kuikly/core/render/android/performace/frame/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/kuikly/core/render/android/performace/frame/b;", "driveFrameDetector", "<init>", "()V", "E", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class d extends com.tencent.kuikly.core.render.android.performace.b<c> implements a {

    /* renamed from: C, reason: from kotlin metadata */
    private c frameData = new c(0, 0, 0, 0, 0, 31, null);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b driveFrameDetector = new b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isStarted;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isResumed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isInForeground;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long lastFrameTimeNanos;

    private final void s() {
        if (this.isStarted && this.isResumed) {
            this.isResumed = false;
            this.lastFrameTimeNanos = 0L;
            KRFrameDetector.INSTANCE.b(this);
            return;
        }
        w.f392617a.c("KRFrameMonitor", "pause, isStarted: " + this.isStarted + ", isResumed: " + this.isResumed);
    }

    private final void t() {
        if (this.isStarted && !this.isResumed) {
            this.isResumed = true;
            this.lastFrameTimeNanos = 0L;
            KRFrameDetector.INSTANCE.a(this);
            return;
        }
        w.f392617a.c("KRFrameMonitor", "resume, isStarted: " + this.isStarted + ", isResumed: " + this.isResumed);
    }

    private final void u() {
        w wVar = w.f392617a;
        wVar.c("KRFrameMonitor", "star");
        if (!com.tencent.kuikly.core.render.android.css.ktx.b.l()) {
            wVar.c("KRFrameMonitor", "star, must in main thread.");
            return;
        }
        if (!this.isInForeground) {
            wVar.c("KRFrameMonitor", "activity is not in foreground.");
            return;
        }
        if (this.isStarted) {
            wVar.c("KRFrameMonitor", "has start before.");
            return;
        }
        this.lastFrameTimeNanos = 0L;
        this.isStarted = true;
        this.isResumed = true;
        KRFrameDetector.INSTANCE.a(this);
    }

    private final void v() {
        if (!this.isStarted) {
            w.f392617a.c("KRFrameMonitor", "stop, not start yet.");
            return;
        }
        this.isStarted = false;
        this.isResumed = false;
        this.lastFrameTimeNanos = 0L;
        KRFrameDetector.INSTANCE.b(this);
    }

    @Override // com.tencent.kuikly.core.render.android.performace.frame.a
    public void doFrame(long frameTimeNanos) {
        long j3 = this.lastFrameTimeNanos;
        if (frameTimeNanos >= j3) {
            long j16 = 0;
            if (j3 != 0) {
                long j17 = frameTimeNanos - j3;
                c cVar = this.frameData;
                long j18 = j17 / 1000000;
                cVar.l(cVar.getTotalDuration() + j18);
                if (j17 > 16666667) {
                    j16 = (j17 - 16666667) / 1000000;
                }
                c cVar2 = this.frameData;
                cVar2.k(cVar2.getHitchesDuration() + j16);
                c cVar3 = this.frameData;
                cVar3.j(cVar3.getFrameCount() + 1);
                if (this.driveFrameDetector.k(this.lastFrameTimeNanos, frameTimeNanos)) {
                    c cVar4 = this.frameData;
                    cVar4.h(cVar4.getDriveFrameCount() + 1);
                    c cVar5 = this.frameData;
                    cVar5.i(cVar5.getDriveHitchesDuration() + j16);
                } else {
                    c cVar6 = this.frameData;
                    cVar6.i(cVar6.getDriveHitchesDuration() + j18);
                }
                this.lastFrameTimeNanos = frameTimeNanos;
                return;
            }
        }
        this.lastFrameTimeNanos = frameTimeNanos;
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void e() {
        u();
    }

    @Override // com.tencent.kuikly.core.render.android.performace.frame.a
    public boolean isOpen() {
        if (this.isStarted && this.isResumed) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void onDestroy() {
        v();
        w.f392617a.a("KRFrameMonitor", this.frameData + ", fps: " + this.frameData.c() + ", driveFps: " + this.frameData.f());
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void onPause() {
        this.isInForeground = false;
        s();
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void onResume() {
        this.isInForeground = true;
        t();
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b
    @NotNull
    public String p() {
        return "KRFrameMonitor";
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final b getDriveFrameDetector() {
        return this.driveFrameDetector;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public c getFrameData() {
        return this.frameData;
    }
}
