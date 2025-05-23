package com.tencent.hippy.qq.view.video;

import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class VVideoInit {
    public static JSONObject initDefaultVideoData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("muted", false);
            jSONObject.put("autoplay", true);
            jSONObject.put("resize", HVideoConstants.ResizeType.RESIZE_CONTAIN);
            jSONObject.put(ITroopAnnouncementHelperApi.CONTROL_TYPE, 0);
            jSONObject.put("timeupdateRate", 1000);
            jSONObject.put("disableFullScreen", false);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }
}
