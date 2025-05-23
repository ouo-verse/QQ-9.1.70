package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gk;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<d, b> f388106a = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f388107a;

        static {
            int[] iArr = new int[d.values().length];
            f388107a = iArr;
            try {
                iArr[d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f388107a[d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f388107a[d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f388107a[d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f388108a;

        /* renamed from: b, reason: collision with root package name */
        public String f388109b;

        public b(String str, String str2) {
            this.f388108a = str;
            this.f388109b = str2;
        }
    }

    static {
        d(d.ASSEMBLE_PUSH_HUAWEI, new b("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        d(d.ASSEMBLE_PUSH_FCM, new b("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        d(d.ASSEMBLE_PUSH_COS, new b("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        d(d.ASSEMBLE_PUSH_FTOS, new b("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static b a(d dVar) {
        return f388106a.get(dVar);
    }

    public static v b(d dVar) {
        int i3 = a.f388107a[dVar.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return null;
                    }
                    return v.UPLOAD_FTOS_TOKEN;
                }
                return v.UPLOAD_COS_TOKEN;
            }
            return v.UPLOAD_FCM_TOKEN;
        }
        return v.UPLOAD_HUAWEI_TOKEN;
    }

    public static gk c(d dVar) {
        return gk.AggregatePushSwitch;
    }

    private static void d(d dVar, b bVar) {
        if (bVar != null) {
            f388106a.put(dVar, bVar);
        }
    }
}
