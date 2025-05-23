package com.tencent.open.agent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OpenSdkFriendService {

    /* renamed from: j, reason: collision with root package name */
    protected static OpenSdkFriendService f339905j;

    /* renamed from: a, reason: collision with root package name */
    protected HttpCgiAsyncTask f339906a;

    /* renamed from: b, reason: collision with root package name */
    protected a f339907b;

    /* renamed from: c, reason: collision with root package name */
    protected long f339908c;

    /* renamed from: d, reason: collision with root package name */
    protected String f339909d;

    /* renamed from: e, reason: collision with root package name */
    protected String f339910e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.open.component.cache.database.b f339911f;

    /* renamed from: g, reason: collision with root package name */
    protected Bundle f339912g;

    /* renamed from: h, reason: collision with root package name */
    protected String f339913h;

    /* renamed from: i, reason: collision with root package name */
    protected String f339914i;

    /* compiled from: P */
    /* renamed from: com.tencent.open.agent.OpenSdkFriendService$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Handler f339915d;
        final /* synthetic */ OpenSdkFriendService this$0;

        @Override // java.lang.Runnable
        public void run() {
            Message.obtain(this.f339915d, 888802, this.this$0.d()).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class CheckAvatarUpdateCallback implements HttpCgiAsyncTask.a {
        protected CheckAvatarUpdateCallback() {
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void f(JSONObject jSONObject) {
            try {
                int i3 = jSONObject.getInt("ret");
                String string = jSONObject.getString("msg");
                if (i3 == 0) {
                    final JSONArray jSONArray = jSONObject.getJSONArray("update_list");
                    final int length = jSONArray.length();
                    if (length > 0) {
                        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback.1
                            @Override // java.lang.Runnable
                            public void run() {
                                for (int i16 = 0; i16 < length; i16++) {
                                    try {
                                        gp3.e.a().d(gp3.f.a(OpenSdkFriendService.this.f339909d, jSONArray.getJSONObject(i16).getString("openid")));
                                    } catch (JSONException e16) {
                                        e16.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                    SharedPreferences.Editor edit = lq3.b.a(com.tencent.open.adapter.a.f().e(), "prefer_last_avatar_update_time").edit();
                    edit.putString(OpenSdkFriendService.this.f339910e, jSONObject.getString("time"));
                    edit.commit();
                    a aVar = OpenSdkFriendService.this.f339907b;
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                com.tencent.open.base.f.c("OpenSdkFriendService", "CheckAvatarUpdateCallback error. ret=" + i3 + ", msg=" + string);
            } catch (JSONException e16) {
                com.tencent.open.base.f.d("OpenSdkFriendService", "CheckAvatarUpdate Exception. " + e16.getMessage(), e16);
            }
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void onException(Exception exc) {
            com.tencent.open.base.f.d("OpenSdkFriendService", "CheckAvatarUpdate Exception. " + exc.getMessage(), exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class GetFriendListCallback implements HttpCgiAsyncTask.a {

        /* renamed from: d, reason: collision with root package name */
        protected final WeakReference<b> f339920d;

        public GetFriendListCallback(b bVar) {
            this.f339920d = new WeakReference<>(bVar);
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void f(JSONObject jSONObject) {
            final String str;
            gp3.d dVar = new gp3.d();
            try {
                dVar.f403032a = jSONObject.getInt("ret");
                dVar.f403033b = jSONObject.getString("msg");
                if (dVar.f403032a == 0) {
                    if (jSONObject.has("conc_max")) {
                        dVar.f403036e = jSONObject.getInt("conc_max");
                    }
                    if (jSONObject.has("inv_max") && jSONObject.has("inv_count")) {
                        dVar.f403034c = jSONObject.getInt("inv_max");
                        dVar.f403035d = jSONObject.getInt("inv_count");
                    }
                    if (jSONObject.has("fgmax") && jSONObject.has("fgcur")) {
                        dVar.f403034c = jSONObject.getInt("fgmax");
                        dVar.f403035d = jSONObject.getInt("fgcur");
                    }
                    com.tencent.open.base.f.a("OpenSdkFriendService", "-->result = " + jSONObject);
                    dVar.f403039h = jSONObject.optInt("app_rid", -1);
                    dVar.f403040i = jSONObject.optInt("app_tid", -1);
                    if ("action_invite".equals(OpenSdkFriendService.this.f339914i)) {
                        if (jSONObject.has("md5str")) {
                            str = jSONObject.getString("md5str");
                        } else {
                            str = null;
                        }
                        if (!lq3.b.a(com.tencent.open.adapter.a.f().e(), "invite_friend_list_md5").getString(OpenSdkFriendService.this.f339910e, "").equals(str)) {
                            final ArrayList<gp3.c> arrayList = (ArrayList) gp3.c.d(jSONObject);
                            dVar.f403037f = arrayList;
                            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.open.agent.OpenSdkFriendService.GetFriendListCallback.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if ("action_invite".equals(OpenSdkFriendService.this.f339914i)) {
                                        OpenSdkFriendService.this.g(arrayList);
                                        OpenSdkFriendService.this.h(str);
                                    }
                                }
                            });
                        } else {
                            ArrayList<gp3.c> d16 = OpenSdkFriendService.this.d();
                            dVar.f403037f = d16;
                            if (d16.size() == 0) {
                                OpenSdkFriendService.this.f339912g.putString("md5str", "0");
                                OpenSdkFriendService.this.h("0");
                                b bVar = this.f339920d.get();
                                if (bVar != null) {
                                    OpenSdkFriendService openSdkFriendService = OpenSdkFriendService.this;
                                    new HttpCgiAsyncTask(openSdkFriendService.f339913h, "GET", new GetFriendListCallback(bVar), true).b(OpenSdkFriendService.this.f339912g);
                                    return;
                                }
                                return;
                            }
                        }
                    } else {
                        if (!"action_gift".equals(OpenSdkFriendService.this.f339914i) && !"action_ask".equals(OpenSdkFriendService.this.f339914i) && !"action_voice".equals(OpenSdkFriendService.this.f339914i) && !"action_reactive".equals(OpenSdkFriendService.this.f339914i)) {
                            dVar.f403037f = (ArrayList) gp3.c.b(jSONObject);
                        }
                        dVar.f403037f = (ArrayList) gp3.c.c(jSONObject);
                    }
                    b bVar2 = this.f339920d.get();
                    if (bVar2 != null) {
                        bVar2.n2(dVar);
                        return;
                    }
                    return;
                }
                dVar.f403038g = jSONObject;
                Intent intent = new Intent();
                intent.putExtra("key_error_code", dVar.f403032a);
                intent.putExtra("key_error_msg", dVar.f403033b);
                intent.putExtra("key_error_detail", dVar.f403038g.toString());
                b bVar3 = this.f339920d.get();
                if (bVar3 != null) {
                    bVar3.S1(intent);
                }
            } catch (Exception e16) {
                onException(e16);
            }
        }

        @Override // com.tencent.open.base.http.HttpCgiAsyncTask.a
        public void onException(Exception exc) {
            com.tencent.open.base.f.d("OpenSdkFriendService", "GetFriendListCallback exception." + exc.getMessage(), exc);
            Intent intent = new Intent();
            if (exc instanceof ConnectTimeoutException) {
                intent.putExtra("key_error_code", -7);
                intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341057e);
            } else if (exc instanceof SocketTimeoutException) {
                intent.putExtra("key_error_code", -8);
                intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341058f);
            } else if (exc instanceof MalformedURLException) {
                intent.putExtra("key_error_code", -3);
                intent.putExtra("key_error_msg", "\u8bbf\u95eeurl\u6709\u8bef!");
            } else if (exc instanceof HttpBaseUtil.HttpStatusException) {
                intent.putExtra("key_error_code", -10);
                intent.putExtra("key_error_msg", "Http\u8fd4\u56de\u7801\u5f02\u5e38!");
            } else if (exc instanceof HttpBaseUtil.NetworkUnavailableException) {
                intent.putExtra("key_error_code", -9);
                intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341059g);
            } else if (exc instanceof JSONException) {
                intent.putExtra("key_error_code", -4);
                intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341054b);
            } else if (exc instanceof IOException) {
                intent.putExtra("key_error_code", -2);
                intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341053a);
            } else {
                intent.putExtra("key_error_code", -6);
                intent.putExtra("key_error_msg", com.tencent.open.business.base.b.f341056d);
            }
            b bVar = this.f339920d.get();
            if (bVar != null) {
                bVar.S1(intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void S1(Intent intent);

        void n2(gp3.d dVar);
    }

    public static synchronized OpenSdkFriendService c() {
        OpenSdkFriendService openSdkFriendService;
        synchronized (OpenSdkFriendService.class) {
            if (f339905j == null) {
                f339905j = new OpenSdkFriendService();
            }
            openSdkFriendService = f339905j;
        }
        return openSdkFriendService;
    }

    public void a(String str, Bundle bundle, a aVar) {
        this.f339907b = aVar;
        bundle.putString("time", lq3.b.a(com.tencent.open.adapter.a.f().e(), "prefer_last_avatar_update_time").getString(this.f339910e, "0"));
        new HttpCgiAsyncTask(str, "GET", new CheckAvatarUpdateCallback(), true).b(bundle);
    }

    public void b(Bundle bundle, b bVar, String str) {
        String a16;
        if (bundle != null && bVar != null) {
            this.f339912g = bundle;
            this.f339914i = str;
            if ("action_invite".equals(str)) {
                a16 = lq3.c.c().a("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
                bundle.putString("md5str", lq3.b.a(com.tencent.open.adapter.a.f().e(), "invite_friend_list_md5").getString(this.f339910e, ""));
            } else if ("action_story".equals(str)) {
                a16 = lq3.c.c().a("https://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
                bundle.putString("needhttpcache", "nothing");
            } else if ("action_voice".equals(str)) {
                a16 = lq3.c.c().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
            } else if ("action_reactive".equals(str)) {
                a16 = lq3.c.c().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
            } else {
                a16 = lq3.c.c().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
            }
            this.f339913h = a16;
            HttpCgiAsyncTask httpCgiAsyncTask = new HttpCgiAsyncTask(a16, "GET", new GetFriendListCallback(bVar), true);
            this.f339906a = httpCgiAsyncTask;
            httpCgiAsyncTask.b(bundle);
            return;
        }
        com.tencent.open.base.f.c("OpenSdkFriendService", "getFriendListAsync params error. params=" + bundle + "; listener=" + bVar);
    }

    public ArrayList<gp3.c> d() {
        com.tencent.open.component.cache.database.b bVar = this.f339911f;
        if (bVar == null) {
            return new ArrayList<>(0);
        }
        int y16 = bVar.y();
        ArrayList<gp3.c> arrayList = new ArrayList<>(y16);
        for (int i3 = 0; i3 < y16; i3++) {
            arrayList.add((gp3.c) this.f339911f.z(i3));
        }
        return arrayList;
    }

    public synchronized void e(String str, String str2) {
        if (str != null && str2 != null) {
            this.f339908c = Long.parseLong(lq3.b.a(com.tencent.open.adapter.a.f().e(), "uin_openid_store").getString(str2, ""));
            this.f339909d = str;
            this.f339910e = str2;
            try {
                this.f339911f = rp3.a.a().a(gp3.c.class, this.f339908c, "invite_friend_list_" + this.f339910e);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return;
        }
        com.tencent.open.base.f.c("OpenSdkFriendService", "initData error. appid=" + str + "; openid=" + str2);
    }

    public void f() {
        this.f339907b = null;
        HttpCgiAsyncTask httpCgiAsyncTask = this.f339906a;
        if (httpCgiAsyncTask != null) {
            httpCgiAsyncTask.i();
        }
    }

    public void g(List<gp3.c> list) {
        if (this.f339911f == null) {
            return;
        }
        gp3.c[] cVarArr = new gp3.c[list.size()];
        list.toArray(cVarArr);
        this.f339911f.B(cVarArr, 2);
    }

    protected void h(String str) {
        if ("action_invite".equals(this.f339914i)) {
            SharedPreferences.Editor edit = lq3.b.a(com.tencent.open.adapter.a.f().e(), "invite_friend_list_md5").edit();
            edit.putString(this.f339910e, str);
            edit.commit();
        }
    }
}
