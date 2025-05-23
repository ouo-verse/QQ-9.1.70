package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Lambda;

/* JADX WARN: Incorrect field signature: Lkotlin/jvm/functions/Function1<-Lcom/tencent/kuikly/core/base/ViewContainer<**>;Lkotlin/Unit;>; */
/* compiled from: P */
/* loaded from: classes32.dex */
public final class HighlightAttr extends k {
    public boolean isIgnoreCase;
    public Lambda tailContentBuilder;
    public float fontSize = 13.0f;
    public String text = "";
    public String highlightText = "";
    public h textColor = QUISkinColor.INSTANCE.textPrimary();
    public int maxLength = 20;
}
