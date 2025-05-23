package com.tencent.mobileqq.data;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/data/DressUpShowType;", "", WidgetCacheConstellationData.NUM, "", "(Ljava/lang/String;II)V", "getNum", "()I", "NONE", "DRESSUP", "SUIT", "IP", "Companion", "IMCore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public enum DressUpShowType {
    NONE(0),
    DRESSUP(1),
    SUIT(2),
    IP(3);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int num;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/data/DressUpShowType$Companion;", "", "()V", "fromInt", "Lcom/tencent/mobileqq/data/DressUpShowType;", "value", "", "toInt", "type", "IMCore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final DressUpShowType fromInt(int value) {
            boolean z16;
            for (DressUpShowType dressUpShowType : DressUpShowType.values()) {
                if (dressUpShowType.getNum() == value) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return dressUpShowType;
                }
            }
            return null;
        }

        @JvmStatic
        public final int toInt(@NotNull DressUpShowType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return type.getNum();
        }

        Companion() {
        }
    }

    DressUpShowType(int i3) {
        this.num = i3;
    }

    @JvmStatic
    @Nullable
    public static final DressUpShowType fromInt(int i3) {
        return INSTANCE.fromInt(i3);
    }

    @JvmStatic
    public static final int toInt(@NotNull DressUpShowType dressUpShowType) {
        return INSTANCE.toInt(dressUpShowType);
    }

    public final int getNum() {
        return this.num;
    }
}
