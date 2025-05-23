package com.tencent.pts.utils;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* loaded from: classes22.dex */
public class PTSNodeVirtualUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "PTSNodeVirtualUtil";
    private static INodeVirtualOnBindNodeInfo sOnBindNodeInfo;
    private static INodeVirtualOnViewClick sOnViewClick;

    /* loaded from: classes22.dex */
    public interface INodeVirtualOnBindNodeInfo {
        void onBindNodeInfoFinished(String str, View view, String str2, Map<String, Object> map, Map<String, Object> map2);
    }

    /* loaded from: classes22.dex */
    public interface INodeVirtualOnViewClick {
        void onViewClicked(View view);
    }

    public PTSNodeVirtualUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void onBindNodeInfoFinished(String str, View view, String str2, Map<String, Object> map, Map<String, Object> map2) {
        INodeVirtualOnBindNodeInfo iNodeVirtualOnBindNodeInfo = sOnBindNodeInfo;
        if (iNodeVirtualOnBindNodeInfo != null) {
            iNodeVirtualOnBindNodeInfo.onBindNodeInfoFinished(str, view, str2, map, map2);
        }
    }

    public static void onViewClicked(View view) {
        INodeVirtualOnViewClick iNodeVirtualOnViewClick = sOnViewClick;
        if (iNodeVirtualOnViewClick != null) {
            iNodeVirtualOnViewClick.onViewClicked(view);
        }
    }

    public static void register(INodeVirtualOnBindNodeInfo iNodeVirtualOnBindNodeInfo, INodeVirtualOnViewClick iNodeVirtualOnViewClick) {
        sOnBindNodeInfo = iNodeVirtualOnBindNodeInfo;
        sOnViewClick = iNodeVirtualOnViewClick;
    }
}
