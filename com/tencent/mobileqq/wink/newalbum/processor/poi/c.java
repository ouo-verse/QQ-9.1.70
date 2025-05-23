package com.tencent.mobileqq.wink.newalbum.processor.poi;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qcircle.api.event.QcircleLbsEvent;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.mobileqq.winkpublish.util.WinkHostLbsHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\u0005\u0010B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0004R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R&\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/poi/c;", "", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "context", "", "a", "e", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "Lcom/tencent/mobileqq/wink/newalbum/processor/poi/c$b;", "callBack", "d", "", "c", "b", "", "Ljava/util/List;", "pendingList", "", "", "", "Ljava/util/Map;", "peadingRequest", "I", "requestCode", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    private static int f324304e = 100;

    /* renamed from: f, reason: collision with root package name */
    private static int f324305f = 100;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<WinkNewAlbumContext> pendingList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, List<WinkNewAlbumContext>> peadingRequest = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int requestCode = f324305f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/poi/c$b;", "", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a();
    }

    public final void a(@NotNull WinkNewAlbumContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.pendingList.add(context);
        QLog.i("WinkNewAlbumPoiRequestUtils", 1, "add:" + context.getMetaData().getPath() + ",lat:" + context.getMetaData().getLatitude() + ", longt:" + context.getMetaData().getLongitude() + ", pendingList.size:" + this.pendingList.size());
        if (this.pendingList.size() >= f324304e) {
            e();
        }
    }

    public final void b() {
        this.pendingList.clear();
        this.peadingRequest.clear();
        this.requestCode = 1;
    }

    public final boolean c() {
        if (this.pendingList.isEmpty() && this.peadingRequest.isEmpty()) {
            return true;
        }
        return false;
    }

    public final void d(@NotNull SimpleBaseEvent event, @NotNull WinkNewAlbumDatabaseImp db5, @NotNull b callBack) {
        boolean z16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(db5, "db");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        if (event instanceof QcircleLbsEvent) {
            QcircleLbsEvent qcircleLbsEvent = (QcircleLbsEvent) event;
            int i3 = qcircleLbsEvent.requestCode;
            if (i3 < f324305f) {
                QLog.i("WinkNewAlbumPoiRequestUtils", 1, "onReceiveEvent, requestCode:" + i3 + ", peadingRequestSize:" + this.peadingRequest.size() + ", not our event");
                return;
            }
            QLog.i("WinkNewAlbumPoiRequestUtils", 1, "onReceiveEvent, requestCode:" + i3 + ", peadingRequestSize:" + this.peadingRequest.size());
            LbsDataV2.PoiList poiList = qcircleLbsEvent.mPoiList;
            if (poiList == null) {
                QLog.e("WinkNewAlbumPoiRequestUtils", 1, "getBatchPoi error, event.mPoiList == null");
                this.peadingRequest.remove(Integer.valueOf(qcircleLbsEvent.requestCode));
                callBack.a();
                return;
            }
            ArrayList<LbsDataV2.PoiInfo> arrayList = poiList.poiInfos;
            if (arrayList == null) {
                QLog.e("WinkNewAlbumPoiRequestUtils", 1, "getBatchPoi error, invalid poiInfos");
                this.peadingRequest.remove(Integer.valueOf(qcircleLbsEvent.requestCode));
                callBack.a();
                return;
            }
            QLog.i("WinkNewAlbumPoiRequestUtils", 1, "size:" + arrayList.size());
            List<WinkNewAlbumContext> list = this.peadingRequest.get(Integer.valueOf(qcircleLbsEvent.requestCode));
            int i16 = 0;
            if (list != null && arrayList.size() == list.size()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.e("WinkNewAlbumPoiRequestUtils", 1, "getBatchPoi error, poiInfos.size:" + arrayList.size());
                this.peadingRequest.remove(Integer.valueOf(qcircleLbsEvent.requestCode));
                callBack.a();
                return;
            }
            if (list != null) {
                Iterator<T> it = arrayList.iterator();
                while (true) {
                    String str = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) next;
                    z83.a metaData = list.get(i16).getMetaData();
                    if (poiInfo != null) {
                        str = poiInfo.city;
                    }
                    if (str == null) {
                        str = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str, "poiInfo?.city ?: \"\"");
                    }
                    metaData.H(str);
                    String str2 = poiInfo.city;
                    LbsDataV2.GpsInfo gpsInfo = poiInfo.gpsInfo;
                    QLog.i("WinkNewAlbumPoiRequestUtils", 1, "city:" + str2 + ", lat:" + gpsInfo.lat + ", long:" + gpsInfo.lon);
                    i16 = i17;
                }
                List<WinkNewAlbumContext> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it5 = list2.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(((WinkNewAlbumContext) it5.next()).getMetaData());
                }
                db5.V(arrayList2, null);
            }
            this.peadingRequest.remove(Integer.valueOf(qcircleLbsEvent.requestCode));
            callBack.a();
        }
    }

    public final void e() {
        if (this.pendingList.size() == 0) {
            QLog.e("WinkNewAlbumPoiRequestUtils", 1, "requestPoi size = 0");
            return;
        }
        ArrayList<WinkNewAlbumContext> arrayList = new ArrayList();
        arrayList.addAll(this.pendingList);
        this.peadingRequest.put(Integer.valueOf(this.requestCode), arrayList);
        this.pendingList.clear();
        ArrayList arrayList2 = new ArrayList();
        for (WinkNewAlbumContext winkNewAlbumContext : arrayList) {
            GpsInfo4LocalImage gpsInfo4LocalImage = new GpsInfo4LocalImage();
            gpsInfo4LocalImage.latitude = winkNewAlbumContext.getMetaData().getLatitude();
            gpsInfo4LocalImage.longtitude = winkNewAlbumContext.getMetaData().getLongitude();
            gpsInfo4LocalImage.gpsType = 1;
            arrayList2.add(gpsInfo4LocalImage);
        }
        QLog.i("WinkNewAlbumPoiRequestUtils", 1, "start request requestCode:" + this.requestCode + ", size:" + arrayList2.size());
        WinkHostLbsHelper.getBatchPoiFromServerForRecom(arrayList2, this.requestCode);
        this.requestCode = this.requestCode + 1;
    }
}
