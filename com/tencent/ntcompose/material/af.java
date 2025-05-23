package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001BI\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0001\u00a2\u0006\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ntcompose/material/af;", "", "", NodeProps.ENABLED, "checked", "Landroidx/compose/runtime/State;", "Lcom/tencent/kuikly/core/base/h;", "a", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "b", "Lcom/tencent/kuikly/core/base/h;", "checkedThumbColor", "uncheckedThumbColor", "c", "checkedTrackColor", "d", "uncheckedTrackColor", "e", "disabledCheckedThumbColor", "f", "disabledUncheckedThumbColor", "g", "disabledCheckedTrackColor", tl.h.F, "disabledUncheckedTrackColor", "<init>", "(Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.base.h checkedThumbColor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.base.h uncheckedThumbColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.base.h checkedTrackColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.base.h uncheckedTrackColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.base.h disabledCheckedThumbColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.base.h disabledUncheckedThumbColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.base.h disabledCheckedTrackColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.base.h disabledUncheckedTrackColor;

    public af(com.tencent.kuikly.core.base.h checkedThumbColor, com.tencent.kuikly.core.base.h uncheckedThumbColor, com.tencent.kuikly.core.base.h checkedTrackColor, com.tencent.kuikly.core.base.h uncheckedTrackColor, com.tencent.kuikly.core.base.h disabledCheckedThumbColor, com.tencent.kuikly.core.base.h disabledUncheckedThumbColor, com.tencent.kuikly.core.base.h disabledCheckedTrackColor, com.tencent.kuikly.core.base.h disabledUncheckedTrackColor) {
        Intrinsics.checkNotNullParameter(checkedThumbColor, "checkedThumbColor");
        Intrinsics.checkNotNullParameter(uncheckedThumbColor, "uncheckedThumbColor");
        Intrinsics.checkNotNullParameter(checkedTrackColor, "checkedTrackColor");
        Intrinsics.checkNotNullParameter(uncheckedTrackColor, "uncheckedTrackColor");
        Intrinsics.checkNotNullParameter(disabledCheckedThumbColor, "disabledCheckedThumbColor");
        Intrinsics.checkNotNullParameter(disabledUncheckedThumbColor, "disabledUncheckedThumbColor");
        Intrinsics.checkNotNullParameter(disabledCheckedTrackColor, "disabledCheckedTrackColor");
        Intrinsics.checkNotNullParameter(disabledUncheckedTrackColor, "disabledUncheckedTrackColor");
        this.checkedThumbColor = checkedThumbColor;
        this.uncheckedThumbColor = uncheckedThumbColor;
        this.checkedTrackColor = checkedTrackColor;
        this.uncheckedTrackColor = uncheckedTrackColor;
        this.disabledCheckedThumbColor = disabledCheckedThumbColor;
        this.disabledUncheckedThumbColor = disabledUncheckedThumbColor;
        this.disabledCheckedTrackColor = disabledCheckedTrackColor;
        this.disabledUncheckedTrackColor = disabledUncheckedTrackColor;
    }

    public final State<com.tencent.kuikly.core.base.h> a(boolean z16, boolean z17, Composer composer, int i3) {
        com.tencent.kuikly.core.base.h hVar;
        composer.startReplaceableGroup(1629180635);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1629180635, i3, -1, "com.tencent.ntcompose.material.SwitchColors.thumbColor (Switch.kt:181)");
        }
        if (z16) {
            if (z17) {
                hVar = this.checkedThumbColor;
            } else {
                hVar = this.uncheckedThumbColor;
            }
        } else if (z17) {
            hVar = this.disabledCheckedThumbColor;
        } else {
            hVar = this.disabledUncheckedThumbColor;
        }
        State<com.tencent.kuikly.core.base.h> a16 = AnimateAsStateKt.a(hVar, null, null, composer, 8, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return a16;
    }

    public final State<com.tencent.kuikly.core.base.h> b(boolean z16, boolean z17, Composer composer, int i3) {
        com.tencent.kuikly.core.base.h hVar;
        composer.startReplaceableGroup(363222608);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(363222608, i3, -1, "com.tencent.ntcompose.material.SwitchColors.trackColor (Switch.kt:200)");
        }
        if (z16) {
            if (z17) {
                hVar = this.checkedTrackColor;
            } else {
                hVar = this.uncheckedTrackColor;
            }
        } else if (z17) {
            hVar = this.disabledCheckedTrackColor;
        } else {
            hVar = this.disabledUncheckedTrackColor;
        }
        State<com.tencent.kuikly.core.base.h> a16 = AnimateAsStateKt.a(hVar, null, null, composer, 8, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return a16;
    }
}
