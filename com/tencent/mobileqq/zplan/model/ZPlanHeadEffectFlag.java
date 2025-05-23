package com.tencent.mobileqq.zplan.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/ZPlanHeadEffectFlag;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "NONE", "NOT_READ", "PLAYING", "PLAYED", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public enum ZPlanHeadEffectFlag {
    NONE,
    NOT_READ,
    PLAYING,
    PLAYED;


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/ZPlanHeadEffectFlag$a;", "", "", "Lcom/tencent/mobileqq/zplan/model/ZPlanHeadEffectFlag;", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.model.ZPlanHeadEffectFlag$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ZPlanHeadEffectFlag a(@Nullable String str) {
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1932423469) {
                    if (hashCode != -1906306142) {
                        if (hashCode == 224418830 && str.equals("PLAYING")) {
                            return ZPlanHeadEffectFlag.PLAYING;
                        }
                    } else if (str.equals("NOT_READ")) {
                        return ZPlanHeadEffectFlag.NOT_READ;
                    }
                } else if (str.equals("PLAYED")) {
                    return ZPlanHeadEffectFlag.PLAYED;
                }
            }
            return ZPlanHeadEffectFlag.NONE;
        }

        Companion() {
        }
    }
}
