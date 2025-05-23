package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x935.oidb_0x935$Color;
import tencent.im.oidb.cmd0x935.oidb_0x935$Label;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Color;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Label;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j {
    static IPatchRedirector $redirector_;

    public static Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.trim().split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    public static List<oidb_0x9fb$Label> b(List<oidb_0x935$Label> list) {
        ArrayList arrayList = new ArrayList();
        for (oidb_0x935$Label oidb_0x935_label : list) {
            oidb_0x9fb$Label oidb_0x9fb_label = new oidb_0x9fb$Label();
            oidb_0x9fb_label.bytes_name.set(oidb_0x935_label.bytes_name.get());
            oidb_0x9fb_label.edging_color.set(c(oidb_0x935_label.edging_color.get()));
            oidb_0x9fb_label.text_color.set(c(oidb_0x935_label.text_color.get()));
            oidb_0x9fb_label.enum_type.set(oidb_0x935_label.enum_type.get());
            oidb_0x9fb_label.uint32_label_attr.set(oidb_0x935_label.uint32_label_attr.get());
            oidb_0x9fb_label.uint32_label_type.set(oidb_0x935_label.uint32_label_type.get());
            arrayList.add(oidb_0x9fb_label);
        }
        return arrayList;
    }

    private static oidb_0x9fb$Color c(oidb_0x935$Color oidb_0x935_color) {
        oidb_0x9fb$Color oidb_0x9fb_color = new oidb_0x9fb$Color();
        oidb_0x9fb_color.uint32_b.set(oidb_0x935_color.uint32_b.get());
        oidb_0x9fb_color.uint32_g.set(oidb_0x935_color.uint32_g.get());
        oidb_0x9fb_color.uint32_r.set(oidb_0x935_color.uint32_r.get());
        return oidb_0x9fb_color;
    }
}
