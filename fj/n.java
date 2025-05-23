package fj;

import android.os.Parcel;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumDBParams;
import com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumParams;
import com.qzone.publish.business.publishqueue.common.CommonPublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.groupalbum.utils.GroupAlbumFakeFeedDbEntity;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellCommon;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bF\u0010GJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\bJ\u0016\u0010 \u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eJ\u0016\u0010!\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eJ\u001e\u0010#\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\fJ\u0018\u0010$\u001a\u00020\b2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010J\u0016\u0010%\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002J\u0016\u0010'\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0012J\u0010\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010*\u001a\u00020)J\u0010\u0010.\u001a\u0004\u0018\u00010)2\u0006\u0010-\u001a\u00020+R)\u00104\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R#\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0/8\u0006\u00a2\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R)\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00040/8\u0006\u00a2\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103R\"\u0010A\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006H"}, d2 = {"Lfj/n;", "", "", "groupId", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "u", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "", "y", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "feed", "Lcom/tencent/qqnt/kernel/nativeinterface/StCommonExt;", "extInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "feedClientKey", "", "realFeedList", "", HippyTKDListViewAdapter.X, "clientKey", BdhLogUtil.LogTag.Tag_Conn, "", "t", "Lsm/i;", "listener", "l", "E", "r", "H", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadAlbumParams;", "params", tl.h.F, "j", "ext", "i", DomainData.DOMAIN_NAME, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "businessFeedData", "J", "p", "Lcom/tencent/component/app/common/SmartParcelable;", "struct", "", "G", "bytes", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "v", "()Ljava/util/concurrent/ConcurrentHashMap;", "mFakeFeedMap", "c", "w", "mFakeStFeedMap", "d", "getMPublishListenerMap", "mPublishListenerMap", "e", "Z", "getMHaveInitDbHistory", "()Z", UserInfo.SEX_FEMALE, "(Z)V", "mHaveInitDbHistory", "Lmqq/app/IAccountCallback;", "f", "Lmqq/app/IAccountCallback;", "accountCallback", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f399459a = new n();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<BusinessFeedData>> mFakeFeedMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, StFeed> mFakeStFeedMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<sm.i>> mPublishListenerMap = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean mHaveInitDbHistory;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final IAccountCallback accountCallback;

    static {
        a aVar = new a();
        accountCallback = aVar;
        MobileQQ.sMobileQQ.registerAccountCallback(aVar);
    }

    n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(CopyOnWriteArrayList it, String clientKey) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(clientKey, "$clientKey");
        Iterator it5 = it.iterator();
        while (it5.hasNext()) {
            ((sm.i) it5.next()).v1(clientKey);
        }
    }

    private final synchronized void C(final String groupId, final String clientKey) {
        CopyOnWriteArrayList<BusinessFeedData> copyOnWriteArrayList = mFakeFeedMap.get(groupId);
        if (copyOnWriteArrayList != null) {
            for (BusinessFeedData businessFeedData : copyOnWriteArrayList) {
                CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
                if (Intrinsics.areEqual(feedCommInfo != null ? feedCommInfo.clientkey : null, clientKey)) {
                    RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[removeFromFakeFeedMap] groupId: " + groupId + ", clientKey:" + clientKey);
                    copyOnWriteArrayList.remove(businessFeedData);
                }
            }
        }
        if (copyOnWriteArrayList != null) {
            RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[removeFromFakeFeedMap] groupId: " + groupId + " ,current data size:" + copyOnWriteArrayList.size());
        }
        mFakeStFeedMap.remove(clientKey);
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: fj.h
            @Override // java.lang.Runnable
            public final void run() {
                n.D(groupId, clientKey);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(String groupId, String clientKey) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(clientKey, "$clientKey");
        f.c().a(groupId, clientKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I() {
        List<GroupAlbumFakeFeedDbEntity> f16 = f.c().f();
        if (f16 != null && !f16.isEmpty()) {
            for (GroupAlbumFakeFeedDbEntity groupAlbumFakeFeedDbEntity : f16) {
                try {
                    n nVar = f399459a;
                    byte[] bArr = groupAlbumFakeFeedDbEntity.data;
                    Intrinsics.checkNotNullExpressionValue(bArr, "it.data");
                    SmartParcelable q16 = nVar.q(bArr);
                    Intrinsics.checkNotNull(q16, "null cannot be cast to non-null type com.qzone.publish.business.model.groupalbum.GroupAlbumUploadAlbumDBParams");
                    GroupAlbumUploadAlbumParams groupAlbumUploadAlbumParams = new GroupAlbumUploadAlbumParams((GroupAlbumUploadAlbumDBParams) q16);
                    yh.a aVar = yh.a.f450323a;
                    StFeed stFeed$default = GroupAlbumUploadAlbumParams.toStFeed$default(groupAlbumUploadAlbumParams, aVar.b(groupAlbumUploadAlbumParams.getMediaWrapperList()), 0, 2, null);
                    BusinessFeedData m3 = nVar.m(stFeed$default, aVar.a());
                    String str = groupAlbumFakeFeedDbEntity.groupId;
                    Intrinsics.checkNotNullExpressionValue(str, "it.groupId");
                    CopyOnWriteArrayList<BusinessFeedData> u16 = nVar.u(str);
                    boolean z16 = true;
                    for (BusinessFeedData businessFeedData : u16) {
                        if (Intrinsics.areEqual(businessFeedData.cellFeedCommInfo.clientkey, m3.cellFeedCommInfo.clientkey)) {
                            RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] feed has in cache key:" + businessFeedData.cellFeedCommInfo.clientkey);
                            z16 = false;
                        }
                    }
                    if (z16) {
                        u16.add(0, m3);
                        ConcurrentHashMap<String, StFeed> concurrentHashMap = mFakeStFeedMap;
                        String str2 = stFeed$default.cellCommon.clientKey;
                        Intrinsics.checkNotNullExpressionValue(str2, "stFeed.cellCommon.clientKey");
                        concurrentHashMap.put(str2, stFeed$default);
                        n nVar2 = f399459a;
                        String str3 = groupAlbumFakeFeedDbEntity.groupId;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.groupId");
                        nVar2.y(str3, m3);
                        RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] convert businessData succeed,groupId:" + groupAlbumFakeFeedDbEntity.groupId + ",clientKey:" + groupAlbumFakeFeedDbEntity.clintKey + "\uff0cpublishTime\uff1a" + groupAlbumFakeFeedDbEntity.insertTime);
                    }
                } catch (Exception unused) {
                    RFWLog.e("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] convert businessData error,groupId:" + groupAlbumFakeFeedDbEntity.groupId + ",clientKey:" + groupAlbumFakeFeedDbEntity.clintKey);
                }
            }
            o(f399459a, null, 1, null);
            return;
        }
        RFWLog.e("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] db size is 0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void K(CopyOnWriteArrayList it, Ref.ObjectRef feedData) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(feedData, "$feedData");
        Iterator it5 = it.iterator();
        while (it5.hasNext()) {
            ((sm.i) it5.next()).I4((BusinessFeedData) feedData.element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GroupAlbumUploadAlbumParams params, String groupId) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        byte[] G = f399459a.G(new GroupAlbumUploadAlbumDBParams(params));
        if (G == null) {
            return;
        }
        GroupAlbumFakeFeedDbEntity groupAlbumFakeFeedDbEntity = new GroupAlbumFakeFeedDbEntity(groupId, params.getClientKey(), G, null);
        groupAlbumFakeFeedDbEntity.insertTime = System.currentTimeMillis();
        f.c().d(groupAlbumFakeFeedDbEntity);
    }

    private final BusinessFeedData m(StFeed feed, StCommonExt extInfo) {
        BusinessFeedData g16 = yh.a.f450323a.g(feed, extInfo);
        CellLocalInfo localInfo = g16.getLocalInfo();
        if (localInfo != null) {
            int i3 = RFWLog.USR;
            StFeedCellCommon stFeedCellCommon = feed.cellCommon;
            RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", i3, "[buildBussFeedData] clientKey: " + stFeedCellCommon.clientKey + ", feedId:" + stFeedCellCommon.feedId + ",set fake flag");
            localInfo.setFake();
        } else {
            int i16 = RFWLog.USR;
            StFeedCellCommon stFeedCellCommon2 = feed.cellCommon;
            RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", i16, "[buildBussFeedData] clientKey: " + stFeedCellCommon2.clientKey + ", feedId:" + stFeedCellCommon2.feedId + ",set fake flag error");
        }
        g16.setMixFake(1);
        CellPictureInfo pictureInfo = g16.getPictureInfo();
        if (pictureInfo != null) {
            pictureInfo.setVideoPicMix(true);
        }
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s(BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        return Intrinsics.compare(businessFeedData.cellFeedCommInfo.time, businessFeedData2.cellFeedCommInfo.time);
    }

    private final long t() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_INTIMATE_FAKE_FEED_TIME_OUT_MILLIS, 3600000L);
    }

    private final synchronized CopyOnWriteArrayList<BusinessFeedData> u(String groupId) {
        CopyOnWriteArrayList<BusinessFeedData> copyOnWriteArrayList;
        ConcurrentHashMap<String, CopyOnWriteArrayList<BusinessFeedData>> concurrentHashMap = mFakeFeedMap;
        copyOnWriteArrayList = concurrentHashMap.get(groupId);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            concurrentHashMap.put(groupId, copyOnWriteArrayList);
        }
        return copyOnWriteArrayList;
    }

    private final void y(String groupId, final BusinessFeedData businessData) {
        final CopyOnWriteArrayList<sm.i> copyOnWriteArrayList = mPublishListenerMap.get(groupId);
        if (copyOnWriteArrayList != null) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: fj.l
                @Override // java.lang.Runnable
                public final void run() {
                    n.z(copyOnWriteArrayList, businessData);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(CopyOnWriteArrayList it, BusinessFeedData businessData) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(businessData, "$businessData");
        Iterator it5 = it.iterator();
        while (it5.hasNext()) {
            ((sm.i) it5.next()).i7(businessData);
        }
    }

    public final synchronized void A(String groupId, final String clientKey) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(clientKey, "clientKey");
        RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[removeFeed] groupId: " + groupId + ", clientKey:" + clientKey);
        if (!p()) {
            RFWLog.e("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[removeFeed] enableFakeFeed return false");
        }
        C(groupId, clientKey);
        final CopyOnWriteArrayList<sm.i> copyOnWriteArrayList = mPublishListenerMap.get(groupId);
        if (copyOnWriteArrayList != null) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: fj.g
                @Override // java.lang.Runnable
                public final void run() {
                    n.B(copyOnWriteArrayList, clientKey);
                }
            });
        }
        eo.d.b(new WinkPublishQualityReportData.Builder().eventId(eo.d.f396887g).ext1(clientKey).ext4(eo.d.f396891k).getReportData());
    }

    public final synchronized void E(String groupId, sm.i listener) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[removePublishListener] groupId: " + groupId + ", listener:" + listener);
        ConcurrentHashMap<String, CopyOnWriteArrayList<sm.i>> concurrentHashMap = mPublishListenerMap;
        CopyOnWriteArrayList<sm.i> copyOnWriteArrayList = concurrentHashMap.get(groupId);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(listener);
        if (copyOnWriteArrayList.isEmpty()) {
            concurrentHashMap.remove(groupId);
        }
    }

    public final void F(boolean z16) {
        mHaveInitDbHistory = z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (r1 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] G(SmartParcelable struct) {
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
                com.qzone.proxy.feedcomponent.b.d("Feed", "writeTo BusinessFeedData exception.", th);
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

    public final synchronized void H() {
        if (mHaveInitDbHistory) {
            return;
        }
        mHaveInitDbHistory = true;
        if (!p()) {
            RFWLog.e("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[tryLoadDbHistoryIfNecessary] enableFakeFeed return false");
        }
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: fj.k
            @Override // java.lang.Runnable
            public final void run() {
                n.I();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, com.qzone.proxy.feedcomponent.model.BusinessFeedData] */
    public final synchronized void J(String groupId, BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(businessFeedData, "businessFeedData");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = businessFeedData;
        String str = businessFeedData.cellFeedCommInfo.feedsid;
        String clientKey = businessFeedData.cellFeedCommInfo.clientkey;
        RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[updateFeed] groupId: " + groupId + ", feedId:" + str + ",clientKey" + clientKey);
        if (!p()) {
            RFWLog.e("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[updateFeed] enableFakeFeed return false");
            return;
        }
        StFeed stFeed = mFakeStFeedMap.get(clientKey);
        if (stFeed != null) {
            RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[updateFeed] convert clint feed succeed");
            objectRef.element = yh.b.g(stFeed, (BusinessFeedData) objectRef.element);
        }
        Intrinsics.checkNotNullExpressionValue(clientKey, "clientKey");
        C(groupId, clientKey);
        final CopyOnWriteArrayList<sm.i> copyOnWriteArrayList = mPublishListenerMap.get(groupId);
        if (copyOnWriteArrayList != null) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: fj.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.K(copyOnWriteArrayList, objectRef);
                }
            });
        }
    }

    public final synchronized void h(String groupId, GroupAlbumUploadAlbumParams params) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!p()) {
            RFWLog.e("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[addFeed] enableFakeFeed return false");
        }
        yh.a aVar = yh.a.f450323a;
        i(groupId, GroupAlbumUploadAlbumParams.toStFeed$default(params, aVar.b(params.getMediaWrapperList()), 0, 2, null), aVar.a());
        j(groupId, params);
    }

    public final synchronized void i(String groupId, StFeed feed, StCommonExt ext) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(ext, "ext");
        if (!p()) {
            RFWLog.e("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[addFeed] enableFakeFeed return false");
        }
        BusinessFeedData m3 = m(feed, ext);
        CopyOnWriteArrayList<BusinessFeedData> u16 = u(groupId);
        u16.add(0, m3);
        RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[addFeed] groupId: " + groupId + ", feedId:" + feed.cellCommon.feedId + ",fake feed size:" + u16.size() + ",clientKey:" + feed.cellCommon.clientKey);
        y(groupId, m3);
    }

    public final void j(final String groupId, final GroupAlbumUploadAlbumParams params) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(params, "params");
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: fj.i
            @Override // java.lang.Runnable
            public final void run() {
                n.k(GroupAlbumUploadAlbumParams.this, groupId);
            }
        });
    }

    public final synchronized void l(String groupId, sm.i listener) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[addPublishListener] groupId: " + groupId + ", listener:" + listener);
        ConcurrentHashMap<String, CopyOnWriteArrayList<sm.i>> concurrentHashMap = mPublishListenerMap;
        CopyOnWriteArrayList<sm.i> copyOnWriteArrayList = concurrentHashMap.get(groupId);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            concurrentHashMap.put(groupId, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(listener);
    }

    public final synchronized void n(List<? extends BusinessFeedData> realFeedList) {
        if (!p()) {
            RFWLog.e("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[deleteInvalidFakeFeed] enableFakeFeed return false");
        }
        for (Map.Entry<String, CopyOnWriteArrayList<BusinessFeedData>> entry : mFakeFeedMap.entrySet()) {
            String key = entry.getKey();
            CopyOnWriteArrayList<BusinessFeedData> value = entry.getValue();
            CommonPublishQueue c16 = z8.c.f452134a.c(key);
            for (BusinessFeedData businessFeedData : value) {
                CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
                Object obj = null;
                String str = feedCommInfo != null ? feedCommInfo.clientkey : null;
                if (str == null) {
                    RFWLog.e("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[deleteInvalidFakeFeed] clientKey is null,groupId is:" + key);
                } else {
                    n nVar = f399459a;
                    if (nVar.x(str, realFeedList)) {
                        RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[deleteInvalidFakeFeed] do delete by real feed,groupId:" + key + ",clientKey:" + str);
                        nVar.A(key, str);
                    } else {
                        Iterator<T> it = c16.a().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object next = it.next();
                            if (Intrinsics.areEqual(((IQueueTask) next).getClientKey(), str)) {
                                obj = next;
                                break;
                            }
                        }
                        IQueueTask iQueueTask = (IQueueTask) obj;
                        CellFeedCommInfo feedCommInfo2 = businessFeedData.getFeedCommInfo();
                        long j3 = feedCommInfo2 != null ? feedCommInfo2.time : 0L;
                        if (iQueueTask == null) {
                            long abs = Math.abs(System.currentTimeMillis() - j3);
                            n nVar2 = f399459a;
                            if (abs > nVar2.t()) {
                                RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[deleteInvalidFakeFeed] do delete by timeout,groupId:" + key + ",clientKey:" + str + ",publishTime:" + j3);
                                nVar2.A(key, str);
                            }
                        }
                    }
                }
            }
        }
    }

    public final boolean p() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_INTIMATE_ENABLE_FAKE_FEED, 1) == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
    
        if (r2 == null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SmartParcelable q(byte[] bytes) {
        Parcel parcel;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Parcel parcel2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        SmartParcelable smartParcelable = null;
        try {
            try {
                parcel = Parcel.obtain();
            } catch (OutOfMemoryError unused) {
                parcel = null;
            } catch (Error e16) {
                e = e16;
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
            } catch (OutOfMemoryError unused2) {
                com.qzone.proxy.feedcomponent.b.i("upload2-QZoneFakeFeedManagerForStruct", "fromBytes BusinessFeedData memory Error");
            } catch (Error e17) {
                e = e17;
                com.qzone.proxy.feedcomponent.b.c("upload2-QZoneFakeFeedManagerForStruct", "fromBytes createFromCursor:" + e);
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

    public final synchronized CopyOnWriteArrayList<BusinessFeedData> r(String groupId) {
        CopyOnWriteArrayList<BusinessFeedData> copyOnWriteArrayList;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        copyOnWriteArrayList = new CopyOnWriteArrayList<>(u(groupId));
        H();
        CollectionsKt___CollectionsKt.sortedWith(copyOnWriteArrayList, new Comparator() { // from class: fj.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int s16;
                s16 = n.s((BusinessFeedData) obj, (BusinessFeedData) obj2);
                return s16;
            }
        });
        return copyOnWriteArrayList;
    }

    public final ConcurrentHashMap<String, CopyOnWriteArrayList<BusinessFeedData>> v() {
        return mFakeFeedMap;
    }

    public final ConcurrentHashMap<String, StFeed> w() {
        return mFakeStFeedMap;
    }

    private final boolean x(String feedClientKey, List<? extends BusinessFeedData> realFeedList) {
        boolean z16;
        if (realFeedList == null) {
            return false;
        }
        List<? extends BusinessFeedData> list = realFeedList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                CellFeedCommInfo feedCommInfo = ((BusinessFeedData) it.next()).getFeedCommInfo();
                if (Intrinsics.areEqual(feedCommInfo != null ? feedCommInfo.clientkey : null, feedClientKey)) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void o(n nVar, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = null;
        }
        nVar.n(list);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"fj/n$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements IAccountCallback {
        a() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime newRuntime) {
            RFWLog.d("upload2-QZoneFakeFeedManagerForStruct", RFWLog.USR, "[onAccountChanged]");
            n nVar = n.f399459a;
            nVar.v().clear();
            nVar.w().clear();
            nVar.F(false);
            f.c().e();
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime newRuntime) {
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason reason) {
        }
    }
}
