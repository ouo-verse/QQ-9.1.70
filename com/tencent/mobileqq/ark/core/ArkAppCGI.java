package com.tencent.mobileqq.ark.core;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.mobileqq.ark.core.ArkAppCGI;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes11.dex */
public class ArkAppCGI implements INetEngineListener {

    /* renamed from: f, reason: collision with root package name */
    static int f199263f;

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f199264h = Pattern.compile("Last-Modified[ ]*=[ ]*\\[([^\\[\\]]+)\\]");

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<AppRuntime> f199265d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<e> f199266e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements g91.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f199270a;

        a(e eVar) {
            this.f199270a = eVar;
        }

        @Override // g91.a
        public void a(int i3, byte[] bArr) {
            if (i3 == 0) {
                ArkAppCGI.this.i(this.f199270a, true, bArr);
            } else {
                QLog.i("ArkApp.ArkAppCGI", 1, String.format("download fail, url=%s, err=%d", this.f199270a.f199277a, Integer.valueOf(i3)));
                ArkAppCGI.this.i(this.f199270a, false, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f199272a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f199273b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f199274c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f199275d;

        b(c cVar, String str, Object obj, AppRuntime appRuntime) {
            this.f199272a = cVar;
            this.f199273b = str;
            this.f199274c = obj;
            this.f199275d = appRuntime;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(e eVar, boolean z16, byte[] bArr) {
            ArkAppCGI.this.j((f) eVar, z16, bArr);
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            QLog.i("ArkApp.ArkAppCGI", 1, "queryPackageNameByAppID, fail to get pskey, return");
            c cVar = this.f199272a;
            if (cVar != null) {
                cVar.a(false, null, this.f199273b, this.f199274c);
            }
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            if (!map.containsKey("connect.qq.com")) {
                QLog.i("ArkApp.ArkAppCGI", 1, "queryPackageNameByAppID, can't find in map, return");
                c cVar = this.f199272a;
                if (cVar != null) {
                    cVar.a(false, null, this.f199273b, this.f199274c);
                }
            }
            String str = map.get("connect.qq.com");
            String format = String.format("https://cgi.connect.qq.com/qqconnectwebsite/v2/appinfo/apkname/get?appid=%s&token=%d", this.f199273b, Integer.valueOf(ArkAppCGI.this.g(str)));
            if (ArkAppCGI.this.h(format, -1L, this.f199274c, this.f199272a)) {
                return;
            }
            f fVar = new f();
            String currentAccountUin = this.f199275d.getCurrentAccountUin();
            while (currentAccountUin.length() < 10) {
                currentAccountUin = "0" + currentAccountUin;
            }
            String str2 = "o" + currentAccountUin;
            fVar.f199284h = "p_uin=" + str2 + "; p_skey=" + str + "; uin=" + str2 + "; skey=";
            fVar.f199277a = format;
            fVar.f199280d.add(this.f199274c);
            fVar.f199281e.add(this.f199272a);
            fVar.f199286j = this.f199273b;
            fVar.f199285i = "https://connect.qq.com";
            ArkAppCGI.this.m(fVar, new d() { // from class: com.tencent.mobileqq.ark.core.a
                @Override // com.tencent.mobileqq.ark.core.ArkAppCGI.d
                public final void a(ArkAppCGI.e eVar, boolean z16, byte[] bArr) {
                    ArkAppCGI.b.this.b(eVar, z16, bArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface d {
        void a(e eVar, boolean z16, byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f199277a;

        /* renamed from: b, reason: collision with root package name */
        public File f199278b;

        /* renamed from: c, reason: collision with root package name */
        public ByteArrayOutputStream f199279c;

        /* renamed from: f, reason: collision with root package name */
        d f199282f;

        /* renamed from: h, reason: collision with root package name */
        public String f199284h;

        /* renamed from: i, reason: collision with root package name */
        public String f199285i;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList<Object> f199280d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList<c> f199281e = new ArrayList<>();

        /* renamed from: g, reason: collision with root package name */
        public long f199283g = -1;

        e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class f extends e {

        /* renamed from: j, reason: collision with root package name */
        public String f199286j;

        f() {
        }
    }

    public ArkAppCGI(AppRuntime appRuntime) {
        this.f199265d = new WeakReference<>(appRuntime);
    }

    private static synchronized String f() {
        String format;
        synchronized (ArkAppCGI.class) {
            String str = ArkEnvironmentManager.getInstance().getCacheDirectory() + "/tmp";
            new File(str).mkdirs();
            int i3 = f199263f + 1;
            f199263f = i3;
            format = String.format("%s/%s", str, String.format("cgi_%d_%d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i3)));
        }
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g(String str) {
        int i3 = 5381;
        for (int i16 = 0; i16 < str.length(); i16++) {
            i3 += (i3 << 5) + str.charAt(i16);
        }
        return Integer.MAX_VALUE & i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(String str, long j3, Object obj, c cVar) {
        synchronized (this.f199266e) {
            Iterator<e> it = this.f199266e.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.f199277a.equalsIgnoreCase(str) && next.f199283g == j3) {
                    next.f199280d.add(obj);
                    next.f199281e.add(cVar);
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final e eVar, final boolean z16, final byte[] bArr) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.ark.core.ArkAppCGI.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ArkAppCGI.this.f199266e) {
                    ArkAppCGI.this.f199266e.remove(eVar);
                }
                e eVar2 = eVar;
                eVar2.f199282f.a(eVar2, z16, bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(f fVar, boolean z16, byte[] bArr) {
        String k3;
        boolean z17;
        if (!z16) {
            QLog.i("ArkApp.ArkAppCGI", 1, String.format("onQueryPackageNameByAppID: fail, url=%s", fVar.f199277a));
            k3 = null;
        } else {
            k3 = k(bArr);
            if (k3 == null) {
                QLog.i("ArkApp.ArkAppCGI", 1, String.format("onQueryPackageNameByAppID: parseReply fail, url=%s", fVar.f199277a));
            }
        }
        for (int i3 = 0; i3 < fVar.f199281e.size(); i3++) {
            Object obj = fVar.f199280d.get(i3);
            c cVar = fVar.f199281e.get(i3);
            if (cVar != null) {
                if (k3 != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                cVar.a(z17, k3, fVar.f199286j, obj);
            }
        }
    }

    private String k(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                String string = jSONObject.getString("retcode");
                if (!string.equalsIgnoreCase("0")) {
                    QLog.i("ArkApp.ArkAppCGI", 1, "parseReply_QueryPackageNameByAppID, reply fail, ret=" + string);
                    return null;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                String string2 = jSONObject2.getString("retcode");
                String string3 = jSONObject2.getString("msg");
                String string4 = jSONObject2.getString("apk_name");
                if (string4 != null && string4.length() > 0) {
                    return string4;
                }
                QLog.i("ArkApp.ArkAppCGI", 1, "parseReply_QueryPackageNameByAppID, packageName is empty, retcode=" + string2 + string3);
                return null;
            } catch (JSONException e16) {
                e16.printStackTrace();
                QLog.i("ArkApp.ArkAppCGI", 1, "parseReply_QueryPackageNameByAppID, Json Exception:" + e16.getMessage());
                return null;
            } catch (Exception e17) {
                e17.printStackTrace();
                QLog.i("ArkApp.ArkAppCGI", 1, "parseReply_QueryPackageNameByAppID, Exception:" + e17.getMessage());
                return null;
            }
        }
        QLog.i("ArkApp.ArkAppCGI", 1, "parseReply_QueryPackageNameByAppID: replyBuf is empty");
        return null;
    }

    public void l(String str, Object obj, c cVar) {
        if (str != null && str.length() > 0) {
            AppRuntime appRuntime = this.f199265d.get();
            if (appRuntime == null) {
                QLog.i("ArkApp.ArkAppCGI", 1, "queryPackageNameByAppID, app is null, return");
                return;
            } else {
                ((IPskeyManager) appRuntime.getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{"connect.qq.com"}, new b(cVar, str, obj, appRuntime));
                return;
            }
        }
        if (cVar != null) {
            cVar.a(false, null, str, obj);
        }
    }

    final void m(e eVar, d dVar) {
        eVar.f199282f = dVar;
        synchronized (this.f199266e) {
            this.f199266e.add(eVar);
        }
        AppRuntime appRuntime = this.f199265d.get();
        if (appRuntime == null) {
            QLog.i("ArkApp.ArkAppCGI", 1, "runTask_retry, app is null, return");
            return;
        }
        File file = new File(f());
        eVar.f199278b = file;
        HashMap hashMap = new HashMap();
        String str = eVar.f199284h;
        if (str != null) {
            hashMap.put("Cookie", str);
        }
        String str2 = eVar.f199285i;
        if (str2 != null) {
            hashMap.put("Referer", str2);
        }
        com.tencent.mobileqq.ark.util.h.b(appRuntime, eVar.f199277a, hashMap, file.toString(), new a(eVar));
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        boolean z16;
        e eVar = (e) netResp.mReq.getUserData();
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        byte[] bArr = null;
        if (z16) {
            try {
                bArr = eVar.f199279c.toByteArray();
            } catch (OutOfMemoryError e16) {
                QLog.i("ArkApp.ArkAppCGI", 1, String.format("ArkAppCGI.onResp, out of memory, msg=%s", e16.getMessage()));
                z16 = false;
            }
        }
        if (netResp.mHttpCode == 304) {
            z16 = true;
        }
        String str = netResp.mRespProperties.get("param_rspHeader");
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = f199264h.matcher(str);
            if (matcher.find()) {
                try {
                    String group = matcher.group(1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E,d MMM y HH:mm:ss 'GMT'", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                    eVar.f199283g = simpleDateFormat.parse(group).getTime();
                } catch (ParseException unused) {
                    QLog.i("ArkApp.ArkAppCGI", 1, String.format("lastModified time parse fail, url=%s", eVar.f199277a));
                }
            }
        }
        i(eVar, z16, bArr);
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c {
        public void a(boolean z16, String str, String str2, Object obj) {
        }
    }
}
