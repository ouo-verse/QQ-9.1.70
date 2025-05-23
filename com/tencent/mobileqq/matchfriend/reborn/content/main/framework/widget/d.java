package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/c;", "", "position", "b", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(c cVar, int i3) {
        View findViewByPosition = cVar.findViewByPosition(i3);
        if (findViewByPosition == null) {
            return 0;
        }
        int measuredHeight = findViewByPosition.getMeasuredHeight() + 0;
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        RecyclerView.LayoutParams layoutParams2 = layoutParams instanceof RecyclerView.LayoutParams ? (RecyclerView.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            measuredHeight += ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
        }
        return measuredHeight;
    }
}
