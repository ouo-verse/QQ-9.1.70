package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.event.PanGestureParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR?\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR?\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR?\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/kuikly/core/views/bq;", "Lcom/tencent/kuikly/core/base/l;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "a", "Lkotlin/jvm/functions/Function1;", "j", "()Lkotlin/jvm/functions/Function1;", "setProgressDidChangedHandlerFn$core_release", "(Lkotlin/jvm/functions/Function1;)V", "progressDidChangedHandlerFn", "Lcom/tencent/kuikly/core/base/event/h;", "params", "b", tl.h.F, "setBeginDragSliderHandlerFn$core_release", "beginDragSliderHandlerFn", "c", "i", "setEndDragSliderHandlerFn$core_release", "endDragSliderHandlerFn", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class bq extends com.tencent.kuikly.core.base.l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Float, Unit> progressDidChangedHandlerFn;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super PanGestureParams, Unit> beginDragSliderHandlerFn;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function1<? super PanGestureParams, Unit> endDragSliderHandlerFn;

    public final Function1<PanGestureParams, Unit> h() {
        return this.beginDragSliderHandlerFn;
    }

    public final Function1<PanGestureParams, Unit> i() {
        return this.endDragSliderHandlerFn;
    }

    public final Function1<Float, Unit> j() {
        return this.progressDidChangedHandlerFn;
    }
}
