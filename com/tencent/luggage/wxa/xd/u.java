package com.tencent.luggage.wxa.xd;

import com.tencent.luggage.wxa.wj.e;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.ArrayUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public class u extends p {
    private static final int CTRL_INDEX = 494;
    private static final String NAME = "onViewDidResize";

    public void a(com.tencent.luggage.wxa.kj.v vVar, int i3, int i16, int i17, int i18, int i19, e.b bVar, Map map) {
        HashMap hashMap = new HashMap(10);
        hashMap.put("windowWidth", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(vVar.getContext(), i16)));
        hashMap.put("windowHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(vVar.getContext(), i17)));
        hashMap.put("screenWidth", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(vVar.getContext(), i18)));
        hashMap.put("screenHeight", Integer.valueOf(com.tencent.luggage.wxa.tk.g.a(vVar.getContext(), i19)));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("size", hashMap);
        hashMap2.put("changedWebviewIds", new int[]{i3});
        if (ArrayUtils.contains(e.b.f144275h, bVar)) {
            hashMap2.put("deviceOrientation", "landscape");
        } else if (e.b.PORTRAIT == bVar) {
            hashMap2.put("deviceOrientation", "portrait");
        }
        if (map != null && !map.isEmpty()) {
            hashMap2.put("pageOrientation", new HashMap(map));
        }
        String obj = com.tencent.luggage.wxa.xa.g.a(hashMap2).toString();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandOnViewDidResize[pageOrientation]", "dispatch(%s) with page(%s:%s) data(%s)", getName(), vVar.getAppId(), vVar.A0(), obj);
        setData(obj).setContext(vVar, vVar.getComponentId()).dispatch();
        setData(obj).setContext(vVar.y0(), vVar.getComponentId()).dispatch();
    }
}
