package com.tencent.mobileqq.qqlive.sail.model;

import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/e;", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "definition", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", "a", "qq-live-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f {
    @Nullable
    public static final com.tencent.mobileqq.qqlive.sail.model.audience.a a(@NotNull com.tencent.mobileqq.qqlive.sail.room.e eVar, @NotNull StreamDefinition definition) {
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        Intrinsics.checkNotNullParameter(definition, "definition");
        com.tencent.mobileqq.qqlive.sail.model.audience.a s16 = eVar.b().s(definition);
        if (s16 != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(s16.e());
            if (!isBlank2) {
                return s16;
            }
        }
        for (com.tencent.mobileqq.qqlive.sail.model.audience.a aVar : eVar.b().t()) {
            isBlank = StringsKt__StringsJVMKt.isBlank(aVar.e());
            if (!isBlank) {
                return aVar;
            }
        }
        return null;
    }
}
