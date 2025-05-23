package com.tencent.mobileqq.weiyun.sdk.download;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.model.a;
import com.tencent.mobileqq.weiyun.sdk.download.processor.a;
import com.tencent.mobileqq.weiyun.sdk.download.processor.b;
import com.tencent.mobileqq.weiyun.sdk.download.processor.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.utils.ThreadPoolWrapper;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool;
import com.tencent.weiyun.utils.DualHashMap;
import com.tencent.weiyun.utils.IOUtils;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c implements a.InterfaceC8982a, b.a, c.b, INetEngineListener {
    static IPatchRedirector $redirector_;
    private static final AtomicInteger N;
    private static Singleton<c, Void> P;
    private y43.d C;
    private List<y43.c> D;
    private com.tencent.mobileqq.weiyun.sdk.download.processor.a E;
    private com.tencent.mobileqq.weiyun.sdk.download.processor.b F;
    private com.tencent.mobileqq.weiyun.sdk.download.processor.c G;
    private Context H;
    private Object I;
    private LinkedList<Long> J;
    private LinkedList<Long> K;
    private Map<Long, NetReq> L;
    private Map<String, HttpNetReq> M;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<Long, com.tencent.mobileqq.weiyun.model.b> f315192d;

    /* renamed from: e, reason: collision with root package name */
    private final DualHashMap<Long, String> f315193e;

    /* renamed from: f, reason: collision with root package name */
    private final HashSet<Long> f315194f;

    /* renamed from: h, reason: collision with root package name */
    private final HashSet<Long> f315195h;

    /* renamed from: i, reason: collision with root package name */
    private final ThreadPoolWrapper f315196i;

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.mobileqq.weiyun.sdk.download.b f315197m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends Singleton<c, Void> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.weiyun.utils.Singleton
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c create(Void r46) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
            }
            return new c(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements INetInfoHandler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                c.this.N(false, false);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                c.this.N(true, true);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                c.this.N(false, true);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else {
                c.this.N(true, true);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                c.this.N(false, true);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                c.this.N(false, false);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.weiyun.sdk.download.c$c, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C8981c implements y43.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ y43.c f315199a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f315200b;

        C8981c(y43.c cVar, int i3) {
            this.f315199a = cVar;
            this.f315200b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, cVar, Integer.valueOf(i3));
            }
        }

        @Override // y43.b
        public void onDownloadFinished(String str, String str2, boolean z16, String str3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), str3, Integer.valueOf(i3));
                return;
            }
            Log.e("WyDownloader", "download finish:" + str + " successed:" + z16 + "errorCode:" + i3);
            if (!z16 || str == null || TextUtils.isEmpty(str2) || !new File(str2).exists()) {
                z17 = false;
            }
            com.tencent.mobileqq.weiyun.model.c cVar = new com.tencent.mobileqq.weiyun.model.c();
            cVar.f315187m = str2;
            cVar.C = str;
            cVar.f315183e = i3;
            cVar.f315184f = str3;
            if (z17) {
                cVar.f315182d = 4;
                this.f315199a.a(str, this.f315200b, cVar, true);
            } else {
                cVar.f315182d = 5;
                this.f315199a.a(str, this.f315200b, cVar, true);
            }
        }

        @Override // y43.b
        public void onDownloadProgress(String str, long j3, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Float.valueOf(f16));
                return;
            }
            com.tencent.mobileqq.weiyun.model.c cVar = new com.tencent.mobileqq.weiyun.model.c();
            cVar.C = str;
            cVar.f315182d = 2;
            cVar.f315186i = f16;
            cVar.f315185h = j3;
            this.f315199a.a(str, this.f315200b, cVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements INetEngineListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y43.b f315202d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f315203e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f315204f;

        d(y43.b bVar, String str, String str2) {
            this.f315202d = bVar;
            this.f315203e = str;
            this.f315204f = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, bVar, str, str2);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
                return;
            }
            int i3 = netResp.mResult;
            if (i3 == 3) {
                return;
            }
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i16 = netResp.mErrCode;
            this.f315202d.onDownloadFinished(this.f315203e, this.f315204f, z16, netResp.mErrDesc, i16);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            } else {
                this.f315202d.onDownloadProgress(this.f315203e, j16, (float) j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements ThreadPool.Job<Void> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HttpNetReq f315206a;

        e(HttpNetReq httpNetReq) {
            this.f315206a = httpNetReq;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) httpNetReq);
            }
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void run(ThreadPool.JobContext jobContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext);
            }
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(this.f315206a);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f implements ThreadPool.Job<Void> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Long f315208a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NetReq f315209b;

        f(Long l3, NetReq netReq) {
            this.f315208a = l3;
            this.f315209b = netReq;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, l3, netReq);
            }
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void run(ThreadPool.JobContext jobContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext);
            }
            com.tencent.mobileqq.weiyun.model.b bVar = (com.tencent.mobileqq.weiyun.model.b) c.this.f315192d.get(this.f315208a);
            if (bVar == null || bVar.k()) {
                c.this.F(this.f315208a.longValue());
                return null;
            }
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(this.f315209b);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class g implements ThreadPool.Job<Void> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f315211a;

        g(List list) {
            this.f315211a = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) list);
            }
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void run(ThreadPool.JobContext jobContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext);
            }
            Iterator it = this.f315211a.iterator();
            while (it.hasNext()) {
                c.this.H(((Long) it.next()).longValue(), true, false, false);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class h implements ThreadPool.Job<Void> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f315213a;

        h(List list) {
            this.f315213a = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) list);
            }
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void run(ThreadPool.JobContext jobContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext);
            }
            Iterator it = this.f315213a.iterator();
            while (it.hasNext()) {
                c.this.L(((Long) it.next()).longValue());
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class i implements ThreadPool.Job<Void> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f315215a;

        i(List list) {
            this.f315215a = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) list);
            }
        }

        @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void run(ThreadPool.JobContext jobContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext);
            }
            Iterator it = this.f315215a.iterator();
            while (it.hasNext()) {
                c.this.C(((Long) it.next()).longValue());
            }
            return null;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20164);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            N = new AtomicInteger(0);
            P = new a();
        }
    }

    /* synthetic */ c(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
            return;
        }
        iPatchRedirector.redirect((short) 30, (Object) this, (Object) aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(long j3) {
        synchronized (this.I) {
            if (this.J.remove(Long.valueOf(j3))) {
                this.L.remove(Long.valueOf(j3));
            } else if (this.K.remove(Long.valueOf(j3))) {
                m();
            } else {
                l();
                m();
            }
        }
    }

    private boolean I(long j3, boolean z16, boolean z17, boolean z18, boolean z19) {
        com.tencent.mobileqq.weiyun.model.b bVar;
        synchronized (this.f315192d) {
            bVar = this.f315192d.get(Long.valueOf(j3));
        }
        if (bVar == null) {
            F(j3);
            return false;
        }
        if (z16) {
            bVar.w(z17);
        }
        if (z18) {
            bVar.t(z19);
        }
        k(bVar, 1, 0, null);
        return true;
    }

    private static boolean J(Context context, File file) {
        int o06;
        Uri uri;
        ParcelFileDescriptor openFileDescriptor;
        BufferedInputStream bufferedInputStream;
        Throwable th5;
        BufferedOutputStream bufferedOutputStream;
        if (!file.getAbsolutePath().startsWith(com.tencent.mobileqq.weiyun.utils.f.d())) {
            return false;
        }
        String name = file.getName();
        try {
            o06 = ah.o0(name);
        } catch (Throwable th6) {
            QLog.e("WyDownloader", 2, "save2MediaStore error", th6);
        }
        if (o06 != 0 && o06 != 2 && o06 != 1) {
            return false;
        }
        String mimeType = MimeTypesTools.getMimeType(context, name);
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", name);
        contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, name);
        contentValues.put("date_modified", Long.valueOf(file.lastModified() / 1000));
        contentValues.put(JobDbManager.COL_UP_MIME_TYPE, mimeType);
        contentValues.put("_size", Long.valueOf(file.length()));
        if (o06 == 0) {
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (o06 == 2) {
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri insert = contentResolver.insert(uri, contentValues);
        if (insert != null && (openFileDescriptor = contentResolver.openFileDescriptor(insert, "w")) != null) {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(openFileDescriptor.getFileDescriptor()));
                } catch (Throwable th7) {
                    th5 = th7;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th8) {
                bufferedInputStream = null;
                th5 = th8;
                bufferedOutputStream = null;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.flush();
                IOUtils.closeSilently(bufferedInputStream);
                IOUtils.closeSilently(bufferedOutputStream);
                try {
                    openFileDescriptor.close();
                } catch (Throwable unused) {
                }
                return true;
            } catch (Throwable th9) {
                th5 = th9;
                IOUtils.closeSilently(bufferedInputStream);
                IOUtils.closeSilently(bufferedOutputStream);
                try {
                    openFileDescriptor.close();
                } catch (Throwable unused2) {
                }
                throw th5;
            }
        }
        return false;
    }

    private void h(long j3, NetReq netReq) {
        if (netReq == null) {
            return;
        }
        synchronized (this.I) {
            this.J.add(Long.valueOf(j3));
            this.L.put(Long.valueOf(j3), netReq);
            l();
            m();
        }
    }

    private void l() {
        Iterator<Long> it = this.K.iterator();
        while (it.hasNext()) {
            Long next = it.next();
            if (next == null) {
                it.remove();
            } else {
                com.tencent.mobileqq.weiyun.model.b bVar = this.f315192d.get(next);
                if (bVar == null || bVar.k()) {
                    it.remove();
                }
            }
        }
    }

    private void m() {
        boolean z16;
        if (this.J.size() > 0) {
            if (this.K.size() < 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Long remove = this.J.remove(0);
                NetReq remove2 = this.L.remove(remove);
                if (remove2 == null) {
                    m();
                    return;
                }
                com.tencent.mobileqq.weiyun.model.b bVar = this.f315192d.get(remove);
                if (bVar != null && y(bVar.l()) && !bVar.k()) {
                    this.K.add(remove);
                    this.f315196i.submit(new f(remove, remove2));
                } else {
                    m();
                }
            }
        }
    }

    private String n(String str, String str2) {
        return str + "." + str2 + ".tmp";
    }

    public static c u() {
        return P.get(null);
    }

    void A(com.tencent.mobileqq.weiyun.model.b bVar, boolean z16) {
        if (bVar == null) {
            return;
        }
        for (y43.c cVar : new ArrayList(this.D)) {
            if (cVar != null) {
                cVar.a(bVar.z(), bVar.e(), bVar.a(), z16);
            }
        }
        if (bVar.i() != null) {
            bVar.i().a(bVar.z(), bVar.e(), bVar.a(), z16);
        }
    }

    public int B() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.f315195h) {
            size = this.f315195h.size();
            arrayList.addAll(this.f315195h);
        }
        if (!arrayList.isEmpty()) {
            this.f315196i.submit(new i(arrayList));
        }
        return size;
    }

    public boolean C(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, j3)).booleanValue();
        }
        this.E.e(j3, true);
        return true;
    }

    public boolean D(String str) {
        Long byValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HttpNetReq httpNetReq = this.M.get(str);
        if (httpNetReq != null) {
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelReq(httpNetReq);
        }
        synchronized (this.f315193e) {
            byValue = this.f315193e.getByValue(str);
        }
        if (byValue == null) {
            return false;
        }
        this.E.e(byValue.longValue(), true);
        return true;
    }

    public void E(y43.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else if (this.D.contains(cVar)) {
            this.D.remove(cVar);
        }
    }

    public int G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        com.tencent.mobileqq.weiyun.sdk.download.b clone = this.f315197m.clone();
        int i3 = clone.f315191h + clone.f315190f;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f315192d) {
            arrayList.addAll(this.f315192d.keySet());
        }
        if (!arrayList.isEmpty()) {
            this.f315196i.submit(new g(arrayList));
        }
        return i3;
    }

    public boolean H(long j3, boolean z16, boolean z17, boolean z18) {
        com.tencent.mobileqq.weiyun.model.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18))).booleanValue();
        }
        synchronized (this.f315192d) {
            bVar = this.f315192d.get(Long.valueOf(j3));
        }
        if (bVar == null) {
            F(j3);
            return false;
        }
        if (z16) {
            bVar.w(z17);
            bVar.t(z18);
        }
        k(bVar, 1, 0, null);
        return true;
    }

    public int K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        com.tencent.mobileqq.weiyun.sdk.download.b clone = this.f315197m.clone();
        int i3 = clone.f315191h + clone.f315188d + clone.f315189e;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f315192d) {
            arrayList.addAll(this.f315192d.keySet());
        }
        if (!arrayList.isEmpty()) {
            this.f315196i.submit(new h(arrayList));
        }
        return i3;
    }

    public boolean L(long j3) {
        com.tencent.mobileqq.weiyun.model.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, j3)).booleanValue();
        }
        synchronized (this.f315192d) {
            bVar = this.f315192d.get(Long.valueOf(j3));
        }
        if (bVar == null) {
            F(j3);
            return false;
        }
        k(bVar, 3, 0, null);
        return true;
    }

    void M(com.tencent.mobileqq.weiyun.model.b bVar, int i3, int i16) {
        this.f315197m.clone();
        this.f315197m.b(bVar, i3, i16);
    }

    void N(boolean z16, boolean z17) {
        if (z16) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.f315194f) {
                arrayList.addAll(this.f315194f);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                I(((Long) it.next()).longValue(), false, false, false, false);
            }
            return;
        }
        synchronized (this.f315192d) {
            Iterator<Map.Entry<Long, com.tencent.mobileqq.weiyun.model.b>> it5 = this.f315192d.entrySet().iterator();
            while (it5.hasNext()) {
                com.tencent.mobileqq.weiyun.model.b value = it5.next().getValue();
                if (value.l() && z17) {
                    if (value.l() && z17 && value.y().e()) {
                        I(value.e(), false, false, false, false);
                    }
                }
                if (value.y().c()) {
                    value.p(true);
                    k(value, 5, ErrorCode.TRAN_NETWORK_NOT_AVAILABLE, null);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.weiyun.sdk.download.processor.a.InterfaceC8982a
    public void a(int i3, com.tencent.mobileqq.weiyun.model.b bVar, String str) {
        com.tencent.mobileqq.weiyun.model.b bVar2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), bVar, str);
            return;
        }
        synchronized (this.f315192d) {
            long e16 = bVar.e();
            bVar2 = this.f315192d.get(Long.valueOf(e16));
            if (bVar2 == null) {
                this.f315192d.put(Long.valueOf(e16), bVar);
            } else if (bVar2.y().a()) {
                bVar.y().f315182d = bVar2.y().f315182d;
                bVar.y().f315183e = bVar2.y().f315183e;
                this.f315192d.put(Long.valueOf(e16), bVar);
            } else {
                z16 = false;
            }
            z16 = true;
        }
        z(i3, bVar);
        if (z16) {
            bVar.r(str);
        } else {
            bVar2.w(bVar.m());
            bVar2.t(bVar.l());
        }
        if (!z16) {
            bVar = bVar2;
        }
        k(bVar, 1, 0, null);
    }

    @Override // com.tencent.mobileqq.weiyun.sdk.download.processor.a.InterfaceC8982a
    public void b(long j3, boolean z16, com.tencent.mobileqq.weiyun.model.b bVar) {
        com.tencent.mobileqq.weiyun.model.b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Long.valueOf(j3), Boolean.valueOf(z16), bVar);
            return;
        }
        synchronized (this.f315192d) {
            bVar2 = this.f315192d.get(Long.valueOf(j3));
        }
        if (bVar2 != null) {
            k(bVar2, 5, ErrorCode.TRAN_USER_CANCELED, null);
        }
        if (bVar != null) {
            bVar.y().f315182d = 0;
            bVar.y().f315183e = ErrorCode.TRAN_USER_CANCELED;
            A(bVar, true);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.sdk.download.processor.b.a
    public void c(long j3, boolean z16, boolean z17, boolean z18, String str) {
        com.tencent.mobileqq.weiyun.model.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str);
            return;
        }
        synchronized (this.f315192d) {
            bVar = this.f315192d.get(Long.valueOf(j3));
        }
        if (bVar == null || bVar.k()) {
            return;
        }
        bVar.r(str);
        if (z16) {
            k(bVar, 4, 0, null);
            return;
        }
        if (z17) {
            k(bVar, 5, ErrorCode.TRAN_LOCAL_PERMISSION_DENIED, null);
            return;
        }
        if (z18) {
            k(bVar, 5, ErrorCode.TRAN_DOWNLOAD_SPACE_LACK, null);
        } else if (!y(bVar.l())) {
            k(bVar, 5, ErrorCode.TRAN_NETWORK_NOT_AVAILABLE, null);
        } else {
            this.G.c(bVar, 0);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.sdk.download.processor.a.InterfaceC8982a
    public void d(long j3, boolean z16, com.tencent.mobileqq.weiyun.model.c cVar, boolean z17) {
        com.tencent.mobileqq.weiyun.model.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(j3), Boolean.valueOf(z16), cVar, Boolean.valueOf(z17));
            return;
        }
        synchronized (this.f315192d) {
            bVar = this.f315192d.get(Long.valueOf(j3));
        }
        if (bVar == null) {
            if (cVar == null) {
                bVar = null;
            } else {
                bVar = cVar.E;
            }
            if (bVar == null) {
                return;
            }
        }
        A(bVar, z17);
    }

    @Override // com.tencent.mobileqq.weiyun.sdk.download.processor.c.b
    public void e(long j3, a.b bVar) {
        com.tencent.mobileqq.weiyun.model.b bVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Long.valueOf(j3), bVar);
            return;
        }
        synchronized (this.f315192d) {
            bVar2 = this.f315192d.get(Long.valueOf(j3));
        }
        if (bVar2 == null || bVar2.k()) {
            return;
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.f315166h)) {
            if (!y(bVar2.l())) {
                k(bVar2, 5, ErrorCode.TRAN_NETWORK_NOT_AVAILABLE, null);
                return;
            }
            HttpNetReq d16 = com.tencent.mobileqq.weiyun.model.b.d(bVar2, bVar.f315166h, bVar2.f(), bVar.f315165f, true, this, n(bVar2.f(), bVar2.g().f315158e));
            bVar2.v(d16);
            bVar2.s(bVar.f315168m);
            bVar2.y().D = bVar.f315168m;
            h(j3, d16);
            return;
        }
        k(bVar2, 5, ErrorCode.TRAN_HTTP_INVALID_URL, null);
    }

    public void i(y43.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
        } else {
            this.D.add(cVar);
        }
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.weiyun.sdk.download.b clone = this.f315197m.clone();
        if (clone.f315188d + clone.f315189e > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void k(com.tencent.mobileqq.weiyun.model.b bVar, int i3, int i16, String str) {
        boolean z16;
        boolean z17;
        if (bVar == null) {
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                if (i16 == 1810002) {
                                    synchronized (this.f315192d) {
                                        this.f315192d.remove(Long.valueOf(bVar.e()));
                                    }
                                    synchronized (this.f315193e) {
                                        this.f315193e.removeByKey(Long.valueOf(bVar.e()));
                                    }
                                    synchronized (this.f315194f) {
                                        this.f315194f.remove(Long.valueOf(bVar.e()));
                                    }
                                    synchronized (this.f315195h) {
                                        this.f315195h.remove(Long.valueOf(bVar.e()));
                                    }
                                    bVar.p(true);
                                    ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelReq(bVar.j());
                                    i3 = 0;
                                } else if (i16 != 1810003 && i16 != 1810004) {
                                    synchronized (this.f315195h) {
                                        this.f315195h.add(Long.valueOf(bVar.e()));
                                    }
                                } else {
                                    synchronized (this.f315194f) {
                                        this.f315194f.add(Long.valueOf(bVar.e()));
                                    }
                                    i3 = 1;
                                }
                                F(bVar.e());
                            }
                        } else {
                            synchronized (this.f315192d) {
                                this.f315192d.remove(Long.valueOf(bVar.e()));
                            }
                            synchronized (this.f315193e) {
                                this.f315193e.removeByKey(Long.valueOf(bVar.e()));
                            }
                            synchronized (this.f315194f) {
                                this.f315194f.remove(Long.valueOf(bVar.e()));
                            }
                            synchronized (this.f315195h) {
                                this.f315195h.remove(Long.valueOf(bVar.e()));
                            }
                            bVar.y().f315187m = bVar.f();
                            bVar.y().f315186i = bVar.y().f315185h;
                            bVar.y().E = bVar;
                            F(bVar.e());
                        }
                        z17 = true;
                    } else {
                        z17 = bVar.y().c();
                        if (z17) {
                            synchronized (this.f315194f) {
                                this.f315194f.remove(Long.valueOf(bVar.e()));
                            }
                            bVar.p(true);
                            bVar.t(false);
                            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelReq(bVar.j());
                            F(bVar.e());
                        }
                    }
                } else {
                    z17 = bVar.y().b();
                }
                if (!z17) {
                    int i17 = bVar.y().f315182d;
                    bVar.y().f315182d = i3;
                    bVar.y().f315183e = i16;
                    bVar.y().f315184f = com.tencent.mobileqq.weiyun.sdk.download.a.a(i16, str);
                    this.E.i(bVar, true);
                    M(bVar, i17, i3);
                    return;
                }
                return;
            }
            z16 = false;
        } else {
            F(bVar.e());
            i3 = 1;
            z16 = true;
        }
        if (!z16 && !bVar.y().a()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            synchronized (this.f315194f) {
                this.f315194f.remove(Long.valueOf(bVar.e()));
            }
            synchronized (this.f315195h) {
                this.f315195h.remove(Long.valueOf(bVar.e()));
            }
            bVar.p(false);
            this.F.c(bVar);
        }
        if (!z17) {
        }
    }

    public String o(com.tencent.mobileqq.weiyun.model.a aVar, String str, boolean z16, y43.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, aVar, str, Boolean.valueOf(z16), cVar);
        }
        return r(aVar, str, z16, cVar);
    }

    @Override // com.tencent.mobileqq.weiyun.sdk.download.processor.c.b
    public void onFetchError(long j3, int i3, String str) {
        com.tencent.mobileqq.weiyun.model.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Long.valueOf(j3), Integer.valueOf(i3), str);
            return;
        }
        synchronized (this.f315192d) {
            bVar = this.f315192d.get(Long.valueOf(j3));
        }
        if (bVar == null || bVar.k()) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(this.H)) {
            k(bVar, 5, ErrorCode.TRAN_NETWORK_NOT_AVAILABLE, null);
        } else {
            k(bVar, 5, i3, str);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.sdk.download.processor.a.InterfaceC8982a
    public void onInfoRestored(String str, List<com.tencent.mobileqq.weiyun.model.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, (Object) list);
            return;
        }
        if (TextUtils.equals(str, WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid()) && list != null && !list.isEmpty()) {
            synchronized (this.f315192d) {
                for (com.tencent.mobileqq.weiyun.model.b bVar : list) {
                    long e16 = bVar.e();
                    int i3 = bVar.y().f315182d;
                    bVar.y().f315182d = 0;
                    this.f315192d.put(Long.valueOf(e16), bVar);
                    if (i3 != 0 && i3 != 1 && i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 5) {
                                k(bVar, 5, bVar.y().f315183e, bVar.y().f315184f);
                            }
                        } else {
                            k(bVar, 3, 0, null);
                        }
                    } else {
                        k(bVar, 1, 0, null);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) netResp);
            return;
        }
        int i3 = netResp.mResult;
        if (i3 == 3) {
            return;
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i16 = netResp.mErrCode;
        Object userData = ((HttpNetReq) netResp.mReq).getUserData();
        if (userData != null && (userData instanceof com.tencent.mobileqq.weiyun.model.b)) {
            com.tencent.mobileqq.weiyun.model.b bVar = (com.tencent.mobileqq.weiyun.model.b) userData;
            if (bVar.k()) {
                return;
            }
            if (z16) {
                File file = new File(bVar.f());
                if (file.exists()) {
                    if (!J(WeiyunTransmissionGlobal.getInstance().getContext(), file)) {
                        IOUtils.scan2MediaStore(WeiyunTransmissionGlobal.getInstance().getContext(), file);
                    }
                    k(bVar, 4, 0, null);
                    return;
                }
                k(bVar, 5, ErrorCode.TRAN_DOWNLOAD_SPACE_LACK, null);
                return;
            }
            if (bVar.k()) {
                return;
            }
            if (com.tencent.mobileqq.weiyun.sdk.download.a.b(i16)) {
                k(bVar, 0, i16, null);
            } else {
                k(bVar, 5, i16, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        Object userData = netReq.getUserData();
        if (userData != null && (userData instanceof com.tencent.mobileqq.weiyun.model.b)) {
            com.tencent.mobileqq.weiyun.model.b bVar = (com.tencent.mobileqq.weiyun.model.b) userData;
            if (bVar.k()) {
                return;
            }
            if (bVar.y().b()) {
                k(bVar, 2, 0, null);
            }
            bVar.y().f315185h = j16;
            com.tencent.mobileqq.weiyun.model.c y16 = bVar.y();
            if (j3 >= j16) {
                j3 = j16;
            }
            y16.f315186i = j3;
            A(bVar, false);
        }
    }

    public void p(String str, String str2, String str3, String str4, y43.b bVar, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3, str4, bVar, str5);
            return;
        }
        HttpNetReq c16 = com.tencent.mobileqq.weiyun.model.b.c(str4, str, str2, str3, true, new d(bVar, str4, str2));
        this.f315196i.submit(new e(c16));
        if (str5 != null) {
            this.M.put(str5, c16);
        }
    }

    public void q(String str, String str2, String str3, y43.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, str3, bVar);
        } else {
            p(str, str2, null, str3, bVar, null);
        }
    }

    String r(com.tencent.mobileqq.weiyun.model.a aVar, String str, boolean z16, y43.c cVar) {
        int andIncrement = N.getAndIncrement();
        com.tencent.mobileqq.weiyun.model.b b16 = com.tencent.mobileqq.weiyun.model.b.b(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid(), aVar, str, new com.tencent.mobileqq.weiyun.model.c());
        b16.t(z16);
        b16.y().C = aVar.f315158e;
        b16.u(cVar);
        this.E.a(andIncrement, b16);
        return Integer.toString(andIncrement);
    }

    public String s(String str, String str2, String str3, String str4, y43.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, str, str2, str3, str4, cVar);
        }
        int andIncrement = N.getAndIncrement();
        p(str, str2, str3, str4, new C8981c(cVar, andIncrement), Integer.toString(andIncrement));
        return Integer.toString(andIncrement);
    }

    public String t(com.tencent.mobileqq.weiyun.model.a aVar, String str, y43.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, aVar, str, cVar);
        }
        return r(aVar, str, true, cVar);
    }

    public com.tencent.mobileqq.weiyun.model.b v(long j3) {
        com.tencent.mobileqq.weiyun.model.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (com.tencent.mobileqq.weiyun.model.b) iPatchRedirector.redirect((short) 18, (Object) this, j3);
        }
        synchronized (this.f315192d) {
            bVar = this.f315192d.get(Long.valueOf(j3));
        }
        if (bVar == null) {
            return null;
        }
        return com.tencent.mobileqq.weiyun.model.b.b(bVar.z(), bVar.g().clone(), bVar.o(), bVar.y().clone());
    }

    public com.tencent.mobileqq.weiyun.sdk.download.b w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.weiyun.sdk.download.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f315197m.clone();
    }

    public void x(y43.d dVar, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar, (Object) context);
            return;
        }
        this.C = dVar;
        if (dVar != null) {
            this.D = new ArrayList();
            ReleaseLooperHandler releaseLooperHandler = new ReleaseLooperHandler("weiyun_download-work-thread");
            this.E = new com.tencent.mobileqq.weiyun.sdk.download.processor.a(this, releaseLooperHandler);
            this.F = new com.tencent.mobileqq.weiyun.sdk.download.processor.b(this, releaseLooperHandler);
            this.G = new com.tencent.mobileqq.weiyun.sdk.download.processor.c(this, this.C, releaseLooperHandler);
            this.H = context;
            this.E.g(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid());
            return;
        }
        throw new NullPointerException("IFetchListener can not be null!");
    }

    boolean y(boolean z16) {
        Context context = WeiyunTransmissionGlobal.getInstance().getContext();
        boolean isTranOnlyWifi = WeiyunTransmissionStatus.getInstance().isTranOnlyWifi();
        if (!z16 && isTranOnlyWifi) {
            return NetworkUtils.isWifiAvailable(context);
        }
        return NetworkUtils.isNetworkAvailable(context);
    }

    void z(int i3, com.tencent.mobileqq.weiyun.model.b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f315193e) {
            this.f315193e.put(Long.valueOf(bVar.e()), Integer.toString(i3));
        }
        for (y43.c cVar : this.D) {
            if (cVar != null) {
                cVar.b(Integer.toString(i3));
            }
        }
        if (bVar.i() != null) {
            bVar.i().b(Integer.toString(i3));
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.I = new Object();
        this.L = new HashMap();
        this.M = new HashMap();
        this.f315192d = new HashMap<>();
        this.f315193e = new DualHashMap<>();
        this.f315194f = new HashSet<>();
        this.f315195h = new HashSet<>();
        this.f315196i = new ThreadPoolWrapper("WyDownloader");
        this.f315197m = new com.tencent.mobileqq.weiyun.sdk.download.b();
        this.J = new LinkedList<>();
        this.K = new LinkedList<>();
        AppNetConnInfo.registerConnectionChangeReceiver(this.H, new b());
    }
}
