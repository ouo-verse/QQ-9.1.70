package com.tencent.could.huiyansdk.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.tencent.could.component.common.ai.eventreport.entry.NetWorkParam;
import com.tencent.could.component.common.ai.net.HttpMethod;
import com.tencent.could.component.common.ai.net.IJsonDataListener;
import com.tencent.could.component.common.ai.net.TXCHttp;
import com.tencent.could.component.common.ai.utils.TwoTuple;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.entity.BuriedPointAction;
import com.tencent.could.huiyansdk.entity.BuriedPointBody;
import com.tencent.could.huiyansdk.entity.BuriedPointInfoError;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.utils.HYPCommonUtils;
import com.tencent.could.huiyansdk.utils.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public BuriedPointBody f100155a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f100156b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements IJsonDataListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f100157a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f100158b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f100159c;

        public a(boolean z16, File file, String str) {
            this.f100157a = z16;
            this.f100158b = file;
            this.f100159c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, Boolean.valueOf(z16), file, str);
            }
        }

        @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
        public void onFailed(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            k.a.f100197a.a(2, "BuriedPointManager", "on failed, s:" + str);
            if (!this.f100157a) {
                d.this.a(this.f100159c);
            }
        }

        @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
        public void onSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            k kVar = k.a.f100197a;
            kVar.a(1, "BuriedPointManager", "upload buried info success!");
            if (this.f100157a && !this.f100158b.delete()) {
                kVar.a(2, "BuriedPointManager", "upload content success, but delete file error : path " + this.f100158b.getAbsolutePath());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final d f100161a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18443);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100161a = new d();
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f100156b = false;
            this.f100155a = new BuriedPointBody();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z16) {
        String b16 = b(z16);
        if (TextUtils.isEmpty(b16)) {
            k.a.f100197a.a(2, "BuriedPointManager", "local dir path is empty!");
            return;
        }
        File[] listFiles = new File(b16).listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (!file.isDirectory()) {
                    try {
                        a(file);
                    } catch (IOException e16) {
                        k.a.f100197a.a(2, "BuriedPointManager", "read and check local file error: " + e16.getMessage());
                    }
                }
            }
        }
    }

    public final void a(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            q.a.f100321a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.manager.o
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.c(z16);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
    }

    public final String b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        HuiYanBaseApi huiYanBaseApi = HuiYanBaseApi.b.f100031a;
        Context a16 = huiYanBaseApi.a();
        if (a16 == null) {
            k.a.f100197a.a(2, "BuriedPointManager", "current context is null!");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cloud-huiyan");
        String str = File.separator;
        sb5.append(str);
        sb5.append("buried");
        String sb6 = sb5.toString();
        if (z16) {
            Context a17 = huiYanBaseApi.a();
            if (a17 == null ? false : com.tencent.could.huiyansdk.utils.m.a(a17, com.tencent.could.huiyansdk.utils.m.f100311b)) {
                return a16.getExternalFilesDir(null) + str + sb6;
            }
        }
        return a16.getFilesDir() + str + sb6;
    }

    public final void a(final String str, final boolean z16, final File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), file);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            k kVar = k.a.f100197a;
            kVar.a(2, "BuriedPointManager", "upload info content is empty!");
            if (!z16 || file == null || file.delete()) {
                return;
            }
            kVar.a(2, "BuriedPointManager", "upload content success, but delete file error : path " + file.getAbsolutePath());
            return;
        }
        q.a.f100321a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.manager.n
            @Override // java.lang.Runnable
            public final void run() {
                d.this.b(str, z16, file);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, boolean z16, File file) {
        TwoTuple<String, String> requestConnectIp = HYPCommonUtils.getRequestConnectIp(false);
        String str2 = requestConnectIp.first + "/api/common/event-tracking";
        TXCHttp.sendRequest(NetWorkParam.NetWorkParamBuilder.newBuilder().setUrl(str2).setDeputyUrl(requestConnectIp.second + "/api/common/event-tracking").setBackUpIpStringUrl("https://121.14.78.51/api/common/event-tracking").setHttpsVerifyHost("sdk.faceid.qq.com").setHttpMethod(HttpMethod.POST).setRequestHeaders(null).setGzip(true).setRequestData(str).createNetWorkParam(), new a(z16, file, str));
    }

    public final void a(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) file);
            return;
        }
        if (file.lastModified() < System.currentTimeMillis() - 259200000) {
            if (file.delete()) {
                return;
            }
            k.a.f100197a.a(2, "BuriedPointManager", "delete file error : path " + file.getCanonicalPath());
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb5.append(readLine);
                    } else {
                        a(new String(Base64.decode(sb5.toString(), 2)), true, file);
                        bufferedReader.close();
                        return;
                    }
                }
            } finally {
            }
        } catch (IOException unused) {
            k.a.f100197a.a(2, "BuriedPointManager", "read file error : " + file.getCanonicalPath());
        }
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        String b16 = b(this.f100156b);
        if (TextUtils.isEmpty(b16)) {
            k.a.f100197a.a(2, "BuriedPointManager", "get error dir path");
            return;
        }
        String faceIdToken = this.f100155a.getFaceIdToken();
        if (TextUtils.isEmpty(faceIdToken)) {
            faceIdToken = "error: " + System.currentTimeMillis();
        }
        File file = new File(b16 + File.separator + Base64.encodeToString(faceIdToken.getBytes(), 2) + ".bur");
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            k.a.f100197a.a(2, "BuriedPointManager", "create parent dir error!");
        }
        if (file.exists() && !file.delete()) {
            k.a.f100197a.a(2, "BuriedPointManager", "delete last video error!");
        }
        String encodeToString = Base64.encodeToString(str.getBytes(), 2);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
            try {
                bufferedWriter.write(encodeToString);
                bufferedWriter.flush();
                bufferedWriter.close();
            } finally {
            }
        } catch (IOException e16) {
            k.a.f100197a.a(2, "BuriedPointManager", "save info to file error: " + e16.getLocalizedMessage());
        }
    }

    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        try {
            return new Gson().toJson((BuriedPointBody) this.f100155a.clone());
        } catch (Exception e16) {
            k.a.f100197a.a(2, "BuriedPointManager", e16.getMessage());
            return "";
        }
    }

    public void a(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        BuriedPointAction buriedPointAction = new BuriedPointAction();
        buriedPointAction.setStage(str);
        buriedPointAction.setAction(str2);
        buriedPointAction.setInfo(str3);
        buriedPointAction.setTimestamp(System.currentTimeMillis());
        this.f100155a.addAction(buriedPointAction);
    }

    public static String a(long j3, String str) {
        BuriedPointInfoError buriedPointInfoError = new BuriedPointInfoError();
        buriedPointInfoError.setErrorCode(j3);
        buriedPointInfoError.setErrorMsg(str);
        return new Gson().toJson(buriedPointInfoError);
    }
}
