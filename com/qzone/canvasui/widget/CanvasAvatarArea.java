package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.qzone.module.feedcomponent.ui.AvatarArea;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.e;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasAvatarArea extends AsyncCanvasImageArea {
    protected static final String UIN = "uin";
    private AvatarArea mAvatarArea;
    private User user;

    public CanvasAvatarArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        int i3;
        AvatarArea avatarArea = new AvatarArea(this);
        this.mAvatarArea = avatarArea;
        if (layoutAttrSet == null || (i3 = layoutAttrSet.width) <= 0) {
            return;
        }
        avatarArea.setAvatarSize(i3);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean clickable() {
        return this.user != null;
    }

    public float getRedPocketAnimParams() {
        return this.mAvatarArea.getRedPocketAnimParams();
    }

    @Override // com.qzone.canvasui.widget.AsyncCanvasImageArea, com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        AvatarArea avatarArea = this.mAvatarArea;
        if (avatarArea != null) {
            avatarArea.draw(canvas, null);
        }
        super.onDraw(canvas);
    }

    @Override // com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onMeasure(int i3, int i16) {
        setMeasuredDimension(this.mAvatarArea.getWidth(), this.mAvatarArea.getHeight());
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean performClick(MotionEvent motionEvent) {
        boolean performClick = super.performClick(motionEvent);
        if (!performClick) {
            DittoHost dittoHost = this.mHost;
            if ((dittoHost instanceof QzoneCanvasAreaView) && ((QzoneCanvasAreaView) dittoHost).onFeedElementClickListener != null) {
                ((QzoneCanvasAreaView) dittoHost).onFeedElementClickListener.onClick((QzoneCanvasAreaView) dittoHost, FeedElement.USER_AVATAR, ((QzoneCanvasAreaView) dittoHost).feedPosition, new e(String.format("%d", Long.valueOf(this.user.uin)), "", ((QzoneCanvasAreaView) this.mHost).feedPosition));
                return true;
            }
        }
        return performClick;
    }

    public void setIsNeedDoRedPocketAnim(boolean z16) {
        this.mAvatarArea.setIsNeedDoRedPocketAnim(z16);
    }

    @Override // com.qzone.canvasui.widget.AsyncCanvasImageArea, com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void setLayoutAttr(LayoutAttrSet layoutAttrSet) {
        super.setLayoutAttr(layoutAttrSet);
        int i3 = layoutAttrSet.width;
        if (i3 > 0) {
            this.mAvatarArea.setAvatarSize(i3);
        }
        if (layoutAttrSet.hasAttr("uin")) {
            long attr = layoutAttrSet.getAttr("uin", 0L);
            User user = new User();
            user.uin = attr;
            setUser(user);
        }
    }

    public void setRedPocketAnimParams(float f16) {
        this.mAvatarArea.setRedPocketAnimParams(f16);
    }

    public void setUser(User user) {
        this.user = user;
        this.mAvatarArea.setUser(user, true);
    }

    public void setUser(User user, boolean z16) {
        this.user = user;
        this.mAvatarArea.setUser(user, true, z16);
    }
}
