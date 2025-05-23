package com.tencent.state.square.guide;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ws4.b;
import ws4.c;
import ws4.d;
import ws4.e;
import ws4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0002\u001a\u00020\u0004*\u00020\u0003\u001a\n\u0010\u0002\u001a\u00020\u0006*\u00020\u0005\u001a\n\u0010\u0002\u001a\u00020\b*\u00020\u0007\u001a\n\u0010\u0002\u001a\u00020\n*\u00020\t\u00a8\u0006\u000b"}, d2 = {"Lws4/b;", "Lcom/tencent/state/square/guide/SquareNoviceGuideConfig;", "parse", "Lws4/f;", "Lcom/tencent/state/square/guide/PublishStatusGuideConfig;", "Lws4/e;", "Lcom/tencent/state/square/guide/CreateRoleGuideConfig;", "Lws4/d;", "Lcom/tencent/state/square/guide/CreateRolePageConfig;", "Lws4/c;", "Lcom/tencent/state/square/guide/CreateRoleRedDotBubbleConfig;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareNoviceGuideConfigKt {
    public static final SquareNoviceGuideConfig parse(b parse) {
        PublishStatusGuideConfig publishStatusGuideConfig;
        CreateRoleGuideConfig createRoleGuideConfig;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        f fVar = parse.f446408b;
        if (fVar == null || (publishStatusGuideConfig = parse(fVar)) == null) {
            publishStatusGuideConfig = new PublishStatusGuideConfig(false, 0L, null, false, 15, null);
        }
        e eVar = parse.f446407a;
        if (eVar == null || (createRoleGuideConfig = parse(eVar)) == null) {
            createRoleGuideConfig = new CreateRoleGuideConfig(false, 0L, null, null, null, 31, null);
        }
        return new SquareNoviceGuideConfig(publishStatusGuideConfig, createRoleGuideConfig);
    }

    public static final PublishStatusGuideConfig parse(f parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        boolean z16 = parse.f446423a;
        long j3 = parse.f446424b;
        String statusPagUrl = parse.f446425c;
        Intrinsics.checkNotNullExpressionValue(statusPagUrl, "statusPagUrl");
        return new PublishStatusGuideConfig(z16, j3, statusPagUrl, parse.f446426d);
    }

    public static final CreateRoleGuideConfig parse(e parse) {
        CreateRoleRedDotBubbleConfig parse2;
        CreateRolePageConfig parse3;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        boolean z16 = parse.f446418a;
        long j3 = parse.f446419b;
        String bornPagUrl = parse.f446420c;
        Intrinsics.checkNotNullExpressionValue(bornPagUrl, "bornPagUrl");
        d dVar = parse.f446421d;
        CreateRolePageConfig createRolePageConfig = (dVar == null || (parse3 = parse(dVar)) == null) ? new CreateRolePageConfig(null, null, null, null, null, 31, null) : parse3;
        c cVar = parse.f446422e;
        return new CreateRoleGuideConfig(z16, j3, bornPagUrl, createRolePageConfig, (cVar == null || (parse2 = parse(cVar)) == null) ? new CreateRoleRedDotBubbleConfig(false, null, 0, null, 15, null) : parse2);
    }

    public static final CreateRolePageConfig parse(d parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        String rolePagUrl = parse.f446413a;
        Intrinsics.checkNotNullExpressionValue(rolePagUrl, "rolePagUrl");
        String firstText = parse.f446414b;
        Intrinsics.checkNotNullExpressionValue(firstText, "firstText");
        String secondText = parse.f446415c;
        Intrinsics.checkNotNullExpressionValue(secondText, "secondText");
        String buttonText = parse.f446416d;
        Intrinsics.checkNotNullExpressionValue(buttonText, "buttonText");
        String buttonJumpSchema = parse.f446417e;
        Intrinsics.checkNotNullExpressionValue(buttonJumpSchema, "buttonJumpSchema");
        return new CreateRolePageConfig(rolePagUrl, firstText, secondText, buttonText, buttonJumpSchema);
    }

    public static final CreateRoleRedDotBubbleConfig parse(c parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        boolean z16 = parse.f446409a;
        String bubbleText = parse.f446410b;
        Intrinsics.checkNotNullExpressionValue(bubbleText, "bubbleText");
        int i3 = parse.f446411c;
        String clickJumpSchema = parse.f446412d;
        Intrinsics.checkNotNullExpressionValue(clickJumpSchema, "clickJumpSchema");
        return new CreateRoleRedDotBubbleConfig(z16, bubbleText, i3, clickJumpSchema);
    }
}
