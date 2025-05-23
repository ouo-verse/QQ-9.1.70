package com.tencent.qq.effect.sensor;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.engine.Layout;
import com.tencent.qq.effect.engine.QEffectData;

/* loaded from: classes22.dex */
public class SensorParams {
    static IPatchRedirector $redirector_;
    public boolean isInit;
    public int layerOffsetX;
    public int layerOffsetY;
    public int[] offsetX;
    public int[] offsetY;
    public float speed;

    public SensorParams(Context context, QEffectData qEffectData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) qEffectData);
            return;
        }
        this.offsetX = new int[1];
        this.offsetY = new int[1];
        this.layerOffsetX = Layout.getLayoutPx(context, qEffectData.offsetX);
        this.layerOffsetY = Layout.getLayoutPx(context, qEffectData.offsetY);
        this.speed = qEffectData.gravitySpeed;
    }
}
