package com.tencent.qqnt.aio.adapter.api.impl;

import com.google.gson.JsonObject;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqcommon.api.INetworkUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IDataLineConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/DataLineConfigApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IDataLineConfigApi;", "()V", "getAutoDownload", "", "setAutoDownload", "", "isOn", "", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class DataLineConfigApiImpl implements IDataLineConfigApi {
    @Override // com.tencent.qqnt.aio.adapter.api.IDataLineConfigApi
    public String getAutoDownload() {
        boolean decodeBool = QMMKV.from(BaseApplicationImpl.sApplication, "common_mmkv_configurations").decodeBool(IDataLineConfigApi.KEY, false);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(IDataLineConfigApi.KEY, Boolean.valueOf(decodeBool || ((INetworkUtilApi) QRoute.api(INetworkUtilApi.class)).isWifi()));
        QLog.i("DataLineConfigApiImpl", 1, "get auto download isON: " + decodeBool + "  isWifi: " + jsonObject);
        String jsonElement = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "json.toString()");
        return jsonElement;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IDataLineConfigApi
    public void setAutoDownload(boolean isOn) {
        QLog.i("DataLineConfigApiImpl", 1, "setAutoDownload: " + isOn);
        QMMKV.from(BaseApplicationImpl.sApplication, "common_mmkv_configurations").encodeBool(IDataLineConfigApi.KEY, isOn);
    }
}
