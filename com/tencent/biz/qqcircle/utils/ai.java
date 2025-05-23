package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.global.QCircleTipsConfig;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleEnvHub$Tips;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ai {
    public static String a(int i3) {
        QQCircleEnvHub$Tips b16 = b(i3);
        if (b16 != null) {
            return b16.text.get();
        }
        return "";
    }

    public static QQCircleEnvHub$Tips b(int i3) {
        byte[] tipConfig = QCircleTipsConfig.getInstance().getTipConfig(i3);
        if (tipConfig != null) {
            QQCircleEnvHub$Tips qQCircleEnvHub$Tips = new QQCircleEnvHub$Tips();
            try {
                qQCircleEnvHub$Tips.mergeFrom(tipConfig);
                return qQCircleEnvHub$Tips;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static void c() {
        uq3.g.e("key_sp_tip_push_feedback_status", Boolean.TRUE);
    }

    public static boolean d() {
        return uq3.k.b().c("key_sp_tip_menu_high_qrcode_status_v2", true);
    }

    public static boolean e() {
        return ((Boolean) uq3.g.d("key_sp_tip_album_status", Boolean.TRUE)).booleanValue();
    }

    public static boolean f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (!com.tencent.biz.qqcircle.immersive.utils.r.Z(feedCloudMeta$StFeed)) {
            QLog.e("QCircleTipsUtil", 1, "[shouldShowQQGroupTips] is not allowed feed bind group.");
            return false;
        }
        return uq3.k.a().c("key_sp_tip_qq_group_status", true);
    }

    public static boolean g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (QCirclePluginUtil.isFeedOwner(feedCloudMeta$StFeed) && ((Boolean) uq3.g.d("key_sp_tip_set_permission_status", Boolean.TRUE)).booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean h(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (QCirclePluginUtil.isFeedOwner(feedCloudMeta$StFeed) && ((Boolean) uq3.g.d("key_sp_tip_stick_status", Boolean.TRUE)).booleanValue()) {
            return true;
        }
        return false;
    }

    public static void i() {
        uq3.k.b().j("key_sp_tip_menu_high_qrcode_status_v2", false);
    }

    public static void j() {
        uq3.k.a().j("key_sp_tip_qq_group_status", false);
    }

    public static void k() {
        uq3.g.e("key_sp_tip_set_permission_status", Boolean.FALSE);
    }

    public static void l() {
        uq3.g.e("key_sp_tip_album_status", Boolean.FALSE);
    }

    public static void m() {
        uq3.g.e("key_sp_tip_stick_status", Boolean.FALSE);
    }
}
