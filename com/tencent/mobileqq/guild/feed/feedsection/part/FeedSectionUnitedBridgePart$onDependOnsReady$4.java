package com.tencent.mobileqq.guild.feed.feedsection.part;

import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class FeedSectionUnitedBridgePart$onDependOnsReady$4 extends FunctionReferenceImpl implements Function1<UIStateData<List<ij1.g>>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedSectionUnitedBridgePart$onDependOnsReady$4(Object obj) {
        super(1, obj, FeedSectionUnitedBridgePart.class, "refreshAnimator", "refreshAnimator(Lcom/tencent/richframework/data/base/UIStateData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<ij1.g>> uIStateData) {
        invoke2(uIStateData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull UIStateData<List<ij1.g>> p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((FeedSectionUnitedBridgePart) this.receiver).ga(p06);
    }
}
