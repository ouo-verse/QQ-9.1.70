package jv2;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f411005a;

    /* renamed from: b, reason: collision with root package name */
    private String f411006b;

    /* renamed from: c, reason: collision with root package name */
    private String f411007c;

    public b(String str, String str2, String str3) {
        this.f411005a = str2;
        this.f411006b = str;
        this.f411007c = str3;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("{");
        sb5.append("'");
        sb5.append("__json_message");
        sb5.append("':{");
        sb5.append("'");
        sb5.append("__msg_type");
        sb5.append("':'");
        sb5.append(this.f411006b);
        sb5.append("',");
        sb5.append("'");
        sb5.append("__event_id");
        sb5.append("':'");
        sb5.append(this.f411005a);
        sb5.append("',");
        if (this.f411007c.startsWith("{") && this.f411007c.endsWith("}")) {
            sb5.append("'");
            sb5.append("__params");
            sb5.append("':");
            sb5.append(this.f411007c);
            sb5.append("");
        } else {
            sb5.append("'");
            sb5.append("__params");
            sb5.append("':'");
            sb5.append(this.f411007c);
            sb5.append("'");
        }
        sb5.append("}}");
        Log.d("H5Message", sb5.toString());
        return sb5.toString();
    }
}
