package kz4;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends d {

    /* renamed from: h, reason: collision with root package name */
    public int f413526h;

    /* renamed from: i, reason: collision with root package name */
    public long f413527i = -1;

    /* renamed from: j, reason: collision with root package name */
    public long f413528j = -1;

    public static c e() {
        return new c();
    }

    @Override // kz4.d
    public JSONObject c() {
        try {
            JSONObject c16 = super.c();
            if (c16 == null) {
                return null;
            }
            c16.put("code", this.f413526h);
            c16.put("perfCounts", this.f413527i);
            c16.put("perfLatencies", this.f413528j);
            return c16;
        } catch (JSONException e16) {
            jz4.c.q(e16);
            return null;
        }
    }

    @Override // kz4.d
    public String d() {
        return super.d();
    }
}
