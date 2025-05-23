package of2;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qqnt.kernel.nativeinterface.BasicFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.BatchRemoveFileRsp;
import com.tencent.qqnt.kernel.nativeinterface.CheckDeviceStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.DownloadErrorFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.DownloadFinishFileInfo;
import com.tencent.qqnt.kernel.nativeinterface.DownloadOptionParams;
import com.tencent.qqnt.kernel.nativeinterface.File;
import com.tencent.qqnt.kernel.nativeinterface.FileDownloadStatus;
import com.tencent.qqnt.kernel.nativeinterface.FileSet;
import com.tencent.qqnt.kernel.nativeinterface.FileSetDownloadStatus;
import com.tencent.qqnt.kernel.nativeinterface.FileSetDownloadTaskStatus;
import com.tencent.qqnt.kernel.nativeinterface.FileSetSimpleUploadInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileSetUploadProgressInfo;
import com.tencent.qqnt.kernel.nativeinterface.FirstClusteringInfo;
import com.tencent.qqnt.kernel.nativeinterface.FlashFileSetDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferPauseReason;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferPauseTaskType;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferSceneType;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferSendMsgRsp;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferTaskStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferThumbnailDownloadResult;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferThumbnailInfo;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferUploadThumbnailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetCompressedFileFolderRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetDownloadedFileCountRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetFailedFileListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetFileCategoryRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetFileListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetFileSetListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetFilesTransferProgressRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetLocalFileListByStatusesRsp;
import com.tencent.qqnt.kernel.nativeinterface.GetLocalFileListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCheckDeviceStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCheckDownloadStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCleanFailedFilesCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferClusteringListListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCompressedFileListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferDownloadOperationCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFileSetSimpleUploadListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFileSetStatusListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFolderListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetClusteringDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetFailedFileListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetFileCategoryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetFileSetDownloadStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetFilesTransferProgressCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetFirstClusteringListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetLocalFileListByStatusesCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferResumePausedTasksAfterDeviceStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferSendMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceBatchRemoveFileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceCreateFileSetCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceFileTransferCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetCompressedFileFolderCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetDownloadedFileCountCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetIdByCodeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetLastFailedSetTasksCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetLocalFileListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetShareLinkCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceUpdateFlashTransferCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferSetDownLoadFileDirCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferTaskInfoListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferThumbnailDownloadCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferUploadListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.MediaClusteringDetailRsp;
import com.tencent.qqnt.kernel.nativeinterface.MediaClusteringListRsp;
import com.tencent.qqnt.kernel.nativeinterface.NetStatusType;
import com.tencent.qqnt.kernel.nativeinterface.ResumePausedTasksAfterDeviceStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.SimpleFileSetStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDownloadOperationInfo;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\bP\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 R2\u00020\u0001:\u0001PB\u0007\u00a2\u0006\u0004\bu\u0010vJ?\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u0010\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u0011\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u0012\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u0013\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u0014\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u0015\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u0016\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u0017\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u0018\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u0019\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u001a\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u001b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u001c\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u001d\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u001e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u001f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010 \u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010!\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\"\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010#\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010$\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010%\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010&\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010'\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010(\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010)\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010*\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010+\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010,\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010-\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010.\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010/\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u00100\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u00101\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u00102\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u00103\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u00104\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u00105\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u00106\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u00107\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u00108\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u00109\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010:\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010;\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010<\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010=\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010>\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010?\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010@\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010A\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010B\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010C\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010D\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010E\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010F\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010G\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010H\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010I\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010J\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010K\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010L\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010M\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010N\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010O\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010P\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010Q\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010R\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010S\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010T\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010U\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010V\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010W\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010X\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010Y\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002JI\u0010\\\u001a\u0004\u0018\u00010\u00022\u0006\u0010[\u001a\u00020Z2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0016R \u0010`\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020^0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010_R \u0010c\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020a0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010_R \u0010f\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020d0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010_R \u0010h\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020d0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010_R \u0010j\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020i0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010_R \u0010l\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020k0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010_R \u0010n\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020m0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010_R \u0010p\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020o0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010_R \u0010r\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020q0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010_R \u0010t\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020s0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010_\u00a8\u0006w"}, d2 = {"Lof2/bh;", "Li01/e;", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "B", "H0", "N", "I", "H", "E", "P", BdhLogUtil.LogTag.Tag_Req, "M", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "n0", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k0", "z0", "E0", "X", "q0", "Y", "r0", "F0", "u", "v0", "w0", "j", "f0", "y0", "D0", "W", "p0", "x0", "V", "o0", "C0", "B0", "G0", "v", "A0", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "h0", "g0", "c", "d", "c0", "b0", "o", "p", "j0", "i0", "u0", "r", "l0", "t0", UserInfo.SEX_FEMALE, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "L", "K", "i", "e0", "J", BdhLogUtil.LogTag.Tag_Conn, "O", "Z", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "t", "m0", "a", "a0", "G", "g", "d0", "y", "U", "s0", ExifInterface.LATITUDE_SOUTH, "T", "", "method", "call", "", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferUploadListener;", "Ljava/util/Map;", "fileSetUploadListenerMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;", "e", "fileSetDownloadListenerMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFileSetStatusListener;", "f", "fileSetSimpleStatusListenerMap", tl.h.F, "desktopFileSetSimpleStatusListenerMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFileSetSimpleUploadListener;", "fileSetSimpleUploadInfoListenerMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferTaskInfoListener;", "flashTransferTaskInfoListenerMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferClusteringListListener;", "fileSetClusteringListListenerMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFolderListener;", "folderListenerMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferCompressedFileListener;", "compressedFileListenerMap", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDeviceStatusListener;", "deviceStatusListenerMap", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bh extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<String, IFlashTransferUploadListener> fileSetUploadListenerMap = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Map<String, IFlashTransferServiceDownloadListener> fileSetDownloadListenerMap = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Map<String, IFlashTransferFileSetStatusListener> fileSetSimpleStatusListenerMap = new LinkedHashMap();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Map<String, IFlashTransferFileSetStatusListener> desktopFileSetSimpleStatusListenerMap = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Map<String, IFlashTransferFileSetSimpleUploadListener> fileSetSimpleUploadInfoListenerMap = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Map<String, IFlashTransferTaskInfoListener> flashTransferTaskInfoListenerMap = new LinkedHashMap();

    /* renamed from: C, reason: from kotlin metadata */
    private final Map<String, IFlashTransferClusteringListListener> fileSetClusteringListListenerMap = new LinkedHashMap();

    /* renamed from: D, reason: from kotlin metadata */
    private final Map<String, IFlashTransferFolderListener> folderListenerMap = new LinkedHashMap();

    /* renamed from: E, reason: from kotlin metadata */
    private final Map<String, IFlashTransferCompressedFileListener> compressedFileListenerMap = new LinkedHashMap();

    /* renamed from: F, reason: from kotlin metadata */
    private final Map<String, IFlashTransferServiceDeviceStatusListener> deviceStatusListenerMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"of2/bh$aa", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetFileSetIdByCodeCallback;", "", "fileSetId", "", "result", "errMsg", "", "onGetFileSetIdByCode", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class aa implements IFlashTransferServiceGetFileSetIdByCodeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422602a;

        aa(Function1<Object, Unit> function1) {
            this.f422602a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetIdByCodeCallback
        public void onGetFileSetIdByCode(String fileSetId, int result, String errMsg) {
            Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetFileSetIdByCode");
            arrayList.add(fileSetId);
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            Function1<Object, Unit> function1 = this.f422602a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$ab", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetFileSetListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetFileSetListRsp;", "rsp", "", "onGetFileSetList", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class ab implements IFlashTransferServiceGetFileSetListCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422603a;

        ab(Function1<Object, Unit> function1) {
            this.f422603a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetListCallback
        public void onGetFileSetList(GetFileSetListRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetFileSetList");
            Object[] a16 = ba.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422603a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$ac", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferGetFilesTransferProgressCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetFilesTransferProgressRsp;", "rsp", "", "onGetFilesTransferProgress", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class ac implements IFlashTransferGetFilesTransferProgressCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422604a;

        ac(Function1<Object, Unit> function1) {
            this.f422604a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetFilesTransferProgressCallback
        public void onGetFilesTransferProgress(GetFilesTransferProgressRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetFilesTransferProgress");
            Object[] a16 = bd.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422604a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$ad", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetLocalFileListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetLocalFileListRsp;", "rsp", "", "onGetLocalFileList", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class ad implements IFlashTransferServiceGetLocalFileListCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422605a;

        ad(Function1<Object, Unit> function1) {
            this.f422605a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetLocalFileListCallback
        public void onGetLocalFileList(GetLocalFileListRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetLocalFileList");
            Object[] a16 = bg.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422605a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$ae", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferGetLocalFileListByStatusesCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetLocalFileListByStatusesRsp;", "rsp", "", "onGetLocalFileListByStatuses", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class ae implements IFlashTransferGetLocalFileListByStatusesCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422606a;

        ae(Function1<Object, Unit> function1) {
            this.f422606a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetLocalFileListByStatusesCallback
        public void onGetLocalFileListByStatuses(GetLocalFileListByStatusesRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetLocalFileListByStatuses");
            Object[] a16 = bf.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422606a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"of2/bh$af", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetShareLinkCallback;", "", "shareLink", "", "expireTimestamp", "", "result", "errMsg", "", "onGetShareLink", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class af implements IFlashTransferServiceGetShareLinkCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422607a;

        af(Function1<Object, Unit> function1) {
            this.f422607a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetShareLinkCallback
        public void onGetShareLink(String shareLink, long expireTimestamp, int result, String errMsg) {
            Intrinsics.checkNotNullParameter(shareLink, "shareLink");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetShareLink");
            arrayList.add(shareLink);
            arrayList.add(String.valueOf(expireTimestamp));
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            Function1<Object, Unit> function1 = this.f422607a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"of2/bh$ag", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferDownloadOperationCallback;", "", "result", "", "errMsg", "extraInfo", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class ag implements IFlashTransferDownloadOperationCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422608a;

        ag(Function1<Object, Unit> function1) {
            this.f422608a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferDownloadOperationCallback
        public void onResult(int result, String errMsg, int extraInfo) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            arrayList.add(String.valueOf(extraInfo));
            Function1<Object, Unit> function1 = this.f422608a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"of2/bh$ah", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferDownloadOperationCallback;", "", "result", "", "errMsg", "extraInfo", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class ah implements IFlashTransferDownloadOperationCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422609a;

        ah(Function1<Object, Unit> function1) {
            this.f422609a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferDownloadOperationCallback
        public void onResult(int result, String errMsg, int extraInfo) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            arrayList.add(String.valueOf(extraInfo));
            Function1<Object, Unit> function1 = this.f422609a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"of2/bh$ai", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferDownloadOperationCallback;", "", "result", "", "errMsg", "extraInfo", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class ai implements IFlashTransferDownloadOperationCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422610a;

        ai(Function1<Object, Unit> function1) {
            this.f422610a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferDownloadOperationCallback
        public void onResult(int result, String errMsg, int extraInfo) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            arrayList.add(String.valueOf(extraInfo));
            Function1<Object, Unit> function1 = this.f422610a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"of2/bh$aj", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferDownloadOperationCallback;", "", "result", "", "errMsg", "extraInfo", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class aj implements IFlashTransferDownloadOperationCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422611a;

        aj(Function1<Object, Unit> function1) {
            this.f422611a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferDownloadOperationCallback
        public void onResult(int result, String errMsg, int extraInfo) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            arrayList.add(String.valueOf(extraInfo));
            Function1<Object, Unit> function1 = this.f422611a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$ak", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferResumePausedTasksAfterDeviceStatusCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/ResumePausedTasksAfterDeviceStatusRsp;", "rsp", "", "onResumePausedTasksAfterDeviceStatus", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class ak implements IFlashTransferResumePausedTasksAfterDeviceStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422612a;

        ak(Function1<Object, Unit> function1) {
            this.f422612a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferResumePausedTasksAfterDeviceStatusCallback
        public void onResumePausedTasksAfterDeviceStatus(ResumePausedTasksAfterDeviceStatusRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResumePausedTasksAfterDeviceStatus");
            Object[] a16 = bt.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422612a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"of2/bh$al", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetLastFailedSetTasksCallback;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferTaskStatusInfo;", "infos", "", "onGetLastFailedSetTaskInfoList", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class al implements IFlashTransferServiceGetLastFailedSetTasksCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422613a;

        al(Function1<Object, Unit> function1) {
            this.f422613a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetLastFailedSetTasksCallback
        public void onGetLastFailedSetTaskInfoList(ArrayList<FlashTransferTaskStatusInfo> infos) {
            Intrinsics.checkNotNullParameter(infos, "infos");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetLastFailedSetTaskInfoList");
            arrayList.add(Integer.valueOf(infos.size()));
            Iterator<T> it = infos.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.aj.a((FlashTransferTaskStatusInfo) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422613a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"of2/bh$am", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferSendMsgCallback;", "", "errCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferSendMsgRsp;", "rsp", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class am implements IFlashTransferSendMsgCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422614a;

        am(Function1<Object, Unit> function1) {
            this.f422614a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferSendMsgCallback
        public void onResult(int errCode, String errMsg, FlashTransferSendMsgRsp rsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(errCode));
            arrayList.add(errMsg);
            if (rsp != null) {
                Object[] a16 = of2.ai.a(rsp);
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            } else {
                arrayList.add(new byte[0]);
            }
            Function1<Object, Unit> function1 = this.f422614a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$an", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferSetDownLoadFileDirCallback;", "", QzoneIPCModule.RESULT_CODE, "", "onSetDownLoadFileDirResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class an implements IFlashTransferSetDownLoadFileDirCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422615a;

        an(Function1<Object, Unit> function1) {
            this.f422615a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferSetDownLoadFileDirCallback
        public void onSetDownLoadFileDirResult(int resultCode) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onSetDownLoadFileDirResult");
            arrayList.add(String.valueOf(resultCode));
            Function1<Object, Unit> function1 = this.f422615a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"of2/bh$ao", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "", "result", "", "errMsg", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class ao implements IOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422616a;

        ao(Function1<Object, Unit> function1) {
            this.f422616a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int result, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            Function1<Object, Unit> function1 = this.f422616a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"of2/bh$ap", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferDownloadOperationCallback;", "", "result", "", "errMsg", "extraInfo", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class ap implements IFlashTransferDownloadOperationCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422617a;

        ap(Function1<Object, Unit> function1) {
            this.f422617a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferDownloadOperationCallback
        public void onResult(int result, String errMsg, int extraInfo) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            arrayList.add(String.valueOf(extraInfo));
            Function1<Object, Unit> function1 = this.f422617a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"of2/bh$aq", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferDownloadOperationCallback;", "", "result", "", "errMsg", "extraInfo", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class aq implements IFlashTransferDownloadOperationCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422618a;

        aq(Function1<Object, Unit> function1) {
            this.f422618a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferDownloadOperationCallback
        public void onResult(int result, String errMsg, int extraInfo) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            arrayList.add(String.valueOf(extraInfo));
            Function1<Object, Unit> function1 = this.f422618a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"of2/bh$ar", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceFileTransferCallback;", "", "ret", "", "url", "", "expireTimestampSeconds", "", "onTransferResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class ar implements IFlashTransferServiceFileTransferCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422619a;

        ar(Function1<Object, Unit> function1) {
            this.f422619a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceFileTransferCallback
        public void onTransferResult(int ret, String url, long expireTimestampSeconds) {
            Intrinsics.checkNotNullParameter(url, "url");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onTransferResult");
            arrayList.add(String.valueOf(ret));
            arrayList.add(url);
            arrayList.add(String.valueOf(expireTimestampSeconds));
            Function1<Object, Unit> function1 = this.f422619a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"of2/bh$as", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferThumbnailDownloadCallback;", "", "result", "", "errMsg", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class as implements IFlashTransferThumbnailDownloadCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422620a;

        as(Function1<Object, Unit> function1) {
            this.f422620a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferThumbnailDownloadCallback
        public void onResult(int result, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            Function1<Object, Unit> function1 = this.f422620a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"of2/bh$at", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferDownloadOperationCallback;", "", "result", "", "errMsg", "extraInfo", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class at implements IFlashTransferDownloadOperationCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422621a;

        at(Function1<Object, Unit> function1) {
            this.f422621a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferDownloadOperationCallback
        public void onResult(int result, String errMsg, int extraInfo) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            arrayList.add(String.valueOf(extraInfo));
            Function1<Object, Unit> function1 = this.f422621a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"of2/bh$au", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferDownloadOperationCallback;", "", "result", "", "errMsg", "extraInfo", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class au implements IFlashTransferDownloadOperationCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422622a;

        au(Function1<Object, Unit> function1) {
            this.f422622a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferDownloadOperationCallback
        public void onResult(int result, String errMsg, int extraInfo) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            arrayList.add(String.valueOf(extraInfo));
            Function1<Object, Unit> function1 = this.f422622a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"of2/bh$av", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferThumbnailDownloadCallback;", "", "result", "", "errMsg", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class av implements IFlashTransferThumbnailDownloadCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422623a;

        av(Function1<Object, Unit> function1) {
            this.f422623a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferThumbnailDownloadCallback
        public void onResult(int result, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            Function1<Object, Unit> function1 = this.f422623a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"of2/bh$aw", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceUpdateFlashTransferCallback;", "", "seq", "result", "", "errMsg", "", "onUpdateFlashTransfer", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class aw implements IFlashTransferServiceUpdateFlashTransferCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422624a;

        aw(Function1<Object, Unit> function1) {
            this.f422624a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceUpdateFlashTransferCallback
        public void onUpdateFlashTransfer(int seq, int result, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onUpdateFlashTransfer");
            arrayList.add(Integer.valueOf(seq));
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            Function1<Object, Unit> function1 = this.f422624a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"of2/bh$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferCompressedFileListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/File;", "file", "Lcom/tencent/qqnt/kernel/nativeinterface/FileSetDownloadStatus;", "status", "", "onCompressedFileDownloadStatusChange", "", "saveDirPath", "onCompressedFileSaveDirPathChange", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements IFlashTransferCompressedFileListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422625a;

        b(Function1<Object, Unit> function1) {
            this.f422625a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCompressedFileListener
        public void onCompressedFileDownloadStatusChange(File file, FileSetDownloadStatus status) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(status, "status");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onCompressedFileDownloadStatusChange");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            arrayList.add(Integer.valueOf(status.ordinal()));
            Function1<Object, Unit> function1 = this.f422625a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCompressedFileListener
        public void onCompressedFileSaveDirPathChange(File file, String saveDirPath) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(saveDirPath, "saveDirPath");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onCompressedFileSaveDirPathChange");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            arrayList.add(saveDirPath);
            Function1<Object, Unit> function1 = this.f422625a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"of2/bh$c", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFileSetStatusListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SimpleFileSetStatusInfo;", "infos", "", "onFileSetStatusUpdate", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements IFlashTransferFileSetStatusListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422626a;

        c(Function1<Object, Unit> function1) {
            this.f422626a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFileSetStatusListener
        public void onFileSetStatusUpdate(ArrayList<SimpleFileSetStatusInfo> infos) {
            Intrinsics.checkNotNullParameter(infos, "infos");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileSetStatusUpdate");
            arrayList.add(Integer.valueOf(infos.size()));
            Iterator<T> it = infos.iterator();
            while (it.hasNext()) {
                Object[] a16 = bv.a((SimpleFileSetStatusInfo) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422626a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"of2/bh$d", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDeviceStatusListener;", "", "seq", "", "msg", "Lcom/tencent/qqnt/kernel/nativeinterface/NetStatusType;", "networkStatus", "", "onNetStatusChanged", "", "isEnough", "onAvailableStorageChange", "showBackToForegroundAlert", "showLowBatterylAlert", "showSleepAlert", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements IFlashTransferServiceDeviceStatusListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422627a;

        d(Function1<Object, Unit> function1) {
            this.f422627a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener
        public void onAvailableStorageChange(int seq, String msg2, boolean isEnough) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onAvailableStorageChange");
            arrayList.add(Integer.valueOf(seq));
            arrayList.add(msg2);
            arrayList.add(Integer.valueOf(isEnough ? 1 : 0));
            Function1<Object, Unit> function1 = this.f422627a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener
        public void onNetStatusChanged(int seq, String msg2, NetStatusType networkStatus) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(networkStatus, "networkStatus");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onNetStatusChanged");
            arrayList.add(Integer.valueOf(seq));
            arrayList.add(msg2);
            arrayList.add(Integer.valueOf(networkStatus.ordinal()));
            Function1<Object, Unit> function1 = this.f422627a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener
        public void showBackToForegroundAlert(int seq, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("showBackToForegroundAlert");
            arrayList.add(Integer.valueOf(seq));
            arrayList.add(msg2);
            Function1<Object, Unit> function1 = this.f422627a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener
        public void showLowBatterylAlert(int seq, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("showLowBatterylAlert");
            arrayList.add(Integer.valueOf(seq));
            arrayList.add(msg2);
            Function1<Object, Unit> function1 = this.f422627a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener
        public void showSleepAlert(int seq, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("showSleepAlert");
            arrayList.add(Integer.valueOf(seq));
            arrayList.add(msg2);
            Function1<Object, Unit> function1 = this.f422627a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$e", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferClusteringListListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/MediaClusteringListRsp;", "rsp", "", "onClusteringListUpdate", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class e implements IFlashTransferClusteringListListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422628a;

        e(Function1<Object, Unit> function1) {
            this.f422628a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferClusteringListListener
        public void onClusteringListUpdate(MediaClusteringListRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onClusteringListUpdate");
            Object[] a16 = bn.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422628a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000i\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0016\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0017\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0018\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u001aH\u0016J(\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u001e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0002H\u0016J\u001e\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020 0\u0002H\u0016J&\u0010#\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00022\u0006\u0010\"\u001a\u00020\rH\u0016J&\u0010$\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00022\u0006\u0010\"\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0016J \u0010,\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00132\u0006\u0010&\u001a\u00020+H\u0016J\u0018\u0010-\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00132\u0006\u0010&\u001a\u00020+H\u0016J\u0016\u00100\u001a\u00020\u00052\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u0002H\u0016\u00a8\u00061"}, d2 = {"of2/bh$f", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/File;", "fileList", "", "onFileListDownloadWaitDownloading", "file", "onFileDidStartDownload", "", "hasDownLoadedBytes", "totalBytes", "onFileDownloadProgressChanged", "", "curSpeedKbps", "remainDownLoadSeconds", "onFileDownloadSpeedChange", "onFileListDidFinishDownload", "errorCode", "", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "onFileDownloadDidError", "onFileListDownloadDidError", "onFileListDownloadDidCancel", "onFileListDownloadDidPause", "filesetId", "Lcom/tencent/qqnt/kernel/nativeinterface/BasicFileInfo;", "onProfilerFileListDownloadWaitDownloading", "onProfilerFileDidStartDownload", "onProfilerFileDownloadProgressChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/DownloadFinishFileInfo;", "onProfilerFileListDidFinishDownload", "Lcom/tencent/qqnt/kernel/nativeinterface/DownloadErrorFileInfo;", "onProfilerFileListDownloadDidError", "reason", "onProfilerFileListDownloadDidCancel", "onProfilerFileListDownloadDidPause", "Lcom/tencent/qqnt/kernel/nativeinterface/UserDownloadOperationInfo;", "info", "onUserDownloadOperationResultNotify", "Lcom/tencent/qqnt/kernel/nativeinterface/FileSetDownloadTaskStatus;", "status", "fileSetId", "Lcom/tencent/qqnt/kernel/nativeinterface/FlashFileSetDownloadInfo;", "onFileSetDownloadTaskStatusChange", "onFileSetDownloadTaskProgressChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferThumbnailDownloadResult;", "resultList", "onThumbnailDownloadResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class f implements IFlashTransferServiceDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422629a;

        f(Function1<Object, Unit> function1) {
            this.f422629a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileDidStartDownload(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileDidStartDownload");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileDownloadDidError(File file, int errorCode, String errorReason) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(errorReason, "errorReason");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileDownloadDidError");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            arrayList.add(String.valueOf(errorCode));
            arrayList.add(errorReason);
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileDownloadProgressChanged(File file, long hasDownLoadedBytes, long totalBytes) {
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileDownloadProgressChanged");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            arrayList.add(String.valueOf(hasDownLoadedBytes));
            arrayList.add(String.valueOf(totalBytes));
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileDownloadSpeedChange(File file, int curSpeedKbps, int remainDownLoadSeconds) {
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileDownloadSpeedChange");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            arrayList.add(String.valueOf(curSpeedKbps));
            arrayList.add(String.valueOf(remainDownLoadSeconds));
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileListDidFinishDownload(ArrayList<File> fileList) {
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileListDidFinishDownload");
            arrayList.add(Integer.valueOf(fileList.size()));
            Iterator<T> it = fileList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.u.a((File) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileListDownloadDidCancel(ArrayList<File> fileList) {
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileListDownloadDidCancel");
            arrayList.add(Integer.valueOf(fileList.size()));
            Iterator<T> it = fileList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.u.a((File) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileListDownloadDidError(ArrayList<File> fileList) {
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileListDownloadDidError");
            arrayList.add(Integer.valueOf(fileList.size()));
            Iterator<T> it = fileList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.u.a((File) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileListDownloadDidPause(ArrayList<File> fileList) {
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileListDownloadDidPause");
            arrayList.add(Integer.valueOf(fileList.size()));
            Iterator<T> it = fileList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.u.a((File) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileListDownloadWaitDownloading(ArrayList<File> fileList) {
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileListDownloadWaitDownloading");
            arrayList.add(Integer.valueOf(fileList.size()));
            Iterator<T> it = fileList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.u.a((File) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileSetDownloadTaskProgressChanged(String fileSetId, FlashFileSetDownloadInfo info) {
            Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
            Intrinsics.checkNotNullParameter(info, "info");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileSetDownloadTaskProgressChanged");
            arrayList.add(fileSetId);
            Object[] a16 = of2.ae.a(info);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onFileSetDownloadTaskStatusChange(FileSetDownloadTaskStatus status, String fileSetId, FlashFileSetDownloadInfo info) {
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
            Intrinsics.checkNotNullParameter(info, "info");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileSetDownloadTaskStatusChange");
            arrayList.add(Integer.valueOf(status.ordinal()));
            arrayList.add(fileSetId);
            Object[] a16 = of2.ae.a(info);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileDidStartDownload(String filesetId, BasicFileInfo file) {
            Intrinsics.checkNotNullParameter(filesetId, "filesetId");
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onProfilerFileDidStartDownload");
            arrayList.add(filesetId);
            Object[] a16 = of2.b.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileDownloadProgressChanged(String filesetId, BasicFileInfo file, long hasDownLoadedBytes, long totalBytes) {
            Intrinsics.checkNotNullParameter(filesetId, "filesetId");
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onProfilerFileDownloadProgressChanged");
            arrayList.add(filesetId);
            Object[] a16 = of2.b.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            arrayList.add(String.valueOf(hasDownLoadedBytes));
            arrayList.add(String.valueOf(totalBytes));
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileListDidFinishDownload(String filesetId, ArrayList<DownloadFinishFileInfo> fileList) {
            Intrinsics.checkNotNullParameter(filesetId, "filesetId");
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onProfilerFileListDidFinishDownload");
            arrayList.add(filesetId);
            arrayList.add(Integer.valueOf(fileList.size()));
            Iterator<T> it = fileList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.o.a((DownloadFinishFileInfo) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileListDownloadDidCancel(String filesetId, ArrayList<BasicFileInfo> fileList, int reason) {
            Intrinsics.checkNotNullParameter(filesetId, "filesetId");
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onProfilerFileListDownloadDidCancel");
            arrayList.add(filesetId);
            arrayList.add(Integer.valueOf(fileList.size()));
            Iterator<T> it = fileList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.b.a((BasicFileInfo) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            arrayList.add(String.valueOf(reason));
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileListDownloadDidError(String filesetId, ArrayList<DownloadErrorFileInfo> fileList) {
            Intrinsics.checkNotNullParameter(filesetId, "filesetId");
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onProfilerFileListDownloadDidError");
            arrayList.add(filesetId);
            arrayList.add(Integer.valueOf(fileList.size()));
            Iterator<T> it = fileList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.n.a((DownloadErrorFileInfo) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileListDownloadDidPause(String filesetId, ArrayList<BasicFileInfo> fileList, int reason) {
            Intrinsics.checkNotNullParameter(filesetId, "filesetId");
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onProfilerFileListDownloadDidPause");
            arrayList.add(filesetId);
            arrayList.add(Integer.valueOf(fileList.size()));
            Iterator<T> it = fileList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.b.a((BasicFileInfo) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            arrayList.add(String.valueOf(reason));
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onProfilerFileListDownloadWaitDownloading(String filesetId, ArrayList<BasicFileInfo> fileList) {
            Intrinsics.checkNotNullParameter(filesetId, "filesetId");
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onProfilerFileListDownloadWaitDownloading");
            arrayList.add(filesetId);
            arrayList.add(Integer.valueOf(fileList.size()));
            Iterator<T> it = fileList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.b.a((BasicFileInfo) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onThumbnailDownloadResult(ArrayList<FlashTransferThumbnailDownloadResult> resultList) {
            Intrinsics.checkNotNullParameter(resultList, "resultList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onThumbnailDownloadResult");
            arrayList.add(Integer.valueOf(resultList.size()));
            Iterator<T> it = resultList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.ak.a((FlashTransferThumbnailDownloadResult) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener
        public void onUserDownloadOperationResultNotify(UserDownloadOperationInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onUserDownloadOperationResultNotify");
            Object[] a16 = cc.a(info);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422629a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"of2/bh$g", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFileSetStatusListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SimpleFileSetStatusInfo;", "infos", "", "onFileSetStatusUpdate", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class g implements IFlashTransferFileSetStatusListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422630a;

        g(Function1<Object, Unit> function1) {
            this.f422630a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFileSetStatusListener
        public void onFileSetStatusUpdate(ArrayList<SimpleFileSetStatusInfo> infos) {
            Intrinsics.checkNotNullParameter(infos, "infos");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileSetStatusUpdate");
            arrayList.add(Integer.valueOf(infos.size()));
            Iterator<T> it = infos.iterator();
            while (it.hasNext()) {
                Object[] a16 = bv.a((SimpleFileSetStatusInfo) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422630a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"of2/bh$h", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFileSetSimpleUploadListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileSetSimpleUploadInfo;", "infos", "", "onFileSetSimpleUploadInfoChanged", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class h implements IFlashTransferFileSetSimpleUploadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422631a;

        h(Function1<Object, Unit> function1) {
            this.f422631a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFileSetSimpleUploadListener
        public void onFileSetSimpleUploadInfoChanged(ArrayList<FileSetSimpleUploadInfo> infos) {
            Intrinsics.checkNotNullParameter(infos, "infos");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileSetSimpleUploadInfoChanged");
            arrayList.add(Integer.valueOf(infos.size()));
            Iterator<T> it = infos.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.y.a((FileSetSimpleUploadInfo) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422631a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0018"}, d2 = {"of2/bh$i", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferUploadListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/File;", "file", "", "onFileDidStartUpload", "onFileUploadStatusChanged", "", "uploadedBytes", "totalBytes", "onFileUploadProgressChanged", "onFileDidFinishUpload", "onFileUploadDidError", "onFileUploadDidCancel", "Lcom/tencent/qqnt/kernel/nativeinterface/FileSet;", "fileSet", "onFileSetUploadStatusChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/FileSetUploadProgressInfo;", "progress", "onFileSetUploadProgressChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferUploadThumbnailInfo;", "info", "onThumbnailGeneratePath", "onFileStaticStatusChanged", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class i implements IFlashTransferUploadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422632a;

        i(Function1<Object, Unit> function1) {
            this.f422632a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferUploadListener
        public void onFileDidFinishUpload(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileDidFinishUpload");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422632a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferUploadListener
        public void onFileDidStartUpload(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileDidStartUpload");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422632a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferUploadListener
        public void onFileSetUploadProgressChanged(FileSetUploadProgressInfo progress) {
            Intrinsics.checkNotNullParameter(progress, "progress");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileSetUploadProgressChanged");
            Object[] a16 = of2.z.a(progress);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422632a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferUploadListener
        public void onFileSetUploadStatusChanged(FileSet fileSet) {
            Intrinsics.checkNotNullParameter(fileSet, "fileSet");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileSetUploadStatusChanged");
            Object[] a16 = of2.w.a(fileSet);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422632a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferUploadListener
        public void onFileStaticStatusChanged(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileStaticStatusChanged");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422632a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferUploadListener
        public void onFileUploadDidCancel(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileUploadDidCancel");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422632a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferUploadListener
        public void onFileUploadDidError(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileUploadDidError");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422632a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferUploadListener
        public void onFileUploadProgressChanged(File file, long uploadedBytes, long totalBytes) {
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileUploadProgressChanged");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            arrayList.add(String.valueOf(uploadedBytes));
            arrayList.add(String.valueOf(totalBytes));
            Function1<Object, Unit> function1 = this.f422632a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferUploadListener
        public void onFileUploadStatusChanged(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFileUploadStatusChanged");
            Object[] a16 = of2.u.a(file);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422632a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferUploadListener
        public void onThumbnailGeneratePath(FlashTransferUploadThumbnailInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onThumbnailGeneratePath");
            Object[] a16 = of2.am.a(info);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422632a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"of2/bh$j", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferTaskInfoListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferTaskStatusInfo;", "infos", "", "onTransferTaskInfoUpdate", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class j implements IFlashTransferTaskInfoListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422633a;

        j(Function1<Object, Unit> function1) {
            this.f422633a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferTaskInfoListener
        public void onTransferTaskInfoUpdate(ArrayList<FlashTransferTaskStatusInfo> infos) {
            Intrinsics.checkNotNullParameter(infos, "infos");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onTransferTaskInfoUpdate");
            arrayList.add(Integer.valueOf(infos.size()));
            Iterator<T> it = infos.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.aj.a((FlashTransferTaskStatusInfo) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422633a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\b"}, d2 = {"of2/bh$k", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFolderListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/File;", "folders", "", "onFolderStatusInfoUpdate", "onFolderProgressChanged", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class k implements IFlashTransferFolderListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422634a;

        k(Function1<Object, Unit> function1) {
            this.f422634a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFolderListener
        public void onFolderProgressChanged(ArrayList<File> folders) {
            Intrinsics.checkNotNullParameter(folders, "folders");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFolderProgressChanged");
            arrayList.add(Integer.valueOf(folders.size()));
            Iterator<T> it = folders.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.u.a((File) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422634a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFolderListener
        public void onFolderStatusInfoUpdate(ArrayList<File> folders) {
            Intrinsics.checkNotNullParameter(folders, "folders");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onFolderStatusInfoUpdate");
            arrayList.add(Integer.valueOf(folders.size()));
            Iterator<T> it = folders.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.u.a((File) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422634a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"of2/bh$l", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferGetFileSetDownloadStatusCallback;", "", "result", "", "fileSetId", "Lcom/tencent/qqnt/kernel/nativeinterface/FileSetDownloadTaskStatus;", "status", "Lcom/tencent/qqnt/kernel/nativeinterface/FlashFileSetDownloadInfo;", "info", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class l implements IFlashTransferGetFileSetDownloadStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422635a;

        l(Function1<Object, Unit> function1) {
            this.f422635a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetFileSetDownloadStatusCallback
        public void onResult(int result, String fileSetId, FileSetDownloadTaskStatus status, FlashFileSetDownloadInfo info) {
            Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(info, "info");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(fileSetId);
            arrayList.add(Integer.valueOf(status.ordinal()));
            Object[] a16 = of2.ae.a(info);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422635a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$m", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceBatchRemoveFileCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchRemoveFileRsp;", "response", "", "onBatchRemoveFile", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class m implements IFlashTransferServiceBatchRemoveFileCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422636a;

        m(Function1<Object, Unit> function1) {
            this.f422636a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceBatchRemoveFileCallback
        public void onBatchRemoveFile(BatchRemoveFileRsp response) {
            Intrinsics.checkNotNullParameter(response, "response");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onBatchRemoveFile");
            Object[] a16 = of2.d.a(response);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422636a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$n", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferCheckDeviceStatusCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckDeviceStatusRsp;", "rsp", "", "onCheckDeviceStatus", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class n implements IFlashTransferCheckDeviceStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422637a;

        n(Function1<Object, Unit> function1) {
            this.f422637a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCheckDeviceStatusCallback
        public void onCheckDeviceStatus(CheckDeviceStatusRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onCheckDeviceStatus");
            Object[] a16 = of2.g.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422637a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"of2/bh$o", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferCheckDownloadStatusCallback;", "", "seq", "result", "", "msg", "fileId", "Lcom/tencent/qqnt/kernel/nativeinterface/FileDownloadStatus;", "fileDownloadStatus", "", "OnCheckDownloadStatus", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class o implements IFlashTransferCheckDownloadStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422638a;

        o(Function1<Object, Unit> function1) {
            this.f422638a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCheckDownloadStatusCallback
        public void OnCheckDownloadStatus(int seq, int result, String msg2, String fileId, FileDownloadStatus fileDownloadStatus) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(fileId, "fileId");
            Intrinsics.checkNotNullParameter(fileDownloadStatus, "fileDownloadStatus");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("OnCheckDownloadStatus");
            arrayList.add(Integer.valueOf(seq));
            arrayList.add(Integer.valueOf(result));
            arrayList.add(msg2);
            arrayList.add(fileId);
            arrayList.add(Integer.valueOf(fileDownloadStatus.ordinal()));
            Function1<Object, Unit> function1 = this.f422638a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"of2/bh$p", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferCleanFailedFilesCallback;", "", "ret", "", "msg", "", "onCleanFailedFilesResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class p implements IFlashTransferCleanFailedFilesCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422639a;

        p(Function1<Object, Unit> function1) {
            this.f422639a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCleanFailedFilesCallback
        public void onCleanFailedFilesResult(int ret, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onCleanFailedFilesResult");
            arrayList.add(Integer.valueOf(ret));
            arrayList.add(msg2);
            Function1<Object, Unit> function1 = this.f422639a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"of2/bh$q", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceCreateFileSetCallback;", "", "seq", "", "fileSetId", "result", "errMsg", "", "onCreateFlashTransferUploadTask", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class q implements IFlashTransferServiceCreateFileSetCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422640a;

        q(Function1<Object, Unit> function1) {
            this.f422640a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceCreateFileSetCallback
        public void onCreateFlashTransferUploadTask(int seq, String fileSetId, int result, String errMsg) {
            Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onCreateFlashTransferUploadTask");
            arrayList.add(Integer.valueOf(seq));
            arrayList.add(fileSetId);
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            Function1<Object, Unit> function1 = this.f422640a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"of2/bh$r", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "", "result", "", "errMsg", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class r implements IOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422641a;

        r(Function1<Object, Unit> function1) {
            this.f422641a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int result, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onResult");
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            Function1<Object, Unit> function1 = this.f422641a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$s", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetCompressedFileFolderCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetCompressedFileFolderRsp;", "rsp", "", "onGetCompressedFileFolder", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class s implements IFlashTransferServiceGetCompressedFileFolderCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422642a;

        s(Function1<Object, Unit> function1) {
            this.f422642a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetCompressedFileFolderCallback
        public void onGetCompressedFileFolder(GetCompressedFileFolderRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetCompressedFileFolder");
            Object[] a16 = of2.aq.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422642a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$t", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetDownloadedFileCountCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetDownloadedFileCountRsp;", "rsp", "", "onGetDownloadedFileCount", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class t implements IFlashTransferServiceGetDownloadedFileCountCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422643a;

        t(Function1<Object, Unit> function1) {
            this.f422643a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetDownloadedFileCountCallback
        public void onGetDownloadedFileCount(GetDownloadedFileCountRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetDownloadedFileCount");
            Object[] a16 = of2.as.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422643a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$u", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferGetFailedFileListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetFailedFileListRsp;", "rsp", "", "onGetFailedFileList", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class u implements IFlashTransferGetFailedFileListCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422644a;

        u(Function1<Object, Unit> function1) {
            this.f422644a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetFailedFileListCallback
        public void onGetFailedFileList(GetFailedFileListRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetFailedFileList");
            Object[] a16 = of2.au.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422644a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$v", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferGetFileCategoryCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetFileCategoryRsp;", "rsp", "", "onGetFileCategory", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class v implements IFlashTransferGetFileCategoryCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422645a;

        v(Function1<Object, Unit> function1) {
            this.f422645a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetFileCategoryCallback
        public void onGetFileCategory(GetFileCategoryRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetFileCategory");
            Object[] a16 = of2.aw.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422645a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$w", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetFileListCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetFileListRsp;", "rsp", "", "onGetFileList", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class w implements IFlashTransferServiceGetFileListCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422646a;

        w(Function1<Object, Unit> function1) {
            this.f422646a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileListCallback
        public void onGetFileList(GetFileListRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetFileList");
            Object[] a16 = ay.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422646a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"of2/bh$x", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetFileSetCallback;", "", "seq", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/FileSet;", "fileSet", "", QAdRewardDefine$VideoParams.ISCACHE, "", "onGetFileSet", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class x implements IFlashTransferServiceGetFileSetCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422647a;

        x(Function1<Object, Unit> function1) {
            this.f422647a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetCallback
        public void onGetFileSet(int seq, int result, String errMsg, FileSet fileSet, boolean isCache) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(fileSet, "fileSet");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetFileSet");
            arrayList.add(Integer.valueOf(seq));
            arrayList.add(Integer.valueOf(result));
            arrayList.add(errMsg);
            Object[] a16 = of2.w.a(fileSet);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            arrayList.add(Integer.valueOf(isCache ? 1 : 0));
            Function1<Object, Unit> function1 = this.f422647a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"of2/bh$y", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferGetClusteringDetailCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/MediaClusteringDetailRsp;", "rsp", "", "onGetClusteringDetail", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class y implements IFlashTransferGetClusteringDetailCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422648a;

        y(Function1<Object, Unit> function1) {
            this.f422648a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetClusteringDetailCallback
        public void onGetClusteringDetail(MediaClusteringDetailRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetClusteringDetail");
            Object[] a16 = bk.a(rsp);
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            Function1<Object, Unit> function1 = this.f422648a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\f"}, d2 = {"of2/bh$z", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferGetFirstClusteringListCallback;", "", "seq", "errCode", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/FirstClusteringInfo;", "firstClusteringList", "", "onGetFirstClusteringList", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class z implements IFlashTransferGetFirstClusteringListCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f422649a;

        z(Function1<Object, Unit> function1) {
            this.f422649a = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferGetFirstClusteringListCallback
        public void onGetFirstClusteringList(int seq, int errCode, String errMsg, ArrayList<FirstClusteringInfo> firstClusteringList) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(firstClusteringList, "firstClusteringList");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new byte[0]);
            arrayList.add("onGetFirstClusteringList");
            arrayList.add(Integer.valueOf(seq));
            arrayList.add(Integer.valueOf(errCode));
            arrayList.add(errMsg);
            arrayList.add(Integer.valueOf(firstClusteringList.size()));
            Iterator<T> it = firstClusteringList.iterator();
            while (it.hasNext()) {
                Object[] a16 = of2.ad.a((FirstClusteringInfo) it.next());
                arrayList.add(Integer.valueOf(a16.length));
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
            }
            Function1<Object, Unit> function1 = this.f422649a;
            if (function1 != null) {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                function1.invoke(array);
            }
        }
    }

    private final void A(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        int parseInt = Integer.parseInt((String) next);
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next2).intValue();
        ArrayList<File> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next3 = it.next();
            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
            int intValue2 = ((Integer) next3).intValue();
            Object[] objArr2 = new Object[intValue2];
            for (int i16 = 0; i16 < intValue2; i16++) {
                objArr2[i16] = it.next();
            }
            arrayList.add(of2.u.b(objArr2));
        }
        flashTransferService.cleanFailedFiles(parseInt, arrayList, new p(callback));
    }

    private final void A0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.startFileTransferUrl(of2.u.b(objArr2), new ar(callback));
    }

    private final void B(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        int intValue2 = ((Integer) next2).intValue();
        Object[] objArr2 = new Object[intValue2];
        for (int i3 = 0; i3 < intValue2; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.createFlashTransferUploadTask(intValue, of2.m.a(objArr2), new q(callback));
    }

    private final void B0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        ArrayList<FlashTransferThumbnailInfo> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next2 = it.next();
            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
            int intValue2 = ((Integer) next2).intValue();
            Object[] objArr2 = new Object[intValue2];
            for (int i16 = 0; i16 < intValue2; i16++) {
                objArr2[i16] = it.next();
            }
            arrayList.add(of2.al.b(objArr2));
        }
        flashTransferService.startThumbnailListDownload(arrayList, new as(callback));
    }

    private final void C(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        flashTransferService.doAIOFlashTransferBubbleActionWithStatus((String) next, ((Integer) next2).intValue(), new r(callback));
    }

    private final void C0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next2).intValue();
        ArrayList<File> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next3 = it.next();
            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
            int intValue2 = ((Integer) next3).intValue();
            Object[] objArr2 = new Object[intValue2];
            for (int i16 = 0; i16 < intValue2; i16++) {
                objArr2[i16] = it.next();
            }
            arrayList.add(of2.u.b(objArr2));
        }
        flashTransferService.stopFileListDownLoad(str, arrayList, new at(callback));
    }

    private final void D(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.getCompressedFileFolder(of2.ap.a(objArr2), new s(callback));
    }

    private final void D0(Object params, Function1<Object, Unit> callback) {
        DownloadOptionParams downloadOptionParams = null;
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        Object next2 = it.next();
        if (!(next2 instanceof byte[])) {
            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) next2).intValue();
            Object[] objArr2 = new Object[intValue];
            for (int i3 = 0; i3 < intValue; i3++) {
                objArr2[i3] = it.next();
            }
            downloadOptionParams = of2.q.a(objArr2);
        }
        flashTransferService.stopFileSetDownload(str, downloadOptionParams, new au(callback));
    }

    private final void E(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.getDownloadedFileCount(of2.ar.a(objArr2), new t(callback));
    }

    private final void E0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.stopFileSetUpload((String) next);
    }

    private final void F(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.getFailedFileList(of2.at.a(objArr2), new u(callback));
    }

    private final void F0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.stopFileUpload((String) next);
    }

    private final void G(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.getFileCategoryList(of2.av.a(objArr2), new v(callback));
    }

    private final void G0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        ArrayList<FlashTransferThumbnailInfo> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next2 = it.next();
            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
            int intValue2 = ((Integer) next2).intValue();
            Object[] objArr2 = new Object[intValue2];
            for (int i16 = 0; i16 < intValue2; i16++) {
                objArr2[i16] = it.next();
            }
            arrayList.add(of2.al.b(objArr2));
        }
        flashTransferService.stopThumbnailListDownload(arrayList, new av(callback));
    }

    private final void H(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.getFileList(ax.a(objArr2), new w(callback));
    }

    private final void H0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        int intValue2 = ((Integer) next2).intValue();
        Object[] objArr2 = new Object[intValue2];
        for (int i3 = 0; i3 < intValue2; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.updateFlashTransfer(intValue, bz.a(objArr2), new aw(callback));
    }

    private final void I(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.getFileSet(bb.a(objArr2), new x(callback));
    }

    private final void J(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.getFileSetClusteringDetail(bj.a(objArr2), new y(callback));
    }

    private final void K(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.getFileSetClusteringList(bm.a(objArr2));
    }

    private final void L(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
        FlashTransferSceneType[] values = FlashTransferSceneType.values();
        Object next3 = it.next();
        Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
        flashTransferService.getFileSetFirstClusteringList(intValue, (String) next2, values[((Integer) next3).intValue()], new z(callback));
    }

    private final void M(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.getFileSetIdByCode((String) next, new aa(callback));
    }

    private final void N(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.getFileSetList(az.a(objArr2), new ab(callback));
    }

    private final void O(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.getFilesTransferProgress(bc.a(objArr2), new ac(callback));
    }

    private final void P(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next2;
        Object next3 = it.next();
        Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
        int intValue2 = ((Integer) next3).intValue();
        ArrayList arrayList = new ArrayList(intValue2);
        for (int i3 = 0; i3 < intValue2; i3++) {
            Object next4 = it.next();
            Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) next4);
        }
        flashTransferService.getLocalFileList(intValue, str, new ArrayList<>(arrayList), new ad(callback));
    }

    private final void Q(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.getLocalFileListByStatuses(be.a(objArr2), new ae(callback));
    }

    private final void R(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.getShareLinkReq((String) next, new af(callback));
    }

    private final void S(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        ArrayIteratorKt.iterator(objArr);
        flashTransferService.onSystemGoingToSleep();
    }

    private final void T(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        ArrayIteratorKt.iterator(objArr);
        flashTransferService.onSystemWokeUp();
    }

    private final void U(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        FlashTransferPauseReason[] values = FlashTransferPauseReason.values();
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        FlashTransferPauseReason flashTransferPauseReason = values[((Integer) next).intValue()];
        FlashTransferPauseTaskType[] values2 = FlashTransferPauseTaskType.values();
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        flashTransferService.pauseAllTasks(flashTransferPauseReason, values2[((Integer) next2).intValue()]);
    }

    private final void V(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next2).intValue();
        ArrayList<File> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next3 = it.next();
            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
            int intValue2 = ((Integer) next3).intValue();
            Object[] objArr2 = new Object[intValue2];
            for (int i16 = 0; i16 < intValue2; i16++) {
                objArr2[i16] = it.next();
            }
            arrayList.add(of2.u.b(objArr2));
        }
        flashTransferService.pauseFileListDownLoad(str, arrayList, new ag(callback));
    }

    private final void W(Object params, Function1<Object, Unit> callback) {
        DownloadOptionParams downloadOptionParams = null;
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        Object next2 = it.next();
        if (!(next2 instanceof byte[])) {
            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) next2).intValue();
            Object[] objArr2 = new Object[intValue];
            for (int i3 = 0; i3 < intValue; i3++) {
                objArr2[i3] = it.next();
            }
            downloadOptionParams = of2.q.a(objArr2);
        }
        flashTransferService.pauseFileSetDownload(str, downloadOptionParams, new ah(callback));
    }

    private final void X(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.pauseFileSetUpload((String) next);
    }

    private final void Y(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.pauseFileUpload((String) next);
    }

    private final void Z(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.pollFilesTransferProgress(bc.a(objArr2));
    }

    private final void a(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        b bVar = new b(callback);
        flashTransferService.addCompressedFileListener(bVar);
        this.compressedFileListenerMap.put((String) next, bVar);
    }

    private final void a0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        IFlashTransferCompressedFileListener iFlashTransferCompressedFileListener = this.compressedFileListenerMap.get(str);
        if (iFlashTransferCompressedFileListener != null) {
            flashTransferService.removeCompressedFileListener(iFlashTransferCompressedFileListener);
            this.compressedFileListenerMap.remove(str);
        }
    }

    private final void b0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        IFlashTransferFileSetStatusListener iFlashTransferFileSetStatusListener = this.desktopFileSetSimpleStatusListenerMap.get(str);
        if (iFlashTransferFileSetStatusListener != null) {
            flashTransferService.removeDesktopFileSetSimpleStatusListener(iFlashTransferFileSetStatusListener);
            this.desktopFileSetSimpleStatusListenerMap.remove(str);
        }
    }

    private final void c(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        c cVar = new c(callback);
        flashTransferService.addDesktopFileSetSimpleStatusListener(cVar);
        this.desktopFileSetSimpleStatusListenerMap.put((String) next, cVar);
    }

    private final void c0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        ArrayList arrayList = new ArrayList(intValue);
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next2 = it.next();
            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) next2);
        }
        flashTransferService.removeDesktopFileSetSimpleStatusMonitoring(new ArrayList<>(arrayList));
    }

    private final void d(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        ArrayList arrayList = new ArrayList(intValue);
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next2 = it.next();
            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) next2);
        }
        flashTransferService.addDesktopFileSetSimpleStatusMonitoring(new ArrayList<>(arrayList));
    }

    private final void d0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        IFlashTransferServiceDeviceStatusListener iFlashTransferServiceDeviceStatusListener = this.deviceStatusListenerMap.get(str);
        if (iFlashTransferServiceDeviceStatusListener != null) {
            flashTransferService.removeDeviceStatusListener(iFlashTransferServiceDeviceStatusListener);
            this.deviceStatusListenerMap.remove(str);
        }
    }

    private final void e0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        IFlashTransferClusteringListListener iFlashTransferClusteringListListener = this.fileSetClusteringListListenerMap.get(str);
        if (iFlashTransferClusteringListListener != null) {
            flashTransferService.removeFileSetClusteringListListener(iFlashTransferClusteringListListener);
            this.fileSetClusteringListListenerMap.remove(str);
        }
    }

    private final void f0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        IFlashTransferServiceDownloadListener iFlashTransferServiceDownloadListener = this.fileSetDownloadListenerMap.get(str);
        if (iFlashTransferServiceDownloadListener != null) {
            flashTransferService.removeFileSetDownloadListener(iFlashTransferServiceDownloadListener);
            this.fileSetDownloadListenerMap.remove(str);
        }
    }

    private final void g(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        d dVar = new d(callback);
        flashTransferService.addDeviceStatusListener(dVar);
        this.deviceStatusListenerMap.put((String) next, dVar);
    }

    private final void g0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.removeFileSetSimpleStatusListener((String) next);
        this.fileSetSimpleStatusListenerMap.clear();
    }

    private final void h0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next2).intValue();
        ArrayList arrayList = new ArrayList(intValue);
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next3 = it.next();
            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) next3);
        }
        flashTransferService.removeFileSetSimpleStatusMonitoring(str, new ArrayList<>(arrayList));
    }

    private final void i(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        e eVar = new e(callback);
        flashTransferService.addFileSetClusteringListListener(eVar);
        this.fileSetClusteringListListenerMap.put((String) next, eVar);
    }

    private final void i0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        IFlashTransferFileSetSimpleUploadListener iFlashTransferFileSetSimpleUploadListener = this.fileSetSimpleUploadInfoListenerMap.get(str);
        if (iFlashTransferFileSetSimpleUploadListener != null) {
            flashTransferService.removeFileSetSimpleUploadInfoListener(iFlashTransferFileSetSimpleUploadListener);
            this.fileSetSimpleUploadInfoListenerMap.remove(str);
        }
    }

    private final void j(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        f fVar = new f(callback);
        flashTransferService.addFileSetDownloadListener(fVar);
        this.fileSetDownloadListenerMap.put((String) next, fVar);
    }

    private final void j0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        ArrayList arrayList = new ArrayList(intValue);
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next2 = it.next();
            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) next2);
        }
        flashTransferService.removeFileSetSimpleUploadInfoMonitoring(new ArrayList<>(arrayList));
    }

    private final void k0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        IFlashTransferUploadListener iFlashTransferUploadListener = this.fileSetUploadListenerMap.get(str);
        if (iFlashTransferUploadListener != null) {
            flashTransferService.removeFileSetUploadListener(iFlashTransferUploadListener);
            this.fileSetUploadListenerMap.remove(str);
        }
    }

    private final void l(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
        g gVar = new g(callback);
        flashTransferService.addFileSetSimpleStatusListener((String) next, gVar);
        this.fileSetSimpleStatusListenerMap.put((String) next2, gVar);
    }

    private final void l0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        IFlashTransferTaskInfoListener iFlashTransferTaskInfoListener = this.flashTransferTaskInfoListenerMap.get(str);
        if (iFlashTransferTaskInfoListener != null) {
            flashTransferService.removeFlashTransferTaskInfoListener(iFlashTransferTaskInfoListener);
            this.flashTransferTaskInfoListenerMap.remove(str);
        }
    }

    private final void m(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next2).intValue();
        ArrayList arrayList = new ArrayList(intValue);
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next3 = it.next();
            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) next3);
        }
        flashTransferService.addFileSetSimpleStatusMonitoring(str, new ArrayList<>(arrayList));
    }

    private final void m0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        IFlashTransferFolderListener iFlashTransferFolderListener = this.folderListenerMap.get(str);
        if (iFlashTransferFolderListener != null) {
            flashTransferService.removeFolderListener(iFlashTransferFolderListener);
            this.folderListenerMap.remove(str);
        }
    }

    private final void n0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        ArrayIteratorKt.iterator(objArr);
        flashTransferService.resumeAllUnfinishedTasks();
    }

    private final void o(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        h hVar = new h(callback);
        flashTransferService.addFileSetSimpleUploadInfoListener(hVar);
        this.fileSetSimpleUploadInfoListenerMap.put((String) next, hVar);
    }

    private final void o0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next2).intValue();
        ArrayList<File> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next3 = it.next();
            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
            int intValue2 = ((Integer) next3).intValue();
            Object[] objArr2 = new Object[intValue2];
            for (int i16 = 0; i16 < intValue2; i16++) {
                objArr2[i16] = it.next();
            }
            arrayList.add(of2.u.b(objArr2));
        }
        flashTransferService.resumeFileListDownLoad(str, arrayList, new ai(callback));
    }

    private final void p(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        ArrayList arrayList = new ArrayList(intValue);
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next2 = it.next();
            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) next2);
        }
        flashTransferService.addFileSetSimpleUploadInfoMonitoring(new ArrayList<>(arrayList));
    }

    private final void p0(Object params, Function1<Object, Unit> callback) {
        DownloadOptionParams downloadOptionParams = null;
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        Object next2 = it.next();
        if (!(next2 instanceof byte[])) {
            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) next2).intValue();
            Object[] objArr2 = new Object[intValue];
            for (int i3 = 0; i3 < intValue; i3++) {
                objArr2[i3] = it.next();
            }
            downloadOptionParams = of2.q.a(objArr2);
        }
        flashTransferService.resumeFileSetDownload(str, downloadOptionParams, new aj(callback));
    }

    private final void q(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        i iVar = new i(callback);
        flashTransferService.addFileSetUploadListener(iVar);
        this.fileSetUploadListenerMap.put((String) next, iVar);
    }

    private final void q0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.resumeFileSetUpload((String) next);
    }

    private final void r(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        j jVar = new j(callback);
        flashTransferService.addFlashTransferTaskInfoListener(jVar);
        this.flashTransferTaskInfoListenerMap.put((String) next, jVar);
    }

    private final void r0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.resumeFileUpload((String) next, (String) next2);
    }

    private final void s0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.resumePausedTasksAfterDeviceStatus(bs.a(objArr2), new ak(callback));
    }

    private final void t(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        k kVar = new k(callback);
        flashTransferService.addFolderListener(kVar);
        this.folderListenerMap.put((String) next, kVar);
    }

    private final void t0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        ArrayIteratorKt.iterator(objArr);
        flashTransferService.retrieveLocalLastFailedSetTasksInfo(new al(callback));
    }

    private final void u(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next2).intValue();
        ArrayList arrayList = new ArrayList(intValue);
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next3 = it.next();
            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) next3);
        }
        flashTransferService.asyncGetThumbnailPath(str, new ArrayList<>(arrayList));
    }

    private final void u0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.sendFlashTransferMsg(of2.ah.a(objArr2), new am(callback));
    }

    private final void v(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.asyncRequestDownLoadStatus((String) next, new l(callback));
    }

    private final void v0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.setDownLoadDefaultFileDir((String) next, new an(callback));
    }

    private final void w(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.batchRemoveFile(of2.c.a(objArr2), new m(callback));
    }

    private final void w0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.setFlashTransferDir((String) next, (String) next2, new ao(callback));
    }

    private final void x(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.cancelPollFilesTransferProgress(of2.e.a(objArr2));
    }

    private final void x0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next2).intValue();
        ArrayList<File> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < intValue; i3++) {
            Object next3 = it.next();
            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
            int intValue2 = ((Integer) next3).intValue();
            Object[] objArr2 = new Object[intValue2];
            for (int i16 = 0; i16 < intValue2; i16++) {
                objArr2[i16] = it.next();
            }
            arrayList.add(of2.u.b(objArr2));
        }
        flashTransferService.startFileListDownLoad(str, arrayList, new ap(callback));
    }

    private final void y(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object[] objArr2 = new Object[intValue];
        for (int i3 = 0; i3 < intValue; i3++) {
            objArr2[i3] = it.next();
        }
        flashTransferService.checkDeviceStatus(of2.f.a(objArr2), new n(callback));
    }

    private final void y0(Object params, Function1<Object, Unit> callback) {
        DownloadOptionParams downloadOptionParams = null;
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        String str = (String) next;
        Object next2 = it.next();
        if (!(next2 instanceof byte[])) {
            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) next2).intValue();
            Object[] objArr2 = new Object[intValue];
            for (int i3 = 0; i3 < intValue; i3++) {
                objArr2[i3] = it.next();
            }
            downloadOptionParams = of2.q.a(objArr2);
        }
        flashTransferService.startFileSetDownload(str, downloadOptionParams, new aq(callback));
    }

    private final void z(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(objArr);
        Object next = it.next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) next).intValue();
        Object next2 = it.next();
        Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
        Object next3 = it.next();
        Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.checkDownloadStatusBeforeLocalFileOper(intValue, (String) next2, (String) next3, new o(callback));
    }

    private final void z0(Object params, Function1<Object, Unit> callback) {
        Object[] objArr = params instanceof Object[] ? (Object[]) params : null;
        if (objArr == null) {
            return;
        }
        if (objArr.length == 0) {
            return;
        }
        IQQNTWrapperSession a16 = bi.a();
        IKernelFlashTransferService flashTransferService = a16 != null ? a16.getFlashTransferService() : null;
        if (flashTransferService == null) {
            return;
        }
        Object next = ArrayIteratorKt.iterator(objArr).next();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
        flashTransferService.startFileSetUpload((String) next);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    public Object call(String method, Object params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2119219457:
                if (method.equals("addFileSetClusteringListListener")) {
                    i(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -2090899042:
                if (method.equals("removeFlashTransferTaskInfoListener")) {
                    l0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -2027466450:
                if (method.equals("sendFlashTransferMsg")) {
                    u0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1838473399:
                if (method.equals("getFileSetClusteringDetail")) {
                    J(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1798127345:
                if (method.equals("getFileSetIdByCode")) {
                    M(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1714974278:
                if (method.equals("setDownLoadDefaultFileDir")) {
                    v0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1701084518:
                if (method.equals("addFileSetUploadListener")) {
                    q(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1653079039:
                if (method.equals("resumeFileSetDownload")) {
                    p0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1628547940:
                if (method.equals("retrieveLocalLastFailedSetTasksInfo")) {
                    t0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1600996425:
                if (method.equals("removeFileSetSimpleUploadInfoListener")) {
                    i0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1511188058:
                if (method.equals("startFileTransferUrl")) {
                    A0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1451336169:
                if (method.equals("asyncGetThumbnailPath")) {
                    u(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1441014121:
                if (method.equals("removeFileSetUploadListener")) {
                    k0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1338784231:
                if (method.equals("getFilesTransferProgress")) {
                    O(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1318410015:
                if (method.equals("addFileSetDownloadListener")) {
                    j(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1272806170:
                if (method.equals("removeFolderListener")) {
                    m0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1145780896:
                if (method.equals("removeDeviceStatusListener")) {
                    d0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1051728434:
                if (method.equals("getFileSetList")) {
                    N(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -866835366:
                if (method.equals("removeFileSetSimpleStatusListener")) {
                    g0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -724906988:
                if (method.equals("checkDownloadStatusBeforeLocalFileOper")) {
                    z(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -633198828:
                if (method.equals("setFlashTransferDir")) {
                    w0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -615734415:
                if (method.equals("addFileSetSimpleStatusMonitoring")) {
                    m(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -572320347:
                if (method.equals("startFileSetUpload")) {
                    z0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -548765936:
                if (method.equals("startThumbnailListDownload")) {
                    B0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -524075434:
                if (method.equals("getDownloadedFileCount")) {
                    E(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -498861666:
                if (method.equals("removeFileSetDownloadListener")) {
                    f0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -495094320:
                if (method.equals("onSystemGoingToSleep")) {
                    S(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -461433603:
                if (method.equals("addDeviceStatusListener")) {
                    g(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -422863346:
                if (method.equals("addFileSetSimpleUploadInfoMonitoring")) {
                    p(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -380209364:
                if (method.equals("startFileSetDownload")) {
                    y0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -379090482:
                if (method.equals("getFileCategoryList")) {
                    G(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -377934785:
                if (method.equals("stopFileUpload")) {
                    F0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -354647071:
                if (method.equals("getCompressedFileFolder")) {
                    D(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -330934788:
                if (method.equals("removeFileSetClusteringListListener")) {
                    e0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -230784744:
                if (method.equals("pauseFileListDownLoad")) {
                    V(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -139894350:
                if (method.equals("updateFlashTransfer")) {
                    H0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -91479421:
                if (method.equals("pauseAllTasks")) {
                    U(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -47262385:
                if (method.equals("resumeFileListDownLoad")) {
                    o0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -11179725:
                if (method.equals("pauseFileUpload")) {
                    Y(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 18409099:
                if (method.equals("removeFileSetSimpleUploadInfoMonitoring")) {
                    j0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 47326437:
                if (method.equals("createFlashTransferUploadTask")) {
                    B(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 87806906:
                if (method.equals("resumeFileSetUpload")) {
                    q0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 175201402:
                if (method.equals("removeDesktopFileSetSimpleStatusMonitoring")) {
                    c0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 181848336:
                if (method.equals("getFileSet")) {
                    I(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 214846997:
                if (method.equals("removeCompressedFileListener")) {
                    a0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 408161859:
                if (method.equals("addFolderListener")) {
                    t(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 415783585:
                if (method.equals("addFlashTransferTaskInfoListener")) {
                    r(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 612314896:
                if (method.equals("checkDeviceStatus")) {
                    y(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 683200367:
                if (method.equals("resumeAllUnfinishedTasks")) {
                    n0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 726255449:
                if (method.equals("doAIOFlashTransferBubbleActionWithStatus")) {
                    C(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 742599282:
                if (method.equals("addCompressedFileListener")) {
                    a(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 747077516:
                if (method.equals("stopFileSetDownload")) {
                    D0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 756991876:
                if (method.equals("startFileListDownLoad")) {
                    x0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 818027075:
                if (method.equals("addDesktopFileSetSimpleStatusListener")) {
                    c(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 948914512:
                if (method.equals("pollFilesTransferProgress")) {
                    Z(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1003512079:
                if (method.equals("getLocalFileList")) {
                    P(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1028190970:
                if (method.equals("batchRemoveFile")) {
                    w(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1044150813:
                if (method.equals("addFileSetSimpleStatusListener")) {
                    l(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1051351441:
                if (method.equals("resumePausedTasksAfterDeviceStatus")) {
                    s0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1105969008:
                if (method.equals("stopThumbnailListDownload")) {
                    G0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1122685463:
                if (method.equals("addDesktopFileSetSimpleStatusMonitoring")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1172550254:
                if (method.equals("removeFileSetSimpleStatusMonitoring")) {
                    h0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1229648554:
                if (method.equals("resumeFileUpload")) {
                    r0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1245255062:
                if (method.equals("getFileSetClusteringList")) {
                    K(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1338824694:
                if (method.equals("cancelPollFilesTransferProgress")) {
                    x(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1342126512:
                if (method.equals("getFileList")) {
                    H(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1343146788:
                if (method.equals("stopFileListDownLoad")) {
                    C0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1356063889:
                if (method.equals("pauseFileSetUpload")) {
                    X(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1385359323:
                if (method.equals("getShareLinkReq")) {
                    R(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1385925638:
                if (method.equals("getFileSetFirstClusteringList")) {
                    L(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1388992251:
                if (method.equals("onSystemWokeUp")) {
                    T(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1612570982:
                if (method.equals("removeDesktopFileSetSimpleStatusListener")) {
                    b0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1666136856:
                if (method.equals("pauseFileSetDownload")) {
                    W(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1677682189:
                if (method.equals("asyncRequestDownLoadStatus")) {
                    v(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1701293617:
                if (method.equals("cleanFailedFiles")) {
                    A(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1752872453:
                if (method.equals("stopFileSetUpload")) {
                    E0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1755853965:
                if (method.equals("getFailedFileList")) {
                    F(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 2058176518:
                if (method.equals("getLocalFileListByStatuses")) {
                    Q(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 2139322362:
                if (method.equals("addFileSetSimpleUploadInfoListener")) {
                    o(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
