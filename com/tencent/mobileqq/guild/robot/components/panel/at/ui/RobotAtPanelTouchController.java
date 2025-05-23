package com.tencent.mobileqq.guild.robot.components.panel.at.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.guild.aio.input.at.quickAt.ui.AtPanelTouchController;

/* loaded from: classes14.dex */
public class RobotAtPanelTouchController extends AtPanelTouchController {
    private boolean P;

    public RobotAtPanelTouchController(@NonNull Context context) {
        super(context);
        this.P = false;
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.ui.AtPanelTouchController, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.P && motionEvent.getAction() == 2) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int j() {
        return this.f111018i;
    }

    public void setIsFixedView(boolean z16) {
        this.P = z16;
    }

    public RobotAtPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.P = false;
    }

    public RobotAtPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.P = false;
    }
}
