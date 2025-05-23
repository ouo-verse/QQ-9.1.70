package com.tencent.mobileqq.troop.recommend;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Color;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Label;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$Color;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$Label;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    public static String a(List<guildSearchRecommendSvr$Label> list) {
        for (guildSearchRecommendSvr$Label guildsearchrecommendsvr_label : list) {
            if (guildsearchrecommendsvr_label.label_type.get() == 300) {
                return guildsearchrecommendsvr_label.icon.get();
            }
        }
        return null;
    }

    public static List<oidb_0x9fb$Label> b(List<guildSearchRecommendSvr$Label> list) {
        ArrayList arrayList = new ArrayList();
        for (guildSearchRecommendSvr$Label guildsearchrecommendsvr_label : list) {
            oidb_0x9fb$Label oidb_0x9fb_label = new oidb_0x9fb$Label();
            oidb_0x9fb_label.bytes_name.set(guildsearchrecommendsvr_label.bytes_name.get());
            oidb_0x9fb_label.edging_color.set(c(guildsearchrecommendsvr_label.edging_color.get()));
            oidb_0x9fb_label.text_color.set(c(guildsearchrecommendsvr_label.text_color.get()));
            oidb_0x9fb_label.enum_type.set(guildsearchrecommendsvr_label.label_type.get());
            oidb_0x9fb_label.uint32_label_attr.set(guildsearchrecommendsvr_label.label_attr.get());
            oidb_0x9fb_label.uint32_label_type.set(guildsearchrecommendsvr_label.label_type.get());
            arrayList.add(oidb_0x9fb_label);
        }
        return arrayList;
    }

    private static oidb_0x9fb$Color c(guildSearchRecommendSvr$Color guildsearchrecommendsvr_color) {
        oidb_0x9fb$Color oidb_0x9fb_color = new oidb_0x9fb$Color();
        oidb_0x9fb_color.uint32_b.set(guildsearchrecommendsvr_color.uint32_b.get());
        oidb_0x9fb_color.uint32_g.set(guildsearchrecommendsvr_color.uint32_g.get());
        oidb_0x9fb_color.uint32_r.set(guildsearchrecommendsvr_color.uint32_r.get());
        return oidb_0x9fb_color;
    }
}
