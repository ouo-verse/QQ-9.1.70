package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;

/* compiled from: P */
/* loaded from: classes37.dex */
public class v extends QZoneBaseShareAction {
    public v(Activity activity) {
        super(activity);
    }

    public String E() {
        PhotoParam photoParam = this.f58110e;
        String str = "";
        if (photoParam == null) {
            return "";
        }
        if (photoParam.ownerUin >= 10001) {
            str = "" + this.f58110e.ownerUin;
        }
        if (!TextUtils.isEmpty(this.f58110e.albumid)) {
            str = str + "_" + this.f58110e.albumid;
        }
        PhotoInfo photoInfo = this.f58109d;
        if (photoInfo == null || TextUtils.isEmpty(photoInfo.lloc)) {
            return str;
        }
        return str + "_" + photoInfo.lloc;
    }

    protected void F(Context context) {
        QZoneCommentPanelParams.a t16 = new QZoneCommentPanelParams.a().y(1206).g(E()).t(40);
        PhotoParam photoParam = this.f58110e;
        ho.i.c().m(t16.r((photoParam == null || photoParam.ownerUin == LoginData.getInstance().getUin()) ? false : true).getParams(), n());
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        F(n());
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{3};
    }
}
