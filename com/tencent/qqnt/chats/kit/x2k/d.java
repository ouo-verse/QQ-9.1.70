package com.tencent.qqnt.chats.kit.x2k;

import com.tencent.qqnt.classadapter.SingleLineTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\"(\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"(\u0010\r\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "", "value", "getTextColor_res", "(Lcom/tencent/qqnt/classadapter/SingleLineTextView;)I", "a", "(Lcom/tencent/qqnt/classadapter/SingleLineTextView;I)V", "textColor_res", "", "getTextSize_dp", "(Lcom/tencent/qqnt/classadapter/SingleLineTextView;)F", "b", "(Lcom/tencent/qqnt/classadapter/SingleLineTextView;F)V", "textSize_dp", "chats_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d {
    public static final void a(@NotNull SingleLineTextView singleLineTextView, int i3) {
        Intrinsics.checkNotNullParameter(singleLineTextView, "<this>");
        singleLineTextView.setTextColor(i3);
    }

    public static final void b(@NotNull SingleLineTextView singleLineTextView, float f16) {
        Intrinsics.checkNotNullParameter(singleLineTextView, "<this>");
        singleLineTextView.setTextSize(f16);
    }
}
