package com.tencent.mobileqq.zplan.widget.impl.control;

import gl3.a;
import gl3.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/widget/impl/control/MediaPlayControlApiImpl;", "Lgl3/a;", "", "K", "", "Lgl3/b;", "b", "Lkotlin/Lazy;", "U0", "()Ljava/util/List;", "mediaPlayEventListenerList", "", "c", "I", "anchorPosition", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MediaPlayControlApiImpl implements a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy mediaPlayEventListenerList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int anchorPosition;

    public MediaPlayControlApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<b>>() { // from class: com.tencent.mobileqq.zplan.widget.impl.control.MediaPlayControlApiImpl$mediaPlayEventListenerList$2
            @Override // kotlin.jvm.functions.Function0
            public final List<b> invoke() {
                return new ArrayList();
            }
        });
        this.mediaPlayEventListenerList = lazy;
        this.anchorPosition = 600;
    }

    private final List<b> U0() {
        return (List) this.mediaPlayEventListenerList.getValue();
    }

    @Override // gl3.a
    public void K() {
        int i3 = Integer.MAX_VALUE;
        b bVar = null;
        for (b bVar2 : U0()) {
            int[] b16 = bVar2.b();
            if (b16.length < 2) {
                return;
            }
            int i16 = b16[1];
            if (Math.abs(i16 - this.anchorPosition) < i3) {
                i3 = Math.abs(i16 - this.anchorPosition);
                bVar = bVar2;
            }
        }
        for (b bVar3 : U0()) {
            if (Intrinsics.areEqual(bVar3, bVar)) {
                bVar3.a();
            } else {
                bVar3.c();
            }
        }
    }
}
