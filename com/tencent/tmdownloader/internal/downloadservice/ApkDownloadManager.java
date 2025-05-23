package com.tencent.tmdownloader.internal.downloadservice;

import android.text.TextUtils;
import com.tencent.hlyyb.HalleyAgent;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.common.TMAssistantDownloadContentType;
import com.tencent.tmassistantbase.network.INetworkChangedObserver;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.h;
import com.tencent.tmassistantbase.util.q;
import com.tencent.tmassistantbase.util.r;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ApkDownloadManager implements INetworkChangedObserver {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "ApkDownloadManager";
    protected static ApkDownloadManager mApkDownloadManager;
    final ConcurrentHashMap<String, c> mDownloads;
    protected long mLastAutoDownloadTime;
    protected long mLastAutoPauseTime;
    protected String mLastNetType;
    private boolean mLeaving;
    final ConcurrentHashMap<String, String> mPkgURL;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    ApkDownloadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLastAutoDownloadTime = 0L;
        this.mLastAutoPauseTime = 0L;
        this.mLastNetType = "";
        this.mLeaving = false;
        this.mDownloads = new ConcurrentHashMap<>();
        this.mPkgURL = new ConcurrentHashMap<>();
        this.mLeaving = false;
    }

    public static ApkDownloadManager getInstance() {
        if (mApkDownloadManager == null) {
            mApkDownloadManager = new ApkDownloadManager();
        }
        return mApkDownloadManager;
    }

    public void AddDownloadListener(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) fVar);
        } else {
            Objects.toString(fVar);
            d.a().a(fVar);
        }
    }

    public void RemoveDownloadListener(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) fVar);
        } else {
            Objects.toString(fVar);
            d.a().b(fVar);
        }
    }

    public void cancelDownload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        c remove = this.mDownloads.remove(str);
        if (remove != null) {
            remove.f();
        }
    }

    public void continueDownload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        c cVar = this.mDownloads.get(str);
        if (cVar != null) {
            cVar.e();
        }
    }

    public void deleteDownload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        c remove = this.mDownloads.remove(str);
        if (remove != null) {
            remove.a();
            if (GlobalUtil.getInstance().getAutoDeleteSwitch()) {
                try {
                    String b16 = com.tencent.tmdownloader.f.b.c.b(remove.f380689j);
                    if (!TextUtils.isEmpty(b16)) {
                        File file = new File(b16);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.mLeaving && GlobalUtil.getInstance().getContext() != null) {
            long currentTimeMillis = System.currentTimeMillis();
            HalleyAgent.init(GlobalUtil.getInstance().getContext(), "", "");
            HalleyAgent.getDownloader().setPhoneGuid(GlobalUtil.getInstance().getPhoneGuid());
            HalleyAgent.getDownloader().setTaskNumForCategory(DownloaderTaskCategory.Cate_DefaultMass, 3);
            HalleyAgent.getDownloader().setNotNetworkWaitMillis(5000);
            this.mDownloads.clear();
            ArrayList<c> b16 = com.tencent.tmdownloader.f.b.a.a().b();
            if (b16 != null) {
                b16.size();
                Iterator<c> it = b16.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null) {
                        next.a(TAG);
                        if (!TextUtils.isEmpty(next.f380681b)) {
                            this.mDownloads.put(next.f380681b, next);
                        }
                        if (!next.b()) {
                            next.b(3);
                        }
                        if (!TextUtils.isEmpty(next.f380681b) && !TextUtils.isEmpty(next.f380697r)) {
                            this.mPkgURL.put(next.f380697r, next.f380681b);
                        }
                    }
                }
            }
            NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this);
            this.mLastNetType = b.a();
            q.a("ApkDownloadManager init end, timeCost = " + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        r.a(TAG, "init failed: mLeaving = " + this.mLeaving + ", context = " + GlobalUtil.getInstance().getContext());
    }

    public Boolean isAllDownloadFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Boolean) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        Iterator<String> it = this.mDownloads.keySet().iterator();
        while (it.hasNext()) {
            if (!this.mDownloads.get(it.next()).b()) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override // com.tencent.tmassistantbase.network.INetworkChangedObserver
    public synchronized void onNetworkChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        try {
            h.c();
            if (b.b() && e.a().c()) {
                String a16 = b.a();
                Iterator<String> it = this.mDownloads.keySet().iterator();
                while (it.hasNext()) {
                    c cVar = this.mDownloads.get(it.next());
                    if (cVar != null && !TextUtils.isEmpty(a16)) {
                        int i3 = cVar.f380686g;
                        boolean z16 = cVar.F;
                        if (((i3 == 3 && z16) || i3 == 5) && e.a().a(this.mLastNetType, a16)) {
                            cVar.e();
                        }
                        int i16 = cVar.f380686g;
                        if (i16 == 2 || i16 == 1) {
                            if (e.a().b(this.mLastNetType, a16)) {
                                cVar.d();
                                cVar.F = true;
                            }
                        }
                    }
                }
                this.mLastNetType = a16;
            }
        } catch (Throwable unused) {
        }
    }

    public void pauseDownload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        c cVar = this.mDownloads.get(str);
        if (cVar != null) {
            cVar.d();
        }
    }

    public c queryDownloadInfo(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (c) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        c cVar = this.mDownloads.get(str);
        if (cVar == null) {
            cVar = com.tencent.tmdownloader.f.b.a.a().b(str);
        }
        if (cVar != null) {
            if (cVar.f380680a.equals(TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF)) {
                z16 = b.b(str, cVar.f380680a);
            } else {
                z16 = b.e(cVar.f380689j);
            }
        } else {
            z16 = false;
        }
        if (cVar != null && cVar.c() && !z16) {
            this.mDownloads.remove(str);
            com.tencent.tmdownloader.f.b.a.a().a(str);
            return null;
        }
        return cVar;
    }

    public c queryDownloadInfoByPkgName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (c) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.mPkgURL.get(str);
            if (!TextUtils.isEmpty(str2)) {
                return queryDownloadInfo(str2);
            }
            return null;
        }
        return null;
    }

    public List<c> queryDownloadInfoByVia(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, c>> it = this.mDownloads.entrySet().iterator();
        while (it.hasNext()) {
            c cVar = this.mDownloads.get(it.next().getKey());
            if (cVar != null && !TextUtils.isEmpty(cVar.f380703x) && cVar.f380703x.contains(str)) {
                cVar.a("jimluo");
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public void restartDownload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        c cVar = this.mDownloads.get(str);
        if (cVar != null) {
            cVar.e();
        }
    }

    public int startDownload(String str, int i3, String str2, String str3, Map<String, String> map) {
        boolean e16;
        boolean e17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2, str3, map)).intValue();
        }
        if (!b.b()) {
            return 1;
        }
        if (!b.a().equalsIgnoreCase("wifi") && e.a().b()) {
            return 2;
        }
        if (!b.f(str)) {
            return 3;
        }
        if (b.b(str, str2)) {
            return 4;
        }
        c cVar = this.mDownloads.get(str);
        if (cVar == null) {
            cVar = com.tencent.tmdownloader.f.b.a.a().b(str);
            if (cVar == null) {
                c cVar2 = new c(str, i3, str2);
                if (map != null) {
                    String remove = map.remove(TMAssistantDownloadConst.PARAM_APPID);
                    if (!TextUtils.isEmpty(remove)) {
                        try {
                            cVar2.f380696q = Long.parseLong(remove);
                        } catch (Exception e18) {
                            r.a(TAG, "call startDownload appid parse Exception: ", e18);
                        }
                    }
                    cVar2.f380697r = map.remove(TMAssistantDownloadConst.PARAM_TASK_PACKNAME);
                    cVar2.f380698s = map.remove(TMAssistantDownloadConst.PARAM_TASK_VERSION);
                    cVar2.f380703x = map.remove(TMAssistantDownloadConst.PARAM_VIA);
                    try {
                        cVar2.H = Long.valueOf(map.remove(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE)).longValue();
                    } catch (Exception unused) {
                        r.c(TAG, "fileSize\u672a\u4f20\uff0c\u4e0d\u5f71\u54cd\u4e0b\u8f7d");
                    }
                    String remove2 = map.remove(TMAssistantDownloadConst.PARAM_DOWNLOADTSTYLE);
                    if (!TextUtils.isEmpty(remove2)) {
                        try {
                            cVar2.G = Integer.parseInt(remove2);
                        } catch (Exception e19) {
                            r.a(TAG, "call startDownload downloadStyle parseException: ", e19);
                        }
                    }
                    String remove3 = map.remove(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE);
                    if (!TextUtils.isEmpty(remove3)) {
                        try {
                            cVar2.H = Long.parseLong(remove3);
                        } catch (Exception e26) {
                            r.a(TAG, "call startDownload fileSize parseException: ", e26);
                        }
                    }
                    String remove4 = map.remove(TMAssistantDownloadConst.PARAM_UIN);
                    if (!TextUtils.isEmpty(remove4)) {
                        try {
                            cVar2.f380701v = Long.parseLong(remove4);
                        } catch (Exception e27) {
                            r.a(TAG, "call startDownload uin parseException: ", e27);
                        }
                    }
                    cVar2.f380702w = map.remove(TMAssistantDownloadConst.PARAM_UIN_TYPE);
                    cVar2.f380704y = map.remove(TMAssistantDownloadConst.PARAM_CHANNELID);
                    cVar2.f380705z = UUID.randomUUID().toString();
                    cVar2.A = map.remove(TMAssistantDownloadConst.PARAM_EXTRA_DATA);
                    String remove5 = map.remove(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE);
                    if (!TextUtils.isEmpty(remove5)) {
                        try {
                            cVar2.B = Integer.parseInt(remove5);
                        } catch (Exception e28) {
                            r.a(TAG, "call startDownload downloadType parse Exception: ", e28);
                        }
                    }
                    cVar2.C = map.remove(TMAssistantDownloadConst.PARAM_ICON_URL);
                    cVar2.D = map.remove(TMAssistantDownloadConst.PARAM_APP_NAME);
                    String remove6 = map.remove(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
                    if (!TextUtils.isEmpty(remove6)) {
                        try {
                            cVar2.J = Integer.parseInt(remove6);
                        } catch (Exception e29) {
                            r.a(TAG, "call startDownload showNotification parse Exception: ", e29);
                        }
                    }
                    cVar2.E = Boolean.valueOf(map.remove(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK)).booleanValue();
                }
                if (cVar2.f380680a.equals(TMAssistantDownloadContentType.CONTENT_TYPE_OTHERS)) {
                    cVar2.f380689j = str3;
                }
                cVar = cVar2;
            } else {
                if (cVar.f380680a.equals(TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF)) {
                    e17 = b.b(str, cVar.f380680a);
                } else {
                    e17 = b.e(cVar.f380689j);
                }
                if (e17) {
                    return 4;
                }
            }
            this.mDownloads.put(str, cVar);
            if (!TextUtils.isEmpty(cVar.f380697r)) {
                this.mPkgURL.put(cVar.f380697r, str);
            }
        } else if (b.e(cVar.f380689j)) {
            return 4;
        }
        if (cVar.f380680a.equals(TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF)) {
            e16 = b.b(str, cVar.f380680a);
        } else {
            e16 = b.e(cVar.f380689j);
        }
        if (map != null) {
            cVar.K = map.remove(TMAssistantDownloadConst.PARAM_QQ_SOURCE_ID);
            cVar.L = map.remove(TMAssistantDownloadConst.PARAM_CALL_STACK);
        } else {
            r.a(TAG, "headerParams is null");
        }
        if (cVar.c() && !e16) {
            this.mDownloads.remove(str);
            com.tencent.tmdownloader.f.b.a.a().a(str);
            c cVar3 = new c(str, i3, str2);
            if (map != null) {
                String remove7 = map.remove(TMAssistantDownloadConst.PARAM_APPID);
                if (!TextUtils.isEmpty(remove7)) {
                    try {
                        cVar3.f380696q = Long.parseLong(remove7);
                    } catch (Exception e36) {
                        r.a(TAG, "call startDownload appid parse Exception: ", e36);
                    }
                }
                cVar3.f380697r = map.remove(TMAssistantDownloadConst.PARAM_TASK_PACKNAME);
                cVar3.f380698s = map.remove(TMAssistantDownloadConst.PARAM_TASK_VERSION);
                cVar3.f380703x = map.remove(TMAssistantDownloadConst.PARAM_VIA);
                String remove8 = map.remove(TMAssistantDownloadConst.PARAM_DOWNLOADTSTYLE);
                if (!TextUtils.isEmpty(remove8)) {
                    try {
                        cVar3.G = Integer.parseInt(remove8);
                    } catch (Exception e37) {
                        r.a(TAG, "call startDownload downloadStyle parseException: ", e37);
                    }
                }
                String remove9 = map.remove(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE);
                if (!TextUtils.isEmpty(remove9)) {
                    try {
                        cVar3.H = Long.parseLong(remove9);
                    } catch (Exception e38) {
                        r.a(TAG, "call startDownload fileSize parseException: ", e38);
                    }
                }
                String remove10 = map.remove(TMAssistantDownloadConst.PARAM_UIN);
                if (!TextUtils.isEmpty(remove10)) {
                    try {
                        cVar3.f380701v = Long.parseLong(remove10);
                    } catch (Exception e39) {
                        r.a(TAG, "call startDownload uin parse Exception: ", e39);
                    }
                }
                cVar3.f380702w = map.remove(TMAssistantDownloadConst.PARAM_UIN_TYPE);
                cVar3.f380704y = map.remove(TMAssistantDownloadConst.PARAM_CHANNELID);
                cVar3.f380705z = UUID.randomUUID().toString();
                cVar3.A = map.remove(TMAssistantDownloadConst.PARAM_EXTRA_DATA);
                String remove11 = map.remove(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE);
                if (!TextUtils.isEmpty(remove11)) {
                    try {
                        cVar3.B = Integer.parseInt(remove11);
                    } catch (Exception e46) {
                        r.a(TAG, "call startDownload downloadType parse Exception: ", e46);
                    }
                }
                cVar3.C = map.remove(TMAssistantDownloadConst.PARAM_ICON_URL);
                cVar3.D = map.remove(TMAssistantDownloadConst.PARAM_APP_NAME);
                String remove12 = map.remove(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION);
                if (!TextUtils.isEmpty(remove12)) {
                    try {
                        cVar3.J = Integer.parseInt(remove12);
                    } catch (Exception e47) {
                        r.a(TAG, "call startDownload showNotification parse Exception: ", e47);
                    }
                }
                cVar3.E = Boolean.valueOf(map.remove(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK)).booleanValue();
            }
            if (cVar3.f380680a.equals(TMAssistantDownloadContentType.CONTENT_TYPE_OTHERS)) {
                cVar3.f380689j = str3;
            }
            cVar3.a((HashMap<String, String>) map);
            this.mDownloads.put(str, cVar3);
            if (!TextUtils.isEmpty(cVar3.f380697r)) {
                this.mPkgURL.put(cVar3.f380697r, str);
            }
            cVar = cVar3;
        }
        cVar.a((HashMap<String, String>) map);
        return cVar.e();
    }

    public void uninit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mLeaving = true;
        ArrayList<c> arrayList = new ArrayList<>();
        if (!this.mDownloads.isEmpty()) {
            Iterator<String> it = this.mDownloads.keySet().iterator();
            while (it.hasNext()) {
                c cVar = this.mDownloads.get(it.next());
                if (cVar.f380686g == 2) {
                    pauseDownload(cVar.f380681b);
                }
                arrayList.add(cVar);
            }
        }
        com.tencent.tmdownloader.f.b.a.a().a(arrayList);
    }
}
