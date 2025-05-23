package com.tencent.luggage.wxa.mc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.appstorage.FileStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a0 implements Closeable {

    /* renamed from: i, reason: collision with root package name */
    public static final ByteOrder f134253i = ByteOrder.BIG_ENDIAN;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.cp.v f134254a;

    /* renamed from: b, reason: collision with root package name */
    public volatile RandomAccessFile f134255b;

    /* renamed from: c, reason: collision with root package name */
    public volatile FileChannel f134256c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f134257d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Map f134258e;

    /* renamed from: f, reason: collision with root package name */
    public volatile FileStructStat f134259f;

    /* renamed from: g, reason: collision with root package name */
    public volatile int f134260g;

    /* renamed from: h, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.nc.a f134261h;

    public a0(com.tencent.luggage.wxa.cp.v vVar) {
        this.f134256c = null;
        this.f134257d = true;
        this.f134258e = null;
        this.f134260g = -1;
        this.f134254a = vVar;
        e();
    }

    public static int a(String str) {
        com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(str);
        if (!vVar.e()) {
            return -1;
        }
        long a16 = w0.a();
        try {
            a0 a0Var = new a0(vVar);
            try {
                int r16 = a0Var.q() ? a0Var.r() : -1;
                a0Var.close();
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaPkg", "getPkgInnerVersion(%s) cost:%dms", str, Long.valueOf(w0.a() - a16));
                return r16;
            } finally {
            }
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaPkg", "getPkgInnerVersion(%s) cost:%dms", str, Long.valueOf(w0.a() - a16));
            throw th5;
        }
    }

    public InputStream b(String str) {
        a c16 = c(str);
        if (this.f134261h != null && this.f134261h.b(c16)) {
            if (c16 != null) {
                return this.f134261h.a(c16);
            }
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.WxaPkg", "can't find info of file: %s", str);
            return null;
        }
        if (c16 != null) {
            if (Thread.currentThread().isInterrupted()) {
                return c(c16);
            }
            try {
                if (!this.f134256c.isOpen()) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "file channel closed unexpectly!");
                    e();
                }
                MappedByteBuffer map = this.f134256c.map(FileChannel.MapMode.READ_ONLY, c16.f134264c, c16.f134265d);
                map.order(f134253i);
                map.limit(c16.f134265d);
                return new com.tencent.luggage.wxa.h6.a(map);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "handleOpenReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", str, Integer.valueOf(c16.f134264c), Integer.valueOf(c16.f134265d), w0.a((Throwable) e16));
                return null;
            }
        }
        com.tencent.luggage.wxa.tn.w.h("MicroMsg.WxaPkg", "can't find info of file: %s", str);
        return null;
    }

    public a c(String str) {
        if (this.f134258e != null && !w0.c(str)) {
            a aVar = (a) this.f134258e.get(str);
            if (aVar == null) {
                return (a) this.f134258e.get(com.tencent.luggage.wxa.rc.m.a(str));
            }
            return aVar;
        }
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.f134258e == null);
        objArr[1] = Integer.valueOf(this.f134258e != null ? this.f134258e.size() : 0);
        objArr[2] = str;
        com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "handleInterruptReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s", objArr);
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtils.closeQuietly(this.f134256c);
        IOUtils.closeQuietly(this.f134255b);
    }

    public String d() {
        return this.f134254a.g();
    }

    public final void e() {
        boolean z16;
        if (a() && l() >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f134257d = z16;
    }

    public void finalize() {
        try {
            close();
            if (this.f134261h != null) {
                this.f134261h.close();
            }
        } finally {
            super.finalize();
        }
    }

    public List g() {
        return new LinkedList(this.f134258e.keySet());
    }

    public List h() {
        if (!m()) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "listInfos readInfo returns false");
        }
        if (this.f134258e == null) {
            return Collections.emptyList();
        }
        return new LinkedList(this.f134258e.values());
    }

    public final boolean j() {
        if (this.f134256c != null && this.f134256c.isOpen()) {
            return true;
        }
        try {
            IOUtils.closeQuietly(this.f134256c);
            IOUtils.closeQuietly(this.f134255b);
            RandomAccessFile c16 = com.tencent.luggage.wxa.cp.x.c(this.f134254a.m(), false);
            this.f134255b = c16;
            this.f134256c = c16.getChannel();
            return true;
        } catch (IOException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "open(), exp = %s", w0.a((Throwable) e16));
            return false;
        }
    }

    public final boolean k() {
        int l3;
        if (!j() || (l3 = l()) < 0) {
            return false;
        }
        this.f134261h = c0.a(l3);
        if (this.f134261h == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "parseHeader, mIWxaPkgAction is null");
            return false;
        }
        try {
            return this.f134261h.a(this.f134256c);
        } catch (IOException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "parseHeader, exp = %s", w0.a((Throwable) e16));
            return false;
        }
    }

    public final int l() {
        int i3 = -1;
        if (!j()) {
            return -1;
        }
        if (this.f134260g >= 0) {
            return this.f134260g;
        }
        try {
            this.f134256c.position(1L);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4);
            allocateDirect.order(f134253i);
            this.f134256c.read(allocateDirect);
            i3 = com.tencent.luggage.wxa.nc.b.a(com.tencent.luggage.wxa.tk.c.a(allocateDirect), 0, 4);
            this.f134260g = i3;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.WxaPkg", "parsed header version:%d, path:%s", Integer.valueOf(i3), this.f134254a.g());
            return i3;
        } catch (IOException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "parseHeaderVersion, exp = %s", w0.a((Throwable) e16));
            return i3;
        }
    }

    public boolean m() {
        if (!q()) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "readInfo, file(%s) valid==false", this.f134254a.g());
            return false;
        }
        if (this.f134261h == null && !k()) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "readInfo, file(%s) parseHeaderFully==false", this.f134254a.g());
            return false;
        }
        if (this.f134261h.n() <= 4) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "readInfo, file(%s) getBodyInfoLength<=4, fileLength:%d, fileExists:%b", this.f134254a.g(), Long.valueOf(this.f134254a.s()), Boolean.valueOf(this.f134254a.e()));
            return false;
        }
        if (this.f134258e != null && this.f134261h.i() >= 0 && this.f134261h.i() == this.f134258e.size()) {
            return true;
        }
        try {
            this.f134258e = this.f134261h.a(this.f134256c, this.f134254a);
            if (this.f134258e != null) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "readInfo, file(%s) getInfo failed exp = %s", this.f134254a.g(), w0.a((Throwable) e16));
            return false;
        }
    }

    public FileStructStat p() {
        FileStructStat fileStructStat = this.f134259f;
        if (fileStructStat == null) {
            FileStructStat fileStructStat2 = new FileStructStat();
            FileStat.vfsStat(this.f134254a.g(), fileStructStat2);
            this.f134259f = fileStructStat2;
            return fileStructStat2;
        }
        return fileStructStat;
    }

    public boolean q() {
        return this.f134257d;
    }

    public int r() {
        return l();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C6468a();

        /* renamed from: a, reason: collision with root package name */
        public final String f134262a;

        /* renamed from: b, reason: collision with root package name */
        public final String f134263b;

        /* renamed from: c, reason: collision with root package name */
        public final int f134264c;

        /* renamed from: d, reason: collision with root package name */
        public final int f134265d;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.mc.a0$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6468a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a(String str, String str2, int i3, int i16) {
            this.f134262a = str;
            this.f134263b = str2;
            this.f134264c = i3;
            this.f134265d = i16;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f134262a);
            parcel.writeString(this.f134263b);
            parcel.writeInt(this.f134264c);
            parcel.writeInt(this.f134265d);
        }

        public a(Parcel parcel) {
            this.f134262a = parcel.readString();
            this.f134263b = parcel.readString();
            this.f134264c = parcel.readInt();
            this.f134265d = parcel.readInt();
        }
    }

    public a0(String str) {
        this(new com.tencent.luggage.wxa.cp.v(str));
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0049: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:16:0x0049 */
    public final InputStream c(a aVar) {
        RandomAccessFile randomAccessFile;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                randomAccessFile = com.tencent.luggage.wxa.cp.x.c(this.f134254a.m(), false);
            } catch (Exception e16) {
                e = e16;
                randomAccessFile = null;
            } catch (Throwable th5) {
                th = th5;
                w0.a(closeable2);
                throw th;
            }
            try {
                byte[] bArr = new byte[aVar.f134265d];
                randomAccessFile.seek(aVar.f134264c);
                randomAccessFile.readFully(bArr);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                w0.a((Closeable) randomAccessFile);
                return byteArrayInputStream;
            } catch (Exception e17) {
                e = e17;
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.WxaPkg", "openReadOnThreadInterrupted pkgPath(%s) fileInfo.name(%s), e = %s", this.f134254a.m(), aVar.f134263b, e);
                w0.a((Closeable) randomAccessFile);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            w0.a(closeable2);
            throw th;
        }
    }

    public final boolean a() {
        com.tencent.luggage.wxa.cp.v vVar = this.f134254a;
        return vVar != null && vVar.e() && this.f134254a.s() > 14;
    }
}
