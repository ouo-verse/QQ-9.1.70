package com.tencent.state.square.bubblesetting;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import fs4.j;
import fs4.o;
import fs4.p;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mt4.a;
import mt4.k;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0005\u001a\n\u0010\u0007\u001a\u00020\t*\u00020\b\u001a\n\u0010\u0007\u001a\u00020\u000b*\u00020\n\u001a\n\u0010\u0007\u001a\u00020\r*\u00020\f\u001a\n\u0010\u0007\u001a\u00020\u000b*\u00020\u000e\u001a\n\u0010\u0007\u001a\u00020\u0000*\u00020\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "", "useDefault", "isDefault", "isReady", "Lfs4/p;", "Lcom/tencent/state/square/bubblesetting/SquareBubbleColor;", "parse", "Lfs4/j;", "Lcom/tencent/state/square/bubblesetting/SquareLikeButtonColor;", "Lmt4/a;", "Lcom/tencent/state/square/bubblesetting/SquareBubbleSkin;", "Lmt4/k;", "Lcom/tencent/state/square/bubblesetting/SquareBubbleSkinGroup;", "Lmt4/j;", "Lfs4/o;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareBubbleSkinKt {
    public static final boolean isDefault(SquareBubbleInfo isDefault) {
        Intrinsics.checkNotNullParameter(isDefault, "$this$isDefault");
        return isDefault.getId() == 1;
    }

    public static final boolean isReady(SquareBubbleInfo isReady) {
        Intrinsics.checkNotNullParameter(isReady, "$this$isReady");
        return isDefault(isReady) || isReady.getBitmap() != null;
    }

    public static final SquareBubbleColor parse(p parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        String str = parse.f400555a;
        String str2 = parse.f400556b;
        String str3 = parse.f400557c;
        j jVar = parse.f400558d;
        SquareLikeButtonColor parse2 = jVar != null ? parse(jVar) : null;
        j jVar2 = parse.f400559e;
        return new SquareBubbleColor(str, str2, str3, parse2, jVar2 != null ? parse(jVar2) : null, parse.f400560f);
    }

    public static final boolean useDefault(SquareBubbleInfo useDefault) {
        Intrinsics.checkNotNullParameter(useDefault, "$this$useDefault");
        return isDefault(useDefault) || useDefault.getBitmap() == null;
    }

    public static final SquareLikeButtonColor parse(j parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        return new SquareLikeButtonColor(parse.f400529a, parse.f400530b);
    }

    public static final SquareBubbleSkin parse(a parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        o oVar = parse.f417579b;
        return new SquareBubbleSkin(oVar != null ? parse(oVar) : null, parse.f417578a, parse.f417580c, parse.f417581d, null, 16, null);
    }

    public static final SquareBubbleSkinGroup parse(k parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        ArrayList arrayList = new ArrayList();
        for (mt4.j skin : parse.f417598c) {
            Intrinsics.checkNotNullExpressionValue(skin, "skin");
            arrayList.add(parse(skin));
        }
        int i3 = parse.f417596a;
        String groupName = parse.f417597b;
        Intrinsics.checkNotNullExpressionValue(groupName, "groupName");
        return new SquareBubbleSkinGroup(i3, groupName, arrayList);
    }

    public static final SquareBubbleSkin parse(mt4.j parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        o oVar = parse.f417589a;
        SquareBubbleInfo parse2 = oVar != null ? parse(oVar) : null;
        String str = parse.f417590b;
        int i3 = parse.f417591c;
        String str2 = parse.f417592d;
        String str3 = parse.f417593e;
        Intrinsics.checkNotNullExpressionValue(str3, "this.skinExpireTips");
        return new SquareBubbleSkin(parse2, str, i3, str2, str3);
    }

    public static final SquareBubbleInfo parse(o parse) {
        SkinUrls skinUrls;
        String str;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        try {
            skinUrls = (SkinUrls) new Gson().fromJson(parse.f400552c, SkinUrls.class);
        } catch (JsonSyntaxException e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "Skin.parse", "error:" + e16, null, 4, null);
            skinUrls = null;
        }
        int i3 = parse.f400550a;
        String str2 = parse.f400551b;
        Intrinsics.checkNotNullExpressionValue(str2, "this.skinName");
        if (skinUrls == null || (str = skinUrls.getStatusBubbleUrl()) == null) {
            str = parse.f400552c;
        }
        String str3 = str;
        String speakingBubbleUrl = skinUrls != null ? skinUrls.getSpeakingBubbleUrl() : null;
        p pVar = parse.f400553d;
        return new SquareBubbleInfo(i3, str2, str3, speakingBubbleUrl, pVar != null ? parse(pVar) : null, parse.f400554e, null, 64, null);
    }
}
