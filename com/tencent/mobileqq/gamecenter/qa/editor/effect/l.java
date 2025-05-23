package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import android.text.Editable;
import android.text.Layout;
import android.util.SparseIntArray;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AlignmentSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Paragraph;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Selection;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class l extends m<Boolean, zd1.c> {

    /* renamed from: b, reason: collision with root package name */
    private o<Boolean> f212434b = new o<>();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v4, types: [int] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.tencent.mobileqq.gamecenter.qa.editor.effect.l, com.tencent.mobileqq.gamecenter.qa.editor.effect.g] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.util.SparseIntArray] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.util.SparseIntArray] */
    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.m
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public synchronized void g(GameStrategyEditTextView gameStrategyEditTextView, Selection selection, Boolean bool) {
        int i3;
        Selection selection2;
        AlignmentSpan alignmentSpan;
        Editable text = gameStrategyEditTextView.getText();
        this.f212434b.b();
        ?? sparseIntArray = new SparseIntArray();
        ?? sparseIntArray2 = new SparseIntArray();
        ArrayList<Paragraph> R = gameStrategyEditTextView.R();
        int size = R.size();
        boolean z16 = true;
        int i16 = 0;
        boolean z17 = false;
        int i17 = 1;
        while (i16 < size) {
            Paragraph paragraph = R.get(i16);
            List<zd1.e<Integer>> d16 = h.INDENTATION.d(text, paragraph, SpanCollectMode.EXACT);
            if (!d16.isEmpty()) {
                Iterator<zd1.e<Integer>> it = d16.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    i3 += it.next().getValue().intValue();
                }
            } else {
                i3 = 0;
            }
            sparseIntArray.put(i17, i3);
            List<? extends zd1.e<Boolean>> d17 = d(text, paragraph, SpanCollectMode.SPAN_FLAGS);
            this.f212434b.e(d17, paragraph);
            boolean isEmpty = d17.isEmpty() ^ z16;
            if (!z17 && gameStrategyEditTextView.a0() && paragraph.getMStart() == paragraph.getMEnd()) {
                selection2 = selection;
                isEmpty = false;
            } else {
                selection2 = selection;
            }
            if (paragraph.isSelected(selection2)) {
                isEmpty = bool.booleanValue();
            }
            if (isEmpty) {
                boolean z18 = z16;
                int i18 = z18;
                for (?? r142 = z18; r142 < i17; r142++) {
                    int i19 = sparseIntArray.get(r142);
                    int i26 = sparseIntArray2.get(r142);
                    if (i19 >= i3) {
                        if (i19 == i3) {
                            if (i26 != 0) {
                                i18 = i26 + 1;
                            }
                        }
                    }
                    i18 = 1;
                }
                sparseIntArray2.put(i17, i18);
                zd1.c cVar = new zd1.c(i18, ae1.a.c(), paragraph.isEmpty(), paragraph.getIsFirst(), paragraph.getIsLast());
                List<zd1.e<Layout.Alignment>> d18 = h.ALIGNMENT.d(text, paragraph, SpanCollectMode.SPAN_FLAGS);
                if (d18 != null && !d18.isEmpty()) {
                    zd1.e<Layout.Alignment> eVar = d18.get(0);
                    if (eVar instanceof AlignmentSpan) {
                        alignmentSpan = (AlignmentSpan) eVar;
                        cVar.j(gameStrategyEditTextView, paragraph, alignmentSpan);
                        this.f212434b.a(cVar, paragraph);
                        h.BULLET.h(text, paragraph, this.f212434b);
                    }
                }
                alignmentSpan = null;
                cVar.j(gameStrategyEditTextView, paragraph, alignmentSpan);
                this.f212434b.a(cVar, paragraph);
                h.BULLET.h(text, paragraph, this.f212434b);
            }
            i17++;
            i16++;
            z17 = isEmpty;
            z16 = true;
        }
        this.f212434b.c(text);
    }
}
