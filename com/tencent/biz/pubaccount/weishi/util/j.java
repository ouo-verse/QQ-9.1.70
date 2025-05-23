package com.tencent.biz.pubaccount.weishi.util;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j {
    private static ArrayList<stSimpleMetaFeed> a(stSimpleMetaFeed stsimplemetafeed) {
        ArrayList<stSimpleMetaFeed> arrayList = new ArrayList<>();
        if (stsimplemetafeed != null) {
            arrayList.add(stsimplemetafeed);
        }
        return arrayList;
    }

    private static stSimpleMetaFeed b(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            jSONObject = null;
        }
        Gson gson = new Gson();
        stSimpleMetaFeed stsimplemetafeed = new stSimpleMetaFeed();
        if (jSONObject != null) {
            stsimplemetafeed.f25129id = jSONObject.optString("id");
            stsimplemetafeed.ding_count = jSONObject.optInt("dingCount");
            stsimplemetafeed.is_ding = jSONObject.optInt("isDing");
            stsimplemetafeed.total_comment_num = jSONObject.optInt("commentNum");
            stsimplemetafeed.material_desc = jSONObject.optString("materialDesc");
            stsimplemetafeed.material_thumburl = jSONObject.optString("materialThumburl");
            stsimplemetafeed.feed_desc = jSONObject.optString("feedDesc");
            stsimplemetafeed.video = (stMetaUgcVideoSeg) gson.fromJson(jSONObject.optJSONObject("video").toString(), stMetaUgcVideoSeg.class);
            stsimplemetafeed.video_url = jSONObject.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
            stMetaUgcImage stmetaugcimage = new stMetaUgcImage();
            stmetaugcimage.url = jSONObject.optString("coverUrl");
            stmetaugcimage.height = jSONObject.optInt("coverHeight");
            stmetaugcimage.width = jSONObject.optInt("coverWidth");
            ArrayList<stMetaUgcImage> arrayList = new ArrayList<>();
            arrayList.add(stmetaugcimage);
            stsimplemetafeed.images = arrayList;
            stsimplemetafeed.poster_id = jSONObject.optString("posterId");
            stsimplemetafeed.poster = (stSimpleMetaPerson) gson.fromJson(jSONObject.optJSONObject(QAdVrReport.ElementID.AD_POSTER).toString(), stSimpleMetaPerson.class);
            stFloatingLayerCardStyle stfloatinglayercardstyle = new stFloatingLayerCardStyle();
            stfloatinglayercardstyle.cardType = 3;
            stsimplemetafeed.floatingLayerCardStyle = stfloatinglayercardstyle;
        }
        return stsimplemetafeed;
    }

    private static JSONObject c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static stSimpleMetaFeed d(JSONObject jSONObject) {
        String optString = jSONObject.optString("feed");
        if (TextUtils.isEmpty(optString)) {
            x.f("ArkJumpUtils", "[ArkJumpUtils.java][getStSimpleMetaFeed] err, strFeed is null!");
            return null;
        }
        stSimpleMetaFeed b16 = b(optString);
        if (b16 != null && !TextUtils.isEmpty(b16.f25129id) && !TextUtils.isEmpty(b16.poster_id)) {
            return b16;
        }
        x.f("ArkJumpUtils", "[ArkJumpUtils.java][getStSimpleMetaFeed] err, feed is err!");
        return null;
    }

    public static void e(String str, String str2) {
        stSimpleMetaFeed d16;
        x.j("ArkJumpUtils", "[ArkJumpUtils.java][handleArkJump] path:" + str + ", metaJson:" + str2);
        JSONObject c16 = c(str2);
        if (c16 != null && (d16 = d(c16)) != null) {
            String optString = c16.optString("groupNum");
            boolean d17 = com.tencent.biz.pubaccount.weishi.net.common.f.d();
            x.j("ArkJumpUtils", "[ArkJumpUtils.java][handleArkJump] studyModeOpen:" + d17);
            if (d17) {
                an.d(1, R.string.x_7);
                com.tencent.biz.pubaccount.weishi.verticalvideo.report.a.b(optString, 1000001, d16);
                return;
            }
            String optString2 = c16.optString("jumpType");
            String optString3 = c16.optString(QZoneDTLoginReporter.SCHEMA);
            if (TextUtils.equals(optString2, "jumpApp") && !TextUtils.isEmpty(optString3) && optString3.startsWith("weishi://") && com.tencent.biz.qqstory.utils.l.c(BaseApplication.getContext())) {
                ao.e(QBaseActivity.sTopActivity, "biz_src_jc_gzh_weishi", optString3);
                com.tencent.biz.pubaccount.weishi.verticalvideo.report.a.b(optString, 1000003, d16);
                return;
            }
            v.b().f();
            v.b().e();
            f(d16, QBaseActivity.sTopActivity);
            WSPublicAccReport.getInstance().enterPublicAccReport(null, 2, "from_qq_chat", null);
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.a.b(optString, 1000001, d16);
            return;
        }
        ToastUtil.a().e("\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
    }

    private static void f(stSimpleMetaFeed stsimplemetafeed, Context context) {
        if (context == null || stsimplemetafeed == null) {
            return;
        }
        a.b.c(new com.tencent.biz.pubaccount.weishi.verticalvideo.k(context, "qqchat", "qqchat").J(a(stsimplemetafeed)).B(true));
    }
}
