package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.dataline.qqnt.activities.MultiPicViewerActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.api.INTMsgProxyUtilsApi;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.drawable.LibraBitmapDrawable;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.history.NTChatHistoryActivity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.aio.utils.b;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filemanager.app.k;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.guild.temp.api.impl.GuildGalleryApiImpl;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qqnt.videoplay.api.view.NTAIOBubbleVideoView;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.aio.adapter.richmedia.provider.AIOFileProvider;
import com.tencent.qqnt.aio.gallery.NTAIOLayerDataLineFragment;
import com.tencent.qqnt.aio.gallery.NTAIOLayerDataLineVideoFragment;
import com.tencent.qqnt.aio.gallery.NTAIOLayerDiscussionFragment;
import com.tencent.qqnt.aio.gallery.NTAIOLayerFragment;
import com.tencent.qqnt.aio.gallery.NTAIOLayerWithoutAllBtnFragment;
import com.tencent.qqnt.aio.gallery.NTAIOLayerWithoutHistoryFragment;
import com.tencent.qqnt.aio.gallery.NTStorageCleanLayerFragment;
import com.tencent.qqnt.aio.gallery.groupemo.NTAIOLayerGroupEmoticonFragment;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerFragment;
import com.tencent.richframework.gallery.RFWLayerImageLoader;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.util.InputMethodUtil;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 e2\u00020\u0001:\u0001fB\u0007\u00a2\u0006\u0004\bc\u0010dJZ\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J0\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\nj\b\u0012\u0004\u0012\u00020\u001e`\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0002J2\u0010+\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0002H\u0002J\"\u0010,\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\u0018\u0010.\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0002H\u0002J4\u00103\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0004H\u0002J\u001a\u00105\u001a\u00020 2\u0006\u00104\u001a\u0002012\b\u0010'\u001a\u0004\u0018\u00010&H\u0002J\u0010\u00106\u001a\u00020\"2\u0006\u00104\u001a\u000201H\u0002J\f\u00107\u001a\u00020\"*\u00020\u0010H\u0002J\f\u00108\u001a\u00020\"*\u00020\u0010H\u0002J\f\u00109\u001a\u00020\"*\u00020\u0010H\u0002J \u0010:\u001a\u00020\u00122\u000e\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u00042\u0006\u00104\u001a\u000201H\u0002J\u001c\u0010<\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u00010&2\b\u0010;\u001a\u0004\u0018\u00010&H\u0002J^\u0010B\u001a\u00020\u00122\u0006\u0010=\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010&2\u0006\u0010?\u001a\u00020\"2\b\u0010@\u001a\u0004\u0018\u00010\u00102\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010A\u001a\u00020\"H\u0016J \u0010E\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010D\u001a\u00020C2\u0006\u00104\u001a\u000201H\u0016J4\u0010F\u001a\u00020\u00122\u0006\u0010=\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\\\u0010K\u001a\u00020\u00122\u0006\u0010=\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020\"2\u0006\u0010I\u001a\u00020\"2\b\u0010@\u001a\u0004\u0018\u00010\u00102\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J \u0010L\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u0002H\u0016J(\u0010L\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010M\u001a\u00020CH\u0016J(\u0010P\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00104\u001a\u0002012\u0006\u0010O\u001a\u00020NH\u0016J*\u0010S\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00104\u001a\u0002012\b\u0010R\u001a\u0004\u0018\u00010QH\u0016J \u0010T\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u0002H\u0016R\u0014\u0010V\u001a\u00020U8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020U8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bX\u0010WR\u0014\u0010Y\u001a\u00020U8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bY\u0010WR\u0014\u0010Z\u001a\u00020U8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bZ\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020U8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b^\u0010WR\u001b\u0010a\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\u00a8\u0006g"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/RichMediaBrowserApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IRichMediaBrowserApi;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "aioMsgItemList", "Landroid/view/View;", "view", "Lru3/b;", "aioImageProviderService", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "Lkotlin/collections/ArrayList;", "data", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "extras", "", "enterToGallery", "Landroid/widget/ImageView;", "imageView", "getEnterImageView", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "itemMediaInfo", "preDownloadLargePic", "Ljava/lang/Class;", "Lcom/tencent/richframework/gallery/RFWLayerFragment;", "getLayerFragmentClass", "findClickImageView", "", "getRootIds", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/filebrowser/e;", "fileBrowserModel", "aioMsgItem", "dataLineAutoPlayVideo", "useTencentDocsOnlinePreview", "extParams", "fillExportParams", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "aioMsgRecordList", "checkIsFavPicAndShowPreview", "msgRecord", "convertFileMsgToEntity", "isFileUploading", "checkChatHistory", "checkGroupEmo", "checkGroupAlbum", "addEmoticonToDataCenter", "sourcePicElement", "isPicElementMatch", "app", "picMsgElement", "isOnePic", "extraInfo", "previewGIFWithEmotionViewer", "enterImagePreview", "", "currentIndex", "enterMultiImagePreviewWithPath", "enterAIOEmotionPreview", "playPosition", "isMute", "isOneItemOnly", "aioRichMediaList", "enterVideoPreview", "enterFileBrowser", "source", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "enterOnlineFileBrowser", "Lcom/tencent/qqnt/kernel/nativeinterface/PttElement;", "pttElement", "enterPttPreview", "enterMultiPicBrowser", "", "FILE_STATUS", "Ljava/lang/String;", "AIO_TYPE", "QQ_PGSTP", "QQ_REF_PGID", "Lcom/tencent/mobileqq/filemanager/app/k$a;", "mTroopDocsQIPCModuleListener", "Lcom/tencent/mobileqq/filemanager/app/k$a;", "IMAGE_PREVIEW_FIND_PIC_ELEMENT_SWITCH", "isElementSwitchOn$delegate", "Lkotlin/Lazy;", "isElementSwitchOn", "()Z", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RichMediaBrowserApiImpl implements IRichMediaBrowserApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "RichMediaBrowserApiImpl";
    public static final String UNKNOWN = "unknown";

    /* renamed from: isElementSwitchOn$delegate, reason: from kotlin metadata */
    private final Lazy isElementSwitchOn;
    private k.a mTroopDocsQIPCModuleListener;
    private final String FILE_STATUS = "file_status";
    private final String AIO_TYPE = "aio_type";
    private final String QQ_PGSTP = "qq_pgstp";
    private final String QQ_REF_PGID = "qq_ref_pgid";
    private final String IMAGE_PREVIEW_FIND_PIC_ELEMENT_SWITCH = "image_preview_find_pic_element_9155_134985925";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\b\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0014\u0010\n\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\tH\u0002J\u0014\u0010\f\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u0014\u0010\u0015\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/RichMediaBrowserApiImpl$a;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Lcom/tencent/mobileqq/activity/aio/photo/AIOFilePicData;", QAdVrReportParams.ParamKey.MEDIA, "", "a", "Lcom/tencent/mobileqq/activity/aio/photo/AIOShortVideoData;", "d", "Lcom/tencent/mobileqq/activity/aio/photo/AIOFileVideoData;", "b", "Lcom/tencent/mobileqq/activity/aio/photo/AIOImageData;", "c", "", "filePath", "", "f", "", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "richMediaInfo", "e", "TAG", "Ljava/lang/String;", "UNKNOWN", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.RichMediaBrowserApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, AIOFilePicData aIOFilePicData) {
            RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
            rFWLayerPicInfo.setPicId(aIOFilePicData.W);
            if (!TextUtils.isEmpty(aIOFilePicData.H)) {
                RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
                rFWPicInfo.setLocalPath(aIOFilePicData.H);
                rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo);
                rFWLayerPicInfo.setBigPicInfo(rFWLayerPicInfo.getSmallPicInfo());
                RFWLayerPicInfo.RFWPicInfo smallPicInfo = rFWLayerPicInfo.getSmallPicInfo();
                Intrinsics.checkNotNull(smallPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
                rFWLayerPicInfo.setCurrentPicInfo(smallPicInfo);
            }
            if (!TextUtils.isEmpty(aIOFilePicData.J)) {
                RFWLayerPicInfo.RFWPicInfo rFWPicInfo2 = new RFWLayerPicInfo.RFWPicInfo();
                rFWPicInfo2.setLocalPath(aIOFilePicData.J);
                rFWPicInfo2.setSize(aIOFilePicData.f179631h);
                rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo2);
                if (RFWFileUtils.fileExists(aIOFilePicData.J)) {
                    RFWLayerPicInfo.RFWPicInfo originPicInfo = rFWLayerPicInfo.getOriginPicInfo();
                    Intrinsics.checkNotNull(originPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
                    rFWLayerPicInfo.setCurrentPicInfo(originPicInfo);
                }
            }
            rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        }

        private final void b(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, AIOFileVideoData aIOFileVideoData) {
            String str;
            RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            if (TextUtils.isEmpty(aIOFileVideoData.G)) {
                str = "";
            } else {
                str = aIOFileVideoData.G;
            }
            rFWPicInfo.setLocalPath(str);
            rFWPicInfo.setUrl(str);
            rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
            rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
            RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
            rFWLayerVideoInfo.setFileId(aIOFileVideoData.F);
            rFWLayerVideoInfo.setVideoOriginUrl(aIOFileVideoData.H);
            String videoOriginUrl = rFWLayerVideoInfo.getVideoOriginUrl();
            rFWLayerVideoInfo.setCurrentVideoUrl(videoOriginUrl != null ? videoOriginUrl : "");
            rFWLayerVideoInfo.setLocalPath(aIOFileVideoData.H);
            rFWLayerVideoInfo.setVideoHeight(aIOFileVideoData.K);
            rFWLayerVideoInfo.setVideoWidth(aIOFileVideoData.J);
            rFWLayerItemMediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
        }

        private final void c(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, AIOImageData aIOImageData) {
            rFWLayerItemMediaInfo.setInvalid(aIOImageData.M);
            RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
            rFWLayerPicInfo.setPicId(aIOImageData.f179572c0);
            Companion companion = RichMediaBrowserApiImpl.INSTANCE;
            if (companion.f(aIOImageData.F)) {
                RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
                rFWPicInfo.setLocalPath(aIOImageData.F);
                rFWPicInfo.setUrl(aIOImageData.F);
                rFWPicInfo.setHeight((int) aIOImageData.T);
                rFWPicInfo.setWidth((int) aIOImageData.S);
                rFWLayerPicInfo.setSmallPicInfo(rFWPicInfo);
                RFWLayerPicInfo.RFWPicInfo smallPicInfo = rFWLayerPicInfo.getSmallPicInfo();
                Intrinsics.checkNotNull(smallPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
                rFWLayerPicInfo.setCurrentPicInfo(smallPicInfo);
            }
            if (companion.f(aIOImageData.G)) {
                RFWLayerPicInfo.RFWPicInfo rFWPicInfo2 = new RFWLayerPicInfo.RFWPicInfo();
                rFWPicInfo2.setLocalPath(aIOImageData.G);
                rFWPicInfo2.setUrl(aIOImageData.G);
                rFWPicInfo2.setHeight((int) aIOImageData.T);
                rFWPicInfo2.setWidth((int) aIOImageData.S);
                rFWLayerPicInfo.setBigPicInfo(rFWPicInfo2);
                RFWLayerPicInfo.RFWPicInfo bigPicInfo = rFWLayerPicInfo.getBigPicInfo();
                Intrinsics.checkNotNull(bigPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
                rFWLayerPicInfo.setCurrentPicInfo(bigPicInfo);
            }
            if (companion.f(aIOImageData.H)) {
                RFWLayerPicInfo.RFWPicInfo rFWPicInfo3 = new RFWLayerPicInfo.RFWPicInfo();
                rFWPicInfo3.setLocalPath(aIOImageData.H);
                rFWPicInfo3.setUrl(aIOImageData.H);
                rFWPicInfo3.setSize(aIOImageData.f179631h);
                rFWPicInfo3.setHeight((int) aIOImageData.T);
                rFWPicInfo3.setWidth((int) aIOImageData.S);
                rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo3);
                if (RFWFileUtils.fileExists(aIOImageData.H)) {
                    RFWLayerPicInfo.RFWPicInfo originPicInfo = rFWLayerPicInfo.getOriginPicInfo();
                    Intrinsics.checkNotNull(originPicInfo, "null cannot be cast to non-null type com.tencent.richframework.gallery.bean.RFWLayerPicInfo.RFWPicInfo");
                    rFWLayerPicInfo.setCurrentPicInfo(originPicInfo);
                }
            }
            rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        }

        private final void d(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, AIOShortVideoData aIOShortVideoData) {
            rFWLayerItemMediaInfo.setInvalid(aIOShortVideoData.V != 0);
            if (!TextUtils.isEmpty(aIOShortVideoData.F)) {
                RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
                RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
                rFWPicInfo.setLocalPath(aIOShortVideoData.F);
                rFWPicInfo.setUrl(aIOShortVideoData.F);
                rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
                rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
            }
            RFWLayerVideoInfo rFWLayerVideoInfo = new RFWLayerVideoInfo();
            rFWLayerVideoInfo.setFileId(aIOShortVideoData.Q);
            rFWLayerVideoInfo.setVideoOriginUrl(aIOShortVideoData.G);
            String videoOriginUrl = rFWLayerVideoInfo.getVideoOriginUrl();
            if (videoOriginUrl == null) {
                videoOriginUrl = "";
            }
            rFWLayerVideoInfo.setCurrentVideoUrl(videoOriginUrl);
            rFWLayerVideoInfo.setLocalPath(aIOShortVideoData.G);
            rFWLayerVideoInfo.setVideoDurationSec(aIOShortVideoData.H);
            rFWLayerVideoInfo.setVideoHeight(aIOShortVideoData.M);
            rFWLayerVideoInfo.setVideoWidth(aIOShortVideoData.L);
            rFWLayerItemMediaInfo.setLayerVideoInfo(rFWLayerVideoInfo);
        }

        private final boolean f(String filePath) {
            return (TextUtils.isEmpty(filePath) || TextUtils.equals(filePath, AIOBrowserBaseData.MEDIA_FILE_NONE)) ? false : true;
        }

        public final List<RFWLayerItemMediaInfo> e(List<? extends AIORichMediaData> richMediaInfo) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(richMediaInfo, "richMediaInfo");
            List<? extends AIORichMediaData> list = richMediaInfo;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (AIORichMediaData aIORichMediaData : list) {
                RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
                rFWLayerItemMediaInfo.setMediaId(com.tencent.qqnt.aio.gallery.h.f350002a.b(aIORichMediaData));
                if (aIORichMediaData instanceof AIOImageData) {
                    RichMediaBrowserApiImpl.INSTANCE.c(rFWLayerItemMediaInfo, (AIOImageData) aIORichMediaData);
                } else if (aIORichMediaData instanceof AIOShortVideoData) {
                    RichMediaBrowserApiImpl.INSTANCE.d(rFWLayerItemMediaInfo, (AIOShortVideoData) aIORichMediaData);
                } else if (aIORichMediaData instanceof AIOFilePicData) {
                    RichMediaBrowserApiImpl.INSTANCE.a(rFWLayerItemMediaInfo, (AIOFilePicData) aIORichMediaData);
                } else if (aIORichMediaData instanceof AIOFileVideoData) {
                    RichMediaBrowserApiImpl.INSTANCE.b(rFWLayerItemMediaInfo, (AIOFileVideoData) aIORichMediaData);
                }
                arrayList.add(rFWLayerItemMediaInfo);
            }
            return arrayList;
        }

        Companion() {
        }
    }

    public RichMediaBrowserApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.RichMediaBrowserApiImpl$isElementSwitchOn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                String str;
                IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
                str = RichMediaBrowserApiImpl.this.IMAGE_PREVIEW_FIND_PIC_ELEMENT_SWITCH;
                return Boolean.valueOf(iUnitedConfigManager.isSwitchOn(str, true));
            }
        });
        this.isElementSwitchOn = lazy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0093, code lost:
    
        if (r8 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addEmoticonToDataCenter(List<MsgRecord> aioMsgRecordList, MsgRecord msgRecord) {
        List<MessageRecord> arrayList;
        int collectionSizeOrDefault;
        List list;
        boolean z16;
        boolean z17;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_emotion_preview_load_data_9020_886237811", false);
        QLog.i("AIOEmotionFragment", 1, "aio_emotion_preview_load_data_9020_886237811:" + isSwitchOn);
        if (isSwitchOn) {
            if (aioMsgRecordList != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : aioMsgRecordList) {
                    MsgRecord msgRecord2 = (MsgRecord) obj;
                    Intrinsics.checkNotNullExpressionValue(msgRecord2.elements, "it.elements");
                    if (!r5.isEmpty()) {
                        PicElement picElement = msgRecord2.elements.get(0).picElement;
                        if (picElement != null) {
                            Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
                            if (MsgExtKt.u(picElement)) {
                                z17 = true;
                                if (z17) {
                                    z16 = true;
                                    if (!z16) {
                                        arrayList2.add(obj);
                                    }
                                }
                            }
                        }
                        z17 = false;
                        if (z17) {
                        }
                    }
                    z16 = false;
                    if (!z16) {
                    }
                }
                INTMsgProxyUtilsApi iNTMsgProxyUtilsApi = (INTMsgProxyUtilsApi) QRoute.api(INTMsgProxyUtilsApi.class);
                String peerUid = msgRecord.getPeerUid();
                Intrinsics.checkNotNullExpressionValue(peerUid, "msgRecord.getPeerUid()");
                arrayList = iNTMsgProxyUtilsApi.transToCompatMsgType(arrayList2, peerUid, msgRecord.chatType);
            }
            arrayList = new ArrayList<>();
            List<MessageRecord> list2 = arrayList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList3.add(new com.tencent.mobileqq.emotionintegrate.y((MessageRecord) it.next()));
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList3);
            zu3.a aVar = new zu3.a();
            aVar.addDataList(list);
            RFWLayerDataCenter.INSTANCE.addDataStore("AIO_EMOTICON_DATA_KEY", aVar);
        }
    }

    private final boolean checkChatHistory(Bundle bundle) {
        IChatHistoryApi iChatHistoryApi = (IChatHistoryApi) QRoute.api(IChatHistoryApi.class);
        if (!iChatHistoryApi.checkFromChatHistory(bundle)) {
            return false;
        }
        iChatHistoryApi.clearChatHistoryBundle(bundle);
        return true;
    }

    private final boolean checkGroupAlbum(Bundle bundle) {
        return bundle.getBoolean("extra.IS_FROM_GROUP_ALBUM", false);
    }

    private final boolean checkGroupEmo(Bundle bundle) {
        return bundle.getBoolean("extra.IS_FROM_GROUP_EMO", false);
    }

    private final FileManagerEntity convertFileMsgToEntity(MsgRecord msgRecord, MsgElement msgElement) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        if (msgElement == null) {
            return fileManagerEntity;
        }
        FileElement fileElement = msgElement.fileElement;
        fileManagerEntity.Uuid = fileElement.fileUuid;
        fileManagerEntity.fileSize = fileElement.fileSize;
        fileManagerEntity.fileName = fileElement.fileName;
        fileManagerEntity.setFilePath(fileElement.filePath);
        FileElement fileElement2 = msgElement.fileElement;
        fileManagerEntity.strFileSHA = fileElement2.fileSha;
        fileManagerEntity.nSessionId = msgElement.elementId;
        fileManagerEntity.strFileMd5 = fileElement2.fileMd5;
        fileManagerEntity.nFileType = com.tencent.mobileqq.filemanager.util.ah.o0(fileElement2.fileName);
        fileManagerEntity.uniseq = msgRecord.msgId;
        fileManagerEntity.peerUin = String.valueOf(msgRecord.peerUin);
        fileManagerEntity.peerNick = msgRecord.peerName;
        fileManagerEntity.peerType = 0;
        fileManagerEntity.srvTime = 0L;
        fileManagerEntity.nOpType = msgRecord.sendType != 1 ? 1 : 0;
        fileManagerEntity.setCloudType(1);
        fileManagerEntity.status = 1;
        fileManagerEntity.msgSeq = msgRecord.msgSeq;
        fileManagerEntity.msgUid = msgRecord.msgId;
        long j3 = msgRecord.msgTime;
        fileManagerEntity.msgTime = j3;
        fileManagerEntity.srvTime = j3 * 1000;
        return fileManagerEntity;
    }

    private final void fillExportParams(Bundle extParams, AIOMsgItem aioMsgItem) {
        String valueOf;
        com.tencent.mobileqq.aio.utils.a e16;
        b.a g16 = com.tencent.mobileqq.aio.utils.b.f194119a.g();
        Map<String, Object> a16 = (g16 == null || (e16 = g16.e()) == null) ? null : e16.a();
        MsgElement firstTypeElement = aioMsgItem.getFirstTypeElement(3);
        FileElement fileElement = firstTypeElement != null ? firstTypeElement.fileElement : null;
        if (fileElement == null) {
            extParams.putString(this.FILE_STATUS, "0");
        } else {
            boolean f16 = com.tencent.qqnt.aio.element.file.util.a.f(fileElement);
            String str = this.FILE_STATUS;
            if (f16) {
                valueOf = "100";
            } else {
                valueOf = String.valueOf(fileElement.transferStatus);
            }
            extParams.putString(str, valueOf);
        }
        extParams.putInt(this.AIO_TYPE, aioMsgItem.getMsgRecord().chatType);
        if (a16 != null) {
            String str2 = this.QQ_PGSTP;
            Object obj = a16.get("qq_pgstp");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            extParams.putInt(str2, ((Integer) obj).intValue() + 1);
            extParams.putString(this.QQ_REF_PGID, (String) a16.get("qq_pgid"));
        }
    }

    private final ImageView findClickImageView(View view) {
        if (view instanceof NTAIOBubbleVideoView) {
            return ((NTAIOBubbleVideoView) view).c();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childAt, "view.getChildAt(i)");
                ImageView findClickImageView = findClickImageView(childAt);
                if (findClickImageView != null) {
                    return findClickImageView;
                }
            }
            return null;
        }
        if (view instanceof RoundBubbleImageView) {
            return (ImageView) view;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
    
        if (r2 == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ImageView getEnterImageView(Context context, ImageView imageView) {
        boolean isInMultiWindowMode;
        boolean isInPictureInPictureMode;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return imageView;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            isInPictureInPictureMode = activity.isInPictureInPictureMode();
        }
        if (i3 >= 24) {
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (isInMultiWindowMode) {
                return null;
            }
        }
        return imageView;
    }

    private final Class<? extends RFWLayerFragment> getLayerFragmentClass(AIOMsgItem msgItem, List<? extends AIOMsgItem> aioMsgItemList, Bundle extras) {
        if (checkGroupAlbum(extras)) {
            return NTAIOLayerWithoutAllBtnFragment.class;
        }
        if (checkChatHistory(extras)) {
            return NTAIOLayerWithoutHistoryFragment.class;
        }
        if (checkGroupEmo(extras)) {
            return NTAIOLayerGroupEmoticonFragment.class;
        }
        if (msgItem.getMsgRecord().chatType == 3) {
            return NTAIOLayerDiscussionFragment.class;
        }
        if (msgItem.getMsgRecord().chatType == 8) {
            if (MsgExtKt.X(msgItem.getMsgRecord())) {
                return NTAIOLayerDataLineVideoFragment.class;
            }
            return NTAIOLayerDataLineFragment.class;
        }
        if (msgItem.s0() != null || aioMsgItemList == null) {
            return NTAIOLayerWithoutHistoryFragment.class;
        }
        if (extras.getInt("key_source", 0) == 1) {
            return NTStorageCleanLayerFragment.class;
        }
        return NTAIOLayerFragment.class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Long> getRootIds(AIOMsgItem msgItem) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (MsgRecordParams h06 = msgItem.h0(); h06 != null; h06 = h06.c()) {
            arrayList.add(Long.valueOf(h06.b()));
        }
        CollectionsKt___CollectionsJvmKt.reverse(arrayList);
        return arrayList;
    }

    private final boolean isDownloaded(FileManagerEntity entity) {
        int i3 = entity.status;
        if (i3 == 1 || i3 == 0 || i3 == 2 || i3 == 3) {
            return true;
        }
        String filePath = entity.getFilePath();
        return !(filePath == null || filePath.length() == 0) && new File(entity.getFilePath()).exists();
    }

    private final boolean isElementSwitchOn() {
        return ((Boolean) this.isElementSwitchOn.getValue()).booleanValue();
    }

    private final boolean isFileUploading(MsgRecord msgRecord) {
        Integer num;
        Integer num2;
        Integer num3;
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList.isEmpty()) {
            return false;
        }
        MsgElement msgElement = arrayList.get(0);
        if (!(msgElement != null && msgElement.elementType == 3)) {
            return false;
        }
        int i3 = msgRecord.sendType;
        if ((i3 != 1 && i3 != 4) || msgRecord.sendStatus == 2) {
            return false;
        }
        FileElement fileElement = msgElement.fileElement;
        if (!((fileElement == null || (num3 = fileElement.transferStatus) == null || num3.intValue() != 2) ? false : true)) {
            FileElement fileElement2 = msgElement.fileElement;
            if (!((fileElement2 == null || (num2 = fileElement2.transferStatus) == null || num2.intValue() != 5) ? false : true)) {
                FileElement fileElement3 = msgElement.fileElement;
                if (!((fileElement3 == null || (num = fileElement3.transferStatus) == null || num.intValue() != 6) ? false : true)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void preDownloadLargePic(AIOMsgItem msgItem, RFWLayerItemMediaInfo itemMediaInfo) {
        itemMediaInfo.setExtraData(msgItem);
        if (itemMediaInfo.isVideo()) {
            return;
        }
        IPicLoader picLoader = ((IPicAIOApi) QRoute.api(IPicAIOApi.class)).getPicLoader();
        Option obtain = Option.obtain();
        obtain.setUrl("unknown");
        obtain.setLocalPath("unknown");
        obtain.setExtraData(RFWLayerImageLoader.getExtraData(itemMediaInfo, RFWLayerPicInfo.PicType.LARGE));
        picLoader.loadImage(obtain.setPredecode(false), new IPicLoadStateListener() { // from class: com.tencent.qqnt.aio.adapter.api.impl.ba
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                RichMediaBrowserApiImpl.preDownloadLargePic$lambda$11(loadState, option);
            }
        });
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterFileBrowser(AppRuntime appRuntime, Context context, AIOMsgItem aioMsgItem) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        enterFileBrowser(appRuntime, context, aioMsgItem, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0290 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x024f A[SYNTHETIC] */
    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void enterImagePreview(AppRuntime app, Context context, View view, AIOMsgItem msgItem, MsgElement picMsgElement, boolean isOnePic, Bundle extraInfo, List<? extends AIOMsgItem> aioMsgItemList, boolean previewGIFWithEmotionViewer) {
        ArrayList arrayList;
        String str;
        Integer num;
        String str2;
        int i3;
        int i16;
        ArrayList arrayList2;
        boolean z16;
        boolean z17;
        boolean z18;
        int i17;
        ArrayList<MsgElement> arrayList3;
        int collectionSizeOrDefault;
        List<? extends AIOMsgItem> list = aioMsgItemList;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        QLog.i(TAG, 1, "enterImagePreview id: " + msgItem.getMsgId());
        if (su3.a.d(msgItem)) {
            list = list != null ? su3.a.a(list, msgItem) : null;
        }
        com.tencent.qqnt.trace.r.f362387a.findStream("GALLERY_PAGE").tagNode("ITEM_CLICK");
        MsgRecord msgRecord = msgItem.getMsgRecord();
        if (list != null) {
            List<? extends AIOMsgItem> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((AIOMsgItem) it.next()).getMsgRecord());
            }
        } else {
            arrayList = null;
        }
        PicElement picElement = picMsgElement != null ? picMsgElement.picElement : null;
        if (previewGIFWithEmotionViewer && checkIsFavPicAndShowPreview(msgItem, picElement, view, arrayList)) {
            QLog.i(TAG, 1, "[enterImagePreview] msgRecordSeq: " + msgRecord.msgSeq + ", msgRecordId: " + msgRecord.msgId + ". isGif.");
            return;
        }
        Bundle bundle = new Bundle();
        if (extraInfo != null) {
            bundle.putAll(extraInfo);
        }
        if (view != null) {
            bundle.putParcelable("KEY_THUMBNAL_BOUND", com.tencent.common.galleryactivity.j.d(view));
        }
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", context.getPackageName());
        if (context instanceof SplashActivity) {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        } else {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", context.getClass().getName());
        }
        int c16 = su3.a.c(msgRecord);
        bundle.putInt(RichMediaBrowserConstants.EXTRA_AIO_CURRENT_PANEL_STATE, 0);
        bundle.putBoolean(ShortVideoConstants.IS_ONE_ITEM, isOnePic);
        bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, c16);
        bundle.putInt("uintype", com.tencent.nt.adapter.session.c.c(msgRecord.chatType));
        bundle.putString("uin", String.valueOf(msgRecord.peerUin));
        bundle.putString(PeakConstants.KEY_TROOP_GROUP_NAME, msgRecord.peerName);
        bundle.putInt(RichMediaBrowserConstants.EXTRA_MOBILE_QQ_PROCESS_ID, Process.myPid());
        bundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        if (c16 == 1) {
            bundle.putBoolean(RichMediaBrowserConstants.EXTRA_CAN_FORWARD_TO_GROUP_ALBUM, true);
            bundle.putString("extra.GROUP_UIN", String.valueOf(msgRecord.peerUin));
            bundle.putString("extra.GROUP_CODE", String.valueOf(msgRecord.senderUin));
        }
        if (c16 != 1 && c16 != 3000) {
            bundle.putInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 1);
        } else {
            bundle.putInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 2);
        }
        bundle.putBoolean(ShortVideoConstants.IS_REPLYMSG_FROM_SAME_SESSION, true);
        bundle.putBoolean(r05.a.f430453b, true);
        bundle.putBoolean("extra.IS_FROM_MULTI_MSG", false);
        bundle.putBoolean("extra.IS_SAVING_FILE", false);
        String currentAccountUin = app.getCurrentAccountUin();
        if (picElement == null || (!((i17 = msgRecord.msgType) == 2 || i17 == 9 || i17 == 31) || (arrayList3 = msgRecord.elements) == null || arrayList3.size() <= 0)) {
            str = TAG;
            num = null;
        } else {
            int size = msgRecord.elements.size();
            num = null;
            for (int i18 = 0; i18 < size; i18++) {
                if (msgRecord.elements.get(i18).picElement != null && isPicElementMatch(msgRecord.elements.get(i18), picMsgElement)) {
                    num = Integer.valueOf(i18);
                }
            }
            String str3 = "handle mixMsg index. elementSize: " + msgRecord.elements.size() + ", filename: " + picElement.fileName + ", elementIndex: " + num;
            str = TAG;
            QLog.i(str, 1, str3);
        }
        if (picMsgElement == null || picElement == null || !(msgItem instanceof com.tencent.mobileqq.aio.msg.j)) {
            str2 = str;
        } else {
            com.tencent.mobileqq.aio.msg.j jVar = (com.tencent.mobileqq.aio.msg.j) msgItem;
            str2 = str;
            String f16 = jVar.f(picMsgElement.elementId, PicSize.PIC_DOWNLOAD_ORI);
            if (f16 != null) {
                defpackage.g.e(picElement, f16);
            }
            String f17 = jVar.f(picMsgElement.elementId, PicSize.PIC_DOWNLOAD_BIG_THUMB);
            if (f17 != null) {
                defpackage.g.f(picElement, 720, f17);
            }
        }
        if (!previewGIFWithEmotionViewer) {
            i3 = 0;
            i16 = 1;
            arrayList2 = arrayList;
        } else if (arrayList != null) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : arrayList) {
                MsgRecord msgRecord2 = (MsgRecord) obj;
                Intrinsics.checkNotNullExpressionValue(msgRecord2.elements, "it.elements");
                if (!r7.isEmpty()) {
                    z16 = false;
                    PicElement picElement2 = msgRecord2.elements.get(0).picElement;
                    if (picElement2 != null) {
                        Intrinsics.checkNotNullExpressionValue(picElement2, "picElement");
                        if (MsgExtKt.u(picElement2)) {
                            z18 = true;
                            if (!z18) {
                                z17 = true;
                                if (!z17) {
                                    arrayList4.add(obj);
                                }
                            }
                        }
                    }
                    z18 = false;
                    if (!z18) {
                    }
                } else {
                    z16 = false;
                }
                z17 = z16;
                if (!z17) {
                }
            }
            i3 = 0;
            i16 = 1;
            arrayList2 = arrayList4;
        } else {
            i3 = 0;
            i16 = 1;
            arrayList2 = null;
        }
        ru3.b bVar = new ru3.b(currentAccountUin, String.valueOf(msgRecord.peerUin), c16, msgRecord, arrayList2);
        if (currentAccountUin != null && msgRecord.peerUid != null) {
            int i19 = i3;
            int i26 = i16;
            String str4 = str2;
            List c17 = ru3.c.c(ru3.c.f432503a, app, msgRecord, num, null, 8, null);
            ArrayList<AIORichMediaData> arrayList5 = c17 instanceof ArrayList ? (ArrayList) c17 : null;
            if (((arrayList5 == null || arrayList5.isEmpty()) ? i26 : i19) != 0) {
                QLog.e(str4, i26, "enterImagePreview data is empty!");
                return;
            } else {
                enterToGallery(msgItem, list, view, bVar, arrayList5, context, bundle);
                return;
            }
        }
        QLog.e(str2, i16, "enterImagePreview selfUin || msgRecord.peerUid is null");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterMultiPicBrowser(AppRuntime appRuntime, Context context, AIOMsgItem aioMsgItem) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Intent intent = new Intent(context, (Class<?>) MultiPicViewerActivity.class);
        intent.addFlags(268435456);
        intent.putParcelableArrayListExtra("ALBUM_RESULT", com.tencent.qqnt.aio.msg.d.O(aioMsgItem));
        intent.putExtra("IS_UPLOAD_KEY", aioMsgItem.isSelf());
        intent.putExtra("MSG_ID", aioMsgItem.getMsgId());
        MultiPicViewerActivity.INSTANCE.b(new SoftReference<>(aioMsgItem.getMsgRecord()));
        context.startActivity(intent);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterPttPreview(AppRuntime appRuntime, Context context, MsgRecord msgRecord, PttElement pttElement) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0275 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0235 A[SYNTHETIC] */
    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void enterVideoPreview(AppRuntime app, Context context, View view, AIOMsgItem aioMsgItem, long playPosition, boolean isMute, boolean isOneItemOnly, Bundle extraInfo, List<? extends AIOMsgItem> aioRichMediaList) {
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean z16;
        boolean z17;
        boolean z18;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        if (!(app instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "[enterVideoPreview] appRuntime is not QQAppInterface!");
            return;
        }
        QLog.i(TAG, 1, "enterVideoPreview id: " + aioMsgItem.getMsgId());
        List<AIOMsgItem> a16 = aioRichMediaList != null ? su3.a.a(aioRichMediaList, aioMsgItem) : null;
        com.tencent.qqnt.trace.r.f362387a.findStream("GALLERY_PAGE").tagNode("ITEM_CLICK");
        MsgRecord msgRecord = aioMsgItem.getMsgRecord();
        if (a16 != null) {
            List<AIOMsgItem> list = a16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList3.add(((AIOMsgItem) it.next()).getMsgRecord());
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        QLog.i(TAG, 1, "[enterVideoPreview] msgRecordSeq: " + msgRecord.msgSeq + ", msgRecordId: " + msgRecord.msgId);
        Iterator<MsgElement> it5 = msgRecord.elements.iterator();
        MsgElement msgElement = null;
        while (it5.hasNext()) {
            MsgElement next = it5.next();
            if (next.elementType == 3) {
                msgElement = next;
            }
        }
        FileManagerEntity i3 = msgElement != null ? NTFileUtils.i((QQAppInterface) app, su3.d.f434769a.a(aioMsgItem.s0()), msgRecord, msgElement.elementId) : null;
        if (i3 != null) {
            FileManagerReporter.a aVar = new FileManagerReporter.a();
            aVar.f209157b = "file_viewer_in";
            aVar.f209158c = 9;
            aVar.f209159d = com.tencent.mobileqq.filemanager.util.q.j(i3.fileName);
            aVar.f209162g = FileManagerUtil.reportSrcType(i3.getCloudType(), i3.peerType);
            FileManagerReporter.addData(app.getCurrentAccountUin(), aVar);
        }
        Bundle bundle = new Bundle();
        if (extraInfo != null) {
            bundle.putAll(extraInfo);
        }
        if (view != null) {
            bundle.putParcelable("KEY_THUMBNAL_BOUND", com.tencent.common.galleryactivity.j.d(view));
        }
        int c16 = su3.a.c(msgRecord);
        if (c16 == 1) {
            bundle.putBoolean(RichMediaBrowserConstants.EXTRA_CAN_FORWARD_TO_GROUP_ALBUM, true);
            bundle.putString("extra.GROUP_UIN", String.valueOf(msgRecord.peerUin));
            bundle.putString("extra.GROUP_CODE", String.valueOf(msgRecord.peerUin));
        }
        if (c16 != 1 && c16 != 3000) {
            bundle.putInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 1);
        } else {
            bundle.putInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 2);
        }
        bundle.putLong("extra.SEEK_POSITION", playPosition);
        bundle.putString(PeakConstants.KEY_TROOP_GROUP_NAME, msgRecord.peerName);
        bundle.putBoolean(ShortVideoConstants.MUTE_PLAY, isMute);
        bundle.putBoolean(ShortVideoConstants.IS_ONE_ITEM, isOneItemOnly);
        bundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        bundle.putInt(RichMediaBrowserConstants.EXTRA_AIO_CURRENT_PANEL_STATE, 0);
        bundle.putLong(ShortVideoConstants.CLICK_VIDEO_BUBBLE_TIME, System.currentTimeMillis());
        bundle.putInt(RichMediaBrowserConstants.EXTRA_MOBILE_QQ_PROCESS_ID, Process.myPid());
        String currentAccountUin = ((QQAppInterface) app).getCurrentAccountUin();
        bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, c16);
        bundle.putInt("uintype", com.tencent.nt.adapter.session.c.c(msgRecord.chatType));
        bundle.putString("uin", String.valueOf(msgRecord.peerUin));
        bundle.putString(AppConstants.Key.NT_UID, msgRecord.peerUid);
        bundle.putInt(AppConstants.Key.NT_CHAT_TYPE, msgRecord.chatType);
        QLog.i(TAG, 1, "uid: " + msgRecord.peerUid + ", chatType: " + msgRecord.chatType);
        List c17 = ru3.c.c(ru3.c.f432503a, app, msgRecord, null, extraInfo != null ? extraInfo.getString("file_local_path", "") : null, 4, null);
        ArrayList<AIORichMediaData> arrayList4 = c17 instanceof ArrayList ? (ArrayList) c17 : null;
        if (arrayList4 == null || arrayList4.isEmpty()) {
            QLog.e(TAG, 1, "enterVideoPreview data is empty!");
            return;
        }
        if (arrayList != null) {
            arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                MsgRecord msgRecord2 = (MsgRecord) obj;
                Intrinsics.checkNotNullExpressionValue(msgRecord2.elements, "it.elements");
                if (!r4.isEmpty()) {
                    z16 = false;
                    PicElement picElement = msgRecord2.elements.get(0).picElement;
                    if (picElement != null) {
                        Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
                        if (MsgExtKt.u(picElement)) {
                            z18 = true;
                            if (!z18) {
                                z17 = true;
                                if (!z17) {
                                    arrayList2.add(obj);
                                }
                            }
                        }
                    }
                    z18 = false;
                    if (!z18) {
                    }
                } else {
                    z16 = false;
                }
                z17 = z16;
                if (!z17) {
                }
            }
        } else {
            arrayList2 = null;
        }
        ru3.b bVar = new ru3.b(currentAccountUin, String.valueOf(msgRecord.peerUin), c16, msgRecord, arrayList2);
        bundle.putBoolean(RFWLaunchKey.KEY_IS_VIDEO_MUTE, isMute);
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", context.getPackageName());
        if (context instanceof SplashActivity) {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        } else {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", context.getClass().getName());
        }
        enterToGallery(aioMsgItem, a16, view, bVar, arrayList4, context, bundle);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterFileBrowser(AppRuntime appRuntime, Context context, final AIOMsgItem aioMsgItem, int source) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "[enterFileBrowser] appRuntime is not QQAppInterface!");
            return;
        }
        MsgRecord msgRecord = aioMsgItem.getMsgRecord();
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        boolean z16 = true;
        MsgElement msgElement = null;
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 3) {
                Integer num = next.fileElement.invalidState;
                if (num != null && num.intValue() == 0) {
                    msgElement = next;
                } else {
                    msgElement = next;
                    z16 = false;
                }
            }
        }
        if (!z16) {
            String string = context.getString(R.string.f201284ue);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026o_richmedia_file_invalid)");
            QQToast.makeText(context, 1, string, 1).show();
            return;
        }
        NTFileUtils.b a16 = su3.d.f434769a.a(aioMsgItem.s0());
        FileManagerEntity i3 = msgElement != null ? NTFileUtils.i((QQAppInterface) appRuntime, a16, msgRecord, msgElement.elementId) : null;
        if (i3 != null) {
            i3.selfUin = String.valueOf(msgRecord.senderUin);
        }
        final Bundle bundle = new Bundle();
        int i16 = a16 != null ? a16.f208722d : msgRecord.chatType;
        com.tencent.mobileqq.filebrowser.toogle.a.c(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.RichMediaBrowserApiImpl$enterFileBrowser$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList rootIds;
                long[] longArray;
                if (com.tencent.mobileqq.aio.utils.d.b0(AIOMsgItem.this)) {
                    rootIds = this.getRootIds(AIOMsgItem.this);
                    Bundle bundle2 = bundle;
                    if (!rootIds.isEmpty()) {
                        longArray = CollectionsKt___CollectionsKt.toLongArray(rootIds);
                        bundle2.putLongArray("forward_root_msg_ids", longArray);
                    }
                }
            }
        });
        if (i16 == 2) {
            if (isFileUploading(msgRecord)) {
                Intent intent = new Intent();
                intent.putExtra(QZoneHelper.Constants.KEY_QUN_ID, msgRecord.peerUid);
                ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).openTroopFileUploadPage((Activity) context, intent);
            } else {
                if (i3 != null) {
                    String str = i3.strTroopFilePath;
                    if (str == null || str.length() == 0) {
                        QLog.w(TAG, 1, "enterFileBrowser entity.strTroopFilePath is empty.");
                    }
                }
                com.tencent.mobileqq.filemanager.openbrowser.d dVar = new com.tencent.mobileqq.filemanager.openbrowser.d((QQAppInterface) appRuntime, i3, 2);
                if (useTencentDocsOnlinePreview(appRuntime, context, i3)) {
                    return;
                }
                fillExportParams(bundle, aioMsgItem);
                bundle.putInt("file_enter_file_browser_type", 3);
                bundle.putLong("multi_msg_file_id", aioMsgItem.getMsgRecord().msgId);
                bundle.putParcelable("multi_msg_file_parent_params", aioMsgItem.h0());
                if (aioMsgItem.k0() != null) {
                    bundle.putParcelable("reply_msg_file_params", aioMsgItem.k0());
                }
                dVar.S(bundle);
                com.tencent.mobileqq.filemanager.openbrowser.c f16 = new com.tencent.mobileqq.filemanager.openbrowser.c().d(3).f(source);
                Intrinsics.checkNotNullExpressionValue(f16, "FileBrowserParam()\n     \u2026       .setSource(source)");
                ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(context, dVar, f16);
            }
        } else {
            bundle.putString("file_browser_extra_params_uin", String.valueOf(msgRecord.peerUin));
            fillExportParams(bundle, aioMsgItem);
            com.tencent.mobileqq.filemanager.openbrowser.d dVar2 = new com.tencent.mobileqq.filemanager.openbrowser.d((QQAppInterface) appRuntime, i3);
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "FileModelAdapter cloudType " + i3);
            dVar2.S(bundle);
            com.tencent.mobileqq.filemanager.openbrowser.c f17 = new com.tencent.mobileqq.filemanager.openbrowser.c().d(1).f(source);
            Intrinsics.checkNotNullExpressionValue(f17, "FileBrowserParam()\n     \u2026       .setSource(source)");
            if (context instanceof NTChatHistoryActivity) {
                f17.e(1);
            } else if (context instanceof MultiForwardActivity) {
                f17.e(0);
            }
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(context, dVar2, f17);
            if (i16 == 8) {
                dataLineAutoPlayVideo(appRuntime, context, msgElement, dVar2, aioMsgItem);
            }
            FileManagerReporter.a aVar = new FileManagerReporter.a();
            aVar.f209157b = "file_viewer_in";
            aVar.f209158c = 9;
            Intrinsics.checkNotNull(i3);
            aVar.f209159d = com.tencent.mobileqq.filemanager.util.q.j(i3.fileName);
            aVar.f209162g = FileManagerUtil.reportSrcType(i3.getCloudType(), i3.peerType);
            FileManagerReporter.addData(appRuntime.getCurrentAccountUin(), aVar);
        }
        if (i3 != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("file_size", String.valueOf(i3.fileSize));
            String j3 = com.tencent.mobileqq.filemanager.util.q.j(i3.fileName);
            Intrinsics.checkNotNullExpressionValue(j3, "getExtension(entity.fileName)");
            linkedHashMap.put("filetype", j3);
            linkedHashMap.put("is_downloaded", isDownloaded(i3) ? "1" : "0");
            if (msgElement != null) {
                FileElement fileElement = msgElement.fileElement;
                Intrinsics.checkNotNullExpressionValue(fileElement, "msgElement.fileElement");
                linkedHashMap.put("is_expired", com.tencent.qqnt.aio.element.file.util.a.f(fileElement) ? "1" : "0");
            }
            com.tencent.mobileqq.aio.utils.b.l("em_bas_file", linkedHashMap);
        }
    }

    private final void dataLineAutoPlayVideo(AppRuntime appRuntime, Context context, MsgElement msgElement, com.tencent.mobileqq.filebrowser.e fileBrowserModel, AIOMsgItem aioMsgItem) {
        FileElement fileElement;
        Integer num;
        boolean z16 = false;
        if (msgElement != null && (fileElement = msgElement.fileElement) != null && (num = fileElement.subElementType) != null && num.intValue() == 2) {
            z16 = true;
        }
        if (z16) {
            fileBrowserModel.r(new b(fileBrowserModel, aioMsgItem, this, appRuntime, context));
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterAIOEmotionPreview(AppRuntime app, Context context, AIOMsgItem aioMsgItem, View view, Bundle extras) {
        MessageForPic q16;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        MsgRecord msgRecord = aioMsgItem.getMsgRecord();
        MsgElement firstTypeElement = aioMsgItem.getFirstTypeElement(2);
        if (firstTypeElement != null) {
            ChatMessage b16 = pu3.a.f427394a.b((BaseQQAppInterface) app, msgRecord, firstTypeElement.picElement);
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForPic");
            q16 = (MessageForPic) b16;
        } else {
            MsgElement firstTypeElement2 = aioMsgItem.getFirstTypeElement(3);
            if (firstTypeElement2 == null) {
                QLog.e(TAG, 1, "enterAIOEmotionPreview error, invalidate msg element!");
                return;
            }
            q16 = com.tencent.mobileqq.service.message.q.q((BaseQQAppInterface) app, "", "", 0);
            Intrinsics.checkNotNullExpressionValue(q16, "createSendMSg_Pic(\n     \u2026          0\n            )");
            FileElement fileElement = firstTypeElement2.fileElement;
            q16.uuid = fileElement.fileUuid;
            q16.path = fileElement.filePath;
            q16.size = fileElement.fileSize;
            q16.width = fileElement.picWidth.intValue();
            q16.height = fileElement.picHeight.intValue();
            q16.md5 = fileElement.fileMd5;
            q16.type = 1;
            q16.ntChatType = msgRecord.chatType;
            q16.ntPeerUid = msgRecord.peerUid;
        }
        MessageForPic messageForPic = q16;
        messageForPic.rootMsgRecordParams = aioMsgItem.s0();
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = com.tencent.nt.adapter.session.c.c(msgRecord.chatType);
        sessionInfo.f179557e = String.valueOf(msgRecord.peerUin);
        sessionInfo.f179559f = String.valueOf(msgRecord.peerUin);
        sessionInfo.f179563i = msgRecord.peerName;
        AIOEmotionFragment.ci(context, messageForPic, sessionInfo, new AIOContact(aioMsgItem.p0(), aioMsgItem.r0(), "", null, 8, null), com.tencent.common.galleryactivity.j.d(view), true, true, extras);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00f0  */
    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void enterMultiImagePreviewWithPath(View view, int currentIndex, MsgRecord msgRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        QLog.i(TAG, 1, "enterMultiImagePreviewWithPath id: " + msgRecord.getMsgId());
        com.tencent.qqnt.trace.r.f362387a.findStream("GALLERY_PAGE").tagNode("ITEM_CLICK");
        QLog.i(TAG, 1, "[enterMultiImagePreviewWithPath] msgRecordSeq: " + msgRecord.msgSeq + ", msgRecordId: " + msgRecord.msgId);
        Bundle bundle = new Bundle();
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", view.getContext().getPackageName());
        if (view.getContext() instanceof SplashActivity) {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        } else {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", view.getContext().getClass().getName());
        }
        int c16 = su3.a.c(msgRecord);
        int i3 = 0;
        bundle.putInt(RichMediaBrowserConstants.EXTRA_AIO_CURRENT_PANEL_STATE, 0);
        Integer num = msgRecord.fileGroupSize;
        if (num != null) {
            Intrinsics.checkNotNullExpressionValue(num, "msgRecord.fileGroupSize");
            if (num.intValue() > 1) {
                z16 = false;
                bundle.putBoolean(ShortVideoConstants.IS_ONE_ITEM, z16);
                bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, c16);
                bundle.putInt("uintype", com.tencent.nt.adapter.session.c.c(msgRecord.chatType));
                bundle.putString("uin", String.valueOf(msgRecord.peerUin));
                bundle.putString(PeakConstants.KEY_TROOP_GROUP_NAME, msgRecord.peerName);
                bundle.putInt(RichMediaBrowserConstants.EXTRA_MOBILE_QQ_PROCESS_ID, Process.myPid());
                bundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
                if (c16 == 1) {
                    bundle.putBoolean(RichMediaBrowserConstants.EXTRA_CAN_FORWARD_TO_GROUP_ALBUM, true);
                    bundle.putString("extra.GROUP_UIN", String.valueOf(msgRecord.peerUin));
                    bundle.putString("extra.GROUP_CODE", String.valueOf(msgRecord.senderUin));
                }
                if (c16 == 1 && c16 != 3000) {
                    bundle.putInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 1);
                } else {
                    bundle.putInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 2);
                }
                bundle.putBoolean(ShortVideoConstants.IS_REPLYMSG_FROM_SAME_SESSION, true);
                bundle.putBoolean(r05.a.f430453b, true);
                bundle.putBoolean("extra.IS_FROM_MULTI_MSG", false);
                bundle.putBoolean("extra.IS_SAVING_FILE", false);
                bundle.putBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, true);
                if (MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin() == null && msgRecord.peerUid != null) {
                    AIOFileProvider aIOFileProvider = new AIOFileProvider();
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
                    List<AIORichMediaData> c17 = aIOFileProvider.c(peekAppRuntime, msgRecord, null, 0);
                    List<RFWLayerItemMediaInfo> e16 = INSTANCE.e(c17);
                    AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
                    com.tencent.qqnt.aio.gallery.d dVar = new com.tencent.qqnt.aio.gallery.d();
                    dVar.addData(aIOMsgItem);
                    RFWLayerDataCenter.INSTANCE.addDataStore(String.valueOf(dVar.getStoreTag()), dVar);
                    bundle.putString(GuildGalleryApiImpl.MSG_RECORD_STORE_KEY, String.valueOf(dVar.getStoreTag()));
                    com.tencent.qqnt.aio.gallery.g gVar = new com.tencent.qqnt.aio.gallery.g();
                    gVar.addDataList(c17);
                    int i16 = 0;
                    for (Object obj : c17) {
                        int i17 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        if (((AIORichMediaData) obj).f179629e == currentIndex) {
                            i16 = i3;
                        }
                        i3 = i17;
                    }
                    QLog.i(TAG, 1, "enterMultiImagePreviewWithPath real index " + i16 + ", " + c17);
                    RFWLayerDataCenter.INSTANCE.addDataStore(GuildGalleryApiImpl.AIO_RICH_MEDIA_DATA_KEY, gVar);
                    RFWLayerLaunchUtil.jumpToGallery$default(view.getContext(), view instanceof ImageView ? (ImageView) view : null, e16, i16, QQGalleryActivity.class, NTAIOLayerDataLineFragment.class, bundle, 0, 128, null);
                    return;
                }
                QLog.e(TAG, 1, "enterMultiImagePreviewWithPath selfUin || msgRecord.peerUid is null");
            }
        }
        z16 = true;
        bundle.putBoolean(ShortVideoConstants.IS_ONE_ITEM, z16);
        bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, c16);
        bundle.putInt("uintype", com.tencent.nt.adapter.session.c.c(msgRecord.chatType));
        bundle.putString("uin", String.valueOf(msgRecord.peerUin));
        bundle.putString(PeakConstants.KEY_TROOP_GROUP_NAME, msgRecord.peerName);
        bundle.putInt(RichMediaBrowserConstants.EXTRA_MOBILE_QQ_PROCESS_ID, Process.myPid());
        bundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        if (c16 == 1) {
        }
        if (c16 == 1) {
        }
        bundle.putInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 2);
        bundle.putBoolean(ShortVideoConstants.IS_REPLYMSG_FROM_SAME_SESSION, true);
        bundle.putBoolean(r05.a.f430453b, true);
        bundle.putBoolean("extra.IS_FROM_MULTI_MSG", false);
        bundle.putBoolean("extra.IS_SAVING_FILE", false);
        bundle.putBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, true);
        if (MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin() == null) {
        }
        QLog.e(TAG, 1, "enterMultiImagePreviewWithPath selfUin || msgRecord.peerUid is null");
    }

    private final boolean checkIsFavPicAndShowPreview(AIOMsgItem msgItem, PicElement picElement, View view, List<MsgRecord> aioMsgRecordList) {
        if (!(picElement != null && MsgExtKt.u(picElement)) || view == null) {
            return false;
        }
        MsgRecord msgRecord = msgItem.getMsgRecord();
        pu3.a aVar = pu3.a.f427394a;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        ChatMessage b16 = aVar.b((BaseQQAppInterface) peekAppRuntime, msgRecord, picElement);
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForPic");
        MessageForPic messageForPic = (MessageForPic) b16;
        messageForPic.rootMsgRecordParams = msgItem.s0();
        messageForPic.replyRealSourceMsgId = msgItem.m0();
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = com.tencent.nt.adapter.session.c.c(msgRecord.chatType);
        sessionInfo.f179557e = String.valueOf(msgRecord.peerUin);
        sessionInfo.f179559f = String.valueOf(msgRecord.peerUin);
        sessionInfo.f179563i = msgRecord.peerName;
        Rect d16 = com.tencent.common.galleryactivity.j.d(view);
        AIOContact aIOContact = new AIOContact(msgItem.p0(), msgItem.r0(), "", null, 8, null);
        Bundle bundle = new Bundle();
        if (aIOContact.e() == 3) {
            bundle.putBoolean("need_more_btn", false);
        }
        bundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", MobileQQ.sMobileQQ.getPackageName());
        if (view.getContext() instanceof SplashActivity) {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.getAliasName());
        } else {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", view.getContext().getClass().getName());
        }
        addEmoticonToDataCenter(aioMsgRecordList, msgRecord);
        AIOEmotionFragment.ci(view.getContext(), messageForPic, sessionInfo, aIOContact, d16, true, true, bundle);
        return true;
    }

    private final boolean isPicElementMatch(MsgElement picElement, MsgElement sourcePicElement) {
        if (sourcePicElement == null || picElement == null) {
            return false;
        }
        if (isElementSwitchOn()) {
            return sourcePicElement.elementId == picElement.elementId;
        }
        PicElement picElement2 = sourcePicElement.picElement;
        String str = picElement2 != null ? picElement2.fileName : null;
        PicElement picElement3 = picElement.picElement;
        return Intrinsics.areEqual(str, picElement3 != null ? picElement3.fileName : null);
    }

    private final boolean useTencentDocsOnlinePreview(AppRuntime appRuntime, Context context, FileManagerEntity entity) {
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "[enterFileBrowser] appRuntime is not QQAppInterface!");
            return false;
        }
        if (entity == null) {
            return false;
        }
        String str = entity.fileName;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        com.tencent.mobileqq.troop.data.t o16 = TroopFileUtils.o(qQAppInterface, entity, true);
        if (o16 == null) {
            o16 = TroopFileUtils.k(qQAppInterface, entity.TroopUin, entity.strTroopFileID, entity.strTroopFilePath, entity.fileName, entity.fileSize, entity.busId);
        }
        if (o16 == null || TextUtils.isEmpty(str2) || !com.tencent.mobileqq.filemanager.util.bb.o(qQAppInterface, o16.f294972f, false, entity.TroopUin, str2, entity.fileSize, 3)) {
            return false;
        }
        if (this.mTroopDocsQIPCModuleListener != null) {
            com.tencent.mobileqq.filemanager.app.k.c().d(this.mTroopDocsQIPCModuleListener);
            this.mTroopDocsQIPCModuleListener = null;
        }
        this.mTroopDocsQIPCModuleListener = new com.tencent.mobileqq.filemanager.app.j((Activity) context, true);
        com.tencent.mobileqq.filemanager.app.k.c().b(this.mTroopDocsQIPCModuleListener);
        long j3 = entity.lastTime;
        String str3 = entity.selfUin.toString();
        boolean z16 = entity.bSend;
        long j16 = entity.TroopUin;
        String str4 = entity.strFileMd5;
        com.tencent.mobileqq.filemanager.util.bb.q(qQAppInterface, context, o16, 3, 3, j3, str3, true, false, z16, j16, str4 == null ? entity.str10Md5 : str4);
        return true;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi
    public void enterOnlineFileBrowser(AppRuntime appRuntime, Context context, MsgRecord msgRecord, FileElement fileElement) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(fileElement, "fileElement");
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e(TAG, 1, "[enterFileBrowser] appRuntime is not QQAppInterface!");
            return;
        }
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.cloudType = 0;
        String str = fileElement.fileName;
        fileManagerEntity.fileName = str;
        fileManagerEntity.fileSize = fileElement.fileSize;
        fileManagerEntity.nFileType = FileManagerUtil.getFileType(str);
        com.tencent.mobileqq.filemanager.openbrowser.d dVar = new com.tencent.mobileqq.filemanager.openbrowser.d((QQAppInterface) appRuntime, fileManagerEntity);
        Bundle bundle = new Bundle();
        bundle.putString("file_browser_extra_params_uin", String.valueOf(msgRecord.peerUin));
        long j3 = msgRecord.msgId;
        int i3 = msgRecord.chatType;
        int i16 = msgRecord.sendType;
        String str2 = msgRecord.peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.peerUid");
        bundle.putParcelable("file_browser_extra_msg_record_params", new MsgRecordParams(j3, i3, i16, str2, msgRecord.peerUin, null, 32, null));
        dVar.S(bundle);
        com.tencent.mobileqq.filemanager.openbrowser.c d16 = new com.tencent.mobileqq.filemanager.openbrowser.c().d(1);
        Intrinsics.checkNotNullExpressionValue(d16, "FileBrowserParam().setEntranceType(entranceType)");
        ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(context, dVar, d16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if (((r3 != null ? r3.getDrawable() : null) instanceof com.tencent.image.URLDrawable) == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void enterToGallery(final AIOMsgItem msgItem, List<? extends AIOMsgItem> aioMsgItemList, View view, ru3.b aioImageProviderService, ArrayList<AIORichMediaData> data, Context context, final Bundle extras) {
        ImageView findClickImageView;
        int i3;
        int i16;
        List<? extends AIORichMediaData> listOf;
        List<RFWLayerItemMediaInfo> e16;
        int i17;
        List<AIORichMediaData> listOf2;
        int coerceAtLeast;
        int coerceAtLeast2;
        ImageView imageView = null;
        if (view instanceof ImageView) {
            findClickImageView = (ImageView) view;
        } else {
            findClickImageView = view instanceof ViewGroup ? findClickImageView(view) : null;
        }
        if (!((findClickImageView != null ? findClickImageView.getDrawable() : null) instanceof LibraBitmapDrawable)) {
        }
        imageView = findClickImageView;
        List<AIORichMediaData> y55 = aioImageProviderService.y5();
        Intrinsics.checkNotNullExpressionValue(y55, "aioImageProviderService.richMediaList");
        Iterator<AIORichMediaData> it = y55.iterator();
        int i18 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                i18 = -1;
                break;
            } else {
                AIORichMediaData next = it.next();
                if (next.f179628d == data.get(data.size() + (-1)).f179628d && next.f179629e == data.get(data.size() - 1).f179629e) {
                    i3 = -1;
                    break;
                }
                i18++;
            }
        }
        if (i18 != i3) {
            Companion companion = INSTANCE;
            List<AIORichMediaData> y56 = aioImageProviderService.y5();
            Intrinsics.checkNotNullExpressionValue(y56, "aioImageProviderService.richMediaList");
            e16 = companion.e(y56);
            i17 = -1;
            i16 = 1;
        } else {
            Companion companion2 = INSTANCE;
            i16 = 1;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(data.get(data.size() - 1));
            e16 = companion2.e(listOf);
            i17 = -1;
        }
        if (i18 == i17) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(data.get(data.size() - i16));
        } else {
            listOf2 = aioImageProviderService.y5();
            Intrinsics.checkNotNullExpressionValue(listOf2, "{\n            aioImagePr\u2026e.richMediaList\n        }");
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i18, 0);
        preDownloadLargePic(msgItem, e16.get(coerceAtLeast));
        com.tencent.qqnt.aio.gallery.d dVar = new com.tencent.qqnt.aio.gallery.d();
        if (aioMsgItemList != null) {
            dVar.addDataList(aioMsgItemList);
        }
        dVar.addData(msgItem);
        RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
        rFWLayerDataCenter.addDataStore(String.valueOf(dVar.getStoreTag()), dVar);
        extras.putString(GuildGalleryApiImpl.MSG_RECORD_STORE_KEY, String.valueOf(dVar.getStoreTag()));
        extras.putInt(RichMediaBrowserConstants.INTERNAL_EXTRA_ENTRANCE, 1);
        extras.putBoolean(RichMediaBrowserConstants.KEY_ALLOW_FORWARD_PHOTO_PREVIEW_EDIT, true);
        com.tencent.mobileqq.filebrowser.toogle.a.c(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.adapter.api.impl.RichMediaBrowserApiImpl$enterToGallery$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList rootIds;
                long[] longArray;
                rootIds = RichMediaBrowserApiImpl.this.getRootIds(msgItem);
                Bundle bundle = extras;
                if (!rootIds.isEmpty()) {
                    longArray = CollectionsKt___CollectionsKt.toLongArray(rootIds);
                    bundle.putLongArray("forward_root_msg_ids", longArray);
                }
            }
        });
        com.tencent.qqnt.aio.gallery.g gVar = new com.tencent.qqnt.aio.gallery.g();
        gVar.addDataList(listOf2);
        rFWLayerDataCenter.addDataStore(GuildGalleryApiImpl.AIO_RICH_MEDIA_DATA_KEY, gVar);
        if (context instanceof Activity) {
            InputMethodUtil.hide((Activity) context);
        }
        ImageView enterImageView = getEnterImageView(context, imageView);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i18, 0);
        RFWLayerLaunchUtil.jumpToGallery$default(context, enterImageView, e16, coerceAtLeast2, QQGalleryActivity.class, getLayerFragmentClass(msgItem, aioMsgItemList, extras), extras, 0, 128, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/RichMediaBrowserApiImpl$b", "Lcom/tencent/mobileqq/filebrowser/e$f;", "", "progress", "", "a", "j", "l", "f", "e", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements e.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filebrowser.e f348585d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AIOMsgItem f348586e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RichMediaBrowserApiImpl f348587f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AppRuntime f348588h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f348589i;

        b(com.tencent.mobileqq.filebrowser.e eVar, AIOMsgItem aIOMsgItem, RichMediaBrowserApiImpl richMediaBrowserApiImpl, AppRuntime appRuntime, Context context) {
            this.f348585d = eVar;
            this.f348586e = aIOMsgItem;
            this.f348587f = richMediaBrowserApiImpl;
            this.f348588h = appRuntime;
            this.f348589i = context;
        }

        @Override // com.tencent.mobileqq.filebrowser.e.f
        public void f() {
            Object first;
            Activity t06;
            com.tencent.mobileqq.filebrowser.e eVar = this.f348585d;
            com.tencent.mobileqq.filemanager.openbrowser.d dVar = eVar instanceof com.tencent.mobileqq.filemanager.openbrowser.d ? (com.tencent.mobileqq.filemanager.openbrowser.d) eVar : null;
            if (dVar != null && (t06 = dVar.t0()) != null) {
                t06.finish();
            }
            Intrinsics.checkNotNullExpressionValue(this.f348586e.getMsgRecord().elements, "aioMsgItem.msgRecord.elements");
            if (!r0.isEmpty()) {
                ArrayList<MsgElement> arrayList = this.f348586e.getMsgRecord().elements;
                Intrinsics.checkNotNullExpressionValue(arrayList, "aioMsgItem.msgRecord.elements");
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                ((MsgElement) first).fileElement.filePath = this.f348585d.I().getFilePath();
                this.f348587f.enterVideoPreview(this.f348588h, this.f348589i, null, this.f348586e, 0L, false, false, null, null);
            }
        }

        @Override // com.tencent.mobileqq.filebrowser.e.f
        public void e() {
        }

        @Override // com.tencent.mobileqq.filebrowser.e.f
        public void j() {
        }

        @Override // com.tencent.mobileqq.filebrowser.e.f
        public void l() {
        }

        @Override // com.tencent.mobileqq.filebrowser.e.f
        public void a(float progress) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preDownloadLargePic$lambda$11(LoadState loadState, Option option) {
    }
}
