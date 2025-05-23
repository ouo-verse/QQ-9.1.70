package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.tencent.commonsdk.util.notification.NotificationUtil;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AuthorizeItemListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public int f152626a;

    public AuthorizeItemListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.f152626a <= 5) {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE));
        } else {
            super.onMeasure(i3, i16);
        }
    }

    public AuthorizeItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AuthorizeItemListView(Context context) {
        super(context);
    }
}
