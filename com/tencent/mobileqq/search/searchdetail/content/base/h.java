package com.tencent.mobileqq.search.searchdetail.content.base;

import com.tencent.mobileqq.search.searchdetail.content.template.model.QSearchEnumJumpType;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "", "a", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h {
    public static final boolean a(@NotNull SearchJump searchJump) {
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(searchJump, "<this>");
        if (!QSearchEnumJumpType.INSTANCE.b(searchJump.type)) {
            return false;
        }
        if (searchJump.type == 0) {
            String jumpLink = searchJump.jumpLink;
            Intrinsics.checkNotNullExpressionValue(jumpLink, "jumpLink");
            isBlank = StringsKt__StringsJVMKt.isBlank(jumpLink);
            if (isBlank) {
                String jumpAndLink = searchJump.jumpAndLink;
                Intrinsics.checkNotNullExpressionValue(jumpAndLink, "jumpAndLink");
                isBlank2 = StringsKt__StringsJVMKt.isBlank(jumpAndLink);
                if (isBlank2) {
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }
}
