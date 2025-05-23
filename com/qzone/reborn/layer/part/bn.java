package com.qzone.reborn.layer.part;

import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.base.PictureConst;
import cooperation.qzone.model.MapParcelable;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bn extends x {
    @Override // com.qzone.reborn.layer.part.x
    protected PhotoParam O9() {
        ((uk.j) getViewModel(uk.j.class)).W1().appid = 4;
        return z9(((uk.j) getViewModel(uk.j.class)).W1());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.x
    public void R9() {
        PhotoInfo photoInfo = this.f57984d;
        uk.j jVar = (uk.j) getViewModel(uk.j.class);
        if (photoInfo == null || jVar == null) {
            return;
        }
        if (photoInfo.appid != 311) {
            super.R9();
            return;
        }
        Bundle bundle = new Bundle();
        Map map = photoInfo.busi_param;
        if (map == null) {
            map = new HashMap();
        }
        if (!TextUtils.isEmpty(photoInfo.lloc)) {
            map.put(2, photoInfo.lloc);
            map.put(1, photoInfo.lloc);
        }
        bundle.putLong("uin", jVar.W1().ownerUin);
        bundle.putString(PictureConst.CELL_ID, photoInfo.pssCellId);
        bundle.putString("sub_id", photoInfo.pssCellSubId);
        bundle.putInt("appid", photoInfo.appid);
        bundle.putString(QZoneResult.UGC_KEY, tk.h.u(photoInfo));
        bundle.putParcelable("business_params", new MapParcelable(map));
        this.I.C0(bundle);
        if (this.I.T() != null && this.I.T().g0() != null) {
            this.I.T().g0().setLoadingBackgroundColor(-16777216);
        }
        this.G.setVisibility(0);
        this.I.G0();
    }
}
