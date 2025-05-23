package com.tencent.ams.dsdk.core.mosaic;

import android.text.TextUtils;
import com.tencent.ams.dsdk.cache.SoConfigCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.data.SoConfig;
import com.tencent.ams.dsdk.data.SoInfo;
import com.tencent.ams.dsdk.data.SoPlatform;
import com.tencent.ams.dsdk.fodder.SoConfigManager;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.mosaic.load.b;
import com.tencent.ams.mosaic.load.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKMosaicSoDownloadListener implements b.a {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKMosaicSoDownloadListener";

    public DKMosaicSoDownloadListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private SoConfig createSoConfig(com.tencent.ams.mosaic.load.d dVar) {
        boolean z16;
        String version = getVersion(dVar);
        SoConfig soConfig = new SoConfig();
        soConfig.version = version;
        if (dVar == null) {
            z16 = false;
        } else {
            z16 = dVar.f71513b;
        }
        soConfig.isForceUpdate = z16;
        soConfig.engineType = 1;
        List<d.c> d16 = dVar.d(DKEngine.getApplicationContext());
        if (d16 != null && !d16.isEmpty()) {
            for (d.c cVar : d16) {
                if (cVar != null && !TextUtils.isEmpty(cVar.f71521d) && !TextUtils.isEmpty(cVar.f71520c)) {
                    insertSoInfoIfNeed(queryOrCreateSoPlatform(queryOrCreateSoPlatformList(soConfig), cVar.f71521d), cVar);
                }
            }
        }
        return soConfig;
    }

    private String getVersion(com.tencent.ams.mosaic.load.d dVar) {
        if (dVar == null) {
            return null;
        }
        return dVar.f71512a;
    }

    private boolean insertSoInfoIfNeed(SoPlatform soPlatform, d.c cVar) {
        SoInfo soInfo;
        if (soPlatform != null && cVar != null) {
            List<SoInfo> list = soPlatform.soList;
            Iterator<SoInfo> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    soInfo = it.next();
                    if (soInfo != null && !TextUtils.isEmpty(soInfo.name) && soInfo.name.equals(cVar.f71520c)) {
                        break;
                    }
                } else {
                    soInfo = null;
                    break;
                }
            }
            if (soInfo == null) {
                list.add(toSoInfo(cVar));
                return true;
            }
        }
        return false;
    }

    private SoPlatform queryOrCreateSoPlatform(List<SoPlatform> list, String str) {
        SoPlatform soPlatform = null;
        if (list == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<SoPlatform> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SoPlatform next = it.next();
            if (next != null && !TextUtils.isEmpty(next.abi) && next.abi.equals(str)) {
                soPlatform = next;
                break;
            }
        }
        if (soPlatform == null) {
            SoPlatform soPlatform2 = new SoPlatform(str, new ArrayList());
            list.add(soPlatform2);
            return soPlatform2;
        }
        return soPlatform;
    }

    private List<SoPlatform> queryOrCreateSoPlatformList(SoConfig soConfig) {
        if (soConfig == null) {
            return null;
        }
        List<SoPlatform> list = soConfig.platforms;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            soConfig.platforms = arrayList;
            return arrayList;
        }
        return list;
    }

    private SoInfo toSoInfo(d.c cVar) {
        if (cVar == null) {
            return null;
        }
        return new SoInfo(cVar.f71520c, cVar.f71518a, cVar.f71519b, cVar.f71523f);
    }

    @Override // com.tencent.ams.mosaic.load.b.a
    public void onComplete(com.tencent.ams.mosaic.load.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
            return;
        }
        DLog.i(TAG, "onComplete, config: " + dVar);
        SoConfigCache.getInstance().updateSoConfig(createSoConfig(dVar));
    }

    @Override // com.tencent.ams.mosaic.load.b.a
    public void onDownloadFailure(com.tencent.ams.mosaic.load.d dVar, d.c cVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, dVar, cVar, Integer.valueOf(i3));
            return;
        }
        DLog.i(TAG, "onDownloadFailure, config: " + dVar + ", item: " + cVar + ", errorCode: " + i3);
        SoConfigManager.OnSoDownloadListener onSoDownloadListener = DKConfiguration.getOnSoDownloadListener();
        if (onSoDownloadListener != null) {
            onSoDownloadListener.onDownloadFailure(1, getVersion(dVar), cVar.f71521d, toSoInfo(cVar), i3);
        }
    }

    @Override // com.tencent.ams.mosaic.load.b.a
    public void onDownloadStart(com.tencent.ams.mosaic.load.d dVar, d.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar, (Object) cVar);
            return;
        }
        DLog.i(TAG, "onDownloadStart, config: " + dVar + ", item: " + cVar);
        SoConfigManager.OnSoDownloadListener onSoDownloadListener = DKConfiguration.getOnSoDownloadListener();
        if (onSoDownloadListener != null) {
            onSoDownloadListener.onDownloadStart(1, getVersion(dVar), cVar.f71521d, toSoInfo(cVar));
        }
    }

    @Override // com.tencent.ams.mosaic.load.b.a
    public void onDownloadSuccess(com.tencent.ams.mosaic.load.d dVar, d.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar, (Object) cVar);
            return;
        }
        DLog.i(TAG, "onDownloadSuccess, config: " + dVar + ", item: " + cVar);
        SoConfigManager.OnSoDownloadListener onSoDownloadListener = DKConfiguration.getOnSoDownloadListener();
        String version = getVersion(dVar);
        if (onSoDownloadListener != null) {
            onSoDownloadListener.onDownloadSuccess(1, version, cVar.f71521d, toSoInfo(cVar));
        }
    }

    @Override // com.tencent.ams.mosaic.load.b.a
    public void onFailure(com.tencent.ams.mosaic.load.d dVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar, i3);
            return;
        }
        DLog.i(TAG, "onFailure, config: " + dVar + ", errorCode: " + i3);
    }

    @Override // com.tencent.ams.mosaic.load.b.a
    public void onStart(com.tencent.ams.mosaic.load.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            return;
        }
        DLog.i(TAG, "onStart, config: " + dVar);
    }
}
