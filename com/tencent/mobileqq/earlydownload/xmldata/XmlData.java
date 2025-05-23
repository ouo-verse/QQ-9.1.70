package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.earlydownload.a;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.b;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class XmlData extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final int STATE_LOADING = 2;
    public static final int STATE_NONE = 0;
    public static final int STATE_SUCCESS = 1;

    @saveInSP(isServer = true, save = false)
    public String MD5;

    @saveInSP(isServer = true, save = true)
    public boolean StoreBackup;

    @saveInSP(isServer = true, save = true)
    public int Version;
    public long downSize;

    @saveInSP(isServer = false, save = true)
    public boolean hasResDownloaded;
    public boolean isUserClick;

    @saveInSP(isServer = true, save = true)
    public boolean load2G;

    @saveInSP(isServer = true, save = true)
    public boolean load3G;

    @saveInSP(isServer = false, save = true)
    public int loadState;

    @saveInSP(isServer = true, save = true)
    public boolean loadWifi;

    @saveInSP(isServer = true, save = true)
    public boolean net_2_2G;

    @saveInSP(isServer = true, save = true)
    public boolean net_2_3G;

    @saveInSP(isServer = true, save = true)
    public boolean net_2_wifi;

    @saveInSP(isServer = true, save = true)
    public boolean notPreDownloadInLowEndPhone;
    public int reqLoadCount;
    public String strLog;

    @saveInSP(isServer = true, save = true)
    public String strPkgName;

    @saveInSP(isServer = true, save = true)
    public String strResName;

    @saveInSP(isServer = true, save = false)
    public String strResURL_big;

    @saveInSP(isServer = true, save = false)
    public String strResURL_small;

    @saveInSP(isServer = false, save = true)
    public long tLoadFail;
    public long tStart;
    public long totalSize;

    public XmlData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String packageNameOf(AppInterface appInterface, String str) {
        b earlyHandler = ((IEarlyDownloadService) appInterface.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler(str);
        if (earlyHandler != null && earlyHandler.o() != null) {
            return earlyHandler.o().strPkgName;
        }
        return "(null)";
    }

    public abstract String getSharedPreferencesName();

    public abstract String getStrResName();

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        for (Class<?> cls = getClass(); cls != Entity.class; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers()) && field.isAnnotationPresent(saveInSP.class)) {
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    String name = field.getName();
                    try {
                        Object obj = field.get(this);
                        sb5.append(',');
                        sb5.append(name);
                        sb5.append('=');
                        sb5.append(obj);
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return sb5.toString();
    }

    public void updateServerInfo(XmlData xmlData) {
        Field[] c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) xmlData);
            return;
        }
        if (xmlData != null && (c16 = a.c(xmlData.getClass())) != null && c16.length != 0) {
            for (Field field : c16) {
                if (field.isAnnotationPresent(saveInSP.class) && ((saveInSP) field.getAnnotation(saveInSP.class)).isServer()) {
                    try {
                        field.set(this, field.get(xmlData));
                    } catch (IllegalAccessException e16) {
                        e16.printStackTrace();
                    } catch (IllegalArgumentException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }
}
