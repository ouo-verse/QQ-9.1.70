package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QVipTroopFileConfig {
    private int enable = 0;
    private String cacheFlag = "";
    private String intructionPageUrl = "";
    private String cancleString = "\u6682\u4e0d";
    Info fullSpaceMessage = new Info();
    Info redSubString = new Info();
    Info blueSubString = new Info();
    Info blueActionUrl = new Info();
    Info fullAlertMessage = new Info();
    Info bigFileAlertMessage = new Info();
    Info alertButtonTitle = new Info();
    Info buttonActionUrl = new Info();
    Info aIObuttonActionUrl = new Info();
    boolean needShowGuideAlertFlag = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Info {
        String notVIP = "";
        String normalVIP = "";
        String superVIP = "";

        Info() {
        }

        static Info fromJson(JSONObject jSONObject) {
            Info info = new Info();
            info.notVIP = jSONObject.optString("nonVIP", info.notVIP);
            info.normalVIP = jSONObject.optString(b8.a.f28043VIP, info.normalVIP);
            info.superVIP = jSONObject.optString("SVIP", info.superVIP);
            return info;
        }

        String getString(String str) {
            if ("normal".equals(str)) {
                return this.notVIP;
            }
            if ("vip".equals(str)) {
                return this.normalVIP;
            }
            return this.superVIP;
        }

        public String toString() {
            return "Info{nonVIP='" + this.notVIP + "', VIP='" + this.normalVIP + "', SVIP='" + this.superVIP + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f308950d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f308951e;

        a(String str, String str2) {
            this.f308950d = str;
            this.f308951e = str2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.f308950d.equals(QVipTroopFileConfig.this.blueActionUrl.superVIP)) {
                ((IVasH5PayUtil) QRoute.api(IVasH5PayUtil.class)).openH5Page(this.f308950d, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), view.getContext());
            } else {
                ((IVasH5PayUtil) QRoute.api(IVasH5PayUtil.class)).openH5PayByURL(view.getContext(), this.f308950d);
            }
            QVipTroopFileConfig.report("0X800AE67", this.f308951e, "");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor("#4D94FF"));
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f308953d;

        b(String str) {
            this.f308953d = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ((IVasH5PayUtil) QRoute.api(IVasH5PayUtil.class)).openH5Page(QVipTroopFileConfig.this.intructionPageUrl, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), view.getContext());
            QVipTroopFileConfig.report("0X800AE6D", this.f308953d, "");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor("#4D94FF"));
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f308955d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f308956e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f308957f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f308958h;

        c(Context context, boolean z16, String str, boolean z17) {
            this.f308955d = context;
            this.f308956e = z16;
            this.f308957f = str;
            this.f308958h = z17;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            Info info;
            String str;
            String str2;
            String str3;
            String str4;
            IVasH5PayUtil iVasH5PayUtil = (IVasH5PayUtil) QRoute.api(IVasH5PayUtil.class);
            Context context = this.f308955d;
            if (this.f308956e) {
                info = QVipTroopFileConfig.this.buttonActionUrl;
            } else {
                info = QVipTroopFileConfig.this.aIObuttonActionUrl;
            }
            iVasH5PayUtil.openH5PayByURL(context, info.getString(this.f308957f));
            dialogInterface.dismiss();
            if (this.f308956e) {
                str = "0X800AE6A";
            } else {
                str = "0X800AE64";
            }
            String str5 = this.f308957f;
            if (this.f308958h) {
                str2 = "size";
            } else {
                str2 = "full";
            }
            QVipTroopFileConfig.report(str, str5, str2);
            IMobileReportManager iMobileReportManager = (IMobileReportManager) QRoute.api(IMobileReportManager.class);
            boolean z16 = this.f308956e;
            if (z16) {
                str3 = "2";
            } else {
                str3 = "3";
            }
            if (z16) {
                str4 = "2";
            } else {
                str4 = "1";
            }
            iMobileReportManager.reportAction("Open", "4", SearchConstants.PLATFORM, str3, str4, 102, 1, System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Runnable f308960d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f308961e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f308962f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f308963h;

        d(Runnable runnable, boolean z16, String str, boolean z17) {
            this.f308960d = runnable;
            this.f308961e = z16;
            this.f308962f = str;
            this.f308963h = z17;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            String str2;
            String str3;
            String str4;
            dialogInterface.dismiss();
            this.f308960d.run();
            if (this.f308961e) {
                str = "0X800AE6B";
            } else {
                str = "0X800AE65";
            }
            String str5 = this.f308962f;
            if (this.f308963h) {
                str2 = "size";
            } else {
                str2 = "full";
            }
            QVipTroopFileConfig.report(str, str5, str2);
            IMobileReportManager iMobileReportManager = (IMobileReportManager) QRoute.api(IMobileReportManager.class);
            boolean z16 = this.f308961e;
            if (z16) {
                str3 = "2";
            } else {
                str3 = "3";
            }
            if (z16) {
                str4 = "2";
            } else {
                str4 = "1";
            }
            iMobileReportManager.reportAction("Later", "4", SearchConstants.PLATFORM, str3, str4, 102, 1, System.currentTimeMillis());
        }
    }

    @NonNull
    public static QVipTroopFileConfig fromJson(@Nullable String str) {
        QVipTroopFileConfig qVipTroopFileConfig = new QVipTroopFileConfig();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                qVipTroopFileConfig.enable = jSONObject.optInt("enable", qVipTroopFileConfig.enable);
                qVipTroopFileConfig.cacheFlag = jSONObject.optString("cacheFlag", qVipTroopFileConfig.cacheFlag);
                qVipTroopFileConfig.intructionPageUrl = jSONObject.optString("intructionPageUrl", qVipTroopFileConfig.intructionPageUrl);
                qVipTroopFileConfig.fullSpaceMessage = Info.fromJson(jSONObject.getJSONObject("fullSpaceMessage"));
                qVipTroopFileConfig.redSubString = Info.fromJson(jSONObject.getJSONObject("redSubString"));
                qVipTroopFileConfig.blueSubString = Info.fromJson(jSONObject.getJSONObject("blueSubString"));
                qVipTroopFileConfig.blueActionUrl = Info.fromJson(jSONObject.getJSONObject("blueActionUrl"));
                qVipTroopFileConfig.fullAlertMessage = Info.fromJson(jSONObject.getJSONObject("fullAlertMessage"));
                qVipTroopFileConfig.bigFileAlertMessage = Info.fromJson(jSONObject.getJSONObject("bigFileAlertMessage"));
                qVipTroopFileConfig.alertButtonTitle = Info.fromJson(jSONObject.getJSONObject("alertButtonTitle"));
                qVipTroopFileConfig.buttonActionUrl = Info.fromJson(jSONObject.getJSONObject("buttonActionUrl"));
                qVipTroopFileConfig.aIObuttonActionUrl = Info.fromJson(jSONObject.getJSONObject("AIObuttonActionUrl"));
            }
        } catch (Exception e16) {
            QLog.e("QVIP.TROOP_FILE.ConfigProcessor", 1, "json parse error:" + e16);
        }
        return qVipTroopFileConfig;
    }

    @NonNull
    public static QVipTroopFileConfig obtainDefault() {
        return fromJson("{\"enable\":1,\"cacheFlag\":\"20200403\",\"intructionPageUrl\":\"https://act.qzone.qq.com/vip/meteor/blockly/p/4136x48826\",\"fullSpaceMessage\":{\"nonVIP\":\"\u5f53\u524d\u7fa4\u6587\u4ef6\u5bb9\u91cf\u5df2\u6ee1\uff0c\u65b0\u4e0a\u4f20\u6587\u4ef6\u4ec5\u4fdd\u755910\u5929\uff0c\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\u53ef\u5ef6\u957f\u81f330\u5929\u3002\",\"VIP\":\"\u5f53\u524d\u7fa4\u6587\u4ef6\u5bb9\u91cf\u5df2\u6ee1\uff0c\u4f1a\u5458\u65b0\u4e0a\u4f20\u7684\u6587\u4ef6\u4ec5\u4fdd\u755920\u5929\uff0c\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\u53ef\u5ef6\u957f\u81f330\u5929\u3002\",\"SVIP\":\"\u5f53\u524d\u7fa4\u6587\u4ef6\u5bb9\u91cf\u5df2\u6ee1\uff0c\u4f60\u5df2\u4eab\u53d7\u8d85\u7ea7\u4f1a\u5458\u7279\u6743\uff0c\u65b0\u4e0a\u4f20\u7684\u6587\u4ef6\u53ef\u4fdd\u755930\u5929\u3002\"},\"redSubString\":{\"nonVIP\":\"\u5bb9\u91cf\u5df2\u6ee1\",\"VIP\":\"\u5bb9\u91cf\u5df2\u6ee1\",\"SVIP\":\"\u5bb9\u91cf\u5df2\u6ee1\"},\"blueSubString\":{\"nonVIP\":\"\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\",\"VIP\":\"\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\",\"SVIP\":\"\u8d85\u7ea7\u4f1a\u5458\u7279\u6743\"},\"blueActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_list&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_list&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"https://act.qzone.qq.com/vip/meteor/blockly/p/4136x48826\"},\"fullAlertMessage\":{\"nonVIP\":\"\u5f53\u524d\u7fa4\u6587\u4ef6\u5bb9\u91cf\u5df2\u6ee1\uff0c\u65b0\u4e0a\u4f20\u7684\u6587\u4ef6\u4ec5\u4fdd\u755910\u5929\uff0c\u8d85\u7ea7\u4f1a\u5458\u53ef\u5ef6\u957f\u81f330\u5929\u3002\",\"VIP\":\"\u5f53\u524d\u7fa4\u6587\u4ef6\u5bb9\u91cf\u5df2\u6ee1\uff0c\u4f1a\u5458\u65b0\u4e0a\u4f20\u7684\u6587\u4ef6\u4ec5\u4fdd\u755920\u5929\uff0c\u8d85\u7ea7\u4f1a\u5458\u53ef\u5ef6\u957f\u81f330\u5929\u3002\",\"SVIP\":\"\"},\"bigFileAlertMessage\":{\"nonVIP\":\"\u4e34\u65f6\u6587\u4ef6\u6709\u6548\u671f10\u5929\uff0c\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\u53ef\u5c06\u4fdd\u5b58\u65f6\u95f4\u5ef6\u957f\u81f330\u5929\",\"VIP\":\"\u4f1a\u5458\u4e0a\u4f20\u7684\u4e34\u65f6\u6587\u4ef6\u6709\u6548\u671f20\u5929\uff0c\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\u53ef\u5c06\u4fdd\u5b58\u65f6\u95f4\u5ef6\u957f\u81f330\u5929\u3002\",\"SVIP\":\"\"},\"alertButtonTitle\":{\"nonVIP\":\"\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\",\"VIP\":\"\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\",\"SVIP\":\"\"},\"buttonActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_tf&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_tf&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"\"},\"AIObuttonActionUrl\":{\"nonVIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_aio&month=&type=svip&isAskFriendPay=0\",\"VIP\":\"https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.n.group.qwj_aio&month=&type=svip&isAskFriendPay=0\",\"SVIP\":\"\"}}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(String str, String str2, String str3) {
        int i3;
        if ("normal".equals(str2)) {
            i3 = 1;
        } else if ("vip".equals(str2)) {
            i3 = 2;
        } else if ("svip".equals(str2)) {
            i3 = 3;
        } else {
            i3 = 0;
        }
        ReportController.n(null, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, str, i3, 1, 0, "", "", str3, "");
    }

    public boolean focusFileExpired(@NonNull SpannableString spannableString, @NonNull String str, String str2) {
        String spannableString2;
        int i3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(spannableString)) {
            String trim = Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
            if (TextUtils.isEmpty(trim)) {
                return false;
            }
            try {
                int intValue = Integer.valueOf(trim).intValue();
                if (spannableString.toString().contains("\n")) {
                    spannableString2 = spannableString.toString().replace("\n", "");
                    i3 = 1;
                } else {
                    spannableString2 = spannableString.toString();
                    i3 = 0;
                }
                int indexOf = spannableString2.indexOf(str);
                if (intValue > 10 && indexOf > -1) {
                    spannableString.setSpan(new b(str2), indexOf, str.length() + indexOf + i3, 33);
                    report("0X800AE6C", str2, "");
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public String getCacheFlag() {
        return this.cacheFlag;
    }

    public SpannableString getFullSpaceMessage(String str) {
        String string = this.fullSpaceMessage.getString(str);
        String string2 = this.redSubString.getString(str);
        String string3 = this.blueSubString.getString(str);
        String string4 = this.blueActionUrl.getString(str);
        SpannableString spannableString = new SpannableString(string);
        int indexOf = string.indexOf(string2);
        if (indexOf > -1) {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF0000")), indexOf, string2.length() + indexOf, 33);
        }
        int indexOf2 = string.indexOf(string3);
        if (indexOf2 > -1) {
            spannableString.setSpan(new a(string4, str), indexOf2, string3.length() + indexOf2, 33);
        }
        report("0X800AE66", str, "");
        return spannableString;
    }

    public boolean isEnable() {
        if (this.enable == 1) {
            return true;
        }
        return false;
    }

    boolean needShowGuideAlert() {
        if (!this.needShowGuideAlertFlag) {
            return false;
        }
        this.needShowGuideAlertFlag = false;
        SharedPreferences preferences = MobileQQ.sMobileQQ.waitAppRuntime(null).getPreferences();
        boolean z16 = !TextUtils.equals(this.cacheFlag, preferences.getString("vas_guide_troop_file", null));
        if (z16) {
            preferences.edit().putString("vas_guide_troop_file", this.cacheFlag).apply();
        }
        return z16;
    }

    public boolean showAlertGuideMessage(Context context, Runnable runnable, boolean z16, String str, boolean z17) {
        Info info;
        if (z16) {
            info = this.bigFileAlertMessage;
        } else {
            info = this.fullAlertMessage;
        }
        String string = info.getString(str);
        if (!(!TextUtils.isEmpty(string)) || !needShowGuideAlert()) {
            return false;
        }
        showGuideDialog(context, string, str, runnable, z17, z16);
        return true;
    }

    void showGuideDialog(Context context, String str, String str2, Runnable runnable, boolean z16, boolean z17) {
        String str3;
        String str4;
        String str5;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, "", str, this.cancleString, this.alertButtonTitle.getString(str2), new c(context, z16, str2, z17), new d(runnable, z16, str2, z17));
        createCustomDialog.getTitleTextView().setVisibility(8);
        createCustomDialog.show();
        if (z16) {
            str3 = "0X800AE69";
        } else {
            str3 = "0X800AE63";
        }
        if (z17) {
            str4 = "size";
        } else {
            str4 = "full";
        }
        report(str3, str2, str4);
        IMobileReportManager iMobileReportManager = (IMobileReportManager) QRoute.api(IMobileReportManager.class);
        String str6 = "2";
        if (z16) {
            str5 = "2";
        } else {
            str5 = "3";
        }
        if (!z16) {
            str6 = "1";
        }
        iMobileReportManager.reportAction("", "", SearchConstants.PLATFORM, str5, str6, 111, 1, System.currentTimeMillis());
    }

    public String toString() {
        return "QVipTroopFileConfig{enable=" + this.enable + ", cacheFlag='" + this.cacheFlag + "', intructionPageUrl='" + this.intructionPageUrl + "', fullSpaceMessage=" + this.fullSpaceMessage + ", redSubString=" + this.redSubString + ", blueSubString=" + this.blueSubString + ", blueActionUrl=" + this.blueActionUrl + ", fullAlertMessage=" + this.fullAlertMessage + ", bigFileAlertMessage=" + this.bigFileAlertMessage + ", alertButtonTitle=" + this.alertButtonTitle + ", buttonActionUrl=" + this.buttonActionUrl + ", AIObuttonActionUrl=" + this.aIObuttonActionUrl + '}';
    }
}
