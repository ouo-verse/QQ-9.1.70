package com.tencent.kuikly.core.nvi.serialization.json;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/kuikly/core/nvi/serialization/json/JSONException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", ReportConstant.COSTREPORT_PREFIX, "", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class JSONException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSONException(String s16) {
        super(s16);
        Intrinsics.checkNotNullParameter(s16, "s");
    }
}
