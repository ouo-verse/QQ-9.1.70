package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.b.b;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.web.b.b;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class d extends b {
    public WeiboMultiMessage aK;
    private byte[] aL;
    String aM;

    /* renamed from: ak, reason: collision with root package name */
    public String f61292ak;
    public String packageName;
    private String text;

    public d(AuthInfo authInfo) {
        super(authInfo, 1, null, null);
    }

    @Override // com.sina.weibo.sdk.web.b.b
    protected final void a(Bundle bundle) {
        WeiboMultiMessage weiboMultiMessage = this.aK;
        if (weiboMultiMessage != null) {
            weiboMultiMessage.writeToBundle(bundle);
        }
        bundle.putString("token", this.f61292ak);
        bundle.putString("packageName", this.packageName);
    }

    @Override // com.sina.weibo.sdk.web.b.b
    protected final void b(Bundle bundle) {
        byte[] bArr;
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        this.aK = weiboMultiMessage;
        weiboMultiMessage.readFromBundle(bundle);
        this.f61292ak = bundle.getString("token");
        this.packageName = bundle.getString("packageName");
        StringBuilder sb5 = new StringBuilder();
        TextObject textObject = this.aK.textObject;
        if (textObject != null) {
            sb5.append(textObject.text);
        }
        ImageObject imageObject = this.aK.imageObject;
        if (imageObject != null) {
            String str = imageObject.imagePath;
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists() && file.canRead() && file.length() > 0) {
                    byte[] bArr2 = new byte[(int) file.length()];
                    FileInputStream fileInputStream = null;
                    try {
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(file);
                            try {
                                fileInputStream2.read(bArr2);
                                this.aL = e.b(bArr2);
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            } catch (Exception e17) {
                                e = e17;
                                fileInputStream = fileInputStream2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                bArr = imageObject.imageData;
                                if (bArr != null) {
                                    this.aL = e.b(bArr);
                                }
                                this.text = sb5.toString();
                            } catch (Throwable th5) {
                                th = th5;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e19) {
                                        e19.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Exception e26) {
                        e = e26;
                    }
                }
            }
            bArr = imageObject.imageData;
            if (bArr != null && bArr.length > 0) {
                this.aL = e.b(bArr);
            }
        }
        this.text = sb5.toString();
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final String getUrl() {
        Uri.Builder buildUpon = Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
        buildUpon.appendQueryParameter("title", this.text);
        buildUpon.appendQueryParameter("version", "0041005000");
        String appKey = this.aI.a().getAppKey();
        if (!TextUtils.isEmpty(appKey)) {
            buildUpon.appendQueryParameter("source", appKey);
        }
        if (!TextUtils.isEmpty(this.f61292ak)) {
            buildUpon.appendQueryParameter(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, this.f61292ak);
        }
        String f16 = e.f(this.f61291af, appKey);
        if (!TextUtils.isEmpty(f16)) {
            buildUpon.appendQueryParameter("aid", f16);
        }
        if (!TextUtils.isEmpty(this.packageName)) {
            buildUpon.appendQueryParameter("packagename", this.packageName);
        }
        if (!TextUtils.isEmpty(this.aM)) {
            buildUpon.appendQueryParameter("picinfo", this.aM);
        }
        buildUpon.appendQueryParameter("luicode", "10000360");
        buildUpon.appendQueryParameter("lfid", "OP_" + appKey);
        return buildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final boolean w() {
        byte[] bArr = this.aL;
        if (bArr != null && bArr.length > 0) {
            return true;
        }
        return super.w();
    }

    public d(Context context) {
        this.f61291af = context;
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final void a(final b.a aVar) {
        com.sina.weibo.sdk.b.b bVar;
        com.sina.weibo.sdk.b.e eVar = new com.sina.weibo.sdk.b.e(this.f61291af, new String(this.aL), this.aI.a().getAppKey(), this.f61292ak, new com.sina.weibo.sdk.net.c<String>() { // from class: com.sina.weibo.sdk.web.b.d.1
            @Override // com.sina.weibo.sdk.net.c
            public final /* synthetic */ void a(String str) {
                String str2 = str;
                com.sina.weibo.sdk.c.c.a("WbShareTag", "handle image result :" + str2);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        int optInt = jSONObject.optInt("code");
                        String optString = jSONObject.optString("data");
                        if (optInt == 1 && !TextUtils.isEmpty(optString)) {
                            d.this.aM = optString;
                            b.a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.onComplete();
                                return;
                            }
                            return;
                        }
                        b.a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.onError("\u56fe\u7247\u5185\u5bb9\u4e0d\u5408\u9002\uff0c\u7981\u6b62\u4e0a\u4f20\uff01");
                            return;
                        }
                        return;
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        b.a aVar4 = aVar;
                        if (aVar4 != null) {
                            aVar4.onError("\u89e3\u6790\u670d\u52a1\u7aef\u8fd4\u56de\u7684\u5b57\u7b26\u4e32\u65f6\u53d1\u751f\u5f02\u5e38\uff01");
                            return;
                        }
                        return;
                    }
                }
                b.a aVar5 = aVar;
                if (aVar5 != null) {
                    aVar5.onError("\u5904\u7406\u56fe\u7247\uff0c\u670d\u52a1\u7aef\u8fd4\u56denull!");
                }
            }

            @Override // com.sina.weibo.sdk.net.c
            public final void onError(Throwable th5) {
                b.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onError(th5.getMessage());
                }
            }
        });
        bVar = b.a.Q;
        bVar.a(eVar);
    }
}
