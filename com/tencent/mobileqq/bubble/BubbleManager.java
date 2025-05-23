package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.qzone.widget.v;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.cache.api.Business;
import com.tencent.common.app.AppInterface;
import com.tencent.ditto.widget.DittoTextArea;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.activity.aio.vasbubble.BubbleTextColorManage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.a;
import com.tencent.mobileqq.bubble.c;
import com.tencent.mobileqq.bubble.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.business.BubbleBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.k;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import com.tencent.util.Pair;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BubbleManager implements Manager {
    static IPatchRedirector $redirector_;
    public static volatile boolean K;
    public static long L;
    public static long M;
    public static volatile int N;
    BubbleBusiness C;
    Map<String, Float> D;
    k E;
    float F;
    com.tencent.cache.api.collection.a<Integer, JSONObject> G;
    public final e H;
    public ConcurrentHashMap<String, com.tencent.mobileqq.bubble.a> I;
    public ConcurrentHashMap<String, d> J;

    /* renamed from: d, reason: collision with root package name */
    protected Context f200577d;

    /* renamed from: e, reason: collision with root package name */
    protected AppInterface f200578e;

    /* renamed from: f, reason: collision with root package name */
    protected com.tencent.cache.api.collection.a<Integer, com.tencent.mobileqq.bubble.c> f200579f;

    /* renamed from: h, reason: collision with root package name */
    protected Vector<Integer> f200580h;

    /* renamed from: i, reason: collision with root package name */
    private final List<String> f200581i;

    /* renamed from: m, reason: collision with root package name */
    public LruLinkedHashMap<Integer, com.tencent.mobileqq.bubble.b> f200582m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class HandleBubbleConfigRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        com.tencent.mobileqq.bubble.b f200584d;

        /* renamed from: e, reason: collision with root package name */
        int f200585e;

        /* renamed from: f, reason: collision with root package name */
        boolean f200586f;

        public HandleBubbleConfigRunnable(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BubbleManager.this, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                this.f200585e = i3;
                this.f200586f = z16;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String bubbleJsonPath = BubbleManager.this.C.getBubbleJsonPath(this.f200585e);
            this.f200584d = BubbleManager.this.h(this.f200585e, bubbleJsonPath);
            if (QLog.isColorLevel()) {
                QLog.d("BubbleManager", 2, "getBubbleConfig bubbleId=" + this.f200585e + ",filePath=" + bubbleJsonPath + ",bubbleConfig=" + this.f200584d);
            }
            if (this.f200584d != null) {
                BubbleManager.this.f200582m.put(Integer.valueOf(this.f200585e), this.f200584d);
            } else if (this.f200586f) {
                BubbleManager.this.n(this.f200585e, "config.json", "0");
                BubbleManager.this.p(this.f200585e);
            }
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.bubble.BubbleManager.HandleBubbleConfigRunnable.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HandleBubbleConfigRunnable.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            };
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class LruLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;
        private final Lock lock;
        protected final int maxCapacity;

        public LruLinkedHashMap(int i3) {
            super(i3, 0.75f, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BubbleManager.this, i3);
            } else {
                this.lock = new ReentrantLock();
                this.maxCapacity = i3;
            }
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            try {
                this.lock.lock();
                super.clear();
            } finally {
                this.lock.unlock();
            }
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (V) iPatchRedirector.redirect((short) 3, (Object) this, obj);
            }
            try {
                this.lock.lock();
                return (V) super.get(obj);
            } finally {
                this.lock.unlock();
            }
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V put(K k3, V v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3, (Object) v3);
            }
            try {
                this.lock.lock();
                return (V) super.put(k3, v3);
            } finally {
                this.lock.unlock();
            }
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entry)).booleanValue();
            }
            if (size() > this.maxCapacity) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends com.tencent.cache.api.collection.a<Integer, com.tencent.mobileqq.bubble.c> {
        static IPatchRedirector $redirector_;

        a(Business business, String str, int i3) {
            super(business, str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BubbleManager.this, business, str, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.cache.api.collection.a, com.tencent.cache.api.b, java.util.AbstractMap, java.util.Map
        public void clear() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            Map<Integer, com.tencent.mobileqq.bubble.c> i3 = i();
            if (i3 != null) {
                Iterator<com.tencent.mobileqq.bubble.c> it = i3.values().iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
                if (QLog.isColorLevel()) {
                    QLog.i("BubbleManager", 2, "BubbleInfoLruCache cleared, size = " + i3.size());
                }
            }
        }

        @Override // com.tencent.cache.api.collection.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void c(boolean z16, Integer num, com.tencent.mobileqq.bubble.c cVar, com.tencent.mobileqq.bubble.c cVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), num, cVar, cVar2);
                return;
            }
            super.c(z16, num, cVar, cVar2);
            cVar.a();
            if (QLog.isColorLevel()) {
                QLog.d("BubbleManager", 2, "entryRemoved key=" + num);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements IDownLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BubbleBusiness f200589a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f200590b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f200591c;

        b(BubbleBusiness bubbleBusiness, int i3, String str) {
            this.f200589a = bubbleBusiness;
            this.f200590b = i3;
            this.f200591c = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BubbleManager.this, bubbleBusiness, Integer.valueOf(i3), str);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) updateListenerParams);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) updateListenerParams);
                return;
            }
            if (this.f200589a.isFileExists(this.f200590b)) {
                BubbleManager.this.h0("bubble.android." + this.f200590b + BubbleBusiness.STATIC_FILE_PACK_NAME, "", this.f200591c, 0, 0);
                BubbleManager.this.h0("bubble.android." + this.f200590b + ".other.zip", "", this.f200591c, 0, 0);
                BubbleManager.this.h0("bubble.android." + this.f200590b + BubbleBusiness.CONFIG_FILE_NAME, "", this.f200591c, 0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f200593a;

        /* renamed from: b, reason: collision with root package name */
        private com.tencent.mobileqq.bubble.c f200594b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f200595c;

        /* renamed from: d, reason: collision with root package name */
        private String f200596d;

        /* renamed from: e, reason: collision with root package name */
        private BitmapFactory.Options f200597e;

        public c(int i3, com.tencent.mobileqq.bubble.c cVar, boolean z16, String str, BitmapFactory.Options options) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BubbleManager.this, Integer.valueOf(i3), cVar, Boolean.valueOf(z16), str, options);
                return;
            }
            this.f200593a = i3;
            this.f200594b = cVar;
            this.f200595c = z16;
            this.f200596d = str;
            this.f200597e = options;
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f200596d;
        }

        public c b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (c) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            if (this.f200595c) {
                Bitmap m3 = BubbleManager.m(this.f200594b.f200669b, this.f200597e);
                if (m3 != null) {
                    byte[] ninePatchChunk = m3.getNinePatchChunk();
                    if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
                        this.f200594b.f200670c = new NinePatch(m3, ninePatchChunk, null);
                    } else {
                        this.f200595c = false;
                        this.f200596d = "nor9pngErr";
                        QLog.e("BubbleManager", 1, "createBubbleInfo, normal bg chunk null or not nine patch, chunk=" + ninePatchChunk + ", bubbleId=" + this.f200593a);
                    }
                } else {
                    this.f200595c = false;
                    this.f200596d = "norDecodeErr";
                    QLog.e("BubbleManager", 1, "createBubbleInfo, decode normal bg null, bubbleId=" + this.f200593a);
                }
            }
            if (this.f200595c) {
                Bitmap m16 = BubbleManager.m(this.f200594b.f200671d, this.f200597e);
                if (m16 != null) {
                    byte[] ninePatchChunk2 = m16.getNinePatchChunk();
                    if (ninePatchChunk2 != null && NinePatch.isNinePatchChunk(ninePatchChunk2)) {
                        this.f200594b.f200672e = new NinePatch(m16, ninePatchChunk2, null);
                    } else {
                        this.f200595c = false;
                        this.f200596d = "9pngErr";
                        QLog.e("BubbleManager", 1, "createBubbleInfo, animation bg chunk null or not nine patch, chunk=" + ninePatchChunk2 + ", bubbleId=" + this.f200593a);
                    }
                } else {
                    this.f200595c = false;
                    this.f200596d = "decodeErr";
                    QLog.e("BubbleManager", 1, "createBubbleInfo, decode animation bg null, bubbleId=" + this.f200593a);
                }
            }
            return this;
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.f200595c;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71027);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
            return;
        }
        L = 1000L;
        M = MiniBoxNoticeInfo.MIN_5;
        N = 0;
    }

    public BubbleManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f200581i = new ArrayList();
        this.C = (BubbleBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(BubbleBusiness.class);
        this.E = null;
        this.F = 1.0f;
        Business business = Business.AIO;
        this.G = new com.tencent.cache.api.collection.a<>(business, "BubbleVersionInfo", 100);
        this.H = new e(this);
        this.I = new ConcurrentHashMap<>();
        this.J = new ConcurrentHashMap<>();
        this.f200578e = appInterface;
        this.f200577d = appInterface.getApp().getApplicationContext();
        this.f200579f = new a(business, "BubbleInfoCache", 50);
        this.f200582m = new LruLinkedHashMap<>(9);
        float f16 = this.f200577d.getResources().getDisplayMetrics().density;
        this.F = f16 != 160.0f ? f16 : 1.0f;
        this.f200580h = new Vector<>(16);
        this.D = new ConcurrentHashMap();
    }

    private void A(com.tencent.mobileqq.bubble.b bVar, JSONArray jSONArray) throws JSONException {
        if (jSONArray != null && jSONArray.length() > 0) {
            bVar.f200666w = new ArrayList<>(jSONArray.length());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                bVar.f200666w.add(jSONArray.getString(i3));
            }
        }
    }

    private void A0(int i3, float f16) {
        Iterator<String> it = this.D.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next.startsWith(i3 + "_")) {
                this.D.remove(next);
                break;
            }
        }
        this.D.put(i3 + "_" + System.currentTimeMillis(), Float.valueOf(f16));
    }

    private int C(String str, int i3) {
        int D = D(str);
        if (i3 == 0) {
            A0(D, 1.0f);
        } else {
            A0(D, 2.0f);
        }
        synchronized (this.f200581i) {
            if (this.f200581i.contains(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("BubbleManager", 2, str + " download completed, remove from download queue.");
                }
                this.f200581i.remove(str);
            }
        }
        return D;
    }

    private boolean C0(int i3) {
        File file = new File(G(), i3 + PluginUtils.CONFIG_FILE_EXTEND_NAME);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("BubbleManager", 2, "readLocalVersionInfo local info not exist id = " + i3);
            }
            return false;
        }
        String readFileToStringEx = FileUtils.readFileToStringEx(file, -1);
        if (TextUtils.isEmpty(readFileToStringEx)) {
            if (QLog.isColorLevel()) {
                QLog.d("BubbleManager", 2, "readLocalVersionInfo read local info fail id = " + i3);
            }
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(readFileToStringEx);
            synchronized (this.G) {
                this.G.f(Integer.valueOf(i3), jSONObject);
            }
            if (jSONObject.optInt("full_download") != 1) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e("BubbleManager", 1, "readLocalVersionInfo id = " + i3 + " error: ", e16);
            return false;
        }
    }

    @NotNull
    private com.tencent.mobileqq.bubble.c E(int i3, com.tencent.mobileqq.bubble.b bVar) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        if (bVar.f200655l != null) {
            for (int i16 = 0; i16 < bVar.f200655l.size(); i16++) {
                com.tencent.mobileqq.bubble.a aVar = bVar.f200655l.get(i16);
                int i17 = 0;
                while (true) {
                    String[] strArr = aVar.f200626i;
                    if (i17 < strArr.length) {
                        String str = strArr[i17];
                        arrayList.add(str);
                        hashMap.put(str, aVar.f200619b);
                        i17++;
                    }
                }
            }
        }
        return new com.tencent.mobileqq.bubble.c(i3, "", "", "", "", bVar.f200660q, bVar.f200646c, bVar.f200647d, bVar.f200648e, bVar.f200649f, bVar.f200650g, bVar.f200651h, (String[]) arrayList.toArray(new String[0]), null, 0, 0, null, null, hashMap);
    }

    private Boolean E0(int i3, JSONObject jSONObject) {
        File file = new File(G(), i3 + PluginUtils.CONFIG_FILE_EXTEND_NAME);
        if (file.exists()) {
            file.delete();
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                    try {
                        randomAccessFile2.write(jSONObject.toString().getBytes());
                        randomAccessFile2.close();
                        return Boolean.TRUE;
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        randomAccessFile = randomAccessFile2;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return Boolean.FALSE;
                    } catch (IOException e17) {
                        e = e17;
                        randomAccessFile = randomAccessFile2;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return Boolean.FALSE;
                    } catch (Throwable th5) {
                        th = th5;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e19) {
                    e = e19;
                } catch (IOException e26) {
                    e = e26;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e27) {
            e27.printStackTrace();
        }
    }

    private void H0(JSONObject jSONObject, d.b bVar) throws JSONException {
        if (jSONObject.has("img_alpha")) {
            JSONArray jSONArray = jSONObject.getJSONArray("img_alpha");
            bVar.f200733w = jSONArray.getInt(0);
            bVar.f200734x = jSONArray.getInt(1);
        }
        if (jSONObject.has("repeat")) {
            bVar.f200707c = jSONObject.getInt("repeat");
        }
        if (jSONObject.has("img_rotate")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("img_rotate");
            bVar.f200735y = jSONArray2.getInt(0);
            bVar.f200736z = jSONArray2.getInt(1);
        }
        if (jSONObject.has("img_count")) {
            bVar.f200708d = jSONObject.getInt("img_count");
        }
        if (jSONObject.has("periodical")) {
            bVar.A = jSONObject.getBoolean("periodical");
        }
        if (jSONObject.has("period_length")) {
            bVar.B = jSONObject.getInt("period_length");
        }
    }

    private void I0(com.tencent.mobileqq.bubble.b bVar, JSONObject jSONObject) throws JSONException {
        JSONObject s16;
        if (jSONObject.has("bubbleframe_animation")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("bubbleframe_animation");
            if (!jSONObject2.has("animation_set") || (s16 = s(jSONObject2.getString("animation_set"), jSONObject)) == null) {
                return;
            }
            com.tencent.mobileqq.bubble.a n06 = n0(s16);
            n06.f200619b = jSONObject2.getString("animation_set");
            bVar.f200656m = n06;
            if (!TextUtils.isEmpty(n06.f200618a)) {
                bVar.f200659p.add(n06.f200618a);
            }
        }
    }

    private void K(JSONObject jSONObject, com.tencent.mobileqq.bubble.a aVar) throws JSONException {
        JSONArray jSONArray;
        if (jSONObject.has("cut_array") && (jSONArray = jSONObject.getJSONArray("cut_array")) != null && jSONArray.length() > 0) {
            aVar.f200627j = new int[jSONArray.length()];
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                aVar.f200627j[i3] = jSONArray.getInt(i3);
            }
            Arrays.sort(aVar.f200627j);
        }
    }

    private Float L(int i3) {
        String str;
        long j3;
        try {
            Iterator<String> it = this.D.keySet().iterator();
            while (it.hasNext()) {
                str = it.next();
                if (str.startsWith(i3 + "_")) {
                    StringBuilder sb5 = new StringBuilder(str);
                    j3 = Long.valueOf(sb5.substring(sb5.indexOf("_") + 1)).longValue();
                    break;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        str = "";
        j3 = 0;
        if (j3 == 0 || "".equals(str)) {
            return null;
        }
        if (System.currentTimeMillis() - j3 > M) {
            this.D.remove(str);
            return null;
        }
        return this.D.get(str);
    }

    private ArrayList<d> M(JSONArray jSONArray) throws JSONException {
        d N2;
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList<d> arrayList = new ArrayList<>(jSONArray.length());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject.has("pendent_prefix")) {
                    N2 = O(jSONObject);
                } else {
                    N2 = N(jSONObject);
                }
                arrayList.add(N2);
            }
            return arrayList;
        }
        return null;
    }

    private d N(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            QLog.e("BubbleManager", 1, "getPathAnimConf object == null");
            return null;
        }
        d.b bVar = new d.b();
        if (jSONObject.has("key")) {
            bVar.f200705a = jSONObject.getString("key");
        }
        if (jSONObject.has("start_end")) {
            JSONArray jSONArray = jSONObject.getJSONArray("start_end");
            bVar.f200723m = (float) jSONArray.getDouble(0);
            bVar.f200724n = (float) jSONArray.getDouble(1);
            bVar.f200725o = (float) jSONArray.getDouble(2);
            bVar.f200726p = (float) jSONArray.getDouble(3);
        }
        if (jSONObject.has("bezier")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("bezier");
            bVar.f200727q = (float) jSONArray2.getDouble(0);
            bVar.f200728r = (float) jSONArray2.getDouble(1);
            bVar.f200729s = (float) jSONArray2.getDouble(2);
            bVar.f200730t = (float) jSONArray2.getDouble(3);
        }
        if (jSONObject.has("duration")) {
            bVar.f200706b = jSONObject.getInt("duration");
        }
        if (jSONObject.has("speed")) {
            bVar.f200731u = jSONObject.getInt("speed");
        }
        if (jSONObject.has("img_prefix")) {
            bVar.f200709e = jSONObject.getString("img_prefix");
        }
        if (jSONObject.has("img_reverse")) {
            bVar.f200732v = jSONObject.getBoolean("img_reverse");
        }
        H0(jSONObject, bVar);
        return bVar;
    }

    private d O(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            QLog.e("BubbleManager", 1, "getPendantAnimConf object == null");
            return null;
        }
        d.c cVar = new d.c();
        if (jSONObject.has("key")) {
            cVar.f200705a = jSONObject.getString("key");
        }
        if (jSONObject.has("duration")) {
            cVar.f200706b = jSONObject.getInt("duration");
        }
        if (jSONObject.has("repeat")) {
            cVar.f200707c = jSONObject.getInt("repeat");
        }
        if (jSONObject.has("pendent_prefix")) {
            cVar.f200709e = jSONObject.getString("pendent_prefix");
        }
        if (jSONObject.has("img_count")) {
            cVar.f200708d = jSONObject.getInt("img_count");
        }
        if (jSONObject.has("play_with")) {
            cVar.f200737m = jSONObject.getString("play_with");
        }
        return cVar;
    }

    private Rect P(int i3, int i16, int i17, int i18) {
        Rect rect = new Rect();
        float f16 = this.F;
        rect.set((int) ((i3 / 2.0f) * f16), (int) ((i16 / 2.0f) * f16), (int) ((i17 / 2.0f) * f16), (int) ((i18 / 2.0f) * f16));
        return rect;
    }

    private void Q(JSONObject jSONObject, com.tencent.mobileqq.bubble.a aVar) throws JSONException {
        if (jSONObject.has(CanvasView.ACTION_RECT)) {
            JSONArray jSONArray = jSONObject.getJSONArray(CanvasView.ACTION_RECT);
            aVar.f200624g = new int[4];
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                aVar.f200624g[i3] = jSONArray.getInt(i3);
            }
        }
    }

    private void R(com.tencent.mobileqq.bubble.a aVar, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("type")) {
            String string = jSONObject.getString("type");
            if ("line".equalsIgnoreCase(string)) {
                aVar.f200630m = 10;
            }
            if (WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_CIRCLE.equalsIgnoreCase(string)) {
                aVar.f200630m = 11;
            }
            if ("static".equalsIgnoreCase(string)) {
                aVar.f200630m = 1;
            }
        }
    }

    @Nullable
    private Boolean S(int i3) {
        com.tencent.mobileqq.bubble.b z16;
        if (new File(this.C.getBubbleJsonPath(i3)).exists() && (z16 = z(i3, false)) != null) {
            return Boolean.valueOf(z16.b(B(i3)));
        }
        return null;
    }

    @Nullable
    private Boolean T(int i3) {
        String[] list;
        boolean z16;
        File file = new File(B(i3), "static");
        if (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length >= 3) {
            List asList = Arrays.asList(list);
            if (asList.contains(BubbleBusiness.AIO_USER_BG_NOR) && asList.contains(BubbleBusiness.AIO_USER_PIC_NOR) && asList.contains("chat_bubble_thumbnail.png")) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
        return null;
    }

    private void U(com.tencent.mobileqq.bubble.a aVar, c.a aVar2) {
        aVar2.f200694a = aVar.f200623f;
        aVar2.f200697d = aVar.f200625h;
        int i3 = aVar.f200622e;
        aVar2.f200695b = i3;
        aVar2.f200701h = aVar.f200629l;
        aVar2.f200704k = aVar;
        if (i3 <= 1) {
            aVar2.f200696c = true;
        } else {
            aVar2.f200696c = false;
        }
    }

    private void Y(int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, "createBubbleInfo, isCheckOk=" + z16 + ", bubbleId=" + i3);
        }
    }

    private void a0(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, str);
        }
    }

    private void b0(int i3, String str, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, str + Integer.toHexString(i3) + ",  now chage to " + Integer.toHexString(i16));
        }
    }

    private boolean c(com.tencent.mobileqq.bubble.a aVar, File file, String[] strArr, boolean z16) {
        String str;
        if (aVar.f200621d == 4) {
            str = "%04d.9.png";
        } else {
            str = "%04d.png";
        }
        int i3 = 0;
        while (i3 < strArr.length) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(file.getAbsolutePath());
            sb5.append(File.separatorChar);
            int i16 = i3 + 1;
            sb5.append(String.format(str, Integer.valueOf(i16)));
            strArr[i3] = sb5.toString();
            boolean exists = new File(strArr[i3]).exists();
            if (QLog.isColorLevel()) {
                QLog.d("BubbleManager", 2, "checkBubbleSource|pngs[" + i3 + "]=" + strArr[i3] + ",isFileExists=" + exists);
            }
            if (!exists) {
                return true;
            }
            i3 = i16;
        }
        return z16;
    }

    private void c0(int i3, String str, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "getAttrsByConfig, bubbleId = " + i3 + " animName = " + str + " autoDown = " + z16 + " reversion = " + z17);
        }
    }

    private boolean d(com.tencent.mobileqq.bubble.a aVar, File file, String[] strArr, boolean z16) {
        int size = aVar.f200638u.size();
        boolean z17 = z16;
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            a.C7439a valueAt = aVar.f200638u.valueAt(i16);
            int i17 = 0;
            while (true) {
                if (i17 >= valueAt.f200641a) {
                    break;
                }
                int i18 = i17 + i3;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(file.getAbsolutePath());
                sb5.append(File.separatorChar);
                sb5.append(valueAt.f200643c);
                int i19 = i17 + 1;
                sb5.append(String.format("%04d.png", Integer.valueOf(i19)));
                strArr[i18] = sb5.toString();
                boolean exists = new File(strArr[i18]).exists();
                if (QLog.isColorLevel()) {
                    QLog.d("BubbleManager", 2, "checkBubbleSource|pngs[" + i17 + "]=" + strArr[i17] + ",isFileExists=" + exists);
                }
                if (!exists) {
                    z17 = true;
                    break;
                }
                i17 = i19;
            }
            if (z17) {
                break;
            }
            i3 += valueAt.f200641a;
        }
        return z17;
    }

    private void d0(int i3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, "createBubbleInfo, bubbleId=" + i3 + ", autoAsyncDownload=" + z16);
        }
    }

    private boolean e(com.tencent.mobileqq.bubble.c cVar, boolean z16) {
        if ((!z16 || !TextUtils.isEmpty(cVar.f200674g)) && !TextUtils.isEmpty(cVar.f200673f) && !TextUtils.isEmpty(cVar.f200669b) && !TextUtils.isEmpty(cVar.f200671d)) {
            if (QLog.isColorLevel()) {
                QLog.d("BubbleManager", 2, "checkBubbleStaticSource|bubbleId=" + cVar.f200668a + ",chkStaticSrcAndUpdate is ok | not empty");
                return false;
            }
            return false;
        }
        return true;
    }

    private void e0(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, str);
        }
    }

    private boolean f(com.tencent.mobileqq.bubble.c cVar, List<String> list) {
        for (String str : list) {
            if (!new File(str).exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d("BubbleManager", 2, "checkBubbleStaticSource|file is not exists,bubbleId=" + cVar.f200668a + ",strFilePath=" + str);
                    return true;
                }
                return true;
            }
        }
        return false;
    }

    private void f0(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, str2 + str);
        }
    }

    private boolean g(com.tencent.mobileqq.bubble.c cVar) {
        if (cVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BubbleManager", 2, "checkBubbleStaticSource|bubbleInfo is null");
            }
            return false;
        }
        StringBuilder P = l.P();
        P.append(B(cVar.f200668a).getAbsolutePath());
        P.append(File.separatorChar);
        P.append("chartlet");
        P.append(File.separatorChar);
        String sb5 = P.toString();
        StringBuilder P2 = l.P();
        P2.append(sb5);
        P2.append("chartlet.png");
        String sb6 = P2.toString();
        boolean exists = new File(sb6).exists();
        if (!e(cVar, exists)) {
            return true;
        }
        StringBuilder P3 = l.P();
        P3.append(B(cVar.f200668a).getAbsolutePath());
        P3.append(File.separatorChar);
        P3.append("static");
        P3.append(File.separatorChar);
        String sb7 = P3.toString();
        StringBuilder P4 = l.P();
        P4.append(sb7);
        P4.append(BubbleBusiness.AIO_USER_BG_NOR);
        String sb8 = P4.toString();
        StringBuilder P5 = l.P();
        P5.append(sb7);
        P5.append(BubbleBusiness.AIO_USER_PIC_NOR);
        String sb9 = P5.toString();
        StringBuilder P6 = l.P();
        P6.append(sb7);
        P6.append("chat_bubble_thumbnail.png");
        String sb10 = P6.toString();
        ArrayList arrayList = new ArrayList();
        arrayList.add(sb8);
        arrayList.add(sb9);
        arrayList.add(sb10);
        if (exists) {
            arrayList.add(sb6);
        }
        if (f(cVar, arrayList)) {
            return false;
        }
        cVar.f200673f = sb10;
        cVar.f200669b = sb8;
        cVar.f200671d = sb9;
        cVar.f200674g = sb6;
        cVar.f200675h = this.H.a(cVar.f200668a);
        try {
            x(cVar, m(sb10, null));
        } catch (Exception e16) {
            QLog.e("BubbleManager", 2, "bubble change color throws exception!", e16);
        } catch (OutOfMemoryError e17) {
            QLog.e("BubbleManager", 2, "bubble change color out of memory error!", e17);
        }
        return true;
    }

    private void g0(String str, String str2, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, String.format("onDownloadComplete, scid %s, errorcode %d, from %s, httpCode %d", str, Integer.valueOf(i3), str2, Integer.valueOf(i16)));
        }
    }

    private void j(String str, int i3, int i16) {
        if (i3 == 0) {
            F0(i16);
        }
        if (!str.equals("0") && this.E != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("srcType", 3);
            bundle.putString("callbackId", str);
            this.E.a(i16, i3, bundle);
        }
    }

    private void k(int i3, int i16) {
        if (i3 == 0) {
            File file = new File(this.C.getBubbleJsonPath(i16));
            if (file.exists()) {
                com.tencent.mobileqq.bubble.b h16 = h(i16, file.getAbsolutePath());
                if (QLog.isColorLevel()) {
                    QLog.d("BubbleManager", 2, "onDownloadComplete|bubbleId=" + i16 + ",createBubbleConfig bubbleConfig=" + h16);
                }
                if (h16 != null) {
                    this.f200582m.put(Integer.valueOf(i16), h16);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BubbleManager", 2, "onDownloadComplete|" + file.getAbsolutePath() + " not exist");
            }
        }
    }

    private void k0(com.tencent.mobileqq.bubble.b bVar, JSONObject jSONObject, JSONArray jSONArray, ArrayList<com.tencent.mobileqq.bubble.a> arrayList, int i3) throws JSONException {
        JSONObject r16;
        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
        if (!jSONObject2.has("animation") || (r16 = r(jSONObject2.getString("animation"), jSONObject)) == null) {
            return;
        }
        com.tencent.mobileqq.bubble.a r06 = r0(1, r16);
        JSONArray jSONArray2 = jSONObject2.getJSONArray(QCircleSchemeAttr.Detail.KEY_WORD);
        r06.f200626i = new String[jSONArray2.length()];
        for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
            r06.f200626i[i16] = jSONArray2.getString(i16);
        }
        r06.f200619b = jSONObject2.getString("animation");
        arrayList.add(r06);
        if (!TextUtils.isEmpty(r06.f200618a)) {
            bVar.f200659p.add(r06.f200618a);
        }
    }

    private void l(String str, int i3, int i16) {
        com.tencent.mobileqq.bubble.c e16;
        if (i3 == 0) {
            i(i16, false);
            Pair<c.a, c.a> j06 = j0(i16, q(i16, "static"), false);
            if (j06 != null && (e16 = this.f200579f.e(Integer.valueOf(i16))) != null) {
                e16.f200689v.add(j06);
            }
        }
        if (!str.equals("0") && this.E != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("srcType", 3);
            bundle.putString("callbackId", str);
            this.E.a(i16, i3, bundle);
        }
    }

    private void l0(com.tencent.mobileqq.bubble.b bVar, JSONObject jSONObject) throws JSONException {
        JSONObject r16;
        JSONObject r17;
        y0(bVar, jSONObject);
        if (jSONObject.has("height_animation")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("height_animation");
            if (jSONObject2.has("animation") && (r17 = r(jSONObject2.getString("animation"), jSONObject)) != null) {
                VasCommonReporter.getHistoryFeature().setValue1("bubble").setValue2(String.valueOf(bVar.f200644a)).setValue3("height_animation").report();
                com.tencent.mobileqq.bubble.a r06 = r0(2, r17);
                JSONArray jSONArray = r17.getJSONArray("height_interval");
                jSONArray.getInt(0);
                jSONArray.getInt(1);
                r06.f200619b = jSONObject2.getString("animation");
                bVar.f200653j = r06;
                if (!TextUtils.isEmpty(r06.f200618a)) {
                    bVar.f200659p.add(r06.f200618a);
                }
            }
        }
        if (jSONObject.has("width_animation")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("width_animation");
            if (jSONObject3.has("animation") && (r16 = r(jSONObject3.getString("animation"), jSONObject)) != null) {
                VasCommonReporter.getHistoryFeature().setValue1("bubble").setValue2(String.valueOf(bVar.f200644a)).setValue3("width_animation").report();
                com.tencent.mobileqq.bubble.a r07 = r0(3, r16);
                r07.f200619b = jSONObject3.getString("animation");
                if (jSONObject3.has("width")) {
                    r07.f200637t = (int) (((WindowManager) this.f200577d.getSystemService("window")).getDefaultDisplay().getWidth() * (jSONObject3.getInt("width") / 100.0d));
                }
                bVar.f200654k = r07;
                if (!TextUtils.isEmpty(r07.f200618a)) {
                    bVar.f200659p.add(r07.f200618a);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        if (r4 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0050, code lost:
    
        if (r4 == null) goto L39;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v14, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v16, types: [android.graphics.Bitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap m(String str, BitmapFactory.Options options) {
        InputStream inputStream;
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        ?? r26 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
                bufferedInputStream = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                fileInputStream = null;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                if (fileInputStream2 != null) {
                }
                if (inputStream == null) {
                }
            }
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    if (options != null) {
                        str = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    } else {
                        str = BitmapFactory.decodeStream(bufferedInputStream);
                    }
                    r26 = str;
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception e18) {
                    e = e18;
                    QLog.e("BubbleManager", 1, "Unable to decode stream: " + e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    QLog.e("BubbleManager", 1, "decode bitmap error, oom occurred, pathName=" + str, e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                }
            } catch (Exception e26) {
                e = e26;
                bufferedInputStream = null;
            } catch (OutOfMemoryError e27) {
                e = e27;
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                inputStream = null;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                if (inputStream == null) {
                    try {
                        inputStream.close();
                        throw th;
                    } catch (IOException unused5) {
                        throw th;
                    }
                }
                throw th;
            }
            try {
                bufferedInputStream.close();
            } catch (IOException unused6) {
                return r26;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private void m0(com.tencent.mobileqq.bubble.a aVar, JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            QLog.e("BubbleManager", 1, "parseAttrInPathAnimation animation = null");
            return;
        }
        R(aVar, jSONObject);
        if (jSONObject.has("padding")) {
            JSONArray jSONArray = jSONObject.getJSONArray("padding");
            aVar.f200631n = jSONArray.getInt(0);
            aVar.f200633p = jSONArray.getInt(1);
            aVar.f200632o = jSONArray.getInt(2);
            aVar.f200634q = jSONArray.getInt(3);
        }
        if (!jSONObject.has("step")) {
            return;
        }
        if (aVar.f200638u == null) {
            aVar.f200638u = new SparseArray<>(3);
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("step");
        if (jSONObject2.has("static")) {
            aVar.f200638u.put(0, s0("static", jSONObject2.getJSONObject("static")));
        }
        if (jSONObject2.has("moving")) {
            aVar.f200638u.put(1, s0("moving", jSONObject2.getJSONObject("moving")));
        }
        if (jSONObject2.has("turnback")) {
            aVar.f200638u.put(2, s0("turnback", jSONObject2.getJSONObject("turnback")));
        }
    }

    private com.tencent.mobileqq.bubble.a n0(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            QLog.e("BubbleManager", 1, "parseBubbleFrameAnimationConfig object = null");
            return null;
        }
        com.tencent.mobileqq.bubble.a aVar = new com.tencent.mobileqq.bubble.a();
        aVar.f200621d = 4;
        aVar.f200630m = 1;
        if (jSONObject.has("repeat")) {
            aVar.f200622e = jSONObject.getInt("repeat");
        }
        if (jSONObject.has("count")) {
            aVar.f200623f = jSONObject.getInt("count");
        }
        if (jSONObject.has(v.COLUMN_ZIP_NAME)) {
            aVar.f200618a = jSONObject.getString(v.COLUMN_ZIP_NAME);
        }
        if (jSONObject.has("time")) {
            aVar.f200625h = jSONObject.getInt("time");
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3) {
        if (b(i3)) {
            o(i3, new String[]{"bubble.android." + i3 + ".static.zip", "bubble.android." + i3 + ".other.zip"}, "0");
        } else {
            n(i3, "static.zip", "0");
        }
        if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, "createBubbleInfo, download bubble resource, bubbleId=" + i3);
        }
    }

    private void p0(com.tencent.mobileqq.bubble.b bVar, JSONObject jSONObject) {
        if (jSONObject.has("loopList")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("loopList");
                if (jSONArray != null && jSONArray.length() > 0) {
                    bVar.f200662s = new ArrayList<>();
                    bVar.f200663t = 0;
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        bVar.f200662s.add(Integer.valueOf(jSONArray.getInt(i3)));
                    }
                    f0(TextUtils.join(",", bVar.f200662s), "bubble loopList: ");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("BubbleManager", 2, "", e16);
                }
            }
        }
    }

    private void q0(com.tencent.mobileqq.bubble.b bVar, JSONObject jSONObject) throws JSONException {
        x0(bVar, jSONObject);
        v0(bVar, jSONObject);
        if (jSONObject.has("shadow_blur_color")) {
            bVar.f200649f = true;
            String string = jSONObject.getString("shadow_blur_color");
            if (string.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                string = string.substring(2);
            }
            try {
                bVar.f200648e = Color.parseColor("#" + string);
                return;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("BubbleManager", 2, "strokeColor invalid");
                    return;
                }
                return;
            }
        }
        if (jSONObject.has("shadow_color")) {
            bVar.f200650g = true;
            String string2 = jSONObject.getString("shadow_color");
            if (string2.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                string2 = string2.substring(2);
            }
            try {
                bVar.f200648e = Color.parseColor("#" + string2);
            } catch (Exception unused2) {
                if (QLog.isColorLevel()) {
                    QLog.d("BubbleManager", 2, "strokeColor invalid");
                }
            }
        }
    }

    private JSONObject r(String str, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        if (!jSONObject.has("animations") || (jSONObject2 = jSONObject.getJSONObject("animations")) == null) {
            return null;
        }
        return jSONObject2.getJSONObject(str);
    }

    private com.tencent.mobileqq.bubble.a r0(int i3, JSONObject jSONObject) throws JSONException {
        com.tencent.mobileqq.bubble.a aVar = new com.tencent.mobileqq.bubble.a();
        aVar.f200621d = i3;
        if (jSONObject == null) {
            QLog.e("BubbleManager", 1, "parseCommonAnimationConfig animation = null");
            return null;
        }
        Q(jSONObject, aVar);
        if (jSONObject.has("cycle_count")) {
            aVar.f200622e = jSONObject.getInt("cycle_count");
        }
        if (jSONObject.has("count")) {
            aVar.f200623f = jSONObject.getInt("count");
        }
        if (jSONObject.has(v.COLUMN_ZIP_NAME)) {
            aVar.f200618a = jSONObject.getString(v.COLUMN_ZIP_NAME);
        }
        if (jSONObject.has("second_zip_name")) {
            aVar.f200620c = jSONObject.getString("second_zip_name");
        }
        if (jSONObject.has("align")) {
            aVar.f200628k = jSONObject.getString("align");
        }
        if (jSONObject.has(com.tencent.luggage.wxa.c8.c.f123400v)) {
            aVar.f200629l = jSONObject.getBoolean(com.tencent.luggage.wxa.c8.c.f123400v);
        }
        if (jSONObject.has("displayChartlet")) {
            aVar.f200635r = jSONObject.getBoolean("displayChartlet");
        }
        if (jSONObject.has("mirror")) {
            aVar.f200636s = jSONObject.getBoolean("mirror");
        }
        m0(aVar, jSONObject);
        aVar.f200625h = jSONObject.getInt("time");
        return aVar;
    }

    private JSONObject s(String str, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        if (!jSONObject.has("animation_sets") || (jSONObject2 = jSONObject.getJSONObject("animation_sets")) == null) {
            return null;
        }
        return jSONObject2.getJSONObject(str);
    }

    private a.C7439a s0(String str, JSONObject jSONObject) throws JSONException {
        a.C7439a c7439a = new a.C7439a();
        if (jSONObject == null) {
            QLog.e("BubbleManager", 1, "parseEachStepAttrInPathAnim jsonObject = null");
            return null;
        }
        if (jSONObject.has("count")) {
            c7439a.f200641a = jSONObject.getInt("count");
        }
        if (jSONObject.has("cycle_count")) {
            c7439a.f200642b = jSONObject.getInt("cycle_count");
        }
        if (jSONObject.has("prefix_name")) {
            c7439a.f200643c = jSONObject.getString("prefix_name");
        }
        return c7439a;
    }

    private int t(String str, boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("T")) {
                return u(z16, 3, 4);
            }
            if (str.equals("L")) {
                return u(z16, 2, 7);
            }
            if (str.equals("TL")) {
                return u(z16, 0, 5);
            }
            if (str.equals("B")) {
                return u(z16, 4, 3);
            }
            if (str.equals("BL")) {
                return u(z16, 1, 6);
            }
            if (str.equals(BdhLogUtil.LogTag.Tag_Req)) {
                return u(z16, 7, 2);
            }
            if (str.equals("TR")) {
                return u(z16, 5, 0);
            }
            if (str.equals("BR")) {
                return u(z16, 6, 1);
            }
        }
        return -1;
    }

    private void t0(com.tencent.mobileqq.bubble.b bVar, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("voiceprint_animation")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("voiceprint_animation");
            if (jSONObject2.has("animation_set")) {
                VasCommonReporter.getHistoryFeature().setValue1("bubble").setValue2(String.valueOf(bVar.f200644a)).setValue3("voiceprint_animation").report();
                JSONObject s16 = s(jSONObject2.getString("animation_set"), jSONObject);
                if (s16 != null) {
                    com.tencent.mobileqq.bubble.a z06 = z0(s16);
                    z06.f200619b = jSONObject2.getString("animation_set");
                    bVar.f200657n = z06;
                    if (!TextUtils.isEmpty(z06.f200618a)) {
                        bVar.f200659p.add(z06.f200618a);
                    }
                }
            }
        }
        if (jSONObject.has("key_animations")) {
            JSONArray jSONArray = jSONObject.getJSONArray("key_animations");
            ArrayList<com.tencent.mobileqq.bubble.a> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                k0(bVar, jSONObject, jSONArray, arrayList, i3);
            }
            bVar.f200655l = arrayList;
        }
    }

    private int u(boolean z16, int i3, int i16) {
        if (z16) {
            return i16;
        }
        return i3;
    }

    private void u0(com.tencent.mobileqq.bubble.b bVar, JSONObject jSONObject, JSONObject jSONObject2, String str) throws Exception {
        String optString = jSONObject2.optString(str);
        JSONObject s16 = s(optString, jSONObject);
        d.a aVar = new d.a();
        aVar.a(bVar.f200644a, optString, s16);
        bVar.f200667x.put(str, aVar);
    }

    private boolean v(String str, com.tencent.mobileqq.bubble.b bVar, com.tencent.mobileqq.bubble.a aVar) {
        if (aVar != null && aVar.f200619b.equals(str)) {
            return true;
        }
        return false;
    }

    private void v0(com.tencent.mobileqq.bubble.b bVar, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(DittoTextArea.LinkColor)) {
            String string = jSONObject.getString(DittoTextArea.LinkColor);
            if (string.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                string = string.substring(2);
            }
            try {
                bVar.f200647d = Color.parseColor("#" + string);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("BubbleManager", 2, "linkcolor invalid");
                }
            }
        }
    }

    private c.a w(int i3, String str, boolean z16, boolean z17) {
        com.tencent.mobileqq.bubble.a q16;
        boolean d16;
        c0(i3, str, z16, z17);
        String[] strArr = null;
        if (TextUtils.isEmpty(str) || (q16 = q(i3, str)) == null) {
            return null;
        }
        c.a aVar = new c.a();
        U(q16, aVar);
        File file = new File(B(i3), q16.f200618a);
        int i16 = q16.f200623f;
        String[] strArr2 = new String[i16];
        if (q16.f200638u == null) {
            d16 = c(q16, file, strArr2, false);
        } else {
            d16 = d(q16, file, strArr2, false);
        }
        if (z16 && d16) {
            n(i3, "other.zip", "0");
            return null;
        }
        if (d16) {
            return null;
        }
        if (i16 > 0) {
            strArr = strArr2;
        }
        aVar.f200703j = strArr;
        aVar.f200702i = str;
        aVar.f200700g = t(q16.f200628k, z17);
        int[] iArr = q16.f200624g;
        if (iArr != null && iArr.length > 0) {
            aVar.f200699f = P(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        return aVar;
    }

    private void w0(com.tencent.mobileqq.bubble.b bVar, JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        if (jSONObject.has("pendant_animation")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("pendant_animation");
            com.tencent.mobileqq.bubble.a aVar = new com.tencent.mobileqq.bubble.a();
            if (jSONObject2.has("pendant_id")) {
                aVar.f200640w = jSONObject2.getInt("pendant_id");
            }
            if (jSONObject2.has("animation_set")) {
                VasCommonReporter.getHistoryFeature().setValue1("bubble").setValue2(String.valueOf(bVar.f200644a)).setValue3("pendant_animation").report();
                String string = jSONObject2.getString("animation_set");
                aVar.f200619b = string;
                JSONObject s16 = s(string, jSONObject);
                if (s16 != null) {
                    aVar.f200618a = s16.getString(v.COLUMN_ZIP_NAME);
                    JSONArray jSONArray2 = s16.getJSONArray("anim_sets");
                    if (s16.has("padding") && (jSONArray = s16.getJSONArray("padding")) != null && jSONArray.length() > 0) {
                        aVar.f200631n = jSONArray.getInt(0);
                        aVar.f200633p = jSONArray.getInt(1);
                        aVar.f200632o = jSONArray.getInt(2);
                        aVar.f200634q = jSONArray.getInt(3);
                    }
                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                        aVar.f200639v = M(jSONArray2);
                    }
                    bVar.f200658o = aVar;
                }
            }
        }
    }

    private void x(com.tencent.mobileqq.bubble.c cVar, Bitmap bitmap) {
        if (bitmap != null) {
            int pixel = bitmap.getPixel(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            if (cVar.f200677j == pixel) {
                int rgb = Color.rgb(255 - Color.red(pixel), 255 - Color.green(pixel), 255 - Color.blue(pixel));
                cVar.f200677j = rgb;
                b0(pixel, "text color:", rgb);
            }
            if (cVar.f200678k == pixel) {
                int rgb2 = Color.rgb(255 - Color.red(pixel), 255 - Color.green(pixel), 255 - Color.blue(pixel));
                cVar.f200678k = rgb2;
                b0(pixel, "mLinkColor :", rgb2);
            }
        }
    }

    private void x0(com.tencent.mobileqq.bubble.b bVar, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("color")) {
            String string = jSONObject.getString("color");
            if (string.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
                string = string.substring(2);
            }
            try {
                bVar.f200646c = Color.parseColor("#" + string);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("BubbleManager", 2, "color invalid");
                }
            }
        }
    }

    private void y0(com.tencent.mobileqq.bubble.b bVar, JSONObject jSONObject) throws JSONException {
        JSONObject r16;
        if (jSONObject.has("voice_animation")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("voice_animation");
            if (!jSONObject2.has("animation") || (r16 = r(jSONObject2.getString("animation"), jSONObject)) == null) {
                return;
            }
            com.tencent.mobileqq.bubble.a r06 = r0(0, r16);
            r06.f200619b = jSONObject2.getString("animation");
            bVar.f200652i = r06;
            if (!TextUtils.isEmpty(r06.f200618a)) {
                bVar.f200659p.add(r06.f200618a);
            }
        }
    }

    private com.tencent.mobileqq.bubble.a z0(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        com.tencent.mobileqq.bubble.a aVar = new com.tencent.mobileqq.bubble.a();
        aVar.f200621d = 5;
        aVar.f200630m = 1;
        if (jSONObject == null) {
            QLog.e("BubbleManager", 1, "parseVoicePrintAnimationConfig object = null");
            return null;
        }
        if (jSONObject.has("align")) {
            aVar.f200628k = jSONObject.getString("align");
        }
        if (jSONObject.has("repeat")) {
            aVar.f200622e = jSONObject.getInt("repeat");
        }
        if (jSONObject.has("count")) {
            aVar.f200623f = jSONObject.getInt("count");
        }
        if (jSONObject.has(v.COLUMN_ZIP_NAME)) {
            aVar.f200618a = jSONObject.getString(v.COLUMN_ZIP_NAME);
        }
        if (jSONObject.has("time")) {
            aVar.f200625h = jSONObject.getInt("time");
        }
        if (jSONObject.has("padding") && (jSONArray = jSONObject.getJSONArray("padding")) != null && jSONArray.length() > 0) {
            aVar.f200631n = BaseAIOUtils.f(jSONArray.getInt(0) / 2, this.f200577d.getResources());
            aVar.f200633p = BaseAIOUtils.f(jSONArray.getInt(1) / 2, this.f200577d.getResources());
            aVar.f200632o = BaseAIOUtils.f(jSONArray.getInt(2) / 2, this.f200577d.getResources());
            aVar.f200634q = BaseAIOUtils.f(jSONArray.getInt(3) / 2, this.f200577d.getResources());
        }
        K(jSONObject, aVar);
        return aVar;
    }

    public File B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (File) iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
        File file = new File(y(), String.valueOf(i3));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public JSONObject B0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (JSONObject) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            int i16 = 0;
            if (X(i3).booleanValue()) {
                jSONObject2.put("status", 3);
                jSONObject2.put("progress", 100);
                jSONObject.put("result", 0);
                jSONObject.put("message", HardCodeUtil.qqStr(R.string.k3y));
            } else {
                Float L2 = L(i3);
                if (L2 != null) {
                    if (L2.floatValue() == 1.0f) {
                        jSONObject2.put("status", 3);
                        jSONObject.put("result", 0);
                        jSONObject.put("message", HardCodeUtil.qqStr(R.string.f171671k41));
                    } else {
                        jSONObject2.put("status", 2);
                        jSONObject.put("result", 0);
                        jSONObject.put("message", HardCodeUtil.qqStr(R.string.k3x));
                    }
                    if (L2.floatValue() == 3.0f) {
                        i16 = 1;
                    }
                    jSONObject2.put("canceling", i16);
                    jSONObject2.put("progress", L2.floatValue() * 100.0f);
                } else {
                    jSONObject2.put("status", 1);
                    jSONObject2.put("progress", 0);
                    jSONObject.put("result", 0);
                    jSONObject.put("message", HardCodeUtil.qqStr(R.string.k3w));
                }
            }
            jSONObject2.put("id", i3);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, "queryInfo bubbleId=" + i3 + ",json=" + jSONObject.toString());
        }
        return jSONObject;
    }

    public int D(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str)).intValue();
        }
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\.");
            if (split.length == 5) {
                try {
                    return Integer.parseInt(split[2]);
                } catch (NumberFormatException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("BubbleManager", 2, "getBubbleIdFromScid: parse bubbleId error", e16);
                        return 0;
                    }
                    return 0;
                }
            }
            return 0;
        }
        return 0;
    }

    public void D0(k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) kVar);
        } else {
            this.E = kVar;
        }
    }

    public com.tencent.mobileqq.bubble.c F(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mobileqq.bubble.c) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (i3 < 1) {
            return null;
        }
        com.tencent.mobileqq.bubble.c e16 = this.f200579f.e(Integer.valueOf(i3));
        if (e16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("BubbleManager", 2, "getBubbleInfo, from cache, bubbleId=" + i3);
            }
            return e16;
        }
        if (z16 && !this.f200580h.contains(Integer.valueOf(i3))) {
            synchronized (this.f200580h) {
                Runnable runnable = new Runnable(i3) { // from class: com.tencent.mobileqq.bubble.BubbleManager.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f200583d;

                    {
                        this.f200583d = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BubbleManager.this, i3);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        ei.a(null, "AIO_bubble_craete_bubble_info");
                        BubbleManager.this.i(this.f200583d, true);
                        ei.a("AIO_bubble_craete_bubble_info", null);
                    }
                };
                this.f200580h.add(Integer.valueOf(i3));
                ThreadManagerV2.post(runnable, 8, null, true);
            }
        }
        return null;
    }

    public void F0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        try {
            synchronized (this.G) {
                JSONObject e16 = this.G.e(Integer.valueOf(i3));
                if (e16 == null) {
                    e16 = new JSONObject();
                }
                e16.put("full_download", 1);
                e16.put("id", i3);
                this.G.f(Integer.valueOf(i3), e16);
                E0(i3, e16);
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public File G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (File) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        File file = new File(y(), "bubble_local/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public void G0(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, "startDownload id=" + i3 + " callbackId = " + str);
        }
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putInt("srcType", 3);
            bundle.putString("callbackId", str);
        }
        if (!NetworkUtil.isNetSupport(this.f200577d)) {
            k kVar = this.E;
            if (kVar != null && str != null) {
                kVar.a(i3, -1, bundle);
                return;
            }
            return;
        }
        BubbleBusiness bubbleBusiness = (BubbleBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(BubbleBusiness.class);
        if (bubbleBusiness.isFileExists(i3)) {
            h0("bubble.android." + i3 + BubbleBusiness.STATIC_FILE_PACK_NAME, "", str, 0, 0);
            h0("bubble.android." + i3 + ".other.zip", "", str, 0, 0);
            h0("bubble.android." + i3 + BubbleBusiness.CONFIG_FILE_NAME, "", str, 0, 0);
            return;
        }
        bubbleBusiness.addDownLoadListener(i3, new b(bubbleBusiness, i3, str));
        bubbleBusiness.startDownload(i3);
    }

    public File H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (File) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        File file = new File(VasConstant.INTERNAL_DIY_BUBBLE_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public String I(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        }
        File file = new File(str);
        if (!file.exists()) {
            QLog.e("BubbleManager", 1, "getConfigContent file not exist : " + str);
            return null;
        }
        try {
            return FileUtils.readFileToString(file);
        } catch (IOException e16) {
            QLog.e("BubbleManager", 1, e16, new Object[0]);
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.e("BubbleManager", 2, e17, new Object[0]);
            return null;
        }
    }

    public boolean V(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        f0(str, "isBubblePasterExists scid: ");
        if (!TextUtils.isEmpty(str) && str.startsWith("bubble.paster.")) {
            File file = new File(y(), str.replace("bubble.paster.", ""));
            if (QLog.isColorLevel()) {
                QLog.i("BubbleManager", 2, "isBubblePasterExists file is Exits: " + file.exists() + ", path:" + file.getAbsolutePath());
            }
            return file.exists();
        }
        return false;
    }

    public boolean W(String str) {
        int D;
        Boolean S;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        f0(str, "scid isFileExists: ");
        if (!TextUtils.isEmpty(str) && str.startsWith("bubble.android.") && (D = D(str)) > 0) {
            if (str.endsWith("config.json")) {
                return new File(this.C.getBubbleJsonPath(D)).exists();
            }
            if (str.endsWith("static.zip")) {
                Boolean T = T(D);
                if (T != null) {
                    return T.booleanValue();
                }
            } else if (str.endsWith("other.zip") && (S = S(D)) != null) {
                return S.booleanValue();
            }
        }
        return false;
    }

    public Boolean X(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Boolean) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        if (!new File(y(), Integer.toString(i3)).exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("BubbleManager", 2, "bubble dir does not exist id:" + i3);
            }
            return Boolean.FALSE;
        }
        synchronized (this.G) {
            JSONObject e16 = this.G.e(Integer.valueOf(i3));
            if (e16 != null) {
                int optInt = e16.optInt("full_download");
                boolean z16 = true;
                if (optInt != 1) {
                    z16 = false;
                }
                return Boolean.valueOf(z16);
            }
            return Boolean.valueOf(C0(i3));
        }
    }

    public boolean b(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, i3)).booleanValue();
        }
        boolean G = DownloaderFactory.G(this.f200578e.getApp().getApplicationContext());
        if (G && !X(i3).booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, "bubbleId=" + i3 + ",isQualityNetwork=" + G + ",canFullDown=" + z16);
        }
        return z16;
    }

    com.tencent.mobileqq.bubble.b h(int i3, String str) {
        e0("createBubbleConfig, bubbleId = " + i3 + " path = " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String I = I(str);
            if (TextUtils.isEmpty(I)) {
                return null;
            }
            a0("content:" + I);
            String J = J(I);
            com.tencent.mobileqq.bubble.b bVar = new com.tencent.mobileqq.bubble.b(i3);
            JSONObject jSONObject = new JSONObject(J);
            bVar.f200645b = jSONObject.getString("name");
            p0(bVar, jSONObject);
            q0(bVar, jSONObject);
            bVar.f200651h = jSONObject.optDouble("color_threshold_factor", 1.0d);
            l0(bVar, jSONObject);
            I0(bVar, jSONObject);
            t0(bVar, jSONObject);
            bVar.f200661r = g.g(i3, jSONObject);
            w0(bVar, jSONObject);
            if (jSONObject.has("interaction_animation")) {
                VasCommonReporter.getHistoryFeature().setValue1("bubble").setValue2(String.valueOf(bVar.f200644a)).setValue3("interaction_animation").report();
                JSONObject jSONObject2 = jSONObject.getJSONObject("interaction_animation");
                JSONArray optJSONArray = jSONObject2.optJSONArray(QCircleSchemeAttr.Detail.KEY_WORD);
                bVar.f200667x = new HashMap<>();
                A(bVar, optJSONArray);
                int optInt = jSONObject.optInt("package_id", -1);
                bVar.f200664u = optInt;
                if (optInt == -1) {
                    bVar.f200664u = jSONObject.optInt("groupId", -1);
                }
                bVar.f200665v = jSONObject.optInt(NotifyMsgApiImpl.KEY_GROUP_TYPE, 2);
                u0(bVar, jSONObject, jSONObject2, "animation_start");
                u0(bVar, jSONObject, jSONObject2, "animation_running");
                u0(bVar, jSONObject, jSONObject2, "animation_end");
                u0(bVar, jSONObject, jSONObject2, "passive_animation");
            }
            return bVar;
        } catch (JSONException e16) {
            QLog.e("BubbleManager", 1, "bubble " + i3 + " json file invalidate exception=", e16);
            return null;
        } catch (Exception e17) {
            QLog.e("BubbleManager", 1, "null pointer or index out of range or other error", e17);
            return null;
        }
    }

    public void h0(String str, String str2, String str3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        g0(str, str3, i3, i16);
        if (!TextUtils.isEmpty(str) && str.startsWith("bubble.android.")) {
            int C = C(str, i3);
            VasLogReporter.getBubble().reportHighest("native download result - bubbleId:" + C + "+errorCode:" + i3 + " httpCode:" + i16);
            if (str.endsWith("config.json")) {
                k(i3, C);
                return;
            }
            if (str.endsWith("all.zip")) {
                j(str3, i3, C);
                return;
            }
            if (str.endsWith("static.zip")) {
                l(str3, i3, C);
            } else if (str.endsWith("other.zip") && i3 == 0) {
                i(C, false);
            }
        }
    }

    boolean i(int i3, boolean z16) {
        boolean z17;
        boolean z18;
        long uptimeMillis = SystemClock.uptimeMillis();
        d0(i3, z16);
        com.tencent.mobileqq.bubble.b z19 = z(i3, z16);
        if (z19 == null) {
            QLog.e("BubbleManager", 1, "createBubbleInfo, no config, bubbleId=" + i3);
            this.f200580h.remove(Integer.valueOf(i3));
            return false;
        }
        try {
            com.tencent.mobileqq.bubble.c E = E(i3, z19);
            boolean g16 = g(E);
            Y(i3, g16);
            if (!g16) {
                if (z16) {
                    p(i3);
                }
                this.f200580h.remove(Integer.valueOf(i3));
                return false;
            }
            if (!TextUtils.isEmpty(E.f200669b)) {
                z17 = true;
            } else {
                z17 = false;
            }
            boolean z26 = !TextUtils.isEmpty(E.f200671d);
            if (z17 && z26) {
                z18 = true;
            } else {
                z18 = false;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = 320;
            options.inTargetDensity = this.f200577d.getResources().getDisplayMetrics().densityDpi;
            c b16 = new c(i3, E, z18, null, options).b();
            boolean c16 = b16.c();
            String a16 = b16.a();
            if (!c16) {
                QLog.e("BubbleManager", 1, "createBubbleInfo, load nine patch failed, abort, bubbleId=" + i3);
                VasMonitorDT.reportErrCode("individual_v2_bubble_9png_err", a16);
                this.f200580h.remove(Integer.valueOf(i3));
                return false;
            }
            this.f200579f.f(Integer.valueOf(i3), E);
            AppInterface appInterface = this.f200578e;
            if (appInterface != null) {
                VasUtils.c(appInterface);
                MqqHandler handler = this.f200578e.getHandler(FontSettingActivity.class);
                if (handler != null) {
                    handler.removeMessages(16711697);
                    handler.sendMessageDelayed(handler.obtainMessage(16711697), L);
                }
            }
            this.f200580h.remove(Integer.valueOf(i3));
            if (QLog.isColorLevel()) {
                QLog.d("BubbleManager", 2, "createBubbleInfo, duration=" + (SystemClock.uptimeMillis() - uptimeMillis) + ", bubbleId=" + i3);
            }
            BubbleTextColorManage.d().f(E.f200669b, E.f200668a + "");
            return true;
        } catch (Exception e16) {
            QLog.e("BubbleManager", 1, "createBubbleInfo failed", e16);
            return false;
        }
    }

    public void i0(String str, String str2, String str3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, String.format("onPasterDownloadComplete, scid %s, errorcode %d", str, Integer.valueOf(i3)));
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("bubble.paster.")) {
            BubbleDiyFetcher.m().t(str.replace("bubble.paster.", "").replace(".png", ""));
        }
    }

    public Pair<c.a, c.a> j0(int i3, com.tencent.mobileqq.bubble.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Pair) iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), aVar, Boolean.valueOf(z16));
        }
        if (aVar == null || TextUtils.isEmpty(aVar.f200618a) || TextUtils.isEmpty(aVar.f200619b)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "parseAnimToCommonAttrs, bubbleId = " + i3 + " autoDown = " + z16);
        }
        c.a w3 = w(i3, aVar.f200619b, z16, false);
        if (w3 == null) {
            return null;
        }
        return new Pair<>(w3, w(i3, aVar.f200620c, z16, aVar.f200618a.equals(aVar.f200620c)));
    }

    public void n(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "downloadBubble, bubbleId = " + i3 + " pkgName = " + str + " from = " + str2);
        }
        if (i3 == 0) {
            return;
        }
        String str3 = "bubble.android." + i3 + "." + str;
        IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) this.f200578e.getRuntimeService(IVasQuickUpdateService.class, "");
        if (iVasQuickUpdateService != null) {
            synchronized (this.f200581i) {
                if (this.f200581i.contains(str3)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("BubbleManager", 2, str3 + " is downloading, remove duplicate download.");
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("BubbleManager", 2, str3 + " is downloading, remove duplicate download.");
                }
                this.f200581i.add(str3);
                iVasQuickUpdateService.downloadItem(2L, str3, str2);
            }
        }
        VasLogReporter.getBubble().reportHighest("native startDownload - bubbleId:" + i3 + "+scid:" + str3);
    }

    public void o(int i3, String[] strArr, String str) {
        IVasQuickUpdateService iVasQuickUpdateService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), strArr, str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BubbleManager", 2, "downloadBubbleGather, bubbleId = " + i3 + " pkgName[]= " + strArr + " from = " + str);
        }
        if (i3 != 0 && (iVasQuickUpdateService = (IVasQuickUpdateService) this.f200578e.getRuntimeService(IVasQuickUpdateService.class, "")) != null) {
            String str2 = "bubble.android." + i3 + ".all.zip";
            if ("0".equals(str)) {
                synchronized (this.f200581i) {
                    if (this.f200581i.contains(str2)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BubbleManager", 2, str2 + " is downloading, remove duplicate download.");
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("BubbleManager", 2, str2 + " add download queue.");
                    }
                    this.f200581i.add(str2);
                }
            }
            if (strArr == null) {
                strArr = new String[]{"bubble.android." + i3 + ".config.json", "bubble.android." + i3 + ".static.zip", "bubble.android." + i3 + ".other.zip"};
            }
            iVasQuickUpdateService.downloadGatherItem(2L, str2, strArr, str);
            A0(i3, 0.0f);
            VasLogReporter.getBubble().reportHighest("native startDownload \u7ec4\u5408\u4e0b\u8f7d - bubbleId:" + i3 + "+scid:" + str2);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, "onDestroy...");
        }
        this.f200579f.clear();
        this.f200582m.clear();
        N = 0;
    }

    com.tencent.mobileqq.bubble.a q(int i3, String str) {
        com.tencent.mobileqq.bubble.b z16 = z(i3, true);
        if (z16 == null) {
            QLog.e("BubbleManager", 1, "findAnimConfig bubbleId = " + i3 + " bubbleConfig = null");
            return null;
        }
        if (v(str, z16, z16.f200652i)) {
            return z16.f200652i;
        }
        if (v(str, z16, z16.f200653j)) {
            return z16.f200653j;
        }
        if (v(str, z16, z16.f200654k)) {
            return z16.f200654k;
        }
        if (v(str, z16, z16.f200656m)) {
            return z16.f200656m;
        }
        if (v(str, z16, z16.f200657n)) {
            return z16.f200657n;
        }
        ArrayList<com.tencent.mobileqq.bubble.a> arrayList = z16.f200655l;
        if (arrayList != null) {
            Iterator<com.tencent.mobileqq.bubble.a> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.bubble.a next = it.next();
                if (next.f200619b.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public File y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (File) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        File file = new File(VasConstant.INTERNAL_BUBBLE_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public com.tencent.mobileqq.bubble.b z(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.bubble.b) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (i3 == 0) {
            return null;
        }
        com.tencent.mobileqq.bubble.b bVar = this.f200582m.get(Integer.valueOf(i3));
        if (bVar == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                ThreadManagerV2.post(new HandleBubbleConfigRunnable(i3, z16), 5, null, true);
            } else {
                new HandleBubbleConfigRunnable(i3, z16).run();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("BubbleManager", 2, "getBubbleConfig bubbleId=" + i3 + ",autoDownload=" + z16 + ",bubbleConfig=" + bVar);
        }
        return bVar;
    }

    private String J(String str) {
        return str;
    }
}
