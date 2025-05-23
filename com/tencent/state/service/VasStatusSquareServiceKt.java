package com.tencent.state.service;

import android.graphics.Point;
import android.util.Size;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.Resource;
import hs4.a;
import hs4.b;
import hs4.l;
import hs4.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lhs4/s;", "Lcom/tencent/state/square/data/Resource;", "parse", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class VasStatusSquareServiceKt {
    public static final Resource parse(s parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        l lVar = parse.f406203c;
        b showDpi = lVar.f406167b;
        b recordDpi = lVar.f406166a;
        a aVar = parse.f406204d;
        int i3 = parse.f406201a;
        Intrinsics.checkNotNullExpressionValue(showDpi, "showDpi");
        Size formatSize = UserFormatKt.formatSize(showDpi, true);
        Intrinsics.checkNotNullExpressionValue(recordDpi, "recordDpi");
        Size formatSize2 = UserFormatKt.formatSize(recordDpi, true);
        int i16 = parse.f406205e;
        SquareBase squareBase = SquareBase.INSTANCE;
        Resource resource = new Resource(i3, null, null, formatSize, formatSize2, false, new Point(ViewExtensionsKt.calPx(squareBase.getApp(), aVar != null ? aVar.f406125a : 0), ViewExtensionsKt.calPx(squareBase.getApp(), aVar != null ? aVar.f406126b : 0)), i16, 0, null, 806, null);
        UserFormatKt.filamentFill(resource, parse);
        return resource;
    }
}
