package com.tencent.tavsticker.core;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import me4.a;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGText;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerView extends FrameLayout {
    private String assetPath;
    private Context context;
    private boolean isAutoPlay;
    private PAGView pagView;
    private String path;
    private int repeatCount;

    public TAVStickerView(Context context) {
        this(context, null);
    }

    private void init() {
        if (this.pagView == null) {
            PAGView pAGView = new PAGView(this.context);
            this.pagView = pAGView;
            addView(pAGView);
        }
        if (!TextUtils.isEmpty(this.assetPath)) {
            setStickerAssetPath(this.assetPath);
        } else if (!TextUtils.isEmpty(this.path)) {
            setStickerPath(this.path);
        }
        this.pagView.setRepeatCount(this.repeatCount);
        if (this.isAutoPlay) {
            this.pagView.play();
        }
    }

    public void addListener(Animator.AnimatorListener animatorListener) {
        PAGView pAGView;
        if (animatorListener != null && (pAGView = this.pagView) != null) {
            pAGView.addListener(animatorListener);
        }
    }

    public long duration() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.duration() / 1000;
        }
        return 0L;
    }

    public boolean flush(boolean z16) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.flush(z16);
        }
        return false;
    }

    public PAGFile getPagFile() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.getFile();
        }
        return null;
    }

    public double getProgress() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.getProgress();
            return 0.0d;
        }
        return 0.0d;
    }

    public boolean isPlaying() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.isPlaying();
        }
        return false;
    }

    public float maxFrameRate() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.maxFrameRate();
            return 0.0f;
        }
        return 0.0f;
    }

    public void play(int i3) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setRepeatCount(i3);
            this.pagView.play();
        }
    }

    public void removeListener(Animator.AnimatorListener animatorListener) {
        PAGView pAGView;
        if (animatorListener != null && (pAGView = this.pagView) != null) {
            pAGView.removeListener(animatorListener);
        }
    }

    public void replaceImage(int i3, PAGImage pAGImage) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.replaceImage(i3, pAGImage);
        }
    }

    public void setMaxFrameRate(float f16) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setMaxFrameRate(f16);
        }
    }

    public void setProgress(double d16) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setProgress(d16);
        }
    }

    public void setRepeatCount(int i3) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setRepeatCount(i3);
        }
    }

    public void setStickerAssetPath(String str) {
        PAGView pAGView;
        PAGFile pAGFileFromAsset = TAVPAGFileManager.getInstance().getPAGFileFromAsset(this.context, str);
        if (pAGFileFromAsset != null && (pAGView = this.pagView) != null) {
            pAGView.setFile(pAGFileFromAsset);
        }
    }

    public void setStickerPath(String str) {
        PAGView pAGView;
        PAGFile pAGFileFromPath = TAVPAGFileManager.getInstance().getPAGFileFromPath(str);
        if (pAGFileFromPath != null && (pAGView = this.pagView) != null) {
            pAGView.setFile(pAGFileFromPath);
        }
    }

    public void setTextData(int i3, PAGText pAGText) {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setTextData(i3, pAGText);
        }
    }

    public void stop() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.stop();
        }
    }

    public TAVStickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TAVStickerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.pagView = null;
        this.assetPath = "";
        this.path = "";
        this.repeatCount = 0;
        this.isAutoPlay = false;
        this.context = context;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.N, i3, 0);
        if (obtainStyledAttributes != null) {
            this.assetPath = obtainStyledAttributes.getString(a.Q);
            this.path = obtainStyledAttributes.getString(a.R);
            this.repeatCount = obtainStyledAttributes.getInt(a.P, 0);
            this.isAutoPlay = obtainStyledAttributes.getBoolean(a.O, false);
            obtainStyledAttributes.recycle();
        }
        init();
    }

    public boolean flush() {
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            return pAGView.flush();
        }
        return false;
    }
}
