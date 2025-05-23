package com.tencent.richframework.argus;

import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy;
import com.tencent.biz.richframework.monitor.local.fps.RFWDropFrameCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0006\u0010\u001d\u001a\u00020\fJ\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\f0\u001ej\b\u0012\u0004\u0012\u00020\f`\u001fJ\u0006\u0010!\u001a\u00020\u0004R\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R&\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\f0\u001ej\b\u0012\u0004\u0012\u00020\f`\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010#\u00a8\u0006/"}, d2 = {"Lcom/tencent/richframework/argus/ArgusMonitorProxyImpl;", "Lcom/tencent/biz/richframework/monitor/local/RFWAbsMonitorProxy;", "", "scene", "", "reportToDcTable", "", "frameTimeArray", "", "getCurrentDropFrameCount", "initializeSharePreference", "reportFrameRateInfo", "", "getCurrentFPSVal", "msg", "printDebugLogInfo", "", "pageId", "onParseSceneForPageId", "", "isEnabledPerformanceUI", "isEnabledTracePrint", "isWnsEnabledCollect", "onBeginFPSFrameMonitor", "onEndFPSFrameMonitor", "Lcom/tencent/biz/richframework/monitor/local/fps/RFWDropFrameCollector$DropFrameInfo;", "info", "isReportInfo", "onFrameInfo", "getCurrentSMVal", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCurrentFpsRecord", "clearPerformanceFPSRecord", "mIsInitPerformance", "Z", "mIsEnabledPerformance", "mCurrentFPSVal", UserInfo.SEX_FEMALE, "mCurrentSMVal", "mPreScene", "Ljava/lang/String;", "mFpsList", "Ljava/util/ArrayList;", "isReportCalculateFlow", "<init>", "()V", "argus-monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ArgusMonitorProxyImpl extends RFWAbsMonitorProxy {

    @NotNull
    public static final ArgusMonitorProxyImpl INSTANCE;
    private static boolean isReportCalculateFlow;
    private static float mCurrentFPSVal;
    private static float mCurrentSMVal;
    private static ArrayList<Float> mFpsList;
    private static boolean mIsEnabledPerformance;
    private static boolean mIsInitPerformance;
    private static String mPreScene;

    static {
        ArgusMonitorProxyImpl argusMonitorProxyImpl = new ArgusMonitorProxyImpl();
        INSTANCE = argusMonitorProxyImpl;
        mFpsList = new ArrayList<>();
        argusMonitorProxyImpl.initializeSharePreference();
    }

    ArgusMonitorProxyImpl() {
    }

    private final long getCurrentDropFrameCount(long[] frameTimeArray) {
        boolean z16;
        if (frameTimeArray == null) {
            return 0L;
        }
        if (frameTimeArray.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0L;
        }
        return frameTimeArray[0];
    }

    private final float getCurrentFPSVal() {
        float coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(mCurrentFPSVal, 60);
        return coerceAtMost;
    }

    private final void initializeSharePreference() {
        if (mIsInitPerformance) {
            return;
        }
        mIsEnabledPerformance = true;
        mIsInitPerformance = true;
    }

    private final void printDebugLogInfo(String msg2) {
        if (TextUtils.isEmpty(msg2)) {
            return;
        }
        if (RFWLog.isColorLevel() || RFWApplication.isDebug()) {
            RFWLog.d("FAM-ArgusMonitorProxyImpl", RFWLog.USR, "[printDebugLogInfo] msg: ", msg2);
        }
    }

    private final void reportFrameRateInfo(String scene) {
        if (TextUtils.isEmpty(scene)) {
            return;
        }
        mCurrentSMVal = getCurrentSMVal();
        float currentFPSVal = getCurrentFPSVal();
        mCurrentFPSVal = currentFPSVal;
        if (mCurrentSMVal != 0.0f && currentFPSVal != 0.0f) {
            if (RFWLog.isColorLevel()) {
                RFWLog.d("FAM-ArgusMonitorProxyImpl", RFWLog.USR, "[reportFrameRateInfo] current sm: ", Float.valueOf(mCurrentSMVal), " | fps: ", Float.valueOf(mCurrentFPSVal));
                return;
            }
            return;
        }
        printDebugLogInfo("[reportFrameRateInfo] current sm(" + mCurrentSMVal + ") is zero or pfs(" + mCurrentFPSVal + ")");
    }

    private final void reportToDcTable(String scene) {
        if (!isWnsEnabledCollect()) {
            printDebugLogInfo("[reportToDcTable] current wns enabled collect close.");
        } else {
            reportFrameRateInfo(scene);
        }
    }

    public final void clearPerformanceFPSRecord() {
        mFpsList.clear();
    }

    @NotNull
    public final ArrayList<Float> getCurrentFpsRecord() {
        return mFpsList;
    }

    public final float getCurrentSMVal() {
        float coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(mCurrentSMVal, 100);
        return coerceAtMost;
    }

    @Override // com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy, com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isEnabledPerformanceUI() {
        return false;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isEnabledTracePrint() {
        return false;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public boolean isWnsEnabledCollect() {
        return true;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onBeginFPSFrameMonitor(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        mPreScene = scene;
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onEndFPSFrameMonitor(@NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
    }

    @Override // com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    public void onFrameInfo(@NotNull RFWDropFrameCollector.DropFrameInfo info, boolean isReportInfo) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (TextUtils.isEmpty(mPreScene)) {
            return;
        }
        RFWLog.i("FAM-ArgusMonitorProxyImpl", RFWLog.DEV, "fps:" + info.getFps());
        mCurrentFPSVal = info.getFps();
        mCurrentSMVal = info.getSmoothRate();
        if (info.getFps() > 0.0f && mFpsList.size() <= 500) {
            mFpsList.add(Float.valueOf(info.getFps()));
        }
        if (!isReportInfo) {
            return;
        }
        long currentDropFrameCount = getCurrentDropFrameCount(info.getFrameTimeArray());
        if (currentDropFrameCount == 0) {
            return;
        }
        if (currentDropFrameCount >= 20) {
            reportToDcTable(mPreScene);
            mPreScene = "";
            isReportCalculateFlow = true;
        } else {
            printDebugLogInfo("[onFrameInfo] current check low frame num, report fail.");
            isReportCalculateFlow = false;
        }
    }

    @Override // com.tencent.biz.richframework.monitor.local.RFWAbsMonitorProxy, com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy
    @NotNull
    public String onParseSceneForPageId(int pageId) {
        return String.valueOf(pageId);
    }
}
