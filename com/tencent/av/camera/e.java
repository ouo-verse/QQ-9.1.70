package com.tencent.av.camera;

import com.tencent.av.utils.af;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.Pair;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static tw.b f73503a;

    public static Pair<Integer, Integer> a(int i3, int i16) {
        boolean b16 = b();
        int i17 = 720;
        int i18 = 1280;
        if (i3 >= 640 && i16 >= 480) {
            if (i3 >= 1920 || i16 >= 1080) {
                i17 = 1080;
                i18 = 1920;
            }
        } else {
            if (b16) {
                i18 = 640;
            }
            if (b16) {
                i17 = 480;
            }
        }
        return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i17));
    }

    private static boolean b() {
        if (f73503a == null) {
            f73503a = new tw.b(af.c("machineMiddleLine"), af.c("machineHighLine"));
        }
        if (f73503a.a() == 3) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        return "1".equalsIgnoreCase(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.use720PCameraPreviewSize.name(), "0"));
    }
}
