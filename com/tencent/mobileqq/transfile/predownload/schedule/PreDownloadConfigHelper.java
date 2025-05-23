package com.tencent.mobileqq.transfile.predownload.schedule;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.transfile.predownload.QQPreDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes19.dex */
public class PreDownloadConfigHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PreDownloadConfigHelper";

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/QQCommon/Inject_PredownloadConfig.yml", version = 1)
    private static ArrayList<Class<? extends AbsPreDownloadConfig>> mConfigClassList;
    private final Map<Integer, String> mBusinessName;
    private final Map<Integer, String> mBusinessNameEng;
    private final Map<Integer, Integer> mBusinessPriority;
    private final ArrayList<AbsPreDownloadConfig> mConfigList;
    private final List<Integer> mPreDownloadWhiteList;
    private int mVersion;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        ArrayList<Class<? extends AbsPreDownloadConfig>> arrayList = new ArrayList<>();
        mConfigClassList = arrayList;
        arrayList.add(QQPreDownloadConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreDownloadConfigHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mConfigList = new ArrayList<>();
        this.mBusinessName = new HashMap();
        this.mBusinessNameEng = new HashMap();
        this.mBusinessPriority = new HashMap();
        this.mPreDownloadWhiteList = new ArrayList();
        this.mVersion = 0;
        initConfigList();
        initVersion();
        initWhiteList();
        initBusinessInfo();
    }

    private void initBusinessInfo() {
        Iterator<AbsPreDownloadConfig> it = this.mConfigList.iterator();
        while (it.hasNext()) {
            AbsPreDownloadConfig next = it.next();
            this.mBusinessName.putAll(next.getBusinessName());
            this.mBusinessNameEng.putAll(next.getBusinessEnglishName());
            this.mBusinessPriority.putAll(next.getBusinessPriority());
        }
    }

    private void initConfigList() {
        if (mConfigClassList.size() > 0) {
            if (QLog.isColorLevel()) {
                for (int i3 = 0; i3 < mConfigClassList.size(); i3++) {
                    QLog.i(TAG, 2, mConfigClassList.get(i3).toString());
                }
            }
        } else {
            QLog.e(TAG, 1, "mConfigClassList inject failed !");
        }
        Iterator<Class<? extends AbsPreDownloadConfig>> it = mConfigClassList.iterator();
        while (it.hasNext()) {
            try {
                this.mConfigList.add(it.next().newInstance());
            } catch (IllegalAccessException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "initConfigList, IllegalAccessException ", e16);
                }
                e16.printStackTrace();
            } catch (InstantiationException e17) {
                e17.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "initConfigList, InstantiationException ", e17);
                }
            }
        }
    }

    private void initVersion() {
        int i3 = this.mVersion;
        Iterator<AbsPreDownloadConfig> it = this.mConfigList.iterator();
        while (it.hasNext()) {
            AbsPreDownloadConfig next = it.next();
            if (next.getVersion() > i3) {
                i3 = next.getVersion();
            }
        }
        this.mVersion = i3;
    }

    private void initWhiteList() {
        Iterator<AbsPreDownloadConfig> it = this.mConfigList.iterator();
        while (it.hasNext()) {
            this.mPreDownloadWhiteList.addAll(it.next().getWhiteList());
        }
    }

    public List<String> cleanOnVersionUpdate(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        ArrayList arrayList = new ArrayList(5);
        Iterator<AbsPreDownloadConfig> it = this.mConfigList.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().cleanResOnVersionUpdate(i3, i16));
        }
        return arrayList;
    }

    public Map<Integer, String> getBusinessName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mBusinessName;
    }

    public Map<Integer, String> getBusinessNameEng() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mBusinessNameEng;
    }

    public Map<Integer, Integer> getBusinessPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mBusinessPriority;
    }

    public List<Integer> getPreDownloadWhiteList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mPreDownloadWhiteList;
    }

    public int getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mVersion;
    }
}
