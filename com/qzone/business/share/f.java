package com.qzone.business.share;

import android.app.Activity;
import android.text.TextUtils;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.activities.base.ch;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.DetailDataOutShare;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.proxy.feedcomponent.text.TextCellParser;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f44794a;

    /* renamed from: b, reason: collision with root package name */
    private BusinessFeedData f44795b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f44796c;

    /* renamed from: d, reason: collision with root package name */
    public long f44797d;

    /* renamed from: e, reason: collision with root package name */
    public int f44798e;

    /* renamed from: f, reason: collision with root package name */
    public String f44799f;

    /* renamed from: g, reason: collision with root package name */
    public String f44800g;

    f(int i3) {
        this.f44794a = i3;
    }

    public static f b() {
        return new f(349);
    }

    public static f c() {
        return new f(200);
    }

    public f d(BusinessFeedData businessFeedData) {
        this.f44795b = businessFeedData;
        return this;
    }

    public f e(BusinessFeedData businessFeedData, String str) {
        this.f44795b = businessFeedData;
        this.f44800g = str;
        return this;
    }

    public f f(BusinessFeedData businessFeedData, boolean z16, long j3, int i3, String str) {
        this.f44795b = businessFeedData;
        this.f44796c = z16;
        this.f44797d = j3;
        this.f44798e = i3;
        this.f44799f = str;
        return this;
    }

    public f g(BusinessFeedData businessFeedData, boolean z16, long j3, int i3, String str, String str2) {
        this.f44795b = businessFeedData;
        this.f44796c = z16;
        this.f44797d = j3;
        this.f44798e = i3;
        this.f44799f = str;
        this.f44800g = str2;
        return this;
    }

    public void a(Activity activity, String str, String str2) {
        DetailDataOutShare detailDataOutShare;
        VideoInfo videoInfo;
        User user;
        CellFeedCommInfo cellFeedCommInfo;
        BusinessFeedData businessFeedData = this.f44795b;
        if (businessFeedData == null || businessFeedData.getOperationInfo() == null || (detailDataOutShare = this.f44795b.getOperationInfo().shareData) == null) {
            return;
        }
        String plainText = TextCellParser.toPlainText(detailDataOutShare.sTitle);
        String plainText2 = TextCellParser.toPlainText(detailDataOutShare.sSummary);
        String str3 = TextUtils.isEmpty(str) ? "m.qzone.com" : str;
        if (TextUtils.isEmpty(plainText2)) {
            plainText2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ClickToLookUp", "\u70b9\u51fb\u67e5\u770b");
        }
        String c16 = ch.c(detailDataOutShare.mapPhotoUrl);
        int indexOf = c16.indexOf("#");
        if (indexOf >= 0) {
            c16 = c16.substring(0, indexOf);
        }
        if (this.f44795b.getVideoInfo() != null && this.f44795b.getVideoInfo().videoUrl != null && !TextUtils.isEmpty(this.f44795b.getVideoInfo().videoUrl.url)) {
            videoInfo = this.f44795b.getVideoInfo();
            user = this.f44795b.getUser();
            cellFeedCommInfo = this.f44795b.getFeedCommInfoV2();
        } else if (this.f44795b.getOriginalInfo() == null || this.f44795b.getOriginalInfo().getVideoInfo() == null || this.f44795b.getOriginalInfo().getVideoInfo().videoUrl == null || TextUtils.isEmpty(this.f44795b.getOriginalInfo().getVideoInfo().videoUrl.url)) {
            videoInfo = null;
            user = null;
            cellFeedCommInfo = null;
        } else {
            videoInfo = this.f44795b.getOriginalInfo().getVideoInfo();
            user = this.f44795b.getOriginalInfo().getUser();
            cellFeedCommInfo = this.f44795b.getOriginalInfo().getFeedCommInfoV2();
        }
        if (com.qzone.proxy.feedcomponent.util.f.c(this.f44795b)) {
            ShareUtils.e eVar = new ShareUtils.e();
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "GiveRedPacket", "\u6b63\u5728\u7a7a\u95f4\u53d1\u653e\u7ea2\u5305");
            eVar.f44740a = str3;
            eVar.f44711h = 2;
            eVar.f44712i = str2;
            eVar.f44713j = 1;
            eVar.f44741b = this.f44795b.getCellUserInfo().getUser().nickName + config;
            if (com.qzone.proxy.feedcomponent.util.f.a(this.f44795b)) {
                eVar.f44741b = this.f44795b.getOriginalInfo().getCellUserInfo().getUser().nickName + config;
            }
            eVar.f44742c = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "GetImmediately", "\u901f\u6765\u9886\u53d6>>");
            eVar.f44714k = activity.getString(R.string.gg_);
            eVar.f44715l = true;
            eVar.f44743d = "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_redpocket_share_to_qq_1.png";
            ShareUtils.n(activity, eVar, 0);
            return;
        }
        if (videoInfo != null && !this.f44795b.isLiveVideoFeed() && TextUtils.isEmpty(detailDataOutShare.ark_content)) {
            ShareUtils.f fVar = new ShareUtils.f();
            fVar.f44741b = plainText;
            fVar.f44742c = plainText2;
            fVar.f44743d = c16;
            fVar.f44740a = str3;
            VideoUrl videoUrl = videoInfo.videoUrl;
            fVar.f44728h = videoUrl != null ? videoUrl.url : null;
            int i3 = (int) (videoInfo.videoTime / 1000);
            fVar.f44729i = i3;
            fVar.f44730j = i3;
            fVar.f44731k = videoInfo.width;
            fVar.f44732l = videoInfo.height;
            VideoInfo.VideoRemark videoRemark = videoInfo.videoRemark;
            if (videoRemark != null && videoRemark.isTencentVideo()) {
                fVar.f44733m = videoInfo.videoId;
                fVar.f44734n = 3;
            }
            fVar.f44736p = this.f44796c;
            fVar.f44737q = this.f44797d;
            fVar.f44738r = this.f44798e;
            try {
                JSONObject jSONObject = new JSONObject();
                long j3 = user.uin;
                String str4 = user.nickName;
                String str5 = cellFeedCommInfo.ugckey;
                String str6 = videoInfo.videoUrl.url;
                String str7 = videoInfo.videoId;
                boolean isTencentVideo = videoInfo.videoRemark.isTencentVideo();
                int i16 = cellFeedCommInfo.appid;
                if (QZLog.isColorLevel()) {
                    QZLog.d("ShareAdapter", 2, "[doShareToQQunChecked] rays, uin=" + j3 + ", nickname=" + str4 + ", ugckey=" + str5 + ", videoUrl=" + str6 + ", videoID=" + str7 + ", isTencentVideo=" + isTencentVideo + ", appid=" + i16);
                }
                jSONObject.put("uin", j3);
                jSONObject.put("nickname", str4);
                jSONObject.put(AppConstants.Key.KEY_QZONE_UGCKEY, str5);
                jSONObject.put(AppConstants.Key.KEY_QZONE_ISTXVIDEO, isTencentVideo ? 1 : 0);
                jSONObject.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, str6);
                jSONObject.put("videoID", str7);
                jSONObject.put(AppConstants.Key.KEY_QZONE_ENTER_VIDEOLAYER, 1);
                jSONObject.put("appid", i16);
                fVar.f44735o = jSONObject.toString();
            } catch (Exception e16) {
                QZLog.e("ShareAdapter", "[doShareToQQunChecked] rays", e16);
            }
            ShareUtils.o(activity, fVar, 0);
        } else {
            ShareUtils.e eVar2 = new ShareUtils.e();
            eVar2.f44740a = str3;
            eVar2.f44711h = 2;
            eVar2.f44712i = str2;
            eVar2.f44713j = 1;
            eVar2.f44741b = plainText;
            eVar2.f44742c = plainText2;
            if (!TextUtils.isEmpty(this.f44800g)) {
                eVar2.b(this.f44800g, detailDataOutShare.ark_id, detailDataOutShare.view_id);
            } else if (!TextUtils.isEmpty(detailDataOutShare.ark_content)) {
                eVar2.c(detailDataOutShare.ark_content, detailDataOutShare.ark_id, detailDataOutShare.view_id, str3);
            }
            eVar2.f44714k = activity.getString(R.string.gg_);
            eVar2.f44715l = true;
            eVar2.f44743d = c16;
            eVar2.f44716m = this.f44796c;
            eVar2.f44717n = this.f44797d;
            eVar2.f44718o = this.f44798e;
            eVar2.f44719p = this.f44799f;
            ShareUtils.n(activity, eVar2, 0);
        }
        if (this.f44795b.getVideoInfo() != null) {
            ClickReport.r(null, null, null, true, "350", "3", "1");
        }
    }
}
