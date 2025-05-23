package dov.com.qq.im.ae.current;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.QIMCircleProgress;

/* loaded from: classes28.dex */
public class AnimationQIMCircleProgress extends QIMCircleProgress {
    Paint C;
    private RectF D;
    private int E;
    private int F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private float f394430d;

    /* renamed from: e, reason: collision with root package name */
    private int f394431e;

    /* renamed from: f, reason: collision with root package name */
    private int f394432f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f394433h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f394434i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f394435m;

    public AnimationQIMCircleProgress(Context context) {
        super(context);
        this.f394430d = 1.0f;
        this.f394433h = false;
        this.f394434i = false;
        this.f394435m = false;
        this.G = true;
    }

    protected void a(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f394432f * this.mCenterScale, this.mPaintWhite);
    }

    protected void b(Canvas canvas) {
        this.D.set((getWidth() - this.E) / 2, (getHeight() - this.E) / 2, r0 + r2, r1 + r2);
        RectF rectF = this.D;
        int i3 = this.F;
        canvas.drawRoundRect(rectF, i3, i3, this.mPaintWhite);
    }

    protected void c(Canvas canvas) {
        int b16 = UIUtils.b(getContext(), 3.0f);
        Color.parseColor(GameCenterVideoViewController.GRAY_MASK);
        int i3 = this.mWidth;
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setStrokeWidth(b16);
        this.C.setColor(-1);
        canvas.drawCircle(i3 / 2, i3 / 2, (i3 / 2) - (b16 / 2), this.C);
    }

    @Override // com.tencent.widget.QIMCircleProgress
    public void changeMode(int i3) {
        boolean z16 = this.f394435m;
        if (this.f394434i) {
            setBackgroundResource(R.drawable.hki);
        } else if (i3 != 1 && this.f394433h) {
            setBackgroundDrawable(null);
        } else {
            setBackgroundResource(R.drawable.ebv);
        }
        super.changeMode(i3);
    }

    @Override // com.tencent.widget.QIMCircleProgress
    protected void drawCenterCircle(Canvas canvas) {
        if (!this.G) {
            return;
        }
        if (!this.f394433h) {
            if (this.mMode == 3) {
                b(canvas);
                return;
            } else {
                a(canvas);
                return;
            }
        }
        int i3 = this.mMode;
        if (i3 == 1) {
            a(canvas);
            return;
        }
        if (i3 == 3) {
            b(canvas);
        }
        c(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.QIMCircleProgress
    public void init() {
        super.init();
        Paint paint = new Paint();
        this.C = paint;
        paint.setAntiAlias(true);
        this.mPaintWhite.setStyle(Paint.Style.FILL);
        setBackgroundResource(R.drawable.ebv);
        this.E = ViewUtils.dip2px(30.0f);
        this.F = ViewUtils.dip2px(6.0f);
        this.D = new RectF();
    }

    @Override // com.tencent.widget.QIMCircleProgress
    public void setCenterView() {
        super.setCenterView();
        this.f394431e = ViewUtils.dip2px(3.0f);
        this.f394432f = ViewUtils.dip2px(53.0f) / 2;
    }

    public void setDrawCenterCircle(boolean z16) {
        if (this.G != z16) {
            this.G = z16;
            invalidate();
        }
    }

    public void setIldeStyle(boolean z16) {
        this.f394433h = z16;
        if (z16) {
            setBackgroundDrawable(null);
        } else {
            setBackgroundResource(R.drawable.ebv);
        }
        invalidate();
    }

    public AnimationQIMCircleProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f394430d = 1.0f;
        this.f394433h = false;
        this.f394434i = false;
        this.f394435m = false;
        this.G = true;
    }
}
