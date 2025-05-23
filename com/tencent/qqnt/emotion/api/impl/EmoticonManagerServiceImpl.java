package com.tencent.qqnt.emotion.api.impl;

import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import androidx.collection.LruCache;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.QueryTask;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.stickerrecommended.g;
import com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.qqnt.emotion.stickerrecommended.t;
import com.tencent.qqnt.emotion.utils.k;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceSupportSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes24.dex */
public class EmoticonManagerServiceImpl implements IEmoticonManagerService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "NT_EmoticonManager";
    public static HashMap<Double, Integer> betterDisplaySize;

    /* renamed from: em, reason: collision with root package name */
    public com.tencent.qqnt.emotion.db.a f356156em;
    public LruCache<String, Emoticon> emoticonCache;
    public LruCache<String, List<Emoticon>> keywordEmoticonsCache;
    private String mCurrentAccountUin;
    public double mScreenInch;
    public LruCache<String, EmoticonPackage> pkgCache;
    public LruCache<String, List<Emoticon>> subEmoticonsCache;
    public List<String> tabCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class a implements QueryTask.a<Pair<String, Integer>, EmoticonPackage> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EmoticonManagerServiceImpl.this);
            }
        }

        @Override // com.tencent.qqnt.emotion.QueryTask.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EmoticonPackage query(Pair<String, Integer> pair) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EmoticonPackage) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pair);
            }
            return EmoticonManagerServiceImpl.this.syncFindEmoticonPackageById((String) pair.first, ((Integer) pair.second).intValue());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35061);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
        } else {
            betterDisplaySize = new HashMap<>();
        }
    }

    public EmoticonManagerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.tabCache = new CopyOnWriteArrayList();
        this.pkgCache = new LruCache<>(100);
        this.emoticonCache = new LruCache<>(400);
        this.subEmoticonsCache = new LruCache<>(50);
        this.keywordEmoticonsCache = new LruCache<>(50);
        this.mScreenInch = 0.0d;
    }

    private void addExtensionSizeByScreenSize(String str, Emoticon emoticon, MarkFaceMessage markFaceMessage) {
        Integer num = betterDisplaySize.get(Double.valueOf(fetchScreenInch()));
        if (num != null && num.intValue() != 0) {
            if (str != null && emoticon.extensionHeight == 0 && emoticon.extensionWidth == 0) {
                int extensionSizeByScreenSize = getExtensionSizeByScreenSize(str);
                if (extensionSizeByScreenSize != -1) {
                    emoticon.extensionHeight = extensionSizeByScreenSize;
                    emoticon.extensionWidth = extensionSizeByScreenSize;
                    return;
                }
                return;
            }
            updateExtensionSize(str, emoticon, markFaceMessage, num);
        }
    }

    private double fetchScreenInch() {
        double d16 = this.mScreenInch;
        double d17 = 0.0d;
        if (d16 != 0.0d) {
            return d16;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) BaseApplication.getContext().getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        if (displayMetrics.xdpi != 0.0f && displayMetrics.ydpi != 0.0f) {
            d17 = Math.round(Math.sqrt(Math.pow(displayMetrics.widthPixels / r1, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d)) * 100.0d) / 100.0d;
        }
        if (d17 >= 4.6d && displayMetrics.widthPixels >= 720 && displayMetrics.heightPixels >= 1280) {
            this.mScreenInch = 4.7d;
        } else {
            this.mScreenInch = -1.0d;
        }
        QLog.d("screenInch", 1, "screen inches-> screenInch: " + d17 + ", formatInch: " + this.mScreenInch + ", widthPixels: " + displayMetrics.widthPixels + " ,heightPixels: " + displayMetrics.heightPixels + " , xdpi: " + displayMetrics.xdpi + " , ydpi: " + displayMetrics.ydpi + ", densityDpi: " + displayMetrics.densityDpi + " , density: " + displayMetrics.density);
        return this.mScreenInch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTabs() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initTabs begins");
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = (ArrayList) this.f356156em.i(EmoticonTab.class, false, null, null, null, null, null, null);
        this.tabCache.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                EmoticonTab emoticonTab = (EmoticonTab) it.next();
                if (emoticonTab != null && emoticonTab.aioHave) {
                    this.tabCache.add(emoticonTab.epId);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initTabs ends, tabCache.size:" + this.tabCache.size() + ",time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private ArrayList<Emoticon> queryEmoticonsByKeyWordFromDB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<Emoticon> arrayList = (ArrayList) this.f356156em.i(Emoticon.class, false, "name=? and jobType= ?", new String[]{str, "0"}, null, null, null, null);
        if (arrayList != null) {
            synchronized (this.keywordEmoticonsCache) {
                this.keywordEmoticonsCache.put(str, arrayList);
                Iterator<Emoticon> it = arrayList.iterator();
                while (it.hasNext()) {
                    Emoticon next = it.next();
                    this.emoticonCache.put(next.getMapKey(), next);
                }
            }
            return arrayList;
        }
        QLog.e(TAG, 1, "queryEmoticonsByKeyWordFromDB data is null , keyWord = " + str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " queryEmoticonsByKeyWordFromDB keywordEmoticonsCache.size:" + this.keywordEmoticonsCache.size() + ",keyWord:" + str);
        }
        return null;
    }

    private ArrayList<Emoticon> queryEmoticonsByPackageIdFromDB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<Emoticon> arrayList = (ArrayList) this.f356156em.i(Emoticon.class, false, "epId=?", new String[]{str}, null, null, null, null);
        synchronized (this.subEmoticonsCache) {
            if (arrayList != null) {
                this.subEmoticonsCache.put(str, arrayList);
                Iterator<Emoticon> it = arrayList.iterator();
                while (it.hasNext()) {
                    Emoticon next = it.next();
                    this.emoticonCache.put(next.getMapKey(), next);
                }
            } else {
                QLog.e(TAG, 1, "queryEmoticonsByPackageIdFromDB data is null , epId = " + str);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, " queryEmoticonsByPackageIdFromDB subEmoticonsCache.size:" + this.subEmoticonsCache.size() + ",epId:" + str);
        }
        return arrayList;
    }

    private void runInCurrentThread(Runnable runnable, int i3) {
        if (runnable != null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                runnable.run();
            } else {
                ThreadManagerV2.post(runnable, i3, null, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmoticonCache(Emoticon emoticon) {
        if (TextUtils.isEmpty(emoticon.encryptKey)) {
            Emoticon emoticon2 = this.emoticonCache.get(emoticon.getMapKey());
            if (emoticon2 == null || TextUtils.isEmpty(emoticon2.encryptKey)) {
                emoticon2 = (Emoticon) this.f356156em.e(Emoticon.class, "epId=? and eId=?", new String[]{emoticon.epId, emoticon.eId});
            }
            if (emoticon2 != null && !TextUtils.isEmpty(emoticon2.encryptKey)) {
                emoticon.encryptKey = emoticon2.encryptKey;
            }
        }
        this.emoticonCache.put(emoticon.getMapKey(), emoticon);
        synchronized (this.subEmoticonsCache) {
            List<Emoticon> list = this.subEmoticonsCache.get(emoticon.epId);
            if (list != null) {
                Iterator<Emoticon> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Emoticon next = it.next();
                    if (emoticon.eId.equals(next.eId)) {
                        list.remove(next);
                        list.add(emoticon);
                        break;
                    }
                }
                this.subEmoticonsCache.put(emoticon.epId, list);
            }
        }
        updateKeywordEmoticonsCache(emoticon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateEntity(Entity entity) {
        if (entity.getStatus() == 1000) {
            this.f356156em.g(entity);
            if (entity.getStatus() != 1001) {
                return false;
            }
            return true;
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return false;
        }
        return this.f356156em.j(entity);
    }

    private void updateExtensionSize(String str, Emoticon emoticon, MarkFaceMessage markFaceMessage, Integer num) {
        int i3 = 0;
        if (markFaceMessage.isAPNG) {
            if (markFaceMessage.apngSupportSize != null && emoticon.extensionWidth == 0 && emoticon.extensionHeight == 0) {
                while (i3 < markFaceMessage.apngSupportSize.size()) {
                    MarketFaceSupportSize marketFaceSupportSize = markFaceMessage.apngSupportSize.get(i3);
                    int width = marketFaceSupportSize.getWidth();
                    int height = marketFaceSupportSize.getHeight();
                    if (width == num.intValue() && height == num.intValue()) {
                        emoticon.extensionWidth = num.intValue();
                        emoticon.extensionHeight = num.intValue();
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "get apng support size from resvAttr, betterSize: " + num + ", epId: " + str + " , eId: " + emoticon.eId);
                            return;
                        }
                        return;
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        if (markFaceMessage.supportSize != null && emoticon.extensionHeight == 0 && emoticon.extensionWidth == 0) {
            while (i3 < markFaceMessage.supportSize.size()) {
                MarketFaceSupportSize marketFaceSupportSize2 = markFaceMessage.supportSize.get(i3);
                int width2 = marketFaceSupportSize2.getWidth();
                int height2 = marketFaceSupportSize2.getHeight();
                if (width2 == num.intValue() && height2 == num.intValue()) {
                    emoticon.extensionWidth = num.intValue();
                    emoticon.extensionHeight = num.intValue();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "get support size from resvAttr, betterSize: " + num + ", epId: " + str + " , eId: " + emoticon.eId);
                        return;
                    }
                    return;
                }
                i3++;
            }
        }
    }

    private void updateKeywordEmoticonsCache(Emoticon emoticon) {
        synchronized (this.keywordEmoticonsCache) {
            List<Emoticon> list = this.keywordEmoticonsCache.get(emoticon.name);
            if (list != null) {
                Iterator<Emoticon> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Emoticon next = it.next();
                    if (emoticon.eId.equals(next.eId)) {
                        list.remove(next);
                        list.add(emoticon);
                        break;
                    }
                }
                this.keywordEmoticonsCache.put(emoticon.name, list);
            }
        }
    }

    public void addKeywordEmoticonsCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            return;
        }
        List<Emoticon> syncGetSubEmoticonsByPackageId = syncGetSubEmoticonsByPackageId(str);
        if (syncGetSubEmoticonsByPackageId == null) {
            return;
        }
        synchronized (this.keywordEmoticonsCache) {
            for (Emoticon emoticon : syncGetSubEmoticonsByPackageId) {
                List<Emoticon> list = this.keywordEmoticonsCache.get(emoticon.name);
                if (list != null && !list.contains(emoticon)) {
                    list.add(emoticon);
                    this.keywordEmoticonsCache.put(emoticon.name, list);
                }
            }
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void addTabEmoticonPackage(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "addTabEmoticonPackage, emoticonTabId = " + str + " businessType = " + i3);
        }
        this.tabCache.remove(str);
        this.tabCache.add(0, str);
        runInCurrentThread(new Runnable(str) { // from class: com.tencent.qqnt.emotion.api.impl.EmoticonManagerServiceImpl.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f356162d;

            {
                this.f356162d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonManagerServiceImpl.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                List<Emoticon> syncGetSubEmoticonsByPackageId = EmoticonManagerServiceImpl.this.syncGetSubEmoticonsByPackageId(this.f356162d);
                if (syncGetSubEmoticonsByPackageId == null) {
                    return;
                }
                HashSet hashSet = new HashSet();
                Iterator<Emoticon> it = syncGetSubEmoticonsByPackageId.iterator();
                while (it.hasNext()) {
                    String str2 = it.next().name;
                    if (str2 != null) {
                        hashSet.add(str2);
                    }
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (!(peekAppRuntime instanceof BaseQQAppInterface)) {
                    QLog.e(EmoticonManagerServiceImpl.TAG, 1, "addTabEmoticonPackage error, app is null!");
                } else {
                    StickerRecManagerImpl.get((BaseQQAppInterface) peekAppRuntime).syncAddLocalEmoticonKeywords(hashSet);
                    EmoticonManagerServiceImpl.this.addKeywordEmoticonsCache(this.f356162d);
                }
            }
        }, 5);
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void asyncFindEmoticonPackage(String str, com.tencent.qqnt.emotion.c<EmoticonPackage> cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            asyncFindEmoticonPackage(str, 0, cVar);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) cVar);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void asyncIncreaseEmotionClickNum(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) emoticon);
            return;
        }
        if (emoticon == null) {
            return;
        }
        List<Emoticon> list = this.keywordEmoticonsCache.get(emoticon.name);
        if (list == null) {
            emoticon.increaseExposeNum();
            this.emoticonCache.put(emoticon.getMapKey(), emoticon);
            return;
        }
        for (Emoticon emoticon2 : list) {
            if (emoticon2 != null && emoticon.getMapKey().equals(emoticon2.getMapKey())) {
                emoticon2.increaseClickNum();
                this.emoticonCache.put(emoticon2.getMapKey(), emoticon2);
                return;
            }
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void clearCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "clearCache begins");
        }
        this.tabCache.clear();
        this.pkgCache.evictAll();
        this.emoticonCache.evictAll();
        this.subEmoticonsCache.evictAll();
        this.keywordEmoticonsCache.evictAll();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "clearCache ends");
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public int getExtensionSizeByScreenSize(List<MarketFaceSupportSize> list) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) list)).intValue();
        }
        if (list != null && (num = betterDisplaySize.get(Double.valueOf(fetchScreenInch()))) != null && num.intValue() != 0) {
            for (MarketFaceSupportSize marketFaceSupportSize : list) {
                if (marketFaceSupportSize.getWidth() == num.intValue() && marketFaceSupportSize.getHeight() == num.intValue()) {
                    return num.intValue();
                }
            }
        }
        return -1;
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public String getSmallEmoticonDescription(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
        }
        Emoticon emoticon = this.emoticonCache.get(str + "_" + str2);
        if (emoticon == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "can not find small emotion in cache, but pkg in cache: epId = " + str + ", eId = " + str2);
            }
            runInCurrentThread(new Runnable(str, str2) { // from class: com.tencent.qqnt.emotion.api.impl.EmoticonManagerServiceImpl.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f356157d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f356158e;

                {
                    this.f356157d = str;
                    this.f356158e = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, EmoticonManagerServiceImpl.this, str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Emoticon emoticon2 = (Emoticon) EmoticonManagerServiceImpl.this.f356156em.e(Emoticon.class, "epId=? and eId=?", new String[]{this.f356157d, this.f356158e});
                    if (emoticon2 != null) {
                        EmoticonManagerServiceImpl.this.emoticonCache.put(emoticon2.getMapKey(), emoticon2);
                        if (QLog.isColorLevel()) {
                            QLog.d(EmoticonManagerServiceImpl.TAG, 2, "hit db, put into cache");
                        }
                    }
                }
            }, 5);
            return "";
        }
        return emoticon.character;
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public List<String> getTabCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (List) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.tabCache;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        this.mCurrentAccountUin = baseQQAppInterface.getCurrentAccountUin();
        this.f356156em = com.tencent.qqnt.emotion.db.b.f356229a.a(baseQQAppInterface);
        betterDisplaySize.put(Double.valueOf(4.7d), 300);
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.qqnt.emotion.api.impl.EmoticonManagerServiceImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonManagerServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    EmoticonManagerServiceImpl.this.initTabs();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, null, true);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public List<Emoticon> queryBigEmoticonsFromDB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (List) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.f356156em.i(Emoticon.class, false, "jobType= ?", new String[]{"0"}, null, null, null, null);
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void reconstructAllTabEmoticonPackage(List<String> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) list, i3);
            return;
        }
        this.tabCache.clear();
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            String str = list.get(i16);
            if (!this.tabCache.contains(str)) {
                this.tabCache.add(str);
            }
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void saveEmoticon(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) emoticon);
        } else {
            if (emoticon == null) {
                return;
            }
            runInCurrentThread(new Runnable(emoticon) { // from class: com.tencent.qqnt.emotion.api.impl.EmoticonManagerServiceImpl.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Emoticon f356160d;

                {
                    this.f356160d = emoticon;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonManagerServiceImpl.this, (Object) emoticon);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        EmoticonManagerServiceImpl.this.updateEmoticonCache(this.f356160d);
                        if (!EmoticonManagerServiceImpl.this.updateEntity(this.f356160d)) {
                            QLog.e(EmoticonManagerServiceImpl.TAG, 1, "saveEmoticon fail epId = " + this.f356160d.epId + ", eId = " + this.f356160d.eId);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }, 8);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void saveEmoticonPackage(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) emoticonPackage);
        } else if (emoticonPackage != null) {
            this.pkgCache.put(emoticonPackage.epId, emoticonPackage);
            runInCurrentThread(new Runnable(emoticonPackage) { // from class: com.tencent.qqnt.emotion.api.impl.EmoticonManagerServiceImpl.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ EmoticonPackage f356159d;

                {
                    this.f356159d = emoticonPackage;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonManagerServiceImpl.this, (Object) emoticonPackage);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!EmoticonManagerServiceImpl.this.updateEntity(this.f356159d)) {
                        QLog.e(EmoticonManagerServiceImpl.TAG, 1, "saveEmoticonPackage fail epId = " + this.f356159d.epId);
                    }
                }
            }, 8);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void saveEmoticonPackages(List<EmoticonPackage> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            for (EmoticonPackage emoticonPackage : list) {
                if (emoticonPackage != null) {
                    this.pkgCache.put(emoticonPackage.epId, emoticonPackage);
                }
            }
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void saveEmoticons(List<Emoticon> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) list);
        } else {
            if (list == null) {
                return;
            }
            runInCurrentThread(new Runnable(list) { // from class: com.tencent.qqnt.emotion.api.impl.EmoticonManagerServiceImpl.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f356161d;

                {
                    this.f356161d = list;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonManagerServiceImpl.this, (Object) list);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Iterator it = this.f356161d.iterator();
                    while (it.hasNext()) {
                        EmoticonManagerServiceImpl.this.updateEmoticonCache((Emoticon) it.next());
                    }
                }
            }, 8);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public Emoticon syncFindEmoticonById(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Emoticon) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "syncFindEmoticonById epId = " + str + ", eId = " + str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Emoticon emoticon = this.emoticonCache.get(str + "_" + str2);
            if (emoticon == null) {
                emoticon = (Emoticon) this.f356156em.e(Emoticon.class, "epId=? and eId=?", new String[]{str, str2});
                if (emoticon != null) {
                    this.emoticonCache.put(emoticon.getMapKey(), emoticon);
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "can not findEmoticonById epId = " + str + ", eId = " + str2);
                }
            }
            return emoticon;
        }
        QLog.e(TAG, 1, "syncFindEmoticonById error epId = " + str + ",eId = " + str2);
        return null;
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public EmoticonPackage syncFindEmoticonPackageById(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? syncFindEmoticonPackageById(str, 0) : (EmoticonPackage) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public EmoticonPackage syncFindEmoticonPackageInCache(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "syncFindEmoticonPackageInCache epId = " + str + ", type = " + i3);
        }
        EmoticonPackage emoticonPackage = this.pkgCache.get(str);
        if (emoticonPackage != null) {
            if (i3 == -1) {
                return emoticonPackage;
            }
            if (i3 == 0) {
                if (!emoticonPackage.aio) {
                    return null;
                }
                return emoticonPackage;
            }
            if (i3 == 1 && !emoticonPackage.kandian) {
                return null;
            }
            return emoticonPackage;
        }
        return emoticonPackage;
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public EmoticonPackage syncFindTabEmoticonPackageById(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) ? syncFindTabEmoticonPackageById(str, 0) : (EmoticonPackage) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public List<Emoticon> syncGetEmoticonsByKeyword(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (List) iPatchRedirector.redirect((short) 26, this, str, Boolean.valueOf(z16));
        }
        if (str == null) {
            return null;
        }
        ArrayList<Emoticon> arrayList = (ArrayList) this.keywordEmoticonsCache.get(str);
        if (arrayList == null) {
            arrayList = queryEmoticonsByKeyWordFromDB(str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "syncGetEmoticonsByKeyword from cache arrEmoticon.size:" + arrayList.size() + ",keyWord: " + k.a(str));
        }
        if (z16 && arrayList != null && !arrayList.isEmpty()) {
            return (List) arrayList.clone();
        }
        return arrayList;
    }

    public List<Emoticon> syncGetSubEmoticonsByPackageId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? syncGetSubEmoticonsByPackageId(str, false) : (List) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void syncIncreaseEmoticonExposeNum(g gVar) {
        Emoticon emoticon;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) gVar);
            return;
        }
        if ((gVar instanceof t) && (emoticon = ((t) gVar).f356642f) != null) {
            List<Emoticon> list = this.keywordEmoticonsCache.get(emoticon.name);
            if (list == null) {
                emoticon.increaseExposeNum();
                this.emoticonCache.put(emoticon.getMapKey(), emoticon);
                return;
            }
            for (Emoticon emoticon2 : list) {
                if (emoticon2 != null && emoticon.getMapKey().equals(emoticon2.getMapKey())) {
                    emoticon2.increaseExposeNum();
                    this.emoticonCache.put(emoticon2.getMapKey(), emoticon2);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void syncPcTabEmoticonPackage(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "syncPcTabEmoticonPackage epId = " + str + " businessType = " + i3);
        }
        if (str != null && !this.tabCache.contains(str)) {
            this.tabCache.add(0, str);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public void asyncFindEmoticonPackage(String str, int i3, com.tencent.qqnt.emotion.c<EmoticonPackage> cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            new QueryTask(new a(), cVar).a(new Pair(str, Integer.valueOf(i3)));
        } else {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), cVar);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public EmoticonPackage syncFindEmoticonPackageById(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "syncFindEmoticonPackageById epId = " + str + ", type = " + i3);
        }
        EmoticonPackage emoticonPackage = this.pkgCache.get(str);
        if (emoticonPackage == null && (emoticonPackage = (EmoticonPackage) this.f356156em.d(EmoticonPackage.class, str)) != null) {
            this.pkgCache.put(str, emoticonPackage);
        }
        if (emoticonPackage == null || i3 == -1) {
            return emoticonPackage;
        }
        if (i3 == 0) {
            if (emoticonPackage.aio) {
                return emoticonPackage;
            }
            return null;
        }
        if (i3 != 1 || emoticonPackage.kandian) {
            return emoticonPackage;
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public EmoticonPackage syncFindTabEmoticonPackageById(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "syncFindTabEmoticonPackageById epId = " + str + " businessType = " + i3);
        }
        if (str != null && this.tabCache.contains(str)) {
            return syncFindEmoticonPackageById(str, i3);
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    public PicEmoticonInfo syncGetEmoticonInfo(MarkFaceMessage markFaceMessage) {
        String f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (PicEmoticonInfo) iPatchRedirector.redirect((short) 16, (Object) this, (Object) markFaceMessage);
        }
        if (markFaceMessage == null || (f16 = com.tencent.qqnt.emotion.emosm.b.f(markFaceMessage.sbufID, markFaceMessage.mediaType)) == null) {
            return null;
        }
        String valueOf = String.valueOf(markFaceMessage.dwTabID);
        int i3 = markFaceMessage.imageWidth;
        int i16 = markFaceMessage.imageHeight;
        Emoticon syncFindEmoticonById = syncFindEmoticonById(valueOf, f16);
        if (syncFindEmoticonById != null) {
            PicEmoticonInfo picEmoticonInfo = new PicEmoticonInfo(this.mCurrentAccountUin);
            picEmoticonInfo.type = 6;
            picEmoticonInfo.emoticon = syncFindEmoticonById;
            picEmoticonInfo.isAPNG = markFaceMessage.isAPNG;
            byte[] bArr = markFaceMessage.sbfKey;
            if (bArr != null && bArr.length > 0) {
                syncFindEmoticonById.encryptKey = new String(bArr);
            } else {
                syncFindEmoticonById.encryptKey = "";
            }
            if (syncFindEmoticonById.width == 0) {
                syncFindEmoticonById.width = i3;
            }
            if (syncFindEmoticonById.height == 0) {
                syncFindEmoticonById.height = i16;
            }
            byte[] bArr2 = markFaceMessage.mobileparam;
            if (bArr2 != null && bArr2.length > 0) {
                syncFindEmoticonById.jobType = 2;
                syncFindEmoticonById.magicValue = new String(bArr2);
            }
            if (markFaceMessage.mediaType == 3) {
                syncFindEmoticonById.jobType = 4;
            }
            if (syncFindEmoticonById.parseSoundPrintString() == null || syncFindEmoticonById.parseSoundPrintString().isEmpty()) {
                syncFindEmoticonById.voicePrintItems = markFaceMessage.voicePrintItems;
                syncFindEmoticonById.voicePrint = syncFindEmoticonById.toSoundPrintString();
            }
            if (TextUtils.isEmpty(syncFindEmoticonById.backColor)) {
                syncFindEmoticonById.backColor = markFaceMessage.backColor;
            }
            if (TextUtils.isEmpty(syncFindEmoticonById.volumeColor)) {
                syncFindEmoticonById.volumeColor = markFaceMessage.volumeColor;
            }
            picEmoticonInfo.imageType = markFaceMessage.cSubType;
            addExtensionSizeByScreenSize(valueOf, syncFindEmoticonById, markFaceMessage);
            return picEmoticonInfo;
        }
        PicEmoticonInfo picEmoticonInfo2 = new PicEmoticonInfo(this.mCurrentAccountUin);
        picEmoticonInfo2.type = 6;
        picEmoticonInfo2.isAPNG = markFaceMessage.isAPNG;
        Emoticon emoticon = new Emoticon();
        int i17 = markFaceMessage.mediaType;
        if (i17 == 1) {
            emoticon.isSound = true;
        } else if (i17 == 2) {
            emoticon.jobType = 1;
        } else if (i17 == 3) {
            emoticon.jobType = 4;
        }
        byte[] bArr3 = markFaceMessage.mobileparam;
        if (bArr3 != null && bArr3.length > 0) {
            emoticon.jobType = 2;
            emoticon.magicValue = new String(bArr3);
        }
        emoticon.epId = valueOf;
        emoticon.eId = f16;
        byte[] bArr4 = markFaceMessage.sbfKey;
        if (bArr4 != null && bArr4.length > 0) {
            emoticon.encryptKey = new String(bArr4);
        } else {
            emoticon.encryptKey = "";
        }
        emoticon.width = i3;
        emoticon.height = i16;
        emoticon.name = markFaceMessage.faceName;
        emoticon.volumeColor = markFaceMessage.volumeColor;
        emoticon.backColor = markFaceMessage.backColor;
        emoticon.voicePrintItems = markFaceMessage.voicePrintItems;
        emoticon.voicePrint = emoticon.toSoundPrintString();
        picEmoticonInfo2.emoticon = emoticon;
        picEmoticonInfo2.imageType = markFaceMessage.cSubType;
        addExtensionSizeByScreenSize(null, emoticon, markFaceMessage);
        return picEmoticonInfo2;
    }

    public List<Emoticon> syncGetSubEmoticonsByPackageId(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, this, str, Boolean.valueOf(z16));
        }
        if (str == null) {
            return null;
        }
        ArrayList<Emoticon> arrayList = (ArrayList) this.subEmoticonsCache.get(str);
        if (arrayList == null) {
            arrayList = queryEmoticonsByPackageIdFromDB(str);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "syncGetSubEmoticonsByPackageId from cache subEmoticonsCache.size:" + this.subEmoticonsCache.size() + ",epId:" + str);
        }
        return (arrayList == null || !z16) ? arrayList : (List) arrayList.clone();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057 A[EXC_TOP_SPLITTER, LOOP:0: B:20:0x0057->B:35:0x00a5, LOOP_START, PHI: r4
  0x0057: PHI (r4v1 int) = (r4v0 int), (r4v2 int) binds: [B:18:0x0054, B:35:0x00a5] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // com.tencent.qqnt.emotion.api.IEmoticonManagerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getExtensionSizeByScreenSize(String str) {
        JSONArray jSONArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str)).intValue();
        }
        Integer num = betterDisplaySize.get(Double.valueOf(fetchScreenInch()));
        if (num != null && num.intValue() != 0) {
            EmoticonPackage syncFindEmoticonPackageById = syncFindEmoticonPackageById(str);
            if (syncFindEmoticonPackageById != null && !TextUtils.isEmpty(syncFindEmoticonPackageById.supportSize)) {
                try {
                    jSONArray = new JSONArray(syncFindEmoticonPackageById.supportSize);
                } catch (JSONException e16) {
                    QLog.e(TAG, 1, e16, new Object[0]);
                }
                if (jSONArray != null) {
                    return -1;
                }
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        int i16 = jSONObject.getInt("Width");
                        int i17 = jSONObject.getInt("Height");
                        if (i16 == num.intValue() && i17 == num.intValue()) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "get support size from db, betterSize " + num + ", epId: " + str);
                            }
                            return num.intValue();
                        }
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                }
            }
            jSONArray = null;
            if (jSONArray != null) {
            }
        }
        return -1;
    }
}
