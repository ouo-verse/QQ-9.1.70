package com.tencent.mobileqq.troop.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class am {
    static IPatchRedirector $redirector_;

    public static String a(MessageForDeliverGiftTips messageForDeliverGiftTips) {
        String i3 = i(messageForDeliverGiftTips);
        if (QVipGiftProcessor.getConfig().isEnable() && !TextUtils.isEmpty(messageForDeliverGiftTips.animationPackageUrl)) {
            return messageForDeliverGiftTips.animationPackageUrl;
        }
        if (messageForDeliverGiftTips.isInteract()) {
            return "https://pub.idqqimg.com/pc/misc/groupgift/" + i3 + "_NEW.zip";
        }
        if (messageForDeliverGiftTips.animationType == 1) {
            return "https://pub.idqqimg.com/pc/misc/groupgift/" + i3 + "_V.zip";
        }
        return "https://pub.idqqimg.com/pc/misc/groupgift/" + i3 + "_HD.zip";
    }

    public static String b(String str, int i3, boolean z16) {
        StringBuffer stringBuffer = new StringBuffer();
        if (z16) {
            stringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
            stringBuffer.append(File.separator);
            stringBuffer.append(str);
            stringBuffer.append("_NEW.zip");
        } else if (i3 == 1) {
            stringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
            stringBuffer.append(File.separator);
            stringBuffer.append(str);
            stringBuffer.append("_V.zip");
        } else {
            stringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
            stringBuffer.append(File.separator);
            stringBuffer.append(str);
            stringBuffer.append("_HD.zip");
        }
        return stringBuffer.toString();
    }

    public static List<String> c(MessageForDeliverGiftTips messageForDeliverGiftTips) {
        ArrayList arrayList = new ArrayList();
        File file = new File(d(messageForDeliverGiftTips));
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3].getAbsolutePath().endsWith(".png")) {
                    arrayList.add(listFiles[i3].getAbsolutePath());
                }
            }
        }
        return arrayList;
    }

    public static String d(MessageForDeliverGiftTips messageForDeliverGiftTips) {
        String i3 = i(messageForDeliverGiftTips);
        if (messageForDeliverGiftTips.isInteract()) {
            return g(i3);
        }
        return e(i3, messageForDeliverGiftTips.animationType);
    }

    public static String e(String str, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i3 == 1) {
            stringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
            stringBuffer.append(str + "_V");
            stringBuffer.append(File.separator);
        } else {
            stringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
            stringBuffer.append(str + "_HD");
            stringBuffer.append(File.separator);
        }
        return stringBuffer.toString();
    }

    public static String f(MessageForDeliverGiftTips messageForDeliverGiftTips) {
        File file = new File(d(messageForDeliverGiftTips) + "/video.mp4");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static String g(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
        stringBuffer.append(str + "_NEW");
        stringBuffer.append(File.separator);
        return stringBuffer.toString();
    }

    public static JSONObject h(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AppConstants.SDCARD_GIFT_SAVE);
        stringBuffer.append(str + "_NEW");
        stringBuffer.append(File.separator);
        stringBuffer.append("info.json");
        String readFileContent = FileUtils.readFileContent(new File(stringBuffer.toString()));
        if (readFileContent == null) {
            return null;
        }
        try {
            return new JSONObject(readFileContent);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String i(MessageForDeliverGiftTips messageForDeliverGiftTips) {
        if (messageForDeliverGiftTips == null) {
            return null;
        }
        if (messageForDeliverGiftTips.isToAll()) {
            return String.valueOf(messageForDeliverGiftTips.exflag);
        }
        return String.valueOf(messageForDeliverGiftTips.animationPackageId);
    }

    public static Intent j(Activity activity, String str, String str2) {
        Intent troopMemberListActivityLaunchIntent = ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).getTroopMemberListActivityLaunchIntent(activity, str, 14);
        troopMemberListActivityLaunchIntent.putExtra("custom_title_name", activity.getString(R.string.f171418ev1));
        troopMemberListActivityLaunchIntent.putExtra("troop_gift_from", str2);
        return troopMemberListActivityLaunchIntent;
    }

    public static String k(int i3) {
        return VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/.troop/pic_effects/" + i3 + ".mp4");
    }

    public static String l(int i3) {
        return "https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effect_" + i3 + ".mp4";
    }

    public static boolean m(MessageForDeliverGiftTips messageForDeliverGiftTips) {
        if (messageForDeliverGiftTips != null) {
            if (messageForDeliverGiftTips.animationPackageId > 0 || messageForDeliverGiftTips.isToAll()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean n(File file) {
        String[] split;
        if (file.exists()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(file.getAbsolutePath());
            stringBuffer.append(File.separator);
            stringBuffer.append("check.ini");
            File file2 = new File(stringBuffer.toString());
            if (!file2.exists()) {
                return false;
            }
            try {
                String readFileToString = FileUtils.readFileToString(file2);
                if (TextUtils.isEmpty(readFileToString) || (split = readFileToString.split(ContainerUtils.FIELD_DELIMITER)) == null) {
                    return false;
                }
                for (String str : split) {
                    stringBuffer.setLength(0);
                    stringBuffer.append(file.getAbsolutePath());
                    stringBuffer.append(File.separator);
                    stringBuffer.append(str.toString());
                    File file3 = new File(stringBuffer.toString());
                    if (!file3.exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.e(".troop.send_giftTroopMemberUtil", 2, "isAnimationPackageValid File not exist:" + file3.getName());
                        }
                        return false;
                    }
                }
                return true;
            } catch (IOException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopMemberUtil", 2, "isAnimationPackageValid IOException");
                }
            }
        }
        return false;
    }

    public static boolean o(String str, int i3, boolean z16) {
        String e16;
        if (z16) {
            e16 = g(str);
        } else {
            e16 = e(str, i3);
        }
        return n(new File(e16));
    }

    public static boolean p(List<?> list) {
        if (list != null && list.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean q(int i3) {
        if (i3 < 40003 || i3 > 40005) {
            return true;
        }
        File file = new File(k(i3));
        if (file.exists()) {
            long length = file.length();
            if (i3 == 40003 && length == 827720) {
                return true;
            }
            if (i3 == 40004 && length == 355077) {
                return true;
            }
            if (i3 == 40005 && length == 796025) {
                return true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberUtil", 2, "isTroopPicEffectVideoValid = false, id:" + i3);
            return false;
        }
        return false;
    }

    public static void r(File file, String str) {
        File file2 = new File(str);
        if (file2.exists()) {
            for (String str2 : file2.list()) {
                if (!"__MACOSX".equalsIgnoreCase(str2) && !str2.endsWith(".")) {
                    String replace = file.getAbsolutePath().replace(".zip", "/");
                    File file3 = new File(file2, str2);
                    if (file3.exists()) {
                        FileUtils.copyDirectory(file3.getAbsolutePath(), replace, true);
                        FileUtils.deleteDirectory(file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void s(Activity activity, Intent intent, QQAppInterface qQAppInterface) {
        if (intent == null) {
            return;
        }
        t(activity, intent.getStringExtra("troop_uin"), intent.getStringExtra("member_uin"), intent.getStringExtra("member_display_name"), intent.getStringExtra("troop_gift_from"), qQAppInterface);
    }

    public static void t(Activity activity, String str, String str2, String str3, String str4, QQAppInterface qQAppInterface) {
        u(activity, str, str2, str3, str4, qQAppInterface, null);
    }

    public static void u(Activity activity, String str, String str2, String str3, String str4, QQAppInterface qQAppInterface, Map<String, String> map) {
        String str5;
        String str6;
        TroopInfo k3;
        if (activity == null) {
            return;
        }
        int i3 = 0;
        try {
            str5 = Base64.encodeToString(str3.getBytes("UTF-8"), 0);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            str5 = str3;
        }
        if (qQAppInterface != null) {
            ITroopLinkApi iTroopLinkApi = (ITroopLinkApi) QRoute.api(ITroopLinkApi.class);
            str6 = QVipGiftProcessor.getConfig().troopGiftUrl;
            if (!TextUtils.isEmpty(str6)) {
                ITroopLinkApi.a aVar = new ITroopLinkApi.a();
                aVar.f300491a = str;
                aVar.f300493c = str4;
                aVar.f300492b = str2;
                aVar.f300495e = str3;
                str6 = iTroopLinkApi.replaceParams(str6, aVar);
            }
        } else {
            str6 = null;
        }
        if (TextUtils.isEmpty(str6)) {
            Bundle bundle = new Bundle();
            bundle.putString("troopUin", str);
            bundle.putString("uin", str2);
            bundle.putString("name", str5);
            bundle.putString("from", str4);
            bundle.putString("_wv", "1031");
            bundle.putString("_bid", "2204");
            str6 = "https://qun.qq.com/qunpay/gifts/index.html?" + HttpUtil.encodeUrl(bundle);
        }
        String str7 = str6;
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str7);
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                intent.putExtra(entry.getKey(), entry.getValue());
            }
        }
        activity.startActivityForResult(intent, 13001);
        if (qQAppInterface != null && (k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str)) != null) {
            if (!k3.isTroopOwner(qQAppInterface.getCurrentAccountUin())) {
                if (k3.isOwnerOrAdmin()) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
            }
            ReportController.o(qQAppInterface, "P_CliOper", "Grp_flower", "", "mber", "send_page", 0, 0, str, i3 + "", "", "");
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberUtil", 2, "openSendTroopGiftUrl url:" + str7);
        }
    }
}
