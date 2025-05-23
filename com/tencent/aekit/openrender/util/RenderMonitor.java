package com.tencent.aekit.openrender.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.render.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RenderMonitor {
    static IPatchRedirector $redirector_;
    private static String TAG;
    private static List<String> dumpInfos;
    private static List<String> renderChain;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12617);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TAG = RenderMonitor.class.getSimpleName();
        dumpInfos = new ArrayList();
        renderChain = new ArrayList();
    }

    public RenderMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void end() {
        if (BuildConfig.DEBUG) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("render chain:\n");
            for (int i3 = 0; i3 < renderChain.size(); i3++) {
                sb5.append(String.format("[%s] %s\n", String.valueOf(i3), renderChain.get(i3)));
            }
            LogUtils.i(TAG, sb5.toString());
            for (int i16 = 0; i16 < dumpInfos.size(); i16++) {
                LogUtils.i(TAG, "renderer " + i16 + ":\n" + dumpInfos.get(i16));
            }
        }
    }

    public static void record(String str, String str2) {
        if (BuildConfig.DEBUG) {
            dumpInfos.add(str2);
            renderChain.add(str);
        }
    }

    public static void start() {
        if (BuildConfig.DEBUG) {
            dumpInfos.clear();
            renderChain.clear();
        }
    }
}
