package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.TXLiveBase;
import java.io.File;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes34.dex */
public class cf {

    /* renamed from: a, reason: collision with root package name */
    private static String f347894a = "WXLiveUtils";

    /* renamed from: b, reason: collision with root package name */
    private static volatile Boolean f347895b = Boolean.FALSE;

    public static void b() {
        if (f347895b.booleanValue()) {
            return;
        }
        SoLoad.load(SoLoad.BIZ_TRTC_QQMINI, SoLoadConstants.SONAME_TRTC, new SoLoad.LoadCallback() { // from class: com.tencent.qqmini.proxyimpl.ce
            @Override // com.tencent.mobileqq.soload.api.SoLoad.LoadCallback
            public final void onLoad(boolean z16, String str, String str2) {
                cf.d(z16, str, str2);
            }
        });
    }

    public static boolean c() {
        return f347895b.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(boolean z16, String str, String str2) {
        QLog.i(f347894a, 1, "initTrtc onLoadResult isSuccess:" + z16);
        if (z16) {
            f347895b = Boolean.TRUE;
            e(str2);
        }
    }

    private static void e(String str) {
        QLog.i(f347894a, 1, "setLibraryPath: " + str);
        QLog.i(f347894a, 1, "setLibraryPath file list: " + Arrays.toString(new File(str).list()));
        TXLiveBase.setLibraryPath(str);
    }
}
