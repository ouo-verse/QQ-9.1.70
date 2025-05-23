package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ShareMsgHelper implements AppConstants {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.tencent.mobileqq.data.MessageForArkApp] */
    public static synchronized MessageRecord a(QQAppInterface qQAppInterface, String str, int i3, AbsStructMsg absStructMsg) {
        MessageForStructing messageForStructing;
        ?? convertMultiStructMrToArkMr;
        synchronized (ShareMsgHelper.class) {
            if (i3 != 0 && i3 != 1 && i3 != 3000) {
                messageForStructing = null;
            } else {
                String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                int i16 = MobileQQServiceBase.seq;
                MobileQQServiceBase.seq = i16 + 1;
                MessageForStructing A = com.tencent.mobileqq.service.message.q.A(qQAppInterface, currentAccountUin, str, currentAccountUin, i3, i16, absStructMsg);
                if (ArkMsgUtils.isXmlToArkEnabled() && (convertMultiStructMrToArkMr = ArkMsgUtils.convertMultiStructMrToArkMr(A)) != 0) {
                    A = convertMultiStructMrToArkMr;
                }
                com.tencent.mobileqq.activity.aio.forward.b.d().e(A.uniseq, 0L, absStructMsg.forwardID);
                qQAppInterface.getMessageFacade().n(A, 0);
                messageForStructing = A;
            }
        }
        return messageForStructing;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Intent b(Context context, int i3, int i16, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, Intent intent, int i17, String str19, long j3) {
        Intent intent2;
        WebViewFragment currentWebViewFragment;
        WebViewFragment currentWebViewFragment2;
        String str20 = str4;
        String str21 = str5;
        if (intent == null) {
            intent2 = new Intent();
            intent2.putExtra("key_flag_from_plugin", true);
            intent2.setClass(context, ForwardRecentActivity.class);
        } else {
            intent2 = intent;
        }
        intent2.putExtra("isFromShare", true);
        intent2.putExtra("forward_type", i3);
        intent2.putExtra("pluginName", str);
        intent2.putExtra(AppConstants.Key.SHARE_REQ_TYPE, i16);
        intent2.putExtra("detail_url", str7);
        intent2.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, str3);
        intent2.putExtra(AppConstants.Key.SHARE_SOURCE_URL, str19);
        if (j3 != -1) {
            intent2.putExtra("req_share_id", j3);
        }
        intent2.putExtra(IPublicAccountJavascriptInterface.KEY_PUB_UIN, str2);
        intent2.putExtra("struct_uin", str2);
        boolean z16 = context instanceof com.tencent.mobileqq.webview.swift.u;
        if (z16 && (currentWebViewFragment2 = ((com.tencent.mobileqq.webview.swift.u) context).getCurrentWebViewFragment()) != null) {
            intent2.putExtra("strurt_msgid", ((SwiftBrowserShareMenuHandler) currentWebViewFragment2.getComponentProvider().a(4)).K);
            intent2.putExtra("emoInputType", 1);
            intent2.putExtra("forward _key_nojump", true);
        }
        if (i16 == 44 || i16 == 1 || i16 == 95) {
            intent2.putExtra("forward _key_nojump", true);
        }
        if (str20 != null && str4.length() > 45) {
            str20 = str20.substring(0, 45) + "\u2026";
        }
        intent2.putExtra("title", str20);
        if (str21 != null && str5.length() > 60) {
            str21 = str21.substring(0, 60) + "\u2026";
        }
        intent2.putExtra("desc", str21);
        intent2.putExtra(AppConstants.Key.FORWARD_THUMB, str18);
        intent2.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION, str8);
        intent2.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_A_ACTION_DATA, str10);
        intent2.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_I_ACTION_DATA, str11);
        intent2.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION_DATA, str9);
        intent2.putExtra("req_share_id", -1L);
        intent2.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, str12);
        intent2.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION_DATA, str13);
        intent2.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_A_ACTION_DATA, str14);
        intent2.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_I_ACTION_DATA, str15);
        intent2.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, str16);
        intent2.putExtra("app_name", str17);
        intent2.putExtra(AppConstants.Key.SHARE_BRIEF, str6);
        if ("struct_favorite".equals(str)) {
            intent2.putExtra("k_favorites", false);
            intent2.putExtra("forward _key_nojump", true);
        }
        AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(intent2.getExtras());
        if (e16 == null) {
            return null;
        }
        intent2.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e16.getBytes());
        if ((i17 < 0 || !(context instanceof Activity)) && ((1001 == i3 || 38 == i3) && z16 && (currentWebViewFragment = ((com.tencent.mobileqq.webview.swift.u) context).getCurrentWebViewFragment()) != null)) {
            SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) currentWebViewFragment.getComponentProvider().a(4);
            intent2.putExtra("strurt_msgid", swiftBrowserShareMenuHandler.K);
            intent2.putExtra("struct_uin", swiftBrowserShareMenuHandler.J);
            intent2.putExtra("struct_url", currentWebViewFragment.getUrl());
            intent2.putExtra(QZoneShareManager.QZONE_SHARE_FROM_WEB, true);
            String str22 = swiftBrowserShareMenuHandler.L;
            if (str22 != null && !"".equals(str22)) {
                intent2.putExtra("source_puin", swiftBrowserShareMenuHandler.L);
            }
        }
        return intent2;
    }

    public static void c(QQAppInterface qQAppInterface, String str, int i3, AbsStructMsg absStructMsg, BusinessObserver businessObserver, String str2, String str3) {
        String str4;
        if (i3 == 0 || i3 == 1 || i3 == 1000 || i3 == 1001 || i3 == 1004 || i3 == 1006 || i3 == 1010 || i3 == 1024 || i3 == 3000 || i3 == 10002 || i3 == 10004 || i3 == 10008 || i3 == 10010) {
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            int i16 = MobileQQServiceBase.seq;
            MobileQQServiceBase.seq = i16 + 1;
            long j3 = i16;
            if (TextUtils.isEmpty(str)) {
                str4 = currentAccountUin;
            } else {
                str4 = str;
            }
            MessageForStructing A = com.tencent.mobileqq.service.message.q.A(qQAppInterface, currentAccountUin, str, str4, i3, j3, absStructMsg);
            QLog.i(com.tencent.mobileqq.teamwork.t.f292405j, 1, "sendDocsStructingMsg. disUin = " + str + ", disUinType = " + i3 + ", seq = " + j3 + ", shmsgseq = " + A.shmsgseq + ", time = " + A.time);
            qQAppInterface.getMessageFacade().a(A, null);
            if (i3 == 0 || i3 == 1) {
                ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).addTeamWorkGrayTips(qQAppInterface, str, i3, A.shmsgseq, A.time + 1, str2, str3);
            }
        }
    }

    public static boolean d(Context context, int i3, int i16, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18) {
        return f(context, i3, i16, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, "", null, -1, str18, -1L);
    }

    public static boolean e(Context context, int i3, int i16, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Intent intent, int i17) {
        return f(context, i3, i16, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, "", intent, i17, null, -1L);
    }

    public static boolean f(Context context, int i3, int i16, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, Intent intent, int i17, String str19, long j3) {
        Intent b16 = b(context, i3, i16, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, intent, i17, str19, j3);
        if (b16 != null) {
            if (i17 >= 0 && (context instanceof Activity)) {
                ((Activity) context).startActivityForResult(b16, i17);
                return true;
            }
            context.startActivity(b16);
            return true;
        }
        return false;
    }

    public static void g(final QQAppInterface qQAppInterface, final String str, final int i3, final AbsStructMsg absStructMsg, final BusinessObserver businessObserver) {
        if (absStructMsg != null) {
            com.tencent.mobileqq.statistics.e.d(absStructMsg);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.utils.ShareMsgHelper.1
            @Override // java.lang.Runnable
            public void run() {
                ShareMsgHelper.i(QQAppInterface.this, str, null, i3, absStructMsg, businessObserver);
            }
        }, 8, null, false);
    }

    public static void h(final QQAppInterface qQAppInterface, final String str, final String str2, final int i3, final AbsStructMsg absStructMsg, final BusinessObserver businessObserver) {
        if (absStructMsg != null) {
            com.tencent.mobileqq.statistics.e.d(absStructMsg);
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.utils.ShareMsgHelper.2
            @Override // java.lang.Runnable
            public void run() {
                ShareMsgHelper.i(QQAppInterface.this, str, str2, i3, absStructMsg, businessObserver);
            }
        });
    }

    public static void i(QQAppInterface qQAppInterface, String str, String str2, int i3, AbsStructMsg absStructMsg, BusinessObserver businessObserver) {
        long j3;
        String str3;
        MessageRecord A;
        String str4;
        String str5;
        if (i3 != 0 && i3 != 1 && i3 != 1000 && i3 != 1001 && i3 != 1010 && i3 != 1024 && i3 != 3000 && i3 != 10002 && i3 != 10004 && i3 != 10008 && i3 != 10010) {
            switch (i3) {
                case 1004:
                case 1006:
                    break;
                case 1005:
                    if (absStructMsg == null) {
                        return;
                    }
                    int i16 = absStructMsg.mMsgServiceID;
                    if (i16 == 1) {
                        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                        int i17 = MobileQQServiceBase.seq;
                        MobileQQServiceBase.seq = i17 + 1;
                        MessageForStructing A2 = com.tencent.mobileqq.service.message.q.A(qQAppInterface, currentAccountUin, str, currentAccountUin, i3, i17, absStructMsg);
                        com.tencent.mobileqq.forward.utils.f fVar = com.tencent.mobileqq.forward.utils.f.f211079a;
                        fVar.q(fVar.c(i3, str, str2), A2);
                        return;
                    }
                    if (i16 == 41) {
                        String currentAccountUin2 = qQAppInterface.getCurrentAccountUin();
                        int i18 = MobileQQServiceBase.seq;
                        MobileQQServiceBase.seq = i18 + 1;
                        MessageForStructing A3 = com.tencent.mobileqq.service.message.q.A(qQAppInterface, currentAccountUin2, str, currentAccountUin2, i3, i18, absStructMsg);
                        com.tencent.mobileqq.forward.utils.f fVar2 = com.tencent.mobileqq.forward.utils.f.f211079a;
                        fVar2.q(fVar2.c(i3, str, str2), A3);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        String currentAccountUin3 = qQAppInterface.getCurrentAccountUin();
        int i19 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i19 + 1;
        long j16 = i19;
        int i26 = absStructMsg.forwardID;
        int i27 = absStructMsg.mMsgServiceID;
        if (i27 == 80) {
            if (TextUtils.isEmpty(str2)) {
                str5 = currentAccountUin3;
            } else {
                str5 = str2;
            }
            j3 = j16;
            A = com.tencent.mobileqq.service.message.q.y(qQAppInterface, currentAccountUin3, str, str5, i3, j16, absStructMsg);
        } else {
            j3 = j16;
            if (i27 == 118) {
                if (TextUtils.isEmpty(str2)) {
                    str4 = currentAccountUin3;
                } else {
                    str4 = str2;
                }
                A = com.tencent.mobileqq.service.message.q.C(qQAppInterface, currentAccountUin3, str, str4, i3, j3, absStructMsg);
            } else {
                if (TextUtils.isEmpty(str2)) {
                    str3 = currentAccountUin3;
                } else {
                    str3 = str2;
                }
                A = com.tencent.mobileqq.service.message.q.A(qQAppInterface, currentAccountUin3, str, str3, i3, j3, absStructMsg);
            }
        }
        int i28 = absStructMsg.mMsgServiceID;
        if (i28 == 41) {
            com.tencent.mobileqq.activity.aio.forward.b.d().e(A.uniseq, absStructMsg.parentUniseq, i26);
            com.tencent.mobileqq.forward.utils.f fVar3 = com.tencent.mobileqq.forward.utils.f.f211079a;
            fVar3.q(fVar3.c(i3, str, str2), A);
        } else {
            if (i28 == 100) {
                absStructMsg.mMsgServiceID = 1;
                MessageForStructing A4 = com.tencent.mobileqq.service.message.q.A(qQAppInterface, currentAccountUin3, str, currentAccountUin3, i3, j3, absStructMsg);
                com.tencent.mobileqq.activity.aio.forward.b.d().e(A4.uniseq, absStructMsg.parentUniseq, i26);
                com.tencent.mobileqq.forward.utils.f fVar4 = com.tencent.mobileqq.forward.utils.f.f211079a;
                fVar4.q(fVar4.c(i3, str, str2), A4);
                return;
            }
            com.tencent.mobileqq.activity.aio.forward.b.d().e(A.uniseq, absStructMsg.parentUniseq, i26);
            com.tencent.mobileqq.forward.utils.f fVar5 = com.tencent.mobileqq.forward.utils.f.f211079a;
            fVar5.q(fVar5.c(i3, str, str2), A);
        }
    }
}
