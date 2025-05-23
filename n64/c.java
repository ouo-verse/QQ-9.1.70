package n64;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n64.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u001a\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u0014\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u001a\u0012\u0010\u000f\u001a\u00020\r*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0010"}, d2 = {"", "keyword", "name", "", "d", "Landroid/content/Context;", "context", "c", "", "Lb74/a;", "itemDataList", "", "a", "", "key", "b", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    @NotNull
    public static final int[] a(@NotNull List<? extends b74.a> itemDataList) {
        int[] intArray;
        Intrinsics.checkNotNullParameter(itemDataList, "itemDataList");
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : itemDataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((b74.a) obj) instanceof e64.b) {
                arrayList.add(Integer.valueOf(i3));
            }
            i3 = i16;
        }
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        return intArray;
    }

    public static final int b(@NotNull int[] iArr, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        boolean z17 = true;
        int length = iArr.length - 1;
        int i16 = 0;
        while (i16 <= length) {
            int i17 = (i16 + length) >>> 1;
            int i18 = iArr[i17];
            if (i18 < i3) {
                i16 = i17 + 1;
            } else if (i18 > i3) {
                length = i17 - 1;
            } else {
                return i17;
            }
        }
        if (i16 >= 0 && i16 < iArr.length) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || i3 <= iArr[i16]) {
            int length2 = iArr.length;
            int i19 = i16 - 1;
            if (i19 < 0 || i19 >= length2) {
                z17 = false;
            }
            if (z17 && i3 > iArr[i19]) {
                return i19;
            }
            return -(i16 + 1);
        }
        return i16;
    }

    @NotNull
    public static final String c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.f223486gc);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026.robot_slash_list_recent)");
        return string;
    }

    public static final boolean d(@Nullable String str, @Nullable String str2) {
        try {
            if (a.c(str, str2, 0, 1, 31, new a.b()) != null) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e16) {
            QLog.e("SlashToolUtils", 1, e16, new Object[0]);
            return false;
        }
    }
}
