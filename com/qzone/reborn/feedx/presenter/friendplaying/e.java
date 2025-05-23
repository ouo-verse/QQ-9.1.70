package com.qzone.reborn.feedx.presenter.friendplaying;

import TianShuJce.AdItem;
import TianShuJce.AdPlacementInfo;
import android.text.TextUtils;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellUniverse;
import com.qzone.proxy.feedcomponent.model.PicText;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.proxy.feedcomponent.model.k;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e {
    private static i6.a c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        QLog.e("QZoneFriendPlayingFeedUtil", 1, "[parseListFeedData] bigCardData:", jSONObject);
        com.qzone.feed.business.model.a aVar = new com.qzone.feed.business.model.a();
        aVar.f47117a = 30;
        BusinessADBannerData businessADBannerData = new BusinessADBannerData();
        AdPlacementInfo adPlacementInfo = new AdPlacementInfo();
        businessADBannerData.tianshuAdPlacementInfo = adPlacementInfo;
        adPlacementInfo.lst = new ArrayList<>();
        AdItem adItem = new AdItem();
        adItem.iAdId = jSONObject.optLong("ad_id");
        adItem.traceinfo = jSONObject.optString(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO);
        HashMap hashMap = new HashMap();
        adItem.argList = hashMap;
        hashMap.put("nick", jSONObject.optString("nick"));
        adItem.argList.put("avatar", jSONObject.optString("avatar"));
        adItem.argList.put("title", jSONObject.optString("title"));
        adItem.argList.put(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, "daka");
        adItem.argList.put("jump_url", jSONObject.optString("jump_url"));
        adItem.argList.put("video_type", jSONObject.optString("video_type"));
        adItem.argList.put("video_cover", jSONObject.optString("video_cover"));
        adItem.argList.put("video_url", jSONObject.optString("video_url"));
        adItem.argList.put("vid", jSONObject.optString("vid"));
        adItem.argList.put("subtitle1", jSONObject.optString("subtitle1"));
        adItem.argList.put("subtitle2", jSONObject.optString("subtitle2"));
        adItem.argList.put("appid", jSONObject.optString("game_appid"));
        adItem.argList.put("ad_type", jSONObject.optString("ad_type"));
        adItem.argList.put(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, jSONObject.optString(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT));
        adItem.argList.put("button_jump", jSONObject.optString("button_jump"));
        adItem.argList.put("material_type", jSONObject.optString("material_type"));
        adItem.argList.put("picture", jSONObject.optString("picture"));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_type", 1);
            jSONObject2.put("subscribe_status", 1);
            jSONObject2.put("package_name", jSONObject.optString("pkg_name"));
            JSONArray optJSONArray = jSONObject.optJSONArray(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
            if (optJSONArray != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    jSONArray.mo162put(optJSONArray.getJSONObject(i3).optString("name"));
                }
                jSONObject2.put("game_labels", jSONArray);
            }
            jSONObject2.put("app_type", jSONObject.optString("game_type"));
            jSONObject2.put("subscribe_status", jSONObject.optString("subscribe_status"));
            jSONObject2.put("game_status", jSONObject.optString("online_status"));
            adItem.argList.put("extra_info_1", jSONObject2.toString());
        } catch (Exception e16) {
            QLog.e("QZoneFriendPlayingFeedUtil", 1, "[parseBigCardFeedData] failed:", e16);
        }
        businessADBannerData.tianshuAdPlacementInfo.lst.add(adItem);
        aVar.f47123g = businessADBannerData;
        aVar.f47136t = new BusinessFeedData();
        VideoInfo videoInfo = new VideoInfo();
        VideoUrl videoUrl = new VideoUrl();
        videoUrl.url = jSONObject.optString("video_url");
        videoInfo.videoUrl = videoUrl;
        aVar.f47136t.setVideoInfo(videoInfo);
        aVar.f47123g = businessADBannerData;
        return new i6.a(aVar);
    }

    private static ArrayList<PicText> e(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        QLog.e("QZoneFriendPlayingFeedUtil", 1, "[parseListFeedData] dataList:", jSONArray);
        ArrayList<PicText> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                PicText picText = new PicText();
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                picText.summary = jSONObject.optString("rank_title");
                picText.title = jSONObject.optString(CrashRtInfoHolder.BeaconKey.GAME_NAME);
                picText.actionUrl = jSONObject.optString("button_jump");
                PictureItem pictureItem = new PictureItem();
                pictureItem.currentUrl = new PictureUrl(jSONObject.optString("icon"), 0, 0);
                picText.pictureItem = pictureItem;
                int optInt = jSONObject.optInt("game_type");
                int optInt2 = jSONObject.optInt("online_status");
                int optInt3 = jSONObject.optInt("subscribe_status");
                picText.descBeforeClick = a(optInt, optInt2, optInt3);
                picText.descPostClick = b(optInt, optInt2, optInt3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkg_name", jSONObject.optString("pkg_name"));
                jSONObject2.put("game_type", optInt);
                jSONObject2.put("online_status", optInt2);
                jSONObject2.put("app_id", jSONObject.optString("game_appid"));
                picText.extraInfo = jSONObject2.toString();
                arrayList.add(picText);
            } catch (JSONException e16) {
                QLog.e("QZoneFriendPlayingFeedUtil", 1, "[parseMiniGameFeedData] failed:", e16);
            }
        }
        return arrayList;
    }

    public static k d(CellUniverse cellUniverse) {
        JSONObject optJSONObject;
        String str;
        k kVar = null;
        if (cellUniverse != null && cellUniverse.universeType == 87) {
            if (TextUtils.isEmpty(cellUniverse.jsonTemplate)) {
                QLog.e("QZoneFriendPlayingFeedUtil", 1, "[parseMiniGameFeedData] failed: game json template is empty");
                return null;
            }
            String str2 = cellUniverse.jsonTemplate;
            kVar = new k();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                int optInt = jSONObject.optInt("style");
                kVar.f50335a = optInt;
                if (optInt == 1) {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("big_card");
                    kVar.f50338d = c(optJSONObject2);
                    if (optJSONObject2 != null) {
                        str = optJSONObject2.optString("alg_id");
                    } else {
                        str = "";
                    }
                    kVar.f50337c = str;
                } else if (optInt == 2 && (optJSONObject = jSONObject.optJSONObject("list")) != null) {
                    kVar.f50339e = e(optJSONObject.optJSONArray("item_list"));
                    kVar.f50336b = optJSONObject.optString("jump_url");
                    kVar.f50337c = optJSONObject.optString("alg_id");
                }
            } catch (Exception e16) {
                QLog.e("QZoneFriendPlayingFeedUtil", 1, "[parseMiniGameFeedData] failed:", e16);
            }
        }
        return kVar;
    }

    private static String a(int i3, int i16, int i17) {
        if (i3 == 5) {
            return HardCodeUtil.qqStr(R.string.f1334667);
        }
        if (i3 != 1) {
            return HardCodeUtil.qqStr(R.string.f1334768);
        }
        if (i16 == 1 && i17 != 2) {
            return HardCodeUtil.qqStr(R.string.f1334364);
        }
        if (i16 == 1 && i17 == 2) {
            return HardCodeUtil.qqStr(R.string.f1334465);
        }
        return HardCodeUtil.qqStr(R.string.f1334566);
    }

    private static String b(int i3, int i16, int i17) {
        if (i3 == 1 && i16 == 1 && i17 != 2) {
            return HardCodeUtil.qqStr(R.string.f1334465);
        }
        return null;
    }
}
