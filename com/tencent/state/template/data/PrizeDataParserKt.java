package com.tencent.state.template.data;

import as4.a;
import as4.b;
import as4.e;
import as4.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0003*\u00020\u0000\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u0000\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\u0000\u001a\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002\u001a\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002\u001a\n\u0010\u0002\u001a\u00020\u0011*\u00020\u0010\u001a\n\u0010\u0002\u001a\u00020\u0013*\u00020\u0012\u001a\n\u0010\u0002\u001a\u00020\u0015*\u00020\u0014\"\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Las4/f;", "Lcom/tencent/state/template/data/PrizeInfo;", "parse", "Lcom/tencent/state/template/data/BasePrizeExtra;", "parseExtra", "parseLikeExtra", "parseFocusExtra", "parseEventExtra", "", "type", "Lcom/tencent/state/template/data/PrizeType;", "covertPrizeType", "Lcom/tencent/state/template/data/EventPrizeType;", "covertEventPrizeType", "Lcom/tencent/state/template/data/LikePrizeType;", "covertLikePrizeType", "Las4/a;", "Lcom/tencent/state/template/data/EventPrizeExtra;", "Las4/b;", "Lcom/tencent/state/template/data/FocusPrizeExtra;", "Las4/e;", "Lcom/tencent/state/template/data/LikePrizeExtra;", "", "TAG", "Ljava/lang/String;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PrizeDataParserKt {
    private static final String TAG = "PrizeDataParser";

    public static final PrizeInfo parse(f parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        throw null;
    }

    public static final BasePrizeExtra parseEventExtra(f parseEventExtra) {
        Intrinsics.checkNotNullParameter(parseEventExtra, "$this$parseEventExtra");
        throw null;
    }

    public static final BasePrizeExtra parseExtra(f parseExtra) {
        Intrinsics.checkNotNullParameter(parseExtra, "$this$parseExtra");
        throw null;
    }

    public static final BasePrizeExtra parseFocusExtra(f parseFocusExtra) {
        Intrinsics.checkNotNullParameter(parseFocusExtra, "$this$parseFocusExtra");
        throw null;
    }

    public static final BasePrizeExtra parseLikeExtra(f parseLikeExtra) {
        Intrinsics.checkNotNullParameter(parseLikeExtra, "$this$parseLikeExtra");
        throw null;
    }

    public static final EventPrizeExtra parse(a parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        return new EventPrizeExtra(covertEventPrizeType(parse.f26875a));
    }

    public static final FocusPrizeExtra parse(b parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        long j3 = parse.f26876a;
        String str = parse.f26877b;
        Intrinsics.checkNotNullExpressionValue(str, "this.tagId");
        return new FocusPrizeExtra(j3, str);
    }

    private static final EventPrizeType covertEventPrizeType(int i3) {
        if (i3 == 1) {
            return EventPrizeType.FLOWER;
        }
        if (i3 != 2) {
            return EventPrizeType.UNKNOWN;
        }
        return EventPrizeType.BG;
    }

    private static final LikePrizeType covertLikePrizeType(int i3) {
        if (i3 == 1) {
            return LikePrizeType.ACTIVE;
        }
        if (i3 != 2) {
            return LikePrizeType.UNKNOWN;
        }
        return LikePrizeType.INACTIVE;
    }

    public static final LikePrizeExtra parse(e parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        String str = parse.f26895a;
        Intrinsics.checkNotNullExpressionValue(str, "this.tagId");
        String str2 = parse.f26897c;
        Intrinsics.checkNotNullExpressionValue(str2, "this.tagText");
        return new LikePrizeExtra(str, str2, covertLikePrizeType(parse.f26896b));
    }

    private static final PrizeType covertPrizeType(int i3) {
        if (i3 == 1) {
            return PrizeType.LIKE;
        }
        if (i3 == 2) {
            return PrizeType.FOCUS;
        }
        if (i3 != 3) {
            return PrizeType.UNKNOWN;
        }
        return PrizeType.EVENT;
    }
}
