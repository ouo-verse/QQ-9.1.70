package com.tencent.mobileqq.vas.avatar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLState;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.FindTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.LongSparseArray;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasFaceManager extends VasManager<String> {
    private static Bundle C;

    /* renamed from: h, reason: collision with root package name */
    public static Boolean f308778h;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f308780m;

    /* renamed from: d, reason: collision with root package name */
    public QQAppInterface f308781d;

    /* renamed from: e, reason: collision with root package name */
    private final LongSparseArray<Object> f308782e = new LongSparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    private LinkedHashMap<String, Object> f308783f = new LinkedHashMap<String, Object>(20, 0.75f, true) { // from class: com.tencent.mobileqq.vas.avatar.VasFaceManager.2
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, Object> entry) {
            if (size() > 20) {
                ImageCacheHelper.f98636a.m(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public synchronized Object put(String str, Object obj) {
            return super.put((AnonymousClass2) str, (String) obj);
        }
    };

    /* renamed from: i, reason: collision with root package name */
    public static Handler f308779i = new Handler(Looper.getMainLooper());
    private static final ArrayList<Replayer> D = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Replayer implements Runnable, ApngDrawable.OnPlayRepeatListener {

        /* renamed from: d, reason: collision with root package name */
        public WeakReference<ApngImage> f308786d;

        /* renamed from: e, reason: collision with root package name */
        private long f308787e;

        /* renamed from: f, reason: collision with root package name */
        private long f308788f;

        /* renamed from: h, reason: collision with root package name */
        private Handler f308789h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f308790i;

        /* renamed from: m, reason: collision with root package name */
        private String f308791m;

        public Replayer(String str, ApngDrawable apngDrawable, Handler handler) {
            this.f308786d = new WeakReference<>(apngDrawable.getImage());
            this.f308789h = handler;
            apngDrawable.setOnPlayRepeatListener(this);
            this.f308791m = str;
        }

        public void e() {
            if (this.f308790i) {
                this.f308788f += SystemClock.uptimeMillis() - this.f308787e;
                this.f308789h.removeCallbacks(this);
            }
        }

        public void f() {
            this.f308789h.post(this);
        }

        public void g() {
            if (this.f308790i) {
                this.f308787e = SystemClock.uptimeMillis();
                long j3 = this.f308788f;
                if (j3 >= 5000) {
                    this.f308789h.post(this);
                } else {
                    this.f308789h.postDelayed(this, 5000 - j3);
                }
            }
        }

        @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
        public void onPlayRepeat(int i3) {
            if (i3 == 3) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.qqhead.VasFaceManager", 1, "onPlayRepeat: " + this.f308791m + " image: " + this.f308786d.get());
                }
                this.f308787e = SystemClock.uptimeMillis();
                this.f308788f = 0L;
                this.f308790i = true;
                this.f308789h.postDelayed(this, 5000L);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f308790i = false;
            this.f308789h.removeCallbacks(this);
            ApngImage apngImage = this.f308786d.get();
            if (apngImage != null) {
                apngImage.replay();
                if (QLog.isColorLevel()) {
                    QLog.i("Q.qqhead.VasFaceManager", 2, "replay " + apngImage + " in " + this);
                }
            }
        }
    }

    public VasFaceManager(AppInterface appInterface) {
        this.f308781d = (QQAppInterface) appInterface;
    }

    public static Bundle c() {
        if (C == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_loop", 3);
            bundle.putBoolean("key_double_bitmap", true);
            bundle.putBoolean("key_draw_round", true);
            bundle.putBoolean("key_get_reset_loop", false);
            bundle.putBoolean("key_stop_on_first", true);
            bundle.putIntArray("key_tagId_arr", new int[]{9, 10, 2, 1, 0, 11});
            bundle.putString("key_name", "-face-");
            C = bundle;
        }
        return C;
    }

    public static Bundle d(boolean z16) {
        Bundle c16 = c();
        if (z16) {
            Bundle bundle = new Bundle();
            bundle.putAll(c16);
            bundle.remove("key_loop");
            return bundle;
        }
        return c16;
    }

    public static String e(int i3, String str) {
        StringBuilder P = com.tencent.mobileqq.activity.aio.l.P();
        String str2 = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 23L).getBusinessItemInfo(23L, g(i3, str)).mSavePath;
        if (new File(str2).exists()) {
            return str2;
        }
        if (j()) {
            P.append(AppConstants.PATH_HEAD_STORE);
        } else {
            P.append("/data/data/com.tencent.mobileqq/files/head/_st/");
        }
        P.append(i3);
        P.append(File.separatorChar);
        P.append(str);
        P.append(".png");
        return P.toString();
    }

    public static VasFaceManager f(QQAppInterface qQAppInterface) {
        return ((ao) qQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308429f;
    }

    public static String g(int i3, String str) {
        StringBuilder P = com.tencent.mobileqq.activity.aio.l.P();
        P.append("face.");
        P.append(i3);
        P.append(".");
        P.append(str);
        return P.toString();
    }

    public static int h(String str, QQAppInterface qQAppInterface) {
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "Q.qqhead.VasFaceManager");
        VipData vipDataForFriends = ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(str);
        if ((vasSimpleInfoWithUid == null || vasSimpleInfoWithUid.faceId <= 0) && !SimpleUIUtil.getSimpleUISwitch() && vipDataForFriends.getSpecialAvatarId() <= 0) {
            return 0;
        }
        return 4;
    }

    private static boolean j() {
        if (f308778h == null) {
            f308778h = Boolean.valueOf(cu.e());
        }
        return f308778h.booleanValue();
    }

    public static void m() {
        if (!f308780m) {
            ArrayList<Replayer> arrayList = D;
            synchronized (arrayList) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    D.get(size).e();
                }
            }
            f308780m = true;
        }
    }

    public static void n(String str, ApngDrawable apngDrawable) {
        ArrayList<Replayer> arrayList = D;
        synchronized (arrayList) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ArrayList<Replayer> arrayList2 = D;
                ApngImage apngImage = arrayList2.get(size).f308786d.get();
                if (apngImage == null) {
                    arrayList2.remove(size);
                } else if (apngImage == apngDrawable.getImage()) {
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.qqhead.VasFaceManager", 2, "registerNewFace: " + apngDrawable.getImage());
            }
            D.add(new Replayer(str, apngDrawable, f308779i));
        }
    }

    public static void o(ApngDrawable apngDrawable) {
        ArrayList<Replayer> arrayList = D;
        synchronized (arrayList) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ArrayList<Replayer> arrayList2 = D;
                Replayer replayer = arrayList2.get(size);
                ApngImage apngImage = replayer.f308786d.get();
                if (apngImage == null) {
                    arrayList2.remove(size);
                } else if (apngImage == apngDrawable.getImage()) {
                    replayer.f();
                    return;
                }
            }
        }
    }

    public static void t() {
        if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.VasFaceManager", 2, "resume: " + D.size());
        }
        ArrayList<Replayer> arrayList = D;
        synchronized (arrayList) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ArrayList<Replayer> arrayList2 = D;
                Replayer replayer = arrayList2.get(size);
                if (replayer.f308786d.get() != null) {
                    replayer.g();
                } else {
                    arrayList2.remove(size);
                }
            }
        }
        f308780m = false;
    }

    private void u(NTVasSimpleInfo nTVasSimpleInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.VasFaceManager", 2, "onFaceIdChanged uin: " + nTVasSimpleInfo.getUin() + " newId: " + nTVasSimpleInfo.faceId + " faceUpdateTime: " + nTVasSimpleInfo.faceIdUpdateTime);
        }
        complete(nTVasSimpleInfo.getUin(), null);
        if (nTVasSimpleInfo.getUin().equals(this.f308781d.getCurrentAccountUin())) {
            SharedPreferences.Editor edit = com.tencent.relation.common.utils.h.e(this.f308781d.getApplicationContext(), this.f308781d.getCurrentAccountUin()).edit();
            edit.putInt(AppConstants.Preferences.MY_STORE_FACE_ID, nTVasSimpleInfo.faceId);
            edit.commit();
        }
    }

    public void b(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        this.f308783f.put(URLState.getMemoryCacheKey(url.toString(), uRLDrawableOptions), Boolean.TRUE);
    }

    public void i(String str, int i3) {
        int i16;
        try {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "Q.qqhead.VasFaceManager");
            if (vasSimpleInfoWithUid == null) {
                NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo();
                nTVasSimpleInfo.f(str);
                nTVasSimpleInfo.e(uidFromUin);
                i16 = 0;
            } else {
                i16 = vasSimpleInfoWithUid.faceId;
            }
            QLog.d("Q.qqhead.VasFaceManager", 1, "handleFaceId uin: " + str + " oldId: " + i16 + " newId: " + i3);
            if (i16 != i3) {
                s(Arrays.asList(str));
            }
            NTVasSimpleInfo nTVasSimpleInfo2 = new NTVasSimpleInfo(uidFromUin, str);
            nTVasSimpleInfo2.c();
            nTVasSimpleInfo2.faceId = i3;
            nTVasSimpleInfo2.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
            nTVasSimpleInfo2.timestamp = System.currentTimeMillis();
            ((IVasInfoService) QRoute.api(IVasInfoService.class)).accurateUpdateVasSimpleInfo(nTVasSimpleInfo2, "Q.qqhead.VasFaceManager", (hx3.c<NTVasSimpleInfo>) null);
        } catch (Exception e16) {
            QLog.e("Q.qqhead.VasFaceManager", 1, "", e16);
        }
    }

    public void k(List<NTVasSimpleInfo> list) {
        HashSet hashSet = new HashSet();
        for (NTVasSimpleInfo nTVasSimpleInfo : list) {
            if (nTVasSimpleInfo != null && !TextUtils.isEmpty(nTVasSimpleInfo.getUin())) {
                u(nTVasSimpleInfo);
                hashSet.add(nTVasSimpleInfo.getUin());
            }
        }
        if (!hashSet.isEmpty()) {
            this.f308781d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(46, true, hashSet);
        }
    }

    public void l(NTVasSimpleInfo nTVasSimpleInfo) {
        HashSet hashSet = new HashSet();
        if (nTVasSimpleInfo != null && !TextUtils.isEmpty(nTVasSimpleInfo.getUin())) {
            u(nTVasSimpleInfo);
            hashSet.add(nTVasSimpleInfo.getUin());
            this.f308781d.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(46, true, hashSet);
        }
    }

    @Override // com.tencent.mobileqq.vas.VasManager, mqq.manager.Manager
    public void onDestroy() {
        super.onDestroy();
    }

    public void p(String str, VasManager.CompleteListener<String> completeListener, Object obj) {
        q(str, completeListener, obj, false);
    }

    public void q(String str, VasManager.CompleteListener<String> completeListener, Object obj, boolean z16) {
        r(str, completeListener, obj, z16, false);
    }

    public void r(final String str, VasManager.CompleteListener<String> completeListener, Object obj, final boolean z16, boolean z17) {
        registerListener(str, completeListener, obj);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.VasFaceManager.1
            @Override // java.lang.Runnable
            public void run() {
                NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "Q.qqhead.VasFaceManager");
                if (!z16 && vasSimpleInfoWithUid != null && vasSimpleInfoWithUid.faceIdUpdateTime != 0) {
                    VasFaceManager.this.complete(str, null);
                    return;
                }
                if (QLog.isDebugVersion()) {
                    QLog.d("Q.qqhead.VasFaceManager", 2, "requestFaceId uin: " + str);
                }
                AvatarPendantUtil.b(str, VasFaceManager.this.f308781d);
            }
        }, 32, null, true);
    }

    public void s(Collection<String> collection) {
        EntityManager createEntityManager = this.f308781d.getEntityManagerFactory().createEntityManager();
        try {
            try {
                ArrayList arrayList = new ArrayList();
                for (String str : collection) {
                    Setting setting = (Setting) createEntityManager.doFindOperateByTransaction(new FindTransaction((Class<? extends Entity>) Setting.class, str));
                    if (setting != null) {
                        setting.updateTimestamp = 0L;
                        this.f308781d.updateSettingTableCache(setting);
                        this.f308781d.removeFaceIconCache(1, str, 200);
                        arrayList.add(new UpdateTransaction(setting));
                    }
                }
                if (!arrayList.isEmpty()) {
                    createEntityManager.doMultiDBOperateByTransaction(arrayList);
                }
            } catch (Exception e16) {
                QLog.e("Q.qqhead.VasFaceManager", 1, "resetBaseAvatar failed", e16);
            }
        } finally {
            createEntityManager.close();
        }
    }
}
