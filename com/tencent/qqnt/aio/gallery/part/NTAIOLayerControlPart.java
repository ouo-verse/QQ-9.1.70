package com.tencent.qqnt.aio.gallery.part;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.avbiz.Constants;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.biz.richframework.video.event.RFWMediaFocusChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.video.u;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C;
import com.tencent.mobileqq.filemanager.nt.NTFileUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.guild.temp.api.impl.GuildGalleryApiImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.MsgRevokeEvent;
import com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi;
import com.tencent.qqnt.aio.adapter.api.IVideoConfigurationChangedApi;
import com.tencent.qqnt.aio.adapter.richmedia.provider.i;
import com.tencent.qqnt.aio.gallery.event.MsgFetchEvent;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.VideoCodecFormatType;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataStore;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.delegate.IVideoOfflineDownload;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.delegate.outer.IMediaProvider;
import com.tencent.richframework.gallery.event.RFWLayerFileStateChangeEvent;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.util.PermissionUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000\u00ee\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000 \u0093\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u0006:\b\u0094\u0001\u0095\u0001\u0096\u0001S[B\t\u00a2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010\u001d\u001a\u00020\u000f2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001bH\u0002J \u0010$\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020 H\u0002J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0016H\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010*\u001a\u00020\rH\u0002J\u0014\u0010-\u001a\u0004\u0018\u00010\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010/\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020 J\u001a\u00104\u001a\u00020\u000f2\u0006\u00101\u001a\u0002002\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u0010\u00105\u001a\u00020\u000f2\u0006\u00101\u001a\u000200H\u0016J\u0012\u00108\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010;\u001a\u00020\u000f2\u0006\u0010:\u001a\u000209H\u0016J\u0018\u0010?\u001a\u00020>2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020<H\u0016J\u0010\u0010@\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010A\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010B\u001a\u00020>2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010C\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0016JJ\u0010J\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010D\u001a\u0004\u0018\u00010\u00162\b\u0010E\u001a\u0004\u0018\u00010\u00162\b\u0010F\u001a\u0004\u0018\u00010\u00162\u001a\u0010I\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010Gj\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`HH\u0016J\u0010\u0010L\u001a\u00020\u000f2\u0006\u0010K\u001a\u000202H\u0014J\u0012\u0010N\u001a\u00020\u000f2\b\u0010M\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040O0GH\u0016J\u0012\u0010Q\u001a\u00020>2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010R\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R$\u0010Y\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR*\u0010a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R(\u0010i\u001a\b\u0018\u00010bR\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR(\u0010q\u001a\b\u0018\u00010jR\u00020\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR>\u0010z\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160rj\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016`s8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR)\u0010\u0081\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00160{j\b\u0012\u0004\u0012\u00020\u0016`|8\u0006\u00a2\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001d\u0010\u0087\u0001\u001a\u00030\u0082\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R)\u0010\u008a\u0001\u001a\u00020>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R)\u0010\u008f\u0001\u001a\u00020>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u0089\u0001\u001a\u0006\b\u008f\u0001\u0010\u008b\u0001\"\u0006\b\u0090\u0001\u0010\u008d\u0001\u00a8\u0006\u0097\u0001"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/outer/IMediaProvider;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/richframework/gallery/delegate/IVideoOfflineDownload;", "Lbv3/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/VideoCodecFormatType;", "U9", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "c2cMessage", "", "O9", "troopMsgRecord", "T9", "Lcom/tencent/mobileqq/filemanager/fileviewer/data/b;", "biz", "R9", "", "mediaId", "Y9", "Lcom/tencent/mobileqq/app/QQAppInterface;", "N9", "", "mediaInfoList", "ga", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState$FileState;", "state", "", "elementId", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "entity", "ea", "L9", "path", "ha", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "S9", "aioMsgItem", "Q9", "targetMediaId", "findMediaInfoWithMediaId", "msgId", "M9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo$PicType;", "picSize", "", "downloadPic", "saveToAlbum", "Z9", "getVideoUrl", "v4", "vid", "playUrl", "localPath", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "cookie", "H2", "bundle", "initIntentData", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "startVideoOfflineDownload", "stopVideoOfflineDownload", "d", "Ljava/lang/String;", "getMsgRecordDataStoreKey", "()Ljava/lang/String;", "setMsgRecordDataStoreKey", "(Ljava/lang/String;)V", "msgRecordDataStoreKey", "Lcom/tencent/richframework/data/idata/IDataStore;", "e", "Lcom/tencent/richframework/data/idata/IDataStore;", "getMsgRecordDataStore", "()Lcom/tencent/richframework/data/idata/IDataStore;", "setMsgRecordDataStore", "(Lcom/tencent/richframework/data/idata/IDataStore;)V", "msgRecordDataStore", "Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$e;", "f", "Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$e;", "getMTroopFileObserver", "()Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$e;", "setMTroopFileObserver", "(Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$e;)V", "mTroopFileObserver", "Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$d;", tl.h.F, "Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$d;", "getMC2CFileObserver", "()Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$d;", "setMC2CFileObserver", "(Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$d;)V", "mC2CFileObserver", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", "getMediaToContextId", "()Ljava/util/HashMap;", "setMediaToContextId", "(Ljava/util/HashMap;)V", "mediaToContextId", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashSet;", "P9", "()Ljava/util/HashSet;", "downloadSuccessVideoElementIds", "Lcom/tencent/qqnt/aio/gallery/pic/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/gallery/pic/a;", "getPicLoaderWrapper", "()Lcom/tencent/qqnt/aio/gallery/pic/a;", "picLoaderWrapper", "D", "Z", "isPartLive", "()Z", "setPartLive", "(Z)V", "E", "isConfigurationChanged", "setConfigurationChanged", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "c", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class NTAIOLayerControlPart extends NTAIOLayerBasePart implements IMediaProvider, SimpleEventReceiver<SimpleBaseEvent>, IVideoOfflineDownload, bv3.a {

    /* renamed from: D, reason: from kotlin metadata */
    private volatile boolean isPartLive;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isConfigurationChanged;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String msgRecordDataStoreKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IDataStore<AIOMsgItem> msgRecordDataStore;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private e mTroopFileObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private d mC2CFileObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, String> mediaToContextId = new HashMap<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final HashSet<String> downloadSuccessVideoElementIds = new HashSet<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.qqnt.aio.gallery.pic.a picLoaderWrapper = new com.tencent.qqnt.aio.gallery.pic.a(((IPicAIOApi) QRoute.api(IPicAIOApi.class)).getPicLoader());

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$b;", "Lcom/tencent/mobileqq/filemanager/core/i;", "Lcom/tencent/superplayer/api/SuperPlayerVideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "errCode", "", "errMsg", "p", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart;", "d", "Ljava/lang/ref/WeakReference;", "mWrfPart", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "e", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mMediaInfo", "part", "mediaInfo", "<init>", "(Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart;Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.filemanager.core.i {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<NTAIOLayerControlPart> mWrfPart;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final RFWLayerItemMediaInfo mMediaInfo;

        public b(NTAIOLayerControlPart part, RFWLayerItemMediaInfo mediaInfo) {
            Intrinsics.checkNotNullParameter(part, "part");
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            this.mWrfPart = new WeakReference<>(part);
            this.mMediaInfo = mediaInfo;
        }

        @Override // com.tencent.mobileqq.filemanager.core.i
        public void m(SuperPlayerVideoInfo videoInfo) {
            RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "[onDownloadInfoSuc]");
            if (videoInfo != null && !TextUtils.isEmpty(videoInfo.getPlayUrl())) {
                NTAIOLayerControlPart nTAIOLayerControlPart = this.mWrfPart.get();
                if (nTAIOLayerControlPart != null) {
                    nTAIOLayerControlPart.H2(this.mMediaInfo, videoInfo.getVid(), videoInfo.getPlayUrl(), videoInfo.getLocalSavePath(), videoInfo.getCookie());
                    return;
                }
                return;
            }
            RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "[onDownloadInfoSuc] but video url is empty");
        }

        @Override // com.tencent.mobileqq.filemanager.core.i
        public void p(int errCode, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "[onDownloadInfoError] errCode:" + errCode + " errMsg:" + errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$c;", "Lcom/tencent/qqnt/aio/adapter/richmedia/provider/i;", "", "path", "", CoverDBCacheData.URLS, "domain", "", "b", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart;", "a", "Ljava/lang/ref/WeakReference;", "mWrfPart", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mMediaInfo", "part", "mediaInfo", "<init>", "(Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart;Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.qqnt.aio.adapter.richmedia.provider.i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<NTAIOLayerControlPart> mWrfPart;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final RFWLayerItemMediaInfo mMediaInfo;

        public c(NTAIOLayerControlPart part, RFWLayerItemMediaInfo mediaInfo) {
            Intrinsics.checkNotNullParameter(part, "part");
            Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
            this.mWrfPart = new WeakReference<>(part);
            this.mMediaInfo = mediaInfo;
        }

        @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.i
        public void a(int i3, String str) {
            i.a.a(this, i3, str);
        }

        @Override // com.tencent.qqnt.aio.adapter.richmedia.provider.i
        public void b(String path, String[] urls, String domain) {
            String joinToString$default;
            List mutableList;
            String str;
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(urls, "urls");
            Intrinsics.checkNotNullParameter(domain, "domain");
            NTAIOLayerControlPart nTAIOLayerControlPart = this.mWrfPart.get();
            if ((nTAIOLayerControlPart != null ? nTAIOLayerControlPart.getMLayerViewModel() : null) == null) {
                return;
            }
            int i3 = RFWLog.USR;
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(urls, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            RFWLog.i("NTAIOLayerControlPart", i3, "[downloadMedia] onGetVideoUrl: path:" + path + " urls:" + joinToString$default);
            if (!(urls.length == 0)) {
                RFWLayerVideoInfo layerVideoInfo = this.mMediaInfo.getLayerVideoInfo();
                if (layerVideoInfo != null) {
                    layerVideoInfo.setVideoOriginUrl(urls[0]);
                }
                RFWLayerVideoInfo layerVideoInfo2 = this.mMediaInfo.getLayerVideoInfo();
                if (layerVideoInfo2 != null) {
                    RFWLayerVideoInfo layerVideoInfo3 = this.mMediaInfo.getLayerVideoInfo();
                    if (layerVideoInfo3 == null || (str = layerVideoInfo3.getVideoOriginUrl()) == null) {
                        str = "";
                    }
                    layerVideoInfo2.setCurrentVideoUrl(str);
                }
                if (urls.length > 1) {
                    mutableList = ArraysKt___ArraysKt.toMutableList(urls);
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(mutableList.subList(0, mutableList.size()));
                    RFWLayerVideoInfo layerVideoInfo4 = this.mMediaInfo.getLayerVideoInfo();
                    if (layerVideoInfo4 != null) {
                        layerVideoInfo4.setVecVideoUrl(arrayList);
                    }
                }
                RFWLayerVideoInfo layerVideoInfo5 = this.mMediaInfo.getLayerVideoInfo();
                if (layerVideoInfo5 != null) {
                    layerVideoInfo5.setLocalPath(path);
                }
                UIStateData<RFWLayerState> value = nTAIOLayerControlPart.getMLayerViewModel().mRichMediaInfo.getValue();
                if (value != null) {
                    value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
                }
                nTAIOLayerControlPart.getMLayerViewModel().mRichMediaInfo.postValue(nTAIOLayerControlPart.getMLayerViewModel().mRichMediaInfo.getValue());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$e;", "Lcom/tencent/mobileqq/app/c;", "", "data", "", "g", "<init>", "(Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class e extends com.tencent.mobileqq.app.c {
        public e() {
        }

        @Override // com.tencent.mobileqq.app.c
        protected void g(Object data) {
            RFWLayerFileDownloadState.FileState fileState;
            if (data instanceof com.tencent.mobileqq.troop.data.t) {
                com.tencent.mobileqq.troop.data.t tVar = (com.tencent.mobileqq.troop.data.t) data;
                switch (tVar.f294972f) {
                    case 8:
                        fileState = RFWLayerFileDownloadState.FileState.DOWNLOADING;
                        break;
                    case 9:
                    default:
                        RFWLayerFileDownloadState.FileState fileState2 = RFWLayerFileDownloadState.FileState.UNKNOWN;
                        return;
                    case 10:
                        fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_FAILED;
                        break;
                    case 11:
                        fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS;
                        break;
                    case 12:
                        fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_FAILED;
                        break;
                }
                if (fileState == RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS) {
                    NTAIOLayerControlPart nTAIOLayerControlPart = NTAIOLayerControlPart.this;
                    long j3 = tVar.K;
                    String str = tVar.f294978l;
                    Intrinsics.checkNotNullExpressionValue(str, "data.LocalFile");
                    nTAIOLayerControlPart.ha(j3, str);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$f", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RFWLayerItemMediaInfo f350029b;

        f(RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
            this.f350029b = rFWLayerItemMediaInfo;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            NTAIOLayerControlPart.this.saveToAlbum(this.f350029b);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            super.onDenied(permissions, results);
            com.tencent.xaction.log.b.a("NTAIOLayerControlPart", 1, "requestPermissions onDenied mediaId: " + this.f350029b.getMediaId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RFWLayerItemMediaInfo L9(long elementId) {
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        String str = com.tencent.qqnt.aio.gallery.i.f350003a.b().get(Long.valueOf(elementId));
        if (str == null) {
            return null;
        }
        try {
            UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
            if (value == null || (data = value.getData()) == null || (richMediaDataList = data.getRichMediaDataList()) == null) {
                return null;
            }
            for (Object obj : richMediaDataList) {
                if (Intrinsics.areEqual(((RFWLayerItemMediaInfo) obj).getMediaId(), str)) {
                    return (RFWLayerItemMediaInfo) obj;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } catch (NoSuchElementException unused) {
            RFWLog.i(getTAG(), RFWLog.USR, "findMediaInfoWithElementId targetMediaId: " + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface N9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private final void O9(RFWLayerItemMediaInfo mediaInfo, AIOMsgItem c2cMessage) {
        RFWLog.i(getTAG(), RFWLog.USR, "troop file is video, getUrl troopMsgRecord:" + mediaInfo.getMediaId());
        NTFileUtils.b a16 = su3.d.f434769a.a(c2cMessage.s0());
        MsgElement msgElement = c2cMessage.getMsgRecord().elements.get(0);
        if (msgElement != null) {
            FileManagerEntity i3 = NTFileUtils.i(N9(), a16, c2cMessage.getMsgRecord(), msgElement.elementId);
            if (i3 == null) {
                RFWLog.e(getTAG(), RFWLog.USR, "getC2CVideoUrl, curEntity == null");
            } else {
                R9(mediaInfo, new VideoForC2C(N9(), i3));
            }
        }
    }

    private final long Q9(AIOMsgItem aioMsgItem) {
        int i3;
        MsgRecord msgRecord = aioMsgItem.getMsgRecord();
        Integer valueOf = msgRecord != null ? Integer.valueOf(msgRecord.msgType) : null;
        if (valueOf != null && valueOf.intValue() == 7) {
            i3 = 5;
        } else {
            i3 = (valueOf != null && valueOf.intValue() == 3) ? 3 : 0;
        }
        MsgElement firstTypeElement = aioMsgItem.getFirstTypeElement(i3);
        if (firstTypeElement != null) {
            return firstTypeElement.elementId;
        }
        return 0L;
    }

    private final void R9(RFWLayerItemMediaInfo mediaInfo, com.tencent.mobileqq.filemanager.fileviewer.data.b biz) {
        com.tencent.mobileqq.filemanager.core.k b16 = com.tencent.mobileqq.filemanager.core.g.b(biz);
        if (b16 != null) {
            com.tencent.qqnt.aio.gallery.i iVar = com.tencent.qqnt.aio.gallery.i.f350003a;
            if (!iVar.a().containsKey(mediaInfo.getMediaId())) {
                ConcurrentHashMap<String, com.tencent.mobileqq.filemanager.core.k> a16 = iVar.a();
                String mediaId = mediaInfo.getMediaId();
                Intrinsics.checkNotNull(mediaId);
                a16.put(mediaId, b16);
            }
        }
        HashMap<String, String> hashMap = this.mediaToContextId;
        String mediaId2 = mediaInfo.getMediaId();
        Intrinsics.checkNotNull(mediaId2);
        String a17 = biz.a();
        Intrinsics.checkNotNullExpressionValue(a17, "biz.contextId");
        hashMap.put(mediaId2, a17);
        if (b16 != null) {
            b16.g(new b(this, mediaInfo));
        }
        if (b16 != null) {
            b16.f(new g(mediaInfo, biz, this));
        }
        if (b16 != null) {
            b16.d(true);
        }
        if (b16 != null) {
            b16.startDownload();
        }
    }

    private final RichMediaElementGetReq S9(String mediaId) {
        RFWLayerItemMediaInfo findMediaInfoWithMediaId = findMediaInfoWithMediaId(mediaId);
        if ((findMediaInfoWithMediaId != null ? findMediaInfoWithMediaId.getExtraData() : null) instanceof AIOMsgItem) {
            Object extraData = findMediaInfoWithMediaId.getExtraData();
            Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            AIOMsgItem aIOMsgItem = (AIOMsgItem) extraData;
            return new RichMediaElementGetReq(aIOMsgItem.getMsgRecord().msgId, aIOMsgItem.getMsgRecord().peerUid, aIOMsgItem.getMsgRecord().chatType, Q9(aIOMsgItem), 1, 0, "", 0L, 2, 1);
        }
        RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "getRichMediaElementReq return null, mediaId: " + mediaId);
        return null;
    }

    private final void T9(RFWLayerItemMediaInfo mediaInfo, AIOMsgItem troopMsgRecord) {
        TroopFileTransferManager.Item m3;
        RFWLog.i(getTAG(), RFWLog.USR, "troop file is video, getUrl troopMsgRecord:" + mediaInfo.getMediaId());
        NTFileUtils.b a16 = su3.d.f434769a.a(troopMsgRecord.s0());
        MsgElement msgElement = troopMsgRecord.getMsgRecord().elements.get(0);
        if (msgElement == null || (m3 = NTFileUtils.m(N9(), a16, troopMsgRecord.getMsgRecord(), msgElement.elementId)) == null) {
            return;
        }
        com.tencent.mobileqq.troop.data.t info = m3.getInfo(troopMsgRecord.getMsgRecord().peerUin);
        if (info == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "getTroopVideoUrl, info == null");
        } else {
            R9(mediaInfo, new com.tencent.mobileqq.filemanager.fileviewer.data.i(info));
        }
    }

    private final VideoCodecFormatType U9(MsgRecord msgRecord) {
        VideoElement videoElement;
        MsgElement m3 = qu3.i.f429570a.m(msgRecord);
        boolean z16 = false;
        if (m3 != null && m3.elementType == 5) {
            z16 = true;
        }
        if (z16 && (videoElement = m3.videoElement) != null) {
            u.Companion companion = com.tencent.mobileqq.aio.msglist.holder.component.video.u.INSTANCE;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            int i3 = videoElement.busiType;
            int i16 = videoElement.thumbWidth;
            int i17 = videoElement.thumbHeight;
            return companion.b(Integer.valueOf(com.tencent.mobileqq.shortvideo.i.a(peekAppRuntime, i3, i16, i17, i16, i17, new com.tencent.mobileqq.aio.msglist.holder.component.video.u())));
        }
        return VideoCodecFormatType.KCODECFORMATH264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(AIOMsgItem targetMsgItem, final com.tencent.qqnt.aio.adapter.richmedia.provider.h hVar, final Pair mainAndSubId, final MsgRecord targetMsgRecord, final NTAIOLayerControlPart this$0, final RFWLayerItemMediaInfo mediaInfo, int i3, String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(targetMsgItem, "$targetMsgItem");
        Intrinsics.checkNotNullParameter(mainAndSubId, "$mainAndSubId");
        Intrinsics.checkNotNullParameter(targetMsgRecord, "$targetMsgRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        RFWLog.d("NTAIOLayerControlPart", RFWLog.USR, "forwardMsg getMsgsByMsgId result=" + i3 + ", errMsg=" + str);
        if (arrayList != null && (!arrayList.isEmpty())) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.part.e
                @Override // java.lang.Runnable
                public final void run() {
                    NTAIOLayerControlPart.W9(com.tencent.qqnt.aio.adapter.richmedia.provider.h.this, arrayList, mainAndSubId, targetMsgRecord, this$0, mediaInfo);
                }
            });
            return;
        }
        RFWLog.e("NTAIOLayerControlPart", RFWLog.USR, "getKernelMsgService can't find msg by msgId: " + targetMsgItem.q0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(com.tencent.qqnt.aio.adapter.richmedia.provider.h hVar, ArrayList arrayList, Pair mainAndSubId, MsgRecord targetMsgRecord, NTAIOLayerControlPart this$0, RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mainAndSubId, "$mainAndSubId");
        Intrinsics.checkNotNullParameter(targetMsgRecord, "$targetMsgRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Object obj = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "msgList[0]");
        hVar.b((MsgRecord) obj, ((Number) mainAndSubId.getSecond()).intValue(), 1, qu3.i.f429570a.m(targetMsgRecord), 0, 2, this$0.U9(targetMsgRecord), new c(this$0, mediaInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(com.tencent.qqnt.aio.adapter.richmedia.provider.h hVar, MsgRecord targetMsgRecord, Pair mainAndSubId, NTAIOLayerControlPart this$0, RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(targetMsgRecord, "$targetMsgRecord");
        Intrinsics.checkNotNullParameter(mainAndSubId, "$mainAndSubId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        hVar.b(targetMsgRecord, ((Number) mainAndSubId.getSecond()).intValue(), 1, null, 0, 2, this$0.U9(targetMsgRecord), new c(this$0, mediaInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9(String mediaId) {
        com.tencent.qqnt.aio.gallery.i iVar = com.tencent.qqnt.aio.gallery.i.f350003a;
        com.tencent.mobileqq.filemanager.core.k kVar = iVar.a().get(mediaId);
        if (kVar != null) {
            kVar.f(null);
            kVar.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(NTAIOLayerControlPart this$0, RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        IAIOFileManagerApi iAIOFileManagerApi = (IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class);
        Activity activity = this$0.getActivity();
        Object extraData = mediaInfo.getExtraData();
        Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
        iAIOFileManagerApi.downloadFile(activity, (AIOMsgItem) extraData, new Function0<Unit>() { // from class: com.tencent.qqnt.aio.gallery.part.NTAIOLayerControlPart$saveToAlbumInner$1$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(final NTAIOLayerControlPart this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int i3 = z16 ? 2 : 0;
        final int i16 = z16 ? R.string.f173075h42 : R.string.f238307je;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.part.i
            @Override // java.lang.Runnable
            public final void run() {
                NTAIOLayerControlPart.ca(NTAIOLayerControlPart.this, i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(NTAIOLayerControlPart this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQToast.makeText(this$0.getContext(), i3, i16, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(NTAIOLayerControlPart this$0, RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        FileManagerUtil.saveToAlbum(this$0.getContext(), mediaInfo.getExistSaveOrEditPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea(RFWLayerFileDownloadState.FileState state, long elementId, FileManagerEntity entity) {
        String str = com.tencent.qqnt.aio.gallery.i.f350003a.b().get(Long.valueOf(elementId));
        if (str == null) {
            return;
        }
        RFWLog.i(getTAG(), RFWLog.USR, "entity.fProgress: " + entity.fProgress + ", fileType = " + entity.nFileType + ", mediaId: " + str);
        RFWLayerFileDownloadState rFWLayerFileDownloadState = new RFWLayerFileDownloadState(str);
        rFWLayerFileDownloadState.setFileState(state);
        rFWLayerFileDownloadState.setProgressPercent(entity.fProgress);
        rFWLayerFileDownloadState.setFileSize(entity.fileSize);
        int i3 = entity.nFileType;
        if (i3 == 2) {
            RFWLayerDataCenter.INSTANCE.updateVideoFileState(str, rFWLayerFileDownloadState);
        } else if (i3 == 0) {
            RFWLayerDataCenter.INSTANCE.updateFileState(rFWLayerFileDownloadState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RFWLayerItemMediaInfo findMediaInfoWithMediaId(String targetMediaId) {
        RFWLayerState data;
        List<RFWLayerItemMediaInfo> richMediaDataList;
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        Object obj = null;
        if (value == null || (data = value.getData()) == null || (richMediaDataList = data.getRichMediaDataList()) == null) {
            return null;
        }
        Iterator<T> it = richMediaDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((RFWLayerItemMediaInfo) next).getMediaId(), targetMediaId)) {
                obj = next;
                break;
            }
        }
        return (RFWLayerItemMediaInfo) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha(long elementId, String path) {
        RFWLayerItemMediaInfo L9 = L9(elementId);
        if (L9 == null) {
            return;
        }
        RFWLayerPicInfo layerPicInfo = L9.getLayerPicInfo();
        if ((layerPicInfo != null ? layerPicInfo.getOriginPicInfo() : null) != null) {
            RFWLayerPicInfo layerPicInfo2 = L9.getLayerPicInfo();
            RFWLayerPicInfo.RFWPicInfo originPicInfo = layerPicInfo2 != null ? layerPicInfo2.getOriginPicInfo() : null;
            if (originPicInfo != null) {
                originPicInfo.setUrl(path);
            }
            RFWLayerPicInfo layerPicInfo3 = L9.getLayerPicInfo();
            RFWLayerPicInfo.RFWPicInfo originPicInfo2 = layerPicInfo3 != null ? layerPicInfo3.getOriginPicInfo() : null;
            if (originPicInfo2 != null) {
                originPicInfo2.setLocalPath(path);
            }
            RFWLog.i(getTAG(), RFWLog.USR, "onFileTransferEnd update:" + L9.getMediaId() + " path:" + path);
            UIStateData.ModifyListRecord obtainNotifyItemRangeChange = UIStateData.ModifyListRecord.obtainNotifyItemRangeChange(this.mSelectedPosition, 1);
            Intrinsics.checkNotNullExpressionValue(obtainNotifyItemRangeChange, "obtainNotifyItemRangeChange(mSelectedPosition, 1)");
            updateRichMediaList(obtainNotifyItemRangeChange);
            if (L9.getExtraData() instanceof AIOMsgItem) {
                Object extraData = L9.getExtraData();
                Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
                MsgElement firstTypeElement = ((AIOMsgItem) extraData).getFirstTypeElement(3);
                if (firstTypeElement != null) {
                    firstTypeElement.fileElement.filePath = path;
                }
            }
        }
    }

    @Override // bv3.a
    public void H2(RFWLayerItemMediaInfo mediaInfo, String vid, String playUrl, String localPath, ArrayList<String> cookie) {
        String videoOriginUrl;
        RFWLayerVideoInfo layerVideoInfo;
        RFWLayerVideoInfo layerVideoInfo2;
        String localPath2;
        RFWLayerVideoInfo layerVideoInfo3;
        RFWLayerVideoInfo layerVideoInfo4;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        RFWLog.i(getTAG(), RFWLog.USR, "updateVideoInfo update:" + mediaInfo.getMediaId());
        if (playUrl != null && (layerVideoInfo4 = mediaInfo.getLayerVideoInfo()) != null) {
            layerVideoInfo4.setVideoOriginUrl(playUrl);
        }
        if (localPath != null && (layerVideoInfo3 = mediaInfo.getLayerVideoInfo()) != null) {
            layerVideoInfo3.setLocalPath(localPath);
        }
        boolean fileExists = RFWFileUtils.fileExists(localPath);
        String str = "";
        if (fileExists) {
            RFWLayerVideoInfo layerVideoInfo5 = mediaInfo.getLayerVideoInfo();
            if (layerVideoInfo5 != null) {
                RFWLayerVideoInfo layerVideoInfo6 = mediaInfo.getLayerVideoInfo();
                if (layerVideoInfo6 != null && (localPath2 = layerVideoInfo6.getLocalPath()) != null) {
                    str = localPath2;
                }
                layerVideoInfo5.setCurrentVideoUrl(str);
            }
        } else {
            RFWLayerVideoInfo layerVideoInfo7 = mediaInfo.getLayerVideoInfo();
            if (layerVideoInfo7 != null) {
                RFWLayerVideoInfo layerVideoInfo8 = mediaInfo.getLayerVideoInfo();
                if (layerVideoInfo8 != null && (videoOriginUrl = layerVideoInfo8.getVideoOriginUrl()) != null) {
                    str = videoOriginUrl;
                }
                layerVideoInfo7.setCurrentVideoUrl(str);
            }
        }
        if (cookie != null && (layerVideoInfo2 = mediaInfo.getLayerVideoInfo()) != null) {
            layerVideoInfo2.setCookies(cookie);
        }
        if (vid != null && (layerVideoInfo = mediaInfo.getLayerVideoInfo()) != null) {
            layerVideoInfo.setFileId(vid);
        }
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        if (value != null) {
            value.setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged());
        }
        getMLayerViewModel().mRichMediaInfo.postValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    public final AIOMsgItem M9(long msgId) {
        IDataStore<AIOMsgItem> iDataStore = this.msgRecordDataStore;
        AIOMsgItem data = iDataStore != null ? iDataStore.getData(String.valueOf(msgId)) : null;
        if (data != null) {
            return data;
        }
        return null;
    }

    public final HashSet<String> P9() {
        return this.downloadSuccessVideoElementIds;
    }

    public final void Z9(final RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (TextUtils.isEmpty(mediaInfo.getExistSaveOrEditPath()) && (mediaInfo.getExtraData() instanceof AIOMsgItem)) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.part.f
                @Override // java.lang.Runnable
                public final void run() {
                    NTAIOLayerControlPart.aa(NTAIOLayerControlPart.this, mediaInfo);
                }
            });
            return;
        }
        Boolean i3 = AIOGalleryUtils.i();
        Intrinsics.checkNotNullExpressionValue(i3, "isNewSaveApiEnable()");
        if (i3.booleanValue()) {
            AIOGalleryUtils.m(getContext(), mediaInfo.getExistSaveOrEditPath(), false, new AIOGalleryUtils.d() { // from class: com.tencent.qqnt.aio.gallery.part.g
                @Override // com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.d
                public final void onSavePhotoResult(boolean z16) {
                    NTAIOLayerControlPart.ba(NTAIOLayerControlPart.this, z16);
                }
            });
        } else {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.part.h
                @Override // java.lang.Runnable
                public final void run() {
                    NTAIOLayerControlPart.da(NTAIOLayerControlPart.this, mediaInfo);
                }
            });
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaProvider
    public boolean downloadPic(RFWLayerItemMediaInfo mediaInfo, RFWLayerPicInfo.PicType picSize) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        if (!(mediaInfo.getExtraData() instanceof AIOMsgItem)) {
            return false;
        }
        Object extraData = mediaInfo.getExtraData();
        Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
        AIOMsgItem aIOMsgItem = (AIOMsgItem) extraData;
        MsgRecord msgRecord = aIOMsgItem.getMsgRecord();
        Pair<Long, Integer> a16 = com.tencent.qqnt.aio.gallery.h.f350002a.a(mediaInfo);
        if (a16 == null || com.tencent.qqnt.aio.gallery.e.a(msgRecord, a16.getSecond().intValue()) != 2 || picSize != RFWLayerPicInfo.PicType.ORIGIN) {
            return false;
        }
        RFWLog.d(getTAG(), RFWLog.USR, "downloadFile msgId: " + aIOMsgItem.getMsgId());
        ((IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class)).downloadFile(getActivity(), aIOMsgItem, new Function0<Unit>() { // from class: com.tencent.qqnt.aio.gallery.part.NTAIOLayerControlPart$downloadPic$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(RFWLayerFileStateChangeEvent.class);
        arrayList.add(MsgRevokeEvent.class);
        arrayList.add(MsgFetchEvent.class);
        arrayList.add(RFWMediaFocusChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart
    protected void initIntentData(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        com.tencent.mobileqq.richmediabrowser.h.a().n(getActivity().getIntent());
        String string = bundle.getString(GuildGalleryApiImpl.MSG_RECORD_STORE_KEY);
        this.msgRecordDataStoreKey = string;
        if (string != null) {
            this.msgRecordDataStore = RFWLayerDataCenter.INSTANCE.getAllDataStore().get(this.msgRecordDataStoreKey);
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        RFWLayerInitBean rFWLayerInitBean = (RFWLayerInitBean) ((Activity) context).getIntent().getParcelableExtra(RFWLaunchKey.KEY_INIT_BEAN);
        List<RFWLayerItemMediaInfo> richMediaDataList = rFWLayerInitBean != null ? rFWLayerInitBean.getRichMediaDataList() : null;
        com.tencent.qqnt.aio.gallery.i.f350003a.b().clear();
        ga(richMediaDataList);
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null && configuration.orientation == 1) {
            RFWLog.d(getTAG(), RFWLog.USR, "onConfigurationChanged ORIENTATION_PORTRAIT");
            this.isConfigurationChanged = true;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWLayerIOCUtil.registerPicLoader(rootView, this.picLoaderWrapper);
        RFWLayerIOCUtil.registerMediaProvider(rootView, this);
        RFWIocAbilityProvider.g().registerGlobalIoc(getActivity(), this, IVideoOfflineDownload.class);
    }

    @Override // com.tencent.richframework.gallery.part.NTAIOLayerBasePart, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        this.isPartLive = true;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        bv3.d.f29249a.d(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        RFWLog.d(getTAG(), RFWLog.USR, "onPartCreate registerListener");
        if (peekAppRuntime instanceof QQAppInterface) {
            if (this.mTroopFileObserver == null) {
                e eVar = new e();
                this.mTroopFileObserver = eVar;
                ((QQAppInterface) peekAppRuntime).addObserver(eVar);
            }
            if (this.mC2CFileObserver == null) {
                this.mC2CFileObserver = new d();
                ((QQAppInterface) peekAppRuntime).getFileManagerNotifyCenter().addObserver(this.mC2CFileObserver);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Iterator it;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        this.isPartLive = false;
        if (this.msgRecordDataStoreKey != null) {
            RFWLayerDataCenter.INSTANCE.getAllDataStore().remove(this.msgRecordDataStoreKey);
        }
        RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
        rFWLayerDataCenter.getAllDataStore().remove(GuildGalleryApiImpl.AIO_RICH_MEDIA_DATA_KEY);
        rFWLayerDataCenter.clearAllData();
        if (this.mTroopFileObserver != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            ((QQAppInterface) peekAppRuntime).removeObserver(this.mTroopFileObserver);
        }
        if (this.mC2CFileObserver != null) {
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            ((QQAppInterface) peekAppRuntime2).getFileManagerNotifyCenter().deleteObserver(this.mC2CFileObserver);
        }
        if (this.isConfigurationChanged) {
            RFWLog.d(getTAG(), RFWLog.USR, "notifyConfigurationChanged");
            ((IVideoConfigurationChangedApi) QRoute.api(IVideoConfigurationChangedApi.class)).notifyConfigurationChanged();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        bv3.d.f29249a.j(this);
        Iterator<T> it5 = this.downloadSuccessVideoElementIds.iterator();
        while (it5.hasNext()) {
            com.tencent.mobileqq.filemanager.core.g.k((String) it5.next(), true);
        }
        Enumeration<String> downloadKeys = com.tencent.qqnt.aio.gallery.i.f350003a.a().keys();
        Intrinsics.checkNotNullExpressionValue(downloadKeys, "downloadKeys");
        it = CollectionsKt__IteratorsJVMKt.iterator(downloadKeys);
        while (it.hasNext()) {
            String str = (String) it.next();
            Y9(str);
            com.tencent.qqnt.aio.gallery.i.f350003a.a().remove(str);
        }
        com.tencent.qqnt.aio.gallery.i.f350003a.d().clear();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo;
        IVideoPlayerProvider mLayerVideoControlProvider;
        IDataStore<AIOMsgItem> iDataStore;
        if (event instanceof RFWLayerFileStateChangeEvent) {
            RFWLayerFileStateChangeEvent rFWLayerFileStateChangeEvent = (RFWLayerFileStateChangeEvent) event;
            RFWLayerFileDownloadState rFWLayerFileDownloadState = rFWLayerFileStateChangeEvent.mState;
            if ((rFWLayerFileDownloadState != null ? rFWLayerFileDownloadState.getFileState() : null) == RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS) {
                RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "downloadSuccess mediaId: " + rFWLayerFileStateChangeEvent.mState.getMediaId());
                if (com.tencent.qqnt.aio.gallery.i.f350003a.c().containsKey(rFWLayerFileStateChangeEvent.mState.getMediaId())) {
                    RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "RFWLayerFileStateChangeEvent containsKey mediaId: " + rFWLayerFileStateChangeEvent.mState.getMediaId());
                    RFWLayerItemMediaInfo findMediaInfoWithMediaId = findMediaInfoWithMediaId(rFWLayerFileStateChangeEvent.mState.getMediaId());
                    if (findMediaInfoWithMediaId != null) {
                        bv3.d.f(bv3.d.f29249a, findMediaInfoWithMediaId, null, 2, null);
                    } else {
                        RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "RFWLayerFileStateChangeEvent mediaId: " + rFWLayerFileStateChangeEvent.mState.getMediaId() + ", mediaInfo is null");
                    }
                }
                String str = this.mediaToContextId.get(rFWLayerFileStateChangeEvent.mState.getMediaId());
                if (str == null || TextUtils.isEmpty(str)) {
                    return;
                }
                com.tencent.mobileqq.filemanager.core.g.g(str);
                return;
            }
            return;
        }
        if (event instanceof MsgFetchEvent) {
            MsgFetchEvent msgFetchEvent = (MsgFetchEvent) event;
            List<MsgRecord> msgRecordList = msgFetchEvent.getMsgRecordList();
            if (msgRecordList != null) {
                for (MsgRecord msgRecord : msgRecordList) {
                    IDataStore<AIOMsgItem> iDataStore2 = this.msgRecordDataStore;
                    if ((iDataStore2 != null ? iDataStore2.getData(String.valueOf(msgRecord.msgId)) : null) == null && (iDataStore = this.msgRecordDataStore) != null) {
                        iDataStore.addData(new AIOMsgItem(msgRecord));
                    }
                }
            }
            ga(msgFetchEvent.getItemMediaInfoList());
            return;
        }
        if (event instanceof RFWMediaFocusChangeEvent) {
            RFWMediaFocusChangeEvent rFWMediaFocusChangeEvent = (RFWMediaFocusChangeEvent) event;
            if (TextUtils.equals(Constants.Business.QQ_LAYER, rFWMediaFocusChangeEvent.getConflictBusinessName()) && rFWMediaFocusChangeEvent.hasFocusConflict()) {
                IVideoPlayerProvider mLayerVideoControlProvider2 = getMLayerVideoControlProvider();
                boolean z16 = false;
                if (mLayerVideoControlProvider2 != null && mLayerVideoControlProvider2.isPlaying()) {
                    z16 = true;
                }
                if (!z16 || (rFWLayerItemMediaInfo = this.mCurrentSelectedItem) == null) {
                    return;
                }
                Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
                if (!rFWLayerItemMediaInfo.isVideo() || (mLayerVideoControlProvider = getMLayerVideoControlProvider()) == null) {
                    return;
                }
                mLayerVideoControlProvider.stop();
            }
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaProvider
    public void saveToAlbum(RFWLayerItemMediaInfo mediaInfo) {
        boolean contains;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "[saveToAlbum] mediaId: " + mediaInfo.getMediaId() + ", videoPath: " + mediaInfo.getExistSaveOrEditPath());
        String str = this.mediaToContextId.get(mediaInfo.getMediaId());
        contains = CollectionsKt___CollectionsKt.contains(this.downloadSuccessVideoElementIds, str);
        if (contains) {
            com.tencent.mobileqq.filemanager.core.g.k(str, true);
        }
        Z9(mediaInfo);
    }

    @Override // com.tencent.richframework.gallery.delegate.IVideoOfflineDownload
    public boolean startVideoOfflineDownload(String mediaId) {
        if (!TextUtils.isEmpty(mediaId) && com.tencent.qqnt.aio.gallery.i.f350003a.c().containsKey(mediaId)) {
            return false;
        }
        RFWLayerItemMediaInfo findMediaInfoWithMediaId = findMediaInfoWithMediaId(mediaId);
        if (findMediaInfoWithMediaId != null) {
            ConcurrentHashMap<String, RFWLayerItemMediaInfo> c16 = com.tencent.qqnt.aio.gallery.i.f350003a.c();
            Intrinsics.checkNotNull(mediaId);
            c16.put(mediaId, findMediaInfoWithMediaId);
        }
        RichMediaElementGetReq S9 = S9(mediaId);
        if (S9 == null) {
            return true;
        }
        RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "startVideoOfflineDownload mediaId: " + mediaId);
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.getRichMediaElement(S9);
        }
        RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
        Intrinsics.checkNotNull(mediaId);
        RFWLayerFileDownloadState rFWLayerFileDownloadState = new RFWLayerFileDownloadState(mediaId);
        rFWLayerFileDownloadState.setFileState(RFWLayerFileDownloadState.FileState.DOWNLOADING);
        rFWLayerFileDownloadState.setProgressPercent(0.0f);
        rFWLayerFileDownloadState.setFileSize(0L);
        rFWLayerDataCenter.updateFileState(rFWLayerFileDownloadState);
        return true;
    }

    @Override // com.tencent.richframework.gallery.delegate.IVideoOfflineDownload
    public void stopVideoOfflineDownload(String mediaId) {
        com.tencent.qqnt.aio.gallery.i iVar = com.tencent.qqnt.aio.gallery.i.f350003a;
        if (iVar.c().containsKey(mediaId)) {
            TypeIntrinsics.asMutableMap(iVar.c()).remove(mediaId);
        }
        RichMediaElementGetReq S9 = S9(mediaId);
        if (S9 != null) {
            RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "stopVideoOfflineDownload mediaId: " + mediaId);
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.cancelGetRichMediaElement(S9);
            }
        }
    }

    @Override // bv3.a
    public void v4(RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        com.tencent.xaction.log.b.a("NTAIOLayerControlPart", 1, "dealSaveVideo mediaId: " + mediaInfo.getMediaId() + ", filePath: " + mediaInfo.getExistSaveOrEditPath());
        if (mediaInfo.getExistSaveOrEditPath() != null) {
            if (!PermissionUtil.isHasStoragePermission(getActivity())) {
                if (!getActivity().isFinishing() && !getActivity().isDestroyed()) {
                    QQPermissionFactory.getQQPermission(getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_VIDEO)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new f(mediaInfo));
                    return;
                }
                com.tencent.xaction.log.b.a("NTAIOLayerControlPart", 1, "dealSaveVideo activity is finish, mediaId: " + mediaInfo.getMediaId());
                return;
            }
            saveToAlbum(mediaInfo);
        }
    }

    private final void ga(List<? extends RFWLayerItemMediaInfo> mediaInfoList) {
        RFWLayerItemMediaInfo next;
        Pair<Long, Integer> a16;
        AIOMsgItem M9;
        RFWLayerPicInfo layerPicInfo;
        if (mediaInfoList != null) {
            Iterator<? extends RFWLayerItemMediaInfo> it = mediaInfoList.iterator();
            while (it.hasNext() && (a16 = com.tencent.qqnt.aio.gallery.h.f350002a.a((next = it.next()))) != null && (M9 = M9(a16.getFirst().longValue())) != null) {
                MsgRecord msgRecord = M9.getMsgRecord();
                if (msgRecord.elements.size() > a16.getSecond().intValue() && a16.getSecond().intValue() >= 0) {
                    MsgElement msgElement = msgRecord.elements.get(a16.getSecond().intValue());
                    if (next.getLayerPicInfo() != null && (layerPicInfo = next.getLayerPicInfo()) != null) {
                        layerPicInfo.setPicId(String.valueOf(msgElement.elementId));
                    }
                    HashMap<Long, String> b16 = com.tencent.qqnt.aio.gallery.i.f350003a.b();
                    Long valueOf = Long.valueOf(msgElement.elementId);
                    String mediaId = next.getMediaId();
                    Intrinsics.checkNotNull(mediaId);
                    b16.put(valueOf, mediaId);
                }
                next.setExtraData(M9);
            }
        }
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IMediaProvider
    public boolean getVideoUrl(final RFWLayerItemMediaInfo mediaInfo) {
        final AIOMsgItem M9;
        boolean z16;
        ArrayList<Long> arrayListOf;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        RFWLog.d(getTAG(), RFWLog.USR, "downloadMedia:" + mediaInfo);
        final Pair<Long, Integer> a16 = com.tencent.qqnt.aio.gallery.h.f350002a.a(mediaInfo);
        if (a16 == null || (M9 = M9(a16.getFirst().longValue())) == null) {
            return false;
        }
        final MsgRecord msgRecord = M9.getMsgRecord();
        final com.tencent.qqnt.aio.adapter.richmedia.provider.h e16 = ru3.c.e(ru3.c.f432503a, msgRecord, null, 2, null);
        RFWLog.i(getTAG(), RFWLog.USR, "[downloadMedia] msgSeq: " + msgRecord.msgSeq + ", type: " + msgRecord.msgType + ", msgId: " + msgRecord.msgId + ", subType: " + msgRecord.subMsgType);
        if (e16 == null) {
            return false;
        }
        int a17 = com.tencent.qqnt.aio.gallery.e.a(msgRecord, a16.getSecond().intValue());
        if (a17 == 4) {
            z16 = true;
            if (M9.p0() == 1) {
                O9(mediaInfo, M9);
                return true;
            }
        } else {
            z16 = true;
        }
        if (a17 == 4 && M9.p0() == 2) {
            T9(mediaInfo, M9);
            return z16;
        }
        if (a17 != 3) {
            return false;
        }
        RFWLog.i(getTAG(), RFWLog.USR, "download video:" + mediaInfo.getMediaId());
        if (M9.s0() == null && M9.k0() == null) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.qqnt.aio.gallery.part.d
                @Override // java.lang.Runnable
                public final void run() {
                    NTAIOLayerControlPart.X9(com.tencent.qqnt.aio.adapter.richmedia.provider.h.this, msgRecord, a16, this, mediaInfo);
                }
            });
            return true;
        }
        com.tencent.qqnt.kernel.api.w e17 = com.tencent.qqnt.msg.f.e();
        if (e17 == null) {
            return true;
        }
        Contact contact = new Contact(M9.p0(), M9.r0(), "");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(M9.q0()));
        e17.getMsgsByMsgId(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.qqnt.aio.gallery.part.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                NTAIOLayerControlPart.V9(AIOMsgItem.this, e16, a16, msgRecord, this, mediaInfo, i3, str, arrayList);
            }
        });
        return true;
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$g", "Lcom/tencent/mobileqq/filemanager/core/j;", "", "playableDurationMS", "downloadSpeedKBs", "", "currentDownloadSizeByte", "totalFileSizeByte", "", "d", "", "targetPath", "r", "moduleID", "errCode", "extInfo", "onDownloadError", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements com.tencent.mobileqq.filemanager.core.j {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RFWLayerItemMediaInfo f350030d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filemanager.fileviewer.data.b f350031e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ NTAIOLayerControlPart f350032f;

        g(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, com.tencent.mobileqq.filemanager.fileviewer.data.b bVar, NTAIOLayerControlPart nTAIOLayerControlPart) {
            this.f350030d = rFWLayerItemMediaInfo;
            this.f350031e = bVar;
            this.f350032f = nTAIOLayerControlPart;
        }

        @Override // com.tencent.mobileqq.filemanager.core.j
        public void onDownloadError(int moduleID, int errCode, String extInfo) {
            this.f350032f.Y9(this.f350030d.getMediaId());
            RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "[onDownloadError] mediaId: " + this.f350030d.getMediaId() + ", moduleID:" + moduleID + " errCode:" + errCode + ", extInfo:" + extInfo);
        }

        @Override // com.tencent.mobileqq.filemanager.core.j
        public void r(String targetPath) {
            RFWLog.i("NTAIOLayerControlPart", RFWLog.USR, "[onDownloadFinish] mediaId: " + this.f350030d.getMediaId() + ", targetPath:" + targetPath + " biz.contextId:" + this.f350031e.a());
            RFWLayerItemMediaInfo findMediaInfoWithMediaId = this.f350032f.findMediaInfoWithMediaId(this.f350030d.getMediaId());
            if (findMediaInfoWithMediaId != null) {
                bv3.d.f(bv3.d.f29249a, findMediaInfoWithMediaId, null, 2, null);
            }
            this.f350032f.P9().add(this.f350031e.a());
            this.f350032f.Y9(this.f350030d.getMediaId());
        }

        @Override // com.tencent.mobileqq.filemanager.core.j
        public void d(int playableDurationMS, int downloadSpeedKBs, long currentDownloadSizeByte, long totalFileSizeByte) {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0014JD\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0014\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart$d;", "Lcom/tencent/mobileqq/filemanager/app/FMObserver;", "", "isShowCancel", "", "uniSeq", "sessionId", "", "strUin", "", "peerType", "", "T", "isSuccess", "errCode", "errMsg", ExifInterface.LATITUDE_SOUTH, "<init>", "(Lcom/tencent/qqnt/aio/gallery/part/NTAIOLayerControlPart;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class d extends FMObserver {
        public d() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void S(boolean isSuccess, long uniSeq, long sessionId, String strUin, int peerType, int errCode, String errMsg) {
            RFWLayerFileDownloadState.FileState fileState;
            FileManagerDataCenter fileManagerDataCenter;
            QQAppInterface N9 = NTAIOLayerControlPart.this.N9();
            FileManagerEntity D = (N9 == null || (fileManagerDataCenter = N9.getFileManagerDataCenter()) == null) ? null : fileManagerDataCenter.D(sessionId);
            if (D == null) {
                return;
            }
            String tag = NTAIOLayerControlPart.this.getTAG();
            int i3 = RFWLog.USR;
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = NTAIOLayerControlPart.this.mCurrentSelectedItem;
            RFWLog.i(tag, i3, "OfflineFileObserver onFileTransferEnd uniSeq:" + uniSeq + " sessionId:" + sessionId + " errorCode:" + errCode + " mediaId: " + (rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getMediaId() : null));
            NTAIOLayerControlPart nTAIOLayerControlPart = NTAIOLayerControlPart.this;
            if (isSuccess) {
                fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_SUCCESS;
            } else {
                fileState = RFWLayerFileDownloadState.FileState.DOWNLOAD_FAILED;
            }
            nTAIOLayerControlPart.ea(fileState, uniSeq, D);
            if (TextUtils.isEmpty(D.getFilePath())) {
                RFWLog.i(NTAIOLayerControlPart.this.getTAG(), RFWLog.USR, "OfflineFileObserver transferEnd filePath is empty");
                return;
            }
            if (isSuccess) {
                int i16 = D.nFileType;
                if (i16 == 0) {
                    NTAIOLayerControlPart nTAIOLayerControlPart2 = NTAIOLayerControlPart.this;
                    String filePath = D.getFilePath();
                    Intrinsics.checkNotNullExpressionValue(filePath, "entity.filePath");
                    nTAIOLayerControlPart2.ha(uniSeq, filePath);
                    return;
                }
                if (i16 == 2) {
                    NTAIOLayerControlPart.this.P9().add(String.valueOf(uniSeq));
                    RFWLayerItemMediaInfo L9 = NTAIOLayerControlPart.this.L9(uniSeq);
                    if (L9 == null) {
                        return;
                    }
                    NTAIOLayerControlPart.this.H2(L9, null, null, D.getFilePath(), null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        public void T(boolean isShowCancel, long uniSeq, long sessionId, String strUin, int peerType) {
        }
    }
}
