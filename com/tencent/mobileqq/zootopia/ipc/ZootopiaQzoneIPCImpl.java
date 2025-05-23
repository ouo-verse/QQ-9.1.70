package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZplanQzoneApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import com.tencent.zplan.luabridge.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00102\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaQzoneIPCImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/ae;", "Lcom/tencent/mobileqq/zootopia/ipc/ag;", "Lcom/tencent/mobileqq/zootopia/ipc/af;", "", "initForQzone", "Lorg/json/JSONObject;", "value", "openQzonePicList", "getValidUrlByInvalidUrl", "onQzonePicSelected", "onGetValidUrl", "onQzonePicSelectedOnMain", "onGetValidUrlOnMain", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaQzoneIPCImpl implements ae, ag, af {
    public static final String TAG = "ZootopiaQzoneIPCImpl";

    @Override // com.tencent.mobileqq.zootopia.ipc.ag
    public void getValidUrlByInvalidUrl(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.i(TAG, 4, "getValidUrlByInvalidUrl " + value);
        ((IZplanQzoneApi) QRoute.api(IZplanQzoneApi.class)).getValidUrlByInvalidUrl(value);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ag
    public void initForQzone() {
        ((IZplanQzoneApi) QRoute.api(IZplanQzoneApi.class)).initForQzone();
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ae
    public void onGetValidUrl(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.i(TAG, 4, "onGetValidUrl " + value);
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        String jSONObject = value.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "value.toString()");
        a.C10063a.b(zPlanLuaBridge, "N2L_OnGetValidUrl", jSONObject, null, 4, null);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.af
    public void onGetValidUrlOnMain(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ((ae) k74.i.INSTANCE.a(ae.class)).onGetValidUrl(value);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ae
    public void onQzonePicSelected(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.i(TAG, 4, "onQzonePicSelected " + value);
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        String jSONObject = value.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "value.toString()");
        a.C10063a.b(zPlanLuaBridge, "N2L_OnQzonePicSelected", jSONObject, null, 4, null);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.af
    public void onQzonePicSelectedOnMain(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ((ae) k74.i.INSTANCE.a(ae.class)).onQzonePicSelected(value);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.ag
    public void openQzonePicList(JSONObject value) {
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.i(TAG, 4, "openQzonePicList " + value);
        ((IZplanQzoneApi) QRoute.api(IZplanQzoneApi.class)).openQzonePicList(value);
    }
}
