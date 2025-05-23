package g43;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b2\b\u0086\b\u0018\u0000 92\u00020\u0001:\u00014B\u00a7\u0001\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u0012\b\b\u0002\u0010,\u001a\u00020\u0004\u0012\b\b\u0002\u0010.\u001a\u00020\u0004\u0012\b\b\u0002\u00101\u001a\u00020\u0004\u0012\b\b\u0002\u00106\u001a\u00020\b\u00a2\u0006\u0004\b7\u00108J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\rR\u0017\u0010'\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u0010*\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\rR\u0017\u0010,\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000b\u001a\u0004\b+\u0010\rR\u0017\u0010.\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u0017\u00101\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\rR\u0017\u00106\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lg43/d;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "getMaxInterval", "()I", "maxInterval", "e", "getMaxIncrement", "maxIncrement", "f", "g", "timer1StartHour", h.F, "timer1StartMin", "i", "b", "timer1EndHour", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "timer1EndMin", BdhLogUtil.LogTag.Tag_Conn, "timer1Interval", "D", "timer1Increment", "E", "timer1SpanMinute", UserInfo.SEX_FEMALE, "l", "timer2StartHour", "G", "timer2EndHour", "H", "j", "timer2Interval", "k", "timer2RetryTimes", "J", "timer3StartHour", "K", DomainData.DOMAIN_NAME, "timer3StartMin", "L", "Z", "a", "()Z", "configReady", "<init>", "(IIIIIIIIIIIIIIIZ)V", "M", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: g43.d, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class HealthTimerConfigData implements IConfigData {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private final int timer1Interval;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private final int timer1Increment;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private final int timer1SpanMinute;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private final int timer2StartHour;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private final int timer2EndHour;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    private final int timer2Interval;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    private final int timer2RetryTimes;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    private final int timer3StartHour;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    private final int timer3StartMin;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    private final boolean configReady;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxInterval;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxIncrement;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int timer1StartHour;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final int timer1StartMin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int timer1EndHour;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final int timer1EndMin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b$\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0018R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0018R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0018R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0018R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0018R\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0018\u00a8\u0006*"}, d2 = {"Lg43/d$a;", "", "", "content", "Lg43/d;", "a", "", "DEFAULT_END_HOUR_1", "I", "DEFAULT_END_HOUR_2", "DEFAULT_END_MIN_1", "DEFAULT_MAX_INCREMENT", "DEFAULT_MAX_INTERVAL", "DEFAULT_RETRY_TIMES", "DEFAULT_START_HOUR_1", "DEFAULT_START_HOUR_2", "DEFAULT_START_HOUR_3", "DEFAULT_START_MIN_1", "DEFAULT_START_MIN_3", "DEFAULT_TIMER1_INCREMENT", "DEFAULT_TIMER1_INTERVAL", "DEFAULT_TIMER1_SPAN_MINUTE", "DEFAULT_TIMER2_INTERVAL", "KEY_END_HOUR_1", "Ljava/lang/String;", "KEY_END_HOUR_2", "KEY_END_MIN_1", "KEY_MAX_INCREMENT", "KEY_MAX_INTERVAL", "KEY_RETRY_TIMES", "KEY_START_HOUR_1", "KEY_START_HOUR_2", "KEY_START_HOUR_3", "KEY_START_MIN_1", "KEY_START_MIN_3", "KEY_TIMER1_INCREMENT", "KEY_TIMER1_INTERVAL", "KEY_TIMER1_SPAN_MINUTE", "KEY_TIMER2_INTERVAL", "TAG", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g43.d$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final HealthTimerConfigData a(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (QLog.isColorLevel()) {
                QLog.d("HealthTimerConfigData", 2, "parse from:" + content + " ");
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                return new HealthTimerConfigData(jSONObject.optInt("max_interval", 1800000), jSONObject.optInt("max_increment", 300), jSONObject.optInt("timer1_start_hour", 20), jSONObject.optInt("timer1_start_min", 20), jSONObject.optInt("timer1_end_hour", 21), jSONObject.optInt("timer1_end_min", 20), jSONObject.optInt("timer1_interval", 900000), jSONObject.optInt("timer1_increment", 200), jSONObject.optInt("timer1_span_minute", 20), jSONObject.optInt("timer2_start_hour", 23), jSONObject.optInt("timer2_end_hour", 7), jSONObject.optInt("timer2_interval", 600000), jSONObject.optInt("timer2_retry_times", 10), jSONObject.optInt("timer3_start_hour", 5), jSONObject.optInt("timer3_start_min", 20), true);
            } catch (JSONException e16) {
                QLog.e("HealthTimerConfigData", 1, "error parse weather manage content:" + content, e16);
                return new HealthTimerConfigData(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 65535, null);
            }
        }

        Companion() {
        }
    }

    public HealthTimerConfigData() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 65535, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getConfigReady() {
        return this.configReady;
    }

    /* renamed from: b, reason: from getter */
    public final int getTimer1EndHour() {
        return this.timer1EndHour;
    }

    /* renamed from: c, reason: from getter */
    public final int getTimer1EndMin() {
        return this.timer1EndMin;
    }

    /* renamed from: d, reason: from getter */
    public final int getTimer1Increment() {
        return this.timer1Increment;
    }

    /* renamed from: e, reason: from getter */
    public final int getTimer1Interval() {
        return this.timer1Interval;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HealthTimerConfigData)) {
            return false;
        }
        HealthTimerConfigData healthTimerConfigData = (HealthTimerConfigData) other;
        if (this.maxInterval == healthTimerConfigData.maxInterval && this.maxIncrement == healthTimerConfigData.maxIncrement && this.timer1StartHour == healthTimerConfigData.timer1StartHour && this.timer1StartMin == healthTimerConfigData.timer1StartMin && this.timer1EndHour == healthTimerConfigData.timer1EndHour && this.timer1EndMin == healthTimerConfigData.timer1EndMin && this.timer1Interval == healthTimerConfigData.timer1Interval && this.timer1Increment == healthTimerConfigData.timer1Increment && this.timer1SpanMinute == healthTimerConfigData.timer1SpanMinute && this.timer2StartHour == healthTimerConfigData.timer2StartHour && this.timer2EndHour == healthTimerConfigData.timer2EndHour && this.timer2Interval == healthTimerConfigData.timer2Interval && this.timer2RetryTimes == healthTimerConfigData.timer2RetryTimes && this.timer3StartHour == healthTimerConfigData.timer3StartHour && this.timer3StartMin == healthTimerConfigData.timer3StartMin && this.configReady == healthTimerConfigData.configReady) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getTimer1SpanMinute() {
        return this.timer1SpanMinute;
    }

    /* renamed from: g, reason: from getter */
    public final int getTimer1StartHour() {
        return this.timer1StartHour;
    }

    /* renamed from: h, reason: from getter */
    public final int getTimer1StartMin() {
        return this.timer1StartMin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((((((((((((((((((((((((((((this.maxInterval * 31) + this.maxIncrement) * 31) + this.timer1StartHour) * 31) + this.timer1StartMin) * 31) + this.timer1EndHour) * 31) + this.timer1EndMin) * 31) + this.timer1Interval) * 31) + this.timer1Increment) * 31) + this.timer1SpanMinute) * 31) + this.timer2StartHour) * 31) + this.timer2EndHour) * 31) + this.timer2Interval) * 31) + this.timer2RetryTimes) * 31) + this.timer3StartHour) * 31) + this.timer3StartMin) * 31;
        boolean z16 = this.configReady;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    /* renamed from: i, reason: from getter */
    public final int getTimer2EndHour() {
        return this.timer2EndHour;
    }

    /* renamed from: j, reason: from getter */
    public final int getTimer2Interval() {
        return this.timer2Interval;
    }

    /* renamed from: k, reason: from getter */
    public final int getTimer2RetryTimes() {
        return this.timer2RetryTimes;
    }

    /* renamed from: l, reason: from getter */
    public final int getTimer2StartHour() {
        return this.timer2StartHour;
    }

    /* renamed from: m, reason: from getter */
    public final int getTimer3StartHour() {
        return this.timer3StartHour;
    }

    /* renamed from: n, reason: from getter */
    public final int getTimer3StartMin() {
        return this.timer3StartMin;
    }

    @NotNull
    public String toString() {
        return "HealthTimerConfigData(maxInterval=" + this.maxInterval + ", maxIncrement=" + this.maxIncrement + ", timer1StartHour=" + this.timer1StartHour + ", timer1StartMin=" + this.timer1StartMin + ", timer1EndHour=" + this.timer1EndHour + ", timer1EndMin=" + this.timer1EndMin + ", timer1Interval=" + this.timer1Interval + ", timer1Increment=" + this.timer1Increment + ", timer1SpanMinute=" + this.timer1SpanMinute + ", timer2StartHour=" + this.timer2StartHour + ", timer2EndHour=" + this.timer2EndHour + ", timer2Interval=" + this.timer2Interval + ", timer2RetryTimes=" + this.timer2RetryTimes + ", timer3StartHour=" + this.timer3StartHour + ", timer3StartMin=" + this.timer3StartMin + ", configReady=" + this.configReady + ")";
    }

    public HealthTimerConfigData(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, boolean z16) {
        this.maxInterval = i3;
        this.maxIncrement = i16;
        this.timer1StartHour = i17;
        this.timer1StartMin = i18;
        this.timer1EndHour = i19;
        this.timer1EndMin = i26;
        this.timer1Interval = i27;
        this.timer1Increment = i28;
        this.timer1SpanMinute = i29;
        this.timer2StartHour = i36;
        this.timer2EndHour = i37;
        this.timer2Interval = i38;
        this.timer2RetryTimes = i39;
        this.timer3StartHour = i46;
        this.timer3StartMin = i47;
        this.configReady = z16;
    }

    public /* synthetic */ HealthTimerConfigData(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46, int i47, boolean z16, int i48, DefaultConstructorMarker defaultConstructorMarker) {
        this((i48 & 1) != 0 ? 1800000 : i3, (i48 & 2) != 0 ? 300 : i16, (i48 & 4) != 0 ? 20 : i17, (i48 & 8) != 0 ? 20 : i18, (i48 & 16) != 0 ? 21 : i19, (i48 & 32) != 0 ? 20 : i26, (i48 & 64) != 0 ? 900000 : i27, (i48 & 128) != 0 ? 200 : i28, (i48 & 256) != 0 ? 20 : i29, (i48 & 512) != 0 ? 23 : i36, (i48 & 1024) != 0 ? 7 : i37, (i48 & 2048) != 0 ? 600000 : i38, (i48 & 4096) != 0 ? 10 : i39, (i48 & 8192) != 0 ? 5 : i46, (i48 & 16384) != 0 ? 20 : i47, (i48 & 32768) != 0 ? true : z16);
    }
}
