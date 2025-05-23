package com.sina.weibo.sdk.b;

import android.content.Context;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class e extends c<Void, Void, String> {

    /* renamed from: af, reason: collision with root package name */
    private Context f61239af;

    /* renamed from: ah, reason: collision with root package name */
    private com.sina.weibo.sdk.net.c<String> f61240ah;

    /* renamed from: ai, reason: collision with root package name */
    private Throwable f61241ai;

    /* renamed from: aj, reason: collision with root package name */
    private String f61242aj;

    /* renamed from: ak, reason: collision with root package name */
    private String f61243ak;
    private String appKey;

    public e(Context context, String str, String str2, String str3, com.sina.weibo.sdk.net.c<String> cVar) {
        this.f61239af = context;
        this.f61242aj = str;
        this.appKey = str2;
        this.f61243ak = str3;
        this.f61240ah = cVar;
    }

    private String d(String str) {
        return HttpManager.a(this.f61239af, getAid(), this.f61243ak, this.appKey, str);
    }

    private String getAid() {
        return com.sina.weibo.sdk.c.e.f(this.f61239af, this.appKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.b.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public String o() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            e.a aVar = new e.a();
            aVar.url = "https://service.weibo.com/share/mobilesdk_uppic.php";
            return new com.sina.weibo.sdk.net.b().a(aVar.a("aid", getAid()).a("oauth_timestamp", valueOf).a("oauth_sign", d(valueOf)).b(com.heytap.mcssdk.a.a.f36102l, this.appKey).b("aid", getAid()).b("oauth_timestamp", valueOf).b("oauth_sign", d(valueOf)).b("img", this.f61242aj).i()).j();
        } catch (Throwable th5) {
            th5.printStackTrace();
            this.f61241ai = th5;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.b.c
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th5 = this.f61241ai;
        if (th5 != null) {
            com.sina.weibo.sdk.net.c<String> cVar = this.f61240ah;
            if (cVar != null) {
                cVar.onError(th5);
                return;
            }
            return;
        }
        com.sina.weibo.sdk.net.c<String> cVar2 = this.f61240ah;
        if (cVar2 != null) {
            cVar2.a(str2);
        }
    }
}
