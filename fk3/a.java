package fk3;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.resource.api.data.ZPlanResHubIdInfo;
import com.tencent.mobileqq.zplan.resource.api.data.ZPlanResourceDownloadTask;
import com.tencent.mobileqq.zplan.resource.api.data.ZPlanResourceType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.utils.ab;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import com.tencent.zplan.resource.api.a;
import com.tencent.zplan.resource.data.ZPlanUEResInfo;
import cy4.UserAvatarCharacter;
import cy4.ZPlanResourceBusinessData;
import hv4.f;
import hv4.g;
import hv4.i;
import hv4.k;
import hv4.l;
import hv4.m;
import hv4.q;
import hv4.s;
import hv4.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.LogUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;
import vj3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102JR\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J8\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002JF\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00022&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J>\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00112\u0006\u0010\u001b\u001a\u00020\u00022&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0002J8\u0010 \u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0002J\u0016\u0010\"\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002Jf\u0010)\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00022(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010$\u001a\u00020#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'J8\u0010*\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u00022(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006R,\u00100\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u000b0,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lfk3/a;", "", "", "resBizScene", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", QQBrowserActivity.APP_PARAM, "Lhv4/k;", "extReqInfo", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhv4/f;", "callback", "", "p", "l", "downloadInfoRsp", "", "Lcom/tencent/mobileqq/zplan/resource/api/data/c;", "g", "businessScene", "", "Lcom/tencent/zplan/resource/data/ZPlanUEResInfo;", "downloadResultMap", "originalExtInfoBytes", "Lcy4/b;", h.F, "scene", "downloadTaskList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lhv4/h;", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "taskList", DomainData.DOMAIN_NAME, "", "onlyRequestInfo", "Lcom/tencent/zplan/resource/api/a;", "resourceCallback", "Lvj3/b;", "mobileDownloadHandler", "j", "f", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "resDownloadInfoMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a */
    public static final a f399712a = new a();

    /* renamed from: b, reason: from kotlin metadata */
    private static final ConcurrentHashMap<String, Pair<Long, f>> resDownloadInfoMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"fk3/a$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhv4/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements e<f> {

        /* renamed from: d */
        final /* synthetic */ String f399727d;

        /* renamed from: e */
        final /* synthetic */ e<f> f399728e;

        b(String str, e<f> eVar) {
            this.f399727d = str;
            this.f399728e = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a */
        public void onResultSuccess(f result) {
            s[] sVarArr;
            g[] gVarArr;
            Intrinsics.checkNotNullParameter(result, "result");
            String str = this.f399727d;
            i iVar = result.f406417b;
            Integer num = null;
            Integer valueOf = (iVar == null || (gVarArr = iVar.f406431a) == null) ? null : Integer.valueOf(gVarArr.length);
            t tVar = result.f406416a;
            if (tVar != null && (sVarArr = tVar.f406497a) != null) {
                num = Integer.valueOf(sVarArr.length);
            }
            QLog.i("ZPLanSceneResource_Helper", 1, "queryResourceDownloadInfo_Net success, reqKey= " + str + ", resHubSize= " + valueOf + ", urlSize= " + num);
            a.resDownloadInfoMap.put(this.f399727d, new Pair(Long.valueOf(System.currentTimeMillis()), result));
            this.f399728e.onResultSuccess(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPLanSceneResource_Helper", 1, "queryResourceDownloadInfo_Net error, " + error + " - " + message);
            this.f399728e.onResultFailure(error, message);
        }
    }

    a() {
    }

    private final String l(k extReqInfo) {
        hv4.h[] hVarArr;
        StringBuilder sb5 = new StringBuilder("SceneExtInfo");
        if (extReqInfo != null && (hVarArr = extReqInfo.f406443d) != null) {
            for (hv4.h hVar : hVarArr) {
                sb5.append("_");
                sb5.append(hVar.f406429a);
                sb5.append("_");
                sb5.append(hVar.f406430b);
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        return sb6;
    }

    private final String m(int i3, HashMap<String, String> hashMap) {
        String str;
        String str2;
        String str3;
        String b16 = w.f373306a.b();
        String str4 = "";
        if (hashMap == null || (str = hashMap.get(VRReportDefine$ReportParam.AD_MOD_ID)) == null) {
            str = "";
        }
        if (hashMap == null || (str2 = hashMap.get("mod_pack_ver")) == null) {
            str2 = "";
        }
        if (hashMap != null && (str3 = hashMap.get("mod_pack_type")) != null) {
            str4 = str3;
        }
        String str5 = str + "_" + str2 + "_" + str4;
        return "SceneRes_" + b16 + "_" + ab.INSTANCE.b() + "_" + i3 + "_" + str5;
    }

    public final String n(List<ZPlanResourceDownloadTask> list) {
        g resHubInfoDetail;
        StringBuilder sb5 = new StringBuilder();
        for (ZPlanResourceDownloadTask zPlanResourceDownloadTask : list) {
            if (zPlanResourceDownloadTask.getDownloadType() == ZPlanResourceType.ResHubId) {
                sb5.append("ResHub - ");
                ZPlanResHubIdInfo resHubIdInfo = zPlanResourceDownloadTask.getResHubIdInfo();
                if (resHubIdInfo != null && (resHubInfoDetail = resHubIdInfo.getResHubInfoDetail()) != null) {
                    r5 = resHubInfoDetail.f406420a;
                }
                if (r5 == null) {
                    r5 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(r5, "it.resHubIdInfo?.resHubInfoDetail?.resId ?: \"\"");
                }
                sb5.append(r5);
                sb5.append("\n");
            } else if (zPlanResourceDownloadTask.getDownloadType() == ZPlanResourceType.DirectUrl) {
                sb5.append("Url - ");
                s directUrlResource = zPlanResourceDownloadTask.getDirectUrlResource();
                sb5.append(directUrlResource != null ? directUrlResource.f406494b : null);
                sb5.append(" -- ");
                s directUrlResource2 = zPlanResourceDownloadTask.getDirectUrlResource();
                sb5.append(directUrlResource2 != null ? directUrlResource2.f406493a : null);
                sb5.append("\n");
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        return sb6;
    }

    private final List<hv4.h> o(int scene, HashMap<String, String> r222) {
        ArrayList arrayList = new ArrayList();
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(m(scene, r222), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                ((vj3.a) vb3.a.f441346a.a(vj3.a.class)).f(false);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    String appId = optJSONObject.optString("appId", "");
                    String appKey = optJSONObject.optString(com.heytap.mcssdk.a.a.f36102l, "");
                    String env = optJSONObject.optString(MosaicConstants$JsProperty.PROP_ENV, "");
                    String resId = optJSONObject.optString("resId", "");
                    vj3.a aVar = (vj3.a) vb3.a.f441346a.a(vj3.a.class);
                    Intrinsics.checkNotNullExpressionValue(appId, "appId");
                    Intrinsics.checkNotNullExpressionValue(appKey, "appKey");
                    Intrinsics.checkNotNullExpressionValue(env, "env");
                    Intrinsics.checkNotNullExpressionValue(resId, "resId");
                    com.tencent.rdelivery.reshub.api.g c16 = a.C11422a.c(aVar, appId, appKey, env, resId, false, 16, null);
                    if (c16 != null) {
                        hv4.h hVar = new hv4.h();
                        hVar.f406429a = resId;
                        hVar.f406430b = String.valueOf(c16.getVersion());
                        arrayList.add(hVar);
                    }
                }
            } catch (Exception e16) {
                QLog.e("ZPLanSceneResource_Helper", 1, "queryResHubInfoByScene error - " + string, e16);
            }
        }
        return arrayList;
    }

    private final void p(int resBizScene, HashMap<String, String> r112, k extReqInfo, e<f> callback) {
        Set<Map.Entry<String, String>> entrySet;
        String str = resBizScene + "_" + r112 + "_" + l(extReqInfo);
        Pair<Long, f> pair = resDownloadInfoMap.get(str);
        if (pair != null && pair.getFirst().longValue() > 0) {
            int o26 = ZPlanFeatureSwitch.f369852a.o2(resBizScene);
            if (System.currentTimeMillis() - pair.getFirst().longValue() <= o26 * 1000) {
                QLog.e("ZPLanSceneResource_Helper", 1, "queryResourceDownloadInfo useCache, lastRequestTimeStamp= " + pair.getFirst() + ", validSeconds= " + o26);
                callback.onResultSuccess(pair.getSecond());
                return;
            }
        }
        hv4.e eVar = new hv4.e();
        eVar.f406413a = resBizScene;
        if ((r112 != null ? r112.size() : 0) > 0) {
            ArrayList arrayList = new ArrayList();
            if (r112 != null && (entrySet = r112.entrySet()) != null) {
                Iterator<T> it = entrySet.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    vu4.d dVar = new vu4.d();
                    dVar.f443568a = (String) entry.getKey();
                    dVar.f443569b = (String) entry.getValue();
                    arrayList.add(dVar);
                }
            }
            Object[] array = arrayList.toArray(new vu4.d[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            eVar.f406414b = (vu4.d[]) array;
        }
        if (extReqInfo != null) {
            eVar.f406415c = extReqInfo;
        }
        ek3.a.b(ek3.a.f396529a, eVar, new b(str, callback), 0, 4, null);
    }

    public final boolean f(int businessScene, HashMap<String, String> r19) {
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(m(businessScene, r19), "");
        boolean z16 = false;
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 0) {
                return false;
            }
            ((vj3.a) vb3.a.f441346a.a(vj3.a.class)).f(false);
            int length = jSONArray.length();
            boolean z17 = false;
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    String appId = optJSONObject.optString("appId", "");
                    String appKey = optJSONObject.optString(com.heytap.mcssdk.a.a.f36102l, "");
                    String env = optJSONObject.optString(MosaicConstants$JsProperty.PROP_ENV, "");
                    String resId = optJSONObject.optString("resId", "");
                    if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(resId)) {
                        vj3.a aVar = (vj3.a) vb3.a.f441346a.a(vj3.a.class);
                        Intrinsics.checkNotNullExpressionValue(appId, "appId");
                        Intrinsics.checkNotNullExpressionValue(appKey, "appKey");
                        Intrinsics.checkNotNullExpressionValue(env, "env");
                        Intrinsics.checkNotNullExpressionValue(resId, "resId");
                        aVar.w(appId, appKey, env, resId);
                        z17 = true;
                    }
                } catch (Exception e16) {
                    e = e16;
                    z16 = z17;
                    QLog.e("ZPLanSceneResource_Helper", 1, "cancelResHubDownloadByScene error - " + string, e);
                    return z16;
                }
            }
            return z17;
        } catch (Exception e17) {
            e = e17;
        }
    }

    public final void q(int i3, HashMap<String, String> hashMap, List<ZPlanResourceDownloadTask> list) {
        String str;
        String str2;
        String str3;
        g resHubInfoDetail;
        ArrayList<ZPlanResourceDownloadTask> arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ZPlanResourceDownloadTask zPlanResourceDownloadTask = (ZPlanResourceDownloadTask) next;
            if (zPlanResourceDownloadTask.getDownloadType() == ZPlanResourceType.ResHubId && zPlanResourceDownloadTask.getResHubIdInfo() != null) {
                arrayList.add(next);
            }
        }
        String m3 = m(i3, hashMap);
        if (arrayList.isEmpty() && (!list.isEmpty())) {
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).remove(m3);
            return;
        }
        if (!arrayList.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (ZPlanResourceDownloadTask zPlanResourceDownloadTask2 : arrayList) {
                JSONObject jSONObject = new JSONObject();
                ZPlanResHubIdInfo resHubIdInfo = zPlanResourceDownloadTask2.getResHubIdInfo();
                String str4 = "'";
                if (resHubIdInfo == null || (str = resHubIdInfo.getAppId()) == null) {
                    str = "'";
                }
                jSONObject.put("appId", str);
                ZPlanResHubIdInfo resHubIdInfo2 = zPlanResourceDownloadTask2.getResHubIdInfo();
                if (resHubIdInfo2 == null || (str2 = resHubIdInfo2.getAppKey()) == null) {
                    str2 = "'";
                }
                jSONObject.put(com.heytap.mcssdk.a.a.f36102l, str2);
                ZPlanResHubIdInfo resHubIdInfo3 = zPlanResourceDownloadTask2.getResHubIdInfo();
                if (resHubIdInfo3 == null || (str3 = resHubIdInfo3.getEnv()) == null) {
                    str3 = "'";
                }
                jSONObject.put(MosaicConstants$JsProperty.PROP_ENV, str3);
                ZPlanResHubIdInfo resHubIdInfo4 = zPlanResourceDownloadTask2.getResHubIdInfo();
                String str5 = (resHubIdInfo4 == null || (resHubInfoDetail = resHubIdInfo4.getResHubInfoDetail()) == null) ? null : resHubInfoDetail.f406420a;
                if (str5 != null) {
                    Intrinsics.checkNotNullExpressionValue(str5, "it.resHubIdInfo?.resHubInfoDetail?.resId ?: \"'\"");
                    str4 = str5;
                }
                jSONObject.put("resId", str4);
                jSONArray.mo162put(jSONObject);
            }
            IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
            String jSONArray2 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
            iZPlanMMKVApi.setString(m3, jSONArray2);
        }
    }

    public final List<ZPlanResourceDownloadTask> g(f downloadInfoRsp) {
        s[] sVarArr;
        ArrayList arrayList = new ArrayList();
        i iVar = downloadInfoRsp.f406417b;
        if (iVar != null) {
            g[] list = iVar.f406431a;
            if ((list != null ? list.length : 0) > 0 && list != null) {
                Intrinsics.checkNotNullExpressionValue(list, "list");
                for (g resHubItem : list) {
                    if (iVar.f406435e && TextUtils.isEmpty(resHubItem.f406425f)) {
                        QLog.e("ZPLanSceneResource_Helper", 1, "convertDownloadInfo, useBase but url is empty! " + resHubItem);
                    } else {
                        ZPlanResourceType zPlanResourceType = ZPlanResourceType.ResHubId;
                        String str = resHubItem.f406420a;
                        Intrinsics.checkNotNullExpressionValue(str, "resHubItem.resId");
                        boolean z16 = resHubItem.f406424e;
                        String str2 = iVar.f406432b;
                        Intrinsics.checkNotNullExpressionValue(str2, "resHubResources.appId");
                        String str3 = iVar.f406433c;
                        Intrinsics.checkNotNullExpressionValue(str3, "resHubResources.appKey");
                        String str4 = iVar.f406434d;
                        Intrinsics.checkNotNullExpressionValue(str4, "resHubResources.env");
                        boolean z17 = iVar.f406435e;
                        Intrinsics.checkNotNullExpressionValue(resHubItem, "resHubItem");
                        arrayList.add(new ZPlanResourceDownloadTask(zPlanResourceType, str, z16, new ZPlanResHubIdInfo(str2, str3, str4, z17, resHubItem), null));
                    }
                }
            }
        }
        t tVar = downloadInfoRsp.f406416a;
        if (tVar != null && (sVarArr = tVar.f406497a) != null) {
            for (s sVar : sVarArr) {
                ZPlanResourceType zPlanResourceType2 = ZPlanResourceType.DirectUrl;
                String str5 = sVar.f406493a;
                Intrinsics.checkNotNullExpressionValue(str5, "urlResource.url");
                arrayList.add(new ZPlanResourceDownloadTask(zPlanResourceType2, str5, sVar.f406496d, null, sVar));
            }
        }
        return arrayList;
    }

    public final ZPlanResourceBusinessData h(int i3, f fVar, Map<String, ZPlanUEResInfo> map, Object obj) {
        boolean z16;
        Object obj2;
        l[] lVarArr;
        jx4.a aVar;
        l[] lVarArr2;
        m[] mVarArr;
        jx4.b bVar;
        qu4.s[] sVarArr;
        gx4.a aVar2;
        ArrayList arrayList = new ArrayList();
        k kVar = fVar.f406418c;
        if (kVar == null || (sVarArr = kVar.f406441b) == null) {
            z16 = false;
        } else {
            z16 = false;
            for (qu4.s sVar : sVarArr) {
                qu4.a aVar3 = sVar.f429671c;
                if (aVar3 == null) {
                    aVar2 = null;
                } else {
                    try {
                        aVar2 = gx4.a.c(MessageNano.toByteArray(aVar3));
                    } catch (Exception unused) {
                        QLog.e("ZPLanSceneResource_Helper", 1, "convertSceneExtInfo, AvatarCharacter error - " + sVar);
                        aVar2 = null;
                        z16 = true;
                    }
                }
                if (aVar2 != null) {
                    String str = sVar.f429669a;
                    Intrinsics.checkNotNullExpressionValue(str, "it.uin");
                    qu4.h hVar = sVar.f429672d;
                    String str2 = hVar != null ? hVar.f429598b : null;
                    if (str2 == null) {
                        str2 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str2, "it.dressKey?.dressKey ?: \"\"");
                    }
                    arrayList.add(new UserAvatarCharacter(str, aVar2, str2));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        k kVar2 = fVar.f406418c;
        if (kVar2 != null && (mVarArr = kVar2.f406445f) != null) {
            for (m mVar : mVarArr) {
                try {
                    bVar = jx4.b.c(MessageNano.toByteArray(mVar));
                } catch (Exception unused2) {
                    QLog.e("ZPLanSceneResource_Helper", 1, "convertSceneExtInfo, StickerIdConf error - " + mVar);
                    bVar = null;
                    z16 = true;
                }
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
        }
        if (arrayList2.size() == 0) {
            k kVar3 = fVar.f406418c;
            if (((kVar3 == null || (lVarArr2 = kVar3.f406442c) == null) ? 0 : lVarArr2.length) > 0) {
                QLog.e("ZPLanSceneResource_Helper", 1, "!!! convertSceneExtInfo, StickIdConf tmp logic");
                k kVar4 = fVar.f406418c;
                if (kVar4 != null && (lVarArr = kVar4.f406442c) != null) {
                    for (l lVar : lVarArr) {
                        try {
                            aVar = jx4.a.c(MessageNano.toByteArray(lVar));
                        } catch (Exception unused3) {
                            QLog.e("ZPLanSceneResource_Helper", 1, "convertSceneExtInfo, StickerConf error - " + lVar);
                            aVar = null;
                            z16 = true;
                        }
                        if (aVar != null) {
                            jx4.b bVar2 = new jx4.b();
                            bVar2.f411139a = aVar.f411115a;
                            bVar2.f411140b = fx4.b.f(aVar).toString();
                            arrayList2.add(bVar2);
                        }
                    }
                }
            }
        }
        if (z16) {
            QLog.e("ZPLanSceneResource_Helper", 1, "!!! convertSceneExtInfo, hasPbConvertError !!! - " + fVar.f406418c);
        }
        k kVar5 = fVar.f406418c;
        boolean z17 = kVar5 != null ? kVar5.f406440a : false;
        if (obj == null) {
            obj2 = kVar5 != null ? MessageNano.toByteArray(kVar5) : null;
        } else {
            obj2 = obj;
        }
        return new ZPlanResourceBusinessData(i3, z17, arrayList, arrayList2, map, obj2);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"fk3/a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhv4/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fk3.a$a */
    /* loaded from: classes38.dex */
    public static final class C10322a implements e<f> {
        final /* synthetic */ vj3.b C;

        /* renamed from: d */
        final /* synthetic */ long f399714d;

        /* renamed from: e */
        final /* synthetic */ String f399715e;

        /* renamed from: f */
        final /* synthetic */ com.tencent.zplan.resource.api.a f399716f;

        /* renamed from: h */
        final /* synthetic */ int f399717h;

        /* renamed from: i */
        final /* synthetic */ HashMap<String, String> f399718i;

        /* renamed from: m */
        final /* synthetic */ boolean f399719m;

        /* compiled from: P */
        @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0016\u00a8\u0006\u0015"}, d2 = {"fk3/a$a$a", "Lcom/tencent/zplan/resource/api/a;", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Lcy4/c;", "statisticData", "", "c", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "", "errorCode", "", "errorMessage", "totalTaskCount", "failedTaskCount", "d", "", "progress", "completedTaskCount", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: fk3.a$a$a */
        /* loaded from: classes38.dex */
        public static final class C10323a implements com.tencent.zplan.resource.api.a {

            /* renamed from: a */
            final /* synthetic */ long f399720a;

            /* renamed from: b */
            final /* synthetic */ long f399721b;

            /* renamed from: c */
            final /* synthetic */ String f399722c;

            /* renamed from: d */
            final /* synthetic */ long f399723d;

            /* renamed from: e */
            final /* synthetic */ com.tencent.zplan.resource.api.a f399724e;

            /* renamed from: f */
            final /* synthetic */ int f399725f;

            /* renamed from: g */
            final /* synthetic */ f f399726g;

            C10323a(long j3, long j16, String str, long j17, com.tencent.zplan.resource.api.a aVar, int i3, f fVar) {
                this.f399720a = j3;
                this.f399721b = j16;
                this.f399722c = str;
                this.f399723d = j17;
                this.f399724e = aVar;
                this.f399725f = i3;
                this.f399726g = fVar;
            }

            @Override // com.tencent.zplan.resource.api.a
            public void c(ZPlanResourceBusinessData r85, cy4.c statisticData) {
                Intrinsics.checkNotNullParameter(r85, "businessData");
                long currentTimeMillis = System.currentTimeMillis() - this.f399720a;
                long currentTimeMillis2 = System.currentTimeMillis() - this.f399721b;
                QLog.i("ZPLanSceneResource_Helper", 1, this.f399722c + " - FinalDownloadSuccess, netReqCostTime= " + this.f399723d + ", downloadCostTime= " + currentTimeMillis + ", totalCostTime= " + currentTimeMillis2);
                cy4.c cVar = new cy4.c();
                cVar.e(this.f399723d);
                cVar.d(currentTimeMillis);
                cVar.f(currentTimeMillis2);
                com.tencent.zplan.resource.api.a aVar = this.f399724e;
                if (aVar != null) {
                    aVar.c(a.f399712a.h(this.f399725f, this.f399726g, r85.c(), r85.getOriginalExtInfoBytes()), cVar);
                }
            }

            @Override // com.tencent.zplan.resource.api.a
            public void d(ZPlanSceneResourceErrType r102, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
                Intrinsics.checkNotNullParameter(r102, "errType");
                QLog.e("ZPLanSceneResource_Helper", 1, this.f399722c + " - FinalDownloadError - " + r102 + ", errorCode= " + errorCode + ", errorMessage= " + errorMessage + ", totalTaskCount= " + totalTaskCount + ", failedTaskCount= " + failedTaskCount + ", costTime= " + (System.currentTimeMillis() - this.f399721b));
                com.tencent.zplan.resource.api.a aVar = this.f399724e;
                if (aVar != null) {
                    aVar.d(r102, errorCode, errorMessage, totalTaskCount, failedTaskCount);
                }
            }

            @Override // com.tencent.zplan.resource.api.a
            public void f(float progress, int totalTaskCount, int completedTaskCount) {
                a.C10071a.a(this, progress, totalTaskCount, completedTaskCount);
                com.tencent.zplan.resource.api.a aVar = this.f399724e;
                if (aVar != null) {
                    aVar.f(progress, totalTaskCount, completedTaskCount);
                }
            }
        }

        C10322a(long j3, String str, com.tencent.zplan.resource.api.a aVar, int i3, HashMap<String, String> hashMap, boolean z16, vj3.b bVar) {
            this.f399714d = j3;
            this.f399715e = str;
            this.f399716f = aVar;
            this.f399717h = i3;
            this.f399718i = hashMap;
            this.f399719m = z16;
            this.C = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            String str = this.f399715e;
            ZPlanSceneResourceErrType zPlanSceneResourceErrType = ZPlanSceneResourceErrType.QueryResourceError;
            QLog.e("ZPLanSceneResource_Helper", 1, str + " - FinalQueryDownloadResourcesReq error - " + zPlanSceneResourceErrType + ", errorCode= " + error + ", errorMessage= " + message + ", costTime= " + (System.currentTimeMillis() - this.f399714d));
            com.tencent.zplan.resource.api.a aVar = this.f399716f;
            if (aVar != null) {
                aVar.d(zPlanSceneResourceErrType, error, message, 0, 0);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a */
        public void onResultSuccess(f result) {
            Map emptyMap;
            s[] sVarArr;
            g[] gVarArr;
            Intrinsics.checkNotNullParameter(result, "result");
            a aVar = a.f399712a;
            List<ZPlanResourceDownloadTask> g16 = aVar.g(result);
            String n3 = aVar.n(g16);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - this.f399714d;
            String str = this.f399715e;
            i iVar = result.f406417b;
            Integer valueOf = (iVar == null || (gVarArr = iVar.f406431a) == null) ? null : Integer.valueOf(gVarArr.length);
            t tVar = result.f406416a;
            QLog.i("ZPLanSceneResource_Helper", 1, str + " - queryDownloadResourcesReq success, resHubSize= " + valueOf + ", urlSize= " + ((tVar == null || (sVarArr = tVar.f406497a) == null) ? null : Integer.valueOf(sVarArr.length)) + ", totalTaskList ===>  " + n3);
            com.tencent.zplan.resource.api.a aVar2 = this.f399716f;
            bk3.b bVar = aVar2 instanceof bk3.b ? (bk3.b) aVar2 : null;
            if (bVar != null) {
                bVar.a(j3, !g16.isEmpty(), result);
            }
            aVar.q(this.f399717h, this.f399718i, g16);
            if (this.f399719m) {
                com.tencent.zplan.resource.api.a aVar3 = this.f399716f;
                if (aVar3 != null) {
                    int i3 = this.f399717h;
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    ZPlanResourceBusinessData i16 = a.i(aVar, i3, result, emptyMap, null, 8, null);
                    cy4.c cVar = new cy4.c();
                    cVar.e(j3);
                    cVar.f(j3);
                    Unit unit = Unit.INSTANCE;
                    aVar3.c(i16, cVar);
                    return;
                }
                return;
            }
            c cVar2 = c.f399733a;
            String str2 = this.f399715e;
            cVar2.d(str2, g16, new C10323a(currentTimeMillis, this.f399714d, str2, j3, this.f399716f, this.f399717h, result), this.C);
        }
    }

    public static /* synthetic */ void k(a aVar, int i3, HashMap hashMap, k kVar, boolean z16, com.tencent.zplan.resource.api.a aVar2, vj3.b bVar, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            hashMap = new HashMap();
        }
        HashMap hashMap2 = hashMap;
        k kVar2 = (i16 & 4) != 0 ? null : kVar;
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        aVar.j(i3, hashMap2, kVar2, z16, (i16 & 16) != 0 ? null : aVar2, (i16 & 32) != 0 ? null : bVar);
    }

    static /* synthetic */ ZPlanResourceBusinessData i(a aVar, int i3, f fVar, Map map, Object obj, int i16, Object obj2) {
        if ((i16 & 8) != 0) {
            obj = null;
        }
        return aVar.h(i3, fVar, map, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(int businessScene, HashMap<String, String> r17, k extReqInfo, boolean onlyRequestInfo, com.tencent.zplan.resource.api.a resourceCallback, vj3.b mobileDownloadHandler) {
        k kVar;
        String str;
        qu4.a aVar;
        qu4.s[] sVarArr;
        Object orNull;
        qu4.s sVar;
        qu4.s[] sVarArr2;
        Object orNull2;
        HashMap<String, String> hashMap = r17 == null ? new HashMap<>() : r17;
        hashMap.put("ue_env", ab.INSTANCE.d());
        long currentTimeMillis = System.currentTimeMillis();
        List<hv4.h> o16 = o(businessScene, r17);
        if (o16.isEmpty()) {
            kVar = extReqInfo;
        } else {
            k kVar2 = extReqInfo == null ? new k() : extReqInfo;
            Object[] array = o16.toArray(new hv4.h[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            kVar2.f406443d = (hv4.h[]) array;
            kVar = kVar2;
        }
        String str2 = "downloadResourceByScene_" + businessScene + "_" + currentTimeMillis;
        if (extReqInfo != null && (sVarArr2 = extReqInfo.f406441b) != null) {
            orNull2 = ArraysKt___ArraysKt.getOrNull(sVarArr2, 0);
            qu4.s sVar2 = (qu4.s) orNull2;
            if (sVar2 != null) {
                str = sVar2.f429669a;
                if (str == null) {
                    str = "";
                }
                String wrapLogUin = LogUtil.wrapLogUin(str);
                if (extReqInfo != null && (sVarArr = extReqInfo.f406441b) != null) {
                    orNull = ArraysKt___ArraysKt.getOrNull(sVarArr, 0);
                    sVar = (qu4.s) orNull;
                    if (sVar != null) {
                        aVar = sVar.f429671c;
                        boolean z16 = aVar != null;
                        q qVar = extReqInfo != null ? extReqInfo.f406444e : null;
                        QLog.i("ZPLanSceneResource_Helper", 1, str2 + " - BEGIN, extraParams = " + hashMap + ", hasUin= " + wrapLogUin + ", hasAvatarInfo= " + z16 + ", cacheResIdVersion = " + o16 + ", filamentReq = " + qVar + ", readCacheCostTime = " + (System.currentTimeMillis() - currentTimeMillis) + ", onlyRequestInfo = " + onlyRequestInfo);
                        p(businessScene, hashMap, kVar, new C10322a(currentTimeMillis, str2, resourceCallback, businessScene, r17, onlyRequestInfo, mobileDownloadHandler));
                    }
                }
                aVar = null;
                if (aVar != null) {
                }
                if (extReqInfo != null) {
                }
                QLog.i("ZPLanSceneResource_Helper", 1, str2 + " - BEGIN, extraParams = " + hashMap + ", hasUin= " + wrapLogUin + ", hasAvatarInfo= " + z16 + ", cacheResIdVersion = " + o16 + ", filamentReq = " + qVar + ", readCacheCostTime = " + (System.currentTimeMillis() - currentTimeMillis) + ", onlyRequestInfo = " + onlyRequestInfo);
                p(businessScene, hashMap, kVar, new C10322a(currentTimeMillis, str2, resourceCallback, businessScene, r17, onlyRequestInfo, mobileDownloadHandler));
            }
        }
        str = null;
        if (str == null) {
        }
        String wrapLogUin2 = LogUtil.wrapLogUin(str);
        if (extReqInfo != null) {
            orNull = ArraysKt___ArraysKt.getOrNull(sVarArr, 0);
            sVar = (qu4.s) orNull;
            if (sVar != null) {
            }
        }
        aVar = null;
        if (aVar != null) {
        }
        if (extReqInfo != null) {
        }
        QLog.i("ZPLanSceneResource_Helper", 1, str2 + " - BEGIN, extraParams = " + hashMap + ", hasUin= " + wrapLogUin2 + ", hasAvatarInfo= " + z16 + ", cacheResIdVersion = " + o16 + ", filamentReq = " + qVar + ", readCacheCostTime = " + (System.currentTimeMillis() - currentTimeMillis) + ", onlyRequestInfo = " + onlyRequestInfo);
        p(businessScene, hashMap, kVar, new C10322a(currentTimeMillis, str2, resourceCallback, businessScene, r17, onlyRequestInfo, mobileDownloadHandler));
    }
}
