package com.tencent.mobileqq.winkpublish.outbox.slot;

import com.google.gson.Gson;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/TaskEndSummary;", "", "a", "qq_winkpublish_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e {
    public static final String a(TaskEndSummary taskEndSummary) {
        Intrinsics.checkNotNullParameter(taskEndSummary, "<this>");
        try {
            String json = new Gson().toJson(taskEndSummary);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            return json;
        } catch (Exception e16) {
            QLog.w("WinkPublish-upload2-TaskEndSummary", 1, "[toJson] ", e16);
            return "";
        }
    }
}
