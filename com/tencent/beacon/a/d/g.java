package com.tencent.beacon.a.d;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.a.b.i;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private FileChannel f77691b;

    /* renamed from: d, reason: collision with root package name */
    private MappedByteBuffer f77693d;

    /* renamed from: e, reason: collision with root package name */
    private long f77694e;

    /* renamed from: f, reason: collision with root package name */
    private Runnable f77695f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f77696g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f77697h;

    /* renamed from: a, reason: collision with root package name */
    private final Object f77690a = new Object();

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f77692c = new JSONObject();

    g(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f77691b = randomAccessFile.getChannel();
        this.f77694e = randomAccessFile.length();
        com.tencent.beacon.base.util.c.a("[properties]", "file size: " + this.f77694e, new Object[0]);
        e();
    }

    private Object c(@NonNull String str) {
        Object obj = null;
        try {
            synchronized (this.f77690a) {
                obj = this.f77692c.get(str);
            }
        } catch (Exception unused) {
            com.tencent.beacon.base.util.c.a("[properties]", "current jsonObject not exist key: " + str, new Object[0]);
        }
        return obj;
    }

    private Runnable d() {
        if (this.f77695f == null) {
            this.f77695f = new e(this);
        }
        return this.f77695f;
    }

    private void e() throws IOException {
        if (this.f77694e <= 10) {
            this.f77697h = true;
            this.f77694e = 4L;
        }
        MappedByteBuffer map = this.f77691b.map(FileChannel.MapMode.READ_WRITE, 0L, this.f77694e);
        this.f77693d = map;
        map.rewind();
        if (this.f77697h) {
            this.f77693d.putInt(0, 1);
            a(d());
            return;
        }
        byte[] a16 = a(this.f77693d);
        if (a16 == null) {
            return;
        }
        try {
            this.f77692c = new JSONObject(new String(b(a16), "ISO8859-1"));
        } catch (Exception e16) {
            com.tencent.beacon.base.util.c.a("[properties]", "init error" + e16.getMessage(), new Object[0]);
            i.e().a("504", "[properties] init error! msg: " + e16.getMessage() + ". file size: " + this.f77694e, e16);
        }
        com.tencent.beacon.base.util.c.a("[properties]", "init json: " + this.f77692c.toString(), new Object[0]);
    }

    public static g a(Context context, String str) throws IOException {
        File file = new File(context.getFilesDir(), "beacon");
        if (!(!file.exists() ? file.mkdirs() : true)) {
            com.tencent.beacon.base.util.e.a("mkdir " + file.getName() + " exception!");
        }
        return new g(new File(file, str + "V1"));
    }

    public static byte[] b(byte[] bArr) {
        byte[] a16 = a(bArr, "BEACONDEFAULTAES");
        if (a16 != null) {
            return a16;
        }
        i.e().a("517", "default aesKey unEncryption failed");
        byte[] a17 = a(bArr, com.tencent.beacon.a.c.f.e().a());
        return a17 != null ? a17 : a(bArr, "");
    }

    private boolean c() {
        if (!this.f77696g) {
            return false;
        }
        com.tencent.beacon.base.util.c.a("[properties]", "File is close!", new Object[0]);
        return true;
    }

    public synchronized void b(@NonNull String str, @NonNull Object obj) {
        Object c16;
        if (c()) {
            return;
        }
        try {
            c16 = c(str);
        } catch (Exception e16) {
            i.e().a("504", "[properties] JSON put error!", e16);
            com.tencent.beacon.base.util.c.b("[properties] JSON put error!" + e16.getMessage(), new Object[0]);
        }
        if (c16 == null || !c16.equals(obj)) {
            if (obj instanceof String) {
                if (TextUtils.isEmpty((String) obj)) {
                    return;
                }
                if (!com.tencent.beacon.base.util.f.a((String) obj)) {
                    com.tencent.beacon.base.util.c.b("[properties] JSON put value not english ! !", new Object[0]);
                    return;
                }
            }
            synchronized (this.f77690a) {
                this.f77692c.put(str, obj);
            }
            a(d());
        }
    }

    private static byte[] a(byte[] bArr, String str) {
        try {
            return com.tencent.beacon.base.net.b.c.a(3, str, bArr);
        } catch (Throwable th5) {
            com.tencent.beacon.base.util.c.a(th5);
            i.e().a("513", "unEncrypt error: key=" + str, th5);
            return null;
        }
    }

    public static byte[] a(byte[] bArr) throws Exception {
        return com.tencent.beacon.base.net.b.c.b(3, "BEACONDEFAULTAES", bArr);
    }

    private byte[] a(ByteBuffer byteBuffer) {
        int i3 = byteBuffer.getInt(0);
        if (i3 <= 1 || i3 > 2097152 || byteBuffer.capacity() <= 10) {
            return null;
        }
        byteBuffer.position(10);
        byte[] bArr = new byte[i3];
        byteBuffer.get(bArr, 0, i3);
        return bArr;
    }

    public synchronized <T> T a(@NonNull String str, @NonNull T t16) {
        if (c()) {
            return t16;
        }
        Object c16 = c(str);
        if (c16 != null) {
            t16 = (T) c16;
        }
        return t16;
    }

    public synchronized <T> void b(@NonNull String str, @NonNull Set<T> set) {
        if (c()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator<T> it = set.iterator();
            for (int i3 = 0; i3 < set.size(); i3++) {
                if (it.hasNext()) {
                    jSONObject.put(String.valueOf(i3), it.next());
                }
            }
            b(str, jSONObject);
        } catch (JSONException e16) {
            com.tencent.beacon.base.util.c.a(e16);
            i.e().a("504", "[properties] JSON put set error!", e16);
        }
    }

    public synchronized <T> Set<T> a(@NonNull String str, @Nullable Set<T> set) {
        JSONObject jSONObject;
        if (c()) {
            return set;
        }
        try {
            HashSet hashSet = new HashSet();
            synchronized (this.f77690a) {
                jSONObject = this.f77692c.getJSONObject(str);
            }
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    hashSet.add(jSONObject.get((String) keys.next()));
                }
            }
            if (!hashSet.isEmpty()) {
                set = hashSet;
            }
        } catch (JSONException e16) {
            i.e().a("504", "[properties] JSON getSet error!", e16);
            com.tencent.beacon.base.util.c.b("[properties] JSON get error!" + e16.getMessage(), new Object[0]);
        }
        return set;
    }

    public synchronized void b(String str) {
        synchronized (this.f77690a) {
            this.f77692c.remove(str);
        }
        a(d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j3) throws IOException {
        if (j3 <= 2097152) {
            this.f77693d.rewind();
            this.f77693d = this.f77691b.map(FileChannel.MapMode.READ_WRITE, 0L, j3);
            return;
        }
        throw new IllegalArgumentException("file size to reach maximum!");
    }

    public Map<String, ?> b() {
        synchronized (this.f77690a) {
            JSONObject jSONObject = this.f77692c;
            if (jSONObject == null) {
                return null;
            }
            Iterator keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                try {
                    hashMap.put(str, this.f77692c.get(str));
                } catch (JSONException e16) {
                    com.tencent.beacon.base.util.c.a(e16);
                }
            }
            return hashMap;
        }
    }

    private void a(Runnable runnable) {
        com.tencent.beacon.a.b.a.a().a(new f(this, runnable));
    }

    public synchronized void a() {
        this.f77692c = new JSONObject();
        a(d());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
    
        if (r1 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r1.hasNext() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r4.equals(r1.next()) == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str) {
        synchronized (this.f77690a) {
            Iterator keys = this.f77692c.keys();
        }
    }
}
