package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bi {
    public static String a(Context context) {
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(context);
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null || !qCircleInitBean.getSchemeAttrs().containsKey("xsj_main_entrance")) {
            return "";
        }
        String str = qCircleInitBean.getSchemeAttrs().get("xsj_main_entrance");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1840810162:
                if (str.equals(QCircleDaTongConstant.ElementParamValue.QQ_MAIN_TAB)) {
                    c16 = 0;
                    break;
                }
                break;
            case -952588632:
                if (str.equals("qq_aio")) {
                    c16 = 1;
                    break;
                }
                break;
            case -952582346:
                if (str.equals(QCircleDaTongConstant.ElementParamValue.QCIRCLE_PUBLIC_ACCOUNT_MAIN_ENTRANCE)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return "qfs_force_auto_slide_scene_all_push";
            case 1:
                return "qfs_force_auto_slide_scene_aio";
            case 2:
                return "qfs_force_auto_slide_scene_public_account";
            default:
                QLog.d("QFSFeedAutoSlideUtil", 1, "[getForceAutoSlideSceneMMKVKey] not target scene.");
                return "";
        }
    }

    public static boolean b() {
        if (uq3.c.E6() && uq3.c.d5()) {
            return true;
        }
        return false;
    }

    public static boolean c(List<e30.b> list, String str, int i3) {
        e30.b bVar;
        if (list == null || TextUtils.isEmpty(str) || i3 != 0 || list.size() < 2 || (bVar = (e30.b) new ArrayList(list.subList(0, 2)).get(1)) == null || bVar.g() == null || !bVar.g().opMask2.get().contains(59)) {
            return false;
        }
        boolean c16 = uq3.n.c(System.currentTimeMillis(), uq3.k.a().f(str, 0L));
        QLog.d("QFSFeedAutoSlideUtil", 1, "[isForceAutoSlide] force auto slide, scene: " + str + ", isLimit: " + c16);
        return true ^ c16;
    }

    public static boolean d(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSFeedAutoSlideUtil", 1, "shouldAutoSlide false, feed null ");
            return false;
        }
        if (feedCloudMeta$StFeed.opMask2.get().contains(58)) {
            QLog.d("QFSFeedAutoSlideUtil", 1, "[shouldAutoSlide] force slide feed. ");
            return true;
        }
        boolean contains = feedCloudMeta$StFeed.opMask2.get().contains(17);
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(context);
        if (qCircleInitBean == null || qCircleInitBean.getExtraTypeInfo() == null) {
            return false;
        }
        if (qCircleInitBean.getExtraTypeInfo().sourceType == 52) {
            return contains;
        }
        if (qCircleInitBean.getExtraTypeInfo().sourceType == 20111) {
            return true;
        }
        if (contains && b()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (feedCloudMeta$StFeed.type.get() == 2) {
            if (!uq3.c.e5() || !z16) {
                return false;
            }
            return true;
        }
        return z16;
    }
}
