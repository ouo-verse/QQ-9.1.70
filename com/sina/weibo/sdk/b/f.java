package com.sina.weibo.sdk.b;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class f extends c<Void, Void, String> {

    /* renamed from: ah, reason: collision with root package name */
    private com.sina.weibo.sdk.net.c<String> f61244ah;

    /* renamed from: ai, reason: collision with root package name */
    private Throwable f61245ai;

    /* renamed from: al, reason: collision with root package name */
    private Oauth2AccessToken f61246al;
    private String appKey;

    public f(String str, Oauth2AccessToken oauth2AccessToken, com.sina.weibo.sdk.net.c<String> cVar) {
        this.appKey = str;
        this.f61246al = oauth2AccessToken;
        this.f61244ah = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.b.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public String o() {
        try {
            e.a aVar = new e.a();
            aVar.url = "https://api.weibo.com/oauth2/access_token";
            return new com.sina.weibo.sdk.net.b().a(aVar.b(CommonConstant.ReqAccessTokenParam.CLIENT_ID, this.appKey).b(com.heytap.mcssdk.a.a.f36102l, this.appKey).b("grant_type", "refresh_token").b("refresh_token", this.f61246al.getRefreshToken()).i()).j();
        } catch (Throwable th5) {
            th5.printStackTrace();
            this.f61245ai = th5;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.b.c
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th5 = this.f61245ai;
        if (th5 != null) {
            com.sina.weibo.sdk.net.c<String> cVar = this.f61244ah;
            if (cVar != null) {
                cVar.onError(th5);
                return;
            }
            return;
        }
        com.sina.weibo.sdk.net.c<String> cVar2 = this.f61244ah;
        if (cVar2 != null) {
            cVar2.a(str2);
        }
    }
}
