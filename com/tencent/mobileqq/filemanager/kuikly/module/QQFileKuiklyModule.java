package com.tencent.mobileqq.filemanager.kuikly.module;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.highway.transaction.Tracker;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import i01.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0002\u000f\u001cB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J=\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0010\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0011\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0012\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0013\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0014\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/filemanager/kuikly/module/QQFileKuiklyModule;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "g", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "fileEntity", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "d", "l", "i", "method", "call", "Lorg/json/JSONObject;", "paramsJSON", "c", "<init>", "()V", "DownloadStatus", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQFileKuiklyModule extends e {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0082\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/filemanager/kuikly/module/QQFileKuiklyModule$DownloadStatus;", "", "", DetailMeFragmentConfig.CURRENT_STATUS_ID, "I", "getStatusId", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "UNDOWNLOAD", "DOWNLOADING", "CANCEL", "DOWNDONE", Tracker.FAIL, "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public enum DownloadStatus {
        UNDOWNLOAD(0),
        DOWNLOADING(1),
        CANCEL(2),
        DOWNDONE(3),
        FAIL(4);


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int statusId;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/filemanager/kuikly/module/QQFileKuiklyModule$DownloadStatus$a;", "", "", DetailMeFragmentConfig.CURRENT_STATUS_ID, "Lcom/tencent/mobileqq/filemanager/kuikly/module/QQFileKuiklyModule$DownloadStatus;", "a", "<init>", "()V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.filemanager.kuikly.module.QQFileKuiklyModule$DownloadStatus$a, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final DownloadStatus a(int statusId) {
                DownloadStatus downloadStatus;
                boolean z16;
                DownloadStatus[] values = DownloadStatus.values();
                int length = values.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        downloadStatus = values[i3];
                        if (downloadStatus.getStatusId() == statusId) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                        i3++;
                    } else {
                        downloadStatus = null;
                        break;
                    }
                }
                if (downloadStatus == null) {
                    return DownloadStatus.UNDOWNLOAD;
                }
                return downloadStatus;
            }

            Companion() {
            }
        }

        DownloadStatus(int i3) {
            this.statusId = i3;
        }

        public final int getStatusId() {
            return this.statusId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0014JD\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0014\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/filemanager/kuikly/module/QQFileKuiklyModule$b", "Lcom/tencent/mobileqq/filemanager/app/FMObserver;", "", "isShowCancel", "", "uniseq", "sessionId", "", "strUin", "", "peerType", "", "T", "isSuccess", "errCode", "retMsg", ExifInterface.LATITUDE_SOUTH, "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends FMObserver {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f208634e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IQQFileDataCenter f208635f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ WeakReference<Function1<Object, Unit>> f208636h;

        b(FileManagerEntity fileManagerEntity, IQQFileDataCenter iQQFileDataCenter, WeakReference<Function1<Object, Unit>> weakReference) {
            this.f208634e = fileManagerEntity;
            this.f208635f = iQQFileDataCenter;
            this.f208636h = weakReference;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void S(boolean isSuccess, long uniseq, long sessionId, @Nullable String strUin, int peerType, int errCode, @Nullable String retMsg) {
            FileManagerEntity fileManagerEntity;
            DownloadStatus downloadStatus;
            float f16;
            Function1<Object, Unit> function1;
            if (this.f208634e.nSessionId != sessionId) {
                return;
            }
            if (!isSuccess && errCode == 17) {
                QLog.d("QQFileKuiklyModule", 2, "onFileTransferEnd: C2C_VIDEO_DOWNLOAD_CANCEL");
                return;
            }
            IQQFileDataCenter iQQFileDataCenter = this.f208635f;
            Float f17 = null;
            if (iQQFileDataCenter != null) {
                fileManagerEntity = iQQFileDataCenter.queryBySessionId(sessionId);
            } else {
                fileManagerEntity = null;
            }
            if (isSuccess) {
                downloadStatus = DownloadStatus.DOWNDONE;
            } else {
                downloadStatus = DownloadStatus.FAIL;
            }
            int statusId = downloadStatus.getStatusId();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", isSuccess);
            jSONObject.put("uuid", this.f208634e.Uuid);
            jSONObject.put("isDownloading", false);
            jSONObject.put(VirtualAppProxy.KEY_DOWNLOAD_STATUS, String.valueOf(statusId));
            if (isSuccess) {
                f16 = 1.0f;
            } else {
                if (fileManagerEntity != null) {
                    f16 = fileManagerEntity.fProgress;
                }
                jSONObject.put("process", f17);
                function1 = this.f208636h.get();
                if (function1 != null) {
                    function1.invoke(jSONObject);
                }
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this);
                QLog.d("QQFileKuiklyModule", 2, "onFileTransferEnd: isSuccess :" + isSuccess);
            }
            f17 = Float.valueOf(f16);
            jSONObject.put("process", f17);
            function1 = this.f208636h.get();
            if (function1 != null) {
            }
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this);
            QLog.d("QQFileKuiklyModule", 2, "onFileTransferEnd: isSuccess :" + isSuccess);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void T(boolean isShowCancel, long uniseq, long sessionId, @Nullable String strUin, int peerType) {
            FileManagerEntity fileManagerEntity;
            if (this.f208634e.nSessionId != sessionId) {
                return;
            }
            IQQFileDataCenter iQQFileDataCenter = this.f208635f;
            Float f16 = null;
            if (iQQFileDataCenter != null) {
                fileManagerEntity = iQQFileDataCenter.queryBySessionId(sessionId);
            } else {
                fileManagerEntity = null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", true);
            jSONObject.put("uuid", this.f208634e.Uuid);
            if (fileManagerEntity != null) {
                f16 = Float.valueOf(fileManagerEntity.fProgress);
            }
            jSONObject.put("process", f16);
            jSONObject.put("isDownloading", true);
            jSONObject.put(VirtualAppProxy.KEY_DOWNLOAD_STATUS, String.valueOf(DownloadStatus.DOWNLOADING.getStatusId()));
            Function1<Object, Unit> function1 = this.f208636h.get();
            if (function1 != null) {
                function1.invoke(jSONObject);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JD\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/filemanager/kuikly/module/QQFileKuiklyModule$c", "Lcom/tencent/mobileqq/filemanager/app/FMObserver;", "", "isSuccess", "", "uniseq", "sessionId", "", "strUin", "", "peerType", "errCode", "retMsg", "", ExifInterface.LATITUDE_SOUTH, "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends FMObserver {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<FileManagerEntity> f208637e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference<Function1<Object, Unit>> f208638f;

        c(Ref.ObjectRef<FileManagerEntity> objectRef, WeakReference<Function1<Object, Unit>> weakReference) {
            this.f208637e = objectRef;
            this.f208638f = weakReference;
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean isSuccess, long uniseq, long sessionId, @Nullable String strUin, int peerType, int errCode, @Nullable String retMsg) {
            boolean z16;
            String str;
            FileManagerEntity fileManagerEntity = this.f208637e.element;
            if (fileManagerEntity != null && fileManagerEntity.nSessionId == sessionId) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", isSuccess);
            FileManagerEntity fileManagerEntity2 = this.f208637e.element;
            if (fileManagerEntity2 != null) {
                str = fileManagerEntity2.Uuid;
            } else {
                str = null;
            }
            jSONObject.put("uuid", str);
            jSONObject.put("isDownloading", false);
            Function1<Object, Unit> function1 = this.f208638f.get();
            if (function1 != null) {
                function1.invoke(jSONObject);
            }
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteObserver(this);
            QLog.d("QQFileKuiklyModule", 2, "onFileTransferEnd: isSuccess :" + isSuccess);
        }
    }

    private final void a(FileManagerEntity fileEntity, Function1<Object, Unit> callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.w("QQFileKuiklyModule", 1, "addFileObserver: appRuntime empty!");
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IQQFileDataCenter.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).addObserver(new b(fileEntity, (IQQFileDataCenter) runtimeService, new WeakReference(callback)));
    }

    private final void g(String params, Function1<Object, Unit> callback) {
        boolean z16;
        boolean z17 = false;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("QQFileKuiklyModule", 1, "downloadFile: params empty!");
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("uuid");
        if (optString == null || optString.length() == 0) {
            z17 = true;
        }
        if (z17) {
            QLog.w("QQFileKuiklyModule", 1, "downloadFile: uuid empty!");
            return;
        }
        DownloadStatus downloadStatus = DownloadStatus.UNDOWNLOAD;
        DownloadStatus a16 = DownloadStatus.INSTANCE.a(jSONObject.optInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS, downloadStatus.getStatusId()));
        QLog.d("QQFileKuiklyModule", 2, "downloadFile: status is: " + a16);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.w("QQFileKuiklyModule", 1, "downloadFile: appRuntime empty!");
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IQQFileDataCenter.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IQQFileDataCenter iQQFileDataCenter = (IQQFileDataCenter) runtimeService;
        FileManagerEntity queryFileEntityByUuid = iQQFileDataCenter.queryFileEntityByUuid(optString);
        if (queryFileEntityByUuid == null) {
            QLog.d("QQFileKuiklyModule", 2, "downloadFile: queryByUuid fail!");
            queryFileEntityByUuid = c(jSONObject);
        } else {
            QLog.d("QQFileKuiklyModule", 2, "downloadFile: queryByUuid success!");
        }
        if (queryFileEntityByUuid.nFileType == 2) {
            queryFileEntityByUuid.videoDownloadForceThroughNT = true;
            FileManagerEntity queryBySessionId = iQQFileDataCenter.queryBySessionId(queryFileEntityByUuid.nSessionId);
            if (queryBySessionId != null) {
                queryBySessionId.videoDownloadForceThroughNT = true;
            }
        }
        IRuntimeService runtimeService2 = peekAppRuntime.getRuntimeService(IQQFileEngine.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IQQFileEngine iQQFileEngine = (IQQFileEngine) runtimeService2;
        if (a16 == DownloadStatus.DOWNLOADING) {
            iQQFileEngine.pause(queryFileEntityByUuid.nSessionId);
            return;
        }
        if (a16 != DownloadStatus.CANCEL && (a16 != downloadStatus || queryFileEntityByUuid.fProgress <= 0.0f)) {
            a(queryFileEntityByUuid, callback);
            iQQFileEngine.reviceFile(queryFileEntityByUuid);
        } else {
            a(queryFileEntityByUuid, callback);
            iQQFileEngine.resume(queryFileEntityByUuid.nSessionId);
        }
    }

    private final void i(String params, Function1<Object, Unit> callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtime.getRuntimeServic\u2026va, ProcessConstant.MAIN)");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
        iRedTouchManager.onRedTouchItemClick("140130");
        iRedTouchManager.onRedTouchItemClick("100160");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
    
        if (r3 != false) goto L53;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.filemanager.data.FileManagerEntity, T] */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.tencent.mobileqq.filemanager.data.FileManagerEntity, T] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.tencent.mobileqq.filemanager.data.FileManagerEntity, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(String params, Function1<Object, Unit> callback) {
        boolean z16;
        boolean z17;
        boolean z18;
        ?? queryBySessionId;
        boolean z19;
        int i3;
        String str;
        boolean z26;
        boolean z27 = false;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("QQFileKuiklyModule", 1, "openFileBrowser: params empty!");
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("uuid");
        if (optString != null && optString.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            QLog.w("QQFileKuiklyModule", 1, "openFileBrowser: uuid empty!");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.w("QQFileKuiklyModule", 1, "openFileBrowser: appRuntime empty!");
            return;
        }
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IQQFileDataCenter.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IQQFileDataCenter iQQFileDataCenter = (IQQFileDataCenter) runtimeService;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? queryFileEntityByUuid = iQQFileDataCenter.queryFileEntityByUuid(optString);
        objectRef.element = queryFileEntityByUuid;
        if (queryFileEntityByUuid == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            QLog.d("QQFileKuiklyModule", 2, "openFileBrowser: queryByUuid fail!");
            objectRef.element = c(jSONObject);
        } else {
            QLog.d("QQFileKuiklyModule", 2, "openFileBrowser: queryByUuid success!");
            FileManagerEntity fileManagerEntity = (FileManagerEntity) objectRef.element;
            if (fileManagerEntity != null && (queryBySessionId = iQQFileDataCenter.queryBySessionId(fileManagerEntity.nSessionId)) != 0) {
                objectRef.element = queryBySessionId;
            }
        }
        c cVar = new c(objectRef, new WeakReference(callback));
        T t16 = objectRef.element;
        FileManagerEntity fileManagerEntity2 = (FileManagerEntity) t16;
        if (fileManagerEntity2 != null && fileManagerEntity2.nFileType == 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z19) {
            FileManagerEntity fileManagerEntity3 = (FileManagerEntity) t16;
            if (fileManagerEntity3 != null && fileManagerEntity3.nFileType == 2) {
                z26 = true;
            } else {
                z26 = false;
            }
        }
        if (z18) {
            QLog.w("QQFileKuiklyModule", 1, "openFileBrowser\uff1aimage or video MessageNotFound");
            FileManagerEntity fileManagerEntity4 = (FileManagerEntity) objectRef.element;
            if (fileManagerEntity4 != null && fileManagerEntity4.nFileType == 0) {
                z27 = true;
            }
            if (z27) {
                i3 = 5;
            } else {
                i3 = 6;
            }
            ReportController.o(baseQQAppInterface, "dc00898", "", "", "0X800B62F", "0X800B62F", i3, 0, "", "", "", "");
            return;
        }
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).addObserver(cVar);
        IQQFileTempUtils iQQFileTempUtils = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
        Activity activity = getActivity();
        T t17 = objectRef.element;
        FileManagerEntity fileManagerEntity5 = (FileManagerEntity) t17;
        FileManagerEntity fileManagerEntity6 = (FileManagerEntity) t17;
        if (fileManagerEntity6 != null) {
            str = fileManagerEntity6.peerUin;
        } else {
            str = null;
        }
        iQQFileTempUtils.openRencentFileBrowserOnItemClick(baseQQAppInterface, activity, fileManagerEntity5, false, str, null, true, false, 6);
    }

    private final void m(String params, Function1<Object, Unit> callback) {
        boolean z16;
        boolean z17 = false;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("QQFileKuiklyModule", 1, "shareFile: params empty!");
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("uuid");
        if (optString == null || optString.length() == 0) {
            z17 = true;
        }
        if (z17) {
            QLog.w("QQFileKuiklyModule", 1, "shareFile: uuid empty!");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.w("QQFileKuiklyModule", 1, "shareFile: appRuntime empty!");
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IQQFileDataCenter.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        FileManagerEntity queryFileEntityByUuid = ((IQQFileDataCenter) runtimeService).queryFileEntityByUuid(optString);
        if (queryFileEntityByUuid == null) {
            QLog.d("QQFileKuiklyModule", 2, "shareFile: queryByUuid fail!");
            queryFileEntityByUuid = c(jSONObject);
        } else {
            QLog.d("QQFileKuiklyModule", 2, "shareFile: queryByUuid success!");
        }
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).forwardFile(getActivity(), queryFileEntityByUuid);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("result", true);
        if (callback != null) {
            callback.invoke(jSONObject2);
        }
    }

    @NotNull
    public final FileManagerEntity c(@NotNull JSONObject paramsJSON) {
        boolean z16;
        Intrinsics.checkNotNullParameter(paramsJSON, "paramsJSON");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        OfflineFileInfo offlineFileInfo = new OfflineFileInfo();
        offlineFileInfo.f207721e = paramsJSON.optString("uuid", "");
        offlineFileInfo.f207725m = paramsJSON.optString(WadlProxyConsts.PARAM_FILENAME, "");
        offlineFileInfo.E = paramsJSON.optLong(PhotoCategorySinglePicInfo.UPLOAD_TIME, 0L) * 1000;
        offlineFileInfo.D = paramsJSON.optLong("lifeTime", 0L);
        offlineFileInfo.C = paramsJSON.optLong("fileSize", 0L);
        offlineFileInfo.f207722f = paramsJSON.optString("fileIdCrc", "");
        offlineFileInfo.F = paramsJSON.optString("md5", "");
        long optLong = paramsJSON.optLong("ownerUin", 0L);
        if (peekAppRuntime != null && optLong == peekAppRuntime.getLongAccountUin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        offlineFileInfo.f207720d = z16;
        if (z16) {
            optLong = paramsJSON.optLong("peerUin", 0L);
        }
        offlineFileInfo.f207723h = optLong;
        FileManagerEntity fileEntity = ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).newEntityByOfflineFileInfo(offlineFileInfo, 0);
        fileEntity.str10Md5 = paramsJSON.optString("md5_10m", "");
        fileEntity.strFileSHA = paramsJSON.optString(WidgetCacheLunarData.SHA, "");
        fileEntity.strFileSha3 = paramsJSON.optString("sha_3", "");
        Intrinsics.checkNotNullExpressionValue(fileEntity, "fileEntity");
        return fileEntity;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1582452229:
                if (method.equals("shareFile")) {
                    m(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 102323864:
                if (method.equals("reportBeacon")) {
                    l(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 214399330:
                if (method.equals("openFileBrowser")) {
                    j(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1108651556:
                if (method.equals("downloadFile")) {
                    g(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1764172231:
                if (method.equals("deleteFile")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1837449591:
                if (method.equals("onFileExpiringListPageLaunch")) {
                    i(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    private final void d(String params, Function1<Object, Unit> callback) {
    }

    private final void l(String params, Function1<Object, Unit> callback) {
    }
}
