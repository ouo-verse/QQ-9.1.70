package com.qzone.album.qun.ui;

import android.content.Intent;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.util.ToastUtil;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.image.NetImageInfo;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends QZoneUploadPhotoActivity.ai {

    /* renamed from: c, reason: collision with root package name */
    public String f44023c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<NetImageInfo> f44024d;

    public b(QZoneUploadPhotoActivity qZoneUploadPhotoActivity) {
        super(qZoneUploadPhotoActivity);
        this.f44023c = "";
    }

    private void w(ArrayList<NetImageInfo> arrayList) {
        this.f51767a.cm(arrayList);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public String b() {
        return this.f51767a.getResources().getString(R.string.gdk);
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
            this.f44023c = intent.getStringExtra(QZoneHelper.Constants.KEY_QUN_ID);
            ArrayList<NetImageInfo> arrayListFromIntent = ParcelableWrapper.getArrayListFromIntent(intent, QZoneUploadPhotoActivity.f51687c5);
            this.f44024d = arrayListFromIntent;
            w(arrayListFromIntent);
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
    public void p() {
        long uin = LoginData.getInstance().getUin();
        String j06 = u5.b.j0("key_upload_photo_albun_id", "", uin);
        if (TextUtils.isEmpty(j06)) {
            return;
        }
        this.f51767a.L2 = BusinessAlbumInfo.create(j06);
        this.f51767a.L2.mTitle = u5.b.j0("key_upload_photo_albun_name", "", uin);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void q() {
        if (this.f51767a.L2 == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        u5.b.x0("key_upload_photo_albun_id", this.f51767a.L2.getId(), uin);
        u5.b.x0("key_upload_photo_albun_name", this.f51767a.L2.getTitle(), uin);
        u5.b.r0("key_upload_photo_albun_type", this.f51767a.L2.mAlbumType, uin);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void r() {
        this.f51767a.startActivityForResult(ak.x(this.f51767a.getActivity(), this.f51767a.getString(R.string.gng), 0), 2);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void v(List<ImageInfo> list, BusinessAlbumInfo businessAlbumInfo, int i3, LbsDataV2.PoiInfo poiInfo, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, Object... objArr) {
        if (businessAlbumInfo == null) {
            return;
        }
        QZoneWriteOperationService.v0().V1(this.f44023c, businessAlbumInfo.getId(), businessAlbumInfo.getTitle(), (ArrayList) objArr[0], (String) objArr[1]);
        if (NetworkState.isNetSupport()) {
            ToastUtil.o(R.string.f173040gn1, 5);
        }
        this.f51767a.getActivity().setResult(-1);
        this.f51767a.finish();
    }
}
