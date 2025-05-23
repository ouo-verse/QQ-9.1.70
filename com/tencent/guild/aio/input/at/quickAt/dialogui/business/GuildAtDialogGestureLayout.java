package com.tencent.guild.aio.input.at.quickAt.dialogui.business;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GuildAtDialogGestureLayout extends GuildDialogGestureLayout {
    private int L;

    public GuildAtDialogGestureLayout(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout
    public void q() {
        super.q();
        this.L = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity() * 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout
    public boolean x(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        this.G.computeCurrentVelocity(1000);
        float yVelocity = this.G.getYVelocity();
        float height = getHeight() / 6.0f;
        if (yVelocity > 0.0f && yVelocity > this.L) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (motionEvent.getY() - this.C > height) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("GuildAtDialogGestureLayout", 4, "currentVelocityY: " + yVelocity + " velocity threshold: " + this.L + " minFlingDistance: " + height);
        }
        if ((!z16 || !z17) && super.x(motionEvent)) {
            return true;
        }
        return false;
    }

    public GuildAtDialogGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuildAtDialogGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
