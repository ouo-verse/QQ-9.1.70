package com.tencent.mobileqq.troop.troopidentity.dialog;

import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityInteractionTag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "", "iconUrl", "Lcom/tencent/mobileqq/troop/troopidentity/dialog/b;", "a", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class i {
    @NotNull
    public static final b a(@NotNull GroupIdentityInteractionTag groupIdentityInteractionTag, @Nullable String str) {
        Intrinsics.checkNotNullParameter(groupIdentityInteractionTag, "<this>");
        String str2 = groupIdentityInteractionTag.interactionTagId;
        Intrinsics.checkNotNullExpressionValue(str2, "this.interactionTagId");
        String str3 = groupIdentityInteractionTag.name;
        Intrinsics.checkNotNullExpressionValue(str3, "this.name");
        if (str == null) {
            str = "";
        }
        String str4 = groupIdentityInteractionTag.rule;
        Intrinsics.checkNotNullExpressionValue(str4, "this.rule");
        return new b(str2, str3, str, str4, groupIdentityInteractionTag.isObtained, groupIdentityInteractionTag.isSet);
    }
}
