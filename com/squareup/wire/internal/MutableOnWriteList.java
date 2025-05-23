package com.squareup.wire.internal;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\u0013\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u000fH\u0096\u0002\u00a2\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u000fH\u0016\u00a2\u0006\u0002\u0010\u0018J\u001e\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/squareup/wire/internal/MutableOnWriteList;", "T", "Lkotlin/collections/AbstractMutableList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Ljava/io/Serializable;", "Lcom/squareup/wire/internal/Serializable;", "immutableList", "", "(Ljava/util/List;)V", "mutableList", "getMutableList$wire_runtime", "()Ljava/util/List;", "setMutableList$wire_runtime", "size", "", "getSize", "()I", "add", "", "index", DTConstants.TAG.ELEMENT, "(ILjava/lang/Object;)V", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "writeReplace", "", "wire-runtime"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class MutableOnWriteList<T> extends AbstractMutableList<T> implements RandomAccess, Serializable {
    private final List<T> immutableList;

    @NotNull
    private List<? extends T> mutableList;

    /* JADX WARN: Multi-variable type inference failed */
    public MutableOnWriteList(@NotNull List<? extends T> immutableList) {
        Intrinsics.checkNotNullParameter(immutableList, "immutableList");
        this.immutableList = immutableList;
        this.mutableList = immutableList;
    }

    private final Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.mutableList);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, T element) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        List<? extends T> list = this.mutableList;
        if (list != null) {
            ((ArrayList) list).add(index, element);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<T>");
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int index) {
        return this.mutableList.get(index);
    }

    @NotNull
    public final List<T> getMutableList$wire_runtime() {
        return this.mutableList;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.mutableList.size();
    }

    @Override // kotlin.collections.AbstractMutableList
    public T removeAt(int index) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        List<? extends T> list = this.mutableList;
        if (list != null) {
            return (T) ((ArrayList) list).remove(index);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<T>");
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public T set(int index, T element) {
        if (this.mutableList == this.immutableList) {
            this.mutableList = new ArrayList(this.immutableList);
        }
        List<? extends T> list = this.mutableList;
        if (list != null) {
            return (T) ((ArrayList) list).set(index, element);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<T>");
    }

    public final void setMutableList$wire_runtime(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mutableList = list;
    }
}
