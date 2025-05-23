package com.tencent.qqnt.graytips.util;

import android.text.TextUtils;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "", "a", "graytips_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class j {
    @NotNull
    public static final String a(@NotNull RevokeElement revokeElement) {
        Intrinsics.checkNotNullParameter(revokeElement, "<this>");
        if (!TextUtils.isEmpty(revokeElement.operatorMemRemark)) {
            String str = revokeElement.operatorMemRemark;
            Intrinsics.checkNotNullExpressionValue(str, "{\n            operatorMemRemark\n        }");
            return str;
        }
        if (!TextUtils.isEmpty(revokeElement.operatorRemark)) {
            String str2 = revokeElement.operatorRemark;
            Intrinsics.checkNotNullExpressionValue(str2, "{\n            operatorRemark\n        }");
            return str2;
        }
        if (!TextUtils.isEmpty(revokeElement.operatorNick)) {
            String str3 = revokeElement.operatorNick;
            Intrinsics.checkNotNullExpressionValue(str3, "{\n            operatorNick\n        }");
            return str3;
        }
        return "";
    }
}
