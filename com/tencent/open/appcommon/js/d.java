package com.tencent.open.appcommon.js;

import com.tencent.open.base.j;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    protected static Map<Integer, List<BaseInterface>> f340697a = new HashMap();

    public static void a(WebView webView, String str) {
        try {
            for (BaseInterface baseInterface : f340697a.get(Integer.valueOf(webView.hashCode()))) {
                if (baseInterface != null) {
                    baseInterface.setCurrentUrl(str);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void b(WebView webView) {
        try {
            int hashCode = webView.hashCode();
            List<BaseInterface> list = f340697a.get(Integer.valueOf(hashCode));
            if (list == null) {
                return;
            }
            for (BaseInterface baseInterface : list) {
                if (baseInterface != null) {
                    baseInterface.destroy();
                }
            }
            list.clear();
            f340697a.remove(Integer.valueOf(hashCode));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void c(List<BaseInterface> list, WebView webView, String str, com.tencent.mobileqq.jsbridge.a aVar) {
        if (!j.d(str)) {
            for (BaseInterface baseInterface : list) {
                aVar.c(baseInterface, baseInterface.getInterfaceName());
                c.f340696b.put(baseInterface.getInterfaceName(), baseInterface.getClass());
                baseInterface.setCurrentUrl(str);
            }
        }
        f340697a.put(Integer.valueOf(webView.hashCode()), list);
    }
}
