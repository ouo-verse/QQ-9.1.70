package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import com.tencent.mobileqq.app.BusinessObserver;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class bn implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<Activity> f292106d;

    public bn(Activity activity) {
        this.f292106d = new WeakReference<>(activity);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4 && obj != null) {
                        Object[] objArr = (Object[]) obj;
                        if (objArr.length == 1) {
                            c(((Integer) objArr[0]).intValue());
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (obj != null) {
                    Object[] objArr2 = (Object[]) obj;
                    if (objArr2.length == 1) {
                        try {
                            JSONObject jSONObject = (JSONObject) objArr2[0];
                            String optString = jSONObject.optString("url");
                            int optInt = jSONObject.optInt("ret");
                            String decode = URLDecoder.decode(optString, "UTF-8");
                            if (optInt == 0 && decode.length() > 0) {
                                a(z16, decode);
                            } else {
                                b(optInt + "", "", optInt);
                            }
                            return;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            b(e16.toString(), "", -1);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            d();
            return;
        }
        if (obj != null) {
            Object[] objArr3 = (Object[]) obj;
            if (objArr3.length == 3) {
                b((String) objArr3[0], (String) objArr3[1], ((Integer) objArr3[2]).intValue());
            }
        }
    }

    public void d() {
    }

    public void c(int i3) {
    }

    public void a(boolean z16, String str) {
    }

    public void b(String str, String str2, int i3) {
    }
}
