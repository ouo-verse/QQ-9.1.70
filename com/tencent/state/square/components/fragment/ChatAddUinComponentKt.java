package com.tencent.state.square.components.fragment;

import com.tencent.state.square.MoveItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"addToSquareList", "", "Lcom/tencent/state/square/MoveItem;", "getAddToSquareList", "()Ljava/util/List;", "lastAddNeedLocalTo", "", "getLastAddNeedLocalTo", "()Ljava/lang/String;", "setLastAddNeedLocalTo", "(Ljava/lang/String;)V", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatAddUinComponentKt {
    private static final List<MoveItem> addToSquareList = new ArrayList();
    private static String lastAddNeedLocalTo = "";

    public static final List<MoveItem> getAddToSquareList() {
        return addToSquareList;
    }

    public static final String getLastAddNeedLocalTo() {
        return lastAddNeedLocalTo;
    }

    public static final void setLastAddNeedLocalTo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        lastAddNeedLocalTo = str;
    }
}
