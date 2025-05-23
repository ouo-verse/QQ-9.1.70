package com.tencent.state.square.data;

import et4.a;
import et4.f;
import et4.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0002\u001a\u00020\u0004*\u00020\u0003\u001a\n\u0010\u0002\u001a\u00020\u0006*\u00020\u0005\u00a8\u0006\u0007"}, d2 = {"Let4/a;", "Lcom/tencent/state/square/data/SquareEntry;", "parse", "Let4/f;", "Lcom/tencent/state/square/data/SquareHippyInfo;", "Let4/g;", "Lcom/tencent/state/square/data/SquareRedDotInfo;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareEntryKt {
    public static final SquareEntry parse(a parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        String str = parse.f397121h;
        Intrinsics.checkNotNullExpressionValue(str, "this.entryName");
        boolean z16 = parse.f397114a;
        String str2 = parse.f397115b;
        String str3 = parse.f397116c;
        int i3 = parse.f397117d;
        int i16 = parse.f397118e;
        f fVar = parse.f397119f;
        SquareHippyInfo parse2 = fVar != null ? parse(fVar) : null;
        g gVar = parse.f397120g;
        return new SquareEntry(str, z16, str2, str3, i3, i16, parse2, gVar != null ? parse(gVar) : null);
    }

    public static final SquareHippyInfo parse(f parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        return new SquareHippyInfo(parse.f397125b, parse.f397124a, parse.f397126c, parse.f397127d == 1);
    }

    public static final SquareRedDotInfo parse(g parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        return new SquareRedDotInfo(parse.f397128a, parse.f397129b);
    }
}
