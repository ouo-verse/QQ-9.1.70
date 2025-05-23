package g43;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 \u00142\u00020\u0001:\u0001\nB9\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lg43/f;", "Lcom/tencent/freesia/IConfigData;", "", "d", "I", "e", "()I", StepCounterConstants.ATTR_STEP_COUNTER_MODE, StepCounterConstants.ATTR_STEP_CADENCE, "f", "a", StepCounterConstants.ATTR_ACTIVE_REPORT_INTERVAL, h.F, "c", StepCounterConstants.ATTR_PASSIVE_REPORT_INTERVAL, "i", "b", StepCounterConstants.ATTR_MAX_RECORD_DAYS, "<init>", "(IIIII)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f implements IConfigData {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int stepCounterMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int stepCadence;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int activeReportInterval;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int passiveReportInterval;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int maxRecordDays;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lg43/f$a;", "", "", "content", "Lg43/f;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g43.f$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final f a(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (QLog.isColorLevel()) {
                QLog.d("StepConfigData", 2, "parse from:" + content + " ");
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                return new f(jSONObject.getInt(StepCounterConstants.ATTR_STEP_COUNTER_MODE), jSONObject.getInt(StepCounterConstants.ATTR_STEP_CADENCE), jSONObject.getInt(StepCounterConstants.ATTR_ACTIVE_REPORT_INTERVAL), jSONObject.getInt(StepCounterConstants.ATTR_PASSIVE_REPORT_INTERVAL), jSONObject.getInt(StepCounterConstants.ATTR_MAX_RECORD_DAYS));
            } catch (JSONException e16) {
                QLog.e("StepConfigData", 1, "error parse weather manage content:" + content, e16);
                return new f(0, 0, 0, 0, 0, 31, null);
            }
        }

        Companion() {
        }
    }

    public f() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getActiveReportInterval() {
        return this.activeReportInterval;
    }

    /* renamed from: b, reason: from getter */
    public final int getMaxRecordDays() {
        return this.maxRecordDays;
    }

    /* renamed from: c, reason: from getter */
    public final int getPassiveReportInterval() {
        return this.passiveReportInterval;
    }

    /* renamed from: d, reason: from getter */
    public final int getStepCadence() {
        return this.stepCadence;
    }

    /* renamed from: e, reason: from getter */
    public final int getStepCounterMode() {
        return this.stepCounterMode;
    }

    public f(int i3, int i16, int i17, int i18, int i19) {
        this.stepCounterMode = i3;
        this.stepCadence = i16;
        this.activeReportInterval = i17;
        this.passiveReportInterval = i18;
        this.maxRecordDays = i19;
    }

    public /* synthetic */ f(int i3, int i16, int i17, int i18, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? 2 : i3, (i26 & 2) != 0 ? 300 : i16, (i26 & 4) != 0 ? 600 : i17, (i26 & 8) != 0 ? 1200 : i18, (i26 & 16) != 0 ? 7 : i19);
    }
}
