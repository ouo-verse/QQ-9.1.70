package com.tencent.kuikly.core.base;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\rRA\u0010\u001e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u0019\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/kuikly/core/base/c;", "", "Lcom/tencent/kuikly/core/base/b;", "animation", "", "makeDirty", "", "a", "d", "b", "f", "c", "", "Ljava/util/List;", "nextAnimations", "", "I", "animIndex", "Ljava/lang/Integer;", "layoutIndex", "", "curAnimations", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "e", "Lkotlin/jvm/functions/Function1;", "getIndexChangeCallback", "()Lkotlin/jvm/functions/Function1;", "(Lkotlin/jvm/functions/Function1;)V", "indexChangeCallback", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<b> nextAnimations = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int animIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Integer layoutIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<b> curAnimations;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function1<? super b, Unit> indexChangeCallback;

    public c() {
        List<b> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.curAnimations = emptyList;
    }

    public final void a(b animation, boolean makeDirty) {
        b b16;
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.nextAnimations.add(animation);
        if (this.layoutIndex == null && makeDirty) {
            this.layoutIndex = Integer.valueOf(this.animIndex);
        }
        this.animIndex++;
        Function1<? super b, Unit> function1 = this.indexChangeCallback;
        if (function1 == null || (b16 = b()) == null) {
            return;
        }
        function1.invoke(b16);
    }

    public final b b() {
        Object lastOrNull;
        b bVar;
        int lastIndex;
        List<b> list = this.curAnimations;
        int i3 = this.animIndex;
        if (i3 >= 0) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            if (i3 <= lastIndex) {
                bVar = list.get(i3);
                return bVar;
            }
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.curAnimations);
        bVar = (b) lastOrNull;
        return bVar;
    }

    public final b d() {
        Object lastOrNull;
        b bVar;
        int lastIndex;
        List<b> list = this.curAnimations;
        Integer num = this.layoutIndex;
        int intValue = num != null ? num.intValue() : 0;
        if (intValue >= 0) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            if (intValue <= lastIndex) {
                bVar = list.get(intValue);
                return bVar;
            }
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.curAnimations);
        bVar = (b) lastOrNull;
        return bVar;
    }

    public final void e(Function1<? super b, Unit> function1) {
        this.indexChangeCallback = function1;
    }

    public final void f() {
        List<b> list;
        this.animIndex = 0;
        this.layoutIndex = null;
        list = CollectionsKt___CollectionsKt.toList(this.nextAnimations);
        this.curAnimations = list;
        this.nextAnimations.clear();
    }

    public final void c() {
    }
}
