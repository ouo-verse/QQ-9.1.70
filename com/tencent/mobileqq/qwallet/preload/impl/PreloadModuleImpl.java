package com.tencent.mobileqq.qwallet.preload.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.impl.d;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.vip.f;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class PreloadModuleImpl implements Serializable, kl2.a {
    public static final int DEFAULT_VALUE_RETRY_COUNT = 5;
    public static final int DEFAULT_VALUE_RETRY_TIME_INTERVAL = 24;
    private static final long serialVersionUID = 1;
    public boolean isForbidAutoDownload;
    public boolean mBackControl;
    public String mBaseUrl;
    private CopyOnWriteArrayList<PreloadResourceImpl> mPreloadResourceImpls;
    public int mRetryCount;
    public int mRetryTimeInterval;
    public String mid;
    public String name;
    public int option;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements d4.a {
        a() {
        }

        @Override // d4.a
        public void loaded(String str, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("PreloadModule", 2, "checkUpByBusinessId progress:" + str);
            }
        }

        @Override // d4.a
        public void progress(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("PreloadModule", 2, "checkUpByBusinessId loaded, code:" + i3);
            }
        }
    }

    public PreloadModuleImpl() {
        this.mRetryTimeInterval = 24;
        this.mRetryCount = 5;
        this.mPreloadResourceImpls = new CopyOnWriteArrayList<>();
    }

    private void a(String str, AppRuntime appRuntime) {
        String str2;
        try {
            Uri parse = Uri.parse(str);
            if (parse != null && parse.isHierarchical()) {
                str2 = parse.getQueryParameter("_bid");
            } else {
                str2 = null;
            }
            if (!b(str2)) {
                return;
            }
            ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).checkUpByBusinessId(str2, appRuntime, true, new a());
        } catch (Exception e16) {
            QLog.e("PreloadModule", 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    public static PreloadModuleImpl parsePreloadModule(JSONObject jSONObject, boolean z16, int i3) {
        boolean z17;
        boolean z18;
        PreloadModuleImpl preloadModuleImpl = new PreloadModuleImpl();
        try {
            if (jSONObject.optInt("back_control") == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            preloadModuleImpl.mBackControl = z17;
            if (z16) {
                preloadModuleImpl.mBackControl = false;
            }
            if (i3 == 2) {
                preloadModuleImpl.name = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getRedPacket2024PreloadModuleName();
            } else if (i3 == 5) {
                preloadModuleImpl.name = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getRedPacket2025PreloadModuleName();
            } else if (i3 == 3) {
                preloadModuleImpl.name = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getCJ2021AvGamePreloadModuleName();
            } else {
                preloadModuleImpl.name = jSONObject.optString("module_name");
            }
            String optString = jSONObject.optString("module_id");
            if (TextUtils.isEmpty(optString)) {
                preloadModuleImpl.mid = preloadModuleImpl.name;
            } else {
                preloadModuleImpl.mid = optString;
            }
            preloadModuleImpl.option = jSONObject.optInt("option");
            if (jSONObject.optInt("forbid_download") == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            preloadModuleImpl.isForbidAutoDownload = z18;
            preloadModuleImpl.mBaseUrl = jSONObject.optString("url_base");
            preloadModuleImpl.mRetryTimeInterval = jSONObject.optInt("retry_t_interval", 24);
            int optInt = jSONObject.optInt("retry_cnt", 5);
            preloadModuleImpl.mRetryCount = optInt;
            preloadModuleImpl.mRetryCount = Math.max(optInt, 5);
            JSONArray optJSONArray = jSONObject.optJSONArray(DKConfiguration.Directory.RESOURCES);
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                preloadModuleImpl.mPreloadResourceImpls.add(PreloadResourceImpl.parsePreloadResource(optJSONArray.getJSONObject(i16), preloadModuleImpl, z16, i3));
            }
        } catch (Exception e16) {
            QLog.e("PreloadModule", 1, "error msg in qqpay-impl module: ", e16);
        }
        return preloadModuleImpl;
    }

    public void check() {
        if (TextUtils.isEmpty(this.mid)) {
            this.mid = this.name;
        }
        int i3 = this.mRetryTimeInterval;
        if (i3 <= 0) {
            i3 = 24;
        }
        this.mRetryTimeInterval = i3;
        int i16 = this.mRetryCount;
        if (i16 <= 0) {
            i16 = 5;
        }
        this.mRetryCount = i16;
    }

    @Override // kl2.a
    public void deleteResFromLocal() {
        try {
            Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
            while (it.hasNext()) {
                PreloadResourceImpl next = it.next();
                next.deleteResFile(this, 2);
                this.mPreloadResourceImpls.remove(next);
            }
        } catch (Exception e16) {
            QLog.e("PreloadModule", 1, "deleteResFromLocal error:" + e16);
        }
    }

    public void deleteResFromServer(int i3) {
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            PreloadResourceImpl next = it.next();
            if (next.mIsFromLocal || next.mFromType == i3) {
                this.mPreloadResourceImpls.remove(next);
            }
        }
    }

    public void downloadModule(boolean z16, f fVar, PreloadServiceImpl preloadServiceImpl, boolean z17) {
        if (this.name.equals("wallet_offline")) {
            handleHtmlOffline(MobileQQ.sMobileQQ.peekAppRuntime());
            return;
        }
        if (!z16 && this.isForbidAutoDownload) {
            return;
        }
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            PreloadResourceImpl next = it.next();
            if (!next.isInValidTime()) {
                next.deleteResFile(this, 6);
                this.mPreloadResourceImpls.remove(next);
            } else if (next.isAbiMatch() && next.isTimeToDownload(preloadServiceImpl)) {
                next.startDownload(preloadServiceImpl, this, fVar, z17);
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PreloadModuleImpl)) {
            PreloadModuleImpl preloadModuleImpl = (PreloadModuleImpl) obj;
            String str = this.mid;
            if (str != null && str.equals(preloadModuleImpl.mid)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void filterInvalidRes(PreloadServiceImpl preloadServiceImpl) {
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            PreloadResourceImpl next = it.next();
            if (!next.isInValidTime()) {
                next.deleteResFile(this, 6);
                this.mPreloadResourceImpls.remove(next);
            } else if (next.handleAbnormalRetry(this)) {
                this.mPreloadResourceImpls.remove(next);
                next.deleteResFile(this, 9);
            }
        }
    }

    @Override // kl2.a
    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    public int getModuleResSize() {
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().size;
        }
        return i3;
    }

    @Override // kl2.a
    public String getName() {
        return this.name;
    }

    @Override // kl2.a
    public List<IPreloadResource> getResApiList() {
        ArrayList arrayList = new ArrayList();
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public List<PreloadResourceImpl> getResList() {
        ArrayList arrayList = new ArrayList();
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public int getResNum() {
        return this.mPreloadResourceImpls.size();
    }

    public PreloadResourceImpl getResourceByResId(String str) {
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            PreloadResourceImpl next = it.next();
            if (d.r(next.mResId, str)) {
                return next;
            }
        }
        return null;
    }

    public PreloadResourceImpl getResourceByType(int i3) {
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            PreloadResourceImpl next = it.next();
            if (next.type == i3) {
                return next;
            }
        }
        return null;
    }

    public void handleHtmlOffline(AppRuntime appRuntime) {
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            a(it.next().url, appRuntime);
        }
    }

    public boolean isModuleChange(PreloadModuleImpl preloadModuleImpl) {
        if (!d.r(this.mid, preloadModuleImpl.mid) || this.mBackControl != preloadModuleImpl.mBackControl || !d.r(this.name, preloadModuleImpl.name) || this.option != preloadModuleImpl.option || this.isForbidAutoDownload != preloadModuleImpl.isForbidAutoDownload || this.mRetryTimeInterval != preloadModuleImpl.mRetryTimeInterval || this.mRetryCount != preloadModuleImpl.mRetryCount || !d.r(this.mBaseUrl, preloadModuleImpl.mBaseUrl)) {
            return true;
        }
        List<PreloadResourceImpl> resList = getResList();
        if (resList.size() != preloadModuleImpl.mPreloadResourceImpls.size()) {
            return true;
        }
        for (int i3 = 0; i3 < resList.size(); i3++) {
            if (resList.get(i3).isResChange(preloadModuleImpl.mPreloadResourceImpls.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public boolean isModuleFinish(PreloadServiceImpl preloadServiceImpl) {
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            if (!it.next().isResFileExist(this)) {
                return false;
            }
        }
        return true;
    }

    public void removeResource(PreloadResourceImpl preloadResourceImpl) {
        if (preloadResourceImpl == null) {
            return;
        }
        this.mPreloadResourceImpls.remove(preloadResourceImpl);
    }

    @Override // kl2.a
    public boolean resDownloaded() {
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            if (!it.next().isResFileExist(this)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "Module [mid=" + this.mid + ", mBC=" + this.mBackControl + ", mRes=" + this.mPreloadResourceImpls + "]";
    }

    public void updateNewModuleWhenReplace(PreloadModuleImpl preloadModuleImpl, PreloadServiceImpl preloadServiceImpl, int i3) {
        Iterator<PreloadResourceImpl> it = this.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            PreloadResourceImpl next = it.next();
            PreloadResourceImpl resourceByResId = preloadModuleImpl.getResourceByResId(next.mResId);
            if (resourceByResId == null) {
                if (!next.mIsFromLocal && i3 != next.mFromType) {
                    preloadModuleImpl.mPreloadResourceImpls.add(next);
                }
            } else if (next.isNeedDeleteOldFileWhenUpdate(this, resourceByResId, preloadServiceImpl)) {
                next.deleteResFile(this, 3);
            }
        }
    }

    public void updatePreloadModule(PreloadModuleImpl preloadModuleImpl, PreloadServiceImpl preloadServiceImpl) {
        this.mid = preloadModuleImpl.mid;
        this.mBackControl = preloadModuleImpl.mBackControl;
        this.name = preloadModuleImpl.name;
        this.option = preloadModuleImpl.option;
        this.isForbidAutoDownload = preloadModuleImpl.isForbidAutoDownload;
        this.mBaseUrl = preloadModuleImpl.mBaseUrl;
        this.mRetryTimeInterval = preloadModuleImpl.mRetryTimeInterval;
        this.mRetryCount = preloadModuleImpl.mRetryCount;
        Iterator<PreloadResourceImpl> it = preloadModuleImpl.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            PreloadResourceImpl next = it.next();
            PreloadResourceImpl resourceByResId = getResourceByResId(next.mResId);
            if (resourceByResId == null) {
                this.mPreloadResourceImpls.add(next);
            } else {
                if (resourceByResId.isNeedDeleteOldFileWhenUpdate(this, next, preloadServiceImpl)) {
                    resourceByResId.deleteResFile(this, 4);
                    resourceByResId.mHasUnzip = false;
                }
                resourceByResId.mDownloadTime = next.mDownloadTime;
                resourceByResId.mInvalidTime = next.mInvalidTime;
                resourceByResId.md5 = next.md5;
                resourceByResId.type = next.type;
                resourceByResId.size = next.size;
                resourceByResId.urlPath = next.urlPath;
                resourceByResId.url = next.url;
                resourceByResId.mResId = next.mResId;
                resourceByResId.mFlowControl = next.mFlowControl;
                resourceByResId.mIsFromLocal = next.mIsFromLocal;
                resourceByResId.mIsTemp = next.mIsTemp;
                resourceByResId.mIsNeedUnzip = next.mIsNeedUnzip;
                resourceByResId.mIsUnzipInside = next.mIsUnzipInside;
                resourceByResId.mUnzipPrefix = next.mUnzipPrefix;
                resourceByResId.mFromType = next.mFromType;
                resourceByResId.mFilePos = next.mFilePos;
                resourceByResId.mAbi = next.mAbi;
            }
        }
    }

    public PreloadModuleImpl(PreloadModuleImpl preloadModuleImpl) {
        this();
        this.mid = preloadModuleImpl.mid;
        this.mBackControl = preloadModuleImpl.mBackControl;
        this.name = preloadModuleImpl.name;
        this.option = preloadModuleImpl.option;
        this.isForbidAutoDownload = preloadModuleImpl.isForbidAutoDownload;
        this.mBaseUrl = preloadModuleImpl.mBaseUrl;
        Iterator<PreloadResourceImpl> it = preloadModuleImpl.mPreloadResourceImpls.iterator();
        while (it.hasNext()) {
            this.mPreloadResourceImpls.add(new PreloadResourceImpl(it.next()));
        }
        this.mRetryTimeInterval = preloadModuleImpl.mRetryTimeInterval;
        this.mRetryCount = preloadModuleImpl.mRetryCount;
    }
}
