package com.tencent.mobileqq.mutualmark;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.x;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Comparator<b> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) bVar2)).intValue();
            }
            int i3 = bVar.f252023c;
            int i16 = bVar2.f252023c;
            if (i3 < i16) {
                return -1;
            }
            if (i3 > i16) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f252021a;

        /* renamed from: b, reason: collision with root package name */
        public String f252022b;

        /* renamed from: c, reason: collision with root package name */
        public int f252023c;

        /* renamed from: d, reason: collision with root package name */
        public String f252024d;

        /* renamed from: e, reason: collision with root package name */
        public int f252025e;

        /* renamed from: f, reason: collision with root package name */
        public int f252026f;

        /* renamed from: g, reason: collision with root package name */
        public String f252027g;

        /* renamed from: h, reason: collision with root package name */
        public String f252028h;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f252021a = 0;
            }
        }

        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            String str = this.f252022b;
            if (str != null) {
                return str.contains("icon");
            }
            return false;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "GrayTipHighlightItemInfo{old_key:" + this.f252022b + ", old_start:" + this.f252023c + ", id:" + this.f252024d + ", start:" + this.f252025e + ", end:" + this.f252026f + ", key:" + this.f252027g + ", url:" + this.f252028h + ", }";
        }
    }

    public static int a(long j3, long j16) {
        if (j3 > 0 && j16 >= 0) {
            return g.f(j3, j16);
        }
        return 0;
    }

    public static int b(x xVar) {
        long f16 = xVar.f();
        long e16 = xVar.e();
        if (f16 == 17) {
            if (xVar.h()) {
                return 999;
            }
            return 0;
        }
        if (xVar.h()) {
            return 999;
        }
        if (xVar.i()) {
            return 998;
        }
        return a(f16, e16);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0082. Please report as an issue. */
    public static void c(QQAppInterface qQAppInterface, x xVar, PushMsg0x210C7Info pushMsg0x210C7Info) {
        String str;
        int b16;
        int i3;
        int i16;
        x.b d16 = xVar.d();
        if (QLog.isColorLevel()) {
            QLog.i("MutualMarkGrayTipsHelper", 2, "checkAndInsertGrayTips grayInfo:" + d16 + " onlinePush:" + pushMsg0x210C7Info.onlinePush);
        }
        if (d16 != null && d16.a()) {
            if (!TextUtils.isEmpty(d16.f180258c)) {
                str = d16.f180258c;
            } else {
                str = xVar.f180248b + "_" + xVar.f180249c + "_" + pushMsg0x210C7Info.msgSeq + "_" + d16.f180257b;
            }
            String str2 = str;
            int i17 = xVar.f180249c;
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 != 11000) {
                            if (i17 != 11001) {
                                switch (i17) {
                                    case 10003:
                                        break;
                                    case 10004:
                                    case 10005:
                                        break;
                                    default:
                                        i16 = 1002;
                                        break;
                                }
                                h(qQAppInterface, xVar, d16.f180256a, e(d16.f180259d), i16, i3, str2);
                            }
                        }
                    } else {
                        x.c cVar = xVar.f180251e;
                        if (cVar != null && xVar.f180252f != null) {
                            if (cVar.a() <= xVar.f180252f.a()) {
                                if (xVar.f180251e.a() < xVar.f180252f.a()) {
                                    b16 = b(xVar);
                                    i3 = b16;
                                    i16 = 1018;
                                    h(qQAppInterface, xVar, d16.f180256a, e(d16.f180259d), i16, i3, str2);
                                }
                            }
                        }
                        i16 = 1002;
                    }
                    i3 = 0;
                    h(qQAppInterface, xVar, d16.f180256a, e(d16.f180259d), i16, i3, str2);
                }
                i16 = 1019;
                i3 = 0;
                h(qQAppInterface, xVar, d16.f180256a, e(d16.f180259d), i16, i3, str2);
            }
            b16 = b(xVar);
            i3 = b16;
            i16 = 1018;
            h(qQAppInterface, xVar, d16.f180256a, e(d16.f180259d), i16, i3, str2);
        }
    }

    public static ArrayList<b> d(AppInterface appInterface, String str, StringBuilder sb5) {
        Matcher matcher = Pattern.compile("#(name|icon)_(\\d+)").matcher(sb5);
        ArrayList<b> arrayList = new ArrayList<>();
        while (true) {
            int i3 = 2;
            if (!matcher.find()) {
                break;
            }
            b bVar = new b();
            bVar.f252022b = matcher.group();
            bVar.f252023c = matcher.start();
            bVar.f252024d = matcher.group(2);
            if (!bVar.a()) {
                i3 = 1;
            }
            bVar.f252021a = i3;
            arrayList.add(bVar);
        }
        Matcher matcher2 = Pattern.compile("#nick").matcher(sb5);
        while (matcher2.find()) {
            b bVar2 = new b();
            bVar2.f252022b = matcher2.group();
            bVar2.f252023c = matcher2.start();
            bVar2.f252021a = 7;
            bVar2.f252028h = "mqqapi://card/show_pslcard?src_type=internal&source=MutualMarkGrayTips&version=1&uin=" + str;
            arrayList.add(bVar2);
        }
        Matcher matcher3 = Pattern.compile("\\(([^\\(]+?)\\)\\[\\]").matcher(sb5);
        while (matcher3.find()) {
            b bVar3 = new b();
            bVar3.f252021a = 5;
            bVar3.f252022b = matcher3.group();
            bVar3.f252023c = matcher3.start();
            bVar3.f252027g = matcher3.group(1);
            arrayList.add(bVar3);
        }
        Matcher matcher4 = Pattern.compile("\\(([^\\(]+?)\\)\\[([^\\)]+?)\\]").matcher(sb5);
        while (matcher4.find()) {
            b bVar4 = new b();
            bVar4.f252021a = 3;
            bVar4.f252022b = matcher4.group();
            bVar4.f252023c = matcher4.start();
            bVar4.f252027g = matcher4.group(1);
            bVar4.f252028h = g.b(matcher4.group(2));
            arrayList.add(bVar4);
        }
        Matcher matcher5 = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(sb5);
        while (matcher5.find()) {
            b bVar5 = new b();
            bVar5.f252021a = 4;
            bVar5.f252022b = matcher5.group();
            bVar5.f252023c = matcher5.start();
            String b16 = g.b(matcher5.group(1));
            bVar5.f252028h = b16;
            bVar5.f252028h = com.tencent.mobileqq.mutualmark.alienation.a.b(appInterface, str, b16);
            bVar5.f252027g = bVar5.f252022b.replace(matcher5.group(1), bVar5.f252028h);
            arrayList.add(bVar5);
        }
        Matcher matcher6 = Pattern.compile("\\(([^\\(]+?)\\)#special_care\\{([^\\)]+?)\\}").matcher(sb5);
        while (matcher6.find()) {
            b bVar6 = new b();
            bVar6.f252021a = 6;
            bVar6.f252022b = matcher6.group();
            bVar6.f252023c = matcher6.start();
            bVar6.f252027g = matcher6.group(1);
            bVar6.f252024d = matcher6.group(2);
            arrayList.add(bVar6);
        }
        Collections.sort(arrayList, new a());
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!TextUtils.isEmpty(next.f252022b)) {
                int indexOf = sb5.indexOf(next.f252022b);
                int length = next.f252022b.length() + indexOf;
                if (indexOf >= 0 && length <= sb5.length()) {
                    int i16 = next.f252021a;
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 == 7) {
                                next.f252027g = ac.H(appInterface, str);
                            }
                        } else {
                            next.f252027g = com.tencent.mobileqq.mutualmark.b.c(appInterface, str, next.f252024d);
                        }
                    } else {
                        next.f252027g = com.tencent.mobileqq.mutualmark.b.e(appInterface, next.f252024d);
                    }
                    if (next.f252027g == null) {
                        next.f252027g = next.f252022b;
                    }
                    next.f252025e = indexOf;
                    next.f252026f = next.f252027g.length() + indexOf;
                    sb5.replace(indexOf, length, next.f252027g);
                }
            }
        }
        return arrayList;
    }

    public static int e(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL;
                }
                return MessageRecord.MSG_TYPE_UNITE_TAB_DB_INVI;
            }
            return MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI;
        }
        return MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI;
    }

    public static void f(com.tencent.mobileqq.graytip.g gVar, ArrayList<b> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("MutualMarkGrayTipsHelper", 2, "handleHighlightInfo type=" + next.f252021a + ",item=" + next);
                }
                int i3 = next.f252021a;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 != 5) {
                                }
                            }
                        } else if (!TextUtils.isEmpty(next.f252027g) && !TextUtils.isEmpty(next.f252028h)) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("key_action", 1);
                            bundle.putString("key_action_DATA", next.f252028h);
                            gVar.b(next.f252025e, next.f252026f, bundle);
                        }
                    }
                    if (!TextUtils.isEmpty(next.f252027g)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("image_resource", next.f252027g);
                        gVar.b(next.f252025e, next.f252026f, bundle2);
                    }
                }
                if (!TextUtils.isEmpty(next.f252027g)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("key_action", 11);
                    bundle3.putString("key_action_DATA", next.f252027g);
                    gVar.b(next.f252025e, next.f252026f, bundle3);
                }
            }
        }
    }

    private static void g(AppRuntime appRuntime, com.tencent.mobileqq.graytip.g gVar, MessageForUniteGrayTip messageForUniteGrayTip) {
        String account = appRuntime.getAccount();
        String str = gVar.f213681d;
        String str2 = gVar.f213682e;
        String str3 = gVar.f213683f;
        long j3 = gVar.f213686i;
        messageForUniteGrayTip.init(account, str, str2, str3, j3, gVar.f213687j, gVar.f213684g, j3);
        messageForUniteGrayTip.mIsParsed = true;
        messageForUniteGrayTip.isread = true;
        messageForUniteGrayTip.tipParam = gVar;
        messageForUniteGrayTip.msgData = null;
    }

    public static void h(QQAppInterface qQAppInterface, x xVar, String str, int i3, int i16, int i17, String str2) {
        String str3 = str;
        if (QLog.isColorLevel()) {
            QLog.i("MutualMarkGrayTipsHelper", 2, "insertGrayTips friendUin:" + xVar.f180248b + " grayType:" + i3 + " grayID:" + i16 + " subType:" + i17 + " grayTipKey:" + str2 + " _grayTipTemplate:" + str3);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str3.contains("#nick") && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("use_old_mutual_mark_gray_tips", false)) {
            str3 = str3.replaceAll("#nick", ac.H(qQAppInterface, xVar.f180248b));
        }
        StringBuilder sb5 = new StringBuilder(str3);
        ArrayList<b> d16 = d(qQAppInterface, xVar.f180248b, sb5);
        String sb6 = sb5.toString();
        String str4 = xVar.f180248b;
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str4, str4, sb6, 0, i3, i16, com.tencent.mobileqq.service.message.e.K0());
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.hasRead = 0;
        messageForUniteGrayTip.subType = i17;
        g(qQAppInterface, gVar, messageForUniteGrayTip);
        messageForUniteGrayTip.tipParam.f213693p = str2;
        if (i17 == 998) {
            String c16 = xVar.c();
            messageForUniteGrayTip.caidanAnimUrl = c16;
            String b16 = g.b(c16);
            messageForUniteGrayTip.caidanAnimUrl = b16;
            messageForUniteGrayTip.caidanAnimUrl = com.tencent.mobileqq.mutualmark.alienation.a.b(qQAppInterface, xVar.f180248b, b16);
        } else if (i17 == 999) {
            String b17 = xVar.b();
            messageForUniteGrayTip.caidanAnimUrl = b17;
            messageForUniteGrayTip.caidanAnimUrl = g.b(b17);
            messageForUniteGrayTip.caidanAnimUrlMd5 = xVar.a();
        }
        f(gVar, d16);
        messageForUniteGrayTip.saveExtInfoToExtStr("mutualmark_id", g.d(xVar.f(), xVar.e()));
        int g16 = xVar.g();
        if (g16 > 0) {
            messageForUniteGrayTip.saveExtInfoToExtStr("sub_level", String.valueOf(g16));
        }
        com.tencent.mobileqq.mutualmark.nt.g.INSTANCE.a().e(MutualMarkConfProcessor.a().b(xVar.f180248b) + "&mutualmark_id=" + xVar.f()).f(d16).c(qQAppInterface, xVar.f180248b, i16, gVar.f213683f);
        com.tencent.mobileqq.mutualmark.a.a(qQAppInterface, messageForUniteGrayTip, messageForUniteGrayTip.tipParam.f213685h);
        com.tencent.mobileqq.mutualmark.a.b(qQAppInterface, messageForUniteGrayTip, messageForUniteGrayTip.tipParam.f213685h);
    }
}
