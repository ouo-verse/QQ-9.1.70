package c.t.m.g;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.map.geolocation.internal.TencentLogImpl;
import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes.dex */
public class m2 {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<b> f29853a = new LinkedBlockingQueue<>(3);

    /* renamed from: b, reason: collision with root package name */
    public final n1 f29854b;

    /* renamed from: c, reason: collision with root package name */
    public long f29855c;

    /* renamed from: d, reason: collision with root package name */
    public long f29856d;

    /* renamed from: e, reason: collision with root package name */
    public long f29857e;

    /* renamed from: f, reason: collision with root package name */
    public long f29858f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f29859g;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f29860a;

        public a(Handler handler) {
            this.f29860a = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            m2.this.f29853a.clear();
            m2.this.a(this.f29860a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: j, reason: collision with root package name */
        public static final b f29862j = new b();

        /* renamed from: a, reason: collision with root package name */
        public int f29863a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f29864b;

        /* renamed from: c, reason: collision with root package name */
        public String f29865c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f29866d;

        /* renamed from: e, reason: collision with root package name */
        public int f29867e;

        /* renamed from: f, reason: collision with root package name */
        public String f29868f;

        /* renamed from: g, reason: collision with root package name */
        public long f29869g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f29870h;

        /* renamed from: i, reason: collision with root package name */
        public int f29871i;

        public b() {
            this.f29867e = 1;
            this.f29871i = -1;
            this.f29863a = 0;
            this.f29864b = null;
            this.f29865c = null;
            this.f29866d = null;
        }

        public static /* synthetic */ int e(b bVar) {
            int i3 = bVar.f29867e;
            bVar.f29867e = i3 - 1;
            return i3;
        }

        public String toString() {
            return "type=" + this.f29863a + JefsClass.INDEX_URL + this.f29865c + ",coorType=" + this.f29871i;
        }

        public b(int i3, byte[] bArr, String str, Object obj) {
            this.f29867e = 1;
            this.f29871i = -1;
            this.f29863a = i3;
            this.f29864b = bArr;
            this.f29865c = str;
            this.f29866d = obj;
            if (3 == i3) {
                this.f29867e = 3;
            }
        }
    }

    public m2(n1 n1Var) {
        this.f29854b = n1Var;
    }

    public void b(String str, v2 v2Var, int i3, boolean z16) {
        SystemClock.elapsedRealtime();
        try {
            byte[] a16 = u3.a(str.getBytes("GBK"));
            b bVar = new b(3, a16, a(a16, i3), v2Var);
            bVar.f29868f = str;
            bVar.f29870h = z16;
            if (bVar.f29864b != null) {
                this.f29853a.clear();
                this.f29853a.offer(bVar);
                o3.a("TxRequestSender", "the verify request come.so we delete queue others");
            }
        } catch (UnsupportedEncodingException e16) {
            o3.a("TxRequestSender", "", e16);
        }
    }

    public void a(String str, v2 v2Var, int i3, boolean z16) {
        try {
            byte[] a16 = u3.a(str.getBytes("GBK"));
            b bVar = new b(1, a16, a(a16, i3), v2Var);
            bVar.f29868f = str;
            bVar.f29871i = i3;
            bVar.f29870h = z16;
            if (bVar.f29864b != null) {
                this.f29853a.offer(bVar);
            }
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public void a(b bVar) {
        try {
            if (bVar.f29863a != 1 || bVar == null || bVar.f29865c == null) {
                return;
            }
            bVar.f29863a = 4;
            bVar.f29865c = bVar.f29865c.replace("lbs.map.qq.com", "iplocreptest.map.qq.com");
            if (bVar.f29864b != null) {
                this.f29853a.offer(bVar);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void b(Handler handler) {
        if (this.f29859g) {
            return;
        }
        this.f29859g = true;
        this.f29854b.e().execute(new a(handler));
        this.f29858f = SystemClock.elapsedRealtime();
    }

    public void b() {
        if (this.f29859g) {
            this.f29859g = false;
            this.f29853a.clear();
            this.f29853a.offer(b.f29862j);
            if (this.f29858f != 0) {
                o3.b("TxRequestSender", String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", Long.valueOf((SystemClock.elapsedRealtime() - this.f29858f) / 1000), Long.valueOf(this.f29856d), Long.valueOf(this.f29857e), Long.valueOf(this.f29855c)));
            }
            a();
        }
    }

    public final void a() {
        this.f29855c = 0L;
        this.f29856d = 0L;
        this.f29857e = 0L;
        this.f29858f = 0L;
    }

    public final void a(Handler handler) {
        LinkedBlockingQueue<b> linkedBlockingQueue;
        b take;
        long j3;
        LinkedBlockingQueue<b> linkedBlockingQueue2 = this.f29853a;
        b bVar = null;
        while (this.f29859g) {
            try {
                take = linkedBlockingQueue2.take();
                try {
                } catch (Exception e16) {
                    e = e16;
                    linkedBlockingQueue = linkedBlockingQueue2;
                }
            } catch (Exception e17) {
                e = e17;
                linkedBlockingQueue = linkedBlockingQueue2;
            }
            if (b.f29862j == take) {
                o3.b("TxRequestSender", "run: state=[shutdown]");
                return;
            }
            if (TencentExtraKeys.COMPHTTPIO) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f29854b.a(take.f29865c, take.f29864b);
                j3 = System.currentTimeMillis() - currentTimeMillis;
            } else {
                j3 = 0;
            }
            o3.a("request:" + take.f29868f);
            long currentTimeMillis2 = System.currentTimeMillis();
            String a16 = this.f29854b.a(take.f29865c, take.f29864b);
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            StringBuilder sb5 = new StringBuilder();
            linkedBlockingQueue = linkedBlockingQueue2;
            try {
                sb5.append("cost:");
                sb5.append(currentTimeMillis3);
                sb5.append(",request:");
                sb5.append(a16);
                o3.a(sb5.toString());
                a(take, a16);
                if (TencentExtraKeys.COMPHTTPIO) {
                    o3.a("TxRequestSender", "Halley:" + currentTimeMillis3 + "ms,HttpURLConnection:" + j3 + "ms");
                    Log.w("TxRequestSender", "Halley:" + currentTimeMillis3 + "ms,HttpURLConnection:" + j3 + "ms");
                }
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.arg1 = (int) currentTimeMillis3;
                obtainMessage.arg2 = (int) j3;
                take.f29869g = currentTimeMillis2;
                a(a16, take, obtainMessage);
                bVar = take;
            } catch (Exception e18) {
                e = e18;
                bVar = take;
                o3.a("TxRequestSender", "run: io error", e);
                b(bVar);
                boolean z16 = bVar.f29863a == 1;
                a(bVar);
                if (!z16 && 4 == bVar.f29863a) {
                    handler.sendEmptyMessageDelayed(4998, 60000L);
                }
                if (3 == bVar.f29863a) {
                    handler.sendEmptyMessageDelayed(4996, 0L);
                }
                linkedBlockingQueue2 = linkedBlockingQueue;
            }
            linkedBlockingQueue2 = linkedBlockingQueue;
        }
    }

    public final void b(b bVar) {
        boolean z16;
        b.e(bVar);
        Iterator<b> it = this.f29853a.iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = false;
                break;
            } else if (it.next().f29863a == bVar.f29863a) {
                z16 = true;
                break;
            }
        }
        if (bVar.f29867e <= 0 || z16 || bVar.f29863a == 2) {
            return;
        }
        o3.b("TxRequestSender", "retryIfNeed: times=" + bVar.f29867e);
        this.f29853a.offer(bVar);
    }

    public final void a(b bVar, String str) throws FileNotFoundException, IOException {
        this.f29855c++;
        this.f29856d += bVar.f29864b.length;
        this.f29857e += u3.a(str.getBytes()) != null ? r5.length : 0;
    }

    public final void a(String str, b bVar, Message message) {
        if (1 == bVar.f29863a) {
            message.obj = Pair.create(str, bVar);
            message.what = 4999;
            message.sendToTarget();
        }
        if (4 == bVar.f29863a) {
            message.obj = Pair.create(str, bVar);
            message.what = 4999;
            message.sendToTarget();
        }
        if (3 == bVar.f29863a) {
            message.obj = Pair.create(str, bVar);
            message.what = 4997;
            message.sendToTarget();
        }
    }

    public final String a(byte[] bArr, int i3) {
        if (!TencentLogImpl.isDebugEnabled() && bArr != null) {
            try {
                if (com.tencent.tencentmap.lbssdk.service.e.o(bArr, 1) >= 0) {
                    return c2.a(1, i3, 1);
                }
            } catch (UnsatisfiedLinkError unused) {
                return null;
            }
        }
        return c2.a(1, i3, 0);
    }
}
