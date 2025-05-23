package com.tencent.ntcompose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J_\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ntcompose/material/ag;", "", "Lcom/tencent/kuikly/core/base/h;", "checkedThumbColor", "uncheckedThumbColor", "checkedTrackColor", "uncheckedTrackColor", "disabledCheckedThumbColor", "disabledUncheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedTrackColor", "Lcom/tencent/ntcompose/material/af;", "a", "(Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Lcom/tencent/kuikly/core/base/h;Landroidx/compose/runtime/Composer;II)Lcom/tencent/ntcompose/material/af;", "", "b", UserInfo.SEX_FEMALE, "c", "()F", "defaultTrackWidth", "defaultTrackHeight", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    public static final ag f339378a = new ag();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final float defaultTrackWidth = 51;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final float defaultTrackHeight = 31;

    ag() {
    }

    public final af a(com.tencent.kuikly.core.base.h hVar, com.tencent.kuikly.core.base.h hVar2, com.tencent.kuikly.core.base.h hVar3, com.tencent.kuikly.core.base.h hVar4, com.tencent.kuikly.core.base.h hVar5, com.tencent.kuikly.core.base.h hVar6, com.tencent.kuikly.core.base.h hVar7, com.tencent.kuikly.core.base.h hVar8, Composer composer, int i3, int i16) {
        composer.startReplaceableGroup(1462444937);
        com.tencent.kuikly.core.base.h n3 = (i16 & 1) != 0 ? com.tencent.kuikly.core.base.h.INSTANCE.n() : hVar;
        com.tencent.kuikly.core.base.h n16 = (i16 & 2) != 0 ? com.tencent.kuikly.core.base.h.INSTANCE.n() : hVar2;
        com.tencent.kuikly.core.base.h h16 = (i16 & 4) != 0 ? com.tencent.kuikly.core.base.h.INSTANCE.h() : hVar3;
        com.tencent.kuikly.core.base.h e16 = (i16 & 8) != 0 ? com.tencent.kuikly.core.base.h.INSTANCE.e() : hVar4;
        com.tencent.kuikly.core.base.h n17 = (i16 & 16) != 0 ? com.tencent.kuikly.core.base.h.INSTANCE.n() : hVar5;
        com.tencent.kuikly.core.base.h n18 = (i16 & 32) != 0 ? com.tencent.kuikly.core.base.h.INSTANCE.n() : hVar6;
        com.tencent.kuikly.core.base.h h17 = (i16 & 64) != 0 ? com.tencent.kuikly.core.base.h.INSTANCE.h() : hVar7;
        com.tencent.kuikly.core.base.h e17 = (i16 & 128) != 0 ? com.tencent.kuikly.core.base.h.INSTANCE.e() : hVar8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1462444937, i3, -1, "com.tencent.ntcompose.material.SwitchDefaults.colors (Switch.kt:135)");
        }
        af afVar = new af(n3, n16, h16, e16, n17, n18, h17, e17);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return afVar;
    }

    public final float b() {
        return defaultTrackHeight;
    }

    public final float c() {
        return defaultTrackWidth;
    }
}
