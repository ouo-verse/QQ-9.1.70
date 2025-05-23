package com.tencent.mobileqq.minigame.report;

import android.text.TextUtils;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.app.cf;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import cooperation.qzone.QUA;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\"#B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fH\u0002J \u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u000bH\u0007\u00a2\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u000bH\u0007J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\n\n\u0002\u0010\r\u0012\u0004\b\f\u0010\u0002\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGameCrashReporter;", "", "()V", "BEACON_EVENT_CODE_CRASH", "", "DEBUG_REPORT", "", "TAG", "currentMiniGameAppId", "getCurrentMiniGameAppId$annotations", "currentMiniGameState", "", "getCurrentMiniGameState$annotations", "Ljava/lang/Integer;", "buildCrashReportInfo", "", "crashInfo", "Lcom/tencent/mobileqq/minigame/report/MiniGameCrashReporter$CrashInfo;", "dumpReportParams", "", "params", "findFirstLibFromStack", "crashStack", "libNames", "", "getCurrentMiniGameAppId", "getCurrentMiniGameState", "()Ljava/lang/Integer;", "getQQVersionType", "getStackFirstLine", "onAppStateChange", "appId", "state", "reportCrash", "BeaconKey", "CrashInfo", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameCrashReporter {
    private static final String BEACON_EVENT_CODE_CRASH = "mini_game_crash_android";
    private static final String TAG = "MiniSdk-MiniGameCrashReporter";
    private static String currentMiniGameAppId;
    private static Integer currentMiniGameState;
    public static final MiniGameCrashReporter INSTANCE = new MiniGameCrashReporter();
    private static final boolean DEBUG_REPORT = false;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGameCrashReporter$BeaconKey;", "", "()V", "CRASH_ADDRESS", "", "CRASH_IS_NATIVE", "CRASH_SIGNAL", "CRASH_TIME", "CRASH_TYPE", "FIRST_ENGINE_LIB", "PROC_NAME", "QUA", "STACK_FIRST_LINE", "TOP_ACTIVITY", "UID", "VERSION_TYPE", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class BeaconKey {
        public static final String CRASH_ADDRESS = "crash_address";
        public static final String CRASH_IS_NATIVE = "crash_is_native";
        public static final String CRASH_SIGNAL = "crash_signal";
        public static final String CRASH_TIME = "crash_time";
        public static final String CRASH_TYPE = "crash_type";
        public static final String FIRST_ENGINE_LIB = "first_engine_lib";
        public static final BeaconKey INSTANCE = new BeaconKey();
        public static final String PROC_NAME = "proc_name";
        public static final String QUA = "qua";
        public static final String STACK_FIRST_LINE = "stack_first_line";
        public static final String TOP_ACTIVITY = "top_activity";
        public static final String UID = "uid";
        public static final String VERSION_TYPE = "version_type";

        BeaconKey() {
        }
    }

    MiniGameCrashReporter() {
    }

    private final Map<String, String> buildCrashReportInfo(CrashInfo crashInfo) {
        String str;
        CrashRtInfoHolder crashRtInfoHolder;
        HashMap hashMap = new HashMap();
        hashMap.put("uid", crashInfo.getUin());
        String qua3 = QUA.getQUA3();
        Intrinsics.checkNotNullExpressionValue(qua3, "getQUA3()");
        hashMap.put("qua", qua3);
        hashMap.put("version_type", getQQVersionType());
        hashMap.put(BeaconKey.PROC_NAME, crashInfo.getProcName());
        String a16 = cf.a();
        Intrinsics.checkNotNullExpressionValue(a16, "getTopActivityName()");
        hashMap.put(BeaconKey.TOP_ACTIVITY, a16);
        if (crashInfo.isNativeCrashed()) {
            str = "1";
        } else {
            str = "-1";
        }
        hashMap.put(BeaconKey.CRASH_IS_NATIVE, str);
        String crashType = crashInfo.getCrashType();
        if (crashType == null) {
            crashType = "";
        }
        hashMap.put("crash_type", crashType);
        String crashAddress = crashInfo.getCrashAddress();
        hashMap.put(BeaconKey.CRASH_ADDRESS, crashAddress != null ? crashAddress : "");
        hashMap.put(BeaconKey.CRASH_SIGNAL, String.valueOf(crashInfo.getNativeSignal()));
        hashMap.put("crash_time", String.valueOf(crashInfo.getCrashTime()));
        hashMap.put(BeaconKey.STACK_FIRST_LINE, getStackFirstLine(crashInfo.getCrashStack()));
        ICommonManager commonManager = AppLoaderFactory.g().getCommonManager();
        if (commonManager != null && (crashRtInfoHolder = commonManager.getCrashRtInfoHolder()) != null) {
            hashMap.putAll(crashRtInfoHolder.buildReportParams());
            if (crashInfo.isNativeCrashed()) {
                hashMap.put(BeaconKey.FIRST_ENGINE_LIB, INSTANCE.findFirstLibFromStack(crashInfo.getCrashStack(), crashRtInfoHolder.getRuntimeNativeLibs()));
            }
        }
        dumpReportParams(hashMap);
        return hashMap;
    }

    private final void dumpReportParams(Map<String, String> params) {
        if (DEBUG_REPORT) {
            StringBuilder sb5 = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(" = ");
                sb5.append(entry.getValue());
                sb5.append("\n");
            }
            QLog.d(TAG, 2, "buildCrashReportInfo: params --->\n" + ((Object) sb5));
        }
    }

    @JvmStatic
    public static final String getCurrentMiniGameAppId() {
        return currentMiniGameAppId;
    }

    @JvmStatic
    public static final Integer getCurrentMiniGameState() {
        return currentMiniGameState;
    }

    private final String getQQVersionType() {
        return "public";
    }

    @JvmStatic
    public static final void onAppStateChange(String appId, int state) {
        currentMiniGameAppId = appId;
        currentMiniGameState = Integer.valueOf(state);
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        CrashReport.putUserData(BaseApplication.getContext(), "miniGameAppId", appId);
        CrashReport.putUserData(BaseApplication.getContext(), "tritonSDKVersion", "3.0.0.486.6d09724f2");
        CrashReport.putUserData(BaseApplication.getContext(), "miniGameState", String.valueOf(state));
    }

    @JvmStatic
    public static final void reportCrash(CrashInfo crashInfo) {
        Intrinsics.checkNotNullParameter(crashInfo, "crashInfo");
        QLog.d(TAG, 1, "reportCrash for mini game");
        MiniGameBeaconReport.report(BEACON_EVENT_CODE_CRASH, INSTANCE.buildCrashReportInfo(crashInfo), true, true);
    }

    private final String getStackFirstLine(String crashStack) {
        String substringBefore$default;
        if (!(crashStack == null || crashStack.length() == 0)) {
            substringBefore$default = StringsKt__StringsKt.substringBefore$default(crashStack, '\n', (String) null, 2, (Object) null);
            return substringBefore$default;
        }
        return "";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\rH\u00c6\u0003J_\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020\rH\u00d6\u0001J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0015R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/MiniGameCrashReporter$CrashInfo;", "", "uin", "", "procName", "crashTime", "", "isNativeCrashed", "", "crashType", "crashAddress", "crashStack", "nativeSignal", "", "(Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getCrashAddress", "()Ljava/lang/String;", "getCrashStack", "getCrashTime", "()J", "getCrashType", "()Z", "getNativeSignal", "()I", "getProcName", "getUin", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class CrashInfo {
        private final String crashAddress;
        private final String crashStack;
        private final long crashTime;
        private final String crashType;
        private final boolean isNativeCrashed;
        private final int nativeSignal;
        private final String procName;
        private final String uin;

        public CrashInfo(String uin, String procName, long j3, boolean z16, String str, String str2, String str3, int i3) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(procName, "procName");
            this.uin = uin;
            this.procName = procName;
            this.crashTime = j3;
            this.isNativeCrashed = z16;
            this.crashType = str;
            this.crashAddress = str2;
            this.crashStack = str3;
            this.nativeSignal = i3;
        }

        /* renamed from: component1, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        /* renamed from: component2, reason: from getter */
        public final String getProcName() {
            return this.procName;
        }

        /* renamed from: component3, reason: from getter */
        public final long getCrashTime() {
            return this.crashTime;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsNativeCrashed() {
            return this.isNativeCrashed;
        }

        /* renamed from: component5, reason: from getter */
        public final String getCrashType() {
            return this.crashType;
        }

        /* renamed from: component6, reason: from getter */
        public final String getCrashAddress() {
            return this.crashAddress;
        }

        /* renamed from: component7, reason: from getter */
        public final String getCrashStack() {
            return this.crashStack;
        }

        /* renamed from: component8, reason: from getter */
        public final int getNativeSignal() {
            return this.nativeSignal;
        }

        public final CrashInfo copy(String uin, String procName, long crashTime, boolean isNativeCrashed, String crashType, String crashAddress, String crashStack, int nativeSignal) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(procName, "procName");
            return new CrashInfo(uin, procName, crashTime, isNativeCrashed, crashType, crashAddress, crashStack, nativeSignal);
        }

        public final String getCrashAddress() {
            return this.crashAddress;
        }

        public final String getCrashStack() {
            return this.crashStack;
        }

        public final long getCrashTime() {
            return this.crashTime;
        }

        public final String getCrashType() {
            return this.crashType;
        }

        public final int getNativeSignal() {
            return this.nativeSignal;
        }

        public final String getProcName() {
            return this.procName;
        }

        public final String getUin() {
            return this.uin;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.uin.hashCode() * 31) + this.procName.hashCode()) * 31) + com.tencent.mobileqq.mini.appbrand.utils.f.a(this.crashTime)) * 31;
            boolean z16 = this.isNativeCrashed;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode + i3) * 31;
            String str = this.crashType;
            int hashCode2 = (i16 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.crashAddress;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.crashStack;
            return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.nativeSignal;
        }

        public final boolean isNativeCrashed() {
            return this.isNativeCrashed;
        }

        public String toString() {
            return "CrashInfo(uin=" + this.uin + ", procName=" + this.procName + ", crashTime=" + this.crashTime + ", isNativeCrashed=" + this.isNativeCrashed + ", crashType=" + this.crashType + ", crashAddress=" + this.crashAddress + ", crashStack=" + this.crashStack + ", nativeSignal=" + this.nativeSignal + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CrashInfo)) {
                return false;
            }
            CrashInfo crashInfo = (CrashInfo) other;
            return Intrinsics.areEqual(this.uin, crashInfo.uin) && Intrinsics.areEqual(this.procName, crashInfo.procName) && this.crashTime == crashInfo.crashTime && this.isNativeCrashed == crashInfo.isNativeCrashed && Intrinsics.areEqual(this.crashType, crashInfo.crashType) && Intrinsics.areEqual(this.crashAddress, crashInfo.crashAddress) && Intrinsics.areEqual(this.crashStack, crashInfo.crashStack) && this.nativeSignal == crashInfo.nativeSignal;
        }

        public /* synthetic */ CrashInfo(String str, String str2, long j3, boolean z16, String str3, String str4, String str5, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, j3, z16, (i16 & 16) != 0 ? null : str3, (i16 & 32) != 0 ? null : str4, (i16 & 64) != 0 ? null : str5, (i16 & 128) != 0 ? 0 : i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String findFirstLibFromStack(String crashStack, List<String> libNames) {
        int indexOf$default;
        String str = "";
        if (crashStack == 0 || crashStack.length() == 0) {
            return "";
        }
        for (String str2 : libNames) {
            indexOf$default = StringsKt__StringsKt.indexOf$default(crashStack, str2, 0, false, 6, (Object) null);
            if (indexOf$default >= 0) {
                crashStack = crashStack.subSequence(0, indexOf$default);
                str = str2;
            }
        }
        return str;
    }

    @JvmStatic
    private static /* synthetic */ void getCurrentMiniGameAppId$annotations() {
    }

    @JvmStatic
    private static /* synthetic */ void getCurrentMiniGameState$annotations() {
    }
}
