package com.tencent.mobileqq.guild.setting.qrcode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildSelectableRelativeLayout extends RelativeLayout {
    public GuildSelectableRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (d.a(this)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (d.a(this)) {
            return;
        }
        super.draw(canvas);
    }

    public GuildSelectableRelativeLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuildSelectableRelativeLayout(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
