package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import android.text.Spannable;
import com.tencent.mobileqq.gamecenter.qa.editor.span.IndentationSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Paragraph;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Selection;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class j extends m<Integer, IndentationSpan> {

    /* renamed from: b, reason: collision with root package name */
    private o<Integer> f212433b = new o<>();

    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.m
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void g(GameStrategyEditTextView gameStrategyEditTextView, Selection selection, Integer num) {
        int i3;
        int intValue;
        Spannable text = gameStrategyEditTextView.getText();
        this.f212433b.b();
        ArrayList<Paragraph> R = gameStrategyEditTextView.R();
        int size = R.size();
        for (int i16 = 0; i16 < size; i16++) {
            Paragraph paragraph = R.get(i16);
            List<? extends zd1.e<Integer>> d16 = d(text, paragraph, SpanCollectMode.EXACT);
            this.f212433b.e(d16, paragraph);
            Iterator<? extends zd1.e<Integer>> it = d16.iterator();
            if (it.hasNext()) {
                i3 = it.next().getValue().intValue() + 0;
            } else {
                i3 = 0;
            }
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            if (!paragraph.isSelected(selection)) {
                intValue = 0;
            }
            int i17 = i3 + intValue;
            if (i17 > 0) {
                this.f212433b.a(new IndentationSpan(i17, paragraph.isEmpty(), paragraph.getIsFirst(), paragraph.getIsLast()), paragraph);
            }
        }
        this.f212433b.c(text);
    }
}
