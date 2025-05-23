package com.tencent.mobileqq.soload.api.impl;

import android.os.Bundle;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.commonsdk.zip.QZipIOException;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.soload.api.ISoLoadResService;
import com.tencent.mobileqq.soload.biz.SoLoadIPCModule;
import com.tencent.mobileqq.soload.download.DownloadParam;
import com.tencent.mobileqq.soload.download.ResourceInfo;
import com.tencent.mobileqq.soload.download.SoDownloadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u001c\u0010\u0015\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0002J$\u0010\u0015\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J*\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010!\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010$\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010%\u001a\u00020\u000fH\u0016J\u001c\u0010'\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u000fH\u0016J\u001e\u0010)\u001a\u0004\u0018\u00010\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010*\u001a\u0004\u0018\u00010\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J\u001e\u0010,\u001a\u0004\u0018\u00010\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010-\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010.\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010/\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u00100\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u00102\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u000f2\u0006\u00101\u001a\u00020\u0012H\u0016J\u0018\u00103\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0010\u00105\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u001a\u00109\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u0001062\b\u00108\u001a\u0004\u0018\u00010\u0002J\u001a\u0010;\u001a\u0002062\b\u0010\"\u001a\u0004\u0018\u00010\u000f2\u0006\u0010:\u001a\u00020\u0012H\u0016J\u001a\u0010<\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fJ\u001a\u0010=\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u000fJ\u001c\u0010>\u001a\u00020\u00122\b\u0010(\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010A\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010B\u001a\u00020\bH\u0016J\u0010\u0010C\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010E\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u000fJ\u0010\u0010G\u001a\u00020F2\b\u00104\u001a\u0004\u0018\u00010\u000fJ\u001c\u0010H\u001a\u0004\u0018\u00010\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000fJ\u001c\u0010I\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010J\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u000f\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/soload/api/impl/SoLoadResServiceImpl;", "Lcom/tencent/mobileqq/soload/api/ISoLoadResService;", "Lcom/tencent/mobileqq/soload/download/DownloadParam;", "param", "Lcom/tencent/mobileqq/soload/api/ISoLoadResService$PathResult;", "getResPathSyncOnMainProcess", "Lcom/tencent/mobileqq/soload/api/ISoLoadResService$OnGetPathListener;", "listener", "", "getResPathOnMainProcess", "Lcom/tencent/mobileqq/vip/g;", "task", "downloadParams", "callback", "processOnFileDone", "", "zipPath", "unzipFolderPath", "", "doUnzipAtomically", "destinationPath", "doUnzip", "isCreateTmp", "Ljava/util/zip/ZipFile;", "zipfile", "Ljava/util/zip/ZipEntry;", "entry", "outputDir", "unzipEntry", "Ljava/io/File;", QzoneZipCacheHelper.DIR, "createDir", "folderPath", "isFolderPathValid", "url", "getResPathByUrl", "getFilePath", "getResPathPrefix", "md5", "updateResInfo", "filePath", "getResMd5UseCache", "getResMd5", "defValue", "getCacheMd5", "deleteFile", "removeResInfo", "getResPathSync", "getResPath", "isForceUnzip", "deleteRes", "realTimeDownload", "path", "delete", "Lcom/tencent/mobileqq/soload/download/ResourceInfo;", "resInfo", "dp", "isFileValid", "isUnzipDefault", "getResInfoByUrl", "checkFolderAndUnzip", "unzip", "unzipAtomically", "soFileName", "curLoadSoPath", "checkIfClearOldSoVersion", "cleanLocalCache", "getEntryName", "unzipPath", "isDiskEnoughToUnzip", "", "getFreeSpace", "getFolderPath", "getFolderPathByMD5AndUrl", "isNeedAutoUnzip", "<init>", "()V", "Companion", "a", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SoLoadResServiceImpl implements ISoLoadResService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String KEY_LAST_USE_TIME = "qqso_last_use_time";

    @NotNull
    private static final String KEY_RES_URL_MD5 = "qqso_url_md5";
    private static final long ONE_DAY = 86400000;
    private static final int SAFE_FREE_SPACE = 52428800;

    @NotNull
    private static final String SO_DOWNLOAD_PREFIX = ".download";

    @NotNull
    private static final String SO_ROOT_PREFIX = "qqso";

    @NotNull
    private static final String SO_SUFFIX = ".so";

    @NotNull
    private static final String TAG = "SoLoadWidget.SoLoadResServiceImpl";

    @NotNull
    private static final String ZIP_SUFFIX = ".zip";

    @NotNull
    private static final HashMap<String, Long> checkCleanOldVersionMap;

    @NotNull
    private static final byte[] sFileLock;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000fR \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/soload/api/impl/SoLoadResServiceImpl$a;", "", "", "url", "b", "", "time", "", "e", "md5", "f", "c", "", "d", "KEY_LAST_USE_TIME", "Ljava/lang/String;", "KEY_RES_URL_MD5", "ONE_DAY", "J", "", "SAFE_FREE_SPACE", "I", "SO_DOWNLOAD_PREFIX", "SO_ROOT_PREFIX", "SO_SUFFIX", "TAG", "ZIP_SUFFIX", "Ljava/util/HashMap;", "checkCleanOldVersionMap", "Ljava/util/HashMap;", "", "sFileLock", "[B", "<init>", "()V", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.soload.api.impl.SoLoadResServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(String url) {
            return SoLoadResServiceImpl.KEY_LAST_USE_TIME + MD5.toMD5(url);
        }

        @NotNull
        public final String c(@Nullable String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) url);
            }
            return SoLoadResServiceImpl.KEY_RES_URL_MD5 + MD5.toMD5(url);
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return MobileQQ.sMobileQQ.peekAppRuntime() instanceof BaseQQAppInterface;
        }

        public final void e(@Nullable String url, long time) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, url, Long.valueOf(time));
            } else if (url != null) {
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                from.encodeLong(SoLoadResServiceImpl.INSTANCE.b(url), time);
            }
        }

        public final void f(@Nullable String url, @Nullable String md5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) md5);
            } else if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(md5)) {
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
                from.encodeString(c(url), md5);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/soload/api/impl/SoLoadResServiceImpl$b", "Lcom/tencent/mobileqq/vip/f;", "Lcom/tencent/mobileqq/vip/g;", "task", "", "onDoneFile", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DownloadParam f288528b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISoLoadResService.OnGetPathListener f288529c;

        b(DownloadParam downloadParam, ISoLoadResService.OnGetPathListener onGetPathListener) {
            this.f288528b = downloadParam;
            this.f288529c = onGetPathListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SoLoadResServiceImpl.this, downloadParam, onGetPathListener);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDoneFile(@NotNull com.tencent.mobileqq.vip.g task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            super.onDoneFile(task);
            task.I = System.currentTimeMillis();
            SoLoadResServiceImpl.this.processOnFileDone(task, this.f288528b, this.f288529c);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20845);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
            return;
        }
        INSTANCE = new Companion(null);
        sFileLock = new byte[0];
        checkCleanOldVersionMap = new HashMap<>();
    }

    public SoLoadResServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIfClearOldSoVersion$lambda$4(SoLoadResServiceImpl this$0, String str, String str2) {
        boolean contains$default;
        String replace$default;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (sFileLock) {
            try {
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
            if (!com.tencent.mobileqq.soload.util.f.C()) {
                QLog.i(TAG, 1, "[checkIfClearOldSoVersion] switch is close");
                return;
            }
            String resPathPrefix = this$0.getResPathPrefix();
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) resPathPrefix, false, 2, (Object) null);
            if (contains$default) {
                replace$default = StringsKt__StringsJVMKt.replace$default(str, resPathPrefix, "", false, 4, (Object) null);
                Iterator<String> it = FileUtils.getChildFiles(resPathPrefix).iterator();
                while (it.hasNext()) {
                    String path = it.next();
                    if (Intrinsics.areEqual(str2, new File(path).getName())) {
                        Intrinsics.checkNotNullExpressionValue(path, "path");
                        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(path, replace$default, false, 2, null);
                        if (!endsWith$default) {
                            this$0.delete(path);
                            QLog.i(TAG, 1, "[checkIfClearOldSoVersion] delete:" + str2 + ",path:" + path + ",curLoadSoPath:" + str);
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void createDir(File dir) {
        if (dir.exists()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "Creating dir " + dir.getName());
        }
        if (dir.mkdirs()) {
            return;
        }
        throw new RuntimeException("Can not create dir " + dir);
    }

    private final boolean doUnzip(String zipPath, String destinationPath) {
        return doUnzip(zipPath, destinationPath, false);
    }

    private final boolean doUnzipAtomically(String zipPath, String unzipFolderPath) {
        File file = new File(zipPath);
        if (!file.exists()) {
            return false;
        }
        String str = zipPath + "Tmp";
        File file2 = new File(str);
        QLog.d(TAG, 2, "unzipAtomically1" + file + file.exists() + file2 + file2.exists());
        FileUtils.delete(str, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "unzipAtomically2" + file + file.exists() + file2 + file2.exists());
        }
        if (!doUnzip(zipPath, str) || !file2.exists()) {
            return false;
        }
        File file3 = new File(unzipFolderPath);
        FileUtils.delete(unzipFolderPath, false);
        if (!FileUtils.renameFile(file2, file3)) {
            return false;
        }
        return file3.exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getResPath$lambda$2(ISoLoadResService.OnGetPathListener onGetPathListener, DownloadParam downloadParam, EIPCResult eIPCResult) {
        boolean z16;
        Bundle bundle;
        if (eIPCResult != null && eIPCResult.isSuccess() && (bundle = eIPCResult.data) != null) {
            int i3 = bundle.getInt("result_code");
            ISoLoadResService.PathResult pathResult = (ISoLoadResService.PathResult) eIPCResult.data.getSerializable("path_result");
            if (onGetPathListener != null) {
                onGetPathListener.onResult(i3, pathResult);
            }
        } else if (onGetPathListener != null) {
            onGetPathListener.onResult(1, ISoLoadResService.PathResult.INSTANCE.getFailRes(downloadParam.url));
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getResPath: onServer:");
        if (eIPCResult != null) {
            z16 = eIPCResult.isSuccess();
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d(TAG, 2, sb5.toString());
    }

    private final void getResPathOnMainProcess(DownloadParam param, ISoLoadResService.OnGetPathListener listener) {
        ResourceInfo resInfoByUrl = getResInfoByUrl(param.url, param.isForceUnzip);
        boolean isFileValid = isFileValid(resInfoByUrl, param);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getResPath: isValidFileExist" + isFileValid + QbAddrData.DATA_SPLITER + resInfoByUrl);
        }
        if (isFileValid) {
            if (listener != null) {
                ISoLoadResService.PathResult pathResult = new ISoLoadResService.PathResult();
                pathResult.url = param.url;
                pathResult.filePath = resInfoByUrl.filePath;
                pathResult.folderPath = resInfoByUrl.folderPath;
                pathResult.isAlreadyExist = true;
                listener.onResult(0, pathResult);
                return;
            }
            return;
        }
        removeResInfo(param.url);
        delete(resInfoByUrl.filePath);
        delete(resInfoByUrl.folderPath);
        realTimeDownload(param, listener);
    }

    private final ISoLoadResService.PathResult getResPathSyncOnMainProcess(DownloadParam param) {
        ResourceInfo resInfoByUrl = getResInfoByUrl(param.url, param.isForceUnzip);
        if (isFileValid(resInfoByUrl, param)) {
            ISoLoadResService.PathResult pathResult = new ISoLoadResService.PathResult();
            pathResult.url = param.url;
            pathResult.filePath = resInfoByUrl.filePath;
            pathResult.folderPath = resInfoByUrl.folderPath;
            pathResult.isAlreadyExist = true;
            return pathResult;
        }
        return null;
    }

    private final boolean isFolderPathValid(String folderPath) {
        if (!TextUtils.isEmpty(folderPath) && new File(folderPath).exists() && FileUtils.getFileOrFolderSize(folderPath) > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processOnFileDone(com.tencent.mobileqq.vip.g task, DownloadParam downloadParams, ISoLoadResService.OnGetPathListener callback) {
        String absolutePath;
        boolean equals;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("RealTime onDoneFile|");
            sb5.append(task.f313006d);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(task.f313004c);
            sb5.append(QbAddrData.DATA_SPLITER);
            File file = task.f313010h.get(task.f313004c);
            Intrinsics.checkNotNull(file);
            sb5.append(file.getAbsolutePath());
            sb5.append(",cost:");
            sb5.append(task.I - task.H);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (task.f313006d == 0 && task.f313010h != null && !TextUtils.isEmpty(task.f313004c)) {
            File file2 = task.f313010h.get(task.f313004c);
            if (file2 == null) {
                absolutePath = "";
            } else {
                absolutePath = file2.getAbsolutePath();
            }
            String encodeFile2HexStr = MD5Coding.encodeFile2HexStr(absolutePath);
            if (file2 != null && file2.exists() && !TextUtils.isEmpty(encodeFile2HexStr)) {
                if (!TextUtils.isEmpty(downloadParams.md5ForChecked)) {
                    equals = StringsKt__StringsJVMKt.equals(downloadParams.md5ForChecked, encodeFile2HexStr, true);
                    if (!equals) {
                        if (callback != null) {
                            callback.onResult(2, ISoLoadResService.PathResult.INSTANCE.getFailRes(task.f313004c));
                        }
                        deleteRes(task.f313004c, false);
                        return;
                    }
                }
                updateResInfo(task.f313004c, encodeFile2HexStr);
            }
        }
        int i3 = task.f313006d;
        if (i3 == 0) {
            ResourceInfo resInfoByUrl = getResInfoByUrl(task.f313004c, downloadParams.isForceUnzip);
            ISoLoadResService.PathResult pathResult = new ISoLoadResService.PathResult();
            pathResult.url = task.f313004c;
            pathResult.filePath = resInfoByUrl.filePath;
            pathResult.folderPath = resInfoByUrl.folderPath;
            pathResult.fileSize = task.f313013k;
            pathResult.downloadCost = task.I - task.H;
            if (callback != null) {
                callback.onResult(0, pathResult);
                return;
            }
            return;
        }
        if (callback != null) {
            callback.onResult(1, ISoLoadResService.PathResult.INSTANCE.getFailRes(task.f313004c, i3, task.f313013k));
        }
    }

    private final void unzipEntry(ZipFile zipfile, ZipEntry entry, String outputDir, boolean isCreateTmp) throws IOException {
        String str;
        String entryName = getEntryName(entry);
        if (entry.isDirectory()) {
            createDir(new File(outputDir, entryName));
            return;
        }
        if (isCreateTmp) {
            str = entryName + "tmp";
        } else {
            str = entryName;
        }
        File file = new File(outputDir, str);
        if (!file.getParentFile().exists()) {
            File parentFile = file.getParentFile();
            Intrinsics.checkNotNullExpressionValue(parentFile, "outputFile.parentFile");
            createDir(parentFile);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "Extracting: " + entry);
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipfile.getInputStream(entry));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    break;
                } else {
                    bufferedOutputStream.write(bArr, 0, read);
                }
            }
            bufferedOutputStream.flush();
        } finally {
            bufferedOutputStream.close();
            bufferedInputStream.close();
            if (isCreateTmp) {
                FileUtils.renameFile(file, new File(outputDir, entryName));
            }
        }
    }

    public final synchronized boolean checkFolderAndUnzip(@Nullable String filePath, @Nullable String folderPath) {
        boolean unzipAtomically;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) filePath, (Object) folderPath)).booleanValue();
        }
        if (isFolderPathValid(folderPath)) {
            unzipAtomically = true;
        } else {
            unzipAtomically = unzipAtomically(filePath, folderPath);
        }
        return unzipAtomically;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    public void checkIfClearOldSoVersion(@Nullable final String soFileName, @Nullable final String curLoadSoPath) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) soFileName, (Object) curLoadSoPath);
            return;
        }
        boolean z17 = true;
        if (soFileName != null && soFileName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (curLoadSoPath != null && curLoadSoPath.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                HashMap<String, Long> hashMap = checkCleanOldVersionMap;
                Long l3 = hashMap.get(soFileName);
                if (l3 != null && Math.abs(System.currentTimeMillis() - l3.longValue()) < 86400000) {
                    return;
                }
                hashMap.put(soFileName, Long.valueOf(System.currentTimeMillis()));
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.soload.api.impl.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        SoLoadResServiceImpl.checkIfClearOldSoVersion$lambda$4(SoLoadResServiceImpl.this, curLoadSoPath, soFileName);
                    }
                }, 64, null, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    public void cleanLocalCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            com.tencent.mobileqq.soload.util.f.b();
        }
    }

    public final void delete(@Nullable String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) path);
            return;
        }
        try {
            if (!TextUtils.isEmpty(path)) {
                FileUtils.delete(path, false);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "error msg ", th5);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    public void deleteFile(@Nullable String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) filePath);
            return;
        }
        try {
            if (!TextUtils.isEmpty(filePath)) {
                FileUtils.delete(filePath, false);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "delete file:" + filePath);
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    public void deleteRes(@Nullable String url, boolean isForceUnzip) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, url, Boolean.valueOf(isForceUnzip));
            return;
        }
        ResourceInfo resInfoByUrl = getResInfoByUrl(url, isForceUnzip);
        removeResInfo(url);
        delete(resInfoByUrl.filePath);
        delete(resInfoByUrl.folderPath);
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    @Nullable
    public String getCacheMd5(@Nullable String url, @Nullable String defValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) url, (Object) defValue);
        }
        if (url != null) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            from.decodeString(INSTANCE.c(url), defValue);
            return "";
        }
        return "";
    }

    @Nullable
    public final String getEntryName(@NotNull ZipEntry entry) throws QZipIOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this, (Object) entry);
        }
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!QZipIOException.isInvalidEntry(entry)) {
            return entry.getName();
        }
        throw new QZipIOException();
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    @NotNull
    public String getFilePath(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
        }
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        return getResPathPrefix() + MD5.toMD5(url);
    }

    @Nullable
    public final String getFolderPath(@Nullable String url, @Nullable String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this, (Object) url, (Object) filePath);
        }
        if (isNeedAutoUnzip(url)) {
            return getFolderPathByMD5AndUrl(getResMd5UseCache(url, filePath), url);
        }
        return null;
    }

    @Nullable
    public final String getFolderPathByMD5AndUrl(@Nullable String md5, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, (Object) md5, (Object) url);
        }
        if (!TextUtils.isEmpty(md5) && !TextUtils.isEmpty(url)) {
            return getResPathPrefix() + MD5.toMD5(url + md5);
        }
        return null;
    }

    public final long getFreeSpace(@Nullable String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Long) iPatchRedirector.redirect((short) 25, (Object) this, (Object) path)).longValue();
        }
        try {
            StatFs statFs = new StatFs(path);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return 0L;
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    @NotNull
    public ResourceInfo getResInfoByUrl(@Nullable String url, boolean isUnzipDefault) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ResourceInfo) iPatchRedirector.redirect((short) 17, this, url, Boolean.valueOf(isUnzipDefault));
        }
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.url = url;
        String resPathByUrl = getResPathByUrl(url);
        if (!TextUtils.isEmpty(resPathByUrl)) {
            resourceInfo.filePath = resPathByUrl;
            resourceInfo.fileMd5 = getResMd5UseCache(url, resPathByUrl);
            if (isUnzipDefault || isNeedAutoUnzip(url)) {
                String folderPathByMD5AndUrl = getFolderPathByMD5AndUrl(resourceInfo.fileMd5, url);
                if (checkFolderAndUnzip(resourceInfo.filePath, folderPathByMD5AndUrl)) {
                    resourceInfo.folderPath = folderPathByMD5AndUrl;
                }
            }
        }
        return resourceInfo;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    @Nullable
    public String getResMd5(@Nullable String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) filePath);
        }
        return MD5Coding.encodeFile2HexStr(filePath);
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    @Nullable
    public String getResMd5UseCache(@Nullable String url, @Nullable String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) url, (Object) filePath);
        }
        String cacheMd5 = getCacheMd5(url, "");
        if (TextUtils.isEmpty(cacheMd5) && !TextUtils.isEmpty(filePath) && new File(filePath).exists()) {
            String encodeFile2HexStr = MD5Coding.encodeFile2HexStr(filePath);
            INSTANCE.f(url, encodeFile2HexStr);
            return encodeFile2HexStr;
        }
        return cacheMd5;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    public void getResPath(@Nullable final DownloadParam param, @Nullable final ISoLoadResService.OnGetPathListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) param, (Object) listener);
            return;
        }
        if (param != null && !TextUtils.isEmpty(param.url)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getResPath: param:");
            sb5.append(param);
            sb5.append(",isQQProcess:");
            Companion companion = INSTANCE;
            sb5.append(companion.d());
            QLog.d(TAG, 2, sb5.toString());
            if (companion.d()) {
                getResPathOnMainProcess(param, listener);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("method_type", 1);
            bundle.putSerializable("download_params", param);
            QIPCClientHelper.getInstance().callServer(SoLoadIPCModule.NAME, SoLoadIPCModule.ACTION_PRELOAD_COMMON, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.soload.api.impl.p
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    SoLoadResServiceImpl.getResPath$lambda$2(ISoLoadResService.OnGetPathListener.this, param, eIPCResult);
                }
            });
            return;
        }
        if (listener != null) {
            listener.onResult(1, ISoLoadResService.PathResult.INSTANCE.getFailRes(null));
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    @Nullable
    public String getResPathByUrl(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        if (!TextUtils.isEmpty(url)) {
            String filePath = getFilePath(url);
            if (!TextUtils.isEmpty(filePath) && new File(filePath).exists()) {
                INSTANCE.e(url, NetConnInfoCenter.getServerTimeMillis());
                return filePath;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    @NotNull
    public String getResPathPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        File file = new File(BaseApplication.getContext().getFilesDir(), SO_ROOT_PREFIX);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, SO_DOWNLOAD_PREFIX);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.getAbsolutePath() + '/';
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    @Nullable
    public ISoLoadResService.PathResult getResPathSync(@Nullable DownloadParam param) {
        boolean z16;
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ISoLoadResService.PathResult) iPatchRedirector.redirect((short) 11, (Object) this, (Object) param);
        }
        if (param != null && !TextUtils.isEmpty(param.url)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getResPathSync: param:");
            sb5.append(param);
            sb5.append(",isQQProcess:");
            Companion companion = INSTANCE;
            sb5.append(companion.d());
            QLog.d(TAG, 2, sb5.toString());
            if (companion.d()) {
                return getResPathSyncOnMainProcess(param);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("method_type", 2);
            bundle2.putSerializable("download_params", param);
            EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), SoLoadIPCModule.NAME, SoLoadIPCModule.ACTION_PRELOAD_COMMON, bundle2);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("getResPathSync: onServer:");
            if (callServer != null) {
                z16 = callServer.isSuccess();
            } else {
                z16 = false;
            }
            sb6.append(z16);
            QLog.d(TAG, 2, sb6.toString());
            if (callServer != null && callServer.isSuccess() && (bundle = callServer.data) != null) {
                try {
                    return (ISoLoadResService.PathResult) bundle.getSerializable("path_result");
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, th5, new Object[0]);
                }
            }
        }
        return null;
    }

    public final boolean isDiskEnoughToUnzip(@NotNull String unzipPath) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) unzipPath)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(unzipPath, "unzipPath");
        File file = new File(unzipPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!TextUtils.isEmpty(unzipPath)) {
            j3 = getFreeSpace(unzipPath);
            if (j3 > IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "isDiskEnoughToUnzip|true|" + unzipPath + QbAddrData.DATA_SPLITER + j3);
                }
                return true;
            }
        } else {
            j3 = 0;
        }
        QLog.d(TAG, 1, "isDiskEnoughToUnzip|false|" + unzipPath + QbAddrData.DATA_SPLITER + j3);
        return false;
    }

    public final boolean isFileValid(@Nullable ResourceInfo resInfo, @Nullable DownloadParam dp5) {
        boolean equals;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) resInfo, (Object) dp5)).booleanValue();
        }
        if (dp5 != null && resInfo != null && !TextUtils.isEmpty(resInfo.filePath) && new File(resInfo.filePath).exists()) {
            boolean z16 = dp5.isForceUnzip;
            String str = dp5.md5ForChecked;
            if (!TextUtils.isEmpty(str)) {
                equals = StringsKt__StringsJVMKt.equals(str, resInfo.fileMd5, true);
                if (!equals) {
                    QLog.e(TAG, 1, "[isFileValid] false,md5ForChecked:" + str + ",fileMd5:" + resInfo.fileMd5);
                    return false;
                }
            }
            if ((z16 || isNeedAutoUnzip(resInfo.url)) && TextUtils.isEmpty(resInfo.folderPath)) {
                return false;
            }
            return true;
        }
        QLog.i(TAG, 1, "[isFileValid] false , dp:" + dp5 + ",resInfo:" + resInfo);
        return false;
    }

    public final boolean isNeedAutoUnzip(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) url)).booleanValue();
        }
        if (url != null && url.length() > 5) {
            String substring = url.substring(url.length() - 4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            if (Intrinsics.areEqual(substring, ".zip")) {
                return true;
            }
        }
        return false;
    }

    public final void realTimeDownload(@NotNull DownloadParam downloadParams, @Nullable ISoLoadResService.OnGetPathListener callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) downloadParams, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        b bVar = new b(downloadParams, callback);
        if (TextUtils.isEmpty(downloadParams.filePath)) {
            downloadParams.filePath = getFilePath(downloadParams.url);
        }
        SoDownloadManager.INSTANCE.a().h(downloadParams, bVar, null);
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    public void removeResInfo(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) url);
            return;
        }
        if (url != null) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            Companion companion = INSTANCE;
            from.removeKey(companion.c(url));
            from.removeKey(companion.b(url));
        }
    }

    public final void unzip(@Nullable String filePath, @Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) filePath, (Object) url);
        } else {
            if (TextUtils.isEmpty(filePath)) {
                return;
            }
            checkFolderAndUnzip(filePath, getFolderPath(url, filePath));
        }
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    public synchronized boolean unzipAtomically(@Nullable String filePath, @Nullable String folderPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) filePath, (Object) folderPath)).booleanValue();
        }
        boolean z16 = false;
        if (!TextUtils.isEmpty(filePath) && !TextUtils.isEmpty(folderPath)) {
            Intrinsics.checkNotNull(folderPath);
            if (isDiskEnoughToUnzip(folderPath)) {
                Intrinsics.checkNotNull(filePath);
                z16 = doUnzipAtomically(filePath, folderPath);
            }
            return z16;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.soload.api.ISoLoadResService
    public void updateResInfo(@Nullable String url, @Nullable String md5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) url, (Object) md5);
            return;
        }
        Companion companion = INSTANCE;
        companion.f(url, md5);
        companion.e(url, NetConnInfoCenter.getServerTimeMillis());
    }

    private final boolean doUnzip(String zipPath, String destinationPath, boolean isCreateTmp) {
        QZipFile qZipFile;
        File file = new File(zipPath);
        QZipFile qZipFile2 = null;
        try {
            qZipFile = new QZipFile(file);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            Enumeration<? extends ZipEntry> entries = qZipFile.entries();
            Intrinsics.checkNotNullExpressionValue(entries, "zipfile.entries()");
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                Intrinsics.checkNotNull(nextElement, "null cannot be cast to non-null type java.util.zip.ZipEntry");
                unzipEntry(qZipFile, nextElement, destinationPath, isCreateTmp);
            }
            try {
                qZipFile.close();
            } catch (Throwable th6) {
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", th6);
            }
            return true;
        } catch (Throwable th7) {
            th = th7;
            qZipFile2 = qZipFile;
            try {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "Error while extracting file " + file + th);
                }
                if (qZipFile2 == null) {
                    return false;
                }
                try {
                    qZipFile2.close();
                    return false;
                } catch (Throwable th8) {
                    QLog.e(TAG, 1, "error msg in qqpay-impl module: ", th8);
                    return false;
                }
            } catch (Throwable th9) {
                if (qZipFile2 != null) {
                    try {
                        qZipFile2.close();
                    } catch (Throwable th10) {
                        QLog.e(TAG, 1, "error msg in qqpay-impl module: ", th10);
                    }
                }
                throw th9;
            }
        }
    }
}
