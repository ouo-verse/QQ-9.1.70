package com.tencent.qqnt.ntrelation.onlinestatusinfo.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "", "a", "", "b", "contacts_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d {
    public static final int a(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        return cVar.y() & 127;
    }

    public static final boolean b(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if ((cVar.y() & 128) > 0) {
            return true;
        }
        return false;
    }
}
