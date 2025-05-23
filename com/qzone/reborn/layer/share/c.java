package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.qzone.util.ToastUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class c extends QZoneBaseShareAction {

    /* renamed from: j, reason: collision with root package name */
    private boolean f58169j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "\u53d6\u6d88\u5206\u4eab");
            c.this.f58169j = false;
        }
    }

    public c(Activity activity) {
        super(activity);
        this.f58169j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(f fVar, DialogInterface dialogInterface, int i3) {
        G(fVar);
        this.f58169j = false;
    }

    protected void G(f fVar) {
        PhotoInfo photoInfo = fVar.f58179c;
        if (photoInfo == null) {
            return;
        }
        PhotoParam photoParam = fVar.f58180d;
        QZoneFeedxPictureManager.getInstance().getOutShareUrl(new QZoneInteractPhotoRequestBuilder().setAppId(photoInfo.appid).setUgcType(photoInfo.appid == 4 ? -1 : 1).setCellId(H(photoInfo)).setAlbumId(photoInfo.albumId).setLloc(photoInfo.lloc).setBatchId(photoParam.busi_param.get(21)).setIisShareTo(1).setOwnerUin(photoParam.ownerUin).setShareScene(2).setExtraInfoMap(null), r());
        B(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchingUrl", "\u6b63\u5728\u83b7\u53d6\u5206\u4eaburl"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String H(PhotoInfo photoInfo) {
        if (!TextUtils.isEmpty(photoInfo.pssCellId)) {
            return photoInfo.pssCellId;
        }
        return this.f58110e.cell_id;
    }

    protected void I(QZoneResult qZoneResult) {
        i();
        if (qZoneResult != null && qZoneResult.getSucceed()) {
            Bundle bundle = qZoneResult.getBundle();
            if (bundle == null) {
                QZLog.e("[PhotoAlbum]shareOutSide", "QZoneBaseShareOutSizeAction data == null");
                return;
            }
            String string = bundle.getString("msg", "");
            int i3 = bundle.getInt("iShareOutType", 0);
            if (i3 == 1) {
                ToastUtil.s(string, 4);
                return;
            } else if (i3 != 3) {
                L(bundle);
                return;
            } else {
                L(bundle);
                return;
            }
        }
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastFetchUrlFail", "\u83b7\u53d6\u5206\u4eab\u4fe1\u606f\u5931\u8d25"), 4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean J() {
        PhotoParam photoParam = this.f58110e;
        return photoParam != null && photoParam.notAllowShareOutside;
    }

    protected abstract void L(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    public void M() {
        ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastContentHasPerssion", "\u8be5\u5185\u5bb9\u6709\u6743\u9650\uff0c\u4ec5\u5141\u8bb8\u7a7a\u95f4\u5185\u8f6c\u53d1"));
    }

    public void N(final f fVar) {
        ShareUtils.s(n(), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.layer.share.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.this.K(fVar, dialogInterface, i3);
            }
        }, new a());
        this.f58169j = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void x(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && message.what == 1000083) {
            I(unpack);
        }
    }
}
