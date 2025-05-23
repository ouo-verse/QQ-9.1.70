package com.qzone.module.feedcomponent;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.module.feedcomponent.ui.AvatarArea;
import com.qzone.module.feedcomponent.ui.SubArea;
import com.qzone.proxy.feedcomponent.model.User;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AvatarAreaView extends View implements SubArea.ViewHost {
    private AvatarArea mAvatarArea;
    private int mAvatarSize;

    public AvatarAreaView(Context context) {
        super(context);
        AvatarArea avatarArea = new AvatarArea();
        this.mAvatarArea = avatarArea;
        avatarArea.setViewHost(this);
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public void invalidateDelayed(long j3) {
        postInvalidateDelayed(j3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mAvatarArea.draw(canvas, null);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17 = this.mAvatarSize;
        setMeasuredDimension(i17, i17);
    }

    public void setSize(int i3) {
        this.mAvatarSize = i3;
        this.mAvatarArea.setAvatarSize(i3);
    }

    public void setUser(User user) {
        this.mAvatarArea.setUser(user, true);
    }

    public AvatarAreaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAvatarArea = new AvatarArea();
    }

    @Override // com.qzone.module.feedcomponent.ui.SubArea.ViewHost
    public View getAttachedView() {
        return this;
    }
}
