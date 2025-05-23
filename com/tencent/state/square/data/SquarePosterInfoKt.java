package com.tencent.state.square.data;

import com.tencent.mobileqq.app.AppConstants;
import hs4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import lt4.b;
import lt4.c;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0002\u001a\u00020\u0004*\u00020\u0003\u001a\n\u0010\u0002\u001a\u00020\u0006*\u00020\u0005\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0006\u001a\n\u0010\u0002\u001a\u00020\n*\u00020\t\u00a8\u0006\u000b"}, d2 = {"Llt4/c;", "Lcom/tencent/state/square/data/PosterMotionInfo;", "parse", "Llt4/b;", "Lcom/tencent/state/square/data/SquarePosterInfo;", "Lhs4/a;", "Lcom/tencent/state/square/data/NickCoordinate;", "", AppConstants.Key.COLUMN_IS_VALID, "Lkt4/c;", "Lcom/tencent/state/square/data/SquareMainPosterShareInfo;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquarePosterInfoKt {
    public static final boolean isValid(NickCoordinate isValid) {
        Intrinsics.checkNotNullParameter(isValid, "$this$isValid");
        return (isValid.getX() == 0 && isValid.getY() == 0) ? false : true;
    }

    public static final PosterMotionInfo parse(c parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        int i3 = parse.f415556a;
        String str = parse.f415557b;
        String str2 = parse.f415558c;
        a aVar = parse.f415559d;
        Intrinsics.checkNotNullExpressionValue(aVar, "this.ownerCoordinate");
        NickCoordinate parse2 = parse(aVar);
        a aVar2 = parse.f415560e;
        Intrinsics.checkNotNullExpressionValue(aVar2, "this.guestCoordinate");
        return new PosterMotionInfo(i3, str, str2, parse2, parse(aVar2));
    }

    public static final SquarePosterInfo parse(b parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        int i3 = parse.f415552a;
        c cVar = parse.f415553b;
        Intrinsics.checkNotNullExpressionValue(cVar, "this.motionInfo");
        return new SquarePosterInfo(i3, parse(cVar), parse.f415554c, parse.f415555d);
    }

    public static final NickCoordinate parse(a parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        return new NickCoordinate(parse.f406125a, parse.f406126b);
    }

    public static final SquareMainPosterShareInfo parse(kt4.c parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        String str = parse.f413010a;
        String str2 = parse.f413011b;
        byte[] shareNickName = parse.f413012c;
        Intrinsics.checkNotNullExpressionValue(shareNickName, "shareNickName");
        return new SquareMainPosterShareInfo(str, str2, new String(shareNickName, Charsets.UTF_8));
    }
}
