package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NBPFeedCommentsViewKt {
    public static void NBPFeedComments$default(ViewContainer viewContainer, String str, String str2, NBPFeedCommentsData nBPFeedCommentsData, boolean z16, boolean z17, Function1 function1, int i3) {
        viewContainer.addChild(new NBPFeedCommentsView(str, str2, nBPFeedCommentsData, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? true : z17, (i3 & 32) != 0 ? 1000 : 0, (i3 & 64) != 0), function1);
    }
}
