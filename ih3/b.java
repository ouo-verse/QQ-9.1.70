package ih3;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lih3/b;", "", "", "eventId", "", "params", "", "b", "Lih3/b$a;", DownloadInfo.spKey_Config, "d", "<init>", "()V", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f407666a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\r\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lih3/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "hasCreatedRole", "b", "I", "c", "()I", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "Ljava/lang/String;", "()Ljava/lang/String;", "reportActionType", "<init>", "(ZILjava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ih3.b$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class GrayTipsReportConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean hasCreatedRole;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int sessionType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String reportActionType;

        public GrayTipsReportConfig(boolean z16, int i3, @NotNull String reportActionType) {
            Intrinsics.checkNotNullParameter(reportActionType, "reportActionType");
            this.hasCreatedRole = z16;
            this.sessionType = i3;
            this.reportActionType = reportActionType;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getHasCreatedRole() {
            return this.hasCreatedRole;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getReportActionType() {
            return this.reportActionType;
        }

        /* renamed from: c, reason: from getter */
        public final int getSessionType() {
            return this.sessionType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GrayTipsReportConfig)) {
                return false;
            }
            GrayTipsReportConfig grayTipsReportConfig = (GrayTipsReportConfig) other;
            if (this.hasCreatedRole == grayTipsReportConfig.hasCreatedRole && this.sessionType == grayTipsReportConfig.sessionType && Intrinsics.areEqual(this.reportActionType, grayTipsReportConfig.reportActionType)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.hasCreatedRole;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.sessionType) * 31) + this.reportActionType.hashCode();
        }

        @NotNull
        public String toString() {
            return "GrayTipsReportConfig(hasCreatedRole=" + this.hasCreatedRole + ", sessionType=" + this.sessionType + ", reportActionType=" + this.reportActionType + ')';
        }
    }

    b() {
    }

    private final void b(final String eventId, final Map<String, ? extends Object> params) {
        ThreadManagerV2.excute(new Runnable() { // from class: ih3.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c(eventId, params);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String eventId, Map params) {
        Intrinsics.checkNotNullParameter(eventId, "$eventId");
        Intrinsics.checkNotNullParameter(params, "$params");
        VideoReport.reportEvent(eventId, params);
        if (QLog.isColorLevel()) {
            QLog.i("ZPlanEmoticonDtReporter", 2, "report " + eventId + " -> " + params);
        }
    }

    public final void d(@NotNull GrayTipsReportConfig config) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(config, "config");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_is_create_avatar", Integer.valueOf(config.getHasCreatedRole() ? 1 : 0)), TuplesKt.to("zplan_c2c_or_group", Integer.valueOf(config.getSessionType())), TuplesKt.to("zplan_action_type", config.getReportActionType()));
        b("ev_zplan_emote_graytab_action", hashMapOf);
    }
}
