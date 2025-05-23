package com.tencent.mobileqq.vas.pendant.drawable.interfaces;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.vip.api.VipData;

/* loaded from: classes20.dex */
public interface IPendantInfo {
    void clearCache();

    Drawable getDrawable(int i3, long j3, String str, int i16, boolean z16);

    Drawable getDrawable(int i3, long j3, String str, int i16, boolean z16, @Nullable VipData.VipNumberInfo vipNumberInfo, boolean z17);

    void setDrawable(View view, int i3, long j3);

    void setDrawable(View view, int i3, long j3, String str, int i16);

    void setPause(boolean z16);
}
