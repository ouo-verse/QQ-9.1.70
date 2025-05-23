package com.tencent.gdtad.kuikly.impl;

import android.content.Context;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.kuikly.IGdtKuiklyAPI;
import com.tencent.gdtad.kuikly.dex.GdtKuiklyDexManager;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.DexResInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.jvm.functions.Function0;

/* loaded from: classes6.dex */
public final class GdtKuiklyAPIImpl implements IGdtKuiklyAPI {
    private static final String TAG = "GdtKuiklyAPIImpl";

    /* loaded from: classes6.dex */
    class a implements Function0<i01.a> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i01.a invoke() {
            QLog.i(GdtKuiklyAPIImpl.TAG, 1, "[registerExternalModule][invoke]");
            return new com.tencent.gdtad.kuikly.module.a();
        }
    }

    @Override // com.tencent.gdtad.kuikly.IGdtKuiklyAPI
    public long getLocalVersion(Context context, String str, String str2) {
        long j3;
        DexResInfo dexResInfo;
        GdtKuiklyDexManager.b bVar = new GdtKuiklyDexManager.b();
        bVar.f109268a = str;
        bVar.f109269b = str2;
        GdtKuiklyDexManager.c f16 = GdtKuiklyDexManager.f(bVar);
        if (f16 != null && (dexResInfo = f16.f109273a) != null && f16.f109274b) {
            j3 = dexResInfo.getResVersion();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        QLog.i(TAG, 1, "[getLocalVersion] bundleName:" + str + " pageName:" + str2 + " localVersion:" + j3);
        return j3;
    }

    @Override // com.tencent.gdtad.kuikly.IGdtKuiklyAPI
    public void init(Context context) {
        com.tencent.gdtad.kuikly.dex.a.c().d();
        an0.a.n().h();
    }

    @Override // com.tencent.gdtad.kuikly.IGdtKuiklyAPI
    public void preDownload(Context context, String str, String str2) {
        com.tencent.gdtad.kuikly.dex.a.c().e(context, str, str2);
    }

    @Override // com.tencent.gdtad.kuikly.IGdtKuiklyAPI
    public void registerExternalModule(b bVar) {
        if (bVar == null) {
            QLog.e(TAG, 1, "[registerExternalModule] error, renderExport is null");
        } else {
            QLog.i(TAG, 1, "[registerExternalModule]");
            bVar.a("GdtKuiklyModule", new a());
        }
    }
}
