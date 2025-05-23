package cooperation.vip.vipcomponent.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<Integer, String> f391401a;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        f391401a = hashMap;
        hashMap.put(2, "qzone_ys_haohua");
        hashMap.put(3, "qzone_ys_haohua_guan");
        hashMap.put(4, "qzone_ys_huangzuan_guan");
        hashMap.put(5, "qzone_ys_huangzuan_guan_gq");
        hashMap.put(6, "qzone_ys_huangzuan_gq");
        hashMap.put(7, "qzone_annualvip_icon");
        hashMap.put(8, "qzone_annualvip_gray");
        hashMap.put(9, "qzone_ys_huangzuan_gq_nianfei_level1");
        hashMap.put(10, "qzone_ys_huangzuan_gq_nianfei_level2");
        hashMap.put(11, "qzone_ys_huangzuan_gq_nianfei_level3");
        hashMap.put(12, "qzone_ys_huangzuan_gq_nianfei_level4");
        hashMap.put(13, "qzone_ys_huangzuan_gq_nianfei_level5");
        hashMap.put(14, "qzone_ys_huangzuan_gq_nianfei_level6");
        hashMap.put(15, "qzone_ys_huangzuan_gq_nianfei_level7");
        hashMap.put(16, "qzone_ys_huangzuan_gq_nianfei_level8");
        hashMap.put(17, "qzone_ys_huangzuan_gq_nianfei_level9");
        hashMap.put(18, "qzone_ys_huangzuan_gq_level1");
        hashMap.put(19, "qzone_ys_huangzuan_gq_level2");
        hashMap.put(20, "qzone_ys_huangzuan_gq_level3");
        hashMap.put(21, "qzone_ys_huangzuan_gq_level4");
        hashMap.put(22, "qzone_ys_huangzuan_gq_level5");
        hashMap.put(23, "qzone_ys_huangzuan_gq_level6");
        hashMap.put(24, "qzone_ys_huangzuan_gq_level7");
        hashMap.put(25, "qzone_ys_huangzuan_gq_level8");
        hashMap.put(26, "qzone_ys_huangzuan_gq_level9");
        hashMap.put(27, "qzone_ys_nianfei_level1");
        hashMap.put(28, "qzone_ys_nianfei_level2");
        hashMap.put(29, "qzone_ys_nianfei_level3");
        hashMap.put(30, "qzone_ys_nianfei_level4");
        hashMap.put(31, "qzone_ys_nianfei_level5");
        hashMap.put(32, "qzone_ys_nianfei_level6");
        hashMap.put(33, "qzone_ys_nianfei_level7");
        hashMap.put(34, "qzone_ys_nianfei_level8");
        hashMap.put(35, "qzone_ys_nianfei_level9");
        hashMap.put(36, "qzone_ys_nianfei_level10");
        hashMap.put(37, "qzone_ys_huangzuan_level1");
        hashMap.put(38, "qzone_ys_huangzuan_level2");
        hashMap.put(39, "qzone_ys_huangzuan_level3");
        hashMap.put(40, "qzone_ys_huangzuan_level4");
        hashMap.put(41, "qzone_ys_huangzuan_level5");
        hashMap.put(42, "qzone_ys_huangzuan_level6");
        hashMap.put(43, "qzone_ys_huangzuan_level7");
        hashMap.put(44, "qzone_ys_huangzuan_level8");
        hashMap.put(45, "qzone_ys_huangzuan_level9");
        hashMap.put(46, "qzone_ys_huangzuan_level10");
        hashMap.put(48, "qzone_icon_star_vip_king");
        hashMap.put(49, "qzone_icon_star_vip_king_gray");
        hashMap.put(50, "qzone_icon_star_vip_gray");
        hashMap.put(51, "qz_icon_star_vip_high");
        hashMap.put(52, "qz_icon_star_vip_high_gray");
        hashMap.put(53, "qz_icon_star_vip_high_king");
        hashMap.put(54, "qz_icon_star_vip_high_king_gray");
        hashMap.put(55, "qzone_icon_star_vip_lv1_year");
        hashMap.put(56, "qzone_icon_star_vip_lv2_year");
        hashMap.put(57, "qzone_icon_star_vip_lv3_year");
        hashMap.put(58, "qzone_icon_star_vip_lv4_year");
        hashMap.put(59, "qzone_icon_star_vip_lv5_year");
        hashMap.put(60, "qzone_icon_star_vip_lv6_year");
        hashMap.put(61, "qzone_icon_star_vip_lv7_year");
        hashMap.put(62, "qzone_icon_star_vip_lv8_year");
        hashMap.put(63, "qzone_icon_star_vip_lv1_normal");
        hashMap.put(64, "qzone_icon_star_vip_lv2_normal");
        hashMap.put(65, "qzone_icon_star_vip_lv3_normal");
        hashMap.put(66, "qzone_icon_star_vip_lv4_normal");
        hashMap.put(67, "qzone_icon_star_vip_lv5_normal");
        hashMap.put(68, "qzone_icon_star_vip_lv6_normal");
        hashMap.put(69, "qzone_icon_star_vip_lv7_normal");
        hashMap.put(70, "qzone_icon_star_vip_lv8_normal");
        hashMap.put(71, "qzone_icon_star_vip_lv1_year_gray");
        hashMap.put(72, "qzone_icon_star_vip_lv2_year_gray");
        hashMap.put(73, "qzone_icon_star_vip_lv3_year_gray");
        hashMap.put(74, "qzone_icon_star_vip_lv4_year_gray");
        hashMap.put(75, "qzone_icon_star_vip_lv5_year_gray");
        hashMap.put(76, "qzone_icon_star_vip_lv6_year_gray");
        hashMap.put(77, "qzone_icon_star_vip_lv7_year_gray");
        hashMap.put(78, "qzone_icon_star_vip_lv8_year_gray");
        hashMap.put(79, "qzone_icon_star_vip_lv1_gray");
        hashMap.put(80, "qzone_icon_star_vip_lv2_gray");
        hashMap.put(81, "qzone_icon_star_vip_lv3_gray");
        hashMap.put(82, "qzone_icon_star_vip_lv4_gray");
        hashMap.put(83, "qzone_icon_star_vip_lv5_gray");
        hashMap.put(84, "qzone_icon_star_vip_lv6_gray");
        hashMap.put(85, "qzone_icon_star_vip_lv7_gray");
        hashMap.put(86, "qzone_icon_star_vip_lv8_gray");
        hashMap.put(87, "qzone_widget_vip_nianpai_lv1");
        hashMap.put(88, "qzone_widget_vip_nianpai_lv2");
        hashMap.put(89, "qzone_widget_vip_nianpai_lv3");
        hashMap.put(90, "qzone_widget_vip_nianpai_lv4");
        hashMap.put(91, "qzone_widget_vip_nianpai_lv5");
        hashMap.put(92, "qzone_widget_vip_nianpai_lv6");
        hashMap.put(93, "qzone_widget_vip_nianpai_lv7");
        hashMap.put(94, "qzone_widget_vip_nianpai_lv8");
        hashMap.put(95, "qzone_widget_vip_nianpai_lv9");
        hashMap.put(96, "qzone_widget_vip_nianpai_lv10");
        hashMap.put(97, "qzone_widget_vip_lv1");
        hashMap.put(98, "qzone_widget_vip_lv2");
        hashMap.put(99, "qzone_widget_vip_lv3");
        hashMap.put(100, "qzone_widget_vip_lv4");
        hashMap.put(101, "qzone_widget_vip_lv5");
        hashMap.put(102, "qzone_widget_vip_lv6");
        hashMap.put(103, "qzone_widget_vip_lv7");
        hashMap.put(104, "qzone_widget_vip_lv8");
        hashMap.put(105, "qzone_widget_vip_lv9");
        hashMap.put(106, "qzone_widget_vip_lv10");
        hashMap.put(107, "qzone_icon_star_vip_sidai_year_lv1");
        hashMap.put(108, "qzone_icon_star_vip_sidai_year_lv2");
        hashMap.put(109, "qzone_icon_star_vip_sidai_year_lv3");
        hashMap.put(110, "qzone_icon_star_vip_sidai_year_lv4");
        hashMap.put(111, "qzone_icon_star_vip_sidai_year_lv5");
        hashMap.put(112, "qzone_icon_star_vip_sidai_year_lv6");
        hashMap.put(113, "qzone_icon_star_vip_sidai_year_lv7");
        hashMap.put(114, "qzone_icon_star_vip_sidai_year_lv8");
        hashMap.put(115, "qzone_icon_star_vip_sidai_lv1");
        hashMap.put(116, "qzone_icon_star_vip_sidai_lv2");
        hashMap.put(117, "qzone_icon_star_vip_sidai_lv3");
        hashMap.put(118, "qzone_icon_star_vip_sidai_lv4");
        hashMap.put(119, "qzone_icon_star_vip_sidai_lv5");
        hashMap.put(120, "qzone_icon_star_vip_sidai_lv6");
        hashMap.put(121, "qzone_icon_star_vip_sidai_lv7");
        hashMap.put(122, "qzone_icon_star_vip_sidai_lv8");
        hashMap.put(123, "qzone_icon_lv9_winds");
        hashMap.put(124, "qzone_icon_lv9_winds_gray");
        hashMap.put(125, "qzone_icon_lv9_guan");
        hashMap.put(126, "qzone_icon_lv9_guan_gray");
    }

    public static Drawable a(String str, int i3, int i16, int i17, boolean z16, int i18, e eVar) {
        String b16 = b(i3, i17, z16, i18);
        if (!TextUtils.isEmpty(b16)) {
            return ZipResDownloadManager.C().v(str, i16, b16, true, eVar);
        }
        return null;
    }

    public static String b(int i3, int i16, boolean z16, int i17) {
        String str;
        switch (i17) {
            case 4:
            case 7:
                if (i3 == 2) {
                    str = "svip_widget_lv" + i16;
                } else {
                    str = "vip_widget_lv" + i16;
                }
                String str2 = str;
                if (z16) {
                    return str2 + "nian";
                }
                return str2;
            case 5:
            case 6:
            case 8:
                if (i3 == 2) {
                    return "svip_feed_lv" + i16;
                }
                return "vip_feed_lv" + i16;
            default:
                return "";
        }
    }

    public static QQUnionIconInfo c(int i3, int i16) {
        int i17;
        int i18;
        String str = null;
        if (i16 <= 0) {
            return null;
        }
        QQUnionIconInfo qQUnionIconInfo = new QQUnionIconInfo();
        switch (i3) {
            case 4:
                str = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_HEAD_URL, QzoneConfig.DEFAULT_UNION_VIP_HEAD_URL).replace("{level}", String.valueOf(i16));
                i17 = 52;
                i18 = 54;
                break;
            case 5:
            case 6:
            case 8:
                str = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_FEED_URL, QzoneConfig.DEFAULT_UNION_VIP_FEED_URL).replace("{level}", String.valueOf(i16));
                i17 = 94;
                i18 = 44;
                break;
            case 7:
                str = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_WIDGET_URL, QzoneConfig.DEFAULT_UNION_VIP_WIDGET_URL).replace("{level}", String.valueOf(i16));
                i17 = 49;
                i18 = 50;
                break;
            default:
                i17 = -1;
                i18 = -1;
                break;
        }
        qQUnionIconInfo.mIconUrl = str;
        qQUnionIconInfo.mIconWidth = i17;
        qQUnionIconInfo.mIconHeight = i18;
        return qQUnionIconInfo;
    }

    public static Drawable d(int i3, int i16, e eVar) {
        HashMap<Integer, String> hashMap = f391401a;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            return ZipResDownloadManager.C().u("https://tianquan.gtimg.cn/shoal/qqgxh/2f25bfa8-efb0-451f-af0b-1c1fcd2578ab.zip", i16, hashMap.get(Integer.valueOf(i3)), eVar);
        }
        if (i3 != 1) {
            return null;
        }
        return BaseApplication.getContext().getResources().getDrawable(R.drawable.gjz);
    }

    public static Drawable e(String str, int i3, int i16, int i17, e eVar) {
        return f(str, i3, i16, i17, eVar, 0);
    }

    public static Drawable f(String str, int i3, int i16, int i17, e eVar, int i18) {
        if (i18 != 0) {
            if (i18 == 1) {
                ZipResDownloadManager.C().u(str, i3, "border", eVar);
                return null;
            }
            return null;
        }
        switch (i17) {
            case 4:
                return ZipResDownloadManager.C().u(str, i3, "head", eVar);
            case 5:
            case 6:
            case 8:
                return ZipResDownloadManager.C().u(str, i3, "right", eVar);
            case 7:
                return ZipResDownloadManager.C().u(str, i3, "bottom_lv" + i16, eVar);
            default:
                return null;
        }
    }

    public static QQUnionIconInfo g(int i3, int i16, Map<String, QQUnionIconInfo> map) {
        QQUnionIconInfo qQUnionIconInfo;
        if (map != null) {
            switch (i3) {
                case 4:
                    qQUnionIconInfo = map.get("head_icon");
                    break;
                case 5:
                case 6:
                case 8:
                    qQUnionIconInfo = map.get("feed_icon");
                    break;
                case 7:
                    qQUnionIconInfo = map.get("widget_icon");
                    break;
            }
            if (qQUnionIconInfo != null || TextUtils.isEmpty(qQUnionIconInfo.mIconUrl) || qQUnionIconInfo.mIconWidth <= 0 || qQUnionIconInfo.mIconHeight <= 0) {
                QZLog.i("QQUnionVip", 1, "current getQQUnionVipUrl = null use default location = " + i3);
                qQUnionIconInfo = c(i3, i16);
            }
            if (qQUnionIconInfo != null && !TextUtils.isEmpty(qQUnionIconInfo.mIconUrl) && qQUnionIconInfo.mIconUrl.contains("{platform}")) {
                qQUnionIconInfo.mIconUrl = qQUnionIconInfo.mIconUrl.replace("{platform}", "az");
            }
            return qQUnionIconInfo;
        }
        qQUnionIconInfo = null;
        if (qQUnionIconInfo != null) {
        }
        QZLog.i("QQUnionVip", 1, "current getQQUnionVipUrl = null use default location = " + i3);
        qQUnionIconInfo = c(i3, i16);
        if (qQUnionIconInfo != null) {
            qQUnionIconInfo.mIconUrl = qQUnionIconInfo.mIconUrl.replace("{platform}", "az");
        }
        return qQUnionIconInfo;
    }

    public static void h(Context context, String str) {
        ZipResDownloadManager.C().G(str);
    }
}
