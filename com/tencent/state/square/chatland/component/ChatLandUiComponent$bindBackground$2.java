package com.tencent.state.square.chatland.component;

import android.graphics.Point;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "p1", "Landroid/graphics/Point;", "p2", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* synthetic */ class ChatLandUiComponent$bindBackground$2 extends FunctionReferenceImpl implements Function2<Point, Point, Boolean> {
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(Point point, Point point2) {
        return Boolean.valueOf(invoke2(point, point2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatLandUiComponent$bindBackground$2(ChatLandUiComponent chatLandUiComponent) {
        super(2, chatLandUiComponent, ChatLandUiComponent.class, "backgroundClickInterceptor", "backgroundClickInterceptor(Landroid/graphics/Point;Landroid/graphics/Point;)Z", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Point p16, Point p26) {
        boolean backgroundClickInterceptor;
        Intrinsics.checkNotNullParameter(p16, "p1");
        Intrinsics.checkNotNullParameter(p26, "p2");
        backgroundClickInterceptor = ((ChatLandUiComponent) this.receiver).backgroundClickInterceptor(p16, p26);
        return backgroundClickInterceptor;
    }
}
