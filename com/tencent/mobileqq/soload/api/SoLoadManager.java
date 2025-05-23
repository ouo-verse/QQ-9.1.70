package com.tencent.mobileqq.soload.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoLoadManager {
    static IPatchRedirector $redirector_ = null;
    public static final String SOLOAD_TAG_PREFIX = "SoLoadWidget.";
    public static final String TAG = "SoLoadWidget.SoLoadManager";
    private static volatile SoLoadManager sInstance;
    private final ISoLoaderService mISoLoadService;

    SoLoadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mISoLoadService = (ISoLoaderService) QRoute.api(ISoLoaderService.class);
        }
    }

    public static SoLoadManager getInstance() {
        if (sInstance == null) {
            synchronized (SoLoadManager.class) {
                if (sInstance == null) {
                    sInstance = new SoLoadManager();
                }
            }
        }
        return sInstance;
    }

    public void download(String str, OnLoadListener onLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.mISoLoadService.download(str, onLoadListener);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) onLoadListener);
        }
    }

    @Deprecated
    public List<String> getCurInitSoList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mISoLoadService.getCurInitSoList();
    }

    public String getInitVer(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
        return this.mISoLoadService.getInitVer(str);
    }

    public String getSoVer(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        return this.mISoLoadService.getSoVer(str);
    }

    public boolean isExist(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        LoadExtResult loadSync = loadSync(str, new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).setIsNoNeedCRC(true).setCloseRetry(true).setCloseReport(true).build());
        if (loadSync == null) {
            loadSync = new LoadExtResult();
        }
        return loadSync.isSucc();
    }

    public void load(String str, OnLoadListener onLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) onLoadListener);
        } else {
            this.mISoLoadService.load(str, onLoadListener);
        }
    }

    public void loadSequentially(String[] strArr, OnLoadListener onLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            loadSequentially(strArr, onLoadListener, null);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) strArr, (Object) onLoadListener);
        }
    }

    public LoadExtResult loadSequentiallySync(String[] strArr, LoadOptions[] loadOptionsArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (LoadExtResult) iPatchRedirector.redirect((short) 12, (Object) this, (Object) strArr, (Object) loadOptionsArr);
        }
        return this.mISoLoadService.loadSequentiallySync(strArr, loadOptionsArr);
    }

    public LoadExtResult loadSync(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.mISoLoadService.loadSync(str, null) : (LoadExtResult) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
    }

    public void download(String[] strArr, OnLoadListener onLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.mISoLoadService.download(strArr, onLoadListener);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) strArr, (Object) onLoadListener);
        }
    }

    public void loadSequentially(String[] strArr, OnLoadListener onLoadListener, LoadOptions[] loadOptionsArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            this.mISoLoadService.loadSequentially(strArr, onLoadListener, loadOptionsArr);
        } else {
            iPatchRedirector.redirect((short) 11, this, strArr, onLoadListener, loadOptionsArr);
        }
    }

    public LoadExtResult loadSync(String str, LoadOptions loadOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.mISoLoadService.loadSync(str, loadOptions) : (LoadExtResult) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) loadOptions);
    }

    public boolean isExist(String[] strArr) {
        LoadOptions[] loadOptionsArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) strArr)).booleanValue();
        }
        int length = strArr == null ? 0 : strArr.length;
        if (length > 0) {
            loadOptionsArr = new LoadOptions[length];
            for (int i3 = 0; i3 < length; i3++) {
                loadOptionsArr[i3] = new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).setIsNoNeedCRC(true).setCloseRetry(true).setCloseReport(true).build();
            }
        } else {
            loadOptionsArr = null;
        }
        LoadExtResult loadSequentiallySync = loadSequentiallySync(strArr, loadOptionsArr);
        return loadSequentiallySync != null && loadSequentiallySync.isSucc();
    }
}
