package com.tencent.mobileqq.guild.rolegroup.adapters.extra;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRoleGroupGridEditText extends EditText {
    public GuildRoleGroupGridEditText(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public GuildRoleGroupGridEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuildRoleGroupGridEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
