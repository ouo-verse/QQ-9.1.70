package com.tencent.mobileqq.flashtransfer;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.v;
import com.tencent.mobileqq.flashtransfer.FlashTransferFileBrowser;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.q;
import com.tencent.qqnt.kernel.nativeinterface.BasicFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.DownloadErrorFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.File;
import com.tencent.qqnt.kernel.nativeinterface.FileDownLoadInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileSetDownloadTaskStatus;
import com.tencent.qqnt.kernel.nativeinterface.FlashFileSetDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetLocalFileListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceFileTransferCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetLocalFileListCallback;
import com.tencent.qqnt.kernel.nativeinterface.URL;
import com.tencent.qqnt.kernel.nativeinterface.UserDownloadOperationInfo;
import com.tencent.qqnt.kernel.nativeinterface.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 W2\u00020\u0001:\u00011B\t\b\u0002\u00a2\u0006\u0004\bU\u0010VJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J:\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J>\u0010\u0018\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0002J8\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0019j\b\u0012\u0004\u0012\u00020\b`\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0019j\b\u0012\u0004\u0012\u00020\u0006`\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0002JT\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00060\u001ej\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0006` 2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0019j\b\u0012\u0004\u0012\u00020\b`\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0019j\b\u0012\u0004\u0012\u00020\u0006`\u001aH\u0002J(\u0010\"\u001a\u00020\u00102\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0019j\b\u0012\u0004\u0012\u00020\b`\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\nH\u0002J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0002J\u0012\u0010)\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J*\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0019j\b\u0012\u0004\u0012\u00020\u0006`\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010+\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010-\u001a\u0004\u0018\u00010,H\u0016J$\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00060\u001ej\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0006` H\u0016J\u0012\u00100\u001a\u00020/2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u00101\u001a\u00020\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\"\u00107\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R>\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00060\u001ej\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0006` 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R>\u0010@\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00060\u001ej\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0006` 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R$\u0010G\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010M\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010T\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/flashtransfer/FlashTransferFileBrowser;", "Lqb1/d;", "", "params", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/kernel/nativeinterface/File;", "file", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", ReportConstant.COSTREPORT_PREFIX, "", "entityList", "", "curEntityIdx", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "pageFrom", "tencentDocSupportedExt", "l", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fileList", "curEntity", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "D", "E", "r", HippyTKDListViewAdapter.X, "y", "Lorg/json/JSONObject;", "paramsJSON", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "c", "Lcom/tencent/mobileqq/filemanager/util/v;", "d", "b", "", "e", "a", "Z", "getMHasInitedDownload", "()Z", "setMHasInitedDownload", "(Z)V", "mHasInitedDownload", "Ljava/util/HashMap;", UserInfo.SEX_FEMALE, "()Ljava/util/HashMap;", "setMBrowsingFileMap", "(Ljava/util/HashMap;)V", "mBrowsingFileMap", "getMDownloadingFileMap", "setMDownloadingFileMap", "mDownloadingFileMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;", "getMDownloadListener", "()Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;", "setMDownloadListener", "(Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;)V", "mDownloadListener", "Lcom/tencent/mobileqq/filemanager/util/v;", "getMDownloadOper", "()Lcom/tencent/mobileqq/filemanager/util/v;", "setMDownloadOper", "(Lcom/tencent/mobileqq/filemanager/util/v;)V", "mDownloadOper", "f", "J", "getMBrowseStartTimeMs", "()J", "setMBrowseStartTimeMs", "(J)V", "mBrowseStartTimeMs", "<init>", "()V", "g", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlashTransferFileBrowser implements qb1.d {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<FlashTransferFileBrowser> f209853h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mHasInitedDownload;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Long, File> mBrowsingFileMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Long, File> mDownloadingFileMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IFlashTransferServiceDownloadListener mDownloadListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private v mDownloadOper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mBrowseStartTimeMs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0014\u0010\u0016\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\nR\u0014\u0010\u0018\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\n\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/flashtransfer/FlashTransferFileBrowser$a;", "", "Lcom/tencent/mobileqq/flashtransfer/FlashTransferFileBrowser;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/flashtransfer/FlashTransferFileBrowser;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "PARAM_COMPRESSED_FILE_FOLDER_ID", "Ljava/lang/String;", "PARAM_DOWNLOAD_URL", "PARAM_FILESET_ID", "PARAM_FILESET_NAME", "PARAM_FILE_ID", "PARAM_FILE_LIST", "PARAM_FILE_NAME", "PARAM_FILE_SIZE", "PARAM_FILE_TYPE", "PARAM_SAVE_FILE_PATH", "PARAM_SRVFILE_ID", "PARAM_THUMBNAIL_LOCAL_PATH", "PARAM_THUMBNAIL_URL", "PARAM_UUID", "TAG", "<init>", "()V", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flashtransfer.FlashTransferFileBrowser$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final FlashTransferFileBrowser a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FlashTransferFileBrowser) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (FlashTransferFileBrowser) FlashTransferFileBrowser.f209853h.getValue();
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
    @Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\"\u0010\u000f\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J$\u0010\u0012\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0011H\u0016J2\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001e\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0010j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u0001`\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010H\u0016J:\u0010\u0019\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001e\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0010j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J$\u0010\u001a\u001a\u00020\u00062\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0011H\u0016\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/flashtransfer/FlashTransferFileBrowser$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;", "", "filesetId", "Lcom/tencent/qqnt/kernel/nativeinterface/BasicFileInfo;", "file", "", "onProfilerFileDidStartDownload", "Lcom/tencent/qqnt/kernel/nativeinterface/File;", "onFileDidStartDownload", "fileSetId", "", "hasDownLoadedBytes", "totalBytes", "onProfilerFileDownloadProgressChanged", "onFileDownloadProgressChanged", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onFileListDidFinishDownload", "Lcom/tencent/qqnt/kernel/nativeinterface/DownloadErrorFileInfo;", "fileList", "onProfilerFileListDownloadDidError", "onFileListDownloadDidError", "", "reason", "onProfilerFileListDownloadDidCancel", "onFileListDownloadDidCancel", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements IFlashTransferServiceDownloadListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlashTransferFileBrowser.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileDidStartDownload(@Nullable File file) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) file);
                return;
            }
            if (!FlashTransferFileBrowser.this.e(file)) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onFileDidStartDownLoad. fileid: ");
            String str2 = null;
            if (file != null) {
                str = file.cliFileId;
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(", filename: ");
            if (file != null) {
                str2 = file.name;
            }
            sb5.append(str2);
            sb5.append('.');
            QLog.i("FlashTransferFileBrowser", 1, sb5.toString());
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileDownloadDidError(File file, int i3, String str) {
            l.b(this, file, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileDownloadProgressChanged(@Nullable File file, long hasDownLoadedBytes, long totalBytes) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, file, Long.valueOf(hasDownLoadedBytes), Long.valueOf(totalBytes));
                return;
            }
            if (!FlashTransferFileBrowser.this.e(file)) {
                return;
            }
            long a16 = FlashTransferFileBrowser.this.a(file);
            int i3 = (int) ((100 * hasDownLoadedBytes) / totalBytes);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onFileDownLoadProgressChanged. fileid: ");
            String str2 = null;
            if (file != null) {
                str = file.cliFileId;
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(", filename: ");
            if (file != null) {
                str2 = file.name;
            }
            sb5.append(str2);
            sb5.append(", hasDownLoadedBytes: ");
            sb5.append(hasDownLoadedBytes);
            sb5.append(", totalBytes: ");
            sb5.append(totalBytes);
            sb5.append(", progress: ");
            sb5.append(i3);
            sb5.append('.');
            QLog.i("FlashTransferFileBrowser", 1, sb5.toString());
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).notifyFlashTransferDownloadProgress(a16, i3, totalBytes);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileDownloadSpeedChange(File file, int i3, int i16) {
            l.d(this, file, i3, i16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileListDidFinishDownload(@Nullable ArrayList<File> file) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) file);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileListDownloadDidCancel(@Nullable ArrayList<File> fileList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) fileList);
                return;
            }
            if (fileList != null) {
                Iterator<File> it = fileList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    QLog.i("FlashTransferFileBrowser", 1, "onFileDownLoadDidCancel. fileid: " + next.cliFileId + ", filename: " + next.name + '.');
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileListDownloadDidError(@Nullable ArrayList<File> fileList) {
            Integer num;
            String str;
            FileDownLoadInfo fileDownLoadInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) fileList);
                return;
            }
            if (fileList == null) {
                return;
            }
            FlashTransferFileBrowser flashTransferFileBrowser = FlashTransferFileBrowser.this;
            for (File file : fileList) {
                if (!flashTransferFileBrowser.e(file)) {
                    return;
                }
                long a16 = flashTransferFileBrowser.a(file);
                flashTransferFileBrowser.b().remove(Long.valueOf(a16));
                String str2 = null;
                if (file != null && (fileDownLoadInfo = file.downloadInfo) != null) {
                    num = Integer.valueOf(fileDownLoadInfo.errorCode);
                } else {
                    num = null;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onFileListDownloadDidError. fileid: ");
                if (file != null) {
                    str = file.cliFileId;
                } else {
                    str = null;
                }
                sb5.append(str);
                sb5.append(", filename: ");
                if (file != null) {
                    str2 = file.name;
                }
                sb5.append(str2);
                sb5.append(", errorCode: ");
                sb5.append(num);
                sb5.append('.');
                QLog.i("FlashTransferFileBrowser", 1, sb5.toString());
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).notifyFlashTransferDownloadResult(a16, false, "");
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileListDownloadDidPause(ArrayList arrayList) {
            l.h(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileListDownloadWaitDownloading(ArrayList arrayList) {
            l.i(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileSetDownloadTaskProgressChanged(String str, FlashFileSetDownloadInfo flashFileSetDownloadInfo) {
            l.j(this, str, flashFileSetDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileSetDownloadTaskStatusChange(FileSetDownloadTaskStatus fileSetDownloadTaskStatus, String str, FlashFileSetDownloadInfo flashFileSetDownloadInfo) {
            l.k(this, fileSetDownloadTaskStatus, str, flashFileSetDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileDidStartDownload(@Nullable String filesetId, @Nullable BasicFileInfo file) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) filesetId, (Object) file);
                return;
            }
            File file2 = new File();
            file2.fileSetId = filesetId;
            String str2 = null;
            if (file != null) {
                str = file.fileId;
            } else {
                str = null;
            }
            file2.cliFileId = str;
            if (file != null) {
                str2 = file.compressId;
            }
            file2.compressedFileFolderId = str2;
            onFileDidStartDownload(file2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileDownloadProgressChanged(@Nullable String fileSetId, @Nullable BasicFileInfo file, long hasDownLoadedBytes, long totalBytes) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, fileSetId, file, Long.valueOf(hasDownLoadedBytes), Long.valueOf(totalBytes));
                return;
            }
            File file2 = new File();
            file2.fileSetId = fileSetId;
            String str2 = null;
            if (file != null) {
                str = file.fileId;
            } else {
                str = null;
            }
            file2.cliFileId = str;
            if (file != null) {
                str2 = file.compressId;
            }
            file2.compressedFileFolderId = str2;
            onFileDownloadProgressChanged(file2, hasDownLoadedBytes, totalBytes);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onProfilerFileListDidFinishDownload(String str, ArrayList arrayList) {
            l.n(this, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileListDownloadDidCancel(@Nullable String filesetId, @Nullable ArrayList<BasicFileInfo> fileList, int reason) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, filesetId, fileList, Integer.valueOf(reason));
                return;
            }
            if (fileList == null) {
                return;
            }
            ArrayList<File> arrayList = new ArrayList<>();
            Iterator<BasicFileInfo> it = fileList.iterator();
            while (it.hasNext()) {
                BasicFileInfo next = it.next();
                File file = new File();
                file.fileSetId = filesetId;
                if (next != null) {
                    str = next.fileId;
                } else {
                    str = null;
                }
                file.cliFileId = str;
                arrayList.add(file);
            }
            onFileListDownloadDidCancel(arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileListDownloadDidError(@Nullable String filesetId, @Nullable ArrayList<DownloadErrorFileInfo> fileList) {
            String str;
            BasicFileInfo basicFileInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) filesetId, (Object) fileList);
                return;
            }
            if (fileList == null) {
                return;
            }
            ArrayList<File> arrayList = new ArrayList<>();
            Iterator<DownloadErrorFileInfo> it = fileList.iterator();
            while (it.hasNext()) {
                DownloadErrorFileInfo next = it.next();
                File file = new File();
                file.fileSetId = filesetId;
                if (next != null && (basicFileInfo = next.fileInfo) != null) {
                    str = basicFileInfo.fileId;
                } else {
                    str = null;
                }
                file.cliFileId = str;
                arrayList.add(file);
            }
            onFileListDownloadDidError(arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onProfilerFileListDownloadDidPause(String str, ArrayList arrayList, int i3) {
            l.q(this, str, arrayList, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onProfilerFileListDownloadWaitDownloading(String str, ArrayList arrayList) {
            l.r(this, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onThumbnailDownloadResult(ArrayList arrayList) {
            l.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onUserDownloadOperationResultNotify(UserDownloadOperationInfo userDownloadOperationInfo) {
            l.t(this, userDownloadOperationInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/flashtransfer/FlashTransferFileBrowser$c", "Lcom/tencent/mobileqq/filemanager/util/v;", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "", "a", "", "b", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements v {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlashTransferFileBrowser.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void d(Ref.ObjectRef file, Ref.ObjectRef filelist, GetLocalFileListRsp getLocalFileListRsp) {
            AppInterface appInterface;
            IKernelService iKernelService;
            q flashTransferService;
            ArrayList<File> arrayList;
            Intrinsics.checkNotNullParameter(file, "$file");
            Intrinsics.checkNotNullParameter(filelist, "$filelist");
            if (getLocalFileListRsp != null && getLocalFileListRsp.result == 0 && (arrayList = getLocalFileListRsp.fileList) != null && arrayList.size() > 0) {
                ((File) file.element).srvFileId = getLocalFileListRsp.fileList.get(0).srvFileId;
                ((File) file.element).fileType = getLocalFileListRsp.fileList.get(0).fileType;
                QLog.i("FlashTransferFileBrowser", 1, "requestDownload. GetLocalFileListCallback. fileName:" + getLocalFileListRsp.fileList.get(0).name + ", srvFileId:" + ((File) file.element).srvFileId + ", fileType:" + ((File) file.element).fileType);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null && (iKernelService = (IKernelService) appInterface.getRuntimeService(IKernelService.class, "all")) != null && (flashTransferService = iKernelService.getFlashTransferService()) != null) {
                String str = ((File) file.element).fileSetId;
                Intrinsics.checkNotNullExpressionValue(str, "file.fileSetId");
                flashTransferService.K(str, (ArrayList) filelist.element);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v9, types: [T, java.util.ArrayList] */
        @Override // com.tencent.mobileqq.filemanager.util.v
        public boolean a(@NotNull FileManagerEntity entity) {
            AppInterface appInterface;
            IKernelService iKernelService;
            q flashTransferService;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entity)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(entity, "entity");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? r16 = FlashTransferFileBrowser.this.F().get(Long.valueOf(entity.nSessionId));
            objectRef.element = r16;
            if (r16 == 0) {
                return false;
            }
            if (FlashTransferFileBrowser.this.e((File) r16)) {
                return true;
            }
            QLog.i("FlashTransferFileBrowser", 1, "requestDownload. uuid: " + ((File) objectRef.element).physical.f359199id + ", fileid: " + ((File) objectRef.element).cliFileId + ", filename: " + ((File) objectRef.element).name + '.');
            FlashTransferFileBrowser.this.b().put(Long.valueOf(entity.nSessionId), objectRef.element);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ?? arrayList = new ArrayList();
            objectRef2.element = arrayList;
            arrayList.add(objectRef.element);
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(((File) objectRef.element).cliFileId);
            IFlashTransferServiceGetLocalFileListCallback iFlashTransferServiceGetLocalFileListCallback = new IFlashTransferServiceGetLocalFileListCallback() { // from class: com.tencent.mobileqq.flashtransfer.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetLocalFileListCallback
                public final void onGetLocalFileList(GetLocalFileListRsp getLocalFileListRsp) {
                    FlashTransferFileBrowser.c.d(Ref.ObjectRef.this, objectRef2, getLocalFileListRsp);
                }
            };
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null && (iKernelService = (IKernelService) appInterface.getRuntimeService(IKernelService.class, "all")) != null && (flashTransferService = iKernelService.getFlashTransferService()) != null) {
                flashTransferService.getLocalFileList(0, ((File) objectRef.element).fileSetId, arrayList2, iFlashTransferServiceGetLocalFileListCallback);
            }
            return true;
        }

        @Override // com.tencent.mobileqq.filemanager.util.v
        public void b(@NotNull FileManagerEntity entity) {
            AppInterface appInterface;
            IKernelService iKernelService;
            q flashTransferService;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) entity);
                return;
            }
            Intrinsics.checkNotNullParameter(entity, "entity");
            File file = FlashTransferFileBrowser.this.F().get(Long.valueOf(entity.nSessionId));
            if (file == null || !FlashTransferFileBrowser.this.e(file)) {
                return;
            }
            QLog.i("FlashTransferFileBrowser", 1, "cancelDownload. uuid: " + file.physical.f359199id + ", fileid: " + file.cliFileId + ", filename: " + file.name + '.');
            TypeIntrinsics.asMutableMap(FlashTransferFileBrowser.this.b()).remove(Long.valueOf(entity.nSessionId));
            ArrayList<File> arrayList = new ArrayList<>();
            arrayList.add(file);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null && (iKernelService = (IKernelService) appInterface.getRuntimeService(IKernelService.class, "all")) != null && (flashTransferService = iKernelService.getFlashTransferService()) != null) {
                String str = file.fileSetId;
                Intrinsics.checkNotNullExpressionValue(str, "file.fileSetId");
                flashTransferService.H(str, arrayList);
            }
        }
    }

    static {
        Lazy<FlashTransferFileBrowser> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19199);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(FlashTransferFileBrowser$Companion$instance$2.INSTANCE);
        f209853h = lazy;
    }

    public /* synthetic */ FlashTransferFileBrowser(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, (Object) this, (Object) defaultConstructorMarker);
    }

    private final File A(String params) {
        try {
            return B(new JSONObject(params));
        } catch (JSONException e16) {
            QLog.e("FlashTransferFileBrowser", 1, "convertToFile err: ", e16);
            return new File();
        }
    }

    private final File B(JSONObject paramsJSON) {
        File file = new File();
        file.fileSetId = paramsJSON.optString("fileSetId");
        file.cliFileId = paramsJSON.optString("fileId");
        file.name = paramsJSON.optString(WadlProxyConsts.PARAM_FILENAME);
        file.fileSize = paramsJSON.optLong("fileSize", 0L);
        file.saveFilePath = paramsJSON.optString("saveFilePath");
        file.physical.f359199id = paramsJSON.optString("uuid");
        file.srvFileId = paramsJSON.optString("srvFileId");
        URL url = new URL();
        url.url = paramsJSON.optString("thumbnailUrl");
        file.thumbnail.urls.add(url);
        file.thumbnail.localCachePath = paramsJSON.optString("thumbnailLocalPath");
        file.compressedFileFolderId = paramsJSON.optString("compressedFileFolderId");
        return file;
    }

    private final ArrayList<File> C(String params, File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(params).optJSONArray("fileList");
            Intrinsics.checkNotNullExpressionValue(optJSONArray, "paramsJSON.optJSONArray(PARAM_FILE_LIST)");
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "fileListJSON.getJSONObject(i)");
                File B = B(jSONObject);
                if (((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).getFileType(B.name) == 0 && (TextUtils.isEmpty(B.compressedFileFolderId) || FileUtils.fileExists(B.saveFilePath))) {
                    arrayList.add(B);
                }
            }
            return arrayList;
        } catch (JSONException e16) {
            QLog.e("FlashTransferFileBrowser", 1, "convertToFileList err: ", e16);
            arrayList.clear();
            arrayList.add(file);
            return arrayList;
        }
    }

    private final HashMap<Long, File> D(ArrayList<FileManagerEntity> entityList, ArrayList<File> fileList) {
        HashMap<Long, File> hashMap = new HashMap<>();
        if (entityList.size() != fileList.size()) {
            return hashMap;
        }
        int size = entityList.size();
        for (int i3 = 0; i3 < size; i3++) {
            FileManagerEntity fileManagerEntity = entityList.get(i3);
            Intrinsics.checkNotNullExpressionValue(fileManagerEntity, "entityList[i]");
            File file = fileList.get(i3);
            Intrinsics.checkNotNullExpressionValue(file, "fileList[i]");
            hashMap.put(Long.valueOf(fileManagerEntity.nSessionId), file);
        }
        return hashMap;
    }

    private final int E(ArrayList<FileManagerEntity> entityList, FileManagerEntity curEntity) {
        Iterator<FileManagerEntity> it = entityList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().Uuid.equals(curEntity.Uuid)) {
                return i3;
            }
            i3++;
        }
        return 0;
    }

    private final void l(Context context, List<? extends FileManagerEntity> entityList, int curEntityIdx, int pageFrom, String tencentDocSupportedExt) {
        BaseQQAppInterface baseQQAppInterface;
        String str;
        FileManagerEntity fileManagerEntity;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Integer num = null;
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("browseFile end. filename: ");
        if (entityList != null && (fileManagerEntity = entityList.get(0)) != null) {
            str = fileManagerEntity.fileName;
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(", curEntityIdx: ");
        sb5.append(curEntityIdx);
        sb5.append(", entityListSize: ");
        if (entityList != null) {
            num = Integer.valueOf(entityList.size());
        }
        sb5.append(num);
        sb5.append(", time_len_ms: ");
        sb5.append(System.currentTimeMillis() - this.mBrowseStartTimeMs);
        sb5.append('.');
        QLog.i("FlashTransferFileBrowser", 1, sb5.toString());
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).browseFlashTransferFile(baseQQAppInterface, context, entityList, curEntityIdx, 7, tencentDocSupportedExt);
    }

    private final void m(final String params, final Activity activity, final File file, final FileManagerEntity entity) {
        if (!FileUtils.fileExists(entity.getFilePath())) {
            if (FileUtils.fileExists(file.thumbnail.localCachePath)) {
                entity.strMiddleThumPath = file.thumbnail.localCachePath;
            } else {
                StringBuilder sb5 = new StringBuilder();
                IFlashTransferApi iFlashTransferApi = (IFlashTransferApi) QRoute.api(IFlashTransferApi.class);
                String str = entity.fileSetId;
                Intrinsics.checkNotNullExpressionValue(str, "entity.fileSetId");
                sb5.append(iFlashTransferApi.getThumbImgSaveRootDirectory(str));
                sb5.append('/');
                sb5.append(entity.fileName);
                final String sb6 = sb5.toString();
                if (FileUtils.fileExists(sb6)) {
                    entity.strMiddleThumPath = sb6;
                } else {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            FlashTransferFileBrowser.n(FileManagerEntity.this, file, sb6, this, params, activity);
                        }
                    }, 128, null, true);
                    return;
                }
            }
        }
        entity.strLargeThumPath = entity.strMiddleThumPath;
        o(params, activity, file, entity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(FileManagerEntity entity, File file, String localPath, FlashTransferFileBrowser this$0, String params, Activity activity) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(localPath, "$localPath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        long currentTimeMillis = System.currentTimeMillis();
        entity.strMiddleThumPath = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).downloadThumbImage(file.thumbnail.urls.get(0).url, localPath);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 20) {
            QLog.i("FlashTransferFileBrowser", 1, "browseFile. downloadThumbImage end. timeLenMs: " + currentTimeMillis2 + '.');
        }
        entity.strLargeThumPath = entity.strMiddleThumPath;
        this$0.o(params, activity, file, entity);
    }

    private final void o(final String params, final Activity activity, final File file, final FileManagerEntity entity) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.f
            @Override // java.lang.Runnable
            public final void run() {
                FlashTransferFileBrowser.p(FlashTransferFileBrowser.this, params, file, entity, activity);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(FlashTransferFileBrowser this$0, String params, File file, FileManagerEntity entity, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        ArrayList<File> C = this$0.C(params, file);
        ArrayList<FileManagerEntity> z16 = this$0.z(C, entity);
        int E = this$0.E(z16, entity);
        this$0.mBrowsingFileMap = this$0.D(z16, C);
        this$0.l(activity, z16, E, 7, "");
    }

    private final void q(String params, Activity activity, File file, FileManagerEntity entity) {
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(file);
        arrayList2.add(entity);
        this.mBrowsingFileMap.put(Long.valueOf(entity.nSessionId), file);
        if (entity.cloudType != 3) {
            String tencentDocSupportedExtension = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getTencentDocSupportedExtension(entity.fileName);
            if (!TextUtils.isEmpty(tencentDocSupportedExtension)) {
                if (TextUtils.isEmpty(file.compressedFileFolderId)) {
                    entity.Uuid = "fileSetId=" + file.fileSetId + "&fileId=" + file.srvFileId;
                }
            }
            str = tencentDocSupportedExtension;
            l(activity, arrayList2, 0, 7, str);
        }
        str = "";
        l(activity, arrayList2, 0, 7, str);
    }

    private final void r() {
        AppInterface appInterface;
        IKernelService iKernelService;
        q flashTransferService;
        if (!this.mHasInitedDownload) {
            this.mHasInitedDownload = true;
            this.mDownloadListener = new b();
            this.mDownloadOper = new c();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null && (iKernelService = (IKernelService) appInterface.getRuntimeService(IKernelService.class, "all")) != null && (flashTransferService = iKernelService.getFlashTransferService()) != null) {
                IFlashTransferServiceDownloadListener iFlashTransferServiceDownloadListener = this.mDownloadListener;
                Intrinsics.checkNotNull(iFlashTransferServiceDownloadListener, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener");
                flashTransferService.addFileSetDownloadListener(iFlashTransferServiceDownloadListener);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
    private final void s(String params, final Activity activity, final File file, final FileManagerEntity entity) {
        ArrayList arrayList = new ArrayList();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        final Ref.IntRef intRef = new Ref.IntRef();
        arrayList.add(file);
        ((ArrayList) objectRef.element).add(entity);
        intRef.element = 0;
        this.mBrowsingFileMap.put(Long.valueOf(entity.nSessionId), file);
        if (entity.cloudType == 3) {
            l(activity, (List) objectRef.element, intRef.element, 7, "");
            return;
        }
        if (FileUtils.fileExists(file.thumbnail.localCachePath)) {
            entity.strMiddleThumPath = file.thumbnail.localCachePath;
        } else {
            StringBuilder sb5 = new StringBuilder();
            IFlashTransferApi iFlashTransferApi = (IFlashTransferApi) QRoute.api(IFlashTransferApi.class);
            String str = entity.fileSetId;
            Intrinsics.checkNotNullExpressionValue(str, "entity.fileSetId");
            sb5.append(iFlashTransferApi.getThumbImgSaveRootDirectory(str));
            sb5.append('/');
            sb5.append(entity.fileName);
            final String sb6 = sb5.toString();
            if (FileUtils.fileExists(sb6)) {
                entity.strMiddleThumPath = sb6;
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlashTransferFileBrowser.t(FileManagerEntity.this, file, sb6, this, activity, objectRef, intRef);
                    }
                }, 128, null, true);
                return;
            }
        }
        entity.strLargeThumPath = entity.strMiddleThumPath;
        u(activity, file, entity, (List) objectRef.element, intRef.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(FileManagerEntity entity, File file, String localPath, FlashTransferFileBrowser this$0, Activity activity, Ref.ObjectRef entityList, Ref.IntRef curEntityIdx) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(localPath, "$localPath");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(entityList, "$entityList");
        Intrinsics.checkNotNullParameter(curEntityIdx, "$curEntityIdx");
        long currentTimeMillis = System.currentTimeMillis();
        entity.strMiddleThumPath = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).downloadThumbImage(file.thumbnail.urls.get(0).url, localPath);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 20) {
            QLog.i("FlashTransferFileBrowser", 1, "browseFile. downloadThumbImage end. timeLenMs: " + currentTimeMillis2 + '.');
        }
        entity.strLargeThumPath = entity.strMiddleThumPath;
        this$0.u(activity, file, entity, (List) entityList.element, curEntityIdx.element);
    }

    private final void u(final Activity activity, final File file, final FileManagerEntity entity, final List<? extends FileManagerEntity> entityList, final int curEntityIdx) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.e
            @Override // java.lang.Runnable
            public final void run() {
                FlashTransferFileBrowser.v(File.this, entity, this, activity, entityList, curEntityIdx);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(File file, final FileManagerEntity entity, final FlashTransferFileBrowser this$0, final Activity activity, final List list, final int i3) {
        BaseQQAppInterface baseQQAppInterface;
        q flashTransferService;
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        QLog.i("FlashTransferFileBrowser", 1, "browseFile. startFileTransferUrl.");
        IKernelService iKernelService = (IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "all");
        if (iKernelService != null && (flashTransferService = iKernelService.getFlashTransferService()) != null) {
            flashTransferService.startFileTransferUrl(file, new IFlashTransferServiceFileTransferCallback() { // from class: com.tencent.mobileqq.flashtransfer.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceFileTransferCallback
                public final void onTransferResult(int i16, String str, long j3) {
                    FlashTransferFileBrowser.w(FileManagerEntity.this, this$0, activity, list, i3, i16, str, j3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(FileManagerEntity entity, FlashTransferFileBrowser this$0, Activity activity, List list, int i3, int i16, String str, long j3) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QLog.i("FlashTransferFileBrowser", 1, "browseFile. startFileTransferUrl. onTransferResult. ret: " + i16 + ", url: " + str + '.');
        if (i16 == 0) {
            entity.setFilePath(str);
        }
        this$0.l(activity, list, i3, 7, "");
    }

    private final void x() {
        this.mBrowsingFileMap.clear();
    }

    private final void y() {
        this.mDownloadingFileMap.clear();
    }

    private final ArrayList<FileManagerEntity> z(ArrayList<File> fileList, FileManagerEntity curEntity) {
        boolean equals;
        long currentTimeMillis = System.currentTimeMillis();
        QLog.i("FlashTransferFileBrowser", 1, "browseFile. convertToEntityList start. fileList.size: " + fileList.size());
        ArrayList<FileManagerEntity> arrayList = new ArrayList<>();
        if (fileList.size() == 0) {
            arrayList.add(curEntity);
            return arrayList;
        }
        IFlashTransferApi iFlashTransferApi = (IFlashTransferApi) QRoute.api(IFlashTransferApi.class);
        String str = curEntity.fileSetId;
        Intrinsics.checkNotNullExpressionValue(str, "curEntity.fileSetId");
        String thumbImgSaveRootDirectory = iFlashTransferApi.getThumbImgSaveRootDirectory(str);
        Iterator<File> it = fileList.iterator();
        while (it.hasNext()) {
            File file = it.next();
            equals = StringsKt__StringsJVMKt.equals(curEntity.Uuid, file.physical.f359199id, true);
            if (equals) {
                arrayList.add(curEntity);
            } else {
                IFlashTransferApi iFlashTransferApi2 = (IFlashTransferApi) QRoute.api(IFlashTransferApi.class);
                Intrinsics.checkNotNullExpressionValue(file, "file");
                FileManagerEntity convertToFileManagerEntity = iFlashTransferApi2.convertToFileManagerEntity(file, "", true, false);
                if (!FileUtils.fileExists(convertToFileManagerEntity.getFilePath())) {
                    if (FileUtils.fileExists(file.thumbnail.localCachePath)) {
                        convertToFileManagerEntity.strMiddleThumPath = file.thumbnail.localCachePath;
                    } else {
                        String str2 = thumbImgSaveRootDirectory + '/' + convertToFileManagerEntity.fileName;
                        if (FileUtils.fileExists(str2)) {
                            convertToFileManagerEntity.strMiddleThumPath = str2;
                        } else {
                            convertToFileManagerEntity.strMiddleThumPath = file.thumbnail.urls.get(0).url;
                        }
                    }
                }
                convertToFileManagerEntity.strLargeThumPath = convertToFileManagerEntity.strMiddleThumPath;
                arrayList.add(convertToFileManagerEntity);
            }
        }
        QLog.i("FlashTransferFileBrowser", 1, "browseFile. convertToEntityList end. fileList.size: " + fileList.size() + ", time_len_ms: " + (System.currentTimeMillis() - currentTimeMillis) + '.');
        return arrayList;
    }

    @NotNull
    public final HashMap<Long, File> F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mBrowsingFileMap;
    }

    @Override // qb1.d
    public long a(@Nullable File file) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this, (Object) file)).longValue();
        }
        for (Map.Entry<Long, File> entry : this.mDownloadingFileMap.entrySet()) {
            long longValue = entry.getKey().longValue();
            String str2 = entry.getValue().cliFileId;
            if (file != null) {
                str = file.cliFileId;
            } else {
                str = null;
            }
            if (str2.equals(str)) {
                return longValue;
            }
        }
        return 0L;
    }

    @Override // qb1.d
    @NotNull
    public HashMap<Long, File> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (HashMap) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mDownloadingFileMap;
    }

    @Override // qb1.d
    public void c(@Nullable String params, @NotNull Activity activity) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) params, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("FlashTransferFileBrowser", 1, "browseFile failed. params empty.");
            return;
        }
        this.mBrowseStartTimeMs = System.currentTimeMillis();
        x();
        y();
        File A = A(params);
        QLog.i("FlashTransferFileBrowser", 1, "browseFile start. filename: " + A.name + '.');
        FileManagerEntity convertToFileManagerEntity = ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).convertToFileManagerEntity(A, "", true, true);
        int i3 = convertToFileManagerEntity.nFileType;
        if (i3 == 0) {
            m(params, activity, A, convertToFileManagerEntity);
        } else if (i3 == 2) {
            s(params, activity, A, convertToFileManagerEntity);
        } else {
            q(params, activity, A, convertToFileManagerEntity);
        }
    }

    @Override // qb1.d
    @Nullable
    public v d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (v) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        r();
        return this.mDownloadOper;
    }

    @Override // qb1.d
    public boolean e(@Nullable File file) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) file)).booleanValue();
        }
        for (Map.Entry<Long, File> entry : this.mDownloadingFileMap.entrySet()) {
            entry.getKey().longValue();
            String str2 = entry.getValue().cliFileId;
            if (file != null) {
                str = file.cliFileId;
            } else {
                str = null;
            }
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    FlashTransferFileBrowser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mBrowsingFileMap = new HashMap<>();
        this.mDownloadingFileMap = new HashMap<>();
        this.mBrowseStartTimeMs = System.currentTimeMillis();
    }
}
