package oj2;

import java.util.ArrayList;
import java.util.List;
import org.light.device.LightDeviceUtils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f423025a;

    static {
        ArrayList arrayList = new ArrayList();
        f423025a = arrayList;
        arrayList.add("pbem00");
    }

    public static <T> T a(T t16, T t17, T t18) {
        long totalRamMemory = LightDeviceUtils.getTotalRamMemory(com.tencent.mobileqq.qqvideoedit.a.c());
        if (totalRamMemory <= 2147483648L) {
            return t16;
        }
        if (totalRamMemory <= 4294967296L) {
            return t17;
        }
        return t18;
    }
}
