package com.tencent.mobileqq.activity.troop.config;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.utils.aw;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e extends com.tencent.mobileqq.troop.api.config.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f186609a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69433);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f186609a = "TroopAnnouncementProcessor";
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static TroopNotificationCache c(ITroopAnnouncementHelperApi.a aVar, String str, int i3, int i16, long j3) {
        if (aVar != null) {
            int i17 = aVar.f293916a;
            if (i17 == 1) {
                String d16 = d(aVar.f293919d);
                int lastIndexOf = d16.lastIndexOf(38);
                if (lastIndexOf != -1 && d16.indexOf(";", lastIndexOf) == -1) {
                    d16 = d16.substring(0, lastIndexOf - 1);
                }
                String d17 = d(aVar.f293917b);
                if (TextUtils.isEmpty(aVar.f293917b)) {
                    d17 = new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5").format((Date) new java.sql.Date(aVar.f293923h * 1000)) + " \u7fa4\u516c\u544a";
                }
                String format = String.format("https://web.qun.qq.com/mannounce/index.html?_wv=1031&amp;_bid=148#gc=%d&amp;feedType=%d&amp;gotoFid=%s", Long.valueOf(j3), Integer.valueOf(i3), str);
                TroopNotificationCache troopNotificationCache = new TroopNotificationCache();
                troopNotificationCache.title = aVar.f293917b;
                troopNotificationCache.feedType = i3;
                troopNotificationCache.appId = i16;
                troopNotificationCache.userUin = aVar.f293922g;
                troopNotificationCache.troopUin = j3;
                troopNotificationCache.time = aVar.f293923h;
                troopNotificationCache.feedsId = aVar.f293918c;
                troopNotificationCache.serviceID = 27;
                troopNotificationCache.needConfirm = aVar.f293929n;
                String format2 = new SimpleDateFormat("M-d HH:mm").format((Date) new java.sql.Date(troopNotificationCache.time * 1000));
                if (TextUtils.isEmpty(aVar.f293920e)) {
                    troopNotificationCache.xmlBytes = String.format("<?xml version=\"1.0\" encoding=\"utf-8\" ?><msg action=\"web\" serviceID=\"27\" templateID=\"\" actionData=\"\" url=\"%s\" flag=\"5\" brief=\"%s\"><item layout=\"1\"><title size=\"30\" color=\"#000000\">[\u516c\u544a] %s</title><hr /><title size=\"22\" color=\"#000000\">%s</title><summary size=\"28\" color=\"#808080\">%s</summary></item></msg>", format, "", d17, format2, d16).getBytes();
                } else {
                    troopNotificationCache.xmlBytes = String.format("<?xml version=\"1.0\" encoding=\"utf-8\" ?><msg action=\"web\" serviceID=\"27\" templateID=\"\" actionData=\"\" url=\"%s\" flag=\"5\" brief=\"%s\"><item layout=\"6\"><title size=\"30\" color=\"#000000\">[\u516c\u544a] %s</title><hr /></item><item layout=\"2\"><picture cover=\"%s\"/><title size=\"22\" color=\"#000000\">%s</title><summary size=\"28\" color=\"#808080\">%s</summary></item></msg>", format, "", d17, aVar.f293920e, format2, d16).getBytes();
                }
                return troopNotificationCache;
            }
            if (i17 == 2) {
                TroopNotificationCache troopNotificationCache2 = new TroopNotificationCache();
                troopNotificationCache2.feedType = i3;
                troopNotificationCache2.appId = i16;
                troopNotificationCache2.userUin = aVar.f293922g;
                troopNotificationCache2.troopUin = j3;
                troopNotificationCache2.time = aVar.f293923h;
                troopNotificationCache2.feedsId = aVar.f293918c;
                troopNotificationCache2.ctrlStr = aVar.f293925j;
                troopNotificationCache2.xmlBytes = aVar.f293924i;
                troopNotificationCache2.src = aVar.f293926k;
                troopNotificationCache2.filterID = aVar.f293927l;
                troopNotificationCache2.serviceID = 20;
                return troopNotificationCache2;
            }
            return null;
        }
        return null;
    }

    private static String d(String str) {
        if (str == null) {
            return "";
        }
        return f(f(f(f(f(str, ContainerUtils.FIELD_DELIMITER, "&amp;"), "<", "&lt;"), ">", "&gt;"), "'", "&apos;"), "\"", "&quot;");
    }

    private TroopNotificationCache e(QQAppInterface qQAppInterface, long j3, int i3, int i16, boolean z16, DataInputStream dataInputStream) {
        boolean z17;
        try {
            dataInputStream.readInt();
            dataInputStream.readInt();
            short readShort = dataInputStream.readShort();
            dataInputStream.readShort();
            if (i3 == 23) {
                z17 = true;
            } else {
                z17 = false;
            }
            ITroopAnnouncementHelperApi.a V = ((com.tencent.mobileqq.troop.announcement.api.a) qQAppInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName())).V(dataInputStream, z17);
            if (V != null) {
                if (i3 == 23) {
                    TroopNotificationCache c16 = c(V, V.f293918c, readShort, i16, j3);
                    if (c16 != null && TextUtils.isEmpty(c16.title)) {
                        c16.title = V.f293919d;
                    }
                    return c16;
                }
                if (!aw.i(qQAppInterface, Long.toString(j3), V.f293918c) && z16) {
                    aw.r(qQAppInterface, V.f293918c, Long.toString(j3), 2);
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f186609a, 2, e16.getMessage());
                return null;
            }
            return null;
        }
    }

    public static String f(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf >= 0) {
            String str4 = "";
            while (indexOf >= 0) {
                str4 = str4 + str.substring(0, indexOf) + str3;
                str = str.substring(indexOf + str2.length());
                indexOf = str.indexOf(str2);
            }
            return str4 + str;
        }
        return str;
    }

    @Override // com.tencent.mobileqq.troop.api.config.c
    public void a(AppInterface appInterface, long j3, long j16, int i3, ITroopAnnouncementHelperApi.a aVar, String str, boolean z16) {
        TroopNotificationCache c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), aVar, str, Boolean.valueOf(z16));
            return;
        }
        if (aVar != null) {
            int i16 = aVar.f293916a;
            if (i16 != 1 && i16 != 2) {
                c16 = null;
            } else {
                c16 = c(aVar, str, 23, i3, j16);
            }
            if (appInterface instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
                QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                ArrayList<TroopNotificationCache> arrayList = new ArrayList<>();
                arrayList.add(c16);
                messageFacade.G1().h1(qQAppInterface, String.valueOf(j3), String.valueOf(j16), arrayList, 23, (int) com.tencent.mobileqq.service.message.e.K0(), aVar.f293928m, aVar.f293918c, z16);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.c
    public void b(AppInterface appInterface, long j3, long j16, int i3, String str, int i16, boolean z16, DataInputStream dataInputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), str, Integer.valueOf(i16), Boolean.valueOf(z16), dataInputStream);
            return;
        }
        if (appInterface instanceof QQAppInterface) {
            QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
            TroopNotificationCache e16 = e(qQAppInterface, j16, i16, i3, z16, dataInputStream);
            if (i16 == 23 && e16 != null) {
                ((com.tencent.mobileqq.troop.announcement.api.a) qQAppInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName())).a(com.tencent.mobileqq.troop.announcement.api.b.f293932f, true, e16);
                return;
            }
            if (i16 == 34 && e16 != null) {
                QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
                ArrayList<TroopNotificationCache> arrayList = new ArrayList<>();
                arrayList.add(e16);
                messageFacade.G1().h1(qQAppInterface, String.valueOf(j3), String.valueOf(j16), arrayList, 34, (int) com.tencent.mobileqq.service.message.e.K0(), 0, str, false);
                MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
                if (handler != null) {
                    handler.sendEmptyMessage(1009);
                }
            }
        }
    }
}
