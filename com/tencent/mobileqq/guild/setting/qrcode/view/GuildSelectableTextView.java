package com.tencent.mobileqq.guild.setting.qrcode.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes14.dex */
public class GuildSelectableTextView extends TextView {
    public GuildSelectableTextView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (d.a(this)) {
            return;
        }
        super.draw(canvas);
    }

    public GuildSelectableTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuildSelectableTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
