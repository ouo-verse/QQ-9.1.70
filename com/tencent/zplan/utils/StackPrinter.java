package com.tencent.zplan.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/zplan/utils/StackPrinter;", "Ljava/lang/Exception;", "message", "", "(Ljava/lang/String;)V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class StackPrinter extends Exception {
    public StackPrinter(@Nullable String str) {
        super("\u8fd9\u4e0d\u662f\u5f02\u5e38, " + str + " stack: ");
    }
}
