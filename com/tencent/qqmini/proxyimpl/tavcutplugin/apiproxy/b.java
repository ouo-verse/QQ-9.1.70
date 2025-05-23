package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import android.graphics.PointF;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.model.LightAssetModel;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0001J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010\u0015\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0005J \u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00122\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\b\u0010'\u001a\u0004\u0018\u00010\u0005J\u001c\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010#\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/b;", "", "obj", "", IECDtReport.ACTION_IDENTIFIER, "Lorg/json/JSONObject;", "f", "Lcom/tencent/tav/coremedia/CMTime;", "cmTime", "e", AdMetricTag.EVENT_NAME, "resultKey", "resultValue", "d", "b", "Lcom/tencent/tavcut/model/LightAssetModel;", "lightAssetModel", "c", "", "bundleList", "targetObj", "a", "jsonObj", "Lcom/tencent/tav/coremedia/CMTimeRange;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/PointF;", DomainData.DOMAIN_NAME, "j", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/c;", "k", "l", "Lcom/tencent/tavcut/composition/model/component/Size;", "o", "Lorg/json/JSONArray;", "fontJsonArray", "Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager;", MosaicConstants$JsProperty.PROP_FILE_MANAGER, "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/k;", tl.h.F, "bundleJsonObject", "g", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/m;", "i", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f347944a = new b();

    b() {
    }

    public final JSONObject a(List<String> bundleList, JSONObject targetObj) throws JSONException {
        Intrinsics.checkNotNullParameter(targetObj, "targetObj");
        if (bundleList != null && !bundleList.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = bundleList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            targetObj.put("lightAbility", jSONArray);
        }
        return targetObj;
    }

    public final Object b(JSONObject obj) throws JSONException {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return nu3.g.f421341a.a(obj.getString(IECDtReport.ACTION_IDENTIFIER));
    }

    public final JSONObject c(LightAssetModel lightAssetModel) throws JSONException {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        if (lightAssetModel == null) {
            return jSONObject;
        }
        List<String> list = lightAssetModel.musicIds;
        boolean z16 = true;
        if (!(list == null || list.isEmpty())) {
            obj = (String) lightAssetModel.musicIds.get(0);
        } else {
            obj = "";
        }
        jSONObject.put("musicId", obj);
        JSONArray jSONArray = new JSONArray();
        List<LightAssetModel.FontAsset> list2 = lightAssetModel.fontAssets;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        }
        if (!z16) {
            for (LightAssetModel.FontAsset fontAsset : lightAssetModel.fontAssets) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("fontFamily", fontAsset.fontFamily);
                jSONObject2.put("fontStyle", fontAsset.fontStyle);
                jSONArray.mo162put(jSONObject2);
            }
        }
        jSONObject.put("fontList", jSONArray);
        LightAssetModel.MaterialConfig materialConfig = lightAssetModel.materialConfig;
        if (materialConfig != null) {
            jSONObject.put("resourceType", materialConfig.type);
            jSONObject.put("minClipAssetCount", materialConfig.minAssetCount);
            jSONObject.put("maxClipAssetCount", materialConfig.maxAssetCount);
            jSONObject.put("minImageDuration", materialConfig.minImageDuration);
            jSONObject.put("maxImageDuration", materialConfig.maxImageDuration);
            jSONObject.put("minVideoDuration", materialConfig.minVideoDuration);
        }
        return jSONObject;
    }

    public final JSONObject d(Object obj, String eventName, String resultKey, Object resultValue) throws JSONException {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(resultKey, "resultKey");
        Intrinsics.checkNotNullParameter(resultValue, "resultValue");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("object", f(obj, nu3.g.f421341a.c(obj)));
        jSONObject.put(AdMetricTag.EVENT_NAME, eventName);
        jSONObject.put(resultKey, resultValue);
        return jSONObject;
    }

    public final JSONObject e(CMTime cmTime) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (cmTime != null) {
            jSONObject.put("value", cmTime.value);
            jSONObject.put("timeScale", cmTime.timeScale);
        }
        return jSONObject;
    }

    public final JSONObject f(Object obj, String identifier) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (obj != null) {
            jSONObject.put(IECDtReport.ACTION_IDENTIFIER, identifier);
            jSONObject.put(PushClientConstants.TAG_CLASS_NAME, obj.getClass().getSimpleName());
        }
        return jSONObject;
    }

    public final List<String> g(JSONObject bundleJsonObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (bundleJsonObject == null) {
            return arrayList;
        }
        JSONArray jSONArray = bundleJsonObject.getJSONArray("lightAbility");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(jSONArray.get(i3).toString());
        }
        return arrayList;
    }

    public final List<TavFont> h(JSONArray fontJsonArray, IMiniAppFileManager fileManager) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (fileManager != null && fontJsonArray != null && fontJsonArray.length() != 0) {
            int length = fontJsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = fontJsonArray.get(i3);
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    String string = jSONObject.getString("fontFamily");
                    if (string == null) {
                        string = "";
                    }
                    String string2 = jSONObject.getString("fontStyle");
                    if (string2 == null) {
                        string2 = "";
                    }
                    String string3 = jSONObject.getString("fontPath");
                    String absolutePath = fileManager.getAbsolutePath(string3 != null ? string3 : "");
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "fileManager.getAbsolutePath(fontPath)");
                    arrayList.add(new TavFont(string, string2, absolutePath));
                }
            }
        }
        return arrayList;
    }

    public final String j(JSONObject jsonObj) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        String string = jsonObj.getString("templateFilePath");
        return string == null ? "" : string;
    }

    public final c k(JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        JSONObject clipResourceListJson = jsonObj.getJSONObject("clipResourceList");
        b bVar = f347944a;
        Intrinsics.checkNotNullExpressionValue(clipResourceListJson, "clipResourceListJson");
        Object b16 = bVar.b(clipResourceListJson);
        if (b16 instanceof c) {
            return (c) b16;
        }
        return null;
    }

    public final CMTime l(JSONObject jsonObj) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        return new CMTime(jsonObj.getInt("value"), jsonObj.getInt("timeScale"));
    }

    public final CMTimeRange m(JSONObject jsonObj) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        JSONObject start = jsonObj.getJSONObject("start");
        JSONObject duration = jsonObj.getJSONObject("duration");
        Intrinsics.checkNotNullExpressionValue(start, "start");
        CMTime l3 = l(start);
        Intrinsics.checkNotNullExpressionValue(duration, "duration");
        return new CMTimeRange(l3, l(duration));
    }

    public final Size o(JSONObject jsonObj) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        return new Size(Integer.valueOf((int) jsonObj.getDouble("width")), Integer.valueOf((int) jsonObj.getDouble("height")), null, 4, null);
    }

    public final PointF n(JSONObject jsonObj) throws JSONException {
        return new PointF((float) (jsonObj != null ? jsonObj.getDouble(HippyTKDListViewAdapter.X) : 0.0d), (float) (jsonObj != null ? jsonObj.getDouble("y") : 0.0d));
    }

    public final TavMusic i(JSONObject jsonObj, IMiniAppFileManager fileManager) throws JSONException {
        if (jsonObj == null || fileManager == null) {
            return null;
        }
        String string = jsonObj.getString("musicId");
        if (string == null) {
            string = "";
        }
        String string2 = jsonObj.getString("musicPath");
        String absolutePath = fileManager.getAbsolutePath(string2 != null ? string2 : "");
        Intrinsics.checkNotNullExpressionValue(absolutePath, "fileManager.getAbsolutePath(musicPath)");
        return new TavMusic(string, absolutePath);
    }
}
