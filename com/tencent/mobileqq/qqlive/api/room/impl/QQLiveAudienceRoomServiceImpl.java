package com.tencent.mobileqq.qqlive.api.room.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveAudienceRoomService;
import com.tencent.mobileqq.qqlive.data.record.QQLiveSwitchRoom;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAudienceRoomServiceImpl implements IQQLiveAudienceRoomService {
    static IPatchRedirector $redirector_ = null;
    private static final String RTMP_URL_PREFIX = "rtmp";
    private static final String TAG = "QQLiveAudienceRoomServiceImpl";
    private static final String USE_FLV_NO = "0";
    private static final String USE_FLV_YES = "1";

    public QQLiveAudienceRoomServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String addSchemeParams(String str, String str2, String str3) {
        if (str == null) {
            return "";
        }
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return str + ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
        }
        return str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
    }

    @RequiresApi(api = 19)
    private String addVideoUrlToScheme(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            boolean startsWith = str2.startsWith("rtmp");
            QLog.d(TAG, 1, "isRtmp:" + startsWith);
            try {
                String encode = URLEncoder.encode(str2, StandardCharsets.UTF_8.name());
                if (startsWith) {
                    str = addSchemeParams(addSchemeParams(str, "is_use_flv", "0"), "rtmp", encode);
                } else {
                    str = addSchemeParams(addSchemeParams(str, "is_use_flv", "1"), "flv_url", encode);
                }
            } catch (UnsupportedEncodingException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
        return str;
    }

    private String getEncodeValue(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            QLog.w(TAG, 2, "encode fail", e16);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IQQLiveAudienceRoomService
    public void enterAudienceRoom(Context context, QQLiveSwitchRoom qQLiveSwitchRoom, Bundle bundle) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, qQLiveSwitchRoom, bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "enterAudienceRoom room:" + qQLiveSwitchRoom);
        }
        String replace = RoomServiceConstants.SCHEME_ILIVE_WATCH.replace("{roomid}", String.valueOf(qQLiveSwitchRoom.roomId));
        if (TextUtils.isEmpty(bundle.getString("from"))) {
            string = ThemeBackground.DIY_UPLOAD_BG_ID;
        } else {
            string = bundle.getString("from");
        }
        String addSchemeParams = addSchemeParams(addSchemeParams(addSchemeParams(addSchemeParams(addSchemeParams(addSchemeParams(addSchemeParams(addSchemeParams(replace, "from", string), "source", bundle.getString("source")), "room_type", String.valueOf(qQLiveSwitchRoom.roomType)), "video_source", String.valueOf(qQLiveSwitchRoom.videoSource)), "game_id", String.valueOf(qQLiveSwitchRoom.gameId)), "game_tag_id", String.valueOf(qQLiveSwitchRoom.gameTagId)), "cover_url", getEncodeValue(qQLiveSwitchRoom.coverUrl)), "pip", String.valueOf(qQLiveSwitchRoom.pip));
        String str = qQLiveSwitchRoom.liveProductType;
        if (str == null) {
            str = "";
        }
        String addSchemeParams2 = addSchemeParams(addVideoUrlToScheme(addSchemeParams(addSchemeParams, RoomServiceConstants.PARAMS_QQ_LIVE_PRODUCT_TYPE, str), qQLiveSwitchRoom.videoUrl), "noclearTop", bundle.getString("noclearTop"));
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(addSchemeParams2));
        context.startActivity(intent);
    }
}
