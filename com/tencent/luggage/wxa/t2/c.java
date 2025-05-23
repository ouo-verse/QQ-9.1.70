package com.tencent.luggage.wxa.t2;

import com.tencent.luggage.wxa.xd.i;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f140841a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c {
        @Override // com.tencent.luggage.wxa.t2.c
        public boolean a(String str, i iVar, JSONObject jSONObject) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.t2.c
        public void a(i iVar, b bVar) {
            if (bVar != null) {
                bVar.a(-1, "fail:not supported");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(int i3, String str);
    }

    void a(i iVar, b bVar);

    boolean a(String str, i iVar, JSONObject jSONObject);
}
