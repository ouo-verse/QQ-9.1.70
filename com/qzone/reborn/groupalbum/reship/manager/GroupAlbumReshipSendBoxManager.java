package com.qzone.reborn.groupalbum.reship.manager;

import android.os.Parcel;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.groupalbum.GroupAlbumReshipAlbumPicTask;
import com.qzone.publish.business.task.groupalbum.GroupAlbumReshipAlbumVideoTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.groupalbum.event.GroupAlbumUploadAlbumEvent;
import com.qzone.util.image.ImageInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qqnt.kernel.api.g;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceQueryQuoteToQunAlbumStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTQueryQuoteToQunAlbumStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.NTQueryQuoteToQunAlbumStatusRsp;
import com.tencent.qqnt.kernel.nativeinterface.QuoteStatus;
import com.tencent.qqnt.kernel.nativeinterface.QuoteToQunAlbumUnit;
import com.tencent.qqnt.kernel.nativeinterface.RequestTimelineInfo;
import com.tencent.qqnt.kernel.nativeinterface.StatusUnit;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import fj.r;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bM\u0010NJ\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0003J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0002J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J:\u0010#\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\b2\u0006\u0010\"\u001a\u00020!J\u001e\u0010&\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$J\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010(\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010)\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010+\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u001dJ\u0010\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010-\u001a\u00020,J\u0010\u00101\u001a\u0004\u0018\u00010,2\u0006\u00100\u001a\u00020.J\u000e\u00102\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J,\u00107\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\f\u00106\u001a\b\u0012\u0004\u0012\u00020504JV\u0010>\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u001504j\b\u0012\u0004\u0012\u00020\u0015`92\u0006\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u001bR(\u0010C\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0@0?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR,\u0010F\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170D0@0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010BR \u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010BR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006O"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/manager/GroupAlbumReshipSendBoxManager;", "", "", "groupId", "Lkotlin/Function0;", "", "block", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Lcom/qzone/publish/business/task/IQueueTask;", Constants.Raft.TASKS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/qzone/reborn/groupalbum/reship/manager/GroupAlbumReshipSendBoxCell;", "cellList", "p", "mediaId", "", "status", "B", "Lcom/qzone/reborn/groupalbum/reship/manager/GroupAblbumReshipUnit;", "unit", "Lcom/tencent/qqnt/kernel/nativeinterface/QuoteToQunAlbumUnit;", "o", "Lcom/qzone/reborn/groupalbum/reship/manager/b;", "listener", "i", "v", "", "batchId", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfoList", "Lcom/qzone/proxy/feedcomponent/model/ShuoshuoVideoInfo;", "shuoshuoVideoInfoList", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", BdhLogUtil.LogTag.Tag_Conn, "", "needNotifyUI", "u", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "mediaInfo", "j", "Lcom/tencent/component/app/common/SmartParcelable;", "struct", "", "y", "bytes", "k", "w", "albumId", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/StatusUnit;", "statusUnits", "D", "clientKey", "Lkotlin/collections/ArrayList;", "units", "seq", "retryCount", "delay", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "sendBoxMap", "Lmqq/util/WeakReference;", "c", "mReshipSendBoxListenerMap", "d", "mHaveInitDbMap", "Lmqq/app/IAccountCallback;", "e", "Lmqq/app/IAccountCallback;", "accountCallback", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumReshipSendBoxManager {

    /* renamed from: a, reason: collision with root package name */
    public static final GroupAlbumReshipSendBoxManager f56848a = new GroupAlbumReshipSendBoxManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ConcurrentHashMap<String, CopyOnWriteArrayList<GroupAlbumReshipSendBoxCell>> sendBoxMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<WeakReference<b>>> mReshipSendBoxListenerMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Boolean> mHaveInitDbMap = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final IAccountCallback accountCallback;

    static {
        a aVar = new a();
        accountCallback = aVar;
        MobileQQ.sMobileQQ.registerAccountCallback(aVar);
    }

    GroupAlbumReshipSendBoxManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(String groupId, Function0 block) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(block, "$block");
        List<GroupAlbumReshipSendBoxDbEntity> f16 = com.qzone.reborn.groupalbum.reship.manager.a.c().f(groupId);
        if (f16 != null && !f16.isEmpty()) {
            for (GroupAlbumReshipSendBoxDbEntity groupAlbumReshipSendBoxDbEntity : f16) {
                try {
                    GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager = f56848a;
                    byte[] bArr = groupAlbumReshipSendBoxDbEntity.data;
                    Intrinsics.checkNotNullExpressionValue(bArr, "it.data");
                    SmartParcelable k3 = groupAlbumReshipSendBoxManager.k(bArr);
                    Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxCell");
                    GroupAlbumReshipSendBoxCell groupAlbumReshipSendBoxCell = (GroupAlbumReshipSendBoxCell) k3;
                    if (sendBoxMap.get(groupId) == null) {
                        sendBoxMap.put(groupId, new CopyOnWriteArrayList<>());
                    }
                    CopyOnWriteArrayList<GroupAlbumReshipSendBoxCell> copyOnWriteArrayList = sendBoxMap.get(groupId);
                    if (copyOnWriteArrayList != null) {
                        copyOnWriteArrayList.add(groupAlbumReshipSendBoxCell);
                    }
                    RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] convert GroupAlbumReshipSendBoxCell succeed,groupId:" + groupAlbumReshipSendBoxDbEntity.groupId + ",mediaId:" + groupAlbumReshipSendBoxDbEntity.mediaId);
                } catch (Exception unused) {
                    RFWLog.e("GroupAlbumReshipSendBoxManager", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] convert GroupAlbumReshipSendBoxCell error,groupId:" + groupAlbumReshipSendBoxDbEntity.groupId + ",mediaId:" + groupAlbumReshipSendBoxDbEntity.mediaId);
                }
            }
            GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager2 = f56848a;
            List<GroupAlbumReshipSendBoxCell> list = (CopyOnWriteArrayList) sendBoxMap.get(groupId);
            if (list == null) {
                list = new ArrayList<>();
            }
            groupAlbumReshipSendBoxManager2.q(groupId, groupAlbumReshipSendBoxManager2.p(list));
            block.invoke();
            return;
        }
        RFWLog.e("GroupAlbumReshipSendBoxManager", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] db size is 0");
        block.invoke();
    }

    private final void B(String mediaId, String groupId, int status) {
        CopyOnWriteArrayList<GroupAlbumReshipSendBoxCell> copyOnWriteArrayList = sendBoxMap.get(groupId);
        if (copyOnWriteArrayList != null) {
            for (GroupAlbumReshipSendBoxCell it : copyOnWriteArrayList) {
                if (Intrinsics.areEqual(mediaId, it.getUnit().getMediaId())) {
                    it.setStatus(status);
                    com.qzone.reborn.groupalbum.reship.manager.a c16 = com.qzone.reborn.groupalbum.reship.manager.a.c();
                    String mediaId2 = it.getUnit().getMediaId();
                    GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager = f56848a;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    c16.g(new GroupAlbumReshipSendBoxDbEntity(groupId, mediaId2, groupAlbumReshipSendBoxManager.y(it), System.currentTimeMillis()));
                }
            }
        }
    }

    private final QuoteToQunAlbumUnit o(GroupAblbumReshipUnit unit) {
        QuoteToQunAlbumUnit quoteToQunAlbumUnit = new QuoteToQunAlbumUnit();
        quoteToQunAlbumUnit.mediaId = unit.getMediaId();
        quoteToQunAlbumUnit.mediaMd5 = unit.getMediaMd5();
        quoteToQunAlbumUnit.mediaSize = unit.getMediaSize();
        quoteToQunAlbumUnit.mediaType = unit.getMediaType();
        quoteToQunAlbumUnit.uin = unit.getUin();
        quoteToQunAlbumUnit.dittoUin = unit.getDittoUin();
        quoteToQunAlbumUnit.sha1 = unit.getSha1();
        quoteToQunAlbumUnit.mediaName = unit.getMediaName();
        quoteToQunAlbumUnit.storeId = unit.getStoreId();
        quoteToQunAlbumUnit.width = unit.getWidth();
        quoteToQunAlbumUnit.height = unit.getHeight();
        quoteToQunAlbumUnit.duration = unit.getDuration();
        return quoteToQunAlbumUnit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<IQueueTask> p(List<GroupAlbumReshipSendBoxCell> cellList) {
        ArrayList arrayList = new ArrayList();
        for (GroupAlbumReshipSendBoxCell groupAlbumReshipSendBoxCell : cellList) {
            int i3 = 0;
            GroupAlbumUploadAlbumParams groupAlbumUploadAlbumParams = new GroupAlbumUploadAlbumParams(0L, null, null, null, null, null, null, null, 0L, i3, i3, null, null, InitSkin.DRAWABLE_COUNT, null);
            groupAlbumUploadAlbumParams.getAlbumInfo().setAlbumName(groupAlbumReshipSendBoxCell.getAlbumName());
            groupAlbumUploadAlbumParams.setGroupId(groupAlbumReshipSendBoxCell.getGroupId());
            if (groupAlbumReshipSendBoxCell.getUnit().getMediaType() == 0) {
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.mPath = groupAlbumReshipSendBoxCell.getCoverUrl();
                HashMap<String, Object> hashMap = new HashMap<>();
                imageInfo.mExtraData = hashMap;
                Intrinsics.checkNotNullExpressionValue(hashMap, "imageInfo.mExtraData");
                hashMap.put("status", Integer.valueOf(groupAlbumReshipSendBoxCell.getStatus()));
                HashMap<String, Object> hashMap2 = imageInfo.mExtraData;
                Intrinsics.checkNotNullExpressionValue(hashMap2, "imageInfo.mExtraData");
                hashMap2.put("mediaId", groupAlbumReshipSendBoxCell.getUnit().getMediaId());
                groupAlbumUploadAlbumParams.getMediaWrapperList().add(new MediaWrapper(imageInfo));
                arrayList.add(new GroupAlbumReshipAlbumPicTask(groupAlbumUploadAlbumParams));
            } else {
                ShuoshuoVideoInfo shuoshuoVideoInfo = new ShuoshuoVideoInfo();
                shuoshuoVideoInfo.mCoverUrl = groupAlbumReshipSendBoxCell.getCoverUrl();
                HashMap hashMap3 = new HashMap();
                shuoshuoVideoInfo.extraInfo = hashMap3;
                Intrinsics.checkNotNullExpressionValue(hashMap3, "videoInfo.extraInfo");
                hashMap3.put("status", Integer.valueOf(groupAlbumReshipSendBoxCell.getStatus()));
                Map<String, Object> map = shuoshuoVideoInfo.extraInfo;
                Intrinsics.checkNotNullExpressionValue(map, "videoInfo.extraInfo");
                map.put("mediaId", groupAlbumReshipSendBoxCell.getUnit().getMediaId());
                groupAlbumUploadAlbumParams.getMediaWrapperList().add(new MediaWrapper(shuoshuoVideoInfo));
                arrayList.add(new GroupAlbumReshipAlbumVideoTask(groupAlbumUploadAlbumParams));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(String groupId, final List<? extends IQueueTask> tasks) {
        final CopyOnWriteArrayList<WeakReference<b>> copyOnWriteArrayList = mReshipSendBoxListenerMap.get(groupId);
        if (copyOnWriteArrayList != null) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.groupalbum.reship.manager.f
                @Override // java.lang.Runnable
                public final void run() {
                    GroupAlbumReshipSendBoxManager.r(copyOnWriteArrayList, tasks);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(CopyOnWriteArrayList it, List tasks) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(tasks, "$tasks");
        Iterator it5 = it.iterator();
        while (it5.hasNext()) {
            b bVar = (b) ((WeakReference) it5.next()).get();
            if (bVar != null) {
                bVar.H5(tasks);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(String groupId, NTQueryQuoteToQunAlbumStatusReq it, NTQueryQuoteToQunAlbumStatusRsp nTQueryQuoteToQunAlbumStatusRsp) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(it, "$it");
        RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "queryQuoteToQunAlbumStatus rsp result:" + nTQueryQuoteToQunAlbumStatusRsp.result + ", err:" + nTQueryQuoteToQunAlbumStatusRsp.errMs + ", trace:" + nTQueryQuoteToQunAlbumStatusRsp.traceId + ", units:" + nTQueryQuoteToQunAlbumStatusRsp.statusUnits.size());
        GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager = f56848a;
        String str = it.albumId;
        Intrinsics.checkNotNullExpressionValue(str, "it.albumId");
        long j3 = it.batchId;
        ArrayList<StatusUnit> arrayList = nTQueryQuoteToQunAlbumStatusRsp.statusUnits;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.statusUnits");
        groupAlbumReshipSendBoxManager.D(groupId, str, j3, arrayList);
    }

    @JvmStatic
    private static final synchronized void z(final String groupId, final Function0<Unit> block) {
        synchronized (GroupAlbumReshipSendBoxManager.class) {
            ConcurrentHashMap<String, Boolean> concurrentHashMap = mHaveInitDbMap;
            if (concurrentHashMap.get(groupId) != null) {
                block.invoke();
            } else {
                concurrentHashMap.put(groupId, Boolean.TRUE);
                RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.groupalbum.reship.manager.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        GroupAlbumReshipSendBoxManager.A(groupId, block);
                    }
                });
            }
        }
    }

    public final void C(final String groupId, final long batchId, final List<? extends LocalMediaInfo> mediaInfoList, final List<? extends ShuoshuoVideoInfo> shuoshuoVideoInfoList, final CommonAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        Intrinsics.checkNotNullParameter(shuoshuoVideoInfoList, "shuoshuoVideoInfoList");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        z(groupId, new Function0<Unit>() { // from class: com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxManager$updateDataWithMediaInfos$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                List p16;
                String str;
                List<LocalMediaInfo> list = mediaInfoList;
                CommonAlbumInfo commonAlbumInfo = albumInfo;
                String str2 = groupId;
                long j3 = batchId;
                List<ShuoshuoVideoInfo> list2 = shuoshuoVideoInfoList;
                for (LocalMediaInfo localMediaInfo : list) {
                    GroupAlbumReshipSendBoxCell groupAlbumReshipSendBoxCell = new GroupAlbumReshipSendBoxCell();
                    QuoteToQunAlbumUnit j16 = GroupAlbumReshipSendBoxManager.f56848a.j(localMediaInfo);
                    groupAlbumReshipSendBoxCell.setUnit(new GroupAblbumReshipUnit(j16));
                    groupAlbumReshipSendBoxCell.setAlbumName(commonAlbumInfo.getName());
                    groupAlbumReshipSendBoxCell.setAlbumId(commonAlbumInfo.getAlbumId());
                    groupAlbumReshipSendBoxCell.setGroupId(str2);
                    groupAlbumReshipSendBoxCell.setBatchId(j3);
                    String str3 = "";
                    if (localMediaInfo.mMediaType == 0) {
                        String str4 = localMediaInfo.path;
                        if (str4 != null) {
                            Intrinsics.checkNotNullExpressionValue(str4, "it.path ?: \"\"");
                            str3 = str4;
                        }
                    } else {
                        while (true) {
                            str = "";
                            for (ShuoshuoVideoInfo shuoshuoVideoInfo : list2) {
                                if (Intrinsics.areEqual(shuoshuoVideoInfo.mVideoPath, localMediaInfo.path)) {
                                    str = shuoshuoVideoInfo.mCoverUrl;
                                    if (str == null) {
                                        break;
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(str, "shuoshuoVideoInfo.mCoverUrl ?: \"\"");
                                    }
                                }
                            }
                        }
                        str3 = str;
                    }
                    groupAlbumReshipSendBoxCell.setCoverUrl(str3);
                    if (!(str3.length() == 0)) {
                        if (GroupAlbumReshipSendBoxManager.sendBoxMap.get(str2) == null) {
                            GroupAlbumReshipSendBoxManager.sendBoxMap.put(str2, new CopyOnWriteArrayList());
                        }
                        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) GroupAlbumReshipSendBoxManager.sendBoxMap.get(str2);
                        if (copyOnWriteArrayList != null) {
                            copyOnWriteArrayList.add(groupAlbumReshipSendBoxCell);
                        }
                        a.c().d(new GroupAlbumReshipSendBoxDbEntity(str2, groupAlbumReshipSendBoxCell.getUnit().getMediaId(), GroupAlbumReshipSendBoxManager.f56848a.y(groupAlbumReshipSendBoxCell), System.currentTimeMillis()));
                    } else {
                        RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "updateDataWithMediaInfos, coverUrl empty. unit:" + j16);
                    }
                }
                GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager = GroupAlbumReshipSendBoxManager.f56848a;
                String str5 = groupId;
                List list3 = (CopyOnWriteArrayList) GroupAlbumReshipSendBoxManager.sendBoxMap.get(groupId);
                if (list3 == null) {
                    list3 = new ArrayList();
                }
                p16 = groupAlbumReshipSendBoxManager.p(list3);
                groupAlbumReshipSendBoxManager.q(str5, p16);
            }
        });
    }

    public final synchronized void i(String groupId, b listener) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "[addReshipListener] groupId: " + groupId + ", listener:" + listener);
        ConcurrentHashMap<String, CopyOnWriteArrayList<WeakReference<b>>> concurrentHashMap = mReshipSendBoxListenerMap;
        CopyOnWriteArrayList<WeakReference<b>> copyOnWriteArrayList = concurrentHashMap.get(groupId);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            concurrentHashMap.put(groupId, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(new WeakReference<>(listener));
    }

    public final QuoteToQunAlbumUnit j(LocalMediaInfo mediaInfo) {
        String str;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        QuoteToQunAlbumUnit quoteToQunAlbumUnit = new QuoteToQunAlbumUnit();
        if (mediaInfo.mDuration > 0) {
            quoteToQunAlbumUnit.mediaType = 1;
            quoteToQunAlbumUnit.mediaSize = mediaInfo.fileSize;
            quoteToQunAlbumUnit.width = mediaInfo.mediaWidth;
            quoteToQunAlbumUnit.height = mediaInfo.mediaHeight;
            quoteToQunAlbumUnit.sha1 = "0000000000000000000000000000000000000000";
            quoteToQunAlbumUnit.mediaName = new File(mediaInfo.path).getName();
            Serializable serializable = mediaInfo.extData.get("storeID");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type kotlin.Int");
            quoteToQunAlbumUnit.storeId = ((Integer) serializable).intValue();
            quoteToQunAlbumUnit.duration = (int) (mediaInfo.mDuration / 1000);
            Serializable serializable2 = mediaInfo.extData.get("uin");
            Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type kotlin.Long");
            quoteToQunAlbumUnit.uin = ((Long) serializable2).longValue();
            Serializable serializable3 = mediaInfo.extData.get("dittoUin");
            String str2 = serializable3 instanceof String ? (String) serializable3 : null;
            if (str2 == null) {
                str2 = "";
            }
            quoteToQunAlbumUnit.dittoUin = str2;
            Serializable serializable4 = mediaInfo.extData.get("extFileUUID");
            String str3 = serializable4 instanceof String ? (String) serializable4 : null;
            if (str3 == null) {
                str3 = "";
            }
            quoteToQunAlbumUnit.mediaId = str3;
            Serializable serializable5 = mediaInfo.extData.get("extVideoMd5");
            str = serializable5 instanceof String ? (String) serializable5 : null;
            quoteToQunAlbumUnit.mediaMd5 = str != null ? str : "";
        } else {
            quoteToQunAlbumUnit.mediaType = 0;
            quoteToQunAlbumUnit.mediaSize = mediaInfo.fileSize;
            quoteToQunAlbumUnit.width = mediaInfo.mediaWidth;
            quoteToQunAlbumUnit.height = mediaInfo.mediaHeight;
            quoteToQunAlbumUnit.sha1 = "0000000000000000000000000000000000000000";
            quoteToQunAlbumUnit.mediaName = new File(mediaInfo.path).getName();
            Serializable serializable6 = mediaInfo.extData.get("storeID");
            Intrinsics.checkNotNull(serializable6, "null cannot be cast to non-null type kotlin.Int");
            quoteToQunAlbumUnit.storeId = ((Integer) serializable6).intValue();
            quoteToQunAlbumUnit.duration = 0;
            Serializable serializable7 = mediaInfo.extData.get("uin");
            Intrinsics.checkNotNull(serializable7, "null cannot be cast to non-null type kotlin.Long");
            quoteToQunAlbumUnit.uin = ((Long) serializable7).longValue();
            Serializable serializable8 = mediaInfo.extData.get("dittoUin");
            String str4 = serializable8 instanceof String ? (String) serializable8 : null;
            if (str4 == null) {
                str4 = "";
            }
            quoteToQunAlbumUnit.dittoUin = str4;
            Serializable serializable9 = mediaInfo.extData.get("extFileUUID");
            String str5 = serializable9 instanceof String ? (String) serializable9 : null;
            if (str5 == null) {
                str5 = "";
            }
            quoteToQunAlbumUnit.mediaId = str5;
            Serializable serializable10 = mediaInfo.extData.get("extImageMd5");
            str = serializable10 instanceof String ? (String) serializable10 : null;
            quoteToQunAlbumUnit.mediaMd5 = str != null ? str : "";
        }
        return quoteToQunAlbumUnit;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x006d, code lost:
    
        if (r4 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SmartParcelable k(byte[] bytes) {
        Parcel parcel;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Parcel parcel2 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        SmartParcelable smartParcelable = null;
        try {
            try {
                parcel = Parcel.obtain();
            } catch (OutOfMemoryError e16) {
                e = e16;
                parcel = null;
            } catch (Error e17) {
                e = e17;
                parcel = null;
            } catch (Throwable th5) {
                th = th5;
                if (parcel2 != null) {
                }
                throw th;
            }
            try {
                parcel.unmarshall(bytes, 0, bytes.length);
                parcel.setDataPosition(0);
                smartParcelable = ParcelableWrapper.createDataFromParcel(parcel);
            } catch (OutOfMemoryError e18) {
                e = e18;
                RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "fromBytes BusinessFeedData memory Error " + e.getLocalizedMessage());
            } catch (Error e19) {
                e = e19;
                RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "fromBytes createFromCursor:" + e.getLocalizedMessage());
                if (parcel != null) {
                    OaidMonitor.parcelRecycle(parcel);
                }
                return smartParcelable;
            }
            OaidMonitor.parcelRecycle(parcel);
            return smartParcelable;
        } catch (Throwable th6) {
            th = th6;
            parcel2 = parcel;
            if (parcel2 != null) {
                OaidMonitor.parcelRecycle(parcel2);
            }
            throw th;
        }
    }

    public final int l(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Iterable<GroupAlbumReshipSendBoxCell> iterable = (CopyOnWriteArrayList) sendBoxMap.get(groupId);
        if (iterable == null) {
            iterable = new ArrayList();
        }
        z(groupId, new Function0<Unit>() { // from class: com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxManager$getAllReshipFailTaskSize$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        int i3 = 0;
        for (GroupAlbumReshipSendBoxCell groupAlbumReshipSendBoxCell : iterable) {
            if (groupAlbumReshipSendBoxCell.getStatus() != QuoteStatus.KQUOTESTATUSPROCESSING.ordinal() && groupAlbumReshipSendBoxCell.getStatus() != QuoteStatus.KQUOTESTATUSSUCCESS.ordinal()) {
                i3++;
            }
        }
        return i3;
    }

    public final int m(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        List list = (CopyOnWriteArrayList) sendBoxMap.get(groupId);
        if (list == null) {
            list = new ArrayList();
        }
        z(groupId, new Function0<Unit>() { // from class: com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxManager$getAllReshipTaskSize$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        return list.size();
    }

    public final List<IQueueTask> n(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        List<GroupAlbumReshipSendBoxCell> list = (CopyOnWriteArrayList) sendBoxMap.get(groupId);
        if (list == null) {
            list = new ArrayList<>();
        }
        List<IQueueTask> p16 = p(list);
        z(groupId, new Function0<Unit>() { // from class: com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxManager$getAllSendBoxTaskList$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        return p16;
    }

    public final void u(String groupId, String mediaId, boolean needNotifyUI) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        CopyOnWriteArrayList<GroupAlbumReshipSendBoxCell> copyOnWriteArrayList = sendBoxMap.get(groupId);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        for (GroupAlbumReshipSendBoxCell groupAlbumReshipSendBoxCell : copyOnWriteArrayList) {
            if (Intrinsics.areEqual(groupAlbumReshipSendBoxCell.getUnit().getMediaId(), mediaId)) {
                RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "didRemove cell:" + groupAlbumReshipSendBoxCell.getUnit().getMediaId());
                CopyOnWriteArrayList<GroupAlbumReshipSendBoxCell> copyOnWriteArrayList2 = sendBoxMap.get(groupId);
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.remove(groupAlbumReshipSendBoxCell);
                }
                com.qzone.reborn.groupalbum.reship.manager.a.c().a(groupId, mediaId);
                if (needNotifyUI) {
                    GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager = f56848a;
                    List<GroupAlbumReshipSendBoxCell> list = (CopyOnWriteArrayList) sendBoxMap.get(groupId);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    groupAlbumReshipSendBoxManager.q(groupId, groupAlbumReshipSendBoxManager.p(list));
                    return;
                }
                return;
            }
        }
    }

    public final synchronized void v(String groupId, b listener) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "[removeReshipListener] groupId: " + groupId + ", listener:" + listener);
        ConcurrentHashMap<String, CopyOnWriteArrayList<WeakReference<b>>> concurrentHashMap = mReshipSendBoxListenerMap;
        CopyOnWriteArrayList<WeakReference<b>> copyOnWriteArrayList = concurrentHashMap.get(groupId);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(new WeakReference(listener));
        if (copyOnWriteArrayList.isEmpty()) {
            concurrentHashMap.remove(groupId);
        }
    }

    public final void w(final String groupId) {
        ArrayList<QuoteToQunAlbumUnit> arrayList;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "requestUpdateUnitIfNeeded req:" + groupId);
        CopyOnWriteArrayList<GroupAlbumReshipSendBoxCell> copyOnWriteArrayList = sendBoxMap.get(groupId);
        if (copyOnWriteArrayList == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        RequestTimelineInfo requestTimelineInfo = new RequestTimelineInfo();
        for (GroupAlbumReshipSendBoxCell groupAlbumReshipSendBoxCell : copyOnWriteArrayList) {
            if (concurrentHashMap.get(Long.valueOf(groupAlbumReshipSendBoxCell.getBatchId())) == null) {
                concurrentHashMap.put(Long.valueOf(groupAlbumReshipSendBoxCell.getBatchId()), new NTQueryQuoteToQunAlbumStatusReq(0, requestTimelineInfo, groupId, groupAlbumReshipSendBoxCell.getAlbumId(), groupAlbumReshipSendBoxCell.getBatchId(), new ArrayList()));
            }
            NTQueryQuoteToQunAlbumStatusReq nTQueryQuoteToQunAlbumStatusReq = (NTQueryQuoteToQunAlbumStatusReq) concurrentHashMap.get(Long.valueOf(groupAlbumReshipSendBoxCell.getBatchId()));
            if (nTQueryQuoteToQunAlbumStatusReq != null && (arrayList = nTQueryQuoteToQunAlbumStatusReq.units) != null) {
                arrayList.add(f56848a.o(groupAlbumReshipSendBoxCell.getUnit()));
            }
        }
        g b16 = r.b();
        Collection<NTQueryQuoteToQunAlbumStatusReq> values = concurrentHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "map.values");
        for (final NTQueryQuoteToQunAlbumStatusReq nTQueryQuoteToQunAlbumStatusReq2 : values) {
            if (b16 != null) {
                b16.queryQuoteToQunAlbumStatus(nTQueryQuoteToQunAlbumStatusReq2, new IAlbumServiceQueryQuoteToQunAlbumStatusCallback() { // from class: com.qzone.reborn.groupalbum.reship.manager.d
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceQueryQuoteToQunAlbumStatusCallback
                    public final void onQueryQuoteToQunAlbumStatus(NTQueryQuoteToQunAlbumStatusRsp nTQueryQuoteToQunAlbumStatusRsp) {
                        GroupAlbumReshipSendBoxManager.x(groupId, nTQueryQuoteToQunAlbumStatusReq2, nTQueryQuoteToQunAlbumStatusRsp);
                    }
                });
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
    
        if (r2 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] y(SmartParcelable struct) {
        Parcel parcel;
        Intrinsics.checkNotNullParameter(struct, "struct");
        byte[] bArr = null;
        try {
            parcel = Parcel.obtain();
        } catch (Throwable th5) {
            th = th5;
            parcel = null;
        }
        try {
            parcel.setDataPosition(0);
            ParcelableWrapper.writeDataToParcel(parcel, 0, struct);
            bArr = parcel.marshall();
        } catch (Throwable th6) {
            th = th6;
            try {
                RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "writeTo BusinessFeedData exception. " + th.getLocalizedMessage());
            } catch (Throwable th7) {
                if (parcel != null) {
                    OaidMonitor.parcelRecycle(parcel);
                }
                throw th7;
            }
        }
        OaidMonitor.parcelRecycle(parcel);
        return bArr;
    }

    public final void s(final String groupId, final String albumId, final long batchId, final String clientKey, final ArrayList<QuoteToQunAlbumUnit> units, final int seq, final int retryCount, final long delay) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        Intrinsics.checkNotNullParameter(units, "units");
        RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "queryQuoteStatusAndUpdateFeedIfNeeded. req. groupId:" + groupId + ", albumId:" + albumId + ", batchId:" + batchId + ", seq:" + seq + ", retryCount:" + retryCount + ", delay:" + delay);
        NTQueryQuoteToQunAlbumStatusReq nTQueryQuoteToQunAlbumStatusReq = new NTQueryQuoteToQunAlbumStatusReq(seq, new RequestTimelineInfo(), groupId, albumId, batchId, units);
        g b16 = r.b();
        if (b16 != null) {
            b16.queryQuoteToQunAlbumStatus(nTQueryQuoteToQunAlbumStatusReq, new IAlbumServiceQueryQuoteToQunAlbumStatusCallback() { // from class: com.qzone.reborn.groupalbum.reship.manager.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceQueryQuoteToQunAlbumStatusCallback
                public final void onQueryQuoteToQunAlbumStatus(NTQueryQuoteToQunAlbumStatusRsp nTQueryQuoteToQunAlbumStatusRsp) {
                    GroupAlbumReshipSendBoxManager.t(groupId, albumId, batchId, seq, retryCount, delay, clientKey, units, nTQueryQuoteToQunAlbumStatusRsp);
                }
            });
        }
    }

    public final void D(String groupId, String albumId, long batchId, ArrayList<StatusUnit> statusUnits) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(statusUnits, "statusUnits");
        int i3 = 1;
        boolean z16 = true;
        for (StatusUnit statusUnit : statusUnits) {
            int i16 = RFWLog.USR;
            Object[] objArr = new Object[i3];
            objArr[0] = "queryQuoteToQunAlbumStatus statusUnit:" + statusUnit.status + ", err:" + statusUnit.errMsg + ", mediaId:" + statusUnit.mediaId + ", continue:" + statusUnit.isNeedContinueQuery;
            RFWLog.d("GroupAlbumReshipSendBoxManager", i16, objArr);
            if (statusUnit.status == QuoteStatus.KQUOTESTATUSSUCCESS.ordinal()) {
                GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager = f56848a;
                String str = statusUnit.mediaId;
                Intrinsics.checkNotNullExpressionValue(str, "statusUnit.mediaId");
                groupAlbumReshipSendBoxManager.u(groupId, str, false);
            } else {
                if (statusUnit.status != QuoteStatus.KQUOTESTATUSPROCESSING.ordinal()) {
                    GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager2 = f56848a;
                    String str2 = statusUnit.mediaId;
                    Intrinsics.checkNotNullExpressionValue(str2, "statusUnit.mediaId");
                    groupAlbumReshipSendBoxManager2.B(str2, groupId, QuoteStatus.KQUOTESTATUSFAIL.ordinal());
                }
                z16 = false;
            }
            i3 = 1;
        }
        if (z16 && statusUnits.size() > 0) {
            RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "updateWhenStatusChange all succ, groupId:" + groupId + ", albumId:" + albumId + ", batchId:" + batchId);
            SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumUploadAlbumEvent(groupId, albumId, batchId, 0, null, 16, null));
        }
        List<GroupAlbumReshipSendBoxCell> list = (CopyOnWriteArrayList) sendBoxMap.get(groupId);
        if (list == null) {
            list = new ArrayList<>();
        }
        q(groupId, p(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final String groupId, final String albumId, final long j3, final int i3, final int i16, final long j16, final String clientKey, final ArrayList units, NTQueryQuoteToQunAlbumStatusRsp nTQueryQuoteToQunAlbumStatusRsp) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(albumId, "$albumId");
        Intrinsics.checkNotNullParameter(clientKey, "$clientKey");
        Intrinsics.checkNotNullParameter(units, "$units");
        int i17 = RFWLog.USR;
        int i18 = nTQueryQuoteToQunAlbumStatusRsp.seq;
        int i19 = nTQueryQuoteToQunAlbumStatusRsp.result;
        String str2 = nTQueryQuoteToQunAlbumStatusRsp.errMs;
        String str3 = nTQueryQuoteToQunAlbumStatusRsp.traceId;
        RequestTimelineInfo requestTimelineInfo = nTQueryQuoteToQunAlbumStatusRsp.requestTimeLine;
        RFWLog.d("GroupAlbumReshipSendBoxManager", i17, "queryQuoteStatusAndUpdateFeedIfNeeded. rsp. groupId:" + groupId + ", albumId:" + albumId + ", batchId:" + j3 + ", seq:" + i18 + ", result:" + i19 + ", errMs:" + str2 + ", traceid:" + str3 + ", requestTimeLine requestSendTime:" + requestTimelineInfo.requestSendTime + ", requestTimeLine responseRecvTime:" + requestTimelineInfo.responseRecvTime + ", statusUnits size:" + nTQueryQuoteToQunAlbumStatusRsp.statusUnits.size());
        Iterator<StatusUnit> it = nTQueryQuoteToQunAlbumStatusRsp.statusUnits.iterator();
        boolean z17 = false;
        while (true) {
            if (!it.hasNext()) {
                str = "response.statusUnits";
                z16 = false;
                break;
            }
            StatusUnit next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "response.statusUnits");
            StatusUnit statusUnit = next;
            Iterator<StatusUnit> it5 = it;
            str = "response.statusUnits";
            RFWLog.d("GroupAIOReshipAlbumViewModel", RFWLog.USR, "queryQuoteToQunAlbumStatus. rsp statusUnits. mediaId:" + statusUnit.mediaId + ", status:" + statusUnit.status + ", errMsg:" + statusUnit.errMsg + ", isNeedContinueQuery:" + statusUnit.isNeedContinueQuery + " ");
            if (statusUnit.status == QuoteStatus.KQUOTESTATUSPROCESSING.ordinal()) {
                z16 = true;
                break;
            } else if (statusUnit.status == QuoteStatus.KQUOTESTATUSSUCCESS.ordinal()) {
                it = it5;
                z17 = true;
            } else {
                it = it5;
            }
        }
        if (z16 && i3 < i16) {
            new BaseTimer().schedule(new TimerTask() { // from class: com.qzone.reborn.groupalbum.reship.manager.GroupAlbumReshipSendBoxManager$queryQuoteStatusAndUpdateFeedIfNeeded$1$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    GroupAlbumReshipSendBoxManager.f56848a.s(groupId, albumId, j3, clientKey, units, i3 + 1, i16, j16);
                }
            }, j16);
            return;
        }
        RFWLog.d("GroupAIOReshipAlbumViewModel", RFWLog.USR, "queryQuoteStatusAndUpdateFeedIfNeeded. end. groupId:" + groupId + ", albumId:" + albumId + ", batchId:" + j3 + ", seq:" + i3 + ", hasProcessing:" + z16 + ", hasSuccess:" + z17 + ".");
        if (z17) {
            GroupAlbumReshipSendBoxManager groupAlbumReshipSendBoxManager = f56848a;
            ArrayList<StatusUnit> arrayList = nTQueryQuoteToQunAlbumStatusRsp.statusUnits;
            Intrinsics.checkNotNullExpressionValue(arrayList, str);
            groupAlbumReshipSendBoxManager.D(groupId, albumId, j3, arrayList);
            SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumUploadAlbumEvent(groupId, albumId, j3, 0, clientKey));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/qzone/reborn/groupalbum/reship/manager/GroupAlbumReshipSendBoxManager$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements IAccountCallback {
        a() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime newRuntime) {
            RFWLog.d("GroupAlbumReshipSendBoxManager", RFWLog.USR, "[onAccountChanged]");
            GroupAlbumReshipSendBoxManager.mHaveInitDbMap.clear();
            GroupAlbumReshipSendBoxManager.sendBoxMap.clear();
            com.qzone.reborn.groupalbum.reship.manager.a.c().e();
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime newRuntime) {
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason reason) {
        }
    }
}
