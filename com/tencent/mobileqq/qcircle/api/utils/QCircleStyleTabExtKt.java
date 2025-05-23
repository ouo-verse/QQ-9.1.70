package com.tencent.mobileqq.qcircle.api.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleCounterMsg$RedDisplayInfo;
import qqcircle.QQCircleCounterStyle$StyleBubble;
import qqcircle.QQCircleCounterStyle$StyleTabButton;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0012\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"TAG", "", "isSameBubbleContent", "", "Lqqcircle/QQCircleCounterStyle$StyleBubble;", "preBubble", "isSameTabAvatar", "Lqqcircle/QQCircleCounterStyle$StyleTabButton;", "other", "qcircle-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCircleStyleTabExtKt {

    @NotNull
    private static final String TAG = "QCircleStyleTabExt";

    public static final boolean isSameBubbleContent(@NotNull QQCircleCounterStyle$StyleBubble qQCircleCounterStyle$StyleBubble, @NotNull QQCircleCounterStyle$StyleBubble preBubble) {
        Intrinsics.checkNotNullParameter(qQCircleCounterStyle$StyleBubble, "<this>");
        Intrinsics.checkNotNullParameter(preBubble, "preBubble");
        String str = qQCircleCounterStyle$StyleBubble.f429298id.get();
        String str2 = preBubble.f429298id.get();
        boolean areEqual = Intrinsics.areEqual(str, str2);
        if (!areEqual) {
            QLog.i(TAG, 1, "is not same Bubble, currentId = " + str + ", preId = " + str2);
        }
        return areEqual;
    }

    public static final boolean isSameTabAvatar(@NotNull QQCircleCounterStyle$StyleTabButton qQCircleCounterStyle$StyleTabButton, @NotNull QQCircleCounterStyle$StyleTabButton other) {
        boolean z16;
        Intrinsics.checkNotNullParameter(qQCircleCounterStyle$StyleTabButton, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!qQCircleCounterStyle$StyleTabButton.has() && !other.has()) {
            return true;
        }
        List<QQCircleCounterMsg$RedDisplayInfo> list = qQCircleCounterStyle$StyleTabButton.icons.get();
        List<QQCircleCounterMsg$RedDisplayInfo> list2 = other.icons.get();
        if (list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (Intrinsics.areEqual(list.get(i3).avatarURL.get(), list2.get(i3).avatarURL.get()) && Intrinsics.areEqual(list.get(i3).headImg.get(), list2.get(i3).headImg.get())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
        }
        return true;
    }
}
