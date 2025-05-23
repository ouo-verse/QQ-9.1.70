package com.tencent.mobileqq.pic;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.HttpDownloaderParams;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class aa {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f258590a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f258591b;

    /* renamed from: c, reason: collision with root package name */
    public static String f258592c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73559);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f258590a = 0;
        f258591b = false;
        f258592c = "struct_msg_pic_pre";
    }

    public static void a(MessageForStructing messageForStructing, QQAppInterface qQAppInterface) {
        List<AbsStructMsgElement> structMsgItemLists;
        int a16 = a.a();
        if (!f258591b) {
            f258590a = c();
            f258591b = true;
        }
        if (a16 != 0 && f258590a == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("StructMsgPicPreDelegate", 2, "not wifi not pre download");
                return;
            }
            return;
        }
        if (messageForStructing != null) {
            AbsStructMsg absStructMsg = messageForStructing.structingMsg;
            ArrayList arrayList = new ArrayList();
            if (absStructMsg != null && (absStructMsg instanceof AbsShareMsg) && (structMsgItemLists = ((AbsShareMsg) absStructMsg).getStructMsgItemLists()) != null && structMsgItemLists.size() > 0) {
                Iterator<AbsStructMsgElement> it = structMsgItemLists.iterator();
                while (it.hasNext()) {
                    b(it.next(), arrayList);
                }
            }
            if (arrayList.size() > 0) {
                HttpDownloaderParams httpDownloaderParams = new HttpDownloaderParams();
                if (absStructMsg != null) {
                    httpDownloaderParams.param1 = absStructMsg.mMsgServiceID;
                    httpDownloaderParams.param2 = absStructMsg.mMsgTemplateID;
                }
                httpDownloaderParams.param3 = String.valueOf(messageForStructing.istroop);
                httpDownloaderParams.isPreDownload = true;
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    e((String) it5.next(), httpDownloaderParams);
                }
            }
        }
    }

    public static void b(AbsStructMsgElement absStructMsgElement, List<String> list) {
        if (absStructMsgElement != null && (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a)) {
            ArrayList<AbsStructMsgElement> arrayList = ((com.tencent.mobileqq.structmsg.a) absStructMsgElement).U0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<AbsStructMsgElement> it = arrayList.iterator();
                while (it.hasNext()) {
                    b(it.next(), list);
                }
                return;
            }
            return;
        }
        if (absStructMsgElement != null && (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.view.c)) {
            String str = ((com.tencent.mobileqq.structmsg.view.c) absStructMsgElement).S0;
            if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
                try {
                    if (d(new URL(str).getHost())) {
                        list.add(str);
                    }
                } catch (MalformedURLException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public static int c() {
        if (MobileQQ.sProcessId != 1) {
            return 0;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        return BaseApplicationImpl.getApplication().getSharedPreferences(qQAppInterface.getCurrentAccountUin() + "_" + f258592c, 0).getInt("mStructMsgPicSwitch", 0);
    }

    public static boolean d(String str) {
        boolean find = Pattern.compile("((\\.|^)(qq\\.com|soso\\.com|gtimg\\.cn|url\\.cn|qpic\\.cn|qlogo\\.cn|idqqimg\\.com)$)").matcher(str).find();
        if (QLog.isDevelopLevel()) {
            QLog.d("StructMsgPicPreDelegate", 4, " host = " + str + " ,isTencentDomain = " + find);
        }
        return find;
    }

    public static void e(String str, HttpDownloaderParams httpDownloaderParams) {
        if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
            HttpDownloader.downloadImageByHttpEngine(str, httpDownloaderParams, null, 1);
        }
    }

    public static void f(int i3) {
        if (MobileQQ.sProcessId == 1) {
            f258590a = i3;
            f258591b = true;
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(qQAppInterface.getCurrentAccountUin() + "_" + f258592c, 0).edit();
            edit.putInt("mStructMsgPicSwitch", i3);
            edit.commit();
        }
    }
}
