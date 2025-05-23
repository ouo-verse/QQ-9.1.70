package com.tencent.qqlive.tvkplayer.tools.utils;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.api.TVKDefinitionType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDefinitionUtils {
    private static final int DEF_ORDER_FHD = 4;
    private static final int DEF_ORDER_HD = 2;
    private static final int DEF_ORDER_HDR = 6;
    private static final int DEF_ORDER_SD = 1;
    private static final int DEF_ORDER_SHD = 3;
    private static final int DEF_ORDER_SUHD = 7;
    private static final int DEF_ORDER_UHD = 5;
    private static final String TAG = "TVKDefinitionUtils";
    private static final List<DefinitionModel> sAllDefinitionDescendList;
    private static final Map<String, DefinitionModel> sDefinitionMap;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class DefinitionModel {
        String code;
        String name;
        int order;

        public DefinitionModel(String str, String str2, int i3) {
            this.code = str;
            this.name = str2;
            this.order = i3;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        sDefinitionMap = hashMap;
        ArrayList arrayList = new ArrayList();
        sAllDefinitionDescendList = arrayList;
        DefinitionModel definitionModel = new DefinitionModel("msd", "\u6d41\u7545 270P", 1);
        DefinitionModel definitionModel2 = new DefinitionModel("sd", "\u6d41\u7545 270P", 1);
        DefinitionModel definitionModel3 = new DefinitionModel("mp4", "\u6807\u6e05 480P", 2);
        DefinitionModel definitionModel4 = new DefinitionModel("hd", "\u6807\u6e05 480P", 2);
        DefinitionModel definitionModel5 = new DefinitionModel("shd", "\u51c6\u9ad8\u6e05 720P", 3);
        DefinitionModel definitionModel6 = new DefinitionModel("fhd", "\u9ad8\u6e05SDR 1080P", 4);
        DefinitionModel definitionModel7 = new DefinitionModel(TVKDefinitionType.DEFINITION_TYPE_FHD10M, "\u9ad8\u6e05SDR 1080P \u9ad8\u7801\u7387", 4);
        DefinitionModel definitionModel8 = new DefinitionModel("uhd", "\u8d85\u9ad8\u6e05SDR 4K", 5);
        DefinitionModel definitionModel9 = new DefinitionModel("hdr10", "\u81fb\u5f69\u89c6\u542c", 6);
        DefinitionModel definitionModel10 = new DefinitionModel(TVKDefinitionType.DEFINITION_TYPE_DOLBYVISION, "\u675c\u6bd4\u89c6\u754c", 6);
        DefinitionModel definitionModel11 = new DefinitionModel(TVKDefinitionType.DEFINITION_TYPE_SUHD, "\u81fb\u5f69\u89c6\u542c", 7);
        hashMap.put(definitionModel.code, definitionModel);
        hashMap.put(definitionModel2.code, definitionModel2);
        hashMap.put(definitionModel3.code, definitionModel3);
        hashMap.put(definitionModel4.code, definitionModel4);
        hashMap.put(definitionModel5.code, definitionModel5);
        hashMap.put(definitionModel6.code, definitionModel6);
        hashMap.put(definitionModel7.code, definitionModel7);
        hashMap.put(definitionModel8.code, definitionModel8);
        hashMap.put(definitionModel9.code, definitionModel9);
        hashMap.put(definitionModel10.code, definitionModel10);
        hashMap.put(definitionModel11.code, definitionModel11);
        arrayList.addAll(hashMap.values());
        Collections.sort(arrayList, new Comparator<DefinitionModel>() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.TVKDefinitionUtils.1
            @Override // java.util.Comparator
            public int compare(DefinitionModel definitionModel12, DefinitionModel definitionModel13) {
                return definitionModel13.order - definitionModel12.order;
            }
        });
    }

    public static String convertDefnName(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace(";(", "  ").replace(")", "");
    }

    public static String getDefShowName(String str) {
        DefinitionModel definitionModel = sDefinitionMap.get(str);
        if (definitionModel == null) {
            TVKLogUtil.e(TAG, "getDefShowName, def=" + str + " has not put into sDefinitionMap");
            return "";
        }
        return definitionModel.name;
    }

    public static List<TVKNetVideoInfo.DefnInfo> getSortedDefnInfoList(List<TVKNetVideoInfo.DefnInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (TVKNetVideoInfo.DefnInfo defnInfo : list) {
                if (!TextUtils.isEmpty(defnInfo.getDefn())) {
                    String defn = defnInfo.getDefn();
                    if ("sd".equalsIgnoreCase(defn) || "hd".equalsIgnoreCase(defn) || "shd".equalsIgnoreCase(defn) || "fhd".equalsIgnoreCase(defn)) {
                        arrayList.add(defnInfo);
                    }
                }
            }
            Collections.sort(arrayList, new Comparator<TVKNetVideoInfo.DefnInfo>() { // from class: com.tencent.qqlive.tvkplayer.tools.utils.TVKDefinitionUtils.2
                @Override // java.util.Comparator
                public int compare(TVKNetVideoInfo.DefnInfo defnInfo2, TVKNetVideoInfo.DefnInfo defnInfo3) {
                    return defnInfo3.getVideoBandwidth() - defnInfo2.getVideoBandwidth() > 0 ? 1 : -1;
                }
            });
            return arrayList;
        }
        TVKLogUtil.w(TAG, " definition list is empty.");
        return Collections.emptyList();
    }

    public static String getSuggestDefinition(String str) {
        if (TVKDefinitionType.DEFINITION_TYPE_ADAPTIVE.equals(str)) {
            return "auto";
        }
        return str;
    }
}
