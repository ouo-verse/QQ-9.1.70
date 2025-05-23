package com.tencent.mobileqq.wxmini.api.impl;

import com.tencent.mobileqq.wxmini.api.IWxMiniAdAPI;
import com.tencent.qphone.base.util.QLog;
import kotlin.jvm.functions.Function0;

/* loaded from: classes35.dex */
public final class WxMiniAdAPIImpl implements IWxMiniAdAPI {
    private static final String TAG = "WxMiniAdAPIImpl";

    /* loaded from: classes35.dex */
    class a implements Function0<i01.a> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i01.a invoke() {
            QLog.i(WxMiniAdAPIImpl.TAG, 1, "[registerGameCenterKuiklyExternalModule][invoke]");
            return new com.tencent.mobileqq.wxmini.ad.kuikly.module.b();
        }
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniAdAPI
    public void registerGameCenterKuiklyExternalModule(com.tencent.kuikly.core.render.android.b bVar) {
        if (bVar == null) {
            QLog.e(TAG, 1, "[registerGameCenterKuiklyExternalModule] error, renderExport is null");
        } else {
            QLog.i(TAG, 1, "[registerGameCenterKuiklyExternalModule]");
            bVar.a("GdtWXMiniGameKuiklyModule", new a());
        }
    }
}
