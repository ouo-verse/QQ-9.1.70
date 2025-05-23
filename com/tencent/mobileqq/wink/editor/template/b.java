package com.tencent.mobileqq.wink.editor.template;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "", "a", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "openSingleImageSmartClip", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {
    public static final boolean a(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (com.tencent.mobileqq.wink.editor.c.N(metaMaterial, "openSingleImageSmartClip") == 1) {
            return true;
        }
        return false;
    }
}
