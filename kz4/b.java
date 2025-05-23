package kz4;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends d {

    /* renamed from: h, reason: collision with root package name */
    public String f413522h;

    /* renamed from: i, reason: collision with root package name */
    public int f413523i;

    /* renamed from: j, reason: collision with root package name */
    public long f413524j;

    /* renamed from: k, reason: collision with root package name */
    public String f413525k;

    @Override // kz4.d
    public JSONObject c() {
        try {
            JSONObject c16 = super.c();
            if (c16 == null) {
                return null;
            }
            c16.put("eventId", this.f413522h);
            c16.put("eventType", this.f413523i);
            c16.put("eventTime", this.f413524j);
            String str = this.f413525k;
            if (str == null) {
                str = "";
            }
            c16.put("eventContent", str);
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
