package com.tencent.mobileqq.emoticonview.searchemo;

import android.graphics.Typeface;
import androidx.annotation.WorkerThread;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoUtil;", "", "()V", "HOT_PIC_FONT", "", "HOT_PIC_FONT_FILE_LENGTH", "", "HOT_PIC_FONT_FILE_MD5", "HOT_PIC_FONT_ZIP", "HOT_PIC_RES", "HOT_PIC_RES_DIR", "kotlin.jvm.PlatformType", "TAG", "isFontDownloading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "downloadFontFile", "", "app", "Lcom/tencent/common/app/AppInterface;", "getTypeface", "Landroid/graphics/Typeface;", "isFontFileCorrect", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class SearchEmoUtil {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String HOT_PIC_FONT;
    private static final long HOT_PIC_FONT_FILE_LENGTH = 1533056;

    @NotNull
    private static final String HOT_PIC_FONT_FILE_MD5 = "24BA8E2E8ADB388A87AC8D3A97976AB7";

    @NotNull
    private static final String HOT_PIC_FONT_ZIP;

    @NotNull
    private static final String HOT_PIC_RES = "res/";
    private static final String HOT_PIC_RES_DIR;

    @NotNull
    public static final SearchEmoUtil INSTANCE;

    @NotNull
    private static final String TAG = "SearchEmoUtil";

    @NotNull
    private static final AtomicBoolean isFontDownloading;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23554);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new SearchEmoUtil();
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_HOT_PIC_PATH + File.separator + HOT_PIC_RES);
        HOT_PIC_RES_DIR = sDKPrivatePath;
        HOT_PIC_FONT_ZIP = sDKPrivatePath + "composite_font.otf.zip";
        HOT_PIC_FONT = sDKPrivatePath + "composite_font.otf";
        isFontDownloading = new AtomicBoolean(false);
    }

    SearchEmoUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void downloadFontFile(AppInterface app) {
        if (!isFontDownloading.compareAndSet(false, true)) {
            return;
        }
        QLog.i(TAG, 1, "start download hot pic composite font");
        IRuntimeService runtimeService = app.getRuntimeService(IHttpEngineService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IH\u2026ava, ProcessConstant.ALL)");
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = "https://static-res.qq.com/static-res/aio/emoticon/composite_font.otf.zip";
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = HOT_PIC_FONT_ZIP;
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mCallback = new INetEngineListener() { // from class: com.tencent.mobileqq.emoticonview.searchemo.SearchEmoUtil$downloadFontFile$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onResp(@NotNull NetResp resp) {
                boolean z16;
                String str;
                String str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) resp);
                    return;
                }
                Intrinsics.checkNotNullParameter(resp, "resp");
                try {
                    int i3 = resp.mResult;
                    if (i3 == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        QLog.i("SearchEmoUtil", 1, "onResp, result:" + i3);
                    } else {
                        File file = new File(resp.mReq.mOutPath);
                        if (file.exists()) {
                            try {
                                str2 = SearchEmoUtil.HOT_PIC_RES_DIR;
                                ZipUtils.unZipFile(file, str2);
                            } catch (IOException e16) {
                                QLog.i("SearchEmoUtil", 1, "file unZipFile, e:" + e16);
                            }
                            str = SearchEmoUtil.HOT_PIC_FONT;
                            String fileMd5 = SecUtil.getFileMd5(str);
                            if (!Intrinsics.areEqual(fileMd5, "24BA8E2E8ADB388A87AC8D3A97976AB7")) {
                                QLog.i("SearchEmoUtil", 1, "file md5 not match, md5:" + fileMd5);
                            } else {
                                QLog.i("SearchEmoUtil", 1, "download font file success, deleteSuccess:" + file.delete());
                            }
                        } else {
                            QLog.i("SearchEmoUtil", 1, "file not exist, path:" + file.getAbsolutePath());
                        }
                    }
                } finally {
                    SearchEmoUtil.INSTANCE.isFontDownloading().set(false);
                }
            }

            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onUpdateProgeress(@NotNull NetReq req, long curOffset, long totalLen) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, req, Long.valueOf(curOffset), Long.valueOf(totalLen));
                } else {
                    Intrinsics.checkNotNullParameter(req, "req");
                }
            }
        };
        ((IHttpEngineService) runtimeService).sendReq(httpNetReq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTypeface$lambda$1$lambda$0(AppInterface it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        INSTANCE.downloadFontFile(it);
    }

    private final boolean isFontFileCorrect() {
        File file = new File(HOT_PIC_FONT);
        if (file.exists() && file.length() == HOT_PIC_FONT_FILE_LENGTH) {
            return true;
        }
        return false;
    }

    @WorkerThread
    @Nullable
    public final Typeface getTypeface() {
        final AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Typeface) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (isFontFileCorrect()) {
            try {
                return Typeface.createFromFile(HOT_PIC_FONT);
            } catch (Exception e16) {
                QLog.i(TAG, 1, "Typeface.createFromFile failed, e:" + e16);
            }
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.emoticonview.searchemo.k
                @Override // java.lang.Runnable
                public final void run() {
                    SearchEmoUtil.getTypeface$lambda$1$lambda$0(AppInterface.this);
                }
            }, 128, null, false);
        }
        return null;
    }

    @NotNull
    public final AtomicBoolean isFontDownloading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AtomicBoolean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return isFontDownloading;
    }
}
