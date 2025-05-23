package com.tencent.mobileqq.activity.contact.newfriend;

import android.annotation.TargetApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.action.p;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87$CloneInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87$MsgNotify;

/* compiled from: P */
@TargetApi(11)
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f181275a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f181276b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap<String, Long> f181277c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67913);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f181275a = false;
        f181276b = new HashSet<>();
        f181277c = new HashMap<>();
    }

    private static void a(QQAppInterface qQAppInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("CloneFriendPushHelper", 2, "addUin, uin=" + str);
        }
        HashSet<String> hashSet = f181276b;
        synchronized (hashSet) {
            if (!f181275a) {
                b(qQAppInterface);
            }
            if (!hashSet.contains(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("CloneFriendPushHelper", 2, "addUin, not contains, need add");
                }
                hashSet.add(str);
                qQAppInterface.getPreferences().edit().putStringSet("cloneFriendPush_" + qQAppInterface.getCurrentUin(), hashSet).commit();
            }
        }
    }

    private static boolean b(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("CloneFriendPushHelper", 2, "initSet, uin=" + qQAppInterface.getCurrentUin() + ", hasInit=" + f181275a);
        }
        HashSet<String> hashSet = f181276b;
        synchronized (hashSet) {
            if (f181275a) {
                return false;
            }
            hashSet.clear();
            Set<String> stringSet = qQAppInterface.getPreferences().getStringSet("cloneFriendPush_" + qQAppInterface.getCurrentUin(), null);
            if (stringSet != null) {
                hashSet.addAll(stringSet);
            }
            f181275a = true;
            return true;
        }
    }

    private static void c(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, int i3) {
        int i16;
        String qqStr = HardCodeUtil.qqStr(R.string.f171750kn2);
        String format = String.format("%s(%s)", str2, str);
        String qqStr2 = HardCodeUtil.qqStr(R.string.f171748kn0);
        Object[] objArr = new Object[1];
        if (i3 == 1) {
            i16 = R.string.kmu;
        } else {
            i16 = R.string.kmx;
        }
        objArr[0] = HardCodeUtil.qqStr(i16);
        String format2 = String.format(qqStr2, objArr);
        String format3 = String.format("%s(%s)", str4, str3);
        String qqStr3 = HardCodeUtil.qqStr(R.string.kmy);
        String qqStr4 = HardCodeUtil.qqStr(R.string.kmv);
        String format4 = String.format("mqqapi://relation/deleteFriends?src_type=app&version=1&uins=%s,%s&title=\u786e\u5b9a\u5220\u9664\u4ed6\u4eec", str3, str);
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str3), 1, 1006L, 1, true, true, null);
        localGrayTipBuilder.g(qqStr, 1).h(format, new p("", str2, str), 3).g(format2, 1).h(format3, new p("", str4, str3), 3).g("\u7684\u597d\u53cb\u5217\u8868\u4e2d\u3002\n\u4e0d\u60f3\u548c\u4ed6\u4eec\u662f\u597d\u53cb\u5173\u7cfb\uff0c\u53ef\u9009\u62e9", 1).e(qqStr3, format4, 3).g("\u3002\n\u4e0d\u60f3\u518d\u88ab\u5176\u4ed6\u597d\u53cb\u514b\u9686\uff0c\u53ef\u9009\u62e9", 1).a(qqStr4, "https://ti.qq.com/friendship_auth/index.html?_wv=3#clone_setting", 3).g("\u3002", 1);
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(qQAppInterface, localGrayTipBuilder.m(), null);
    }

    private static void d(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, int i3) {
        c(qQAppInterface, str, str2, str3, str4, i3);
        e(qQAppInterface, str2, str3, str4);
        f(qQAppInterface, str3);
    }

    private static void e(QQAppInterface qQAppInterface, String str, String str2, String str3) {
        String format = String.format(HardCodeUtil.qqStr(R.string.kmz), str, str3, str2);
        f fVar = f.f211079a;
        fVar.i(fVar.c(0, str2, ""), format);
    }

    private static void f(QQAppInterface qQAppInterface, String str) {
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(qQAppInterface, new LocalGrayTip.LocalGrayTipBuilder(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), 1, 1006L, 1, true, true, null).g(HardCodeUtil.qqStr(R.string.kmw), 1).m(), null);
    }

    public static void g(QQAppInterface qQAppInterface, SubMsgType0x87$MsgBody subMsgType0x87$MsgBody) {
        int i3;
        SubMsgType0x87$CloneInfo subMsgType0x87$CloneInfo;
        boolean z16;
        long longValue;
        int i16 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("CloneFriendPushHelper", 2, "onLinePush onReceivePush, app=" + qQAppInterface + ", msgBody=" + subMsgType0x87$MsgBody);
        }
        List<SubMsgType0x87$MsgNotify> list = subMsgType0x87$MsgBody.rpt_msg_msg_notify.get();
        if (list != null && list.size() > 0) {
            int i17 = 0;
            while (i17 < list.size()) {
                SubMsgType0x87$MsgNotify subMsgType0x87$MsgNotify = list.get(i17);
                if (subMsgType0x87$MsgNotify != null && subMsgType0x87$MsgNotify.uint32_reqsubtype.get() == i16 && subMsgType0x87$MsgNotify.msg_clone_info.has() && (subMsgType0x87$CloneInfo = subMsgType0x87$MsgNotify.msg_clone_info.get()) != null) {
                    String valueOf = String.valueOf(subMsgType0x87$CloneInfo.uint64_uin.get());
                    String stringUtf8 = subMsgType0x87$CloneInfo.bytes_remark.get().toStringUtf8();
                    if (subMsgType0x87$CloneInfo.uint32_show_in_aio.get() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    String valueOf2 = String.valueOf(subMsgType0x87$CloneInfo.uint64_to_uin.get());
                    String stringUtf82 = subMsgType0x87$CloneInfo.bytes_to_nick.get().toStringUtf8();
                    int i18 = subMsgType0x87$CloneInfo.uint32_src_gender.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("CloneFriendPushHelper", i16, "cloneInfo, uinC=" + valueOf + ", nickC=" + stringUtf8 + ", showInAio=" + z16 + ", uinB=" + valueOf2 + ", nickB=" + stringUtf82 + ", gender=" + i18);
                    }
                    if (z16) {
                        String str = valueOf2 + valueOf + qQAppInterface.getCurrentUin();
                        HashMap<String, Long> hashMap = f181277c;
                        if (hashMap.get(str) == null) {
                            longValue = 0;
                        } else {
                            longValue = hashMap.get(str).longValue();
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        hashMap.put(str, Long.valueOf(currentTimeMillis));
                        if (Math.abs(currentTimeMillis - longValue) < 60000) {
                            QLog.d("CloneFriendPushHelper", 1, "onReceivePush, gap < 60s");
                            return;
                        }
                        d(qQAppInterface, valueOf, stringUtf8, valueOf2, stringUtf82, i18);
                        i3 = i17;
                        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8008071", "0X8008071", 0, 0, "", "", "", "");
                        a(qQAppInterface, valueOf2);
                        i17 = i3 + 1;
                        i16 = 2;
                    }
                }
                i3 = i17;
                i17 = i3 + 1;
                i16 = 2;
            }
        }
    }

    public static void h() {
        HashSet<String> hashSet = f181276b;
        synchronized (hashSet) {
            f181275a = false;
            hashSet.clear();
        }
    }
}
