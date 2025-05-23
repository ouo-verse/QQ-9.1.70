package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.emoticon.api.IFunnyPicHelperService;
import com.tencent.mobileqq.emoticonview.EmoticonStoreTabEntryUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.EmojiHomeUiPluginConstant;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.constants.QQBrowserActivityConstants;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasCommonAdapterImpl implements IVasCommonAdapter {
    private static final int TIPS_TYPE_DIALOG = 1;
    private static final int TIPS_TYPE_PAY = 2;

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public String addParamToUrl(String str, String str2) {
        return HtmlOffline.b(str, str2);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public void clearMagicFontCache(AppRuntime appRuntime) {
        VasUtils.c((AppInterface) appRuntime);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public Bitmap decodeFileWithBufferedStream(String str, BitmapFactory.Options options) {
        return BaseImageUtil.decodeFileWithBufferedStream(str, options);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public yc2.a getBaseChatPieAdapter(Context context) {
        if (context instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) context;
            if (baseActivity.getChatFragment() != null && baseActivity.getChatFragment().qh() != null) {
                return new com.tencent.mobileqq.panel.a(baseActivity.getChatFragment().qh());
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public int getChatTextSize(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            return ChatTextSizeSettingActivity.H2(((QQAppInterface) appRuntime).getApp());
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public String getKeyIsKandianEmoticon() {
        return EmojiHomeUiPluginConstant.EXTRA_KEY_IS_KANDIAN_EMOTICON;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public String getKeyIsShowAD() {
        return "isShowAd";
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public String getKeyIsSmallEmoticon() {
        return EmojiHomeUiPluginConstant.EXTRA_KEY_IS_SMALL_EMOTICON;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public QQProgressDialog getProgressDialog(Context context) {
        BaseActivity baseActivity = (BaseActivity) context;
        if (baseActivity.getChatFragment() != null && baseActivity.getChatFragment().qh() != null) {
            if (baseActivity.getChatFragment().qh().f25588m == null) {
                baseActivity.getChatFragment().qh().f25588m = new QQProgressDialog(context);
            }
            return baseActivity.getChatFragment().qh().f25588m;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public Class<?> getQQBrowserActivityClass() {
        return QQBrowserActivity.class;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public void getRichTextChatConfig(AppInterface appInterface) {
        if (appInterface instanceof QQAppInterface) {
            com.tencent.mobileqq.flashchat.e.d((QQAppInterface) appInterface).a(appInterface);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public String getUserDataString() {
        return "content://qq.friendlist/individuationUserData";
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public boolean hasSysEmotion(String str) {
        return TextUtils.hasSysEmotion(str);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public String insertMtype(String str, String str2) {
        return com.tencent.mobileqq.emosm.e.A(str, str2);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public Intent insertWbPlugin(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        if (com.tencent.mobileqq.webview.swift.ag.f314191a.containsKey(str)) {
            intent.putExtra("insertPluginsArray", new String[]{str});
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public boolean isFragmentStyleOrEmoStore(Intent intent) {
        if (intent == null || intent.getIntExtra("fragmentStyle", 0) != 4) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public boolean isLaterVersionByUrlConfig(String str, String str2) {
        return com.tencent.mobileqq.webview.swift.utils.i.o(str, AppSetting.f99551k);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public String isShowAdKey() {
        return "isShowAd";
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public void parseURLJson(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            ((URLInterceptManager) appRuntime.getManager(QQManagerFactory.URL_INTECEPT_MANAGER)).j((QQAppInterface) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public String processEmoStoreHomeUrl(String str) {
        return EmoticonStoreTabEntryUtils.processEmoStoreHomeUrl(str);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public Bundle putSrcType(Bundle bundle) {
        bundle.putInt("srcType", 2);
        return bundle;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public Intent putWebViewTitleStyle(Intent intent, String str) {
        WebViewTitleStyle webViewTitleStyle = com.tencent.mobileqq.webview.n.a().f314000a.get(str);
        if (webViewTitleStyle != null) {
            intent.putExtra(QQBrowserActivityConstants.KEY_TITLE_STYLE, webViewTitleStyle);
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public void reportClickEventTo644(AppInterface appInterface, String str, String str2, String str3, int i3, int i16, String[] strArr) {
        String str4;
        String str5;
        String str6 = "UNKNOWN";
        if (appInterface instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (android.text.TextUtils.isEmpty(str)) {
                str5 = "UNKNOWN";
            } else {
                str5 = str;
            }
            ReportController.o(qQAppInterface, "P_CliOper", str5, "", str2, str3, i3, i16, strArr[0], strArr[1], strArr[2], strArr[3]);
            return;
        }
        if (appInterface != null) {
            if (!android.text.TextUtils.isEmpty(str)) {
                str6 = str;
            }
            com.tencent.mobileqq.utils.g.a(appInterface, "P_CliOper", str6, "", str2, str3, i3, i16, strArr[0], strArr[1], strArr[2], strArr[3]);
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str4 = "UNKNOWN";
        } else {
            str4 = str;
        }
        ReportController.o(null, "P_CliOper", str4, "", str2, str3, i3, i16, strArr[0], strArr[1], strArr[2], strArr[3]);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public void reportClickEventTo644V2(AppInterface appInterface, String str, String str2, String str3, String str4, int i3, int i16, String[] strArr) {
        String str5;
        String str6;
        String str7 = "UNKNOWN";
        if (appInterface instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            if (android.text.TextUtils.isEmpty(str)) {
                str6 = "UNKNOWN";
            } else {
                str6 = str;
            }
            ReportController.o(qQAppInterface, "P_CliOper", str6, str4, str2, str3, i3, i16, strArr[0], strArr[1], strArr[2], strArr[3]);
            return;
        }
        if (appInterface != null) {
            if (!android.text.TextUtils.isEmpty(str)) {
                str7 = str;
            }
            com.tencent.mobileqq.utils.g.a(appInterface, "P_CliOper", str7, str4, str2, str3, i3, i16, strArr[0], strArr[1], strArr[2], strArr[3]);
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str5 = "UNKNOWN";
        } else {
            str5 = str;
        }
        ReportController.o(null, "P_CliOper", str5, str4, str2, str3, i3, i16, strArr[0], strArr[1], strArr[2], strArr[3]);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public void reportRedPacket(AppRuntime appRuntime) {
        String str;
        if (((IndividualRedPacketManager) appRuntime.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER)).v()) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(appRuntime, "CliOper", "", "", "0X800612B", "0X800612B", 0, 0, str, "0", "", "");
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public void resolveFunnyPicJson(AppRuntime appRuntime) {
        ((IFunnyPicHelperService) QRoute.api(IFunnyPicHelperService.class)).resolveFunnyPicJson((AppInterface) appRuntime);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public Intent setBrowserTitleStyle(Intent intent, String str) {
        if (intent == null) {
            return null;
        }
        WebViewTitleStyle webViewTitleStyle = com.tencent.mobileqq.webview.n.a().f314000a.get(str);
        if (webViewTitleStyle != null) {
            intent.putExtra(QQBrowserActivityConstants.KEY_TITLE_STYLE, webViewTitleStyle);
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public void setColorNickEnabke(boolean z16) {
        com.tencent.mobileqq.vas.f.D.set(z16);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public void setSignatureEnable(boolean z16) {
        SignatureManager.M = z16;
        if (QLog.isColorLevel()) {
            QLog.d("DiySignature", 2, "diySigEnable = " + SignatureManager.M);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public void updateMsgFieldByUniseq(String str, int i3, long j3, String str2, String str3) {
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getMessageFacade().a1(str, i3, j3, AppConstants.Key.COLUMN_EXT_STR, str2);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasCommonAdapter
    public void startWebSoRequest(String str) {
    }
}
