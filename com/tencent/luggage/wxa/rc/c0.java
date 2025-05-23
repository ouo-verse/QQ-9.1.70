package com.tencent.luggage.wxa.rc;

import android.system.ErrnoException;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.appstorage.FileStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileUnlink;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.apache.commons.io.FilenameUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c0 extends com.tencent.luggage.wxa.rc.h {

    /* renamed from: a, reason: collision with root package name */
    public final String f139478a;

    /* renamed from: b, reason: collision with root package name */
    public final String f139479b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f139480c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final r f139481d = new h();

    /* renamed from: e, reason: collision with root package name */
    public final r f139482e = new i();

    /* renamed from: f, reason: collision with root package name */
    public final q f139483f = new j();

    /* renamed from: g, reason: collision with root package name */
    public final q f139484g = new k();

    /* renamed from: h, reason: collision with root package name */
    public final q f139485h = new l();

    /* renamed from: i, reason: collision with root package name */
    public final q f139486i = new m();

    /* renamed from: j, reason: collision with root package name */
    public final q f139487j = new n();

    /* renamed from: k, reason: collision with root package name */
    public final q f139488k = new o();

    /* renamed from: l, reason: collision with root package name */
    public final r f139489l = new p();

    /* renamed from: m, reason: collision with root package name */
    public final q f139490m = new a();
    public final q C = new b();
    public final q D = new c();
    public final q E = new d();
    public final q F = new e();
    public final q G = new g();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements q {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            if (!vVar.e()) {
                return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
            }
            int vfsStat = FileStat.vfsStat(vVar.m(), (FileStructStat) objArr[0]);
            if (vfsStat != 0) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.LuggageNonFlattenedFileSystem", "stat err %d, %s", Integer.valueOf(vfsStat), vVar.m());
            }
            if (vfsStat == 0) {
                return com.tencent.luggage.wxa.rc.l.OK;
            }
            return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements q {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements com.tencent.luggage.wxa.cp.w {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f139493a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f139494b;

            public a(String str, List list) {
                this.f139493a = str;
                this.f139494b = list;
            }

            @Override // com.tencent.luggage.wxa.cp.w
            public boolean a(com.tencent.luggage.wxa.cp.v vVar) {
                boolean z16 = !vVar.i().endsWith(".nomedia");
                if (z16 && !vVar.p()) {
                    z zVar = new z(com.tencent.luggage.wxa.rc.m.b(vVar.g().replaceFirst(this.f139493a, "")));
                    FileStat.vfsStat(vVar.g(), zVar);
                    this.f139494b.add(zVar);
                }
                return z16;
            }
        }

        public b() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            if (!vVar.p()) {
                return com.tencent.luggage.wxa.rc.l.ERR_NOT_SUPPORTED;
            }
            com.tencent.luggage.wxa.rc.m.a(vVar, new a(Pattern.quote(vVar.g()), (List) objArr[0]));
            return com.tencent.luggage.wxa.rc.l.OK;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements q {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            com.tencent.luggage.wxa.cp.v vVar2 = (com.tencent.luggage.wxa.cp.v) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (vVar.p()) {
                return com.tencent.luggage.wxa.rc.l.RET_ALREADY_EXISTS;
            }
            if (com.tencent.luggage.wxa.rc.m.a(vVar)) {
                return com.tencent.luggage.wxa.rc.l.ERR_SYMLINK;
            }
            if (c0.this.f139480c > 0 && c0.this.c() + vVar2.s() > c0.this.f139480c) {
                return com.tencent.luggage.wxa.rc.l.ERR_EXCEED_DIRECTORY_MAX_SIZE;
            }
            if (booleanValue) {
                Pair a16 = com.tencent.luggage.wxa.rc.k.a(vVar2.g(), vVar.g());
                if (((Boolean) a16.first).booleanValue()) {
                    return com.tencent.luggage.wxa.rc.l.OK;
                }
                return com.tencent.luggage.wxa.rc.k.a((ErrnoException) a16.second);
            }
            if (com.tencent.luggage.wxa.tn.o.a(vVar2.g(), vVar.g(), false)) {
                return com.tencent.luggage.wxa.rc.l.OK;
            }
            return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements q {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            ((com.tencent.luggage.wxa.tk.i) objArr[0]).f141499a = vVar;
            return com.tencent.luggage.wxa.rc.l.OK;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements q {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.cp.v f139499a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tk.i f139500b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f139501c;

        public f(com.tencent.luggage.wxa.cp.v vVar, com.tencent.luggage.wxa.tk.i iVar, String str) {
            this.f139499a = vVar;
            this.f139500b = iVar;
            this.f139501c = str;
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            vVar.s();
            this.f139499a.s();
            vVar.d();
            Pair a16 = com.tencent.luggage.wxa.rc.k.a(this.f139499a.g(), vVar.g());
            if (!((Boolean) a16.first).booleanValue()) {
                return com.tencent.luggage.wxa.rc.k.a((ErrnoException) a16.second);
            }
            com.tencent.luggage.wxa.tk.i iVar = this.f139500b;
            if (iVar != null) {
                iVar.f141499a = this.f139501c;
            }
            c0.d(c0.this);
            return com.tencent.luggage.wxa.rc.l.OK;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements q {
        public g() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            com.tencent.luggage.wxa.tk.i iVar = (com.tencent.luggage.wxa.tk.i) objArr[0];
            if (!vVar.e()) {
                return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
            }
            if (!vVar.q()) {
                return com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED;
            }
            if (com.tencent.luggage.wxa.rc.m.a(vVar)) {
                return com.tencent.luggage.wxa.rc.l.ERR_SYMLINK;
            }
            try {
                iVar.f141499a = com.tencent.luggage.wxa.cp.x.a(vVar);
                return com.tencent.luggage.wxa.rc.l.OK;
            } catch (FileNotFoundException unused) {
                return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h extends r {
        public h() {
            super(c0.this, null);
        }

        @Override // com.tencent.luggage.wxa.rc.c0.r
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar) {
            if (vVar.e()) {
                return com.tencent.luggage.wxa.rc.l.OK;
            }
            return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class i extends r {
        public i() {
            super(c0.this, null);
        }

        @Override // com.tencent.luggage.wxa.rc.c0.r
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar) {
            if (!vVar.e()) {
                return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
            }
            if (vVar.p()) {
                return com.tencent.luggage.wxa.rc.l.OK;
            }
            return com.tencent.luggage.wxa.rc.l.ERR_IS_FILE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class j implements q {
        public j() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            if (vVar.e()) {
                return com.tencent.luggage.wxa.rc.l.RET_ALREADY_EXISTS;
            }
            if (!((Boolean) objArr[0]).booleanValue() ? vVar.v() : vVar.w()) {
                return com.tencent.luggage.wxa.rc.l.OK;
            }
            return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class k implements q {
        public k() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            if (!vVar.q() && vVar.e()) {
                if (vVar.equals(c0.this.b())) {
                    return com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED;
                }
                if (((Boolean) objArr[0]).booleanValue()) {
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive");
                    try {
                        com.tencent.luggage.wxa.rc.m.d(vVar);
                        return com.tencent.luggage.wxa.rc.l.OK;
                    } catch (Exception e16) {
                        com.tencent.luggage.wxa.tn.w.b("MicroMsg.LuggageNonFlattenedFileSystem", "rmdir recursive exp = %s", e16);
                        return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
                    }
                }
                com.tencent.luggage.wxa.cp.v[] u16 = vVar.u();
                if (u16.length > 0) {
                    if (u16.length == 1) {
                        if (u16[0].i().equals(".nomedia")) {
                            u16[0].d();
                        } else {
                            return com.tencent.luggage.wxa.rc.l.ERR_DIR_NOT_EMPTY;
                        }
                    } else {
                        return com.tencent.luggage.wxa.rc.l.ERR_DIR_NOT_EMPTY;
                    }
                }
                if (vVar.d()) {
                    return com.tencent.luggage.wxa.rc.l.OK;
                }
                return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
            }
            return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class l implements q {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements com.tencent.luggage.wxa.cp.w {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f139509a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f139510b;

            public a(String str, List list) {
                this.f139509a = str;
                this.f139510b = list;
            }

            @Override // com.tencent.luggage.wxa.cp.w
            public boolean a(com.tencent.luggage.wxa.cp.v vVar) {
                boolean z16 = !vVar.i().endsWith(".nomedia");
                if (z16) {
                    com.tencent.luggage.wxa.rc.j jVar = new com.tencent.luggage.wxa.rc.j();
                    jVar.f139536a = com.tencent.luggage.wxa.rc.m.b(vVar.g().replaceFirst(this.f139509a, ""));
                    this.f139510b.add(jVar);
                }
                return z16;
            }
        }

        public l() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            if (!vVar.p()) {
                return com.tencent.luggage.wxa.rc.l.ERR_IS_FILE;
            }
            if (com.tencent.luggage.wxa.rc.m.a(vVar)) {
                return com.tencent.luggage.wxa.rc.l.ERR_SYMLINK;
            }
            LinkedList linkedList = new LinkedList();
            vVar.a(new a(Pattern.quote(vVar.g()), linkedList));
            ((com.tencent.luggage.wxa.tk.i) objArr[0]).f141499a = linkedList;
            return com.tencent.luggage.wxa.rc.l.OK;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class m implements q {
        public m() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            Long l3;
            Long l16;
            com.tencent.luggage.wxa.tk.i iVar = (com.tencent.luggage.wxa.tk.i) objArr[0];
            if (objArr.length >= 3) {
                l3 = (Long) objArr[1];
                l16 = (Long) objArr[2];
            } else {
                l3 = null;
                l16 = null;
            }
            if (!vVar.e()) {
                return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
            }
            if (!vVar.q()) {
                return com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED;
            }
            if (com.tencent.luggage.wxa.rc.m.a(vVar)) {
                return com.tencent.luggage.wxa.rc.l.ERR_SYMLINK;
            }
            if (iVar != null) {
                if (l3 != null && l16 != null) {
                    if (l16.longValue() == Long.MAX_VALUE) {
                        l16 = Long.valueOf(vVar.s() - l3.longValue());
                    }
                    com.tencent.luggage.wxa.rc.l a16 = c0.this.a(l3.longValue(), l16.longValue(), vVar.s());
                    if (a16 != com.tencent.luggage.wxa.rc.l.OK) {
                        return a16;
                    }
                    iVar.f141499a = com.tencent.luggage.wxa.rc.m.a(vVar, l3.longValue(), l16.longValue());
                } else {
                    iVar.f141499a = com.tencent.luggage.wxa.rc.m.c(vVar);
                }
            }
            return com.tencent.luggage.wxa.rc.l.OK;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class n implements q {
        public n() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            long j3;
            String str;
            long j16;
            com.tencent.luggage.wxa.tk.i iVar = (com.tencent.luggage.wxa.tk.i) objArr[0];
            if (objArr.length >= 4) {
                String str2 = (String) objArr[1];
                long longValue = ((Long) objArr[2]).longValue();
                j3 = ((Long) objArr[3]).longValue();
                j16 = longValue;
                str = str2;
            } else {
                j3 = Long.MAX_VALUE;
                str = null;
                j16 = 0;
            }
            if (!vVar.e()) {
                return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
            }
            if (!vVar.q()) {
                return com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED;
            }
            if (com.tencent.luggage.wxa.rc.m.a(vVar)) {
                return com.tencent.luggage.wxa.rc.l.ERR_SYMLINK;
            }
            if (iVar != null) {
                return com.tencent.luggage.wxa.rc.m.a(vVar.g(), iVar, str, j16, j3);
            }
            return com.tencent.luggage.wxa.rc.l.OK;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class o implements q {
        public o() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            if (com.tencent.luggage.wxa.rc.m.a(vVar)) {
                return com.tencent.luggage.wxa.rc.l.ERR_SYMLINK;
            }
            InputStream inputStream = (InputStream) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (inputStream instanceof ZipInputStream) {
                if (com.tencent.luggage.wxa.rc.m.a((ZipInputStream) inputStream, vVar.g()) == 0) {
                    if (c0.this.f139480c > 0 && c0.this.c() > c0.this.f139480c) {
                        vVar.d();
                        return com.tencent.luggage.wxa.rc.l.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                    }
                    return com.tencent.luggage.wxa.rc.l.OK;
                }
                return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
            }
            if (vVar.p()) {
                return com.tencent.luggage.wxa.rc.l.RET_ALREADY_EXISTS;
            }
            if (c0.this.f139480c > 0) {
                try {
                    if (c0.this.c() + inputStream.available() > c0.this.f139480c) {
                        return com.tencent.luggage.wxa.rc.l.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                    }
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.LuggageNonFlattenedFileSystem", "writeFile, access available e=%s", e16);
                    return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
                }
            }
            if (!vVar.e() && booleanValue) {
                return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
            }
            OutputStream outputStream = null;
            try {
                outputStream = com.tencent.luggage.wxa.cp.x.d(vVar.g(), booleanValue);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        return com.tencent.luggage.wxa.rc.l.OK;
                    }
                }
            } catch (Exception e17) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.LuggageNonFlattenedFileSystem", "writeFile exp %s", e17);
                return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
            } finally {
                w0.a((Closeable) outputStream);
                w0.a((Closeable) inputStream);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class p extends r {
        public p() {
            super(c0.this, null);
        }

        @Override // com.tencent.luggage.wxa.rc.c0.r
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar) {
            if (vVar.p()) {
                return com.tencent.luggage.wxa.rc.l.ERR_IS_DIRECTORY;
            }
            if (!vVar.e()) {
                return com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS;
            }
            int vfsUnlink = FileUnlink.vfsUnlink(vVar.m());
            if (vfsUnlink != 0) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.LuggageNonFlattenedFileSystem", "unlink err %d, %s", Integer.valueOf(vfsUnlink), vVar.m());
            }
            if (vfsUnlink == 0) {
                return com.tencent.luggage.wxa.rc.l.OK;
            }
            return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface q {
        com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public abstract class r implements q {
        public r() {
        }

        public abstract com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar);

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public final com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            return a(vVar);
        }

        public /* synthetic */ r(c0 c0Var, h hVar) {
            this();
        }
    }

    public c0(String str, String str2) {
        this.f139478a = str;
        this.f139479b = str2;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.LuggageNonFlattenedFileSystem", "mRootPath:%s mPathPrefix:%s", str, str2);
    }

    public static /* synthetic */ t d(c0 c0Var) {
        c0Var.getClass();
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public boolean accept(String str) {
        return w0.d(str).startsWith(this.f139479b);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l access(String str) {
        return a(str, this.f139481d, new Object[0]);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public boolean canRenameFile(String str) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l copyTo(String str, com.tencent.luggage.wxa.cp.v vVar, boolean z16) {
        return a(str, this.D, vVar, Boolean.valueOf(z16));
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l createTempFileFrom(com.tencent.luggage.wxa.cp.v vVar, String str, boolean z16, com.tencent.luggage.wxa.tk.i iVar) {
        return com.tencent.luggage.wxa.rc.l.ERR_NOT_SUPPORTED;
    }

    public String e() {
        return this.f139479b;
    }

    public long f() {
        return this.f139480c;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.cp.v getAbsoluteFile(String str, boolean z16) {
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        a(str, this.E, iVar);
        com.tencent.luggage.wxa.cp.v vVar = (com.tencent.luggage.wxa.cp.v) iVar.f141499a;
        if (vVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), get null file", str);
            return null;
        }
        if (!vVar.e()) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), file not exists", str);
            return null;
        }
        if (!z16 && !vVar.q()) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), not a file", str);
            return null;
        }
        if (com.tencent.luggage.wxa.rc.m.a(vVar)) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.LuggageNonFlattenedFileSystem", "getAbsoluteFile with path(%s), symlink file", str);
            return null;
        }
        return vVar;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public List getSavedFileList() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public t getStorageSpaceStatistics() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l getTempDirectory(com.tencent.luggage.wxa.tk.i iVar) {
        return com.tencent.luggage.wxa.rc.l.ERR_NOT_SUPPORTED;
    }

    public String i() {
        return this.f139478a;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void initialize() {
        com.tencent.luggage.wxa.cp.v b16 = b();
        if (b16 == null || !b16.e()) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.LuggageNonFlattenedFileSystem", "Initialization Failed");
        }
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l isdir(String str) {
        return a(str, this.f139482e, new Object[0]);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l mkdir(String str, boolean z16) {
        return a(str, this.f139483f, z16, Boolean.valueOf(z16));
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l readDir(String str, com.tencent.luggage.wxa.tk.i iVar) {
        return a(str, this.f139485h, iVar);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l readFile(String str, com.tencent.luggage.wxa.tk.i iVar) {
        return a(str, this.f139486i, iVar);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public final InputStream readStream(String str) {
        com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
        if (com.tencent.luggage.wxa.rc.l.OK == a(str, this.G, iVar)) {
            return (InputStream) iVar.f141499a;
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l readZipEntry(String str, com.tencent.luggage.wxa.tk.i iVar, String str2, long j3, long j16) {
        return a(str, this.f139487j, iVar, str2, Long.valueOf(j3), Long.valueOf(j16));
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l rmdir(String str, boolean z16) {
        return a(str, this.f139484g, z16, Boolean.valueOf(z16));
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l saveFile(com.tencent.luggage.wxa.cp.v vVar, String str, com.tencent.luggage.wxa.tk.i iVar) {
        if (!accept(str)) {
            return com.tencent.luggage.wxa.rc.l.ERR_NOT_SUPPORTED;
        }
        if (vVar != null && vVar.e()) {
            if (TextUtils.isEmpty(str)) {
                return com.tencent.luggage.wxa.rc.l.ERR_NOT_SUPPORTED;
            }
            long c16 = c() + vVar.s();
            if (this.f139480c > 0 && c16 > this.f139480c) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.LuggageNonFlattenedFileSystem", "saveFile exceed directory max size, MAX_SIZE[%d MB], TOTAL_SIZE[%d MB]", Long.valueOf(this.f139480c / 1048576), Long.valueOf(c16 / 1048576));
                return com.tencent.luggage.wxa.rc.l.ERR_EXCEED_DIRECTORY_MAX_SIZE;
            }
            com.tencent.luggage.wxa.rc.l isdir = isdir(str);
            if (isdir != com.tencent.luggage.wxa.rc.l.RET_NOT_EXISTS && isdir != com.tencent.luggage.wxa.rc.l.ERR_IS_FILE) {
                return isdir;
            }
            try {
                return a(str, new f(vVar, iVar, str), new Object[0]);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.LuggageNonFlattenedFileSystem", e16, "saveFile() error", new Object[0]);
                return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
            }
        }
        return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
    }

    @Override // com.tencent.luggage.wxa.rc.h
    public void setMaxTotalSize(long j3) {
        this.f139480c = j3;
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l stat(String str, FileStructStat fileStructStat) {
        return a(str, this.f139490m, fileStructStat);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l statDir(String str, List list) {
        return a(str, this.C, list);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l unlink(String str) {
        return a(str, this.f139489l, new Object[0]);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l unzip(String str, com.tencent.luggage.wxa.cp.v vVar) {
        return a(str, this.F, vVar);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r
    public com.tencent.luggage.wxa.rc.l writeFile(String str, InputStream inputStream, boolean z16) {
        if (inputStream == null) {
            return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
        }
        return a(str, this.f139488k, inputStream, Boolean.valueOf(z16));
    }

    public final com.tencent.luggage.wxa.rc.l a(String str, q qVar, boolean z16, Object... objArr) {
        String str2;
        if (w0.c(str)) {
            return com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED;
        }
        if (this.f139479b.endsWith("/")) {
            str2 = this.f139479b;
        } else {
            str2 = this.f139479b + "/";
        }
        if (str.equals(this.f139479b)) {
            str = str2;
        } else if (!str.startsWith(str2)) {
            return com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED;
        }
        String replace = com.tencent.luggage.wxa.rc.m.b(str.replaceFirst(Pattern.quote(this.f139479b), "")).replace("\u0000", "");
        com.tencent.luggage.wxa.cp.v b16 = b();
        if (b16 == null) {
            return com.tencent.luggage.wxa.rc.l.ERR_FS_NOT_MOUNTED;
        }
        String concat = FilenameUtils.concat(b16.g(), replace);
        if (w0.c(concat)) {
            return com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED;
        }
        com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(concat);
        if (!a(vVar)) {
            return com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED;
        }
        if (!z16 && !vVar.k().e()) {
            return com.tencent.luggage.wxa.rc.l.ERR_PARENT_DIR_NOT_EXISTS;
        }
        return qVar.a(vVar, objArr);
    }

    public final com.tencent.luggage.wxa.cp.v b() {
        if (TextUtils.isEmpty(this.f139478a)) {
            return null;
        }
        com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(this.f139478a);
        if (vVar.e() && vVar.q()) {
            vVar.d();
        }
        vVar.w();
        try {
            new com.tencent.luggage.wxa.cp.v(vVar.m() + "/.nomedia").c();
        } catch (Exception unused) {
        }
        return vVar;
    }

    public final long c() {
        return com.tencent.luggage.wxa.rc.m.b(new com.tencent.luggage.wxa.cp.v(this.f139478a));
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public com.tencent.luggage.wxa.rc.l readFile(String str, long j3, long j16, com.tencent.luggage.wxa.tk.i iVar) {
        return a(str, this.f139486i, iVar, Long.valueOf(j3), Long.valueOf(j16));
    }

    public final com.tencent.luggage.wxa.rc.l a(String str, q qVar, Object... objArr) {
        return a(str, qVar, false, objArr);
    }

    @Override // com.tencent.luggage.wxa.rc.h, com.tencent.luggage.wxa.rc.r, com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public void release() {
    }

    public final boolean a(com.tencent.luggage.wxa.cp.v vVar) {
        com.tencent.luggage.wxa.cp.v b16 = b();
        return b16 != null && a(b16, vVar);
    }

    public static boolean a(com.tencent.luggage.wxa.cp.v vVar, com.tencent.luggage.wxa.cp.v vVar2) {
        while (vVar2 != null) {
            if (vVar.equals(vVar2)) {
                return true;
            }
            vVar2 = vVar2.k();
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements q {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.rc.c0.q
        public com.tencent.luggage.wxa.rc.l a(com.tencent.luggage.wxa.cp.v vVar, Object... objArr) {
            if (com.tencent.luggage.wxa.rc.m.a(vVar)) {
                return com.tencent.luggage.wxa.rc.l.ERR_SYMLINK;
            }
            if (vVar.q() && vVar.e()) {
                return com.tencent.luggage.wxa.rc.l.RET_ALREADY_EXISTS;
            }
            com.tencent.luggage.wxa.rc.m.b(vVar);
            try {
                com.tencent.luggage.wxa.cp.v vVar2 = (com.tencent.luggage.wxa.cp.v) objArr[0];
                int vfsUnzip = ZipJNI.vfsUnzip(vVar2.g(), vVar.g(), null);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.LuggageNonFlattenedFileSystem", "unzip zipFile(%s) iRet(%d)", vVar2.g(), Integer.valueOf(vfsUnzip));
                if (vfsUnzip == 0) {
                    c0.d(c0.this);
                    long c16 = c0.this.c();
                    if (c0.this.f139480c > 0 && c16 > c0.this.f139480c) {
                        if (!a(vVar2.g(), vVar.g())) {
                            com.tencent.luggage.wxa.rc.m.d(vVar);
                        }
                        return com.tencent.luggage.wxa.rc.l.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                    }
                    return com.tencent.luggage.wxa.rc.l.OK;
                }
                if (vfsUnzip != -1) {
                    if (vfsUnzip == 1) {
                        return com.tencent.luggage.wxa.rc.l.ERR_PERMISSION_DENIED;
                    }
                    if (vfsUnzip != 2) {
                        switch (vfsUnzip) {
                            case -106:
                                return com.tencent.luggage.wxa.rc.l.ERR_WRITE_ZIP_ENTRY;
                            case -105:
                            case -104:
                            case -103:
                            case -102:
                                break;
                            default:
                                return com.tencent.luggage.wxa.rc.l.ERR_OP_FAIL;
                        }
                    }
                }
                return com.tencent.luggage.wxa.rc.l.ERR_BAD_ZIP_FILE;
            } finally {
                c0.d(c0.this);
            }
        }

        public final boolean a(String str, String str2) {
            try {
                ZipFile zipFile = new ZipFile(str);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        String name = entries.nextElement().getName();
                        if (!name.contains("../") && !name.contains("..\\")) {
                            com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(str2, name);
                            if (vVar.e()) {
                                vVar.d();
                            }
                        }
                    }
                    zipFile.close();
                    return true;
                } finally {
                }
            } catch (IOException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.LuggageNonFlattenedFileSystem", e16, "undo unzip failed", new Object[0]);
                return false;
            }
        }
    }
}
