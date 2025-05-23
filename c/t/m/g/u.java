package c.t.m.g;

import android.content.SharedPreferences;
import c.t.m.g.z0;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f30025a = true;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Timer f30026a;

        public a(Timer timer) {
            this.f30026a = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            w0.a("th_loc_task_t_consume", new b(null));
            this.f30026a.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* compiled from: P */
        /* loaded from: classes.dex */
        public class a implements z0.c {
            public a(b bVar) {
            }

            @Override // c.t.m.g.z0.c
            public void a(String str) {
                c1.a("UpdateRsaPublicKey", "onFailed:" + str);
            }

            @Override // c.t.m.g.z0.c
            public void b(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i3 = jSONObject.getInt("status");
                    if (i3 == 0) {
                        String string = jSONObject.getString("version");
                        String a16 = t0.a(jSONObject.getString("key"));
                        u0.a(l0.a(a16), string);
                        SharedPreferences a17 = k1.a();
                        k1.b(a17, "loc_comm_rsa_pub_key_ver", (Object) string);
                        k1.b(a17, "loc_comm_rsa_pub_key_64", (Object) a16);
                        k1.b(a17, "loc_comm_rsa_key_update_time", Long.valueOf(System.currentTimeMillis()));
                    } else {
                        c1.a("UpdateRsaPublicKey", "parse json status:" + i3 + ", json=" + str);
                    }
                } catch (Throwable th5) {
                    c1.a("UpdateRsaPublicKey", "parse json error : " + str, th5);
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!u.f30025a) {
                return;
            }
            z0.a("https://cs.map.qq.com/key", new a(this));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static void b() {
        SharedPreferences a16 = k1.a();
        long longValue = ((Long) k1.a(a16, "loc_comm_rsa_key_update_time", (Object) 0L)).longValue();
        if (longValue != 0) {
            u0.a(l0.a((String) k1.a(a16, "loc_comm_rsa_pub_key_64", (Object) "")), (String) k1.a(a16, "loc_comm_rsa_pub_key_ver", (Object) ""));
        }
        if (Math.abs(System.currentTimeMillis() - longValue) < 259200000) {
            return;
        }
        BaseTimer baseTimer = new BaseTimer();
        baseTimer.schedule(new a(baseTimer), 5000L);
    }
}
