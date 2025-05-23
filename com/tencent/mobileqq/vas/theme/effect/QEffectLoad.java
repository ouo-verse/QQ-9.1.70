package com.tencent.mobileqq.vas.theme.effect;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.engine.QEffectData;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QEffectLoad implements IQEffectLoad {
    @Override // com.tencent.qq.effect.IQEffectLoad
    public void load(Context context, IQEffect iQEffect, QEffectData qEffectData) {
        int i3 = qEffectData.resType;
        if (i3 != 1) {
            if (i3 == 3) {
                loadFromResource(context, iQEffect, qEffectData.resId);
                return;
            }
            return;
        }
        loadFromFile(context, iQEffect, qEffectData.src);
    }

    @Override // com.tencent.qq.effect.IQEffectLoad
    public void loadFromFile(Context context, IQEffect iQEffect, String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = ApngOptions.TRANSPARENT;
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        iQEffect.complete(URLDrawable.getFileDrawable(str, obtain));
    }

    @Override // com.tencent.qq.effect.IQEffectLoad
    public void loadFromResource(Context context, IQEffect iQEffect, int i3) {
        if (context != null) {
            iQEffect.complete(context.getResources().getDrawable(i3));
        }
    }

    @Override // com.tencent.qq.effect.IQEffectLoad
    public void loadFromAsset(Context context, IQEffect iQEffect, String str) {
    }
}
