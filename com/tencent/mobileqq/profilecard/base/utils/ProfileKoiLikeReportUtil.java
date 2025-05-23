package com.tencent.mobileqq.profilecard.base.utils;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ProfileKoiLikeReportUtil {
    static IPatchRedirector $redirector_;
    public static String TAG;
    private View mElementView;
    private LinearLayout mPageView;

    /* loaded from: classes16.dex */
    private static class HelperHolder {
        static IPatchRedirector $redirector_;
        private static final ProfileKoiLikeReportUtil INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73997);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new ProfileKoiLikeReportUtil();
            }
        }

        HelperHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73998);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            TAG = "ProfileKoiLikeReportUtil";
        }
    }

    ProfileKoiLikeReportUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mPageView = new LinearLayout(BaseApplication.getContext());
        View view = new View(BaseApplication.getContext());
        this.mElementView = view;
        this.mPageView.addView(view);
    }

    public static ProfileKoiLikeReportUtil getInstance() {
        return HelperHolder.INSTANCE;
    }

    private void koiTellArkReport(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if ("imp".equals(str)) {
                VideoReport.reportEvent(KoiReportConstant.EV_ZPLAN_TELL_TA_ARK_IMP, new HashMap<String, Object>(str2, str3) { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileKoiLikeReportUtil.5
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$level;
                    final /* synthetic */ String val$toUin;

                    {
                        String str4;
                        this.val$level = str2;
                        this.val$toUin = str3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, ProfileKoiLikeReportUtil.this, str2, str3);
                            return;
                        }
                        put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                        put(KoiReportConstant.PAK_ZPLAN_KOI_LIKE_LEVEL, str2);
                        if (ProfileKoiLikeReportUtil.this.getUserUin().equals(str3)) {
                            str4 = "1";
                        } else {
                            str4 = "0";
                        }
                        put(KoiReportConstant.PAK_ZPLAN_IS_SEND_PEOPLE, str4);
                    }
                });
            } else if ("click".equals(str)) {
                VideoReport.reportEvent(KoiReportConstant.EV_ZPLAN_TELL_TA_ARK_CLICK, new HashMap<String, Object>(str2, str3) { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileKoiLikeReportUtil.6
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$level;
                    final /* synthetic */ String val$toUin;

                    {
                        String str4;
                        this.val$level = str2;
                        this.val$toUin = str3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, ProfileKoiLikeReportUtil.this, str2, str3);
                            return;
                        }
                        put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                        put(KoiReportConstant.PAK_ZPLAN_KOI_LIKE_LEVEL, str2);
                        if (ProfileKoiLikeReportUtil.this.getUserUin().equals(str3)) {
                            str4 = "1";
                        } else {
                            str4 = "0";
                        }
                        put(KoiReportConstant.PAK_ZPLAN_IS_SEND_PEOPLE, str4);
                    }
                });
            }
        }
    }

    private void koiThankArkReport(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if ("imp".equals(str)) {
                VideoReport.reportEvent(KoiReportConstant.EV_ZPLAN_THANKS_TA_ARK_IMP, new HashMap<String, Object>(str2, str3) { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileKoiLikeReportUtil.3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$level;
                    final /* synthetic */ String val$toUin;

                    {
                        String str4;
                        this.val$level = str2;
                        this.val$toUin = str3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, ProfileKoiLikeReportUtil.this, str2, str3);
                            return;
                        }
                        put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                        put(KoiReportConstant.PAK_ZPLAN_KOI_LIKE_LEVEL, str2);
                        if (ProfileKoiLikeReportUtil.this.getUserUin().equals(str3)) {
                            str4 = "1";
                        } else {
                            str4 = "0";
                        }
                        put(KoiReportConstant.PAK_ZPLAN_IS_SEND_PEOPLE, str4);
                    }
                });
            } else if ("click".equals(str)) {
                VideoReport.reportEvent(KoiReportConstant.EV_ZPLAN_THANKS_TA_CLICK, new HashMap<String, Object>(str2, str3) { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileKoiLikeReportUtil.4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$level;
                    final /* synthetic */ String val$toUin;

                    {
                        String str4;
                        this.val$level = str2;
                        this.val$toUin = str3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, ProfileKoiLikeReportUtil.this, str2, str3);
                            return;
                        }
                        put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                        put(KoiReportConstant.PAK_ZPLAN_KOI_LIKE_LEVEL, str2);
                        if (ProfileKoiLikeReportUtil.this.getUserUin().equals(str3)) {
                            str4 = "1";
                        } else {
                            str4 = "0";
                        }
                        put(KoiReportConstant.PAK_ZPLAN_IS_SEND_PEOPLE, str4);
                    }
                });
            }
        }
    }

    public String getUserUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        String currentUin = peekAppRuntime.getCurrentUin();
        if (TextUtils.isEmpty(currentUin)) {
            return "";
        }
        return currentUin;
    }

    public void koiArkReport(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, str3, str4);
        } else if ("1".equals(str)) {
            koiTellArkReport(str2, str3, str4);
        } else if ("2".equals(str)) {
            koiThankArkReport(str2, str3, str4);
        }
    }

    public void koiTitleReport(String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            if (TextUtils.isEmpty(str2)) {
                VideoReport.reportEvent(str, new HashMap<String, Object>(str3, str4, str5) { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileKoiLikeReportUtil.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$paramKey;
                    final /* synthetic */ String val$paramValue;
                    final /* synthetic */ String val$uin;

                    {
                        String str6;
                        this.val$paramKey = str3;
                        this.val$paramValue = str4;
                        this.val$uin = str5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, ProfileKoiLikeReportUtil.this, str3, str4, str5);
                            return;
                        }
                        put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
                        put(str3, str4);
                        if (ProfileKoiLikeReportUtil.this.getUserUin().equals(str5)) {
                            str6 = "0";
                        } else {
                            str6 = "1";
                        }
                        put(KoiReportConstant.PAK_ZPLAN_OWN_VISITOR_STATE, str6);
                        put("zplan_other_user_qq", str5);
                    }
                });
                return;
            } else {
                VideoReport.reportEvent(str, new HashMap<String, Object>(str2, str3, str4, str5) { // from class: com.tencent.mobileqq.profilecard.base.utils.ProfileKoiLikeReportUtil.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$appKey;
                    final /* synthetic */ String val$paramKey;
                    final /* synthetic */ String val$paramValue;
                    final /* synthetic */ String val$uin;

                    {
                        String str6;
                        this.val$appKey = str2;
                        this.val$paramKey = str3;
                        this.val$paramValue = str4;
                        this.val$uin = str5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, ProfileKoiLikeReportUtil.this, str2, str3, str4, str5);
                            return;
                        }
                        put(DTParamKey.REPORT_KEY_APPKEY, str2);
                        put(str3, str4);
                        if (ProfileKoiLikeReportUtil.this.getUserUin().equals(str5)) {
                            str6 = "0";
                        } else {
                            str6 = "1";
                        }
                        put(KoiReportConstant.PAK_ZPLAN_OWN_VISITOR_STATE, str6);
                        put("zplan_other_user_qq", str5);
                    }
                });
                return;
            }
        }
        VideoReport.reportEvent(str, null);
    }
}
