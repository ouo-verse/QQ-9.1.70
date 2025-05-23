package com.tencent.ams.fusion.widget.insideslideinteractive;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class HolderGuideLayer extends GroupLayer {
    static IPatchRedirector $redirector_ = null;
    private static final int ARROW_HEIGHT = 32;
    private static final int ARROW_WIDTH = 16;
    private static final int BACKGROUND_HEIGHT = 56;
    private static final int GUIDE_TEXT_MAX_SIZE = 12;
    private static final String LEFT_ARROW_NAME = "insideslide/ic_arrow_left.png";
    private static final int MARGIN = 24;
    private static final int PADDING_LEFT = 24;
    private static final int PADDING_RIGHT = 32;
    private static final String RIGHT_ARROW_NAME = "insideslide/ic_arrow_right.png";
    private static final String TAG = "HolderGuideLayer";
    private static final int TEXT_MARGIN = 12;
    private BitmapLayer mArrowLayer1;
    private BitmapLayer mArrowLayer2;
    private int mBackgroundColor;
    private PathShapeLayer mBackgroundLayer;
    private Context mContext;
    private String mGuideText;
    private TextLayer mGuideTextLayer;

    @SlideGestureViewHelper.SlideDirection
    private int mSlideDirection;
    private int mTextColor;
    private float mTextSizeDp;

    public HolderGuideLayer(Context context) {
        super(new AnimatorLayer[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mSlideDirection = 1;
        this.mBackgroundColor = Color.parseColor("#99000000");
        this.mTextColor = Color.parseColor("#FFFFFF");
        this.mTextSizeDp = 12.0f;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createArrowAnimator() {
        AlphaAnimator alphaAnimator = new AlphaAnimator(this.mArrowLayer1, 1.0f, 0.4f);
        alphaAnimator.setDuration(200L);
        AlphaAnimator alphaAnimator2 = new AlphaAnimator(this.mArrowLayer1, 0.4f, 0.4f);
        alphaAnimator2.setDuration(200L);
        AlphaAnimator alphaAnimator3 = new AlphaAnimator(this.mArrowLayer1, 0.4f, 1.0f);
        alphaAnimator3.setDuration(200L);
        SequentialAnimator sequentialAnimator = new SequentialAnimator(this.mArrowLayer1, alphaAnimator, alphaAnimator2, alphaAnimator3);
        sequentialAnimator.setPathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        sequentialAnimator.setRepeatCount(0);
        this.mArrowLayer1.setAnimator(sequentialAnimator);
        AlphaAnimator alphaAnimator4 = new AlphaAnimator(this.mArrowLayer2, 0.4f, 0.4f);
        alphaAnimator4.setDuration(200L);
        AlphaAnimator alphaAnimator5 = new AlphaAnimator(this.mArrowLayer2, 0.4f, 1.0f);
        alphaAnimator5.setDuration(200L);
        AlphaAnimator alphaAnimator6 = new AlphaAnimator(this.mArrowLayer2, 1.0f, 0.4f);
        alphaAnimator6.setDuration(200L);
        SequentialAnimator sequentialAnimator2 = new SequentialAnimator(this.mArrowLayer2, alphaAnimator4, alphaAnimator5, alphaAnimator6);
        sequentialAnimator2.setPathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        sequentialAnimator2.setRepeatCount(0);
        this.mArrowLayer2.setAnimator(sequentialAnimator2);
    }

    private BitmapLayer createArrowLayer() {
        String str;
        int i3 = this.mSlideDirection;
        if (i3 == 1) {
            str = LEFT_ARROW_NAME;
        } else if (i3 == 3) {
            str = RIGHT_ARROW_NAME;
        } else {
            str = null;
        }
        if (this.mContext == null || TextUtils.isEmpty(str)) {
            return null;
        }
        int relativeSize = Utils.getRelativeSize(this.mContext, 16);
        int relativeSize2 = Utils.getRelativeSize(this.mContext, 32);
        BitmapLayer bitmapLayer = new BitmapLayer(Utils.bitmapFromAssets(this.mContext, str, relativeSize, relativeSize2));
        bitmapLayer.setWidth(relativeSize);
        bitmapLayer.setHeight(relativeSize2);
        return bitmapLayer;
    }

    private Path createBackgroundPath(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        Path path = new Path();
        float height = rectF.height() / 2.0f;
        path.moveTo(rectF.left + height, rectF.top);
        path.lineTo(rectF.left + height, rectF.bottom);
        path.lineTo(rectF.right - height, rectF.bottom);
        path.lineTo(rectF.right - height, rectF.top);
        path.lineTo(rectF.left + height, rectF.top);
        float f16 = rectF.left;
        path.addArc(new RectF(f16, rectF.top, rectF.height() + f16, rectF.bottom), 90.0f, 180.0f);
        path.addArc(new RectF(rectF.right - rectF.height(), rectF.top, rectF.right, rectF.bottom), 270.0f, 180.0f);
        return path;
    }

    private Shader createBackgroundShader(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        float f16 = rectF.left;
        float f17 = rectF.right;
        int i3 = this.mBackgroundColor;
        return new LinearGradient(f16, 0.0f, f17, 0.0f, i3, i3, Shader.TileMode.MIRROR);
    }

    private String getText() {
        String str = this.mGuideText;
        if (str != null && !str.isEmpty()) {
            if (this.mGuideText.length() > 12) {
                return this.mGuideText.substring(0, 12) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            return this.mGuideText;
        }
        return "";
    }

    private void initArrowLayer() {
        this.mArrowLayer1 = createArrowLayer();
        BitmapLayer createArrowLayer = createArrowLayer();
        this.mArrowLayer2 = createArrowLayer;
        if (this.mArrowLayer1 != null && createArrowLayer != null) {
            RectF backgroundRect = getBackgroundRect();
            float height = backgroundRect.top + ((backgroundRect.height() - this.mArrowLayer1.getHeight()) / 2.0f);
            float relativeSize = backgroundRect.left + Utils.getRelativeSize(this.mContext, 24);
            this.mArrowLayer1.setX(relativeSize);
            this.mArrowLayer1.setY(height);
            this.mArrowLayer2.setX(relativeSize + this.mArrowLayer1.getWidth());
            this.mArrowLayer2.setY(height);
            return;
        }
        Logger.w(TAG, "initArrowLayer: mArrowLayer1 or 2 is null");
    }

    private void initBackgroundLayer() {
        RectF backgroundRect = getBackgroundRect();
        PathShapeLayer pathShapeLayer = new PathShapeLayer();
        this.mBackgroundLayer = pathShapeLayer;
        pathShapeLayer.setShader(createBackgroundShader(backgroundRect));
        this.mBackgroundLayer.setPath(createBackgroundPath(backgroundRect));
    }

    private void initTextLayer() {
        float dp2px = Utils.dp2px(this.mTextSizeDp);
        if (this.mGuideTextLayer == null) {
            this.mGuideTextLayer = new TextLayer(getText(), this.mTextColor, dp2px);
        }
        RectF backgroundRect = getBackgroundRect();
        float relativeSize = backgroundRect.left + Utils.getRelativeSize(this.mContext, 68);
        float height = (backgroundRect.bottom - ((backgroundRect.height() - Utils.getTextPaintHeight(dp2px)) / 2.0f)) - Utils.getTextPaintBaselineToBottom(dp2px);
        this.mGuideTextLayer.setX(relativeSize);
        this.mGuideTextLayer.setY(height);
        this.mGuideTextLayer.setTextSize(dp2px);
    }

    public RectF getBackgroundRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (RectF) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        float relativeSize = Utils.getRelativeSize(this.mContext, 24);
        float height = getHeight() - Utils.getRelativeSize(this.mContext, 24);
        return new RectF(relativeSize, height - Utils.getRelativeSize(this.mContext, 56), Utils.getTextBound(Utils.dp2px(this.mTextSizeDp), getText()).width() + relativeSize + Utils.getRelativeSize(this.mContext, 100), height);
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (this.mContext == null) {
                return;
            }
            initArrowLayer();
            initBackgroundLayer();
            initTextLayer();
            addLayers(this.mBackgroundLayer, this.mArrowLayer1, this.mArrowLayer2, this.mGuideTextLayer);
        }
    }

    public void setBackgroundColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.mBackgroundColor = i3;
        if (this.mBackgroundLayer != null) {
            this.mBackgroundLayer.setShader(createBackgroundShader(getBackgroundRect()));
        }
    }

    public void setGuideText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        this.mGuideText = str;
        TextLayer textLayer = this.mGuideTextLayer;
        if (textLayer != null) {
            textLayer.setText(getText());
        }
    }

    public void setSlideDirection(@SlideGestureViewHelper.SlideDirection int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mSlideDirection = i3;
        }
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        this.mTextColor = i3;
        TextLayer textLayer = this.mGuideTextLayer;
        if (textLayer != null && textLayer.getPaint() != null) {
            this.mGuideTextLayer.getPaint().setColor(i3);
        }
    }

    public void setTextSizeDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            return;
        }
        this.mTextSizeDp = f16;
        if (this.mGuideTextLayer != null) {
            initTextLayer();
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AlphaAnimator alphaAnimator = new AlphaAnimator(this, 0.0f, 1.0f);
        alphaAnimator.setDuration(200L);
        alphaAnimator.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.insideslideinteractive.HolderGuideLayer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HolderGuideLayer.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                HolderGuideLayer.this.setAnimator(null);
                HolderGuideLayer.this.createArrowAnimator();
                HolderGuideLayer.this.mBackgroundLayer.setAnimator(new KeepAnimator(HolderGuideLayer.this.mBackgroundLayer));
                HolderGuideLayer.this.mGuideTextLayer.setAnimator(new KeepAnimator(HolderGuideLayer.this.mGuideTextLayer));
            }
        });
        setAnimator(alphaAnimator);
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mBackgroundLayer.setAnimator(null);
        this.mGuideTextLayer.setAnimator(null);
        setAnimator(null);
    }
}
