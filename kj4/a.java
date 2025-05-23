package kj4;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.common.api.IAegisLogApi;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.concurrent.ConcurrentHashMap;
import tk4.d;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static String a(int i3, int i16) {
        return (b(d()) + "qqlive_clck_source=" + i3 + ContainerUtils.FIELD_DELIMITER) + "tab=" + i16;
    }

    public static String b(String str) {
        String str2;
        c cVar = c.f272176a;
        int q16 = cVar.q();
        long p16 = cVar.p();
        long k3 = cVar.k(p16, 1);
        if (cVar.J(p16, 1)) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        ConcurrentHashMap<String, String> f16 = d.f436481a.f();
        StringBuilder sb5 = new StringBuilder(str);
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("from_anchor=" + str2 + ContainerUtils.FIELD_DELIMITER);
        sb5.append("anchor_uid=" + k3 + ContainerUtils.FIELD_DELIMITER);
        sb5.append("room_type=" + q16 + ContainerUtils.FIELD_DELIMITER);
        sb5.append("appid=" + QQLiveSDKConfigHelper.getSceneIdByRoomType(q16) + ContainerUtils.FIELD_DELIMITER);
        sb5.append("loading=light&");
        sb5.append("qqlive_user_id=");
        sb5.append(f16.get("qqlive_user_id"));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("qqlive_program_id=");
        sb5.append(f16.get("qqlive_program_id"));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("qqlive_enter_id=");
        sb5.append(f16.get("qqlive_enter_id"));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("qqlive_zhibo_type=");
        sb5.append(f16.get("qqlive_zhibo_type"));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("qqlive_start_source=");
        sb5.append(f16.get("qqlive_start_source"));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("qqlive_abtoken=");
        sb5.append(f16.get(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("qqlive_room_id=");
        sb5.append(f16.get("qqlive_room_id"));
        return sb5.toString();
    }

    private static int c(Context context) {
        float a16 = x.f(context).a() * 0.6f;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            a16 = activity.getWindow().getDecorView().getHeight() * 0.6f;
            if (activity.getRequestedOrientation() == 0 || 8 == activity.getRequestedOrientation()) {
                a16 = activity.getWindow().getDecorView().getWidth() * 0.6f;
            }
        }
        return wi2.c.e(a16);
    }

    private static String d() {
        if (SSODebugUtil.isTestEnv()) {
            return "https://tde.qlive.qq.com/cos/live/h5/fan-group/index.html?_tde_id=6881&_bid=4880";
        }
        return "https://qlive.qq.com/cos/live/h5/fan-group/index.html?_bid=4880";
    }

    public static void e(Context context, long j3, long j16, int i3, int i16) {
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("FansGroupJumpUtil", 1, "jumpGroupUtil context=" + context + ",anchorId=" + j3 + ",selfId=" + j16 + ",source=" + i3);
        if (context != null && j3 > 0 && j16 > 0) {
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(context, context.getString(R.string.f171139ci4), 0).show();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("height_web_dialog", c(context));
            bundle.putBoolean("transparent_web_bg", false);
            f(context, a(i3, i16));
        }
    }

    public static void f(Context context, String str) {
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("FansGroupJumpUtil", "jumpGroupUtil context=" + context + JefsClass.INDEX_URL + str);
        if (context != null && !TextUtils.isEmpty(str)) {
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(context, context.getString(R.string.f171139ci4), 0).show();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("height_web_dialog", c(context));
            bundle.putBoolean("transparent_web_bg", false);
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).openCommonWebDialog(context, str, bundle);
        }
    }
}
