package com.tencent.thumbplayer.core.drm;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.thumbplayer.api.capability.TPDrmCapAttribute;
import com.tencent.thumbplayer.core.utils.TPApplicationContext;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes26.dex */
public class TPMediaDrmCapabilityCache {
    private static final String DRM_ATTRIBUTE_LIST_KEY = "TP_DRM_ATTRIBUTE_LIST_KEY";
    private static final String DRM_SP_NAME = "TP_DRM_ATTRIBUTE_CAPABILITY";
    private static final String TAG = "TPMediaDrmCapabilityCache";
    private static TPDrmCapAttribute[] sDrmAttributes;

    public static synchronized TPDrmCapAttribute[] getMediaDrmCapAttributesCache() {
        TPDrmCapAttribute[] tPDrmCapAttributeArr;
        synchronized (TPMediaDrmCapabilityCache.class) {
            if (sDrmAttributes == null) {
                sDrmAttributes = readDrmCapAttributes();
            }
            tPDrmCapAttributeArr = sDrmAttributes;
            if (tPDrmCapAttributeArr == null) {
                tPDrmCapAttributeArr = new TPDrmCapAttribute[0];
            }
        }
        return tPDrmCapAttributeArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x004f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TPDrmCapAttribute[] readDrmCapAttributes() {
        Set<String> set;
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        TPDrmCapAttribute tPDrmCapAttribute;
        ObjectInputStream objectInputStream2 = null;
        try {
            set = TPApplicationContext.getContext().getSharedPreferences(DRM_SP_NAME, 0).getStringSet(DRM_ATTRIBUTE_LIST_KEY, null);
        } catch (ClassCastException e16) {
            TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, sp getStringSet has exception:" + e16.getMessage());
            set = null;
        }
        if (set == null || set.isEmpty()) {
            return null;
        }
        TPDrmCapAttribute[] tPDrmCapAttributeArr = new TPDrmCapAttribute[set.size()];
        Iterator<String> it = set.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            try {
                byteArrayInputStream = new ByteArrayInputStream(Base64.decode(it.next().getBytes(), 0));
            } catch (IOException e17) {
                e = e17;
                objectInputStream = null;
                byteArrayInputStream = null;
                TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, readObject has exception:" + e.getMessage());
                if (objectInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
            } catch (ClassCastException e18) {
                e = e18;
                objectInputStream = null;
                byteArrayInputStream = null;
                TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, readObject has exception:" + e.getMessage());
                if (objectInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
            } catch (ClassNotFoundException e19) {
                e = e19;
                objectInputStream = null;
                byteArrayInputStream = null;
                TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, readObject has exception:" + e.getMessage());
                if (objectInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
            } catch (IllegalArgumentException e26) {
                e = e26;
                objectInputStream = null;
                byteArrayInputStream = null;
                TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, readObject has exception:" + e.getMessage());
                if (objectInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
            } catch (Throwable th5) {
                th = th5;
                byteArrayInputStream = null;
            }
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e27) {
                e = e27;
                objectInputStream = null;
                TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, readObject has exception:" + e.getMessage());
                if (objectInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
            } catch (ClassCastException e28) {
                e = e28;
                objectInputStream = null;
                TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, readObject has exception:" + e.getMessage());
                if (objectInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
            } catch (ClassNotFoundException e29) {
                e = e29;
                objectInputStream = null;
                TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, readObject has exception:" + e.getMessage());
                if (objectInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
            } catch (IllegalArgumentException e36) {
                e = e36;
                objectInputStream = null;
                TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, readObject has exception:" + e.getMessage());
                if (objectInputStream != null) {
                }
                if (byteArrayInputStream != null) {
                }
            } catch (Throwable th6) {
                th = th6;
            }
            try {
                try {
                    tPDrmCapAttribute = (TPDrmCapAttribute) objectInputStream.readObject();
                } catch (IOException e37) {
                    e = e37;
                } catch (ClassCastException e38) {
                    e = e38;
                } catch (ClassNotFoundException e39) {
                    e = e39;
                } catch (IllegalArgumentException e46) {
                    e = e46;
                }
                if (tPDrmCapAttribute == null) {
                    TPNativeLog.printLog(0, TAG, "readDrmCapAttributes, drmCapAttribute is null and return null");
                    try {
                        objectInputStream.close();
                    } catch (IOException e47) {
                        TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, ois close has exception:" + e47.getMessage());
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e48) {
                        TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, bais close has exception:" + e48.getMessage());
                    }
                    return null;
                }
                int i16 = i3 + 1;
                try {
                    tPDrmCapAttributeArr[i3] = tPDrmCapAttribute;
                    try {
                        objectInputStream.close();
                    } catch (IOException e49) {
                        TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, ois close has exception:" + e49.getMessage());
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e56) {
                        TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, bais close has exception:" + e56.getMessage());
                    }
                    i3 = i16;
                } catch (IOException | ClassCastException | ClassNotFoundException | IllegalArgumentException e57) {
                    e = e57;
                    i3 = i16;
                    TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, readObject has exception:" + e.getMessage());
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e58) {
                            TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, ois close has exception:" + e58.getMessage());
                        }
                    }
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e59) {
                            TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, bais close has exception:" + e59.getMessage());
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                objectInputStream2 = objectInputStream;
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e65) {
                        TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, ois close has exception:" + e65.getMessage());
                    }
                }
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                        throw th;
                    } catch (IOException e66) {
                        TPNativeLog.printLog(1, TAG, "readDrmCapAttributes, bais close has exception:" + e66.getMessage());
                        throw th;
                    }
                }
                throw th;
            }
        }
        return tPDrmCapAttributeArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void saveDrmCapAttributes(TPDrmCapAttribute[] tPDrmCapAttributeArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        HashSet hashSet = new HashSet();
        for (TPDrmCapAttribute tPDrmCapAttribute : tPDrmCapAttributeArr) {
            if (tPDrmCapAttribute != null) {
                ObjectOutputStream objectOutputStream2 = null;
                objectOutputStream2 = null;
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream.writeObject(tPDrmCapAttribute);
                            hashSet.add(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                            try {
                                objectOutputStream.close();
                            } catch (IOException e16) {
                                TPNativeLog.printLog(1, TAG, "saveDrmCapAttributes, oos close has exception:" + e16.getMessage());
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e17) {
                                TPNativeLog.printLog(1, TAG, "saveDrmCapAttributes, baos close has exception:" + e17.getMessage());
                            }
                        } catch (IOException e18) {
                            e = e18;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            try {
                                TPNativeLog.printLog(1, TAG, "saveDrmCapAttributes, writeObject has exception:" + e.getMessage());
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (IOException e19) {
                                        TPNativeLog.printLog(1, TAG, "saveDrmCapAttributes, oos close has exception:" + e19.getMessage());
                                    }
                                }
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                        return;
                                    } catch (IOException e26) {
                                        TPNativeLog.printLog(1, TAG, "saveDrmCapAttributes, baos close has exception:" + e26.getMessage());
                                        return;
                                    }
                                }
                                return;
                            } catch (Throwable th5) {
                                th = th5;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                objectOutputStream2 = objectOutputStream;
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (IOException e27) {
                                        TPNativeLog.printLog(1, TAG, "saveDrmCapAttributes, oos close has exception:" + e27.getMessage());
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th;
                                    } catch (IOException e28) {
                                        TPNativeLog.printLog(1, TAG, "saveDrmCapAttributes, baos close has exception:" + e28.getMessage());
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            objectOutputStream2 = objectOutputStream;
                            if (objectOutputStream2 != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                        }
                    } catch (IOException e29) {
                        e = e29;
                        objectOutputStream = null;
                    } catch (Throwable th7) {
                        th = th7;
                        if (objectOutputStream2 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                    }
                } catch (IOException e36) {
                    e = e36;
                    objectOutputStream = null;
                } catch (Throwable th8) {
                    th = th8;
                    byteArrayOutputStream = null;
                }
            }
        }
        SharedPreferences.Editor edit = TPApplicationContext.getContext().getSharedPreferences(DRM_SP_NAME, 0).edit();
        edit.putStringSet(DRM_ATTRIBUTE_LIST_KEY, hashSet);
        edit.apply();
    }

    public static synchronized void setMediaDrmCapAttributesCache(TPDrmCapAttribute[] tPDrmCapAttributeArr) {
        synchronized (TPMediaDrmCapabilityCache.class) {
            sDrmAttributes = tPDrmCapAttributeArr;
            if (tPDrmCapAttributeArr == null) {
                TPNativeLog.printLog(1, TAG, "setMediaDrmCapAttributesCache, drmCapAttributes is null and return");
            } else {
                saveDrmCapAttributes(tPDrmCapAttributeArr);
            }
        }
    }
}
