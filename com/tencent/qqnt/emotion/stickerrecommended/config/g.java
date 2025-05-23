package com.tencent.qqnt.emotion.stickerrecommended.config;

import com.tencent.qqnt.emotion.stickerrecommended.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/config/e;", "", "idx", "Lcom/tencent/qqnt/emotion/stickerrecommended/o;", "a", "emotion_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g {
    @NotNull
    public static final o a(@NotNull e eVar, int i3) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        o oVar = new o();
        oVar.N(i3);
        oVar.M(eVar.d());
        oVar.J(eVar.a());
        oVar.K(eVar.b());
        oVar.L(eVar.c());
        return oVar;
    }

    public static /* synthetic */ o b(e eVar, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = -1;
        }
        return a(eVar, i3);
    }
}
