package com.tencent.mobileqq.search.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ThemeFixSizeImageView extends ThemeImageView {
    public ThemeFixSizeImageView(Context context) {
        super(context);
    }

    @Override // com.tencent.widget.ThemeImageView
    protected void init() {
        setSupportMaskView(true);
        setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }

    public ThemeFixSizeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ThemeFixSizeImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
