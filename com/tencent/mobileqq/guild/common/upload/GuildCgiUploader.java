package com.tencent.mobileqq.guild.common.upload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildCgiUploader {

    /* renamed from: a, reason: collision with root package name */
    private final String f215482a;

    /* renamed from: b, reason: collision with root package name */
    private final String f215483b;

    /* renamed from: c, reason: collision with root package name */
    private IUploadApi.c f215484c;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private static class UploadResultParser {
        private static IGProSecurityResult a(JSONObject jSONObject) {
            final JSONObject optJSONObject;
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 == null) {
                optJSONObject = null;
            } else {
                optJSONObject = optJSONObject2.optJSONObject("msgSecRet");
            }
            if (optJSONObject == null) {
                return null;
            }
            return new IGProSecurityResult() { // from class: com.tencent.mobileqq.guild.common.upload.GuildCgiUploader.UploadResultParser.1
                @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
                public long getActionCode() {
                    try {
                        return Long.parseLong(JSONObject.this.optString("action", String.valueOf(Integer.MIN_VALUE)));
                    } catch (Exception unused) {
                        return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
                    }
                }

                @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
                public String getStrDetail() {
                    return JSONObject.this.optString("detail", "");
                }

                @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
                public String getStrPrompt() {
                    return JSONObject.this.optString("prompt", "");
                }
            };
        }

        public static b b(String str) {
            b c16 = c(str);
            c16.f215491b = b.d(c16.f215490a);
            if (c16.f()) {
                c16.f215492c = null;
                if (QLog.isColorLevel()) {
                    QLog.d("QQGuildCoverUploader", 2, "parseFromResponse success");
                }
            } else if (c16.f215490a == 1001) {
                c16.f215492c = null;
                if (QLog.isColorLevel()) {
                    QLog.d("QQGuildCoverUploader", 2, "parseFromResponse fail... code=", Integer.valueOf(c16.f215490a));
                }
            }
            return c16;
        }

        private static b c(String str) {
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("retcode", -1);
                String optString = jSONObject.optString("msg", "");
                if (optInt != 0 && optString.equalsIgnoreCase("success")) {
                    optInt = 0;
                }
                bVar.f215490a = optInt;
                bVar.f215491b = optString;
                bVar.f215492c = a(jSONObject);
                return bVar;
            } catch (JSONException unused) {
                bVar.f215490a = -1;
                bVar.f215491b = "\u89e3\u6790json\u5931\u8d25";
                return bVar;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UploadEndPoint f215485a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f215486b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f215487c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IUploadApi.b f215488d;

        a(UploadEndPoint uploadEndPoint, Map map, String str, IUploadApi.b bVar) {
            this.f215485a = uploadEndPoint;
            this.f215486b = map;
            this.f215487c = str;
            this.f215488d = bVar;
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            if (this.f215488d != null) {
                IUploadApi.d dVar = new IUploadApi.d();
                dVar.f230932b = 2;
                dVar.f230934d = str;
                this.f215488d.a(null, dVar);
            }
            QLog.e("QQGuildCoverUploader", 2, "\u83b7\u53d6PSKey\u5931\u8d25, [errMsg]=", str);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            String str;
            String str2 = map.get(FlockBaseRequest.QUN_DOMAIN);
            if (!TextUtils.isEmpty(str2)) {
                if (str2.length() >= 10) {
                    str = str2.substring(0, 10);
                } else {
                    str = str2;
                }
                IUploadApi.e eVar = new IUploadApi.e();
                eVar.f230935a = this.f215485a.getHost();
                eVar.f230939e = GuildCgiUploader.this.c(str, str2);
                eVar.f230936b = this.f215485a.getUrl();
                GuildCgiUploader guildCgiUploader = GuildCgiUploader.this;
                Map<String, String> d16 = guildCgiUploader.d(guildCgiUploader.f215482a, str);
                eVar.f230938d = d16;
                Map<? extends String, ? extends String> map2 = this.f215486b;
                if (map2 != null) {
                    d16.putAll(map2);
                }
                eVar.f230937c = this.f215487c;
                eVar.f230940f = this.f215488d;
                GuildCgiUploader.this.g();
                GuildCgiUploader.this.f215484c = ((IUploadApi) QRoute.api(IUploadApi.class)).startUploadTask(eVar);
                return;
            }
            if (this.f215488d != null) {
                IUploadApi.d dVar = new IUploadApi.d();
                dVar.f230932b = 2;
                dVar.f230934d = "\u4e0a\u4f20\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                this.f215488d.a(null, dVar);
            }
            QLog.e("QQGuildCoverUploader", 2, "\u83b7\u53d6PSKey\u56de\u8c03\u6210\u529f, \u83b7\u53d6\u503c\u4e3a\u7a7a");
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f215490a;

        /* renamed from: b, reason: collision with root package name */
        public String f215491b;

        /* renamed from: c, reason: collision with root package name */
        public IGProSecurityResult f215492c;

        public static b b(IUploadApi.d dVar) {
            b bVar = new b();
            int i3 = dVar.f230932b;
            bVar.f215490a = i3;
            bVar.f215491b = d(i3);
            bVar.f215492c = null;
            return bVar;
        }

        public static b c(String str) {
            return UploadResultParser.b(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String d(int i3) {
            if (i3 == 0) {
                return "\u4e0a\u4f20\u6210\u529f";
            }
            if (i3 == 1001) {
                return "\u4e0a\u4f20\u5931\u8d25\uff0c\u8d85\u8fc7\u4fee\u6539\u6b21\u6570\u4e0a\u9650";
            }
            if (i3 == -1 || (i3 != 1009 && i3 != 108203 && i3 != 1012)) {
                return "\u4e0a\u4f20\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            }
            return "\u670d\u52a1\u5668\u5347\u7ea7\u7ef4\u62a4\uff0c\u6682\u4e0d\u652f\u6301\u4fee\u6539";
        }

        public boolean e() {
            return !ch.p(this.f215492c);
        }

        public boolean f() {
            if (this.f215490a == 0 && ch.p(this.f215492c)) {
                return true;
            }
            return false;
        }

        @NonNull
        public String toString() {
            return "UploadResult{code=" + this.f215490a + ", message='" + this.f215491b + "', securityResult=" + this.f215492c + '}';
        }
    }

    public GuildCgiUploader(String str, String str2) {
        this.f215483b = str;
        this.f215482a = str2;
    }

    private int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i3 = 5381;
        for (int i16 = 0; i16 < str.length(); i16++) {
            i3 += (i3 << 5) + str.charAt(i16);
        }
        return Integer.MAX_VALUE & i3;
    }

    public List<IUploadApi.a> c(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IUploadApi.a("uin", this.f215483b));
        arrayList.add(new IUploadApi.a("skey", str));
        arrayList.add(new IUploadApi.a(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN, this.f215483b));
        arrayList.add(new IUploadApi.a("p_skey", str2));
        return arrayList;
    }

    public Map<String, String> d(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("bkn", String.valueOf(e(str2)));
        hashMap.put("groupProId", str);
        return hashMap;
    }

    public void f(String str, UploadEndPoint uploadEndPoint, Map<String, String> map, IUploadApi.b bVar) {
        ((IPskeyManager) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{FlockBaseRequest.QUN_DOMAIN}, new a(uploadEndPoint, map, str, bVar));
    }

    public void g() {
        IUploadApi.c cVar = this.f215484c;
        if (cVar != null) {
            cVar.b();
        }
        this.f215484c = null;
    }
}
