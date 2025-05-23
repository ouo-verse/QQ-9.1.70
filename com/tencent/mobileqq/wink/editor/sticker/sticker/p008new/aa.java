package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/google/android/material/tabs/TabLayout$g;", "", "selected", "", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class aa {
    public static final void a(@NotNull TabLayout.g gVar, boolean z16) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        int childCount = gVar.f34288i.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = gVar.f34288i.getChildAt(i3);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (z16) {
                    typeface = Typeface.DEFAULT_BOLD;
                } else {
                    typeface = Typeface.DEFAULT;
                }
                textView.setTypeface(typeface);
                return;
            }
        }
    }
}
