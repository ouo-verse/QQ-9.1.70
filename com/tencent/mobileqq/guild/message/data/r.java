package com.tencent.mobileqq.guild.message.data;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.data.GrayTipsMessageConstants$HighlightItem;
import com.tencent.mobileqq.guild.api.impl.GuildWebApiImpl;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class r extends com.tencent.mobileqq.guild.message.base.n {

    /* renamed from: a, reason: collision with root package name */
    private static String f230378a = "GuildUniteGrayTipSimpleClickHandler";

    private boolean b(Context context, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem) {
        String str;
        if (TextUtils.isEmpty(grayTipsMessageConstants$HighlightItem.mMsgActionData)) {
            str = grayTipsMessageConstants$HighlightItem.mMsgAActionData;
        } else {
            str = grayTipsMessageConstants$HighlightItem.mMsgActionData;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(f230378a, 1, "onClickActionWeb fail! url is empty!");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_isReadModeEnabled", true);
        bundle.putString("big_brother_source_key", "biz_src_jc_aio");
        GuildWebApiImpl.guildOpenWebUrlOnly(context, str, bundle, null, null);
        return true;
    }

    private boolean c(AppRuntime appRuntime, Context context, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem) {
        QLog.i(f230378a, 1, " onClickAppMsg actionData = " + grayTipsMessageConstants$HighlightItem.mMsgActionData + "actionDataA" + grayTipsMessageConstants$HighlightItem.mMsgAActionData);
        String[] e16 = e(grayTipsMessageConstants$HighlightItem.mMsgActionData, grayTipsMessageConstants$HighlightItem.mMsgAActionData);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (InstalledAppListMonitor.getPackageInfo(packageManager, e16[0], 1) == null) {
                return false;
            }
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, e16[0]);
            if (!TextUtils.isEmpty(e16[1]) && launchIntentForPackage != null) {
                launchIntentForPackage.setData(Uri.parse(e16[1]));
            }
            if (launchIntentForPackage != null) {
                try {
                    launchIntentForPackage.putExtra("big_brother_source_key", "biz_src_jc_aio");
                    StartAppCheckHandler startAppCheckHandler = (StartAppCheckHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER);
                    launchIntentForPackage.putExtra("report_open_type", "graytipsmsg");
                    launchIntentForPackage.putExtra("report_url", "");
                    launchIntentForPackage.putExtra("report_from", "1");
                    launchIntentForPackage.putExtra("report_click_origin", "AIOTail");
                    launchIntentForPackage.putExtra("report_class_name", context.getClass().getName());
                    startAppCheckHandler.J2(e16[0].trim(), context, launchIntentForPackage);
                } catch (Exception e17) {
                    QLog.i(f230378a, 1, "StartAppCheckHandler AbsShareMSG Failed! " + e17.toString());
                    context.startActivity(launchIntentForPackage);
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException e18) {
            QLog.e(f230378a, 1, e18.getMessage());
            return b(context, grayTipsMessageConstants$HighlightItem);
        }
    }

    private boolean d(AppRuntime appRuntime, Context context, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem) {
        String str;
        QLog.i(f230378a, 1, "onClickPluginMsg.  actionData = " + grayTipsMessageConstants$HighlightItem.mMsgActionData + ", actionDataA = " + grayTipsMessageConstants$HighlightItem.mMsgAActionData);
        if (!TextUtils.isEmpty(grayTipsMessageConstants$HighlightItem.mMsgAActionData) && !TextUtils.equals("null", grayTipsMessageConstants$HighlightItem.mMsgAActionData)) {
            str = grayTipsMessageConstants$HighlightItem.mMsgAActionData;
        } else {
            str = grayTipsMessageConstants$HighlightItem.mMsgActionData;
        }
        try {
            ax c16 = bi.c((QQAppInterface) appRuntime, context, str);
            if (c16 == null) {
                return false;
            }
            c16.z();
            return c16.b();
        } catch (Exception e16) {
            QLog.e(f230378a, 1, e16.getMessage(), e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.n
    public boolean a(AppRuntime appRuntime, Context context, GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem, Bundle bundle) {
        int i3 = grayTipsMessageConstants$HighlightItem.actionType;
        if (i3 == 1) {
            return b(context, grayTipsMessageConstants$HighlightItem);
        }
        if (i3 == 2) {
            return c(appRuntime, context, grayTipsMessageConstants$HighlightItem);
        }
        if (i3 != 3) {
            return false;
        }
        return d(appRuntime, context, grayTipsMessageConstants$HighlightItem);
    }

    protected final String[] e(String str, String str2) {
        String[] strArr = {"", ""};
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        int indexOf = TextUtils.isEmpty(str) ? -1 : str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        if (indexOf == -1) {
            strArr[0] = str;
        } else {
            strArr[0] = str.substring(0, indexOf);
            strArr[1] = str.substring(indexOf + 3);
        }
        return strArr;
    }
}
