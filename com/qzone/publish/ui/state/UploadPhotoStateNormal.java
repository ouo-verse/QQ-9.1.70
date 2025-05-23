package com.qzone.publish.ui.state;

import android.content.Intent;
import android.text.TextUtils;
import com.qzone.album.data.model.GifInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.ui.activity.QZoneUploadPhotoActivity;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.publish.ui.publishmodule.LBSModule;
import com.qzone.reborn.util.l;
import com.qzone.util.image.ImageInfo;
import com.qzone.widget.ExtendEditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.RecentPhotoManger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes39.dex */
public class UploadPhotoStateNormal extends QZoneUploadPhotoActivity.ai {

    /* renamed from: c, reason: collision with root package name */
    private String f52003c;

    /* renamed from: d, reason: collision with root package name */
    private String f52004d;

    /* renamed from: e, reason: collision with root package name */
    private String f52005e;

    /* renamed from: f, reason: collision with root package name */
    private int f52006f;

    /* renamed from: g, reason: collision with root package name */
    private String f52007g;

    /* renamed from: h, reason: collision with root package name */
    private String f52008h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f52009i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f52010j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f52011k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f52012l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f52013m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f52014n;

    /* renamed from: o, reason: collision with root package name */
    private String f52015o;

    public UploadPhotoStateNormal(QZoneUploadPhotoActivity qZoneUploadPhotoActivity) {
        super(qZoneUploadPhotoActivity);
        this.f52009i = false;
        this.f52010j = false;
        this.f52011k = false;
        this.f52012l = false;
        this.f52013m = false;
        this.f52014n = false;
    }

    private boolean E() {
        BusinessAlbumInfo businessAlbumInfo;
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
        return (qZoneUploadPhotoActivity == null || (businessAlbumInfo = qZoneUploadPhotoActivity.L2) == null || businessAlbumInfo.isFromLastUpload || !qZoneUploadPhotoActivity.Z2) ? false : true;
    }

