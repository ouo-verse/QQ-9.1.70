package com.tencent.mobileqq.zplan.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/ZPlanActionType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "UNKNOWN", "MEME", "ACTION", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public enum ZPlanActionType {
    UNKNOWN,
    MEME,
    ACTION;


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0003\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/ZPlanActionType$a;", "", "Lcom/tencent/mobileqq/zplan/model/ZPlanActionType;", "", "a", "b", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.model.ZPlanActionType$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(@NotNull ZPlanActionType zPlanActionType) {
            Intrinsics.checkNotNullParameter(zPlanActionType, "<this>");
            return zPlanActionType.ordinal();
        }

        @NotNull
        public final ZPlanActionType b(int i3) {
            ZPlanActionType zPlanActionType = ZPlanActionType.MEME;
            if (i3 != zPlanActionType.ordinal()) {
                ZPlanActionType zPlanActionType2 = ZPlanActionType.ACTION;
                if (i3 != zPlanActionType2.ordinal()) {
                    return ZPlanActionType.UNKNOWN;
                }
                return zPlanActionType2;
            }
            return zPlanActionType;
        }

        Companion() {
        }
    }
}
