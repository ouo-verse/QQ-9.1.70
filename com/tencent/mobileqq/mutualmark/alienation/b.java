package com.tencent.mobileqq.mutualmark.alienation;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, Integer> f251966a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73280);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        f251966a = hashMap;
        hashMap.put("skin_icon_small_ship_svip", Integer.valueOf(R.drawable.skin_icon_small_ship_svip));
        f251966a.put("skin_icon_big_ship_svip", Integer.valueOf(R.drawable.skin_icon_big_ship_svip));
        f251966a.put("skin_icon_small_ship_unionvip", Integer.valueOf(R.drawable.skin_icon_small_ship_unionvip));
        f251966a.put("skin_icon_big_ship_unionvip", Integer.valueOf(R.drawable.skin_icon_big_ship_unionvip));
        f251966a.put("skin_icon_small_fire_svip", Integer.valueOf(R.drawable.skin_icon_small_fire_svip));
        f251966a.put("skin_icon_big_fire_svip", Integer.valueOf(R.drawable.skin_icon_big_fire_svip));
        f251966a.put("skin_icon_small_fire_unionvip", Integer.valueOf(R.drawable.skin_icon_small_fire_unionvip));
        f251966a.put("skin_icon_big_fire_unionvip", Integer.valueOf(R.drawable.skin_icon_big_fire_unionvip));
        f251966a.put("skin_icon_intimate_lover_vip_1", Integer.valueOf(R.drawable.skin_icon_intimate_lover_vip_1));
        f251966a.put("skin_icon_intimate_lover_vip_2", Integer.valueOf(R.drawable.skin_icon_intimate_lover_vip_2));
        f251966a.put("skin_icon_intimate_lover_vip_3", Integer.valueOf(R.drawable.skin_icon_intimate_lover_vip_3));
        f251966a.put("hot_reactive_gray_intimate_guimi_svip_1_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_guimi_svip_1_icon));
        f251966a.put("hot_reactive_gray_intimate_guimi_svip_2_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_guimi_svip_2_icon));
        f251966a.put("hot_reactive_gray_intimate_guimi_svip_3_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_guimi_svip_3_icon));
        f251966a.put("hot_reactive_gray_intimate_guimi_unionvip_1_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_guimi_unionvip_1_icon));
        f251966a.put("hot_reactive_gray_intimate_guimi_unionvip_2_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_guimi_unionvip_2_icon));
        f251966a.put("hot_reactive_gray_intimate_guimi_unionvip_3_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_guimi_unionvip_3_icon));
        f251966a.put("hot_reactive_gray_intimate_jiyou_svip_1_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_jiyou_svip_1_icon));
        f251966a.put("hot_reactive_gray_intimate_jiyou_svip_2_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_jiyou_svip_2_icon));
        f251966a.put("hot_reactive_gray_intimate_jiyou_svip_3_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_jiyou_svip_3_icon));
        f251966a.put("hot_reactive_gray_intimate_jiyou_unionvip_1_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_jiyou_unionvip_1_icon));
        f251966a.put("hot_reactive_gray_intimate_jiyou_unionvip_2_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_jiyou_unionvip_2_icon));
        f251966a.put("hot_reactive_gray_intimate_jiyou_unionvip_3_icon", Integer.valueOf(R.drawable.hot_reactive_gray_intimate_jiyou_unionvip_3_icon));
    }
}
