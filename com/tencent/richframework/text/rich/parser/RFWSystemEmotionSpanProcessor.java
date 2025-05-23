package com.tencent.richframework.text.rich.parser;

import com.tencent.mobileqq.text.processor.QQEmoticonSpanProcessor;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.richframework.text.rich.span.RFWSystemEmotionSpan;

/* loaded from: classes25.dex */
public class RFWSystemEmotionSpanProcessor extends QQEmoticonSpanProcessor {
    @Override // com.tencent.mobileqq.text.processor.QQEmoticonSpanProcessor
    protected EmoticonSpan createEmoticonSpan(boolean z16, int i3, int i16, int i17) {
        return new RFWSystemEmotionSpan(i3, i16, i17);
    }
}
