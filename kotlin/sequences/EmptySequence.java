package kotlin.sequences;

import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.EmptyIterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0096\u0002J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"Lkotlin/sequences/EmptySequence;", "Lkotlin/sequences/Sequence;", "", "Lkotlin/sequences/DropTakeSequence;", "()V", "drop", DomainData.DOMAIN_NAME, "", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
final class EmptySequence implements Sequence, DropTakeSequence {

    @NotNull
    public static final EmptySequence INSTANCE = new EmptySequence();

    EmptySequence() {
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public EmptySequence drop(int n3) {
        return INSTANCE;
    }

    @Override // kotlin.sequences.DropTakeSequence
    @NotNull
    public EmptySequence take(int n3) {
        return INSTANCE;
    }
}
