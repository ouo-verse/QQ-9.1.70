package o82;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAItem;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lo82/d;", "Lo82/a;", "", "startTimeStr", "endTimeStr", "", "b", "timeStr", "Lkotlin/Pair;", "", "c", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d implements a {
    private final boolean b(String startTimeStr, String endTimeStr) {
        Pair<Integer, Integer> c16;
        Pair<Integer, Integer> c17 = c(startTimeStr);
        if (c17 == null || (c16 = c(endTimeStr)) == null) {
            return false;
        }
        int intValue = (c17.getFirst().intValue() * 60) + c17.getSecond().intValue();
        int intValue2 = (c16.getFirst().intValue() * 60) + c16.getSecond().intValue();
        Calendar calendar = Calendar.getInstance();
        int i3 = (calendar.get(11) * 60) + calendar.get(12);
        if (intValue2 < intValue) {
            if (i3 < intValue && i3 > intValue2) {
                return false;
            }
        } else if (intValue > i3 || i3 > intValue2) {
            return false;
        }
        return true;
    }

    private final Pair<Integer, Integer> c(String timeStr) {
        List split$default;
        Integer intOrNull;
        Integer intOrNull2;
        split$default = StringsKt__StringsKt.split$default((CharSequence) timeStr, new String[]{":"}, false, 0, 6, (Object) null);
        if (split$default.size() != 2) {
            return null;
        }
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(0));
        intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(1));
        if (intOrNull == null || intOrNull2 == null) {
            return null;
        }
        return new Pair<>(intOrNull, intOrNull2);
    }

    @Override // o82.a
    public boolean a(QQStrangerLIAItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getStartTime().length() > 0) {
            if (item.getEndTime().length() > 0) {
                return !b(item.getStartTime(), item.getEndTime());
            }
        }
        return false;
    }
}
