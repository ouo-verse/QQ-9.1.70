package com.tencent.mobileqq.vas.api;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0002\f\rJ8\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/api/INtVasTabFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "owner", "time", "testName", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/vas/api/INtVasTabFactory$NtABTest;", "", "getResultAndExposure", "Lcom/tencent/mobileqq/vas/api/INtVasTabFactory$a;", "buildABTest", "NtABTest", "a", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface INtVasTabFactory extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/api/INtVasTabFactory$NtABTest;", "", "isContrast", "", "isExperiment", "(Ljava/lang/String;IZZ)V", "()Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "MISS", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public enum NtABTest {
        A(true, false),
        B(false, true),
        C(false, true),
        D(false, true),
        E(false, true),
        F(false, true),
        G(false, true),
        H(false, true),
        MISS(false, false);

        private final boolean isContrast;
        private final boolean isExperiment;

        NtABTest(boolean z16, boolean z17) {
            this.isContrast = z16;
            this.isExperiment = z17;
        }

        /* renamed from: isContrast, reason: from getter */
        public final boolean getIsContrast() {
            return this.isContrast;
        }

        /* renamed from: isExperiment, reason: from getter */
        public final boolean getIsExperiment() {
            return this.isExperiment;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/vas/api/INtVasTabFactory$a;", "", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
    }

    @NotNull
    a buildABTest(@NotNull String owner, @NotNull String time, @NotNull String testName);

    @NotNull
    Pair<NtABTest, Map<String, String>> getResultAndExposure(@NotNull String owner, @NotNull String time, @NotNull String testName);
}
