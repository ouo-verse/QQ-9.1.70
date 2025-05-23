package com.tencent.aio.data.msglist;

import com.tencent.aio.exception.AIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/aio/data/msglist/a;", "", "b", "viewType", "subViewType", "a", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    public static final int a(int i3, int i16) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = true;
        if (i3 > 65535) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (i3 < 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (i16 > 65535) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    if (i16 >= 0) {
                        z19 = false;
                    }
                    if (z19) {
                        com.tencent.aio.base.log.a.f69187b.e("assembleViewType", "getSubViewType can not low 0");
                    }
                    return i3 | (i16 << 16);
                }
                throw new AIOException("getSubViewType can not high 65535");
            }
            throw new AIOException("getViewType can not low 0");
        }
        throw new AIOException("getViewType can not high 65535");
    }

    public static final int b(@NotNull a getViewHolderType) {
        Intrinsics.checkNotNullParameter(getViewHolderType, "$this$getViewHolderType");
        int viewType = getViewHolderType.getViewType();
        return a(viewType, getViewHolderType.getSubViewType(viewType));
    }
}
