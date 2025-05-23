package com.tencent.mobileqq.wink.publish.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.event.QcircleLbsEvent;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.model.ExtendExifInterface;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.mobileqq.winkpublish.util.WinkHostLbsHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.WiFiPhotoErrorCode;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class o extends BaseViewModel implements SimpleEventReceiver {
    public static final String P = UploadConstants.TAG + "FSPoiViewModel";
    public LocalImageShootInfo H;
    public ArrayList<LocalImageShootInfo> I;
    private long K;
    private long L;

    /* renamed from: i, reason: collision with root package name */
    public int f326058i = 0;
    public List<LbsDataV2.PoiInfo> E = null;
    public List<LbsDataV2.PoiInfo> F = null;
    public LbsDataV2.PoiInfo G = null;
    public int J = -1;
    public boolean M = false;
    public boolean N = false;

    /* renamed from: m, reason: collision with root package name */
    public MutableLiveData<List<LbsDataV2.PoiInfo>> f326059m = new MutableLiveData<>();
    public MutableLiveData<LbsDataV2.PoiInfo> C = new MutableLiveData<>();
    public MutableLiveData<LbsDataV2.PoiInfo> D = new MutableLiveData<>();

    private ArrayList<LbsDataV2.PoiInfo> L1(List<LbsDataV2.PoiInfo> list) {
        ArrayList<LbsDataV2.PoiInfo> arrayList = new ArrayList<>();
        Iterator<LbsDataV2.PoiInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    private void M1() {
        this.L = System.currentTimeMillis();
        ArrayList<LocalImageShootInfo> arrayList = this.I;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<LocalImageShootInfo> it = this.I.iterator();
            while (it.hasNext()) {
                GpsInfo4LocalImage gpsInfo4LocalImage = it.next().gpsInfo;
                if (gpsInfo4LocalImage != null) {
                    arrayList2.add(gpsInfo4LocalImage);
                }
            }
            QLog.d(P, 2, "[fetchPOI] fetch Batch poi");
            WinkHostLbsHelper.getBatchPoiFromServer(arrayList2, true);
            return;
        }
        QLog.d(P, 2, "[fetchPOI] fetch Batch poi no image poi hasRequestLocalPoi:", Boolean.valueOf(this.M));
        WinkHostLbsHelper.getBatchPoiFromServer(null, true);
    }

    private void Q1(BasePartFragment basePartFragment, Context context) {
        Bundle bundle = new Bundle();
        LocalImageShootInfo localImageShootInfo = this.H;
        ArrayList<LocalImageShootInfo> arrayList = this.I;
        ArrayList<String> n26 = ((PublishViewModel) basePartFragment.getViewModel(PublishViewModel.class)).n2();
        if (localImageShootInfo != null && n26 != null && n26.contains(localImageShootInfo.path)) {
            bundle.putParcelable("key_current_img_shoot_info", localImageShootInfo);
        }
        if (arrayList != null && arrayList.size() > 0) {
            bundle.putParcelableArrayList("key_current_image_shoot_infos", arrayList);
        }
        List<LbsDataV2.PoiInfo> list = this.E;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArrayList("key_current_poi_list_infos", L1(this.E));
        }
        LbsDataV2.PoiInfo poiInfo = this.G;
        if (poiInfo != null) {
            bundle.putParcelable("key_current_poi", poiInfo);
            this.f326058i = 1;
        }
        bundle.putBoolean("key_sync_weishi", false);
        bundle.putBoolean("key_show_local_geo", false);
        bundle.putInt("key_app_id", WiFiPhotoErrorCode.ERR_FILEBRIDGE_NOT_FOLDER);
        bundle.putInt("key_lbs_state", this.f326058i);
        bundle.putBoolean("key_is_from_circle", true);
        bundle.putBoolean("key_is_test_case", true);
        bundle.putBoolean("key_not_adapt_night_mode", true);
        bundle.putStringArrayList("key_is_from_circle_for_aitextlabel", ((PublishViewModel) basePartFragment.getViewModel(PublishViewModel.class)).c2());
        com.tencent.mobileqq.wink.publish.util.c.a(context, WinkCommonUtil.getCurrentAccount(), 1208, bundle);
    }

    private void R1(ArrayList<LocalMediaInfo> arrayList) {
        this.J = -1;
        ArrayList<LocalImageShootInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<LocalMediaInfo> it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                LocalMediaInfo next = it.next();
                i3++;
                if (next != null) {
                    try {
                        if (!JpegExifReader.isCrashJpeg(next.path) && !next.mMimeType.contains("video")) {
                            float[] fArr = new float[2];
                            if (new ExtendExifInterface(next.path).getLatLong(fArr)) {
                                LocalImageShootInfo localImageShootInfo = new LocalImageShootInfo();
                                localImageShootInfo.captureTime = next.addedDate;
                                localImageShootInfo.modifyTime = next.modifiedDate;
                                GpsInfo4LocalImage gpsInfo4LocalImage = new GpsInfo4LocalImage();
                                gpsInfo4LocalImage.latitude = fArr[0];
                                gpsInfo4LocalImage.longtitude = fArr[1];
                                localImageShootInfo.gpsInfo = gpsInfo4LocalImage;
                                localImageShootInfo.path = next.path;
                                arrayList2.add(localImageShootInfo);
                                if (this.J == -1) {
                                    this.J = i3 - 1;
                                    this.H = localImageShootInfo;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(P, 2, String.format("LocalImageShootInfo.latitude=%f, LocalImageShootInfo.longtitude=%f, LocalImageShootInfo.path=%s", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), next.path));
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.e(P, 2, "exif.getLatLong==false");
                            }
                        }
                    } catch (Exception unused) {
                        QLog.e(P, 1, "read pic exif error");
                    }
                }
            }
        }
        this.I = arrayList2;
    }

    public LbsDataV2.PoiInfo N1() {
        LbsDataV2.PoiInfo poiInfo = this.G;
        if (poiInfo != null) {
            return poiInfo;
        }
        List<LbsDataV2.PoiInfo> list = this.F;
        if (list != null && list.size() > 0) {
            return this.F.get(0);
        }
        return null;
    }

    public void O1(Intent intent) {
        LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) intent.getExtras().getParcelable(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
        intent.getExtras().getBoolean("key_has_shoot_info");
        if (poiInfo != null && !poiInfo.poiId.equals("invalide_poi_id")) {
            this.G = poiInfo;
            this.C.postValue(poiInfo);
        } else {
            this.C.postValue(null);
        }
    }

    public void P1(BasePartFragment basePartFragment) {
        Q1(basePartFragment, basePartFragment.getActivity());
    }

    public void S1(ArrayList<LocalMediaInfo> arrayList, boolean z16) {
        this.K = uq3.c.X0("QZoneSetting", QzoneConfig.SECONDARY_LOCATE_MINPOI_INTERVAL, 20).intValue() * 1000;
        if (System.currentTimeMillis() - this.L > this.K || z16) {
            R1(arrayList);
            M1();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QcircleLbsEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return P;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        LbsDataV2.PoiList poiList;
        if (!(simpleBaseEvent instanceof QcircleLbsEvent) || (poiList = ((QcircleLbsEvent) simpleBaseEvent).mPoiList) == null) {
            return;
        }
        ArrayList<LbsDataV2.PoiInfo> arrayList = poiList.poiInfos;
        this.E = arrayList;
        if (arrayList == null) {
            QLog.w(P, 1, "[Lbs-onReceiveEvent] invalid poiInfos");
            return;
        }
        if (this.G == null && !this.N) {
            int min = Math.min(uq3.c.X0("qqcircle", "qqcircle_publish_show_lbs_count", 5).intValue(), this.E.size());
            if (min > 0) {
                QLog.d(P, 2, "[Lbs-onReceiveEvent] show def poi count: " + min);
                List<LbsDataV2.PoiInfo> subList = this.E.subList(0, min);
                this.F = subList;
                this.f326059m.postValue(subList);
            }
            List<LbsDataV2.PoiInfo> list = this.E;
            if (list != null && !list.isEmpty()) {
                QLog.d(P, 1, "[Lbs-onReceiveEvent] def selected first poi info.");
                this.D.postValue(this.E.get(0));
                return;
            }
            return;
        }
        QLog.w(P, 1, "[Lbs-onReceiveEvent] mSelectPoiData is selected || hasOperate:" + this.N);
    }
}
