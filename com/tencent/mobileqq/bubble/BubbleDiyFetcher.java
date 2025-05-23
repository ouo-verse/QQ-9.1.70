package com.tencent.mobileqq.bubble;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.g;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BubbleDiyFetcher {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static BubbleDiyFetcher f200560k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f200561l;

    /* renamed from: m, reason: collision with root package name */
    public static volatile long f200562m;

    /* renamed from: a, reason: collision with root package name */
    public final int f200563a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, String> f200564b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, HashMap<String, String>> f200565c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f200566d;

    /* renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<h> f200567e;

    /* renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet<String> f200568f;

    /* renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet<String> f200569g;

    /* renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArraySet<String> f200570h;

    /* renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, HashMap<String, g>> f200571i;

    /* renamed from: j, reason: collision with root package name */
    public final Runnable f200572j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71016);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            f200561l = false;
            f200562m = 0L;
        }
    }

    BubbleDiyFetcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f200563a = 64;
        this.f200564b = Collections.synchronizedMap(new LRULinkedHashMap(32));
        this.f200565c = Collections.synchronizedMap(new LRULinkedHashMap(64));
        this.f200566d = new Handler(Looper.getMainLooper());
        this.f200567e = new CopyOnWriteArrayList<>();
        this.f200568f = new CopyOnWriteArraySet<>();
        this.f200569g = new CopyOnWriteArraySet<>();
        this.f200570h = new CopyOnWriteArraySet<>();
        this.f200571i = new ConcurrentHashMap<>();
        this.f200572j = new Runnable() { // from class: com.tencent.mobileqq.bubble.BubbleDiyFetcher.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BubbleDiyFetcher.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime instanceof QQAppInterface) {
                    BubbleDiyFetcher.this.q((QQAppInterface) runtime);
                }
            }
        };
    }

    public static BubbleDiyFetcher m() {
        if (f200560k == null) {
            synchronized (BubbleDiyFetcher.class) {
                if (f200560k == null) {
                    f200560k = new BubbleDiyFetcher();
                }
            }
        }
        return f200560k;
    }

    @Nullable
    private Bitmap n(File file, String str, Bitmap bitmap) {
        File file2 = new File(file, str + ".png");
        if (file2.exists()) {
            r(file2.getAbsolutePath(), "decode and put scale bitmap into BaseApplicationImpl.sImageCache, ");
            bitmap = j.c(file2.getAbsolutePath());
            if (bitmap != null) {
                ImageCacheHelper.f98636a.i("BubbleDiyFetcher_" + str, bitmap, Business.AIO);
            }
        }
        return bitmap;
    }

    private boolean o(h hVar, g.a aVar) {
        if (hVar != null && aVar != null && !TextUtils.isEmpty(hVar.f200769k)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, str2 + str);
        }
    }

    private void v(QQAppInterface qQAppInterface) {
        ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.bubble.BubbleDiyFetcher.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f200575d;

            {
                this.f200575d = qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BubbleDiyFetcher.this, (Object) qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (!BubbleDiyFetcher.this.f200568f.isEmpty()) {
                    BubbleDiyFetcher bubbleDiyFetcher = BubbleDiyFetcher.this;
                    bubbleDiyFetcher.r(TextUtils.join(",", bubbleDiyFetcher.f200568f), "now query mUnCacheDiyId: ");
                    BubbleDiyFetcher.this.i(this.f200575d);
                    if (!BubbleDiyFetcher.this.f200568f.isEmpty()) {
                        ((BubbleDiyHandler) this.f200575d.getBusinessHandler(BusinessHandlerFactory.BUBBLE_DIYTEXT_HANDLER)).E2(new ArrayList(BubbleDiyFetcher.this.f200568f), null);
                        BubbleDiyFetcher.this.f200568f.clear();
                    }
                }
                if (!BubbleDiyFetcher.this.f200569g.isEmpty()) {
                    BubbleDiyFetcher.this.f();
                }
                if (!BubbleDiyFetcher.this.f200570h.isEmpty()) {
                    Iterator<String> it = BubbleDiyFetcher.this.f200570h.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next)) {
                            BubbleDiyFetcher.this.e(next);
                        }
                    }
                }
                Iterator<h> it5 = BubbleDiyFetcher.this.f200567e.iterator();
                while (it5.hasNext()) {
                    h next2 = it5.next();
                    if (next2 == null || next2.getCallback() == null) {
                        BubbleDiyFetcher.this.f200567e.remove(next2);
                    }
                }
                BubbleDiyFetcher.f200562m = 0L;
            }
        }, 5, null, false);
    }

    private void w(Set<String> set) {
        this.f200566d.post(new Runnable(set) { // from class: com.tencent.mobileqq.bubble.BubbleDiyFetcher.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Set f200574d;

            {
                this.f200574d = set;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BubbleDiyFetcher.this, (Object) set);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                HashSet hashSet = new HashSet();
                Iterator<h> it = BubbleDiyFetcher.this.f200567e.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next != null && next.getCallback() != null) {
                        String str = next.f200769k;
                        if (this.f200574d.contains(str) && !hashSet.contains(next)) {
                            if (QLog.isColorLevel()) {
                                QLog.i("BubbleDiyFetcher", 2, "refresh uinAndDiyId drawables: " + str + ", vipBubbleDrawable:" + next.toString());
                            }
                            hashSet.add(next);
                            next.invalidateSelf();
                            BubbleDiyFetcher.this.f200567e.remove(next);
                        }
                    } else {
                        BubbleDiyFetcher.this.f200567e.remove(next);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("BubbleDiyFetcher", 2, "wait for refresh size: " + BubbleDiyFetcher.this.f200567e.size());
                }
            }
        });
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Iterator<String> it = this.f200569g.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.endsWith(str)) {
                    d(next);
                }
            }
        }
    }

    public boolean c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || !this.f200564b.containsKey(str) || !this.f200565c.containsKey(str)) {
            return false;
        }
        HashMap<String, String> hashMap = this.f200565c.get(str);
        Iterator<String> it = this.f200569g.iterator();
        while (it.hasNext()) {
            String[] split = it.next().split("_");
            if (split.length == 4 && hashMap.containsValue(split[3])) {
                return false;
            }
        }
        return true;
    }

    public void d(String str) {
        HashMap<String, g> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        File H = ((BubbleManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER)).H();
        String[] split = str.split("_");
        if (split.length == 4) {
            String str2 = split[3];
            String str3 = split[1];
            String str4 = split[2];
            ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
            if (imageCacheHelper.f(str) == null) {
                Bitmap f16 = imageCacheHelper.f("BubbleDiyFetcher_" + str2);
                if (f16 == null) {
                    f16 = n(H, str2, f16);
                }
                if (f16 != null) {
                    try {
                        hashMap = this.f200571i.get(Integer.valueOf(Integer.parseInt(str3)));
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("BubbleDiyFetcher", 2, "", e16);
                        }
                        hashMap = null;
                    }
                    if (hashMap != null && hashMap.containsKey(str4)) {
                        int[] iArr = hashMap.get(str4).f200747b;
                        ImageCacheHelper.f98636a.i(str, Bitmap.createScaledBitmap(f16, iArr[2], iArr[3], true), Business.AIO);
                        this.f200569g.remove(str);
                    }
                }
            }
        }
    }

    public void e(String str) {
        HashMap<String, g> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        BubbleManager bubbleManager = (BubbleManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
        String[] split = str.split("_");
        if (split.length == 4) {
            String str2 = split[1];
            String str3 = split[2];
            ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
            if (imageCacheHelper.f(str) == null) {
                String str4 = new File(bubbleManager.y(), String.valueOf(str2)).getAbsolutePath() + File.separatorChar + "chartlet" + File.separatorChar + "chartlet.png";
                Bitmap f16 = imageCacheHelper.f("BubbleDiyFetcher_" + str2 + "_chartlet");
                if (f16 == null) {
                    File file = new File(str4);
                    if (file.exists()) {
                        r(file.getAbsolutePath(), "createStaticBitmapCache: decode and put scale bitmap into BaseApplicationImpl.sImageCache, ");
                        f16 = j.c(file.getAbsolutePath());
                        if (f16 != null) {
                            imageCacheHelper.i("BubbleDiyFetcher_" + str2 + "_chartlet", f16, Business.AIO);
                        }
                    }
                }
                if (f16 != null) {
                    try {
                        hashMap = this.f200571i.get(Integer.valueOf(Integer.parseInt(str2)));
                    } catch (Exception e16) {
                        QLog.e("BubbleDiyFetcher", 1, "createStaticBitmapCache error!", e16);
                        hashMap = null;
                    }
                    if (hashMap != null && hashMap.containsKey(str3)) {
                        int[] iArr = hashMap.get(str3).f200747b;
                        ImageCacheHelper.f98636a.i(str, Bitmap.createScaledBitmap(f16, iArr[2], iArr[3], true), Business.AIO);
                        this.f200570h.remove(str);
                    }
                }
            }
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            g();
            if (!this.f200569g.isEmpty()) {
                IVasQuickUpdateService iVasQuickUpdateService = (IVasQuickUpdateService) runtime.getRuntimeService(IVasQuickUpdateService.class, "");
                ArrayList arrayList = new ArrayList(this.f200569g);
                Iterator it = arrayList.iterator();
                String[] strArr = null;
                int i3 = 0;
                while (it.hasNext()) {
                    String[] split = ((String) it.next()).split("_");
                    if (split.length == 4) {
                        if (strArr == null) {
                            strArr = new String[arrayList.size()];
                        }
                        strArr[i3] = "bubble.paster." + split[3] + ".png";
                        i3++;
                    }
                }
                if (strArr != null && strArr.length > 0) {
                    r(TextUtils.join(",", strArr), "now download from VasUpdateConstants list: ");
                    iVasQuickUpdateService.downloadGatherItem(2L, strArr[0], strArr, "0");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("BubbleDiyFetcher", 2, "all paster has decode!");
            }
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (this.f200569g.size() > 0) {
            Iterator<String> it = this.f200569g.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
            x();
        }
    }

    public void h(QQAppInterface qQAppInterface, String str, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, qQAppInterface, str, businessObserver);
            return;
        }
        if (qQAppInterface != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("BubbleDiyFetcher", 2, String.format("uinAndDiyId %s, text cache is %b, diy paster cache is %b", str, Boolean.valueOf(this.f200564b.containsKey(str)), Boolean.valueOf(this.f200565c.containsKey(str))));
            }
            if (this.f200564b.containsKey(str) && this.f200565c.containsKey(str)) {
                BubbleDiyEntity bubbleDiyEntity = new BubbleDiyEntity();
                bubbleDiyEntity.uinAndDiyId = str;
                bubbleDiyEntity.diyText = this.f200564b.get(str);
                BubbleDiyEntity.parsePasterMap(bubbleDiyEntity, this.f200565c.get(str));
                ArrayList arrayList = new ArrayList();
                arrayList.add(bubbleDiyEntity);
                if (businessObserver != null) {
                    businessObserver.onUpdate(1, true, arrayList);
                    return;
                }
                return;
            }
            BubbleDiyEntity bubbleDiyEntity2 = (BubbleDiyEntity) DBMethodProxy.find(qQAppInterface.getEntityManagerFactory().createEntityManager(), BubbleDiyEntity.class, " uinAndDiyId=? ", new String[]{str});
            if (bubbleDiyEntity2 != null) {
                r(str, "query bubbleDiy from database, uinAndDiyId: ");
                this.f200564b.put(str, bubbleDiyEntity2.diyText);
                this.f200565c.put(str, bubbleDiyEntity2.convertToPasterMap());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bubbleDiyEntity2);
                if (businessObserver != null) {
                    businessObserver.onUpdate(1, true, arrayList2);
                    return;
                }
                return;
            }
            r(str, "start request diy id ");
            this.f200568f.add(str);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(str);
            ((BubbleDiyHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.BUBBLE_DIYTEXT_HANDLER)).E2(arrayList3, businessObserver);
        }
    }

    public void i(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (this.f200568f.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("BubbleDiyFetcher", 2, "mUnCacheDiyId size is 0!");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(this.f200568f);
        int size = arrayList2.size();
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        for (int i3 = 0; i3 < size; i3++) {
            BubbleDiyEntity bubbleDiyEntity = (BubbleDiyEntity) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) BubbleDiyEntity.class, (String) arrayList2.get(i3));
            if (bubbleDiyEntity != null) {
                arrayList.add(bubbleDiyEntity);
            }
        }
        Iterator<BubbleDiyEntity> it = arrayList.iterator();
        while (it.hasNext()) {
            this.f200568f.remove(it.next().uinAndDiyId);
        }
        if (!arrayList.isEmpty()) {
            s(qQAppInterface, false, arrayList);
        }
    }

    public Bitmap j(h hVar, g.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) hVar, (Object) aVar);
        }
        if (o(hVar, aVar)) {
            return null;
        }
        if (this.f200565c.containsKey(hVar.f200769k)) {
            HashMap<String, String> hashMap = this.f200565c.get(hVar.f200769k);
            if (hashMap == null || !hashMap.containsKey(aVar.f200746a.toUpperCase())) {
                return null;
            }
            String str = hashMap.get(aVar.f200746a.toUpperCase());
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i("BubbleDiyFetcher", 2, "diy id " + hVar.f200769k + " has no pasterId for align: " + aVar.f200746a.toUpperCase());
                }
                return null;
            }
            String str2 = "BubbleDiyFetcher_" + aVar.f200748c + "_" + aVar.f200746a.toUpperCase() + "_" + str;
            Bitmap f16 = ImageCacheHelper.f98636a.f(str2);
            if (f16 != null) {
                this.f200569g.remove(str2);
                return f16;
            }
            r(str2, "can not found bitmap cache in BaseApplicationImpl.sImageCache! ");
            this.f200569g.add(str2);
        } else {
            r(hVar.f200769k, "can not found cache in diyPasterCache! ");
            this.f200568f.add(hVar.f200769k);
        }
        r(" and post delay 0.5s to load bubble diy!", "fetchDiyPaster: put VipBubbleDrawable into mNotRefreshAIODrawables");
        this.f200567e.add(hVar);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            u((QQAppInterface) runtime, 500);
        }
        return null;
    }

    public String k(h hVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hVar, (Object) str);
        }
        if (hVar != null && !TextUtils.isEmpty(str)) {
            String str2 = this.f200564b.get(str);
            if (str2 != null) {
                return str2;
            }
            this.f200568f.add(str);
            r(" and post delay 0.5s to load bubble diy!", "fetchDiyText: put VipBubbleDrawable into mNotRefreshAIODrawables");
            this.f200567e.add(hVar);
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                u((QQAppInterface) runtime, 500);
                return null;
            }
            return null;
        }
        return "";
    }

    public Bitmap l(h hVar, g.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, (Object) this, (Object) hVar, (Object) aVar);
        }
        if (hVar != null && aVar != null) {
            String str = "BubbleDiyFetcher_" + aVar.f200748c + "_" + aVar.f200746a.toUpperCase() + "_chartlet";
            Bitmap f16 = ImageCacheHelper.f98636a.f(str);
            if (f16 != null) {
                this.f200570h.remove(str);
                return f16;
            }
            this.f200570h.add(str);
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                u((QQAppInterface) runtime, 500);
            }
        }
        return null;
    }

    public void p(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
        } else if (!f200561l) {
            f200561l = true;
            ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.bubble.BubbleDiyFetcher.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f200573d;

                {
                    this.f200573d = qQAppInterface;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BubbleDiyFetcher.this, (Object) qQAppInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    List<? extends Entity> query = this.f200573d.getEntityManagerFactory().createEntityManager().query(BubbleDiyEntity.class, true, null, null, null, null, null, " 20 ");
                    if (query != null && query.size() > 0) {
                        Iterator<? extends Entity> it = query.iterator();
                        while (it.hasNext()) {
                            BubbleDiyEntity bubbleDiyEntity = (BubbleDiyEntity) it.next();
                            if (!TextUtils.isEmpty(bubbleDiyEntity.uinAndDiyId)) {
                                BubbleDiyFetcher.this.f200564b.put(bubbleDiyEntity.uinAndDiyId, bubbleDiyEntity.diyText);
                                BubbleDiyFetcher.this.f200565c.put(bubbleDiyEntity.uinAndDiyId, bubbleDiyEntity.convertToPasterMap());
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("BubbleDiyFetcher", 2, "initCacheFromDB, size: " + query.size());
                        }
                    }
                }
            }, 5, null, false);
        }
    }

    @TargetApi(11)
    public void q(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (qQAppInterface == null) {
            return;
        }
        p(qQAppInterface);
        if (!this.f200568f.isEmpty() || !this.f200569g.isEmpty() || !this.f200567e.isEmpty() || !this.f200570h.isEmpty()) {
            v(qQAppInterface);
        }
    }

    public void s(QQAppInterface qQAppInterface, boolean z16, List<BubbleDiyEntity> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, qQAppInterface, Boolean.valueOf(z16), list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            for (BubbleDiyEntity bubbleDiyEntity : list) {
                if (z16) {
                    qQAppInterface.getEntityManagerFactory().createEntityManager().persistOrReplace(bubbleDiyEntity);
                }
                this.f200568f.remove(bubbleDiyEntity.uinAndDiyId);
                this.f200564b.put(bubbleDiyEntity.uinAndDiyId, bubbleDiyEntity.diyText);
                this.f200565c.put(bubbleDiyEntity.uinAndDiyId, bubbleDiyEntity.convertToPasterMap());
                if (!TextUtils.isEmpty(bubbleDiyEntity.topLeftId)) {
                    b(bubbleDiyEntity.topLeftId);
                }
                if (!TextUtils.isEmpty(bubbleDiyEntity.topRightId)) {
                    b(bubbleDiyEntity.topRightId);
                }
                if (!TextUtils.isEmpty(bubbleDiyEntity.bottomLeftId)) {
                    b(bubbleDiyEntity.bottomLeftId);
                }
                if (!TextUtils.isEmpty(bubbleDiyEntity.bottomRightId)) {
                    b(bubbleDiyEntity.bottomRightId);
                }
            }
            x();
        }
    }

    public void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        r(str, "notifyPasterDownloadComplete ");
        if (!TextUtils.isEmpty(str)) {
            b(str);
            x();
        }
    }

    public void u(QQAppInterface qQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) qQAppInterface, i3);
            return;
        }
        if (qQAppInterface == null) {
            return;
        }
        if (!this.f200568f.isEmpty() || !this.f200569g.isEmpty() || !this.f200570h.isEmpty()) {
            if (i3 <= 0) {
                this.f200566d.removeCallbacks(this.f200572j);
                q(qQAppInterface);
            } else if (System.currentTimeMillis() > f200562m) {
                if (QLog.isColorLevel()) {
                    QLog.i("BubbleDiyFetcher", 2, "postLoadBubbleDiyTexts delay:  " + i3);
                }
                long j3 = i3;
                this.f200566d.postDelayed(this.f200572j, j3);
                f200562m = System.currentTimeMillis() + j3;
            }
        }
    }

    @TargetApi(11)
    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        HashSet hashSet = new HashSet(this.f200567e.size());
        Iterator<h> it = this.f200567e.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (next != null && next.getCallback() != null && c(next.f200769k)) {
                hashSet.add(next.f200769k);
            }
        }
        if (hashSet.size() > 0) {
            r(TextUtils.join(",", hashSet), "refreshDrawableOnUiThread: ");
            w(hashSet);
        }
    }
}
