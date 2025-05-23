package com.tencent.mobileqq.vas.quickupdate;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public abstract class BaseUpdateCallback implements QuickUpdateBusinessCallback, QuickUpdateListener {
    private static final int ERROR_NULL_APP = 10087;
    private static final int ERROR_WRONG_APP = 10088;
    private static final int ERROR_X86 = 10086;
    private static final String TAG = "BaseUpdateCallback";
    private static boolean isMainProcess;
    private static ListenerMap<QuickUpdateListener> listeners = new ListenerMap<>();
    private static ListenerMap<WeakReference<QuickUpdateListener>> weakListeners = new ListenerMap<>();

    static {
        boolean z16;
        String str = MobileQQ.processName;
        if (str != null && str.equals(BaseApplication.getContext().getPackageName())) {
            z16 = true;
        } else {
            z16 = false;
        }
        isMainProcess = z16;
    }

    private static String getKey(long j3, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return j3 + "_" + str;
        }
        return j3 + "_" + str2;
    }

    private boolean isDefaultSc(String str) {
        String scidPrefix = getScidPrefix();
        if (!TextUtils.isEmpty(scidPrefix) && str.startsWith(scidPrefix)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public boolean canUpdate(long j3, String str, String str2) {
        return true;
    }

    public void cleanCache(Context context) {
        if (!TextUtils.isEmpty(getRootDir())) {
            VasUpdateUtil.safeDeleteFile(new File(context.getFilesDir() + File.separator + getRootDir()));
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public boolean deleteFiles(long j3, String str) {
        if (isDefaultSc(str)) {
            return VasUpdateUtil.safeDeleteFile(new File(getDir(BaseApplication.getContext(), str)));
        }
        return false;
    }

    public void doOnCompleted(long j3, String str, String str2, String str3, int i3, int i16) {
        if (isZip_KeepZip() && i3 == 0 && isDefaultSc(str)) {
            String dir = getDir(BaseApplication.getContext(), str);
            String savePath = getSavePath(BaseApplication.getContext(), str);
            try {
                String str4 = "uncompress_" + j3 + str;
                VasMMKVProxy quickUpdateSystem = VasMMKV.getQuickUpdateSystem();
                if (quickUpdateSystem.containsKey(str4)) {
                    FileUtils.deleteDirectory(dir);
                } else {
                    quickUpdateSystem.encodeBool(str4, true);
                }
                FileUtils.uncompressZip(savePath, dir, false);
                quickUpdateSystem.removeKey(str4);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "_onCompleted: ", e16);
                FileUtils.deleteDirectory(dir);
            }
        }
    }

    public void download(int i3, QuickUpdateListener quickUpdateListener, boolean z16) {
        download(getScid(i3), quickUpdateListener, z16);
    }

    public abstract long getBID();

    public String getDir(Context context, String str) {
        return new File(context.getFilesDir() + File.separator + getRootDir(), str).getAbsolutePath();
    }

    public int getId(String str) {
        try {
            return Integer.parseInt(str.substring(getScidPrefix().length()));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getId error scid: " + str, e16);
            return 0;
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public TagItemInfo getItemInfo(long j3, String str) {
        if (isDefaultSc(str)) {
            TagItemInfo tagItemInfo = new TagItemInfo();
            tagItemInfo.bPreConfig = false;
            tagItemInfo.bSaveInDir = false;
            tagItemInfo.strSavePath = getSavePath(BaseApplication.getContext(), str);
            return tagItemInfo;
        }
        return null;
    }

    protected String getRootDir() {
        return "";
    }

    public String getSavePath(Context context, String str) {
        String dir = getDir(context, str);
        if (isZip_KeepZip()) {
            return dir + File.separator + str + ".zip";
        }
        return dir;
    }

    public String getScid(int i3) {
        return getScidPrefix() + i3;
    }

    protected String getScidPrefix() {
        return "";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public boolean isFileExists(long j3, String str) {
        if (isDefaultSc(str)) {
            return new File(getSavePath(BaseApplication.getContext(), str)).exists();
        }
        return false;
    }

    protected boolean isZip_KeepZip() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener
    public final void onCompleted(long j3, String str, String str2, String str3, int i3, int i16) {
        boolean z16;
        List<QuickUpdateListener> list;
        List<WeakReference<QuickUpdateListener>> list2;
        doOnCompleted(j3, str, str2, str3, i3, i16);
        TagItemInfo itemInfo = getItemInfo(j3, str);
        boolean z17 = true;
        if (itemInfo == null) {
            QLog.e(TAG, 1, "onComplete getItemInfo failed: " + j3 + "_" + str);
        }
        if (itemInfo == null) {
            z16 = false;
        } else {
            z16 = itemInfo.bPreConfig;
        }
        if (z16 && i3 == 0) {
            z17 = false;
        }
        String key = getKey(j3, str, str2);
        ListenerMap<QuickUpdateListener> listenerMap = listeners;
        if (z17) {
            list = listenerMap.remove(key);
        } else {
            list = listenerMap.get(key);
        }
        Iterator<QuickUpdateListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onCompleted(j3, str, str2, str3, i3, i16);
        }
        if (z17) {
            list2 = weakListeners.remove(key);
        } else {
            list2 = weakListeners.get(key);
        }
        Iterator<WeakReference<QuickUpdateListener>> it5 = list2.iterator();
        while (it5.hasNext()) {
            QuickUpdateListener quickUpdateListener = it5.next().get();
            if (quickUpdateListener != null) {
                quickUpdateListener.onCompleted(j3, str, str2, str3, i3, i16);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener
    public final void onProgress(long j3, String str, String str2, long j16, long j17) {
        boolean z16;
        TagItemInfo itemInfo = getItemInfo(j3, str);
        if (itemInfo == null) {
            QLog.e(TAG, 1, "onProgress getItemInfo failed: " + j3 + "_" + str);
        }
        if (itemInfo == null) {
            z16 = false;
        } else {
            z16 = itemInfo.bPreConfig;
        }
        String key = getKey(j3, str, str2);
        if (!z16) {
            doOnProgress(j3, str, str2, j16, j17);
            Iterator<QuickUpdateListener> it = listeners.get(key).iterator();
            while (it.hasNext()) {
                it.next().onProgress(j3, str, str2, j16, j17);
            }
            Iterator<WeakReference<QuickUpdateListener>> it5 = weakListeners.get(key).iterator();
            while (it5.hasNext()) {
                QuickUpdateListener quickUpdateListener = it5.next().get();
                if (quickUpdateListener != null) {
                    quickUpdateListener.onProgress(j3, str, str2, j16, j17);
                }
            }
        }
    }

    public void removeListener(long j3, String str, QuickUpdateListener quickUpdateListener) {
        String key = getKey(j3, str, "");
        listeners.removeListener(key, quickUpdateListener, false);
        weakListeners.removeListener(key, quickUpdateListener, true);
    }

    public void download(String str) {
        download(str, (QuickUpdateListener) null, false);
    }

    public void download(String str, QuickUpdateListener quickUpdateListener, boolean z16) {
        download(getBID(), str, quickUpdateListener, z16);
    }

    public void download(long j3, String str, QuickUpdateListener quickUpdateListener, boolean z16) {
        if (quickUpdateListener != null) {
            String key = getKey(j3, str, "");
            if (z16) {
                weakListeners.add(key, new WeakReference<>(quickUpdateListener));
            } else {
                listeners.add(key, quickUpdateListener);
            }
        }
        if (isMainProcess) {
            QLog.e(TAG, 1, "derect download: " + j3 + "_" + str + ", " + quickUpdateListener);
            ((IVasQuickUpdateService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IVasQuickUpdateService.class, "")).downloadItem(j3, str, TAG);
            return;
        }
        QLog.e(TAG, 1, "ipc[" + MobileQQ.processName + "] download: " + j3 + "_" + str + ", " + quickUpdateListener);
        VasUtil.getService(MobileQQ.sMobileQQ.peekAppRuntime()).getVasUpdateManager().startRemoteDownload(j3, str, TAG);
    }

    public void doOnProgress(long j3, String str, String str2, long j16, long j17) {
    }
}
