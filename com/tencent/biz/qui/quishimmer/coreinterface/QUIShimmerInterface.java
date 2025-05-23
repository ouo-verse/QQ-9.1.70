package com.tencent.biz.qui.quishimmer.coreinterface;

import android.graphics.PorterDuff;
import com.tencent.biz.qui.quishimmer.QUIShimmerController;
import com.tencent.biz.qui.quishimmer.QUIShimmerEntity;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface QUIShimmerInterface {
    void setBusinessTag(String str);

    void setOnVisibilityChangeListener(QUIShimmerEntity.OnVisibilityChangeListener onVisibilityChangeListener);

    void startShimming(QUIShimmerController qUIShimmerController);

    void stopShimming(QUIShimmerController qUIShimmerController);

    void updateColors(int i3, int i16, int i17, int i18);

    void updateRepeatCount(int i3);

    void updateXfermode(PorterDuff.Mode mode);
}
