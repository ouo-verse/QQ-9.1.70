package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.business.share.ShareUtils;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.qzone.util.ad;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.IQzoneShareApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import oo.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class af extends c {
    public af(Activity activity) {
        super(activity);
    }

    private void P(Bundle bundle) {
        String str;
        String str2;
        String string = bundle.getString("url", "");
        bundle.getString("mini_title", "");
        PhotoInfo photoInfo = this.f58109d;
        ShareUtils.g gVar = new ShareUtils.g();
        if (TextUtils.isEmpty(photoInfo.shareTitle)) {
            str = "\u5206\u4eabQQ\u7a7a\u95f4\u7684\u7167\u7247";
        } else {
            str = photoInfo.shareTitle;
        }
        gVar.f44741b = str;
        gVar.f44742c = "\u6765\u81eaQQ\u7a7a\u95f4";
        if (TextUtils.isEmpty(photoInfo.sharePhotoUrl)) {
            str2 = photoInfo.bigUrl;
        } else {
            str2 = photoInfo.sharePhotoUrl;
        }
        gVar.f44743d = str2;
        gVar.f44740a = string;
        ShareUtils.r(n(), 10, gVar, 0);
    }

    private void Q(f fVar) {
        String str;
        long j3;
        PhotoInfo photoInfo = fVar.f58179c;
        HashMap<Integer, String> hashMap = new HashMap<>(1);
        hashMap.put(1, photoInfo.bigUrl);
        hashMap.put(2, "0");
        hashMap.put(10, "1");
        PhotoParam photoParam = fVar.f58180d;
        if (photoInfo.appid != 311) {
            QZoneFeedxPictureManager qZoneFeedxPictureManager = QZoneFeedxPictureManager.getInstance();
            QZoneInteractPhotoRequestBuilder ugcType = new QZoneInteractPhotoRequestBuilder().setAppId(4).setUgcType(1);
            if (TextUtils.isEmpty(photoInfo.pssCellId)) {
                str = photoInfo.albumId;
            } else {
                str = photoInfo.pssCellId;
            }
            QZoneInteractPhotoRequestBuilder iisShareTo = ugcType.setCellId(str).setAlbumId(photoInfo.albumId).setLloc(photoInfo.lloc).setBatchId(null).setIisShareTo(0);
            if (photoParam != null) {
                j3 = photoParam.ownerUin;
            } else {
                j3 = photoInfo.uploaduin;
            }
            qZoneFeedxPictureManager.getOutShareUrl(iisShareTo.setOwnerUin(j3).setShareScene(2).setExtraInfoMap(hashMap), r());
        } else {
            R(photoInfo, photoParam, hashMap);
        }
        B(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
    }

    private void S(f fVar, String str) {
        PhotoInfo photoInfo = fVar.f58179c;
        ShareUtils.g gVar = new ShareUtils.g();
        gVar.f44741b = photoInfo.shareTitle;
        gVar.f44742c = photoInfo.shareSummary;
        gVar.f44743d = photoInfo.sharePhotoUrl;
        gVar.f44740a = str;
        ShareUtils.q(n(), 10, gVar);
    }

    private void T(f fVar) {
        if (J()) {
            M();
            return;
        }
        PhotoInfo photoInfo = fVar.f58179c;
        int O = O(fVar);
        if (O == 0) {
            S(fVar, photoInfo.shareWeixinUrl);
        } else {
            if (O != 4) {
                return;
            }
            N(fVar);
        }
    }

    protected int O(f fVar) {
        PhotoInfo photoInfo = fVar.f58179c;
        return ShareUtils.d(com.qzone.preview.d.d(fVar.f58180d), photoInfo.shareSpaceRight, photoInfo.shareAlbumRight, true, false);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    protected void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (fVar.f58179c.isVideo()) {
            T(fVar);
            return;
        }
        if (oo.b.l() && !fVar.f58179c.isSrUrl) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f58109d.downloadUrl);
            oo.b.f(null, 1, arrayList, new a());
            return;
        }
        Q(fVar);
    }

    @Override // com.qzone.reborn.layer.share.c
    public void L(Bundle bundle) {
        QZLog.d("[PhotoAlbum]shareOutSide", 1, "QZoneShareWXTimeLineAction", " handleGetShareUrlResult rsp:", bundle.toString());
        String string = bundle.getString("url", "");
        if (this.f58107b.f58179c.isVideo()) {
            S(this.f58107b, string);
        } else {
            P(bundle);
        }
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{10};
    }

    protected void R(PhotoInfo photoInfo, PhotoParam photoParam, HashMap<Integer, String> hashMap) {
        if (photoInfo == null || photoParam == null) {
            return;
        }
        String str = photoParam.cell_id;
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(photoInfo.pssCellId)) {
                str = photoInfo.albumId;
            } else {
                str = photoInfo.pssCellId;
            }
        }
        QZoneFeedxPictureManager qZoneFeedxPictureManager = QZoneFeedxPictureManager.getInstance();
        QZoneInteractPhotoRequestBuilder iisShareTo = new QZoneInteractPhotoRequestBuilder().setAppId(photoInfo.appid).setUgcType(1).setCellId(str).setAlbumId(photoInfo.albumId).setLloc(photoInfo.lloc).setBatchId(null).setIisShareTo(0);
        long j3 = photoParam.ownerUin;
        if (j3 == 0) {
            j3 = photoInfo.uploaduin;
        }
        qZoneFeedxPictureManager.getOutShareUrl(iisShareTo.setOwnerUin(j3).setShareScene(2).setExtraInfoMap(hashMap), r());
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements b.InterfaceC10931b {
        a() {
        }

        @Override // oo.b.InterfaceC10931b
        public void a(ArrayList<String> arrayList) {
            com.qzone.util.ad.f59766a.d(arrayList, new C0487a());
        }

        /* compiled from: P */
        /* renamed from: com.qzone.reborn.layer.share.af$a$a, reason: collision with other inner class name */
        /* loaded from: classes37.dex */
        class C0487a implements ad.a {
            C0487a() {
            }

            @Override // com.qzone.util.ad.a
            public void a(String str, String str2) {
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), str2, com.qzone.util.image.c.i(str2), 1);
            }

            @Override // com.qzone.util.ad.a
            public void b(String str) {
            }
        }
    }
}
