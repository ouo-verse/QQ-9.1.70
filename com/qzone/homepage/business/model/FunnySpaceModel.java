package com.qzone.homepage.business.model;

import NS_MOBILE_FEEDS.FunnySpaceAction;
import NS_MOBILE_MATERIAL.CustomTrackAction;
import com.qzone.util.w;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FunnySpaceModel implements SmartParcelable {
    public static final String EXTRA_KEY_FIRST_FRAME_URL = "love_url";
    public static final String EXTRA_KEY_ICON_URL = "button_pic";
    public static final String EXTRA_KEY_META_JSON = "meta_data";
    public static final String FUNNYSPACE_KEY_CYCLE_END = "cycle_end";
    public static final String FUNNYSPACE_KEY_CYCLE_START = "cycle_start";
    public static final String FUNNYSPACE_KEY_FEED_PIC = "feeds_pic";
    public static final String FUNNYSPACE_KEY_VIBRATION = "vibration";
    public static final String META_KEY_CYCLE = "cycle";
    public static final String META_KEY_CYCLE_END = "end";
    public static final String META_KEY_CYCLE_START = "start";
    public static final String META_KEY_RANK = "rank";
    public static final String META_KEY_SPE_TYPE = "spe_type";
    public static final String META_KEY_VIBRATION = "vibration";

    @NeedParcel
    public ArrayList<Integer> comboIndexList;

    @NeedParcel
    public int cycleEnd;

    @NeedParcel
    public int cycleStart;

    @NeedParcel
    public String feeds_image;

    @NeedParcel
    public String firstFrameUrl;

    @NeedParcel
    public String iconUrl;

    /* renamed from: id, reason: collision with root package name */
    @NeedParcel
    public String f47486id;

    @NeedParcel
    public String likeKey;

    @NeedParcel
    public String metaJson;

    @NeedParcel
    public String name;

    @NeedParcel
    public int rank;

    @NeedParcel
    public boolean spy_type;

    @NeedParcel
    public int type;

    @NeedParcel
    public String url;

    @NeedParcel
    public int[] vibration;

    @NeedParcel
    public int dataSource = 0;

    @NeedParcel
    public int is_block = -1;

    @NeedParcel
    public int itemId = -1;

    public static FunnySpaceModel create(FunnySpaceAction funnySpaceAction) {
        FunnySpaceModel funnySpaceModel = new FunnySpaceModel();
        funnySpaceModel.f47486id = funnySpaceAction.ID;
        funnySpaceModel.type = funnySpaceAction.Type;
        funnySpaceModel.name = funnySpaceAction.Name;
        funnySpaceModel.dataSource = 0;
        funnySpaceModel.likeKey = funnySpaceAction.LikeKey;
        funnySpaceModel.url = funnySpaceAction.Url;
        Map<String, String> map = funnySpaceAction.ExtendInfo;
        if (map != null) {
            funnySpaceModel.firstFrameUrl = map.get(EXTRA_KEY_FIRST_FRAME_URL);
            funnySpaceModel.iconUrl = funnySpaceAction.ExtendInfo.get(EXTRA_KEY_ICON_URL);
            funnySpaceModel.metaJson = funnySpaceAction.ExtendInfo.get("meta_data");
        }
        ArrayList<Integer> arrayList = funnySpaceAction.ComboIndexList;
        if (arrayList != null) {
            funnySpaceModel.comboIndexList = arrayList;
        }
        return funnySpaceModel;
    }

    public static FunnySpaceModel createCustomTrack(CustomTrackAction customTrackAction, int i3) {
        FunnySpaceModel funnySpaceModel = new FunnySpaceModel();
        try {
            funnySpaceModel.f47486id = customTrackAction.ID;
            funnySpaceModel.type = customTrackAction.Type;
            funnySpaceModel.name = customTrackAction.Name;
            funnySpaceModel.likeKey = "";
            funnySpaceModel.dataSource = 1;
            funnySpaceModel.iconUrl = customTrackAction.Button;
            funnySpaceModel.url = customTrackAction.Url;
            funnySpaceModel.is_block = customTrackAction.is_block;
            funnySpaceModel.spy_type = false;
            funnySpaceModel.itemId = i3;
            Map<String, String> map = customTrackAction.ExtendInfo;
            if (map != null && map.size() != 0) {
                HashMap hashMap = (HashMap) customTrackAction.ExtendInfo;
                funnySpaceModel.feeds_image = (String) hashMap.get(FUNNYSPACE_KEY_FEED_PIC);
                String str = (String) hashMap.get(FUNNYSPACE_KEY_CYCLE_START);
                if (str.length() == 0) {
                    funnySpaceModel.cycleStart = 0;
                } else {
                    try {
                        funnySpaceModel.cycleStart = Integer.parseInt(str);
                    } catch (NumberFormatException unused) {
                        funnySpaceModel.cycleStart = 0;
                    }
                }
                String str2 = (String) hashMap.get(FUNNYSPACE_KEY_CYCLE_END);
                if (str2.length() != 0 && !"0".equals(str2)) {
                    try {
                        funnySpaceModel.cycleEnd = Integer.parseInt(str2);
                    } catch (NumberFormatException unused2) {
                        funnySpaceModel.cycleEnd = Integer.MAX_VALUE;
                    }
                } else {
                    funnySpaceModel.cycleEnd = Integer.MAX_VALUE;
                }
                try {
                    funnySpaceModel.rank = Integer.parseInt(funnySpaceModel.f47486id);
                } catch (NumberFormatException unused3) {
                    funnySpaceModel.rank = Integer.MAX_VALUE;
                }
                String str3 = (String) hashMap.get("vibration");
                if (str3 != null && !"0".equals(str3)) {
                    try {
                        JSONArray jSONArray = new JSONArray(str3);
                        funnySpaceModel.vibration = new int[jSONArray.length()];
                        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                            try {
                                funnySpaceModel.vibration[i16] = Integer.parseInt(jSONArray.optString(i16));
                            } catch (NumberFormatException unused4) {
                                funnySpaceModel.vibration[i16] = -2;
                            }
                        }
                    } catch (Exception unused5) {
                        funnySpaceModel.vibration = new int[0];
                    }
                } else {
                    funnySpaceModel.vibration = new int[0];
                }
            }
        } catch (Exception unused6) {
        }
        return funnySpaceModel;
    }

    public int hashCode() {
        return w.b(this.f47486id, Integer.valueOf(this.type), this.name, this.likeKey, this.url, this.firstFrameUrl, this.iconUrl, this.metaJson);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FunnySpaceModel funnySpaceModel = (FunnySpaceModel) obj;
        return this.type == funnySpaceModel.type && w.a(this.f47486id, funnySpaceModel.f47486id) && w.a(this.name, funnySpaceModel.name) && w.a(this.likeKey, funnySpaceModel.likeKey) && w.a(this.url, funnySpaceModel.url) && w.a(this.firstFrameUrl, funnySpaceModel.firstFrameUrl) && w.a(this.iconUrl, funnySpaceModel.iconUrl) && w.a(this.metaJson, funnySpaceModel.metaJson);
    }
}
