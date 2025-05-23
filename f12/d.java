package f12;

import android.text.TextUtils;
import android.view.Choreographer;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.performance.report.data.GuildPerformanceInfo;
import com.tencent.mobileqq.guild.performance.report.data.InfoType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0014\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b^\u0010_J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010%\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010$R\u0016\u0010&\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010(R\u0016\u0010+\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010*R\u0016\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010,R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010,R\u0016\u00105\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00104R\u0016\u00107\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00109\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00104R\u0016\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010,R\u0016\u0010<\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010,R\u0016\u0010>\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00104R\u0016\u0010@\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00104R\u0016\u0010B\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00104R\u0014\u0010D\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bC\u0010:R\u0014\u0010F\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bE\u0010:R&\u0010K\u001a\u0012\u0012\u0004\u0012\u00020\u001f0Gj\b\u0012\u0004\u0012\u00020\u001f`H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u00104R\u0016\u0010Q\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u00104R\u0016\u0010S\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u00104R\u0016\u0010U\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u00104R\u0016\u0010W\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u00104R\u0016\u0010Y\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u00104R\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\\u00a8\u0006`"}, d2 = {"Lf12/d;", "Landroid/view/Choreographer$FrameCallback;", "", "scene", "", "o", "p", "", "frameTimeNanos", "Lf12/e;", "data", "d", "frameInterval", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "dropCount", "", tl.h.F, "", WidgetCacheConstellationData.NUM, "mantissa", "g", "", "isReportInfo", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "j", DomainData.DOMAIN_NAME, "f", HippyTKDListViewAdapter.SCROLL_STATE, "i", "Lcom/tencent/mobileqq/guild/performance/report/data/a;", "performanceCallback", "c", "l", "doFrame", "Z", "mInitiated", "mIsStarted", "Landroid/view/Choreographer;", "Landroid/view/Choreographer;", "mChoreographer", "Lf12/e;", "mDropFrameData", "J", "lastRefreshTime", BdhLogUtil.LogTag.Tag_Conn, "mStartDropTimeNanos", "D", "lastFrameTime", "E", "frameCount", UserInfo.SEX_FEMALE, "mFps", "G", "mSmoothRate", "H", "mTotalSmoothRate", "I", "mTotalPredictTimes", "mTotalScrollDurationMs", "K", "sRefreshRate", "L", "sVSyncIntervalNs", "M", "sVsyncIntervalMs", "N", "RANGE_COUNT", "P", "MIN_SCROLL_SCROLL_THRESHOLD", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/HashSet;", "mGuildDropFrameCallbacks", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", ExifInterface.LATITUDE_SOUTH, "DROP_DURATION_0", "T", "DROP_DURATION_1_2", "U", "DROP_DURATION_2_4", "V", "DROP_DURATION_4_8", "W", "DROP_DURATION_8_15", "X", "DROP_DURATION_BIGGER", "", "Y", "[F", "DROP_DURATION_ARRAY", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d implements Choreographer.FrameCallback {

    /* renamed from: C, reason: from kotlin metadata */
    private static long mStartDropTimeNanos;

    /* renamed from: D, reason: from kotlin metadata */
    private static long lastFrameTime;

    /* renamed from: E, reason: from kotlin metadata */
    private static long frameCount;

    /* renamed from: F, reason: from kotlin metadata */
    private static float mFps;

    /* renamed from: G, reason: from kotlin metadata */
    private static float mSmoothRate;

    /* renamed from: H, reason: from kotlin metadata */
    private static float mTotalSmoothRate;

    /* renamed from: I, reason: from kotlin metadata */
    private static long mTotalPredictTimes;

    /* renamed from: J, reason: from kotlin metadata */
    private static long mTotalScrollDurationMs;

    /* renamed from: K, reason: from kotlin metadata */
    private static float sRefreshRate;

    /* renamed from: L, reason: from kotlin metadata */
    private static float sVSyncIntervalNs;

    /* renamed from: M, reason: from kotlin metadata */
    private static float sVsyncIntervalMs;

    /* renamed from: S, reason: from kotlin metadata */
    private static float DROP_DURATION_0;

    /* renamed from: T, reason: from kotlin metadata */
    private static float DROP_DURATION_1_2;

    /* renamed from: U, reason: from kotlin metadata */
    private static float DROP_DURATION_2_4;

    /* renamed from: V, reason: from kotlin metadata */
    private static float DROP_DURATION_4_8;

    /* renamed from: W, reason: from kotlin metadata */
    private static float DROP_DURATION_8_15;

    /* renamed from: X, reason: from kotlin metadata */
    private static float DROP_DURATION_BIGGER;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private static float[] DROP_DURATION_ARRAY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mInitiated;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsStarted;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Choreographer mChoreographer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static GuildDropFrameData mDropFrameData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static long lastRefreshTime;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final d f397604d = new d();

    /* renamed from: N, reason: from kotlin metadata */
    private static final int RANGE_COUNT = 6;

    /* renamed from: P, reason: from kotlin metadata */
    private static final int MIN_SCROLL_SCROLL_THRESHOLD = 100;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private static HashSet<com.tencent.mobileqq.guild.performance.report.data.a> mGuildDropFrameCallbacks = new HashSet<>();

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private static String scene = "default";

    static {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: f12.c
            @Override // java.lang.Runnable
            public final void run() {
                d.b();
            }
        });
        Object systemService = MobileQQ.sMobileQQ.getApplicationContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        float refreshRate = ((WindowManager) systemService).getDefaultDisplay().getRefreshRate();
        sRefreshRate = refreshRate;
        if (refreshRate <= 0.0f) {
            QLog.d("GuildDropFrameCollector", 4, "init failed, device refresh rate: " + refreshRate);
        } else {
            mInitiated = true;
        }
        float f16 = sRefreshRate;
        if (f16 > 0.0f) {
            sVsyncIntervalMs = 1000 / f16;
            sVSyncIntervalNs = 1000000000 / f16;
        }
        float f17 = sVsyncIntervalMs;
        if (f17 > 0.0f) {
            DROP_DURATION_0 = f17;
            DROP_DURATION_1_2 = 1.5f * f17;
            DROP_DURATION_2_4 = 3.0f * f17;
            DROP_DURATION_4_8 = 6.0f * f17;
            DROP_DURATION_8_15 = 11.5f * f17;
            DROP_DURATION_BIGGER = f17 * 15.0f;
        }
        DROP_DURATION_ARRAY = new float[]{DROP_DURATION_0, DROP_DURATION_1_2, DROP_DURATION_2_4, DROP_DURATION_4_8, DROP_DURATION_8_15, DROP_DURATION_BIGGER};
        mDropFrameData = new GuildDropFrameData(6);
    }

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        mChoreographer = Choreographer.getInstance();
    }

    private final void d(long frameTimeNanos, GuildDropFrameData data) {
        if (TextUtils.isEmpty(data.getScene())) {
            return;
        }
        if (data.getFirstFrameTime() == 0) {
            data.h(mStartDropTimeNanos);
            q(mDropFrameData, frameTimeNanos - mStartDropTimeNanos, frameTimeNanos);
        } else {
            q(data, frameTimeNanos - lastFrameTime, frameTimeNanos);
        }
        lastFrameTime = frameTimeNanos;
    }

    private final void e(GuildDropFrameData data) {
        long roundToLong;
        long roundToLong2;
        long[] dropTimes = data.getDropTimes();
        int length = dropTimes.length;
        long j3 = 0;
        int i3 = 0;
        int i16 = 0;
        long j16 = 0;
        while (i3 < length) {
            long j17 = dropTimes[i3];
            roundToLong2 = MathKt__MathJVMKt.roundToLong(((float) j17) * DROP_DURATION_ARRAY[i16]);
            j16 += roundToLong2;
            j3 += j17;
            i3++;
            i16++;
        }
        roundToLong = MathKt__MathJVMKt.roundToLong(((float) j3) * sVsyncIntervalMs);
        data.k(j16);
        mSmoothRate = g((((float) roundToLong) * 100.0f) / ((float) j16), 10);
        long j18 = mTotalPredictTimes + roundToLong;
        mTotalPredictTimes = j18;
        long j19 = mTotalScrollDurationMs + j16;
        mTotalScrollDurationMs = j19;
        mTotalSmoothRate = g((((float) j18) * 100.0f) / ((float) j19), 10);
    }

    private final float g(float num, int mantissa) {
        int roundToInt;
        float f16 = mantissa;
        roundToInt = MathKt__MathJVMKt.roundToInt(num * f16);
        return roundToInt / f16;
    }

    private final int h(long dropCount) {
        if (dropCount <= 0) {
            return 0;
        }
        if (dropCount == 1) {
            return 1;
        }
        if (dropCount <= 4) {
            return 2;
        }
        if (dropCount <= 8) {
            return 3;
        }
        if (dropCount <= 15) {
            return 4;
        }
        return 5;
    }

    private final boolean j() {
        if (!mInitiated || !q.h()) {
            return false;
        }
        o oVar = o.f397685a;
        if (oVar.h() && !oVar.l()) {
            return false;
        }
        return true;
    }

    private final void k(boolean isReportInfo) {
        GuildPerformanceInfo guildPerformanceInfo;
        if (isReportInfo) {
            guildPerformanceInfo = new GuildPerformanceInfo(mFps, sRefreshRate, mSmoothRate, 0.0f, 0.0f, 0.0f, 0.0f, scene, InfoType.DROP_FRAME_INFO, false, false, null, 0.0d, 0.0d, 15992, null);
        } else {
            guildPerformanceInfo = new GuildPerformanceInfo(mFps, mSmoothRate, mTotalSmoothRate, 0.0f, 0.0f, 0.0f, 0.0f, null, null, false, false, null, 0.0d, 0.0d, 16376, null);
        }
        if (isReportInfo) {
            Iterator<T> it = mGuildDropFrameCallbacks.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.performance.report.data.a) it.next()).a(guildPerformanceInfo, isReportInfo);
            }
        }
    }

    private final void m() {
        long millis = TimeUnit.NANOSECONDS.toMillis(mDropFrameData.getFinalFrameTime() - mDropFrameData.getFirstFrameTime());
        if (Intrinsics.areEqual(scene, "aio_msg_list")) {
            if (mDropFrameData.getFrameCount() > 0 && millis > 500) {
                e(mDropFrameData);
                k(true);
            }
        } else if (mDropFrameData.getFrameCount() > 0 && millis > MIN_SCROLL_SCROLL_THRESHOLD) {
            e(mDropFrameData);
            k(true);
        }
        mDropFrameData.f();
        mStartDropTimeNanos = 0L;
    }

    private final void o(String scene2) {
        if (mChoreographer == null) {
            return;
        }
        if (!mIsStarted) {
            n();
        }
        mStartDropTimeNanos = System.nanoTime();
        if (Intrinsics.areEqual(scene, "aio_msg_list")) {
            lastRefreshTime = 0L;
            frameCount = 0L;
        }
        mDropFrameData.j(scene2);
        scene = scene2;
    }

    private final void p() {
        m();
    }

    private final void q(GuildDropFrameData data, long frameInterval, long frameTimeNanos) {
        float f16 = sVSyncIntervalNs;
        int h16 = h((((float) frameInterval) - f16) / f16);
        data.i(data.getFrameCount() + 1);
        long[] dropTimes = data.getDropTimes();
        dropTimes[h16] = dropTimes[h16] + 1;
        data.g(frameTimeNanos);
    }

    public final void c(@NotNull com.tencent.mobileqq.guild.performance.report.data.a performanceCallback) {
        Intrinsics.checkNotNullParameter(performanceCallback, "performanceCallback");
        mGuildDropFrameCallbacks.add(performanceCallback);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        if (!mIsStarted) {
            return;
        }
        d(frameTimeNanos, mDropFrameData);
        if (lastRefreshTime <= 0) {
            lastRefreshTime = frameTimeNanos;
        } else {
            long millis = TimeUnit.NANOSECONDS.toMillis(frameTimeNanos - lastRefreshTime);
            long j3 = frameCount + 1;
            frameCount = j3;
            if (millis > 500) {
                frameCount = 0L;
                mFps = g((((float) j3) * 1000.0f) / ((float) millis), 100);
                lastRefreshTime = frameTimeNanos;
                k(false);
            }
        }
        Choreographer choreographer = mChoreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(this);
        }
    }

    public final void f() {
        mIsStarted = false;
    }

    public final void i(@NotNull String scene2, int scrollState) {
        Intrinsics.checkNotNullParameter(scene2, "scene");
        if (!j()) {
            return;
        }
        if (scrollState != 0) {
            if (scrollState == 1) {
                o(scene2);
                return;
            }
            return;
        }
        p();
    }

    public final boolean l(@NotNull com.tencent.mobileqq.guild.performance.report.data.a performanceCallback) {
        Intrinsics.checkNotNullParameter(performanceCallback, "performanceCallback");
        return mGuildDropFrameCallbacks.remove(performanceCallback);
    }

    public final void n() {
        mIsStarted = true;
        Choreographer choreographer = mChoreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(this);
        }
    }
}
