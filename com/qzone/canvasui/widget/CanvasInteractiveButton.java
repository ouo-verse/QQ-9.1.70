package com.qzone.canvasui.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.reflect.DittoValue;
import com.tencent.ditto.reflect.MustacheParser;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.qzone.zipanimate.OnAnimationListener;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasInteractiveButton extends AsyncCanvasImageArea implements OnAnimationListener, Drawable.Callback {
    private static final String ANIMATION_FLAG_KEY_PATH = "animation_flag_key_path";
    private static final String ANIMATION_REPLAYABLE = "animation_replayable";
    private static final String FRAME_ANIMATION_URL = "frame_animation_url";
    private static final String FRAME_RATE = "frame_rate";
    private static final String POST_CLICK_IMG_URL = "post_click_img_url";
    private static final String PRE_CLICK_IMG_URL = "pre_click_img_url";
    private static final String SCALE = "scale";
    private Drawable animationDrawable;
    private DittoValue animationFlag;
    private boolean animationReplayable;
    private String frameAnimationUrl;
    private int frameRate;
    private String postClickImageUrl;
    private String preClickImageUrl;
    private float scale;

    public CanvasInteractiveButton(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
        this.scale = 1.0f;
        this.frameRate = 20;
        this.animationReplayable = false;
        processLayoutAttr();
    }

    private void processLayoutAttr() {
        LayoutAttrSet layoutAttrSet = this.mLayoutAttr;
        if (layoutAttrSet == null) {
            return;
        }
        if (layoutAttrSet.hasAttr(FRAME_ANIMATION_URL)) {
            setFrameAnimationUrl(this.mLayoutAttr.getAttr(FRAME_ANIMATION_URL, (String) null));
        }
        if (this.mLayoutAttr.hasAttr(PRE_CLICK_IMG_URL)) {
            setPreClickImageUrl(this.mLayoutAttr.getAttr(PRE_CLICK_IMG_URL, (String) null));
        }
        if (this.mLayoutAttr.hasAttr(ANIMATION_FLAG_KEY_PATH)) {
            setAnimationFlag(MustacheParser.parse(this.mLayoutAttr.getAttr(ANIMATION_FLAG_KEY_PATH, "")));
        }
        if (this.mLayoutAttr.hasAttr(POST_CLICK_IMG_URL)) {
            setPostClickImageUrl(this.mLayoutAttr.getAttr(POST_CLICK_IMG_URL, (String) null));
        }
        if (this.mLayoutAttr.hasAttr("scale")) {
            setScale(this.mLayoutAttr.getAttr("scale", 0.0f));
        }
        if (this.mLayoutAttr.hasAttr("frame_rate")) {
            setFrameRate(this.mLayoutAttr.getAttr("frame_rate", 20));
        }
        if (this.mLayoutAttr.hasAttr(ANIMATION_REPLAYABLE)) {
            this.animationReplayable = this.mLayoutAttr.getAttr(ANIMATION_REPLAYABLE, false);
        }
        reloadFrameAnimationDrawable();
        updateStatus();
    }

    private void updateStatus() {
        DittoValue dittoValue = this.animationFlag;
        if (dittoValue != null) {
            Object value = dittoValue.getValue(getHost().getCurrentViewModel());
            if ((value instanceof Boolean) && ((Boolean) value).booleanValue()) {
                setAsyncImage(null, this.postClickImageUrl, null, null);
                return;
            }
        }
        setAsyncImage(null, this.preClickImageUrl, null, null);
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean clickable() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    @Override // cooperation.qzone.zipanimate.OnAnimationListener
    public void onAnimationFinished() {
        updateStatus();
        if (this.animationReplayable) {
            reloadFrameAnimationDrawable();
        }
    }

    @Override // com.tencent.ditto.area.DittoArea
    public boolean performClick(MotionEvent motionEvent) {
        Object value = this.animationFlag.getValue(getHost().getCurrentViewModel());
        if (value instanceof Boolean) {
            if (((Boolean) value).booleanValue() && !this.animationReplayable) {
                return true;
            }
            Drawable drawable = this.animationDrawable;
            if (drawable != null) {
                drawable.setCallback(this);
                setImageDrawable(this.animationDrawable);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).restartAnimation(this.animationDrawable);
                this.animationFlag.setValue(getHost().getCurrentViewModel(), true);
            }
            getHost().storageViewModel(false);
            return super.performClick(motionEvent);
        }
        return super.performClick(motionEvent);
    }

    public void reloadFrameAnimationDrawable() {
        if (this.animationDrawable != null && ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getAnimationResZipUrl(this.animationDrawable).equals(this.frameAnimationUrl)) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).preLoadFrame(this.animationDrawable, 0);
            return;
        }
        if (!TextUtils.isEmpty(this.frameAnimationUrl)) {
            this.animationDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable(this.frameAnimationUrl, this.frameRate);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationListener(this.animationDrawable, this);
            this.animationDrawable.setCallback(this);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.animationDrawable, this.scale);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setPreloadNum(this.animationDrawable, 5);
            return;
        }
        if (this.animationDrawable != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationListener(this.animationDrawable, null);
            this.animationDrawable.setCallback(null);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.animationDrawable);
            this.animationDrawable = null;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        if (getHost() instanceof View) {
            ((View) getHost()).scheduleDrawable(drawable, runnable, j3);
        }
    }

    public void setAnimationDrawable(Drawable drawable) {
        this.animationDrawable = drawable;
    }

    public void setAnimationFlag(DittoValue dittoValue) {
        this.animationFlag = dittoValue;
    }

    public void setFrameAnimationUrl(String str) {
        this.frameAnimationUrl = str;
    }

    public void setFrameRate(int i3) {
        this.frameRate = i3;
    }

    @Override // com.qzone.canvasui.widget.AsyncCanvasImageArea, com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void setLayoutAttr(LayoutAttrSet layoutAttrSet) {
        super.setLayoutAttr(layoutAttrSet);
        processLayoutAttr();
    }

    public void setPostClickImageUrl(String str) {
        this.postClickImageUrl = str;
    }

    public void setPreClickImageUrl(String str) {
        this.preClickImageUrl = str;
    }

    public void setScale(float f16) {
        this.scale = f16;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (getHost() instanceof View) {
            ((View) getHost()).unscheduleDrawable(drawable, runnable);
        }
    }

    @Override // cooperation.qzone.zipanimate.OnAnimationListener
    public void onDrawableLoaded() {
    }
}
