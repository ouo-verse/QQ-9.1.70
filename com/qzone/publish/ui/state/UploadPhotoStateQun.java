package com.qzone.publish.ui.state;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.util.image.ImageInfo;
import com.tencent.mobileqq.R;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes39.dex */
public class UploadPhotoStateQun extends QZoneUploadPhotoActivity.ai {

    /* renamed from: d, reason: collision with root package name */
    public static String f52028d;

    /* renamed from: c, reason: collision with root package name */
    private int f52029c;

    public UploadPhotoStateQun(QZoneUploadPhotoActivity qZoneUploadPhotoActivity) {
        super(qZoneUploadPhotoActivity);
        this.f52029c = 0;
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
        if (TextUtils.isEmpty(this.f51767a.getIntent().getStringExtra(QZoneHelper.Constants.KEY_QUN_ID))) {
            this.f51767a.bq(f52028d);
        }
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = this.f51767a;
        qZoneUploadPhotoActivity2.cq(qZoneUploadPhotoActivity2.getIntent().getStringExtra(QZoneHelper.Constants.KEY_QUN_NAME));
        this.f52029c = this.f51767a.getIntent().getIntExtra("up_way", 0);
        f52028d = this.f51767a.getIntent().getStringExtra(QZoneHelper.Constants.KEY_QUN_ID);
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
        long uin = LoginData.getInstance().getUin();
        String j06 = u5.b.j0("key_upload_photo_albun_id_qun", "", uin);
        if (TextUtils.isEmpty(j06)) {
            return;
        }
        this.f51767a.L2 = BusinessAlbumInfo.create(j06);
        String j07 = u5.b.j0("key_upload_photo_albun_name_qun", "", uin);
        String j08 = u5.b.j0("key_upload_photo_albun_cover_qun", "", uin);
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
        qZoneUploadPhotoActivity.L2.mTitle = j07;
        qZoneUploadPhotoActivity.W2 = j08;
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
        u5.b.x0("key_upload_photo_albun_cover_qun", this.f51767a.W2, uin);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void r() {
        String Xo;
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_ALBUM_SELECT_URL, QZoneHelper.Constants.URL_QUN_ALBUM_SELECT_URL);
        if (TextUtils.isEmpty(config)) {
            com.qzone.proxy.feedcomponent.util.j.d("UploadPhotoStateQun", "[selectNetAlbum] current url should not be null.", new NullPointerException());
            return;
        }
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
        FragmentActivity activity = qZoneUploadPhotoActivity == null ? null : qZoneUploadPhotoActivity.getActivity();
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = this.f51767a;
        if (qZoneUploadPhotoActivity2 == null) {
            Xo = "";
        } else {
            Xo = qZoneUploadPhotoActivity2.Xo();
        }
        if (activity == null) {
            com.qzone.proxy.feedcomponent.util.j.d("UploadPhotoStateQun", "[selectNetAlbum] start intent activity should not be null.", new NullPointerException());
        } else if (TextUtils.isEmpty(Xo)) {
            com.qzone.proxy.feedcomponent.util.j.c("UploadPhotoStateQun", "[selectNetAlbum] current troop id is empty, end flow.");
        } else {
            yo.d.l(activity, config.replace("{QUN_ID}", Xo), 2, null);
        }
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void u(final String str, final List<MediaWrapper> list, final BusinessAlbumInfo businessAlbumInfo, final LbsDataV2.PoiInfo poiInfo, final QZonePreUploadInfo qZonePreUploadInfo, final Map<String, String> map, final Object... objArr) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.state.UploadPhotoStateQun.2
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
                BusinessAlbumInfo businessAlbumInfo2 = ((QZoneUploadPhotoActivity.ai) UploadPhotoStateQun.this).f51767a.L2;
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
                                    QZoneWriteOperationService.v0().v2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateQun.this).f51767a.f45111l1, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null, objArr3.length > 6 ? (String) objArr3[6] : null);
                                }
                            }
                            map3 = null;
                            if (objArr3.length > 5) {
                            }
                            QZoneWriteOperationService.v0().v2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateQun.this).f51767a.f45111l1, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null, objArr3.length > 6 ? (String) objArr3[6] : null);
                        }
                    }
                    map2 = null;
                    if (objArr3.length > 4) {
                    }
                    map3 = null;
                    if (objArr3.length > 5) {
                    }
                    QZoneWriteOperationService.v0().v2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateQun.this).f51767a.f45111l1, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null, objArr3.length > 6 ? (String) objArr3[6] : null);
                }
            }
        });
        this.f51767a.finish();
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void v(final List<ImageInfo> list, final BusinessAlbumInfo businessAlbumInfo, final int i3, final LbsDataV2.PoiInfo poiInfo, final QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, final Object... objArr) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.state.UploadPhotoStateQun.1
            @Override // java.lang.Runnable
            public void run() {
                QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
                List<ImageInfo> list2 = list;
                Object[] objArr2 = objArr;
                v06.s2(1, list2, (String) objArr2[0], businessAlbumInfo, poiInfo, i3, qZonePreUploadInfo, (String) objArr2[1], (String) objArr2[2], UploadPhotoStateQun.this.f52029c);
            }
        });
        this.f51767a.finish();
    }
}
