package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormSwitchItem;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RoundFormSwitchItem extends FormSwitchItem {
    public RoundFormSwitchItem(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.FormSwitchItem, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundDrawable(getResources().getDrawable(R.drawable.guild_setting_round_rect_8_normal_white));
    }

    public RoundFormSwitchItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
