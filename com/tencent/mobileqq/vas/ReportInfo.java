package com.tencent.mobileqq.vas;

import android.os.Build;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasUtilProxy;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.utils.VasCommonUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J,\u0010\u0016\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J,\u0010\u001a\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0012\u0010\u001b\u001a\u00020\u00142\b\b\u0002\u0010\u001c\u001a\u00020\nH\u0007J\u0012\u0010\u001d\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\u0003H\u0007J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010#\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u0010\u0010$\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u0010\u0010%\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u0010\u0010&\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u0010\u0010'\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\b\u0010(\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/vas/VasCommonReportProxy;", "", AdMetricTag.EVENT_NAME, "", "(Ljava/lang/String;)V", "num1", "", "num2", "num3", "useNewEventCode", "", "value1", "value2", "value3", "value4", "value5", "getReportMap", "", "isNeedInterceptEventName", "printLog", "", "logString", "recordNum", "records", "key", "value", "recordString", "report", "isSample", "reportEveryDay", "flag", "setNum1", "setNum2", "setNum3", "setUseNewEventCode", "setValue1", "setValue2", "setValue3", "setValue4", "setValue5", "toString", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.tencent.mobileqq.vas.VasCommonReportProxy, reason: from toString */
/* loaded from: classes20.dex */
public final class ReportInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long INVALID_NUM = -1;

    @NotNull
    private static final String INVALID_STRING = "";

    @NotNull
    private static final String TAG = "VasCommonReporter";
    private static final boolean isHit;

    @NotNull
    private final String eventName;
    private long num1;
    private long num2;
    private long num3;
    private boolean useNewEventCode;

    @NotNull
    private String value1;

    @NotNull
    private String value2;

    @NotNull
    private String value3;

    @NotNull
    private String value4;

    @NotNull
    private String value5;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/VasCommonReportProxy$Companion;", "", "()V", "INVALID_NUM", "", "INVALID_STRING", "", "TAG", "isHit", "", "()Z", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.vas.VasCommonReportProxy$Companion, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isHit() {
            return ReportInfo.isHit;
        }

        Companion() {
        }
    }

    static {
        int roundToInt;
        boolean z16;
        roundToInt = MathKt__MathJVMKt.roundToInt(Math.floor(1000 * Math.random()));
        if (roundToInt == 500) {
            z16 = true;
        } else {
            z16 = false;
        }
        isHit = z16;
        try {
            if (VasCommonUtils.INSTANCE.isMainProcess()) {
                int i3 = Calendar.getInstance().get(5);
                VasMMKVProxy reportControl = VipNtMMKV.INSTANCE.getReportControl();
                if (reportControl.decodeInt("last_clear_day", -1) != i3) {
                    reportControl.removeKeyList(reportControl.allKey());
                    reportControl.encodeInt("last_clear_day", i3);
                }
            }
        } catch (NoClassDefFoundError e16) {
            QLog.i(TAG, 1, "error : " + e16);
        }
    }

    public ReportInfo(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        this.value1 = "";
        this.value2 = "";
        this.value3 = "";
        this.value4 = "";
        this.value5 = "";
        this.num1 = -1L;
        this.num2 = -1L;
        this.num3 = -1L;
        this.useNewEventCode = true;
    }

    private final Map<String, String> getReportMap() {
        long j3;
        HashMap hashMap = new HashMap();
        recordString(hashMap, AdMetricTag.EVENT_NAME, this.eventName);
        recordString(hashMap, "value1", this.value1);
        recordString(hashMap, "value2", this.value2);
        recordString(hashMap, "value3", this.value3);
        recordString(hashMap, "value4", this.value4);
        recordString(hashMap, "value5", this.value5);
        recordNum(hashMap, "num1", this.num1);
        recordNum(hashMap, "num2", this.num2);
        recordNum(hashMap, "num3", this.num3);
        if (this.useNewEventCode) {
            j3 = 1;
        } else {
            j3 = 0;
        }
        recordNum(hashMap, "useNewEventCode", j3);
        return hashMap;
    }

    private final boolean isNeedInterceptEventName() {
        List split$default;
        UnitedProxy unitedProxy = VasNtToggle.VAS_REPORT_EVENT_NAME_BLACK_LIST;
        if (unitedProxy.isEnable(true)) {
            try {
                split$default = StringsKt__StringsKt.split$default((CharSequence) unitedProxy.getStringData("theme_switch"), new String[]{","}, false, 0, 6, (Object) null);
            } catch (Exception e16) {
                QLog.i(TAG, 1, "isNeedInterceptEventName e:" + e16);
            }
            if (split$default.contains(this.eventName)) {
                return true;
            }
            return false;
        }
        return false;
    }

    private final void printLog(String logString) {
        QLog.i(this.eventName, 1, logString);
    }

    private final void recordNum(Map<String, String> records, String key, long value) {
        if (value == -1) {
            return;
        }
        records.put(key, String.valueOf(value));
    }

    private final void recordString(Map<String, String> records, String key, String value) {
        if (Intrinsics.areEqual(value, "")) {
            return;
        }
        records.put(key, value);
    }

    public static /* synthetic */ void report$default(ReportInfo reportInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = com.tencent.qqnt.util.b.f362976b.isPublicVersion();
        }
        reportInfo.report(z16);
    }

    public static /* synthetic */ void reportEveryDay$default(ReportInfo reportInfo, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = reportInfo.value1;
        }
        reportInfo.reportEveryDay(str);
    }

    @JvmOverloads
    public final void report() {
        report$default(this, false, 1, null);
    }

    @JvmOverloads
    public final void reportEveryDay() {
        reportEveryDay$default(this, null, 1, null);
    }

    @NotNull
    public final ReportInfo setNum1(long value) {
        this.num1 = value;
        return this;
    }

    @NotNull
    public final ReportInfo setNum2(long value) {
        this.num2 = value;
        return this;
    }

    @NotNull
    public final ReportInfo setNum3(long value) {
        this.num3 = value;
        return this;
    }

    public final void setUseNewEventCode(boolean useNewEventCode) {
        this.useNewEventCode = useNewEventCode;
    }

    @NotNull
    public final ReportInfo setValue1(@Nullable String value) {
        if (value != null) {
            this.value1 = value;
        }
        return this;
    }

    @NotNull
    public final ReportInfo setValue2(@Nullable String value) {
        if (value != null) {
            this.value2 = value;
        }
        return this;
    }

    @NotNull
    public final ReportInfo setValue3(@Nullable String value) {
        if (value != null) {
            this.value3 = value;
        }
        return this;
    }

    @NotNull
    public final ReportInfo setValue4(@Nullable String value) {
        if (value != null) {
            this.value4 = value;
        }
        return this;
    }

    @NotNull
    public final ReportInfo setValue5(@Nullable String value) {
        if (value != null) {
            this.value5 = value;
        }
        return this;
    }

    @NotNull
    public String toString() {
        return "ReportInfo(eventName='" + this.eventName + "', value1='" + this.value1 + "', value2='" + this.value2 + "', value3='" + this.value3 + "', value4='" + this.value4 + "', value5='" + this.value5 + "', num1=" + this.num1 + ", num2=" + this.num2 + ", num3=" + this.num3 + ")";
    }

    @JvmOverloads
    public final void report(boolean isSample) {
        if (isNeedInterceptEventName()) {
            return;
        }
        if (Build.VERSION.SDK_INT > 25) {
            printLog(toString());
        }
        if (!isSample || isHit) {
            ((IVasUtilProxy) QRoute.api(IVasUtilProxy.class)).reportCommonReal(getReportMap());
        }
    }

    @JvmOverloads
    public final void reportEveryDay(@NotNull String flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        if (isNeedInterceptEventName()) {
            return;
        }
        printLog(toString());
        VasMMKVProxy reportControl = VipNtMMKV.INSTANCE.getReportControl();
        String str = this.eventName + flag;
        if (reportControl.decodeBool(str, false)) {
            return;
        }
        reportControl.encodeBool(str, true);
        ((IVasUtilProxy) QRoute.api(IVasUtilProxy.class)).reportCommonReal(getReportMap());
    }
}
