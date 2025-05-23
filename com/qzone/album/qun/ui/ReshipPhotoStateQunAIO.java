package com.qzone.album.qun.ui;

import android.content.Intent;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.publish.ui.state.f;
import com.qzone.util.ToastUtil;
import com.qzone.util.image.NetImageInfo;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;
import yo.d;

/* loaded from: classes39.dex */
public class ReshipPhotoStateQunAIO extends f {

    /* renamed from: g, reason: collision with root package name */
    private long f44010g;

    /* renamed from: h, reason: collision with root package name */
    private String f44011h;

    public ReshipPhotoStateQunAIO(QZoneUploadPhotoActivity qZoneUploadPhotoActivity) {
        super(qZoneUploadPhotoActivity);
    }

    public List<NetImageInfo> B() {
        if (this.f52082c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f52082c.size();
        int size2 = this.f52085f.size();
        ArrayList<String> arrayList2 = this.f52084e;
        int size3 = arrayList2 != null ? arrayList2.size() : 0;
        for (int i3 = 0; i3 < size && i3 < size2; i3++) {
            NetImageInfo netImageInfo = new NetImageInfo(this.f52082c.get(i3), this.f52085f.get(i3).longValue(), this.f44010g);
            if (i3 < size3) {
                netImageInfo.mSmallPath = this.f52084e.get(i3);
            }
            arrayList.add(0, netImageInfo);
        }
        return arrayList;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public String b() {
        return this.f51767a.getResources().getString(R.string.gdl);
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
        v4.a I = w4.a.L().I(this.f44011h, this.f51767a.L2.getId());
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
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity;
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_ALBUM_SELECT_URL, QZoneHelper.Constants.URL_QUN_ALBUM_SELECT_URL);
        if (!TextUtils.isEmpty(config) && !TextUtils.isEmpty(this.f44011h) && (qZoneUploadPhotoActivity = this.f51767a) != null) {
            d.l(qZoneUploadPhotoActivity.getActivity(), config.replace("{QUN_ID}", this.f44011h), 2, null);
        } else {
            QZLog.w("ReshipPhotoStateQunAIO", "url is null");
        }
    }

    @Override // com.qzone.publish.ui.state.f
    protected void z(Intent intent) {
        String stringExtra = intent.getStringExtra(QZoneHelper.Constants.KEY_QUN_CODE);
        if (stringExtra != null) {
            try {
                this.f44010g = Long.parseLong(stringExtra);
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        this.f44011h = intent.getStringExtra(QZoneHelper.Constants.KEY_QUN_ID);
    }

    @Override // com.qzone.publish.ui.state.f
    protected void w(final BusinessAlbumInfo businessAlbumInfo, final Object... objArr) {
        if (objArr != null) {
            final List<NetImageInfo> B = B();
            if (B == null) {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDataError", "\u6570\u636e\u5f02\u5e38"), 4);
                return;
            }
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastQuoteYet", "\u5df2\u8f6c\u8f7d"), 5);
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.album.qun.ui.ReshipPhotoStateQunAIO.1
                @Override // java.lang.Runnable
                public void run() {
                    QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
                    String str = ReshipPhotoStateQunAIO.this.f44011h;
                    BusinessAlbumInfo businessAlbumInfo2 = businessAlbumInfo;
                    long uin = LoginData.getInstance().getUin();
                    List<NetImageInfo> list = B;
                    Object[] objArr2 = objArr;
                    v06.W1(str, businessAlbumInfo2, uin, list, (String) objArr2[0], (String) objArr2[1]);
                }
            });
            this.f51767a.finish();
        }
    }
}
