package com.qzone.reborn.albumx.qzone.local;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qzone.common.business.result.QZoneResult;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWMediaInfo;
import com.tencent.biz.richframework.localupload.recommend.delegate.IRFWRecommendPoiDelegate;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001a\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\fR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/local/q;", "", "", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWMediaInfo;", "mediaInfos", "Ljava/util/ArrayList;", "Lcooperation/qzone/model/GpsInfo4LocalImage;", "b", "Lcom/qzone/common/business/result/QZoneResult;", "result", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "e", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWRecommendPoiDelegate$PoiCallBack;", "callBack", "", "d", "", "Landroid/os/Handler;", "Ljava/util/List;", "c", "()Ljava/util/List;", "setMMsgHandlers", "(Ljava/util/List;)V", "mMsgHandlers", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f52675a = new q();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static List<Handler> mMsgHandlers = new CopyOnWriteArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/albumx/qzone/local/q$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IRFWRecommendPoiDelegate.PoiCallBack f52677a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<RFWMediaInfo> f52678b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(IRFWRecommendPoiDelegate.PoiCallBack poiCallBack, List<RFWMediaInfo> list, Looper looper) {
            super(looper);
            this.f52677a = poiCallBack;
            this.f52678b = list;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 513) {
                q qVar = q.f52675a;
                qVar.c().remove(this);
                QZoneResult unpack = QZoneResult.unpack(msg2);
                if (unpack != null && unpack.getSucceed()) {
                    ArrayList e16 = qVar.e(unpack);
                    if (e16 == null) {
                        this.f52677a.onPoiError(this.f52678b);
                        QZLog.e("MediaRecommend_QZoneUploadRecommendDirector", "process POI info poiInfos is null");
                        return;
                    }
                    RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "POI info response size:" + e16.size());
                    if (e16.size() == this.f52678b.size()) {
                        List<RFWMediaInfo> list = this.f52678b;
                        int i3 = 0;
                        for (Object obj : e16) {
                            int i16 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) obj;
                            RFWMediaInfo rFWMediaInfo = list.get(i3);
                            String str = null;
                            String str2 = poiInfo != null ? poiInfo.city : null;
                            if (str2 == null) {
                                str2 = "";
                            } else {
                                Intrinsics.checkNotNullExpressionValue(str2, "poiInfo?.city ?: \"\"");
                            }
                            rFWMediaInfo.fillPoiInfo(str2);
                            int i17 = RFWLog.DEV;
                            Object[] objArr = new Object[1];
                            if (poiInfo != null) {
                                str = poiInfo.city;
                            }
                            objArr[0] = "POI info " + str;
                            RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", i17, objArr);
                            i3 = i16;
                        }
                        this.f52677a.onPoiResult(this.f52678b);
                        return;
                    }
                    RFWLog.d("MediaRecommend_QZoneUploadRecommendDirector", RFWLog.USR, "poi size:" + e16.size() + " is not equals media size " + this.f52678b.size());
                    this.f52677a.onPoiError(this.f52678b);
                    return;
                }
                QZLog.e("MediaRecommend_QZoneUploadRecommendDirector", "process POI info result error " + unpack);
                this.f52677a.onPoiError(this.f52678b);
            }
        }
    }

    q() {
    }

    private final ArrayList<GpsInfo4LocalImage> b(List<RFWMediaInfo> mediaInfos) {
        ArrayList<GpsInfo4LocalImage> arrayList = new ArrayList<>();
        for (RFWMediaInfo rFWMediaInfo : mediaInfos) {
            GpsInfo4LocalImage gpsInfo4LocalImage = new GpsInfo4LocalImage();
            gpsInfo4LocalImage.latitude = rFWMediaInfo.getMLatitude();
            gpsInfo4LocalImage.longtitude = rFWMediaInfo.getMLongitude();
            gpsInfo4LocalImage.gpsType = 1;
            arrayList.add(gpsInfo4LocalImage);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<LbsDataV2.PoiInfo> e(QZoneResult result) {
        Object data = result.getData();
        try {
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type java.util.ArrayList<cooperation.qzone.LbsDataV2.PoiInfo?>");
            return (ArrayList) data;
        } catch (Throwable th5) {
            QZLog.e("MediaRecommend_QZoneUploadRecommendDirector", "process POI info response error!", th5);
            return null;
        }
    }

    public final List<Handler> c() {
        return mMsgHandlers;
    }

    public final void d(List<RFWMediaInfo> mediaInfos, IRFWRecommendPoiDelegate.PoiCallBack callBack) {
        Intrinsics.checkNotNullParameter(mediaInfos, "mediaInfos");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        a aVar = new a(callBack, mediaInfos, Looper.getMainLooper());
        com.qzone.business.lbsv2.business.e.c(QzoneLbsConstant.BUSINESS_ID_QZONE_PHOTO_RECOMMEND).k(aVar, 513, b(mediaInfos), 100115);
        mMsgHandlers.add(aVar);
    }
}
