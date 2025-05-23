package com.tencent.mobileqq.multimsg.save;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.multisave.a;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.multimsg.save.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\"\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0011J\u0014\u0010\u001a\u001a\u00020\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017J(\u0010!\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0004J*\u0010$\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0004J\u0018\u0010'\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/multimsg/save/o;", "", "", "filePath", "Landroid/os/Handler;", "handler", "", tl.h.F, "", "errorCode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "msgId", "msgElementId", "e", "key", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/multimsg/save/m$c;", "fileReqMap", "Lcom/tencent/mobileqq/multimsg/save/d;", "d", "", "Lcom/tencent/mobileqq/multimsg/save/m$b;", "fileSaveReqList", "", "g", "fileSaveReq", "f", WadlProxyConsts.PARAM_FILENAME, "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "mHandler", "i", "mVideoPath", "mUniqueName", "j", "Lcom/tencent/mobileqq/filemanager/multisave/a$a;", "callBack", "k", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f251729a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/multimsg/save/o$a", "Lcom/tencent/mobileqq/richmediabrowser/utils/AIOGalleryUtils$d;", "", "isSucc", "", "onSavePhotoResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements AIOGalleryUtils.d {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Handler f251730d;

        a(Handler handler) {
            this.f251730d = handler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler);
            }
        }

        @Override // com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.d
        public void onSavePhotoResult(boolean isSucc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isSucc);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("NTMultiRichMediaSaveManager", 2, "[savePictureFile]: result is " + isSucc);
            }
            if (isSucc) {
                o.f251729a.n(this.f251730d);
            } else {
                o.f251729a.m(10004, this.f251730d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59050);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f251729a = new o();
        }
    }

    o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void h(String filePath, Handler handler) {
        AIOGalleryUtils.m(BaseApplication.context, filePath, false, new a(handler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String filePath, a.InterfaceC7581a interfaceC7581a) {
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        try {
            String a16 = com.tencent.mobileqq.filemanager.util.l.a(filePath);
            boolean z16 = !TextUtils.isEmpty(a16);
            if (interfaceC7581a != null) {
                if (z16) {
                    BaseImageUtil.savePic2SystemMedia(BaseApplicationImpl.getApplication(), new File(a16));
                    BaseImageUtil.savePhotoToSysAlbum(BaseApplication.getContext(), a16);
                    interfaceC7581a.onSuccess();
                } else {
                    interfaceC7581a.onError(-1, "save file fail. filePath[" + filePath + "]");
                }
            }
        } catch (Exception e16) {
            if (interfaceC7581a != null) {
                interfaceC7581a.onError(-1, e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int errorCode, Handler handler) {
        d dVar = new d();
        dVar.f251679b = -1;
        dVar.f251680c = errorCode;
        dVar.f251681d = b.a(errorCode);
        Message obtainMessage = handler.obtainMessage(2);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(Fi\u2026tants.MSG_TYPE_SAVE_FAIL)");
        obtainMessage.obj = dVar;
        handler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Handler handler) {
        d dVar = new d();
        dVar.f251679b = 0;
        Message obtainMessage = handler.obtainMessage(1);
        Intrinsics.checkNotNullExpressionValue(obtainMessage, "handler.obtainMessage(Fi\u2026ts.MSG_TYPE_SAVE_SUCCESS)");
        obtainMessage.obj = dVar;
        handler.sendMessage(obtainMessage);
    }

    @NotNull
    public final d d(@NotNull String key, @NotNull ConcurrentHashMap<String, m.c> fileReqMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this, (Object) key, (Object) fileReqMap);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(fileReqMap, "fileReqMap");
        m.c cVar = fileReqMap.get(key);
        d dVar = new d();
        if (cVar != null) {
            dVar.f251680c = (int) cVar.c().fileErrCode;
            dVar.f251681d = cVar.c().fileErrMsg;
        }
        return dVar;
    }

    @NotNull
    public final String e(long msgId, long msgElementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, Long.valueOf(msgId), Long.valueOf(msgElementId));
        }
        return msgId + "_" + msgElementId;
    }

    public final boolean f(@Nullable m.b fileSaveReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) fileSaveReq)).booleanValue();
        }
        if (fileSaveReq == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NTMultiRichMediaSaveManager", 2, "isFileExist fileSaveReq is empty!");
            }
            return false;
        }
        File file = new File(fileSaveReq.c().filePath);
        if (!file.exists() || file.length() != fileSaveReq.a()) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NTMultiRichMediaSaveManager", 2, "isFileExist " + file.getName() + " exists");
            return true;
        }
        return true;
    }

    public final boolean g(@NotNull List<m.b> fileSaveReqList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) fileSaveReqList)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(fileSaveReqList, "fileSaveReqList");
        if (AppNetConnInfo.isWifiConn() || fileSaveReqList.isEmpty()) {
            return false;
        }
        long j3 = 0;
        for (m.b bVar : fileSaveReqList) {
            if (!f(bVar)) {
                j3 += bVar.a();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("NTMultiRichMediaSaveManager", 2, "isSaveNeedTips totalSaveSize = " + j3);
        }
        if (j3 <= 29360128) {
            return false;
        }
        return true;
    }

    public final void i(@Nullable String filePath, @NotNull String fileName, @NotNull FileTransNotifyInfo notifyInfo, @NotNull Handler mHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, filePath, fileName, notifyInfo, mHandler);
            return;
        }
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
        Intrinsics.checkNotNullParameter(mHandler, "mHandler");
        if (TextUtils.isEmpty(filePath)) {
            i3 = 10001;
        } else if (TextUtils.isEmpty(fileName)) {
            i3 = 10002;
        } else if (!FileUtils.fileExists(filePath)) {
            i3 = 10003;
        }
        if (i3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.e("NTMultiRichMediaSaveManager", 2, "savePictureFile fail, errorCode = " + i3);
            }
            m(i3, mHandler);
            return;
        }
        if (filePath != null) {
            f251729a.h(filePath, mHandler);
        }
    }

    public final void j(@Nullable String mVideoPath, @Nullable String mUniqueName, @NotNull FileTransNotifyInfo notifyInfo, @NotNull Handler mHandler) {
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, mVideoPath, mUniqueName, notifyInfo, mHandler);
            return;
        }
        Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
        Intrinsics.checkNotNullParameter(mHandler, "mHandler");
        if (TextUtils.isEmpty(mVideoPath)) {
            i3 = 10001;
        } else if (TextUtils.isEmpty(mUniqueName)) {
            i3 = 10002;
        } else if (!FileUtils.fileExists(mVideoPath)) {
            i3 = 10003;
        }
        if (i3 != 0) {
            if (QLog.isColorLevel()) {
                QLog.e("NTMultiRichMediaSaveManager", 2, "saveShortVideoFile fail, errorCode = " + i3);
            }
            m(i3, mHandler);
            return;
        }
        if (VersionUtils.isrFroyo()) {
            file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        } else {
            file = new File(AppConstants.SDCARD_VIDEO);
        }
        file.mkdirs();
        ThreadManager.getFileThreadHandler().post(new NTFileSaveRunnable(new File(mVideoPath), new File(file, ShortVideoUtils.getShortVideoSaveFileName(mUniqueName)), mHandler, notifyInfo, false));
    }

    public final void k(@NotNull final String filePath, @Nullable final a.InterfaceC7581a callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) filePath, (Object) callBack);
            return;
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (!FileUtils.fileExistsAndNotEmpty(filePath)) {
            if (callBack != null) {
                callBack.onError(-1, "file is not exist");
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.multimsg.save.n
            @Override // java.lang.Runnable
            public final void run() {
                o.l(filePath, callBack);
            }
        }, 64, null, true);
    }
}
