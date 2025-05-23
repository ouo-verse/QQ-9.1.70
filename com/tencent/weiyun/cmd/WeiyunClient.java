package com.tencent.weiyun.cmd;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.callback.CheckShareFileCallback;
import com.tencent.weiyun.callback.DeleteDirFileCallback;
import com.tencent.weiyun.callback.FetchFileListCallback;
import com.tencent.weiyun.callback.FetchPOICallback;
import com.tencent.weiyun.callback.FetchPicVideoInfoCallback;
import com.tencent.weiyun.callback.FetchUserInfoCallback;
import com.tencent.weiyun.callback.ModifyFileCallback;
import com.tencent.weiyun.callback.WeiyunCallbackCenter;
import com.tencent.weiyun.data.DirItem;
import com.tencent.weiyun.data.FileItem;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.WyLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
final class WeiyunClient extends WeiyunNative {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "WeiyunClient";
    private static WeiyunClient sInstance;
    private final WeiyunCallbackCenter mCallbackCenter;
    private boolean mIsInit;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10479);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            sInstance = null;
        }
    }

    WeiyunClient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCallbackCenter = new WeiyunCallbackCenter();
            this.mIsInit = false;
        }
    }

    private boolean ensureInit() {
        if (!this.mIsInit) {
            WyLog.e(TAG, "WeiyunSdk hasn't be init.");
        }
        return this.mIsInit;
    }

    public static WeiyunClient getInstance() {
        if (sInstance == null) {
            synchronized (WeiyunClient.class) {
                if (sInstance == null) {
                    sInstance = new WeiyunClient();
                }
            }
        }
        return sInstance;
    }

    public static boolean isLoaded() {
        return WeiyunNative.sIsLoaded;
    }

    public boolean checkShareFile(List<DirItem> list, List<FileItem> list2, List<String> list3, CheckShareFileCallback checkShareFileCallback) {
        DirItem[] dirItemArr;
        FileItem[] fileItemArr;
        String[] strArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, list, list2, list3, checkShareFileCallback)).booleanValue();
        }
        boolean ensureInit = ensureInit();
        if (ensureInit) {
            if (list == null) {
                dirItemArr = new DirItem[0];
            } else {
                dirItemArr = (DirItem[]) list.toArray(new DirItem[list.size()]);
            }
            DirItem[] dirItemArr2 = dirItemArr;
            if (list2 == null) {
                fileItemArr = new FileItem[0];
            } else {
                fileItemArr = (FileItem[]) list2.toArray(new FileItem[list2.size()]);
            }
            FileItem[] fileItemArr2 = fileItemArr;
            if (list3 == null) {
                strArr = new String[0];
            } else {
                strArr = (String[]) list3.toArray(new String[list3.size()]);
            }
            nativeCheckShareFile(dirItemArr2, fileItemArr2, strArr, this.mCallbackCenter.addCallback(checkShareFileCallback));
        }
        return ensureInit;
    }

    public boolean deleteDirFile(List<DirItem> list, List<FileItem> list2, DeleteDirFileCallback deleteDirFileCallback) {
        DirItem[] dirItemArr;
        FileItem[] fileItemArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, list, list2, deleteDirFileCallback)).booleanValue();
        }
        boolean ensureInit = ensureInit();
        if (ensureInit) {
            if (list == null) {
                dirItemArr = new DirItem[0];
            } else {
                dirItemArr = (DirItem[]) list.toArray(new DirItem[list.size()]);
            }
            if (list2 == null) {
                fileItemArr = new FileItem[0];
            } else {
                fileItemArr = (FileItem[]) list2.toArray(new FileItem[list2.size()]);
            }
            nativeDeleteDirFile(dirItemArr, fileItemArr, this.mCallbackCenter.addCallback(deleteDirFileCallback));
        }
        return ensureInit;
    }

    public boolean fetchFileList(int i3, boolean z16, int i16, int i17, int i18, FetchFileListCallback fetchFileListCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), fetchFileListCallback)).booleanValue();
        }
        boolean ensureInit = ensureInit();
        if (ensureInit) {
            nativeFetchFileList(i3, z16, i16, i17, i18, this.mCallbackCenter.addCallback(fetchFileListCallback));
        }
        return ensureInit;
    }

    public boolean fetchFileListRecursively(int i3, int i16, int i17, int i18, FetchFileListCallback fetchFileListCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), fetchFileListCallback)).booleanValue();
        }
        boolean ensureInit = ensureInit();
        if (ensureInit) {
            nativeFetchFileListRecursively(i3, i16, i17, i18, this.mCallbackCenter.addCallback(fetchFileListCallback));
        }
        return ensureInit;
    }

    public boolean fetchPOI(List<PoiItem> list, FetchPOICallback fetchPOICallback) {
        PoiItem[] poiItemArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) list, (Object) fetchPOICallback)).booleanValue();
        }
        boolean ensureInit = ensureInit();
        if (ensureInit) {
            if (list == null) {
                poiItemArr = new PoiItem[0];
            } else {
                poiItemArr = (PoiItem[]) list.toArray(new PoiItem[list.size()]);
            }
            nativeFetchPOI(poiItemArr, this.mCallbackCenter.addCallback(fetchPOICallback));
        }
        return ensureInit;
    }

    public boolean fetchPicVideoInfo(FetchPicVideoInfoCallback fetchPicVideoInfoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) fetchPicVideoInfoCallback)).booleanValue();
        }
        boolean ensureInit = ensureInit();
        if (ensureInit) {
            nativeFetchPicVideoInfo(this.mCallbackCenter.addCallback(fetchPicVideoInfoCallback));
        }
        return ensureInit;
    }

    public boolean fetchUserInfo(FetchUserInfoCallback fetchUserInfoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) fetchUserInfoCallback)).booleanValue();
        }
        boolean ensureInit = ensureInit();
        if (ensureInit) {
            nativeFetchUserInfo(this.mCallbackCenter.addCallback(fetchUserInfoCallback));
        }
        return ensureInit;
    }

    public boolean init(WeiyunSDKContext weiyunSDKContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunSDKContext)).booleanValue();
        }
        if (weiyunSDKContext != null && WeiyunNative.sIsLoaded) {
            if (!this.mIsInit) {
                synchronized (this) {
                    if (!this.mIsInit) {
                        nativeRegisterContext(weiyunSDKContext);
                        this.mIsInit = true;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean modifyFile(FileItem fileItem, FileItem fileItem2, ModifyFileCallback modifyFileCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, fileItem, fileItem2, modifyFileCallback)).booleanValue();
        }
        boolean ensureInit = ensureInit();
        if (ensureInit) {
            nativeModifyFile(fileItem, fileItem2, this.mCallbackCenter.addCallback(modifyFileCallback));
        }
        return ensureInit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onNativeCallback(long j3, long j16, int i3, boolean z16, int i16, String str, boolean z17) {
        this.mCallbackCenter.onCallback(j3, j16, i3, z16, i16, str, z17);
    }

    public boolean reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        boolean ensureInit = ensureInit();
        if (ensureInit) {
            nativeReset();
        }
        return ensureInit;
    }

    public String version() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (ensureInit()) {
            return nativeVersion();
        }
        return "unknown";
    }
}
