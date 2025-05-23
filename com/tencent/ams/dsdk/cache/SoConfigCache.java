package com.tencent.ams.dsdk.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.data.SoConfig;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.ams.dsdk.utils.ParcelableUtil;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SoConfigCache {
    static IPatchRedirector $redirector_ = null;
    private static final String CACHE_DIR = "conf";
    protected static final String CACHE_FILE_NAME = "so_configs.conf";
    private static final String TAG = "SoConfigCache";
    private String mCachePath;
    private volatile boolean mInited;
    private final Map<Integer, SoConfig> mSoConfigMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static IPatchRedirector $redirector_;
        private static final SoConfigCache INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14050);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new SoConfigCache(null);
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ SoConfigCache(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doInit, reason: merged with bridge method [inline-methods] */
    public synchronized void lambda$init$0() {
        if (!this.mInited) {
            this.mInited = true;
            List<SoConfig> readCacheWithParcel = readCacheWithParcel();
            if (readCacheWithParcel != null && !readCacheWithParcel.isEmpty()) {
                for (SoConfig soConfig : readCacheWithParcel) {
                    if (soConfig != null) {
                        this.mSoConfigMap.put(Integer.valueOf(soConfig.engineType), soConfig);
                    }
                }
            }
        }
    }

    private String getCachePath() {
        if (this.mCachePath == null) {
            String fileDir = FileUtils.getFileDir();
            if (TextUtils.isEmpty(fileDir)) {
                return null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(fileDir);
            String str = File.separator;
            sb5.append(str);
            sb5.append(CACHE_DIR);
            sb5.append(str);
            sb5.append(CACHE_FILE_NAME);
            this.mCachePath = sb5.toString();
        }
        return this.mCachePath;
    }

    public static SoConfigCache getInstance() {
        return Holder.INSTANCE;
    }

    private void init() {
        DLog.i(TAG, "init");
        Runnable runnable = new Runnable() { // from class: com.tencent.ams.dsdk.cache.b
            @Override // java.lang.Runnable
            public final void run() {
                SoConfigCache.this.lambda$init$0();
            }
        };
        if (DKConfiguration.isEnableOrganizeThreads()) {
            DynamicUtils.runOnAsyncThread(runnable);
        } else {
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(runnable);
        }
    }

    private List<SoConfig> readCacheWithParcel() {
        List<SoConfig> arrayList = new ArrayList<>();
        String cachePath = getCachePath();
        if (cachePath == null) {
            DLog.w(TAG, "filePath is null or empty.");
            return arrayList;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            byte[] readBytesFromFile = FileUtils.readBytesFromFile(cachePath);
            if (readBytesFromFile != null) {
                SoConfigs createFromParcel = SoConfigs.CREATOR.createFromParcel(ParcelableUtil.unmarshall(readBytesFromFile));
                if (createFromParcel != null) {
                    arrayList = createFromParcel.configs;
                }
            }
        } catch (Throwable th5) {
            DLog.e(TAG, "readCacheWithParcel error.", th5);
        }
        DLog.d(TAG, "readCacheWithParcel, timeCost: " + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList;
    }

    private boolean saveCacheWithParcel(List<SoConfig> list) {
        DLog.d(TAG, "saveCacheWithParcel");
        boolean z16 = false;
        if (list == null) {
            DLog.w(TAG, "map is null or empty.");
            return false;
        }
        String cachePath = getCachePath();
        if (TextUtils.isEmpty(cachePath)) {
            DLog.w(TAG, "cache path is null or empty.");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            z16 = FileUtils.writeBytesToFile(ParcelableUtil.marshall(new SoConfigs(list)), cachePath);
        } catch (Throwable th5) {
            DLog.e(TAG, "saveCacheWithParcel error.", th5);
        }
        DLog.d(TAG, "saveCacheWithParcel, timeCost: " + (System.currentTimeMillis() - currentTimeMillis));
        return z16;
    }

    private synchronized boolean updateSoConfigMemory(SoConfig soConfig) {
        DLog.i(TAG, "updateSoConfigMemory, config: " + soConfig);
        if (soConfig == null) {
            return false;
        }
        lambda$init$0();
        SoConfig soConfig2 = this.mSoConfigMap.get(Integer.valueOf(soConfig.engineType));
        if (soConfig2 != null && !TextUtils.isEmpty(soConfig2.version) && DynamicUtils.compareVersion(soConfig.version, soConfig2.version) <= 0) {
            return false;
        }
        this.mSoConfigMap.put(Integer.valueOf(soConfig.engineType), soConfig);
        return true;
    }

    public synchronized SoConfig getSoConfig(@SoConfig.EngineType int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SoConfig) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        lambda$init$0();
        return this.mSoConfigMap.get(Integer.valueOf(i3));
    }

    public synchronized List<SoConfig> getSoConfigs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        lambda$init$0();
        Collection<SoConfig> values = this.mSoConfigMap.values();
        ArrayList arrayList = new ArrayList();
        if (values != null && !values.isEmpty()) {
            arrayList.addAll(values);
        }
        return arrayList;
    }

    public synchronized void updateSoConfig(List<SoConfig> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        DLog.i(TAG, "updateSoConfig list");
        if (list == null) {
            return;
        }
        lambda$init$0();
        Iterator<SoConfig> it = list.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (updateSoConfigMemory(it.next())) {
                z16 = true;
            }
        }
        if (z16) {
            saveCacheWithParcel(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class SoConfigs implements Parcelable {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<SoConfigs> CREATOR;
        public List<SoConfig> configs;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14061);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = new Parcelable.Creator<SoConfigs>() { // from class: com.tencent.ams.dsdk.cache.SoConfigCache.SoConfigs.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public SoConfigs createFromParcel(Parcel parcel) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new SoConfigs(parcel) : (SoConfigs) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public SoConfigs[] newArray(int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SoConfigs[i3] : (SoConfigs[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                    }
                };
            }
        }

        public SoConfigs(List<SoConfig> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.configs = list;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            } else {
                parcel.writeTypedList(this.configs);
            }
        }

        protected SoConfigs(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.configs = parcel.createTypedArrayList(SoConfig.CREATOR);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
        }
    }

    SoConfigCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSoConfigMap = new ConcurrentHashMap();
        this.mCachePath = null;
        this.mInited = false;
        init();
    }

    public synchronized void updateSoConfig(SoConfig soConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) soConfig);
            return;
        }
        boolean updateSoConfigMemory = updateSoConfigMemory(soConfig);
        DLog.i(TAG, "updateSoConfig, config: " + soConfig + ", isUpdateMemory: " + updateSoConfigMemory);
        if (updateSoConfigMemory) {
            saveCacheWithParcel(getSoConfigs());
        }
    }
}
