package com.tencent.open.agent.auth.model;

import android.util.Base64;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.agent.util.o;
import com.tencent.open.agent.util.t;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import java.io.FileInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VirtualCreatorDataSourceImpl implements f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements fp3.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ fp3.d f340134a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f340135b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f340136c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f340137d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f340138e;

        a(fp3.d dVar, String str, String str2, JSONObject jSONObject, boolean z16) {
            this.f340134a = dVar;
            this.f340135b = str;
            this.f340136c = str2;
            this.f340137d = jSONObject;
            this.f340138e = z16;
        }

        @Override // fp3.d
        public boolean a(boolean z16, String str, int i3, String str2) {
            if (this.f340134a.a(z16, str, i3, str2)) {
                VirtualCreatorDataSourceImpl.this.d(this.f340135b, this.f340136c, this.f340137d, this.f340138e, this.f340134a);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, JSONObject jSONObject, boolean z16, fp3.d dVar) {
        OpenSdkVirtualUtil.e("oidb_0xc7f_25", str2, str, jSONObject.toString(), new a(dVar, str, str2, jSONObject, z16), z16);
    }

    @Override // com.tencent.open.agent.auth.model.f
    public boolean a(String str, String str2, String str3, String str4, boolean z16, fp3.d dVar) {
        JSONObject jSONObject = new JSONObject();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str2);
                try {
                    int available = fileInputStream2.available();
                    byte[] bArr = new byte[available];
                    fileInputStream2.read(bArr);
                    String encodeToString = Base64.encodeToString(bArr, 2);
                    t.b("VirtualCreatorDataSourceImpl", "OpenVirtual.uploadAvatarImage.origin length=", Integer.valueOf(available), ", base64.length:", Integer.valueOf(encodeToString.length()));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("enum_img_style", 4);
                    jSONObject2.put("enmu_img_fmt", 3);
                    jSONObject2.put("uint32_img_size", available);
                    jSONObject2.put("bytes_img_data", encodeToString);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("uint32_is_from_pc", 0);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.mo162put(jSONObject2);
                    jSONObject3.put("msg_img_meta", jSONArray);
                    jSONObject.put("uint64_service_uin", o.c(str3));
                    jSONObject.put("uint32_service_uin_type", 1);
                    jSONObject.put("uint32_op_type", 1);
                    jSONObject.put("uint32_current_or_history", 1);
                    jSONObject.put("msg_img_data", jSONObject3);
                    d(str3, str4, jSONObject, z16, dVar);
                    com.tencent.open.agent.util.h.a(fileInputStream2);
                    return true;
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = fileInputStream2;
                    t.d("VirtualCreatorDataSourceImpl", "uploadAvatarImage.e:", e);
                    com.tencent.open.agent.util.h.a(fileInputStream);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    com.tencent.open.agent.util.h.a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    @Override // com.tencent.open.agent.auth.model.f
    public void b(final long j3, final String str, final String str2, final com.tencent.open.model.a aVar, final boolean z16, final fp3.d dVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.agent.auth.model.VirtualCreatorDataSourceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("uint64_appid", j3);
                    jSONObject.put("str_nick", str);
                    jSONObject.put("str_head_id", str2);
                } catch (JSONException e16) {
                    t.a("VirtualCreatorDataSourceImpl", "createVirtual.e:", e16);
                }
                OpenSdkVirtualUtil.e("oidb_0xd17_1", String.valueOf(j3), aVar.f341678a, jSONObject.toString(), dVar, z16);
            }
        }, 128, null, true);
    }
}
