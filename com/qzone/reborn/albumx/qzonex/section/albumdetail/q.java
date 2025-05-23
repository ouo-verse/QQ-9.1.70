package com.qzone.reborn.albumx.qzonex.section.albumdetail;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsArea;
import com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsAreaList;
import com.qzone.reborn.albumx.qzonex.view.QZAlbumxTextureMapView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.widget.RoundCorneredLinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001OB\u0007\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J,\u0010\u000e\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0010\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J*\u0010\u001f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\f2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0006H\u0014J\b\u0010 \u001a\u00020\u0004H\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u001c\u00103\u001a\b\u0012\u0004\u0012\u0002020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010.R\u0018\u00105\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u000eR\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0016\u0010:\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0016\u0010;\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000eR\u0016\u0010=\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u000eR\u0016\u0010>\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010@\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\u000eR\u0016\u0010B\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010\u000eR\u0016\u0010D\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010<R\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010FR\u0016\u0010I\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010<R\u0016\u0010K\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010<\u00a8\u0006P"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/section/albumdetail/q;", "Lcom/qzone/reborn/base/l;", "Lxa/a;", "data", "", "G", "", "Lcom/qzone/album/data/model/PhotoPoiArea;", "photoPoiAreaList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/tencentmap/mapsdk/maps/model/Marker;", "overlayItemsList", "", "count", "D", "", "N", "overlayItemsBackup", "J", "", "objList", UserInfo.SEX_FEMALE, "", "getLogTag", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "position", "payload", "H", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mContainLayout", "Lcom/tencent/biz/richframework/widget/RoundCorneredLinearLayout;", "f", "Lcom/tencent/biz/richframework/widget/RoundCorneredLinearLayout;", "mTravelLinearLayout", "Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxTextureMapView;", tl.h.F, "Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxTextureMapView;", "mapView", "i", "Ljava/util/List;", "photoPoiAreaListBackup", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "markerTitles", "", "photoNumList", "Lcom/tencent/tencentmap/mapsdk/maps/model/Marker;", "lastClickMarker", "", "E", "maxLat", "maxLng", "minLat", "minLng", "I", "maxPhotoLat", "maxPhotoLng", "K", "centerLat", "L", "centerLng", "M", "maxIndex", "", "Z", "needRefreshMap", "P", "latSpan", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "lngSpan", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class q extends com.qzone.reborn.base.l<xa.a> {

    /* renamed from: D, reason: from kotlin metadata */
    private Marker lastClickMarker;

    /* renamed from: I, reason: from kotlin metadata */
    private double maxPhotoLat;

    /* renamed from: J, reason: from kotlin metadata */
    private double maxPhotoLng;

    /* renamed from: K, reason: from kotlin metadata */
    private double centerLat;

    /* renamed from: L, reason: from kotlin metadata */
    private double centerLng;

    /* renamed from: M, reason: from kotlin metadata */
    private int maxIndex;

    /* renamed from: P, reason: from kotlin metadata */
    private int latSpan;

    /* renamed from: Q, reason: from kotlin metadata */
    private int lngSpan;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mContainLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredLinearLayout mTravelLinearLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxTextureMapView mapView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<PhotoPoiArea> photoPoiAreaListBackup;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<String> markerTitles = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private List<Long> photoNumList = new ArrayList();

    /* renamed from: E, reason: from kotlin metadata */
    private double maxLat = -500.0d;

    /* renamed from: F, reason: from kotlin metadata */
    private double maxLng = -500.0d;

    /* renamed from: G, reason: from kotlin metadata */
    private double minLat = 500.0d;

    /* renamed from: H, reason: from kotlin metadata */
    private double minLng = 500.0d;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean needRefreshMap = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/albumx/qzonex/section/albumdetail/q$b", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$OnCameraChangeListener;", "Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", "cameraPosition", "", "onCameraChange", "onCameraChangeFinished", "d", "Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", "getPrePosition", "()Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", "setPrePosition", "(Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;)V", "prePosition", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements TencentMap.OnCameraChangeListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private CameraPosition prePosition;

        b() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChange(CameraPosition cameraPosition) {
            Intrinsics.checkNotNullParameter(cameraPosition, "cameraPosition");
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
        
            if ((r0.target.getLatitude() == r10.target.getLatitude()) == false) goto L16;
         */
        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCameraChangeFinished(CameraPosition cameraPosition) {
            Intrinsics.checkNotNullParameter(cameraPosition, "cameraPosition");
            if (this.prePosition == null) {
                this.prePosition = cameraPosition;
            }
            CameraPosition cameraPosition2 = this.prePosition;
            Intrinsics.checkNotNull(cameraPosition2);
            if (cameraPosition2.target.getLongitude() == cameraPosition.target.getLongitude()) {
                CameraPosition cameraPosition3 = this.prePosition;
                Intrinsics.checkNotNull(cameraPosition3);
            }
            com.qzone.album.env.common.a.m().R("368", "28", "3");
            CameraPosition cameraPosition4 = this.prePosition;
            Intrinsics.checkNotNull(cameraPosition4);
            if (cameraPosition4.zoom == cameraPosition.zoom) {
                return;
            }
            com.qzone.album.env.common.a.m().R("368", "29", "3");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x009e, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void C(List<PhotoPoiArea> photoPoiAreaList) {
        List<PhotoPoiArea> mutableList;
        boolean z16;
        List<PhotoPoiArea> list = this.photoPoiAreaListBackup;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (list.size() == photoPoiAreaList.size()) {
                int i3 = 0;
                while (true) {
                    List<PhotoPoiArea> list2 = this.photoPoiAreaListBackup;
                    Intrinsics.checkNotNull(list2);
                    if (i3 >= list2.size() || i3 >= photoPoiAreaList.size()) {
                        break;
                    }
                    List<PhotoPoiArea> list3 = this.photoPoiAreaListBackup;
                    Intrinsics.checkNotNull(list3);
                    if (list3.get(i3).poiInfo != null) {
                        List<PhotoPoiArea> list4 = this.photoPoiAreaListBackup;
                        Intrinsics.checkNotNull(list4);
                        if (list4.get(i3).poiInfo.poiX != null) {
                            List<PhotoPoiArea> list5 = this.photoPoiAreaListBackup;
                            Intrinsics.checkNotNull(list5);
                            if (list5.get(i3).poiInfo.poiY != null) {
                                List<PhotoPoiArea> list6 = this.photoPoiAreaListBackup;
                                Intrinsics.checkNotNull(list6);
                                if (!Intrinsics.areEqual(list6.get(i3).poiInfo.poiX, photoPoiAreaList.get(i3).poiInfo.poiX)) {
                                    break;
                                }
                                List<PhotoPoiArea> list7 = this.photoPoiAreaListBackup;
                                Intrinsics.checkNotNull(list7);
                                if (!Intrinsics.areEqual(list7.get(i3).poiInfo.poiY, photoPoiAreaList.get(i3).poiInfo.poiY)) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                    i3++;
                    if (z16) {
                        QLog.d("QZAlbumxAlbumDetailTravelMapSection", 2, "addPoiOnMap | Same not refresh mapview");
                        return;
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
        }
        QLog.d("QZAlbumxAlbumDetailTravelMapSection", 2, "addPoiOnMap");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) photoPoiAreaList);
        this.photoPoiAreaListBackup = mutableList;
        ArrayList arrayList = new ArrayList();
        N(arrayList, D(photoPoiAreaList, arrayList, 0));
    }

    private final void G(xa.a data) {
        ArrayList<CommonMediaLbsArea> a16;
        if (data.getIsAlbumDetailEmpty()) {
            LinearLayout linearLayout = this.mContainLayout;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = this.mContainLayout;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        CommonMediaLbsAreaList mediaLbsAreaList = data.getMediaLbsAreaList();
        ArrayList arrayList = new ArrayList();
        if (mediaLbsAreaList != null && (a16 = mediaLbsAreaList.a()) != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : a16) {
                if (((CommonMediaLbsArea) obj).getLbsInfo().getLocation().length() > 0) {
                    arrayList2.add(obj);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(fb.a.M((CommonMediaLbsArea) it.next()));
            }
        }
        if (arrayList.size() > 0) {
            C(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(q this$0, double d16, double d17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            QZAlbumxTextureMapView qZAlbumxTextureMapView = this$0.mapView;
            Intrinsics.checkNotNull(qZAlbumxTextureMapView);
            qZAlbumxTextureMapView.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(this$0.centerLat, this$0.centerLng)));
            QZAlbumxTextureMapView qZAlbumxTextureMapView2 = this$0.mapView;
            Intrinsics.checkNotNull(qZAlbumxTextureMapView2);
            qZAlbumxTextureMapView2.getMap().moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(new LatLng(this$0.maxLat + d16, this$0.minLng - d17), new LatLng(this$0.minLat - d16, this$0.maxLng + d17)), 0));
        } catch (Throwable th5) {
            QLog.e("QZAlbumxAlbumDetailTravelMapSection", 1, "exception:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(q this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            QZAlbumxTextureMapView qZAlbumxTextureMapView = this$0.mapView;
            Intrinsics.checkNotNull(qZAlbumxTextureMapView);
            qZAlbumxTextureMapView.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(this$0.maxPhotoLat, this$0.maxPhotoLng)));
            QZAlbumxTextureMapView qZAlbumxTextureMapView2 = this$0.mapView;
            Intrinsics.checkNotNull(qZAlbumxTextureMapView2);
            qZAlbumxTextureMapView2.getMap().moveCamera(CameraUpdateFactory.zoomTo(6.0f));
        } catch (Throwable th5) {
            QLog.e("QZAlbumxAlbumDetailTravelMapSection", 1, "exception:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(q this$0, double d16, double d17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            QZAlbumxTextureMapView qZAlbumxTextureMapView = this$0.mapView;
            Intrinsics.checkNotNull(qZAlbumxTextureMapView);
            qZAlbumxTextureMapView.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(this$0.centerLat, this$0.centerLng)));
            QZAlbumxTextureMapView qZAlbumxTextureMapView2 = this$0.mapView;
            Intrinsics.checkNotNull(qZAlbumxTextureMapView2);
            qZAlbumxTextureMapView2.getMap().moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(new LatLng(this$0.maxLat + d16, this$0.minLng - d17), new LatLng(this$0.minLat - d16, this$0.maxLng + d17)), 0));
        } catch (Throwable th5) {
            QLog.e("QZAlbumxAlbumDetailTravelMapSection", 1, "exception:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(q this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZAlbumxTextureMapView qZAlbumxTextureMapView = this$0.mapView;
        if (qZAlbumxTextureMapView != null) {
            Intrinsics.checkNotNull(qZAlbumxTextureMapView);
            if (qZAlbumxTextureMapView.getMap() != null) {
                QZAlbumxTextureMapView qZAlbumxTextureMapView2 = this$0.mapView;
                Intrinsics.checkNotNull(qZAlbumxTextureMapView2);
                qZAlbumxTextureMapView2.getMap().clear();
            }
        }
        this$0.needRefreshMap = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P(q this$0, Marker marker) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (marker == null) {
            return false;
        }
        this$0.lastClickMarker = marker;
        Object tag = marker.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        if (((Integer) tag).intValue() < this$0.markerTitles.size()) {
            List<String> list = this$0.markerTitles;
            Object tag2 = marker.getTag();
            Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type kotlin.Int");
            marker.setTitle(list.get(((Integer) tag2).intValue()));
        }
        QQMapActivity.showInfoWindow(marker);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(q this$0, LatLng latLng) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Marker marker = this$0.lastClickMarker;
        if (marker != null) {
            Intrinsics.checkNotNull(marker);
            if (TextUtils.isEmpty(marker.getTitle())) {
                return;
            }
            Marker marker2 = this$0.lastClickMarker;
            Intrinsics.checkNotNull(marker2);
            marker2.setTitle("");
            this$0.lastClickMarker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(final q this$0, final List overlayItemsBackup) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(overlayItemsBackup, "$overlayItemsBackup");
        try {
            QLog.d("QZAlbumxAlbumDetailTravelMapSection", 2, "onMapLoaded");
            this$0.needRefreshMap = true;
            QZAlbumxTextureMapView qZAlbumxTextureMapView = this$0.mapView;
            if (qZAlbumxTextureMapView != null) {
                Intrinsics.checkNotNull(qZAlbumxTextureMapView);
                if (qZAlbumxTextureMapView.getMap() != null) {
                    QZAlbumxTextureMapView qZAlbumxTextureMapView2 = this$0.mapView;
                    Intrinsics.checkNotNull(qZAlbumxTextureMapView2);
                    if (qZAlbumxTextureMapView2.getMap().getProjection() != null) {
                        QZAlbumxTextureMapView qZAlbumxTextureMapView3 = this$0.mapView;
                        Intrinsics.checkNotNull(qZAlbumxTextureMapView3);
                        Projection projection = qZAlbumxTextureMapView3.getMap().getProjection();
                        this$0.latSpan = (int) ((projection.getVisibleRegion().latLngBounds.northeast.latitude * 1000000.0d) - (projection.getVisibleRegion().latLngBounds.southwest.latitude * 1000000.0d));
                        this$0.lngSpan = (int) ((projection.getVisibleRegion().latLngBounds.northeast.longitude * 1000000.0d) - (projection.getVisibleRegion().latLngBounds.southwest.longitude * 1000000.0d));
                    }
                }
            }
            RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.p
                @Override // java.lang.Runnable
                public final void run() {
                    q.S(q.this, overlayItemsBackup);
                }
            });
        } catch (Throwable th5) {
            QLog.e("QZAlbumxAlbumDetailTravelMapSection", 1, "showMap onMapLoaded exception:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(q this$0, List overlayItemsBackup) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(overlayItemsBackup, "$overlayItemsBackup");
        try {
            this$0.J(overlayItemsBackup);
        } catch (Throwable th5) {
            QLog.e("QZAlbumxAlbumDetailTravelMapSection", 1, "onMapLoaded exception:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailTravelMapSection";
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        QZAlbumxTextureMapView qZAlbumxTextureMapView = this.mapView;
        if (qZAlbumxTextureMapView != null) {
            qZAlbumxTextureMapView.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nhl};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onBindData(xa.a data, int position, List<Object> payload) {
        if (data != null) {
            G(data);
        }
    }

    private final void J(List<? extends Marker> overlayItemsBackup) {
        QZAlbumxTextureMapView qZAlbumxTextureMapView = this.mapView;
        Intrinsics.checkNotNull(qZAlbumxTextureMapView);
        QLog.d("QZAlbumxAlbumDetailTravelMapSection", 4, "refreshMap mMapView.getMap().getZoomLevel():", Float.valueOf(qZAlbumxTextureMapView.getMap().getCameraPosition().zoom));
        QLog.d("QZAlbumxAlbumDetailTravelMapSection", 4, "dLat:", Double.valueOf(Math.abs(this.maxLat - this.minLat) * 1000000.0d), " dLng:", Double.valueOf(Math.abs(this.maxLng - this.minLng) * 1000000.0d));
        QLog.d("QZAlbumxAlbumDetailTravelMapSection", 4, "getLatitudeSpan:", Integer.valueOf(this.latSpan), " getLongitudeSpan:", Integer.valueOf(this.lngSpan));
        if (this.needRefreshMap && this.latSpan == 0) {
            QZAlbumxTextureMapView qZAlbumxTextureMapView2 = this.mapView;
            Intrinsics.checkNotNull(qZAlbumxTextureMapView2);
            Projection projection = qZAlbumxTextureMapView2.getMap().getProjection();
            this.latSpan = (int) (projection.getVisibleRegion().latLngBounds.southwest.latitude - projection.getVisibleRegion().latLngBounds.northeast.latitude);
            this.lngSpan = (int) (projection.getVisibleRegion().latLngBounds.southwest.longitude - projection.getVisibleRegion().latLngBounds.northeast.longitude);
            QLog.d("QZAlbumxAlbumDetailTravelMapSection", 4, "getLatitudeSpan:", Integer.valueOf(this.latSpan), " getLongitudeSpan:", Integer.valueOf(this.lngSpan));
        }
        if (this.latSpan > 0) {
            final double abs = Math.abs(this.maxLat - this.minLat);
            final double abs2 = Math.abs(this.maxLng - this.minLng);
            if (abs * 1000000.0d * 1.5d < this.latSpan && 1000000.0d * abs2 * 1.5d < this.lngSpan) {
                double d16 = (this.minLat + this.maxLat) / 2.0d;
                this.centerLat = d16;
                this.centerLng = (this.maxLng + this.minLng) / 2.0d;
                QLog.d("QZAlbumxAlbumDetailTravelMapSection", 4, "in the world centerLat:", Double.valueOf(d16), " centerLng:", Double.valueOf(this.centerLng));
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.K(q.this, abs, abs2);
                    }
                });
                return;
            }
            F(overlayItemsBackup);
            final double abs3 = Math.abs(this.maxLat - this.minLat);
            final double abs4 = Math.abs(this.maxLng - this.minLng);
            if (((int) this.maxLat) != Integer.MIN_VALUE && ((int) this.maxLng) != Integer.MIN_VALUE && ((int) this.minLat) != Integer.MAX_VALUE && ((int) this.minLng) != Integer.MAX_VALUE) {
                QLog.d("QZAlbumxAlbumDetailTravelMapSection", 1, "out the world centerLat:", Double.valueOf(this.centerLat), " centerLng:", Double.valueOf(this.centerLng));
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.M(q.this, abs3, abs4);
                    }
                });
            } else {
                QLog.d("QZAlbumxAlbumDetailTravelMapSection", 4, "out the world maxPhotoLat:", Double.valueOf(this.maxPhotoLat), " maxPhotoLng:", Double.valueOf(this.maxPhotoLng));
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.L(q.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView == null) {
            return;
        }
        int o16 = (int) ((pl.a.f426446a.o(containerView.getContext()) - (ViewUtils.dpToPx(13.0f) * 2)) / 2.8333333f);
        this.mContainLayout = (LinearLayout) containerView.findViewById(R.id.nhk);
        this.mTravelLinearLayout = (RoundCorneredLinearLayout) containerView.findViewById(R.id.nhj);
        Context context = containerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        TencentMapOptions tencentMapOptions = new TencentMapOptions();
        tencentMapOptions.setDisallowInterceptTouchEvent(true);
        Unit unit = Unit.INSTANCE;
        this.mapView = new QZAlbumxTextureMapView(context, tencentMapOptions);
        RoundCorneredLinearLayout roundCorneredLinearLayout = this.mTravelLinearLayout;
        if (roundCorneredLinearLayout != null) {
            Intrinsics.checkNotNull(roundCorneredLinearLayout);
            roundCorneredLinearLayout.setRadius(ViewUtils.dpToPx(8.0f));
            RoundCorneredLinearLayout roundCorneredLinearLayout2 = this.mTravelLinearLayout;
            Intrinsics.checkNotNull(roundCorneredLinearLayout2);
            roundCorneredLinearLayout2.addView(this.mapView, new ViewGroup.LayoutParams(-1, o16));
        }
        QZAlbumxTextureMapView qZAlbumxTextureMapView = this.mapView;
        if (qZAlbumxTextureMapView != null) {
            Intrinsics.checkNotNull(qZAlbumxTextureMapView);
            if (qZAlbumxTextureMapView.getMap() != null) {
                QZAlbumxTextureMapView qZAlbumxTextureMapView2 = this.mapView;
                Intrinsics.checkNotNull(qZAlbumxTextureMapView2);
                UiSettings uiSettings = qZAlbumxTextureMapView2.getMap().getUiSettings();
                uiSettings.setScaleViewEnabled(false);
                uiSettings.setLogoPosition(5);
                QZAlbumxTextureMapView qZAlbumxTextureMapView3 = this.mapView;
                Intrinsics.checkNotNull(qZAlbumxTextureMapView3);
                TencentMap map = qZAlbumxTextureMapView3.getMap();
                map.moveCamera(CameraUpdateFactory.zoomTo(map.getMinZoomLevel()));
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:3|(3:4|5|6)|(7:7|8|9|(7:11|12|(6:14|15|16|17|18|(11:20|(1:22)|23|(1:25)|26|(1:28)|29|(3:31|32|33)|34|35|33))(1:43)|36|34|35|33)(1:46)|40|41|42)|47|48|49|50|51|52|53|54|55|56|57|(6:(4:63|64|65|(3:67|68|(5:70|71|72|73|74)))(1:60)|61|62|40|41|42)(1:93)|76|77|78|79|80|81|82|42) */
    /* JADX WARN: Can't wrap try/catch for region: R(25:3|4|5|6|(7:7|8|9|(7:11|12|(6:14|15|16|17|18|(11:20|(1:22)|23|(1:25)|26|(1:28)|29|(3:31|32|33)|34|35|33))(1:43)|36|34|35|33)(1:46)|40|41|42)|47|48|49|50|51|52|53|54|55|56|57|(6:(4:63|64|65|(3:67|68|(5:70|71|72|73|74)))(1:60)|61|62|40|41|42)(1:93)|76|77|78|79|80|81|82|42) */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01e7, code lost:
    
        r1 = r16;
        r7 = r17;
        r9 = r18;
        r14 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f1, code lost:
    
        r1 = r16;
        r7 = r17;
        r9 = r18;
        r14 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0148, code lost:
    
        if (r37.photoNumList.get(r1).longValue() > r37.photoNumList.get(r9).longValue()) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01fd, code lost:
    
        r1 = r16;
        r7 = r17;
        r9 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0204, code lost:
    
        r12 = r7;
        r13 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void F(Object objList) {
        List list;
        String str;
        String str2;
        String str3;
        int i3;
        int i16;
        double latitude;
        double longitude;
        double d16;
        int i17;
        int i18;
        int i19;
        double d17;
        double d18;
        double d19;
        int i26;
        int i27;
        String str4;
        int i28;
        double d26;
        double d27;
        String str5 = " num:";
        String str6 = "i:";
        String str7 = "QZAlbumxAlbumDetailTravelMapSection";
        Intrinsics.checkNotNull(objList, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.tencentmap.mapsdk.maps.model.Marker>");
        List list2 = (List) objList;
        this.maxLat = -2.147483648E9d;
        this.maxLng = -2.147483648E9d;
        double d28 = 2.147483647E9d;
        this.minLat = 2.147483647E9d;
        this.minLng = 2.147483647E9d;
        int size = list2.size();
        int i29 = 0;
        int i36 = 0;
        int i37 = 0;
        while (i29 < size) {
            Marker marker = (Marker) list2.get(i29);
            try {
                latitude = marker.getPosition().getLatitude();
                longitude = marker.getPosition().getLongitude();
                str = str5;
                str2 = str6;
                d16 = d28;
                i3 = size;
                i17 = i29;
                i18 = i36;
                i19 = i37;
                d17 = -2.147483648E9d;
                d18 = -2.147483648E9d;
                d19 = d16;
                i26 = 0;
                i27 = 0;
            } catch (Exception unused) {
                list = list2;
                str = str5;
                str2 = str6;
                str3 = str7;
                i3 = size;
                i16 = i29;
            }
            while (true) {
                try {
                    str4 = str7;
                    if (i26 >= list2.size()) {
                        break;
                    }
                    try {
                        Marker marker2 = (Marker) list2.get(i26);
                        double latitude2 = marker2.getPosition().getLatitude();
                        double longitude2 = marker2.getPosition().getLongitude();
                        double d29 = latitude;
                        int i38 = i26;
                        double d36 = 2;
                        if (Math.abs(latitude - latitude2) * 1000000.0d < (this.latSpan * 0.8d) / d36) {
                            list = list2;
                            try {
                                d26 = longitude;
                                if (Math.abs(longitude - longitude2) * 1000000.0d < (this.lngSpan * 0.8d) / d36) {
                                    i27++;
                                    if (latitude2 > d18) {
                                        d18 = latitude2;
                                    }
                                    if (latitude2 < d19) {
                                        d19 = latitude2;
                                    }
                                    d27 = d16;
                                    if (longitude2 > d17) {
                                        d17 = longitude2;
                                    }
                                    if (longitude2 < d27) {
                                        d16 = longitude2;
                                        i26 = i38 + 1;
                                        str7 = str4;
                                        list2 = list;
                                        longitude = d26;
                                        latitude = d29;
                                    }
                                    d16 = d27;
                                    i26 = i38 + 1;
                                    str7 = str4;
                                    list2 = list;
                                    longitude = d26;
                                    latitude = d29;
                                }
                            } catch (Exception unused2) {
                                i16 = i17;
                                i36 = i18;
                                i37 = i19;
                                str3 = str4;
                                i29 = i16 + 1;
                                str7 = str3;
                                str5 = str;
                                str6 = str2;
                                size = i3;
                                list2 = list;
                                d28 = 2.147483647E9d;
                            }
                        } else {
                            list = list2;
                            d26 = longitude;
                        }
                        d27 = d16;
                        d16 = d27;
                        i26 = i38 + 1;
                        str7 = str4;
                        list2 = list;
                        longitude = d26;
                        latitude = d29;
                    } catch (Exception unused3) {
                        list = list2;
                    }
                } catch (Exception unused4) {
                    list = list2;
                    str3 = str7;
                }
                i29 = i16 + 1;
                str7 = str3;
                str5 = str;
                str6 = str2;
                size = i3;
                list2 = list;
                d28 = 2.147483647E9d;
            }
            list = list2;
            double d37 = latitude;
            int i39 = i26;
            double d38 = longitude;
            double d39 = d16;
            Object[] objArr = new Object[4];
            objArr[0] = str2;
            objArr[1] = Integer.valueOf(i17);
            objArr[2] = " currentNum:";
            objArr[3] = Integer.valueOf(i27);
            str3 = str4;
            QLog.d(str3, 1, objArr);
            if (i27 <= i18) {
                if (i27 == i18) {
                    try {
                        i16 = i17;
                        if (this.photoNumList.size() > i16) {
                            try {
                                if (this.photoNumList.size() > i39) {
                                    i28 = i19;
                                }
                            } catch (Exception unused5) {
                            }
                        }
                    } catch (Exception unused6) {
                        i16 = i17;
                    }
                } else {
                    i16 = i17;
                }
                i28 = i19;
                i36 = i18;
                i37 = i28;
                i29 = i16 + 1;
                str7 = str3;
                str5 = str;
                str6 = str2;
                size = i3;
                list2 = list;
                d28 = 2.147483647E9d;
            } else {
                i16 = i17;
            }
            this.maxLat = d18;
            this.minLat = d19;
            this.maxLng = d17;
            this.minLng = d39;
            this.centerLat = d37;
            this.centerLng = d38;
            Object[] objArr2 = new Object[16];
            objArr2[0] = str2;
            objArr2[1] = Integer.valueOf(i16);
            objArr2[2] = str;
            objArr2[3] = this.photoNumList.get(i16);
            objArr2[4] = " maxIndex:";
            objArr2[5] = Integer.valueOf(i16);
            objArr2[6] = str;
            objArr2[7] = this.photoNumList.get(i16);
            objArr2[8] = " maxLat:";
            objArr2[9] = Double.valueOf(this.maxLat);
            objArr2[10] = " minLat:";
            objArr2[11] = Double.valueOf(this.minLat);
            objArr2[12] = " maxLng:";
            objArr2[13] = Double.valueOf(this.maxLng);
            objArr2[14] = " minLng:";
            objArr2[15] = Double.valueOf(this.minLng);
            QLog.d(str3, 1, objArr2);
            i37 = i16;
            i36 = i27;
            i29 = i16 + 1;
            str7 = str3;
            str5 = str;
            str6 = str2;
            size = i3;
            list2 = list;
            d28 = 2.147483647E9d;
        }
    }

    private final void N(final List<? extends Marker> overlayItemsList, int count) {
        if (count != 0 && overlayItemsList != null && overlayItemsList.size() > 0) {
            QZAlbumxTextureMapView qZAlbumxTextureMapView = this.mapView;
            Intrinsics.checkNotNull(qZAlbumxTextureMapView);
            qZAlbumxTextureMapView.getMap().setOnMarkerClickListener(new TencentMap.OnMarkerClickListener() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.i
                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener
                public final boolean onMarkerClick(Marker marker) {
                    boolean P;
                    P = q.P(q.this, marker);
                    return P;
                }
            });
            QZAlbumxTextureMapView qZAlbumxTextureMapView2 = this.mapView;
            Intrinsics.checkNotNull(qZAlbumxTextureMapView2);
            qZAlbumxTextureMapView2.getMap().setOnMapClickListener(new TencentMap.OnMapClickListener() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.j
                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener
                public final void onMapClick(LatLng latLng) {
                    q.Q(q.this, latLng);
                }
            });
            QZAlbumxTextureMapView qZAlbumxTextureMapView3 = this.mapView;
            Intrinsics.checkNotNull(qZAlbumxTextureMapView3);
            qZAlbumxTextureMapView3.getMap().setOnMapLoadedCallback(new TencentMap.OnMapLoadedCallback() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.k
                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
                public final void onMapLoaded() {
                    q.R(q.this, overlayItemsList);
                }
            });
            QZAlbumxTextureMapView qZAlbumxTextureMapView4 = this.mapView;
            Intrinsics.checkNotNull(qZAlbumxTextureMapView4);
            qZAlbumxTextureMapView4.getMap().setOnCameraChangeListener(new b());
            boolean z16 = this.needRefreshMap;
            if (z16) {
                QLog.d("QZAlbumxAlbumDetailTravelMapSection", 4, "refreshMapForOld needRefreshMap:", Boolean.valueOf(z16));
                J(overlayItemsList);
                return;
            }
            return;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.albumx.qzonex.section.albumdetail.l
            @Override // java.lang.Runnable
            public final void run() {
                q.O(q.this);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fd, code lost:
    
        if ((r11 == 0.0d) != false) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int D(List<PhotoPoiArea> photoPoiAreaList, List<Marker> overlayItemsList, int count) {
        long j3;
        this.maxLng = -500.0d;
        this.maxLat = -500.0d;
        this.minLng = 500.0d;
        this.minLat = 500.0d;
        long j16 = 0;
        this.centerLng = 0.0d;
        this.centerLat = 0.0d;
        this.maxPhotoLng = 0.0d;
        this.maxPhotoLat = 0.0d;
        int size = photoPoiAreaList.size();
        long j17 = 0;
        int i3 = 0;
        int i16 = count;
        while (i3 < size) {
            String title = photoPoiAreaList.get(i3).sceneryName;
            List<String> list = this.markerTitles;
            Intrinsics.checkNotNullExpressionValue(title, "title");
            list.add(title);
            String str = photoPoiAreaList.get(i3).poiInfo.poiX;
            String str2 = photoPoiAreaList.get(i3).poiInfo.poiY;
            this.photoNumList.add(Long.valueOf(photoPoiAreaList.get(i3).photoNum));
            if (str == null || str2 == null) {
                j3 = j16;
            } else {
                int length = str.length() - 1;
                int i17 = 0;
                boolean z16 = false;
                while (i17 <= length) {
                    boolean z17 = Intrinsics.compare((int) str.charAt(!z16 ? i17 : length), 32) <= 0;
                    if (z16) {
                        if (!z17) {
                            break;
                        }
                        length--;
                    } else if (z17) {
                        i17++;
                    } else {
                        z16 = true;
                    }
                }
                if (!TextUtils.isEmpty(str.subSequence(i17, length + 1).toString())) {
                    int length2 = str2.length() - 1;
                    int i18 = 0;
                    boolean z18 = false;
                    while (i18 <= length2) {
                        boolean z19 = Intrinsics.compare((int) str2.charAt(!z18 ? i18 : length2), 32) <= 0;
                        if (z18) {
                            if (!z19) {
                                break;
                            }
                            length2--;
                        } else if (z19) {
                            i18++;
                        } else {
                            z18 = true;
                        }
                    }
                    if (!TextUtils.isEmpty(str2.subSequence(i18, length2 + 1).toString())) {
                        double parseDouble = Double.parseDouble(str2);
                        double parseDouble2 = Double.parseDouble(str);
                        j3 = 0;
                        if (parseDouble == 0.0d) {
                        }
                        if (Math.abs(parseDouble2) > 180.0d || Math.abs(parseDouble) > 90.0d) {
                            double d16 = parseDouble / 1000000.0d;
                            parseDouble = parseDouble2 / 1000000.0d;
                            parseDouble2 = d16;
                        }
                        if (Math.abs(parseDouble2) <= 180.0d && Math.abs(parseDouble) <= 90.0d) {
                            QLog.d("QZAlbumxAlbumDetailTravelMapSection", 4, "currentLng:", Double.valueOf(parseDouble2), " currentLat:", Double.valueOf(parseDouble), " title:", title);
                            QZAlbumxTextureMapView qZAlbumxTextureMapView = this.mapView;
                            Intrinsics.checkNotNull(qZAlbumxTextureMapView);
                            Marker marker = qZAlbumxTextureMapView.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.fwq)).position(new LatLng(parseDouble, parseDouble2)).tag(Integer.valueOf(i3)).snippet(""));
                            QQMapActivity.showInfoWindow(marker);
                            Intrinsics.checkNotNullExpressionValue(marker, "marker");
                            overlayItemsList.add(marker);
                            if (parseDouble > this.maxLat) {
                                this.maxLat = parseDouble;
                            }
                            if (parseDouble < this.minLat) {
                                this.minLat = parseDouble;
                            }
                            if (parseDouble2 > this.maxLng) {
                                this.maxLng = parseDouble2;
                            }
                            if (parseDouble2 < this.minLng) {
                                this.minLng = parseDouble2;
                            }
                            if (photoPoiAreaList.get(i3).poiPhotoNum >= j17) {
                                j17 = photoPoiAreaList.get(i3).poiPhotoNum;
                                this.maxPhotoLat = parseDouble;
                                this.maxPhotoLng = parseDouble2;
                                this.maxIndex = i16;
                            }
                            i16++;
                            i3++;
                            j16 = j3;
                        }
                    }
                }
                j3 = 0;
            }
            i3++;
            j16 = j3;
        }
        return i16;
    }
}
