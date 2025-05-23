package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import java.util.HashMap;
import java.util.Random;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static final Random f209401a = new Random();

    public static void a(Activity activity, long j3, long j16, long j17) {
        if (!(activity instanceof FMActivity) || !e()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("fm_setContentCost", String.valueOf(j3));
        hashMap.put("fm_inflateCost", String.valueOf(j16));
        hashMap.put("fm_layoutTotalCost", String.valueOf(j17));
        com.tencent.mobileqq.inject.v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "FileSelectorPerformance", hashMap);
    }

    public static void b(long j3) {
        if (!e()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("fm_onCreateCost", String.valueOf(j3));
        com.tencent.mobileqq.inject.v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "FileSelectorPerformance", hashMap);
    }

    public static void c(long j3, long j16, long j17, long j18, long j19, long j26, boolean z16) {
        if (!e()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("media_tab_systemAudioCost", String.valueOf(j3));
        hashMap.put("media_tab_systemVideoCost", String.valueOf(j16));
        hashMap.put("media_tab_sandboxAudioCost", String.valueOf(j17));
        hashMap.put("media_tab_sandboxVideoCost", String.valueOf(j18));
        hashMap.put("media_tab_dataLoadTotalCost", String.valueOf(j19));
        hashMap.put("media_tab_groupCost", String.valueOf(j26));
        hashMap.put("media_tab_is_optimize", String.valueOf(z16 ? 1 : 0));
        com.tencent.mobileqq.inject.v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "FileSelectorPerformance", hashMap);
    }

    public static void d(long j3, long j16, long j17, boolean z16) {
        if (!e()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pic_tab_systemPicCost", String.valueOf(j3));
        hashMap.put("pic_tab_sandboxPicCost", String.valueOf(j16));
        hashMap.put("pic_tab_dataLoadTotalCost", String.valueOf(j17));
        hashMap.put("pic_tab_dataLoad_new_tech", String.valueOf(z16));
        com.tencent.mobileqq.inject.v.c(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "FileSelectorPerformance", hashMap);
    }

    private static boolean e() {
        if (f209401a.nextInt(10) == 0) {
            return true;
        }
        return false;
    }
}
