package com.tencent.state.square.chatland.component;

import android.graphics.Point;
import com.tencent.state.square.chatland.view.AreaType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Landroid/graphics/Point;", "p2", "p3", "Lcom/tencent/state/square/chatland/view/AreaType;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* synthetic */ class ChatLandUiComponent$bindBackground$1 extends FunctionReferenceImpl implements Function3<Point, Point, AreaType, Unit> {
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Point point, Point point2, AreaType areaType) {
        invoke2(point, point2, areaType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatLandUiComponent$bindBackground$1(ChatLandUiComponent chatLandUiComponent) {
        super(3, chatLandUiComponent, ChatLandUiComponent.class, "handleBackgroundClick", "handleBackgroundClick(Landroid/graphics/Point;Landroid/graphics/Point;Lcom/tencent/state/square/chatland/view/AreaType;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Point p16, Point p26, AreaType p36) {
        Intrinsics.checkNotNullParameter(p16, "p1");
        Intrinsics.checkNotNullParameter(p26, "p2");
        Intrinsics.checkNotNullParameter(p36, "p3");
        ((ChatLandUiComponent) this.receiver).handleBackgroundClick(p16, p26, p36);
    }
}
