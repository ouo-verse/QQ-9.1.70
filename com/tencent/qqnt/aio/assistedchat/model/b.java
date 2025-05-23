package com.tencent.qqnt.aio.assistedchat.model;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\"\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0015\u0010\b\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/model/a;", "", "c", "", "b", "(Lcom/tencent/qqnt/aio/assistedchat/model/a;)I", "textColor", "a", "backgroundColor", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    public static final int a(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return ColorUtils.setAlphaComponent(b(aVar), 26);
    }

    public static final int b(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return Color.rgb((int) ((aVar.a() >> 16) & 255), (int) ((aVar.a() >> 8) & 255), (int) (255 & aVar.a()));
    }

    public static final boolean c(@Nullable a aVar) {
        boolean z16;
        boolean z17;
        if (aVar == null) {
            return false;
        }
        if (aVar.d().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (aVar.b().length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return false;
        }
        return true;
    }
}
