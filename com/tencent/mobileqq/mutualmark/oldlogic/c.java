package com.tencent.mobileqq.mutualmark.oldlogic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.mutualmark.d;
import com.tencent.mobileqq.mutualmark.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.imagespan.UrlBottomImageSpan;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$ToDegradeInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f252252a;

        /* renamed from: b, reason: collision with root package name */
        String f252253b;

        /* renamed from: c, reason: collision with root package name */
        int f252254c;

        /* renamed from: d, reason: collision with root package name */
        String f252255d;

        /* renamed from: e, reason: collision with root package name */
        int f252256e;

        /* renamed from: f, reason: collision with root package name */
        int f252257f;

        /* renamed from: g, reason: collision with root package name */
        long f252258g;

        /* renamed from: h, reason: collision with root package name */
        String f252259h;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f252252a = "";
            this.f252253b = "";
            this.f252254c = 0;
            this.f252255d = "";
            this.f252256e = 0;
            this.f252257f = 0;
            this.f252258g = 0L;
            this.f252259h = "";
        }
    }

    public static void a(QQAppInterface qQAppInterface, submsgtype0xc7$RelationalChainChange submsgtype0xc7_relationalchainchange, PushMsg0x210C7Info pushMsg0x210C7Info) {
        QLog.i("ReactivePushHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 app:" + qQAppInterface + "  changeInfo:" + submsgtype0xc7_relationalchainchange + "  msginfo:" + pushMsg0x210C7Info);
        if (qQAppInterface != null && submsgtype0xc7_relationalchainchange != null && pushMsg0x210C7Info != null) {
            String valueOf = String.valueOf(submsgtype0xc7_relationalchainchange.uint64_src_uin.get());
            String valueOf2 = String.valueOf(submsgtype0xc7_relationalchainchange.uint64_dst_uin.get());
            if (TextUtils.equals(qQAppInterface.getCurrentAccountUin(), valueOf) && !TextUtils.isEmpty(valueOf2)) {
                int i3 = submsgtype0xc7_relationalchainchange.uint32_change_type.get();
                if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf2), "ReactivePushHelper")) {
                    QLog.i("ReactivePushHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 is not friend");
                } else if (i3 == 10001) {
                    f(qQAppInterface, submsgtype0xc7_relationalchainchange, valueOf2, pushMsg0x210C7Info);
                }
            }
        }
    }

    private static void b(QQAppInterface qQAppInterface, a aVar, PushMsg0x210C7Info pushMsg0x210C7Info, submsgtype0xc7$ToDegradeInfo submsgtype0xc7_todegradeinfo) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.i("ReactivePushHelper", 2, "insertGrayTips uin:" + aVar.f252259h + " grayTips:" + aVar.f252252a + " nick:" + aVar.f252253b + " lNotifyTime:" + aVar.f252258g);
        }
        if (TextUtils.isEmpty(aVar.f252252a)) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(aVar.f252252a);
        ArrayList<d.b> d16 = d.d(qQAppInterface, aVar.f252259h, sb5);
        aVar.f252252a = sb5.toString();
        String str2 = aVar.f252259h;
        g gVar = new g(str2, str2, aVar.f252252a, 0, aVar.f252254c, aVar.f252256e, e.K0());
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.hasRead = 0;
        messageForUniteGrayTip.subType = aVar.f252257f;
        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
        if (!TextUtils.isEmpty(aVar.f252255d)) {
            messageForUniteGrayTip.tipParam.f213693p = aVar.f252255d;
        } else {
            messageForUniteGrayTip.tipParam.f213693p = aVar.f252259h + "_reactive_" + pushMsg0x210C7Info.msgSeq + "_" + aVar.f252258g;
        }
        d.f(gVar, d16);
        messageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_WillDowngradeSoon", "true");
        if (submsgtype0xc7_todegradeinfo == null || submsgtype0xc7_todegradeinfo.rpt_to_degrade_item.isEmpty()) {
            str = "";
        } else {
            str = MutualMarkConfProcessor.a().b(aVar.f252259h) + "&mutualmark_id=" + submsgtype0xc7_todegradeinfo.rpt_to_degrade_item.get(0).type.get();
        }
        com.tencent.mobileqq.mutualmark.nt.g.INSTANCE.a().e(str).f(d16).c(qQAppInterface, aVar.f252259h, aVar.f252256e, gVar.f213683f);
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A1BC", "0X800A1BC", 0, 0, "", "", "", "");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (d(qQAppInterface, aVar.f252258g, currentTimeMillis, "0")) {
            ((IMessageFacade) qQAppInterface.getRuntimeService(IMessageFacade.class, "")).setIncomingMsg(((IMessageFacade) qQAppInterface.getRuntimeService(IMessageFacade.class, "")).getLastMessage(messageForUniteGrayTip.frienduin, messageForUniteGrayTip.istroop));
            qQAppInterface.handleReceivedMessage(1, true, true);
            ((IMessageFacade) qQAppInterface.getRuntimeService(IMessageFacade.class, "")).setIncomingMsg(null);
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A1BE", "0X800A1BE", 1, 0, "", "", "", "");
            h(qQAppInterface, aVar.f252258g, currentTimeMillis, "0");
            if (QLog.isColorLevel()) {
                QLog.d("ReactivePushHelper", 2, "ShowNotification, localtime:" + currentTimeMillis + " servertime:" + aVar.f252258g + " frienduin:" + aVar.f252259h);
            }
        }
    }

    public static boolean c(QQAppInterface qQAppInterface, Message message) {
        MessageForUniteGrayTip messageForUniteGrayTip;
        if (message == null || qQAppInterface == null || message.msgtype != -5040) {
            return false;
        }
        try {
            messageForUniteGrayTip = (MessageForUniteGrayTip) qQAppInterface.getMessageFacade().w0(message.frienduin, message.istroop, message.uniseq);
        } catch (Exception e16) {
            QLog.i("ReactivePushHelper", 1, "query msg exception:" + e16.toString());
            messageForUniteGrayTip = null;
        }
        if (messageForUniteGrayTip == null) {
            QLog.i("ReactivePushHelper", 1, "query msg, msg is null");
            return false;
        }
        g gVar = messageForUniteGrayTip.tipParam;
        if (gVar != null && com.tencent.mobileqq.mutualmark.g.m(gVar.f213685h)) {
            QLog.i("ReactivePushHelper", 1, "isReactivePushTips : true");
            return true;
        }
        return false;
    }

    private static boolean d(AppInterface appInterface, long j3, long j16, String str) {
        return false;
    }

    private static boolean e(AppInterface appInterface, long j3, String str) {
        if (appInterface == null) {
            return false;
        }
        long A1 = ea.A1(BaseApplication.getContext(), appInterface.getCurrentUin(), str);
        if (QLog.isColorLevel()) {
            QLog.d("ReactivePushHelper", 2, "needShowTips, LastTime:" + A1 + " servertime:" + j3 + " frienduin:" + str);
        }
        if (A1 != 0 && j3 == A1) {
            return false;
        }
        return true;
    }

    private static void f(QQAppInterface qQAppInterface, submsgtype0xc7$RelationalChainChange submsgtype0xc7_relationalchainchange, String str, PushMsg0x210C7Info pushMsg0x210C7Info) {
        submsgtype0xc7$ToDegradeInfo submsgtype0xc7_todegradeinfo;
        long j3;
        String str2;
        String str3 = null;
        if (submsgtype0xc7_relationalchainchange.msg_to_degrade_info.has()) {
            submsgtype0xc7_todegradeinfo = submsgtype0xc7_relationalchainchange.msg_to_degrade_info.get();
        } else {
            submsgtype0xc7_todegradeinfo = null;
        }
        if (submsgtype0xc7_todegradeinfo == null) {
            return;
        }
        a aVar = new a();
        aVar.f252259h = str;
        aVar.f252256e = 2097155;
        int i3 = 0;
        aVar.f252257f = 0;
        if (submsgtype0xc7_todegradeinfo.bytes_nick.has()) {
            str3 = submsgtype0xc7_todegradeinfo.bytes_nick.get().toStringUtf8();
        }
        aVar.f252253b = str3;
        if (submsgtype0xc7_todegradeinfo.notify_time.has()) {
            j3 = submsgtype0xc7_todegradeinfo.notify_time.get();
        } else {
            j3 = 0;
        }
        aVar.f252258g = j3;
        if (QLog.isColorLevel()) {
            QLog.i("ReactivePushHelper", 2, "onWillDowngradeSoon, nick:" + aVar.f252253b + " notifytime:" + aVar.f252258g);
        }
        if (!e(qQAppInterface, aVar.f252258g, str)) {
            return;
        }
        if (TextUtils.isEmpty(aVar.f252253b)) {
            aVar.f252253b = ac.H(qQAppInterface, str);
            if (QLog.isColorLevel()) {
                QLog.i("ReactivePushHelper", 2, "onWillDowngradeSoon, local nick:" + aVar.f252253b);
            }
        }
        if (submsgtype0xc7_todegradeinfo.uint32_graytip_type.has()) {
            i3 = submsgtype0xc7_todegradeinfo.uint32_graytip_type.get();
        }
        aVar.f252254c = i3;
        aVar.f252254c = d.e(i3);
        String str4 = "";
        if (!submsgtype0xc7_todegradeinfo.bytes_duplicate_removal.has()) {
            str2 = "";
        } else {
            str2 = submsgtype0xc7_todegradeinfo.bytes_duplicate_removal.get().toStringUtf8();
        }
        aVar.f252255d = str2;
        if (submsgtype0xc7_todegradeinfo.bytes_wildcard_wording.has()) {
            str4 = submsgtype0xc7_todegradeinfo.bytes_wildcard_wording.get().toStringUtf8();
        }
        aVar.f252252a = str4;
        if (!TextUtils.isEmpty(str4) && !com.tencent.mobileqq.mutualmark.g.k(qQAppInterface)) {
            b(qQAppInterface, aVar, pushMsg0x210C7Info, submsgtype0xc7_todegradeinfo);
        }
        i(qQAppInterface, aVar.f252258g, str);
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        QLog.i("ReactivePushHelper", 1, "removeReactiveIconResource start:" + str);
        String replaceAll = str.replaceAll("[icon]", "");
        Iterator<g.b> it = com.tencent.mobileqq.mutualmark.g.h(replaceAll).iterator();
        while (it.hasNext()) {
            replaceAll = replaceAll.replaceAll(it.next().f252054c, "");
        }
        for (String str2 : com.tencent.mobileqq.mutualmark.g.c()) {
            if (replaceAll.contains(str2)) {
                replaceAll = replaceAll.replaceAll(str2, "");
            }
        }
        QLog.i("ReactivePushHelper", 1, "removeReactiveIconResource end:" + replaceAll);
        return replaceAll;
    }

    private static void h(AppInterface appInterface, long j3, long j16, String str) {
        if (appInterface == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReactivePushHelper", 2, "saveShowNotificationTime, time:" + j3 + " localtime:" + j16 + " frienduin:" + str);
        }
        ea.i3(BaseApplication.getContext(), appInterface.getCurrentUin(), "" + j3 + "_" + j16, str);
    }

    private static void i(AppInterface appInterface, long j3, String str) {
        if (appInterface == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReactivePushHelper", 2, "saveShowTipsTime, time:" + j3 + " frienduin:" + str);
        }
        ea.j3(BaseApplication.getContext(), appInterface.getCurrentUin(), str, j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SpannableStringBuilder j(Context context, SpannableStringBuilder spannableStringBuilder) {
        int i3;
        boolean z16;
        Integer num;
        Drawable drawable;
        if (!TextUtils.isEmpty(spannableStringBuilder) && context != null) {
            QLog.i("ReactivePushHelper", 1, "updateReactiveIconResource start:" + ((Object) spannableStringBuilder));
            String spannableStringBuilder2 = spannableStringBuilder.toString();
            float f16 = 16.0f;
            try {
                int dpToPx = ViewUtils.dpToPx(16.0f);
                List<String> c16 = com.tencent.mobileqq.mutualmark.g.c();
                ArrayList arrayList = new ArrayList();
                ArrayList<g.b> h16 = com.tencent.mobileqq.mutualmark.g.h(spannableStringBuilder2);
                if (h16 != null && !h16.isEmpty()) {
                    Iterator<g.b> it = h16.iterator();
                    int i16 = 0;
                    while (it.hasNext()) {
                        g.b next = it.next();
                        if (!TextUtils.isEmpty(next.f252055d)) {
                            Object urlBottomImageSpan = new UrlBottomImageSpan(context, 0, next.f252055d, ViewUtils.dpToPx(f16));
                            String str = "[icon]";
                            if (!TextUtils.isEmpty(next.f252056e)) {
                                str = next.f252056e;
                            }
                            int i17 = next.f252052a + i16;
                            next.f252052a = i17;
                            int i18 = next.f252053b + i16;
                            next.f252053b = i18;
                            spannableStringBuilder.replace(i17, i18, (CharSequence) str);
                            int i19 = next.f252052a;
                            spannableStringBuilder.setSpan(urlBottomImageSpan, i19, str.length() + i19, 33);
                            i16 += (next.f252052a + str.length()) - next.f252053b;
                        }
                        f16 = 16.0f;
                    }
                    spannableStringBuilder2 = spannableStringBuilder.toString();
                }
                for (String str2 : c16) {
                    int indexOf = spannableStringBuilder2.indexOf(str2);
                    if (indexOf != -1) {
                        while (indexOf >= 0) {
                            Iterator it5 = arrayList.iterator();
                            while (true) {
                                if (it5.hasNext()) {
                                    Pair pair = (Pair) it5.next();
                                    if (indexOf >= ((Integer) pair.first).intValue() && indexOf < ((Integer) pair.second).intValue()) {
                                        z16 = true;
                                        break;
                                    }
                                } else {
                                    z16 = false;
                                    break;
                                }
                            }
                            if (!z16 && com.tencent.mobileqq.mutualmark.g.f252050d.containsKey(str2) && (num = com.tencent.mobileqq.mutualmark.g.f252050d.get(str2)) != null && num.intValue() != 0 && (drawable = context.getResources().getDrawable(num.intValue())) != null) {
                                drawable.setBounds(0, 0, dpToPx, dpToPx);
                                spannableStringBuilder.setSpan(new ImageSpan(drawable, 0), indexOf, str2.length() + indexOf, 33);
                                arrayList.add(new Pair(Integer.valueOf(indexOf), Integer.valueOf(str2.length() + indexOf)));
                            }
                            indexOf = spannableStringBuilder2.indexOf(str2, indexOf + str2.length());
                        }
                    }
                }
                i3 = 1;
            } catch (Throwable th5) {
                i3 = 1;
                QLog.e("ReactivePushHelper", 1, "updateReactiveIconResource exception:" + th5);
            }
            QLog.i("ReactivePushHelper", i3, "removeReactiveIconResource end:" + spannableStringBuilder2);
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder k(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            return j(context, new SpannableStringBuilder(str));
        }
        return null;
    }
}
