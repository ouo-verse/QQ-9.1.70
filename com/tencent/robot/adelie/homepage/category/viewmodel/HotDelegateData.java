package com.tencent.robot.adelie.homepage.category.viewmodel;

import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/viewmodel/d;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfo;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "cards", "<init>", "(Ljava/util/ArrayList;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.category.viewmodel.d, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class HotDelegateData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<RobotRecommendCardInfo> cards;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotDelegateData(@NotNull ArrayList<RobotRecommendCardInfo> cards) {
        super(RecommendCardType.HOT);
        Intrinsics.checkNotNullParameter(cards, "cards");
        this.cards = cards;
    }

    @NotNull
    public final ArrayList<RobotRecommendCardInfo> b() {
        return this.cards;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof HotDelegateData) && Intrinsics.areEqual(this.cards, ((HotDelegateData) other).cards)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.cards.hashCode();
    }

    @NotNull
    public String toString() {
        return "HotDelegateData(cards=" + this.cards + ")";
    }
}
