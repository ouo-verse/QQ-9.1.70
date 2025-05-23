package com.tencent.mobileqq.vas.pendant.drawable;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantImageLayout;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class l implements IPendantInfo {

    /* renamed from: a, reason: collision with root package name */
    private final long f310514a;

    public l(long j3) {
        this.f310514a = j3;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo
    public Drawable getDrawable(int i3, long j3, String str, int i16, boolean z16) {
        return getDrawable(i3, j3, str, i16, true, null, z16);
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo
    public void setDrawable(View view, int i3, long j3) {
        setDrawable(view, i3, j3, "", 0);
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo
    public void setPause(boolean z16) {
        if (z16) {
            CacheStateMap.stop(this.f310514a);
        } else {
            CacheStateMap.restart(this.f310514a);
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo
    public Drawable getDrawable(int i3, long j3, String str, int i16, boolean z16, @Nullable VipData.VipNumberInfo vipNumberInfo, boolean z17) {
        PendantDrawable pendantDrawable = new PendantDrawable(this.f310514a, str, i16, j3, i3);
        pendantDrawable.b0(z16);
        pendantDrawable.a0(z17);
        pendantDrawable.Z(vipNumberInfo);
        pendantDrawable.f0();
        return pendantDrawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo
    public void setDrawable(View view, int i3, long j3, String str, int i16) {
        if (SimpleUIUtil.getSimpleUISwitch()) {
            if (QLog.isColorLevel()) {
                QLog.i("PendantInfo", 2, "setDrawable, SimpleUIMode is open now");
                return;
            }
            return;
        }
        Drawable drawable = getDrawable(i3, j3, str, i16, true, null, true);
        if (view instanceof IPendantImageLayout) {
            ((IPendantImageLayout) view).setPendantImage(drawable);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(drawable);
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo
    public void clearCache() {
    }
}
