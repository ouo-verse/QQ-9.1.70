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
public class d extends m<Boolean, zd1.b> {

    /* renamed from: b, reason: collision with root package name */
    private o<Boolean> f212419b = new o<>();

    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.m
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public synchronized void g(GameStrategyEditTextView gameStrategyEditTextView, Selection selection, Boolean bool) {
        Selection selection2;
        AlignmentSpan alignmentSpan;
        Spannable text = gameStrategyEditTextView.getText();
        this.f212419b.b();
        ArrayList<Paragraph> R = gameStrategyEditTextView.R();
        int size = R.size();
        int i3 = 0;
        boolean z16 = false;
        while (i3 < size) {
            Paragraph paragraph = R.get(i3);
            SpanCollectMode spanCollectMode = SpanCollectMode.SPAN_FLAGS;
            List<? extends zd1.e<Boolean>> d16 = d(text, paragraph, spanCollectMode);
            this.f212419b.e(d16, paragraph);
            boolean z17 = !d16.isEmpty();
            if (!z16 && gameStrategyEditTextView.a0() && paragraph.getMStart() == paragraph.getMEnd()) {
                selection2 = selection;
                z17 = false;
            } else {
                selection2 = selection;
            }
            if (paragraph.isSelected(selection2)) {
                z17 = bool.booleanValue();
            }
            if (z17) {
                zd1.b bVar = new zd1.b(ae1.a.c(), paragraph.isEmpty(), paragraph.getIsFirst(), paragraph.getIsLast());
                List<zd1.e<Layout.Alignment>> d17 = h.ALIGNMENT.d(text, paragraph, spanCollectMode);
                if (d17 != null && !d17.isEmpty()) {
                    zd1.e<Layout.Alignment> eVar = d17.get(0);
                    if (eVar instanceof AlignmentSpan) {
                        alignmentSpan = (AlignmentSpan) eVar;
                        bVar.k(gameStrategyEditTextView, paragraph, alignmentSpan);
                        this.f212419b.a(bVar, paragraph);
                        h.NUMBER.h(text, paragraph, this.f212419b);
                    }
                }
                alignmentSpan = null;
                bVar.k(gameStrategyEditTextView, paragraph, alignmentSpan);
                this.f212419b.a(bVar, paragraph);
                h.NUMBER.h(text, paragraph, this.f212419b);
            }
            i3++;
            z16 = z17;
        }
        this.f212419b.c(text);
    }
}
