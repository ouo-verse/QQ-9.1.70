package bu1;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.group_pro_proto.common.common$Event;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static String f29140d = "GuildMsgEventVersionItem";

    /* renamed from: e, reason: collision with root package name */
    private static long f29141e;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<b> f29142a;

    /* renamed from: b, reason: collision with root package name */
    public long f29143b;

    /* renamed from: c, reason: collision with root package name */
    private final Comparator<b> f29144c;

    /* compiled from: P */
    /* renamed from: bu1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C0151a implements Comparator {
        C0151a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj != null && obj2 != null) {
                long j3 = ((b) obj).f29146a;
                long j16 = ((b) obj2).f29146a;
                if (j3 == j16) {
                    return 0;
                }
                if (j3 <= j16) {
                    return -1;
                }
                return 1;
            }
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj2 == null) {
                return -1;
            }
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f29146a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f29147b = a.f29141e;

        /* renamed from: c, reason: collision with root package name */
        public long f29148c = a.f29141e;

        /* renamed from: d, reason: collision with root package name */
        public long f29149d = a.f29141e;

        /* renamed from: e, reason: collision with root package name */
        public long f29150e = a.f29141e;

        /* renamed from: f, reason: collision with root package name */
        public long f29151f = a.f29141e;

        /* renamed from: g, reason: collision with root package name */
        public long f29152g = a.f29141e;

        public String toString() {
            return "VersionItem{type=" + this.f29146a + ", localVersion=" + this.f29147b + ", latestVersion=" + this.f29148c + ", operatorRole=" + this.f29149d + ", operatorTid=" + this.f29150e + ", operatorTime=" + this.f29151f + ", operatorAtType=" + this.f29152g + '}';
        }
    }

    public a() {
        this.f29142a = new ArrayList<>();
        this.f29143b = 0L;
        this.f29144c = new C0151a();
    }

    private boolean b(long j3) {
        if (j3 != 1 && j3 != 2 && j3 != 5 && j3 != 4 && j3 != 6 && j3 != 3) {
            return false;
        }
        return true;
    }

    public static a c(String str) {
        long j3;
        long j16;
        long j17;
        long j18;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("versions");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                b bVar = new b();
                bVar.f29146a = jSONObject2.getLong("type");
                bVar.f29147b = jSONObject2.getLong("localVersion");
                bVar.f29148c = jSONObject2.getLong("latestVersion");
                if (jSONObject2.has("operatorRole")) {
                    j3 = jSONObject2.getLong("operatorRole");
                } else {
                    j3 = f29141e;
                }
                bVar.f29149d = j3;
                if (jSONObject2.has("operatorTid")) {
                    j16 = jSONObject2.getLong("operatorTid");
                } else {
                    j16 = f29141e;
                }
                bVar.f29150e = j16;
                if (jSONObject2.has("operatorTime")) {
                    j17 = jSONObject2.getLong("operatorTime");
                } else {
                    j17 = f29141e;
                }
                bVar.f29151f = j17;
                if (jSONObject2.has("operatorAtType")) {
                    j18 = jSONObject2.getLong("operatorAtType");
                } else {
                    j18 = f29141e;
                }
                bVar.f29152g = j18;
                aVar.f29142a.add(bVar);
            }
            aVar.f29143b = jSONObject.getLong("syncTime");
            return aVar;
        } catch (Exception e16) {
            QLog.e(f29140d, 1, e16.getMessage());
            return null;
        }
    }

    public static boolean g(long j3) {
        if (j3 != 6 && j3 != 3) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        if (r1.f29148c >= r2.f29148c) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b d() {
        Iterator<b> it = this.f29142a.iterator();
        b bVar = null;
        while (it.hasNext()) {
            b next = it.next();
            long j3 = next.f29146a;
            if (j3 == 1 || j3 == 2 || j3 == 6 || j3 == 3) {
                bVar = next;
            }
        }
        return bVar;
    }

    public long e() {
        Iterator<b> it = this.f29142a.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            b next = it.next();
            if (b(next.f29146a)) {
                long j16 = next.f29147b;
                if (j3 < j16) {
                    j3 = j16;
                }
            }
        }
        return j3;
    }

    public b f(long j3) {
        Iterator<b> it = this.f29142a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f29146a == j3) {
                return next;
            }
        }
        return null;
    }

    public boolean h() {
        Iterator<b> it = this.f29142a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (b(next.f29146a) && next.f29147b < next.f29148c) {
                return true;
            }
        }
        return false;
    }

    public String i() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f29142a, this.f29144c);
            Iterator<b> it = this.f29142a.iterator();
            while (it.hasNext()) {
                b next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", next.f29146a);
                jSONObject2.put("localVersion", next.f29147b);
                jSONObject2.put("latestVersion", next.f29148c);
                jSONObject2.put("operatorRole", next.f29149d);
                jSONObject2.put("operatorTid", next.f29150e);
                jSONObject2.put("operatorTime", next.f29151f);
                jSONObject2.put("operatorAtType", next.f29152g);
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("versions", jSONArray);
            jSONObject.put("syncTime", this.f29143b);
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e(f29140d, 1, e16.getMessage());
            return "";
        }
    }

    public String toString() {
        return "GuildMsgEventInfo{versions=" + this.f29142a + ", syncTime=" + this.f29143b + '}';
    }

    public a(List<common$Event> list) {
        this.f29142a = new ArrayList<>();
        this.f29143b = 0L;
        this.f29144c = new C0151a();
        if (list != null) {
            for (common$Event common_event : list) {
                b bVar = new b();
                bVar.f29146a = common_event.type.get();
                bVar.f29148c = common_event.version.get();
                bVar.f29149d = common_event.op_info.operator_role.get();
                bVar.f29150e = common_event.op_info.operator_tinyid.get();
                bVar.f29151f = common_event.op_info.timestamp.get();
                bVar.f29152g = common_event.op_info.at_type.get();
                this.f29142a.add(bVar);
            }
        }
    }

    public a(List<common$Event> list, long j3) {
        this.f29142a = new ArrayList<>();
        this.f29143b = 0L;
        this.f29144c = new C0151a();
        if (list != null) {
            for (common$Event common_event : list) {
                b bVar = new b();
                bVar.f29146a = common_event.type.get();
                bVar.f29148c = common_event.version.get();
                bVar.f29149d = common_event.op_info.operator_role.get();
                bVar.f29150e = common_event.op_info.operator_tinyid.get();
                bVar.f29151f = common_event.op_info.timestamp.get();
                bVar.f29152g = common_event.op_info.at_type.get();
                if (b(bVar.f29146a)) {
                    bVar.f29147b = bVar.f29148c;
                }
                this.f29142a.add(bVar);
            }
        }
        this.f29143b = j3;
    }
}
