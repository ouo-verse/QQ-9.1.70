package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.BubbleImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TroopGiftBubbleView extends BubbleImageView {
    public TroopGiftBubbleView(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.widget.BubbleImageView
    protected void c() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.J = 2;
        }
    }

    public TroopGiftBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TroopGiftBubbleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
