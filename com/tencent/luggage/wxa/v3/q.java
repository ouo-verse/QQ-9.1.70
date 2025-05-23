package com.tencent.luggage.wxa.v3;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.p004if.s;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.v3.r;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class q {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143188b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements DialogInterface.OnDismissListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.vo.a f143192a;

            public b(com.tencent.luggage.wxa.vo.a aVar) {
                this.f143192a = aVar;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                this.f143192a.g();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class c implements DialogInterface.OnCancelListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.vo.a f143194a;

            public c(com.tencent.luggage.wxa.vo.a aVar) {
                this.f143194a = aVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                this.f143194a.g();
            }
        }

        public a(com.tencent.luggage.wxa.ic.d dVar) {
            this.f143188b = dVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(com.tencent.luggage.wxa.ap.b bVar) {
            com.tencent.luggage.wxa.ml.m currentDialog;
            String str = (String) bVar.b();
            Bitmap bitmap = (Bitmap) bVar.c();
            com.tencent.luggage.wxa.ml.r b16 = q.b(this.f143188b);
            if (b16 == null) {
                currentDialog = null;
            } else {
                currentDialog = b16.getCurrentDialog();
            }
            if (currentDialog instanceof o) {
                o oVar = (o) currentDialog;
                oVar.a(bitmap);
                com.tencent.luggage.wxa.vo.a a16 = r.a(this.f143188b, str, new C6825a(currentDialog, com.tencent.luggage.wxa.xo.h.b()));
                oVar.setOnDismissListener(new b(a16));
                oVar.setOnCancelListener(new c(a16));
            } else {
                com.tencent.luggage.wxa.xo.h.a().a(new IllegalStateException("Invalid QRCodeDisplayDialog display state"));
            }
            return null;
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.v3.q$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6825a implements r.b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ml.m f143189a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143190b;

            public C6825a(com.tencent.luggage.wxa.ml.m mVar, com.tencent.luggage.wxa.xo.b bVar) {
                this.f143189a = mVar;
                this.f143190b = bVar;
            }

            @Override // com.tencent.luggage.wxa.v3.r.b
            public void a() {
                ((o) this.f143189a).g();
                this.f143190b.a("fail cancel");
            }

            @Override // com.tencent.luggage.wxa.v3.r.b
            public void b() {
                ((o) this.f143189a).h();
            }

            @Override // com.tencent.luggage.wxa.v3.r.b
            public void onCancelled() {
                this.f143190b.a("fail cancel");
                this.f143189a.dismiss();
            }

            @Override // com.tencent.luggage.wxa.v3.r.b
            public void a(String str) {
                this.f143190b.a(str);
                this.f143189a.dismiss();
            }

            @Override // com.tencent.luggage.wxa.v3.r.b
            public void a(Exception exc) {
                ((o) this.f143189a).f();
                this.f143190b.a("fail cancel");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143196b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f143197c;

        public b(com.tencent.luggage.wxa.ic.d dVar, h hVar) {
            this.f143196b = dVar;
            this.f143197c = hVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.ap.b call(String str) {
            if (!this.f143196b.isRunning()) {
                com.tencent.luggage.wxa.xo.h.a().a(new InterruptedException("env dead"));
                return null;
            }
            s a16 = s.b.a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", this.f143196b.getAppId());
                jSONObject.put("uuid", str);
                Response execute = com.tencent.luggage.wxa.n3.p.cgiClient().newCall(new Request.Builder().url("https://servicewechat.com/wxaruntime/getqrcode").post(RequestBody.create(com.tencent.luggage.wxa.n3.p.f135236e, jSONObject.toString())).build()).execute();
                try {
                    com.tencent.luggage.wxa.ap.b a17 = com.tencent.luggage.wxa.ap.j.a(str, a16.a(execute.body().byteStream(), null, new BitmapFactory.Options()));
                    execute.close();
                    return a17;
                } finally {
                }
            } catch (Exception e16) {
                w.b("Luggage.QRCodeTransfer", "invoke, get QRCode, api = %s, appId = %s, e = %s", this.f143197c.getName(), this.f143196b.getAppId(), e16);
                com.tencent.luggage.wxa.xo.h.a().a(e16);
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143198b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f143199c;

        public c(com.tencent.luggage.wxa.ic.d dVar, h hVar) {
            this.f143198b = dVar;
            this.f143199c = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [okhttp3.Response] */
        /* JADX WARN: Type inference failed for: r1v2 */
        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String call(JSONObject jSONObject) {
            Response response;
            com.tencent.luggage.wxa.ml.m currentDialog;
            ?? r16 = 0;
            try {
                try {
                    response = com.tencent.luggage.wxa.n3.p.cgiClient().newCall(new Request.Builder().url("https://servicewechat.com/wxaruntime/getuuid").post(RequestBody.create(com.tencent.luggage.wxa.n3.p.f135236e, jSONObject.toString())).build()).execute();
                } catch (Exception e16) {
                    e = e16;
                    response = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (r16 != 0) {
                    }
                    throw th;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(response.body().string());
                    int optInt = jSONObject2.optInt("ErrCode", 0);
                    if (optInt == 0) {
                        String optString = jSONObject2.optString("uuid");
                        if (!TextUtils.isEmpty(optString)) {
                            response.close();
                            return optString;
                        }
                        throw new IllegalArgumentException("Invalid UUID");
                    }
                    throw new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.TRANSFER, optInt, jSONObject2.optString("ErrMsg"));
                } catch (Exception e17) {
                    e = e17;
                    com.tencent.luggage.wxa.ml.r b16 = q.b(this.f143198b);
                    if (b16 == null) {
                        currentDialog = null;
                    } else {
                        currentDialog = b16.getCurrentDialog();
                    }
                    if (currentDialog instanceof o) {
                        ((o) currentDialog).f();
                    }
                    w.b("Luggage.QRCodeTransfer", "invoke, get UUID, api = %s, appId = %s, e = %s", this.f143199c.getName(), this.f143198b.getAppId(), e);
                    com.tencent.luggage.wxa.xo.h.a().a(e);
                    if (response != null) {
                        response.close();
                    }
                    return null;
                }
            } catch (Throwable th6) {
                th = th6;
                r16 = jSONObject;
                if (r16 != 0) {
                    r16.close();
                }
                throw th;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143200b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f143201c;

        public d(com.tencent.luggage.wxa.ic.d dVar, h hVar) {
            this.f143200b = dVar;
            this.f143201c = hVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JSONObject call(String str) {
            w.d("Luggage.QRCodeTransfer", "reqData:%s", str);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", this.f143200b.getAppId());
                jSONObject.put("req_data", str);
                return jSONObject;
            } catch (JSONException e16) {
                w.b("Luggage.QRCodeTransfer", "invoke, put fields api = %s, appId = %s, e = %s", this.f143201c.getName(), this.f143200b.getAppId(), e16);
                com.tencent.luggage.wxa.xo.h.a().a(e16);
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f143202b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143203c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f143204d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f143205e;

        public e(h hVar, com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
            this.f143202b = hVar;
            this.f143203c = dVar;
            this.f143204d = jSONObject;
            this.f143205e = i3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(Void r46) {
            com.tencent.luggage.wxa.xo.h.a((com.tencent.luggage.wxa.xo.e) this.f143202b.c(this.f143203c, this.f143204d, this.f143205e));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f143206b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f143207c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f143208d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f143209a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ o f143210b;

            public a(com.tencent.luggage.wxa.xo.b bVar, o oVar) {
                this.f143209a = bVar;
                this.f143210b = oVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f143209a.a("fail cancel");
                this.f143210b.dismiss();
            }
        }

        public f(com.tencent.luggage.wxa.ic.d dVar, h hVar, JSONObject jSONObject) {
            this.f143206b = dVar;
            this.f143207c = hVar;
            this.f143208d = jSONObject;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(Void r65) {
            com.tencent.luggage.wxa.ml.r b16 = q.b(this.f143206b);
            if (b16 == null) {
                com.tencent.luggage.wxa.xo.h.a().a(new IllegalStateException("Invalid env state"));
                return null;
            }
            com.tencent.luggage.wxa.xo.b a16 = com.tencent.luggage.wxa.xo.h.a();
            o oVar = new o(this.f143206b.getContext());
            oVar.a(this.f143207c, this.f143206b, this.f143208d);
            oVar.a(new a(a16, oVar));
            b16.a(oVar);
            return null;
        }
    }

    public static com.tencent.luggage.wxa.ml.r b(com.tencent.luggage.wxa.ic.d dVar) {
        if (dVar.getRuntime() == null) {
            return null;
        }
        return dVar.getRuntime().H();
    }

    public static com.tencent.luggage.wxa.xo.d a(com.tencent.luggage.wxa.ic.d dVar, h hVar, JSONObject jSONObject, int i3) {
        return com.tencent.luggage.wxa.xo.h.c().a(new f(dVar, hVar, jSONObject)).c(new e(hVar, dVar, jSONObject, i3)).c(new d(dVar, hVar)).c(new c(dVar, hVar)).b(new b(dVar, hVar)).a(new a(dVar));
    }
}
