package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FlingHelperUtils {
    static IPatchRedirector $redirector_;

    @ConfigInject(configPath = "Foundation/QQCommon/src/main/resources/Inject_FlingGestureConfig.yml", version = 1)
    public static ArrayList<Class<? extends IFlingHelperUtils>> injectClzList;
    public static IFlingHelperUtils utils;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    interface IFlingHelperUtils {
        boolean isDragFrameLayoutClass(View view);

        boolean isInTwoFingerMode(GestureDetector gestureDetector);

        GestureDetector newStickerDismissGestureDetectorInstance(TopGestureLayout topGestureLayout, Context context, GestureDetector.OnGestureListener onGestureListener);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39370);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends IFlingHelperUtils>> arrayList = new ArrayList<>();
        injectClzList = arrayList;
        arrayList.add(TopGestureLayoutUtil.class);
        try {
            if (injectClzList.size() > 0) {
                utils = injectClzList.get(0).newInstance();
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (InstantiationException e17) {
            e17.printStackTrace();
        }
    }

    public FlingHelperUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
