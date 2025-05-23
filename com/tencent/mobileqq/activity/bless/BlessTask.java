package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "id")
/* loaded from: classes10.dex */
public class BlessTask extends Entity {
    static IPatchRedirector $redirector_;
    public int cameraMode;
    public String defaultShareTitle;
    public String defaultVoice;
    public int defaultVoiceLength;
    public String entranceBegin;
    public int entranceEnabled;
    public String entranceEnd;
    public String entranceHint;

    /* renamed from: ex1, reason: collision with root package name */
    public String f180570ex1;

    /* renamed from: ex2, reason: collision with root package name */
    public String f180571ex2;

    /* renamed from: ex3, reason: collision with root package name */
    public int f180572ex3;

    /* renamed from: ex4, reason: collision with root package name */
    public int f180573ex4;
    public int festival_id;
    public String filterCategory;
    public String filterId;

    /* renamed from: id, reason: collision with root package name */
    @unique
    public int f180574id;
    public boolean isDeleted;
    public boolean isNew;
    public String mainBanner;
    public String mainCenter;
    public String pendantCategory;
    public String pendantId;
    public int ptvAnimationCost;
    public int ptvAnimationCount;
    public boolean ptvAnimationSwtich;
    public String ptvAnimationUrl;
    public int ptvEnabled;
    public String recentHeadImgUrl;
    public String recentHeadImgUrlSimple;
    public String sendBackBegin;
    public String sendBackEnd;
    public int sendTotalLimit;
    public String shareQzoneTitle;
    public String shareUrl;
    public String shareWeixinTitle;
    public String starAvator;
    public String starAvatorSimple;
    public String starBegin;
    public String starBless;
    public String starEnd;
    public String starVideo;
    public String starVideoCoverFileName;
    public String starVideoCoverFolderName;
    public String starWord;
    public String succeededBanner;
    public int supportFilter;
    public int supportPendant;
    public int supportPhoto;
    public int supportVideo;
    public int task_id;
    public String typeBanner;
    public int uinTotalLimit;
    public int unfoldFilter;
    public int unfoldPendant;
    public int unread;
    public boolean videoPlayed;
    public String webBlessUrl;

