package com.tencent.mobileqq.soload.biz.entity;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.util.e;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes18.dex */
public class LoadParam implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static int CALL_TYPE_ASYNC = 0;
    public static int CALL_TYPE_ASYNC_BY_SYNC = 0;
    public static int CALL_TYPE_SYNC = 0;
    private static final long OVER_TIME_DEFAULT = 180000;
    public int commonFlag;
    public int mCallType;
    public ClassLoader mClassLoader;
    public List<LoadItem> mLoadItems;
    public volatile long mLoadTime;
    public long mReportSeq;

    /* loaded from: classes18.dex */
    public static class LoadItem implements Serializable {
        static IPatchRedirector $redirector_;
        public LoadOptions lops;
        public String name;
        public String soFileName;

        public LoadItem(String str) {
            this(str, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }

        public boolean isSame(LoadItem loadItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) loadItem)).booleanValue();
            }
            if (loadItem == null || !e.f(loadItem.name, this.name)) {
                return false;
            }
            return this.lops.isSame(loadItem.lops);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "LoadItem{name='" + this.name + "', lops=" + this.lops + '}';
        }

        public LoadItem(String str, LoadOptions loadOptions) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) loadOptions);
                return;
            }
            this.name = str;
            this.soFileName = e.b(str);
            if (loadOptions != null) {
                this.lops = loadOptions;
            } else {
                this.lops = new LoadOptions.LoadOptionsBuilder().build();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33729);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        CALL_TYPE_ASYNC = 0;
        CALL_TYPE_SYNC = 1;
        CALL_TYPE_ASYNC_BY_SYNC = 2;
    }

    public LoadParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mReportSeq = 0L;
        this.mCallType = CALL_TYPE_ASYNC;
        this.mLoadItems = new LinkedList();
        this.commonFlag = 0;
    }

    public static int getItemSize(LoadParam loadParam) {
        List<LoadItem> list;
        if (loadParam != null && (list = loadParam.mLoadItems) != null) {
            return list.size();
        }
        return 0;
    }

    public static String getReportStr(LoadParam loadParam) {
        List<LoadItem> list;
        if (loadParam != null && (list = loadParam.mLoadItems) != null && list.size() > 0) {
            StringBuilder sb5 = new StringBuilder("names=");
            boolean z16 = true;
            for (LoadItem loadItem : loadParam.mLoadItems) {
                if (z16) {
                    z16 = false;
                } else {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb5.append(loadItem.name);
            }
            return sb5.toString();
        }
        return null;
    }

    public static boolean isCloseReport(LoadParam loadParam) {
        if (loadParam == null || (loadParam.commonFlag & 32) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isCloseRetry(LoadParam loadParam) {
        if (loadParam == null || (loadParam.commonFlag & 16) == 0) {
            return false;
        }
        return true;
    }

    public static boolean isValid(LoadParam loadParam) {
        return loadParam != null && loadParam.isValid();
    }

    public void addItem(String str, LoadOptions loadOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) loadOptions);
            return;
        }
        LoadItem loadItem = new LoadItem(str, loadOptions);
        this.mLoadItems.add(loadItem);
        this.commonFlag |= loadItem.lops.flag & 48;
    }

    public boolean isOverTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.mLoadTime) > 180000) {
            return true;
        }
        return false;
    }

    public boolean isSame(LoadParam loadParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) loadParam)).booleanValue();
        }
        if (loadParam == null || this.mCallType != loadParam.mCallType || loadParam.mLoadItems.size() != this.mLoadItems.size()) {
            return false;
        }
        for (int i3 = 0; i3 < loadParam.mLoadItems.size(); i3++) {
            if (!this.mLoadItems.get(i3).isSame(loadParam.mLoadItems.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "LoadParam{mCallType=" + this.mCallType + "mLoadItems=" + this.mLoadItems + '}';
    }

    boolean isValid() {
        List<LoadItem> list = this.mLoadItems;
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (LoadItem loadItem : this.mLoadItems) {
            if (loadItem == null || TextUtils.isEmpty(loadItem.name) || loadItem.lops == null) {
                return false;
            }
        }
        return true;
    }
}
