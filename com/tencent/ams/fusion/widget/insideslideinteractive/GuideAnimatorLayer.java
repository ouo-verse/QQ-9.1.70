package com.tencent.ams.fusion.widget.insideslideinteractive;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.ams.fusion.widget.animatorview.animator.AlphaAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.GroupAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator;
import com.tencent.ams.fusion.widget.animatorview.animator.SequentialAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.BitmapLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.PathShapeLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.TextLayer;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GuideAnimatorLayer extends GroupLayer {
    static IPatchRedirector $redirector_ = null;
    private static final int[] GUIDE_COLORS;
    private static final int GUIDE_MARGIN_TOP = 136;
    private static final int GUIDE_MIN_SIZE = 112;
    private static final int GUIDE_TEXT_MARGIN_TOP = 276;
    private static final String HAND_PATH = "insideslide/ic_hand.png";
    private static final int HAND_SIZE = 96;
    private static final int HORIZONTAL_GUIDE_HEIGHT = 48;
    private static final int HORIZONTAL_MARGIN_END = 160;
    private static final int HORIZONTAL_MARGIN_START = 144;
    private static final String TAG = "GuideAnimatorLayer";
    private Context mContext;
    private int mGuideDirection;
    private GroupLayer mGuideGroupLayer;
    private PathShapeLayer mGuideLayer;
    private int mGuideRepeatCount;
    private String mGuideText;
    private int mGuideTextColor;
    private TextLayer mGuideTextLayer;
    private float mGuideTextSizeDp;
    private BitmapLayer mHandleLayer;
    private Animator.AnimatorListener mOnAnimatorListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class GuideProgressAnimator extends ProgressAnimator {
        static IPatchRedirector $redirector_;

        public GuideProgressAnimator(AnimatorLayer animatorLayer, float f16, float f17) {
            super(animatorLayer, f16, f17);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, GuideAnimatorLayer.this, animatorLayer, Float.valueOf(f16), Float.valueOf(f17));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.ams.fusion.widget.animatorview.animator.ProgressAnimator, com.tencent.ams.fusion.widget.animatorview.animator.Animator
        public void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, canvas, animatorLayer, Boolean.valueOf(z16));
                return;
            }
            super.onPostAnimation(canvas, animatorLayer, z16);
            if (z16 && !shouldRepeat()) {
                GuideAnimatorLayer.this.postProgress(this.mProgress);
            } else {
                GuideAnimatorLayer.this.postProgress(computeProgress());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class KeepProgressAnimator extends KeepAnimator {
        static IPatchRedirector $redirector_;
        private float progress;

        public KeepProgressAnimator(AnimatorLayer animatorLayer, float f16) {
            super(animatorLayer);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, GuideAnimatorLayer.this, animatorLayer, Float.valueOf(f16));
            } else {
                this.progress = f16;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator, com.tencent.ams.fusion.widget.animatorview.animator.Animator
        public void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, canvas, animatorLayer, Boolean.valueOf(z16));
            } else {
                GuideAnimatorLayer.this.postProgress(this.progress);
                super.onPostAnimation(canvas, animatorLayer, z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21605);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            GUIDE_COLORS = new int[]{Color.parseColor("#CCFFFFFF"), Color.parseColor("#00FFFFFF")};
        }
    }

    public GuideAnimatorLayer(Context context) {
        super(new AnimatorLayer[0]);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mGuideDirection = 3;
        this.mGuideRepeatCount = 0;
        this.mGuideTextSizeDp = 14.0f;
        this.mGuideTextColor = -1;
        this.mContext = context.getApplicationContext();
    }

    private Animator createGuideAnimatorStep1() {
        GroupAnimator groupAnimator = new GroupAnimator(this.mGuideGroupLayer, new AlphaAnimator(this.mGuideGroupLayer, 0.0f, 1.0f), new KeepProgressAnimator(this.mGuideGroupLayer, 0.0f));
        groupAnimator.setDuration(200L);
        GuideProgressAnimator guideProgressAnimator = new GuideProgressAnimator(this.mGuideGroupLayer, 0.0f, 1.0f);
        guideProgressAnimator.setDuration(400L);
        guideProgressAnimator.setPathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        KeepProgressAnimator keepProgressAnimator = new KeepProgressAnimator(this.mGuideGroupLayer, 1.0f);
        keepProgressAnimator.setDuration(200L);
        GroupAnimator groupAnimator2 = new GroupAnimator(this.mGuideGroupLayer, new AlphaAnimator(this.mGuideGroupLayer, 1.0f, 0.0f), new KeepProgressAnimator(this.mGuideGroupLayer, 1.0f));
        groupAnimator2.setDuration(200L);
        GroupAnimator groupAnimator3 = new GroupAnimator(this.mGuideGroupLayer, new AlphaAnimator(this.mGuideGroupLayer, 0.0f, 0.0f), new KeepProgressAnimator(this.mGuideGroupLayer, 0.0f));
        groupAnimator3.setDuration(200L);
        return new SequentialAnimator(this.mGuideGroupLayer, groupAnimator, guideProgressAnimator, keepProgressAnimator, groupAnimator2, groupAnimator3);
    }

    private void createGuideTextLayer() {
        float dp2px = Utils.dp2px(this.mGuideTextSizeDp);
        String text = getText();
        if (this.mGuideTextLayer == null) {
            this.mGuideTextLayer = new TextLayer(text, this.mGuideTextColor, dp2px);
        }
        this.mGuideTextLayer.setTextSize(dp2px);
        this.mGuideTextLayer.setTextBold(true);
        this.mGuideTextLayer.setText(text);
        this.mGuideTextLayer.setTextAlign(Paint.Align.CENTER);
        this.mGuideTextLayer.setShadowLayer(8.0f, 8.0f, 24.0f, Color.parseColor("#40000000"));
        this.mGuideTextLayer.setY((int) ((Utils.getRelativeSize(this.mContext, 276) + Utils.getTextPaintHeight(dp2px)) - Utils.getTextPaintBaselineToBottom(dp2px)));
        this.mGuideTextLayer.setX(getWidth() / 2.0f);
    }

    private Path createPath(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        Path path = new Path();
        float height = rectF.height() / 2.0f;
        int i3 = this.mGuideDirection;
        if (i3 == 1) {
            path.moveTo(rectF.left + height, rectF.top);
            path.lineTo(rectF.left + height, rectF.bottom);
            path.lineTo(rectF.right, rectF.bottom);
            path.lineTo(rectF.right, rectF.top);
            path.lineTo(rectF.left + height, rectF.top);
            float f16 = rectF.left;
            path.addArc(new RectF(f16, rectF.top, rectF.height() + f16, rectF.bottom), 90.0f, 180.0f);
        } else {
            if (i3 != 3) {
                return null;
            }
            path.moveTo(rectF.left, rectF.top);
            path.lineTo(rectF.left, rectF.bottom);
            path.lineTo(rectF.right - height, rectF.bottom);
            path.lineTo(rectF.right - height, rectF.top);
            path.lineTo(rectF.left, rectF.top);
            path.addArc(new RectF(rectF.right - rectF.height(), rectF.top, rectF.right, rectF.bottom), 270.0f, 180.0f);
        }
        return path;
    }

    private Shader createShader(RectF rectF) {
        if (rectF == null) {
            return null;
        }
        int i3 = this.mGuideDirection;
        if (i3 == 1) {
            return new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, GUIDE_COLORS, (float[]) null, Shader.TileMode.MIRROR);
        }
        if (i3 != 3) {
            return null;
        }
        return new LinearGradient(rectF.right, 0.0f, rectF.left, 0.0f, GUIDE_COLORS, (float[]) null, Shader.TileMode.MIRROR);
    }

    private RectF getGuideRect(float f16) {
        if (isHorizontalGuide()) {
            float relativeSize = Utils.getRelativeSize(this.mContext, 136);
            float relativeSize2 = Utils.getRelativeSize(this.mContext, 48) + relativeSize;
            float relativeSize3 = Utils.getRelativeSize(this.mContext, 112);
            float width = getWidth() - Utils.getRelativeSize(this.mContext, 304);
            if (this.mGuideDirection == 1) {
                float width2 = getWidth() - Utils.getRelativeSize(this.mContext, 144);
                return new RectF((width2 - relativeSize3) - ((width - relativeSize3) * f16), relativeSize, width2, relativeSize2);
            }
            float relativeSize4 = Utils.getRelativeSize(this.mContext, 144);
            return new RectF(relativeSize4, relativeSize, relativeSize4 + relativeSize3 + ((width - relativeSize3) * f16), relativeSize2);
        }
        return null;
    }

    private String getMaxWidthText(String str, int i3, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (Utils.getTextBound(Utils.dp2px(this.mGuideTextSizeDp), str + str2).width() > i3) {
            return getMaxWidthText(str.substring(0, str.length() - 1), i3, str2);
        }
        return str + str2;
    }

    private String getText() {
        if (TextUtils.isEmpty(this.mGuideText)) {
            return "";
        }
        if (Utils.getTextBound(Utils.dp2px(this.mGuideTextSizeDp), this.mGuideText).width() > getWidth()) {
            return getMaxWidthText(this.mGuideText.substring(0, r0.length() - 1), getWidth(), MiniBoxNoticeInfo.APPNAME_SUFFIX);
        }
        return this.mGuideText;
    }

    private boolean isHorizontalGuide() {
        int i3 = this.mGuideDirection;
        if (i3 == 1 || i3 == 3) {
            return true;
        }
        return false;
    }

    public RectF getRect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RectF) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        RectF guideRect = getGuideRect(1.0f);
        if (guideRect != null && this.mGuideTextLayer != null) {
            RectF rectF = new RectF();
            float dp2px = Utils.dp2px(this.mGuideTextSizeDp);
            Rect textBound = Utils.getTextBound(dp2px, getText());
            float f16 = textBound.right - textBound.left;
            float f17 = 0.0f;
            if (f16 > 0.0f) {
                f17 = (getWidth() / 2.0f) - (f16 / 2.0f);
            }
            float max = Math.max(f16, guideRect.width());
            float min = Math.min(guideRect.left, f17);
            rectF.left = min;
            rectF.top = guideRect.top;
            rectF.right = min + max;
            rectF.bottom = Utils.getRelativeSize(this.mContext, 276) + Utils.getTextPaintHeight(dp2px);
            return rectF;
        }
        Logger.w(TAG, "getRect: guideRect or mGuideTextLayer is null");
        return new RectF();
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mGuideLayer = new PathShapeLayer();
        int relativeSize = Utils.getRelativeSize(this.mContext, 96);
        BitmapLayer bitmapLayer = new BitmapLayer(Utils.bitmapFromAssets(this.mContext, HAND_PATH, relativeSize, relativeSize));
        this.mHandleLayer = bitmapLayer;
        bitmapLayer.setWidth(relativeSize);
        this.mHandleLayer.setHeight(relativeSize);
        this.mGuideGroupLayer = new GroupLayer(this.mGuideLayer, this.mHandleLayer);
        createGuideTextLayer();
        addLayers(this.mGuideGroupLayer, this.mGuideTextLayer);
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            return;
        }
        RectF guideRect = getGuideRect(f16);
        if (this.mGuideLayer != null) {
            this.mGuideLayer.setPath(createPath(guideRect));
            this.mGuideLayer.setShader(createShader(guideRect));
        }
        BitmapLayer bitmapLayer = this.mHandleLayer;
        if (bitmapLayer != null && guideRect != null) {
            int i3 = this.mGuideDirection;
            if (i3 == 1) {
                bitmapLayer.setX(guideRect.left);
                this.mHandleLayer.setY(guideRect.top);
            } else if (i3 == 3) {
                bitmapLayer.setY(guideRect.top);
                this.mHandleLayer.setX(guideRect.right - r0.getWidth());
            }
        }
    }

    public void setGuideDirection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mGuideDirection = i3;
        }
    }

    public void setGuideRepeatCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mGuideRepeatCount = i3;
        }
    }

    public void setGuideText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        this.mGuideText = str;
        TextLayer textLayer = this.mGuideTextLayer;
        if (textLayer != null) {
            textLayer.setText(getText());
        }
    }

    public void setOnAnimatorListener(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) animatorListener);
        } else {
            this.mOnAnimatorListener = animatorListener;
        }
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        this.mGuideTextColor = i3;
        TextLayer textLayer = this.mGuideTextLayer;
        if (textLayer != null) {
            textLayer.getPaint().setColor(i3);
        }
    }

    public void setTextSizeDp(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            return;
        }
        this.mGuideTextSizeDp = f16;
        if (this.mGuideTextLayer != null) {
            createGuideTextLayer();
        }
    }

    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mGuideTextLayer.setAnimator(new KeepAnimator(this.mGuideTextLayer));
        Animator createGuideAnimatorStep1 = createGuideAnimatorStep1();
        createGuideAnimatorStep1.setRepeatCount(this.mGuideRepeatCount);
        createGuideAnimatorStep1.setAnimatorListener(new Animator.AnimatorListener() { // from class: com.tencent.ams.fusion.widget.insideslideinteractive.GuideAnimatorLayer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuideAnimatorLayer.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
            public void onAnimationFinish() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (GuideAnimatorLayer.this.mOnAnimatorListener != null) {
                    GuideAnimatorLayer.this.mOnAnimatorListener.onAnimationFinish();
                }
                GuideAnimatorLayer.this.stop();
            }
        });
        this.mGuideGroupLayer.setAnimator(createGuideAnimatorStep1);
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        TextLayer textLayer = this.mGuideTextLayer;
        if (textLayer != null) {
            textLayer.setAnimator(null);
        }
        GroupLayer groupLayer = this.mGuideGroupLayer;
        if (groupLayer != null) {
            groupLayer.setAnimator(null);
        }
    }
}
