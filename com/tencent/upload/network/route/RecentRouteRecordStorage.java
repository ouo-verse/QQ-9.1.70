package com.tencent.upload.network.route;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.UploadLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RecentRouteRecordStorage {
    static IPatchRedirector $redirector_ = null;
    private static final String RECORD_FILE_NAME_PREFIX = "upload_recent_route";
    private static final String RECORD_FILE_VER = "_v2.0.3";
    private static final String TAG = "RouteSetStorage";
    private HashMap<String, RecentRouteRecord> mRecentRouteRecordMap;
    private final ServerRouteTable mServerRouteTable;

    public RecentRouteRecordStorage(ServerRouteTable serverRouteTable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) serverRouteTable);
            return;
        }
        this.mRecentRouteRecordMap = new HashMap<>();
        this.mServerRouteTable = serverRouteTable;
        load();
    }

    private void dump() {
        for (String str : this.mRecentRouteRecordMap.keySet()) {
            RecentRouteRecord recentRouteRecord = this.mRecentRouteRecordMap.get(str);
            if (recentRouteRecord != null) {
                UploadLog.d(TAG, "mRecentRouteRecordMap key=" + str + ",value=" + recentRouteRecord);
            }
        }
    }

    private String getRecentRouteSetFilePath(Const.BusinessType businessType) {
        return "upload_recent_route_" + businessType + "_" + RECORD_FILE_VER;
    }

    private boolean load() {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        Exception e16;
        UploadLog.i(TAG, "load");
        Context context = UploadGlobalConfig.getContext();
        if (context == null) {
            UploadLog.e(TAG, "load() UploadGlobalConfig.getContext() == null");
            return false;
        }
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = context.openFileInput(getRecentRouteSetFilePath(this.mServerRouteTable.businessType));
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream, 8192);
                        try {
                            objectInputStream = new ObjectInputStream(bufferedInputStream);
                            try {
                                Object readObject = objectInputStream.readObject();
                                if (readObject instanceof HashMap) {
                                    this.mRecentRouteRecordMap = (HashMap) readObject;
                                }
                                if (this.mRecentRouteRecordMap == null) {
                                    this.mRecentRouteRecordMap = new HashMap<>();
                                    objectInputStream.close();
                                    try {
                                        objectInputStream.close();
                                        bufferedInputStream.close();
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                    } catch (Exception e17) {
                                        e17.printStackTrace();
                                    }
                                    return false;
                                }
                                removeExpired();
                                dump();
                                try {
                                    objectInputStream.close();
                                    bufferedInputStream.close();
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                        return true;
                                    }
                                    return true;
                                } catch (Exception e18) {
                                    e18.printStackTrace();
                                    return true;
                                }
                            } catch (FileNotFoundException unused) {
                                objectInputStream2 = objectInputStream;
                                UploadLog.w(TAG, "load() FileNotFoundException:" + getRecentRouteSetFilePath(this.mServerRouteTable.businessType));
                                if (objectInputStream2 != null) {
                                    try {
                                        objectInputStream2.close();
                                    } catch (Exception e19) {
                                        e19.printStackTrace();
                                        return false;
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return false;
                            } catch (Exception e26) {
                                e16 = e26;
                                try {
                                    UploadLog.e(TAG, "load() readObject Exception", e16);
                                    context.deleteFile(getRecentRouteSetFilePath(this.mServerRouteTable.businessType));
                                } catch (Exception e27) {
                                    UploadLog.e(TAG, "deleteFile Exception", e27);
                                }
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e28) {
                                        e28.printStackTrace();
                                        return false;
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return false;
                            }
                        } catch (FileNotFoundException unused2) {
                        } catch (Exception e29) {
                            objectInputStream = null;
                            e16 = e29;
                        }
                    } catch (FileNotFoundException unused3) {
                        bufferedInputStream = null;
                    } catch (Exception e36) {
                        objectInputStream = null;
                        e16 = e36;
                        bufferedInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = null;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (Exception e37) {
                                e37.printStackTrace();
                                throw th;
                            }
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused4) {
                    fileInputStream = null;
                    bufferedInputStream = null;
                } catch (Exception e38) {
                    bufferedInputStream = null;
                    objectInputStream = null;
                    e16 = e38;
                    fileInputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = null;
                    bufferedInputStream = null;
                }
            } catch (Throwable th7) {
                th = th7;
                objectInputStream2 = objectInputStream;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    private void removeExpired() {
        Set<String> keySet;
        HashMap<String, RecentRouteRecord> hashMap = this.mRecentRouteRecordMap;
        if (hashMap == null || (keySet = hashMap.keySet()) == null) {
            return;
        }
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            RecentRouteRecord recentRouteRecord = this.mRecentRouteRecordMap.get(next);
            if (recentRouteRecord != null) {
                long timeStamp = recentRouteRecord.getTimeStamp();
                if (timeStamp != 0 && System.currentTimeMillis() > timeStamp + UploadConfiguration.getRecentRouteExpire()) {
                    it.remove();
                    UploadLog.d(TAG, "removeExpired key:" + next + " contains:" + this.mRecentRouteRecordMap.containsKey(next));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    private boolean save() {
        String str = "closeObject Exception";
        UploadLog.i(TAG, "save");
        Context context = UploadGlobalConfig.getContext();
        if (context == null) {
            UploadLog.e(TAG, "save() UploadGlobalConfig.getContext() == null");
            return false;
        }
        removeExpired();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput(getRecentRouteSetFilePath(this.mServerRouteTable.businessType), 0)));
                    try {
                        objectOutputStream2.writeObject(this.mRecentRouteRecordMap);
                        dump();
                        objectOutputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        objectOutputStream = objectOutputStream2;
                        UploadLog.e(TAG, "writeObject Exception", e);
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                            str = 1;
                            return true;
                        }
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e17) {
                                UploadLog.e(TAG, str, e17);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e18) {
                    e = e18;
                }
                str = 1;
                return true;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e19) {
            UploadLog.e(TAG, "closeObject Exception", e19);
            return true;
        }
    }

    public RecentRouteRecord getData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecentRouteRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return this.mRecentRouteRecordMap.get(str);
    }

    public void setData(String str, RecentRouteRecord recentRouteRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) recentRouteRecord);
        } else {
            this.mRecentRouteRecordMap.put(str, recentRouteRecord);
            save();
        }
    }
}
