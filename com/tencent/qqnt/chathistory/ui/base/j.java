package com.tencent.qqnt.chathistory.ui.base;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0000H\u0000\u001a\u001c\u0010\b\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0000\"\u0018\u0010\f\u001a\u00020\t*\u00020\u00008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0018\u0010\u0006\u001a\u00020\u0005*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0018\u0010\u0007\u001a\u00020\u0005*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000e\"\u0018\u0010\u0011\u001a\u00020\u0005*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/i;", "other", "", "g", "e", "", "year", "month", "f", "Ljava/util/Calendar;", "a", "(Lcom/tencent/qqnt/chathistory/ui/base/i;)Ljava/util/Calendar;", QQPermissionConstants.Permission.CALENDAR_GROUP, "d", "(Lcom/tencent/qqnt/chathistory/ui/base/i;)I", "c", "b", "day", "chathistory_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class j {
    private static final Calendar a(i iVar) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(iVar.a() * 1000));
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  \u2026te(msgTime * 1000L)\n    }");
        return calendar;
    }

    public static final int b(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return a(iVar).get(5);
    }

    public static final int c(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return a(iVar).get(2) + 1;
    }

    public static final int d(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return a(iVar).get(1);
    }

    public static final boolean e(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        Calendar calendar = Calendar.getInstance();
        if (d(iVar) == calendar.get(1) && a(iVar).get(2) == calendar.get(2) && a(iVar).get(4) == calendar.get(4)) {
            return true;
        }
        return false;
    }

    public static final boolean f(@NotNull i iVar, int i3, int i16) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        if (d(iVar) == i3 && c(iVar) == i16) {
            return true;
        }
        return false;
    }

    public static final boolean g(@NotNull i iVar, @Nullable i iVar2) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        if (iVar2 == null || d(iVar) != d(iVar2) || c(iVar) != c(iVar2) || b(iVar) != b(iVar2)) {
            return false;
        }
        return true;
    }
}
