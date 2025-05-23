package com.tencent.mobileqq.ark.module;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.api.notify.GdtNotify;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.zootopia.ark.ZootopiaArkNotify;
import com.tencent.mobileqq.zootopia.ark.ZootopiaResidenceAuthNotify;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppNotifyCenter {
    public static final String TAG = "ArkAppNotifyCenter";
    static boolean inited;
    private static final Object lock;

    @ConfigInject(configPath = "Business/qqark-impl/src/main/resources/Inject_ArkAppNotifyCenter.yml", version = 1)
    private static final HashMap<String, Class<? extends g>> notifyClasses;
    private static final HashMap<String, g> notifyRegs = new HashMap<>();

    static {
        HashMap<String, Class<? extends g>> hashMap = new HashMap<>();
        notifyClasses = hashMap;
        hashMap.put("com.tencent.zplan.motioninvite", p13.b.class);
        hashMap.put("com.tencent.zplan.homelimit", ZootopiaResidenceAuthNotify.class);
        hashMap.put("com.tencent.zplan.giftopening", zc3.a.class);
        hashMap.put(IZootopiaShareArkService.ZOOTOPIA_ARK_NAME, ZootopiaArkNotify.class);
        hashMap.put("com.tencent.qqvip_ams_push", GdtNotify.class);
        hashMap.put("com.tencent.syh.render", GdtNotify.class);
        hashMap.put("com.tencent.syh.ad", GdtNotify.class);
        hashMap.put("com.tencent.gwh.illustrated", GdtNotify.class);
        hashMap.put("com.tencent.gwh.graphic", GdtNotify.class);
        hashMap.put("com.tencent.gwh.video", GdtNotify.class);
        hashMap.put("com.tencent.cmshow.mp", GdtNotify.class);
        hashMap.put("com.tencent.carecomic.update", GdtNotify.class);
        hashMap.put("com.tencent.carecomic.normal", GdtNotify.class);
        hashMap.put("com.tencent.qqcomic.care", GdtNotify.class);
        hashMap.put("com.tencent.pcg.qzone.qqcps", GdtNotify.class);
        hashMap.put("com.tencent.weather", GdtNotify.class);
        hashMap.put("com.tencent.tangram.test", GdtNotify.class);
        hashMap.put("com.tencent.tangram.card", GdtNotify.class);
        hashMap.put("com.tencent.mobileqq.reading", GdtNotify.class);
        hashMap.put("com.tencent.gdt.funPlayView", GdtNotify.class);
        hashMap.put("com.tencent.gdt.IllustratedView", GdtNotify.class);
        hashMap.put("com.tencent.gdt.label", GdtNotify.class);
        hashMap.put("com.tencent.gdt.gouwu", GdtNotify.class);
        hashMap.put("com.tencent.yundong", GdtNotify.class);
        hashMap.put("com.tencent.test.troopapp", com.tencent.mobileqq.ark.api.notify.a.class);
        hashMap.put("com.tencent.troopapp", com.tencent.mobileqq.ark.api.notify.a.class);
        lock = new Object();
        Log.i(TAG, "ArkAppNotifyCenter.cinit");
        init();
        inited = false;
    }

    public static void init() {
        if (inited) {
            return;
        }
        synchronized (lock) {
            if (inited) {
                return;
            }
            inited = true;
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Class<? extends g>> entry : notifyClasses.entrySet()) {
                g gVar = (g) hashMap.get(entry.getValue());
                if (gVar == null) {
                    try {
                        gVar = entry.getValue().newInstance();
                        hashMap.put(entry.getValue(), gVar);
                    } catch (Exception unused) {
                    }
                }
                notifyRegs.put(entry.getKey(), gVar);
            }
        }
    }

    public static boolean notify(final String str, final String str2, final String str3) {
        final g gVar = notifyRegs.get(str);
        if (gVar != null) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ark.module.ArkAppNotifyCenter.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.notify(str, str2, str3);
                }
            });
            return true;
        }
        return false;
    }

    public static void removeNotify(String str) {
        if (!TextUtils.isEmpty(str)) {
            notifyRegs.remove(str);
        }
    }

    public static void setNotify(String str, g gVar) {
        if (gVar != null) {
            notifyRegs.put(str, gVar);
        } else {
            notifyRegs.remove(str);
        }
    }
}
