package com.tencent.mobileqq.vas;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u000f\fB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJB\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u0007J*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/VasTabFactory;", "", "", "owner", "time", "testName", "appId", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/vas/VasTabFactory$ABTest;", "", "d", "Lcom/tencent/mobileqq/vas/VasTabFactory$a;", "a", "<init>", "()V", "ABTest", "vas-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasTabFactory {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final VasTabFactory f307875a = new VasTabFactory();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/VasTabFactory$ABTest;", "", "isContrast", "", "isExperiment", "(Ljava/lang/String;IZZ)V", "()Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "MISS", "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public enum ABTest {
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

        ABTest(boolean z16, boolean z17) {
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
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u0002J&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/VasTabFactory$a;", "", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/vas/VasTabFactory$ABTest;", "", "", "b", "", "autoExposure", "a", "Ljava/lang/String;", "testName", "appId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        private static boolean f307877d;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String testName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String appId;

        public a(@NotNull String testName, @NotNull String appId) {
            Intrinsics.checkNotNullParameter(testName, "testName");
            Intrinsics.checkNotNullParameter(appId, "appId");
            this.testName = testName;
            this.appId = appId;
            if (Intrinsics.areEqual(appId, ABTestController.APPID_1504) && !f307877d && !ABTestController.getInstance().isTabInited(ABTestController.APPID_1504)) {
                ABTestController aBTestController = ABTestController.getInstance();
                String c16 = com.tencent.mobileqq.statistics.o.c();
                Intrinsics.checkNotNullExpressionValue(c16, "getQimei36()");
                String upperCase = c16.toUpperCase();
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
                aBTestController.doInit1504(upperCase);
                f307877d = true;
            }
        }

        @NotNull
        public final Pair<ABTest, Map<String, String>> a(boolean autoExposure) {
            String trimIndent;
            ABTest aBTest;
            Map emptyMap;
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(this.appId, this.testName);
            Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(appId, testName)");
            trimIndent = StringsKt__IndentKt.trimIndent("\n                testName " + this.testName + " grayId: " + expEntity.getGrayId() + " isExperiment: " + expEntity.isExperiment() + " isContrast: " + expEntity.isContrast() + " assignment: " + expEntity.getAssignment() + "    \n                ");
            QLog.i("VasABTest", 1, trimIndent);
            if (expEntity.isExpInvalid()) {
                ABTest aBTest2 = ABTest.MISS;
                emptyMap = MapsKt__MapsKt.emptyMap();
                return TuplesKt.to(aBTest2, emptyMap);
            }
            String assignment = expEntity.getAssignment();
            String expName = expEntity.getExpName();
            Intrinsics.checkNotNullExpressionValue(assignment, "assignment");
            String upperCase = assignment.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
            Intrinsics.checkNotNullExpressionValue(expName, "expName");
            String upperCase2 = expName.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase()");
            if (Intrinsics.areEqual(upperCase, upperCase2 + "_A")) {
                aBTest = ABTest.A;
            } else {
                String upperCase3 = expName.toUpperCase();
                Intrinsics.checkNotNullExpressionValue(upperCase3, "this as java.lang.String).toUpperCase()");
                if (Intrinsics.areEqual(upperCase, upperCase3 + "_B")) {
                    aBTest = ABTest.B;
                } else {
                    String upperCase4 = expName.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(upperCase4, "this as java.lang.String).toUpperCase()");
                    if (Intrinsics.areEqual(upperCase, upperCase4 + "_C")) {
                        aBTest = ABTest.C;
                    } else {
                        String upperCase5 = expName.toUpperCase();
                        Intrinsics.checkNotNullExpressionValue(upperCase5, "this as java.lang.String).toUpperCase()");
                        if (Intrinsics.areEqual(upperCase, upperCase5 + "_D")) {
                            aBTest = ABTest.D;
                        } else {
                            String upperCase6 = expName.toUpperCase();
                            Intrinsics.checkNotNullExpressionValue(upperCase6, "this as java.lang.String).toUpperCase()");
                            if (Intrinsics.areEqual(upperCase, upperCase6 + "_E")) {
                                aBTest = ABTest.E;
                            } else {
                                String upperCase7 = expName.toUpperCase();
                                Intrinsics.checkNotNullExpressionValue(upperCase7, "this as java.lang.String).toUpperCase()");
                                if (Intrinsics.areEqual(upperCase, upperCase7 + "_F")) {
                                    aBTest = ABTest.F;
                                } else {
                                    String upperCase8 = expName.toUpperCase();
                                    Intrinsics.checkNotNullExpressionValue(upperCase8, "this as java.lang.String).toUpperCase()");
                                    if (Intrinsics.areEqual(upperCase, upperCase8 + "_G")) {
                                        aBTest = ABTest.G;
                                    } else {
                                        String upperCase9 = expName.toUpperCase();
                                        Intrinsics.checkNotNullExpressionValue(upperCase9, "this as java.lang.String).toUpperCase()");
                                        if (Intrinsics.areEqual(upperCase, upperCase9 + "_H")) {
                                            aBTest = ABTest.H;
                                        } else {
                                            aBTest = ABTest.MISS;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (autoExposure && aBTest != ABTest.MISS) {
                expEntity.reportExpExposure();
            }
            if (QLog.isDebugVersion()) {
                Map<String, String> tabParams = expEntity.getTabParams();
                Intrinsics.checkNotNullExpressionValue(tabParams, "entity.tabParams");
                for (Map.Entry<String, String> entry : tabParams.entrySet()) {
                    QLog.i("VasABTest", 1, "key: " + ((Object) entry.getKey()) + " value: " + ((Object) entry.getValue()));
                }
            }
            return TuplesKt.to(aBTest, expEntity.getTabParams());
        }

        @NotNull
        public final Pair<ABTest, Map<String, String>> b() {
            return a(true);
        }
    }

    VasTabFactory() {
    }

    @JvmStatic
    @NotNull
    public static final a a(@NotNull String owner, @NotNull String time, @NotNull String testName, @NotNull String appId) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(testName, "testName");
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (QLog.isDebugVersion() || ReportInfo.INSTANCE.isHit()) {
            VasNtCommonReporter.getHistoryFeature("vas-tab").setValue2(owner).setValue3(time).setValue4(testName).reportEveryDay(testName);
        }
        return new a(testName, appId);
    }

    public static /* synthetic */ a b(String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str4 = ABTestController.APPID_1505;
        }
        return a(str, str2, str3, str4);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Pair<ABTest, Map<String, String>> c(@NotNull String owner, @NotNull String time, @NotNull String testName) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(testName, "testName");
        return e(owner, time, testName, null, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Pair<ABTest, Map<String, String>> d(@NotNull String owner, @NotNull String time, @NotNull String testName, @NotNull String appId) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(testName, "testName");
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (QLog.isDebugVersion() || ReportInfo.INSTANCE.isHit()) {
            VasNtCommonReporter.getHistoryFeature("vas-tab").setValue2(owner).setValue3(time).setValue4(testName).reportEveryDay(testName);
        }
        return new a(testName, appId).b();
    }

    public static /* synthetic */ Pair e(String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str4 = ABTestController.APPID_1505;
        }
        return d(str, str2, str3, str4);
    }
}
