package com.tenpay.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.api.IApiCache;
import com.tenpay.cache.CacheEnc;
import com.tenpay.cache.DiskCache;
import com.tenpay.proxy.ObjectProxy;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiCacheImpl implements IApiCache {
    private static final String CACHE_NAME = "QWallet_cache";
    private static final int CACHE_SIZE = 200;
    private static final String TAG = "ApiCache";
    private static final String UIN_KEY_FORMAT = "%s_%s";
    private DiskCache mDiskCache;
    private ObjectProxy memCacheProxy;

    @Override // com.tenpay.api.IApiCache
    public Object getUinValue(String str, String str2, Object obj) {
        return getValue(String.format(UIN_KEY_FORMAT, str, str2), obj);
    }

    @Override // com.tenpay.api.IApiCache
    public Object getValue(String str, Object obj) {
        boolean z16;
        synchronized (ApiCacheImpl.class) {
            String str2 = this.memCacheProxy.get(str);
            if (str2 == null) {
                str2 = this.mDiskCache.getValue(str);
                if (str2 == null) {
                    QwLog.i("error, cache can't find...");
                    return obj;
                }
                z16 = true;
            } else {
                z16 = false;
            }
            long parseLong = Long.parseLong(str2.substring(0, 10).trim());
            long currentTimeMillis = parseLong - (System.currentTimeMillis() / 1000);
            QwLog.i(str + ": endTime = " + parseLong + " cache left time = " + currentTimeMillis);
            if (currentTimeMillis < 0) {
                QwLog.i(str + ": cache time over...");
                removeKey(str);
                return obj;
            }
            String substring = str2.substring(10);
            if (z16) {
                setValue(str, substring, currentTimeMillis, false);
            }
            try {
                if (obj instanceof Integer) {
                    return Integer.valueOf(Integer.parseInt(substring));
                }
                if (obj instanceof Boolean) {
                    return Boolean.valueOf(Boolean.parseBoolean(substring));
                }
                if (obj instanceof Float) {
                    return Float.valueOf(Float.parseFloat(substring));
                }
                if (obj instanceof Long) {
                    return Long.valueOf(Long.parseLong(substring));
                }
                if (obj instanceof byte[]) {
                    return substring.getBytes();
                }
                return substring;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
                return substring;
            }
        }
    }

    @Override // com.tenpay.api.IApiBase
    public void init(Context context) {
        synchronized (ApiCacheImpl.class) {
            QwLog.i("initialize the cacher...");
            this.memCacheProxy = new ObjectProxy(200);
            this.mDiskCache = new DiskCache(context, CACHE_NAME, new CacheEnc(context));
        }
    }

    @Override // com.tenpay.api.IApiCache
    public void removeKey(String str) {
        synchronized (ApiCacheImpl.class) {
            this.memCacheProxy.put(str, null);
            this.mDiskCache.getWorker().remove(str);
        }
    }

    @Override // com.tenpay.api.IApiCache
    public void removeUinKey(String str, String str2) {
        removeKey(String.format(UIN_KEY_FORMAT, str, str2));
    }

    @Override // com.tenpay.api.IApiCache
    public boolean resetCacheTime(String str, long j3) {
        String str2 = (String) getValue(str, "");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        setValue(str, str2, j3);
        return true;
    }

    @Override // com.tenpay.api.IApiCache
    public boolean resetUinCacheTime(String str, String str2, long j3) {
        String str3 = (String) getUinValue(str, str2, "");
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        setUinValue(str, str2, str3, j3);
        return true;
    }

    @Override // com.tenpay.api.IApiCache
    public void setUinValue(String str, String str2, Object obj, long j3) {
        setValue(String.format(UIN_KEY_FORMAT, str, str2), obj, j3);
    }

    @Override // com.tenpay.api.IApiCache
    public void setValue(String str, Object obj, long j3) {
        setValue(str, obj, j3, true);
    }

    private void setValue(String str, Object obj, long j3, boolean z16) {
        synchronized (ApiCacheImpl.class) {
            if (j3 > 31536000) {
                throw new RuntimeException("cache time expired, you should specify the the time between TIME_NO_LIMIT and TIME_MAX_LIMIT...");
            }
            if (obj != null && j3 > 0) {
                String format = String.format("%-10s", Long.valueOf((System.currentTimeMillis() / 1000) + j3));
                QwLog.i(str + ": endtime = " + format + " cache time = " + j3);
                ObjectProxy objectProxy = this.memCacheProxy;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(format);
                sb5.append(obj.toString());
                objectProxy.put(str, sb5.toString());
                if (z16) {
                    this.mDiskCache.getWorker().setValue(str, obj.toString(), format);
                }
                return;
            }
            QwLog.i("remove the key second = " + j3);
            removeKey(str);
        }
    }
}
