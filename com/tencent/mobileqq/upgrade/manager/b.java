package com.tencent.mobileqq.upgrade.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static boolean a(NewUpgradeConfig newUpgradeConfig, UpgradeInfo upgradeInfo, XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        if (str.equalsIgnoreCase("configId")) {
            newUpgradeConfig.dialog.f306149a = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("taskName")) {
            newUpgradeConfig.dialog.f306150b = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("taskTime")) {
            newUpgradeConfig.dialog.f306151c = com.tencent.mobileqq.olympic.utils.a.b(xmlPullParser.nextText());
        } else if (str.equalsIgnoreCase(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME)) {
            newUpgradeConfig.dialog.f306152d = com.tencent.mobileqq.olympic.utils.a.b(xmlPullParser.nextText());
        } else if (str.equalsIgnoreCase("title")) {
            newUpgradeConfig.dialog.f306153e = xmlPullParser.nextText();
            upgradeInfo.strTitle = newUpgradeConfig.dialog.f306153e;
        } else if (str.equalsIgnoreCase("strNewTitle")) {
            newUpgradeConfig.dialog.f306154f = xmlPullParser.nextText();
            upgradeInfo.strNewTitle = newUpgradeConfig.dialog.f306154f;
        } else if (str.equalsIgnoreCase("content")) {
            newUpgradeConfig.dialog.f306155g = xmlPullParser.nextText();
            upgradeInfo.strUpgradeDesc = newUpgradeConfig.dialog.f306155g;
        } else if (str.equalsIgnoreCase("desc")) {
            newUpgradeConfig.dialog.f306156h = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("installFail")) {
            newUpgradeConfig.dialog.f306157i = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("info")) {
            newUpgradeConfig.dialog.f306158j = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("yellowBar")) {
            newUpgradeConfig.dialog.f306159k = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("barContent")) {
            newUpgradeConfig.dialog.f306160l = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("barContent2")) {
            newUpgradeConfig.dialog.f306161m = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("lBtnText")) {
            newUpgradeConfig.dialog.f306162n = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("rBtnText")) {
            newUpgradeConfig.dialog.f306163o = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("downloadDialogMaxTimes")) {
            newUpgradeConfig.dialog.f306165q = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("downloadDialogDayRate")) {
            newUpgradeConfig.dialog.f306166r = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("installDialogMaxTimes")) {
            newUpgradeConfig.dialog.f306167s = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("installDialogDayRate")) {
            newUpgradeConfig.dialog.f306168t = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("preDownloadYYB")) {
            newUpgradeConfig.dialog.f306164p = xmlPullParser.nextText().equals("1");
        } else {
            return false;
        }
        return true;
    }

    public static boolean b(UpgradeInfo upgradeInfo, XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        if (str.equalsIgnoreCase("iUpgradeSdkId")) {
            upgradeInfo.iUpgradeSdkId = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("iUpgradeType")) {
            upgradeInfo.iUpgradeType = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("iDownloadPageUrl")) {
            String nextText = xmlPullParser.nextText();
            upgradeInfo.strUrl = nextText;
            upgradeInfo.strUpgradePageUrl = nextText;
            upgradeInfo.strNewUpgradeDescURL = nextText;
        } else if (str.equalsIgnoreCase("iActionType")) {
            upgradeInfo.iActionType = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("bNewSwitch")) {
            upgradeInfo.bNewSwitch = Byte.valueOf(xmlPullParser.nextText()).byteValue();
        } else if (str.equalsIgnoreCase("iIncrementUpgrade")) {
            upgradeInfo.iIncrementUpgrade = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("iTipsType")) {
            upgradeInfo.iTipsType = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("strProgressName")) {
            upgradeInfo.strProgressName = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("strNewSoftwareURL")) {
            upgradeInfo.strNewSoftwareURL = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("strNewSoftwareMD5")) {
            upgradeInfo.strNewSoftwareMD5 = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("bGray")) {
            upgradeInfo.bGray = Byte.valueOf(xmlPullParser.nextText()).byteValue();
        } else if (str.equalsIgnoreCase("strButtonDesc")) {
            upgradeInfo.strButtonDesc = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("strCancelButtonDescNew")) {
            upgradeInfo.strCancelButtonDesc = xmlPullParser.nextText();
        } else if (str.equalsIgnoreCase("iNewTimeStamp")) {
            upgradeInfo.iNewTimeStamp = Integer.valueOf(xmlPullParser.nextText()).intValue();
        } else if (str.equalsIgnoreCase("strNewTipsDescURL")) {
            upgradeInfo.strNewTipsDescURL = xmlPullParser.nextText();
        } else {
            return false;
        }
        return true;
    }
}
