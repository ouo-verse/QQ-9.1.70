package com.tencent.biz.qqstory.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.peak.PeakConstants;
import cooperation.qzone.video.QzoneVerticalVideoConst;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j {
    public static Intent a(Intent intent, Bundle bundle, Activity activity) {
        if (bundle == null) {
            return intent;
        }
        intent.putExtra("troop_uin", bundle.getInt("troop_uin", 0));
        intent.putExtra("entrance_type", bundle.getInt("entrance_type"));
        if (bundle.getString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM) != null) {
            intent.putExtra(PeakConstants.KEY_QQ_CAMERA_SCHEME, ((IJumpUtil) QRoute.api(IJumpUtil.class)).getSchemeForTail(bundle.getString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM)));
            intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, bundle.getString(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM));
            String string = bundle.getString(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
            ms.a.f("StoryIntentUtils", "passStoryRecordExtrasToIntent---takeSameName=" + string);
            if (!TextUtils.isEmpty(string)) {
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, string);
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, string);
            } else {
                intent.putExtra(PeakConstants.KEY_QQ_CAMERA_TOP_TITLE, PeakConstants.QZONETAIL_TITLE);
            }
        }
        intent.putExtra("material_id", bundle.getString("material_id"));
        String string2 = bundle.getString(AECameraConstants.KEY_SEND_ARK_MSG_JSON_INFO);
        intent.putExtra(AECameraConstants.KEY_SEND_ARK_MSG_JSON_INFO, string2);
        String string3 = bundle.getString(AECameraConstants.KEY_SEND_ARK_MSG_GAME_SCORE);
        intent.putExtra(AECameraConstants.KEY_SEND_ARK_MSG_GAME_SCORE, string3);
        ms.a.f("StoryIntentUtils", "ArkVideo score=" + string3 + ", arkJson=" + string2);
        intent.putExtra(QzoneVerticalVideoConst.KEY_SCHEME_REQUEST_FROM_BUSINESS_TYPE, bundle.getString(QzoneVerticalVideoConst.KEY_SCHEME_REQUEST_FROM_BUSINESS_TYPE));
        return intent;
    }
}
