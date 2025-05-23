package com.tencent.mobileqq.managers;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes15.dex */
public class DraftTextManager {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static LruCache<String, DraftTextInfo> f243626b;

    /* renamed from: c, reason: collision with root package name */
    private static LruCache<String, DraftSummaryInfo> f243627c;

    /* renamed from: d, reason: collision with root package name */
    private static HashSet<String> f243628d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile DraftTextManager f243629e;

    /* renamed from: a, reason: collision with root package name */
    private Object f243630a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f243626b = new LruCache<>(10);
        f243627c = new LruCache<>(99);
        f243628d = new HashSet<>();
    }

    public DraftTextManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f243630a = new Object();
        }
    }

    private static DraftSummaryInfo c(QQAppInterface qQAppInterface, DraftTextInfo draftTextInfo) {
        if (draftTextInfo == null) {
            return null;
        }
        DraftSummaryInfo draftSummaryInfo = new DraftSummaryInfo();
        draftSummaryInfo.setUin(draftTextInfo.uin);
        draftSummaryInfo.setType(draftTextInfo.type);
        draftSummaryInfo.setTime(draftTextInfo.time);
        draftSummaryInfo.setAtInfoStr(draftTextInfo.mAtInfoStr);
        if (draftTextInfo.sourceMsgSeq != 0 && TextUtils.isEmpty(draftTextInfo.text)) {
            draftSummaryInfo.setSummary(" ");
        } else {
            String str = draftTextInfo.text;
            String str2 = draftTextInfo.guildArticleMsgMediaPreview;
            if (str2 != null && !str2.isEmpty()) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    int length = jSONArray.length();
                    LocalMediaInfo formObjectByJsonString = LocalMediaInfo.formObjectByJsonString(jSONArray.getString(0));
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    int i3 = formObjectByJsonString.mMediaType;
                    if (i3 == 0) {
                        for (int i16 = 0; i16 < length; i16++) {
                            sb5.append(qQAppInterface.getApplicationContext().getString(R.string.image));
                        }
                    } else if (i3 == 1 || i3 == 2) {
                        sb5.append(qQAppInterface.getApplicationContext().getString(R.string.ic7));
                    }
                    str = sb5.toString();
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.e("DraftTextManger", 2, QLog.getStackTraceString(new Throwable()));
                    }
                }
            }
            draftSummaryInfo.setSummary(l(str));
        }
        return draftSummaryInfo;
    }

    private static List<DraftTextInfo> d(QQAppInterface qQAppInterface) {
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        try {
            try {
                List query = createEntityManager.query(DraftTextInfo.class, new DraftTextInfo().getTableName(), false, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null);
                if (query != null) {
                    if (query.size() > 0) {
                        return query;
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            createEntityManager.close();
            return new ArrayList();
        } finally {
            createEntityManager.close();
        }
    }

    public static DraftTextManager h(QQAppInterface qQAppInterface) {
        if (qQAppInterface != null) {
            if (f243629e == null) {
                synchronized (DraftTextManager.class) {
                    if (f243629e == null) {
                        f243629e = new DraftTextManager();
                        j(qQAppInterface);
                    }
                }
            }
            return f243629e;
        }
        throw new IllegalArgumentException("DraftTextManager this.app == null");
    }

    private static String i(String str, int i3) {
        return ao.f(str, i3);
    }

    private static void j(QQAppInterface qQAppInterface) {
        for (DraftTextInfo draftTextInfo : d(qQAppInterface)) {
            if (!TextUtils.isEmpty(draftTextInfo.text) || draftTextInfo.sourceMsgSeq != 0 || !TextUtils.isEmpty(draftTextInfo.guildArticleMsgMediaPreview)) {
                String i3 = i(draftTextInfo.uin, draftTextInfo.type);
                f243628d.add(i3);
                f243626b.put(i3, draftTextInfo);
                f243627c.put(i3, c(qQAppInterface, draftTextInfo));
            }
        }
    }

    private static String l(String str) {
        return Utils.m(str, 50);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        f243629e = null;
        f243628d.clear();
        f243626b = new LruCache<>(10);
        f243627c = new LruCache<>(99);
    }

    public boolean b(QQAppInterface qQAppInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, qQAppInterface, str, Integer.valueOf(i3))).booleanValue();
        }
        synchronized (this.f243630a) {
            String i16 = i(str, i3);
            if (!f243628d.contains(i16)) {
                return false;
            }
            DraftTextInfo draftTextInfo = f243626b.get(i16);
            f243628d.remove(i16);
            f243626b.remove(i16);
            f243627c.remove(i16);
            ThreadManagerV2.post(new Runnable(draftTextInfo, qQAppInterface, str, i3) { // from class: com.tencent.mobileqq.managers.DraftTextManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ DraftTextInfo f243633d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f243634e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f243635f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f243636h;

                {
                    this.f243633d = draftTextInfo;
                    this.f243634e = qQAppInterface;
                    this.f243635f = str;
                    this.f243636h = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DraftTextManager.this, draftTextInfo, qQAppInterface, str, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    DraftTextInfo draftTextInfo2 = this.f243633d;
                    if (draftTextInfo2 == null) {
                        draftTextInfo2 = DraftTextManager.this.g(this.f243634e, this.f243635f, this.f243636h);
                    }
                    EntityManager createEntityManager = this.f243634e.getEntityManagerFactory().createEntityManager();
                    try {
                        try {
                            createEntityManager.remove(draftTextInfo2);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    } finally {
                        createEntityManager.close();
                    }
                }
            }, 8, null, false);
            return false;
        }
    }

    public DraftSummaryInfo e(QQAppInterface qQAppInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (DraftSummaryInfo) iPatchRedirector.redirect((short) 5, this, qQAppInterface, str, Integer.valueOf(i3));
        }
        String i16 = i(str, i3);
        if (!f243628d.contains(i16)) {
            return null;
        }
        DraftSummaryInfo draftSummaryInfo = f243627c.get(i16);
        if (draftSummaryInfo != null) {
            return draftSummaryInfo;
        }
        DraftTextInfo draftTextInfo = f243626b.get(i16);
        if (draftTextInfo == null) {
            draftTextInfo = g(qQAppInterface, str, i3);
        }
        DraftSummaryInfo c16 = c(qQAppInterface, draftTextInfo);
        if (c16 != null && !TextUtils.isEmpty(c16.getSummary())) {
            f243627c.put(i16, c16);
        }
        return c16;
    }

    public String f(QQAppInterface qQAppInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, qQAppInterface, str, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("DraftTextManger", 4, "Get draft text| uin=" + str + " draftList=" + f243628d + " cache=" + f243626b);
        }
        String i16 = i(str, i3);
        if (!f243628d.contains(i16)) {
            return null;
        }
        DraftTextInfo draftTextInfo = f243626b.get(i16);
        if (draftTextInfo != null) {
            return draftTextInfo.text;
        }
        DraftTextInfo g16 = g(qQAppInterface, str, i3);
        if (g16 != null && !StringUtil.isEmpty(g16.text)) {
            f243626b.put(i16, g16);
        }
        if (g16 != null) {
            return g16.text;
        }
        return "";
    }

    public DraftTextInfo g(QQAppInterface qQAppInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DraftTextInfo) iPatchRedirector.redirect((short) 8, this, qQAppInterface, str, Integer.valueOf(i3));
        }
        synchronized (this.f243630a) {
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            try {
                try {
                    List<? extends Entity> query = createEntityManager.query(DraftTextInfo.class, new DraftTextInfo().getTableName(), false, "uin=? AND type=?", new String[]{str, String.valueOf(i3)}, (String) null, (String) null, (String) null, (String) null);
                    if (query != null && query.size() > 0) {
                        return (DraftTextInfo) query.get(0);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                return new DraftTextInfo();
            } finally {
                createEntityManager.close();
            }
        }
    }

    public void k(QQAppInterface qQAppInterface, DraftTextInfo draftTextInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface, (Object) draftTextInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DraftTextManger", 2, "<---saveDraftText : begin....");
        }
        synchronized (this.f243630a) {
            if (draftTextInfo == null) {
                return;
            }
            String i3 = i(draftTextInfo.uin, draftTextInfo.type);
            if (!f243628d.contains(i3)) {
                f243628d.add(i3);
            }
            f243626b.put(i3, draftTextInfo);
            f243627c.put(i3, c(qQAppInterface, draftTextInfo));
            ThreadManagerV2.post(new Runnable(qQAppInterface, draftTextInfo) { // from class: com.tencent.mobileqq.managers.DraftTextManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f243631d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ DraftTextInfo f243632e;

                {
                    this.f243631d = qQAppInterface;
                    this.f243632e = draftTextInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DraftTextManager.this, qQAppInterface, draftTextInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    EntityManager createEntityManager = this.f243631d.getEntityManagerFactory().createEntityManager();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new PersistOrReplaceTransaction(this.f243632e));
                    createEntityManager.doMultiDBOperateByTransaction(arrayList);
                }
            }, 8, null, false);
        }
    }
}
