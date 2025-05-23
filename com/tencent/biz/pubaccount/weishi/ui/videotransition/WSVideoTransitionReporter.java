package com.tencent.biz.pubaccount.weishi.ui.videotransition;

import android.view.Choreographer;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionReporter$frameCallback$2;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\b\b*\u0001\u001e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001b\u0010\u001d\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSVideoTransitionReporter;", "", "", "isEnter", "", DomainData.DOMAIN_NAME, "Lcom/tencent/biz/pubaccount/weishi/report/WSStatisticsReporter$Builder;", "kotlin.jvm.PlatformType", "j", "o", "p", "k", "b", "Z", "isMonitorRunning", "", "c", "J", "lastFrameTimeNanos", "", "d", "I", "normalFrameCnt", "e", "skipFrameCnt", "f", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "refreshRate", "com/tencent/biz/pubaccount/weishi/ui/videotransition/WSVideoTransitionReporter$frameCallback$2$a", "g", "l", "()Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSVideoTransitionReporter$frameCallback$2$a;", "frameCallback", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSVideoTransitionReporter {

    /* renamed from: a, reason: collision with root package name */
    public static final WSVideoTransitionReporter f81655a = new WSVideoTransitionReporter();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isMonitorRunning;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastFrameTimeNanos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int normalFrameCnt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int skipFrameCnt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Lazy refreshRate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Lazy frameCallback;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionReporter$refreshRate$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Object systemService = BaseApplication.getContext().getSystemService("window");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                return Integer.valueOf((int) ((WindowManager) systemService).getDefaultDisplay().getRefreshRate());
            }
        });
        refreshRate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WSVideoTransitionReporter$frameCallback$2.a>() { // from class: com.tencent.biz.pubaccount.weishi.ui.videotransition.WSVideoTransitionReporter$frameCallback$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\u000b\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/pubaccount/weishi/ui/videotransition/WSVideoTransitionReporter$frameCallback$2$a", "Landroid/view/Choreographer$FrameCallback;", "", "frameTimeNanos", "", "doFrame", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes32.dex */
            public static final class a implements Choreographer.FrameCallback {
                a() {
                }

                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long frameTimeNanos) {
                    int i3;
                    long j3;
                    boolean z16;
                    long j16;
                    int m3;
                    int i16;
                    i3 = WSVideoTransitionReporter.normalFrameCnt;
                    WSVideoTransitionReporter.normalFrameCnt = i3 + 1;
                    j3 = WSVideoTransitionReporter.lastFrameTimeNanos;
                    if (j3 != 0) {
                        j16 = WSVideoTransitionReporter.lastFrameTimeNanos;
                        long j17 = 1000;
                        long j18 = ((frameTimeNanos - j16) / j17) / j17;
                        m3 = WSVideoTransitionReporter.f81655a.m();
                        int i17 = ((int) (((float) j18) / (1000.0f / m3))) - 1;
                        if (i17 > 0) {
                            i16 = WSVideoTransitionReporter.skipFrameCnt;
                            WSVideoTransitionReporter.skipFrameCnt = i16 + i17;
                        }
                    }
                    WSVideoTransitionReporter.lastFrameTimeNanos = frameTimeNanos;
                    z16 = WSVideoTransitionReporter.isMonitorRunning;
                    if (!z16) {
                        WSVideoTransitionReporter.f81655a.o();
                    } else {
                        Choreographer.getInstance().postFrameCallback(this);
                    }
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
        frameCallback = lazy2;
    }

    WSVideoTransitionReporter() {
    }

    private final WSStatisticsReporter.Builder j() {
        return new WSStatisticsReporter.Builder().setSendWeSeeServer(false).setFlush(true);
    }

    private final WSVideoTransitionReporter$frameCallback$2.a l() {
        return (WSVideoTransitionReporter$frameCallback$2.a) frameCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m() {
        return ((Number) refreshRate.getValue()).intValue();
    }

    private final void n(boolean isEnter) {
        String str;
        HashMap hashMapOf;
        int i3 = skipFrameCnt;
        int i16 = normalFrameCnt + i3;
        float f16 = i16 == 0 ? 0.0f : i3 / i16;
        Pair[] pairArr = new Pair[4];
        if (isEnter) {
            str = "1";
        } else {
            str = "2";
        }
        pairArr[0] = TuplesKt.to("type", str);
        pairArr[1] = TuplesKt.to("totalFrame", String.valueOf(i16));
        pairArr[2] = TuplesKt.to("skipFrame", String.valueOf(skipFrameCnt));
        pairArr[3] = TuplesKt.to("refreshRate", String.valueOf(m()));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        j().addParams(hashMapOf).build("actWsGzhTransitionAnim").report();
        x.b("WSVideoTransitionReporter", "totalFrameCnt = " + normalFrameCnt + ", skipFrameCnt = " + skipFrameCnt + ", refreshRate = " + m() + ", \u6389\u5e27\u7387\uff1a" + f16);
    }

    public final void k(boolean isEnter) {
        x.b("WSVideoTransitionReporter", "endMonitor() isEnter = " + isEnter);
        Choreographer.getInstance().removeFrameCallback(l());
        n(isEnter);
        o();
    }

    public final void p(boolean isEnter) {
        x.b("WSVideoTransitionReporter", "startMonitor() isEnter = " + isEnter);
        isMonitorRunning = true;
        Choreographer.getInstance().postFrameCallback(l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        lastFrameTimeNanos = 0L;
        normalFrameCnt = 0;
        skipFrameCnt = 0;
        isMonitorRunning = false;
    }
}
