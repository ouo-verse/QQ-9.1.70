package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import android.text.Layout;
import android.text.Spannable;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AlignmentSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Paragraph;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Selection;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends m<Layout.Alignment, AlignmentSpan> {

    /* renamed from: b, reason: collision with root package name */
    private o<Layout.Alignment> f212416b = new o<>();

    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.m
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void g(GameStrategyEditTextView gameStrategyEditTextView, Selection selection, Layout.Alignment alignment) {
        Layout.Alignment alignment2;
        Spannable text = gameStrategyEditTextView.getText();
        this.f212416b.b();
        ArrayList<Paragraph> R = gameStrategyEditTextView.R();
        int size = R.size();
        for (int i3 = 0; i3 < size; i3++) {
            Paragraph paragraph = R.get(i3);
            List<? extends zd1.e<Layout.Alignment>> d16 = d(text, paragraph, SpanCollectMode.SPAN_FLAGS);
            this.f212416b.e(d16, paragraph);
            boolean z16 = !d16.isEmpty();
            if (paragraph.isSelected(selection)) {
                alignment2 = alignment;
            } else if (z16) {
                alignment2 = d16.get(0).getValue();
            } else {
                alignment2 = null;
            }
            if (alignment2 != null) {
                this.f212416b.a(new AlignmentSpan(alignment2, ae1.a.d(text, paragraph.getMStart(), paragraph.getMEnd())), paragraph);
            }
        }
        this.f212416b.c(text);
    }
}
