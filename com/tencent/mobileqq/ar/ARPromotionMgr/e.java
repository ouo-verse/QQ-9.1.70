package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    static String f196949a;

    private static String a(String str, int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(g());
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(i3);
        sb5.append(str2);
        return sb5.toString();
    }

    public static String b(PromotionConfigInfo.a aVar) {
        PromotionConfigInfo.b bVar;
        if (aVar == null || (bVar = aVar.e().get(0)) == null) {
            return null;
        }
        return c(bVar);
    }

    public static String c(PromotionConfigInfo.b bVar) {
        return bVar.f196906e + "entry" + File.separator;
    }

    public static String d(PromotionConfigInfo.a aVar) {
        PromotionConfigInfo.b bVar = aVar.e().get(0);
        if (bVar == null) {
            return null;
        }
        return e(bVar);
    }

    public static String e(PromotionConfigInfo.b bVar) {
        return bVar.f196906e + "guide" + File.separator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String f(String str, int i3, String str2) {
        return a(str, i3) + str2 + File.separator;
    }

    public static String g() {
        String str;
        if (f196949a == null) {
            if (cu.e()) {
                str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "pddata/prd/ar_promotion" + File.separator;
            } else {
                str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/ar_promotion" + File.separator;
            }
            f196949a = str;
        }
        return f196949a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(String str, int i3, String str2) {
        return a(str, i3) + str2 + ".zip";
    }
}
