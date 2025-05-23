package com.tencent.mobileqq.vas.gxh;

import com.tencent.mobileqq.vas.report.VasJsbCommonReport;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/gxh/a;", "", "Lorg/json/JSONObject;", "data", "", VasCommonJsbProxy.JSON_KEY_SET_KEY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "jsonStr", "", "callback", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.vas.gxh.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C8910a {
        public static void a(@NotNull a aVar, @NotNull VasJsbCommonReport report, @NotNull String setKey, @NotNull String id5) {
            long j3;
            Intrinsics.checkNotNullParameter(report, "report");
            Intrinsics.checkNotNullParameter(setKey, "setKey");
            Intrinsics.checkNotNullParameter(id5, "id");
            long currentTimeMillis = System.currentTimeMillis();
            VasJsbCommonReport.TimeRecord timeRecord = report.getMSetKeyToStartTime().get(setKey);
            if (timeRecord != null) {
                j3 = timeRecord.getFirstQueryTime();
            } else {
                j3 = 0;
            }
            report.reportSetEndSetSuccess(setKey, id5, currentTimeMillis - j3);
        }
    }

    void a(@NotNull JSONObject data, @NotNull String setKey, @NotNull Function1<? super String, Unit> callback);
}
