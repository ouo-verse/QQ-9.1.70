package com.tencent.biz.pubaccount.weishi.util;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class q {
    public static stSimpleMetaFeed a(String str) {
        try {
            return b(new JSONObject(URLDecoder.decode(str, "UTF-8")));
        } catch (Exception e16) {
            e16.printStackTrace();
            x.f("WSFeedParseUtilsLog", "[WSFeedParseUtils][parseJson2Feed] parse json error: " + e16.getMessage());
            return null;
        }
    }

    private static stSimpleMetaPerson c(JSONObject jSONObject) {
        stSimpleMetaPerson stsimplemetaperson = new stSimpleMetaPerson();
        if (jSONObject != null) {
            stsimplemetaperson.f25130id = jSONObject.optString("id");
            stsimplemetaperson.type = jSONObject.optInt("type");
            stsimplemetaperson.uid = jSONObject.optString("uid");
            stsimplemetaperson.nick = jSONObject.optString("nick");
            stsimplemetaperson.avatar = jSONObject.optString("avatar");
            stsimplemetaperson.followStatus = jSONObject.optInt("followStatus");
        }
        return stsimplemetaperson;
    }

    private static stMetaUgcVideoSeg d(JSONObject jSONObject) {
        stMetaUgcVideoSeg stmetaugcvideoseg = new stMetaUgcVideoSeg();
        if (jSONObject != null) {
            stmetaugcvideoseg.file_id = jSONObject.optString("file_id");
            stmetaugcvideoseg.file_size = jSONObject.optInt("file_size");
            stmetaugcvideoseg.duration = jSONObject.optInt("duration");
            stmetaugcvideoseg.width = jSONObject.optInt("width");
            stmetaugcvideoseg.height = jSONObject.optInt("height");
        }
        return stmetaugcvideoseg;
    }

    private static stSimpleMetaFeed b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        stSimpleMetaFeed stsimplemetafeed = new stSimpleMetaFeed();
        stsimplemetafeed.f25129id = jSONObject.optString("id");
        stsimplemetafeed.ding_count = jSONObject.optInt("dingCount");
        stsimplemetafeed.is_ding = jSONObject.optInt("isDing");
        stsimplemetafeed.total_comment_num = jSONObject.optInt("commentNum");
        stsimplemetafeed.material_desc = jSONObject.optString("materialDesc");
        stsimplemetafeed.material_thumburl = jSONObject.optString("materialThumburl");
        stsimplemetafeed.feed_desc = jSONObject.optString("feedDesc");
        stsimplemetafeed.video = d(jSONObject.optJSONObject("video"));
        stsimplemetafeed.video_url = jSONObject.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
        stMetaUgcImage stmetaugcimage = new stMetaUgcImage();
        stmetaugcimage.url = jSONObject.optString("coverUrl");
        stmetaugcimage.height = jSONObject.optInt("coverHeight");
        stmetaugcimage.width = jSONObject.optInt("coverWidth");
        ArrayList<stMetaUgcImage> arrayList = new ArrayList<>();
        arrayList.add(stmetaugcimage);
        stsimplemetafeed.images = arrayList;
        stsimplemetafeed.poster_id = jSONObject.optString("posterId");
        stsimplemetafeed.poster = c(jSONObject.optJSONObject(QAdVrReport.ElementID.AD_POSTER));
        stFloatingLayerCardStyle stfloatinglayercardstyle = new stFloatingLayerCardStyle();
        stfloatinglayercardstyle.cardType = 3;
        stsimplemetafeed.floatingLayerCardStyle = stfloatinglayercardstyle;
        return stsimplemetafeed;
    }
}
