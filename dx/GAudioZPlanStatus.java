package dx;

import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\nB\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bB\t\b\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Ldx/a;", "", "", "b", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "f", "(I)V", "status", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", IProfileProtocolConst.PARAM_TARGET_UIN, "e", h.F, PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: dx.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GAudioZPlanStatus {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String targetUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String timeStamp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Ldx/a$a;", "", "", "statusStr", "Ldx/a;", "a", "", "IN_SMALL_HOME", "I", "OUT_SMALL_HOME", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dx.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final GAudioZPlanStatus a(@Nullable String statusStr) {
            List split$default;
            if (TextUtils.isEmpty(statusStr)) {
                QLog.i("GAudioZPlanStatus", 2, "convertStringToGAudioZPlanStatus statusStr is empty");
                return null;
            }
            Intrinsics.checkNotNull(statusStr);
            split$default = StringsKt__StringsKt.split$default((CharSequence) statusStr, new String[]{"_"}, false, 0, 6, (Object) null);
            if (split$default.size() < 3) {
                QLog.i("GAudioZPlanStatus", 2, "convertStringToGAudioZPlanStatus statusStr size invalid");
                return null;
            }
            GAudioZPlanStatus gAudioZPlanStatus = new GAudioZPlanStatus();
            try {
                gAudioZPlanStatus.f(Integer.parseInt((String) split$default.get(0)));
                gAudioZPlanStatus.g((String) split$default.get(1));
                gAudioZPlanStatus.h((String) split$default.get(2));
                return gAudioZPlanStatus;
            } catch (Exception unused) {
                QLog.e("GAudioZPlanStatus", 2, "convertStringToGAudioZPlanStatus parse exception");
                return null;
            }
        }

        Companion() {
        }
    }

    public GAudioZPlanStatus(int i3, @NotNull String targetUin, @NotNull String timeStamp) {
        Intrinsics.checkNotNullParameter(targetUin, "targetUin");
        Intrinsics.checkNotNullParameter(timeStamp, "timeStamp");
        this.status = i3;
        this.targetUin = targetUin;
        this.timeStamp = timeStamp;
    }

    @JvmStatic
    @Nullable
    public static final GAudioZPlanStatus a(@Nullable String str) {
        return INSTANCE.a(str);
    }

    @NotNull
    public final String b() {
        String str = this.status + "_" + this.targetUin + "_" + this.timeStamp;
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().append(s\u2026end(timeStamp).toString()");
        QLog.i("GAudioZPlanStatus", 2, str);
        return str;
    }

    /* renamed from: c, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTargetUin() {
        return this.targetUin;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTimeStamp() {
        return this.timeStamp;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GAudioZPlanStatus)) {
            return false;
        }
        GAudioZPlanStatus gAudioZPlanStatus = (GAudioZPlanStatus) other;
        if (this.status == gAudioZPlanStatus.status && Intrinsics.areEqual(this.targetUin, gAudioZPlanStatus.targetUin) && Intrinsics.areEqual(this.timeStamp, gAudioZPlanStatus.timeStamp)) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.status = i3;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetUin = str;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeStamp = str;
    }

    public int hashCode() {
        return (((this.status * 31) + this.targetUin.hashCode()) * 31) + this.timeStamp.hashCode();
    }

    @NotNull
    public String toString() {
        return "GAudioZPlanStatus(status=" + this.status + ", targetUin=" + this.targetUin + ", timeStamp=" + this.timeStamp + ")";
    }

    public GAudioZPlanStatus() {
        this(0, "", "");
    }
}
