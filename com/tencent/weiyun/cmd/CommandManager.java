package com.tencent.weiyun.cmd;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.weiyun.WeiyunLiteGlobal;
import com.tencent.weiyun.callback.CheckShareFileCallback;
import com.tencent.weiyun.callback.DeleteDirFileCallback;
import com.tencent.weiyun.callback.FetchFileListCallback;
import com.tencent.weiyun.callback.FetchPOICallback;
import com.tencent.weiyun.callback.FetchPicVideoInfoCallback;
import com.tencent.weiyun.callback.FetchUserInfoCallback;
import com.tencent.weiyun.callback.ModifyFileCallback;
import com.tencent.weiyun.data.DirItem;
import com.tencent.weiyun.data.FileItem;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import com.tencent.weiyun.utils.UIHelper;
import com.tencent.weiyun.utils.Utils;
import com.tencent.weiyun.utils.WyLog;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CommandManager implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CommandManager";
    private static Singleton<CommandManager, Void> sInstance;
    private final Context mContext;
    private final Handler mHandler;
    private final WeiyunSDKContext mSdkContext;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10443);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            sInstance = new Singleton<CommandManager, Void>() { // from class: com.tencent.weiyun.cmd.CommandManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.weiyun.utils.Singleton
                public CommandManager create(Void r46) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new CommandManager(null) : (CommandManager) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
                }
            };
        }
    }

    /* synthetic */ CommandManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) anonymousClass1);
    }

    public static CommandManager getInstance() {
        return sInstance.get(null);
    }

    private void invokeMethod(Method method, Object[] objArr) {
        if (method != null && objArr != null) {
            try {
                WeiyunClient.class.getMethod(method.getName(), method.getParameterTypes()).invoke(WeiyunClient.getInstance(), objArr);
            } catch (Throwable th5) {
                WyLog.e(TAG, th5);
            }
        }
    }

    private void sendMessage(Method method, Object[] objArr) {
        if (method != null && objArr != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = new Object[]{method, objArr};
            this.mHandler.sendMessage(obtain);
        }
    }

    public void checkShareFile(List<DirItem> list, List<FileItem> list2, List<String> list3, CheckShareFileCallback checkShareFileCallback) {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, list, list2, list3, checkShareFileCallback);
            return;
        }
        try {
            method = CommandManager.class.getMethod("checkShareFile", List.class, List.class, List.class, CheckShareFileCallback.class);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method != null) {
            sendMessage(method, new Object[]{list, list2, list3, checkShareFileCallback});
        } else {
            WyLog.e(TAG, "method checkShareFile is null.");
        }
    }

    public void deleteDirFile(List<DirItem> list, List<FileItem> list2, DeleteDirFileCallback deleteDirFileCallback) {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, list, list2, deleteDirFileCallback);
            return;
        }
        try {
            method = CommandManager.class.getMethod("deleteDirFile", List.class, List.class, DeleteDirFileCallback.class);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method != null) {
            sendMessage(method, new Object[]{list, list2, deleteDirFileCallback});
        } else {
            WyLog.e(TAG, "method deleteDirFile is null.");
        }
    }

    public void fetchFileList(int i3, boolean z16, int i16, int i17, int i18, FetchFileListCallback fetchFileListCallback) {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), fetchFileListCallback);
            return;
        }
        try {
            Class cls = Integer.TYPE;
            method = CommandManager.class.getMethod("fetchFileList", cls, Boolean.TYPE, cls, cls, cls, FetchFileListCallback.class);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method != null) {
            sendMessage(method, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), fetchFileListCallback});
        } else {
            WyLog.e(TAG, "method fetchFileList is null.");
        }
    }

    public void fetchFileListRecursively(int i3, int i16, int i17, int i18, FetchFileListCallback fetchFileListCallback) {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), fetchFileListCallback);
            return;
        }
        try {
            Class cls = Integer.TYPE;
            method = CommandManager.class.getMethod("fetchFileListRecursively", cls, cls, cls, cls, FetchFileListCallback.class);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method != null) {
            sendMessage(method, new Object[]{Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), fetchFileListCallback});
        } else {
            WyLog.e(TAG, "method fetchFileListRecursively is null.");
        }
    }

    public void fetchPOI(List<PoiItem> list, FetchPOICallback fetchPOICallback) {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) list, (Object) fetchPOICallback);
            return;
        }
        try {
            method = CommandManager.class.getMethod("fetchPOI", List.class, FetchPOICallback.class);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method != null) {
            sendMessage(method, new Object[]{list, fetchPOICallback});
        } else {
            WyLog.e(TAG, "method fetchPOI is null.");
        }
    }

    public void fetchPicVideoInfo(FetchPicVideoInfoCallback fetchPicVideoInfoCallback) {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fetchPicVideoInfoCallback);
            return;
        }
        try {
            method = CommandManager.class.getMethod("fetchPicVideoInfo", FetchPicVideoInfoCallback.class);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method != null) {
            sendMessage(method, new Object[]{fetchPicVideoInfoCallback});
        } else {
            WyLog.e(TAG, "method fetchPicVideoInfo is null.");
        }
    }

    public void fetchUserInfo(FetchUserInfoCallback fetchUserInfoCallback) {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fetchUserInfoCallback);
            return;
        }
        try {
            method = CommandManager.class.getMethod("fetchUserInfo", FetchUserInfoCallback.class);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method != null) {
            sendMessage(method, new Object[]{fetchUserInfoCallback});
        } else {
            WyLog.e(TAG, "method fetchUserInfo is null.");
        }
    }

    public String getWeiyunSdkVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return WeiyunClient.getInstance().version();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            Object[] objArr = (Object[]) message.obj;
            invokeMethod((Method) objArr[0], (Object[]) objArr[1]);
        }
        return true;
    }

    public boolean isLibLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return WeiyunClient.isLoaded();
    }

    public boolean loadLibFromPath(String str) {
        boolean loadLibrary;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (WeiyunClient.isLoaded()) {
            loadLibrary = true;
        } else if (TextUtils.isEmpty(str)) {
            loadLibrary = false;
        } else {
            loadLibrary = WeiyunNative.loadLibrary(str);
        }
        if (loadLibrary) {
            WeiyunClient.getInstance().init(this.mSdkContext);
        }
        return loadLibrary;
    }

    public void modifyFile(FileItem fileItem, FileItem fileItem2, ModifyFileCallback modifyFileCallback) {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, fileItem, fileItem2, modifyFileCallback);
            return;
        }
        try {
            method = CommandManager.class.getMethod("modifyFile", FileItem.class, FileItem.class, ModifyFileCallback.class);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method != null) {
            sendMessage(method, new Object[]{fileItem, fileItem2, modifyFileCallback});
        } else {
            WyLog.e(TAG, "method modifyFile is null.");
        }
    }

    public void resetWeiyunSdk() {
        Method method;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            method = CommandManager.class.getMethod("reset", new Class[0]);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method != null) {
            sendMessage(method, new Object[0]);
        } else {
            WyLog.e(TAG, "method resetWeiyunSdk is null.");
        }
    }

    CommandManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mContext = WeiyunLiteGlobal.getInstance().getContext();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(TAG);
        baseHandlerThread.start();
        this.mHandler = new Handler(baseHandlerThread.getLooper(), this);
        WeiyunSDKContext weiyunSDKContext = new WeiyunSDKContext() { // from class: com.tencent.weiyun.cmd.CommandManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CommandManager.this);
                }
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public String getAccessToken() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 14)) {
                    return (String) iPatchRedirector2.redirect((short) 14, (Object) this);
                }
                return null;
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public String getCachePath() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return CommandManager.this.mContext.getFilesDir().toString();
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public String getDeviceId() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (String) iPatchRedirector2.redirect((short) 3, (Object) this);
                }
                return Utils.getDeviceId(CommandManager.this.mContext);
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public String getDeviceInfo() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    return (String) iPatchRedirector2.redirect((short) 5, (Object) this);
                }
                return "";
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public String getDeviceName() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return (String) iPatchRedirector2.redirect((short) 4, (Object) this);
                }
                return DeviceInfoMonitor.getModel();
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public int getLoginType() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 11)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 11, (Object) this)).intValue();
                }
                return 0;
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public int getNetworkType() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 8)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 8, (Object) this)).intValue();
                }
                return NetworkUtils.getNetworkTypeDiff4G(CommandManager.this.mContext);
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public String getOpenID() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 12)) {
                    return (String) iPatchRedirector2.redirect((short) 12, (Object) this);
                }
                return null;
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public String getOpenKey() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 13)) {
                    return (String) iPatchRedirector2.redirect((short) 13, (Object) this);
                }
                return null;
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public int getPlatform() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 9)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 9, (Object) this)).intValue();
                }
                return Build.VERSION.SDK_INT;
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public String getRefreshToken() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 15)) {
                    return (String) iPatchRedirector2.redirect((short) 15, (Object) this);
                }
                return null;
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public long[] getScreenSize() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    return (long[]) iPatchRedirector2.redirect((short) 6, (Object) this);
                }
                return new long[]{UIHelper.getWindowScreenWidth(CommandManager.this.mContext), UIHelper.getWindowScreenHeight(CommandManager.this.mContext)};
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public long getUin() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 10)) {
                    return ((Long) iPatchRedirector2.redirect((short) 10, (Object) this)).longValue();
                }
                return WeiyunLiteGlobal.getInstance().getHostInterface().getCurrentUin();
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public String getWifiBssid() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    return (String) iPatchRedirector2.redirect((short) 7, (Object) this);
                }
                String wifiBSSID = NetworkUtils.getWifiBSSID(CommandManager.this.mContext);
                if (wifiBSSID == null) {
                    return "";
                }
                return wifiBSSID;
            }

            @Override // com.tencent.weiyun.cmd.WeiyunSDKContext
            public void sendRequest(String str, byte[] bArr, long j3, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 16)) {
                    iPatchRedirector2.redirect((short) 16, this, str, bArr, Long.valueOf(j3), Integer.valueOf(i3));
                } else {
                    WeiyunLiteGlobal.getInstance().getHostInterface().sendRequest(str, bArr, new WeiyunLiteGlobal.IResponseHandler(j3, i3) { // from class: com.tencent.weiyun.cmd.CommandManager.1.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int val$nativeCallback;
                        final /* synthetic */ long val$nativeReceiver;

                        {
                            this.val$nativeReceiver = j3;
                            this.val$nativeCallback = i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Long.valueOf(j3), Integer.valueOf(i3));
                            }
                        }

                        @Override // com.tencent.weiyun.WeiyunLiteGlobal.IResponseHandler
                        public void receiveResponse(int i16, String str2, byte[] bArr2) {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, this, Integer.valueOf(i16), str2, bArr2);
                            } else {
                                recvResponse(i16, bArr2, this.val$nativeReceiver, this.val$nativeCallback);
                            }
                        }
                    });
                }
            }
        };
        this.mSdkContext = weiyunSDKContext;
        WeiyunClient.getInstance().init(weiyunSDKContext);
    }
}
