package cw0;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.util.m;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import fu0.c;
import fu0.d;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    public static String a(long j3, long j16, int i3) {
        long j17;
        String str;
        d s16 = ((c) qx0.a.b(c.class)).s();
        BaseRoomInfo q16 = ((c) qx0.a.b(c.class)).q(0L);
        if (s16 != null && q16 != null) {
            j17 = m.b(q16.getRoomId());
        } else {
            j17 = 1;
        }
        ConcurrentHashMap<String, String> e16 = xw0.b.f448881a.e();
        if (j3 == j16) {
            str = "1";
        } else {
            str = "0";
        }
        return String.format(b(), str, Long.valueOf(j3), Long.valueOf(j17)) + ContainerUtils.FIELD_DELIMITER + "qqlive_user_id=" + e16.get("qqlive_user_id") + ContainerUtils.FIELD_DELIMITER + "qqlive_program_id=" + e16.get("qqlive_program_id") + ContainerUtils.FIELD_DELIMITER + "qqlive_enter_id=" + e16.get("qqlive_enter_id") + ContainerUtils.FIELD_DELIMITER + "qqlive_zhibo_type=" + e16.get("qqlive_zhibo_type") + ContainerUtils.FIELD_DELIMITER + "qqlive_start_source=" + e16.get("qqlive_start_source") + ContainerUtils.FIELD_DELIMITER + "qqlive_abtoken=" + e16.get(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN) + ContainerUtils.FIELD_DELIMITER + "qqlive_clck_source=" + i3 + ContainerUtils.FIELD_DELIMITER + "qqlive_room_id=" + e16.get("qqlive_room_id");
    }

    private static String b() {
        if (SSODebugUtil.isTestEnv()) {
            return "https://tde.qlive.qq.com/cos/live/h5/fan-group/index.html?_bid=4880&from_anchor=%s&anchor_uid=%s&room_type=%s&_tde_id=6881&loading=light";
        }
        return "https://qlive.qq.com/cos/live/h5/fan-group/index.html?_bid=4880&from_anchor=%s&anchor_uid=%s&room_type=%s&loading=light";
    }

    public static void c(Context context, long j3, long j16, int i3) {
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        iAegisLogApi.i("ICGameFansGroupJumpUtil", 1, "jumpGroupUtil context=" + context + ",anchorId=" + j3 + ",selfId=" + j16 + ",source=" + i3);
        if (context != null && j3 > 0 && j16 > 0) {
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(context, context.getString(R.string.f171139ci4), 0).show();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("height_web_dialog", 510);
            bundle.putBoolean("transparent_web_bg", false);
            String a16 = a(j3, j16, i3);
            iAegisLogApi.i("ICGameFansGroupJumpUtil", 1, "url=" + a16);
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).openCommonWebDialog(context, a16, bundle);
        }
    }
}
