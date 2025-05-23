package com.tencent.mobileqq.vas.util;

import MQQ.LhLogoInfo;
import MQQ.LhLogoResources;
import MQQ.VAResourcesRsp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.api.IVasLiangNum;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyAccountConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyAccountProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class PrettyAccountUtil {
    public static final int BG_INTERVAL_SPACE = 8;
    public static final int DEFAULT_ACCOUNT_SIZE = 17;
    public static final int DEFAULT_TEXT_SIZE = 14;
    public static final int ERROR_LEVEL = -1;
    public static final String KEY_PRETTY_ACCOUNT_INFO = "pretty_account_info";
    public static final int LH_FLAG = 1;
    public static final int LOGO_BG_HEIGHT = 23;
    public static final int LOGO_FORE_HEIGHT = 22;
    public static final int LOGO_WIDTH = 26;
    private static final String TAG = "PrettyAccountUtil";
    public static long infoUpdateInterVal = 86400;
    public static long lastReportTime = 0;
    public static long lastSynTime = 1594224000;
    public static long lastUpdateInfoTime;
    private static final Map<Integer, LhLogoResources> LH_INFO = new ConcurrentHashMap();
    static int[] prettyAccountTag = {37, 9, 35, 36, 38};

    public static int calLiangNumTopMargin(Context context, ProfileCardInfo profileCardInfo, Card card) {
        int dip2px;
        try {
            if (!QQTheme.isNowSimpleUI() && card.cardId > 0) {
                if (ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId) || TextUtils.isEmpty(card.qid)) {
                    return 0;
                }
                dip2px = DisplayUtil.dip2px(context, 3.8f);
            } else {
                int cardTopMargin = cardTopMargin(profileCardInfo);
                if (cardTopMargin == 0) {
                    dip2px = DisplayUtil.dip2px(context, 3.0f);
                } else {
                    if (cardTopMargin != -2) {
                        return 0;
                    }
                    dip2px = DisplayUtil.dip2px(context, 1.0f);
                }
            }
            return dip2px;
        } catch (Exception e16) {
            QLog.i(TAG, 1, "calLiangNumTopMargin", e16);
            return 0;
        }
    }

    protected static int cardTopMargin(ProfileCardInfo profileCardInfo) {
        Card card;
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            boolean z16 = true;
            if (isPrettyOpenForCard(card) != 1) {
                z16 = false;
            }
            if (!TextUtils.isEmpty(profileCardInfo.card.qidLogoUrl)) {
                if (z16) {
                    return -3;
                }
                return -2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearTextViewStatus(TextView textView, String str, int i3) {
        textView.setText("");
        textView.setContentDescription("\u9753\u53f7" + str);
        textView.setPadding(0, 0, 0, 0);
        textView.setCompoundDrawables(null, null, null, null);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i3;
            ViewParent parent = textView.getParent();
            while (true) {
                if (parent == null) {
                    break;
                }
                if (parent.getClass().getSimpleName().equals("OldProfileHeadView")) {
                    marginLayoutParams.bottomMargin = DisplayUtil.dip2px(textView.getContext(), 4.0f);
                    break;
                }
                parent = parent.getParent();
            }
            textView.setLayoutParams(layoutParams);
        }
    }

    static /* bridge */ /* synthetic */ SharedPreferences d() {
        return getPrettyAccountSp();
    }

    private static String getCurrentUin() {
        return VasUtil.getCurrentUin();
    }

    private static LhLogoResources getInfoByLocal(int i3) {
        SharedPreferences prettyAccountSp = getPrettyAccountSp();
        String string = prettyAccountSp.getString("apngUrl" + i3, "");
        String string2 = prettyAccountSp.getString("backUrl" + i3, "");
        String string3 = prettyAccountSp.getString("logoUrl" + i3, "");
        String string4 = prettyAccountSp.getString("normalColor" + i3, "");
        String string5 = prettyAccountSp.getString("lightColor" + i3, "");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
            return new LhLogoResources(string2, string, string3, string4, string5);
        }
        return null;
    }

    public static int getLhFlagValue() {
        return getPrettyAccountSp().getInt("lh_flag_" + getCurrentUin(), 0);
    }

    public static int getLhLevelValue() {
        return getPrettyAccountSp().getInt("lh_level_" + getCurrentUin(), -1);
    }

    public static LhLogoResources getLhLogoResources(int i3) {
        JSONObject optJSONObject;
        if (i3 == -1) {
            return null;
        }
        if (ar.a("kenaiyu", "2025-03-20", "vas_cool_number_resource").isEnable(true) && (optJSONObject = ar.a("kenaiyu", "2025-03-20", "vas_cool_number_resource").getJson().optJSONObject(String.valueOf(i3))) != null) {
            return new LhLogoResources(optJSONObject.optString("backUrl"), optJSONObject.optString("apngUrl"), optJSONObject.optString("logoUrl"), optJSONObject.optString("normalColor"), optJSONObject.optString("lightColor"));
        }
        Map<Integer, LhLogoResources> map = LH_INFO;
        LhLogoResources lhLogoResources = map.get(Integer.valueOf(i3));
        if (lhLogoResources == null) {
            lhLogoResources = getInfoByLocal(i3);
        }
        if (lhLogoResources != null) {
            map.put(Integer.valueOf(i3), lhLogoResources);
        }
        return lhLogoResources;
    }

    private static SharedPreferences getPrettyAccountSp() {
        if (ar.b("linkliang", "2024-02-22", "vas_bug_pretty_account_mmkv").isEnable(true)) {
            return VipMMKV.getSVipQQSettingMe(BaseApplication.getContext(), KEY_PRETTY_ACCOUNT_INFO);
        }
        return BaseApplication.getContext().getSharedPreferences(KEY_PRETTY_ACCOUNT_INFO, 0);
    }

    @NotNull
    private static String getSopName(AppRuntime appRuntime, ProfileCardInfo profileCardInfo, boolean z16) {
        if (TextUtils.isEmpty(profileCardInfo.allInOne.troopUin)) {
            if (profileCardInfo.allInOne.uin.equals(appRuntime.getCurrentAccountUin())) {
                if (z16) {
                    return "0X800B22E";
                }
                return "0X800B22D";
            }
            if (z16) {
                return "0X800B230";
            }
            return "0X800B22F";
        }
        if (profileCardInfo.allInOne.uin.equals(appRuntime.getCurrentAccountUin())) {
            if (z16) {
                return "0X800B234";
            }
            return "0X800B233";
        }
        if (z16) {
            return "0X800B236";
        }
        return "0X800B235";
    }

    public static TextView handleAccountCloth(TextView textView, int i3, int i16) {
        return handleAccountCloth(textView, i3, i16, 0, "", 0);
    }

    public static TextView handleAccountClothForList(TextView textView, int i3, int i16, int i17, int i18) {
        textView.setBackgroundDrawable(null);
        textView.setTextColor(i17);
        textView.setTextSize(1, i18);
        return handleAccountCloth(textView, i3, i16);
    }

    public static CharSequence handleAccountTxt(int i3, int i16, CharSequence charSequence, String str) {
        if (TextUtils.isEmpty(str)) {
            return charSequence;
        }
        if (i16 < 0) {
            return charSequence;
        }
        if (manageOpen() && 1 == i3) {
            if (LH_INFO.isEmpty()) {
                return charSequence;
            }
            return str;
        }
        return charSequence;
    }

    public static int isPrettyOpenForCard(Card card) {
        if (card == null || (card.lUserFlag & 1024) != 1024) {
            return 0;
        }
        return 1;
    }

    public static void jumpAccountInfoPage() {
        String currentUin = VasUtil.getCurrentUin();
        String url = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.VIP_PERSONAL_CARD_MASTER);
        Intent qQBrowserIntent = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).getQQBrowserIntent();
        qQBrowserIntent.putExtra("uin", currentUin);
        qQBrowserIntent.putExtra("url", url);
        qQBrowserIntent.putExtra("hide_more_button", true);
        qQBrowserIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        BaseApplication.getContext().startActivity(qQBrowserIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleAccountCloth$1(final TextView textView, final String str, final int i3) {
        textView.post(new Runnable() { // from class: com.tencent.mobileqq.vas.util.b
            @Override // java.lang.Runnable
            public final void run() {
                PrettyAccountUtil.clearTextViewStatus(textView, str, i3);
            }
        });
    }

    public static boolean manageOpen() {
        QVipPrettyAccountConfig qVipPrettyAccountConfig = QVipPrettyAccountProcessor.get();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "pretty_account manageOpen:" + qVipPrettyAccountConfig.isEnable);
        }
        return qVipPrettyAccountConfig.isEnable;
    }

    public static void reportLhEvent(String str, int i3, int i16) {
        if (manageOpen() && 1 == i3) {
            ReportController.o(VasUtil.getApp(), "dc00898", "", "", "", str, i16, 0, "", "", "", "");
        }
    }

    public static void reportLhEventForCard(AppRuntime appRuntime, ProfileCardInfo profileCardInfo, boolean z16) {
        if (appRuntime != null && profileCardInfo != null && profileCardInfo.card != null) {
            if (!z16) {
                if (System.currentTimeMillis() - lastReportTime < 1500) {
                    return;
                } else {
                    lastReportTime = System.currentTimeMillis();
                }
            }
            reportLhEvent(getSopName(appRuntime, profileCardInfo, z16), isPrettyOpenForCard(profileCardInfo.card), profileCardInfo.card.lhLevel);
        }
    }

    public static void setAccountText(TextView textView, int i3, int i16, CharSequence charSequence, String str, int i17, int i18) {
        textView.setText(handleAccountTxt(i3, i16, charSequence, str));
        handleAccountCloth(textView, i3, i16, i17, str, i18);
    }

    public static void updateFlagInfoForSelf(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "pretty_account update self:" + i3 + "," + i16);
        }
        if (i16 == -1) {
            return;
        }
        SharedPreferences.Editor edit = getPrettyAccountSp().edit();
        edit.putInt("lh_flag_" + getCurrentUin(), i3);
        edit.putInt("lh_level_" + getCurrentUin(), i16);
        edit.apply();
    }

    public static void updateLhLogoInfo(VAResourcesRsp vAResourcesRsp) {
        LhLogoInfo lhLogoInfo = vAResourcesRsp.lhLogoInfo;
        if (lhLogoInfo != null) {
            boolean z16 = true;
            if (lhLogoInfo.bUpdate == 1 && lhLogoInfo.lhLogoResources != null) {
                Map<Integer, LhLogoResources> map = LH_INFO;
                map.clear();
                map.putAll(lhLogoInfo.lhLogoResources);
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("pretty_account update state:");
                sb5.append(lhLogoInfo.bUpdate);
                sb5.append(",");
                if (lhLogoInfo.lhLogoResources != null) {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d(TAG, 2, sb5.toString());
            }
            updateToLocal();
        }
    }

    private static void updateToLocal() {
        if (LH_INFO.size() == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastUpdateInfoTime < infoUpdateInterVal) {
            return;
        }
        lastUpdateInfoTime = currentTimeMillis;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.util.PrettyAccountUtil.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    for (Integer num : PrettyAccountUtil.LH_INFO.keySet()) {
                        LhLogoResources lhLogoResources = (LhLogoResources) PrettyAccountUtil.LH_INFO.get(num);
                        if (lhLogoResources == null) {
                            return;
                        }
                        PrettyAccountUtil.d().edit().putString("apngUrl" + num, lhLogoResources.apngUrl).putString("backUrl" + num, lhLogoResources.backUrl).putString("logoUrl" + num, lhLogoResources.logoUrl).putString("normalColor" + num, lhLogoResources.normalColor).putString("lightColor" + num, lhLogoResources.lightColor).apply();
                    }
                } catch (Exception e16) {
                    QLog.d(PrettyAccountUtil.TAG, 1, "pretty_account update error:", e16);
                }
            }
        }, 64, null, false);
    }

    public static TextView handleAccountCloth(TextView textView, int i3, int i16, int i17, String str) {
        return handleAccountCloth(textView, i3, i16, i17, str, 0);
    }

    public static TextView handleAccountCloth(final TextView textView, int i3, int i16, int i17, final String str, final int i18) {
        LhLogoResources lhLogoResources;
        ViewGroup.LayoutParams layoutParams;
        IVasLiangNum iVasLiangNum = (IVasLiangNum) QRoute.api(IVasLiangNum.class);
        if (iVasLiangNum.isEnable() && i17 > 0) {
            int dip2px = DisplayUtil.dip2px(textView.getContext(), 15.0f);
            String charSequence = TextUtils.isEmpty(str) ? textView.getText().toString() : str;
            Pair<Integer, Integer> presettingWH = iVasLiangNum.getPresettingWH(charSequence);
            if (presettingWH.getFirst().intValue() > 0 && presettingWH.getSecond().intValue() > 0 && (layoutParams = textView.getLayoutParams()) != null) {
                layoutParams.width = presettingWH.getFirst().intValue() - 1;
                layoutParams.height = presettingWH.getSecond().intValue() - 1;
                textView.setLayoutParams(layoutParams);
            }
            if (textView.getBackground() instanceof IVasLiangNum.a) {
                textView.setVisibility(0);
                if (((IVasLiangNum.a) textView.getBackground()).k(i17)) {
                    clearTextViewStatus(textView, str, i18);
                    return textView;
                }
            }
            iVasLiangNum.setLiangNumDrawable(textView, i17, dip2px, charSequence, "profile", new IVasLiangNum.c() { // from class: com.tencent.mobileqq.vas.util.a
                @Override // com.tencent.mobileqq.vas.api.IVasLiangNum.c
                public final void a() {
                    PrettyAccountUtil.lambda$handleAccountCloth$1(textView, str, i18);
                }
            });
            return textView;
        }
        if (!TextUtils.isEmpty(str) && (textView.getBackground() instanceof IVasLiangNum.a)) {
            textView.setText(str);
        }
        if (!manageOpen() || 1 != i3 || (lhLogoResources = getLhLogoResources(i16)) == null) {
            return textView;
        }
        textView.setGravity(16);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(Color.parseColor(lhLogoResources.normalColor));
        textView.setPadding(0, 0, 0, 0);
        Rect rect = new Rect();
        String charSequence2 = textView.getText().toString();
        textView.getPaint().getTextBounds(charSequence2, 0, charSequence2.length(), rect);
        int dip2px2 = ViewUtils.dip2px(26.0f) + rect.width() + ViewUtils.dip2px(8.0f);
        int dip2px3 = ViewUtils.dip2px(23.0f);
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        layoutParams2.width = dip2px2;
        layoutParams2.height = dip2px3;
        textView.setLayoutParams(layoutParams2);
        textView.setBackgroundDrawable(VasApngUtil.getRegionUrlDrawable(lhLogoResources.backUrl, 320));
        URLDrawable apngURLDrawable = VasApngUtil.getApngURLDrawable(lhLogoResources.apngUrl, prettyAccountTag, com.tencent.mobileqq.urldrawable.b.f306350a);
        int dip2px4 = ViewUtils.dip2px(22.0f);
        apngURLDrawable.setBounds(0, 0, (dip2px4 * 26) / 22, dip2px4);
        textView.setCompoundDrawables(apngURLDrawable, null, null, null);
        return textView;
    }

    public static TextView handleAccountClothForList(TextView textView, int i3, int i16, int i17) {
        textView.setBackgroundDrawable(null);
        textView.setTextSize(1, i17);
        return handleAccountCloth(textView, i3, i16);
    }
}
