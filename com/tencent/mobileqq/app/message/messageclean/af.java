package com.tencent.mobileqq.app.message.messageclean;

import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class af {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f196118a;

    /* renamed from: b, reason: collision with root package name */
    private int f196119b;

    public af() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f196119b = 1000;
        }
    }

    private String a(String str, boolean z16) {
        if (!z16) {
            return str;
        }
        return SecurityUtile.decode(new String(str.getBytes(), StandardCharsets.UTF_8));
    }

    private com.tencent.mobileqq.persistence.g i() {
        AppInterface appInterface = this.f196118a;
        if (appInterface instanceof PeakAppInterface) {
            return ((PeakAppInterface) appInterface).g();
        }
        QQEntityManagerFactory qQEntityManagerFactory = (QQEntityManagerFactory) appInterface.getEntityManagerFactory();
        String currentAccountUin = this.f196118a.getCurrentAccountUin();
        return new com.tencent.mobileqq.persistence.g(qQEntityManagerFactory.build(currentAccountUin), currentAccountUin);
    }

    public AppInterface b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AppInterface) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        AppInterface a16 = QQStoryContext.a();
        this.f196118a = a16;
        return a16;
    }

    public String c(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) str2);
        }
        return d(str, str2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00de, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00db, code lost:
    
        if (0 == 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d(String str, String str2, boolean z16) {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, this, str, str2, Boolean.valueOf(z16));
        }
        String str3 = "";
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), Uri.parse("content://qq.friendlist/discussmenberinfo/" + Long.parseLong(this.f196118a.getCurrentAccountUin()) + "/" + str + "/" + str2), new String[]{"memberName", "inteRemark"}, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                String string = cursor.getString(cursor.getColumnIndexOrThrow("inteRemark"));
                if (!TextUtils.isEmpty(string)) {
                    a16 = a(string, z16);
                } else {
                    String string2 = cursor.getString(cursor.getColumnIndexOrThrow("memberName"));
                    if (!TextUtils.isEmpty(string2)) {
                        a16 = a(string2, z16);
                    }
                }
                str3 = a16;
            }
        } catch (Throwable th5) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.e("MessageDataManager", 2, "getDiscussMemberName exception = " + th5.getMessage());
                }
                th5.printStackTrace();
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }

    public String e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        return f(str, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b7, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b4, code lost:
    
        if (r9 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String f(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, this, str, Boolean.valueOf(z16));
        }
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), Uri.parse("content://qq.friendlist/discussinfo/" + Long.parseLong(this.f196118a.getCurrentAccountUin()) + "/" + str), new String[]{"discussionName"}, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                String string = cursor.getString(cursor.getColumnIndexOrThrow("discussionName"));
                if (!TextUtils.isEmpty(string)) {
                    str2 = a(string, z16);
                }
            }
        } catch (Throwable th5) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.e("MessageDataManager", 2, "getDiscussionListFromQQ exception = " + th5.getMessage());
                }
                th5.printStackTrace();
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public void g(int i3, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) hashMap);
        } else {
            h(i3, hashMap, true);
        }
    }

    public void h(int i3, HashMap<String, String> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), hashMap, Boolean.valueOf(z16));
            return;
        }
        if (hashMap == null) {
            return;
        }
        String[] strArr = {"uin", "remark", "name"};
        Cursor cursor = null;
        try {
            Cursor query = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), Uri.parse("content://qq.friendlist/friendlist/" + Long.parseLong(this.f196118a.getCurrentAccountUin())), strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("uin");
                        int columnIndexOrThrow2 = query.getColumnIndexOrThrow("remark");
                        int columnIndexOrThrow3 = query.getColumnIndexOrThrow("name");
                        do {
                            String string = query.getString(columnIndexOrThrow);
                            if (!TextUtils.isEmpty(string)) {
                                String a16 = a(string, z16);
                                String string2 = query.getString(columnIndexOrThrow2);
                                if (!TextUtils.isEmpty(string2)) {
                                    hashMap.put(a16 + i3, a(string2, z16));
                                } else {
                                    String string3 = query.getString(columnIndexOrThrow3);
                                    if (!TextUtils.isEmpty(string3)) {
                                        String a17 = a(string3, z16);
                                        if (a17.length() > 1 && a17.charAt(a17.length() - 1) == '\n') {
                                            a17 = a17.substring(0, a17.length() - 1);
                                        }
                                        hashMap.put(a16 + i3, a17);
                                    }
                                }
                            }
                        } while (query.moveToNext());
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.e("MessageDataManager", 2, "getFriendListFromQQ exception = " + th.getMessage());
                        }
                        th.printStackTrace();
                        if (cursor != null) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public List<RecentUser> j(Class<? extends Entity> cls, String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, this, cls, str, strArr);
        }
        if (this.f196118a != null) {
            List rawQuery = i().rawQuery(cls, str, strArr);
            if (rawQuery != null && !rawQuery.isEmpty()) {
                return rawQuery;
            }
            if (QLog.isColorLevel()) {
                QLog.e("MessageDataManager", 2, "getRecentUserList list is empty");
            }
        }
        return null;
    }

    public void k(int i3, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) hashMap);
        } else {
            l(i3, hashMap, true);
        }
    }

    public void l(int i3, HashMap<String, String> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), hashMap, Boolean.valueOf(z16));
            return;
        }
        if (hashMap == null) {
            return;
        }
        for (TroopInfo troopInfo : ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache()) {
            if (!TextUtils.isEmpty(troopInfo.troopname)) {
                hashMap.put(troopInfo.troopuin + i3, troopInfo.troopname);
            }
        }
    }
}
