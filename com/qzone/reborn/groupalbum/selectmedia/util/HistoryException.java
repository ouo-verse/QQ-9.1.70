package com.qzone.reborn.groupalbum.selectmedia.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/util/HistoryException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class HistoryException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryException(String msg2) {
        super(msg2);
        Intrinsics.checkNotNullParameter(msg2, "msg");
    }
}
