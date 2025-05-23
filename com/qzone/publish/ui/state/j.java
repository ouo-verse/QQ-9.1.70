package com.qzone.publish.ui.state;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.util.ToastUtil;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.image.NetImageInfo;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class j extends QZoneUploadPhotoActivity.ai {

    /* renamed from: c, reason: collision with root package name */
    long f52093c;

    /* renamed from: d, reason: collision with root package name */
    int f52094d;

    /* renamed from: e, reason: collision with root package name */
    String f52095e;

    /* renamed from: f, reason: collision with root package name */
    String f52096f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f52097g;

    public j(QZoneUploadPhotoActivity qZoneUploadPhotoActivity) {
        super(qZoneUploadPhotoActivity);
        this.f52097g = false;
        Intent intent = qZoneUploadPhotoActivity.getIntent();
        this.f52094d = intent.getIntExtra("appid", -1);
        this.f52093c = intent.getLongExtra("ownerUin", -1L);
        this.f52095e = intent.getStringExtra(s4.c.CELLID);
        this.f52096f = intent.getStringExtra("subid");
        this.f52097g = intent.getBooleanExtra(QZoneHelper.Constants.KEY_TITLE_NAME, false);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public String b() {
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhoneAlbum", "\u624b\u673a\u76f8\u518c");
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public int c() {
        return R.string.f173042gn3;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public int d() {
        return !this.f52097g ? R.string.gn5 : R.string.f173041gn2;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public int e() {
        return !this.f52097g ? R.string.gng : R.string.gdb;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean g() {
        return false;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean h() {
        return super.h();
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
        String j07 = u5.b.j0("key_upload_photo_albun_cover", "", uin);
        if (!TextUtils.isEmpty(j07)) {
            this.f51767a.W2 = j07;
        }
        if (TextUtils.isEmpty(j06)) {
            return;
        }
        this.f51767a.L2 = BusinessAlbumInfo.create(j06);
        String j08 = u5.b.j0("key_upload_photo_albun_name", "", uin);
        int H = u5.b.H("key_upload_photo_albun_type", 0, uin);
        int H2 = u5.b.H("key_upload_photo_albun_privacy", 0, uin);
        BusinessAlbumInfo businessAlbumInfo = this.f51767a.L2;
        businessAlbumInfo.mTitle = j08;
        businessAlbumInfo.mAlbumType = H;
        businessAlbumInfo.mPrivacy = H2;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void q() {
        BusinessAlbumInfo businessAlbumInfo = this.f51767a.L2;
        if (businessAlbumInfo == null || businessAlbumInfo.mAlbumType == 21) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        u5.b.x0("key_upload_photo_albun_id", this.f51767a.L2.mAlbumId, uin);
        u5.b.x0("key_upload_photo_albun_name", this.f51767a.L2.mTitle, uin);
        u5.b.r0("key_upload_photo_albun_type", this.f51767a.L2.mAlbumType, uin);
        u5.b.r0("key_upload_photo_albun_privacy", this.f51767a.L2.mPrivacy, uin);
        if (!TextUtils.isEmpty(this.f51767a.L2.mCover)) {
            u5.b.x0("key_upload_photo_albun_cover", this.f51767a.L2.mCover, uin);
        } else {
            u5.b.x0("key_upload_photo_albun_cover", this.f51767a.W2, uin);
        }
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void r() {
        Intent x16 = ak.x(this.f51767a.getActivity(), this.f51767a.getString(R.string.gng), 0);
        x16.putExtra("refer", this.f51768b);
        this.f51767a.startActivityForResult(x16, 2);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void v(List<ImageInfo> list, BusinessAlbumInfo businessAlbumInfo, int i3, LbsDataV2.PoiInfo poiInfo, QZonePreUploadInfo qZonePreUploadInfo, Map<String, String> map, Object... objArr) {
        String str;
        ArrayList<String> arrayList;
        String str2;
        if (!NetworkState.isNetSupport()) {
            ToastUtil.n(R.string.gdc);
            return;
        }
        Handler handler = this.f51767a.getHandler();
        ArrayList arrayList2 = (ArrayList) objArr[0];
        String str3 = (String) objArr[1];
        HashMap hashMap = new HashMap();
        int i16 = this.f52094d;
        if (i16 != 4) {
            if (i16 != 311) {
                str2 = "";
            } else {
                str2 = this.f52095e;
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    NetImageInfo netImageInfo = (NetImageInfo) it.next();
                    ArrayList arrayList3 = (ArrayList) hashMap.get(netImageInfo.mAlbumId);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        hashMap.put(netImageInfo.mAlbumId, arrayList3);
                    }
                    arrayList3.add(netImageInfo.lloc);
                }
            }
            str = str2;
            arrayList = null;
        } else {
            String str4 = ((NetImageInfo) arrayList2.get(0)).mAlbumId;
            ArrayList<String> arrayList4 = new ArrayList<>();
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                arrayList4.add(((NetImageInfo) it5.next()).lloc);
            }
            str = str4;
            arrayList = arrayList4;
        }
        QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
        int i17 = this.f52094d;
        long j3 = this.f52093c;
        String str5 = businessAlbumInfo.mAlbumId;
        v06.s0(null, null, i17, 0, j3, str, arrayList, str3, null, null, null, 0, 0, 0, null, 7, str5, TextUtils.isEmpty(str5) ? 1 : -1, null, handler, null, false, false, hashMap, null);
    }
}
