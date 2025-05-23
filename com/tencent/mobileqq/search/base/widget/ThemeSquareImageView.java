package com.tencent.mobileqq.search.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ThemeSquareImageView extends SquareImageView {
    public static String I = "1000";
    Paint G;
    boolean H;

    public ThemeSquareImageView(Context context) {
        super(context);
        this.H = true;
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.G = paint;
        paint.setAntiAlias(true);
        this.G.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
    }

    public static void setCurThemeId(String str) {
        I = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.SquareImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.H && ThemeUtil.isNowThemeIsNight(null, false, ThemeUtil.curThemeId)) {
            canvas.saveLayer(null, this.G, 31);
            super.onDraw(canvas);
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }

    public void setSupportMaskView(boolean z16) {
        this.H = z16;
    }

    public ThemeSquareImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = true;
        init();
    }

    public ThemeSquareImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = true;
        init();
    }
}
