package com.tencent.mobileqq.mtt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.qrcode.util.h;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildWebApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(Context context, String str, boolean z16, boolean z17, boolean z18, boolean z19, MessageRecord messageRecord, String str2) {
        if (h.A(str)) {
            Intent intent = new Intent(context, (Class<?>) JoinDiscussionActivity.class);
            int indexOf = str.indexOf("dc/ft?k=");
            if (indexOf > 0) {
                intent.putExtra("innerSig", str.substring(indexOf + 8));
            } else {
                intent.putExtra("innerSig", str);
            }
            context.startActivity(intent);
            return;
        }
        QQAudioHelper.p("gotoWebViewBrowser_" + str);
        Intent intent2 = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
        intent2.putExtra("param_force_internal_browser", z19);
        intent2.putExtra("key_isReadModeEnabled", z16);
        intent2.putExtra("big_brother_source_key", str2);
        if (context instanceof BaseActivity) {
            intent2.putExtra("uin", ((BaseActivity) context).getAppRuntime().getAccount());
        }
        intent2.putExtra("useDefBackText", z18);
        intent2.putExtra("injectrecommend", z17);
        if (messageRecord != null) {
            intent2.putExtra("curtype", messageRecord.istroop);
            intent2.putExtra("friendUin", messageRecord.frienduin);
            int i3 = messageRecord.istroop;
            if (i3 == 0) {
                intent2.putExtra("articalChannelId", 2);
            } else if (i3 == 1) {
                intent2.putExtra("articalChannelId", 3);
            } else if (i3 == 3000) {
                intent2.putExtra("articalChannelId", 4);
            } else if (i3 == 10014) {
                MsgRecord msgRecord = (MsgRecord) messageRecord.extObj;
                intent2.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, msgRecord.getGuildId());
                ((IGuildWebApi) QRoute.api(IGuildWebApi.class)).addGuildSecurityParams(intent2, msgRecord.getSenderUid(), msgRecord.getGuildId());
            }
            if (context instanceof Activity) {
                boolean hasExtra = ((Activity) context).getIntent().hasExtra("key_multiforward_root_msg_record");
                intent2.putExtra("key_multiforward_root_msg_record", hasExtra);
                if (QLog.isColorLevel()) {
                    QLog.i("MttBrowerWrapper", 2, "open url from multiForward: " + hasExtra);
                }
            }
        }
        intent2.putExtra("url", str);
        intent2.putExtra("fromOneCLickCLose", true);
        intent2.putExtra("fromAio", true);
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(messageRecord, intent2, str);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof QQAppInterface) {
            AIOOpenWebMonitor.o(intent2, (QQAppInterface) waitAppRuntime, messageRecord);
        }
        WebAccelerator.s(context, intent2, str);
        ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, str, "", "", "");
    }
}
