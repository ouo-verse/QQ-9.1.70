package com.tencent.mobileqq.app.security;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.impl.LoginFailedCommonSceneHandlerApiImpl;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsec.api.c;
import com.tencent.mobileqq.qqsec.api.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.cg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.util.WeakReference;
import tencent.im.login.GatewayVerify$RspBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static c f196545b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f196546c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f196547d;

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f196548e;

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f196549f;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<Integer> f196550a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.security.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C7391a extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private String f196551d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<QBaseActivity> f196552e;

        /* renamed from: f, reason: collision with root package name */
        private int f196553f;

        public C7391a(String str, WeakReference<QBaseActivity> weakReference, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, weakReference, Integer.valueOf(i3));
                return;
            }
            this.f196551d = str;
            this.f196552e = weakReference;
            this.f196553f = i3;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            boolean z16;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            WeakReference<QBaseActivity> weakReference = this.f196552e;
            if (weakReference == null) {
                QLog.e("FrozenNotifyDlgHelper", 1, "ExpendClickableSpan param error: mActivity == null");
                return;
            }
            QBaseActivity qBaseActivity = weakReference.get();
            if (qBaseActivity == null) {
                QLog.e("FrozenNotifyDlgHelper", 1, "ExpendClickableSpan param error: context == null");
                return;
            }
            if ("https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027".equals(this.f196551d) && ((i3 = this.f196553f) == 1 || i3 == 4)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ("https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027".equals(this.f196551d)) {
                a.d().j(this.f196553f);
            }
            if (!TextUtils.isEmpty(this.f196551d) && this.f196551d.contains("accounts.qq.com") && this.f196553f == 1) {
                ReportController.r(null, "dc00898", "", "", "0X800B428", "0X800B428", 0, 0, "", "", "", "");
            }
            a.f196545b.b(qBaseActivity, z16, this.f196551d);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            } else {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21878);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        try {
            if (d.f274417a.size() > 0) {
                f196545b = d.f274417a.get(0).newInstance();
                QLog.d("FrozenNotifyDlgHelper", 1, "FrozenNotifyDlgHelper newInstance");
            }
        } catch (Exception e16) {
            QLog.e("FrozenNotifyDlgHelper", 1, "FrozenNotifyDlgHelper static statement: ", e16);
        }
        f196547d = cg.f307524c.pattern() + "|" + cg.f307525d.pattern();
        f196548e = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">");
        f196549f = Pattern.compile("<mark>(.*?)</mark>");
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f196550a = arrayList;
        arrayList.add(2);
        this.f196550a.add(3);
        this.f196550a.add(4);
    }

    public static a d() {
        if (f196546c == null) {
            synchronized (a.class) {
                if (f196546c == null) {
                    f196546c = new a();
                }
            }
        }
        return f196546c;
    }

    private CharSequence h(String str, QBaseActivity qBaseActivity, int i3) {
        boolean z16;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Matcher matcher = f196549f.matcher(str);
        Matcher matcher2 = Pattern.compile(f196547d, 2).matcher(str);
        boolean find = matcher.find();
        boolean find2 = matcher2.find();
        int i16 = 0;
        while (true) {
            if ((find || find2) && i16 < str.length()) {
                if (!find || !find2 ? find : matcher.start() <= matcher2.start()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    int start = matcher.start();
                    if (start >= i16) {
                        if (start > i16) {
                            spannableStringBuilder.append((CharSequence) str.substring(i16, start));
                        }
                        i16 = matcher.end();
                        SpannableString spannableString = new SpannableString(str.substring(matcher.start(1), matcher.end(1)));
                        spannableString.setSpan(new ForegroundColorSpan(qBaseActivity.getResources().getColor(R.color.login_error_url)), 0, spannableString.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString);
                    }
                    find = matcher.find();
                } else {
                    int start2 = matcher2.start();
                    if (start2 >= i16) {
                        if (start2 > i16) {
                            spannableStringBuilder.append((CharSequence) str.substring(i16, start2));
                        }
                        i16 = matcher2.end();
                        String substring = str.substring(start2, matcher2.end());
                        SpannableString spannableString2 = new SpannableString(substring);
                        C7391a c7391a = new C7391a(substring, new WeakReference(qBaseActivity), i3);
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(qBaseActivity.getResources().getColor(R.color.login_error_url));
                        spannableString2.setSpan(c7391a, 0, spannableString2.length(), 33);
                        spannableString2.setSpan(foregroundColorSpan, 0, spannableString2.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString2);
                    }
                    find2 = matcher2.find();
                }
            }
        }
        if (i16 < str.length()) {
            spannableStringBuilder.append((CharSequence) str.substring(i16));
        }
        return spannableStringBuilder;
    }

    private void o(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16) {
        String str;
        QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgActionClk: " + i3 + " isPwdLeaked: " + z16);
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    str = "";
                } else {
                    str = "0X800B5E9";
                }
            } else {
                str = "0X800B5E8";
            }
        } else if (z16) {
            str = "0X800B42C";
        } else {
            str = "0X800B436";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            ReportController.r(baseQQAppInterface, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    private void p(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16) {
        String str;
        QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgCancel: " + i3 + " isPwdLeaked: " + z16);
        if (i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                str = "";
            } else {
                str = "0X800B5EA";
            }
        } else if (z16) {
            str = "0X800B42D";
        } else {
            str = "0X800B437";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            ReportController.r(baseQQAppInterface, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    private void q(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16) {
        String str;
        QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgCntActionClk: " + i3 + " isPwdLeaked: " + z16);
        if (i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                str = "";
            } else {
                str = "0X800B5EB";
            }
        } else if (z16) {
            str = "0X800B432";
        } else {
            str = "0X800B43A";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            ReportController.r(baseQQAppInterface, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    private void r(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16) {
        String str;
        QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgCntCancel: " + i3 + " isPwdLeaked: " + z16);
        if (i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                str = "";
            } else {
                str = "0X800B5EC";
            }
        } else if (z16) {
            str = "0X800B433";
        } else {
            str = "0X800B43B";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            ReportController.r(baseQQAppInterface, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    private void s(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16) {
        String str;
        QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgCntShow: " + i3 + " isPwdLeaked: " + z16);
        if (i3 != 2) {
            str = "";
        } else if (z16) {
            str = "0X800B431";
        } else {
            str = "0X800B439";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            ReportController.r(baseQQAppInterface, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    private void t(BaseQQAppInterface baseQQAppInterface, int i3, boolean z16) {
        String str;
        QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlgShow: " + i3 + " isPwdLeaked: " + z16);
        if (i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                str = "";
            } else {
                str = "0X800B5E7";
            }
        } else if (z16) {
            str = "0X800B42B";
        } else {
            str = "0X800B435";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            ReportController.r(baseQQAppInterface, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    public String b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        QLog.d("FrozenNotifyDlgHelper", 1, "getAppendMsgWithSceneId: " + i3);
        if (i3 != 2 && i3 != 3 && i3 != 4) {
            return "";
        }
        return "\u4f60\u4e5f\u53ef\u4ee5\u5bf9\u8d26\u53f7\u8fdb\u884c<TITLE=\"\u8d44\u91d1\u7ba1\u7406\",URL=\"https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027\">\u3002";
    }

    public int c(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr)).intValue();
        }
        if (bArr == null) {
            QLog.e("FrozenNotifyDlgHelper", 1, "getForbidScene: tlvData == null");
            return -1;
        }
        try {
            GatewayVerify$RspBody gatewayVerify$RspBody = new GatewayVerify$RspBody();
            gatewayVerify$RspBody.mergeFrom(bArr);
            return gatewayVerify$RspBody.msg_rsp_tips_info.uint32_scene_id.get();
        } catch (Exception e16) {
            QLog.e("FrozenNotifyDlgHelper", 1, "getForbidScene error: ", e16);
            return -1;
        }
    }

    public String e(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, str, str2, Boolean.valueOf(z16));
        }
        StringBuilder sb5 = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "https://accounts.qq.com/007";
        }
        QLog.d("FrozenNotifyDlgHelper", 1, "loginFailed, before operate jump url is : " + str);
        sb5.append(str);
        if (!str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
        if (!str.endsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        } else if (str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) != str.lastIndexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        }
        sb5.append("from=andapp");
        if (!z16) {
            sb5.append("&account=");
            sb5.append(str2);
        }
        String sb6 = sb5.toString();
        QLog.d("FrozenNotifyDlgHelper", 1, "loginFailed, after operate jump url is : " + sb6);
        return sb6;
    }

    public int f(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("FrozenNotifyDlgHelper", 1, "getLinkTypeForReport error: msg empty");
            return -1;
        }
        QLog.d("FrozenNotifyDlgHelper", 1, "getLinkTypeForReport msg: " + str + " sceneId: " + i3);
        if (i16 != 0) {
            if (i16 == 1) {
                if (i3 == 2) {
                    if (str.contains("\u5df2\u7ecf\u6cc4\u9732")) {
                        return 3;
                    }
                    return 7;
                }
                if (i3 == 3 || i3 == 4) {
                    return 5;
                }
            }
        } else if (i3 == 2) {
            if (str.contains("\u5df2\u7ecf\u6cc4\u9732")) {
                return 2;
            }
            return 6;
        }
        return -1;
    }

    public int g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
        }
        QLog.d("FrozenNotifyDlgHelper", 1, "getTipWithSceneId: " + i3);
        if (i3 != 2) {
            if (i3 == 3 || i3 != 4) {
                return R.string.f1356101x;
            }
            return R.string.f1356301z;
        }
        return R.string.iao;
    }

    public CharSequence i(String str, QBaseActivity qBaseActivity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CharSequence) iPatchRedirector.redirect((short) 7, this, str, qBaseActivity, Integer.valueOf(i3));
        }
        if (str != null && qBaseActivity != null) {
            if (!cg.f307523b.matcher(str).find()) {
                return str;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
            Matcher matcher = f196548e.matcher(str);
            boolean z16 = false;
            int i17 = 0;
            int i18 = 0;
            while (matcher.find()) {
                int start = matcher.start(0);
                i18 = matcher.end(0);
                String substring = str.substring(matcher.start(1), matcher.end(1));
                String substring2 = str.substring(matcher.start(i16), matcher.end(i16));
                if (i17 != start) {
                    spannableStringBuilder.append((CharSequence) str.substring(i17, start));
                    i17 = i18;
                }
                SpannableString spannableString = new SpannableString(substring);
                spannableString.setSpan(new C7391a(substring2, new WeakReference(qBaseActivity), i3), 0, substring.length(), 33);
                spannableString.setSpan(new ForegroundColorSpan(qBaseActivity.getResources().getColor(R.color.login_error_url)), 0, substring.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
                z16 = true;
                i16 = 2;
            }
            if (z16) {
                spannableStringBuilder.append((CharSequence) str.substring(i18));
                return spannableStringBuilder;
            }
            try {
                return h(str, qBaseActivity, i3);
            } catch (Throwable th5) {
                QLog.e("FrozenNotifyDlgHelper", 1, "handleMarkAndLinkSpan error:", th5);
                return str;
            }
        }
        QLog.e("FrozenNotifyDlgHelper", 1, "handleNotifyMsg error: params wrong");
        return str;
    }

    public void j(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        switch (i3) {
            case 1:
                str = "0X800B429";
                break;
            case 2:
                str = "0X800B42E";
                break;
            case 3:
                str = "0X800B434";
                break;
            case 4:
                str = "0X800B5E5";
                break;
            case 5:
                str = "0X800B5ED";
                break;
            case 6:
                str = "0X800B438";
                break;
            case 7:
                str = "0X800B43C";
                break;
            default:
                str = "";
                break;
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            ReportController.r(null, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    public boolean k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            QLog.e("FrozenNotifyDlgHelper", 1, "isKickedForModifyPwd error: msg empty");
            return false;
        }
        if (str.contains("\u4fee\u6539\u5bc6\u7801") && str.contains("\u8d44\u91d1\u7ba1\u7406")) {
            z16 = true;
        }
        QLog.d("FrozenNotifyDlgHelper", 1, "isKickedForModifyPwd kickedForMdfPwd: " + z16);
        return z16;
    }

    public boolean l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            QLog.e("FrozenNotifyDlgHelper", 1, "isKickedForViolation error: msg empty");
            return false;
        }
        if (str.contains("\u51bb\u7ed3") && str.contains("\u8d44\u91d1\u7ba1\u7406")) {
            z16 = true;
        }
        QLog.d("FrozenNotifyDlgHelper", 1, "isKickedForViolation kickedForViolation: " + z16);
        return z16;
    }

    public boolean m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).booleanValue();
        }
        return str.startsWith(LoginFailedCommonSceneHandlerApiImpl.KEY_MINIAPP_PREFIX);
    }

    public void n(BaseQQAppInterface baseQQAppInterface, int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, baseQQAppInterface, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        QLog.d("FrozenNotifyDlgHelper", 1, "reportFrozenDlg: " + i3 + " type: " + i16 + " msg: " + str);
        if (i3 == 2 && !TextUtils.isEmpty(str) && str.contains("\u5df2\u7ecf\u6cc4\u9732")) {
            z16 = true;
        }
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 == 5) {
                                s(baseQQAppInterface, i3, z16);
                                return;
                            }
                            return;
                        }
                        r(baseQQAppInterface, i3, z16);
                        return;
                    }
                    q(baseQQAppInterface, i3, z16);
                    return;
                }
                p(baseQQAppInterface, i3, z16);
                return;
            }
            o(baseQQAppInterface, i3, z16);
            return;
        }
        t(baseQQAppInterface, i3, z16);
    }

    public boolean u(QBaseActivity qBaseActivity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) qBaseActivity, (Object) str)).booleanValue();
        }
        if (qBaseActivity != null && !TextUtils.isEmpty(str)) {
            if (!m(str)) {
                QLog.e("FrozenNotifyDlgHelper", 1, "unBlockWithMiniAppFromCnt: errorUrl is not miniapp url");
                return false;
            }
            if (MiniAppSecurityUtil.checkMiniAppForLogin(str)) {
                QLog.d("FrozenNotifyDlgHelper", 1, "unBlockWithMiniAppFromCnt: startMiniApp");
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(qBaseActivity, str, 2119, null);
            } else {
                QLog.e("FrozenNotifyDlgHelper", 1, "MiniAppLauncher.startMiniApp error: fake app!");
            }
            return true;
        }
        QLog.e("FrozenNotifyDlgHelper", 1, "unBlockWithMiniAppFromCnt error: params empty");
        return false;
    }
}
