package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import android.text.Spannable;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Selection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J0\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/f;", "V", "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/p;", "Landroid/text/Spannable;", "str", "Lcom/tencent/mobileqq/gamecenter/qa/editor/util/Selection;", "selection", "", TtmlNode.TAG_SPAN, "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/SpanCollectMode;", "mode", "", "d", "", "Lzd1/e;", "a", "Ljava/lang/Class;", "spanClazz", "<init>", "(Ljava/lang/Class;)V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class f<V> extends p<V> {
    public f(@Nullable Class<? extends zd1.e<V>> cls) {
        super(cls);
    }

    private final boolean d(Spannable str, Selection selection, Object span, SpanCollectMode mode) {
        int spanStart = str.getSpanStart(span);
        int spanEnd = str.getSpanEnd(span);
        int mStart = selection.getMStart();
        int mEnd = selection.getMEnd();
        int max = Math.max(spanStart, mStart);
        int min = Math.min(spanEnd, mEnd);
        if (max > min) {
            return false;
        }
        if (max < min || ((spanStart > mStart && spanEnd < mEnd) || (mStart > spanStart && mEnd < spanEnd))) {
            return true;
        }
        if (mode == SpanCollectMode.EXACT) {
            return false;
        }
        int spanFlags = str.getSpanFlags(span) & 51;
        if (spanEnd == mStart) {
            return c(spanFlags, 34, 18);
        }
        return c(spanFlags, 17, 18);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.p
    @Nullable
    public List<zd1.e<V>> a(@NotNull Spannable str, @NotNull Selection selection, @NotNull SpanCollectMode mode) {
        Intrinsics.checkNotNullParameter(str, "str");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(mode, "mode");
        ArrayList arrayList = new ArrayList();
        for (zd1.e<V> eVar : b(str, Math.max(0, selection.getMStart()), Math.min(str.length(), selection.getMEnd()))) {
            if (d(str, selection, eVar, mode)) {
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }
}
