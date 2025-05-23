package com.tencent.mobileqq.soload.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soload.download.DownloadParam;
import com.tencent.mobileqq.soload.download.ResourceInfo;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001:\u0003%&'J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH&J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\rH&J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018H&J\u0012\u0010 \u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010!\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010#\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/soload/api/ISoLoadResService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkIfClearOldSoVersion", "", "soFileName", "", "curLoadSoPath", "cleanLocalCache", "deleteFile", "filePath", "deleteRes", "url", "isForceUnzip", "", "getCacheMd5", "defValue", "getFilePath", "getResInfoByUrl", "Lcom/tencent/mobileqq/soload/download/ResourceInfo;", "isUnzipDefault", "getResMd5", "getResMd5UseCache", "getResPath", "param", "Lcom/tencent/mobileqq/soload/download/DownloadParam;", "listener", "Lcom/tencent/mobileqq/soload/api/ISoLoadResService$OnGetPathListener;", "getResPathByUrl", "getResPathPrefix", "getResPathSync", "Lcom/tencent/mobileqq/soload/api/ISoLoadResService$PathResult;", "params", "removeResInfo", "unzipAtomically", "folderPath", "updateResInfo", "md5", "OnGetPathListener", "OnGetPathsListener", "PathResult", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISoLoadResService extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/soload/api/ISoLoadResService$OnGetPathListener;", "", "onResult", "", "resCode", "", "pathRes", "Lcom/tencent/mobileqq/soload/api/ISoLoadResService$PathResult;", "Companion", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public interface OnGetPathListener {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final int RES_FAIL = 1;
        public static final int RES_FAIL_MD5_NOT_MATCH = 2;
        public static final int RES_SUCC = 0;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/soload/api/ISoLoadResService$OnGetPathListener$Companion;", "", "()V", "RES_FAIL", "", "RES_FAIL_MD5_NOT_MATCH", "RES_SUCC", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE;
            static IPatchRedirector $redirector_ = null;
            public static final int RES_FAIL = 1;
            public static final int RES_FAIL_MD5_NOT_MATCH = 2;
            public static final int RES_SUCC = 0;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33578);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    $$INSTANCE = new Companion();
                }
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(33579), (Class<?>) OnGetPathListener.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.$$INSTANCE;
            }
        }

        void onResult(int resCode, @Nullable PathResult pathRes);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052.\u0010\u0006\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/soload/api/ISoLoadResService$OnGetPathsListener;", "", "onResult", "", "resCode", "", "resultMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/soload/api/ISoLoadResService$PathResult;", "Lkotlin/collections/HashMap;", "Companion", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public interface OnGetPathsListener {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final int RES_FAIL = 1;
        public static final int RES_SUCC = 0;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/soload/api/ISoLoadResService$OnGetPathsListener$Companion;", "", "()V", "RES_FAIL", "", "RES_SUCC", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE;
            static IPatchRedirector $redirector_ = null;
            public static final int RES_FAIL = 1;
            public static final int RES_SUCC = 0;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33580);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    $$INSTANCE = new Companion();
                }
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(33581), (Class<?>) OnGetPathsListener.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.$$INSTANCE;
            }
        }

        void onResult(int resCode, @Nullable HashMap<String, PathResult> resultMap);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B=\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/soload/api/ISoLoadResService$PathResult;", "Ljava/io/Serializable;", "()V", "filePath", "", "folderPath", "url", "subErrCode", "", "fileSize", "", "downloadCost", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJ)V", "isAlreadyExist", "", "toString", "Companion", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class PathResult implements Serializable {
        static IPatchRedirector $redirector_;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        @JvmField
        public long downloadCost;

        @JvmField
        @Nullable
        public String filePath;

        @JvmField
        public long fileSize;

        @JvmField
        @Nullable
        public String folderPath;

        @JvmField
        public boolean isAlreadyExist;

        @JvmField
        public int subErrCode;

        @JvmField
        @Nullable
        public String url;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J \u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/soload/api/ISoLoadResService$PathResult$Companion;", "", "()V", "getFailRes", "Lcom/tencent/mobileqq/soload/api/ISoLoadResService$PathResult;", "url", "", "subErrCode", "", "fileSize", "", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                    return;
                }
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
            }

            @NotNull
            public final PathResult getFailRes(@Nullable String url) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? getFailRes(url, 0, 0L) : (PathResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }

            @NotNull
            public final PathResult getFailRes(@Nullable String url, int subErrCode, long fileSize) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new PathResult(null, null, url, subErrCode, fileSize, 0L) : (PathResult) iPatchRedirector.redirect((short) 3, this, url, Integer.valueOf(subErrCode), Long.valueOf(fileSize));
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33583);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public PathResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "PathResult(filePath=" + this.filePath + ", folderPath=" + this.folderPath + ", url=" + this.url + ", isAlreadyExist=" + this.isAlreadyExist + ", subErrCode=" + this.subErrCode + ", fileSize=" + this.fileSize + ", downloadCost=" + this.downloadCost + ')';
        }

        public PathResult(@Nullable String str, @Nullable String str2, @Nullable String str3, int i3, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            this.filePath = str;
            this.folderPath = str2;
            this.url = str3;
            this.subErrCode = i3;
            this.fileSize = j3;
            this.downloadCost = j16;
        }
    }

    void checkIfClearOldSoVersion(@Nullable String soFileName, @Nullable String curLoadSoPath);

    void cleanLocalCache();

    void deleteFile(@Nullable String filePath);

    void deleteRes(@Nullable String url, boolean isForceUnzip);

    @Nullable
    String getCacheMd5(@Nullable String url, @Nullable String defValue);

    @Nullable
    String getFilePath(@Nullable String url);

    @NotNull
    ResourceInfo getResInfoByUrl(@Nullable String url, boolean isUnzipDefault);

    @Nullable
    String getResMd5(@Nullable String filePath);

    @Nullable
    String getResMd5UseCache(@Nullable String url, @Nullable String filePath);

    void getResPath(@Nullable DownloadParam param, @Nullable OnGetPathListener listener);

    @Nullable
    String getResPathByUrl(@Nullable String url);

    @Nullable
    String getResPathPrefix();

    @Nullable
    PathResult getResPathSync(@Nullable DownloadParam params);

    void removeResInfo(@Nullable String url);

    boolean unzipAtomically(@Nullable String filePath, @Nullable String folderPath);

    void updateResInfo(@Nullable String url, @Nullable String md5);
}
