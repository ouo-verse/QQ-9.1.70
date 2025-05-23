package com.tencent.mobileqq.unusedcodecheck.dexparse;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0004J\b\u0010\u0014\u001a\u00020\u000fH\u0016R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/dexparse/b;", "Ljava/io/Closeable;", "", "stringDataOffset", "", "a", "classIndex", "classStartOffset", "b", "typeIndex", "typeStartOffset", "d", "stringIndex", "stringStartOffset", "c", "", "g", "", "e", h.F, "close", "", "Ljava/util/List;", "sortedClassStringDataOffsets", "I", "index", "Lcom/tencent/mobileqq/unusedcodecheck/dexparse/c;", "f", "Lcom/tencent/mobileqq/unusedcodecheck/dexparse/c;", "byteReader", "<init>", "(Lcom/tencent/mobileqq/unusedcodecheck/dexparse/c;)V", "dexparse"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class b implements Closeable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<Integer> sortedClassStringDataOffsets;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int index;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final c byteReader;

    public b(@NotNull c byteReader) {
        Intrinsics.checkNotNullParameter(byteReader, "byteReader");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) byteReader);
        } else {
            this.byteReader = byteReader;
        }
    }

    private final String a(int stringDataOffset) {
        String c16 = this.byteReader.c(false, stringDataOffset);
        Intrinsics.checkNotNullExpressionValue(c16, "byteReader.readString(false, stringDataOffset)");
        return c16;
    }

    private final int b(int classIndex, int classStartOffset) throws DexParseException {
        return this.byteReader.b(classStartOffset + (classIndex * 32) + 0);
    }

    private final int c(int stringIndex, int stringStartOffset) throws DexParseException {
        return this.byteReader.b(stringStartOffset + (stringIndex * 4));
    }

    private final int d(int typeIndex, int typeStartOffset) throws DexParseException {
        return this.byteReader.b(typeStartOffset + (typeIndex * 4));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.byteReader.close();
        }
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        int i3 = this.index;
        List<Integer> list = this.sortedClassStringDataOffsets;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortedClassStringDataOffsets");
        }
        if (i3 < list.size()) {
            return true;
        }
        return false;
    }

    public final void g() throws DexParseException {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List<Integer> mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        int b16 = this.byteReader.b(60);
        int b17 = this.byteReader.b(68);
        int b18 = this.byteReader.b(96);
        int b19 = this.byteReader.b(100);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < b18; i3++) {
            arrayList.add(Integer.valueOf(b(i3, b19)));
        }
        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(d(((Number) it.next()).intValue(), b17)));
        }
        CollectionsKt___CollectionsKt.sorted(arrayList2);
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            arrayList3.add(Integer.valueOf(c(((Number) it5.next()).intValue(), b16)));
        }
        CollectionsKt___CollectionsKt.sorted(arrayList3);
        Unit unit = Unit.INSTANCE;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        this.sortedClassStringDataOffsets = mutableList;
    }

    @NotNull
    public final String h() throws DexParseException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        List<Integer> list = this.sortedClassStringDataOffsets;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortedClassStringDataOffsets");
        }
        int i3 = this.index;
        this.index = i3 + 1;
        return a(list.get(i3).intValue());
    }
}
