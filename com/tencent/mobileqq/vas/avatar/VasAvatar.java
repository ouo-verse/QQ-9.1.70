package com.tencent.mobileqq.vas.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mobileqq.vas.vipicon.api.IVipNumberDrawable;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.mobileqq.widget.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.widget.URLThemeImageView;
import com.tencent.zplan.meme.action.MODE;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasAvatar extends URLThemeImageView implements t.a {
    protected t C;
    private boolean D;
    private long E;
    private Drawable F;

    /* renamed from: d, reason: collision with root package name */
    public boolean f308760d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f308761e;

    /* renamed from: f, reason: collision with root package name */
    public VasAvatarLoader f308762f;

    /* renamed from: h, reason: collision with root package name */
    protected AvatarLayout f308763h;

    /* renamed from: i, reason: collision with root package name */
    protected String f308764i;

    /* renamed from: m, reason: collision with root package name */
    private View.OnLongClickListener f308765m;

    public VasAvatar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f308760d = false;
        setSupportMaskView(false);
    }

    public static boolean c(int i3, int i16) {
        if (i3 == 1 || i3 == 103) {
            return true;
        }
        if (i3 == 32 && i16 == 200) {
            return true;
        }
        return false;
    }

    private void d(Canvas canvas) {
        if (this.E <= 0) {
            return;
        }
        Typeface createFromAsset = Typeface.createFromAsset(getContext().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
        Paint paint = new Paint();
        paint.setTypeface(createFromAsset);
        float height = getHeight() / 7.0f;
        paint.setTextSize(height);
        paint.setColor(-1);
        canvas.drawText(e(this.E), ((getWidth() * 4) / 9.0f) + (((2.0f - (r2.length() / 2.0f)) * height) / 2.0f), (getHeight() * 9) / 10.0f, paint);
    }

    private static String e(long j3) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        if (j3 < JsonGrayBusiId.UI_RESERVE_100000_110000) {
            return decimalFormat.format(j3 / 1000.0d).replace(".0", "") + "k";
        }
        if (j3 < 1000000) {
            return decimalFormat.format(j3 / 10000.0d).replace(".0", "") + "w";
        }
        return decimalFormat.format(j3 / 1000000.0d).replace(".0", "") + "b";
    }

    private boolean f(String str) {
        boolean z16 = false;
        if (!TextUtils.isEmpty(str)) {
            VipData vipDataForFriends = com.tencent.mobileqq.vip.api.b.a().getVipDataForFriends(str);
            if (vipDataForFriends != null && vipDataForFriends.isSplendid()) {
                z16 = true;
            }
            if (z16) {
                this.E = vipDataForFriends.getNvalue();
            }
        }
        return z16;
    }

    public static String i(int i3) {
        if (i3 != 200) {
            if (i3 != 640) {
                return NtFaceConstant.SMALL;
            }
            return NtFaceConstant.LARGE;
        }
        return "medium";
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        t tVar = this.C;
        if (tVar != null) {
            tVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public void g(String str, long j3) {
        VipData.VipNumberInfo vipNumberInfo = com.tencent.mobileqq.vip.api.b.a().getVipDataForFriends(str).getVipNumberInfo(VipData.VipNumberInfo.APPID.Avatar, (int) j3);
        if (vipNumberInfo != null) {
            Drawable newSmallDrawable = ((IVipNumberDrawable) QRoute.api(IVipNumberDrawable.class)).newSmallDrawable(vipNumberInfo.getNumberItemId(), vipNumberInfo.getNumberIdx(), vipNumberInfo.isLongNumber());
            this.F = newSmallDrawable;
            if (newSmallDrawable != null) {
                newSmallDrawable.setCallback(this);
            }
            VasLogNtReporter.getVipNumber().reportLow(String.format("profilecard[%d] number_id[%d] number[%d]", Long.valueOf(j3), Integer.valueOf(vipNumberInfo.getNumberItemId()), Integer.valueOf(vipNumberInfo.getNumberIdx())));
            return;
        }
        this.F = null;
    }

    public void h() {
        AvatarLayout avatarLayout = this.f308763h;
        if (avatarLayout != null) {
            avatarLayout.setGoneBelow(1);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.VasFaceManager", 2, "show vas avatar of " + this.f308764i);
        }
    }

    @Override // android.view.View
    public boolean hasOnLongClickListeners() {
        if (this.f308765m != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.URLThemeImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        t tVar = this.C;
        if (tVar != null) {
            tVar.b(canvas);
        } else {
            super.onDraw(canvas);
        }
        if (this.D) {
            d(canvas);
        }
    }

    @Override // com.tencent.image.URLImageView, com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        super.onLoadSuccessed(uRLDrawable);
        h();
        Drawable currDrawable = uRLDrawable.getCurrDrawable();
        if (ApngDrawable.class.isInstance(currDrawable) && (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            VasFaceManager.n(this.f308764i, (ApngDrawable) currDrawable);
        }
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f308762f = null;
    }

    public void setLoader(AvatarLayout avatarLayout, VasAvatarLoader vasAvatarLoader) {
        this.f308761e = vasAvatarLoader.D;
        vasAvatarLoader.D = null;
        String str = this.f308764i;
        if (str == null) {
            str = "";
        }
        this.f308764i = str;
        boolean z16 = !str.equals(vasAvatarLoader.f308767e);
        String str2 = vasAvatarLoader.f308767e;
        this.f308764i = str2;
        boolean f16 = f(str2);
        this.D = f16;
        if (z16 || !f16) {
            setImageDrawable(this.f308761e);
        }
        if (z16) {
            this.F = null;
        }
        this.f308763h = avatarLayout;
        this.f308762f = vasAvatarLoader;
        vasAvatarLoader.n(this);
    }

    public void setLoaderForCmshow(AvatarLayout avatarLayout, VasAvatarLoader vasAvatarLoader, String str, MODE mode) {
        Drawable drawable = vasAvatarLoader.D;
        this.f308761e = drawable;
        vasAvatarLoader.D = null;
        setImageDrawable(drawable);
        this.D = false;
        this.f308763h = avatarLayout;
        this.f308762f = vasAvatarLoader;
        this.f308764i = vasAvatarLoader.f308767e;
        vasAvatarLoader.o(this, str, mode);
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void setMosaicEffect(t tVar) {
        t tVar2 = this.C;
        if (tVar2 != null) {
            tVar2.c(null);
        }
        this.C = tVar;
        if (tVar != null) {
            tVar.c(this);
        }
        invalidate();
    }

    @Override // android.view.View
    public void setOnLongClickListener(@Nullable @android.support.annotation.Nullable View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.f308765m = onLongClickListener;
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superDrawMosaic(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.tencent.mobileqq.widget.t.a
    public void superOnDrawMosaic(Canvas canvas) {
        super.onDraw(canvas);
    }

    public VasAvatar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public VasAvatar(Context context) {
        this(context, null);
    }
}
