package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import android.text.Spannable;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AbsoluteSizeSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Paragraph;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Selection;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class i extends m<Integer, AbsoluteSizeSpan> {

    /* renamed from: b, reason: collision with root package name */
    private o<Integer> f212432b = new o<>();

    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.m
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void g(GameStrategyEditTextView gameStrategyEditTextView, Selection selection, Integer num) {
        Integer num2;
        Spannable text = gameStrategyEditTextView.getText();
        this.f212432b.b();
        ArrayList<Paragraph> R = gameStrategyEditTextView.R();
        int size = R.size();
        for (int i3 = 0; i3 < size; i3++) {
            Paragraph paragraph = R.get(i3);
            List<? extends zd1.e<Integer>> d16 = d(text, paragraph, SpanCollectMode.SPAN_FLAGS);
            this.f212432b.e(d16, paragraph);
            boolean z16 = !d16.isEmpty();
            if (paragraph.isSelected(selection)) {
                num2 = num;
            } else if (z16) {
                num2 = d16.get(0).getValue();
            } else {
                num2 = null;
            }
            if (num2 != null) {
                this.f212432b.a(new AbsoluteSizeSpan(num2.intValue()), paragraph);
            }
        }
        this.f212432b.c(text);
    }
}
