package com.tencent.mobileqq.flashtransfer.api.impl;

import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.flashtransfer.FlashTransferErrBannerProcessor;
import com.tencent.mobileqq.flashtransfer.FlashTransferErrHandler;
import com.tencent.mobileqq.flashtransfer.FlashTransferFileBrowser;
import com.tencent.mobileqq.flashtransfer.FlashTransferProgressBannerProcessor;
import com.tencent.mobileqq.flashtransfer.FlashTransferProgressHandler;
import com.tencent.mobileqq.flashtransfer.FlashTransferTaskInfoListenerImpl;
import com.tencent.mobileqq.flashtransfer.JumpActionReceiver;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.flashtransfer.api.impl.FlashTransferApiImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.af;
import com.tencent.qqnt.kernel.nativeinterface.BasicFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.CheckDeviceStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.CheckDeviceStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.CleanFileDetail;
import com.tencent.qqnt.kernel.nativeinterface.DownloadFinishFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.File;
import com.tencent.qqnt.kernel.nativeinterface.FileSet;
import com.tencent.qqnt.kernel.nativeinterface.FileSetDownloadTaskStatus;
import com.tencent.qqnt.kernel.nativeinterface.FlashFileSetDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferPauseReason;
import com.tencent.qqnt.kernel.nativeinterface.GetLocalFileListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCheckDeviceStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetIdByCodeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetLocalFileListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferTaskInfoListener;
import com.tencent.qqnt.kernel.nativeinterface.NetStatusType;
import com.tencent.qqnt.kernel.nativeinterface.ResumePausedTasksAfterDeviceStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.Uploader;
import com.tencent.qqnt.kernel.nativeinterface.UserDownloadOperationInfo;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qzone.QZoneHelper;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 Y2\u00020\u0001:\u0001ZB\u0007\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015H\u0016J(\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\"H\u0016J \u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J*\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010(\u001a\u00020\fH\u0016J\b\u0010*\u001a\u00020)H\u0016J(\u00101\u001a\u0002002\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bH\u0016J\u0016\u00103\u001a\u00020\u00132\u0006\u00102\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u00104\u001a\u00020\u00132\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\fJ\u0018\u00106\u001a\u00020\b2\u0006\u00105\u001a\u0002002\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u00107\u001a\u00020\fH\u0016J\b\u00108\u001a\u00020\fH\u0016J\u0010\u00109\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\u001a\u0010;\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010=\u001a\u00020\f2\b\u0010<\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010?\u001a\u00020>H\u0016J\b\u0010A\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020\bH\u0016J\b\u0010C\u001a\u00020\bH\u0016J\b\u0010D\u001a\u00020\bH\u0016J\b\u0010E\u001a\u00020\u0013H\u0016J\u0018\u0010H\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u0002H\u0016J\u0012\u0010I\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010J\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010O\u001a\u00020\u00132\b\u0010L\u001a\u0004\u0018\u00010K2\b\u0010N\u001a\u0004\u0018\u00010MH\u0016J\b\u0010P\u001a\u00020\u0013H\u0016R\"\u0010Q\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/flashtransfer/api/impl/FlashTransferApiImpl;", "Lcom/tencent/mobileqq/flashtransfer/api/IFlashTransferApi;", "", "generateSessionId", "", "actionList", "", "action", "", "hasAction", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "localPath", "saveImage", "getSenderConfig", "getReceiverConfig", "getCommonConfig", "isResumeFailedTransfer", "", "lazyInitBroadcastReceiver", "Ljava/lang/Class;", "", "getFlashTransferJumpParserClass", "Landroid/content/Context;", "context", "url", "fromSource", MttLoader.ENTRY_ID, "interceptFlashTransferUrl", "getFlashTransferProgressHandlerName", "getFlashTransferErrHandlerName", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferTaskInfoListener;", "getFlashTransferTaskInfoListener", "Lcom/tencent/mobileqq/app/BusinessObserver;", "getFlashTransferProgressObserver", "getFlashTransferErrObserver", "filesetId", "getDownloadActivityScheme", "extParams", "getCenterActivityScheme", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;", "getFlashTransferServiceDownloadListener", "Lcom/tencent/qqnt/kernel/nativeinterface/File;", "file", "uploaderName", "isFromBrowse", "isQueryDB", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "convertToFileManagerEntity", "filename", "updateCleanDB", "updateDB", "entity", "canAddMenu", "getFileSaveRootDirectory", "getFileCacheRootDirectory", "getThumbImgSaveRootDirectory", "urlString", "downloadThumbImage", "filePath", "getTencentDocSupportedExtension", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDeviceStatusListener;", "getFlashTransferServiceDeviceStatusListener", "Lqb1/d;", "getFlashTransferFileBrowser", "hasSendEntrance", "isDisabledAioMsgOpen", "hasFlashTransferEntrance", "tryResumeFailedTransfer", TagName.FILE_TYPE, "size", "isTencentDocFileSizeExceeded", "isFlashTransferFile", "getShareWeChatOverSizeResId", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckDeviceStatusReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferCheckDeviceStatusCallback;", "callback", "checkDeviceStatus", "initFlashTransferService", "sessionIdx", "I", "getSessionIdx", "()I", "setSessionIdx", "(I)V", "<init>", "()V", "Companion", "a", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlashTransferApiImpl implements IFlashTransferApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String CENTER_ACTIVITY_SCHEME = "mqqapi://kuikly/open?version=1&src_type=app&page_name=QQTransferCenterActivity&local_bundle_name=nearbypro&qui_token_theme_mode=0&use_host_display_metrics=1&scene_type=0&autorotate=1&custom_back_pressed=1";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String DOWNLOAD_ACTIVITY_SCHEME = "mqqapi://kuikly/open?page_name=QQTransferDownloadActivity&local_bundle_name=nearbypro&use_host_display_metrics=1&bottom_nav_bar_immersive=1&modal_mode=1&qui_token_theme_mode=0&file_set_id=%s&scene_type=%d&entry_id=%d&autorotate=1&custom_back_pressed=1";

    @NotNull
    private static final String FLASH_TRANSFER_HOST = "qfile.qq.com";

    @NotNull
    private static final String FLASH_TRANSFER_HOST_TEST = "test.qfile.qq.com";

    @NotNull
    private static final String FLASH_TRANSFER_PATH = "/flash-transfer";

    @NotNull
    private static final String KEY_FILE_SET_ID = "fileSetId";

    @NotNull
    private static final String SHORT_URL_PREFIX = "/q/";

    @NotNull
    private static final String TAG = "FlashTransferApiImpl";

    @NotNull
    private static final HashMap<String, String> filesetUploaderNameMap;

    @Nullable
    private static JumpActionReceiver receiver;

    @NotNull
    private static final HashMap<String, Long> sBrowsingSessionIdMap;

    @Nullable
    private static String sCommonConfig;

    @NotNull
    private static final int[] sDownloadedImageActionList;

    @NotNull
    private static final int[] sDownloadedOtherFileActionList;

    @NotNull
    private static final int[] sDownloadedVideoActionList;

    @Nullable
    private static HashMap<String, Integer> sFileType;

    @Nullable
    private static IFlashTransferTaskInfoListener sFlashTransferTaskInfoListener;

    @Nullable
    private static Boolean sHasFlashTransferEntrance;

    @Nullable
    private static Boolean sHasSendEntrance;
    private static boolean sIsBrowsingFileExisted;

    @Nullable
    private static Boolean sIsDisabledAioMsgOpen;

    @Nullable
    private static String sReceiverConfig;

    @Nullable
    private static Boolean sResumeFailedTransfer;

    @Nullable
    private static String sSenderConfig;

    @NotNull
    private static final int[] sUnDownloadedImageActionList;

    @NotNull
    private static final int[] sUnDownloadedOtherFileActionList;

    @NotNull
    private static final int[] sUnDownloadedVideoActionList;
    private int sessionIdx;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R0\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R6\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010$\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0004R\u0018\u0010(\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\"R\u0018\u0010)\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u0004R\u0014\u0010*\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u0018R\u0014\u0010+\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u0018R\u0014\u0010,\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\u0018\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/flashtransfer/api/impl/FlashTransferApiImpl$a;", "", "", "CENTER_ACTIVITY_SCHEME", "Ljava/lang/String;", "DOWNLOAD_ACTIVITY_SCHEME", "FLASH_TRANSFER_HOST", "FLASH_TRANSFER_HOST_TEST", "FLASH_TRANSFER_PATH", "KEY_FILE_SET_ID", "SHORT_URL_PREFIX", "TAG", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "filesetUploaderNameMap", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/flashtransfer/JumpActionReceiver;", "receiver", "Lcom/tencent/mobileqq/flashtransfer/JumpActionReceiver;", "", "sBrowsingSessionIdMap", "sCommonConfig", "", "sDownloadedImageActionList", "[I", "sDownloadedOtherFileActionList", "sDownloadedVideoActionList", "", "sFileType", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferTaskInfoListener;", "sFlashTransferTaskInfoListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferTaskInfoListener;", "", "sHasFlashTransferEntrance", "Ljava/lang/Boolean;", "sHasSendEntrance", "sIsBrowsingFileExisted", "Z", "sIsDisabledAioMsgOpen", "sReceiverConfig", "sResumeFailedTransfer", "sSenderConfig", "sUnDownloadedImageActionList", "sUnDownloadedOtherFileActionList", "sUnDownloadedVideoActionList", "<init>", "()V", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flashtransfer.api.impl.FlashTransferApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/flashtransfer/api/impl/FlashTransferApiImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferCheckDeviceStatusCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckDeviceStatusRsp;", "rsp", "", "deviceStatus", "", UinConfigManager.KEY_ADS, "", "e", "onCheckDeviceStatus", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements IFlashTransferCheckDeviceStatusCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IFlashTransferCheckDeviceStatusCallback f209898a;

        b(IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback) {
            this.f209898a = iFlashTransferCheckDeviceStatusCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iFlashTransferCheckDeviceStatusCallback);
            }
        }

        private final void e(final CheckDeviceStatusRsp rsp, int deviceStatus, String notice) {
            boolean z16;
            QLog.i(FlashTransferApiImpl.TAG, 1, "checkDeviceStatus. onCheckDeviceStatus. deviceStatus: " + deviceStatus + ", notice: " + notice);
            if (deviceStatus == 0) {
                rsp.invalidStatus.clear();
                IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback = this.f209898a;
                if (iFlashTransferCheckDeviceStatusCallback != null) {
                    iFlashTransferCheckDeviceStatusCallback.onCheckDeviceStatus(rsp);
                    return;
                }
                return;
            }
            if (notice.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (deviceStatus != 1 && deviceStatus != 2) {
                    if (deviceStatus == 4) {
                        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
                            String qqStr = HardCodeUtil.qqStr(R.string.f1351700q);
                            String qqStr2 = HardCodeUtil.qqStr(R.string.f1352500y);
                            final IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback2 = this.f209898a;
                            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.e
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i3) {
                                    FlashTransferApiImpl.b.h(CheckDeviceStatusRsp.this, iFlashTransferCheckDeviceStatusCallback2, dialogInterface, i3);
                                }
                            };
                            final IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback3 = this.f209898a;
                            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, notice, qqStr, qqStr2, onClickListener, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.f
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i3) {
                                    FlashTransferApiImpl.b.i(IFlashTransferCheckDeviceStatusCallback.this, rsp, dialogInterface, i3);
                                }
                            });
                            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026                       })");
                            createCustomDialog.show();
                            return;
                        }
                        IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback4 = this.f209898a;
                        if (iFlashTransferCheckDeviceStatusCallback4 != null) {
                            iFlashTransferCheckDeviceStatusCallback4.onCheckDeviceStatus(rsp);
                            return;
                        }
                        return;
                    }
                    return;
                }
                QBaseActivity qBaseActivity2 = QBaseActivity.sTopActivity;
                if (qBaseActivity2 != null && !qBaseActivity2.isFinishing()) {
                    String qqStr3 = HardCodeUtil.qqStr(R.string.f1351400n);
                    final IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback5 = this.f209898a;
                    QQCustomDialog createCustomDialog2 = DialogUtil.createCustomDialog(qBaseActivity2, 230, (String) null, notice, (String) null, qqStr3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.d
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            FlashTransferApiImpl.b.g(IFlashTransferCheckDeviceStatusCallback.this, rsp, dialogInterface, i3);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    Intrinsics.checkNotNullExpressionValue(createCustomDialog2, "createCustomDialog(\n    \u2026                 }, null)");
                    createCustomDialog2.show();
                    return;
                }
                IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback6 = this.f209898a;
                if (iFlashTransferCheckDeviceStatusCallback6 != null) {
                    iFlashTransferCheckDeviceStatusCallback6.onCheckDeviceStatus(rsp);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(CheckDeviceStatusRsp rsp, b this$0) {
            Intrinsics.checkNotNullParameter(rsp, "$rsp");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (rsp.invalidStatus.isEmpty()) {
                this$0.e(rsp, 0, "");
                return;
            }
            HashMap<Integer, String> hashMap = rsp.invalidStatus;
            Intrinsics.checkNotNullExpressionValue(hashMap, "rsp.invalidStatus");
            for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
                Integer key = entry.getKey();
                String value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                int intValue = key.intValue();
                Intrinsics.checkNotNullExpressionValue(value, "value");
                this$0.e(rsp, intValue, value);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback, CheckDeviceStatusRsp rsp, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(rsp, "$rsp");
            dialogInterface.dismiss();
            if (iFlashTransferCheckDeviceStatusCallback != null) {
                iFlashTransferCheckDeviceStatusCallback.onCheckDeviceStatus(rsp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(CheckDeviceStatusRsp rsp, IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(rsp, "$rsp");
            dialogInterface.dismiss();
            rsp.invalidStatus.clear();
            if (iFlashTransferCheckDeviceStatusCallback != null) {
                iFlashTransferCheckDeviceStatusCallback.onCheckDeviceStatus(rsp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback, CheckDeviceStatusRsp rsp, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(rsp, "$rsp");
            dialogInterface.dismiss();
            if (iFlashTransferCheckDeviceStatusCallback != null) {
                iFlashTransferCheckDeviceStatusCallback.onCheckDeviceStatus(rsp);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCheckDeviceStatusCallback
        public void onCheckDeviceStatus(@NotNull final CheckDeviceStatusRsp rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
            } else {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlashTransferApiImpl.b.f(CheckDeviceStatusRsp.this, this);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/flashtransfer/api/impl/FlashTransferApiImpl$c", "Lcom/tencent/mobileqq/flashtransfer/b;", "", "taskType", "failedFileCnt", "", "filesetId", "", "b", "a", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends com.tencent.mobileqq.flashtransfer.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.flashtransfer.b
        protected void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i(FlashTransferApiImpl.TAG, 1, "onHide.");
            BannerManager l3 = BannerManager.l();
            if (l3 == null) {
                return;
            }
            l3.O(FlashTransferErrBannerProcessor.f209849e, 0, null);
        }

        @Override // com.tencent.mobileqq.flashtransfer.b
        protected void b(int taskType, int failedFileCnt, @NotNull String filesetId) {
            String qqStr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(taskType), Integer.valueOf(failedFileCnt), filesetId);
                return;
            }
            Intrinsics.checkNotNullParameter(filesetId, "filesetId");
            QLog.i(FlashTransferApiImpl.TAG, 1, "onTransferFileFailed. taskType: " + taskType + ", failedFileCnt: " + failedFileCnt + ", filesetId: " + filesetId);
            BannerManager l3 = BannerManager.l();
            if (l3 == null) {
                return;
            }
            Message message = new Message();
            if (taskType != 0) {
                if (taskType != 1) {
                    if (taskType != 2) {
                        qqStr = "";
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.f1352200v);
                    }
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.f1350600f);
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.f1352300w);
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr2 = HardCodeUtil.qqStr(R.string.f1350700g);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.flash_transfer_err)");
            String format = String.format(qqStr2, Arrays.copyOf(new Object[]{Integer.valueOf(failedFileCnt), qqStr}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            message.obj = new Object[]{format, filesetId};
            l3.O(FlashTransferErrBannerProcessor.f209849e, 2, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/flashtransfer/api/impl/FlashTransferApiImpl$d", "Lcom/tencent/mobileqq/flashtransfer/j;", "", "taskType", "taskCnt", "progress", "", "filesetId", "filesetName", "", "isPaused", "", "c", "a", "b", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d extends com.tencent.mobileqq.flashtransfer.j {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.flashtransfer.j
        protected void a(int taskType, @NotNull String filesetId, @NotNull String filesetName) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(taskType), filesetId, filesetName);
                return;
            }
            Intrinsics.checkNotNullParameter(filesetId, "filesetId");
            Intrinsics.checkNotNullParameter(filesetName, "filesetName");
            QLog.i(FlashTransferApiImpl.TAG, 1, "onAllTransferTasksFinished. taskType: " + taskType + ", filesetId: " + filesetId + ", filesetName: " + filesetName);
            BannerManager l3 = BannerManager.l();
            if (l3 == null) {
                return;
            }
            Message message = new Message();
            if (taskType == 0) {
                i3 = R.string.f1352300w;
            } else {
                i3 = R.string.f1350600f;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f1351300m);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.flash_transfer_finish)");
            String format = String.format(qqStr, Arrays.copyOf(new Object[]{HardCodeUtil.qqStr(i3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            message.obj = new Object[]{filesetName, format, filesetId, Boolean.TRUE};
            l3.O(FlashTransferProgressBannerProcessor.E, 2, message);
        }

        @Override // com.tencent.mobileqq.flashtransfer.j
        protected void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            QLog.i(FlashTransferApiImpl.TAG, 1, "onHide.");
            BannerManager l3 = BannerManager.l();
            if (l3 == null) {
                return;
            }
            l3.O(FlashTransferProgressBannerProcessor.E, 0, null);
        }

        @Override // com.tencent.mobileqq.flashtransfer.j
        protected void c(int taskType, int taskCnt, int progress, @NotNull String filesetId, @NotNull String filesetName, boolean isPaused) {
            String format;
            String str;
            String filesetName2 = filesetName;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(taskType), Integer.valueOf(taskCnt), Integer.valueOf(progress), filesetId, filesetName2, Boolean.valueOf(isPaused));
                return;
            }
            Intrinsics.checkNotNullParameter(filesetId, "filesetId");
            Intrinsics.checkNotNullParameter(filesetName2, "filesetName");
            if (QLog.isColorLevel()) {
                QLog.d(FlashTransferApiImpl.TAG, 2, "onUpdateTransferProgress. taskType: " + taskType + ", taskCnt: " + taskCnt + ", progress: " + progress + ", filesetId: " + filesetId + ", filesetName: " + filesetName2 + ", isPaused: " + isPaused);
            }
            BannerManager l3 = BannerManager.l();
            if (l3 == null) {
                return;
            }
            Message message = new Message();
            if (taskType != 0) {
                if (taskType != 1) {
                    str = "";
                    if (taskType == 2) {
                        if (isPaused) {
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String qqStr = HardCodeUtil.qqStr(R.string.f1351900s);
                            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.flash_transfer_pause2)");
                            format = String.format(qqStr, Arrays.copyOf(new Object[]{Integer.valueOf(taskCnt)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        } else {
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            String qqStr2 = HardCodeUtil.qqStr(R.string.f1352100u);
                            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.flash_transfer_progress2)");
                            format = String.format(qqStr2, Arrays.copyOf(new Object[]{Integer.valueOf(taskCnt)}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        }
                        filesetName2 = "";
                    }
                    message.obj = new Object[]{filesetName2, str, filesetId, Boolean.FALSE};
                    l3.O(FlashTransferProgressBannerProcessor.E, 2, message);
                }
                if (isPaused) {
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String qqStr3 = HardCodeUtil.qqStr(R.string.f1351800r);
                    Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.flash_transfer_pause1)");
                    format = String.format(qqStr3, Arrays.copyOf(new Object[]{HardCodeUtil.qqStr(R.string.f1350600f)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                } else {
                    StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                    String qqStr4 = HardCodeUtil.qqStr(R.string.f1352000t);
                    Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.flash_transfer_progress1)");
                    format = String.format(qqStr4, Arrays.copyOf(new Object[]{HardCodeUtil.qqStr(R.string.f1350600f), Integer.valueOf(progress)}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                }
            } else if (isPaused) {
                StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                String qqStr5 = HardCodeUtil.qqStr(R.string.f1351800r);
                Intrinsics.checkNotNullExpressionValue(qqStr5, "qqStr(R.string.flash_transfer_pause1)");
                format = String.format(qqStr5, Arrays.copyOf(new Object[]{HardCodeUtil.qqStr(R.string.f1352300w)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            } else {
                StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                String qqStr6 = HardCodeUtil.qqStr(R.string.f1352000t);
                Intrinsics.checkNotNullExpressionValue(qqStr6, "qqStr(R.string.flash_transfer_progress1)");
                format = String.format(qqStr6, Arrays.copyOf(new Object[]{HardCodeUtil.qqStr(R.string.f1352300w), Integer.valueOf(progress)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            str = format;
            message.obj = new Object[]{filesetName2, str, filesetId, Boolean.FALSE};
            l3.O(FlashTransferProgressBannerProcessor.E, 2, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/flashtransfer/api/impl/FlashTransferApiImpl$e", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDeviceStatusListener;", "", "seq", "", "msg", "Lcom/tencent/qqnt/kernel/nativeinterface/NetStatusType;", "networkStatus", "", "onNetStatusChanged", "showBackToForegroundAlert", "showLowBatterylAlert", "showSleepAlert", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e implements IFlashTransferServiceDeviceStatusListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(QBaseActivity qBaseActivity, String str) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 230, (String) null, str, HardCodeUtil.qqStr(R.string.f1351700q), HardCodeUtil.qqStr(R.string.f1352500y), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    FlashTransferApiImpl.e.e(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    FlashTransferApiImpl.e.f(dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026                       })");
            createCustomDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(DialogInterface dialogInterface, int i3) {
            BaseQQAppInterface baseQQAppInterface;
            IKernelService iKernelService;
            com.tencent.qqnt.kernel.api.q flashTransferService;
            dialogInterface.dismiss();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof BaseQQAppInterface) {
                baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
            } else {
                baseQQAppInterface = null;
            }
            ResumePausedTasksAfterDeviceStatusReq resumePausedTasksAfterDeviceStatusReq = new ResumePausedTasksAfterDeviceStatusReq();
            resumePausedTasksAfterDeviceStatusReq.pauseReason = FlashTransferPauseReason.KCELLULARNETWORK;
            if (baseQQAppInterface != null && (iKernelService = (IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "all")) != null && (flashTransferService = iKernelService.getFlashTransferService()) != null) {
                flashTransferService.resumePausedTasksAfterDeviceStatus(resumePausedTasksAfterDeviceStatusReq, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener
        public /* synthetic */ void onAvailableStorageChange(int i3, String str, boolean z16) {
            com.tencent.qqnt.kernel.nativeinterface.k.a(this, i3, str, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener
        public void onNetStatusChanged(int seq, @Nullable final String msg2, @Nullable NetStatusType networkStatus) {
            final QBaseActivity qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(seq), msg2, networkStatus);
                return;
            }
            QLog.i(FlashTransferApiImpl.TAG, 1, "onNetStatusChanged. networkStatus: " + networkStatus + ", msg: " + msg2);
            if (!TextUtils.isEmpty(msg2) && networkStatus != null && networkStatus.compareTo(NetStatusType.KREACHABLEVIA2G) >= 0 && networkStatus.compareTo(NetStatusType.KREACHABLEVIA5G) <= 0 && (qBaseActivity = QBaseActivity.sTopActivity) != null && !qBaseActivity.isFinishing()) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlashTransferApiImpl.e.d(QBaseActivity.this, msg2);
                    }
                });
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener
        public void showBackToForegroundAlert(int seq, @Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, seq, (Object) msg2);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener
        public void showLowBatterylAlert(int seq, @Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, seq, (Object) msg2);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener
        public void showSleepAlert(int seq, @Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, seq, (Object) msg2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001e\u0010\u0007\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u0006H\u0016J$\u0010\u000b\u001a\u00020\b2\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/flashtransfer/api/impl/FlashTransferApiImpl$f", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;", "", "filesetId", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/DownloadFinishFileInfo;", "Lkotlin/collections/ArrayList;", "fileList", "", "onProfilerFileListDidFinishDownload", "Lcom/tencent/qqnt/kernel/nativeinterface/File;", "onFileListDidFinishDownload", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class f implements IFlashTransferServiceDownloadListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/flashtransfer/api/impl/FlashTransferApiImpl$f$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetFileSetCallback;", "", "seq", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/FileSet;", "fileSet", "", QAdRewardDefine$VideoParams.ISCACHE, "", "onGetFileSet", "qqfile-common-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class a implements IFlashTransferServiceGetFileSetCallback {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ File f209900a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ GetLocalFileListRsp f209901b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ FlashTransferApiImpl f209902c;

            a(File file, GetLocalFileListRsp getLocalFileListRsp, FlashTransferApiImpl flashTransferApiImpl) {
                this.f209900a = file;
                this.f209901b = getLocalFileListRsp;
                this.f209902c = flashTransferApiImpl;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, file, getLocalFileListRsp, flashTransferApiImpl);
                }
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetCallback
            public void onGetFileSet(int seq, int result, @Nullable String errMsg, @Nullable FileSet fileSet, boolean isCache) {
                String str;
                String str2;
                ArrayList<Uploader> arrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(seq), Integer.valueOf(result), errMsg, fileSet, Boolean.valueOf(isCache));
                    return;
                }
                if (result == 0 && fileSet != null && (arrayList = fileSet.uploaders) != null && arrayList.size() > 0) {
                    str = fileSet.uploaders.get(0).nickname;
                    Intrinsics.checkNotNullExpressionValue(str, "fileSet.uploaders.get(0).nickname");
                    if (!TextUtils.isEmpty(str)) {
                        FlashTransferApiImpl.filesetUploaderNameMap.put(this.f209900a.fileSetId, str);
                    }
                } else {
                    str = "";
                }
                QLog.i(FlashTransferApiImpl.TAG, 1, "onFileDidFinishDownLoad. onGetFileSet. result:" + result + ", errMsg:" + errMsg + ", filePath:" + this.f209901b.fileList.get(0).saveFilePath + ", uploaderName:" + str);
                FlashTransferApiImpl flashTransferApiImpl = this.f209902c;
                File file = this.f209901b.fileList.get(0);
                Intrinsics.checkNotNullExpressionValue(file, "rsp.fileList.get(0)");
                flashTransferApiImpl.updateDB(file, str);
                if (this.f209902c.getFlashTransferFileBrowser().e(this.f209900a)) {
                    long a16 = this.f209902c.getFlashTransferFileBrowser().a(this.f209900a);
                    this.f209902c.getFlashTransferFileBrowser().b().remove(Long.valueOf(a16));
                    IQQFileTempUtils iQQFileTempUtils = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
                    File file2 = this.f209900a;
                    if (file2 != null) {
                        str2 = file2.saveFilePath;
                    } else {
                        str2 = null;
                    }
                    iQQFileTempUtils.notifyFlashTransferDownloadResult(a16, true, str2);
                }
            }
        }

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlashTransferApiImpl.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(File file, FlashTransferApiImpl this$0, BaseQQAppInterface appRuntime, GetLocalFileListRsp getLocalFileListRsp) {
            ArrayList<File> arrayList;
            Intrinsics.checkNotNullParameter(file, "$file");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(appRuntime, "$appRuntime");
            if (getLocalFileListRsp != null && getLocalFileListRsp.result == 0 && (arrayList = getLocalFileListRsp.fileList) != null && arrayList.size() > 0) {
                getLocalFileListRsp.fileList.get(0).saveFilePath = file.saveFilePath;
                getLocalFileListRsp.fileList.get(0).status = file.status;
                QLog.i(FlashTransferApiImpl.TAG, 1, "onFileDidFinishDownLoad. GetLocalFileListCallback. fileName:" + getLocalFileListRsp.fileList.get(0).name + ", filePath:" + getLocalFileListRsp.fileList.get(0).saveFilePath + ", fileid:" + getLocalFileListRsp.fileList.get(0).cliFileId);
                String str = (String) FlashTransferApiImpl.filesetUploaderNameMap.get(file.fileSetId);
                if (!TextUtils.isEmpty(str)) {
                    if (str != null) {
                        File file2 = getLocalFileListRsp.fileList.get(0);
                        Intrinsics.checkNotNullExpressionValue(file2, "rsp.fileList.get(0)");
                        this$0.updateDB(file2, str);
                        if (this$0.getFlashTransferFileBrowser().e(file)) {
                            long a16 = this$0.getFlashTransferFileBrowser().a(file);
                            this$0.getFlashTransferFileBrowser().b().remove(Long.valueOf(a16));
                            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).notifyFlashTransferDownloadResult(a16, true, file.saveFilePath);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.tencent.qqnt.kernel.api.q flashTransferService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "all")).getFlashTransferService();
                if (flashTransferService != null) {
                    flashTransferService.f(0, file.fileSetId, true, true, new a(file, getLocalFileListRsp, this$0));
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileDidStartDownload(File file) {
            com.tencent.qqnt.kernel.nativeinterface.l.a(this, file);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileDownloadDidError(File file, int i3, String str) {
            com.tencent.qqnt.kernel.nativeinterface.l.b(this, file, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileDownloadProgressChanged(File file, long j3, long j16) {
            com.tencent.qqnt.kernel.nativeinterface.l.c(this, file, j3, j16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileDownloadSpeedChange(File file, int i3, int i16) {
            com.tencent.qqnt.kernel.nativeinterface.l.d(this, file, i3, i16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileListDidFinishDownload(@Nullable ArrayList<File> fileList) {
            final BaseQQAppInterface baseQQAppInterface;
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) fileList);
                return;
            }
            if (fileList == null) {
                return;
            }
            Iterator<File> it = fileList.iterator();
            while (it.hasNext()) {
                final File next = it.next();
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                String str3 = null;
                if (peekAppRuntime instanceof BaseQQAppInterface) {
                    baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
                } else {
                    baseQQAppInterface = null;
                }
                if (baseQQAppInterface != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onFileDidFinishDownLoad. fileid: ");
                    if (next != null) {
                        str = next.cliFileId;
                    } else {
                        str = null;
                    }
                    sb5.append(str);
                    sb5.append(", filename: ");
                    if (next != null) {
                        str2 = next.name;
                    } else {
                        str2 = null;
                    }
                    sb5.append(str2);
                    sb5.append(", targetPath: ");
                    if (next != null) {
                        str3 = next.saveFilePath;
                    }
                    sb5.append(str3);
                    sb5.append('.');
                    QLog.i(FlashTransferApiImpl.TAG, 1, sb5.toString());
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(next.cliFileId);
                    final FlashTransferApiImpl flashTransferApiImpl = FlashTransferApiImpl.this;
                    IFlashTransferServiceGetLocalFileListCallback iFlashTransferServiceGetLocalFileListCallback = new IFlashTransferServiceGetLocalFileListCallback() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.j
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetLocalFileListCallback
                        public final void onGetLocalFileList(GetLocalFileListRsp getLocalFileListRsp) {
                            FlashTransferApiImpl.f.b(File.this, flashTransferApiImpl, baseQQAppInterface, getLocalFileListRsp);
                        }
                    };
                    com.tencent.qqnt.kernel.api.q flashTransferService = ((IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "all")).getFlashTransferService();
                    if (flashTransferService != null) {
                        flashTransferService.getLocalFileList(0, next.fileSetId, arrayList, iFlashTransferServiceGetLocalFileListCallback);
                    }
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileListDownloadDidCancel(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.l.f(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileListDownloadDidError(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.l.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileListDownloadDidPause(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.l.h(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileListDownloadWaitDownloading(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.l.i(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileSetDownloadTaskProgressChanged(String str, FlashFileSetDownloadInfo flashFileSetDownloadInfo) {
            com.tencent.qqnt.kernel.nativeinterface.l.j(this, str, flashFileSetDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onFileSetDownloadTaskStatusChange(FileSetDownloadTaskStatus fileSetDownloadTaskStatus, String str, FlashFileSetDownloadInfo flashFileSetDownloadInfo) {
            com.tencent.qqnt.kernel.nativeinterface.l.k(this, fileSetDownloadTaskStatus, str, flashFileSetDownloadInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onProfilerFileDidStartDownload(String str, BasicFileInfo basicFileInfo) {
            com.tencent.qqnt.kernel.nativeinterface.l.l(this, str, basicFileInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onProfilerFileDownloadProgressChanged(String str, BasicFileInfo basicFileInfo, long j3, long j16) {
            com.tencent.qqnt.kernel.nativeinterface.l.m(this, str, basicFileInfo, j3, j16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileListDidFinishDownload(@Nullable String filesetId, @Nullable ArrayList<DownloadFinishFileInfo> fileList) {
            String str;
            BasicFileInfo basicFileInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) filesetId, (Object) fileList);
                return;
            }
            if (fileList == null) {
                return;
            }
            ArrayList<File> arrayList = new ArrayList<>();
            Iterator<DownloadFinishFileInfo> it = fileList.iterator();
            while (it.hasNext()) {
                DownloadFinishFileInfo next = it.next();
                File file = new File();
                file.fileSetId = filesetId;
                String str2 = null;
                if (next != null) {
                    str = next.savePath;
                } else {
                    str = null;
                }
                file.saveFilePath = str;
                if (next != null && (basicFileInfo = next.fileInfo) != null) {
                    str2 = basicFileInfo.fileId;
                }
                file.cliFileId = str2;
                arrayList.add(file);
            }
            onFileListDidFinishDownload(arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onProfilerFileListDownloadDidCancel(String str, ArrayList arrayList, int i3) {
            com.tencent.qqnt.kernel.nativeinterface.l.o(this, str, arrayList, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onProfilerFileListDownloadDidError(String str, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.l.p(this, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onProfilerFileListDownloadDidPause(String str, ArrayList arrayList, int i3) {
            com.tencent.qqnt.kernel.nativeinterface.l.q(this, str, arrayList, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onProfilerFileListDownloadWaitDownloading(String str, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.l.r(this, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onThumbnailDownloadResult(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.l.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public /* synthetic */ void onUserDownloadOperationResultNotify(UserDownloadOperationInfo userDownloadOperationInfo) {
            com.tencent.qqnt.kernel.nativeinterface.l.t(this, userDownloadOperationInfo);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19547);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
            return;
        }
        INSTANCE = new Companion(null);
        sBrowsingSessionIdMap = new HashMap<>();
        filesetUploaderNameMap = new HashMap<>();
        sDownloadedImageActionList = new int[]{2, 26, 9, 64, 39, 220, 52, 121, 11};
        sDownloadedVideoActionList = new int[]{2, 26, 9, 64, 39, 11};
        sDownloadedOtherFileActionList = new int[]{2, 26, 9, 64, 70, 121, 11};
        sUnDownloadedImageActionList = new int[]{2, 26, 124, 220, 52, 121};
        sUnDownloadedVideoActionList = new int[]{2, 26, 124};
        sUnDownloadedOtherFileActionList = new int[]{2, 26, 124, 70, 121};
    }

    public FlashTransferApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long generateSessionId() {
        this.sessionIdx = (this.sessionIdx + 1) % 1000;
        return (System.currentTimeMillis() * 1000) + this.sessionIdx;
    }

    private final String getCommonConfig() {
        String str = sCommonConfig;
        if (str != null) {
            return str;
        }
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("106119", new byte[0]);
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        sCommonConfig = new String(loadRawConfig, UTF_8);
        QLog.i(TAG, 1, "getCommonConfig. config: " + sCommonConfig);
        return sCommonConfig;
    }

    private final String getReceiverConfig() {
        String str = sReceiverConfig;
        if (str != null) {
            return str;
        }
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("106090", new byte[0]);
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        sReceiverConfig = new String(loadRawConfig, UTF_8);
        QLog.i(TAG, 1, "getReceiverConfig. config: " + sReceiverConfig);
        return sReceiverConfig;
    }

    private final String getSenderConfig() {
        String str = sSenderConfig;
        if (str != null) {
            return str;
        }
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("106089", new byte[0]);
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        sSenderConfig = new String(loadRawConfig, UTF_8);
        QLog.i(TAG, 1, "getSenderConfig. config: " + sSenderConfig);
        return sSenderConfig;
    }

    private final boolean hasAction(int[] actionList, int action) {
        for (int i3 : actionList) {
            if (i3 == action) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void interceptFlashTransferUrl$lambda$1(BaseQQAppInterface app, final Context context, FlashTransferApiImpl this$0, int i3, int i16, String fileSetId, int i17, String str) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(TAG, 1, "interceptFlashTransferUrl result=" + i17 + " id=" + fileSetId);
        if (i17 == 0) {
            Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
            ax c16 = bi.c(app, context, this$0.getDownloadActivityScheme(fileSetId, i3, i16));
            if (c16 != null) {
                c16.b();
                return;
            }
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                FlashTransferApiImpl.interceptFlashTransferUrl$lambda$1$lambda$0(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void interceptFlashTransferUrl$lambda$1$lambda$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.f1351600p), 1).show();
    }

    private final boolean isResumeFailedTransfer() {
        Boolean bool;
        Boolean bool2 = sResumeFailedTransfer;
        if (bool2 != null) {
            Intrinsics.checkNotNull(bool2);
            return bool2.booleanValue();
        }
        getCommonConfig();
        if (TextUtils.isEmpty(sCommonConfig)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(sCommonConfig);
            if (jSONObject.has("resume_failed_transfer")) {
                bool = Boolean.valueOf(jSONObject.getBoolean("resume_failed_transfer"));
            } else {
                bool = Boolean.FALSE;
            }
            sResumeFailedTransfer = bool;
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "isResumeFailedTransfer parse json failed. " + QLog.getStackTraceString(e16));
            return false;
        }
    }

    private final void lazyInitBroadcastReceiver() {
        if (receiver != null) {
            return;
        }
        try {
            receiver = new JumpActionReceiver();
            MobileQQ.sMobileQQ.getApplicationContext().registerReceiver(receiver, new IntentFilter("com.tencent.mqq.filetransfer.jumpaction"));
        } catch (Exception e16) {
            QLog.i(TAG, 1, "lazyInitBroadcastReceiver", e16);
        }
    }

    private final boolean saveImage(Bitmap bitmap, String localPath) {
        java.io.File file = new java.io.File(localPath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(TAG, 1, "saveImage failed. localPath: " + localPath + ", msg: " + e16.getMessage());
            return false;
        }
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    public boolean canAddMenu(@NotNull FileManagerEntity entity, int action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) entity, action)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (entity.nOpType != 58) {
            return true;
        }
        int fileType = ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).getFileType(entity.fileName);
        if (action == 70) {
            return false;
        }
        if (fileType != 0 && fileType != 2 && !sIsBrowsingFileExisted) {
            if (!TextUtils.isEmpty(getTencentDocSupportedExtension(entity.fileName))) {
                if (action == 26) {
                    return false;
                }
            } else if (action == 121) {
                return false;
            }
        }
        if (FileUtils.fileExistsAndNotEmpty(entity.strFilePath)) {
            if (fileType != 0) {
                if (fileType != 2) {
                    return hasAction(sDownloadedOtherFileActionList, action);
                }
                return hasAction(sDownloadedVideoActionList, action);
            }
            return hasAction(sDownloadedImageActionList, action);
        }
        if (fileType != 0) {
            if (fileType != 2) {
                return hasAction(sUnDownloadedOtherFileActionList, action);
            }
            return hasAction(sUnDownloadedVideoActionList, action);
        }
        return hasAction(sUnDownloadedImageActionList, action);
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    public void checkDeviceStatus(@Nullable CheckDeviceStatusReq req, @Nullable IFlashTransferCheckDeviceStatusCallback callback) {
        BaseQQAppInterface baseQQAppInterface;
        com.tencent.qqnt.kernel.api.q flashTransferService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) req, (Object) callback);
            return;
        }
        b bVar = new b(callback);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null && (flashTransferService = ((IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "all")).getFlashTransferService()) != null) {
            flashTransferService.checkDeviceStatus(req, bVar);
        }
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public FileManagerEntity convertToFileManagerEntity(@NotNull File file, @NotNull String uploaderName, boolean isFromBrowse, boolean isQueryDB) {
        BaseQQAppInterface baseQQAppInterface;
        IQQFileDataCenter iQQFileDataCenter;
        FileManagerEntity fileManagerEntity;
        String uploaderName2 = uploaderName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (FileManagerEntity) iPatchRedirector.redirect((short) 15, this, file, uploaderName2, Boolean.valueOf(isFromBrowse), Boolean.valueOf(isQueryDB));
        }
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(uploaderName2, "uploaderName");
        String str = file.saveFilePath;
        boolean fileExists = FileUtils.fileExists(str);
        FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str2 = null;
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null) {
            iQQFileDataCenter = (IQQFileDataCenter) baseQQAppInterface.getRuntimeService(IQQFileDataCenter.class, "");
        } else {
            iQQFileDataCenter = null;
        }
        if (isQueryDB && iQQFileDataCenter != null) {
            fileManagerEntity = iQQFileDataCenter.queryFileEntityByUuid(file.physical.f359199id);
        } else {
            fileManagerEntity = null;
        }
        if (fileManagerEntity != null) {
            fileManagerEntity2.nSessionId = fileManagerEntity.nSessionId;
            if (TextUtils.isEmpty(uploaderName)) {
                uploaderName2 = fileManagerEntity.peerNick;
            }
            fileManagerEntity2.peerNick = uploaderName2;
            if (FileUtils.fileExists(fileManagerEntity.strFilePath)) {
                str = fileManagerEntity.strFilePath;
                fileExists = true;
            }
        } else {
            if (!fileExists) {
                long generateSessionId = generateSessionId();
                fileManagerEntity2.nSessionId = generateSessionId;
                sBrowsingSessionIdMap.put(file.cliFileId, Long.valueOf(generateSessionId));
            } else {
                HashMap<String, Long> hashMap = sBrowsingSessionIdMap;
                Long l3 = hashMap.get(file.cliFileId);
                if (l3 != null) {
                    fileManagerEntity2.nSessionId = l3.longValue();
                    hashMap.remove(file.cliFileId);
                } else {
                    fileManagerEntity2.nSessionId = generateSessionId();
                }
            }
            fileManagerEntity2.peerNick = uploaderName2;
        }
        if (baseQQAppInterface != null) {
            str2 = baseQQAppInterface.getCurrentAccountUin();
        }
        fileManagerEntity2.selfUin = str2;
        String str3 = file.fileSetId;
        fileManagerEntity2.fileSetId = str3;
        fileManagerEntity2.Uuid = file.physical.f359199id;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("fileid=%s|filesetid=%s", Arrays.copyOf(new Object[]{file.srvFileId, str3}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        fileManagerEntity2.fileIdCrc = format;
        fileManagerEntity2.fileName = file.name;
        fileManagerEntity2.setFilePath(str);
        fileManagerEntity2.fileSize = file.fileSize;
        fileManagerEntity2.nFileType = ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).getFileType(fileManagerEntity2.fileName);
        if (fileExists) {
            fileManagerEntity2.cloudType = 3;
            java.io.File file2 = new java.io.File(str);
            if (file2.exists()) {
                fileManagerEntity2.setFilePath(file2.getPath());
            }
        } else {
            fileManagerEntity2.cloudType = 17;
            fileManagerEntity2.setFilePath("");
        }
        fileManagerEntity2.nOpType = 58;
        fileManagerEntity2.bSend = false;
        if (isFromBrowse) {
            sIsBrowsingFileExisted = fileExists;
        }
        return fileManagerEntity2;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public String downloadThumbImage(@Nullable String urlString, @NotNull String localPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this, (Object) urlString, (Object) localPath);
        }
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        if (TextUtils.isEmpty(urlString)) {
            return "";
        }
        try {
            URLConnection openConnection = new URL(urlString).openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            Bitmap bitmap = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            if (saveImage(bitmap, localPath)) {
                return localPath;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e(TAG, 1, "downloadThumbImage failed. localPath: " + localPath + ", msg: " + e16.getMessage());
        }
        java.io.File file = new java.io.File(localPath);
        if (file.exists()) {
            file.delete();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public String getCenterActivityScheme() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("&has_send_entrance=");
        if (hasSendEntrance()) {
            str = "1";
        } else {
            str = "0";
        }
        sb5.append(str);
        return CENTER_ACTIVITY_SCHEME + sb5.toString();
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public String getDownloadActivityScheme(@NotNull String filesetId, int fromSource, int entryId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, filesetId, Integer.valueOf(fromSource), Integer.valueOf(entryId));
        }
        Intrinsics.checkNotNullParameter(filesetId, "filesetId");
        return getDownloadActivityScheme(filesetId, fromSource, entryId, "");
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public String getFileCacheRootDirectory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        String g16 = com.tencent.qqnt.util.file.a.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getFileCacheRootDirectory()");
        return g16;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public String getFileSaveRootDirectory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        String h16 = com.tencent.qqnt.util.file.a.h();
        Intrinsics.checkNotNullExpressionValue(h16, "getFileSaveRootDirectory()");
        return h16;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public String getFlashTransferErrHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String name = FlashTransferErrHandler.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "FlashTransferErrHandler::class.java.name");
        return name;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public BusinessObserver getFlashTransferErrObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public qb1.d getFlashTransferFileBrowser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (qb1.d) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return FlashTransferFileBrowser.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public Class<? extends Object> getFlashTransferJumpParserClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.flashtransfer.jump.f.class;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public String getFlashTransferProgressHandlerName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String name = FlashTransferProgressHandler.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "FlashTransferProgressHandler::class.java.name");
        return name;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public BusinessObserver getFlashTransferProgressObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new d();
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public IFlashTransferServiceDeviceStatusListener getFlashTransferServiceDeviceStatusListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (IFlashTransferServiceDeviceStatusListener) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return new e();
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public IFlashTransferServiceDownloadListener getFlashTransferServiceDownloadListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (IFlashTransferServiceDownloadListener) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new f();
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public IFlashTransferTaskInfoListener getFlashTransferTaskInfoListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IFlashTransferTaskInfoListener) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        lazyInitBroadcastReceiver();
        FlashTransferTaskInfoListenerImpl c16 = FlashTransferTaskInfoListenerImpl.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getInstance()");
        return c16;
    }

    public final int getSessionIdx() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.sessionIdx;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    public int getShareWeChatOverSizeResId(@Nullable String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this, (Object) filePath)).intValue();
        }
        int fileType = ((IFileManagerUtil) QRoute.api(IFileManagerUtil.class)).getFileType(filePath);
        if (fileType != 0) {
            if (fileType != 2) {
                return R.string.f1350800h;
            }
            return R.string.f1352400x;
        }
        return R.string.f1351500o;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public String getTencentDocSupportedExtension(@Nullable String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this, (Object) filePath);
        }
        String j3 = com.tencent.mobileqq.filemanager.util.q.j(filePath);
        Intrinsics.checkNotNullExpressionValue(j3, "getExtension(filePath)");
        String lowerCase = j3.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        if (lowerCase != null && lowerCase.length() != 0) {
            if (sFileType == null) {
                HashMap<String, Integer> hashMap = new HashMap<>();
                sFileType = hashMap;
                Intrinsics.checkNotNull(hashMap);
                hashMap.put(".doc", 3);
                HashMap<String, Integer> hashMap2 = sFileType;
                Intrinsics.checkNotNull(hashMap2);
                hashMap2.put(".docx", 3);
                HashMap<String, Integer> hashMap3 = sFileType;
                Intrinsics.checkNotNull(hashMap3);
                hashMap3.put(".xls", 6);
                HashMap<String, Integer> hashMap4 = sFileType;
                Intrinsics.checkNotNull(hashMap4);
                hashMap4.put(".xlsx", 6);
                HashMap<String, Integer> hashMap5 = sFileType;
                Intrinsics.checkNotNull(hashMap5);
                hashMap5.put(".csv", 6);
                HashMap<String, Integer> hashMap6 = sFileType;
                Intrinsics.checkNotNull(hashMap6);
                hashMap6.put(".ppt", 7);
                HashMap<String, Integer> hashMap7 = sFileType;
                Intrinsics.checkNotNull(hashMap7);
                hashMap7.put(".pptx", 7);
                HashMap<String, Integer> hashMap8 = sFileType;
                Intrinsics.checkNotNull(hashMap8);
                hashMap8.put(".pdf", 9);
                HashMap<String, Integer> hashMap9 = sFileType;
                Intrinsics.checkNotNull(hashMap9);
                hashMap9.put(".txt", 10);
            }
            HashMap<String, Integer> hashMap10 = sFileType;
            Intrinsics.checkNotNull(hashMap10);
            String lowerCase2 = lowerCase.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            if (hashMap10.containsKey(lowerCase2)) {
                String substring = lowerCase.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return "";
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public String getThumbImgSaveRootDirectory(@NotNull String filesetId) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this, (Object) filesetId);
        }
        Intrinsics.checkNotNullParameter(filesetId, "filesetId");
        if (TextUtils.isEmpty(filesetId)) {
            str = "";
        } else {
            str = '/' + filesetId;
        }
        String str2 = getFileCacheRootDirectory() + "/thumb" + str;
        java.io.File file = new java.io.File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    public boolean hasFlashTransferEntrance() {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        Boolean bool2 = sHasFlashTransferEntrance;
        if (bool2 != null) {
            Intrinsics.checkNotNull(bool2);
            return bool2.booleanValue();
        }
        getReceiverConfig();
        if (TextUtils.isEmpty(sReceiverConfig)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(sReceiverConfig);
            if (jSONObject.has("has_flash_transfer_entrance")) {
                bool = Boolean.valueOf(jSONObject.getBoolean("has_flash_transfer_entrance"));
            } else {
                bool = Boolean.FALSE;
            }
            sHasFlashTransferEntrance = bool;
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "hasFlashTransferEntrance parse json failed. " + QLog.getStackTraceString(e16));
            return false;
        }
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    public boolean hasSendEntrance() {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        Boolean bool2 = sHasSendEntrance;
        if (bool2 != null) {
            Intrinsics.checkNotNull(bool2);
            return bool2.booleanValue();
        }
        getSenderConfig();
        if (TextUtils.isEmpty(sSenderConfig)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(sSenderConfig);
            if (jSONObject.has("has_send_entrance")) {
                bool = Boolean.valueOf(jSONObject.getBoolean("has_send_entrance"));
            } else {
                bool = Boolean.FALSE;
            }
            sHasSendEntrance = bool;
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "hasSendEntrance parse json failed. " + QLog.getStackTraceString(e16));
            return false;
        }
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    public void initFlashTransferService() {
        BaseQQAppInterface baseQQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        com.tencent.qqnt.kernel.api.q flashTransferService = ((IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "all")).getFlashTransferService();
        if (flashTransferService == null) {
            QLog.e(TAG, 1, "initFlashTransferService failed. service == null.");
            return;
        }
        QLog.i(TAG, 1, "initFlashTransferService.");
        if (sFlashTransferTaskInfoListener == null) {
            sFlashTransferTaskInfoListener = getFlashTransferTaskInfoListener();
        }
        IFlashTransferTaskInfoListener iFlashTransferTaskInfoListener = sFlashTransferTaskInfoListener;
        if (iFlashTransferTaskInfoListener != null) {
            iFlashTransferTaskInfoListener.onTransferTaskInfoUpdate(null);
            flashTransferService.addFlashTransferTaskInfoListener(iFlashTransferTaskInfoListener);
        }
        flashTransferService.addFileSetDownloadListener(getFlashTransferServiceDownloadListener());
        flashTransferService.addDeviceStatusListener(getFlashTransferServiceDeviceStatusListener());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[Catch: Exception -> 0x00fb, TryCatch #0 {Exception -> 0x00fb, blocks: (B:10:0x0042, B:12:0x0057, B:16:0x0062, B:21:0x006f, B:23:0x007a, B:26:0x0081, B:28:0x008a, B:31:0x009c, B:33:0x00cb, B:35:0x00d4, B:37:0x00dd, B:42:0x00e9, B:44:0x00f7), top: B:9:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e9 A[Catch: Exception -> 0x00fb, TryCatch #0 {Exception -> 0x00fb, blocks: (B:10:0x0042, B:12:0x0057, B:16:0x0062, B:21:0x006f, B:23:0x007a, B:26:0x0081, B:28:0x008a, B:31:0x009c, B:33:0x00cb, B:35:0x00d4, B:37:0x00dd, B:42:0x00e9, B:44:0x00f7), top: B:9:0x0042 }] */
    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean interceptFlashTransferUrl(@NotNull final Context context, @NotNull String url, final int fromSource, final int entryId) {
        Uri parse;
        String host;
        String path;
        boolean z16;
        final BaseQQAppInterface baseQQAppInterface;
        boolean startsWith$default;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, context, url, Integer.valueOf(fromSource), Integer.valueOf(entryId))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            parse = Uri.parse(url);
            host = parse.getHost();
            path = parse.getPath();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "interceptFlashTransferUrl", e16);
        }
        if (Intrinsics.areEqual(host, FLASH_TRANSFER_HOST) || Intrinsics.areEqual(host, FLASH_TRANSFER_HOST_TEST)) {
            if (path != null && path.length() != 0) {
                z16 = false;
                if (!z16) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime instanceof BaseQQAppInterface) {
                        baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
                    } else {
                        baseQQAppInterface = null;
                    }
                    if (baseQQAppInterface != null) {
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, SHORT_URL_PREFIX, false, 2, null);
                        if (startsWith$default) {
                            com.tencent.qqnt.kernel.api.q flashTransferService = ((IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "all")).getFlashTransferService();
                            if (flashTransferService == null) {
                                return false;
                            }
                            String substring = path.substring(3);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                            QLog.d(TAG, 1, "interceptFlashTransferUrl code=" + substring);
                            flashTransferService.getFileSetIdByCode(substring, new IFlashTransferServiceGetFileSetIdByCodeCallback() { // from class: com.tencent.mobileqq.flashtransfer.api.impl.b
                                @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetIdByCodeCallback
                                public final void onGetFileSetIdByCode(String str, int i3, String str2) {
                                    FlashTransferApiImpl.interceptFlashTransferUrl$lambda$1(BaseQQAppInterface.this, context, this, fromSource, entryId, str, i3, str2);
                                }
                            });
                            return true;
                        }
                        if (Intrinsics.areEqual(path, FLASH_TRANSFER_PATH)) {
                            String queryParameter = parse.getQueryParameter(KEY_FILE_SET_ID);
                            if (queryParameter != null && queryParameter.length() != 0) {
                                z17 = false;
                                if (!z17) {
                                    ax c16 = bi.c(baseQQAppInterface, context, getDownloadActivityScheme(queryParameter, fromSource, entryId));
                                    if (c16 != null) {
                                        c16.b();
                                    }
                                    return true;
                                }
                            }
                            z17 = true;
                            if (!z17) {
                            }
                        }
                        return false;
                    }
                    return false;
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    public boolean isDisabledAioMsgOpen() {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        Boolean bool2 = sIsDisabledAioMsgOpen;
        if (bool2 != null) {
            Intrinsics.checkNotNull(bool2);
            return bool2.booleanValue();
        }
        getReceiverConfig();
        if (TextUtils.isEmpty(sReceiverConfig)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(sReceiverConfig);
            if (jSONObject.has("is_disabled_aio_msg_open")) {
                bool = Boolean.valueOf(jSONObject.getBoolean("is_disabled_aio_msg_open"));
            } else {
                bool = Boolean.FALSE;
            }
            sIsDisabledAioMsgOpen = bool;
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "isDisabledAioMsgOpen parse json failed. " + QLog.getStackTraceString(e16));
            return false;
        }
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    public boolean isFlashTransferFile(@Nullable String filePath) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) filePath)).booleanValue();
        }
        if (filePath != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(filePath, getFileSaveRootDirectory(), false, 2, null);
            return startsWith$default;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    public boolean isTencentDocFileSizeExceeded(int fileType, long size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, this, Integer.valueOf(fileType), Long.valueOf(size))).booleanValue();
        }
        if (fileType != 3 && fileType != 6) {
            if (size > 1073741824) {
                return true;
            }
            return false;
        }
        if (size > QZoneHelper.Constants.SUPPORT_MIX_MUSIC_DEFAULT) {
            return true;
        }
        return false;
    }

    public final void setSessionIdx(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.sessionIdx = i3;
        }
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    public void tryResumeFailedTransfer() {
        BaseQQAppInterface baseQQAppInterface;
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.q flashTransferService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (!isResumeFailedTransfer()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null && (iKernelService = (IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "all")) != null && (flashTransferService = iKernelService.getFlashTransferService()) != null) {
            flashTransferService.resumeAllUnfinishedTasks();
        }
    }

    public final void updateCleanDB(@NotNull String filename, @NotNull String localPath) {
        BaseQQAppInterface baseQQAppInterface;
        af storageCleanService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) filename, (Object) localPath);
            return;
        }
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null && (storageCleanService = ((IKernelService) baseQQAppInterface.getRuntimeService(IKernelService.class, "")).getStorageCleanService()) != null && FileUtils.fileExistsAndNotEmpty(localPath)) {
            java.io.File file = new java.io.File(localPath);
            storageCleanService.addNewDownloadOrUploadFile(new CleanFileDetail(0L, 0L, "", 0, file.lastModified(), filename, file.length(), localPath, true));
        }
    }

    public final void updateDB(@NotNull File file, @NotNull String uploaderName) {
        BaseQQAppInterface baseQQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) file, (Object) uploaderName);
            return;
        }
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(uploaderName, "uploaderName");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        String str = file.name;
        Intrinsics.checkNotNullExpressionValue(str, "file.name");
        String str2 = file.saveFilePath;
        Intrinsics.checkNotNullExpressionValue(str2, "file.saveFilePath");
        updateCleanDB(str, str2);
        IRuntimeService runtimeService = baseQQAppInterface.getRuntimeService(IQQFileDataCenter.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IQQFileDataCenter iQQFileDataCenter = (IQQFileDataCenter) runtimeService;
        FileManagerEntity convertToFileManagerEntity = convertToFileManagerEntity(file, uploaderName, false, true);
        if (!TextUtils.isEmpty(convertToFileManagerEntity.Uuid)) {
            FileManagerEntity queryFileEntityByUuid = iQQFileDataCenter.queryFileEntityByUuid(convertToFileManagerEntity.Uuid);
            if (queryFileEntityByUuid == null) {
                QLog.i(TAG, 1, "onFileDidFinishDownLoad. insertToFMList. sessionId:" + convertToFileManagerEntity.nSessionId + ", fileName:" + convertToFileManagerEntity.fileName + ", filePath:" + convertToFileManagerEntity.getFilePath() + ", uuid:" + convertToFileManagerEntity.Uuid + ", fileSize:" + convertToFileManagerEntity.fileSize + ", cloudType:" + convertToFileManagerEntity.cloudType + ", peerUin:" + convertToFileManagerEntity.peerUin + ", peerNick:" + convertToFileManagerEntity.peerNick);
                iQQFileDataCenter.insertToFMList(convertToFileManagerEntity);
                return;
            }
            if ((TextUtils.isEmpty(queryFileEntityByUuid.peerUin) || TextUtils.isEmpty(queryFileEntityByUuid.peerNick)) && !TextUtils.isEmpty(convertToFileManagerEntity.peerUin) && !TextUtils.isEmpty(convertToFileManagerEntity.peerNick)) {
                QLog.i(TAG, 1, "onFileDidFinishDownLoad. updateFileEntity. sessionId:" + convertToFileManagerEntity.nSessionId + ", fileName:" + convertToFileManagerEntity.fileName + ", filePath:" + convertToFileManagerEntity.getFilePath() + ", uuid:" + convertToFileManagerEntity.Uuid + ", fileSize:" + convertToFileManagerEntity.fileSize + ", cloudType:" + convertToFileManagerEntity.cloudType + ", peerUin:" + convertToFileManagerEntity.peerUin + ", peerNick:" + convertToFileManagerEntity.peerNick);
                iQQFileDataCenter.updateFileEntity(convertToFileManagerEntity);
            }
        }
    }

    @Override // com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi
    @NotNull
    public String getDownloadActivityScheme(@NotNull String filesetId, int fromSource, int entryId, @Nullable String extParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, filesetId, Integer.valueOf(fromSource), Integer.valueOf(entryId), extParams);
        }
        Intrinsics.checkNotNullParameter(filesetId, "filesetId");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("&has_send_entrance=");
        sb5.append(hasSendEntrance() ? "1" : "0");
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        String format = String.format(DOWNLOAD_ACTIVITY_SCHEME, Arrays.copyOf(new Object[]{filesetId, Integer.valueOf(fromSource), Integer.valueOf(entryId)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        sb7.append(format);
        sb7.append(sb6);
        sb7.append(extParams);
        String sb8 = sb7.toString();
        QLog.i(TAG, 1, "getDownloadActivityScheme. " + sb8);
        return sb8;
    }
}