    public BlessTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f180574id = 1000;
        this.videoPlayed = false;
        this.isNew = true;
        this.isDeleted = false;
        this.starVideoCoverFolderName = "cover";
        this.starVideoCoverFileName = "cover";
        this.f180570ex1 = "";
        this.f180571ex2 = "";
        this.f180572ex3 = 0;
        this.f180573ex4 = 0;
        this.supportVideo = 1;
        this.supportPhoto = 0;
        this.cameraMode = 0;
        this.supportPendant = 1;
        this.supportFilter = 1;
        this.unfoldPendant = 1;
        this.pendantCategory = HardCodeUtil.qqStr(R.string.k2m);
        this.pendantId = "";
        this.unfoldFilter = 0;
        this.filterCategory = "";
        this.filterId = "";
    }

    public static boolean parse(String str, BlessTask blessTask, ArrayList<BlessPtvModule> arrayList, ArrayList<BlessWording> arrayList2) {
        String str2;
        int i3;
        boolean z16;
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            try {
                blessTask.festival_id = jSONObject.optInt("festival_id", -1);
                blessTask.task_id = jSONObject.optInt("task_id", -1);
                blessTask.entranceEnabled = jSONObject.getInt("mb_open");
                blessTask.ptvEnabled = jSONObject.getInt("mb_ptv_open");
                blessTask.starVideo = jSONObject.getString("mb_star_video");
                blessTask.starAvator = jSONObject.getString("mb_star_avator");
                if (jSONObject.has("mb_star_avator_simple")) {
                    blessTask.starAvatorSimple = jSONObject.getString("mb_star_avator_simple");
                }
                blessTask.starWord = jSONObject.getString("mb_star_word");
                blessTask.starBless = jSONObject.getString("mb_star_bless");
                blessTask.f180571ex2 = jSONObject.getString("mb_star_bless_orange");
                blessTask.f180572ex3 = jSONObject.optInt("use_hint", 0);
                blessTask.entranceHint = jSONObject.getString("mb_hint");
                blessTask.entranceBegin = jSONObject.getString("mb_begin");
                blessTask.entranceEnd = jSONObject.getString("mb_end");
                blessTask.sendBackBegin = jSONObject.getString("mb_return_begin");
                blessTask.sendBackEnd = jSONObject.getString("mb_return_end");
                blessTask.starBegin = jSONObject.getString("mb_star_begin");
                blessTask.starEnd = jSONObject.getString("mb_star_end");
                blessTask.unread = jSONObject.getInt("mb_redpoint");
                blessTask.mainBanner = jSONObject.getString("mb_main_banner");
                blessTask.mainCenter = jSONObject.getString("mb_center_banner");
                blessTask.typeBanner = jSONObject.getString("mb_type_banner");
                blessTask.succeededBanner = jSONObject.getString("mb_succed_banner");
                blessTask.uinTotalLimit = jSONObject.getInt("mb_uin_limit");
                blessTask.sendTotalLimit = jSONObject.getInt("mb_send_limit");
                blessTask.defaultVoiceLength = jSONObject.getInt("mb_default_voice_length");
                blessTask.defaultShareTitle = jSONObject.getString("mb_default_share_title");
                try {
                    blessTask.shareUrl = jSONObject.getString("mb_share_url");
                } catch (Exception unused) {
                    blessTask.shareUrl = "";
                }
                if (jSONObject.has("mb_recent_head")) {
                    blessTask.recentHeadImgUrl = jSONObject.getString("mb_recent_head");
                }
                if (jSONObject.has("mb_recent_head_simple")) {
                    blessTask.recentHeadImgUrlSimple = jSONObject.getString("mb_recent_head_simple");
                }
                if (jSONObject.has("mb_shareQzone_title")) {
                    blessTask.shareQzoneTitle = jSONObject.getString("mb_shareQzone_title");
                }
                if (jSONObject.has("mb_shareWeixin_title")) {
                    blessTask.shareWeixinTitle = jSONObject.getString("mb_shareWeixin_title");
                }
                if (jSONObject.has("mb_ptvAnimation_open")) {
                    if (jSONObject.getInt("mb_ptvAnimation_open") == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    blessTask.ptvAnimationSwtich = z16;
                    if (z16 && jSONObject.has("mb_ptvAnimation_Url") && jSONObject.has("mb_ptvAnimation_repeat_count") && jSONObject.has("mb_ptvAnimation_cost")) {
                        blessTask.ptvAnimationUrl = jSONObject.getString("mb_ptvAnimation_Url");
                        blessTask.ptvAnimationCount = jSONObject.getInt("mb_ptvAnimation_repeat_count");
                        blessTask.ptvAnimationCost = jSONObject.getInt("mb_ptvAnimation_cost");
                    }
                }
                if (jSONObject.has("mb_bless_url")) {
                    blessTask.webBlessUrl = jSONObject.getString("mb_bless_url");
                }
                JSONArray jSONArray = jSONObject.getJSONArray("mb_words");
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    arrayList2.add(new BlessWording(jSONArray.getString(i16)));
                }
                blessTask.defaultVoice = jSONObject.getString("mb_default_voice");
                JSONArray jSONArray2 = jSONObject.getJSONArray("mb_ptvs");
                for (int i17 = 0; i17 < jSONArray2.length(); i17++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i17);
                    arrayList.add(new BlessPtvModule(jSONObject2.getString("mb_name"), jSONObject2.getString("mb_data"), jSONObject2.getString("mb_id"), jSONObject2.getString("mb_viplevel"), jSONObject2.getInt("mb_music_length"), jSONObject2.getString("mb_share_title")));
                }
                if (jSONObject.has("camera_param")) {
                    try {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("camera_param");
                        blessTask.supportVideo = jSONObject3.getInt("support_video");
                        blessTask.supportPhoto = jSONObject3.getInt("support_photo");
                        blessTask.cameraMode = jSONObject3.getInt("camera_mode");
                        blessTask.supportPendant = jSONObject3.getInt("support_pendant");
                        blessTask.unfoldPendant = jSONObject3.getInt("unfold_pendant");
                        blessTask.pendantCategory = jSONObject3.getString("pendant_category");
                        blessTask.pendantId = jSONObject3.getString("pendant_id");
                        blessTask.supportFilter = jSONObject3.getInt("support_filter");
                        blessTask.unfoldFilter = jSONObject3.getInt("unfold_filter");
                        blessTask.filterCategory = jSONObject3.getString("filter_category");
                        blessTask.filterId = jSONObject3.getString(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID);
                        if (blessTask.supportVideo == 0 && blessTask.supportPhoto == 0) {
                            blessTask.supportVideo = 1;
                        }
                    } catch (Exception e16) {
                        str2 = "parse error, ";
                        i3 = 1;
                        try {
                            QLog.e("BlessTask", 1, str2, e16);
                            return true;
                        } catch (Exception e17) {
                            e = e17;
                            QLog.e("BlessTask", i3, str2, e);
                            return false;
                        }
                    }
                }
                return true;
            } catch (Exception e18) {
                e = e18;
                str2 = "parse error, ";
                i3 = 1;
                QLog.e("BlessTask", i3, str2, e);
                return false;
            }
        } catch (Exception e19) {
            e = e19;
            str2 = "parse error, ";
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "-----BlessTask KeyDump-----:,festival_id:" + this.festival_id + ",task_id:" + this.task_id + ",entranceEnabled:" + this.entranceEnabled + ",entranceBegin:" + this.entranceBegin + ",entranceEnd:" + this.entranceEnd + ",ptvEnabled:" + this.ptvEnabled + ",videoPlayed:" + this.videoPlayed + ",uinTotalLimit:" + this.uinTotalLimit + ",sendTotalLimit:" + this.sendTotalLimit + ",unfoldPendant:" + this.unfoldPendant + ",unfoldFilter:" + this.unfoldFilter;
    }
}
