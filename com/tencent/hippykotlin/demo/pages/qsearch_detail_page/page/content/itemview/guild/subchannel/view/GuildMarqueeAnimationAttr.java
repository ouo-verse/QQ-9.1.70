package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guild.subchannel.view;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class GuildMarqueeAnimationAttr extends k {
    public float marqueeViewWidth;
    public Function1<? super ViewContainer<?, ?>, Unit> viewCreator;
    public float marqueePerSecondTranslation = 20.0f;
    public int marqueeDirection = 1;
}
