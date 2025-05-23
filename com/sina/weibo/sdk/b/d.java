package com.sina.weibo.sdk.b;

import android.content.Context;
import com.sina.weibo.sdk.api.ChatObject;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.net.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class d extends c<Void, Void, String> {

    /* renamed from: af, reason: collision with root package name */
    private Context f61235af;

    /* renamed from: ag, reason: collision with root package name */
    private ChatObject f61236ag;

    /* renamed from: ah, reason: collision with root package name */
    private com.sina.weibo.sdk.net.c<String> f61237ah;

    /* renamed from: ai, reason: collision with root package name */
    private Throwable f61238ai;

    public d(Context context, ChatObject chatObject, com.sina.weibo.sdk.net.c<String> cVar) {
        this.f61235af = context;
        this.f61236ag = chatObject;
        this.f61237ah = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.b.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public String o() {
        AuthInfo a16 = com.sina.weibo.sdk.a.a();
        try {
            e.a aVar = new e.a();
            aVar.url = "http://i.open.t.sina.com.cn/mobilesdk/sendmessage.php";
            return new com.sina.weibo.sdk.net.b().a(aVar.b("app_key", a16.getAppKey()).b("platform", "2").b("android_pack", a16.getPackageName()).b("android_sign", a16.getHash()).b("display_name", this.f61236ag.content).b("image_url", this.f61236ag.image_url).b("url", this.f61236ag.url).b("summary", this.f61236ag.summary).i()).j();
        } catch (Throwable th5) {
            th5.printStackTrace();
            this.f61238ai = th5;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.b.c
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th5 = this.f61238ai;
        if (th5 != null) {
            com.sina.weibo.sdk.net.c<String> cVar = this.f61237ah;
            if (cVar != null) {
                cVar.onError(th5);
                return;
            }
            return;
        }
        com.sina.weibo.sdk.net.c<String> cVar2 = this.f61237ah;
        if (cVar2 != null) {
            cVar2.a(str2);
        }
    }
}
