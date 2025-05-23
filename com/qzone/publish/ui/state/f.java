package com.qzone.publish.ui.state;

import android.content.Intent;
import android.text.TextUtils;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.util.ToastUtil;
import com.qzone.util.image.ImageInfo;
import com.tencent.mobileqq.R;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f extends QZoneUploadPhotoActivity.ai {

    /* renamed from: c, reason: collision with root package name */
    protected ArrayList<String> f52082c;

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<Long> f52083d;

    /* renamed from: e, reason: collision with root package name */
    protected ArrayList<String> f52084e;

    /* renamed from: f, reason: collision with root package name */
    protected ArrayList<Long> f52085f;

    public f(QZoneUploadPhotoActivity qZoneUploadPhotoActivity) {
        super(qZoneUploadPhotoActivity);
    }

    private ArrayList<Long> x(Intent intent, String str) {
        Object obj = intent.getExtras().get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (ArrayList) obj;
        } catch (ClassCastException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void y(Intent intent) {
        this.f52082c = intent.getStringArrayListExtra(QZoneHelper.Constants.KEY_BIG_PHOTO_UUIDS);
        this.f52083d = x(intent, QZoneHelper.Constants.KEY_BIG_PHOTO_FILEIDS);
        this.f52084e = intent.getStringArrayListExtra(QZoneHelper.Constants.KEY_THUMB_FILE_PATHS);
        this.f52085f = x(intent, QZoneHelper.Constants.KEY_MSG_TIMES);
        if (this.f52082c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.f52082c = arrayList;
            arrayList.add(intent.getStringExtra(QZoneHelper.Constants.KEY_BIG_PHOTO_UUID));
            ArrayList<Long> arrayList2 = new ArrayList<>();
            this.f52083d = arrayList2;
            arrayList2.add(Long.valueOf(intent.getLongExtra(QZoneHelper.Constants.KEY_BIG_PHOTO_FILE_ID, 0L)));
            ArrayList<String> arrayList3 = new ArrayList<>();
            this.f52084e = arrayList3;
            arrayList3.add(intent.getStringExtra(QZoneHelper.Constants.KEY_THUMB_FILE_PATH));
            ArrayList<Long> arrayList4 = new ArrayList<>();
            this.f52085f = arrayList4;
            arrayList4.add(Long.valueOf(intent.getLongExtra(QZoneHelper.Constants.KEY_MSG_TIME, 0L)));
        }
        ArrayList<String> arrayList5 = this.f52084e;
        if (arrayList5 != null) {
            Iterator<String> it = arrayList5.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    this.f51767a.oj().add(next);
                }
            }
        }
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public int c() {
        return R.string.f173042gn3;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public int d() {
        return R.string.gn5;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public int e() {
        return R.string.gnf;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean g() {
        return false;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean h() {
        return false;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean i() {
        return false;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean j() {
        return false;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void k() {
        Intent intent = this.f51767a.getIntent();
        if (intent != null) {
            y(intent);
            z(intent);
        }
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean l() {
        return false;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean m() {
        return false;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean n() {
        return true;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean o() {
        return false;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void v(List<ImageInfo> list, BusinessAlbumInfo businessAlbumInfo, int i3, LbsDataV2.PoiInfo poiInfo, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, Object... objArr) {
        if (!NetworkState.isNetSupport()) {
            ToastUtil.n(R.string.ghj);
        } else {
            w(businessAlbumInfo, objArr);
        }
    }

    protected void w(BusinessAlbumInfo businessAlbumInfo, Object... objArr) {
        throw null;
    }

    protected void z(Intent intent) {
        throw null;
    }
}
