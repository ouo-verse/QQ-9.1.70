package com.tencent.mobileqq.qqgift.utils;

import android.text.TextUtils;
import com.tencent.avbiz.Constants;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.HashMap;

/* loaded from: classes16.dex */
public class QQGiftPanelUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f265037a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31529);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f265037a = new HashMap<String, String>() { // from class: com.tencent.mobileqq.qqgift.utils.QQGiftPanelUtil.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put("1001", "\u7fa4\u793c\u7269");
                    put("1002", "QQ\u76f4\u64ad");
                    put("1003", "\u9891\u9053\u793c\u7269");
                    put(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_AVCAMERAUSED, Constants.Business.QQ_GUILD_LIVE_AUTHOR);
                    put(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR, "QQ\u76f4\u64ad");
                    put(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_INSTALLERROR, "QQ\u76f4\u64ad");
                    put(PluginJumpManager.CONFIG_BID, "QQ\u76f4\u64ad");
                    put(AppConstants.GRAY_TIP_BUSI_ID, "QQ\u76f4\u64ad");
                    put("1009", "\u8d85\u7ea7QQ\u79c0");
                    put(HippyQQConstants.HIPPY_BID, "\u4e92\u52a8\u76f4\u64ad");
                }
            };
        }
    }

    public static String a(String str) {
        String str2 = f265037a.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        QLog.w("QQGiftPanelUtil", 1, "appId not found in map");
        return "";
    }
}
