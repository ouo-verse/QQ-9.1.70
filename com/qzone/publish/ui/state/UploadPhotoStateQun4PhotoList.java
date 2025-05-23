package com.qzone.publish.ui.state;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.util.l;
import com.qzone.util.image.ImageInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes39.dex */
public class UploadPhotoStateQun4PhotoList extends QZoneUploadPhotoActivity.ai {

    /* renamed from: c, reason: collision with root package name */
    private String f52042c;

    /* renamed from: d, reason: collision with root package name */
    private String f52043d;

    /* renamed from: e, reason: collision with root package name */
    private String f52044e;

    public UploadPhotoStateQun4PhotoList(QZoneUploadPhotoActivity qZoneUploadPhotoActivity) {
        super(qZoneUploadPhotoActivity);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public String b() {
        return this.f51767a.getResources().getString(R.string.gdl);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean h() {
        return true;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean i() {
        return true;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void k() {
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
        qZoneUploadPhotoActivity.bq(qZoneUploadPhotoActivity.getIntent().getStringExtra(QZoneHelper.Constants.KEY_QUN_ID));
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = this.f51767a;
        qZoneUploadPhotoActivity2.cq(qZoneUploadPhotoActivity2.getIntent().getStringExtra(QZoneHelper.Constants.KEY_QUN_NAME));
        l lVar = l.f59550a;
        this.f52042c = lVar.h(this.f51767a.bj(), this.f51767a.getIntent());
        this.f52043d = lVar.i(this.f51767a.bj(), this.f51767a.getIntent());
        this.f52044e = lVar.g(this.f51767a.bj(), this.f51767a.getIntent());
        if (TextUtils.isEmpty(this.f52042c)) {
            QLog.e("UploadPhotoStateQun4PhotoList", 1, "UploadPhotoStateQun4PhotoList  init mAlbumId  is null!");
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
    public void p() {
        if (TextUtils.isEmpty(this.f52042c)) {
            QLog.e("UploadPhotoStateQun4PhotoList", 1, "UploadPhotoStateQun4PhotoList  onRestoreAlbumInfo mAlbumId  is null!");
            return;
        }
        this.f51767a.L2 = BusinessAlbumInfo.create(this.f52042c);
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
        qZoneUploadPhotoActivity.L2.mTitle = this.f52043d;
        qZoneUploadPhotoActivity.W2 = this.f52044e;
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
        u5.b.x0("key_upload_photo_albun_cover_qun", this.f51767a.W2, uin);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void r() {
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_ALBUM_SELECT_URL, QZoneHelper.Constants.URL_QUN_ALBUM_SELECT_URL);
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
        if (qZoneUploadPhotoActivity == null || qZoneUploadPhotoActivity.Xo() == null) {
            return;
        }
        yo.d.l(this.f51767a.getActivity(), config.replace("{QUN_ID}", this.f51767a.Xo()), 2, null);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void u(final String str, final List<MediaWrapper> list, final BusinessAlbumInfo businessAlbumInfo, final LbsDataV2.PoiInfo poiInfo, final QZonePreUploadInfo qZonePreUploadInfo, final Map<String, String> map, final Object... objArr) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.state.UploadPhotoStateQun4PhotoList.2
            /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x0083  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Map<String, byte[]> map2;
                Map<String, String> map3;
                BusinessAlbumInfo businessAlbumInfo2 = ((QZoneUploadPhotoActivity.ai) UploadPhotoStateQun4PhotoList.this).f51767a.L2;
                Object[] objArr2 = objArr;
                if (objArr2 != null) {
                    String str2 = objArr2.length > 0 ? (String) objArr2[0] : null;
                    int intValue = objArr2.length > 1 ? ((Integer) objArr2[1]).intValue() : 0;
                    Object[] objArr3 = objArr;
                    String str3 = objArr3.length > 2 ? (String) objArr3[2] : null;
                    if (objArr3.length > 3) {
                        Object obj = objArr3[3];
                        if (obj instanceof Map) {
                            map2 = (Map) obj;
                            if (objArr3.length > 4) {
                                Object obj2 = objArr3[4];
                                if (obj2 instanceof Map) {
                                    map3 = (Map) obj2;
                                    QZoneWriteOperationService.v0().v2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateQun4PhotoList.this).f51767a.f45111l1, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null, objArr3.length > 6 ? (String) objArr3[6] : null);
                                }
                            }
                            map3 = null;
                            if (objArr3.length > 5) {
                            }
                            QZoneWriteOperationService.v0().v2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateQun4PhotoList.this).f51767a.f45111l1, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null, objArr3.length > 6 ? (String) objArr3[6] : null);
                        }
                    }
                    map2 = null;
                    if (objArr3.length > 4) {
                    }
                    map3 = null;
                    if (objArr3.length > 5) {
                    }
                    QZoneWriteOperationService.v0().v2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateQun4PhotoList.this).f51767a.f45111l1, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null, objArr3.length > 6 ? (String) objArr3[6] : null);
                }
            }
        });
        this.f51767a.finish();
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void v(final List<ImageInfo> list, final BusinessAlbumInfo businessAlbumInfo, final int i3, final LbsDataV2.PoiInfo poiInfo, final QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, final Object... objArr) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.state.UploadPhotoStateQun4PhotoList.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
                List<ImageInfo> list2 = list;
                Object[] objArr2 = objArr;
                v06.s2(1, list2, (String) objArr2[0], businessAlbumInfo, poiInfo, i3, qZonePreUploadInfo, (String) objArr2[1], (String) objArr2[2], 0);
            }
        });
        this.f51767a.finish();
        u5.b.o0("key_qun_need_refresh_album_list_flag", true);
    }
}
