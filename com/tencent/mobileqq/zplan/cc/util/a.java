package com.tencent.mobileqq.zplan.cc.util;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/util/a;", "", "", "abTestName", "expTagName", "", "c", HippyControllerProps.STRING, "a", "", "b", "Ljava/util/Map;", "experimentExportResult", "()Z", "disableZplanAIFaceCache", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f332553a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Boolean> experimentExportResult = new LinkedHashMap();

    a() {
    }

    public final String a(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return string + "_B";
    }

    public final boolean b() {
        return c("exp_zplan_avatar_aiface_lodaing", a("exp_zplan_avatar_aiface_lodaing"));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(String abTestName, String expTagName) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(abTestName, "abTestName");
        Intrinsics.checkNotNullParameter(expTagName, "expTagName");
        QLog.d("AIFaceABUtils", 1, "queryAB begin ==>> " + abTestName + MsgSummary.STR_COLON + expTagName);
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(abTestName);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance()\n          \u2026.getExpEntity(abTestName)");
        String assignment = expEntity.getAssignment();
        if (assignment != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(assignment);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    QLog.d("AIFaceABUtils", 1, "queryAB error bucket is null");
                    return false;
                }
                Map<String, Boolean> map = experimentExportResult;
                if (!Intrinsics.areEqual(map.get(abTestName), Boolean.TRUE)) {
                    QLog.d("AIFaceABUtils", 1, "queryAB reportExperimentExport ==>> " + abTestName + MsgSummary.STR_COLON + assignment);
                    map.put(abTestName, Boolean.valueOf(yt.b.g(abTestName)));
                }
                QLog.d("AIFaceABUtils", 1, "queryAB result ==>> " + abTestName + MsgSummary.STR_COLON + assignment);
                return Intrinsics.areEqual(expTagName, assignment);
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
