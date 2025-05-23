package com.tencent.mobileqq.profilecard.base.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class SpringPKReportUtil {
    static IPatchRedirector $redirector_;
    public static String TAG;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74004);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TAG = "ProfileKoiLikeReportUtil";
        }
    }

    public SpringPKReportUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void pkArkClickReport(String str, String str2, String str3) {
        String str4;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
            if (!TextUtils.isEmpty(currentAccountUin) && currentAccountUin.equals(str)) {
                str4 = "0";
                VideoReport.reportEvent(SpringPkReportConstant.EV_ZPLAN_23APRING_PK_ARK_CLCK, new HashMap<String, Object>(str4, str, str2, str3) { // from class: com.tencent.mobileqq.profilecard.base.utils.SpringPKReportUtil.4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$finalIsHost;
                    final /* synthetic */ String val$scene;
                    final /* synthetic */ String val$sourceUin;
                    final /* synthetic */ String val$targetUin;

                    {
                        this.val$finalIsHost = str4;
                        this.val$sourceUin = str;
                        this.val$targetUin = str2;
                        this.val$scene = str3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, str4, str, str2, str3);
                            return;
                        }
                        put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                        put("zplan_zhutai_ketai", str4);
                        put(SpringPkReportConstant.PAK_ZPLAN_SHARE_FROM_QQ, str);
                        put("zplan_other_user_qq", str2);
                        put("zplan_is_friend_or_group", str3);
                    }
                });
            }
        }
        str4 = "1";
        VideoReport.reportEvent(SpringPkReportConstant.EV_ZPLAN_23APRING_PK_ARK_CLCK, new HashMap<String, Object>(str4, str, str2, str3) { // from class: com.tencent.mobileqq.profilecard.base.utils.SpringPKReportUtil.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$finalIsHost;
            final /* synthetic */ String val$scene;
            final /* synthetic */ String val$sourceUin;
            final /* synthetic */ String val$targetUin;

            {
                this.val$finalIsHost = str4;
                this.val$sourceUin = str;
                this.val$targetUin = str2;
                this.val$scene = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str4, str, str2, str3);
                    return;
                }
                put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                put("zplan_zhutai_ketai", str4);
                put(SpringPkReportConstant.PAK_ZPLAN_SHARE_FROM_QQ, str);
                put("zplan_other_user_qq", str2);
                put("zplan_is_friend_or_group", str3);
            }
        });
    }

    public static void pkArkImpReport(String str, String str2, String str3) {
        String str4;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
            if (!TextUtils.isEmpty(currentAccountUin) && currentAccountUin.equals(str)) {
                str4 = "0";
                VideoReport.reportEvent(SpringPkReportConstant.EV_ZPLAN_23APRING_PK_ARK_IMP, new HashMap<String, Object>(str4, str, str2, str3) { // from class: com.tencent.mobileqq.profilecard.base.utils.SpringPKReportUtil.3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$finalIsHost;
                    final /* synthetic */ String val$scene;
                    final /* synthetic */ String val$sourceUin;
                    final /* synthetic */ String val$targetUin;

                    {
                        this.val$finalIsHost = str4;
                        this.val$sourceUin = str;
                        this.val$targetUin = str2;
                        this.val$scene = str3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, str4, str, str2, str3);
                            return;
                        }
                        put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                        put("zplan_zhutai_ketai", str4);
                        put(SpringPkReportConstant.PAK_ZPLAN_SHARE_FROM_QQ, str);
                        put("zplan_other_user_qq", str2);
                        put("zplan_is_friend_or_group", str3);
                    }
                });
            }
        }
        str4 = "1";
        VideoReport.reportEvent(SpringPkReportConstant.EV_ZPLAN_23APRING_PK_ARK_IMP, new HashMap<String, Object>(str4, str, str2, str3) { // from class: com.tencent.mobileqq.profilecard.base.utils.SpringPKReportUtil.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$finalIsHost;
            final /* synthetic */ String val$scene;
            final /* synthetic */ String val$sourceUin;
            final /* synthetic */ String val$targetUin;

            {
                this.val$finalIsHost = str4;
                this.val$sourceUin = str;
                this.val$targetUin = str2;
                this.val$scene = str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str4, str, str2, str3);
                    return;
                }
                put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                put("zplan_zhutai_ketai", str4);
                put(SpringPkReportConstant.PAK_ZPLAN_SHARE_FROM_QQ, str);
                put("zplan_other_user_qq", str2);
                put("zplan_is_friend_or_group", str3);
            }
        });
    }

    public static void pkTagClickReport(String str, String str2, String str3, String str4) {
        VideoReport.reportEvent(SpringPkReportConstant.EV_ZPLAN_23APRING_PK_TAG_CLCK, new HashMap<String, Object>(str, str2, str3, str4) { // from class: com.tencent.mobileqq.profilecard.base.utils.SpringPKReportUtil.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$host;
            final /* synthetic */ String val$level;
            final /* synthetic */ String val$name;
            final /* synthetic */ String val$uin;

            {
                this.val$host = str;
                this.val$uin = str2;
                this.val$name = str3;
                this.val$level = str4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4);
                    return;
                }
                put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                put("zplan_zhutai_ketai", str);
                put("zplan_other_user_qq", str2);
                put(SpringPkReportConstant.PAK_ZPLAN_PK_TAG_TYPE, str3);
                put(SpringPkReportConstant.PAK_ZPLAN_PK_TAG_LEVEL, str4);
            }
        });
    }

    public static void pkTagImpReport(String str, String str2, String str3, String str4) {
        VideoReport.reportEvent(SpringPkReportConstant.EV_ZPLAN_23APRING_PK_TAG_IMP, new HashMap<String, Object>(str, str2, str3, str4) { // from class: com.tencent.mobileqq.profilecard.base.utils.SpringPKReportUtil.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$host;
            final /* synthetic */ String val$level;
            final /* synthetic */ String val$name;
            final /* synthetic */ String val$uin;

            {
                this.val$host = str;
                this.val$uin = str2;
                this.val$name = str3;
                this.val$level = str4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4);
                    return;
                }
                put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                put("zplan_zhutai_ketai", str);
                put("zplan_other_user_qq", str2);
                put(SpringPkReportConstant.PAK_ZPLAN_PK_TAG_TYPE, str3);
                put(SpringPkReportConstant.PAK_ZPLAN_PK_TAG_LEVEL, str4);
            }
        });
    }
}
