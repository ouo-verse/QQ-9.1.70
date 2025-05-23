package com.tencent.qqlive.tvkplayer.logo.utils;

import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKDynamicsLogoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLogoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.logo.impl.TVKLogoCommonDefine;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* loaded from: classes23.dex */
public class TVKLogoInfoParser {
    private static final int DEFAULT_OFFSET = 25;
    private static final String TAG = "TVKLogoInfoParser";

    public static TVKLogoCommonDefine.TVKOriginalLogoInfo getLogoInfoFromVideoInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        String str = null;
        if (!isLogoValid(tVKNetVideoInfo)) {
            return null;
        }
        TVKLogoCommonDefine.TVKOriginalLogoInfo tVKOriginalLogoInfo = new TVKLogoCommonDefine.TVKOriginalLogoInfo();
        if (tVKNetVideoInfo.getCurDefinition() != null) {
            str = tVKNetVideoInfo.getCurDefinition().getDefn();
        }
        tVKOriginalLogoInfo.defn = str;
        tVKOriginalLogoInfo.logoInfoList = tVKNetVideoInfo.getLogoList();
        tVKOriginalLogoInfo.videoW = tVKNetVideoInfo.getWidth();
        tVKOriginalLogoInfo.videoH = tVKNetVideoInfo.getHeight();
        tVKOriginalLogoInfo.vid = tVKNetVideoInfo.getVid();
        tVKOriginalLogoInfo.vodDynamicLogoActionUrl = tVKNetVideoInfo.getVodLogoActionUrl();
        if (tVKNetVideoInfo.getDynamicLogo() != null) {
            tVKOriginalLogoInfo.liveDynamicLogoInfo = tVKNetVideoInfo.getDynamicLogo();
        }
        return tVKOriginalLogoInfo;
    }

    private static boolean isLogoValid(TVKNetVideoInfo tVKNetVideoInfo) {
        if ((tVKNetVideoInfo.getLogoList() == null || tVKNetVideoInfo.getLogoList().size() <= 0) && TextUtils.isEmpty(tVKNetVideoInfo.getVodLogoActionUrl()) && tVKNetVideoInfo.getDynamicLogo() == null) {
            return false;
        }
        return true;
    }

    public static TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews parseDynamicLogoJson(String str) throws Exception {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        TVKLogUtil.i(TAG, "parseDynamicLogoJson, result:" + str);
        if (TextUtils.isEmpty(str) || (optJSONArray = (jSONObject = new JSONObject(str)).optJSONArray("scenes")) == null) {
            return null;
        }
        TVKDynamicsLogoInfo tVKDynamicsLogoInfo = new TVKDynamicsLogoInfo();
        tVKDynamicsLogoInfo.setRunMode(jSONObject.optInt("runmod", 0));
        tVKDynamicsLogoInfo.setDurationMs(jSONObject.optInt("duration", 0));
        tVKDynamicsLogoInfo.setStartTimeMs(jSONObject.optInt("start", 0));
        tVKDynamicsLogoInfo.setScale(jSONObject.optInt("rw", 0));
        tVKDynamicsLogoInfo.setRepeat(jSONObject.optInt("repeat", 0));
        for (TVKDynamicsLogoInfo.Scenes scenes : parseScene(optJSONArray)) {
            Iterator<TVKLogoInfo> it = scenes.getLogoInfoList().iterator();
            while (it.hasNext()) {
                it.next().setVideoMinSideSize(jSONObject.optInt("rw", 0));
            }
            tVKDynamicsLogoInfo.addScenes(scenes);
        }
        TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews tVKDynamicLogoInfoWithImageViews = new TVKLogoCommonDefine.TVKDynamicLogoInfoWithImageViews();
        tVKDynamicLogoInfoWithImageViews.setDynamicsLogoInfo(tVKDynamicsLogoInfo);
        return tVKDynamicLogoInfoWithImageViews;
    }

    private static List<TVKLogoInfo> parseLogoItem(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            TVKLogoInfo tVKLogoInfo = new TVKLogoInfo();
            tVKLogoInfo.setId(jSONObject.optInt("id", 0));
            tVKLogoInfo.setX(jSONObject.optInt(HippyTKDListViewAdapter.X, 0));
            tVKLogoInfo.setY(jSONObject.optInt("y", 0));
            tVKLogoInfo.setWidth(jSONObject.optInt("w", 0));
            tVKLogoInfo.setHeight(jSONObject.optInt(h.F, 0));
            tVKLogoInfo.setAlpha(jSONObject.optInt("a", 100));
            tVKLogoInfo.setMd5(jSONObject.getString("md5"));
            tVKLogoInfo.setLogoUrl(jSONObject.getString("url"));
            tVKLogoInfo.setShow(true);
            arrayList.add(tVKLogoInfo);
        }
        return arrayList;
    }

    private static List<TVKDynamicsLogoInfo.Scenes> parseScene(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            TVKDynamicsLogoInfo.Scenes scenes = new TVKDynamicsLogoInfo.Scenes();
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            scenes.setInTimeMs(jSONObject.optInt("in", 0));
            scenes.setOutTimeMs(jSONObject.optInt("out", 0));
            scenes.setStart(jSONObject.optInt("start"));
            scenes.setEnd(jSONObject.optInt("end"));
            scenes.setLogoInfoList(parseLogoItem(jSONObject.getJSONArray("wi")));
            arrayList.add(scenes);
        }
        return arrayList;
    }
}
