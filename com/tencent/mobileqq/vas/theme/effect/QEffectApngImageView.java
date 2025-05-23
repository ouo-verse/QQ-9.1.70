package com.tencent.mobileqq.vas.theme.effect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.impls.QEffectImageView;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes20.dex */
public class QEffectApngImageView extends QEffectImageView {
    private static final String TAG = "QEffectApngImageView";
    private ApngOptions mApngOptions;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class ApngOptions {
        public Drawable loadingDrawable;
        public String name;
        public int[] picTag;
        public String urlStr;
    }

    public QEffectApngImageView(Context context) {
        super(context);
    }

    public static ApngOptions getApngOptions(int[] iArr, String str) {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.picTag = iArr;
        apngOptions.name = str;
        apngOptions.urlStr = str;
        return apngOptions;
    }

    @Override // com.tencent.qq.effect.impls.QEffectImageView, com.tencent.qq.effect.IQEffect
    public void load(Context context, QEffectView qEffectView, IQEffectLoad iQEffectLoad, QEffectData qEffectData) {
        this.mEffectData = qEffectData;
        if (qEffectData != null) {
            this.mSensorParams = new SensorParams(getContext(), this.mEffectData);
        }
        if (QEffectUtils.isEmpty(qEffectData.src)) {
            Log.e(TAG, " load data.src is null ");
            return;
        }
        Object extOptions = qEffectView.getExtOptions(qEffectData.type);
        if (extOptions != null && (extOptions instanceof ApngOptions)) {
            this.mApngOptions = (ApngOptions) qEffectView.getExtOptions(qEffectData.type);
        } else {
            ApngOptions apngOptions = new ApngOptions();
            this.mApngOptions = apngOptions;
            apngOptions.urlStr = String.valueOf(qEffectData.effectId);
            this.mApngOptions.name = String.valueOf(qEffectData.effectId);
            this.mApngOptions.picTag = new int[]{qEffectData.effectId};
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_double_bitmap", true);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        String str = qEffectData.src;
        ApngOptions apngOptions2 = this.mApngOptions;
        URLDrawable apngDrawable = VasApngUtil.getApngDrawable(waitAppRuntime, str, apngOptions2.urlStr, apngOptions2.loadingDrawable, apngOptions2.picTag, apngOptions2.name, bundle);
        if (apngDrawable == null) {
            Log.e(TAG, " load apng is null" + qEffectData.repeat);
            return;
        }
        if (apngDrawable.getCurrDrawable() instanceof ApngDrawable) {
            ((ApngDrawable) apngDrawable.getCurrDrawable()).getImage().apngLoop = qEffectData.repeat;
        }
        complete((Drawable) apngDrawable);
    }

    @Override // com.tencent.qq.effect.impls.QEffectImageView, com.tencent.qq.effect.IQEffect
    public void pause() {
        for (int i3 : this.mApngOptions.picTag) {
            ApngImage.pauseByTag(i3);
        }
    }

    @Override // com.tencent.qq.effect.impls.QEffectImageView, com.tencent.qq.effect.IQEffect
    public void resume() {
        for (int i3 : this.mApngOptions.picTag) {
            ApngImage.playByTag(i3);
        }
    }
}
