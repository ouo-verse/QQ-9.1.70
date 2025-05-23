package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RecentDynamicAvatarView extends DynamicAvatarView implements IRecentImgv {
    static IPatchRedirector $redirector_;
    protected float M;
    protected float N;
    protected float P;
    protected Paint Q;
    protected Paint R;
    protected boolean S;
    protected boolean T;
    protected Rect U;
    protected long V;
    protected Bitmap W;

    public RecentDynamicAvatarView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.M = -1.0f;
        this.N = -1.0f;
        this.P = 0.0f;
        this.Q = null;
        this.R = null;
        this.S = false;
        this.T = false;
        this.U = null;
        this.V = 5L;
        this.W = null;
    }

    protected static Bitmap e(long j3) {
        int i3;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        if (j3 == 1) {
            i3 = R.drawable.h2g;
            str = "StatusIcon_TroopPermanentBlockStatusBigIconKey";
        } else if (j3 == 2) {
            i3 = R.drawable.h2i;
            str = "StatusIcon_TroopTmpBlockStatusBigIcon";
        } else {
            i3 = -1;
            str = "";
        }
        if (i3 < 0) {
            return null;
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 == null && (f16 = com.tencent.mobileqq.util.j.h(BaseApplicationImpl.getApplication().getResources(), i3)) != null) {
            imageCacheHelper.i(str, f16, Business.Conversation);
        }
        if (QLog.isColorLevel()) {
            QLog.i("FixSizeImageView", 2, "getTroopCreditStatusIcon:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return f16;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        if (this.S) {
            if (this.M == -1.0f || this.N == -1.0f) {
                this.M = getPaddingLeft() + (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.5f);
                this.N = getPaddingTop() + (((getHeight() - getPaddingTop()) - getPaddingBottom()) * 0.5f);
                this.P = Math.max(r0, r2) / 2;
            }
            if (this.Q == null) {
                Paint paint = new Paint();
                this.Q = paint;
                paint.setAntiAlias(true);
                this.Q.setColor(Color.parseColor("#B2000000"));
            }
            canvas.drawCircle(this.M, this.N, this.P, this.Q);
        }
        if (this.T) {
            if (this.R == null) {
                Paint paint2 = new Paint();
                this.R = paint2;
                paint2.setAntiAlias(true);
                this.R.setFilterBitmap(true);
            }
            if (this.W != null) {
                if (this.U == null) {
                    int width = getWidth() - getPaddingRight();
                    int height = getHeight() - getPaddingBottom();
                    this.U = new Rect(width - this.W.getWidth(), height - this.W.getHeight(), width, height);
                }
                canvas.drawBitmap(this.W, (Rect) null, this.U, this.R);
            }
        }
    }

    @Override // android.view.View
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.widget.IRecentImgv
    public void showTroopCreditStatus(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
            return;
        }
        if (this.V == j3) {
            return;
        }
        this.V = j3;
        if (QLog.isColorLevel()) {
            QLog.i("FixSizeImageView", 2, "showTroopCreditStatus:" + j3);
        }
        if (j3 != 2 && j3 != 1) {
            this.S = false;
            this.T = false;
            this.W = null;
        } else {
            this.S = true;
            this.T = true;
            this.W = e(j3);
        }
        invalidate();
    }

    public RecentDynamicAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.M = -1.0f;
        this.N = -1.0f;
        this.P = 0.0f;
        this.Q = null;
        this.R = null;
        this.S = false;
        this.T = false;
        this.U = null;
        this.V = 5L;
        this.W = null;
    }

    public RecentDynamicAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.M = -1.0f;
        this.N = -1.0f;
        this.P = 0.0f;
        this.Q = null;
        this.R = null;
        this.S = false;
        this.T = false;
        this.U = null;
        this.V = 5L;
        this.W = null;
    }
}