    private boolean F() {
        return com.qzone.reborn.a.f52169a.d("exp_qzone_album_noshuoshuoalbum", "_B");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(LbsDataV2.PoiInfo poiInfo) {
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
        if (qZoneUploadPhotoActivity == null || qZoneUploadPhotoActivity.isFinishing()) {
            return;
        }
        ((LBSModule) this.f51767a.hj(LBSModule.class)).H(poiInfo);
    }

    private void I() {
        int i3;
        com.qzone.publish.ui.model.d g16 = un.c.e().g();
        if (g16 == null) {
            return;
        }
        this.f52015o = g16.d();
        this.f51767a.L2 = g16.a();
        if (g16.g() != null) {
            this.f51767a.U.addAll(g16.g());
        }
        if (g16.h() != null) {
            this.f51767a.W.putAll(g16.h());
        }
        if (g16.i() != null) {
            this.f51767a.X.putAll(g16.i());
        }
        if (g16.f() != null) {
            this.f51767a.Z.putAll(g16.f());
        }
        if (g16.b() != null) {
            this.f51767a.f45141y0 = g16.b();
            int size = this.f51767a.f45141y0.size();
            for (int i16 = 0; i16 < size; i16++) {
                Friend friend = this.f51767a.f45141y0.get(i16);
                if (friend != null) {
                    String str = "@" + friend.mName;
                    QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
                    if (qZoneUploadPhotoActivity.f45103i2 < str.length()) {
                        i3 = str.length();
                    } else {
                        i3 = this.f51767a.f45103i2;
                    }
                    qZoneUploadPhotoActivity.f45103i2 = i3;
                }
            }
        }
        final LbsDataV2.PoiInfo e16 = g16.e();
        if (e16 != null) {
            QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.publish.ui.state.k
                @Override // java.lang.Runnable
                public final void run() {
                    UploadPhotoStateNormal.this.G(e16);
                }
            });
        }
    }

    public void H(String str, List<String> list, HashMap<String, LocalMediaInfo> hashMap, HashMap<String, ShuoshuoVideoInfo> hashMap2, HashMap<String, ShuoshuoVideoInfo> hashMap3, BusinessAlbumInfo businessAlbumInfo) {
        if (this.f51767a == null) {
            return;
        }
        com.qzone.publish.ui.model.d dVar = new com.qzone.publish.ui.model.d();
        dVar.l(this.f51767a.Mo());
        dVar.m(((LBSModule) this.f51767a.hj(LBSModule.class)).y());
        dVar.r(this.f51767a.f45104j0.getText().toString());
        dVar.s(str);
        dVar.o(list);
        dVar.k(this.f51767a.f45141y0);
        dVar.p(hashMap);
        dVar.q(hashMap2);
        dVar.n(hashMap3);
        dVar.j(businessAlbumInfo);
        un.c.e().o(LoginData.getInstance().getUin(), dVar);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void a() {
        ExtendEditText extendEditText;
        if (TextUtils.isEmpty(this.f52015o) || (extendEditText = this.f51767a.f45104j0) == null) {
            return;
        }
        extendEditText.setText(this.f52015o);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public String b() {
        if (this.f51767a.isAdded()) {
            return this.f51767a.getResources().getString(R.string.gdk);
        }
        QZLog.w("[PhotoAlbum]UploadPhotoStateNormal", "getDefaultAlbumName mActivity is not attach");
        return "";
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean g() {
        return (this.f52012l || this.f52013m) ? false : true;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean i() {
        return !this.f52012l;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean j() {
        return (this.f52012l || this.f52013m) ? false : true;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void k() {
        l lVar = l.f59550a;
        boolean O = lVar.O(this.f51767a.bj(), this.f51767a.getIntent());
        this.f52011k = O;
        if (O) {
            I();
            return;
        }
        this.f52003c = lVar.h(this.f51767a.bj(), this.f51767a.getIntent());
        this.f52004d = lVar.i(this.f51767a.bj(), this.f51767a.getIntent());
        this.f52005e = lVar.g(this.f51767a.bj(), this.f51767a.getIntent());
        this.f52006f = this.f51767a.getIntent().getIntExtra("UploadPhoto.key_album_anonymity", 1);
        this.f52009i = this.f51767a.getIntent().getBooleanExtra("QZoneLocalRecent.key_is_local_recent_photo", false);
        this.f52010j = this.f51767a.getIntent().getBooleanExtra("QZonePersonalAlbumListt.key_recent_photo", false);
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
        qZoneUploadPhotoActivity.f45111l1 = lVar.r(qZoneUploadPhotoActivity.bj(), this.f51767a.getIntent());
        this.f52015o = lVar.s(this.f51767a.bj(), this.f51767a.getIntent());
        this.f52007g = lVar.A(this.f51767a.bj(), this.f51767a.getIntent());
        this.f52008h = lVar.B(this.f51767a.bj(), this.f51767a.getIntent());
        if (this.f51767a.bj() != null) {
            this.f52014n = this.f51767a.bj().getIsPhotoRepairByOpr() == Boolean.TRUE;
        }
        this.f52012l = (TextUtils.isEmpty(this.f52007g) || TextUtils.isEmpty(this.f52008h)) ? false : true;
        this.f52013m = this.f51767a.getIntent().getIntExtra(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM, -1) == 4;
        if (TextUtils.isEmpty(this.f52003c)) {
            return;
        }
        this.f51767a.L2 = BusinessAlbumInfo.create(this.f52003c);
        int H = u5.b.H("key_upload_photo_albun_privacy", 0, LoginData.getInstance().getUin());
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity2 = this.f51767a;
        BusinessAlbumInfo businessAlbumInfo = qZoneUploadPhotoActivity2.L2;
        businessAlbumInfo.mTitle = this.f52004d;
        businessAlbumInfo.mPrivacy = H;
        businessAlbumInfo.mAnonymity = this.f52006f;
        qZoneUploadPhotoActivity2.W2 = this.f52005e;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public boolean m() {
        return !this.f52012l;
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void p() {
        long uin = LoginData.getInstance().getUin();
        String j06 = u5.b.j0("key_upload_photo_albun_id", "", uin);
        String j07 = u5.b.j0("key_upload_photo_albun_cover", "", uin);
        if (!TextUtils.isEmpty(j07)) {
            this.f51767a.W2 = j07;
        }
        if (TextUtils.isEmpty(j06) || !TextUtils.isEmpty(this.f52003c)) {
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
        businessAlbumInfo.isFromLastUpload = F();
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void q() {
        BusinessAlbumInfo businessAlbumInfo = this.f51767a.L2;
        if (businessAlbumInfo == null || businessAlbumInfo.mAlbumType == 21) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        QLog.i("UploadPhotoStateNormal", 1, "onSaveAlbumInfo, album id is " + this.f51767a.L2.mAlbumId);
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
        boolean z16 = false;
        Intent x16 = ak.x(this.f51767a.getActivity(), this.f51767a.getString(R.string.gp6), 0);
        x16.putExtra("refer", this.f51768b);
        x16.putExtra("suggestedNewAlbumName", this.f51767a.getIntent().getStringExtra("suggestedNewAlbumName"));
        x16.putExtra("QZoneNewAlbumActivity.key_choose_type", this.f51767a.getIntent().getIntExtra("QZoneNewAlbumActivity.key_choose_type", 0));
        BusinessAlbumInfo businessAlbumInfo = this.f51767a.L2;
        if (businessAlbumInfo != null) {
            x16.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_DEFAULT_ALBUM_ID, businessAlbumInfo.mAlbumId);
            x16.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_FROM_UPLOAD, true);
            if (!E() && F()) {
                z16 = true;
            }
            x16.putExtra(PeakConstants.IS_NEED_FILTER_MOOD_PRIVATE_ALBUM, z16);
        }
        this.f51767a.startActivityForResult(x16, 2);
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void u(final String str, final List<MediaWrapper> list, final BusinessAlbumInfo businessAlbumInfo, final LbsDataV2.PoiInfo poiInfo, final QZonePreUploadInfo qZonePreUploadInfo, final Map<String, String> map, final Object... objArr) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.state.UploadPhotoStateNormal.2
            /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Map<String, byte[]> map2;
                Map<String, String> map3;
                BusinessAlbumInfo businessAlbumInfo2 = ((QZoneUploadPhotoActivity.ai) UploadPhotoStateNormal.this).f51767a.L2;
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
                                    QZoneWriteOperationService.v0().u2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateNormal.this).f51767a.f45111l1, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null);
                                }
                            }
                            map3 = null;
                            QZoneWriteOperationService.v0().u2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateNormal.this).f51767a.f45111l1, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null);
                        }
                    }
                    map2 = null;
                    if (objArr3.length > 4) {
                    }
                    map3 = null;
                    QZoneWriteOperationService.v0().u2(str, 5, list, businessAlbumInfo, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str2, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateNormal.this).f51767a.f45111l1, str3, map2, map3, objArr3.length > 5 ? (ArrayList) objArr3[5] : null);
                }
            }
        });
        this.f51767a.finish();
    }

    @Override // com.qzone.publish.ui.activity.QZoneUploadPhotoActivity.ai
    public void v(final List<ImageInfo> list, final BusinessAlbumInfo businessAlbumInfo, final int i3, final LbsDataV2.PoiInfo poiInfo, final QZonePreUploadInfo qZonePreUploadInfo, final Map<String, String> map, final Object... objArr) {
        QZoneUploadPhotoActivity qZoneUploadPhotoActivity = this.f51767a;
        if (qZoneUploadPhotoActivity == null) {
            return;
        }
        if (this.f52009i) {
            for (String str : l.f59550a.C(qZoneUploadPhotoActivity.bj(), this.f51767a.getIntent())) {
                if (!TextUtils.isEmpty(str)) {
                    RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_SHUOSHUO_RECENT_PHOTO_BLACKLIST, str);
                    RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_PERSONAL_ALBUM_RECENT_PHOTO_BLACKLIST, str);
                }
            }
        }
        if (this.f52010j) {
            for (String str2 : l.f59550a.C(this.f51767a.bj(), this.f51767a.getIntent())) {
                if (!TextUtils.isEmpty(str2)) {
                    RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_SHUOSHUO_RECENT_PHOTO_BLACKLIST, str2);
                    RecentPhotoManger.addToRecentPhotoBlacklist(RecentPhotoManger.KEY_BANNER_RECENT_PHOTO_BLACKLIST, str2);
                }
            }
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.ui.state.UploadPhotoStateNormal.1
            /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00c1  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Map<String, byte[]> map2;
                Map<String, String> map3;
                BusinessAlbumInfo businessAlbumInfo2 = ((QZoneUploadPhotoActivity.ai) UploadPhotoStateNormal.this).f51767a.L2;
                Object[] objArr2 = objArr;
                if (objArr2 != null) {
                    String str3 = objArr2.length > 0 ? (String) objArr2[0] : null;
                    int intValue = objArr2.length > 1 ? ((Integer) objArr2[1]).intValue() : 0;
                    Object[] objArr3 = objArr;
                    String str4 = objArr3.length > 2 ? (String) objArr3[2] : null;
                    if (objArr3.length > 3) {
                        Object obj = objArr3[3];
                        if (obj instanceof Map) {
                            map2 = (Map) obj;
                            if (objArr3.length > 4) {
                                Object obj2 = objArr3[4];
                                if (obj2 instanceof Map) {
                                    map3 = (Map) obj2;
                                    ArrayList<GifInfo> arrayList = objArr3.length > 5 ? (ArrayList) objArr3[5] : null;
                                    if (map3 != null && !TextUtils.isEmpty(UploadPhotoStateNormal.this.f52007g) && !TextUtils.isEmpty(UploadPhotoStateNormal.this.f52008h)) {
                                        map3.put(QZoneHelper.QZoneUploadPhotoConstants.KEY_REPAIR_SR_TASK_ID, UploadPhotoStateNormal.this.f52007g);
                                        map3.put(QZoneHelper.QZoneUploadPhotoConstants.KEY_REPAIR_SR_URL, UploadPhotoStateNormal.this.f52008h);
                                    }
                                    if (map3 != null && UploadPhotoStateNormal.this.f52014n) {
                                        map3.put(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, QZoneHelper.QZoneUploadPhotoConstants.DEFAULT_UPLOAD_SR_BY_OPR);
                                        map3.put(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_SR_BY_OPR, "true");
                                    }
                                    QZoneWriteOperationService.v0().r2(0, list, businessAlbumInfo, i3, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str3, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateNormal.this).f51767a.f45111l1, str4, map2, map3, arrayList);
                                }
                            }
                            map3 = null;
                            ArrayList<GifInfo> arrayList2 = objArr3.length > 5 ? (ArrayList) objArr3[5] : null;
                            if (map3 != null) {
                                map3.put(QZoneHelper.QZoneUploadPhotoConstants.KEY_REPAIR_SR_TASK_ID, UploadPhotoStateNormal.this.f52007g);
                                map3.put(QZoneHelper.QZoneUploadPhotoConstants.KEY_REPAIR_SR_URL, UploadPhotoStateNormal.this.f52008h);
                            }
                            if (map3 != null) {
                                map3.put(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, QZoneHelper.QZoneUploadPhotoConstants.DEFAULT_UPLOAD_SR_BY_OPR);
                                map3.put(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_SR_BY_OPR, "true");
                            }
                            QZoneWriteOperationService.v0().r2(0, list, businessAlbumInfo, i3, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str3, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateNormal.this).f51767a.f45111l1, str4, map2, map3, arrayList2);
                        }
                    }
                    map2 = null;
                    if (objArr3.length > 4) {
                    }
                    map3 = null;
                    ArrayList<GifInfo> arrayList22 = objArr3.length > 5 ? (ArrayList) objArr3[5] : null;
                    if (map3 != null) {
                    }
                    if (map3 != null) {
                    }
                    QZoneWriteOperationService.v0().r2(0, list, businessAlbumInfo, i3, poiInfo, businessAlbumInfo2 != null ? businessAlbumInfo2.mSvrTime : 0L, str3, qZonePreUploadInfo, map, intValue, ((QZoneUploadPhotoActivity.ai) UploadPhotoStateNormal.this).f51767a.f45111l1, str4, map2, map3, arrayList22);
                }
            }
        });
        this.f51767a.finish();
    }
}
