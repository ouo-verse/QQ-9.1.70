package com.qq.e.comm.plugin.base.ad.clickcomponent.a;

import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements NetworkCallBack {

    /* renamed from: a, reason: collision with root package name */
    protected String f38525a;

    /* renamed from: b, reason: collision with root package name */
    protected InterfaceC0279a f38526b;

    /* renamed from: c, reason: collision with root package name */
    private int f38527c;

    /* compiled from: P */
    /* renamed from: com.qq.e.comm.plugin.base.ad.clickcomponent.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0279a {
        void a(int i3, JSONObject jSONObject);

        void a(Exception exc);
    }

    public a(String str) {
        this.f38525a = str;
    }

    public void a(InterfaceC0279a interfaceC0279a) {
        this.f38526b = interfaceC0279a;
    }

    @Override // com.qq.e.comm.net.NetworkCallBack
    public void onException(Exception exc) {
        GDTLogger.i("CGI " + hashCode() + " onException ");
        int i3 = this.f38527c;
        if (i3 > 0) {
            this.f38527c = i3 - 1;
            a();
        } else {
            InterfaceC0279a interfaceC0279a = this.f38526b;
            if (interfaceC0279a != null) {
                interfaceC0279a.a(exc);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0068 A[ADDED_TO_REGION] */
    @Override // com.qq.e.comm.net.NetworkCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResponse(Request request, Response response) {
        int i3;
        InterfaceC0279a interfaceC0279a;
        GDTLogger.i("CGI " + hashCode() + " onResponse ");
        int statusCode = response.getStatusCode();
        JSONObject jSONObject = null;
        if (statusCode == 200 || statusCode == 302) {
            try {
                String stringContent = response.getStringContent();
                if (!StringUtil.isEmpty(stringContent)) {
                    JSONObject jSONObject2 = new JSONObject(stringContent);
                    try {
                        GDTLogger.i("CGI response result: " + jSONObject2.toString());
                        jSONObject = jSONObject2;
                    } catch (JSONException unused) {
                        jSONObject = jSONObject2;
                        GDTLogger.e("JSONExceptionWhileParseClickADResponse");
                        i3 = this.f38527c;
                        if (i3 <= 0) {
                        }
                        interfaceC0279a = this.f38526b;
                        if (interfaceC0279a != null) {
                        }
                    } catch (Throwable unused2) {
                        jSONObject = jSONObject2;
                        GDTLogger.e("JSONExceptionWhileParseClickADResponse");
                        i3 = this.f38527c;
                        if (i3 <= 0) {
                        }
                        interfaceC0279a = this.f38526b;
                        if (interfaceC0279a != null) {
                        }
                    }
                }
            } catch (JSONException unused3) {
            } catch (Throwable unused4) {
            }
        }
        i3 = this.f38527c;
        if (i3 <= 0 && statusCode != 200) {
            this.f38527c = i3 - 1;
            a();
        } else {
            interfaceC0279a = this.f38526b;
            if (interfaceC0279a != null) {
                interfaceC0279a.a(statusCode, jSONObject);
            }
        }
    }

    public void a() {
        GDTLogger.i("CGI " + hashCode() + " will to ping: " + this.f38525a);
        a(this.f38525a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        NetworkClientImpl.getInstance().submit(new PlainRequest(str, 1, (byte[]) null), 1, this);
    }
}
