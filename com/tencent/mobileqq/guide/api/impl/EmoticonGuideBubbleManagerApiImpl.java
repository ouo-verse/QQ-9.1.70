package com.tencent.mobileqq.guide.api.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.guide.EmoticonGuideBubbleView;
import com.tencent.mobileqq.guide.EmoticonGuideGradientBubbleView;
import com.tencent.mobileqq.guide.a;
import com.tencent.mobileqq.guide.api.IEmoticonGuideBubbleManagerApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonGuideBubbleManagerApiImpl implements IEmoticonGuideBubbleManagerApi {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_GUIDE_GRADIENT_BUBBLE_SWITCH = "aio_emo_guide_gradient_bubble_8996_887613045";
    private static final String TAG = "EmoticonGuideBubbleMgr";

    public EmoticonGuideBubbleManagerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.guide.api.IEmoticonGuideBubbleManagerApi
    public View createEmoticonGuideBubble(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        if (isGradientBubbleAvailable()) {
            return new EmoticonGuideGradientBubbleView(context);
        }
        return new EmoticonGuideBubbleView(context);
    }

    @Override // com.tencent.mobileqq.guide.api.IEmoticonGuideBubbleManagerApi
    public View generateGuideBubble(View view, ViewGroup viewGroup, ViewGroup viewGroup2, View view2, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, view, viewGroup, viewGroup2, view2, map);
        }
        if (view == 0 || viewGroup == null || viewGroup2 == null || view2 == null || !(view instanceof a)) {
            return null;
        }
        return ((a) view).a(viewGroup, viewGroup2, view2, map);
    }

    @Override // com.tencent.mobileqq.guide.api.IEmoticonGuideBubbleManagerApi
    public boolean isGradientBubbleAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(KEY_GUIDE_GRADIENT_BUBBLE_SWITCH, true);
        QLog.i(TAG, 1, "aio_emo_guide_gradient_bubble_8996_887613045:" + isSwitchOn);
        return isSwitchOn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guide.api.IEmoticonGuideBubbleManagerApi
    public void removeGuideBubble(View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) viewGroup);
        } else if (view != 0 && viewGroup != null && (view instanceof a)) {
            ((a) view).b(viewGroup);
        }
    }
}
