package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b\u00a8\u0006\u001c"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {
    private int counter;
    private int currentStartIndex;

    @Nullable
    private IntRange nextItem;
    private int nextSearchIndex;
    private int nextState = -1;
    final /* synthetic */ DelimitedRangesSequence this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        int i3;
        CharSequence charSequence;
        int coerceIn;
        this.this$0 = delimitedRangesSequence;
        i3 = delimitedRangesSequence.startIndex;
        charSequence = delimitedRangesSequence.input;
        coerceIn = RangesKt___RangesKt.coerceIn(i3, 0, charSequence.length());
        this.currentStartIndex = coerceIn;
        this.nextSearchIndex = coerceIn;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r0 < r4) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void calcNext() {
        int i3;
        CharSequence charSequence;
        Function2 function2;
        CharSequence charSequence2;
        IntRange until;
        CharSequence charSequence3;
        int lastIndex;
        CharSequence charSequence4;
        int lastIndex2;
        int i16;
        int i17 = 0;
        if (this.nextSearchIndex >= 0) {
            i3 = this.this$0.limit;
            if (i3 > 0) {
                int i18 = this.counter + 1;
                this.counter = i18;
                i16 = this.this$0.limit;
            }
            int i19 = this.nextSearchIndex;
            charSequence = this.this$0.input;
            if (i19 <= charSequence.length()) {
                function2 = this.this$0.getNextMatch;
                charSequence2 = this.this$0.input;
                Pair pair = (Pair) function2.invoke(charSequence2, Integer.valueOf(this.nextSearchIndex));
                if (pair == null) {
                    int i26 = this.currentStartIndex;
                    charSequence3 = this.this$0.input;
                    lastIndex = StringsKt__StringsKt.getLastIndex(charSequence3);
                    this.nextItem = new IntRange(i26, lastIndex);
                    this.nextSearchIndex = -1;
                } else {
                    int intValue = ((Number) pair.component1()).intValue();
                    int intValue2 = ((Number) pair.component2()).intValue();
                    until = RangesKt___RangesKt.until(this.currentStartIndex, intValue);
                    this.nextItem = until;
                    int i27 = intValue + intValue2;
                    this.currentStartIndex = i27;
                    if (intValue2 == 0) {
                        i17 = 1;
                    }
                    this.nextSearchIndex = i27 + i17;
                }
                this.nextState = 1;
                return;
            }
            int i28 = this.currentStartIndex;
            charSequence4 = this.this$0.input;
            lastIndex2 = StringsKt__StringsKt.getLastIndex(charSequence4);
            this.nextItem = new IntRange(i28, lastIndex2);
            this.nextSearchIndex = -1;
            this.nextState = 1;
            return;
        }
        this.nextState = 0;
        this.nextItem = null;
    }

    public final int getCounter() {
        return this.counter;
    }

    public final int getCurrentStartIndex() {
        return this.currentStartIndex;
    }

    @Nullable
    public final IntRange getNextItem() {
        return this.nextItem;
    }

    public final int getNextSearchIndex() {
        return this.nextSearchIndex;
    }

    public final int getNextState() {
        return this.nextState;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setCounter(int i3) {
        this.counter = i3;
    }

    public final void setCurrentStartIndex(int i3) {
        this.currentStartIndex = i3;
    }

    public final void setNextItem(@Nullable IntRange intRange) {
        this.nextItem = intRange;
    }

    public final void setNextSearchIndex(int i3) {
        this.nextSearchIndex = i3;
    }

    public final void setNextState(int i3) {
        this.nextState = i3;
    }

    @Override // java.util.Iterator
    @NotNull
    public IntRange next() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState != 0) {
            IntRange intRange = this.nextItem;
            Intrinsics.checkNotNull(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.nextItem = null;
            this.nextState = -1;
            return intRange;
        }
        throw new NoSuchElementException();
    }
}
