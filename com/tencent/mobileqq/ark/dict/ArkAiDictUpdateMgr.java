package com.tencent.mobileqq.ark.dict;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.config.qqmc.AIDictParser;
import com.tencent.mobileqq.ark.core.i;
import com.tencent.mobileqq.ark.dict.b;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAiDictUpdateMgr {

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f199387d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    private final AppRuntime f199388a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f199389b = false;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f199390c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            final com.tencent.mobileqq.ark.dict.c o16 = ArkAiDictUpdateMgr.o();
            Map B = ArkAiDictUpdateMgr.B(o16);
            com.tencent.mobileqq.ark.dict.c n3 = ArkAiDictUpdateMgr.n();
            ArrayList arrayList = new ArrayList();
            for (String str : B.keySet()) {
                com.tencent.mobileqq.ark.dict.c cVar = (com.tencent.mobileqq.ark.dict.c) B.get(str);
                if (!ArkAiDictUpdateMgr.this.v(cVar)) {
                    QLog.i("ArkDict.Update", 1, String.format("updateLocalDict, local dict is not integrity, update, id=%s", str));
                    arrayList.add(cVar);
                } else {
                    QLog.i("ArkDict.Update", 1, String.format("updateLocalDict, local dict is integrity, ignore, id=%s", str));
                }
            }
            if (arrayList.isEmpty()) {
                ArkAiDictUpdateMgr.N(o16);
                ArkAiDictMgr.n(ArkAiDictUpdateMgr.this.f199388a);
                return;
            }
            synchronized (this) {
                if (!ArkAiDictUpdateMgr.this.f199389b) {
                    ArkAiDictUpdateMgr.this.f199389b = true;
                    final i iVar = new i();
                    iVar.f199429b = true;
                    iVar.f199428a = arrayList.size();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        final com.tencent.mobileqq.ark.dict.c cVar2 = (com.tencent.mobileqq.ark.dict.c) it.next();
                        ArkAiDictUpdateMgr.this.Q(n3, cVar2, new h() { // from class: com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.1.1
                            @Override // com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.h
                            public void a(boolean z16) {
                                if (!z16) {
                                    QLog.i("ArkDict.Update", 1, String.format("updateWordDict, one task failed, dict-id=%s", ArkAiDictUpdateMgr.C(cVar2)));
                                    iVar.f199429b = false;
                                }
                                synchronized (iVar) {
                                    i iVar2 = iVar;
                                    int i3 = iVar2.f199428a - 1;
                                    iVar2.f199428a = i3;
                                    if (i3 != 0) {
                                        return;
                                    }
                                    if (iVar.f199429b) {
                                        QLog.i("ArkDict.Update", 1, "updateWordDict, all success");
                                        ArkAiDictUpdateMgr.N(o16);
                                        ArkAiDictUpdateMgr.w(o16);
                                        ArkAiDictMgr.n(ArkAiDictUpdateMgr.this.f199388a);
                                    } else {
                                        QLog.i("ArkDict.Update", 1, "updateWordDict, one or more tasks failed.");
                                    }
                                    synchronized (this) {
                                        ArkAiDictUpdateMgr.this.f199389b = false;
                                        if (ArkAiDictUpdateMgr.this.f199390c) {
                                            ArkAiDictUpdateMgr.this.f199390c = false;
                                            QLog.i("ArkDict.Update", 1, "updateWordDict, pending update task exists, wait 5 second and update");
                                            ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThreadDelay(new Runnable() { // from class: com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.1.1.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    ArkAiDictUpdateMgr.this.P();
                                                }
                                            }, 5000);
                                        }
                                    }
                                }
                            }
                        });
                    }
                    return;
                }
                QLog.i("ArkDict.Update", 1, "updateLocalDict, update in progress, wait current task complete");
                ArkAiDictUpdateMgr.this.f199390c = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f199401a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ark.dict.d f199402b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f199403c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f199404d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f199405e;

        a(i iVar, com.tencent.mobileqq.ark.dict.d dVar, String str, h hVar, String str2) {
            this.f199401a = iVar;
            this.f199402b = dVar;
            this.f199403c = str;
            this.f199404d = hVar;
            this.f199405e = str2;
        }

        @Override // com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.h
        public void a(boolean z16) {
            if (!z16) {
                this.f199401a.f199429b = false;
            }
            synchronized (this.f199401a) {
                i iVar = this.f199401a;
                int i3 = iVar.f199428a - 1;
                iVar.f199428a = i3;
                if (i3 > 0) {
                    QLog.i("ArkDict.Update", 1, String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", this.f199402b.f199448b, Boolean.toString(z16), Integer.valueOf(i3)));
                    return;
                }
                QLog.i("ArkDict.Update", 1, String.format("updateWordDict, all complete, success=%s", Boolean.toString(this.f199401a.f199429b)));
                if (!this.f199401a.f199429b) {
                    FileUtils.deleteDirectory(this.f199403c);
                    this.f199404d.a(false);
                } else if (!ArkAiDictUpdateMgr.M(ArkAiDictMgr.g(this.f199405e), new File(this.f199403c).getParent())) {
                    QLog.i("ArkDict.Update", 1, "updateWordDict, renameDictDirAfterUpdateSuccess fail");
                    this.f199404d.a(false);
                } else {
                    this.f199404d.a(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ark.dict.d f199407a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f199408b;

        b(com.tencent.mobileqq.ark.dict.d dVar, h hVar) {
            this.f199407a = dVar;
            this.f199408b = hVar;
        }

        @Override // com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.h
        public void a(boolean z16) {
            QLog.i("ArkDict.Update", 1, String.format("updateDict, local not exists, full update, success=%s, name=%s", Boolean.toString(z16), this.f199407a.f199448b));
            this.f199408b.a(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ark.dict.d f199410a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f199411b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f199412c;

        /* compiled from: P */
        /* loaded from: classes11.dex */
        class a implements h {
            a() {
            }

            @Override // com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.h
            public void a(boolean z16) {
                QLog.i("ArkDict.Update", 1, String.format("updateDict, incremental update fail, full update result, success=%s, name=%s", Boolean.toString(z16), c.this.f199410a.f199448b));
                c.this.f199411b.a(z16);
            }
        }

        c(com.tencent.mobileqq.ark.dict.d dVar, h hVar, String str) {
            this.f199410a = dVar;
            this.f199411b = hVar;
            this.f199412c = str;
        }

        @Override // com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.h
        public void a(boolean z16) {
            if (z16) {
                QLog.i("ArkDict.Update", 1, String.format("updateDict, incremental update success, name=%s", this.f199410a.f199448b));
                this.f199411b.a(true);
            } else {
                QLog.i("ArkDict.Update", 1, String.format("updateDict, incremental update fail, try full update, name=%s", this.f199410a.f199448b));
                ArkAiDictUpdateMgr.this.x(this.f199412c, this.f199410a, new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f199415a;

        d(h hVar) {
            this.f199415a = hVar;
        }

        @Override // com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.h
        public void a(boolean z16) {
            this.f199415a.a(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ark.dict.d f199417a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f199418b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f199419c;

        e(com.tencent.mobileqq.ark.dict.d dVar, String str, h hVar) {
            this.f199417a = dVar;
            this.f199418b = str;
            this.f199419c = hVar;
        }

        @Override // com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.g
        public void a(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                if (!ArkAiDictUpdateMgr.t(bArr, this.f199417a.f199451e)) {
                    com.tencent.mobileqq.ark.dict.d dVar = this.f199417a;
                    QLog.i("ArkDict.Update", 1, String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", dVar.f199448b, dVar.f199449c, dVar.f199451e));
                } else if (!FileUtils.fileExists(this.f199418b)) {
                    QLog.e("ArkDict.Update", 1, "dictFullUpdate path not exists");
                } else {
                    this.f199419c.a(true);
                    return;
                }
            } else {
                com.tencent.mobileqq.ark.dict.d dVar2 = this.f199417a;
                QLog.i("ArkDict.Update", 1, String.format("dictFullUpdate, download fail, name=%s, url=%s", dVar2.f199448b, dVar2.f199449c));
            }
            this.f199419c.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class f implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ark.dict.d f199421a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f199422b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.ark.dict.d f199423c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f199424d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f199425e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f199426f;

        f(com.tencent.mobileqq.ark.dict.d dVar, String str, com.tencent.mobileqq.ark.dict.d dVar2, String str2, String str3, h hVar) {
            this.f199421a = dVar;
            this.f199422b = str;
            this.f199423c = dVar2;
            this.f199424d = str2;
            this.f199425e = str3;
            this.f199426f = hVar;
        }

        @Override // com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.g
        public void a(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                if (ArkAiDictUpdateMgr.t(bArr, this.f199421a.f199453g)) {
                    String E = ArkAiDictUpdateMgr.E(this.f199422b, this.f199423c.f199448b);
                    if (!new File(E).isFile()) {
                        QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, src path not exist, name=%s, path=s", this.f199421a.f199448b, E));
                    } else if (!FileUtils.fileExists(this.f199424d)) {
                        QLog.e("ArkDict.Update", 1, "dictIncrementalUpdate path not exists");
                    } else if (!BspatchUtil.a(E, this.f199424d, String.format("%s/%s", this.f199425e, this.f199421a.f199448b))) {
                        com.tencent.mobileqq.ark.dict.d dVar = this.f199421a;
                        QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, patch fail, name=%s, diff-md5=%s", dVar.f199448b, dVar.f199453g));
                    } else {
                        this.f199426f.a(true);
                        return;
                    }
                } else {
                    com.tencent.mobileqq.ark.dict.d dVar2 = this.f199421a;
                    QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, md5 mismatch, name=%s, url=%s, md5=%s", dVar2.f199448b, dVar2.f199449c, dVar2.f199453g));
                }
            } else {
                com.tencent.mobileqq.ark.dict.d dVar3 = this.f199421a;
                QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, download fail, name=%s, url=%s", dVar3.f199448b, dVar3.f199449c));
            }
            this.f199426f.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface g {
        void a(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface h {
        void a(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        volatile int f199428a = 0;

        /* renamed from: b, reason: collision with root package name */
        volatile boolean f199429b = false;

        i() {
        }
    }

    public ArkAiDictUpdateMgr(AppRuntime appRuntime) {
        this.f199388a = appRuntime;
    }

    private static String A(String str) {
        return ArkAiDictMgr.g(str) + "/WordData";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, com.tencent.mobileqq.ark.dict.c> B(com.tencent.mobileqq.ark.dict.c cVar) {
        String C;
        HashMap hashMap = new HashMap();
        if (cVar == null) {
            QLog.i("ArkDict.Update", 1, "getDictGroupList,aIDictConfig is null");
            return hashMap;
        }
        String C2 = C(cVar);
        if (C2 != null) {
            hashMap.put(C2, cVar);
        }
        Iterator<com.tencent.mobileqq.ark.dict.b> it = cVar.f199446f.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.ark.dict.b next = it.next();
            if (next != null) {
                b.a aVar = next.f199439b;
                com.tencent.mobileqq.ark.dict.c cVar2 = next.f199438a;
                if (aVar != null && cVar2 != null && (C = C(cVar2)) != null) {
                    hashMap.put(C, cVar2);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String C(com.tencent.mobileqq.ark.dict.c cVar) {
        if (cVar == null) {
            return null;
        }
        String str = cVar.f199442b;
        String str2 = cVar.f199441a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s-%s", str, str2);
    }

    private static Map<String, com.tencent.mobileqq.ark.dict.d> D(com.tencent.mobileqq.ark.dict.c cVar) {
        if (cVar == null) {
            return new HashMap();
        }
        ArrayList<com.tencent.mobileqq.ark.dict.d> arrayList = cVar.f199445e;
        if (arrayList == null) {
            QLog.i("ArkDict.Update", 1, "getDictInfoFromConfig, 'word_dict_list' field not found");
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        Iterator<com.tencent.mobileqq.ark.dict.d> it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.ark.dict.d next = it.next();
            if (next != null) {
                hashMap.put(next.f199448b, next);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String E(String str, String str2) {
        return String.format("%s/%s", A(str), str2);
    }

    public static String F() {
        b.a aVar;
        com.tencent.mobileqq.ark.dict.c cVar;
        String C;
        com.tencent.mobileqq.ark.dict.c G = G();
        if (G == null) {
            return null;
        }
        Iterator<com.tencent.mobileqq.ark.dict.b> it = G.f199446f.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.ark.dict.b next = it.next();
            if (next != null && (aVar = next.f199439b) != null && (cVar = next.f199438a) != null && K(aVar) && (C = C(cVar)) != null) {
                QLog.i("ArkDict.Update", 1, String.format("getEffectDictIdentifier, use condition dict, dict-id=%s, condition=%s", C, aVar.toString()));
                return C;
            }
        }
        String C2 = C(G);
        QLog.i("ArkDict.Update", 1, String.format("getEffectDictIdentifier, use base dict, dict-id=%s", C2));
        return C2;
    }

    private static com.tencent.mobileqq.ark.dict.c G() {
        String string = BaseApplication.getContext().getSharedPreferences("SP_DICT_INFO_KEY", 0).getString("ArkAILocalDictConfig", "");
        if (TextUtils.isEmpty(string)) {
            QLog.i("ArkDict.Update", 1, "getLocalDictConfig, configString is empty");
            return null;
        }
        try {
            return (com.tencent.mobileqq.ark.dict.c) as.e(string, com.tencent.mobileqq.ark.dict.a.class);
        } catch (QStorageInstantiateException e16) {
            QLog.i("ArkDict.Update", 1, String.format("getLocalDictConfig, fail to decode json, err=%s", e16.getMessage()));
            return null;
        }
    }

    private static int H() {
        Date date = new Date();
        return Integer.parseInt(String.format(Locale.CHINA, "%04d%02d%02d%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours())));
    }

    private static com.tencent.mobileqq.ark.dict.c I() {
        d91.a d16 = AIDictParser.d();
        if (d16 == null) {
            QLog.i("ArkDict.Update", 1, "getRemoteDictConfig, config string is empty");
            return null;
        }
        return d16.c();
    }

    private static String J(String str) {
        String A = A(String.format(Locale.CHINA, "%s%s-%d", "tmp-", str, Long.valueOf(System.currentTimeMillis())));
        File file = new File(A);
        file.mkdirs();
        if (!file.isDirectory()) {
            QLog.i("ArkDict.Update", 1, String.format("getTmpWordDataDirectory, fail to create tmp word data directory, dir=%s", A));
            return null;
        }
        return A;
    }

    private static boolean K(b.a aVar) {
        if (aVar == null) {
            return false;
        }
        String str = aVar.f199440a;
        String[] split = str.split("-");
        if (split.length == 2) {
            try {
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                int H = H();
                if (parseInt <= H && H <= parseInt2) {
                    return true;
                }
            } catch (NumberFormatException unused) {
                QLog.i("ArkDict.Update", 1, String.format(Locale.CHINA, "isDictConditionEffect, invalid date, date=%s", str));
            }
        }
        return false;
    }

    private static boolean L(String str, com.tencent.mobileqq.ark.dict.d dVar) {
        if (dVar == null || !u(E(str, dVar.f199448b), dVar.f199451e)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean M(String str, String str2) {
        String format = String.format(Locale.CHINA, "%s-%d", str, Long.valueOf(System.currentTimeMillis()));
        if (FileUtils.rename(str, format)) {
            QLog.i("ArkDict.Update", 1, String.format("did rename dict dir to tmp dir, %s->%s", str, format));
        }
        if (!FileUtils.rename(str2, str)) {
            QLog.i("ArkDict.Update", 1, String.format("fail to rename new dir to dict dir, %s->%s", str2, str));
            return false;
        }
        FileUtils.deleteDirectory(format);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(com.tencent.mobileqq.ark.dict.c cVar) {
        if (cVar == null) {
            QLog.i("ArkDict.Update", 1, "setLocalDictConfig,aIDictConfig is null");
            return;
        }
        String a16 = cVar.a();
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("SP_DICT_INFO_KEY", 0).edit();
        if (edit == null) {
            QLog.e("ArkDict.Update", 1, "setLocalDictConfig,editor is null");
        } else {
            edit.putString("ArkAILocalDictConfig", a16);
            edit.apply();
        }
    }

    private void O(String str, String str2, com.tencent.mobileqq.ark.dict.d dVar, com.tencent.mobileqq.ark.dict.d dVar2, h hVar) {
        if (!L(str2, dVar)) {
            dVar = null;
        }
        com.tencent.mobileqq.ark.dict.d dVar3 = dVar;
        boolean z16 = false;
        if (dVar3 == null) {
            QLog.i("ArkDict.Update", 1, String.format("updateDict, local not exists, full update, name=%s", dVar2.f199448b));
            x(str, dVar2, new b(dVar2, hVar));
            return;
        }
        if (dVar3.f199451e.equals(dVar2.f199451e)) {
            QLog.i("ArkDict.Update", 1, String.format("updateDict, file not change, copy from origin, name=%s", dVar2.f199448b));
            String E = E(str2, dVar3.f199448b);
            String format = String.format("%s/%s", str, dVar2.f199448b);
            if (!FileUtils.copyFile(E, format)) {
                QLog.i("ArkDict.Update", 1, String.format("updateDict, copy file fail, %s->%s", E, format));
            } else {
                z16 = true;
            }
            hVar.a(z16);
            return;
        }
        if (dVar2.a() && dVar3.f199451e.equals(dVar2.f199454h)) {
            QLog.i("ArkDict.Update", 1, String.format("updateDict, incremental update, name=%s", dVar2.f199448b));
            y(str, str2, dVar3, dVar2, new c(dVar2, hVar, str));
        } else {
            QLog.i("ArkDict.Update", 1, String.format("updateDict, full update, name=%s", dVar2.f199448b));
            x(str, dVar2, new d(hVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(com.tencent.mobileqq.ark.dict.c cVar, com.tencent.mobileqq.ark.dict.c cVar2, h hVar) {
        if (cVar2 == null) {
            QLog.i("ArkDict.Update", 1, "updateWordDict, remote dict config is empty");
            hVar.a(false);
            return;
        }
        if (!s(cVar2)) {
            QLog.i("ArkDict.Update", 1, "updateWordDict, canUpdateDictAtCurrentNetType is false");
            hVar.a(false);
            return;
        }
        String C = C(cVar2);
        if (TextUtils.isEmpty(C)) {
            QLog.i("ArkDict.Update", 1, "updateWordDict, empty new dict id");
            hVar.a(false);
            return;
        }
        String J = J(C);
        if (TextUtils.isEmpty(J)) {
            QLog.i("ArkDict.Update", 1, String.format("updateWordDict, fail to create new dict dir, id=%s", C));
            hVar.a(false);
            return;
        }
        Map<String, com.tencent.mobileqq.ark.dict.d> D = D(cVar2);
        if (D != null && D.size() != 0) {
            String C2 = C(cVar);
            Map<String, com.tencent.mobileqq.ark.dict.d> D2 = D(cVar);
            i iVar = new i();
            iVar.f199428a = D.size();
            iVar.f199429b = true;
            for (com.tencent.mobileqq.ark.dict.d dVar : D.values()) {
                O(J, C2, D2.get(dVar.f199448b), dVar, new a(iVar, dVar, J, hVar, C));
                D2 = D2;
                iVar = iVar;
            }
            return;
        }
        QLog.i("ArkDict.Update", 1, "updateWordDict, new dict list is empty");
        hVar.a(true);
    }

    static /* bridge */ /* synthetic */ com.tencent.mobileqq.ark.dict.c n() {
        return G();
    }

    static /* bridge */ /* synthetic */ com.tencent.mobileqq.ark.dict.c o() {
        return I();
    }

    private static String r(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            for (byte b16 : bArr) {
                char[] cArr = f199387d;
                sb5.append(cArr[(b16 >> 4) & 15]);
                sb5.append(cArr[b16 & RegisterType.DOUBLE_HI]);
            }
        }
        return sb5.toString();
    }

    private static boolean s(com.tencent.mobileqq.ark.dict.c cVar) {
        if (cVar == null) {
            return false;
        }
        String str = cVar.f199444d;
        if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase("wifi")) {
            QLog.i("ArkDict.Update", 1, String.format("getNetType, netType in not WIFI.", new Object[0]));
            return true;
        }
        if (AppNetConnInfo.isNetSupport() && AppNetConnInfo.isWifiConn()) {
            QLog.i("ArkDict.Update", 1, String.format("getNetType, invalid dict info, netType=%s", str));
            return true;
        }
        QLog.i("ArkDict.Update", 1, String.format("getNetType, not judge net Type.", new Object[0]));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean t(byte[] bArr, String str) {
        if (bArr != null && bArr.length != 0 && !TextUtils.isEmpty(str)) {
            try {
                if (!r(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(bArr)).equalsIgnoreCase(str)) {
                    return false;
                }
                return true;
            } catch (Exception e16) {
                QLog.i("ArkDict.Update", 1, String.format("checkDictMd5, fail compute buffer md5, msg=%s", e16.getMessage()));
            }
        }
        return false;
    }

    private static boolean u(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str);
        if (!file.isFile()) {
            return false;
        }
        byte[] bArr = new byte[4096];
        FileInputStream fileInputStream = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        QLog.i("ArkDict.Update", 1, String.format("checkFileMD5, exception, err=%s", e.getMessage()));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
                if (r(messageDigest.digest()).equalsIgnoreCase(str2)) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused3) {
                    }
                    return true;
                }
                try {
                    fileInputStream2.close();
                } catch (IOException unused4) {
                }
                return false;
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(com.tencent.mobileqq.ark.dict.c cVar) {
        int i3;
        if (cVar == null) {
            QLog.i("ArkDict.Update", 1, "checkLocalDictIntegrity, config is empty, return");
            return false;
        }
        String C = C(cVar);
        Map<String, com.tencent.mobileqq.ark.dict.d> D = D(cVar);
        if (D == null) {
            QLog.i("ArkDict.Update", 1, "checkLocalDictIntegrity, local dict list is empty");
            return true;
        }
        Iterator<com.tencent.mobileqq.ark.dict.d> it = D.values().iterator();
        while (true) {
            if (it.hasNext()) {
                if (!L(C, it.next())) {
                    i3 = 1;
                    break;
                }
            } else {
                i3 = 0;
                break;
            }
        }
        if (i3 == 0) {
            QLog.i("ArkDict.Update", 1, String.format("checkLocalDictIntegrity, all files check ok, no update, dict-id=%s", C));
            return true;
        }
        QLog.i("ArkDict.Update", 1, String.format(Locale.CHINA, "checkLocalDictIntegrity, %d of %d files need update", Integer.valueOf(i3), Integer.valueOf(D.size())));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(com.tencent.mobileqq.ark.dict.c cVar) {
        if (cVar == null) {
            QLog.i("ArkDict.Update", 1, "deleteUnusedDict, localDictConfig is null");
            return;
        }
        Map<String, com.tencent.mobileqq.ark.dict.c> B = B(cVar);
        String h16 = ArkAiDictMgr.h();
        String[] list = new File(h16).list();
        if (list != null) {
            for (String str : list) {
                if (!B.containsKey(str)) {
                    QLog.i("ArkDict.Update", 1, String.format("deleteUnusedDict, name=%s", str));
                    FileUtils.deleteDirectory(h16 + "/" + str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, com.tencent.mobileqq.ark.dict.d dVar, h hVar) {
        String format = String.format("%s/%s", str, dVar.f199448b);
        z(dVar.f199448b, dVar.f199449c, format, new e(dVar, format, hVar));
    }

    private void y(String str, String str2, com.tencent.mobileqq.ark.dict.d dVar, com.tencent.mobileqq.ark.dict.d dVar2, h hVar) {
        String format = String.format("%s/diff-%s", str, dVar2.f199451e);
        z(dVar2.f199448b, dVar2.f199452f, format, new f(dVar2, str2, dVar, format, str, hVar));
    }

    private void z(String str, final String str2, final String str3, final g gVar) {
        final i.a a16 = com.tencent.mobileqq.ark.core.i.a(this.f199388a, str, str2);
        a16.b(new Runnable() { // from class: com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.8

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr$8$a */
            /* loaded from: classes11.dex */
            class a implements g91.a {
                a() {
                }

                @Override // g91.a
                public void a(int i3, byte[] bArr) {
                    long j3;
                    gVar.a(bArr);
                    AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                    i.a aVar = a16;
                    String str = str2;
                    if (bArr != null) {
                        j3 = bArr.length;
                    } else {
                        j3 = -1;
                    }
                    aVar.a(str, j3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.ark.util.h.b(ArkAiDictUpdateMgr.this.f199388a, str2, null, str3, new a());
            }
        });
    }

    public void P() {
        if (com.tencent.mobileqq.ark.dict.f.a()) {
            QLog.i("ArkDict.Update", 1, "updateLocalDict, use test dict, no update, return");
        } else {
            QLog.i("ArkDict.Update", 1, "updateLocalDict, start");
            ArkRecommendLogic.a().post(new AnonymousClass1());
        }
    }
}
