package com.tencent.qzonehub.api.panorama;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.ViewUtils;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IPanoramaBallView extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final int HEIGHT;
    public static final int WIDTH;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(23855), (Class<?>) IPanoramaBallView.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            WIDTH = ViewUtils.dpToPx(32.0f);
            HEIGHT = ViewUtils.dpToPx(32.0f);
        }
    }

    int getMoveDegreeX(View view);

    int getMoveDegreeY(View view);

    View getPanoramaBallView(Context context);

    void setDegreeChange(View view, int i3, int i16, int i17, float f16);

    void setModeType(View view, int i3);
}
