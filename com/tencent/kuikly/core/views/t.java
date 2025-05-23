package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.views.internal.GroupAttr;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J+\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0019\u0010\u000e\u001a\u0015\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\b\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/kuikly/core/views/t;", "Lcom/tencent/kuikly/core/views/internal/GroupAttr;", "", "pause", "", "screenFramePause", "Lcom/tencent/kuikly/core/base/h;", "color", "highlightBackgroundColor", "", "src", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/af;", "Lkotlin/ExtensionFunctionType;", "imageAttr", "backgroundImage", "Lcom/tencent/kuikly/core/base/e;", "border", "borderBottom", "borderTop", "borderLeft", "borderRight", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class t extends GroupAttr {
    @Override // com.tencent.kuikly.core.views.internal.GroupAttr
    public void backgroundImage(String src, Function1<? super af, Unit> imageAttr) {
        Intrinsics.checkNotNullParameter(src, "src");
        super.backgroundImage(src, imageAttr);
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupAttr
    public void borderBottom(com.tencent.kuikly.core.base.e border) {
        Intrinsics.checkNotNullParameter(border, "border");
        super.borderBottom(border);
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupAttr
    public void borderLeft(com.tencent.kuikly.core.base.e border) {
        Intrinsics.checkNotNullParameter(border, "border");
        super.borderLeft(border);
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupAttr
    public void borderRight(com.tencent.kuikly.core.base.e border) {
        Intrinsics.checkNotNullParameter(border, "border");
        super.borderRight(border);
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupAttr
    public void borderTop(com.tencent.kuikly.core.base.e border) {
        Intrinsics.checkNotNullParameter(border, "border");
        super.borderTop(border);
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupAttr, com.tencent.kuikly.core.base.m
    public void highlightBackgroundColor(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        super.highlightBackgroundColor(color);
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupAttr
    public void screenFramePause(boolean pause) {
        super.screenFramePause(pause);
    }
}
