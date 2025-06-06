package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lkotlin/jvm/internal/BooleanSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class BooleanSpreadBuilder extends PrimitiveSpreadBuilder<boolean[]> {

    @NotNull
    private final boolean[] values;

    public BooleanSpreadBuilder(int i3) {
        super(i3);
        this.values = new boolean[i3];
    }

    public final void add(boolean value) {
        boolean[] zArr = this.values;
        int position = getPosition();
        setPosition(position + 1);
        zArr[position] = value;
    }

    @NotNull
    public final boolean[] toArray() {
        return toArray(this.values, new boolean[size()]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public int getSize(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length;
    }
}
