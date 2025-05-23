package com.tencent.mobileqq.utils;

import android.content.res.AssetManager;
import com.tencent.mobileqq.lzmadecode.LzmaDecode;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bn {

    /* renamed from: a, reason: collision with root package name */
    private static final com.tencent.mobileqq.lzmadecode.b f307493a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements com.tencent.mobileqq.lzmadecode.b {
        a() {
        }
    }

    static {
        a aVar = new a();
        f307493a = aVar;
        LzmaDecode.a(aVar);
        QLog.d("LzmaDecodeHelper", 1, "static set LzmaDecode logger");
    }

    public static int a(AssetManager assetManager, String str, String str2, String str3, String str4) {
        return LzmaDecode.decode(assetManager, str, str2, str3, str4);
    }

    public static int b(String str, String str2) {
        return LzmaDecode.decodeEx(str, str2);
    }

    public static boolean c() {
        boolean decodeBool = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("lzma_decode_feature_switch", false);
        QLog.d("LzmaDecodeHelper", 1, "isUseNewLoad, isToggle: " + decodeBool);
        return decodeBool;
    }
}
