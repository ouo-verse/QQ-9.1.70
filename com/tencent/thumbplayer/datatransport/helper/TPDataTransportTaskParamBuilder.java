package com.tencent.thumbplayer.datatransport.helper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.asset.TPMultiMediaAsset;
import com.tencent.thumbplayer.asset.TPUrlMediaAsset;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class TPDataTransportTaskParamBuilder {
    @Nullable
    public static ArrayList<TPDataTransportTaskParam> buildDataTransportRemuxTaskParam(@NonNull ITPMediaAsset iTPMediaAsset, @NonNull ITPMediaAsset iTPMediaAsset2) {
        if ((iTPMediaAsset instanceof TPUrlMediaAsset) && (iTPMediaAsset2 instanceof TPUrlMediaAsset)) {
            ArrayList<TPDataTransportTaskParam> arrayList = new ArrayList<>();
            TPDataTransportTaskParam buildUrlAssetDataTransportTaskParam = buildUrlAssetDataTransportTaskParam((TPUrlMediaAsset) iTPMediaAsset);
            TPDataTransportTaskParam buildUrlAssetDataTransportTaskParam2 = buildUrlAssetDataTransportTaskParam((TPUrlMediaAsset) iTPMediaAsset2);
            buildUrlAssetDataTransportTaskParam2.getExtraTaskParam().put("dl_param_data_transfer_mode", String.valueOf(1));
            arrayList.add(buildUrlAssetDataTransportTaskParam);
            arrayList.add(buildUrlAssetDataTransportTaskParam2);
            return arrayList;
        }
        return null;
    }

    @Nullable
    public static ArrayList<TPDataTransportTaskParam> buildDataTransportTaskParam(@NonNull ITPMediaAsset iTPMediaAsset) {
        if (iTPMediaAsset instanceof TPMultiMediaAsset) {
            return buildMultiAssetDataTransportTaskParam((TPMultiMediaAsset) iTPMediaAsset);
        }
        if (iTPMediaAsset instanceof TPUrlMediaAsset) {
            ArrayList<TPDataTransportTaskParam> arrayList = new ArrayList<>();
            arrayList.add(buildUrlAssetDataTransportTaskParam((TPUrlMediaAsset) iTPMediaAsset));
            return arrayList;
        }
        return null;
    }

    @NonNull
    private static ArrayList<TPDataTransportTaskParam> buildMultiAssetDataTransportTaskParam(TPMultiMediaAsset tPMultiMediaAsset) {
        ArrayList<TPDataTransportTaskParam> arrayList = new ArrayList<>();
        Iterator<Pair<ITPMediaAsset, Long>> it = tPMultiMediaAsset.getAssetAndClipDurationMsPairList().iterator();
        while (it.hasNext()) {
            ITPMediaAsset iTPMediaAsset = it.next().first;
            if (iTPMediaAsset instanceof TPUrlMediaAsset) {
                arrayList.add(buildUrlAssetDataTransportTaskParam((TPUrlMediaAsset) iTPMediaAsset));
            }
        }
        return arrayList;
    }

    @NonNull
    private static TPDataTransportTaskParam buildUrlAssetDataTransportTaskParam(TPUrlMediaAsset tPUrlMediaAsset) {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList();
        arrayList.add(tPUrlMediaAsset.getUrl());
        ArrayList<Map> arrayList2 = new ArrayList();
        arrayList2.add(tPUrlMediaAsset.getHttpHeader());
        for (Pair<String, Map<String, String>> pair : tPUrlMediaAsset.getBackUrlAndHttpHeaderPairList()) {
            arrayList.add(pair.first);
            arrayList2.add(pair.second);
        }
        JSONArray jSONArray = new JSONArray();
        for (Map map : arrayList2) {
            if (map == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(map);
            }
            jSONArray.mo162put(jSONObject);
        }
        HashMap hashMap = new HashMap(tPUrlMediaAsset.getParamMap());
        hashMap.put("dl_param_url_header", jSONArray.toString());
        return new TPDataTransportTaskParam(arrayList, hashMap);
    }
}
