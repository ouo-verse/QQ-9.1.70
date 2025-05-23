package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.content.Intent;
import com.qzone.common.activities.base.ak;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadSelectAlbumInitBean;
import com.qzone.util.ToastUtil;
import com.qzone.util.image.NetImageInfo;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;
import n5.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class r extends QZoneBaseShareAction {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements d.g {
        a() {
        }

        @Override // n5.d.g
        public void a(BusinessAlbumInfo businessAlbumInfo) {
            String str;
            if (com.qzone.reborn.albumx.qzonex.utils.d.a()) {
                String accountId = RFWApplication.getAccountId();
                if (businessAlbumInfo != null) {
                    str = businessAlbumInfo.mAlbumId;
                } else {
                    str = "";
                }
                ho.i.x().n(r.this.n(), QZoneContant.QZ_SELECT_ALBUM, new QZAlbumxUploadSelectAlbumInitBean(accountId, str));
                return;
            }
            Intent x16 = ak.x(r.this.n(), r.this.n().getResources().getString(R.string.gng), 0);
            if (businessAlbumInfo != null) {
                x16.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_DEFAULT_ALBUM_ID, businessAlbumInfo.mAlbumId);
            }
            r.this.n().startActivityForResult(x16, QZoneContant.QZ_SELECT_ALBUM);
        }
    }

    public r(Activity activity) {
        super(activity);
    }

    public static boolean E(PhotoInfo photoInfo, PhotoParam photoParam) {
        boolean z16 = (photoInfo.opMask & 128) != 0;
        int i3 = photoParam.appid;
        return z16 && tk.k.f436438a.e(photoParam) && (i3 != 2) && ((photoInfo.allow_share != 0) || (i3 == 311));
    }

    public void F(f fVar, Activity activity, d.g gVar) {
        PhotoInfo photoInfo = this.f58109d;
        if (photoInfo == null) {
            return;
        }
        if (!E(fVar.f58179c, fVar.f58180d)) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCannotQuotePhoto", "\u4e3b\u4eba\u4e0d\u5141\u8bb8\u8f6c\u8f7d\u7167\u7247"), 4);
            return;
        }
        NetImageInfo netImageInfo = new NetImageInfo(photoInfo.currentUrl, photoInfo.bigUrl, photoInfo.albumId);
        netImageInfo.lloc = photoInfo.lloc;
        ArrayList<NetImageInfo> arrayList = new ArrayList<>();
        arrayList.add(netImageInfo);
        n5.d.l().s(1);
        n5.d.l().r(gVar);
        n5.d.l().u(new n5.b());
        n5.d l3 = n5.d.l();
        PhotoParam photoParam = this.f58110e;
        l3.o(activity, arrayList, photoParam.appid, tk.k.f436438a.b(photoParam), null);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        F(fVar, n(), new a());
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "6", true);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{100};
    }
}
