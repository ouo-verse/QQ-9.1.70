package com.tencent.mobileqq.tianshu;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.tianshu.api.IQQTianshuApi;
import cooperation.vip.ad.i;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/tianshu/a;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    public static final a f293020d = new a();

    a() {
        super(IQQTianshuApi.NAME);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String action, Bundle params, int callbackId) {
        boolean equals$default;
        String str;
        String string;
        equals$default = StringsKt__StringsJVMKt.equals$default(action, "setHalfLayerADParams", false, 2, null);
        if (equals$default) {
            String str2 = "";
            if (params == null || (str = params.getString("setHalfLayerADParams")) == null) {
                str = "";
            }
            if (params != null && (string = params.getString("from")) != null) {
                str2 = string;
            }
            i.q(str, str2 + "_QQTianshuIPCModule");
            callbackResult(callbackId, EIPCResult.createResult(0, new Bundle()));
        }
        return null;
    }
}
