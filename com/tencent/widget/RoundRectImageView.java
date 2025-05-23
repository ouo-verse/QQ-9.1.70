package com.tencent.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RoundRectImageView extends ImageView {
    static IPatchRedirector $redirector_ = null;
    public static final int MODE_ALL = 1;
    public static final int MODE_BOTTOM = 5;
    public static final int MODE_LEFT = 2;
    public static final int MODE_NONE = 0;
    public static final int MODE_RIGHT = 4;
    public static final int MODE_TOP = 3;
    private int mLastRadius;
    private int mLastRoundMode;
    protected int mRadius;
    protected int mRoundMode;
    protected Path mRoundPath;

    public RoundRectImageView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void checkPathChanged() {
        if (this.mLastRadius == this.mRadius && this.mLastRoundMode == this.mRoundMode) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.mLastRadius = this.mRadius;
        this.mRoundPath.reset();
        int i3 = this.mRoundMode;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            Path path = this.mRoundPath;
                            RectF rectF = new RectF(0.0f, 0.0f, width, height);
                            int i16 = this.mRadius;
                            path.addRoundRect(rectF, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i16, i16, i16, i16}, Path.Direction.CW);
                            return;
                        }
                        return;
                    }
                    Path path2 = this.mRoundPath;
                    RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
                    int i17 = this.mRadius;
                    path2.addRoundRect(rectF2, new float[]{0.0f, 0.0f, i17, i17, i17, i17, 0.0f, 0.0f}, Path.Direction.CW);
                    return;
                }
                Path path3 = this.mRoundPath;
                RectF rectF3 = new RectF(0.0f, 0.0f, width, height);
                int i18 = this.mRadius;
                path3.addRoundRect(rectF3, new float[]{i18, i18, i18, i18, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                return;
            }
            Path path4 = this.mRoundPath;
            RectF rectF4 = new RectF(0.0f, 0.0f, width, height);
            int i19 = this.mRadius;
            path4.addRoundRect(rectF4, new float[]{i19, i19, 0.0f, 0.0f, 0.0f, 0.0f, i19, i19}, Path.Direction.CW);
            return;
        }
        Path path5 = this.mRoundPath;
        RectF rectF5 = new RectF(0.0f, 0.0f, width, height);
        int i26 = this.mRadius;
        path5.addRoundRect(rectF5, i26, i26, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (this.mRoundMode != 0) {
            int save = canvas.save();
            checkPathChanged();
            canvas.clipPath(this.mRoundPath);
            super.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.draw(canvas);
    }

    public void setCornerRadiusAndMode(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mRadius = i3;
            this.mRoundMode = i16;
        }
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mRoundMode = 0;
        Path path = new Path();
        this.mRoundPath = path;
        path.setFillType(Path.FillType.EVEN_ODD);
    }
}
