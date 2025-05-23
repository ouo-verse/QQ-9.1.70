package com.tencent.richframework.text.rich.span;

import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.processor.ISpanProcessor;
import com.tencent.richframework.text.rich.parser.RFWSystemEmotionSpanProcessor;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWQQText extends QQText {
    private static ArrayList<ISpanProcessor> spanProcessorList;

    static {
        initProcessor();
    }

    public RFWQQText(CharSequence charSequence, int i3, int i16) {
        super(charSequence, i3, i16);
    }

    private static void initProcessor() {
        ArrayList<ISpanProcessor> arrayList = new ArrayList<>();
        spanProcessorList = arrayList;
        arrayList.add(new RFWSystemEmotionSpanProcessor());
    }

    @Override // com.tencent.mobileqq.text.QQText
    protected ArrayList<ISpanProcessor> getSpanProcessors() {
        return spanProcessorList;
    }
}
