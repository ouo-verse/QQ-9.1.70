package com.qzone.album.qun.ui;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.image.NetImageInfo;
import com.tencent.mobileqq.R;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.List;
import java.util.Map;
import yo.d;

/* loaded from: classes39.dex */
public class ReshipPhotoStateQun extends QZoneUploadPhotoActivity.ai {
    public ReshipPhotoStateQun(QZoneUploadPhotoActivity qZoneUploadPhotoActivity) {
        super(qZoneUploadPhotoActivity);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public String b() {
        return this.f51767a.getResources().getString(R.string.gdl);
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
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
        qZoneUploadPhotoActivity.bq(qZoneUploadPhotoActivity.getIntent().getStringExtra(QZoneHelper.Constants.KEY_QUN_ID));
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = this.f51767a;
        qZoneUploadPhotoActivity2.cq(qZoneUploadPhotoActivity2.getIntent().getStringExtra(QZoneHelper.Constants.KEY_QUN_NAME));
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
        String j06 = u5.b.j0("key_upload_photo_albun_id_qun", "", uin);
        if (TextUtils.isEmpty(j06)) {
            return;
        }
        this.f51767a.L2 = BusinessAlbumInfo.create(j06);
        String j07 = u5.b.j0("key_upload_photo_albun_name_qun", "", uin);
        this.f51767a.L2.mTitle = j07;
        v4.a I = w4.a.L().I(this.f51767a.Xo(), this.f51767a.L2.getId());
        if (I == null) {
            this.f51767a.L2 = BusinessAlbumInfo.create("");
            this.f51767a.L2.mTitle = b();
            q();
            return;
        }
        if (I.albumname.equals(j07)) {
            return;
        }
        this.f51767a.L2.mTitle = I.albumname;
        q();
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void q() {
        if (this.f51767a.L2 == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        u5.b.x0("key_upload_photo_albun_id_qun", this.f51767a.L2.getId(), uin);
        u5.b.x0("key_upload_photo_albun_name_qun", this.f51767a.L2.getTitle(), uin);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void r() {
        d.l(this.f51767a.getActivity(), QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_ALBUM_SELECT_URL, QZoneHelper.Constants.URL_QUN_ALBUM_SELECT_URL).replace("{QUN_ID}", this.f51767a.Xo()), 2, null);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void v(List<ImageInfo> list, final BusinessAlbumInfo businessAlbumInfo, int i3, LbsDataV2.PoiInfo poiInfo, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, final Object... objArr) {
        if (objArr != null) {
            final List list2 = (List) objArr[0];
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.album.qun.ui.ReshipPhotoStateQun.1
                @Override // java.lang.Runnable
                public void run() {
                    QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
                    String str = (String) objArr[1];
                    BusinessAlbumInfo businessAlbumInfo2 = businessAlbumInfo;
                    long uin = LoginData.getInstance().getUin();
                    List<NetImageInfo> list3 = list2;
                    Object[] objArr2 = objArr;
                    v06.W1(str, businessAlbumInfo2, uin, list3, (String) objArr2[2], (String) objArr2[3]);
                }
            });
            this.f51767a.finish();
        }
    }
}
