package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import android.text.Spannable;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Selection;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
class n<V> extends p<V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Class<? extends zd1.e<V>> cls) {
        super(cls);
    }

    private boolean d(Spannable spannable, Selection selection, Object obj, SpanCollectMode spanCollectMode) {
        int spanStart = spannable.getSpanStart(obj);
        int spanEnd = spannable.getSpanEnd(obj);
        int mStart = selection.getMStart();
        int mEnd = selection.getMEnd();
        int max = Math.max(spanStart, mStart);
        int min = Math.min(spanEnd, mEnd);
        if (max > min) {
            return false;
        }
        if (max < min) {
            return true;
        }
        if ((spanStart > mStart && spanEnd < mEnd) || (mStart > spanStart && mEnd < spanEnd)) {
            return true;
        }
        if (spanCollectMode == SpanCollectMode.EXACT) {
            if (spanStart != mStart || spanEnd != mEnd || mStart != mEnd) {
                return false;
            }
            return true;
        }
        int spanFlags = spannable.getSpanFlags(obj) & 51;
        if (spanEnd == mStart) {
            return c(spanFlags, 34, 18);
        }
        return c(spanFlags, 17, 18);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.p
    public final List<zd1.e<V>> a(Spannable spannable, Selection selection, SpanCollectMode spanCollectMode) {
        ArrayList arrayList = new ArrayList();
        for (zd1.e<V> eVar : b(spannable, selection.getMStart(), selection.getMEnd())) {
            if (d(spannable, selection, eVar, spanCollectMode)) {
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }
}
