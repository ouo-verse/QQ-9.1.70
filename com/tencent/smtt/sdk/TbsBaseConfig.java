package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class TbsBaseConfig {
    public static final String TAG = "TbsBaseConfig";

    /* renamed from: a, reason: collision with root package name */
    Map<String, String> f369083a;

    /* renamed from: b, reason: collision with root package name */
    private Context f369084b;

    private static File a(Context context, String str) {
        n.a();
        File o16 = n.o(context);
        if (o16 == null) {
            return null;
        }
        File file = new File(o16, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void clear() {
        this.f369083a.clear();
        commit();
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }

    public abstract String getConfigFileName();

    public Map<String, String> getPVCLocal() {
        return this.f369083a;
    }

    public void init(Context context) {
        this.f369083a = new HashMap();
        Context applicationContext = context.getApplicationContext();
        this.f369084b = applicationContext;
        if (applicationContext == null) {
            this.f369084b = context;
        }
        refreshSyncMap(context);
    }

    public synchronized void refreshSyncMap(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th5;
        String str;
        String str2;
        File a16;
        try {
            a16 = a(this.f369084b, getConfigFileName());
            TbsLog.i(TAG, "refreshSyncMap propFile is " + a16);
        } catch (Throwable th6) {
            bufferedInputStream = null;
            th5 = th6;
        }
        if (a16 == null) {
            return;
        }
        this.f369083a.clear();
        bufferedInputStream = new BufferedInputStream(new FileInputStream(a16));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            for (String str3 : properties.stringPropertyNames()) {
                this.f369083a.put(str3, properties.getProperty(str3));
            }
            TbsLog.i(TAG, "refreshSyncMap pv mSyncMap is " + this.f369083a.toString());
        } catch (Throwable th7) {
            th5 = th7;
            try {
                TbsLog.i(TAG, "refreshSyncMap stack is " + Log.getStackTraceString(th5));
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e16) {
                        str = TAG;
                        str2 = "refreshSyncMap stack is " + Log.getStackTraceString(e16);
                        TbsLog.i(str, str2);
                    }
                }
            } finally {
            }
        }
        try {
            bufferedInputStream.close();
        } catch (Exception e17) {
            str = TAG;
            str2 = "refreshSyncMap stack is " + Log.getStackTraceString(e17);
            TbsLog.i(str, str2);
        }
    }

    public void update(Map<String, String> map) {
        this.f369083a.clear();
        this.f369083a.putAll(map);
        commit();
    }

    public synchronized void writeTbsDownloadInfo() {
        Throwable th5;
        BufferedOutputStream bufferedOutputStream;
        String str;
        String str2;
        File a16;
        Properties properties;
        TbsLog.i(TAG, "writeTbsDownloadInfo #1");
        BufferedInputStream bufferedInputStream = null;
        try {
            a16 = a(this.f369084b, getConfigFileName());
            TbsLog.i(TAG, "writeTbsDownloadInfo propFile is " + a16);
        } catch (Throwable th6) {
            th5 = th6;
            bufferedOutputStream = null;
        }
        if (a16 == null) {
            return;
        }
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(a16));
        try {
            properties = new Properties();
            properties.load(bufferedInputStream2);
            properties.clear();
            Set<String> keySet = this.f369083a.keySet();
            TbsLog.i(TAG, "writeTbsDownloadInfo mSyncMap.size() is " + this.f369083a.size());
            for (String str3 : keySet) {
                String str4 = this.f369083a.get(str3);
                properties.setProperty(str3, "" + ((Object) str4));
                TbsLog.i(TAG, "writeTbsDownloadInfo key is " + str3 + " value is " + ((Object) str4));
            }
            this.f369083a.clear();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(a16));
        } catch (Throwable th7) {
            th5 = th7;
            bufferedOutputStream = null;
        }
        try {
            properties.store(bufferedOutputStream, (String) null);
            TbsLog.i(TAG, "writeTbsDownloadInfo end ");
            try {
                bufferedInputStream2.close();
            } catch (Exception e16) {
                TbsLog.i(TAG, "writeTbsDownloadInfo stack is " + Log.getStackTraceString(e16));
            }
            try {
                bufferedOutputStream.close();
            } catch (Exception e17) {
                str = TAG;
                str2 = "writeTbsDownloadInfo stack is " + Log.getStackTraceString(e17);
                TbsLog.i(str, str2);
            }
        } catch (Throwable th8) {
            th5 = th8;
            bufferedInputStream = bufferedInputStream2;
            try {
                TbsLog.i(TAG, "writeTbsDownloadInfo stack is " + Log.getStackTraceString(th5));
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e18) {
                        TbsLog.i(TAG, "writeTbsDownloadInfo stack is " + Log.getStackTraceString(e18));
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e19) {
                        str = TAG;
                        str2 = "writeTbsDownloadInfo stack is " + Log.getStackTraceString(e19);
                        TbsLog.i(str, str2);
                    }
                }
            } finally {
            }
        }
    }
}
