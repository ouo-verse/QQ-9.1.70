package com.tencent.mobileqq.vas.pendant.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.vipicon.api.IVipNumberDrawable;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes20.dex */
public class o extends AbsAsyncDrawable implements Drawable.Callback {
    static final boolean E = VasToggle.BUG_103247711.isEnable(true);
    static final boolean F = VasNormalToggle.VAS_BUG_119052570.isEnable(true);
    private static final IVipNumberDrawable G = (IVipNumberDrawable) QRoute.api(IVipNumberDrawable.class);
    private a D;

    /* renamed from: d, reason: collision with root package name */
    String f310517d;

    /* renamed from: e, reason: collision with root package name */
    private final Drawable f310518e;

    /* renamed from: f, reason: collision with root package name */
    private VipData.VipNumberInfo f310519f;

    /* renamed from: i, reason: collision with root package name */
    Drawable f310521i;

    /* renamed from: m, reason: collision with root package name */
    int f310522m;

    /* renamed from: h, reason: collision with root package name */
    private boolean f310520h = true;
    public boolean C = false;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void success(VipData.VipNumberInfo vipNumberInfo);
    }

    public o(String str, Drawable drawable, VipData.VipNumberInfo vipNumberInfo) {
        this.f310517d = str;
        this.f310519f = vipNumberInfo;
        this.f310518e = drawable;
        setTargetDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.pendant.drawable.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Drawable z16;
                z16 = o.this.z();
                return z16;
            }
        });
        load();
    }

    private static VipData.VipNumberInfo.APPID x(int i3) {
        VipData.VipNumberInfo.APPID appid = VipData.VipNumberInfo.APPID.Theme;
        if (i3 == appid.getId()) {
            return appid;
        }
        VipData.VipNumberInfo.APPID appid2 = VipData.VipNumberInfo.APPID.ProfileCard;
        if (i3 == appid2.getId()) {
            return appid2;
        }
        VipData.VipNumberInfo.APPID appid3 = VipData.VipNumberInfo.APPID.Pendant;
        if (i3 == appid3.getId()) {
            return appid3;
        }
        VipData.VipNumberInfo.APPID appid4 = VipData.VipNumberInfo.APPID.Avatar;
        if (i3 == appid4.getId()) {
            return appid4;
        }
        return null;
    }

    private VipData.VipNumberInfo y() {
        if (this.f310519f == null) {
            return null;
        }
        VipData vipDataForFriends = com.tencent.mobileqq.vip.api.b.a().getVipDataForFriends(this.f310517d);
        int appId = this.f310519f.getAppId();
        VipData.VipNumberInfo.APPID x16 = x(appId);
        if (x16 == null) {
            QLog.e("AbsAsyncDrawable", 1, "Invalid appId:" + appId);
            return null;
        }
        return vipDataForFriends.getVipNumberInfo(x16, this.f310519f.getItemId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Drawable z() {
        return this.f310518e;
    }

    public void A(boolean z16) {
        VipData.VipNumberInfo y16 = y();
        if (y16 != null) {
            B(y16, z16);
        }
    }

    public void B(VipData.VipNumberInfo vipNumberInfo, boolean z16) {
        this.f310519f = vipNumberInfo;
        if (vipNumberInfo != null) {
            if (!z16 && this.f310521i != null && vipNumberInfo.getNumberIdx() == this.f310522m) {
                return;
            }
            Drawable newSmallDrawable = G.newSmallDrawable(vipNumberInfo.getNumberItemId(), vipNumberInfo.getNumberIdx(), vipNumberInfo.isLongNumber());
            this.f310521i = newSmallDrawable;
            if (newSmallDrawable != null) {
                newSmallDrawable.setCallback(this);
                this.f310522m = vipNumberInfo.getNumberIdx();
            }
            a aVar = this.D;
            if (aVar != null) {
                aVar.success(vipNumberInfo);
                return;
            }
            return;
        }
        this.f310521i = null;
        this.f310522m = 0;
    }

    public void C(boolean z16) {
        this.f310520h = z16;
    }

    public void D(a aVar) {
        this.D = aVar;
    }

    public void E(boolean z16) {
        this.C = z16;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        VipData.VipNumberInfo vipNumberInfo;
        super.draw(canvas);
        Rect bounds = getBounds();
        if (this.f310521i == null || (vipNumberInfo = this.f310519f) == null) {
            return;
        }
        int width = (int) (bounds.width() * m.f310515a.a(this.C, vipNumberInfo.getAppId()));
        int width2 = (bounds.width() - width) / 2;
        int intrinsicHeight = (int) (this.f310521i.getIntrinsicHeight() * (width / this.f310521i.getIntrinsicWidth()));
        if (F && this.f310519f.getAppId() == 4) {
            int i3 = (intrinsicHeight / 3) * 2;
            Drawable drawable = this.f310521i;
            int i16 = bounds.left + width2;
            int i17 = bounds.bottom;
            drawable.setBounds(i16, i17 - i3, bounds.right - width2, (i17 + intrinsicHeight) - i3);
        } else {
            Drawable drawable2 = this.f310521i;
            int i18 = bounds.left + width2;
            int i19 = bounds.bottom;
            drawable2.setBounds(i18, i19 - intrinsicHeight, bounds.right - width2, i19);
        }
        this.f310521i.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(drawable);
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public boolean isLoadSucess() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j3) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(drawable, runnable, j3);
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        if (z16 && E && this.f310520h) {
            A(false);
        }
        return super.setVisible(z16, z17);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(drawable, runnable);
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NonNull ILoaderSucessCallback iLoaderSucessCallback) {
    }
}
