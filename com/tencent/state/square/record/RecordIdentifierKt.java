package com.tencent.state.square.record;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0004"}, d2 = {"isSame", "", "Lcom/tencent/state/square/record/RecordIdentifier;", IECDtReport.ACTION_IDENTIFIER, "square_base_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class RecordIdentifierKt {
    public static final boolean isSame(@NotNull RecordIdentifier isSame, @NotNull RecordIdentifier identifier) {
        boolean z16;
        Intrinsics.checkNotNullParameter(isSame, "$this$isSame");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        if (isSame.getAllUinList().size() == identifier.getAllUinList().size() && isSame.getType() == identifier.getType() && isSame.getNeedUpload() == identifier.getNeedUpload()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        int size = isSame.getAllUinList().size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(isSame.getAllUinList().get(i3), identifier.getAllUinList().get(i3))) {
                return false;
            }
        }
        return z16;
    }
}
