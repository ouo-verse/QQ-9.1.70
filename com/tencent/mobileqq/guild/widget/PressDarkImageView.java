package com.tencent.mobileqq.guild.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.avcore.jni.codec.HWColorFormat;

@TargetApi(14)
/* loaded from: classes14.dex */
public class PressDarkImageView extends GuildUserAvatarView {
    public PressDarkImageView(Context context) {
        this(context, null, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (isPressed()) {
            super.setColorFilter(HWColorFormat.COLOR_FormatVendorStartUnused);
        } else {
            e();
        }
    }

    public void e() {
        super.clearColorFilter();
    }

    public PressDarkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressDarkImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
