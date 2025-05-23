package kotlin.collections;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0096\u0002\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$1", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", DTConstants.TAG.ELEMENT, "get", "index", "(I)Ljava/lang/Byte;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ArraysKt___ArraysJvmKt$asList$1 extends AbstractList<Byte> implements RandomAccess {
    final /* synthetic */ byte[] $this_asList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArraysKt___ArraysJvmKt$asList$1(byte[] bArr) {
        this.$this_asList = bArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Byte) {
            return contains(((Number) obj).byteValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.$this_asList.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Byte) {
            return indexOf(((Number) obj).byteValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (this.$this_asList.length == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Byte) {
            return lastIndexOf(((Number) obj).byteValue());
        }
        return -1;
    }

    public boolean contains(byte element) {
        boolean contains;
        contains = ArraysKt___ArraysKt.contains(this.$this_asList, element);
        return contains;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    @NotNull
    public Byte get(int index) {
        return Byte.valueOf(this.$this_asList[index]);
    }

    public int indexOf(byte element) {
        int indexOf;
        indexOf = ArraysKt___ArraysKt.indexOf(this.$this_asList, element);
        return indexOf;
    }

    public int lastIndexOf(byte element) {
        int lastIndexOf;
        lastIndexOf = ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, element);
        return lastIndexOf;
    }
}
