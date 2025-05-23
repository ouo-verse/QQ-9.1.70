package kr;

import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static Map<String, Object> a() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        return hashMap;
    }

    public static PageParams b(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        return new PageParams(hashMap);
    }

    public static String e(EditVideoParams editVideoParams) {
        if (editVideoParams == null) {
            return "";
        }
        return editVideoParams.n("extra_media_size", "");
    }

    public static int c(EditVideoParams editVideoParams) {
        if (editVideoParams == null) {
            return 5;
        }
        int l3 = editVideoParams.l("uintype", -1);
        if (l3 == 0) {
            return 1;
        }
        if (l3 == 1) {
            return 0;
        }
        if (l3 != 1004) {
            if (l3 == 1008) {
                return 3;
            }
            if (l3 == 3000) {
                return 4;
            }
            if (l3 == 10014 || l3 == 10016) {
                return 6;
            }
            if (l3 != 10007 && l3 != 10008 && l3 != 10010 && l3 != 10011) {
                return 5;
            }
        }
        return 2;
    }

    public static int d(EditVideoParams editVideoParams) {
        if (editVideoParams == null) {
            return -1;
        }
        int i3 = editVideoParams.f204055d;
        int k3 = editVideoParams.k();
        if (i3 != 2) {
            return -1;
        }
        if (k3 == 140 || k3 == 142) {
            return 2;
        }
        if (k3 == 126) {
            return 3;
        }
        if (k3 == 11 || k3 == 9 || k3 == 10) {
            return 1;
        }
        return (k3 == 125 || k3 == 128 || k3 == 130) ? 4 : -1;
    }
}
