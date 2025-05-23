package com.qzone.preview.business;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.album.business.search.SearchFilterComposition;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.PictureManager;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.component.app.common.ParcelableWrapper;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends g {
    private String Y;
    private SearchFilterComposition Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f49903a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f49904b0;

    @Override // com.qzone.preview.business.BasePicureViewController
    public int H() {
        return this.f49904b0;
    }

    @Override // com.qzone.preview.business.g, com.qzone.preview.business.BasePicureViewController
    public void Y(Bundle bundle) {
        super.Y(bundle);
        if (bundle == null) {
            return;
        }
        this.Y = bundle.getString("attach_info");
        this.Z = (SearchFilterComposition) ParcelableWrapper.getDataFromBudle(bundle, PictureConst.KEY_FILTER_DATA);
        this.f49903a0 = bundle.getString(PictureConst.KEY_ALBUM_ID);
        this.f49904b0 = bundle.getInt(PictureConst.KEY_SEARCH_RESULT_TOTAL);
    }

    @Override // com.qzone.preview.business.BasePicureViewController
    public void t(Handler handler) {
        PhotoInfo b16 = b();
        if (b16 == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(1);
        ArrayList<String> arrayList2 = new ArrayList<>(1);
        arrayList.add(b16.lloc);
        VideoInfo videoInfo = b16.videodata;
        if (videoInfo != null && !TextUtils.isEmpty(videoInfo.videoId)) {
            arrayList2.add(b16.videodata.videoId);
        }
        QZLog.i("QZoneSearchResultPreview", 1, "delete album video ", b16.lloc);
        PictureManager.getInstance().getSender().deleteSearchPhoto(handler, this.f49877g.albumid, arrayList, arrayList2);
    }

    @Override // com.qzone.preview.business.g, com.qzone.preview.business.BasePicureViewController
    public void v() {
        try {
            this.f49872b = (PhotoInfo[]) com.qzone.util.d.b(this.f49872b, this.f49873c);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        int i3 = this.f49873c;
        int i16 = this.f49874d;
        if (i3 == i16 - 1) {
            this.f49873c = i3 - 1;
        }
        this.f49874d = i16 - 1;
        this.f49881k--;
        this.f49904b0--;
    }

    @Override // com.qzone.preview.business.g
    protected void w1(long j3, int i3, int i16, Callback callback) {
        if (TextUtils.isEmpty(this.f49903a0)) {
            return;
        }
        PictureManager.getInstance().getCachePhotoSearchResult(j3, this.f49903a0, i3, i16, callback);
        QZLog.i("QZoneSearchResultPreview", 1, "[onGetCachePhotoList]");
    }

    @Override // com.qzone.preview.business.g
    protected void x1(long j3, Callback callback) {
        PictureManager.getInstance().getMorePhotoSearchResult(j3, this.f49903a0, this.Z, this.Y, callback);
        QZLog.i("QZoneSearchResultPreview", 1, "[onGetMorePhotoList]");
    }

    @Override // com.qzone.preview.business.g, com.qzone.preview.business.BasePicureViewController
    public void C0(QZoneResult qZoneResult, int i3) {
        int i16;
        if (qZoneResult == null) {
            return;
        }
        Bundle bundle = qZoneResult.getBundle();
        if (bundle != null) {
            ClassLoader classLoader = this.W;
            if (classLoader != null) {
                bundle.setClassLoader(classLoader);
            }
            ArrayList<PhotoInfo> parcelableArrayList = bundle.getParcelableArrayList("responseList");
            ArrayList<PhotoInfo> parcelableArrayList2 = bundle.getParcelableArrayList("cacheList");
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                this.f49883m = !bundle.getBoolean("hasMore", false);
                this.Y = bundle.getString("attachInfo");
                k1(parcelableArrayList);
                ArrayList parcelableArrayList3 = bundle.getParcelableArrayList("photoParamList");
                if (parcelableArrayList3 != null && !parcelableArrayList3.isEmpty()) {
                    this.R.addAll(parcelableArrayList3);
                }
                QZLog.i("QZoneSearchResultPreview", 1, "[onUpdatePhotoListResult] GET responseList -> size = " + parcelableArrayList.size() + " mIsRightFinish = " + this.f49883m + " mAttachInfo = " + this.Y);
            } else if (parcelableArrayList2 != null && !parcelableArrayList2.isEmpty() && (i16 = bundle.getInt("start", 0)) >= 0) {
                if ((parcelableArrayList2.size() + i16) - 1 < this.f49880j) {
                    p1(i16, parcelableArrayList2);
                    QZLog.i("QZoneSearchResultPreview", 1, "[onUpdatePhotoListResult] GET cacheList -> size = " + parcelableArrayList2.size() + " load direction = left");
                } else if (i16 > this.f49881k) {
                    k1(parcelableArrayList2);
                    this.f49883m = this.f49881k >= this.S - 1 && !this.T;
                    QZLog.i("QZoneSearchResultPreview", 1, "[onUpdatePhotoListResult] GET cacheList -> size = " + parcelableArrayList2.size() + " load direction = right mIsRightFinish = " + this.f49883m);
                }
            }
            if (this.f49883m) {
                m1();
            }
        }
        this.f49886p = true;
        this.U = false;
    }
}
