package com.tencent.robot.adelie.homepage.category.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/viewmodel/a;", "", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/RecommendCardType;", "a", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/RecommendCardType;", "()Lcom/tencent/robot/adelie/homepage/category/viewmodel/RecommendCardType;", "type", "<init>", "(Lcom/tencent/robot/adelie/homepage/category/viewmodel/RecommendCardType;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecommendCardType type;

    public a(@NotNull RecommendCardType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final RecommendCardType getType() {
        return this.type;
    }
}
