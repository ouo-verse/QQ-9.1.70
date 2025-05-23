package com.tencent.could.huiyansdk.operate;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Base64;
import com.google.gson.Gson;
import com.tencent.could.component.common.ai.eventreport.entry.NetWorkParam;
import com.tencent.could.component.common.ai.log.AiLog;
import com.tencent.could.component.common.ai.net.HttpMethod;
import com.tencent.could.component.common.ai.net.IJsonDataListener;
import com.tencent.could.component.common.ai.net.TXCHttp;
import com.tencent.could.component.common.ai.utils.TwoTuple;
import com.tencent.could.huiyansdk.base.HuiYanBaseApi;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.utils.HYPCommonUtils;
import com.tencent.could.huiyansdk.utils.l;
import com.tencent.could.huiyansdk.utils.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public HuiYanOperateBody f100252a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, Long> f100253b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements IJsonDataListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f100254a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f100255b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f100256c;

        public a(boolean z16, File file, String str) {
            this.f100254a = z16;
            this.f100255b = file;
            this.f100256c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, Boolean.valueOf(z16), file, str);
            }
        }

        @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
        public void onFailed(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            k.a.f100197a.a(2, "OperateInfoManager", "007 onFailed s:" + str);
            if (!this.f100254a) {
                c.this.a(this.f100256c);
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
            kVar.a(1, "OperateInfoManager", "upload 007 info success!");
            if (this.f100254a && !this.f100255b.delete()) {
                kVar.a(2, "OperateInfoManager", "upload content success, but delete file error : path " + this.f100255b.getAbsolutePath());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final c f100258a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12198);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f100258a = new c();
            }
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f100253b = new ArrayMap(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        String c16 = c();
        if (TextUtils.isEmpty(c16)) {
            k.a.f100197a.a(2, "OperateInfoManager", "dirPath is empty!");
            return;
        }
        File[] listFiles = new File(c16).listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file : listFiles) {
                if (!file.isDirectory()) {
                    try {
                        a(file);
                    } catch (IOException e16) {
                        k.a.f100197a.a(2, "OperateInfoManager", "readAnCheckLocalFile error : " + e16.getMessage());
                    }
                }
            }
        }
    }

    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Context a16 = HuiYanBaseApi.b.f100031a.a();
        if (a16 == null) {
            k.a.f100197a.a(2, "OperateInfoManager", "current context is null!");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cloud-huiyan");
        String str = File.separator;
        sb5.append(str);
        sb5.append("operate");
        return a16.getFilesDir() + str + sb5.toString();
    }

    public final void a(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) file);
            return;
        }
        if (file.lastModified() < System.currentTimeMillis() - 259200000) {
            if (file.delete()) {
                return;
            }
            k.a.f100197a.a(2, "OperateInfoManager", "delete file error : path " + file.getCanonicalPath());
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
            k.a.f100197a.a(2, "OperateInfoManager", "read file error : " + file.getCanonicalPath());
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            q.a.f100321a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.operate.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.d();
                }
            });
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, boolean z16, File file) {
        TwoTuple<String, String> requestConnectIp = HYPCommonUtils.getRequestConnectIp(false);
        String str2 = requestConnectIp.first + "/api/common/event-monitor";
        TXCHttp.sendRequest(NetWorkParam.NetWorkParamBuilder.newBuilder().setUrl(str2).setDeputyUrl(requestConnectIp.second + "/api/common/event-monitor").setBackUpIpStringUrl("https://121.14.78.51/api/common/event-monitor").setHttpsVerifyHost("sdk.faceid.qq.com").setHttpMethod(HttpMethod.POST).setRequestHeaders(null).setGzip(true).setRequestData(str).createNetWorkParam(), new a(z16, file, str));
    }

    public final void a(final String str, final boolean z16, final File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16), file);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            k kVar = k.a.f100197a;
            kVar.a(2, "OperateInfoManager", "doUploadInfo content is empty!");
            if (!z16 || file == null || file.delete()) {
                return;
            }
            kVar.a(2, "OperateInfoManager", "upload content success, but delete file error : path " + file.getAbsolutePath());
            return;
        }
        k.a.f100197a.a(2, "OperateInfoManager", "real upload!");
        q.a.f100321a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.operate.d
            @Override // java.lang.Runnable
            public final void run() {
                c.this.b(str, z16, file);
            }
        });
    }

    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        String c16 = c();
        if (TextUtils.isEmpty(c16)) {
            k.a.f100197a.a(2, "OperateInfoManager", "get error dir path");
            return;
        }
        HuiYanOperateBody huiYanOperateBody = this.f100252a;
        if (huiYanOperateBody == null) {
            k.a.f100197a.a(2, "OperateInfoManager", "huiYanOperateBody is null");
            return;
        }
        String token = huiYanOperateBody.getToken();
        if (TextUtils.isEmpty(token)) {
            token = "error: " + System.currentTimeMillis();
        }
        File file = new File(c16 + File.separator + Base64.encodeToString(token.getBytes(), 2) + ".ope");
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            k.a.f100197a.a(2, "OperateInfoManager", "Create parent dir error!");
        }
        if (file.exists() && !file.delete()) {
            k.a.f100197a.a(2, "OperateInfoManager", "delete last video error!");
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
        } catch (IOException unused) {
            k.a.f100197a.a(2, "OperateInfoManager", "");
        }
    }

    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        try {
            return new Gson().toJson((HuiYanOperateBody) this.f100252a.clone());
        } catch (Exception e16) {
            k.a.f100197a.a(2, "OperateInfoManager", e16.getMessage());
            return "";
        }
    }

    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        String str2 = i3 + "";
        HuiYanOperateBody huiYanOperateBody = this.f100252a;
        if (huiYanOperateBody != null) {
            huiYanOperateBody.setErrorCode(str2);
            this.f100252a.setErrorMessage(str);
        }
    }

    public void a(String str, int i3, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2);
            return;
        }
        HuiYanOperateBody huiYanOperateBody = this.f100252a;
        if (huiYanOperateBody != null) {
            huiYanOperateBody.updateInfo(str, i3, j3, System.currentTimeMillis(), str2);
        }
        if ("Crash".equals(str)) {
            a(a());
        }
    }

    public void a(String str, int i3, boolean z16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), str2);
            return;
        }
        try {
            if (i3 == 1) {
                this.f100253b.put(str, Long.valueOf(System.currentTimeMillis()));
                return;
            }
            if (i3 == 2) {
                if (!this.f100253b.containsKey(str)) {
                    k.a.f100197a.a(2, "OperateInfoManager", "not found event start:" + str);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis() - this.f100253b.get(str).longValue();
                if (currentTimeMillis > 0) {
                    if (z16) {
                        a(str, -1, currentTimeMillis, str2);
                    } else {
                        a(str, 1, currentTimeMillis, str2);
                    }
                    this.f100253b.remove(str);
                }
            }
        } catch (Exception e16) {
            l lVar = l.a.f100309a;
            String str3 = "opOperateTimeEvent error! action: " + str + " exc: " + e16.getLocalizedMessage();
            if (lVar.f100307a) {
                AiLog.error("OperateInfoManager", str3);
            }
        }
    }
}
