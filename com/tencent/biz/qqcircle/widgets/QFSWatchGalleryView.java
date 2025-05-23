package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.compat.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSWatchGalleryView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private static final int f93470d = ImmersiveUtils.dpToPx(12.0f);

    public QFSWatchGalleryView(Context context) {
        super(context);
    }

    private void a() {
        int width = getWidth();
        setTranslationX((((bz.i(getContext()) - width) / 2) - getLeft()) - f93470d);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        a();
    }

    public QFSWatchGalleryView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSWatchGalleryView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
