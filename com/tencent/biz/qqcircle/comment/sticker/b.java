package com.tencent.biz.qqcircle.comment.sticker;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uq3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {
    public static boolean a(@Nullable FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_show_comment_recommend_emoji", true);
        if (feedCloudMeta$StFeed != null) {
            z16 = feedCloudMeta$StFeed.opMask2.get().contains(48);
        } else {
            z16 = true;
        }
        if (!studyModeSwitch && isSwitchOn && z16) {
            return true;
        }
        return false;
    }

    public static void b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int e16;
        if (!a(feedCloudMeta$StFeed) || (e16 = k.b().e("sp_key_check_sticker_rec_manager_init_times", 0)) >= 1) {
            return;
        }
        k.b().m("sp_key_check_sticker_rec_manager_init_times", e16 + 1);
        AppInterface appInterface = QCircleServiceImpl.getAppInterface();
        if (appInterface == null) {
            QLog.e("QFSGetRecStickersHelper", 1, "[initStickerRecManager] getAppInterface null");
            return;
        }
        ((IStickerRecManager) appInterface.getRuntimeService(IStickerRecManager.class, "")).init();
        if (((IStickerRecManager) appInterface.getRuntimeService(IStickerRecManager.class, "")).hasInit()) {
            QLog.d("QFSGetRecStickersHelper", 1, "IStickerRecManager has init.");
        } else {
            ((IStickerRecManager) appInterface.getRuntimeService(IStickerRecManager.class, "")).pullWords();
            QLog.d("QFSGetRecStickersHelper", 1, "init IStickerRecManager.");
        }
    }

    public static JSONObject c(List<IStickerRecEmoticon> list) {
        Object valueOf;
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (IStickerRecEmoticon iStickerRecEmoticon : list) {
                if (iStickerRecEmoticon != null && (iStickerRecEmoticon instanceof StickerRecData)) {
                    StickerRecData stickerRecData = (StickerRecData) iStickerRecEmoticon;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("url", stickerRecData.getImgUrl()).put("thumbUrl", stickerRecData.getThumbUrl()).put("md5", stickerRecData.getImgMd5());
                        jSONArray.mo162put(jSONObject2);
                    } catch (JSONException e16) {
                        QLog.d("QFSGetRecStickersHelper", 1, "parseSticker2Json: fail to create data json", e16);
                    }
                }
            }
            try {
                jSONObject.put("data", jSONArray);
                return jSONObject;
            } catch (JSONException e17) {
                QLog.d("QFSGetRecStickersHelper", 1, "parseSticker2Json: fail to put data json", e17);
                return null;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("parseSticker2Json: empty img list ");
        if (list == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(list.size());
        }
        sb5.append(valueOf);
        QLog.d("QFSGetRecStickersHelper", 1, sb5.toString());
        return null;
    }

    public static void d(IStickerRecManager.ImgUpdateListener imgUpdateListener) {
        if (imgUpdateListener == null) {
            return;
        }
        AppInterface appInterface = QCircleServiceImpl.getAppInterface();
        if (appInterface == null) {
            QLog.e("QFSGetRecStickersHelper", 1, "[setStickersUpdateListener] getAppInterface null");
        } else {
            ((IStickerRecManager) appInterface.getRuntimeService(IStickerRecManager.class, "")).setImgUpdateListener(imgUpdateListener);
        }
    }

    public static boolean e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        AppInterface appInterface = QCircleServiceImpl.getAppInterface();
        if (appInterface == null) {
            QLog.e("QFSGetRecStickersHelper", 1, "[updateStickers] getAppInterface null");
            return false;
        }
        ((IStickerRecManager) appInterface.getRuntimeService(IStickerRecManager.class, "")).init();
        if (!((IStickerRecManager) appInterface.getRuntimeService(IStickerRecManager.class, "")).isEmotionRecSettingOpen()) {
            QLog.d("QFSGetRecStickersHelper", 1, "sticker recommend is not open");
            return false;
        }
        boolean analyzeFromQCircle = ((IStickerRecManager) appInterface.getRuntimeService(IStickerRecManager.class, "")).analyzeFromQCircle(str, 10008, str2);
        if (!analyzeFromQCircle) {
            QLog.d("QFSGetRecStickersHelper", 1, "analyze text no pass");
        }
        return analyzeFromQCircle;
    }
}
