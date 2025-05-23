package com.tencent.biz.pubaccount.weishi.verticalvideo.gdt;

import NS_KING_SOCIALIZE_META.stMetaTag;
import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import NS_MOBILE_FEEDS.s_button;
import NS_MOBILE_FEEDS.s_droplist_option;
import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stImgReplacement;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {
    protected static String e(Context context, stSimpleMetaFeed stsimplemetafeed) {
        String str;
        s_button s_buttonVar;
        Map<Integer, String> map;
        stSimpleMetaGdtAdInfo j3 = j(stsimplemetafeed);
        boolean z16 = false;
        if (j3 != null && (map = j3.cookie) != null) {
            str = map.get(0);
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str) && "app".equalsIgnoreCase(str)) {
            z16 = true;
        }
        if (j3 != null && z16 && PackageUtil.isAppInstalled(context, j3.appid)) {
            return "\u6253\u5f00";
        }
        if (j3 != null && (s_buttonVar = j3.bottomButton) != null && !TextUtils.isEmpty(s_buttonVar.text)) {
            return j3.bottomButton.text;
        }
        if (z16) {
            return "\u7acb\u5373\u4e0b\u8f7d";
        }
        return "\u4e86\u89e3\u8be6\u60c5";
    }

    public static String f(GdtAd gdtAd, int i3) {
        if (gdtAd == null) {
            return "";
        }
        try {
            List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap = gdtAd.getExpMap();
            for (int i16 = 0; i16 < expMap.size(); i16++) {
                if (expMap.get(i16).key.get() == i3) {
                    return expMap.get(i16).value.get();
                }
            }
        } catch (Throwable th5) {
            QLog.e("GdtAdUtil", 1, "exp_map error" + th5);
        }
        return "";
    }

    public static void g(Context context, int i3, stSimpleMetaFeed stsimplemetafeed, int i16) {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo videoInfo;
        x.a("GdtAdUtil", 2, "[onItemClick] action=" + i3);
        if (stsimplemetafeed.gdt_ad_info == null) {
            return;
        }
        stSimpleMetaGdtAdInfo stsimplemetagdtadinfo = new stSimpleMetaGdtAdInfo();
        stsimplemetagdtadinfo.customDroplist = new ArrayList<>();
        try {
            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo = d(stsimplemetafeed).display_info;
            if (displayInfo != null && (videoInfo = displayInfo.video_info) != null) {
                stsimplemetagdtadinfo.video_url = videoInfo.video_url.get();
                stsimplemetagdtadinfo.videoId = videoInfo.tencent_video_id.get();
                stsimplemetagdtadinfo.videoClickType = 1;
            }
            s_droplist_option s_droplist_optionVar = new s_droplist_option();
            s_droplist_optionVar.actiontype = 40;
            s_droplist_optionVar.iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
            s_droplist_optionVar.optext = HardCodeUtil.qqStr(R.string.v6g);
            s_droplist_optionVar.reportattach = "option_actiontype=3&";
            s_droplist_optionVar.reporttype = 2001;
            s_droplist_option s_droplist_optionVar2 = new s_droplist_option();
            s_droplist_optionVar2.actiontype = 2;
            s_droplist_optionVar2.iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
            s_droplist_optionVar2.jumpurl = " https://e.qq.com/mo/?from=wsgzh_mo&pid=7020009868695958&aid=763671&tid=iaedv5jxjoynq01";
            s_droplist_optionVar2.optext = HardCodeUtil.qqStr(R.string.v6e);
            s_droplist_optionVar2.reportattach = "option_actiontype=6&";
            stsimplemetagdtadinfo.customDroplist.add(s_droplist_optionVar);
            stsimplemetagdtadinfo.customDroplist.add(s_droplist_optionVar2);
            if (i3 != 131072) {
                x.b("GdtAdUtil", "invalid action, " + i3);
                return;
            }
            h(context, s_droplist_optionVar2);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public static void h(Context context, s_droplist_option s_droplist_optionVar) {
        Activity activity;
        if (context == null) {
            QZLog.w("GdtAdUtil", "[onOpenBrowser] no context");
            return;
        }
        if (s_droplist_optionVar != null && !TextUtils.isEmpty(s_droplist_optionVar.jumpurl)) {
            if (context instanceof BasePluginActivity) {
                activity = (BasePluginActivity) context;
            } else {
                activity = (Activity) context;
            }
            c(activity, s_droplist_optionVar.jumpurl, null, -1);
            return;
        }
        QZLog.w("GdtAdUtil", "[onOpenBrowser] no jumpUrl");
    }

    public static void a(stSimpleMetaFeed stsimplemetafeed) {
        if (stsimplemetafeed != null) {
            try {
                qq_ad_get.QQAdGetRsp.AdInfo d16 = d(stsimplemetafeed);
                if (d16 != null) {
                    GdtPreLoader.c().h(new GdtAd(d16));
                }
            } catch (Throwable th5) {
                x.f("GdtAdUtil", "adPreLoad error: " + th5);
            }
        }
    }

    public static void c(Activity activity, String str, Bundle bundle, int i3) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            if (activity instanceof BasePluginActivity) {
                QZoneHelper.forwardToBrowser(((BasePluginActivity) activity).getOutActivity(), str, i3, bundle, null);
                return;
            } else {
                QZoneHelper.forwardToBrowser(activity, str, i3, bundle, null);
                return;
            }
        }
        QZLog.w("GdtAdUtil", "[forwardToBrowser] invalid parameters, context=" + activity + ", url=" + str);
    }

    public static qq_ad_get.QQAdGetRsp.AdInfo d(stSimpleMetaFeed stsimplemetafeed) {
        if (stsimplemetafeed == null || TextUtils.isEmpty(stsimplemetafeed.gdt_ad_info)) {
            return null;
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
        try {
            return (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(stsimplemetafeed.gdt_ad_info).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0)));
        } catch (Throwable th5) {
            th5.printStackTrace();
            return adInfo;
        }
    }

    public static void b(Context context, stSimpleMetaFeed stsimplemetafeed) {
        qq_ad_get.QQAdGetRsp.AdInfo d16;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo traceInfo;
        if (stsimplemetafeed == null || (d16 = d(stsimplemetafeed)) == null) {
            return;
        }
        stsimplemetafeed.poster = new stSimpleMetaPerson();
        stsimplemetafeed.imgReplacements = new ArrayList<>();
        stsimplemetafeed.new_icon = new stNewIconStyle();
        stsimplemetafeed.video = new stMetaUgcVideoSeg();
        try {
            stsimplemetafeed.floatingLayerCardStyle.cardType = 1002;
            stsimplemetafeed.video_type = 2;
            qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo = d16.report_info;
            if (reportInfo != null && (traceInfo = reportInfo.trace_info) != null && traceInfo.aid != null) {
                stsimplemetafeed.f25129id = String.valueOf(traceInfo.traceid.get());
            }
            i(context, stsimplemetafeed);
            qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo expInfo = d16.exp_info;
            if (expInfo != null) {
                expInfo.qq_game_video_ad_style.get();
            }
            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo = d16.display_info;
            if (displayInfo != null) {
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo advertiserInfo = displayInfo.advertiser_info;
                if (advertiserInfo != null) {
                    stsimplemetafeed.poster.nick = advertiserInfo.corporate_image_name.get();
                    stsimplemetafeed.poster.avatar = advertiserInfo.corporate_logo.get();
                }
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo videoInfo = displayInfo.video_info;
                if (videoInfo != null) {
                    stsimplemetafeed.video_url = videoInfo.video_url.get();
                    stsimplemetafeed.video.duration = videoInfo.media_duration.get() * 1000;
                }
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo = d16.display_info.basic_info;
                stImgReplacement stimgreplacement = new stImgReplacement();
                if (basicInfo == null || stsimplemetafeed.imgReplacements == null || stsimplemetafeed.video == null) {
                    return;
                }
                stsimplemetafeed.feed_desc = basicInfo.txt.get();
                stimgreplacement.img = basicInfo.img.get();
                stimgreplacement.width = basicInfo.pic_width.get();
                stimgreplacement.height = basicInfo.pic_height.get();
                stsimplemetafeed.imgReplacements.add(stimgreplacement);
                stsimplemetafeed.video.width = basicInfo.pic_width.get();
                stsimplemetafeed.video.height = basicInfo.pic_height.get();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static stSimpleMetaGdtAdInfo j(stSimpleMetaFeed stsimplemetafeed) {
        PBEnumField pBEnumField;
        if (stsimplemetafeed == null) {
            return null;
        }
        stSimpleMetaGdtAdInfo stsimplemetagdtadinfo = new stSimpleMetaGdtAdInfo();
        stsimplemetagdtadinfo.floatingLayerCardStyle = new stFloatingLayerCardStyle();
        s_button s_buttonVar = new s_button();
        stsimplemetagdtadinfo.bottomButton = s_buttonVar;
        s_buttonVar.stMapABTest = new HashMap();
        stsimplemetagdtadinfo.user = new stSimpleMetaPerson();
        stsimplemetagdtadinfo.pictureUrl = new stImgReplacement();
        stsimplemetagdtadinfo.left_top_button = new stNewIconStyle();
        qq_ad_get.QQAdGetRsp.AdInfo d16 = d(stsimplemetafeed);
        try {
            stsimplemetagdtadinfo.isWeishiGdtTangramAdv = true;
            stsimplemetagdtadinfo.gdtTangramAdJson = stsimplemetafeed.gdt_ad_info;
            stsimplemetagdtadinfo.cellId = stsimplemetafeed.f25129id;
            stsimplemetagdtadinfo.floatingLayerCardStyle.cardType = 1001;
            ArrayList<stMetaTag> arrayList = stsimplemetafeed.tags;
            if (d16.product_type.get() == 12) {
                HashMap hashMap = new HashMap();
                stsimplemetagdtadinfo.cookie = hashMap;
                hashMap.put(0, "app");
                qq_ad_get.QQAdGetRsp.AdInfo.AppInfo appInfo = d16.app_info;
                if (appInfo != null) {
                    stsimplemetagdtadinfo.appid = appInfo.app_package_name.get();
                }
                stsimplemetagdtadinfo.bottomButton.text = HardCodeUtil.qqStr(R.string.v6b);
            } else {
                stsimplemetagdtadinfo.bottomButton.text = HardCodeUtil.qqStr(R.string.v6d);
            }
            s_button s_buttonVar2 = stsimplemetagdtadinfo.bottomButton;
            s_buttonVar2.button_background_img = "https://qzonestyle.gtimg.cn/aoi/sola/20180427113436_0gqVu4ZoCd.png";
            s_buttonVar2.stMapABTest.put(0, 1);
            stsimplemetagdtadinfo.playType = (byte) 2;
            stsimplemetagdtadinfo.videoType = 1001;
            if (stsimplemetafeed.video != null) {
                stsimplemetagdtadinfo.videoTime = r4.duration;
            }
            qq_ad_get.QQAdGetRsp.AdInfo.ExpInfo expInfo = d16.exp_info;
            if (expInfo != null) {
                expInfo.qq_game_video_ad_style.get();
            }
            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo = d16.display_info;
            if (displayInfo != null) {
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo advertiserInfo = displayInfo.advertiser_info;
                if (advertiserInfo != null) {
                    stsimplemetagdtadinfo.user.nick = advertiserInfo.corporate_image_name.get();
                    stsimplemetagdtadinfo.user.avatar = advertiserInfo.corporate_logo.get();
                }
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo videoInfo = displayInfo.video_info;
                if (videoInfo != null) {
                    stsimplemetagdtadinfo.video_url = videoInfo.video_url.get();
                    stsimplemetagdtadinfo.videoId = videoInfo.tencent_video_id.get();
                    stsimplemetagdtadinfo.videoClickType = 1;
                }
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo = d16.display_info.basic_info;
                if (basicInfo != null) {
                    stsimplemetagdtadinfo.summary = basicInfo.txt.get();
                    PBStringField pBStringField = basicInfo.img;
                    if (pBStringField != null) {
                        stsimplemetagdtadinfo.pictureUrl.img = pBStringField.get();
                        stsimplemetagdtadinfo.pictureUrl.width = basicInfo.pic_width.get();
                        stsimplemetagdtadinfo.pictureUrl.height = basicInfo.pic_height.get();
                    }
                }
                List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo> list = d16.display_info.button_info.get();
                if (list != null && list.size() > 0) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo buttonInfo = list.get(i3);
                        if (buttonInfo != null && (pBEnumField = buttonInfo.pos) != null && pBEnumField.get() == 2) {
                            stsimplemetagdtadinfo.bottomButton.text = buttonInfo.txt.get();
                        }
                    }
                }
            }
            stsimplemetagdtadinfo.customDroplist = new ArrayList<>();
            s_droplist_option s_droplist_optionVar = new s_droplist_option();
            s_droplist_optionVar.actiontype = 40;
            s_droplist_optionVar.iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112610_8Virz5m93z.png";
            s_droplist_optionVar.optext = HardCodeUtil.qqStr(R.string.v6g);
            s_droplist_optionVar.reportattach = "option_actiontype=3&";
            s_droplist_optionVar.reporttype = 2001;
            s_droplist_option s_droplist_optionVar2 = new s_droplist_option();
            s_droplist_optionVar2.actiontype = 2;
            s_droplist_optionVar2.iconurl = "https://qzonestyle.gtimg.cn/aoi/sola/20180522112616_AcTt0SrZ9t.png";
            s_droplist_optionVar2.jumpurl = " https://e.qq.com/mo/?from=wsgzh_mo&pid=7020009868695958&aid=763671&tid=iaedv5jxjoynq01";
            s_droplist_optionVar2.optext = HardCodeUtil.qqStr(R.string.v6e);
            s_droplist_optionVar2.reportattach = "option_actiontype=6&";
            stsimplemetagdtadinfo.customDroplist.add(s_droplist_optionVar);
            stsimplemetagdtadinfo.customDroplist.add(s_droplist_optionVar2);
            qq_ad_get.QQAdGetRsp.AdInfo.DestInfo destInfo = d16.dest_info;
            if (destInfo != null) {
                stsimplemetagdtadinfo.canvasData = destInfo.canvas_json.get();
                stsimplemetagdtadinfo.dest_url = destInfo.landing_page.get();
                stsimplemetagdtadinfo.dest_type = destInfo.dest_type.get();
            }
            qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo = d16.report_info;
            if (reportInfo != null) {
                stsimplemetagdtadinfo.reportUrl = reportInfo.negative_feedback_url.get();
                stsimplemetagdtadinfo.actionUrl = reportInfo.click_url.get();
                stsimplemetagdtadinfo.impressionUrl = reportInfo.exposure_url.get();
                stsimplemetagdtadinfo.isGdtAdImpressionReport = false;
                stsimplemetagdtadinfo.isGdtAdOriginalImpressionReport = false;
            }
            qq_ad_get.QQAdGetRsp.AdInfo.AppInfo appInfo2 = d16.app_info;
            if (appInfo2 != null) {
                stsimplemetagdtadinfo.rankCurrentWithHalfStar = appInfo2.app_score_num.get();
                stsimplemetagdtadinfo.schemaPageUrl = appInfo2.customized_invoke_url.get();
                stsimplemetagdtadinfo.appid = appInfo2.app_package_name.get();
            }
            if (arrayList != null && arrayList.size() > 0) {
                stsimplemetagdtadinfo.left_top_button.img_url = arrayList.get(0).toString();
            }
            stsimplemetagdtadinfo.mapPassBack = stsimplemetafeed.map_pass_back;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return stsimplemetagdtadinfo;
    }

    public static void i(Context context, stSimpleMetaFeed stsimplemetafeed) {
        if (context == null || stsimplemetafeed == null) {
            return;
        }
        String e16 = e(context, stsimplemetafeed);
        if (TextUtils.isEmpty(e16)) {
            return;
        }
        stsimplemetafeed.new_icon.title = e16;
    }
}
