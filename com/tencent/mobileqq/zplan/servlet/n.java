package com.tencent.mobileqq.zplan.servlet;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.model.ZPlanStickerInfo;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/n;", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/n$a;", "", "Lcom/tencent/common/app/AppInterface;", "app", "", "stickerIds", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "Lcom/tencent/mobileqq/zplan/model/ZPlanStickerInfo;", "callback", "", "a", "", "GET_STICKER_CONF", "Ljava/lang/String;", "TAG", "ZPLAN_RESOURCE_MANAGER_SERVICE", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.servlet.n$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/servlet/n$a$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.servlet.n$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9198a implements td3.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ZPlanStickerInfo[]> f335424a;

            C9198a(com.tencent.mobileqq.zootopia.api.e<ZPlanStickerInfo[]> eVar) {
                this.f335424a = eVar;
            }

            @Override // td3.a
            public void a(Integer errCode, String errMsg) {
                QLog.e("ZPlanStickerConfigRequest", 1, "sendJsonRequest failed : errCode == " + errCode + " , errorMessage == " + errMsg);
                com.tencent.mobileqq.zootopia.api.e<ZPlanStickerInfo[]> eVar = this.f335424a;
                int intValue = errCode != null ? errCode.intValue() : -1;
                if (errMsg == null) {
                    errMsg = "";
                }
                eVar.onResultFailure(intValue, errMsg);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // td3.a
            public void onReceive(byte[] data) {
                if (data != null) {
                    try {
                        JSONArray jSONArray = new JSONObject(new String(data, Charsets.UTF_8)).getJSONArray("sticker_confs");
                        ArrayList arrayList = new ArrayList();
                        int length = jSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            ZPlanStickerInfo zPlanStickerInfo = new ZPlanStickerInfo(0, null, 3, null);
                            zPlanStickerInfo.setStickerId(jSONObject.optInt(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID));
                            String jSONObject2 = jSONObject.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject2, "item.toString()");
                            zPlanStickerInfo.setData(jSONObject2);
                            arrayList.add(zPlanStickerInfo);
                        }
                        com.tencent.mobileqq.zootopia.api.e<ZPlanStickerInfo[]> eVar = this.f335424a;
                        Object[] array = arrayList.toArray(new ZPlanStickerInfo[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        eVar.onResultSuccess(array);
                        return;
                    } catch (Exception unused) {
                        QLog.e("ZPlanStickerConfigRequest", 1, "getStickerInfo parser resp fail!");
                    }
                }
                this.f335424a.onResultFailure(-2, "");
            }
        }

        Companion() {
        }

        public final void a(AppInterface app, int[] stickerIds, com.tencent.mobileqq.zootopia.api.e<ZPlanStickerInfo[]> callback) {
            Map emptyMap;
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(stickerIds, "stickerIds");
            Intrinsics.checkNotNullParameter(callback, "callback");
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i3 : stickerIds) {
                jSONArray.put(i3);
            }
            jSONObject.put("stickerIds", jSONArray);
            QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "req.toString()");
            byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            emptyMap = MapsKt__MapsKt.emptyMap();
            IZootopiaProxyServlet.b.a((IZootopiaProxyServlet) api, app, "trpc.metaverse.resource_manage_svr.ResourceManageSvr", "GetStickerConf", bytes, emptyMap, new C9198a(callback), 0, 0, 192, null);
        }
    }
}
