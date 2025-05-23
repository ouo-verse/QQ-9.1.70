package com.qzone.reborn.layer.part;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ar extends x {
    @Override // com.qzone.reborn.layer.part.x
    protected void Q9() {
        uk.d dVar = (uk.d) getViewModel(uk.d.class);
        if (dVar == null || dVar.W1() == null) {
            return;
        }
        PhotoParam W1 = dVar.W1();
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null) {
            QLog.e("QZoneLayerGroupAlbumCommentPanelPart", 1, "[onClick] photoInfo == null", new Exception());
            return;
        }
        if (W1 == null) {
            QLog.e("QZoneLayerGroupAlbumCommentPanelPart", 1, "[onClick] photo param should not be null", new Exception());
            return;
        }
        boolean isEmpty = TextUtils.isEmpty(W1.qunid);
        String str = QzoneConfig.DEFAULT_QZONE_QUN_DETAIL;
        if (!isEmpty) {
            str = QzoneConfig.DEFAULT_QZONE_QUN_DETAIL.replace("{qunid}", W1.qunid);
        }
        if (!TextUtils.isEmpty(photoInfo.albumId)) {
            str = str.replace("{albumid}", photoInfo.albumId);
        }
        if (!TextUtils.isEmpty(photoInfo.lloc)) {
            str = str.replace("{lloc}", photoInfo.lloc);
        }
        QZoneHelper.forwardToBrowser(getActivity(), str.replace("{uploadtime}", photoInfo.uploadtime + "").replace("{qua}", QUA.getQUA3() + "") + "&fromPic=1", 0, null, "");
    }
}
