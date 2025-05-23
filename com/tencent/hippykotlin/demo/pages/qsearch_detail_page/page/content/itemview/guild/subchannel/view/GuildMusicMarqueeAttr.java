package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildMusicMarqueeAttr extends k {
    public Function0<Integer> marqueeItemListCount;
    public Function2<? super ViewContainer<?, ?>, ? super Integer, Unit> marqueeItemViewCreator;
    public float marqueePerSecondTranslation = 100.0f;
    public int maxMarqueeEachBatch = 1;
    public int marqueeDirection = 1;

    public final Function0<Integer> getMarqueeItemListCount$qecommerce_biz_release() {
        Function0<Integer> function0 = this.marqueeItemListCount;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("marqueeItemListCount");
        return null;
    }
}
