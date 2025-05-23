package com.tencent.robot.adelie.homepage.category.viewmodel;

import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qqnt.kernel.nativeinterface.RobotRecommendCardInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/viewmodel/h;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfo;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfo;", IndividuationUrlHelper.UrlId.CARD_HOME, "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/RobotRecommendCardInfo;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.category.viewmodel.h, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class ToolDelegateData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RobotRecommendCardInfo card;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolDelegateData(@NotNull RobotRecommendCardInfo card) {
        super(RecommendCardType.TOOL);
        Intrinsics.checkNotNullParameter(card, "card");
        this.card = card;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final RobotRecommendCardInfo getCard() {
        return this.card;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ToolDelegateData) && Intrinsics.areEqual(this.card, ((ToolDelegateData) other).card)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.card.hashCode();
    }

    @NotNull
    public String toString() {
        return "ToolDelegateData(card=" + this.card + ")";
    }
}
