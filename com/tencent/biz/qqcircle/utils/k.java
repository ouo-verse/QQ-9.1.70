package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f92774a = Collections.synchronizedSet(new HashSet());

    public static String a(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_571, str);
        if (expEntity == null) {
            return "";
        }
        return expEntity.getAssignment();
    }

    public static String b(String str) {
        ExpEntityInfo expEntityByLayerCode = ABTestController.getInstance().getExpEntityByLayerCode(ABTestController.APPID_571, str);
        if (expEntityByLayerCode == null) {
            return "";
        }
        return expEntityByLayerCode.getAssignment();
    }

    public static String c(String str) {
        ExpEntityInfo expEntityByLayerCode = ABTestController.getInstance().getExpEntityByLayerCode(ABTestController.APPID_571, str);
        if (expEntityByLayerCode == null) {
            return "";
        }
        return expEntityByLayerCode.getExpName();
    }

    public static Map<String, String> d(String str) {
        ExpEntityInfo expEntityByLayerCode = ABTestController.getInstance().getExpEntityByLayerCode(ABTestController.APPID_571, str);
        if (expEntityByLayerCode == null) {
            return new HashMap();
        }
        return expEntityByLayerCode.getTabParams();
    }

    private static boolean e(String str) {
        if (!uq3.o.c2()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Set<String> set = f92774a;
        if (set.contains(str)) {
            return true;
        }
        set.add(str);
        return false;
    }

    public static boolean f(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean g(String str, String str2) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_571, str);
        if (expEntity != null && expEntity.isExpHit(str2)) {
            return true;
        }
        return false;
    }

    public static boolean h(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_571, str);
        if (expEntity != null && expEntity.isExperiment()) {
            return true;
        }
        return false;
    }

    public static void i() {
        if (!uq3.o.c2()) {
            return;
        }
        f92774a.clear();
    }

    public static void j(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_571, str);
        if (expEntity == null || e(str)) {
            return;
        }
        expEntity.reportExpExposure();
        com.tencent.qcircle.cooperation.config.debug.e.a(new com.tencent.qcircle.cooperation.config.debug.e(System.currentTimeMillis(), str, PlayerResources.ViewId.EXTENDED_VIEW_LEFT_TOP_CIRCLE, expEntity.getAssignment()));
    }
}
