package com.tencent.open.base.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.agent.util.g;
import com.tencent.open.base.http.d;
import com.tencent.open.model.AccountManage;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AvatarUpdateService implements d.a {

    /* renamed from: f, reason: collision with root package name */
    private static AvatarUpdateService f340976f;

    /* renamed from: e, reason: collision with root package name */
    protected SharedPreferences f340978e = MobileQQ.sMobileQQ.getSharedPreferences("uin_avatarurl", 0);

    /* renamed from: d, reason: collision with root package name */
    protected HashMap<String, a> f340977d = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<Context> f340987a;

        /* renamed from: b, reason: collision with root package name */
        public String f340988b;

        /* renamed from: c, reason: collision with root package name */
        public String f340989c;

        /* renamed from: d, reason: collision with root package name */
        public String f340990d;

        /* renamed from: e, reason: collision with root package name */
        public WeakReference<d.a> f340991e;

        public a(Context context, String str, String str2, String str3, d.a aVar) {
            this.f340987a = new WeakReference<>(context);
            this.f340988b = str;
            this.f340989c = str2;
            this.f340990d = str3;
            this.f340991e = new WeakReference<>(aVar);
        }
    }

    protected AvatarUpdateService() {
    }

    public static AvatarUpdateService a() {
        synchronized (AvatarUpdateService.class) {
            if (f340976f == null) {
                f340976f = new AvatarUpdateService();
            }
        }
        return f340976f;
    }

    protected void b(Bitmap bitmap, String str) throws IOException {
        File createNewFile;
        if (bitmap == null || (createNewFile = BaseImageUtil.createNewFile(str)) == null) {
            return;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(createNewFile);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public void c(final Context context, final String str, String str2, final d.a aVar) {
        QLog.d("AvatarUpdateService", 1, "-->updateAvatar--uin = " + g.C(str));
        final String str3 = "https://openmobile.qq.com/getface?appid=716027609&imgtype=3&encrytype=0&devtype=0&keytype=0&uin=" + str;
        final String n3 = OpenSdkVirtualUtil.n(str);
        cq3.b.f391646a.f(str, "openmobile.qq.com", str2, false, new AccountManage.g() { // from class: com.tencent.open.base.http.AvatarUpdateService.1
            @Override // com.tencent.open.model.AccountManage.g
            public void onFail(int i3, String str4) {
                QLog.e("AvatarUpdateService", 1, "updateAvatar, getPskey fail, errCode = " + i3 + ", errMsg" + str4);
            }

            @Override // com.tencent.open.model.AccountManage.g
            public void onSuccess(String str4) {
                StringBuilder sb5 = new StringBuilder(str);
                while (sb5.length() < 10) {
                    sb5.insert(0, "0");
                }
                sb5.insert(0, "o");
                final String str5 = "p_uin=" + ((Object) sb5) + "; p_skey=" + str4;
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.open.base.http.AvatarUpdateService.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HttpEntity entity;
                        String entityUtils;
                        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                        HttpEntity httpEntity = null;
                        try {
                            try {
                                try {
                                    HttpGet httpGet = new HttpGet(MsfSdkUtils.insertMtype("yingyongbao", str3));
                                    httpGet.addHeader("Cookie", str5);
                                    entity = defaultHttpClient.execute(httpGet).getEntity();
                                    entityUtils = EntityUtils.toString(entity, "utf-8");
                                } catch (Exception e16) {
                                    QLog.e("AvatarUpdateService", 1, "-->updateAvatar---", e16.getMessage());
                                    if (0 != 0) {
                                        httpEntity.getContent().close();
                                    } else {
                                        return;
                                    }
                                }
                                if (TextUtils.isEmpty(entityUtils)) {
                                    QLog.e("AvatarUpdateService", 1, "-->updateAvatar--jsonp is empty");
                                    if (entity != null) {
                                        try {
                                            entity.getContent().close();
                                            return;
                                        } catch (Exception e17) {
                                            QLog.e("AvatarUpdateService", 1, "-->updateAvatar---close. ", e17);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                int indexOf = entityUtils.indexOf(123);
                                int lastIndexOf = entityUtils.lastIndexOf(125);
                                if (indexOf >= 0 && indexOf <= lastIndexOf && lastIndexOf >= 0) {
                                    String string = new JSONObject(entityUtils.substring(indexOf, lastIndexOf + 1)).getString(str);
                                    if (TextUtils.isEmpty(string)) {
                                        QLog.e("AvatarUpdateService", 1, "-->updateAvatar--image url is empty");
                                        if (entity != null) {
                                            try {
                                                entity.getContent().close();
                                                return;
                                            } catch (Exception e18) {
                                                QLog.e("AvatarUpdateService", 1, "-->updateAvatar---close. ", e18);
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    String string2 = AvatarUpdateService.this.f340978e.getString(str, "");
                                    if (!FileUtils.fileExists(n3) || !string.equals(string2)) {
                                        QLog.d("AvatarUpdateService", 1, "-->updateAvatar--avatar not exist or need update, will download new avatar");
                                        synchronized (AvatarUpdateService.this.f340977d) {
                                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                            if (!AvatarUpdateService.this.f340977d.containsKey(str)) {
                                                AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                                AvatarUpdateService avatarUpdateService = AvatarUpdateService.this;
                                                HashMap<String, a> hashMap = avatarUpdateService.f340977d;
                                                String str6 = str;
                                                hashMap.put(str6, new a(context, str6, n3, string, aVar));
                                                AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                                                new d(str, string, null, "GET", AvatarUpdateService.this).execute(new Void[0]);
                                            }
                                        }
                                    }
                                    if (entity != null) {
                                        entity.getContent().close();
                                        return;
                                    }
                                    return;
                                }
                                QLog.e("AvatarUpdateService", 1, "-->updateAvatar--can not find json string");
                                if (entity != null) {
                                    try {
                                        entity.getContent().close();
                                    } catch (Exception e19) {
                                        QLog.e("AvatarUpdateService", 1, "-->updateAvatar---close. ", e19);
                                    }
                                }
                            } catch (Throwable th5) {
                                if (0 != 0) {
                                    try {
                                        httpEntity.getContent().close();
                                    } catch (Exception e26) {
                                        QLog.e("AvatarUpdateService", 1, "-->updateAvatar---close. ", e26);
                                    }
                                }
                                throw th5;
                            }
                        } catch (Exception e27) {
                            QLog.e("AvatarUpdateService", 1, "-->updateAvatar---close. ", e27);
                        }
                    }
                }, 5, null, true);
            }
        });
    }

    @Override // com.tencent.open.base.http.d.a
    public void r1(String str, Bitmap bitmap) {
        a aVar;
        Bitmap s16;
        boolean z16;
        synchronized (this.f340977d) {
            aVar = this.f340977d.get(str);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("-->onTaskCompleted--identifier = ");
            sb5.append(str);
            sb5.append(", bitmap = null ? ");
            boolean z17 = true;
            if (bitmap == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(", task = null ? ");
            if (aVar != null) {
                z17 = false;
            }
            sb5.append(z17);
            QLog.d("AvatarUpdateService", 2, sb5.toString());
        }
        if (aVar == null) {
            return;
        }
        Context context = aVar.f340987a.get();
        if (bitmap != null && context != null && (s16 = g.s(context, bitmap, 63, 63)) != null) {
            try {
                b(s16, aVar.f340989c);
                SharedPreferences.Editor edit = this.f340978e.edit();
                edit.putString(aVar.f340988b, aVar.f340990d);
                edit.commit();
            } catch (IOException unused) {
            }
            d.a aVar2 = aVar.f340991e.get();
            if (aVar2 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("AvatarUpdateService", 2, "-->onTaskCompleted--callback not null, invoke it");
                }
                aVar2.r1(str, s16);
            }
        }
        synchronized (this.f340977d) {
            this.f340977d.remove(str);
        }
    }
}
