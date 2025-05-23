package com.tencent.ad.tangram.experiment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.protocol.gdt_experiment_settings;
import com.tencent.ad.tangram.protocol.gdt_settings;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdExperimentManager {
    private static final int PRECISION = 10000;
    private static final String TAG = "AdExperimentManager";
    private static volatile AdExperimentManager sInstance;

    @NonNull
    private volatile Cache cache = new Cache();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Cache {
        private volatile String currentCachedUin;

        @NonNull
        private volatile ArrayList<String> expIdsInCache;

        @NonNull
        private volatile ArrayList<String> paramKeysInCache;

        Cache() {
            this.currentCachedUin = "";
            this.expIdsInCache = new ArrayList<>();
            this.paramKeysInCache = new ArrayList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public String[] getAllExpIds() {
            return (String[]) this.expIdsInCache.toArray(new String[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public String[] getAllParams() {
            return (String[]) this.paramKeysInCache.toArray(new String[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid(String str) {
            if (!TextUtils.isEmpty(this.currentCachedUin) && this.currentCachedUin.equals(str)) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void putExpId(String str) {
            this.expIdsInCache.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void putParamKeys(@Nullable String[] strArr) {
            if (strArr != null && strArr.length != 0) {
                this.paramKeysInCache.addAll(Arrays.asList(strArr));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCachedUin(String str) {
            AdLog.i(AdExperimentManager.TAG, "[Cache::setCachedUin] update pre uin" + str);
            this.currentCachedUin = str;
        }
    }

    AdExperimentManager() {
    }

    private static void cacheEachLayerParamsByHash(int i3, @Nullable gdt_experiment_settings.SettingsForJointExperiment.ExpItem[] expItemArr, @Nullable Cache cache) {
        if (expItemArr != null && expItemArr.length != 0 && cache != null) {
            for (gdt_experiment_settings.SettingsForJointExperiment.ExpItem expItem : expItemArr) {
                gdt_experiment_settings.SettingsForJointExperiment.Range[] rangeArr = expItem.rangeList;
                if (rangeArr != null) {
                    for (gdt_experiment_settings.SettingsForJointExperiment.Range range : rangeArr) {
                        if (range == null) {
                            return;
                        }
                        if (range.lower <= i3 && i3 <= range.upper) {
                            cache.putExpId(expItem.expId);
                            cache.putParamKeys(expItem.expParamKey);
                            return;
                        }
                    }
                }
            }
        }
    }

    private boolean cacheEachLayerParamsByWhiteLists(String str, @Nullable gdt_experiment_settings.SettingsForJointExperiment.ExpItem[] expItemArr, @Nullable Cache cache) {
        if (expItemArr != null && expItemArr.length != 0 && cache != null) {
            for (gdt_experiment_settings.SettingsForJointExperiment.ExpItem expItem : expItemArr) {
                String[] strArr = expItem.whiteList;
                if (strArr != null) {
                    for (String str2 : strArr) {
                        if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                            cache.putParamKeys(expItem.expParamKey);
                            cache.putExpId(expItem.expId);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static AdExperimentManager getInstance() {
        if (sInstance == null) {
            synchronized (AdExperimentManager.class) {
                if (sInstance == null) {
                    sInstance = new AdExperimentManager();
                }
            }
        }
        return sInstance;
    }

    private static int murmurHash32(byte[] bArr, int i3, int i16) {
        int i17 = i3 / 4;
        int i18 = i3;
        for (int i19 = 0; i19 < i17; i19++) {
            int i26 = i19 * 4;
            int i27 = ((bArr[i26] & 255) + ((bArr[i26 + 1] & 255) << 8) + ((bArr[i26 + 2] & 255) << 16) + ((bArr[i26 + 3] & 255) << 24)) * 1540483477;
            i18 = (i18 * 1540483477) ^ (((i27 >> 24) ^ i27) * 1540483477);
        }
        int i28 = i3 % 4;
        if (i28 == 3) {
            i18 ^= (bArr[(i3 & (-4)) + 2] & 255) << 16;
        }
        if (i28 == 3 || i28 == 2) {
            i18 ^= (bArr[(i3 & (-4)) + 1] & 255) << 8;
        }
        if (i28 != 0) {
            i18 = ((bArr[i3 & (-4)] & 255) ^ i18) * 1540483477;
        }
        int i29 = ((i18 >> 13) ^ i18) * 1540483477;
        return (i29 ^ (i29 >> 15)) % i16;
    }

    @NonNull
    public String[] getAllExpIdsByCache(String str, gdt_settings.Settings settings) {
        if (!this.cache.isValid(str)) {
            updateCache(str, settings);
        }
        return this.cache.getAllExpIds();
    }

    public boolean isHitExperiment(String str, @Nullable String str2, gdt_settings.Settings settings) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!this.cache.isValid(str)) {
            updateCache(str, settings);
        }
        String[] allParams = this.cache.getAllParams();
        if (allParams.length == 0) {
            return false;
        }
        for (String str3 : allParams) {
            if (str2.equals(str3)) {
                return true;
            }
        }
        return false;
    }

    public void updateCache(@Nullable String str, @Nullable gdt_settings.Settings settings) {
        if (TextUtils.isEmpty(str)) {
            AdLog.e(TAG, "[updateCache] error, parameters should not be empty");
            return;
        }
        if (settings == null) {
            AdLog.e(TAG, "[getExpId] error, settings are null");
            return;
        }
        Cache cache = new Cache();
        gdt_experiment_settings.SettingsForJointExperiment[] settingsForJointExperimentArr = settings.settingsForJointExperiment;
        if (settingsForJointExperimentArr == null) {
            return;
        }
        for (gdt_experiment_settings.SettingsForJointExperiment settingsForJointExperiment : settingsForJointExperimentArr) {
            if (!TextUtils.isEmpty(settingsForJointExperiment.layerName) && !cacheEachLayerParamsByWhiteLists(str, settingsForJointExperiment.itemList, cache)) {
                byte[] bytes = (str + settingsForJointExperiment.layerName).getBytes();
                cacheEachLayerParamsByHash(murmurHash32(bytes, bytes.length, 10000), settingsForJointExperiment.itemList, cache);
            }
        }
        cache.setCachedUin(str);
        this.cache = cache;
    }
}
