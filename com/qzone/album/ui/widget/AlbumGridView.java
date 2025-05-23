package com.qzone.album.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.tencent.commonsdk.util.notification.NotificationUtil;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumGridView extends GridView {
    public AlbumGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlbumGridView(Context context) {
        super(context);
    }

    public AlbumGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END, Integer.MIN_VALUE));
    }
}
